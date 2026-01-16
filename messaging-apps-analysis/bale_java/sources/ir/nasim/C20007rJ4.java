package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.rJ4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C20007rJ4 implements InterfaceC20468s37 {
    private final KM2 a;
    private final InterfaceC11621dJ7 b;
    private final C4627Fy0 c;

    /* renamed from: ir.nasim.rJ4$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C20007rJ4.this.c(null, this);
        }
    }

    /* renamed from: ir.nasim.rJ4$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        int f;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C20007rJ4.this.a(null, this);
        }
    }

    public C20007rJ4(KM2 km2, InterfaceC11621dJ7 interfaceC11621dJ7, C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        this.a = km2;
        this.b = interfaceC11621dJ7;
        this.c = c4627Fy0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:23:0x008a, B:25:0x0090], limit reached: 29 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0082 -> B:21:0x0086). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.util.List r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ir.nasim.C20007rJ4.a
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.rJ4$a r0 = (ir.nasim.C20007rJ4.a) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            ir.nasim.rJ4$a r0 = new ir.nasim.rJ4$a
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.e
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r11 = r0.d
            java.util.Collection r11 = (java.util.Collection) r11
            java.lang.Object r2 = r0.c
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.b
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r5 = r0.a
            ir.nasim.rJ4 r5 = (ir.nasim.C20007rJ4) r5
            ir.nasim.AbstractC10685c16.b(r12)
            r9 = r12
            r12 = r11
            r11 = r4
            r4 = r2
            r2 = r0
            r0 = r9
            goto L86
        L3f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L47:
            ir.nasim.AbstractC10685c16.b(r12)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r12 = new java.util.ArrayList
            r2 = 10
            int r2 = ir.nasim.ZW0.x(r11, r2)
            r12.<init>(r2)
            java.util.Iterator r11 = r11.iterator()
            r5 = r10
            r2 = r11
            r11 = r12
        L5e:
            boolean r12 = r2.hasNext()
            if (r12 == 0) goto L98
            java.lang.Object r12 = r2.next()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            ir.nasim.dJ7 r4 = r5.b
            long r6 = (long) r12
            r0.a = r5
            r0.b = r11
            r0.c = r2
            r0.d = r11
            r0.g = r3
            java.lang.Object r12 = r4.a(r6, r0)
            if (r12 != r1) goto L82
            return r1
        L82:
            r4 = r2
            r2 = r0
            r0 = r12
            r12 = r11
        L86:
            ir.nasim.nI7 r0 = (ir.nasim.C17637nI7) r0
            if (r0 == 0) goto L90
            java.lang.String r0 = r0.getName()
            if (r0 != 0) goto L92
        L90:
            java.lang.String r0 = ""
        L92:
            r12.add(r0)
            r0 = r2
            r2 = r4
            goto L5e
        L98:
            java.util.List r11 = (java.util.List) r11
            r0 = r11
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r7 = 62
            r8 = 0
            java.lang.String r1 = " , "
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r11 = ir.nasim.ZW0.A0(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            java.lang.String r11 = ir.nasim.XY6.v(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20007rJ4.c(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a1  */
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.AbstractC17643nJ4 r25, ir.nasim.InterfaceC20295rm1 r26) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20007rJ4.a(ir.nasim.nJ4, ir.nasim.rm1):java.lang.Object");
    }
}
