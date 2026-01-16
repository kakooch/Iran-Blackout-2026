package ir.nasim;

import android.content.Intent;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class GH5 extends AbstractC5961Lo5 {
    private final AbstractC6544Ny5 b;
    private long c;
    private long d;
    private String e;
    private String f;
    private AbstractC24063xz g;
    private String h;
    private C11458d25 i;
    private String j;
    private String k;
    private long l;
    private String m;
    private long n;
    private final int o;
    private String p;
    private String q;
    private String r;
    private String s;
    private int t;
    private boolean u;
    private int v;
    private final EnumC13889gz5 w;

    public GH5(AbstractC6544Ny5 abstractC6544Ny5, long j, long j2, String str, String str2, AbstractC24063xz abstractC24063xz, String str3, C11458d25 c11458d25, String str4, String str5, long j3, String str6, long j4, int i, String str7, String str8, String str9, String str10, int i2, boolean z, int i3) {
        AbstractC13042fc3.i(abstractC6544Ny5, "sourceType");
        AbstractC13042fc3.i(str, "messageRid");
        AbstractC13042fc3.i(str2, "peerUserId");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str4, ParameterNames.TEXT);
        AbstractC13042fc3.i(str5, "title");
        AbstractC13042fc3.i(str7, "reactionPeerType");
        AbstractC13042fc3.i(str8, "reactionExPeerType");
        AbstractC13042fc3.i(str9, "reactionCode");
        AbstractC13042fc3.i(str10, "reactionPeerId");
        this.b = abstractC6544Ny5;
        this.c = j;
        this.d = j2;
        this.e = str;
        this.f = str2;
        this.g = abstractC24063xz;
        this.h = str3;
        this.i = c11458d25;
        this.j = str4;
        this.k = str5;
        this.l = j3;
        this.m = str6;
        this.n = j4;
        this.o = i;
        this.p = str7;
        this.q = str8;
        this.r = str9;
        this.s = str10;
        this.t = i2;
        this.u = z;
        this.v = i3;
        this.w = EnumC13889gz5.f;
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public Intent a() {
        Intent intentB = b();
        intentB.putExtra("pushSendTime", q());
        intentB.putExtra("messageDate", f());
        intentB.putExtra("messageRid", g());
        intentB.putExtra("MessageRID", g());
        intentB.putExtra("peer_user_id", p());
        intentB.putExtra("baseMessage", n());
        intentB.putExtra("pushType", c().name());
        intentB.putExtra("peerType", this.p);
        intentB.putExtra(DialogEntity.COLUMN_EX_PEER_TYPE, this.q);
        intentB.putExtra("reactionCode", this.r);
        intentB.putExtra("peerId", this.s);
        intentB.putExtra("count", this.t);
        intentB.putExtra("isSet", this.u);
        intentB.putExtra("userIds", p());
        intentB.putExtra("apiMessage", n());
        intentB.putExtra(ParameterNames.ICON, k());
        intentB.putExtra(ParameterNames.TEXT, l());
        intentB.putExtra("title", m());
        intentB.putExtra("senderUserId", i());
        intentB.putExtra("owner_id", o());
        return intentB;
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public EnumC13889gz5 c() {
        return this.w;
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public AbstractC6544Ny5 d() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public AbstractC24063xz e() {
        return this.g;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public long f() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public String g() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public C11458d25 h() {
        return this.i;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public long i() {
        return this.n;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public long j() {
        return this.l;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public String k() {
        return this.m;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public String l() {
        return this.j;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public String m() {
        return this.k;
    }

    public String n() {
        return this.h;
    }

    public int o() {
        return this.o;
    }

    public String p() {
        return this.f;
    }

    public long q() {
        return this.c;
    }

    public final String r() {
        return this.r;
    }

    public final String s() {
        return this.q;
    }

    public final boolean t() {
        return this.u;
    }

    public String toString() {
        return "ReactionPushNotification(sourceType = " + d() + Separators.RPAREN;
    }

    public final String u() {
        return this.s;
    }

    public final int v() {
        return this.v;
    }

    public final void w(int i) {
        this.v = i;
    }

    public void x(long j) {
        this.n = j;
    }

    public void y(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.j = str;
    }
}
