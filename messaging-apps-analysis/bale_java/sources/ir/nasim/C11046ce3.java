package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.ce3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C11046ce3 {
    private final String a;
    private final List b;

    public C11046ce3(String str, List list) {
        AbstractC13042fc3.i(list, "invitePeers");
        this.a = str;
        this.b = list;
    }

    public final C11046ce3 a(String str, List list) {
        AbstractC13042fc3.i(list, "invitePeers");
        return new C11046ce3(str, list);
    }

    public final String b() {
        return this.a;
    }

    public final List c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11046ce3)) {
            return false;
        }
        C11046ce3 c11046ce3 = (C11046ce3) obj;
        return AbstractC13042fc3.d(this.a, c11046ce3.a) && AbstractC13042fc3.d(this.b, c11046ce3.b);
    }

    public int hashCode() {
        String str = this.a;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "InviteModel(inviteLink=" + this.a + ", invitePeers=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C11046ce3(String str, List list, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? AbstractC10360bX0.m() : list);
    }
}
