package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;

/* renamed from: ir.nasim.Ov5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6756Ov5 {

    /* renamed from: ir.nasim.Ov5$a */
    static final class a implements InterfaceC24449ye1 {
        final /* synthetic */ InterfaceC20295rm1 a;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = interfaceC20295rm1;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        public final void apply(Object obj) {
            this.a.resumeWith(C9475a16.b(obj));
        }
    }

    /* renamed from: ir.nasim.Ov5$b */
    static final class b implements InterfaceC24449ye1 {
        final /* synthetic */ InterfaceC20295rm1 a;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = interfaceC20295rm1;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(Exception exc) {
            InterfaceC20295rm1 interfaceC20295rm1 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC13042fc3.f(exc);
            interfaceC20295rm1.resumeWith(C9475a16.b(AbstractC10685c16.a(exc)));
        }
    }

    /* renamed from: ir.nasim.Ov5$c */
    static final class c implements InterfaceC24449ye1 {
        final /* synthetic */ InterfaceC20295rm1 a;
        final /* synthetic */ SA2 b;

        c(InterfaceC20295rm1 interfaceC20295rm1, SA2 sa2) {
            this.a = interfaceC20295rm1;
            this.b = sa2;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        public final void apply(Object obj) {
            InterfaceC20295rm1 interfaceC20295rm1 = this.a;
            C9475a16.a aVar = C9475a16.b;
            interfaceC20295rm1.resumeWith(C9475a16.b(this.b.invoke()));
        }
    }

    /* renamed from: ir.nasim.Ov5$d */
    static final class d implements InterfaceC24449ye1 {
        final /* synthetic */ InterfaceC20295rm1 a;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = interfaceC20295rm1;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(Exception exc) {
            InterfaceC20295rm1 interfaceC20295rm1 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC13042fc3.f(exc);
            interfaceC20295rm1.resumeWith(C9475a16.b(AbstractC10685c16.a(exc)));
        }
    }

    /* renamed from: ir.nasim.Ov5$e */
    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= RecyclerView.UNDEFINED_DURATION;
            Object objC = AbstractC6756Ov5.c(null, null, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.Ov5$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ C6517Nv5 e;
        final /* synthetic */ SA2 f;

        /* renamed from: ir.nasim.Ov5$f$a */
        static final class a implements InterfaceC24449ye1 {
            final /* synthetic */ InterfaceC20295rm1 a;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                this.a = interfaceC20295rm1;
            }

            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.resumeWith(C9475a16.b(C9475a16.a(C9475a16.b(obj))));
            }
        }

        /* renamed from: ir.nasim.Ov5$f$b */
        static final class b implements InterfaceC24449ye1 {
            final /* synthetic */ InterfaceC20295rm1 a;

            b(InterfaceC20295rm1 interfaceC20295rm1) {
                this.a = interfaceC20295rm1;
            }

            @Override // ir.nasim.InterfaceC24449ye1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void apply(Exception exc) {
                InterfaceC20295rm1 interfaceC20295rm1 = this.a;
                C9475a16.a aVar = C9475a16.b;
                AbstractC13042fc3.f(exc);
                interfaceC20295rm1.resumeWith(C9475a16.b(C9475a16.a(C9475a16.b(AbstractC10685c16.a(exc)))));
            }
        }

        /* renamed from: ir.nasim.Ov5$f$c */
        static final class c implements InterfaceC3273Ae1 {
            final /* synthetic */ SA2 a;

            c(SA2 sa2) {
                this.a = sa2;
            }

            @Override // ir.nasim.InterfaceC3273Ae1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void apply(Object obj, Exception exc) {
                SA2 sa2 = this.a;
                if (sa2 != null) {
                    sa2.invoke();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C6517Nv5 c6517Nv5, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c6517Nv5;
            this.f = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5 = this.e;
                SA2 sa2 = this.f;
                this.b = c6517Nv5;
                this.c = sa2;
                this.d = 1;
                C16963m96 c16963m96 = new C16963m96(AbstractC14251hc3.c(this));
                c6517Nv5.m0(new a(c16963m96));
                c6517Nv5.E(new b(c16963m96));
                c6517Nv5.z(new c(sa2));
                obj = c16963m96.a();
                if (obj == AbstractC14862ic3.e()) {
                    WA1.c(this);
                }
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(C6517Nv5 c6517Nv5, InterfaceC20295rm1 interfaceC20295rm1) {
        C16963m96 c16963m96 = new C16963m96(AbstractC14251hc3.c(interfaceC20295rm1));
        c6517Nv5.m0(new a(c16963m96));
        c6517Nv5.E(new b(c16963m96));
        Object objA = c16963m96.a();
        if (objA == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objA;
    }

    public static final Object b(C6517Nv5 c6517Nv5, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
        C16963m96 c16963m96 = new C16963m96(AbstractC14251hc3.c(interfaceC20295rm1));
        c6517Nv5.m0(new c(c16963m96, sa2));
        c6517Nv5.E(new d(c16963m96));
        Object objA = c16963m96.a();
        if (objA == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objA;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(ir.nasim.C6517Nv5 r5, ir.nasim.SA2 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            boolean r0 = r7 instanceof ir.nasim.AbstractC6756Ov5.e
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Ov5$e r0 = (ir.nasim.AbstractC6756Ov5.e) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            ir.nasim.Ov5$e r0 = new ir.nasim.Ov5$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L4b
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.WM3 r7 = ir.nasim.C12366eV1.c()
            ir.nasim.WM3 r7 = r7.F0()
            ir.nasim.Ov5$f r2 = new ir.nasim.Ov5$f
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.b = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r5 = r7.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6756Ov5.c(ir.nasim.Nv5, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object d(C6517Nv5 c6517Nv5, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            sa2 = null;
        }
        return c(c6517Nv5, sa2, interfaceC20295rm1);
    }
}
