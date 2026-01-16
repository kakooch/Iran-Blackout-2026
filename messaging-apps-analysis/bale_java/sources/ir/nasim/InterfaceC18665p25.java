package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.p25, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC18665p25 {

    /* renamed from: ir.nasim.p25$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return InterfaceC18665p25.b(InterfaceC18665p25.this, 0L, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object b(ir.nasim.InterfaceC18665p25 r20, long r21, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            r0 = r20
            r1 = r21
            r3 = r23
            boolean r4 = r3 instanceof ir.nasim.InterfaceC18665p25.a
            if (r4 == 0) goto L19
            r4 = r3
            ir.nasim.p25$a r4 = (ir.nasim.InterfaceC18665p25.a) r4
            int r5 = r4.e
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L19
            int r5 = r5 - r6
            r4.e = r5
            goto L1e
        L19:
            ir.nasim.p25$a r4 = new ir.nasim.p25$a
            r4.<init>(r3)
        L1e:
            java.lang.Object r3 = r4.c
            java.lang.Object r5 = ir.nasim.AbstractC13660gc3.e()
            int r6 = r4.e
            r7 = 2
            r8 = 1
            if (r6 == 0) goto L46
            if (r6 == r8) goto L3a
            if (r6 != r7) goto L32
            ir.nasim.AbstractC10685c16.b(r3)
            goto L87
        L32:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3a:
            long r0 = r4.b
            java.lang.Object r2 = r4.a
            ir.nasim.p25 r2 = (ir.nasim.InterfaceC18665p25) r2
            ir.nasim.AbstractC10685c16.b(r3)
            r10 = r0
            r0 = r2
            goto L57
        L46:
            ir.nasim.AbstractC10685c16.b(r3)
            r4.a = r0
            r4.b = r1
            r4.e = r8
            java.lang.Object r3 = r0.e(r1, r4)
            if (r3 != r5) goto L56
            return r5
        L56:
            r10 = r1
        L57:
            r12 = r3
            ir.nasim.r25 r12 = (ir.nasim.C19847r25) r12
            if (r12 != 0) goto L68
            ir.nasim.r25 r1 = new ir.nasim.r25
            r14 = 1
            r15 = 0
            r9 = 0
            r12 = 1
            r8 = r1
            r8.<init>(r9, r10, r12, r14, r15)
            goto L7b
        L68:
            long r1 = r12.c()
            r8 = 1
            long r16 = r1 + r8
            r18 = 3
            r19 = 0
            r13 = 0
            r14 = 0
            ir.nasim.r25 r1 = ir.nasim.C19847r25.b(r12, r13, r14, r16, r18, r19)
        L7b:
            r2 = 0
            r4.a = r2
            r4.e = r7
            java.lang.Object r0 = r0.a(r1, r4)
            if (r0 != r5) goto L87
            return r5
        L87:
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.InterfaceC18665p25.b(ir.nasim.p25, long, ir.nasim.rm1):java.lang.Object");
    }

    Object a(C19847r25 c19847r25, InterfaceC20295rm1 interfaceC20295rm1);

    default Object c(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        return b(this, j, interfaceC20295rm1);
    }

    Object d(InterfaceC20295rm1 interfaceC20295rm1);

    Object e(long j, InterfaceC20295rm1 interfaceC20295rm1);
}
