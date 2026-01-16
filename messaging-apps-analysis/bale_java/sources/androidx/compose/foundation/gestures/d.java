package androidx.compose.foundation.gestures;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC11873dh5;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC18086o37;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC4559Fq4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C10873cL5;
import ir.nasim.C19938rB7;
import ir.nasim.C23864xe6;
import ir.nasim.C6616Og5;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC11049ce6;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC14124hO4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC4325Eq4;
import ir.nasim.InterfaceC7645Sp2;
import ir.nasim.InterfaceC8539Wk0;
import ir.nasim.InterfaceC8748Xd6;
import ir.nasim.InterfaceC9309Zj4;
import ir.nasim.UA2;
import ir.nasim.WH1;

/* loaded from: classes.dex */
public abstract class d {
    private static final UA2 a = a.e;
    private static final InterfaceC8748Xd6 b = new c();
    private static final InterfaceC9309Zj4 c = new b();
    private static final C0039d d = new C0039d();

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C6616Og5 c6616Og5) {
            return Boolean.valueOf(!AbstractC11873dh5.g(c6616Og5.n(), AbstractC11873dh5.a.b()));
        }
    }

    public static final class b implements InterfaceC9309Zj4 {
        b() {
        }

        @Override // ir.nasim.InterfaceC11938do1
        public InterfaceC11938do1 X(InterfaceC11938do1 interfaceC11938do1) {
            return InterfaceC9309Zj4.a.d(this, interfaceC11938do1);
        }

        @Override // ir.nasim.InterfaceC11938do1.b, ir.nasim.InterfaceC11938do1
        public InterfaceC11938do1.b a(InterfaceC11938do1.c cVar) {
            return InterfaceC9309Zj4.a.b(this, cVar);
        }

        @Override // ir.nasim.InterfaceC11938do1
        public Object f0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
            return InterfaceC9309Zj4.a.a(this, obj, interfaceC14603iB2);
        }

        @Override // ir.nasim.InterfaceC11938do1
        public InterfaceC11938do1 l(InterfaceC11938do1.c cVar) {
            return InterfaceC9309Zj4.a.c(this, cVar);
        }

        @Override // ir.nasim.InterfaceC9309Zj4
        public float z() {
            return 1.0f;
        }
    }

    public static final class c implements InterfaceC8748Xd6 {
        c() {
        }

        @Override // ir.nasim.InterfaceC8748Xd6
        public float e(float f) {
            return f;
        }
    }

    /* renamed from: androidx.compose.foundation.gestures.d$d, reason: collision with other inner class name */
    public static final class C0039d implements WH1 {
        C0039d() {
        }

        @Override // ir.nasim.WH1
        public float getDensity() {
            return 1.0f;
        }

        @Override // ir.nasim.InterfaceC23430wu2
        public float t1() {
            return 1.0f;
        }
    }

    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return d.l(null, 0L, this);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C23864xe6 d;
        final /* synthetic */ long e;
        final /* synthetic */ C10873cL5 f;

        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ C10873cL5 e;
            final /* synthetic */ C23864xe6 f;
            final /* synthetic */ InterfaceC4325Eq4 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10873cL5 c10873cL5, C23864xe6 c23864xe6, InterfaceC4325Eq4 interfaceC4325Eq4) {
                super(2);
                this.e = c10873cL5;
                this.f = c23864xe6;
                this.g = interfaceC4325Eq4;
            }

            public final void a(float f, float f2) {
                float f3 = f - this.e.a;
                C23864xe6 c23864xe6 = this.f;
                this.e.a += c23864xe6.x(c23864xe6.F(this.g.b(c23864xe6.G(c23864xe6.x(f3)), AbstractC4559Fq4.a.c())));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C23864xe6 c23864xe6, long j, C10873cL5 c10873cL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c23864xe6;
            this.e = j;
            this.f = c10873cL5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, this.e, this.f, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4325Eq4 interfaceC4325Eq4 = (InterfaceC4325Eq4) this.c;
                float F = this.d.F(this.e);
                a aVar = new a(this.f, this.d, interfaceC4325Eq4);
                this.b = 1;
                if (AbstractC18086o37.e(0.0f, F, 0.0f, null, aVar, this, 12, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4325Eq4 interfaceC4325Eq4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC4325Eq4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC9309Zj4 f() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(InterfaceC7645Sp2 interfaceC7645Sp2) {
        return false;
    }

    public static final androidx.compose.ui.e h(androidx.compose.ui.e eVar, InterfaceC11049ce6 interfaceC11049ce6, EnumC24286yM4 enumC24286yM4, InterfaceC14124hO4 interfaceC14124hO4, boolean z, boolean z2, InterfaceC7645Sp2 interfaceC7645Sp2, InterfaceC18507om4 interfaceC18507om4, InterfaceC8539Wk0 interfaceC8539Wk0) {
        return eVar.i(new ScrollableElement(interfaceC11049ce6, enumC24286yM4, interfaceC14124hO4, z, z2, interfaceC7645Sp2, interfaceC18507om4, interfaceC8539Wk0));
    }

    public static final androidx.compose.ui.e i(androidx.compose.ui.e eVar, InterfaceC11049ce6 interfaceC11049ce6, EnumC24286yM4 enumC24286yM4, boolean z, boolean z2, InterfaceC7645Sp2 interfaceC7645Sp2, InterfaceC18507om4 interfaceC18507om4) {
        return j(eVar, interfaceC11049ce6, enumC24286yM4, null, z, z2, interfaceC7645Sp2, interfaceC18507om4, null, 128, null);
    }

    public static /* synthetic */ androidx.compose.ui.e j(androidx.compose.ui.e eVar, InterfaceC11049ce6 interfaceC11049ce6, EnumC24286yM4 enumC24286yM4, InterfaceC14124hO4 interfaceC14124hO4, boolean z, boolean z2, InterfaceC7645Sp2 interfaceC7645Sp2, InterfaceC18507om4 interfaceC18507om4, InterfaceC8539Wk0 interfaceC8539Wk0, int i, Object obj) {
        return h(eVar, interfaceC11049ce6, enumC24286yM4, interfaceC14124hO4, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? null : interfaceC7645Sp2, (i & 64) != 0 ? null : interfaceC18507om4, (i & 128) != 0 ? null : interfaceC8539Wk0);
    }

    public static /* synthetic */ androidx.compose.ui.e k(androidx.compose.ui.e eVar, InterfaceC11049ce6 interfaceC11049ce6, EnumC24286yM4 enumC24286yM4, boolean z, boolean z2, InterfaceC7645Sp2 interfaceC7645Sp2, InterfaceC18507om4 interfaceC18507om4, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        return i(eVar, interfaceC11049ce6, enumC24286yM4, z3, z2, (i & 16) != 0 ? null : interfaceC7645Sp2, (i & 32) != 0 ? null : interfaceC18507om4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(ir.nasim.C23864xe6 r11, long r12, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.d.e
            if (r0 == 0) goto L13
            r0 = r14
            androidx.compose.foundation.gestures.d$e r0 = (androidx.compose.foundation.gestures.d.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.d$e r0 = new androidx.compose.foundation.gestures.d$e
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r11 = r0.b
            ir.nasim.cL5 r11 = (ir.nasim.C10873cL5) r11
            java.lang.Object r12 = r0.a
            ir.nasim.xe6 r12 = (ir.nasim.C23864xe6) r12
            ir.nasim.AbstractC10685c16.b(r14)
            r14 = r11
            r11 = r12
            goto L5c
        L33:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3b:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.cL5 r14 = new ir.nasim.cL5
            r14.<init>()
            ir.nasim.jn4 r2 = ir.nasim.EnumC15562jn4.a
            androidx.compose.foundation.gestures.d$f r10 = new androidx.compose.foundation.gestures.d$f
            r9 = 0
            r4 = r10
            r5 = r11
            r6 = r12
            r8 = r14
            r4.<init>(r5, r6, r8, r9)
            r0.a = r11
            r0.b = r14
            r0.d = r3
            java.lang.Object r12 = r11.z(r2, r10, r0)
            if (r12 != r1) goto L5c
            return r1
        L5c:
            float r12 = r14.a
            long r11 = r11.G(r12)
            ir.nasim.ZG4 r11 = ir.nasim.ZG4.d(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.d.l(ir.nasim.xe6, long, ir.nasim.rm1):java.lang.Object");
    }
}
