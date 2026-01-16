package androidx.lifecycle;

import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC17933no1;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.C18712p72;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC16204ks5;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.QC3;
import ir.nasim.QG4;
import ir.nasim.TI;

/* renamed from: androidx.lifecycle.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1970f {

    /* renamed from: androidx.lifecycle.f$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ r d;

        /* renamed from: androidx.lifecycle.f$a$a, reason: collision with other inner class name */
        static final class C0091a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ r c;
            final /* synthetic */ QG4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0091a(r rVar, QG4 qg4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = rVar;
                this.d = qg4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0091a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.k(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0091a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: androidx.lifecycle.f$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ r c;
            final /* synthetic */ QG4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(r rVar, QG4 qg4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = rVar;
                this.d = qg4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.k(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: androidx.lifecycle.f$a$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ r c;
            final /* synthetic */ QG4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(r rVar, QG4 qg4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = rVar;
                this.d = qg4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.o(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(r rVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = rVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(InterfaceC16204ks5 interfaceC16204ks5, Object obj) {
            interfaceC16204ks5.h(obj);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:28:0x008a A[RETURN] */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [ir.nasim.QG4] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v6 */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r9.b
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r1 == 0) goto L40
                if (r1 == r5) goto L38
                if (r1 == r4) goto L30
                if (r1 == r3) goto L26
                if (r1 == r2) goto L1d
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1d:
                java.lang.Object r0 = r9.c
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                ir.nasim.AbstractC10685c16.b(r10)
                goto Lb2
            L26:
                java.lang.Object r1 = r9.c
                ir.nasim.QG4 r1 = (ir.nasim.QG4) r1
                ir.nasim.AbstractC10685c16.b(r10)     // Catch: java.lang.Throwable -> L2e
                goto L8b
            L2e:
                r10 = move-exception
                goto L91
            L30:
                java.lang.Object r1 = r9.c
                ir.nasim.QG4 r1 = (ir.nasim.QG4) r1
                ir.nasim.AbstractC10685c16.b(r10)     // Catch: java.lang.Throwable -> L2e
                goto L80
            L38:
                java.lang.Object r1 = r9.c
                ir.nasim.QG4 r1 = (ir.nasim.QG4) r1
                ir.nasim.AbstractC10685c16.b(r10)
                goto L66
            L40:
                ir.nasim.AbstractC10685c16.b(r10)
                java.lang.Object r10 = r9.c
                ir.nasim.ks5 r10 = (ir.nasim.InterfaceC16204ks5) r10
                androidx.lifecycle.e r1 = new androidx.lifecycle.e
                r1.<init>()
                ir.nasim.WM3 r10 = ir.nasim.C12366eV1.c()
                ir.nasim.WM3 r10 = r10.F0()
                androidx.lifecycle.f$a$a r7 = new androidx.lifecycle.f$a$a
                androidx.lifecycle.r r8 = r9.d
                r7.<init>(r8, r1, r6)
                r9.c = r1
                r9.b = r5
                java.lang.Object r10 = ir.nasim.AbstractC9323Zl0.g(r10, r7, r9)
                if (r10 != r0) goto L66
                return r0
            L66:
                ir.nasim.WM3 r10 = ir.nasim.C12366eV1.c()     // Catch: java.lang.Throwable -> L2e
                ir.nasim.WM3 r10 = r10.F0()     // Catch: java.lang.Throwable -> L2e
                androidx.lifecycle.f$a$b r5 = new androidx.lifecycle.f$a$b     // Catch: java.lang.Throwable -> L2e
                androidx.lifecycle.r r7 = r9.d     // Catch: java.lang.Throwable -> L2e
                r5.<init>(r7, r1, r6)     // Catch: java.lang.Throwable -> L2e
                r9.c = r1     // Catch: java.lang.Throwable -> L2e
                r9.b = r4     // Catch: java.lang.Throwable -> L2e
                java.lang.Object r10 = ir.nasim.AbstractC9323Zl0.g(r10, r5, r9)     // Catch: java.lang.Throwable -> L2e
                if (r10 != r0) goto L80
                return r0
            L80:
                r9.c = r1     // Catch: java.lang.Throwable -> L2e
                r9.b = r3     // Catch: java.lang.Throwable -> L2e
                java.lang.Object r10 = ir.nasim.HG1.a(r9)     // Catch: java.lang.Throwable -> L2e
                if (r10 != r0) goto L8b
                return r0
            L8b:
                kotlin.KotlinNothingValueException r10 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L2e
                r10.<init>()     // Catch: java.lang.Throwable -> L2e
                throw r10     // Catch: java.lang.Throwable -> L2e
            L91:
                ir.nasim.WM3 r3 = ir.nasim.C12366eV1.c()
                ir.nasim.WM3 r3 = r3.F0()
                ir.nasim.fB4 r4 = ir.nasim.C12798fB4.b
                ir.nasim.do1 r3 = r3.X(r4)
                androidx.lifecycle.f$a$c r4 = new androidx.lifecycle.f$a$c
                androidx.lifecycle.r r5 = r9.d
                r4.<init>(r5, r1, r6)
                r9.c = r10
                r9.b = r2
                java.lang.Object r1 = ir.nasim.AbstractC9323Zl0.g(r3, r4, r9)
                if (r1 != r0) goto Lb1
                return r0
            Lb1:
                r0 = r10
            Lb2:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.AbstractC1970f.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: androidx.lifecycle.f$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC4557Fq2 d;

        /* renamed from: androidx.lifecycle.f$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ QC3 a;

            a(QC3 qc3) {
                this.a = qc3;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objA = this.a.a(obj, interfaceC20295rm1);
                return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC4557Fq2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                QC3 qc3 = (QC3) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
                a aVar = new a(qc3);
                this.b = 1;
                if (interfaceC4557Fq2.b(aVar, this) == objE) {
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
        public final Object invoke(QC3 qc3, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(qc3, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC4557Fq2 a(r rVar) {
        AbstractC13042fc3.i(rVar, "<this>");
        return AbstractC6459Nq2.q(AbstractC6459Nq2.f(new a(rVar, null)));
    }

    public static final r b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11938do1 interfaceC11938do1, long j) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "<this>");
        AbstractC13042fc3.i(interfaceC11938do1, "context");
        r rVarA = AbstractC17933no1.a(interfaceC11938do1, j, new b(interfaceC4557Fq2, null));
        if (interfaceC4557Fq2 instanceof InterfaceC10258bL6) {
            if (TI.g().b()) {
                rVarA.p(((InterfaceC10258bL6) interfaceC4557Fq2).getValue());
            } else {
                rVarA.n(((InterfaceC10258bL6) interfaceC4557Fq2).getValue());
            }
        }
        return rVarA;
    }

    public static /* synthetic */ r c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11938do1 interfaceC11938do1, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return b(interfaceC4557Fq2, interfaceC11938do1, j);
    }
}
