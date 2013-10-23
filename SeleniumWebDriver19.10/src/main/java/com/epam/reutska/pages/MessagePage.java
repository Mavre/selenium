package com.epam.reutska.pages;

import java.util.List;

public abstract class MessagePage<T>  extends InternalPage{

	public abstract List<T> getItems();
}

