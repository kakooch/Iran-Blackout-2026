package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes2.dex */
public final class IA1 {
    private final String a;
    private final String b;
    private final AbstractC11684dQ7 c;
    private final long d;
    private final long e;
    private final long f;
    private final UA2 g;
    private final SA2 h;

    public IA1(String str, String str2, AbstractC11684dQ7 abstractC11684dQ7, long j, long j2, long j3, UA2 ua2, SA2 sa2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(ua2, "onSelectedDate");
        AbstractC13042fc3.i(sa2, "onClosed");
        this.a = str;
        this.b = str2;
        this.c = abstractC11684dQ7;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = ua2;
        this.h = sa2;
    }

    public final String a() {
        return this.b;
    }

    public final long b() {
        return this.e;
    }

    public final long c() {
        return this.d;
    }

    public final SA2 d() {
        return this.h;
    }

    public final UA2 e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IA1)) {
            return false;
        }
        IA1 ia1 = (IA1) obj;
        return AbstractC13042fc3.d(this.a, ia1.a) && AbstractC13042fc3.d(this.b, ia1.b) && AbstractC13042fc3.d(this.c, ia1.c) && this.d == ia1.d && this.e == ia1.e && this.f == ia1.f && AbstractC13042fc3.d(this.g, ia1.g) && AbstractC13042fc3.d(this.h, ia1.h);
    }

    public final long f() {
        return this.f;
    }

    public final String g() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        AbstractC11684dQ7 abstractC11684dQ7 = this.c;
        return ((((((((((iHashCode + (abstractC11684dQ7 == null ? 0 : abstractC11684dQ7.hashCode())) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "DatePickerState(title=" + this.a + ", description=" + this.b + ", validationError=" + this.c + ", minDate=" + this.d + ", maxDate=" + this.e + ", selectedDate=" + this.f + ", onSelectedDate=" + this.g + ", onClosed=" + this.h + Separators.RPAREN;
    }
}
