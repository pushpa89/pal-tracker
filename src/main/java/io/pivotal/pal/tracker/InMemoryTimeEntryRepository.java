package io.pivotal.pal.tracker;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private HashMap<Long, TimeEntry> hmTimeEntries = new HashMap<>();
    Long currentId = 1L;

    public TimeEntry create(TimeEntry pTimeEntry){
        Long id = currentId++;
        TimeEntry newTimeEntry = new TimeEntry(
                id,
                pTimeEntry.getProjectId(),
                pTimeEntry.getUserId(),
                pTimeEntry.getDate(),
                pTimeEntry.getHours()
        );

        hmTimeEntries.put(id, newTimeEntry);
        //currentId += currentId;
        return newTimeEntry;
    }

    public TimeEntry find(Long pTimeEntryId){
        return hmTimeEntries.get(pTimeEntryId);
    }

    public List<TimeEntry> list(){
        return new ArrayList<>(hmTimeEntries.values());
    }


    public TimeEntry update(Long pTimeEntryId, TimeEntry pTimeEntry){

        if (find(pTimeEntryId) == null) return null;

        TimeEntry updatedEntry = new TimeEntry(
                pTimeEntryId,
                pTimeEntry.getProjectId(),
                pTimeEntry.getUserId(),
                pTimeEntry.getDate(),
                pTimeEntry.getHours()
        );

        hmTimeEntries.replace(pTimeEntryId, updatedEntry);
        return updatedEntry;
    }

    public void delete(Long pTimeEntryId){
        hmTimeEntries.remove(pTimeEntryId);
    }
}