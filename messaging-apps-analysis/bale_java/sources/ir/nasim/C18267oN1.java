package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.oN1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18267oN1 {
    public static final a l = new a(null);
    public static final int m = 8;
    private final C11458d25 a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;
    private final boolean f;
    private final boolean g;
    private final ExPeerType h;
    private final long i;
    private final List j;
    private final List k;

    /* renamed from: ir.nasim.oN1$a */
    public static final class a {
        private a() {
        }

        private final C18267oN1 b(C17676nN1 c17676nN1) {
            C11458d25 c11458d25E = c17676nN1.e();
            AbstractC13042fc3.h(c11458d25E, "getPeer(...)");
            int iJ = c17676nN1.j();
            long jI = c17676nN1.i();
            long jG = c17676nN1.g();
            long jB = c17676nN1.b();
            boolean zM = c17676nN1.m();
            boolean zN = c17676nN1.n();
            ExPeerType exPeerTypeC = c17676nN1.c();
            AbstractC13042fc3.h(exPeerTypeC, "getExPeerType(...)");
            long jD = c17676nN1.d();
            List listK = c17676nN1.k();
            AbstractC13042fc3.h(listK, "getUnreadMentions(...)");
            List listL = c17676nN1.l();
            AbstractC13042fc3.h(listL, "getUnreadReactions(...)");
            return new C18267oN1(c11458d25E, iJ, jI, jG, jB, zM, zN, exPeerTypeC, jD, listK, listL);
        }

        public final List a(List list) {
            AbstractC13042fc3.i(list, "dialog");
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(C18267oN1.l.b((C17676nN1) it.next()));
            }
            return arrayList;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C18267oN1(C11458d25 c11458d25, int i, long j, long j2, long j3, boolean z, boolean z2, ExPeerType exPeerType, long j4, List list, List list2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(list, DialogEntity.COLUMN_UNREAD_MENTIONS_DATE);
        AbstractC13042fc3.i(list2, "unreadReactions");
        this.a = c11458d25;
        this.b = i;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = z;
        this.g = z2;
        this.h = exPeerType;
        this.i = j4;
        this.j = list;
        this.k = list2;
    }

    public final long a() {
        return this.e;
    }

    public final ExPeerType b() {
        return this.h;
    }

    public final long c() {
        return this.i;
    }

    public final C11458d25 d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18267oN1)) {
            return false;
        }
        C18267oN1 c18267oN1 = (C18267oN1) obj;
        return AbstractC13042fc3.d(this.a, c18267oN1.a) && this.b == c18267oN1.b && this.c == c18267oN1.c && this.d == c18267oN1.d && this.e == c18267oN1.e && this.f == c18267oN1.f && this.g == c18267oN1.g && this.h == c18267oN1.h && this.i == c18267oN1.i && AbstractC13042fc3.d(this.j, c18267oN1.j) && AbstractC13042fc3.d(this.k, c18267oN1.k);
    }

    public final List f() {
        return this.j;
    }

    public final List g() {
        return this.k;
    }

    public final boolean h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((((((((((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + Long.hashCode(this.i)) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
    }

    public final boolean i() {
        return this.g;
    }

    public String toString() {
        return "DialogHistoryData(peer=" + this.a + ", unreadCount=" + this.b + ", sortDate=" + this.c + ", rid=" + this.d + ", date=" + this.e + ", isRead=" + this.f + ", isReceived=" + this.g + ", exPeerType=" + this.h + ", firstUnreadDate=" + this.i + ", unreadMentions=" + this.j + ", unreadReactions=" + this.k + Separators.RPAREN;
    }
}
