package ir.nasim;

import ir.nasim.C9736aT6;

/* renamed from: ir.nasim.uR6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21967uR6 {
    public static final C21967uR6 a = new C21967uR6();

    private C21967uR6() {
    }

    public final InterfaceC16114kj5 a() {
        return new C17296mj5();
    }

    public final IX7 b(LX6 lx6, MX6 mx6, ES6 es6) {
        AbstractC13042fc3.i(lx6, "storyWidgetLocalDataSource");
        AbstractC13042fc3.i(mx6, "storyWidgetRemoteDataSource");
        AbstractC13042fc3.i(es6, "storyPreference");
        return new IX7(lx6, mx6, es6);
    }

    public final LX6 c(FX6 fx6, IX6 ix6, KX6 kx6) {
        AbstractC13042fc3.i(fx6, "storyWidgetDao");
        AbstractC13042fc3.i(ix6, "entityMapper");
        AbstractC13042fc3.i(kx6, "dataMapper");
        return new LX6(fx6, ix6, kx6);
    }

    public final ES6 d() {
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.k);
        AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
        return new ES6(interfaceC3570Bk5Q);
    }

    public final MX6 e(VV6 vv6, C9736aT6.a aVar) {
        AbstractC13042fc3.i(vv6, "storyViewApi");
        AbstractC13042fc3.i(aVar, "protobufWidgetToWidgetDataMapper");
        return new MX6(vv6, aVar);
    }
}
