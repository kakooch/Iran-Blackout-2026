package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class CC4 {
    private final QC4 a;
    private final SC4 b;
    private final RC4 c;
    private final OC4 d;
    private final PC4 e;

    public CC4(QC4 qc4, SC4 sc4, RC4 rc4, OC4 oc4, PC4 pc4) {
        AbstractC13042fc3.i(qc4, "noticeIconData");
        AbstractC13042fc3.i(sc4, "noticeTitleTextData");
        AbstractC13042fc3.i(rc4, "noticeLabelTextData");
        AbstractC13042fc3.i(oc4, "noticeButtonData");
        AbstractC13042fc3.i(pc4, "noticeCloseIconData");
        this.a = qc4;
        this.b = sc4;
        this.c = rc4;
        this.d = oc4;
        this.e = pc4;
    }

    public final OC4 a() {
        return this.d;
    }

    public final PC4 b() {
        return this.e;
    }

    public final QC4 c() {
        return this.a;
    }

    public final RC4 d() {
        return this.c;
    }

    public final SC4 e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CC4)) {
            return false;
        }
        CC4 cc4 = (CC4) obj;
        return AbstractC13042fc3.d(this.a, cc4.a) && AbstractC13042fc3.d(this.b, cc4.b) && AbstractC13042fc3.d(this.c, cc4.c) && AbstractC13042fc3.d(this.d, cc4.d) && AbstractC13042fc3.d(this.e, cc4.e);
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "NoticeBarData(noticeIconData=" + this.a + ", noticeTitleTextData=" + this.b + ", noticeLabelTextData=" + this.c + ", noticeButtonData=" + this.d + ", noticeCloseIconData=" + this.e + Separators.RPAREN;
    }
}
