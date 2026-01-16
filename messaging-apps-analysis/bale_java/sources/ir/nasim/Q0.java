package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
public abstract class Q0 implements InterfaceC4557Fq2, LE0 {

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
            return Q0.this.b(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC4557Fq2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r6, ir.nasim.InterfaceC20295rm1 r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.Q0.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Q0$a r0 = (ir.nasim.Q0.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Q0$a r0 = new ir.nasim.Q0$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.a
            ir.nasim.j96 r6 = (ir.nasim.C15190j96) r6
            ir.nasim.AbstractC10685c16.b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.j96 r7 = new ir.nasim.j96
            ir.nasim.do1 r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.a = r7     // Catch: java.lang.Throwable -> L55
            r0.d = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.h(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        L55:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Q0.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
    }

    public abstract Object h(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1);
}
