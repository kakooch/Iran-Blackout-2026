package androidx.compose.material.ripple;

import ir.nasim.InterfaceC21734u26;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class c {
    private final Map a = new LinkedHashMap();
    private final Map b = new LinkedHashMap();

    public final RippleHostView a(InterfaceC21734u26 interfaceC21734u26) {
        return (RippleHostView) this.a.get(interfaceC21734u26);
    }

    public final InterfaceC21734u26 b(RippleHostView rippleHostView) {
        return (InterfaceC21734u26) this.b.get(rippleHostView);
    }

    public final void c(InterfaceC21734u26 interfaceC21734u26) {
        RippleHostView rippleHostView = (RippleHostView) this.a.get(interfaceC21734u26);
        if (rippleHostView != null) {
        }
        this.a.remove(interfaceC21734u26);
    }

    public final void d(InterfaceC21734u26 interfaceC21734u26, RippleHostView rippleHostView) {
        this.a.put(interfaceC21734u26, rippleHostView);
        this.b.put(rippleHostView, interfaceC21734u26);
    }
}
