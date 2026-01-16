package ir.nasim;

import ir.nasim.OE4;
import java.util.Map;

/* loaded from: classes5.dex */
public final class VE4 extends AbstractC21707u0 {
    private final InterfaceC9173Yu3 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VE4(final C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "modules");
        this.b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.TE4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return VE4.E(c9057Yh4);
            }
        });
    }

    private final C9528a7 D() {
        Object value = this.b.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (C9528a7) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9528a7 E(final C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(c9057Yh4, "$modules");
        return C12736f7.n().g("actor/notifications", C4614Fw5.d(new V6() { // from class: ir.nasim.UE4
            @Override // ir.nasim.V6
            public final K6 create() {
                return VE4.F(c9057Yh4);
            }
        }).a("D_default"), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 F(C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(c9057Yh4, "$modules");
        return new OE4(c9057Yh4);
    }

    public final void C() {
        D().d(new OE4.b());
    }

    public final void G(int i, long j) {
        D().d(new OE4.c(i, j));
    }

    public final void H(Map map) {
        AbstractC13042fc3.i(map, "remoteMessage");
        D().d(new OE4.d(map));
    }

    public final void I(AbstractC4398Ey5 abstractC4398Ey5) {
        AbstractC13042fc3.i(abstractC4398Ey5, "pushNotification");
        D().d(new OE4.e(abstractC4398Ey5));
    }
}
