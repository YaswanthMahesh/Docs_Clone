package com.docs.docs_clone.Controller;

import com.docs.docs_clone.Model.Doc;
import com.docs.docs_clone.Repository.DocsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CrudController {

    @Autowired
    DocsRepository docsRepository;

    @GetMapping("/Docs")
    public List<Doc> getAllDocs(){
        return docsRepository.findAll();
    }

    @PostMapping("/CreateDocs")
    public Doc createDocs(@RequestBody Doc doc){
        return docsRepository.save(doc);
    }

}
