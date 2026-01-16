package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC15522jj4;

/* loaded from: classes.dex */
public final class J15 implements InterfaceC15522jj4 {
    private final InterfaceC15522jj4 a;
    private final C6003Lt3 b = new C6003Lt3();

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
            return J15.this.G(null, this);
        }
    }

    public J15(InterfaceC15522jj4 interfaceC15522jj4) {
        this.a = interfaceC15522jj4;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC15522jj4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object G(ir.nasim.UA2 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.J15.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.J15$a r0 = (ir.nasim.J15.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.J15$a r0 = new ir.nasim.J15$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r7)
            goto L63
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.b
            ir.nasim.UA2 r6 = (ir.nasim.UA2) r6
            java.lang.Object r2 = r0.a
            ir.nasim.J15 r2 = (ir.nasim.J15) r2
            ir.nasim.AbstractC10685c16.b(r7)
            goto L53
        L40:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.Lt3 r7 = r5.b
            r0.a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r7.c(r0)
            if (r7 != r1) goto L52
            return r1
        L52:
            r2 = r5
        L53:
            ir.nasim.jj4 r7 = r2.a
            r2 = 0
            r0.a = r2
            r0.b = r2
            r0.e = r3
            java.lang.Object r7 = r7.G(r6, r0)
            if (r7 != r1) goto L63
            return r1
        L63:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J15.G(ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 X(InterfaceC11938do1 interfaceC11938do1) {
        return InterfaceC15522jj4.a.d(this, interfaceC11938do1);
    }

    @Override // ir.nasim.InterfaceC11938do1.b, ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1.b a(InterfaceC11938do1.c cVar) {
        return InterfaceC15522jj4.a.b(this, cVar);
    }

    public final void f() {
        this.b.d();
    }

    @Override // ir.nasim.InterfaceC11938do1
    public Object f0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        return InterfaceC15522jj4.a.a(this, obj, interfaceC14603iB2);
    }

    public final void h() {
        this.b.f();
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 l(InterfaceC11938do1.c cVar) {
        return InterfaceC15522jj4.a.c(this, cVar);
    }
}
