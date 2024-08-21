package com.docs.docs_clone.Controller;

import com.docs.docs_clone.Model.Doc;
import com.docs.docs_clone.Model.DocPojo;
import com.docs.docs_clone.Model.MessageData;
import com.docs.docs_clone.Repository.DocsRepository;
import com.docs.docs_clone.Services.DocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class CrudController {


    private final ConcurrentHashMap<String, DocPojo> unsavedChangesMap;
    @Autowired
    DocsService docsService;

    @Autowired
    DocsRepository docsRepository;


    @Autowired
    public CrudController(ConcurrentHashMap<String, DocPojo> unsavedChangesMap) {
        this.unsavedChangesMap = unsavedChangesMap;
    }


    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public String sendMessage(MessageData messageData) {
        unsavedChangesMap.get(messageData.getId()).setContent(messageData.getMessage());
        return messageData.getMessage();
    }

    @GetMapping("/Docs")
    public List<Doc> getAllDocs(){
        return docsRepository.findAll();
    }

    @GetMapping("/Docs/{id}")
    public ResponseEntity<DocPojo> getDoc(@PathVariable String id){
        DocPojo doc = unsavedChangesMap.getOrDefault(id,null);
        if(doc==null){
            doc = new DocPojo(docsService.getDocument(id));
            unsavedChangesMap.put(id,doc);
        }
        if(doc!=null) {
            doc.setActiveUsers(doc.getActiveUsers()+1);
            System.out.println(doc.getActiveUsers());
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(doc);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(null);
    }

    @PostMapping("/CreateDocs")
    public Doc createDocs(@RequestBody Doc doc){
        return docsRepository.save(doc);
    }

    @PutMapping("/UpdateDoc")
    public Doc updateDocs(@RequestBody Doc doc){
        return docsService.saveDocument(doc);
    }

    @PutMapping("/closeDoc/{id}")
    public ResponseEntity<DocPojo> closeDocs(@PathVariable String id){
        System.out.println("Entered close doc");
        DocPojo doc = unsavedChangesMap.get(id);
        doc.setActiveUsers(doc.getActiveUsers()-1);
        System.out.println("Active Users: " + doc.getActiveUsers());
        if(doc.getActiveUsers()==0) {
            unsavedChangesMap.remove(id);
            docsService.saveDocument(doc.converToDoc());
            System.out.print("Clearing cache and ");
        }
        System.out.println("EOF close doc");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(doc);
    }

}
