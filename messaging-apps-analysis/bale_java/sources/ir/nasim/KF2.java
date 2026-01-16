package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;

/* loaded from: classes5.dex */
public final class KF2 implements InterfaceC15283jK {
    private String a;
    private String b;
    private int c;
    private HistoryMessageData d;
    private Integer e;

    public KF2(String str, String str2, int i, HistoryMessageData historyMessageData, Integer num) {
        AbstractC13042fc3.i(str, "cardId");
        AbstractC13042fc3.i(str2, "destinationPan");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = historyMessageData;
        this.e = num;
    }

    public final int a() {
        return this.c;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final HistoryMessageData d() {
        return this.d;
    }

    public final Integer e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KF2)) {
            return false;
        }
        KF2 kf2 = (KF2) obj;
        return AbstractC13042fc3.d(this.a, kf2.a) && AbstractC13042fc3.d(this.b, kf2.b) && this.c == kf2.c && AbstractC13042fc3.d(this.d, kf2.d) && AbstractC13042fc3.d(this.e, kf2.e);
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31;
        HistoryMessageData historyMessageData = this.d;
        int iHashCode2 = (iHashCode + (historyMessageData == null ? 0 : historyMessageData.hashCode())) * 31;
        Integer num = this.e;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return this.a + Separators.RETURN + this.b + Separators.RETURN + this.c + this.d + Separators.RETURN + this.e;
    }
}
