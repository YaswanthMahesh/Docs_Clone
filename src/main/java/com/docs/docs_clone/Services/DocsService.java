package com.docs.docs_clone.Services;

import com.docs.docs_clone.Model.Doc;
import com.docs.docs_clone.Model.DocDTO;
import com.docs.docs_clone.Repository.DocsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class DocsService {

    private static final String DOCUMENT_CACHE = "Document";

    private final ConcurrentHashMap<String, DocDTO> unsavedChangesMap;
    @Autowired
    DocsRepository docsRepository;

    @Autowired
    public DocsService(ConcurrentHashMap<String, DocDTO> unsavedChangesMap) {
        this.unsavedChangesMap = unsavedChangesMap;
    }


    public Doc getDocument(String id) {
        Optional<Doc> doc = docsRepository.findById(id);
        return doc.isPresent()?doc.get():null;
    }

    public Doc saveDocument(Doc doc) {
        return docsRepository.save(doc);
    }
//
//    public void removeDocumentFromCache(Long id) {
//        redisTemplate.delete(DOCUMENT_CACHE + id);
//    }

}
