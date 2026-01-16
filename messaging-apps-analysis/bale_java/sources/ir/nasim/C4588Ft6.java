package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Ft6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4588Ft6 {
    private final String a;
    private final Integer b;
    private final Integer c;
    private final List d;
    private final Integer e;
    private final List f;

    public C4588Ft6(String str, Integer num, Integer num2, List list, Integer num3, List list2) {
        AbstractC13042fc3.i(str, "title");
        this.a = str;
        this.b = num;
        this.c = num2;
        this.d = list;
        this.e = num3;
        this.f = list2;
    }

    public final List a() {
        return this.f;
    }

    public final Integer b() {
        return this.e;
    }

    public final Integer c() {
        return this.c;
    }

    public final List d() {
        return this.d;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4588Ft6)) {
            return false;
        }
        C4588Ft6 c4588Ft6 = (C4588Ft6) obj;
        return AbstractC13042fc3.d(this.a, c4588Ft6.a) && AbstractC13042fc3.d(this.b, c4588Ft6.b) && AbstractC13042fc3.d(this.c, c4588Ft6.c) && AbstractC13042fc3.d(this.d, c4588Ft6.d) && AbstractC13042fc3.d(this.e, c4588Ft6.e) && AbstractC13042fc3.d(this.f, c4588Ft6.f);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List list = this.d;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.e;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List list2 = this.f;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "ServicesTooltipConfig(title=" + this.a + ", maxWidth=" + this.b + ", maxWidthAndroid=" + this.c + ", relatedPeers=" + this.d + ", maxNumRelatedPeersToShow=" + this.e + ", intervalBetweenShowInDays=" + this.f + Separators.RPAREN;
    }
}
