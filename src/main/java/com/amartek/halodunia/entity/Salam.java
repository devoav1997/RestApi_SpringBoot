package com.amartek.halodunia.entity;



// @Entity
public class Salam {
    private  long id;
    private String content;

    public Salam(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    
    
}
