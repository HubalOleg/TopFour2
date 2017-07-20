package com.example.hubaloleg.topfour.data.mapper.elements;

import com.example.hubaloleg.topfour.data.remote.model.entity.ElementsEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.TagEntity;
import com.example.hubaloleg.topfour.domain.model.elements.Element;
import com.example.hubaloleg.topfour.domain.model.elements.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kostya on 20.07.17.
 */

public class ElementsMapper {

    public List<Element> transform(List<ElementsEntity> elementsEntityList) {
        List<Element> elements = new ArrayList<>();
        for (ElementsEntity elementsEntity : elementsEntityList) {
            Element element = new Element();
            element.setId(elementsEntity.getId());
            element.setType(elementsEntity.getType());
            element.setTags(getTags(elementsEntity.getTagEntity()));
            elements.add(element);
        }
        return elements;
    }

    private Tag getTags(TagEntity tagEntity) {
        Tag tag = new Tag();
        tag.setMaxSpeed(tagEntity.getMaxSpeed());
        tag.setSurface(tagEntity.getSurface());
        return tag;
    }
}
