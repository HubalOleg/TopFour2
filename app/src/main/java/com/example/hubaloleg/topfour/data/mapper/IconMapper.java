package com.example.hubaloleg.topfour.data.mapper;

import com.example.hubaloleg.topfour.data.cache.db.IconDB;
import com.example.hubaloleg.topfour.data.remote.model.entity.IconEntity;
import com.example.hubaloleg.topfour.domain.model.Icon;

/**
 * Created by hubaloleg on 12.07.17.
 */

public class IconMapper {

    public IconDB transformApi(IconEntity iconEntity) {
        return new IconDB(
                iconEntity.getPrefix(),
                iconEntity.getSuffix());
    }

    public Icon transformDB(IconDB iconDB) {
        return new Icon(
                iconDB.getPrefix(),
                iconDB.getSuffix());
    }

}
