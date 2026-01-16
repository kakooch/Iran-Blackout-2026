package ir.nasim;

import ir.nasim.AbstractC7392Rn1;
import ir.nasim.InterfaceC22581vU3;
import ir.nasim.InterfaceC24357yU3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Qn1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C7158Qn1 extends AbstractC16876m1 {
    private final List a = new ArrayList(0);

    /* renamed from: ir.nasim.Qn1$a */
    class a implements InterfaceC24357yU3.c {
        a() {
        }

        @Override // ir.nasim.InterfaceC24357yU3.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC24357yU3 interfaceC24357yU3, C17149mU2 c17149mU2) {
            interfaceC24357yU3.u();
        }
    }

    /* renamed from: ir.nasim.Qn1$b */
    class b implements InterfaceC24357yU3.c {
        b() {
        }

        @Override // ir.nasim.InterfaceC24357yU3.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC24357yU3 interfaceC24357yU3, C9761aW4 c9761aW4) {
            boolean zQ = C7158Qn1.q(c9761aW4);
            if (!zQ) {
                interfaceC24357yU3.z(c9761aW4);
            }
            int length = interfaceC24357yU3.length();
            interfaceC24357yU3.q(c9761aW4);
            AbstractC7392Rn1.f.d(interfaceC24357yU3.o(), Boolean.valueOf(zQ));
            interfaceC24357yU3.p(c9761aW4, length);
            if (zQ) {
                return;
            }
            interfaceC24357yU3.n(c9761aW4);
        }
    }

    /* renamed from: ir.nasim.Qn1$c */
    class c implements InterfaceC24357yU3.c {
        c() {
        }

        @Override // ir.nasim.InterfaceC24357yU3.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC24357yU3 interfaceC24357yU3, C5693Kk7 c5693Kk7) {
            String strM = c5693Kk7.m();
            interfaceC24357yU3.m().d(strM);
            if (C7158Qn1.this.a.isEmpty()) {
                return;
            }
            int length = interfaceC24357yU3.length() - strM.length();
            Iterator it = C7158Qn1.this.a.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(interfaceC24357yU3, strM, length);
            }
        }
    }

    /* renamed from: ir.nasim.Qn1$d */
    class d implements InterfaceC24357yU3.c {
        d() {
        }

        @Override // ir.nasim.InterfaceC24357yU3.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC24357yU3 interfaceC24357yU3, BZ6 bz6) {
            int length = interfaceC24357yU3.length();
            interfaceC24357yU3.q(bz6);
            interfaceC24357yU3.p(bz6, length);
        }
    }

    /* renamed from: ir.nasim.Qn1$e */
    class e implements InterfaceC24357yU3.c {
        e() {
        }

        @Override // ir.nasim.InterfaceC24357yU3.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC24357yU3 interfaceC24357yU3, Z62 z62) {
            int length = interfaceC24357yU3.length();
            interfaceC24357yU3.q(z62);
            interfaceC24357yU3.p(z62, length);
        }
    }

    /* renamed from: ir.nasim.Qn1$f */
    class f implements InterfaceC24357yU3.c {
        f() {
        }

        @Override // ir.nasim.InterfaceC24357yU3.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC24357yU3 interfaceC24357yU3, NB3 nb3) {
            int length = interfaceC24357yU3.length();
            interfaceC24357yU3.q(nb3);
            AbstractC10483bh0 abstractC10483bh0F = nb3.f();
            if (abstractC10483bh0F instanceof PL4) {
                PL4 pl4 = (PL4) abstractC10483bh0F;
                int iQ = pl4.q();
                AbstractC7392Rn1.a.d(interfaceC24357yU3.o(), AbstractC7392Rn1.a.ORDERED);
                AbstractC7392Rn1.c.d(interfaceC24357yU3.o(), Integer.valueOf(iQ));
                pl4.s(pl4.q() + 1);
            } else {
                AbstractC7392Rn1.a.d(interfaceC24357yU3.o(), AbstractC7392Rn1.a.BULLET);
                AbstractC7392Rn1.b.d(interfaceC24357yU3.o(), Integer.valueOf(C7158Qn1.s(nb3)));
            }
            interfaceC24357yU3.p(nb3, length);
            if (interfaceC24357yU3.t(nb3)) {
                interfaceC24357yU3.u();
            }
        }
    }

    /* renamed from: ir.nasim.Qn1$g */
    public interface g {
        void a(InterfaceC24357yU3 interfaceC24357yU3, String str, int i);
    }

    protected C7158Qn1() {
    }

    public static C7158Qn1 n() {
        return new C7158Qn1();
    }

    private static void o(InterfaceC24357yU3.b bVar) {
        bVar.a(Z62.class, new e());
    }

    private static void p(InterfaceC24357yU3.b bVar) {
        bVar.a(C17149mU2.class, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(C9761aW4 c9761aW4) {
        AbstractC10483bh0 abstractC10483bh0F = c9761aW4.f();
        if (abstractC10483bh0F == null) {
            return false;
        }
        TA4 ta4F = abstractC10483bh0F.f();
        if (ta4F instanceof AbstractC24186yB3) {
            return ((AbstractC24186yB3) ta4F).n();
        }
        return false;
    }

    private static void r(InterfaceC24357yU3.b bVar) {
        bVar.a(NB3.class, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int s(TA4 ta4) {
        int i = 0;
        for (TA4 ta4F = ta4.f(); ta4F != null; ta4F = ta4F.f()) {
            if (ta4F instanceof NB3) {
                i++;
            }
        }
        return i;
    }

    private static void t(InterfaceC24357yU3.b bVar) {
        bVar.a(C9761aW4.class, new b());
    }

    private static void u(InterfaceC24357yU3.b bVar) {
        bVar.a(BZ6.class, new d());
    }

    private void v(InterfaceC24357yU3.b bVar) {
        bVar.a(C5693Kk7.class, new c());
    }

    @Override // ir.nasim.AbstractC16876m1, ir.nasim.InterfaceC21991uU3
    public void f(InterfaceC22581vU3.a aVar) {
        aVar.b(BZ6.class, new EZ6()).b(Z62.class, new C11505d72()).b(NB3.class, new PB3()).b(UU2.class, new XU2());
    }

    @Override // ir.nasim.AbstractC16876m1, ir.nasim.InterfaceC21991uU3
    public void i(InterfaceC24357yU3.b bVar) {
        v(bVar);
        u(bVar);
        o(bVar);
        r(bVar);
        p(bVar);
        t(bVar);
    }

    public C7158Qn1 m(g gVar) {
        this.a.add(gVar);
        return this;
    }
}
