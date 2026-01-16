package ir.nasim;

import ir.nasim.C24381yX0;

/* loaded from: classes.dex */
public abstract class RY0 {
    private static final UA2 a = a.e;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        /* renamed from: ir.nasim.RY0$a$a, reason: collision with other inner class name */
        static final class C0600a extends AbstractC8614Ws3 implements UA2 {
            public static final C0600a e = new C0600a();

            C0600a() {
                super(1);
            }

            public final C7917Tt a(long j) {
                long jM = C24381yX0.m(j, LY0.a.D());
                return new C7917Tt(C24381yX0.r(jM), C24381yX0.v(jM), C24381yX0.u(jM), C24381yX0.s(jM));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((C24381yX0) obj).y());
            }
        }

        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AbstractC9775aY0 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(AbstractC9775aY0 abstractC9775aY0) {
                super(1);
                this.e = abstractC9775aY0;
            }

            public final long a(C7917Tt c7917Tt) {
                float fG = c7917Tt.g();
                if (fG < 0.0f) {
                    fG = 0.0f;
                }
                if (fG > 1.0f) {
                    fG = 1.0f;
                }
                float fH = c7917Tt.h();
                if (fH < -0.5f) {
                    fH = -0.5f;
                }
                if (fH > 0.5f) {
                    fH = 0.5f;
                }
                float fI = c7917Tt.i();
                float f = fI >= -0.5f ? fI : -0.5f;
                float f2 = f <= 0.5f ? f : 0.5f;
                float f3 = c7917Tt.f();
                float f4 = f3 >= 0.0f ? f3 : 0.0f;
                return C24381yX0.m(DX0.a(fG, fH, f2, f4 <= 1.0f ? f4 : 1.0f, LY0.a.D()), this.e);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return C24381yX0.k(a((C7917Tt) obj));
            }
        }

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC5342Ix7 invoke(AbstractC9775aY0 abstractC9775aY0) {
            return PQ7.a(C0600a.e, new b(abstractC9775aY0));
        }
    }

    public static final UA2 a(C24381yX0.a aVar) {
        return a;
    }
}
