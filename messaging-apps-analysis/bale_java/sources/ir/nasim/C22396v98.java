package ir.nasim;

import android.app.Activity;
import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.v98, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22396v98 implements InterfaceC21132t98 {
    public static final a d = new a(null);
    private final Ba8 b;
    private final InterfaceC18147o98 c;

    /* renamed from: ir.nasim.v98$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.v98$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ Activity g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(InterfaceC17639nJ0 interfaceC17639nJ0, C25010za8 c25010za8) {
            AbstractC13042fc3.h(c25010za8, ParameterNames.INFO);
            interfaceC17639nJ0.h(c25010za8);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C22396v98.this.new b(this.g, interfaceC20295rm1);
            bVar.e = obj;
            return bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0072 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #0 {all -> 0x001f, blocks: (B:7:0x001a, B:18:0x0064, B:22:0x0076, B:24:0x007e, B:14:0x0036, B:17:0x0060), top: B:31:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0090 -> B:8:0x001d). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r9.d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3a
                if (r1 == r3) goto L2a
                if (r1 != r2) goto L22
                java.lang.Object r1 = r9.c
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                java.lang.Object r4 = r9.b
                ir.nasim.ze1 r4 = (ir.nasim.InterfaceC25043ze1) r4
                java.lang.Object r5 = r9.e
                ir.nasim.Gq2 r5 = (ir.nasim.InterfaceC4806Gq2) r5
                ir.nasim.AbstractC10685c16.b(r10)     // Catch: java.lang.Throwable -> L1f
            L1d:
                r10 = r5
                goto L64
            L1f:
                r10 = move-exception
                goto L9f
            L22:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L2a:
                java.lang.Object r1 = r9.c
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                java.lang.Object r4 = r9.b
                ir.nasim.ze1 r4 = (ir.nasim.InterfaceC25043ze1) r4
                java.lang.Object r5 = r9.e
                ir.nasim.Gq2 r5 = (ir.nasim.InterfaceC4806Gq2) r5
                ir.nasim.AbstractC10685c16.b(r10)     // Catch: java.lang.Throwable -> L1f
                goto L76
            L3a:
                ir.nasim.AbstractC10685c16.b(r10)
                java.lang.Object r10 = r9.e
                ir.nasim.Gq2 r10 = (ir.nasim.InterfaceC4806Gq2) r10
                ir.nasim.Ml0 r1 = ir.nasim.EnumC6162Ml0.DROP_OLDEST
                r4 = 4
                r5 = 10
                r6 = 0
                ir.nasim.nJ0 r1 = ir.nasim.DJ0.b(r5, r1, r6, r4, r6)
                ir.nasim.w98 r4 = new ir.nasim.w98
                r4.<init>()
                ir.nasim.v98 r5 = ir.nasim.C22396v98.this
                ir.nasim.o98 r5 = ir.nasim.C22396v98.c(r5)
                android.app.Activity r6 = r9.g
                ir.nasim.Fu5 r7 = new ir.nasim.Fu5
                r7.<init>()
                r5.b(r6, r7, r4)
                ir.nasim.CJ0 r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1f
            L64:
                r9.e = r10     // Catch: java.lang.Throwable -> L1f
                r9.b = r4     // Catch: java.lang.Throwable -> L1f
                r9.c = r1     // Catch: java.lang.Throwable -> L1f
                r9.d = r3     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r5 = r1.a(r9)     // Catch: java.lang.Throwable -> L1f
                if (r5 != r0) goto L73
                return r0
            L73:
                r8 = r5
                r5 = r10
                r10 = r8
            L76:
                java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L1f
                boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L1f
                if (r10 == 0) goto L93
                java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> L1f
                ir.nasim.za8 r10 = (ir.nasim.C25010za8) r10     // Catch: java.lang.Throwable -> L1f
                r9.e = r5     // Catch: java.lang.Throwable -> L1f
                r9.b = r4     // Catch: java.lang.Throwable -> L1f
                r9.c = r1     // Catch: java.lang.Throwable -> L1f
                r9.d = r2     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r10 = r5.a(r10, r9)     // Catch: java.lang.Throwable -> L1f
                if (r10 != r0) goto L1d
                return r0
            L93:
                ir.nasim.v98 r10 = ir.nasim.C22396v98.this
                ir.nasim.o98 r10 = ir.nasim.C22396v98.c(r10)
                r10.a(r4)
                ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                return r10
            L9f:
                ir.nasim.v98 r0 = ir.nasim.C22396v98.this
                ir.nasim.o98 r0 = ir.nasim.C22396v98.c(r0)
                r0.a(r4)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22396v98.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C22396v98(Ba8 ba8, InterfaceC18147o98 interfaceC18147o98) {
        AbstractC13042fc3.i(ba8, "windowMetricsCalculator");
        AbstractC13042fc3.i(interfaceC18147o98, "windowBackend");
        this.b = ba8;
        this.c = interfaceC18147o98;
    }

    @Override // ir.nasim.InterfaceC21132t98
    public InterfaceC4557Fq2 b(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        return AbstractC6459Nq2.R(new b(activity, null));
    }
}
