/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.filter.Filter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class BlueprintsServices {
   
    @Autowired
    BlueprintsPersistence bpp=null;
    Filter bpf;

    
    public void addNewBlueprint(Blueprint bp){
        try {
            bpp.saveBlueprint(bp);

        }catch (Exception e){
            throw new UnsupportedOperationException("Error con los servicios");
        }
        
    }
    
    public Set<Blueprint> getAllBlueprints(){
        return null;
    }
    
    /**
     * 
     * @param author blueprint's author
     * @param name blueprint's name
     * @throws BlueprintNotFoundException if there is no such blueprint
     */
    public void getBlueprint(String author, String name) throws BlueprintNotFoundException{
        Blueprint blueprint;
        try {
            blueprint = bpp.getBlueprint(author,name);
            blueprint=bpf.filterPoints(blueprint);
        }catch (Exception e){
            throw new UnsupportedOperationException("Error con los servicios");
        }

    }
    
    /**
     * 
     * @param author blueprint's author
     * @return all the blueprints of the given author
     * @throws BlueprintNotFoundException if the given author doesn't exist
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException{

        Set<Blueprint> blueprints;
        Set<Blueprint> blueprintsFiltered = new HashSet<>();

        try {
            blueprints = bpp.getBlueprintByAuthor(author);
            for(Blueprint bp: blueprints){
                bp = bpf.filterPoints(bp);
                blueprintsFiltered.add(bp);
            }
        }catch (Exception e){
            throw new UnsupportedOperationException("Error con los servicios");
        }
        return blueprintsFiltered;
    }
    
}
