package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Qo1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7167Qo1 {
    private final long a;
    private final long b;
    private final boolean c;

    public C7167Qo1(long j, long j2, boolean z) {
        this.a = j;
        this.b = j2;
        this.c = z;
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C7167Qo1)) {
            return super.equals(obj);
        }
        C7167Qo1 c7167Qo1 = (C7167Qo1) obj;
        return c7167Qo1.b == this.b && c7167Qo1.a == this.a;
    }

    public int hashCode() {
        return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "CorrectSpecificMessageId(date=" + this.a + ", rid=" + this.b + ", isCorrectedSource=" + this.c + Separators.RPAREN;
    }
}
