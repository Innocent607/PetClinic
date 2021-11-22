package com.example.PetClinic.services.springdatajpa;

import com.example.PetClinic.model.Visit;
import com.example.PetClinic.repositories.VisitRepository;
import com.example.PetClinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Onalethata I. L. Maswabi
 * AKA Inno607
 */

public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {

        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);

    }
}
