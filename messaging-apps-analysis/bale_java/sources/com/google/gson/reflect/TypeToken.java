package com.google.gson.reflect;

import ir.nasim.AbstractC10051b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/* loaded from: classes3.dex */
public class TypeToken<T> {
    private final Class a;
    private final Type b;
    private final int c;

    protected TypeToken() {
        Type typeE = e();
        this.b = typeE;
        this.a = AbstractC10051b.k(typeE);
        this.c = typeE.hashCode();
    }

    public static TypeToken a(Class cls) {
        return new TypeToken(cls);
    }

    public static TypeToken b(Type type) {
        return new TypeToken(type);
    }

    private Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == TypeToken.class) {
                return AbstractC10051b.b(parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (genericSuperclass == TypeToken.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final Class c() {
        return this.a;
    }

    public final Type d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && AbstractC10051b.f(this.b, ((TypeToken) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return AbstractC10051b.t(this.b);
    }

    private TypeToken(Type type) {
        Objects.requireNonNull(type);
        Type typeB = AbstractC10051b.b(type);
        this.b = typeB;
        this.a = AbstractC10051b.k(typeB);
        this.c = typeB.hashCode();
    }
}
