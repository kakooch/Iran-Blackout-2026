package ir.nasim;

/* loaded from: classes8.dex */
public abstract class UU1 {
    private static final C14539i47 a = new C14539i47("UNDEFINED");
    public static final C14539i47 b = new C14539i47("REUSABLE_CLAIMED");

    /* JADX WARN: Removed duplicated region for block: B:27:0x008f A[Catch: all -> 0x0068, DONT_GENERATE, TryCatch #0 {all -> 0x0068, blocks: (B:11:0x003f, B:13:0x004d, B:15:0x0053, B:28:0x0092, B:18:0x006a, B:20:0x007a, B:25:0x0089, B:27:0x008f, B:33:0x009f, B:36:0x00a8, B:35:0x00a5, B:23:0x0080), top: B:44:0x003f, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ir.nasim.InterfaceC20295rm1 r6, java.lang.Object r7, ir.nasim.UA2 r8) {
        /*
            boolean r0 = r6 instanceof ir.nasim.TU1
            if (r0 == 0) goto Lb2
            ir.nasim.TU1 r6 = (ir.nasim.TU1) r6
            java.lang.Object r8 = ir.nasim.E01.c(r7, r8)
            ir.nasim.go1 r0 = r6.d
            ir.nasim.do1 r1 = r6.getContext()
            boolean r0 = r0.A0(r1)
            r1 = 1
            if (r0 == 0) goto L26
            r6.f = r8
            r6.c = r1
            ir.nasim.go1 r7 = r6.d
            ir.nasim.do1 r8 = r6.getContext()
            r7.x0(r8, r6)
            goto Lb5
        L26:
            ir.nasim.Wo7 r0 = ir.nasim.C8582Wo7.a
            ir.nasim.Xa2 r0 = r0.b()
            boolean r2 = r0.Q0()
            if (r2 == 0) goto L3b
            r6.f = r8
            r6.c = r1
            r0.I0(r6)
            goto Lb5
        L3b:
            r0.L0(r1)
            r2 = 0
            ir.nasim.do1 r3 = r6.getContext()     // Catch: java.lang.Throwable -> L68
            ir.nasim.gj3$b r4 = ir.nasim.InterfaceC13730gj3.n0     // Catch: java.lang.Throwable -> L68
            ir.nasim.do1$b r3 = r3.a(r4)     // Catch: java.lang.Throwable -> L68
            ir.nasim.gj3 r3 = (ir.nasim.InterfaceC13730gj3) r3     // Catch: java.lang.Throwable -> L68
            if (r3 == 0) goto L6a
            boolean r4 = r3.b()     // Catch: java.lang.Throwable -> L68
            if (r4 != 0) goto L6a
            java.util.concurrent.CancellationException r7 = r3.q()     // Catch: java.lang.Throwable -> L68
            r6.a(r8, r7)     // Catch: java.lang.Throwable -> L68
            ir.nasim.a16$a r8 = ir.nasim.C9475a16.b     // Catch: java.lang.Throwable -> L68
            java.lang.Object r7 = ir.nasim.AbstractC10685c16.a(r7)     // Catch: java.lang.Throwable -> L68
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)     // Catch: java.lang.Throwable -> L68
            r6.resumeWith(r7)     // Catch: java.lang.Throwable -> L68
            goto L92
        L68:
            r7 = move-exception
            goto La9
        L6a:
            ir.nasim.rm1 r8 = r6.e     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = r6.g     // Catch: java.lang.Throwable -> L68
            ir.nasim.do1 r4 = r8.getContext()     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = ir.nasim.AbstractC7173Qo7.c(r4, r3)     // Catch: java.lang.Throwable -> L68
            ir.nasim.i47 r5 = ir.nasim.AbstractC7173Qo7.a     // Catch: java.lang.Throwable -> L68
            if (r3 == r5) goto L7f
            ir.nasim.fB7 r8 = ir.nasim.AbstractC12551eo1.g(r8, r4, r3)     // Catch: java.lang.Throwable -> L68
            goto L80
        L7f:
            r8 = r2
        L80:
            ir.nasim.rm1 r5 = r6.e     // Catch: java.lang.Throwable -> L9c
            r5.resumeWith(r7)     // Catch: java.lang.Throwable -> L9c
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L9c
            if (r8 == 0) goto L8f
            boolean r7 = r8.h1()     // Catch: java.lang.Throwable -> L68
            if (r7 == 0) goto L92
        L8f:
            ir.nasim.AbstractC7173Qo7.a(r4, r3)     // Catch: java.lang.Throwable -> L68
        L92:
            boolean r7 = r0.W0()     // Catch: java.lang.Throwable -> L68
            if (r7 != 0) goto L92
        L98:
            r0.C0(r1)
            goto Lb5
        L9c:
            r7 = move-exception
            if (r8 == 0) goto La5
            boolean r8 = r8.h1()     // Catch: java.lang.Throwable -> L68
            if (r8 == 0) goto La8
        La5:
            ir.nasim.AbstractC7173Qo7.a(r4, r3)     // Catch: java.lang.Throwable -> L68
        La8:
            throw r7     // Catch: java.lang.Throwable -> L68
        La9:
            r6.g(r7, r2)     // Catch: java.lang.Throwable -> Lad
            goto L98
        Lad:
            r6 = move-exception
            r0.C0(r1)
            throw r6
        Lb2:
            r6.resumeWith(r7)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UU1.b(ir.nasim.rm1, java.lang.Object, ir.nasim.UA2):void");
    }

    public static /* synthetic */ void c(InterfaceC20295rm1 interfaceC20295rm1, Object obj, UA2 ua2, int i, Object obj2) {
        if ((i & 2) != 0) {
            ua2 = null;
        }
        b(interfaceC20295rm1, obj, ua2);
    }

    public static final boolean d(TU1 tu1) {
        C19938rB7 c19938rB7 = C19938rB7.a;
        AbstractC8717Xa2 abstractC8717Xa2B = C8582Wo7.a.b();
        if (abstractC8717Xa2B.R0()) {
            return false;
        }
        if (abstractC8717Xa2B.Q0()) {
            tu1.f = c19938rB7;
            tu1.c = 1;
            abstractC8717Xa2B.I0(tu1);
            return true;
        }
        abstractC8717Xa2B.L0(true);
        try {
            tu1.run();
            do {
            } while (abstractC8717Xa2B.W0());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
