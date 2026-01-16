package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.cl1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11287cl1 extends YT4 {
    private final String b;
    private final C16686lh6 c;
    private int d;
    private int e;
    private final int f;

    /* renamed from: ir.nasim.cl1$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C11287cl1.this.f(null, this);
        }
    }

    public C11287cl1(String str, C16686lh6 c16686lh6) {
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(c16686lh6, "repository");
        this.b = str;
        this.c = c16686lh6;
        this.e = -1;
        this.f = 30;
    }

    @Override // ir.nasim.YT4
    public boolean b() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof ir.nasim.C11287cl1.a
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.cl1$a r0 = (ir.nasim.C11287cl1.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.cl1$a r0 = new ir.nasim.cl1$a
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r12 = r0.a
            ir.nasim.cl1 r12 = (ir.nasim.C11287cl1) r12
            ir.nasim.AbstractC10685c16.b(r13)
            goto L53
        L2e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L36:
            ir.nasim.AbstractC10685c16.b(r13)
            java.lang.Object r12 = r12.a()
            byte[] r12 = (byte[]) r12
            if (r12 != 0) goto L43
            byte[] r12 = new byte[r3]
        L43:
            ir.nasim.lh6 r13 = r11.c
            java.lang.String r2 = r11.b
            r0.a = r11
            r0.d = r4
            java.lang.Object r13 = r13.a(r2, r12, r0)
            if (r13 != r1) goto L52
            return r1
        L52:
            r12 = r11
        L53:
            ir.nasim.Qf6 r13 = (ir.nasim.C7091Qf6) r13
            int r0 = r12.d
            java.util.List r1 = r13.a()
            int r1 = r1.size()
            int r0 = r0 + r1
            r12.d = r0
            int r0 = r12.e
            r1 = -1
            if (r0 != r1) goto L6d
            int r0 = r13.b()
            r12.e = r0
        L6d:
            int r0 = r12.e
            int r1 = r12.f
            java.util.List r2 = r13.a()
            int r2 = r2.size()
            int r1 = r1 - r2
            int r0 = r0 - r1
            r12.e = r0
            int r1 = r12.d
            if (r1 >= r0) goto L8c
            byte[] r0 = r13.c()
            if (r0 == 0) goto L8b
            int r0 = r0.length
            if (r0 != 0) goto L8b
            goto L8c
        L8b:
            r4 = r3
        L8c:
            java.util.List r6 = r13.a()
            if (r4 == 0) goto L95
            r0 = 0
        L93:
            r8 = r0
            goto L9a
        L95:
            byte[] r0 = r13.c()
            goto L93
        L9a:
            int r0 = r12.e
            int r1 = r12.d
            int r0 = r0 - r1
            int r10 = ir.nasim.AbstractC21867uG5.e(r0, r3)
            int r12 = r12.d
            java.util.List r13 = r13.a()
            int r13 = r13.size()
            int r9 = r12 - r13
            ir.nasim.YT4$b$c r12 = new ir.nasim.YT4$b$c
            r7 = 0
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11287cl1.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public byte[] d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return null;
    }
}
