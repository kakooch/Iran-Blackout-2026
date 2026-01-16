package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ail<E> extends agt<Object> {
    public static final agu a = new aik();
    private final Class<E> b;
    private final agt<E> c;

    public ail(age ageVar, agt<E> agtVar, Class<E> cls) {
        this.c = new ajj(ageVar, agtVar, cls);
        this.b = cls;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final Object read(alb albVar) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        albVar.a();
        while (albVar.e()) {
            arrayList.add(this.c.read(albVar));
        }
        albVar.b();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.b, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final void write(ald aldVar, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            aldVar.g();
            return;
        }
        aldVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.write(aldVar, Array.get(obj, i));
        }
        aldVar.d();
    }
}
