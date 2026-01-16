package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.StoryStruct$MediaStory;
import android.gov.nist.core.Separators;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.GeneratedMessageLite;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public final class QQ6 implements Serializable {
    public static final a u = new a(null);
    public static final int v = 8;
    private final long a;
    private final String b;
    private final StoryStruct$MediaStory c;
    private final EnumC14144hQ6 d;
    private final long e;
    private final int f;
    private AbstractC11710dT6 g;
    private final String h;
    private YK6 i;
    private PeersStruct$ExPeer j;
    private C20091rS7 k;
    private boolean l;
    private C14189hV6 m;
    private Integer n;
    private boolean o;
    private List p;
    private boolean q;
    private final AbstractC2383g r;
    private final String s;
    private final Object t;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public QQ6(long j, String str, StoryStruct$MediaStory storyStruct$MediaStory, EnumC14144hQ6 enumC14144hQ6, long j2, int i, AbstractC11710dT6 abstractC11710dT6, String str2, YK6 yk6, PeersStruct$ExPeer peersStruct$ExPeer, C20091rS7 c20091rS7, boolean z, C14189hV6 c14189hV6, Integer num, boolean z2, List list, boolean z3, AbstractC2383g abstractC2383g, String str3, Object obj) {
        AbstractC13042fc3.i(str, "id");
        AbstractC13042fc3.i(abstractC11710dT6, "reaction");
        AbstractC13042fc3.i(yk6, "state");
        this.a = j;
        this.b = str;
        this.c = storyStruct$MediaStory;
        this.d = enumC14144hQ6;
        this.e = j2;
        this.f = i;
        this.g = abstractC11710dT6;
        this.h = str2;
        this.i = yk6;
        this.j = peersStruct$ExPeer;
        this.k = c20091rS7;
        this.l = z;
        this.m = c14189hV6;
        this.n = num;
        this.o = z2;
        this.p = list;
        this.q = z3;
        this.r = abstractC2383g;
        this.s = str3;
        this.t = obj;
    }

    public final C20091rS7 C() {
        return this.k;
    }

    public final List D() {
        return this.p;
    }

    public final boolean E() {
        return this.l;
    }

    public final boolean F(QQ6 qq6) {
        AbstractC13042fc3.i(qq6, "other");
        long j = this.a;
        return (j != -1 && j == qq6.a) || AbstractC13042fc3.d(this.b, qq6.b);
    }

    public final boolean G() {
        C20091rS7 c20091rS7 = this.k;
        return (c20091rS7 == null || c20091rS7 == null || c20091rS7.a() <= 0.0f) ? false : true;
    }

    public final void H(PeersStruct$ExPeer peersStruct$ExPeer) {
        this.j = peersStruct$ExPeer;
    }

    public final void J(boolean z) {
        this.o = z;
    }

    public final void K(AbstractC11710dT6 abstractC11710dT6) {
        AbstractC13042fc3.i(abstractC11710dT6, "<set-?>");
        this.g = abstractC11710dT6;
    }

    public final void L(Integer num) {
        this.n = num;
    }

    public final void M(List list) {
        this.p = list;
    }

    public final long a(long j) {
        return this.e + TimeUnit.HOURS.toSeconds(j);
    }

    public final QQ6 b(long j, String str, StoryStruct$MediaStory storyStruct$MediaStory, EnumC14144hQ6 enumC14144hQ6, long j2, int i, AbstractC11710dT6 abstractC11710dT6, String str2, YK6 yk6, PeersStruct$ExPeer peersStruct$ExPeer, C20091rS7 c20091rS7, boolean z, C14189hV6 c14189hV6, Integer num, boolean z2, List list, boolean z3, AbstractC2383g abstractC2383g, String str3, Object obj) {
        AbstractC13042fc3.i(str, "id");
        AbstractC13042fc3.i(abstractC11710dT6, "reaction");
        AbstractC13042fc3.i(yk6, "state");
        return new QQ6(j, str, storyStruct$MediaStory, enumC14144hQ6, j2, i, abstractC11710dT6, str2, yk6, peersStruct$ExPeer, c20091rS7, z, c14189hV6, num, z2, list, z3, abstractC2383g, str3, obj);
    }

    public final StoryStruct$MediaStory d() {
        return this.c;
    }

    public final EnumC14144hQ6 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QQ6)) {
            return false;
        }
        QQ6 qq6 = (QQ6) obj;
        return this.a == qq6.a && AbstractC13042fc3.d(this.b, qq6.b) && AbstractC13042fc3.d(this.c, qq6.c) && this.d == qq6.d && this.e == qq6.e && this.f == qq6.f && AbstractC13042fc3.d(this.g, qq6.g) && AbstractC13042fc3.d(this.h, qq6.h) && this.i == qq6.i && AbstractC13042fc3.d(this.j, qq6.j) && AbstractC13042fc3.d(this.k, qq6.k) && this.l == qq6.l && AbstractC13042fc3.d(this.m, qq6.m) && AbstractC13042fc3.d(this.n, qq6.n) && this.o == qq6.o && AbstractC13042fc3.d(this.p, qq6.p) && this.q == qq6.q && AbstractC13042fc3.d(this.r, qq6.r) && AbstractC13042fc3.d(this.s, qq6.s) && AbstractC13042fc3.d(this.t, qq6.t);
    }

    public final long f() {
        return this.e;
    }

    public final PeersStruct$ExPeer g() {
        return this.j;
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        StoryStruct$MediaStory storyStruct$MediaStory = this.c;
        int iHashCode2 = (iHashCode + (storyStruct$MediaStory == null ? 0 : storyStruct$MediaStory.hashCode())) * 31;
        EnumC14144hQ6 enumC14144hQ6 = this.d;
        int iHashCode3 = (((((((iHashCode2 + (enumC14144hQ6 == null ? 0 : enumC14144hQ6.hashCode())) * 31) + Long.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode()) * 31;
        String str = this.h;
        int iHashCode4 = (((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.i.hashCode()) * 31;
        PeersStruct$ExPeer peersStruct$ExPeer = this.j;
        int iHashCode5 = (iHashCode4 + (peersStruct$ExPeer == null ? 0 : peersStruct$ExPeer.hashCode())) * 31;
        C20091rS7 c20091rS7 = this.k;
        int iHashCode6 = (((iHashCode5 + (c20091rS7 == null ? 0 : c20091rS7.hashCode())) * 31) + Boolean.hashCode(this.l)) * 31;
        C14189hV6 c14189hV6 = this.m;
        int iHashCode7 = (iHashCode6 + (c14189hV6 == null ? 0 : c14189hV6.hashCode())) * 31;
        Integer num = this.n;
        int iHashCode8 = (((iHashCode7 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.o)) * 31;
        List list = this.p;
        int iHashCode9 = (((iHashCode8 + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.q)) * 31;
        AbstractC2383g abstractC2383g = this.r;
        int iHashCode10 = (iHashCode9 + (abstractC2383g == null ? 0 : abstractC2383g.hashCode())) * 31;
        String str2 = this.s;
        int iHashCode11 = (iHashCode10 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Object obj = this.t;
        return iHashCode11 + (obj != null ? obj.hashCode() : 0);
    }

    public final long i() {
        return this.a;
    }

    public final Object j() {
        return this.t;
    }

    public final boolean k() {
        return this.q;
    }

    public final String l() {
        return this.b;
    }

    public final String m() {
        return this.h;
    }

    public final C11458d25 n() {
        C11458d25 c11458d25L;
        PeersStruct$ExPeer peersStruct$ExPeer = this.j;
        if (peersStruct$ExPeer != null && (c11458d25L = C18732p92.l(peersStruct$ExPeer)) != null) {
            return c11458d25L;
        }
        GeneratedMessageLite generatedMessageLiteA = PeersStruct$ExPeer.newBuilder().B(this.f).C(EnumC10088b35.ExPeerType_PRIVATE).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        return C18732p92.l((PeersStruct$ExPeer) generatedMessageLiteA);
    }

    public final int p() {
        return this.f;
    }

    public final boolean q() {
        return this.o;
    }

    public final String r() {
        return this.s;
    }

    public final AbstractC11710dT6 s() {
        return this.g;
    }

    public String toString() {
        return "StoryItem(rid=" + this.a + ", id=" + this.b + ", content=" + this.c + ", contentType=" + this.d + ", createdAt=" + this.e + ", ownerUserId=" + this.f + ", reaction=" + this.g + ", imagePath=" + this.h + ", state=" + this.i + ", exPeer=" + this.j + ", videoStory=" + this.k + ", isPopular=" + this.l + ", tag=" + this.m + ", tagIdInAll=" + this.n + ", quoteInAll=" + this.o + ", widget=" + this.p + ", hasWidget=" + this.q + ", thumbnail=" + this.r + ", rawFilePath=" + this.s + ", extras=" + this.t + Separators.RPAREN;
    }

    public final YK6 u() {
        return this.i;
    }

    public final C14189hV6 w() {
        return this.m;
    }

    public final Integer y() {
        return this.n;
    }

    public final AbstractC2383g z() {
        return this.r;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ QQ6(long j, String str, StoryStruct$MediaStory storyStruct$MediaStory, EnumC14144hQ6 enumC14144hQ6, long j2, int i, AbstractC11710dT6 abstractC11710dT6, String str2, YK6 yk6, PeersStruct$ExPeer peersStruct$ExPeer, C20091rS7 c20091rS7, boolean z, C14189hV6 c14189hV6, Integer num, boolean z2, List list, boolean z3, AbstractC2383g abstractC2383g, String str3, Object obj, int i2, ED1 ed1) {
        long j3 = (i2 & 1) != 0 ? -1L : j;
        this(j3, (i2 & 2) != 0 ? String.valueOf(j3) : str, (i2 & 4) != 0 ? null : storyStruct$MediaStory, (i2 & 8) != 0 ? EnumC14144hQ6.a : enumC14144hQ6, j2, i, abstractC11710dT6, (i2 & 128) != 0 ? null : str2, (i2 & 256) != 0 ? YK6.c : yk6, (i2 & 512) != 0 ? null : peersStruct$ExPeer, (i2 & 1024) != 0 ? null : c20091rS7, (i2 & 2048) != 0 ? false : z, (i2 & 4096) != 0 ? null : c14189hV6, (i2 & 8192) != 0 ? null : num, (i2 & 16384) != 0 ? false : z2, (32768 & i2) != 0 ? null : list, (65536 & i2) != 0 ? false : z3, (131072 & i2) != 0 ? null : abstractC2383g, (262144 & i2) != 0 ? null : str3, (i2 & 524288) != 0 ? null : obj);
    }
}
