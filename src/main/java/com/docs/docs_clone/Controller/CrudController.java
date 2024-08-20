package com.docs.docs_clone.Controller;

import com.docs.docs_clone.Model.Doc;
import com.docs.docs_clone.Repository.DocsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudController {

    @Autowired
    DocsRepository docsRepository;

    @GetMapping("/Docs")
    public List<Doc> getAllDocs(){
        return docsRepository.findAll();
    }

    @GetMapping("/Docs/{id}")
    public ResponseEntity<Doc> getDoc(@PathVariable String id){
        Optional<Doc> response = docsRepository.findById(id);
        if(response.isPresent())
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response.get());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(null);
    }

    @PostMapping("/CreateDocs")
    public Doc createDocs(@RequestBody Doc doc){
        return docsRepository.save(doc);
    }

    @PutMapping("/UpdateDoc")
    public Doc updateDocs(@RequestBody Doc doc){
        return docsRepository.save(doc);
    }

}
