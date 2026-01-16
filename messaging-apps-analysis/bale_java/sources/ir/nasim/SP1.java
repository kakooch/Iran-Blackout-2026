package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.RP1;
import ir.nasim.database.dailogLists.MessageState;

/* loaded from: classes5.dex */
public final class SP1 {
    public static final int m = RP1.h.g;
    private final long a;
    private final Integer b;
    private final MessageState c;
    private final RP1.h d;
    private final AbstractC25195zt3 e;
    private final Boolean f;
    private final Boolean g;
    private final Boolean h;
    private final String i;
    private final String j;
    private final String k;
    private final Boolean l;

    public SP1(long j, Integer num, MessageState messageState, RP1.h hVar, AbstractC25195zt3 abstractC25195zt3, Boolean bool, Boolean bool2, Boolean bool3, String str, String str2, String str3, Boolean bool4) {
        this.a = j;
        this.b = num;
        this.c = messageState;
        this.d = hVar;
        this.e = abstractC25195zt3;
        this.f = bool;
        this.g = bool2;
        this.h = bool3;
        this.i = str;
        this.j = str2;
        this.k = str3;
        this.l = bool4;
    }

    public final String a() {
        return this.j;
    }

    public final Boolean b() {
        return this.l;
    }

    public final Boolean c() {
        return this.h;
    }

    public final AbstractC25195zt3 d() {
        return this.e;
    }

    public final String e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SP1)) {
            return false;
        }
        SP1 sp1 = (SP1) obj;
        return this.a == sp1.a && AbstractC13042fc3.d(this.b, sp1.b) && this.c == sp1.c && AbstractC13042fc3.d(this.d, sp1.d) && AbstractC13042fc3.d(this.e, sp1.e) && AbstractC13042fc3.d(this.f, sp1.f) && AbstractC13042fc3.d(this.g, sp1.g) && AbstractC13042fc3.d(this.h, sp1.h) && AbstractC13042fc3.d(this.i, sp1.i) && AbstractC13042fc3.d(this.j, sp1.j) && AbstractC13042fc3.d(this.k, sp1.k) && AbstractC13042fc3.d(this.l, sp1.l);
    }

    public final Boolean f() {
        return this.g;
    }

    public final RP1.h g() {
        return this.d;
    }

    public final MessageState h() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.a) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        MessageState messageState = this.c;
        int iHashCode3 = (iHashCode2 + (messageState == null ? 0 : messageState.hashCode())) * 31;
        RP1.h hVar = this.d;
        int iHashCode4 = (iHashCode3 + (hVar == null ? 0 : hVar.hashCode())) * 31;
        AbstractC25195zt3 abstractC25195zt3 = this.e;
        int iHashCode5 = (iHashCode4 + (abstractC25195zt3 == null ? 0 : abstractC25195zt3.hashCode())) * 31;
        Boolean bool = this.f;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.g;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.h;
        int iHashCode8 = (iHashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str = this.i;
        int iHashCode9 = (iHashCode8 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.j;
        int iHashCode10 = (iHashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.k;
        int iHashCode11 = (iHashCode10 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool4 = this.l;
        return iHashCode11 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public final long i() {
        return this.a;
    }

    public final String j() {
        return this.k;
    }

    public final Integer k() {
        return this.b;
    }

    public final Boolean l() {
        return this.f;
    }

    public String toString() {
        return "DialogUpdateBundle(peerUid=" + this.a + ", unreadCount=" + this.b + ", peerReadState=" + this.c + ", newMessage=" + this.d + ", lastMessagePreview=" + this.e + ", isMuted=" + this.f + ", markAsUnread=" + this.g + ", hasMention=" + this.h + ", lastReaction=" + this.i + ", formatedDate=" + this.j + ", title=" + this.k + ", hasBlueTick=" + this.l + Separators.RPAREN;
    }
}
