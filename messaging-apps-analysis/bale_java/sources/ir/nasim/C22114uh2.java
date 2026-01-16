package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.uh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22114uh2 {
    private final long a;
    private final long b;
    private final long c;
    private final int d;
    private final ExPeerType e;
    private final byte[] f;
    private List g;
    private final Integer h;
    private final int i;
    private final Integer j;
    private final Boolean k;
    private final String l;
    private final int m;
    private final C4026Dj2 n;
    private CW4 o;
    private final Long p;
    private final Integer q;
    private final int r;
    private final long s;

    public C22114uh2(long j, long j2, long j3, int i, ExPeerType exPeerType, byte[] bArr, List list, Integer num, int i2, Integer num2, Boolean bool, String str, int i3, C4026Dj2 c4026Dj2, CW4 cw4, Long l, Integer num3, int i4, long j4) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(bArr, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(list, "reaction");
        AbstractC13042fc3.i(str, SearchSuggestion.CATEGORY_ICON);
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = i;
        this.e = exPeerType;
        this.f = bArr;
        this.g = list;
        this.h = num;
        this.i = i2;
        this.j = num2;
        this.k = bool;
        this.l = str;
        this.m = i3;
        this.n = c4026Dj2;
        this.o = cw4;
        this.p = l;
        this.q = num3;
        this.r = i4;
        this.s = j4;
    }

    public final String a() {
        return this.l;
    }

    public final int b() {
        return this.r;
    }

    public final Integer c() {
        return this.q;
    }

    public final long d() {
        return this.c;
    }

    public final ExPeerType e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C22114uh2.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.jaryan.feed.model.db.FeedEntity");
        C22114uh2 c22114uh2 = (C22114uh2) obj;
        return this.b == c22114uh2.b && this.c == c22114uh2.c && this.d == c22114uh2.d && this.r == c22114uh2.r;
    }

    public final long f() {
        return this.s;
    }

    public final Integer g() {
        return this.h;
    }

    public final Long h() {
        return this.p;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.b) * 31) + Long.hashCode(this.c)) * 31) + this.d) * 31) + this.r;
    }

    public final byte[] i() {
        return this.f;
    }

    public final int j() {
        return this.m;
    }

    public final CW4 k() {
        return this.o;
    }

    public final int l() {
        return this.d;
    }

    public final List m() {
        return this.g;
    }

    public final long n() {
        return this.b;
    }

    public final int o() {
        return this.i;
    }

    public final long p() {
        return this.a;
    }

    public final C4026Dj2 q() {
        return this.n;
    }

    public final Integer r() {
        return this.j;
    }

    public final Boolean s() {
        return this.k;
    }

    public final void t(CW4 cw4) {
        this.o = cw4;
    }

    public String toString() {
        return "FeedEntity(sortId=" + this.a + ", rid=" + this.b + ", date=" + this.c + ", peerId=" + this.d + ", exPeerType=" + this.e + ", message=" + Arrays.toString(this.f) + ", reaction=" + this.g + ", forwardedCount=" + this.h + ", senderUid=" + this.i + ", upvoteCount=" + this.j + ", isUpvotedByMe=" + this.k + ", category=" + this.l + ", messageType=" + this.m + ", tag=" + this.n + ", parentPostId=" + this.o + ", groupedId=" + this.p + ", commentCount=" + this.q + ", categoryId=" + this.r + ", fileId=" + this.s + Separators.RPAREN;
    }

    public /* synthetic */ C22114uh2(long j, long j2, long j3, int i, ExPeerType exPeerType, byte[] bArr, List list, Integer num, int i2, Integer num2, Boolean bool, String str, int i3, C4026Dj2 c4026Dj2, CW4 cw4, Long l, Integer num3, int i4, long j4, int i5, ED1 ed1) {
        this((i5 & 1) != 0 ? 0L : j, j2, j3, i, exPeerType, bArr, list, num, i2, num2, bool, str, i3, (i5 & 8192) != 0 ? null : c4026Dj2, (i5 & 16384) != 0 ? null : cw4, l, (i5 & 65536) != 0 ? null : num3, i4, j4);
    }
}
