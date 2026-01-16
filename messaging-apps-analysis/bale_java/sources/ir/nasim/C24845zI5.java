package ir.nasim;

import android.content.Intent;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.zI5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24845zI5 extends AbstractC4398Ey5 {
    private final AbstractC6544Ny5 b;
    private long c;
    private long d;
    private String e;
    private String f;
    private String g;
    private AbstractC24063xz h;
    private String i;
    private C11458d25 j;
    private C22033uZ0 k;
    private final EnumC13889gz5 l;

    public /* synthetic */ C24845zI5(AbstractC6544Ny5 abstractC6544Ny5, long j, long j2, String str, String str2, String str3, AbstractC24063xz abstractC24063xz, String str4, C11458d25 c11458d25, C22033uZ0 c22033uZ0, int i, ED1 ed1) {
        this(abstractC6544Ny5, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? null : abstractC24063xz, (i & 128) != 0 ? null : str4, c11458d25, (i & 512) != 0 ? null : c22033uZ0);
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public Intent a() {
        Intent intentB = b();
        intentB.putExtra("pushSendTime", this.c);
        intentB.putExtra("messageDate", this.d);
        intentB.putExtra("peerType", this.e);
        intentB.putExtra("senderUserId", this.f);
        intentB.putExtra("update_peer_user_id", this.g);
        intentB.putExtra("baseMessage", this.i);
        intentB.putExtra("pushType", c());
        C22033uZ0 c22033uZ0 = this.k;
        if (c22033uZ0 != null) {
            intentB.putExtra("threadMessageRID", c22033uZ0.c());
            intentB.putExtra("threadMessageDate", c22033uZ0.b());
        }
        return intentB;
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public EnumC13889gz5 c() {
        return this.l;
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public AbstractC6544Ny5 d() {
        return this.b;
    }

    public final long e() {
        return this.d;
    }

    public final C11458d25 f() {
        return this.j;
    }

    public final String g() {
        return this.g;
    }

    public final long h() {
        return this.c;
    }

    public String toString() {
        return "ReadPushNotification(sourceType = " + d() + Separators.RPAREN;
    }

    public C24845zI5(AbstractC6544Ny5 abstractC6544Ny5, long j, long j2, String str, String str2, String str3, AbstractC24063xz abstractC24063xz, String str4, C11458d25 c11458d25, C22033uZ0 c22033uZ0) {
        AbstractC13042fc3.i(abstractC6544Ny5, "sourceType");
        AbstractC13042fc3.i(str, "peerType");
        AbstractC13042fc3.i(str2, "senderUserId");
        AbstractC13042fc3.i(str3, "peerUserId");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.b = abstractC6544Ny5;
        this.c = j;
        this.d = j2;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = abstractC24063xz;
        this.i = str4;
        this.j = c11458d25;
        this.k = c22033uZ0;
        this.l = EnumC13889gz5.e;
    }
}
