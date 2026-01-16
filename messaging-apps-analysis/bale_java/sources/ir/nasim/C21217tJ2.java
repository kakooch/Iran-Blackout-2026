package ir.nasim;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.tJ2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21217tJ2 {
    public static final C21217tJ2 a = new C21217tJ2();
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean c = new AtomicBoolean(false);
    public static final int d = 8;

    /* renamed from: ir.nasim.tJ2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ InterfaceC17639nJ0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC17639nJ0 interfaceC17639nJ0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC17639nJ0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0040 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:6:0x0013, B:17:0x0038, B:19:0x0040, B:14:0x002b, B:20:0x0054, B:13:0x0026), top: B:27:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0054 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:6:0x0013, B:17:0x0038, B:19:0x0040, B:14:0x002b, B:20:0x0054, B:13:0x0026), top: B:27:0x0007 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0035 -> B:17:0x0038). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.d
                r2 = 1
                if (r1 == 0) goto L21
                if (r1 != r2) goto L19
                java.lang.Object r1 = r5.c
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                java.lang.Object r3 = r5.b
                ir.nasim.VI5 r3 = (ir.nasim.VI5) r3
                ir.nasim.AbstractC10685c16.b(r6)     // Catch: java.lang.Throwable -> L17
                goto L38
            L17:
                r6 = move-exception
                goto L5d
            L19:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L21:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.nJ0 r3 = r5.e
                ir.nasim.CJ0 r6 = r3.iterator()     // Catch: java.lang.Throwable -> L17
                r1 = r6
            L2b:
                r5.b = r3     // Catch: java.lang.Throwable -> L17
                r5.c = r1     // Catch: java.lang.Throwable -> L17
                r5.d = r2     // Catch: java.lang.Throwable -> L17
                java.lang.Object r6 = r1.a(r5)     // Catch: java.lang.Throwable -> L17
                if (r6 != r0) goto L38
                return r0
            L38:
                java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: java.lang.Throwable -> L17
                boolean r6 = r6.booleanValue()     // Catch: java.lang.Throwable -> L17
                if (r6 == 0) goto L54
                java.lang.Object r6 = r1.next()     // Catch: java.lang.Throwable -> L17
                ir.nasim.rB7 r6 = (ir.nasim.C19938rB7) r6     // Catch: java.lang.Throwable -> L17
                java.util.concurrent.atomic.AtomicBoolean r6 = ir.nasim.C21217tJ2.a()     // Catch: java.lang.Throwable -> L17
                r4 = 0
                r6.set(r4)     // Catch: java.lang.Throwable -> L17
                androidx.compose.runtime.snapshots.g$a r6 = androidx.compose.runtime.snapshots.g.e     // Catch: java.lang.Throwable -> L17
                r6.m()     // Catch: java.lang.Throwable -> L17
                goto L2b
            L54:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L17
                r6 = 0
                ir.nasim.QJ0.a(r3, r6)
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            L5d:
                throw r6     // Catch: java.lang.Throwable -> L5e
            L5e:
                r0 = move-exception
                ir.nasim.QJ0.a(r3, r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21217tJ2.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tJ2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC17639nJ0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC17639nJ0 interfaceC17639nJ0) {
            super(1);
            this.e = interfaceC17639nJ0;
        }

        public final void a(Object obj) {
            if (C21217tJ2.c.compareAndSet(false, true)) {
                this.e.h(C19938rB7.a);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    private C21217tJ2() {
    }

    public final void b() {
        if (b.compareAndSet(false, true)) {
            InterfaceC17639nJ0 interfaceC17639nJ0B = DJ0.b(1, null, null, 6, null);
            AbstractC10533bm0.d(AbstractC20906so1.a(C20343rr.m.b()), null, null, new a(interfaceC17639nJ0B, null), 3, null);
            androidx.compose.runtime.snapshots.g.e.j(new b(interfaceC17639nJ0B));
        }
    }
}
