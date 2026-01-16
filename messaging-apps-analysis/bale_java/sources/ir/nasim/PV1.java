package ir.nasim;

import ir.nasim.InterfaceC11814db6;
import java.util.Map;

/* loaded from: classes2.dex */
public final class PV1 implements InterfaceC11814db6 {
    private final SA2 a;
    private final /* synthetic */ InterfaceC11814db6 b;

    public PV1(InterfaceC11814db6 interfaceC11814db6, SA2 sa2) {
        this.a = sa2;
        this.b = interfaceC11814db6;
    }

    @Override // ir.nasim.InterfaceC11814db6
    public boolean a(Object obj) {
        return this.b.a(obj);
    }

    public final void b() {
        this.a.invoke();
    }

    @Override // ir.nasim.InterfaceC11814db6
    public Map d() {
        return this.b.d();
    }

    @Override // ir.nasim.InterfaceC11814db6
    public Object e(String str) {
        return this.b.e(str);
    }

    @Override // ir.nasim.InterfaceC11814db6
    public InterfaceC11814db6.a f(String str, SA2 sa2) {
        return this.b.f(str, sa2);
    }
}
