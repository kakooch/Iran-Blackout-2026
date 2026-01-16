package ir.nasim;

import java.util.Collection;
import java.util.Set;

/* loaded from: classes8.dex */
public abstract class H1 implements W24 {
    @Override // ir.nasim.W24
    public Set a() {
        return i().a();
    }

    @Override // ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return i().b(c6432No4, ij3);
    }

    @Override // ir.nasim.W24
    public Set c() {
        return i().c();
    }

    @Override // ir.nasim.W24
    public Collection d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return i().d(c6432No4, ij3);
    }

    @Override // ir.nasim.InterfaceC22011uW5
    public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return i().e(c6432No4, ij3);
    }

    @Override // ir.nasim.InterfaceC22011uW5
    public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        return i().f(c24841zI1, ua2);
    }

    @Override // ir.nasim.W24
    public Set g() {
        return i().g();
    }

    public final W24 h() {
        return i() instanceof H1 ? ((H1) i()).h() : i();
    }

    protected abstract W24 i();
}
