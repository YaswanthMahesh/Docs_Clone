package com.docs.docs_clone.Repository;

import com.docs.docs_clone.Model.Doc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocsRepository extends MongoRepository<Doc,String> {
}
