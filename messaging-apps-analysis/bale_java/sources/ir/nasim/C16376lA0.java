package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.lA0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C16376lA0 extends C20612sJ0 {
    private final InterfaceC14603iB2 e;

    /* renamed from: ir.nasim.lA0$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C16376lA0.this.j(null, this);
        }
    }

    public /* synthetic */ C16376lA0(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0, int i2, ED1 ed1) {
        this(interfaceC14603iB2, (i2 & 2) != 0 ? C18712p72.a : interfaceC11938do1, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? EnumC6162Ml0.SUSPEND : enumC6162Ml0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.C20612sJ0, ir.nasim.AbstractC20003rJ0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object j(ir.nasim.InterfaceC16204ks5 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C16376lA0.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.lA0$a r0 = (ir.nasim.C16376lA0.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.lA0$a r0 = new ir.nasim.lA0$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.ks5 r5 = (ir.nasim.InterfaceC16204ks5) r5
            ir.nasim.AbstractC10685c16.b(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = super.j(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.A()
            if (r5 == 0) goto L4c
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16376lA0.j(ir.nasim.ks5, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.C20612sJ0, ir.nasim.AbstractC20003rJ0
    protected AbstractC20003rJ0 l(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return new C16376lA0(this.e, interfaceC11938do1, i, enumC6162Ml0);
    }

    public C16376lA0(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        super(interfaceC14603iB2, interfaceC11938do1, i, enumC6162Ml0);
        this.e = interfaceC14603iB2;
    }
}
