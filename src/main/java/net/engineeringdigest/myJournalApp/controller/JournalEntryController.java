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

    @GetMapping("/getAll")
    public ArrayList<JournalEntry> getEntries(){

        return new ArrayList<JournalEntry>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){

        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }
    @PutMapping("id/{myid}")
    public boolean updateEntry(@PathVariable Long myid,@RequestBody JournalEntry journalEntry){

        journalEntries.put(myid,journalEntry);
        return true;
    }
    @GetMapping("/getEntry/{id}")
    public JournalEntry getEntryById(@PathVariable Long id){

        return journalEntries.get(id);
    }
}
