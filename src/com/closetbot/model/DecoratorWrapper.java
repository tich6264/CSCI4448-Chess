package com.closetbot.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Owner on 11/2/2016.
 */

public interface DecoratorWrapper extends Serializable {
    public abstract List getClothingArticle();
}
