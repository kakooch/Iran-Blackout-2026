package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.l07, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16283l07 implements InterfaceC4806Gq2 {
    private final InterfaceC4806Gq2 a;
    private final InterfaceC14603iB2 b;

    /* renamed from: ir.nasim.l07$a */
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
            return C16283l07.this.b(this);
        }
    }

    public C16283l07(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = interfaceC4806Gq2;
        this.b = interfaceC14603iB2;
    }

    @Override // ir.nasim.InterfaceC4806Gq2
    public Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.a(obj, interfaceC20295rm1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [ir.nasim.j96] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ir.nasim.C16283l07.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.l07$a r0 = (ir.nasim.C16283l07.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.l07$a r0 = new ir.nasim.l07$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r7)
            goto L79
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            java.lang.Object r2 = r0.b
            ir.nasim.j96 r2 = (ir.nasim.C15190j96) r2
            java.lang.Object r4 = r0.a
            ir.nasim.l07 r4 = (ir.nasim.C16283l07) r4
            ir.nasim.AbstractC10685c16.b(r7)     // Catch: java.lang.Throwable -> L40
            goto L60
        L40:
            r7 = move-exception
            goto L7f
        L42:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.j96 r2 = new ir.nasim.j96
            ir.nasim.Gq2 r7 = r6.a
            ir.nasim.do1 r5 = r0.getContext()
            r2.<init>(r7, r5)
            ir.nasim.iB2 r7 = r6.b     // Catch: java.lang.Throwable -> L40
            r0.a = r6     // Catch: java.lang.Throwable -> L40
            r0.b = r2     // Catch: java.lang.Throwable -> L40
            r0.e = r4     // Catch: java.lang.Throwable -> L40
            java.lang.Object r7 = r7.invoke(r2, r0)     // Catch: java.lang.Throwable -> L40
            if (r7 != r1) goto L5f
            return r1
        L5f:
            r4 = r6
        L60:
            r2.releaseIntercepted()
            ir.nasim.Gq2 r7 = r4.a
            boolean r2 = r7 instanceof ir.nasim.C16283l07
            if (r2 == 0) goto L7c
            ir.nasim.l07 r7 = (ir.nasim.C16283l07) r7
            r2 = 0
            r0.a = r2
            r0.b = r2
            r0.e = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L79
            return r1
        L79:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        L7c:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        L7f:
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16283l07.b(ir.nasim.rm1):java.lang.Object");
    }
}
