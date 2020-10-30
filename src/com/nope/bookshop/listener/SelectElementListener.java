package com.nope.bookshop.listener;

import java.util.List;

/**
 *
 * @author zvr
 */
public interface SelectElementListener<T> {

    public void elementsSelected(List<T> selectedElements);
}
