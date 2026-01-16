package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aja {
    final String a;
    final boolean b;
    final boolean c;
    final /* synthetic */ Field d;
    final /* synthetic */ boolean e;
    final /* synthetic */ agt f;
    final /* synthetic */ age g;
    final /* synthetic */ akz h;
    final /* synthetic */ boolean i;

    protected aja(String str, boolean z, boolean z2) {
        this.a = str;
        this.b = z;
        this.c = z2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    aja(String str, boolean z, boolean z2, Field field, boolean z3, agt agtVar, age ageVar, akz akzVar, boolean z4) {
        this(str, z, z2);
        this.d = field;
        this.e = z3;
        this.f = agtVar;
        this.g = ageVar;
        this.h = akzVar;
        this.i = z4;
    }

    void a(ald aldVar, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
        (this.e ? this.f : new ajj(this.g, this.f, this.h.b())).write(aldVar, this.d.get(obj));
    }

    void b(alb albVar, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
        Object obj2 = this.f.read(albVar);
        if (obj2 == null && this.i) {
            return;
        }
        this.d.set(obj, obj2);
    }

    public boolean c(Object obj) throws IllegalAccessException, IOException {
        return this.b && this.d.get(obj) != obj;
    }
}
