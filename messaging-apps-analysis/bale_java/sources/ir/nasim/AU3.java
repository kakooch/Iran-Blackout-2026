package ir.nasim;

import ir.nasim.InterfaceC24357yU3;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
class AU3 implements InterfaceC24357yU3 {
    private final C18332oU3 a;
    private final InterfaceC17689nO5 b;
    private final C15272jI6 c;
    private final Map d;
    private final InterfaceC24357yU3.a e;

    static class a implements InterfaceC24357yU3.b {
        private final Map a = new HashMap();
        private InterfaceC24357yU3.a b;

        a() {
        }

        @Override // ir.nasim.InterfaceC24357yU3.b
        public InterfaceC24357yU3.b a(Class cls, InterfaceC24357yU3.c cVar) {
            if (cVar == null) {
                this.a.remove(cls);
            } else {
                this.a.put(cls, cVar);
            }
            return this;
        }

        @Override // ir.nasim.InterfaceC24357yU3.b
        public InterfaceC24357yU3 b(C18332oU3 c18332oU3, InterfaceC17689nO5 interfaceC17689nO5) {
            InterfaceC24357yU3.a c13707gh0 = this.b;
            if (c13707gh0 == null) {
                c13707gh0 = new C13707gh0();
            }
            return new AU3(c18332oU3, interfaceC17689nO5, new C15272jI6(), Collections.unmodifiableMap(this.a), c13707gh0);
        }
    }

    AU3(C18332oU3 c18332oU3, InterfaceC17689nO5 interfaceC17689nO5, C15272jI6 c15272jI6, Map map, InterfaceC24357yU3.a aVar) {
        this.a = c18332oU3;
        this.b = interfaceC17689nO5;
        this.c = c15272jI6;
        this.d = map;
        this.e = aVar;
    }

    private void C(TA4 ta4) {
        InterfaceC24357yU3.c cVar = (InterfaceC24357yU3.c) this.d.get(ta4.getClass());
        if (cVar != null) {
            cVar.a(this, ta4);
        } else {
            q(ta4);
        }
    }

    public void A(int i, Object obj) {
        C15272jI6 c15272jI6 = this.c;
        C15272jI6.k(c15272jI6, obj, i, c15272jI6.length());
    }

    public void B(Class cls, int i) {
        InterfaceC12254eI6 interfaceC12254eI6A = this.a.a().a(cls);
        if (interfaceC12254eI6A != null) {
            A(i, interfaceC12254eI6A.a(this.a, this.b));
        }
    }

    @Override // ir.nasim.NY7
    public void a(NB3 nb3) {
        C(nb3);
    }

    @Override // ir.nasim.NY7
    public void b(O03 o03) {
        C(o03);
    }

    @Override // ir.nasim.NY7
    public void c(C22401vA3 c22401vA3) {
        C(c22401vA3);
    }

    @Override // ir.nasim.NY7
    public void d(PL4 pl4) {
        C(pl4);
    }

    @Override // ir.nasim.NY7
    public void e(C19991rH6 c19991rH6) {
        C(c19991rH6);
    }

    @Override // ir.nasim.NY7
    public void f(C14832iZ2 c14832iZ2) {
        C(c14832iZ2);
    }

    @Override // ir.nasim.NY7
    public void g(C10116b63 c10116b63) {
        C(c10116b63);
    }

    @Override // ir.nasim.NY7
    public void h(C9452Zz3 c9452Zz3) {
        C(c9452Zz3);
    }

    @Override // ir.nasim.NY7
    public void i(AbstractC24047xx1 abstractC24047xx1) {
        C(abstractC24047xx1);
    }

    @Override // ir.nasim.NY7
    public void j(C19530qW1 c19530qW1) {
        C(c19530qW1);
    }

    @Override // ir.nasim.NY7
    public void k(Z62 z62) {
        C(z62);
    }

    @Override // ir.nasim.NY7
    public void l(BW0 bw0) {
        C(bw0);
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public int length() {
        return this.c.length();
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public C15272jI6 m() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public void n(TA4 ta4) {
        this.e.a(this, ta4);
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public InterfaceC17689nO5 o() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public void p(TA4 ta4, int i) {
        B(ta4.getClass(), i);
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public void q(TA4 ta4) {
        TA4 ta4C = ta4.c();
        while (ta4C != null) {
            TA4 ta4E = ta4C.e();
            ta4C.a(this);
            ta4C = ta4E;
        }
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public C18332oU3 r() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public void s() {
        this.c.append('\n');
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public boolean t(TA4 ta4) {
        return ta4.e() != null;
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public void u() {
        if (this.c.length() <= 0 || '\n' == this.c.h()) {
            return;
        }
        this.c.append('\n');
    }

    @Override // ir.nasim.NY7
    public void v(C17149mU2 c17149mU2) {
        C(c17149mU2);
    }

    @Override // ir.nasim.NY7
    public void w(C9761aW4 c9761aW4) {
        C(c9761aW4);
    }

    @Override // ir.nasim.NY7
    public void x(BZ6 bz6) {
        C(bz6);
    }

    @Override // ir.nasim.NY7
    public void y(C5693Kk7 c5693Kk7) {
        C(c5693Kk7);
    }

    @Override // ir.nasim.InterfaceC24357yU3
    public void z(TA4 ta4) {
        this.e.b(this, ta4);
    }
}
