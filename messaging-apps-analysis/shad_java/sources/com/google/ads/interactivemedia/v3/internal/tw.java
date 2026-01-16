package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class tw {
    public final Object a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;

    public tw(Object obj) {
        this(obj, -1, -1, -1L, -1);
    }

    private tw(Object obj, int i, int i2, long j, int i3) {
        this.a = obj;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = i3;
    }

    public final tw a(Object obj) {
        return this.a.equals(obj) ? this : new tw(obj, this.b, this.c, this.d, this.e);
    }

    public final boolean b() {
        return this.b != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && tw.class == obj.getClass()) {
            tw twVar = (tw) obj;
            if (this.a.equals(twVar.a) && this.b == twVar.b && this.c == twVar.c && this.d == twVar.d && this.e == twVar.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.a.hashCode() + 527) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d)) * 31) + this.e;
    }

    public tw(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    public tw(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}
