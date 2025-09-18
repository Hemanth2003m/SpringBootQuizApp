package com.hems.quizapp.dao;

import com.hems.quizapp.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Long> {

    Register findByUsername(String username);


}