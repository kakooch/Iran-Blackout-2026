package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class eq {
    public Object a;
    public Object b;
    public int c;
    public long d;
    private long e;
    private vm f = vm.a;

    public final long a() {
        return bi.a(this.e);
    }

    public final long b() {
        return this.e;
    }

    public final long c(int i) {
        return this.f.c[i];
    }

    public final int d(int i) {
        return this.f.d[i].a();
    }

    public final int e(int i, int i2) {
        return this.f.d[i].b(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && eq.class.equals(obj.getClass())) {
            eq eqVar = (eq) obj;
            if (aeu.c(this.a, eqVar.a) && aeu.c(this.b, eqVar.b) && this.c == eqVar.c && this.d == eqVar.d && this.e == eqVar.e && aeu.c(this.f, eqVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int f(long j) {
        vm vmVar = this.f;
        long j2 = this.d;
        int length = vmVar.c.length - 1;
        while (length >= 0 && j != Long.MIN_VALUE) {
            long j3 = vmVar.c[length];
            if (j3 != Long.MIN_VALUE) {
                if (j >= j3) {
                    break;
                }
                length--;
            } else {
                if (j2 != -9223372036854775807L && j >= j2) {
                    break;
                }
                length--;
            }
        }
        if (length < 0 || !vmVar.d[length].c()) {
            return -1;
        }
        return length;
    }

    public final int g(long j) {
        vm vmVar = this.f;
        long j2 = this.d;
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        int i = 0;
        if (j2 != -9223372036854775807L && j >= j2) {
            return -1;
        }
        while (true) {
            long[] jArr = vmVar.c;
            if (i >= jArr.length) {
                break;
            }
            long j3 = jArr[i];
            if (j3 == Long.MIN_VALUE || (j < j3 && vmVar.d[i].c())) {
                break;
            }
            i++;
        }
        if (i < vmVar.c.length) {
            return i;
        }
        return -1;
    }

    public final int h(int i) {
        int i2 = this.f.d[i].a;
        return -1;
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = ((obj == null ? 0 : obj.hashCode()) + 217) * 31;
        Object obj2 = this.b;
        int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
        int i = this.c;
        long j = this.d;
        long j2 = this.e;
        return ((((((((iHashCode + iHashCode2) * 31) + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + this.f.hashCode();
    }

    public final boolean i(int i, int i2) {
        int i3 = this.f.d[i].a;
        return false;
    }

    public final long j(int i, int i2) {
        int i3 = this.f.d[i].a;
        return -9223372036854775807L;
    }

    public final long k() {
        long j = this.f.e;
        return 0L;
    }

    public final eq l(Object obj, Object obj2, long j, long j2) {
        vm vmVar = vm.a;
        this.a = obj;
        this.b = obj2;
        this.c = 0;
        this.d = j;
        this.e = j2;
        this.f = vmVar;
        return this;
    }
}
