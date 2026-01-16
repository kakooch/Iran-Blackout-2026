package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.lN5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC16498lN5 {
    private final C6287Mz a;

    /* renamed from: ir.nasim.lN5$a */
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
            Object objA = AbstractC16498lN5.this.a(null, null, null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    public AbstractC16498lN5(C6287Mz c6287Mz) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        this.a = c6287Mz;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object a(java.lang.String r9, com.google.protobuf.P r10, com.google.protobuf.P r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof ir.nasim.AbstractC16498lN5.a
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.lN5$a r0 = (ir.nasim.AbstractC16498lN5.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            ir.nasim.lN5$a r0 = new ir.nasim.lN5$a
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r5.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r5.c
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.a16 r12 = (ir.nasim.C9475a16) r12
            java.lang.Object r9 = r12.l()
            goto L51
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.vx5 r1 = new ir.nasim.vx5
            r1.<init>(r9, r10, r11)
            ir.nasim.Mz r9 = r8.a
            r5.c = r2
            r3 = 0
            r6 = 2
            r7 = 0
            r2 = r9
            java.lang.Object r9 = ir.nasim.AbstractC6547Nz.b(r1, r2, r3, r5, r6, r7)
            if (r9 != r0) goto L51
            return r0
        L51:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16498lN5.a(java.lang.String, com.google.protobuf.P, com.google.protobuf.P, ir.nasim.rm1):java.lang.Object");
    }
}
