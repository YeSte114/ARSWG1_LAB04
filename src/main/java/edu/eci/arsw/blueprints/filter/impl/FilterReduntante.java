package edu.eci.arsw.blueprints.filter.impl;

import edu.eci.arsw.blueprints.filter.Filter;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterReduntante implements Filter {




    @Override
    public Blueprint filterPoints(Blueprint bp) {
        List<Point> points = bp.getPoints();
        List<Point> points1 = new ArrayList<>();
        for (int i = 0 ; i < points.size() ; i++){
            if (i==0){
                points1 = posInicial(i, points, points1);

            }else if (i==points.size()-1){
                points1=posFin(i, points, points1);
            }else {
                points1=posMe(i, points, points1);
            }
        }
        bp.setPoints(points1);
        return bp;
    }



    public List<Point> posInicial(int i, List<Point> points, List<Point> points1){
        Point point = points.get(i);
        Point nextPoint = points.get(i+1);
        Boolean X = point.getX() == nextPoint.getX();
        Boolean Y = point.getY() == nextPoint.getY();
        if(!(Y && X)){
            points1.add(point);
        }
        return points1;
    }

    public List<Point> posMe(int i, List<Point> points, List<Point> points1){
        Point point = points.get(i);
        Point nextPoint = points.get(i+1);
        Point beforeEndPoint = points.get(i-1);
        Boolean X = point.getX() == nextPoint.getX();
        Boolean Y = point.getY() == nextPoint.getY();
        Boolean X2 = beforeEndPoint.getX() == point.getX();
        Boolean Y2 = beforeEndPoint.getY() == point.getY();
        if(!(Y && X) && !(Y2 && X2)){
            points1.add(point);
        }
        return points1;
    }

    public List<Point> posFin(int i, List<Point> points, List<Point> points1){
        Point endpoint = points.get(i);
        Point beforeEndPoint = points.get(i-1);
        Boolean cordX = beforeEndPoint.getX() == endpoint.getX();
        Boolean cordY = beforeEndPoint.getY() == endpoint.getY();
        if(!(cordY && cordX)){
            points1.add(endpoint);
        }
        return points1;
    }
}
