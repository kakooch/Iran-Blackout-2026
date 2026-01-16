package com.google.android.play.core.splitinstall.internal;

import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class b {
    private final Object a;
    private final Field b;
    private final Class c;

    b(Object obj, Field field, Class cls) {
        this.a = obj;
        this.b = field;
        this.c = cls;
    }

    public final Object a() {
        try {
            return this.c.cast(this.b.get(this.a));
        } catch (Exception e) {
            throw new zzbl(String.format("Failed to get value of field %s of type %s on object of type %s", this.b.getName(), this.a.getClass().getName(), this.c.getName()), e);
        }
    }

    protected final Field b() {
        return this.b;
    }

    public final void c(Object obj) throws IllegalAccessException, IllegalArgumentException {
        try {
            this.b.set(this.a, obj);
        } catch (Exception e) {
            throw new zzbl(String.format("Failed to set value of field %s of type %s on object of type %s", this.b.getName(), this.a.getClass().getName(), this.c.getName()), e);
        }
    }
}
