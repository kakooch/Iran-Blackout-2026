package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.vr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22808vr6 extends AbstractC12586er6 {
    private final int d;
    private final int e;
    private final long f;
    private final long g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22808vr6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "remoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        VB vbU = ((C23011wC) abstractC24063xzC).u();
        AbstractC13042fc3.g(vbU, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExGiftPacketOpenedCompact");
        C14613iC c14613iC = (C14613iC) vbU;
        this.d = c14613iC.u();
        this.e = c14613iC.z();
        this.f = c14613iC.y();
        this.g = c14613iC.w();
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String strB = C24847zI7.b(C24847zI7.a, context, i, str, false, 8, null);
        int i2 = this.e;
        if (i2 > 0) {
            return AbstractC20655sN7.a(AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_gift_packet_opened_compact, strB, XY6.v(String.valueOf(i2))), context, true);
        }
        return AbstractC20655sN7.b(AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_gift_packet_opened, strB), context, i == AbstractC5969Lp4.f());
    }

    public final int s() {
        return this.e;
    }
}
