package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.VS4;

/* renamed from: ir.nasim.Jp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C5499Jp2 {
    private final C5733Kp2 a = new C5733Kp2();
    private final InterfaceC19699qn4 b = AbstractC20899sn4.b(false, 1, null);
    private int c = -1;

    /* renamed from: ir.nasim.Jp2$a */
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
            return C5499Jp2.this.b(this);
        }
    }

    /* renamed from: ir.nasim.Jp2$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C5499Jp2.this.c(null, this);
        }
    }

    public final VS4.b a() {
        VS4 vs4 = (VS4) AbstractC15401jX0.s0(this.a.b());
        if (vs4 == null || !(vs4 instanceof VS4.b)) {
            return null;
        }
        VS4.b bVar = (VS4.b) vs4;
        if (bVar.h() == EnumC16433lG3.REFRESH) {
            return bVar;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof ir.nasim.C5499Jp2.a
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.Jp2$a r0 = (ir.nasim.C5499Jp2.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Jp2$a r0 = new ir.nasim.Jp2$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.b
            ir.nasim.qn4 r1 = (ir.nasim.InterfaceC19699qn4) r1
            java.lang.Object r0 = r0.a
            ir.nasim.Jp2 r0 = (ir.nasim.C5499Jp2) r0
            ir.nasim.AbstractC10685c16.b(r9)
            goto L4e
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3a:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.qn4 r9 = r8.b
            r0.a = r8
            r0.b = r9
            r0.e = r3
            java.lang.Object r0 = r9.a(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r8
            r1 = r9
        L4e:
            ir.nasim.Kp2 r9 = r0.a     // Catch: java.lang.Throwable -> L80
            java.util.List r9 = r9.b()     // Catch: java.lang.Throwable -> L80
            int r0 = r0.c     // Catch: java.lang.Throwable -> L80
            int r2 = r9.size()     // Catch: java.lang.Throwable -> L80
            int r0 = r0 - r2
            int r0 = r0 + r3
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch: java.lang.Throwable -> L80
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L80
            r3 = 10
            int r3 = ir.nasim.ZW0.x(r9, r3)     // Catch: java.lang.Throwable -> L80
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L80
            java.util.Iterator r9 = r9.iterator()     // Catch: java.lang.Throwable -> L80
            r3 = 0
        L6e:
            boolean r5 = r9.hasNext()     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L8f
            java.lang.Object r5 = r9.next()     // Catch: java.lang.Throwable -> L80
            int r6 = r3 + 1
            if (r3 >= 0) goto L82
            ir.nasim.ZW0.w()     // Catch: java.lang.Throwable -> L80
            goto L82
        L80:
            r9 = move-exception
            goto L93
        L82:
            ir.nasim.VS4 r5 = (ir.nasim.VS4) r5     // Catch: java.lang.Throwable -> L80
            ir.nasim.i63 r7 = new ir.nasim.i63     // Catch: java.lang.Throwable -> L80
            int r3 = r3 + r0
            r7.<init>(r3, r5)     // Catch: java.lang.Throwable -> L80
            r2.add(r7)     // Catch: java.lang.Throwable -> L80
            r3 = r6
            goto L6e
        L8f:
            r1.e(r4)
            return r2
        L93:
            r1.e(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5499Jp2.b(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(ir.nasim.C14555i63 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C5499Jp2.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Jp2$b r0 = (ir.nasim.C5499Jp2.b) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.Jp2$b r0 = new ir.nasim.Jp2$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.c
            ir.nasim.qn4 r6 = (ir.nasim.InterfaceC19699qn4) r6
            java.lang.Object r1 = r0.b
            ir.nasim.i63 r1 = (ir.nasim.C14555i63) r1
            java.lang.Object r0 = r0.a
            ir.nasim.Jp2 r0 = (ir.nasim.C5499Jp2) r0
            ir.nasim.AbstractC10685c16.b(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.qn4 r7 = r5.b
            r0.a = r5
            r0.b = r6
            r0.c = r7
            r0.f = r3
            java.lang.Object r0 = r7.a(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            int r1 = r6.c()     // Catch: java.lang.Throwable -> L6e
            r0.c = r1     // Catch: java.lang.Throwable -> L6e
            ir.nasim.Kp2 r0 = r0.a     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r6 = r6.d()     // Catch: java.lang.Throwable -> L6e
            ir.nasim.VS4 r6 = (ir.nasim.VS4) r6     // Catch: java.lang.Throwable -> L6e
            r0.a(r6)     // Catch: java.lang.Throwable -> L6e
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L6e
            r7.e(r4)
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        L6e:
            r6 = move-exception
            r7.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5499Jp2.c(ir.nasim.i63, ir.nasim.rm1):java.lang.Object");
    }
}
