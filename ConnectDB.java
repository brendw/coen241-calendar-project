package calendarApp;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

//https://www.baeldung.com/java-connect-mysql
//https://www.springboottutorial.com/spring-boot-with-mysql-and-oracle

public class ConnectDB {

	final String connectionUrl = "jdbc:mysql://localhost:3306/calendarApp?serverTimezone=UTC";
	final String username = "root";
	final String password = "pw";
	
	// optl constuctor to set url/username/pw ? 
	
    private Connection connect() throws SQLException {
		Properties connectionProps = new Properties();
		connectionProps.put("user", username);
		connectionProps.put("password", password);
		
		Connection conn = null;
		
		try{
			conn = DriverManager.getConnection(connectionUrl, connectionProps);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {try { if (conn != null) conn.close(); } catch (Exception e) {};}
	}
   	
	private String getTime() {
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		return currentTime;
	}
	
//----------------------------------------------------------------------------------------------------------	
	
	// login functions
	
	public String getPassword(String email) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = connect();
			ps = conn.prepareStatement("SELECT * in Login WHERE Email = ? ;"); 
			ps.setString(1, email);
			
	        rs = ps.executeQuery();
	        if (rs.next()) {
	        	return rs.getString(1);
	        }
	        
		} catch (SQLException e) {
			System.out.println("Could not retrieve password for authentication- Error: ");
			e.printStackTrace();
		    
		} finally {
			try { if (ps != null) ps.close(); } catch (Exception e) {};
			try { if (rs != null) rs.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
		}
		
		return null;
		
	} // getPassword
	
	public boolean checkExistingAccount(String Email) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = connect(); 
			ps = conn.prepareStatement("SELECT * in Login WHERE Email=" + Email ); 
	        rs = ps.executeQuery();

			if (rs.getString("Email") != null) //not null email means there exists an account already
				return true;
			else 
				return false; //no account for this email yet 
	        
		} 
		catch (SQLException e) {
			System.out.println("Could not check for existing account with this email - Error: " + e);
		    return true; // so a new account is not made 
		
		} finally {
			try { if (ps != null) ps.close(); } catch (Exception e) {};
			try { if (rs != null) rs.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
		}
		
	} // getPassword
	
