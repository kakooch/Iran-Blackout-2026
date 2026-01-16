package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class gk {
    public final long a;
    public final es b;
    public final int c;
    public final tw d;
    public final long e;
    public final es f;
    public final int g;
    public final tw h;
    public final long i;
    public final long j;

    public gk(long j, es esVar, int i, tw twVar, long j2, es esVar2, int i2, tw twVar2, long j3, long j4) {
        this.a = j;
        this.b = esVar;
        this.c = i;
        this.d = twVar;
        this.e = j2;
        this.f = esVar2;
        this.g = i2;
        this.h = twVar2;
        this.i = j3;
        this.j = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && gk.class == obj.getClass()) {
            gk gkVar = (gk) obj;
            if (this.a == gkVar.a && this.c == gkVar.c && this.e == gkVar.e && this.g == gkVar.g && this.i == gkVar.i && this.j == gkVar.j && apz.b(this.b, gkVar.b) && apz.b(this.d, gkVar.d) && apz.b(this.f, gkVar.f) && apz.b(this.h, gkVar.h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.a), this.b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j)});
    }
}
