package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Td6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC7778Td6 {

    /* renamed from: ir.nasim.Td6$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC7778Td6.a(null, 0.0f, null, this);
        }
    }

    /* renamed from: ir.nasim.Td6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ float d;
        final /* synthetic */ InterfaceC5766Kt e;
        final /* synthetic */ C10873cL5 f;

        /* renamed from: ir.nasim.Td6$b$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ C10873cL5 e;
            final /* synthetic */ InterfaceC8748Xd6 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10873cL5 c10873cL5, InterfaceC8748Xd6 interfaceC8748Xd6) {
                super(2);
                this.e = c10873cL5;
                this.f = interfaceC8748Xd6;
            }

            public final void a(float f, float f2) {
                C10873cL5 c10873cL5 = this.e;
                float f3 = c10873cL5.a;
                c10873cL5.a = f3 + this.f.e(f - f3);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(float f, InterfaceC5766Kt interfaceC5766Kt, C10873cL5 c10873cL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = f;
            this.e = interfaceC5766Kt;
            this.f = c10873cL5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, this.f, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8748Xd6 interfaceC8748Xd6 = (InterfaceC8748Xd6) this.c;
                float f = this.d;
                InterfaceC5766Kt interfaceC5766Kt = this.e;
                a aVar = new a(this.f, interfaceC8748Xd6);
                this.b = 1;
                if (AbstractC18086o37.e(0.0f, f, 0.0f, interfaceC5766Kt, aVar, this, 4, null) == objE) {
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
        public final Object invoke(InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Td6$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC7778Td6.c(null, 0.0f, this);
        }
    }

    /* renamed from: ir.nasim.Td6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C10873cL5 d;
        final /* synthetic */ float e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C10873cL5 c10873cL5, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c10873cL5;
            this.e = f;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, this.e, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC8748Xd6 interfaceC8748Xd6 = (InterfaceC8748Xd6) this.c;
            this.d.a = interfaceC8748Xd6.e(this.e);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Td6$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC8748Xd6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(ir.nasim.InterfaceC11049ce6 r7, float r8, ir.nasim.InterfaceC5766Kt r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            boolean r0 = r10 instanceof ir.nasim.AbstractC7778Td6.a
            if (r0 == 0) goto L14
            r0 = r10
            ir.nasim.Td6$a r0 = (ir.nasim.AbstractC7778Td6.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            ir.nasim.Td6$a r0 = new ir.nasim.Td6$a
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r4.c
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r7 = r4.a
            ir.nasim.cL5 r7 = (ir.nasim.C10873cL5) r7
            ir.nasim.AbstractC10685c16.b(r10)
            goto L55
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.cL5 r10 = new ir.nasim.cL5
            r10.<init>()
            ir.nasim.Td6$b r3 = new ir.nasim.Td6$b
            r1 = 0
            r3.<init>(r8, r9, r10, r1)
            r4.a = r10
            r4.c = r2
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r7
            java.lang.Object r7 = ir.nasim.InterfaceC11049ce6.a(r1, r2, r3, r4, r5, r6)
            if (r7 != r0) goto L54
            return r0
        L54:
            r7 = r10
        L55:
            float r7 = r7.a
            java.lang.Float r7 = ir.nasim.AbstractC6392Nk0.c(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7778Td6.a(ir.nasim.ce6, float, ir.nasim.Kt, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object b(InterfaceC11049ce6 interfaceC11049ce6, float f, InterfaceC5766Kt interfaceC5766Kt, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC5766Kt = AbstractC5999Lt.j(0.0f, 0.0f, null, 7, null);
        }
        return a(interfaceC11049ce6, f, interfaceC5766Kt, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(ir.nasim.InterfaceC11049ce6 r7, float r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            boolean r0 = r9 instanceof ir.nasim.AbstractC7778Td6.c
            if (r0 == 0) goto L14
            r0 = r9
            ir.nasim.Td6$c r0 = (ir.nasim.AbstractC7778Td6.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            ir.nasim.Td6$c r0 = new ir.nasim.Td6$c
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r4.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r4.c
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r7 = r4.a
            ir.nasim.cL5 r7 = (ir.nasim.C10873cL5) r7
            ir.nasim.AbstractC10685c16.b(r9)
            goto L55
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.cL5 r9 = new ir.nasim.cL5
            r9.<init>()
            ir.nasim.Td6$d r3 = new ir.nasim.Td6$d
            r1 = 0
            r3.<init>(r9, r8, r1)
            r4.a = r9
            r4.c = r2
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r7
            java.lang.Object r7 = ir.nasim.InterfaceC11049ce6.a(r1, r2, r3, r4, r5, r6)
            if (r7 != r0) goto L54
            return r0
        L54:
            r7 = r9
        L55:
            float r7 = r7.a
            java.lang.Float r7 = ir.nasim.AbstractC6392Nk0.c(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7778Td6.c(ir.nasim.ce6, float, ir.nasim.rm1):java.lang.Object");
    }

    public static final Object d(InterfaceC11049ce6 interfaceC11049ce6, EnumC15562jn4 enumC15562jn4, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = interfaceC11049ce6.b(enumC15562jn4, new e(null), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public static /* synthetic */ Object e(InterfaceC11049ce6 interfaceC11049ce6, EnumC15562jn4 enumC15562jn4, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC15562jn4 = EnumC15562jn4.a;
        }
        return d(interfaceC11049ce6, enumC15562jn4, interfaceC20295rm1);
    }
}
