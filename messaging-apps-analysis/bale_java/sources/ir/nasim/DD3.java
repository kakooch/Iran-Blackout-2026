package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public interface DD3 {

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
            return DD3.g(DD3.this, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object g(ir.nasim.DD3 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            boolean r0 = r6 instanceof ir.nasim.DD3.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.DD3$a r0 = (ir.nasim.DD3.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.DD3$a r0 = new ir.nasim.DD3$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r6)
            goto L56
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.a
            ir.nasim.DD3 r5 = (ir.nasim.DD3) r5
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4a
        L3c:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = r5.a(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r6 = 0
            r0.a = r6
            r0.d = r3
            java.lang.Object r5 = r5.c(r0)
            if (r5 != r1) goto L56
            return r1
        L56:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.DD3.g(ir.nasim.DD3, ir.nasim.rm1):java.lang.Object");
    }

    Object a(InterfaceC20295rm1 interfaceC20295rm1);

    default Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        return g(this, interfaceC20295rm1);
    }

    Object c(InterfaceC20295rm1 interfaceC20295rm1);

    Object d(long j, InterfaceC20295rm1 interfaceC20295rm1);

    InterfaceC4557Fq2 e();

    Object f(Iterable iterable, InterfaceC20295rm1 interfaceC20295rm1);

    Object h(HD3 hd3, InterfaceC20295rm1 interfaceC20295rm1);
}
