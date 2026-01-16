package ir.nasim;

import java.util.List;

/* loaded from: classes8.dex */
final class PK6 implements InterfaceC16863lz6 {
    private final long b;
    private final long c;

    static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x008d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r9.b
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L3c
                if (r1 == r6) goto L38
                if (r1 == r5) goto L30
                if (r1 == r4) goto L28
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                goto L38
            L18:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L20:
                java.lang.Object r1 = r9.c
                ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                ir.nasim.AbstractC10685c16.b(r10)
                goto L8e
            L28:
                java.lang.Object r1 = r9.c
                ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                ir.nasim.AbstractC10685c16.b(r10)
                goto L7d
            L30:
                java.lang.Object r1 = r9.c
                ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                ir.nasim.AbstractC10685c16.b(r10)
                goto L64
            L38:
                ir.nasim.AbstractC10685c16.b(r10)
                goto L9c
            L3c:
                ir.nasim.AbstractC10685c16.b(r10)
                java.lang.Object r10 = r9.c
                r1 = r10
                ir.nasim.Gq2 r1 = (ir.nasim.InterfaceC4806Gq2) r1
                int r10 = r9.d
                if (r10 <= 0) goto L53
                ir.nasim.iz6 r10 = ir.nasim.EnumC15090iz6.START
                r9.b = r6
                java.lang.Object r10 = r1.a(r10, r9)
                if (r10 != r0) goto L9c
                return r0
            L53:
                ir.nasim.PK6 r10 = ir.nasim.PK6.this
                long r6 = ir.nasim.PK6.c(r10)
                r9.c = r1
                r9.b = r5
                java.lang.Object r10 = ir.nasim.HG1.b(r6, r9)
                if (r10 != r0) goto L64
                return r0
            L64:
                ir.nasim.PK6 r10 = ir.nasim.PK6.this
                long r5 = ir.nasim.PK6.b(r10)
                r7 = 0
                int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r10 <= 0) goto L8e
                ir.nasim.iz6 r10 = ir.nasim.EnumC15090iz6.STOP
                r9.c = r1
                r9.b = r4
                java.lang.Object r10 = r1.a(r10, r9)
                if (r10 != r0) goto L7d
                return r0
            L7d:
                ir.nasim.PK6 r10 = ir.nasim.PK6.this
                long r4 = ir.nasim.PK6.b(r10)
                r9.c = r1
                r9.b = r3
                java.lang.Object r10 = ir.nasim.HG1.b(r4, r9)
                if (r10 != r0) goto L8e
                return r0
            L8e:
                ir.nasim.iz6 r10 = ir.nasim.EnumC15090iz6.STOP_AND_RESET_REPLAY_CACHE
                r3 = 0
                r9.c = r3
                r9.b = r2
                java.lang.Object r10 = r1.a(r10, r9)
                if (r10 != r0) goto L9c
                return r0
            L9c:
                ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PK6.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object n(InterfaceC4806Gq2 interfaceC4806Gq2, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = PK6.this.new a(interfaceC20295rm1);
            aVar.c = interfaceC4806Gq2;
            aVar.d = i;
            return aVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC4806Gq2) obj, ((Number) obj2).intValue(), (InterfaceC20295rm1) obj3);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(((EnumC15090iz6) this.c) != EnumC15090iz6.START);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EnumC15090iz6 enumC15090iz6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(enumC15090iz6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public PK6(long j, long j2) {
        this.b = j;
        this.c = j2;
        if (j < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
        }
        if (j2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
    }

    @Override // ir.nasim.InterfaceC16863lz6
    public InterfaceC4557Fq2 a(InterfaceC10258bL6 interfaceC10258bL6) {
        return AbstractC6459Nq2.v(AbstractC6459Nq2.z(AbstractC6459Nq2.s0(interfaceC10258bL6, new a(null)), new b(null)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof PK6) {
            PK6 pk6 = (PK6) obj;
            if (this.b == pk6.b && this.c == pk6.c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.b) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        List listD = AbstractC9766aX0.d(2);
        if (this.b > 0) {
            listD.add("stopTimeout=" + this.b + "ms");
        }
        if (this.c < Long.MAX_VALUE) {
            listD.add("replayExpiration=" + this.c + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + AbstractC15401jX0.A0(AbstractC9766aX0.a(listD), null, null, null, 0, null, null, 63, null) + ')';
    }
}
