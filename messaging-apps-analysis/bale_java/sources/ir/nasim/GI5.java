package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC3955Db3;
import java.util.List;

/* loaded from: classes2.dex */
public final class GI5 implements InterfaceC3955Db3.a {
    private final W23 a;
    private final List b;
    private final int c;
    private final W23 d;
    private final PD6 e;
    private final InterfaceC8217Va2 f;
    private final boolean g;

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return GI5.this.g(null, this);
        }
    }

    public GI5(W23 w23, List list, int i, W23 w232, PD6 pd6, InterfaceC8217Va2 interfaceC8217Va2, boolean z) {
        this.a = w23;
        this.b = list;
        this.c = i;
        this.d = w232;
        this.e = pd6;
        this.f = interfaceC8217Va2;
        this.g = z;
    }

    private final void a(W23 w23, InterfaceC3955Db3 interfaceC3955Db3) {
        if (w23.l() != this.a.l()) {
            throw new IllegalStateException(("Interceptor '" + interfaceC3955Db3 + "' cannot modify the request's context.").toString());
        }
        if (w23.m() == C11582dF4.a) {
            throw new IllegalStateException(("Interceptor '" + interfaceC3955Db3 + "' cannot set the request's data to null.").toString());
        }
        if (w23.M() != this.a.M()) {
            throw new IllegalStateException(("Interceptor '" + interfaceC3955Db3 + "' cannot modify the request's target.").toString());
        }
        if (w23.z() != this.a.z()) {
            throw new IllegalStateException(("Interceptor '" + interfaceC3955Db3 + "' cannot modify the request's lifecycle.").toString());
        }
        if (w23.K() == this.a.K()) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + interfaceC3955Db3 + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    private final GI5 b(int i, W23 w23, PD6 pd6) {
        return new GI5(this.a, this.b, i, w23, pd6, this.f, this.g);
    }

    static /* synthetic */ GI5 c(GI5 gi5, int i, W23 w23, PD6 pd6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gi5.c;
        }
        if ((i2 & 2) != 0) {
            w23 = gi5.getRequest();
        }
        if ((i2 & 4) != 0) {
            pd6 = gi5.f();
        }
        return gi5.b(i, w23, pd6);
    }

    public final InterfaceC8217Va2 d() {
        return this.f;
    }

    public final boolean e() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC3955Db3.a
    public PD6 f() {
        return this.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(ir.nasim.W23 r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof ir.nasim.GI5.a
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.GI5$a r0 = (ir.nasim.GI5.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.GI5$a r0 = new ir.nasim.GI5$a
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r12 = r0.b
            ir.nasim.Db3 r12 = (ir.nasim.InterfaceC3955Db3) r12
            java.lang.Object r0 = r0.a
            ir.nasim.GI5 r0 = (ir.nasim.GI5) r0
            ir.nasim.AbstractC10685c16.b(r13)
            goto L74
        L31:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L39:
            ir.nasim.AbstractC10685c16.b(r13)
            int r13 = r11.c
            if (r13 <= 0) goto L4c
            java.util.List r2 = r11.b
            int r13 = r13 - r3
            java.lang.Object r13 = r2.get(r13)
            ir.nasim.Db3 r13 = (ir.nasim.InterfaceC3955Db3) r13
            r11.a(r12, r13)
        L4c:
            java.util.List r13 = r11.b
            int r2 = r11.c
            java.lang.Object r13 = r13.get(r2)
            ir.nasim.Db3 r13 = (ir.nasim.InterfaceC3955Db3) r13
            int r2 = r11.c
            int r5 = r2 + 1
            r8 = 4
            r9 = 0
            r7 = 0
            r4 = r11
            r6 = r12
            ir.nasim.GI5 r12 = c(r4, r5, r6, r7, r8, r9)
            r0.a = r11
            r0.b = r13
            r0.e = r3
            java.lang.Object r12 = r13.a(r12, r0)
            if (r12 != r1) goto L70
            return r1
        L70:
            r0 = r11
            r10 = r13
            r13 = r12
            r12 = r10
        L74:
            ir.nasim.Y23 r13 = (ir.nasim.Y23) r13
            ir.nasim.W23 r1 = r13.b()
            r0.a(r1, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GI5.g(ir.nasim.W23, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC3955Db3.a
    public W23 getRequest() {
        return this.d;
    }
}
