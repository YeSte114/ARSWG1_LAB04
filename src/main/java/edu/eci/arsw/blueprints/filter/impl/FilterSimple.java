package edu.eci.arsw.blueprints.filter.impl;

import edu.eci.arsw.blueprints.filter.Filter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;

import java.util.ArrayList;
import java.util.List;

public class FilterSimple implements Filter {
    @Override
    public Blueprint filterPoints(Blueprint bp) {
        List<Point> points = bp.getPoints();
        Boolean delete = false;
        List<Point> ptsAnswer = new ArrayList<>();
        for (Point p: points) {
            if(delete.equals(true)){
                ptsAnswer.add(p);
                delete = false;
            }
            else{
                delete = true;
            }
        }
        bp.setPoints(ptsAnswer);
        return bp;
    }
}
