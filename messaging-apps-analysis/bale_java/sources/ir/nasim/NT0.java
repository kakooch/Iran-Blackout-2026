package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.MX1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class NT0 {
    public static final a h = new a(null);
    private static final BX1 i = BX1.b;
    private final MX1.a a;
    private final InterfaceC20887sm2 b;
    private String c;
    private BX1 d;
    private final InterfaceC19699qn4 e;
    private HashSet f;
    private List g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
        NT0 a(MX1.a aVar);
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return NT0.this.a(null, this);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return NT0.this.b(this);
        }
    }

    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return NT0.this.e(null, this);
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return NT0.this.g(null, this);
        }
    }

    public NT0(MX1.a aVar, InterfaceC20887sm2 interfaceC20887sm2) {
        AbstractC13042fc3.i(aVar, "input");
        AbstractC13042fc3.i(interfaceC20887sm2, "fileSystemDataSource");
        this.a = aVar;
        this.b = interfaceC20887sm2;
        this.e = AbstractC20899sn4.b(false, 1, null);
    }

    private final List c(AX1 ax1) {
        BX1 bx1 = this.d;
        if (bx1 == null) {
            AbstractC13042fc3.y("minChunkSize");
            bx1 = null;
        }
        int iP = bx1.p();
        int iA = ax1.a();
        int iB = ax1.b();
        if (iA % iP != 0) {
            return null;
        }
        int i2 = iB + 1;
        if (i2 % iP != 0 && i2 != ((int) this.a.b())) {
            return null;
        }
        int iCeil = (int) Math.ceil(((ax1.c() - ax1.d()) + 1) / iP);
        ArrayList arrayList = new ArrayList(iCeil);
        for (int i3 = 0; i3 < iCeil; i3++) {
            arrayList.add(Integer.valueOf((iA / iP) + i3));
        }
        return arrayList;
    }

    private final XV4 d(BX1 bx1) {
        List list = this.g;
        XV4 xv4A = null;
        if (list == null) {
            AbstractC13042fc3.y("remainingChunkIndices");
            list = null;
        }
        if (list.isEmpty()) {
            return null;
        }
        int iP = bx1.p();
        BX1 bx12 = this.d;
        if (bx12 == null) {
            AbstractC13042fc3.y("minChunkSize");
            bx12 = null;
        }
        int iP2 = iP / bx12.p();
        List list2 = this.g;
        if (list2 == null) {
            AbstractC13042fc3.y("remainingChunkIndices");
            list2 = null;
        }
        int iIntValue = ((Number) AbstractC15401jX0.q0(list2)).intValue();
        List list3 = this.g;
        if (list3 == null) {
            AbstractC13042fc3.y("remainingChunkIndices");
            list3 = null;
        }
        Iterator it = list3.iterator();
        Integer numValueOf = null;
        while (it.hasNext()) {
            int iIntValue2 = ((Number) it.next()).intValue();
            if (numValueOf == null || numValueOf.intValue() + 1 == iIntValue2) {
                int i2 = iIntValue2 - iIntValue;
                if (i2 + 1 == iP2) {
                    return AbstractC4616Fw7.a(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
                }
                if (xv4A == null) {
                    xv4A = AbstractC4616Fw7.a(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
                } else if (((Number) xv4A.f()).intValue() - ((Number) xv4A.e()).intValue() < i2) {
                    xv4A = AbstractC4616Fw7.a(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
                }
            } else {
                iIntValue = iIntValue2;
            }
            numValueOf = Integer.valueOf(iIntValue2);
        }
        return xv4A;
    }

    private final void f(int i2, int i3) {
        List list;
        List list2 = this.g;
        if (list2 == null) {
            AbstractC13042fc3.y("remainingChunkIndices");
            list = null;
        } else {
            list = list2;
        }
        int iL = AbstractC10360bX0.l(list, Integer.valueOf(i2), 0, 0, 6, null);
        if (i2 > i3) {
            return;
        }
        while (true) {
            List list3 = this.g;
            if (list3 == null) {
                AbstractC13042fc3.y("remainingChunkIndices");
                list3 = null;
            }
            list3.remove(iL);
            if (i2 == i3) {
                return;
            } else {
                i2++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ir.nasim.AX1 r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.NT0.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.NT0$c r0 = (ir.nasim.NT0.c) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.NT0$c r0 = new ir.nasim.NT0$c
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
            ir.nasim.AX1 r1 = (ir.nasim.AX1) r1
            java.lang.Object r0 = r0.a
            ir.nasim.NT0 r0 = (ir.nasim.NT0) r0
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
            ir.nasim.qn4 r7 = r5.e
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
            java.util.List r6 = r0.c(r6)     // Catch: java.lang.Throwable -> L67
            if (r6 != 0) goto L5c
            goto L97
        L5c:
            java.util.HashSet r1 = r0.f     // Catch: java.lang.Throwable -> L67
            java.lang.String r2 = "pendingChunkIndices"
            if (r1 != 0) goto L69
            ir.nasim.AbstractC13042fc3.y(r2)     // Catch: java.lang.Throwable -> L67
            r1 = r4
            goto L69
        L67:
            r6 = move-exception
            goto L9d
        L69:
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch: java.lang.Throwable -> L67
            java.util.Set r6 = ir.nasim.ZW0.r1(r6)     // Catch: java.lang.Throwable -> L67
            java.util.Collection r6 = (java.util.Collection) r6     // Catch: java.lang.Throwable -> L67
            r1.removeAll(r6)     // Catch: java.lang.Throwable -> L67
            java.util.List r6 = r0.g     // Catch: java.lang.Throwable -> L67
            if (r6 != 0) goto L7e
            java.lang.String r6 = "remainingChunkIndices"
            ir.nasim.AbstractC13042fc3.y(r6)     // Catch: java.lang.Throwable -> L67
            r6 = r4
        L7e:
            java.util.Collection r6 = (java.util.Collection) r6     // Catch: java.lang.Throwable -> L67
            java.util.HashSet r0 = r0.f     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L88
            ir.nasim.AbstractC13042fc3.y(r2)     // Catch: java.lang.Throwable -> L67
            r0 = r4
        L88:
            java.util.List r6 = ir.nasim.ZW0.R0(r6, r0)     // Catch: java.lang.Throwable -> L67
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch: java.lang.Throwable -> L67
            java.util.List r6 = ir.nasim.ZW0.j0(r6)     // Catch: java.lang.Throwable -> L67
            java.lang.Iterable r6 = (java.lang.Iterable) r6     // Catch: java.lang.Throwable -> L67
            ir.nasim.ZW0.Z0(r6)     // Catch: java.lang.Throwable -> L67
        L97:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L67
            r7.e(r4)
            return r6
        L9d:
            r7.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NT0.a(ir.nasim.AX1, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:18:0x004e, B:21:0x0054, B:24:0x005c, B:27:0x0066, B:29:0x006a, B:30:0x006e, B:32:0x0074, B:34:0x007c, B:35:0x0080, B:36:0x008d, B:38:0x0091, B:39:0x0095, B:41:0x009b, B:42:0x009f, B:44:0x00b7, B:45:0x00bb, B:47:0x00bf, B:48:0x00c5), top: B:54:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ir.nasim.InterfaceC20295rm1 r9) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NT0.b(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(ir.nasim.InterfaceC18013nw1 r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NT0.e(ir.nasim.nw1, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ir.nasim.BX1 r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.NT0.f
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.NT0$f r0 = (ir.nasim.NT0.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.NT0$f r0 = new ir.nasim.NT0$f
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r8 = r0.c
            ir.nasim.qn4 r8 = (ir.nasim.InterfaceC19699qn4) r8
            java.lang.Object r1 = r0.b
            ir.nasim.BX1 r1 = (ir.nasim.BX1) r1
            java.lang.Object r0 = r0.a
            ir.nasim.NT0 r0 = (ir.nasim.NT0) r0
            ir.nasim.AbstractC10685c16.b(r9)
            r9 = r8
            r8 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.qn4 r9 = r7.e
            r0.a = r7
            r0.b = r8
            r0.c = r9
            r0.f = r3
            java.lang.Object r0 = r9.a(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r7
        L55:
            ir.nasim.XV4 r8 = r0.d(r8)     // Catch: java.lang.Throwable -> L82
            if (r8 != 0) goto L5d
            r2 = r4
            goto Lbe
        L5d:
            java.lang.Object r1 = r8.a()     // Catch: java.lang.Throwable -> L82
            java.lang.Number r1 = (java.lang.Number) r1     // Catch: java.lang.Throwable -> L82
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L82
            java.lang.Object r8 = r8.b()     // Catch: java.lang.Throwable -> L82
            java.lang.Number r8 = (java.lang.Number) r8     // Catch: java.lang.Throwable -> L82
            int r8 = r8.intValue()     // Catch: java.lang.Throwable -> L82
            r0.f(r1, r8)     // Catch: java.lang.Throwable -> L82
            if (r1 > r8) goto L90
            r2 = r1
        L77:
            java.util.HashSet r5 = r0.f     // Catch: java.lang.Throwable -> L82
            if (r5 != 0) goto L84
            java.lang.String r5 = "pendingChunkIndices"
            ir.nasim.AbstractC13042fc3.y(r5)     // Catch: java.lang.Throwable -> L82
            r5 = r4
            goto L84
        L82:
            r8 = move-exception
            goto Lc8
        L84:
            java.lang.Integer r6 = ir.nasim.AbstractC6392Nk0.d(r2)     // Catch: java.lang.Throwable -> L82
            r5.add(r6)     // Catch: java.lang.Throwable -> L82
            if (r2 == r8) goto L90
            int r2 = r2 + 1
            goto L77
        L90:
            ir.nasim.AX1 r2 = new ir.nasim.AX1     // Catch: java.lang.Throwable -> L82
            ir.nasim.BX1 r5 = r0.d     // Catch: java.lang.Throwable -> L82
            java.lang.String r6 = "minChunkSize"
            if (r5 != 0) goto L9c
            ir.nasim.AbstractC13042fc3.y(r6)     // Catch: java.lang.Throwable -> L82
            r5 = r4
        L9c:
            int r5 = r5.p()     // Catch: java.lang.Throwable -> L82
            int r1 = r1 * r5
            int r8 = r8 + r3
            ir.nasim.BX1 r5 = r0.d     // Catch: java.lang.Throwable -> L82
            if (r5 != 0) goto Laa
            ir.nasim.AbstractC13042fc3.y(r6)     // Catch: java.lang.Throwable -> L82
            r5 = r4
        Laa:
            int r5 = r5.p()     // Catch: java.lang.Throwable -> L82
            int r8 = r8 * r5
            ir.nasim.MX1$a r0 = r0.a     // Catch: java.lang.Throwable -> L82
            long r5 = r0.b()     // Catch: java.lang.Throwable -> L82
            int r0 = (int) r5     // Catch: java.lang.Throwable -> L82
            int r8 = java.lang.Math.min(r8, r0)     // Catch: java.lang.Throwable -> L82
            int r8 = r8 - r3
            r2.<init>(r1, r8)     // Catch: java.lang.Throwable -> L82
        Lbe:
            boolean r8 = r9.d()
            if (r8 == 0) goto Lc7
            r9.e(r4)
        Lc7:
            return r2
        Lc8:
            boolean r0 = r9.d()
            if (r0 == 0) goto Ld1
            r9.e(r4)
        Ld1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NT0.g(ir.nasim.BX1, ir.nasim.rm1):java.lang.Object");
    }
}
