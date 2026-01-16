package org.aspectj.internal.lang.reflect;

import java.lang.annotation.Annotation;
import org.aspectj.lang.reflect.AjType;

/* loaded from: classes8.dex */
public class AjTypeImpl<T> implements AjType<T> {
    private Class a;

    public boolean equals(Object obj) {
        if (obj instanceof AjTypeImpl) {
            return ((AjTypeImpl) obj).a.equals(this.a);
        }
        return false;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation getAnnotation(Class cls) {
        return this.a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return this.a.getDeclaredAnnotations();
    }

    public String getName() {
        return this.a.getName();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class cls) {
        return this.a.isAnnotationPresent(cls);
    }

    public String toString() {
        return getName();
    }
}
