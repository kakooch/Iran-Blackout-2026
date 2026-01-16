package ir.nasim;

import android.gov.nist.core.Separators;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC16863lz6;
import java.util.HashMap;

/* loaded from: classes5.dex */
public final class PF2 {
    private static final a f = new a(null);
    public static final int g = 8;
    private final InterfaceC12532em2 a;
    private final AbstractC13778go1 b;
    private final InterfaceC20315ro1 c;
    private final DF2 d;
    private final InterfaceC9173Yu3 e;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static final class b {
        private final String a;
        private final long b;

        public b(String str, long j) {
            AbstractC13042fc3.i(str, "url");
            this.a = str;
            this.b = j;
        }

        public final long a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }
    }

    public static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ PF2 e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;
        final /* synthetic */ InterfaceC9336Zm4 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC20295rm1 interfaceC20295rm1, PF2 pf2, long j, long j2, InterfaceC9336Zm4 interfaceC9336Zm4) {
            super(3, interfaceC20295rm1);
            this.e = pf2;
            this.f = j;
            this.g = j2;
            this.h = interfaceC9336Zm4;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                b bVar = (b) this.d;
                InterfaceC4557Fq2 interfaceC4557Fq2S0 = (bVar == null || this.e.j(bVar)) ? AbstractC6459Nq2.s0(this.e.d.c(), this.e.new d(this.f, this.g, this.h, null)) : AbstractC6459Nq2.R(new e(bVar, this.e, this.h, null));
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2S0, this) == objE) {
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

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(interfaceC20295rm1, this.e, this.f, this.g, this.h);
            cVar.c = interfaceC4806Gq2;
            cVar.d = obj;
            return cVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ boolean d;
        final /* synthetic */ long f;
        final /* synthetic */ long g;
        final /* synthetic */ InterfaceC9336Zm4 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, long j2, InterfaceC9336Zm4 interfaceC9336Zm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.f = j;
            this.g = j2;
            this.h = interfaceC9336Zm4;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r13.b
                r2 = 0
                java.lang.String r3 = "GDUUC"
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L25
                if (r1 == r6) goto L21
                if (r1 == r5) goto L1d
                if (r1 != r4) goto L15
                goto L1d
            L15:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L1d:
                ir.nasim.AbstractC10685c16.b(r14)
                goto L79
            L21:
                ir.nasim.AbstractC10685c16.b(r14)
                goto L44
            L25:
                ir.nasim.AbstractC10685c16.b(r14)
                java.lang.Object r14 = r13.c
                ir.nasim.Gq2 r14 = (ir.nasim.InterfaceC4806Gq2) r14
                boolean r1 = r13.d
                if (r1 == 0) goto L68
                ir.nasim.PF2 r14 = ir.nasim.PF2.this
                ir.nasim.em2 r7 = ir.nasim.PF2.b(r14)
                long r8 = r13.f
                long r10 = r13.g
                r13.b = r6
                r12 = r13
                java.lang.Object r14 = r7.c(r8, r10, r12)
                if (r14 != r0) goto L44
                return r0
            L44:
                java.lang.String r14 = (java.lang.String) r14
                if (r14 == 0) goto L79
                ir.nasim.Zm4 r1 = r13.h
                java.lang.String r4 = "downloaded"
                java.lang.Object[] r2 = new java.lang.Object[r2]
                ir.nasim.C19406qI3.a(r3, r4, r2)
                long r2 = java.lang.System.currentTimeMillis()
                r4 = 3600000(0x36ee80, float:5.044674E-39)
                long r6 = (long) r4
                long r2 = r2 + r6
                ir.nasim.PF2$b r4 = new ir.nasim.PF2$b
                r4.<init>(r14, r2)
                r13.b = r5
                java.lang.Object r14 = r1.a(r4, r13)
                if (r14 != r0) goto L79
                return r0
            L68:
                java.lang.String r1 = "not connected"
                java.lang.Object[] r2 = new java.lang.Object[r2]
                ir.nasim.C19406qI3.a(r3, r1, r2)
                r13.b = r4
                r1 = 0
                java.lang.Object r14 = r14.a(r1, r13)
                if (r14 != r0) goto L79
                return r0
            L79:
                ir.nasim.rB7 r14 = ir.nasim.C19938rB7.a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PF2.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object n(InterfaceC4806Gq2 interfaceC4806Gq2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = PF2.this.new d(this.f, this.g, this.h, interfaceC20295rm1);
            dVar.c = interfaceC4806Gq2;
            dVar.d = z;
            return dVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC4806Gq2) obj, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ b d;
        final /* synthetic */ PF2 e;
        final /* synthetic */ InterfaceC9336Zm4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(b bVar, PF2 pf2, InterfaceC9336Zm4 interfaceC9336Zm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
            this.e = pf2;
            this.f = interfaceC9336Zm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.d, this.e, this.f, interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0067 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r6.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                ir.nasim.AbstractC10685c16.b(r7)
                goto L68
            L15:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1d:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L52
            L21:
                ir.nasim.AbstractC10685c16.b(r7)
                goto L3b
            L25:
                ir.nasim.AbstractC10685c16.b(r7)
                java.lang.Object r7 = r6.c
                ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                ir.nasim.PF2$b r1 = r6.d
                java.lang.String r1 = r1.b()
                r6.b = r4
                java.lang.Object r7 = r7.a(r1, r6)
                if (r7 != r0) goto L3b
                return r0
            L3b:
                ir.nasim.PF2 r7 = r6.e
                ir.nasim.PF2$b r1 = r6.d
                java.lang.Long r7 = ir.nasim.PF2.d(r7, r1)
                if (r7 == 0) goto L52
                long r4 = r7.longValue()
                r6.b = r3
                java.lang.Object r7 = ir.nasim.HG1.b(r4, r6)
                if (r7 != r0) goto L52
                return r0
            L52:
                r7 = 0
                java.lang.Object[] r7 = new java.lang.Object[r7]
                java.lang.String r1 = "GDUUC"
                java.lang.String r3 = "expired"
                ir.nasim.C19406qI3.a(r1, r3, r7)
                ir.nasim.Zm4 r7 = r6.f
                r6.b = r2
                r1 = 0
                java.lang.Object r7 = r7.a(r1, r6)
                if (r7 != r0) goto L68
                return r0
            L68:
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PF2.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public PF2(InterfaceC12532em2 interfaceC12532em2, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, DF2 df2) {
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(df2, "getConnectionStateUseCase");
        this.a = interfaceC12532em2;
        this.b = abstractC13778go1;
        this.c = interfaceC20315ro1;
        this.d = df2;
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.OF2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return PF2.k();
            }
        });
    }

    private final InterfaceC4557Fq2 f(long j, long j2) {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(null);
        C19406qI3.a("GDUUC", "created(" + j + Separators.RPAREN, new Object[0]);
        return AbstractC6459Nq2.o0(AbstractC6459Nq2.V(AbstractC6459Nq2.s0(interfaceC9336Zm4A, new c(null, this, j, j2, interfaceC9336Zm4A)), this.b), this.c, InterfaceC16863lz6.a.b(InterfaceC16863lz6.a, 20000L, 0L, 2, null), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long g(b bVar) {
        if (j(bVar)) {
            return null;
        }
        return Long.valueOf(bVar.a() - System.currentTimeMillis());
    }

    private final HashMap h() {
        return (HashMap) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(b bVar) {
        return System.currentTimeMillis() + ((long) AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) >= bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap k() {
        return new HashMap();
    }

    public final InterfaceC4557Fq2 i(long j, long j2) {
        HashMap mapH = h();
        XV4 xv4 = new XV4(Long.valueOf(j), Long.valueOf(j2));
        Object objF = mapH.get(xv4);
        if (objF == null) {
            objF = f(j, j2);
            mapH.put(xv4, objF);
        }
        return (InterfaceC4557Fq2) objF;
    }
}
