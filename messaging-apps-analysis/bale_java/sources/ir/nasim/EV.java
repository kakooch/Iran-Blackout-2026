package ir.nasim;

/* loaded from: classes2.dex */
public interface EV extends WH1 {
    static /* synthetic */ Object D0(EV ev, EnumC4002Dg5 enumC4002Dg5, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
        }
        if ((i & 1) != 0) {
            enumC4002Dg5 = EnumC4002Dg5.b;
        }
        return ev.f0(enumC4002Dg5, interfaceC20295rm1);
    }

    Object Q(long j, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1);

    C3534Bg5 S0();

    long a();

    Object f0(EnumC4002Dg5 enumC4002Dg5, InterfaceC20295rm1 interfaceC20295rm1);

    Object f1(long j, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1);

    InterfaceC18354oW7 getViewConfiguration();

    long t0();
}
