package cdi.beans;

import java.util.Collection;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;

import misc.TableNum;


@ApplicationScoped
public class TableService {

    private final Collection<TableNum> assignedTables = new HashSet<>();


    public boolean assignTable(TableNum tableNum) {
        return assignedTables.add(tableNum);
    }

    public boolean checkTableAvailability(TableNum tableNum) {
        return assignedTables.contains(tableNum);
    }
}
