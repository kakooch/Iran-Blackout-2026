package ir.nasim;

import android.content.Intent;
import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class IH1 extends AbstractC4398Ey5 {
    private final AbstractC6544Ny5 b;
    private long c;
    private List d;
    private List e;
    private String f;
    private String g;
    private String h;
    private AbstractC24063xz i;
    private String j;
    private C11458d25 k;
    private List l;
    private List m;
    private final EnumC13889gz5 n;

    public /* synthetic */ IH1(AbstractC6544Ny5 abstractC6544Ny5, long j, List list, List list2, String str, String str2, String str3, AbstractC24063xz abstractC24063xz, String str4, C11458d25 c11458d25, List list3, List list4, int i, ED1 ed1) {
        this(abstractC6544Ny5, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? new ArrayList() : list, (i & 8) != 0 ? new ArrayList() : list2, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? "" : str2, (i & 64) != 0 ? "" : str3, (i & 128) != 0 ? null : abstractC24063xz, (i & 256) != 0 ? null : str4, c11458d25, (i & 1024) != 0 ? new ArrayList() : list3, (i & 2048) != 0 ? new ArrayList() : list4);
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public Intent a() {
        Intent intentB = b();
        intentB.putExtra("pushSendTime", this.c);
        intentB.putExtra("messageDates", this.d.toString());
        intentB.putExtra("messageRIds", this.e.toString());
        intentB.putExtra("peerType", this.f);
        intentB.putExtra("senderUserId", this.g);
        intentB.putExtra("update_peer_user_id", this.h);
        intentB.putExtra("baseMessage", this.j);
        intentB.putExtra("pushType", c());
        intentB.putExtra("threadMessageDates", this.l.toString());
        intentB.putExtra("threadMessageRIDs", this.m.toString());
        return intentB;
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public EnumC13889gz5 c() {
        return this.n;
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public AbstractC6544Ny5 d() {
        return this.b;
    }

    public final List e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IH1)) {
            return false;
        }
        IH1 ih1 = (IH1) obj;
        return AbstractC13042fc3.d(this.b, ih1.b) && this.c == ih1.c && AbstractC13042fc3.d(this.d, ih1.d) && AbstractC13042fc3.d(this.e, ih1.e) && AbstractC13042fc3.d(this.f, ih1.f) && AbstractC13042fc3.d(this.g, ih1.g) && AbstractC13042fc3.d(this.h, ih1.h) && AbstractC13042fc3.d(this.i, ih1.i) && AbstractC13042fc3.d(this.j, ih1.j) && AbstractC13042fc3.d(this.k, ih1.k) && AbstractC13042fc3.d(this.l, ih1.l) && AbstractC13042fc3.d(this.m, ih1.m);
    }

    public final List f() {
        return this.e;
    }

    public final List g() {
        return this.m;
    }

    public final C11458d25 h() {
        return this.k;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.b.hashCode() * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        AbstractC24063xz abstractC24063xz = this.i;
        int iHashCode2 = (iHashCode + (abstractC24063xz == null ? 0 : abstractC24063xz.hashCode())) * 31;
        String str = this.j;
        return ((((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode();
    }

    public final String i() {
        return this.h;
    }

    public final long j() {
        return this.c;
    }

    public String toString() {
        return "DeletePushNotification(sourceType = " + d() + Separators.RPAREN;
    }

    public IH1(AbstractC6544Ny5 abstractC6544Ny5, long j, List list, List list2, String str, String str2, String str3, AbstractC24063xz abstractC24063xz, String str4, C11458d25 c11458d25, List list3, List list4) {
        AbstractC13042fc3.i(abstractC6544Ny5, "sourceType");
        AbstractC13042fc3.i(list, "messageDates");
        AbstractC13042fc3.i(list2, "messageRids");
        AbstractC13042fc3.i(str, "peerType");
        AbstractC13042fc3.i(str2, "senderUserId");
        AbstractC13042fc3.i(str3, "peerUserId");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list3, "messageThreadDates");
        AbstractC13042fc3.i(list4, "messageThreadRids");
        this.b = abstractC6544Ny5;
        this.c = j;
        this.d = list;
        this.e = list2;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.i = abstractC24063xz;
        this.j = str4;
        this.k = c11458d25;
        this.l = list3;
        this.m = list4;
        this.n = EnumC13889gz5.c;
    }
}
