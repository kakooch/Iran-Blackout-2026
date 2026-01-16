package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: ir.nasim.g95, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13398g95 extends YT4 {
    private final C11458d25 b;
    private final F95 c;
    private final InterfaceC20315ro1 d;

    /* renamed from: ir.nasim.g95$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.g95$a$a, reason: collision with other inner class name */
        static final class C1249a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13398g95 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1249a(C13398g95 c13398g95, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13398g95;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1249a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.e();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ArrayList arrayList, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1249a) create(arrayList, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13398g95.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6C = C13398g95.this.c.c();
                C1249a c1249a = new C1249a(C13398g95.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10040ay6C, c1249a, this) == objE) {
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

    /* renamed from: ir.nasim.g95$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C13398g95.this.f(null, this);
        }
    }

    public C13398g95(C11458d25 c11458d25, F95 f95, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(f95, "repository");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.b = c11458d25;
        this.c = f95;
        this.d = interfaceC20315ro1;
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C13398g95.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.g95$b r0 = (ir.nasim.C13398g95.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.g95$b r0 = new ir.nasim.g95$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L47
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            java.lang.Object r7 = r7.a()
            java.lang.Long r7 = (java.lang.Long) r7
            ir.nasim.F95 r8 = r6.c
            ir.nasim.d25 r2 = r6.b
            r0.c = r3
            java.lang.Object r8 = r8.i(r2, r7, r0)
            if (r8 != r1) goto L47
            return r1
        L47:
            java.util.List r8 = (java.util.List) r8
            ir.nasim.YT4$b$c r7 = new ir.nasim.YT4$b$c
            java.lang.Object r0 = ir.nasim.ZW0.F0(r8)
            ir.nasim.my6$d r0 = (ir.nasim.InterfaceC17445my6.d) r0
            r1 = 0
            if (r0 == 0) goto L60
            long r2 = r0.h()
            r4 = 1
            long r2 = r2 - r4
            java.lang.Long r0 = ir.nasim.AbstractC6392Nk0.e(r2)
            goto L61
        L60:
            r0 = r1
        L61:
            r7.<init>(r8, r1, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13398g95.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Long d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return null;
    }
}
