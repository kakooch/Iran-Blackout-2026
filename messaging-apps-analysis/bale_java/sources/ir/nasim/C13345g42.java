package ir.nasim;

import android.content.Intent;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.g42, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13345g42 extends AbstractC4398Ey5 {
    private final AbstractC6544Ny5 b;
    private long c;
    private long d;
    private String e;
    private String f;
    private String g;
    private String h;
    private AbstractC24063xz i;
    private String j;
    private String k;
    private String l;
    private C11458d25 m;
    private C22033uZ0 n;
    private final EnumC13889gz5 o;

    public /* synthetic */ C13345g42(AbstractC6544Ny5 abstractC6544Ny5, long j, long j2, String str, String str2, String str3, String str4, AbstractC24063xz abstractC24063xz, String str5, String str6, String str7, C11458d25 c11458d25, C22033uZ0 c22033uZ0, int i, ED1 ed1) {
        this(abstractC6544Ny5, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? null : abstractC24063xz, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? "" : str6, (i & 1024) != 0 ? "" : str7, c11458d25, (i & 4096) != 0 ? null : c22033uZ0);
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public Intent a() {
        Intent intentB = b();
        intentB.putExtra("pushSendTime", this.c);
        intentB.putExtra("messageDate", this.d);
        intentB.putExtra("MessageRID", this.e);
        intentB.putExtra("peerType", this.f);
        intentB.putExtra("senderUserId", this.g);
        intentB.putExtra("update_peer_user_id", this.h);
        intentB.putExtra("baseMessage", this.j);
        intentB.putExtra("editedText", this.k);
        intentB.putExtra("title", this.l);
        intentB.putExtra("pushType", c());
        C22033uZ0 c22033uZ0 = this.n;
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
    public EnumC13889gz5 c() {
        return this.o;
    }

    @Override // ir.nasim.AbstractC4398Ey5
    public AbstractC6544Ny5 d() {
        return this.b;
    }

    public final C22033uZ0 e() {
        return this.n;
    }

    public final String f() {
        return this.k;
    }

    public final long g() {
        return this.d;
    }

    public final String h() {
        return this.e;
    }

    public final C11458d25 i() {
        return this.m;
    }

    public final String j() {
        return this.h;
    }

    public final long k() {
        return this.c;
    }

    public String toString() {
        return "EditPushNotification(sourceType = " + d() + Separators.RPAREN;
    }

    public C13345g42(AbstractC6544Ny5 abstractC6544Ny5, long j, long j2, String str, String str2, String str3, String str4, AbstractC24063xz abstractC24063xz, String str5, String str6, String str7, C11458d25 c11458d25, C22033uZ0 c22033uZ0) {
        AbstractC13042fc3.i(abstractC6544Ny5, "sourceType");
        AbstractC13042fc3.i(str, "messageRid");
        AbstractC13042fc3.i(str2, "peerType");
        AbstractC13042fc3.i(str3, "senderUserId");
        AbstractC13042fc3.i(str4, "peerUserId");
        AbstractC13042fc3.i(str6, "editedText");
        AbstractC13042fc3.i(str7, "title");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.b = abstractC6544Ny5;
        this.c = j;
        this.d = j2;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = abstractC24063xz;
        this.j = str5;
        this.k = str6;
        this.l = str7;
        this.m = c11458d25;
        this.n = c22033uZ0;
        this.o = EnumC13889gz5.d;
    }
}
