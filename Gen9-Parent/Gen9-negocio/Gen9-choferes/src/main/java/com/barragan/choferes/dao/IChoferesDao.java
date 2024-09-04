package com.barragan.choferes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barragan.choferes.models.Chofer;

public interface IChoferesDao extends JpaRepository<Chofer, Long> {

}
