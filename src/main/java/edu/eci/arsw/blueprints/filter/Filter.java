package edu.eci.arsw.blueprints.filter;

import edu.eci.arsw.blueprints.model.Blueprint;

public interface Filter {
    public Blueprint filterPoints(Blueprint bp);
}
