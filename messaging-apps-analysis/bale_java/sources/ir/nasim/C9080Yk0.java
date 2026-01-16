package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Yk0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C9080Yk0 implements InterfaceC7983Ua2 {
    private final InterfaceC8327Vm4 a;
    private final InterfaceC10040ay6 b;

    /* renamed from: ir.nasim.Yk0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C9080Yk0.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C9080Yk0 c9080Yk0 = C9080Yk0.this;
                Object obj2 = this.d;
                this.b = 1;
                if (c9080Yk0.c(obj2, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Yk0$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C9080Yk0.this.d(null, this);
        }
    }

    public C9080Yk0() {
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(0, Integer.MAX_VALUE, null, 5, null);
        this.a = interfaceC8327Vm4B;
        this.b = AbstractC6459Nq2.b(interfaceC8327Vm4B);
    }

    @Override // ir.nasim.InterfaceC7983Ua2
    public InterfaceC10040ay6 a() {
        return this.b;
    }

    public final InterfaceC13730gj3 b(Object obj, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(obj, null), 3, null);
    }

    public final Object c(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = this.a.a(obj, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.util.Collection r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C9080Yk0.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Yk0$b r0 = (ir.nasim.C9080Yk0.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Yk0$b r0 = new ir.nasim.Yk0$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.b
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.a
            ir.nasim.Yk0 r2 = (ir.nasim.C9080Yk0) r2
            ir.nasim.AbstractC10685c16.b(r7)
            goto L43
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            ir.nasim.AbstractC10685c16.b(r7)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r2 = r5
        L43:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L5c
            java.lang.Object r7 = r6.next()
            ir.nasim.Vm4 r4 = r2.a
            r0.a = r2
            r0.b = r6
            r0.e = r3
            java.lang.Object r7 = r4.a(r7, r0)
            if (r7 != r1) goto L43
            return r1
        L5c:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9080Yk0.d(java.util.Collection, ir.nasim.rm1):java.lang.Object");
    }

    public final void f(Object obj) {
        this.a.c(obj);
    }

    public final InterfaceC7983Ua2 e() {
        return this;
    }
}
