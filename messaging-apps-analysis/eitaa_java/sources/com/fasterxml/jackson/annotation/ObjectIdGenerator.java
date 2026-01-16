package com.fasterxml.jackson.annotation;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class ObjectIdGenerator<T> implements Serializable {
    public abstract boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator);

    public abstract ObjectIdGenerator<T> forScope(Class<?> cls);

    public abstract T generateId(Object obj);

    public abstract Class<?> getScope();

    public abstract ObjectIdGenerator<T> newForSerialization(Object obj);
}
