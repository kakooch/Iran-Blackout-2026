package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class UH1 implements InterfaceC15283jK {
    private final String a;
    private final String b;
    private final long c;
    private final String d;

    public UH1(String str, String str2, long j, String str3) {
        AbstractC13042fc3.i(str, "sourceCardId");
        AbstractC13042fc3.i(str2, "destinationCard");
        AbstractC13042fc3.i(str3, "approvalCode");
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = str3;
    }

    public final long a() {
        return this.c;
    }

    public final String b() {
        return this.d;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UH1)) {
            return false;
        }
        UH1 uh1 = (UH1) obj;
        return AbstractC13042fc3.d(this.a, uh1.a) && AbstractC13042fc3.d(this.b, uh1.b) && this.c == uh1.c && AbstractC13042fc3.d(this.d, uh1.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "DeliveryOTP(sourceCardId=" + this.a + ", destinationCard=" + this.b + ", amount=" + this.c + ", approvalCode=" + this.d + Separators.RPAREN;
    }
}
