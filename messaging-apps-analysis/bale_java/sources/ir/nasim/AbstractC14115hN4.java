package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.hN4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14115hN4 {
    private static final float a = C17784nZ1.q(4);
    private static final long b = AbstractC13784go7.g(8);

    /* renamed from: ir.nasim.hN4$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ C23945xm7 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ QY7 h;
        final /* synthetic */ InterfaceC18507om4 i;
        final /* synthetic */ boolean j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ InterfaceC10031ax6 o;
        final /* synthetic */ InterfaceC7614Sl7 p;

        /* renamed from: ir.nasim.hN4$b$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ boolean e;
            final /* synthetic */ boolean f;
            final /* synthetic */ InterfaceC18507om4 g;
            final /* synthetic */ InterfaceC7614Sl7 h;
            final /* synthetic */ InterfaceC10031ax6 i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(boolean z, boolean z2, InterfaceC18507om4 interfaceC18507om4, InterfaceC7614Sl7 interfaceC7614Sl7, InterfaceC10031ax6 interfaceC10031ax6) {
                super(2);
                this.e = z;
                this.f = z2;
                this.g = interfaceC18507om4;
                this.h = interfaceC7614Sl7;
                this.i = interfaceC10031ax6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-794566495, i, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:606)");
                }
                C8555Wl7.a.a(this.e, this.f, this.g, this.h, this.i, 0.0f, 0.0f, interfaceC22053ub1, 12582912, 96);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C23945xm7 c23945xm7, boolean z, boolean z2, QY7 qy7, InterfaceC18507om4 interfaceC18507om4, boolean z3, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC10031ax6 interfaceC10031ax6, InterfaceC7614Sl7 interfaceC7614Sl7) {
            super(3);
            this.e = c23945xm7;
            this.f = z;
            this.g = z2;
            this.h = qy7;
            this.i = interfaceC18507om4;
            this.j = z3;
            this.k = interfaceC14603iB2;
            this.l = interfaceC14603iB22;
            this.m = interfaceC14603iB23;
            this.n = interfaceC14603iB24;
            this.o = interfaceC10031ax6;
            this.p = interfaceC7614Sl7;
        }

        public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2);
            } else {
                i2 = i;
            }
            if (!interfaceC22053ub1.o((i2 & 19) != 18, i2 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1001528775, i2, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:591)");
            }
            C8555Wl7 c8555Wl7 = C8555Wl7.a;
            String strH = this.e.h();
            boolean z = this.f;
            boolean z2 = this.g;
            QY7 qy7 = this.h;
            InterfaceC18507om4 interfaceC18507om4 = this.i;
            boolean z3 = this.j;
            InterfaceC14603iB2 interfaceC14603iB22 = this.k;
            InterfaceC14603iB2 interfaceC14603iB23 = this.l;
            InterfaceC14603iB2 interfaceC14603iB24 = this.m;
            InterfaceC14603iB2 interfaceC14603iB25 = this.n;
            InterfaceC10031ax6 interfaceC10031ax6 = this.o;
            InterfaceC7614Sl7 interfaceC7614Sl7 = this.p;
            c8555Wl7.b(strH, interfaceC14603iB2, z, z2, qy7, interfaceC18507om4, z3, interfaceC14603iB22, interfaceC14603iB23, interfaceC14603iB24, interfaceC14603iB25, interfaceC10031ax6, interfaceC7614Sl7, null, AbstractC19242q11.e(-794566495, true, new a(z, z3, interfaceC18507om4, interfaceC7614Sl7, interfaceC10031ax6), interfaceC22053ub1, 54), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 221184, 8192);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hN4$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int A;
        final /* synthetic */ C23945xm7 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ C9348Zn7 j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ boolean o;
        final /* synthetic */ QY7 p;
        final /* synthetic */ C21605tp3 q;
        final /* synthetic */ C11329cp3 r;
        final /* synthetic */ boolean s;
        final /* synthetic */ int t;
        final /* synthetic */ int u;
        final /* synthetic */ InterfaceC18507om4 v;
        final /* synthetic */ InterfaceC10031ax6 w;
        final /* synthetic */ InterfaceC7614Sl7 x;
        final /* synthetic */ int y;
        final /* synthetic */ int z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C23945xm7 c23945xm7, UA2 ua2, androidx.compose.ui.e eVar, boolean z, boolean z2, C9348Zn7 c9348Zn7, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, boolean z3, QY7 qy7, C21605tp3 c21605tp3, C11329cp3 c11329cp3, boolean z4, int i, int i2, InterfaceC18507om4 interfaceC18507om4, InterfaceC10031ax6 interfaceC10031ax6, InterfaceC7614Sl7 interfaceC7614Sl7, int i3, int i4, int i5) {
            super(2);
            this.e = c23945xm7;
            this.f = ua2;
            this.g = eVar;
            this.h = z;
            this.i = z2;
            this.j = c9348Zn7;
            this.k = interfaceC14603iB2;
            this.l = interfaceC14603iB22;
            this.m = interfaceC14603iB23;
            this.n = interfaceC14603iB24;
            this.o = z3;
            this.p = qy7;
            this.q = c21605tp3;
            this.r = c11329cp3;
            this.s = z4;
            this.t = i;
            this.u = i2;
            this.v = interfaceC18507om4;
            this.w = interfaceC10031ax6;
            this.x = interfaceC7614Sl7;
            this.y = i3;
            this.z = i4;
            this.A = i5;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC14115hN4.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, interfaceC22053ub1, QJ5.a(this.y | 1), QJ5.a(this.z), this.A);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hN4$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ String e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ QY7 h;
        final /* synthetic */ InterfaceC18507om4 i;
        final /* synthetic */ boolean j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ InterfaceC10031ax6 o;
        final /* synthetic */ InterfaceC7614Sl7 p;

        /* renamed from: ir.nasim.hN4$e$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ boolean e;
            final /* synthetic */ boolean f;
            final /* synthetic */ InterfaceC18507om4 g;
            final /* synthetic */ InterfaceC7614Sl7 h;
            final /* synthetic */ InterfaceC10031ax6 i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(boolean z, boolean z2, InterfaceC18507om4 interfaceC18507om4, InterfaceC7614Sl7 interfaceC7614Sl7, InterfaceC10031ax6 interfaceC10031ax6) {
                super(2);
                this.e = z;
                this.f = z2;
                this.g = interfaceC18507om4;
                this.h = interfaceC7614Sl7;
                this.i = interfaceC10031ax6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(1757478222, i, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:398)");
                }
                C8555Wl7.a.a(this.e, this.f, this.g, this.h, this.i, 0.0f, 0.0f, interfaceC22053ub1, 12582912, 96);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, boolean z, boolean z2, QY7 qy7, InterfaceC18507om4 interfaceC18507om4, boolean z3, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC10031ax6 interfaceC10031ax6, InterfaceC7614Sl7 interfaceC7614Sl7) {
            super(3);
            this.e = str;
            this.f = z;
            this.g = z2;
            this.h = qy7;
            this.i = interfaceC18507om4;
            this.j = z3;
            this.k = interfaceC14603iB2;
            this.l = interfaceC14603iB22;
            this.m = interfaceC14603iB23;
            this.n = interfaceC14603iB24;
            this.o = interfaceC10031ax6;
            this.p = interfaceC7614Sl7;
        }

        public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2);
            } else {
                i2 = i;
            }
            if (!interfaceC22053ub1.o((i2 & 19) != 18, i2 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1710364390, i2, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:383)");
            }
            C8555Wl7 c8555Wl7 = C8555Wl7.a;
            String str = this.e;
            boolean z = this.f;
            boolean z2 = this.g;
            QY7 qy7 = this.h;
            InterfaceC18507om4 interfaceC18507om4 = this.i;
            boolean z3 = this.j;
            InterfaceC14603iB2 interfaceC14603iB22 = this.k;
            InterfaceC14603iB2 interfaceC14603iB23 = this.l;
            InterfaceC14603iB2 interfaceC14603iB24 = this.m;
            InterfaceC14603iB2 interfaceC14603iB25 = this.n;
            InterfaceC10031ax6 interfaceC10031ax6 = this.o;
            InterfaceC7614Sl7 interfaceC7614Sl7 = this.p;
            c8555Wl7.b(str, interfaceC14603iB2, z, z2, qy7, interfaceC18507om4, z3, interfaceC14603iB22, interfaceC14603iB23, interfaceC14603iB24, interfaceC14603iB25, interfaceC10031ax6, interfaceC7614Sl7, null, AbstractC19242q11.e(1757478222, true, new a(z, z3, interfaceC18507om4, interfaceC7614Sl7, interfaceC10031ax6), interfaceC22053ub1, 54), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 221184, 8192);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hN4$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int A;
        final /* synthetic */ String e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ C9348Zn7 j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ boolean o;
        final /* synthetic */ QY7 p;
        final /* synthetic */ C21605tp3 q;
        final /* synthetic */ C11329cp3 r;
        final /* synthetic */ boolean s;
        final /* synthetic */ int t;
        final /* synthetic */ int u;
        final /* synthetic */ InterfaceC18507om4 v;
        final /* synthetic */ InterfaceC10031ax6 w;
        final /* synthetic */ InterfaceC7614Sl7 x;
        final /* synthetic */ int y;
        final /* synthetic */ int z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, UA2 ua2, androidx.compose.ui.e eVar, boolean z, boolean z2, C9348Zn7 c9348Zn7, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, boolean z3, QY7 qy7, C21605tp3 c21605tp3, C11329cp3 c11329cp3, boolean z4, int i, int i2, InterfaceC18507om4 interfaceC18507om4, InterfaceC10031ax6 interfaceC10031ax6, InterfaceC7614Sl7 interfaceC7614Sl7, int i3, int i4, int i5) {
            super(2);
            this.e = str;
            this.f = ua2;
            this.g = eVar;
            this.h = z;
            this.i = z2;
            this.j = c9348Zn7;
            this.k = interfaceC14603iB2;
            this.l = interfaceC14603iB22;
            this.m = interfaceC14603iB23;
            this.n = interfaceC14603iB24;
            this.o = z3;
            this.p = qy7;
            this.q = c21605tp3;
            this.r = c11329cp3;
            this.s = z4;
            this.t = i;
            this.u = i2;
            this.v = interfaceC18507om4;
            this.w = interfaceC10031ax6;
            this.x = interfaceC7614Sl7;
            this.y = i3;
            this.z = i4;
            this.A = i5;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC14115hN4.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, interfaceC22053ub1, QJ5.a(this.y | 1), QJ5.a(this.z), this.A);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hN4$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ InterfaceC15796kB2 g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ InterfaceC14603iB2 i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ boolean k;
        final /* synthetic */ float l;
        final /* synthetic */ UA2 m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ TS4 o;
        final /* synthetic */ int p;
        final /* synthetic */ int q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, boolean z, float f, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB25, TS4 ts4, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC14603iB2;
            this.g = interfaceC15796kB2;
            this.h = interfaceC14603iB22;
            this.i = interfaceC14603iB23;
            this.j = interfaceC14603iB24;
            this.k = z;
            this.l = f;
            this.m = ua2;
            this.n = interfaceC14603iB25;
            this.o = ts4;
            this.p = i;
            this.q = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC14115hN4.c(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, interfaceC22053ub1, QJ5.a(this.p | 1), QJ5.a(this.q));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hN4$h */
    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;
        final /* synthetic */ TS4 f;

        /* renamed from: ir.nasim.hN4$h$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC12613eu3.values().length];
                try {
                    iArr[EnumC12613eu3.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j, TS4 ts4) {
            super(1);
            this.e = j;
            this.f = ts4;
        }

        public final void a(InterfaceC23919xk1 interfaceC23919xk1) {
            float fI = OD6.i(this.e);
            if (fI <= 0.0f) {
                interfaceC23919xk1.N1();
                return;
            }
            float fW1 = interfaceC23919xk1.w1(AbstractC14115hN4.a);
            float fW12 = interfaceC23919xk1.w1(this.f.d(interfaceC23919xk1.getLayoutDirection())) - fW1;
            float f = 2;
            float fI2 = fI + fW12 + (fW1 * f);
            EnumC12613eu3 layoutDirection = interfaceC23919xk1.getLayoutDirection();
            int[] iArr = a.a;
            float fI3 = iArr[layoutDirection.ordinal()] == 1 ? OD6.i(interfaceC23919xk1.d()) - fI2 : AbstractC23053wG5.d(fW12, 0.0f);
            if (iArr[interfaceC23919xk1.getLayoutDirection().ordinal()] == 1) {
                fI2 = OD6.i(interfaceC23919xk1.d()) - AbstractC23053wG5.d(fW12, 0.0f);
            }
            float f2 = fI2;
            float fG = OD6.g(this.e);
            float f3 = (-fG) / f;
            float f4 = fG / f;
            int iA = GV0.a.a();
            YZ1 yz1Z1 = interfaceC23919xk1.z1();
            long jD = yz1Z1.d();
            yz1Z1.e().n();
            try {
                yz1Z1.b().b(fI3, f3, f2, f4, iA);
                interfaceC23919xk1.N1();
            } finally {
                yz1Z1.e().i();
                yz1Z1.g(jD);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23919xk1) obj);
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:331:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.C23945xm7 r70, ir.nasim.UA2 r71, androidx.compose.ui.e r72, boolean r73, boolean r74, ir.nasim.C9348Zn7 r75, ir.nasim.InterfaceC14603iB2 r76, ir.nasim.InterfaceC14603iB2 r77, ir.nasim.InterfaceC14603iB2 r78, ir.nasim.InterfaceC14603iB2 r79, boolean r80, ir.nasim.QY7 r81, ir.nasim.C21605tp3 r82, ir.nasim.C11329cp3 r83, boolean r84, int r85, int r86, ir.nasim.InterfaceC18507om4 r87, ir.nasim.InterfaceC10031ax6 r88, ir.nasim.InterfaceC7614Sl7 r89, ir.nasim.InterfaceC22053ub1 r90, int r91, int r92, int r93) {
        /*
            Method dump skipped, instructions count: 1568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14115hN4.a(ir.nasim.xm7, ir.nasim.UA2, androidx.compose.ui.e, boolean, boolean, ir.nasim.Zn7, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.iB2, boolean, ir.nasim.QY7, ir.nasim.tp3, ir.nasim.cp3, boolean, int, int, ir.nasim.om4, ir.nasim.ax6, ir.nasim.Sl7, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:326:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(java.lang.String r71, ir.nasim.UA2 r72, androidx.compose.ui.e r73, boolean r74, boolean r75, ir.nasim.C9348Zn7 r76, ir.nasim.InterfaceC14603iB2 r77, ir.nasim.InterfaceC14603iB2 r78, ir.nasim.InterfaceC14603iB2 r79, ir.nasim.InterfaceC14603iB2 r80, boolean r81, ir.nasim.QY7 r82, ir.nasim.C21605tp3 r83, ir.nasim.C11329cp3 r84, boolean r85, int r86, int r87, ir.nasim.InterfaceC18507om4 r88, ir.nasim.InterfaceC10031ax6 r89, ir.nasim.InterfaceC7614Sl7 r90, ir.nasim.InterfaceC22053ub1 r91, int r92, int r93, int r94) {
        /*
            Method dump skipped, instructions count: 1523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14115hN4.b(java.lang.String, ir.nasim.UA2, androidx.compose.ui.e, boolean, boolean, ir.nasim.Zn7, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.iB2, boolean, ir.nasim.QY7, ir.nasim.tp3, ir.nasim.cp3, boolean, int, int, ir.nasim.om4, ir.nasim.ax6, ir.nasim.Sl7, ir.nasim.ub1, int, int, int):void");
    }

    public static final void c(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, boolean z, float f2, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB25, TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        int i4;
        int i5;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2049536174);
        if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC15796kB2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB24) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= interfaceC22053ub1J.a(z) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= interfaceC22053ub1J.c(f2) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB25) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (interfaceC22053ub1J.V(ts4) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (interfaceC22053ub1J.o(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-2049536174, i3, i4, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:687)");
            }
            boolean z2 = ((3670016 & i3) == 1048576) | ((234881024 & i3) == 67108864) | ((29360128 & i3) == 8388608) | ((i4 & 14) == 4);
            Object objB = interfaceC22053ub1J.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new C14726iN4(ua2, z, f2, ts4);
                interfaceC22053ub1J.s(objB);
            }
            C14726iN4 c14726iN4 = (C14726iN4) objB;
            EnumC12613eu3 enumC12613eu3 = (EnumC12613eu3) interfaceC22053ub1J.H(AbstractC13040fc1.n());
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, c14726iN4, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            interfaceC14603iB25.invoke(interfaceC22053ub1J, Integer.valueOf((i3 >> 27) & 14));
            if (interfaceC14603iB23 != null) {
                interfaceC22053ub1J.W(-978132235);
                androidx.compose.ui.e eVarC = AbstractC25015zb3.c(androidx.compose.ui.layout.a.b(androidx.compose.ui.e.a, "Leading"));
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
                SA2 sa2A2 = aVar.a();
                if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1J.G();
                if (interfaceC22053ub1J.h()) {
                    interfaceC22053ub1J.g(sa2A2);
                } else {
                    interfaceC22053ub1J.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                interfaceC14603iB23.invoke(interfaceC22053ub1J, Integer.valueOf((i3 >> 12) & 14));
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-977887180);
                interfaceC22053ub1J.Q();
            }
            if (interfaceC14603iB24 != null) {
                interfaceC22053ub1J.W(-977844493);
                androidx.compose.ui.e eVarC2 = AbstractC25015zb3.c(androidx.compose.ui.layout.a.b(androidx.compose.ui.e.a, "Trailing"));
                InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC2);
                SA2 sa2A3 = aVar.a();
                if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1J.G();
                if (interfaceC22053ub1J.h()) {
                    interfaceC22053ub1J.g(sa2A3);
                } else {
                    interfaceC22053ub1J.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1J);
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G2, aVar.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar.f());
                androidx.compose.foundation.layout.h hVar2 = androidx.compose.foundation.layout.h.a;
                interfaceC14603iB24.invoke(interfaceC22053ub1J, Integer.valueOf((i3 >> 15) & 14));
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-977597516);
                interfaceC22053ub1J.Q();
            }
            float fG = androidx.compose.foundation.layout.q.g(ts4, enumC12613eu3);
            float f3 = androidx.compose.foundation.layout.q.f(ts4, enumC12613eu3);
            e.a aVar2 = androidx.compose.ui.e.a;
            if (interfaceC14603iB23 != null) {
                i5 = 0;
                fG = C17784nZ1.q(AbstractC23053wG5.d(C17784nZ1.q(fG - AbstractC11925dm7.d()), C17784nZ1.q(0)));
            } else {
                i5 = 0;
            }
            float f4 = fG;
            if (interfaceC14603iB24 != null) {
                f3 = C17784nZ1.q(AbstractC23053wG5.d(C17784nZ1.q(f3 - AbstractC11925dm7.d()), C17784nZ1.q(i5)));
            }
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar2, f4, 0.0f, f3, 0.0f, 10, null);
            if (interfaceC15796kB2 != null) {
                interfaceC22053ub1J.W(-976746535);
                interfaceC15796kB2.q(androidx.compose.ui.layout.a.b(aVar2, "Hint").i(eVarM), interfaceC22053ub1J, Integer.valueOf((i3 >> 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-976659084);
                interfaceC22053ub1J.Q();
            }
            androidx.compose.ui.e eVarI = androidx.compose.ui.layout.a.b(aVar2, "TextField").i(eVarM);
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G3 = androidx.compose.foundation.layout.f.g(aVar3.o(), true);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            SA2 sa2A4 = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A4);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3G3, aVar.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar.f());
            androidx.compose.foundation.layout.h hVar3 = androidx.compose.foundation.layout.h.a;
            interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf((i3 >> 3) & 14));
            interfaceC22053ub1J.u();
            if (interfaceC14603iB22 != null) {
                interfaceC22053ub1J.W(-976429250);
                androidx.compose.ui.e eVarB = androidx.compose.ui.layout.a.b(aVar2, "Label");
                InterfaceC10970cW3 interfaceC10970cW3G4 = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
                int iA5 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q5 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE5 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
                SA2 sa2A5 = aVar.a();
                if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1J.G();
                if (interfaceC22053ub1J.h()) {
                    interfaceC22053ub1J.g(sa2A5);
                } else {
                    interfaceC22053ub1J.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A5 = DG7.a(interfaceC22053ub1J);
                DG7.c(interfaceC22053ub1A5, interfaceC10970cW3G4, aVar.e());
                DG7.c(interfaceC22053ub1A5, interfaceC11819dc1Q5, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B5 = aVar.b();
                if (interfaceC22053ub1A5.h() || !AbstractC13042fc3.d(interfaceC22053ub1A5.B(), Integer.valueOf(iA5))) {
                    interfaceC22053ub1A5.s(Integer.valueOf(iA5));
                    interfaceC22053ub1A5.v(Integer.valueOf(iA5), interfaceC14603iB2B5);
                }
                DG7.c(interfaceC22053ub1A5, eVarE5, aVar.f());
                interfaceC14603iB22.invoke(interfaceC22053ub1J, Integer.valueOf((i3 >> 9) & 14));
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-976346604);
                interfaceC22053ub1J.Q();
            }
            interfaceC22053ub1J.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new g(eVar, interfaceC14603iB2, interfaceC15796kB2, interfaceC14603iB22, interfaceC14603iB23, interfaceC14603iB24, z, f2, ua2, interfaceC14603iB25, ts4, i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(int i, int i2, int i3, int i4, int i5, float f2, long j, float f3, TS4 ts4) {
        int iMax = Math.max(i3, Math.max(i5, AbstractC18932pV3.c(i4, 0, f2)));
        float fC = ts4.c() * f3;
        return AbstractC19606qe1.f(j, Math.max(i, Math.max(i2, AbstractC20723sV3.d(AbstractC18932pV3.b(fC, Math.max(fC, i4 / 2.0f), f2) + iMax + (ts4.a() * f3)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(int i, int i2, int i3, int i4, int i5, float f2, long j, float f3, TS4 ts4) {
        int iMax = i + Math.max(i3, Math.max(AbstractC18932pV3.c(i4, 0, f2), i5)) + i2;
        EnumC12613eu3 enumC12613eu3 = EnumC12613eu3.a;
        return AbstractC19606qe1.g(j, Math.max(iMax, AbstractC20723sV3.d((i4 + (C17784nZ1.q(ts4.d(enumC12613eu3) + ts4.b(enumC12613eu3)) * f3)) * f2)));
    }

    public static final androidx.compose.ui.e k(androidx.compose.ui.e eVar, long j, TS4 ts4) {
        return androidx.compose.ui.draw.b.d(eVar, new h(j, ts4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AbstractC21430te5.a aVar, int i, int i2, AbstractC21430te5 abstractC21430te5, AbstractC21430te5 abstractC21430te52, AbstractC21430te5 abstractC21430te53, AbstractC21430te5 abstractC21430te54, AbstractC21430te5 abstractC21430te55, AbstractC21430te5 abstractC21430te56, float f2, boolean z, float f3, EnumC12613eu3 enumC12613eu3, TS4 ts4) {
        int iD = AbstractC20723sV3.d(ts4.c() * f3);
        int iD2 = AbstractC20723sV3.d(androidx.compose.foundation.layout.q.g(ts4, enumC12613eu3) * f3);
        float fD = AbstractC11925dm7.d() * f3;
        if (abstractC21430te5 != null) {
            AbstractC21430te5.a.l(aVar, abstractC21430te5, 0, InterfaceC12529em.a.i().a(abstractC21430te5.A0(), i), 0.0f, 4, null);
        }
        if (abstractC21430te52 != null) {
            AbstractC21430te5.a.l(aVar, abstractC21430te52, i2 - abstractC21430te52.P0(), InterfaceC12529em.a.i().a(abstractC21430te52.A0(), i), 0.0f, 4, null);
        }
        if (abstractC21430te54 != null) {
            AbstractC21430te5.a.l(aVar, abstractC21430te54, AbstractC20723sV3.d(abstractC21430te5 == null ? 0.0f : (AbstractC11925dm7.h(abstractC21430te5) - fD) * (1 - f2)) + iD2, AbstractC18932pV3.c(z ? InterfaceC12529em.a.i().a(abstractC21430te54.A0(), i) : iD, -(abstractC21430te54.A0() / 2), f2), 0.0f, 4, null);
        }
        AbstractC21430te5.a.l(aVar, abstractC21430te53, AbstractC11925dm7.h(abstractC21430te5), Math.max(z ? InterfaceC12529em.a.i().a(abstractC21430te53.A0(), i) : iD, AbstractC11925dm7.g(abstractC21430te54) / 2), 0.0f, 4, null);
        if (abstractC21430te55 != null) {
            if (z) {
                iD = InterfaceC12529em.a.i().a(abstractC21430te55.A0(), i);
            }
            AbstractC21430te5.a.l(aVar, abstractC21430te55, AbstractC11925dm7.h(abstractC21430te5), Math.max(iD, AbstractC11925dm7.g(abstractC21430te54) / 2), 0.0f, 4, null);
        }
        AbstractC21430te5.a.j(aVar, abstractC21430te56, C22045ua3.b.b(), 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : i - i2;
    }

    /* renamed from: ir.nasim.hN4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
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

    /* renamed from: ir.nasim.hN4$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
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
