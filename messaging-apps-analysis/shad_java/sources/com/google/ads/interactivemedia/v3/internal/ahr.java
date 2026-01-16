package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ahr implements Cloneable, agu {
    public static final ahr a = new ahr();
    private final double b = -1.0d;
    private final int c = 136;
    private final boolean d = true;
    private List<apz> e = Collections.emptyList();
    private final List<apz> f = Collections.emptyList();

    private final boolean f(Class<?> cls) {
        return h(cls);
    }

    private final boolean g(Class<?> cls, boolean z) {
        for (apz apzVar : z ? this.e : this.f) {
        }
        return false;
    }

    private static final boolean h(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        Class<? super T> clsA = akzVar.a();
        boolean zF = f(clsA);
        boolean z = zF || g(clsA, true);
        boolean z2 = zF || g(clsA, false);
        if (z || z2) {
            return new ahq(this, z2, z, ageVar, akzVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final ahr clone() {
        try {
            return (ahr) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean c(Field field, boolean z) {
        if ((field.getModifiers() & 136) != 0 || field.isSynthetic() || h(field.getType())) {
            return true;
        }
        List<apz> list = z ? this.e : this.f;
        if (list.isEmpty()) {
            return false;
        }
        afv afvVar = new afv(field);
        for (apz apzVar : list) {
            if (apz.c(afvVar)) {
                return true;
            }
        }
        return false;
    }

    public final boolean d(Class<?> cls, boolean z) {
        return f(cls) || g(cls, z);
    }

    public final ahr e(apz apzVar) {
        ahr ahrVarClone = clone();
        ArrayList arrayList = new ArrayList(this.e);
        ahrVarClone.e = arrayList;
        arrayList.add(apzVar);
        return ahrVarClone;
    }
}
