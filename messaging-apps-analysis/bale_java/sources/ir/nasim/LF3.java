package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class LF3 {
    private final InterfaceC11621dJ7 a;

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
            return LF3.this.a(0L, this);
        }
    }

    public LF3(InterfaceC11621dJ7 interfaceC11621dJ7) {
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        this.a = interfaceC11621dJ7;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(long r11, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof ir.nasim.LF3.a
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.LF3$a r0 = (ir.nasim.LF3.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.LF3$a r0 = new ir.nasim.LF3$a
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.c
            java.lang.Object r8 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r0.e
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L44
            if (r1 == r2) goto L34
            if (r1 != r9) goto L2c
            ir.nasim.AbstractC10685c16.b(r13)
            goto L72
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L34:
            long r11 = r0.b
            java.lang.Object r1 = r0.a
            ir.nasim.LF3 r1 = (ir.nasim.LF3) r1
            ir.nasim.AbstractC10685c16.b(r13)
            ir.nasim.a16 r13 = (ir.nasim.C9475a16) r13
            java.lang.Object r13 = r13.l()
            goto L5c
        L44:
            ir.nasim.AbstractC10685c16.b(r13)
            ir.nasim.dJ7 r1 = r10.a
            r0.a = r10
            r0.b = r11
            r0.e = r2
            r4 = 0
            r6 = 2
            r7 = 0
            r2 = r11
            r5 = r0
            java.lang.Object r13 = ir.nasim.InterfaceC11621dJ7.q(r1, r2, r4, r5, r6, r7)
            if (r13 != r8) goto L5b
            return r8
        L5b:
            r1 = r10
        L5c:
            java.lang.Throwable r2 = ir.nasim.C9475a16.e(r13)
            r3 = 0
            if (r2 != 0) goto L75
            ir.nasim.rB7 r13 = (ir.nasim.C19938rB7) r13
            ir.nasim.dJ7 r13 = r1.a
            r0.a = r3
            r0.e = r9
            java.lang.Object r13 = r13.a(r11, r0)
            if (r13 != r8) goto L72
            return r8
        L72:
            r3 = r13
            ir.nasim.nI7 r3 = (ir.nasim.C17637nI7) r3
        L75:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LF3.a(long, ir.nasim.rm1):java.lang.Object");
    }
}
