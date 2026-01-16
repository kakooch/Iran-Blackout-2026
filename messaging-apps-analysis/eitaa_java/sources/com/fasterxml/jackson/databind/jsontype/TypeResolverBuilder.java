package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import java.util.Collection;

/* loaded from: classes.dex */
public interface TypeResolverBuilder<T extends TypeResolverBuilder<T>> {
    TypeSerializer buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection);

    T defaultImpl(Class<?> cls);

    T inclusion(JsonTypeInfo.As as);

    T init(JsonTypeInfo.Id id, TypeIdResolver typeIdResolver);

    T typeIdVisibility(boolean z);

    T typeProperty(String str);
}
