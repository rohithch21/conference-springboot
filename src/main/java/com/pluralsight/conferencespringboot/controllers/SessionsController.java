package com.pluralsight.conferencespringboot.controllers;

import com.pluralsight.conferencespringboot.models.Session;
import com.pluralsight.conferencespringboot.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getReferenceById(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
        // you can save artifacts but doesn't commit to db (stays in buffer until flushed)
        return sessionRepository.saveAndFlush(session); // JPA entities commit to the db only after flushed
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //Also need to check for children records before deleting
        //Otherwise a Foreign Key violation is raised
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session){
        // PUT method requires all the attributes whereas PATCH needs only the required properties that needs updating
        Session existingSession = sessionRepository.getReferenceById(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }



}
