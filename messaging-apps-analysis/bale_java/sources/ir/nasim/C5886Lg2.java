package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;

/* renamed from: ir.nasim.Lg2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5886Lg2 {
    public static final a o = new a(null);
    public static final int p = 8;
    private static final C5886Lg2 q = new C5886Lg2(0, 0, AbstractC15520jj2.g.a, AbstractC10360bX0.m(), new ExPeer(ExPeerType.UNKNOWN, 0), null, 0, null, null, null, "", null, null, null);
    private final long a;
    private final long b;
    private final AbstractC15520jj2 c;
    private List d;
    private final ExPeer e;
    private final Integer f;
    private final int g;
    private final Integer h;
    private final Boolean i;
    private final C4026Dj2 j;
    private final String k;
    private final CW4 l;
    private final Long m;
    private final C17532n74 n;

    /* renamed from: ir.nasim.Lg2$a */
    public static final class a {
        private a() {
        }

        public final C5886Lg2 a() {
            return C5886Lg2.q;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C5886Lg2(long j, long j2, AbstractC15520jj2 abstractC15520jj2, List list, ExPeer exPeer, Integer num, int i, Integer num2, Boolean bool, C4026Dj2 c4026Dj2, String str, CW4 cw4, Long l, C17532n74 c17532n74) {
        AbstractC13042fc3.i(abstractC15520jj2, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(list, "reaction");
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, SearchSuggestion.CATEGORY_ICON);
        this.a = j;
        this.b = j2;
        this.c = abstractC15520jj2;
        this.d = list;
        this.e = exPeer;
        this.f = num;
        this.g = i;
        this.h = num2;
        this.i = bool;
        this.j = c4026Dj2;
        this.k = str;
        this.l = cw4;
        this.m = l;
        this.n = c17532n74;
    }

    public final C5886Lg2 b(long j, long j2, AbstractC15520jj2 abstractC15520jj2, List list, ExPeer exPeer, Integer num, int i, Integer num2, Boolean bool, C4026Dj2 c4026Dj2, String str, CW4 cw4, Long l, C17532n74 c17532n74) {
        AbstractC13042fc3.i(abstractC15520jj2, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(list, "reaction");
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, SearchSuggestion.CATEGORY_ICON);
        return new C5886Lg2(j, j2, abstractC15520jj2, list, exPeer, num, i, num2, bool, c4026Dj2, str, cw4, l, c17532n74);
    }

    public final String d() {
        return this.k;
    }

    public final long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C5886Lg2.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.jaryan.feed.model.network.Feed");
        C5886Lg2 c5886Lg2 = (C5886Lg2) obj;
        return this.a == c5886Lg2.a && this.b == c5886Lg2.b && this.e.getPeerId() == c5886Lg2.e.getPeerId();
    }

    public final ExPeer f() {
        return this.e;
    }

    public final Integer g() {
        return this.f;
    }

    public final Long h() {
        return this.m;
    }

    public int hashCode() {
        return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.e.getPeerId());
    }

    public final AbstractC15520jj2 i() {
        return this.c;
    }

    public final CW4 j() {
        return this.l;
    }

    public final List k() {
        return this.d;
    }

    public final C17532n74 l() {
        return this.n;
    }

    public final long m() {
        return this.a;
    }

    public final int n() {
        return this.g;
    }

    public final C4026Dj2 o() {
        return this.j;
    }

    public final Integer p() {
        return this.h;
    }

    public final Boolean q() {
        return this.i;
    }

    public final void r(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.d = list;
    }

    public String toString() {
        return "Feed(rid=" + this.a + ", date=" + this.b + ", message=" + this.c + ", reaction=" + this.d + ", exPeer=" + this.e + ", forwardedCount=" + this.f + ", senderUid=" + this.g + ", upvoteCount=" + this.h + ", isUpvotedByMe=" + this.i + ", tag=" + this.j + ", category=" + this.k + ", parentPostId=" + this.l + ", groupedId=" + this.m + ", repliesInfo=" + this.n + Separators.RPAREN;
    }
}
