package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Pq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC6942Pq2 {

    /* renamed from: ir.nasim.Pq2$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        boolean d;
        /* synthetic */ Object e;
        int f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC6942Pq2.d(null, null, false, this);
        }
    }

    public static final InterfaceC4557Fq2 b(VI5 vi5) {
        return new C18821pJ0(vi5, true, null, 0, null, 28, null);
    }

    public static final Object c(InterfaceC4806Gq2 interfaceC4806Gq2, VI5 vi5, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = d(interfaceC4806Gq2, vi5, true, interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0036, B:24:0x0062, B:28:0x0077, B:30:0x007f, B:20:0x0054, B:23:0x005e), top: B:42:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0091 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(ir.nasim.InterfaceC4806Gq2 r6, ir.nasim.VI5 r7, boolean r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            boolean r0 = r9 instanceof ir.nasim.AbstractC6942Pq2.a
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.Pq2$a r0 = (ir.nasim.AbstractC6942Pq2.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.Pq2$a r0 = new ir.nasim.Pq2$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            boolean r8 = r0.d
            java.lang.Object r6 = r0.c
            ir.nasim.CJ0 r6 = (ir.nasim.CJ0) r6
            java.lang.Object r7 = r0.b
            ir.nasim.VI5 r7 = (ir.nasim.VI5) r7
            java.lang.Object r2 = r0.a
            ir.nasim.Gq2 r2 = (ir.nasim.InterfaceC4806Gq2) r2
            ir.nasim.AbstractC10685c16.b(r9)     // Catch: java.lang.Throwable -> L3c
        L39:
            r9 = r6
            r6 = r2
            goto L62
        L3c:
            r6 = move-exception
            goto L9d
        L3e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L46:
            boolean r8 = r0.d
            java.lang.Object r6 = r0.c
            ir.nasim.CJ0 r6 = (ir.nasim.CJ0) r6
            java.lang.Object r7 = r0.b
            ir.nasim.VI5 r7 = (ir.nasim.VI5) r7
            java.lang.Object r2 = r0.a
            ir.nasim.Gq2 r2 = (ir.nasim.InterfaceC4806Gq2) r2
            ir.nasim.AbstractC10685c16.b(r9)     // Catch: java.lang.Throwable -> L3c
            goto L77
        L58:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.AbstractC6459Nq2.D(r6)
            ir.nasim.CJ0 r9 = r7.iterator()     // Catch: java.lang.Throwable -> L3c
        L62:
            r0.a = r6     // Catch: java.lang.Throwable -> L3c
            r0.b = r7     // Catch: java.lang.Throwable -> L3c
            r0.c = r9     // Catch: java.lang.Throwable -> L3c
            r0.d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r9.a(r0)     // Catch: java.lang.Throwable -> L3c
            if (r2 != r1) goto L73
            return r1
        L73:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L77:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3c
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3c
            if (r9 == 0) goto L94
            java.lang.Object r9 = r6.next()     // Catch: java.lang.Throwable -> L3c
            r0.a = r2     // Catch: java.lang.Throwable -> L3c
            r0.b = r7     // Catch: java.lang.Throwable -> L3c
            r0.c = r6     // Catch: java.lang.Throwable -> L3c
            r0.d = r8     // Catch: java.lang.Throwable -> L3c
            r0.f = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r9 = r2.a(r9, r0)     // Catch: java.lang.Throwable -> L3c
            if (r9 != r1) goto L39
            return r1
        L94:
            if (r8 == 0) goto L9a
            r6 = 0
            ir.nasim.QJ0.a(r7, r6)
        L9a:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        L9d:
            throw r6     // Catch: java.lang.Throwable -> L9e
        L9e:
            r9 = move-exception
            if (r8 == 0) goto La4
            ir.nasim.QJ0.a(r7, r6)
        La4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6942Pq2.d(ir.nasim.Gq2, ir.nasim.VI5, boolean, ir.nasim.rm1):java.lang.Object");
    }

    public static final VI5 e(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC21889uJ0.b(interfaceC4557Fq2).p(interfaceC20315ro1);
    }

    public static final InterfaceC4557Fq2 f(VI5 vi5) {
        return new C18821pJ0(vi5, false, null, 0, null, 28, null);
    }
}
