package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class AG6 {
    private static final float a = C17784nZ1.q(400);

    static final class a extends AbstractC22163um1 {
        float a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return AG6.f(null, 0.0f, null, null, null, this);
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ C10873cL5 f;
        final /* synthetic */ InterfaceC8748Xd6 g;
        final /* synthetic */ UA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(float f, C10873cL5 c10873cL5, InterfaceC8748Xd6 interfaceC8748Xd6, UA2 ua2) {
            super(1);
            this.e = f;
            this.f = c10873cL5;
            this.g = interfaceC8748Xd6;
            this.h = ua2;
        }

        public final void a(C5064Ht c5064Ht) {
            if (Math.abs(((Number) c5064Ht.e()).floatValue()) < Math.abs(this.e)) {
                AG6.g(c5064Ht, this.g, this.h, ((Number) c5064Ht.e()).floatValue() - this.f.a);
                this.f.a = ((Number) c5064Ht.e()).floatValue();
                return;
            }
            float fL = AG6.l(((Number) c5064Ht.e()).floatValue(), this.e);
            AG6.g(c5064Ht, this.g, this.h, fL - this.f.a);
            c5064Ht.a();
            this.f.a = fL;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC22163um1 {
        float a;
        float b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int f;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return AG6.h(null, 0.0f, 0.0f, null, null, null, this);
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ C10873cL5 f;
        final /* synthetic */ InterfaceC8748Xd6 g;
        final /* synthetic */ UA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(float f, C10873cL5 c10873cL5, InterfaceC8748Xd6 interfaceC8748Xd6, UA2 ua2) {
            super(1);
            this.e = f;
            this.f = c10873cL5;
            this.g = interfaceC8748Xd6;
            this.h = ua2;
        }

        public final void a(C5064Ht c5064Ht) {
            float fE;
            float fL = AG6.l(((Number) c5064Ht.e()).floatValue(), this.e);
            float f = fL - this.f.a;
            if (C9225Za1.b) {
                try {
                    fE = this.g.e(f);
                } catch (CancellationException unused) {
                    c5064Ht.a();
                    fE = 0.0f;
                }
            } else {
                fE = this.g.e(f);
            }
            this.h.invoke(Float.valueOf(fE));
            if (Math.abs(f - fE) > 0.5f || fL != ((Number) c5064Ht.e()).floatValue()) {
                c5064Ht.a();
            }
            this.f.a += fE;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(ir.nasim.InterfaceC8748Xd6 r5, float r6, ir.nasim.C6233Mt r7, ir.nasim.InterfaceC10163bB1 r8, ir.nasim.UA2 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            boolean r0 = r10 instanceof ir.nasim.AG6.a
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.AG6$a r0 = (ir.nasim.AG6.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.AG6$a r0 = new ir.nasim.AG6$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            float r6 = r0.a
            java.lang.Object r5 = r0.c
            ir.nasim.cL5 r5 = (ir.nasim.C10873cL5) r5
            java.lang.Object r7 = r0.b
            ir.nasim.Mt r7 = (ir.nasim.C6233Mt) r7
            ir.nasim.AbstractC10685c16.b(r10)
            goto L6b
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.cL5 r10 = new ir.nasim.cL5
            r10.<init>()
            java.lang.Object r2 = r7.z()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L54
            r2 = r3
            goto L55
        L54:
            r2 = 0
        L55:
            r2 = r2 ^ r3
            ir.nasim.AG6$b r4 = new ir.nasim.AG6$b
            r4.<init>(r6, r10, r5, r9)
            r0.b = r7
            r0.c = r10
            r0.a = r6
            r0.e = r3
            java.lang.Object r5 = ir.nasim.AbstractC18086o37.g(r7, r8, r2, r4, r0)
            if (r5 != r1) goto L6a
            return r1
        L6a:
            r5 = r10
        L6b:
            ir.nasim.Ft r8 = new ir.nasim.Ft
            float r5 = r5.a
            float r6 = r6 - r5
            java.lang.Float r5 = ir.nasim.AbstractC6392Nk0.c(r6)
            r8.<init>(r5, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AG6.f(ir.nasim.Xd6, float, ir.nasim.Mt, ir.nasim.bB1, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(C5064Ht c5064Ht, InterfaceC8748Xd6 interfaceC8748Xd6, UA2 ua2, float f) {
        float fE;
        if (C9225Za1.b) {
            try {
                fE = interfaceC8748Xd6.e(f);
            } catch (CancellationException unused) {
                c5064Ht.a();
                fE = 0.0f;
            }
        } else {
            fE = interfaceC8748Xd6.e(f);
        }
        ua2.invoke(Float.valueOf(fE));
        if (Math.abs(f - fE) > 0.5f) {
            c5064Ht.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(ir.nasim.InterfaceC8748Xd6 r12, float r13, float r14, ir.nasim.C6233Mt r15, ir.nasim.InterfaceC5766Kt r16, ir.nasim.UA2 r17, ir.nasim.InterfaceC20295rm1 r18) {
        /*
            r0 = r18
            boolean r1 = r0 instanceof ir.nasim.AG6.c
            if (r1 == 0) goto L16
            r1 = r0
            ir.nasim.AG6$c r1 = (ir.nasim.AG6.c) r1
            int r2 = r1.f
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.f = r2
        L14:
            r7 = r1
            goto L1c
        L16:
            ir.nasim.AG6$c r1 = new ir.nasim.AG6$c
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r7.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r7.f
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            float r1 = r7.b
            float r2 = r7.a
            java.lang.Object r3 = r7.d
            ir.nasim.cL5 r3 = (ir.nasim.C10873cL5) r3
            java.lang.Object r4 = r7.c
            ir.nasim.Mt r4 = (ir.nasim.C6233Mt) r4
            ir.nasim.AbstractC10685c16.b(r0)
            r10 = r2
            r0 = r4
            goto L90
        L3b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L43:
            ir.nasim.AbstractC10685c16.b(r0)
            ir.nasim.cL5 r0 = new ir.nasim.cL5
            r0.<init>()
            java.lang.Object r2 = r15.z()
            java.lang.Number r2 = (java.lang.Number) r2
            float r8 = r2.floatValue()
            java.lang.Float r4 = ir.nasim.AbstractC6392Nk0.c(r13)
            java.lang.Object r2 = r15.z()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L6a
            r2 = r3
            goto L6b
        L6a:
            r2 = 0
        L6b:
            r5 = r2 ^ 1
            ir.nasim.AG6$d r6 = new ir.nasim.AG6$d
            r2 = r12
            r9 = r14
            r10 = r17
            r6.<init>(r14, r0, r12, r10)
            r9 = r15
            r7.c = r9
            r7.d = r0
            r10 = r13
            r7.a = r10
            r7.b = r8
            r7.f = r3
            r2 = r15
            r3 = r4
            r4 = r16
            java.lang.Object r2 = ir.nasim.AbstractC18086o37.i(r2, r3, r4, r5, r6, r7)
            if (r2 != r1) goto L8d
            return r1
        L8d:
            r3 = r0
            r1 = r8
            r0 = r9
        L90:
            java.lang.Object r2 = r0.z()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            float r2 = l(r2, r1)
            ir.nasim.Ft r11 = new ir.nasim.Ft
            float r1 = r3.a
            float r10 = r10 - r1
            java.lang.Float r10 = ir.nasim.AbstractC6392Nk0.c(r10)
            r8 = 29
            r9 = 0
            r1 = 0
            r3 = 0
            r5 = 0
            r7 = 0
            ir.nasim.Mt r0 = ir.nasim.AbstractC6483Nt.g(r0, r1, r2, r3, r5, r7, r8, r9)
            r11.<init>(r10, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AG6.h(ir.nasim.Xd6, float, float, ir.nasim.Mt, ir.nasim.Kt, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object i(InterfaceC8748Xd6 interfaceC8748Xd6, float f, float f2, InterfaceC16429lG interfaceC16429lG, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return interfaceC16429lG.a(interfaceC8748Xd6, AbstractC6392Nk0.c(f), AbstractC6392Nk0.c(f2), ua2, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final float j(int r3, float r4, float r5) {
        /*
            ir.nasim.uo2$a r0 = ir.nasim.AbstractC22184uo2.a
            int r1 = r0.a()
            boolean r1 = ir.nasim.AbstractC22184uo2.e(r3, r1)
            r2 = 0
            if (r1 == 0) goto L1a
            float r3 = java.lang.Math.abs(r5)
            float r0 = java.lang.Math.abs(r4)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L32
            goto L24
        L1a:
            int r1 = r0.b()
            boolean r1 = ir.nasim.AbstractC22184uo2.e(r3, r1)
            if (r1 == 0) goto L26
        L24:
            r4 = r5
            goto L32
        L26:
            int r5 = r0.c()
            boolean r3 = ir.nasim.AbstractC22184uo2.e(r3, r5)
            if (r3 == 0) goto L31
            goto L32
        L31:
            r4 = r2
        L32:
            boolean r3 = k(r4)
            if (r3 == 0) goto L39
            r2 = r4
        L39:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AG6.j(int, float, float):float");
    }

    private static final boolean k(float f) {
        return (f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float l(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return f2 > 0.0f ? AbstractC23053wG5.h(f, f2) : AbstractC23053wG5.d(f, f2);
    }

    public static final float m() {
        return a;
    }

    public static final InterfaceC4031Dj7 n(CG6 cg6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1921733134, i, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:231)");
        }
        Object obj = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
        InterfaceC10163bB1 interfaceC10163bB1B = LI6.b(interfaceC22053ub1, 0);
        boolean zV = interfaceC22053ub1.V(interfaceC10163bB1B) | ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(cg6)) || (i & 6) == 4) | interfaceC22053ub1.V(obj);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = o(cg6, interfaceC10163bB1B, AbstractC5999Lt.j(0.0f, 400.0f, null, 5, null));
            interfaceC22053ub1.s(objB);
        }
        InterfaceC4031Dj7 interfaceC4031Dj7 = (InterfaceC4031Dj7) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC4031Dj7;
    }

    public static final InterfaceC4031Dj7 o(CG6 cg6, InterfaceC10163bB1 interfaceC10163bB1, InterfaceC5766Kt interfaceC5766Kt) {
        return new C24828zG6(cg6, interfaceC10163bB1, interfaceC5766Kt);
    }
}
