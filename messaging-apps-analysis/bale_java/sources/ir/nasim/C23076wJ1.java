package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;

/* renamed from: ir.nasim.wJ1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23076wJ1 {
    private ir.nasim.core.modules.banking.l a;
    private ir.nasim.core.modules.banking.l b;
    private Long c;
    private boolean d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private HistoryMessageData k;
    private Integer l;

    public C23076wJ1(ir.nasim.core.modules.banking.l lVar, ir.nasim.core.modules.banking.l lVar2, Long l, boolean z, String str, String str2, String str3, String str4, String str5, String str6, HistoryMessageData historyMessageData, Integer num) {
        AbstractC13042fc3.i(str, "cardHolderName");
        AbstractC13042fc3.i(str2, "approvalCode");
        AbstractC13042fc3.i(str3, "destinationCardNumber");
        AbstractC13042fc3.i(str4, "sourceCardNumber");
        AbstractC13042fc3.i(str5, "sourceCardId");
        AbstractC13042fc3.i(str6, "description");
        this.a = lVar;
        this.b = lVar2;
        this.c = l;
        this.d = z;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.j = str6;
        this.k = historyMessageData;
        this.l = num;
    }

    public final Long a() {
        return this.c;
    }

    public final String b() {
        return this.f;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.j;
    }

    public final ir.nasim.core.modules.banking.l e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23076wJ1)) {
            return false;
        }
        C23076wJ1 c23076wJ1 = (C23076wJ1) obj;
        return AbstractC13042fc3.d(this.a, c23076wJ1.a) && AbstractC13042fc3.d(this.b, c23076wJ1.b) && AbstractC13042fc3.d(this.c, c23076wJ1.c) && this.d == c23076wJ1.d && AbstractC13042fc3.d(this.e, c23076wJ1.e) && AbstractC13042fc3.d(this.f, c23076wJ1.f) && AbstractC13042fc3.d(this.g, c23076wJ1.g) && AbstractC13042fc3.d(this.h, c23076wJ1.h) && AbstractC13042fc3.d(this.i, c23076wJ1.i) && AbstractC13042fc3.d(this.j, c23076wJ1.j) && AbstractC13042fc3.d(this.k, c23076wJ1.k) && AbstractC13042fc3.d(this.l, c23076wJ1.l);
    }

    public final String f() {
        return this.g;
    }

    public final HistoryMessageData g() {
        return this.k;
    }

    public final ir.nasim.core.modules.banking.l h() {
        return this.a;
    }

    public int hashCode() {
        ir.nasim.core.modules.banking.l lVar = this.a;
        int iHashCode = (lVar == null ? 0 : lVar.hashCode()) * 31;
        ir.nasim.core.modules.banking.l lVar2 = this.b;
        int iHashCode2 = (iHashCode + (lVar2 == null ? 0 : lVar2.hashCode())) * 31;
        Long l = this.c;
        int iHashCode3 = (((((((((((((((iHashCode2 + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        HistoryMessageData historyMessageData = this.k;
        int iHashCode4 = (iHashCode3 + (historyMessageData == null ? 0 : historyMessageData.hashCode())) * 31;
        Integer num = this.l;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.h;
    }

    public final Integer k() {
        return this.l;
    }

    public final boolean l() {
        return this.d;
    }

    public String toString() {
        return "DestinationCardInfo(sourceCard=" + this.a + ", destinationCard=" + this.b + ", amount=" + this.c + ", isOtpRequired=" + this.d + ", cardHolderName=" + this.e + ", approvalCode=" + this.f + ", destinationCardNumber=" + this.g + ", sourceCardNumber=" + this.h + ", sourceCardId=" + this.i + ", description=" + this.j + ", messageData=" + this.k + ", targerUserId=" + this.l + Separators.RPAREN;
    }
}
