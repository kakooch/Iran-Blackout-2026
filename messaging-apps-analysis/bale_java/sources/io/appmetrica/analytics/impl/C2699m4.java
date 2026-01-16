package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.m4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2699m4 {
    public final String a;
    public final Integer b;
    public final String c;

    public C2699m4(String str, Integer num, String str2) {
        this.a = str;
        this.b = num;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2699m4.class != obj.getClass()) {
            return false;
        }
        C2699m4 c2699m4 = (C2699m4) obj;
        if (!this.a.equals(c2699m4.a)) {
            return false;
        }
        Integer num = this.b;
        if (num == null ? c2699m4.b != null : !num.equals(c2699m4.b)) {
            return false;
        }
        String str = this.c;
        String str2 = c2699m4.c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }
}
