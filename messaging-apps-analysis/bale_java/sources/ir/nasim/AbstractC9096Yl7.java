package ir.nasim;

import ir.nasim.C13245fu;
import java.util.List;

/* renamed from: ir.nasim.Yl7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC9096Yl7 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.Yl7$a */
    public static final class a {

        /* renamed from: ir.nasim.Yl7$a$a, reason: collision with other inner class name */
        static final class C0799a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C11475d42 e;
            final /* synthetic */ UA2 f;
            final /* synthetic */ C12889fL5 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0799a(C11475d42 c11475d42, UA2 ua2, C12889fL5 c12889fL5) {
                super(1);
                this.e = c11475d42;
                this.f = ua2;
                this.g = c12889fL5;
            }

            public final void a(List list) {
                AbstractC9096Yl7.a.g(list, this.e, this.f, (C8564Wm7) this.g.a);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((List) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Yl7$a$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC11379cu3 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC11379cu3 interfaceC11379cu3) {
                super(1);
                this.e = interfaceC11379cu3;
            }

            public final void a(float[] fArr) {
                if (this.e.b()) {
                    AbstractC12000du3.d(this.e).g0(this.e, fArr);
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((AV3) obj).p());
                return C19938rB7.a;
            }
        }

        private a() {
        }

        private final void c(UE0 ue0, long j, InterfaceC11600dH4 interfaceC11600dH4, C13774gn7 c13774gn7, InterfaceC12969fU4 interfaceC12969fU4) {
            int iB = interfaceC11600dH4.b(C4301En7.l(j));
            int iB2 = interfaceC11600dH4.b(C4301En7.k(j));
            if (iB != iB2) {
                ue0.f(c13774gn7.z(iB, iB2), interfaceC12969fU4);
            }
        }

        public final C18600ov7 a(long j, C18600ov7 c18600ov7) {
            int iB = c18600ov7.a().b(C4301En7.n(j));
            int iB2 = c18600ov7.a().b(C4301En7.i(j));
            int iMin = Math.min(iB, iB2);
            int iMax = Math.max(iB, iB2);
            C13245fu.b bVar = new C13245fu.b(c18600ov7.b());
            bVar.b(new C12863fI6(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, C24525yl7.b.d(), (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 61439, (ED1) null), iMin, iMax);
            return new C18600ov7(bVar.o(), c18600ov7.a());
        }

        public final void b(UE0 ue0, C23945xm7 c23945xm7, long j, long j2, InterfaceC11600dH4 interfaceC11600dH4, C13774gn7 c13774gn7, InterfaceC12969fU4 interfaceC12969fU4, long j3) {
            if (!C4301En7.h(j)) {
                interfaceC12969fU4.k(j3);
                c(ue0, j, interfaceC11600dH4, c13774gn7, interfaceC12969fU4);
            } else if (!C4301En7.h(j2)) {
                C24381yX0 c24381yX0K = C24381yX0.k(c13774gn7.l().i().h());
                if (c24381yX0K.y() == 16) {
                    c24381yX0K = null;
                }
                long jY = c24381yX0K != null ? c24381yX0K.y() : C24381yX0.b.a();
                interfaceC12969fU4.k(C24381yX0.o(jY, C24381yX0.r(jY) * 0.2f, 0.0f, 0.0f, 0.0f, 14, null));
                c(ue0, j2, interfaceC11600dH4, c13774gn7, interfaceC12969fU4);
            } else if (!C4301En7.h(c23945xm7.g())) {
                interfaceC12969fU4.k(j3);
                c(ue0, c23945xm7.g(), interfaceC11600dH4, c13774gn7, interfaceC12969fU4);
            }
            C25139zn7.a.a(ue0, c13774gn7);
        }

        public final C17428mw7 d(C3342Al7 c3342Al7, long j, EnumC12613eu3 enumC12613eu3, C13774gn7 c13774gn7) {
            C13774gn7 c13774gn7L = c3342Al7.l(j, enumC12613eu3, c13774gn7);
            return new C17428mw7(Integer.valueOf((int) (c13774gn7L.B() >> 32)), Integer.valueOf((int) (c13774gn7L.B() & 4294967295L)), c13774gn7L);
        }

        public final void e(C23945xm7 c23945xm7, C3342Al7 c3342Al7, C13774gn7 c13774gn7, InterfaceC11379cu3 interfaceC11379cu3, C8564Wm7 c8564Wm7, boolean z, InterfaceC11600dH4 interfaceC11600dH4) {
            if (z) {
                int iB = interfaceC11600dH4.b(C4301En7.k(c23945xm7.g()));
                CK5 ck5D = iB < c13774gn7.l().j().length() ? c13774gn7.d(iB) : iB != 0 ? c13774gn7.d(iB - 1) : new CK5(0.0f, 0.0f, 1.0f, (int) (AbstractC9330Zl7.b(c3342Al7.j(), c3342Al7.a(), c3342Al7.b(), null, 0, 24, null) & 4294967295L));
                long jP0 = interfaceC11379cu3.p0(ZG4.e((Float.floatToRawIntBits(ck5D.l()) & 4294967295L) | (Float.floatToRawIntBits(ck5D.i()) << 32)));
                c8564Wm7.c(FK5.b(ZG4.e((Float.floatToRawIntBits(Float.intBitsToFloat((int) (jP0 & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (jP0 >> 32))) << 32)), OD6.d((4294967295L & Float.floatToRawIntBits(ck5D.e() - ck5D.l())) | (Float.floatToRawIntBits(ck5D.j() - ck5D.i()) << 32))));
            }
        }

        public final void f(C8564Wm7 c8564Wm7, C11475d42 c11475d42, UA2 ua2) {
            ua2.invoke(C23945xm7.c(c11475d42.f(), null, 0L, null, 3, null));
            c8564Wm7.a();
        }

        public final void g(List list, C11475d42 c11475d42, UA2 ua2, C8564Wm7 c8564Wm7) {
            C23945xm7 c23945xm7B = c11475d42.b(list);
            if (c8564Wm7 != null) {
                c8564Wm7.d(null, c23945xm7B);
            }
            ua2.invoke(c23945xm7B);
        }

        public final C8564Wm7 h(C7155Qm7 c7155Qm7, C23945xm7 c23945xm7, C11475d42 c11475d42, T33 t33, UA2 ua2, UA2 ua22) {
            return i(c7155Qm7, c23945xm7, c11475d42, t33, ua2, ua22);
        }

        public final C8564Wm7 i(C7155Qm7 c7155Qm7, C23945xm7 c23945xm7, C11475d42 c11475d42, T33 t33, UA2 ua2, UA2 ua22) {
            C12889fL5 c12889fL5 = new C12889fL5();
            C8564Wm7 c8564Wm7D = c7155Qm7.d(c23945xm7, t33, new C0799a(c11475d42, ua2, c12889fL5), ua22);
            c12889fL5.a = c8564Wm7D;
            return c8564Wm7D;
        }

        public final void j(long j, C14367hn7 c14367hn7, C11475d42 c11475d42, InterfaceC11600dH4 interfaceC11600dH4, UA2 ua2) {
            ua2.invoke(C23945xm7.c(c11475d42.f(), null, AbstractC4535Fn7.a(interfaceC11600dH4.a(C14367hn7.e(c14367hn7, j, false, 2, null))), null, 5, null));
        }

        public final void k(C8564Wm7 c8564Wm7, C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, C14367hn7 c14367hn7) {
            InterfaceC11379cu3 interfaceC11379cu3B;
            InterfaceC11379cu3 interfaceC11379cu3C = c14367hn7.c();
            if (interfaceC11379cu3C == null || !interfaceC11379cu3C.b() || (interfaceC11379cu3B = c14367hn7.b()) == null) {
                return;
            }
            c8564Wm7.e(c23945xm7, interfaceC11600dH4, c14367hn7.f(), new b(interfaceC11379cu3C), AbstractC4783Gn6.b(interfaceC11379cu3C), interfaceC11379cu3C.N(interfaceC11379cu3B, false));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }
}
