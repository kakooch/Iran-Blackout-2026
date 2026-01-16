package ir.nasim;

import ir.nasim.InterfaceC22805vr3;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes8.dex */
public final class WL5 implements InterfaceC22805vr3 {
    public static final a c = new a(null);
    private final Class a;
    private final C21625tr3 b;

    public static final class a {
        private a() {
        }

        public final WL5 a(Class cls) {
            AbstractC13042fc3.i(cls, "klass");
            C22475vI5 c22475vI5 = new C22475vI5();
            C21238tL5.a.b(cls, c22475vI5);
            C21625tr3 c21625tr3N = c22475vI5.n();
            ED1 ed1 = null;
            if (c21625tr3N == null) {
                return null;
            }
            return new WL5(cls, c21625tr3N, ed1);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ WL5(Class cls, C21625tr3 c21625tr3, ED1 ed1) {
        this(cls, c21625tr3);
    }

    @Override // ir.nasim.InterfaceC22805vr3
    public void a(InterfaceC22805vr3.d dVar, byte[] bArr) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(dVar, "visitor");
        C21238tL5.a.i(this.a, dVar);
    }

    @Override // ir.nasim.InterfaceC22805vr3
    public void b(InterfaceC22805vr3.c cVar, byte[] bArr) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(cVar, "visitor");
        C21238tL5.a.b(this.a, cVar);
    }

    @Override // ir.nasim.InterfaceC22805vr3
    public C21625tr3 c() {
        return this.b;
    }

    public final Class d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WL5) && AbstractC13042fc3.d(this.a, ((WL5) obj).a);
    }

    @Override // ir.nasim.InterfaceC22805vr3
    public C24948zU0 f() {
        return AbstractC21912uL5.b(this.a);
    }

    @Override // ir.nasim.InterfaceC22805vr3
    public String getLocation() {
        String name = this.a.getName();
        AbstractC13042fc3.h(name, "klass.name");
        return AbstractC13042fc3.q(AbstractC20153rZ6.L(name, '.', '/', false, 4, null), ".class");
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return WL5.class.getName() + ": " + this.a;
    }

    private WL5(Class cls, C21625tr3 c21625tr3) {
        this.a = cls;
        this.b = c21625tr3;
    }
}
