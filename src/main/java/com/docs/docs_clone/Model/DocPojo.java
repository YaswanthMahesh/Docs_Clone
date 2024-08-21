package com.docs.docs_clone.Model;

public class DocPojo {
    private String id;
    private String docName;
    private String ownerName;
    private String ownerId;
    private  int activeUsers;
    private String content;
    private boolean editAccess;

    public DocPojo(Doc doc) {
        this.id = doc.getId();
        this.docName = doc.getDocName();
        this.ownerName = doc.getOwnerName();
        this.ownerId = doc.getOwnerId();
        this.activeUsers = 0;
        this.content = doc.getContent();
        this.editAccess = doc.isEditAccess();
    }

    public Doc converToDoc(){
        return new Doc(id,
                docName,
                ownerName,
                ownerId,
                content,
                editAccess);
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
        return "DocPojo{" +
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
