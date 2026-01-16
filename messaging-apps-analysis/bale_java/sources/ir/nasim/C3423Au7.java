package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;

/* renamed from: ir.nasim.Au7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3423Au7 implements InterfaceC15283jK {
    private String a;
    private String b;
    private int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private HistoryMessageData i;
    private Long j;
    private String k;
    private final String l;

    public C3423Au7(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, HistoryMessageData historyMessageData, Long l, String str8, String str9) {
        AbstractC13042fc3.i(str, "sourceCardID");
        AbstractC13042fc3.i(str2, "destinationPan");
        AbstractC13042fc3.i(str3, "pin2");
        AbstractC13042fc3.i(str4, "cvv2");
        AbstractC13042fc3.i(str5, "expireDate");
        AbstractC13042fc3.i(str6, "approvalCode");
        AbstractC13042fc3.i(str7, "encryptedTransferInfo");
        AbstractC13042fc3.i(str8, "description");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = historyMessageData;
        this.j = l;
        this.k = str8;
        this.l = str9;
    }

    public final int a() {
        return this.c;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        return this.k;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3423Au7)) {
            return false;
        }
        C3423Au7 c3423Au7 = (C3423Au7) obj;
        return AbstractC13042fc3.d(this.a, c3423Au7.a) && AbstractC13042fc3.d(this.b, c3423Au7.b) && this.c == c3423Au7.c && AbstractC13042fc3.d(this.d, c3423Au7.d) && AbstractC13042fc3.d(this.e, c3423Au7.e) && AbstractC13042fc3.d(this.f, c3423Au7.f) && AbstractC13042fc3.d(this.g, c3423Au7.g) && AbstractC13042fc3.d(this.h, c3423Au7.h) && AbstractC13042fc3.d(this.i, c3423Au7.i) && AbstractC13042fc3.d(this.j, c3423Au7.j) && AbstractC13042fc3.d(this.k, c3423Au7.k) && AbstractC13042fc3.d(this.l, c3423Au7.l);
    }

    public final HistoryMessageData f() {
        return this.i;
    }

    public final String g() {
        return this.l;
    }

    public final String h() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        HistoryMessageData historyMessageData = this.i;
        int iHashCode2 = (iHashCode + (historyMessageData == null ? 0 : historyMessageData.hashCode())) * 31;
        Long l = this.j;
        int iHashCode3 = (((iHashCode2 + (l == null ? 0 : l.hashCode())) * 31) + this.k.hashCode()) * 31;
        String str = this.l;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final Long i() {
        return this.j;
    }

    public String toString() {
        return "TransferMoneyByCard(sourceCardID=" + this.a + ", destinationPan=" + this.b + ", amount=" + this.c + ", pin2=" + this.d + ", cvv2=" + this.e + ", expireDate=" + this.f + ", approvalCode=" + this.g + ", encryptedTransferInfo=" + this.h + ", historyData=" + this.i + ", targetUserId=" + this.j + ", description=" + this.k + ", ramzToken=" + this.l + Separators.RPAREN;
    }
}
