package ir.nasim;

import ir.nasim.AbstractC21430te5;

/* renamed from: ir.nasim.a3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9488a3 {
    private static final float a;
    private static final androidx.compose.ui.e b;

    /* renamed from: ir.nasim.a3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final a e = new a();

        /* renamed from: ir.nasim.a3$a$a, reason: collision with other inner class name */
        static final class C0846a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AbstractC21430te5 e;
            final /* synthetic */ int f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0846a(AbstractC21430te5 abstractC21430te5, int i) {
                super(1);
                this.e = abstractC21430te5;
                this.f = i;
            }

            public final void a(AbstractC21430te5.a aVar) {
                AbstractC21430te5.a.h(aVar, this.e, -this.f, 0, 0.0f, 4, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        a() {
            super(3);
        }

        public final InterfaceC11734dW3 a(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
            int iB0 = interfaceC12377eW3.B0(AbstractC9488a3.a());
            int i = iB0 * 2;
            AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.i(j, i, 0));
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0() - i, abstractC21430te5L0.A0(), null, new C0846a(abstractC21430te5L0, iB0), 4, null);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((InterfaceC12377eW3) obj, (ZV3) obj2, ((C17833ne1) obj3).r());
        }
    }

    static {
        float fQ = C17784nZ1.q(10);
        a = fQ;
        b = androidx.compose.foundation.layout.q.k(AbstractC6919Pn6.c(androidx.compose.ui.layout.b.a(androidx.compose.ui.e.a, a.e), true, b.e), fQ, 0.0f, 2, null);
    }

    public static final float a() {
        return a;
    }

    public static final androidx.compose.ui.e b() {
        return b;
    }

    /* renamed from: ir.nasim.a3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
        }
    }
}
