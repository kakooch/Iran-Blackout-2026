package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;

/* loaded from: classes.dex */
public final class CV implements InterfaceC17052mJ4 {
    private boolean b;
    private InterfaceC20295rm1 c;

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
            return CV.this.k(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.CV.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.CV$a r0 = (ir.nasim.CV.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.CV$a r0 = new ir.nasim.CV$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r1 = r0.b
            ir.nasim.rm1 r1 = (ir.nasim.InterfaceC20295rm1) r1
            java.lang.Object r0 = r0.a
            ir.nasim.CV r0 = (ir.nasim.CV) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L68
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L39:
            ir.nasim.AbstractC10685c16.b(r6)
            boolean r6 = r5.b
            if (r6 != 0) goto L75
            ir.nasim.rm1 r6 = r5.c
            r0.a = r5
            r0.b = r6
            r0.e = r3
            ir.nasim.IE0 r2 = new ir.nasim.IE0
            ir.nasim.rm1 r4 = ir.nasim.AbstractC13660gc3.c(r0)
            r2.<init>(r4, r3)
            r2.w()
            f(r5, r2)
            java.lang.Object r2 = r2.t()
            java.lang.Object r3 = ir.nasim.AbstractC13660gc3.e()
            if (r2 != r3) goto L64
            ir.nasim.WA1.c(r0)
        L64:
            if (r2 != r1) goto L67
            return r1
        L67:
            r1 = r6
        L68:
            if (r1 == 0) goto L75
            ir.nasim.a16$a r6 = ir.nasim.C9475a16.b
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            java.lang.Object r6 = ir.nasim.C9475a16.b(r6)
            r1.resumeWith(r6)
        L75:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CV.k(ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC17052mJ4
    public void u(InterfaceC11379cu3 interfaceC11379cu3) {
        if (this.b) {
            return;
        }
        this.b = true;
        InterfaceC20295rm1 interfaceC20295rm1 = this.c;
        if (interfaceC20295rm1 != null) {
            C9475a16.a aVar = C9475a16.b;
            interfaceC20295rm1.resumeWith(C9475a16.b(C19938rB7.a));
        }
        this.c = null;
    }
}
