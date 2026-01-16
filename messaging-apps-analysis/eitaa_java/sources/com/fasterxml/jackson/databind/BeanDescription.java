package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.Converter;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BeanDescription {
    protected final JavaType _type;

    public abstract AnnotatedMember findAnyGetter();

    public abstract Class<?>[] findDefaultViews();

    public abstract JsonFormat.Value findExpectedFormat(JsonFormat.Value value);

    public abstract AnnotatedMember findJsonKeyAccessor();

    public abstract AnnotatedMember findJsonValueAccessor();

    public abstract List<BeanPropertyDefinition> findProperties();

    public abstract JsonInclude.Value findPropertyInclusion(JsonInclude.Value value);

    public abstract Converter<Object, Object> findSerializationConverter();

    public abstract Annotations getClassAnnotations();

    public abstract AnnotatedClass getClassInfo();

    public abstract ObjectIdInfo getObjectIdInfo();

    public abstract boolean hasKnownClassAnnotations();

    public abstract Object instantiateBean(boolean z);

    protected BeanDescription(JavaType javaType) {
        this._type = javaType;
    }

    public JavaType getType() {
        return this._type;
    }

    public Class<?> getBeanClass() {
        return this._type.getRawClass();
    }
}
