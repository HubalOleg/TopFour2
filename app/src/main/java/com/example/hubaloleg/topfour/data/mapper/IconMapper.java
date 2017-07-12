package com.example.hubaloleg.topfour.data.mapper;

import com.example.hubaloleg.topfour.data.remote.model.entity.IconEntity;
import com.example.hubaloleg.topfour.domain.model.Icon;

/**
 * Created by hubaloleg on 12.07.17.
 */

public class IconMapper {

    public Icon transform(IconEntity iconEntity) {
        return new Icon(
                iconEntity.getPrefix(),
                iconEntity.getSuffix());
    }
}
