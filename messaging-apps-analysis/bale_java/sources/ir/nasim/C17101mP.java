package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.mP, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17101mP extends UY3 {
    private final C14110hN f;

    /* renamed from: ir.nasim.mP$a */
    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C17101mP.this.i(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17101mP(C14110hN c14110hN, E84 e84) {
        super(c14110hN, e84);
        AbstractC13042fc3.i(c14110hN, "dataSource");
        AbstractC13042fc3.i(e84, "messagesModule");
        this.f = c14110hN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.UY3
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C14110hN a() {
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(ir.nasim.C11458d25 r5, java.lang.Long r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.C17101mP.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.mP$a r0 = (ir.nasim.C17101mP.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.mP$a r0 = new ir.nasim.mP$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            r0.c = r3
            java.lang.Object r7 = super.g(r5, r6, r0)
            if (r7 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.collections.List<ir.nasim.sharedmedia.data.model.SharedMediaContent.Audio>"
            ir.nasim.AbstractC13042fc3.g(r7, r5)
            java.util.List r7 = (java.util.List) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17101mP.i(ir.nasim.d25, java.lang.Long, ir.nasim.rm1):java.lang.Object");
    }
}
