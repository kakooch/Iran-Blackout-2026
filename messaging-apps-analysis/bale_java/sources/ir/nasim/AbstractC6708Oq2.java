package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Oq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC6708Oq2 {

    /* renamed from: ir.nasim.Oq2$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ Iterable a;

        /* renamed from: ir.nasim.Oq2$a$a, reason: collision with other inner class name */
        public static final class C0562a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int b;
            Object d;
            Object e;

            public C0562a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= RecyclerView.UNDEFINED_DURATION;
                return a.this.b(null, this);
            }
        }

        public a(Iterable iterable) {
            this.a = iterable;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC4557Fq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r6, ir.nasim.InterfaceC20295rm1 r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof ir.nasim.AbstractC6708Oq2.a.C0562a
                if (r0 == 0) goto L13
                r0 = r7
                ir.nasim.Oq2$a$a r0 = (ir.nasim.AbstractC6708Oq2.a.C0562a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                ir.nasim.Oq2$a$a r0 = new ir.nasim.Oq2$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.b
                r3 = 1
                if (r2 == 0) goto L3a
                if (r2 != r3) goto L32
                java.lang.Object r6 = r0.e
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r2 = r0.d
                ir.nasim.Gq2 r2 = (ir.nasim.InterfaceC4806Gq2) r2
                ir.nasim.AbstractC10685c16.b(r7)
                r7 = r2
                goto L46
            L32:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3a:
                ir.nasim.AbstractC10685c16.b(r7)
                java.lang.Iterable r7 = r5.a
                java.util.Iterator r7 = r7.iterator()
                r4 = r7
                r7 = r6
                r6 = r4
            L46:
                boolean r2 = r6.hasNext()
                if (r2 == 0) goto L5d
                java.lang.Object r2 = r6.next()
                r0.d = r7
                r0.e = r6
                r0.b = r3
                java.lang.Object r2 = r7.a(r2, r0)
                if (r2 != r1) goto L46
                return r1
            L5d:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6708Oq2.a.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.Oq2$b */
    public static final class b implements InterfaceC4557Fq2 {
        final /* synthetic */ Object[] a;

        /* renamed from: ir.nasim.Oq2$b$a */
        public static final class a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int b;
            Object d;
            Object e;
            int f;
            int g;

            public a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= RecyclerView.UNDEFINED_DURATION;
                return b.this.b(null, this);
            }
        }

        public b(Object[] objArr) {
            this.a = objArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005d -> B:19:0x0060). Please report as a decompilation issue!!! */
        @Override // ir.nasim.InterfaceC4557Fq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r8, ir.nasim.InterfaceC20295rm1 r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof ir.nasim.AbstractC6708Oq2.b.a
                if (r0 == 0) goto L13
                r0 = r9
                ir.nasim.Oq2$b$a r0 = (ir.nasim.AbstractC6708Oq2.b.a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                ir.nasim.Oq2$b$a r0 = new ir.nasim.Oq2$b$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.b
                r3 = 1
                if (r2 == 0) goto L3e
                if (r2 != r3) goto L36
                int r8 = r0.g
                int r2 = r0.f
                java.lang.Object r4 = r0.e
                ir.nasim.Gq2 r4 = (ir.nasim.InterfaceC4806Gq2) r4
                java.lang.Object r5 = r0.d
                ir.nasim.Oq2$b r5 = (ir.nasim.AbstractC6708Oq2.b) r5
                ir.nasim.AbstractC10685c16.b(r9)
                r9 = r4
                goto L60
            L36:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3e:
                ir.nasim.AbstractC10685c16.b(r9)
                java.lang.Object[] r9 = r7.a
                int r9 = r9.length
                r2 = 0
                r5 = r7
                r6 = r9
                r9 = r8
                r8 = r6
            L49:
                if (r2 >= r8) goto L62
                java.lang.Object[] r4 = r5.a
                r4 = r4[r2]
                r0.d = r5
                r0.e = r9
                r0.f = r2
                r0.g = r8
                r0.b = r3
                java.lang.Object r4 = r9.a(r4, r0)
                if (r4 != r1) goto L60
                return r1
            L60:
                int r2 = r2 + r3
                goto L49
            L62:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6708Oq2.b.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
        }
    }

    /* renamed from: ir.nasim.Oq2$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ Object a;

        public c(Object obj) {
            this.a = obj;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objA = interfaceC4806Gq2.a(this.a, interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    public static final InterfaceC4557Fq2 a(Iterable iterable) {
        return new a(iterable);
    }

    public static final InterfaceC4557Fq2 b(InterfaceC14603iB2 interfaceC14603iB2) {
        return new C16376lA0(interfaceC14603iB2, null, 0, null, 14, null);
    }

    public static final InterfaceC4557Fq2 c(InterfaceC14603iB2 interfaceC14603iB2) {
        return new C20612sJ0(interfaceC14603iB2, null, 0, null, 14, null);
    }

    public static final InterfaceC4557Fq2 d() {
        return C20503s72.a;
    }

    public static final InterfaceC4557Fq2 e(InterfaceC14603iB2 interfaceC14603iB2) {
        return new C17554n96(interfaceC14603iB2);
    }

    public static final InterfaceC4557Fq2 f(Object obj) {
        return new c(obj);
    }

    public static final InterfaceC4557Fq2 g(Object... objArr) {
        return new b(objArr);
    }
}
