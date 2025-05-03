package net.engineeringdigest.myJournalApp.controller;

import net.engineeringdigest.myJournalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public ArrayList<JournalEntry> getEntries(){

        return new ArrayList<JournalEntry>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){

        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }
}
