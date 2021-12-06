package com.example.PetClinic.services.map;

import com.example.PetClinic.model.BaseEntity;
import java.util.*;

/*
    Abstract class:
        is a restricted class that cannot be used
        to create objects (to access it, it must be
        inherited from another class)
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(ID id, T object){

        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        }
        else {
            throw  new RuntimeException("Object cannot be null");
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){

        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        }
        catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}
