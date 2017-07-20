package com.example.hubaloleg.topfour.domain.model.elements;

/**
 * Created by kostya on 20.07.17.
 */

public class Element {
    private String type;
    private String id;
    private Tag tags;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tag getTags() {
        return tags;
    }

    public void setTags(Tag tags) {
        this.tags = tags;
    }
}
