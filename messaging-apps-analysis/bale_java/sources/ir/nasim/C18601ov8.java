package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.util.List;

/* renamed from: ir.nasim.ov8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18601ov8 extends Vh8 {
    private final Pv8 c;

    public C18601ov8(Pv8 pv8) {
        super("internal.registerCallback");
        this.c = pv8;
    }

    @Override // ir.nasim.Vh8
    public final InterfaceC22720vi8 a(C20322ro8 c20322ro8, List list) {
        AbstractC9951ap8.h(this.a, 3, list);
        String strJ = c20322ro8.b((InterfaceC22720vi8) list.get(0)).j();
        InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) list.get(1));
        if (!(interfaceC22720vi8B instanceof C20853si8)) {
            throw new IllegalArgumentException("Invalid callback type");
        }
        InterfaceC22720vi8 interfaceC22720vi8B2 = c20322ro8.b((InterfaceC22720vi8) list.get(2));
        if (!(interfaceC22720vi8B2 instanceof C17289mi8)) {
            throw new IllegalArgumentException("Invalid callback params");
        }
        C17289mi8 c17289mi8 = (C17289mi8) interfaceC22720vi8B2;
        if (!c17289mi8.f("type")) {
            throw new IllegalArgumentException("Undefined rule type");
        }
        this.c.a(strJ, c17289mi8.f("priority") ? AbstractC9951ap8.b(c17289mi8.h("priority").k().doubleValue()) : AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, (C20853si8) interfaceC22720vi8B, c17289mi8.h("type").j());
        return InterfaceC22720vi8.r0;
    }
}
