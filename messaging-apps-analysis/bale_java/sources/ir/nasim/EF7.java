package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class EF7 extends AbstractC20556sC7 {
    private final C11458d25 a;
    private final C3460Az b;
    private final QY1 c;
    private final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EF7(C11458d25 c11458d25, C3460Az c3460Az, QY1 qy1, String str) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c3460Az, "messageId");
        this.a = c11458d25;
        this.b = c3460Az;
        this.c = qy1;
        this.d = str;
    }

    public final QY1 a() {
        return this.c;
    }

    public final String b() {
        return this.d;
    }

    public final C3460Az c() {
        return this.b;
    }

    public final C11458d25 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EF7)) {
            return false;
        }
        EF7 ef7 = (EF7) obj;
        return AbstractC13042fc3.d(this.a, ef7.a) && AbstractC13042fc3.d(this.b, ef7.b) && AbstractC13042fc3.d(this.c, ef7.c) && AbstractC13042fc3.d(this.d, ef7.d);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        QY1 qy1 = this.c;
        int iHashCode2 = (iHashCode + (qy1 == null ? 0 : qy1.hashCode())) * 31;
        String str = this.d;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UpdateTranscriptReady(peer=" + this.a + ", messageId=" + this.b + ", downloadSource=" + this.c + ", error=" + this.d + Separators.RPAREN;
    }
}
