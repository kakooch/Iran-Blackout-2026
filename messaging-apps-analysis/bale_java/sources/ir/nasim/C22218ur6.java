package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.ur6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22218ur6 extends AbstractC12586er6 {
    private final int d;
    private final long e;
    private final long f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22218ur6(C11909dl1 c11909dl1) {
        super(c11909dl1, (ED1) null);
        AbstractC13042fc3.i(c11909dl1, "remoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceMessage");
        C23011wC c23011wC = (C23011wC) abstractC24063xzC;
        VB vbU = c23011wC.u();
        AbstractC13042fc3.g(vbU, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExGiftPacketOpened");
        this.d = ((C14011hC) vbU).y();
        VB vbU2 = c23011wC.u();
        AbstractC13042fc3.g(vbU2, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExGiftPacketOpened");
        this.e = ((C14011hC) vbU2).w();
        VB vbU3 = c23011wC.u();
        AbstractC13042fc3.g(vbU3, "null cannot be cast to non-null type ir.nasim.core.api.ApiServiceExGiftPacketOpened");
        this.f = ((C14011hC) vbU3).u();
    }

    @Override // ir.nasim.InterfaceC13222fr6
    public String a(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return AbstractC20655sN7.b(AbstractC20655sN7.c(context, AbstractC12217eE5.service_holder_gift_packet_opened, C24847zI7.b(C24847zI7.a, context, i, str, false, 8, null)), context, i == AbstractC5969Lp4.f());
    }
}
