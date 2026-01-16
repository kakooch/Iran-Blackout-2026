package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;

/* loaded from: classes2.dex */
public final class PC6 implements OC6, InterfaceC20315ro1, InterfaceC16756lo6 {
    private final InterfaceC16756lo6 a;
    private final /* synthetic */ InterfaceC20315ro1 b;

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return PC6.this.S(null, this);
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ HE0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(HE0 he0) {
            super(1);
            this.e = he0;
        }

        public final void a(Throwable th) {
            HE0 he0 = this.e;
            C9475a16.a aVar = C9475a16.b;
            he0.resumeWith(C9475a16.b(C19938rB7.a));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    public PC6(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC16756lo6 interfaceC16756lo6) {
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(interfaceC16756lo6, "channel");
        this.a = interfaceC16756lo6;
        this.b = interfaceC20315ro1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.OC6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object S(ir.nasim.SA2 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.PC6.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.PC6$a r0 = (ir.nasim.PC6.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.PC6$a r0 = new ir.nasim.PC6$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.b
            ir.nasim.gj3 r6 = (ir.nasim.InterfaceC13730gj3) r6
            java.lang.Object r6 = r0.a
            ir.nasim.SA2 r6 = (ir.nasim.SA2) r6
            ir.nasim.AbstractC10685c16.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L76
        L31:
            r7 = move-exception
            goto L88
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.do1 r7 = r5.getCoroutineContext()     // Catch: java.lang.Throwable -> L31
            ir.nasim.gj3$b r2 = ir.nasim.InterfaceC13730gj3.n0     // Catch: java.lang.Throwable -> L31
            ir.nasim.do1$b r7 = r7.a(r2)     // Catch: java.lang.Throwable -> L31
            if (r7 == 0) goto L7c
            ir.nasim.gj3 r7 = (ir.nasim.InterfaceC13730gj3) r7     // Catch: java.lang.Throwable -> L31
            r0.a = r6     // Catch: java.lang.Throwable -> L31
            r0.b = r7     // Catch: java.lang.Throwable -> L31
            r0.e = r3     // Catch: java.lang.Throwable -> L31
            ir.nasim.IE0 r2 = new ir.nasim.IE0     // Catch: java.lang.Throwable -> L31
            ir.nasim.rm1 r4 = ir.nasim.AbstractC13660gc3.c(r0)     // Catch: java.lang.Throwable -> L31
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L31
            r2.w()     // Catch: java.lang.Throwable -> L31
            ir.nasim.PC6$b r3 = new ir.nasim.PC6$b     // Catch: java.lang.Throwable -> L31
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L31
            r7.s(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.Object r7 = r2.t()     // Catch: java.lang.Throwable -> L31
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()     // Catch: java.lang.Throwable -> L31
            if (r7 != r2) goto L73
            ir.nasim.WA1.c(r0)     // Catch: java.lang.Throwable -> L31
        L73:
            if (r7 != r1) goto L76
            return r1
        L76:
            r6.invoke()
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        L7c:
            java.lang.String r7 = "Internal error, context should have a job."
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L31
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L31
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L31
            throw r0     // Catch: java.lang.Throwable -> L31
        L88:
            r6.invoke()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PC6.S(ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC20315ro1
    public InterfaceC11938do1 getCoroutineContext() {
        return this.b.getCoroutineContext();
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public Object h(Object obj) {
        return this.a.h(obj);
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public Object o(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.o(obj, interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public boolean w(Throwable th) {
        return this.a.w(th);
    }
}
