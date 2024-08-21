package com.docs.docs_clone.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.PrintStream;
import java.io.Serializable;

@Document(collection = "Docs")
public class Doc implements Serializable {
    private String id;
    private String docName;
    private String ownerName;
    private String ownerId;
    private  int activeUsers;
    private String content;
    private boolean editAccess;


    public Doc(String id, String docName, String ownerName, String ownerId, String content, boolean editAccess) {
        this.id = id;
        this.docName = docName;
        this.ownerName = ownerName;
        this.ownerId = ownerId;
        this.activeUsers = 0;
        this.content = content;
        this.editAccess = editAccess;
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

    public int getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(int activeUsers) {
        this.activeUsers = activeUsers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
                "id='" + id + '\'' +
                ", docName='" + docName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", activeUsers=" + activeUsers +
                ", content='" + content + '\'' +
                ", editAccess=" + editAccess +
                '}';
    }
}
