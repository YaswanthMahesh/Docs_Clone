package com.docs.docs_clone.Services;

import com.docs.docs_clone.Model.Doc;
import com.docs.docs_clone.Repository.DocsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


@Service
public class DocsService {

    private static final String DOCUMENT_CACHE = "Document";

    private final ConcurrentHashMap<String, Doc> unsavedChangesMap;
    @Autowired
    DocsRepository docsRepository;

    @Autowired
    public DocsService(ConcurrentHashMap<String, Doc> unsavedChangesMap) {
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