//----------------------------------------------------------------------------------------------------------	
	
	
	//insert functions
	
	public int lastInsertId() {
		
		// rerieve auto-incremented index like after inserting a new user/event
		
		Connection conn = null;
		PreparedStatement ps = null;
	    ResultSet rs = null;
		
	    try {
	    	conn = connect();
	    	ps = conn.prepareStatement("SELECT LAST_INSERT_ID();");
	    	rs = ps.executeQuery();
	    	
	    	if (rs.next()) return rs.getInt(1);
	    	
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	
	    } finally {
	    	try { if (rs != null) rs.close(); } catch (Exception e) {};
	    	try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
	    }
		return -1;
	} //lastInsertId()
	
	public int insertUser(){
    	
    	// pass a User Object and set its values to the variables
    	
    	String user = "T"; // ex: user.username() 
    	String pw = "H";
    	String email = "RRRRRRR"; // note: must be unique or insert will fail
    	
    	Connection conn = null;
    	PreparedStatement ps = null;

		try {
			conn = connect();
			ps = conn.prepareStatement("INSERT INTO Users (username, password, email) VALUES (?, ?, ?)");
			ps.setString(1, user);
			ps.setString(2, pw);
			ps.setString(3, email);
			ps.executeQuery();
			
			return lastInsertId(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
			
		} finally {
		    try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
		}
	} // insertUser() 
    
    public int insertEvent(){
    	
    	// pass a event Object and set its values to the variables
    	
    	String eventName = "coen241 party"; 
    	int publisherId = 1; // userId toString(); doesn't need to be in quotes
    	String imageurl = "NULL";
    	// check if image url was passed else it is "NULL"
    	String description = "party time";
    	String location = "classroom"; 
    	String createTime = getTime(); // add from here or automatically in db?
    	
    	//TODO - datetime object or string? 
    	String eventDate = "tomorrow";
    	String startTime = "17:00";
    	String endTime = "19:00";
    	int valid = 1; // valid true = 1, false = 0; doesn't need to be in quotes
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	
		try {
			conn = connect();
			ps = conn.prepareStatement("INSERT INTO Events (eventName, publisherId, image, description, location, eventDate, startTime, endTime, valid) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?");
			ps.setString(1, eventName);
			ps.setInt(2, publisherId);
			ps.setString(3, imageurl);
			ps.setString(4, description);
			ps.setString(5, location);
			ps.setString(6, eventDate);
			ps.setString(7, startTime);
			ps.setString(8, endTime);
			ps.setInt(9, valid);
			ps.executeQuery();
			return lastInsertId(); //return auto-incremented index
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
		}finally {
		    try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
		}
	} // insertEvent() 
    
	public int insertEventTags(){
    	
    	// pass an ?? and set its values to the variables
    	
    	int eventId = 0; 
    	int tagId = 0;
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	
		try {
			conn = connect();
			ps = conn.prepareStatement("INSERT INTO EventTags (eventId, tagId) VALUES (?, ?)");
			ps.setInt(1, eventId);
			ps.setInt(2, tagId);
			ps.executeQuery();
			return lastInsertId(); //return auto-incremented index
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
			
		} finally {
		    try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
		}
	} // insertEventTags()
	
	public int insertRSVP(){
    	
    	// pass an ?? Object and set its values to the variables
    	
    	int eventId = 0; 
    	int userId = 0;
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	
		try {
			conn = connect();
			ps = conn.prepareStatement("INSERT INTO RSVP (eventId, userId) VALUES (?, ?)");
			ps.setInt(1, eventId);
			ps.setInt(2, userId);
			ps.executeQuery();
			return lastInsertId(); //return auto-incremented index
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -2;
			
		} finally {
		    try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
		}
	} // insertRSVP()


	//----------------------------------------------------------------------------------------------------------	
	
	// update functions (modify) 
	
    public void updateUser(int userId, String col, String newStr) {
    	
    	// update user details
    	
    	// cols: username, password, email
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	
    	try {
    		conn = connect();
    		ps = conn.prepareStatement("UPDATE Users SET ? = ? WHERE userId = ?");
    		ps.setString(1, col);
    		ps.setString(2, newStr);
    		ps.setInt(3, userId);
    		ps.executeQuery();
				
	    } catch (SQLException e) {
	    	e.printStackTrace();

	    } finally {
		    try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
	    }
    } //updateUser()
    public void updateEvent(int eventId, String col, String newStr) {
    	
    	// update event details, including delete
    	
    	// btw: columns that can be modified: eventName, imageURL, description, location, eventDate, startTime, endTime, valid
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	
    	try {
    		conn = connect();
    		ps = conn.prepareStatement("UPDATE Events SET ? = ? WHERE eventId = ?");
    		ps.setString(1, col);
    		ps.setInt(3, eventId);
    		
    		if (col == "valid") {
    			ps.setInt(2, 0); // "delete" the event by setting to invalid
    		} else {
    			ps.setString(2, newStr);
    		}
    	
    		ps.executeQuery();
				
	    } catch (SQLException e) {
	    	e.printStackTrace();

	    } finally {
		    try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
	    }
    } //updateEvent()
    
  //----------------------------------------------------------------------------------------------------------	
	
	//select functions (retrieve info) 
	 
	// get all events
    
    public ArrayList<ArrayList<Object>> getEvents(String col, String val) {
    	
    	// each internal ArrayList<Object> in return ArrayList<> contains info for 1 event
    	
    	// pass multiple parameters for sql query? ex WHERE ?=?, WHERE ?=?
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	try {
    		conn = connect();
    		ps = conn.prepareStatement("SELECT * FROM Events WHERE ? = ?");
    		ps.setString(1, col);
    		ps.setString(2, val);
 
    		rs = ps.executeQuery();
    		
    		ArrayList<ArrayList<Object>> returned_events = new ArrayList<ArrayList<Object>>();
    		
    		// loop through each row in result set
    		while (rs.next()) {
    			ArrayList<Object> event = new ArrayList<Object>();
    			
    			// this is beyond coupled 
    			int a = rs.getInt(1);				//eventId
    			String b = rs.getString(2);			//eventName
    			int c = rs.getInt(3);				//publisherId
    			String d = rs.getString(4);			//image
    			String e = rs.getString(5);			//description
    			String f = rs.getString(6);			//location
    			Timestamp g = rs.getTimestamp(7);	//createDate
    			String h = rs.getString(8);			//eventDate
    			String i = rs.getString(9);			//startTime
    			String j = rs.getString(10);		//endTime
    			int k = rs.getInt(11);				//valid
    			
    			event.add(a);
    			event.add(b);
    			event.add(c);
    			event.add(d);
    			event.add(e);
    			event.add(f);
    			event.add(g);
    			event.add(h);
    			event.add(i);
    			event.add(j);
    			event.add(k);
    			returned_events.add(event);
    		}
    	
    		return returned_events;
    		
    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;

	    } finally {
		    try { if (rs != null) rs.close(); } catch (Exception e) {};
		    try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
	    }
    	
    }
    
	// get all tags for an event or all events for a tag
    public ArrayList<Integer> getEventTags(String col, String val) {
    	
    	// col=tagId -> get all events associated with this tag (return list of eventId)
    	// col=eventId -> get all tags associated with this event (return list of tagId)
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	try {
    		conn = connect();
    		ps = conn.prepareStatement("SELECT * FROM EventTags WHERE ? = ?");
    		ps.setString(1, col);
    		ps.setString(2, val);
    		rs = ps.executeQuery();
    		
    		ArrayList<Integer> returned_ids = new ArrayList<Integer>();
    		
    		// loop through each row in result set
    		while (rs.next()) {
    			int id = rs.getInt(1);				//eventId or tagId
    			returned_ids.add(id);
    		}
    		return returned_ids;
    		
    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;

	    } finally {
		    try { if (rs != null) rs.close(); } catch (Exception e) {};
		    try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
	    }
    } // getEventTags()
    
	// get all users rsvped to an event or all events for a user is rsvped to
    public ArrayList<Integer> getRSVPs(String col, String val) {
    	
    	// col=userId -> get all events associated with this user (return list of eventId)
    	// col=eventId -> get all users associated with this event (return list of userId)
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	try {
    		conn = connect();
    		ps = conn.prepareStatement("SELECT * FROM RSVP WHERE ? = ?");
    		ps.setString(1, col);
    		ps.setString(2, val);
    		rs = ps.executeQuery();
    		
    		ArrayList<Integer> returned_ids = new ArrayList<Integer>();
    		
    		// loop through each row in result set
    		while (rs.next()) {
    			int id = rs.getInt(1);				//eventId or userId
    			returned_ids.add(id);
    		}
    		return returned_ids;
    		
    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;

	    } finally {
		    try { if (rs != null) rs.close(); } catch (Exception e) {};
		    try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
	    }
    } // getRSVPs()

	// get all events a user published
    public ArrayList<Integer> getPublishedEvents(int userId) {
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	try {
    		conn = connect();
    		ps = conn.prepareStatement("SELECT * FROM Events WHERE publisherId = ?");
    		ps.setInt(1, userId);
    		rs = ps.executeQuery();
    		
    		ArrayList<Integer> returned_ids = new ArrayList<Integer>();
    		
    		// loop through each row in result set
    		while (rs.next()) {
    			int id = rs.getInt(1);				//eventId
    			returned_ids.add(id);
    		}
    		return returned_ids;
    		
    	} catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;

	    } finally {
		    try { if (rs != null) rs.close(); } catch (Exception e) {};
		    try { if (ps != null) ps.close(); } catch (Exception e) {};
		    try { if (conn != null) conn.close(); } catch (Exception e) {};
	    }
    } // getEventTags()
	
	
//----------------------------------------------------------------------------------------------------------	
  	
  	 
  	
    
}
