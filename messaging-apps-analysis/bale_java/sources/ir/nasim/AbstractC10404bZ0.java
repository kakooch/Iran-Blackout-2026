package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC16756lo6;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ir.nasim.bZ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10404bZ0 {

    /* renamed from: ir.nasim.bZ0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        int e;
        int f;
        private /* synthetic */ Object g;
        final /* synthetic */ InterfaceC4557Fq2[] h;
        final /* synthetic */ SA2 i;
        final /* synthetic */ InterfaceC15796kB2 j;
        final /* synthetic */ InterfaceC4806Gq2 k;

        /* renamed from: ir.nasim.bZ0$a$a, reason: collision with other inner class name */
        static final class C0916a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2[] c;
            final /* synthetic */ int d;
            final /* synthetic */ AtomicInteger e;
            final /* synthetic */ InterfaceC17639nJ0 f;

            /* renamed from: ir.nasim.bZ0$a$a$a, reason: collision with other inner class name */
            static final class C0917a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC17639nJ0 a;
                final /* synthetic */ int b;

                /* renamed from: ir.nasim.bZ0$a$a$a$a, reason: collision with other inner class name */
                static final class C0918a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int c;

                    C0918a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.c |= RecyclerView.UNDEFINED_DURATION;
                        return C0917a.this.a(null, this);
                    }
                }

                C0917a(InterfaceC17639nJ0 interfaceC17639nJ0, int i) {
                    this.a = interfaceC17639nJ0;
                    this.b = i;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ir.nasim.AbstractC10404bZ0.a.C0916a.C0917a.C0918a
                        if (r0 == 0) goto L13
                        r0 = r8
                        ir.nasim.bZ0$a$a$a$a r0 = (ir.nasim.AbstractC10404bZ0.a.C0916a.C0917a.C0918a) r0
                        int r1 = r0.c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.c = r1
                        goto L18
                    L13:
                        ir.nasim.bZ0$a$a$a$a r0 = new ir.nasim.bZ0$a$a$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.c
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L38
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L56
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L4d
                    L38:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.nJ0 r8 = r6.a
                        ir.nasim.i63 r2 = new ir.nasim.i63
                        int r5 = r6.b
                        r2.<init>(r5, r7)
                        r0.c = r4
                        java.lang.Object r7 = r8.o(r2, r0)
                        if (r7 != r1) goto L4d
                        return r1
                    L4d:
                        r0.c = r3
                        java.lang.Object r7 = ir.nasim.AbstractC23846xc8.a(r0)
                        if (r7 != r1) goto L56
                        return r1
                    L56:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10404bZ0.a.C0916a.C0917a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0916a(InterfaceC4557Fq2[] interfaceC4557Fq2Arr, int i, AtomicInteger atomicInteger, InterfaceC17639nJ0 interfaceC17639nJ0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2Arr;
                this.d = i;
                this.e = atomicInteger;
                this.f = interfaceC17639nJ0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0916a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AtomicInteger atomicInteger;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                try {
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2[] interfaceC4557Fq2Arr = this.c;
                        int i2 = this.d;
                        InterfaceC4557Fq2 interfaceC4557Fq2 = interfaceC4557Fq2Arr[i2];
                        C0917a c0917a = new C0917a(this.f, i2);
                        this.b = 1;
                        if (interfaceC4557Fq2.b(c0917a, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    if (atomicInteger.decrementAndGet() == 0) {
                        InterfaceC16756lo6.a.a(this.f, null, 1, null);
                    }
                    return C19938rB7.a;
                } finally {
                    if (this.e.decrementAndGet() == 0) {
                        InterfaceC16756lo6.a.a(this.f, null, 1, null);
                    }
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0916a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC4557Fq2[] interfaceC4557Fq2Arr, SA2 sa2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = interfaceC4557Fq2Arr;
            this.i = sa2;
            this.j = interfaceC15796kB2;
            this.k = interfaceC4806Gq2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.h, this.i, this.j, this.k, interfaceC20295rm1);
            aVar.g = obj;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00bd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00ca A[LOOP:0: B:28:0x00ca->B:48:?, LOOP_START, PHI: r6 r10
          0x00ca: PHI (r6v6 int) = (r6v5 int), (r6v7 int) binds: [B:25:0x00c5, B:48:?] A[DONT_GENERATE, DONT_INLINE]
          0x00ca: PHI (r10v8 ir.nasim.i63) = (r10v7 ir.nasim.i63), (r10v21 ir.nasim.i63) binds: [B:25:0x00c5, B:48:?] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0135 -> B:45:0x0137). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instructions count: 314
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10404bZ0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC4557Fq2[] interfaceC4557Fq2Arr, SA2 sa2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = AbstractC5274Iq2.a(new a(interfaceC4557Fq2Arr, sa2, interfaceC15796kB2, interfaceC4806Gq2, null), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }
}
