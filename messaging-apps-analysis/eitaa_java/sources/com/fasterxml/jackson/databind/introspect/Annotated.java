package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.annotation.Annotation;

/* loaded from: classes.dex */
public abstract class Annotated {
    public abstract boolean equals(Object obj);

    public abstract <A extends Annotation> A getAnnotation(Class<A> cls);

    public abstract String getName();

    public abstract Class<?> getRawType();

    public abstract JavaType getType();

    public abstract boolean hasAnnotation(Class<?> cls);

    public abstract boolean hasOneOf(Class<? extends Annotation>[] clsArr);

    public abstract int hashCode();

    protected Annotated() {
    }
}
