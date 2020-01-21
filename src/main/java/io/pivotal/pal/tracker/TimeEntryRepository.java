package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry pTimeEntry);
    TimeEntry find(Long pEntryId);
    List<TimeEntry> list();
    TimeEntry update(Long pEntryId, TimeEntry pTimeEntry);
    void delete(Long pEntryId);
}