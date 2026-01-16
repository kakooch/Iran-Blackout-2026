package ir.nasim;

import android.content.Intent;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.i74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C14566i74 extends AbstractC5961Lo5 {
    private final AbstractC6544Ny5 b;
    private long c;
    private long d;
    private String e;
    private String f;
    private AbstractC24063xz g;
    private String h;
    private C11458d25 i;
    private String j;
    private long k;
    private String l;
    private long m;
    private String n;
    private String o;
    private C22033uZ0 p;
    private final int q;
    private EnumC13889gz5 r;

    public /* synthetic */ C14566i74(AbstractC6544Ny5 abstractC6544Ny5, long j, long j2, String str, String str2, AbstractC24063xz abstractC24063xz, String str3, C11458d25 c11458d25, String str4, long j3, String str5, long j4, String str6, String str7, C22033uZ0 c22033uZ0, int i, int i2, ED1 ed1) {
        this(abstractC6544Ny5, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0L : j2, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? null : abstractC24063xz, (i2 & 64) != 0 ? null : str3, c11458d25, (i2 & 256) != 0 ? "" : str4, (i2 & 512) != 0 ? 0L : j3, (i2 & 1024) != 0 ? null : str5, (i2 & 2048) != 0 ? 0L : j4, str6, (i2 & 8192) != 0 ? "" : str7, (i2 & 16384) != 0 ? null : c22033uZ0, i);
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public Intent a() {
        Intent intentB = b();
        intentB.putExtra("pushSendTime", this.c);
        intentB.putExtra("messageDate", this.d);
        intentB.putExtra("MessageRID", this.e);
        intentB.putExtra("peerType", this.o);
        intentB.putExtra("senderUserId", this.m);
        intentB.putExtra("peer_user_id", this.f);
        intentB.putExtra("baseMessage", this.h);
        intentB.putExtra("pushType", this.r.name());
        intentB.putExtra(ParameterNames.TEXT, this.n);
        intentB.putExtra("title", this.j);
        intentB.putExtra(ParameterNames.ICON, this.l);
        intentB.putExtra("owner_id", this.q);
        C22033uZ0 c22033uZ0 = this.p;
        if (c22033uZ0 != null) {
            intentB.putExtra("threadMessageRID", c22033uZ0.c());
            intentB.putExtra("threadMessageDate", c22033uZ0.b());
            Integer numA = c22033uZ0.a();
            if (numA != null) {
                intentB.putExtra("discussionGroupPeerId", numA.intValue());
            }
        }
        return intentB;
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public final EnumC13889gz5 c() {
        return this.r;
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public AbstractC6544Ny5 d() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public final AbstractC24063xz e() {
        return this.g;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public final long f() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public final String g() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public final C11458d25 h() {
        return this.i;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public final long i() {
        return this.m;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public final long j() {
        return this.k;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public final String k() {
        return this.l;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public final String l() {
        return this.n;
    }

    @Override // ir.nasim.AbstractC5961Lo5
    public final String m() {
        return this.j;
    }

    public final C22033uZ0 n() {
        return this.p;
    }

    public final String o() {
        return this.f;
    }

    public final long p() {
        return this.c;
    }

    public final void q(EnumC13889gz5 enumC13889gz5) {
        AbstractC13042fc3.i(enumC13889gz5, "<set-?>");
        this.r = enumC13889gz5;
    }

    public final void r(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.n = str;
    }

    public String toString() {
        return "MessagePushNotification(sourceType = " + d() + Separators.RPAREN;
    }

    public C14566i74(AbstractC6544Ny5 abstractC6544Ny5, long j, long j2, String str, String str2, AbstractC24063xz abstractC24063xz, String str3, C11458d25 c11458d25, String str4, long j3, String str5, long j4, String str6, String str7, C22033uZ0 c22033uZ0, int i) {
        AbstractC13042fc3.i(abstractC6544Ny5, "sourceType");
        AbstractC13042fc3.i(str, "messageRid");
        AbstractC13042fc3.i(str2, "peerUserId");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str4, "title");
        AbstractC13042fc3.i(str6, ParameterNames.TEXT);
        AbstractC13042fc3.i(str7, "peerType");
        this.b = abstractC6544Ny5;
        this.c = j;
        this.d = j2;
        this.e = str;
        this.f = str2;
        this.g = abstractC24063xz;
        this.h = str3;
        this.i = c11458d25;
        this.j = str4;
        this.k = j3;
        this.l = str5;
        this.m = j4;
        this.n = str6;
        this.o = str7;
        this.p = c22033uZ0;
        this.q = i;
        this.r = EnumC13889gz5.b;
    }
}
