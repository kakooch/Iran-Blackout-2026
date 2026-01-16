package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.gq6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13803gq6 implements InterfaceC19567qa2 {
    private final C6409Nm a;

    public C13803gq6(C6409Nm c6409Nm) {
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        this.a = c6409Nm;
    }

    @Override // ir.nasim.InterfaceC19567qa2
    public void a(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        this.a.d(str, map);
    }

    @Override // ir.nasim.InterfaceC19567qa2
    public void b(String str) {
        AbstractC13042fc3.i(str, "eventName");
        this.a.b(str);
    }
}
