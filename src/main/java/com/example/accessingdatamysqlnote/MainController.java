package com.example.accessingdatamysqlnote;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
   
   private final static Logger logger = (Logger) LoggerFactory.getLogger(MainController.class);
   
  @Autowired 
  private NoteRepository noteRepository;

  @PostMapping(path="/note/create", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
  public @ResponseBody String addNewNote (@RequestBody Note member) {
  
    Note n = new Note();
    n.setContent(member.getContent());
    noteRepository.save(n);
    return "Saved";
  }
  
  @PostMapping(path="/note/edit", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
  public @ResponseBody String modifyNote (@RequestBody Note member) {
      
    Note notaDaMod = new Note();
    notaDaMod = noteRepository.findById(member.getId()).get();
    
    logger.info("il note da modificare ID : " + notaDaMod.getId());
    logger.info("il note da modificare CONTENT : " + notaDaMod.getContent());
    System.out.println("il note da modificare ID : " + notaDaMod.getId());
    System.out.println("il note da modificare CONTENT : " + notaDaMod.getContent());
    notaDaMod.setContent(member.getContent());
   
    noteRepository.save(notaDaMod);
    return "Updated";
  }

  @GetMapping(path="/note/get-all")
  public @ResponseBody Iterable<Note> getAllNotes() {
    // This returns a JSON or XML with the notes
    return noteRepository.findAll();
  }
  
  @GetMapping(path="/note/{note_id}")
  public @ResponseBody Optional<Note> getNote(@PathVariable String note_id) {
    // This returns a JSON or XML with the notes
    return noteRepository.findById(Integer.parseInt(note_id));
  }
  
  @GetMapping(path="/note/delete/{note_id}")
  public @ResponseBody String deleteNote(@PathVariable String note_id) {
    // This returns a JSON or XML with the notes
    noteRepository.deleteById(Integer.parseInt(note_id));
    return "deleted";
  }
}