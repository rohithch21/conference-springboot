package com.pluralsight.conferencespringboot.repositories;

import com.pluralsight.conferencespringboot.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {

}
