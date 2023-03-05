package coen241.calendarApp.service;

import coen241.calendarApp.model.RSVP;
import coen241.calendarApp.model.User;
import coen241.calendarApp.model.Event;
import coen241.calendarApp.repository.RSVPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RSVPService {

    private final RSVPRepository rsvpRepository;
    @Autowired
    public RSVPService(RSVPRepository rsvpRepository) { this.rsvpRepository = rsvpRepository; }

    public RSVP saveRSVP(RSVP rsvp) {
        return rsvpRepository.save(rsvp);
    }
    public List<RSVP> getAllRSVP() {
        return rsvpRepository.findAll();
    }

    public List<RSVP> getRSVPByUserId(Long userId) {return rsvpRepository.findByUserId(userId);}
    public List<RSVP> getRSVPByEventId(Long eventId) {return rsvpRepository.findByEventId(eventId);}

}
