package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;

/* loaded from: classes.dex */
public abstract class ClassIntrospector {

    public interface MixInResolver {
        Class<?> findMixInClassFor(Class<?> cls);
    }

    public abstract BeanDescription forClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, MixInResolver mixInResolver);

    public abstract BeanDescription forSerialization(SerializationConfig serializationConfig, JavaType javaType, MixInResolver mixInResolver);

    protected ClassIntrospector() {
    }
}
