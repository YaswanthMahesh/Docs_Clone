package com.docs.docs_clone.Model;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Docs")
public class Doc {
    private String id;
    private String docName;
    private String ownerName;
    private String ownerId;
    private String Content;
    private boolean editAccess;

    public Doc(String ownerName, String ownerId) {
        this.docName = "Untitled";
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        Content = "";
        this.editAccess = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public boolean isEditAccess() {
        return editAccess;
    }

    public void setEditAccess(boolean editAccess) {
        this.editAccess = editAccess;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", docName='" + docName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", editAccess=" + editAccess +
                '}';
    }
}
