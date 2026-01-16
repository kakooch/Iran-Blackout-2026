package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;

/* loaded from: classes.dex */
public abstract class AnnotatedWithParams extends AnnotatedMember {
    protected final AnnotationMap[] _paramAnnotations;

    public abstract JavaType getParameterType(int i);

    protected AnnotatedWithParams(TypeResolutionContext typeResolutionContext, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap);
        this._paramAnnotations = annotationMapArr;
    }

    protected AnnotatedParameter replaceParameterAnnotations(int i, AnnotationMap annotationMap) {
        this._paramAnnotations[i] = annotationMap;
        return getParameter(i);
    }

    public final AnnotationMap getParameterAnnotations(int i) {
        AnnotationMap[] annotationMapArr = this._paramAnnotations;
        if (annotationMapArr == null || i < 0 || i >= annotationMapArr.length) {
            return null;
        }
        return annotationMapArr[i];
    }

    public final AnnotatedParameter getParameter(int i) {
        return new AnnotatedParameter(this, getParameterType(i), this._typeContext, getParameterAnnotations(i), i);
    }
}
