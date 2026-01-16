package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public final class I25 implements InterfaceC20468s37 {
    private final OK7 a;
    private final C10299bQ2 b;
    private final C14375ho5 c;
    private final Context d;

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
            return I25.this.c(0, this);
        }
    }

    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return I25.this.d(0, this);
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        int e;
        /* synthetic */ Object f;
        int h;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return I25.this.a(null, this);
        }
    }

    public I25(OK7 ok7, C10299bQ2 c10299bQ2, C14375ho5 c14375ho5, Context context) {
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c10299bQ2, "groupModule");
        AbstractC13042fc3.i(c14375ho5, "presenceModule");
        AbstractC13042fc3.i(context, "context");
        this.a = ok7;
        this.b = c10299bQ2;
        this.c = c14375ho5;
        this.d = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(int r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.I25.a
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.I25$a r0 = (ir.nasim.I25.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.I25$a r0 = new ir.nasim.I25$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r8 = r9.l()
            goto L51
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.bQ2 r9 = r7.b
            ir.nasim.VL3 r9 = r9.Y1()
            long r5 = (long) r8
            ir.nasim.Nv5 r8 = r9.k(r5)
            if (r8 == 0) goto L69
            r0.c = r4
            java.lang.Object r8 = ir.nasim.AbstractC6756Ov5.d(r8, r3, r0, r4, r3)
            if (r8 != r1) goto L51
            return r1
        L51:
            boolean r9 = ir.nasim.C9475a16.g(r8)
            if (r9 == 0) goto L58
            goto L59
        L58:
            r3 = r8
        L59:
            ir.nasim.iO2 r3 = (ir.nasim.C14733iO2) r3
            if (r3 == 0) goto L69
            ir.nasim.Wh0 r8 = r3.F()
            if (r8 == 0) goto L69
            ir.nasim.Fq2 r8 = ir.nasim.AbstractC23145wQ7.a(r8)
            if (r8 != 0) goto L70
        L69:
            r8 = 0
            java.lang.Boolean[] r8 = new java.lang.Boolean[r8]
            ir.nasim.Fq2 r8 = ir.nasim.AbstractC6459Nq2.U(r8)
        L70:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.I25.c(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(int r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.I25.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.I25$b r0 = (ir.nasim.I25.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.I25$b r0 = new ir.nasim.I25$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L40
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.ho5 r8 = r6.c
            long r4 = (long) r7
            r0.c = r3
            java.lang.Object r8 = r8.F(r4, r0)
            if (r8 != r1) goto L40
            return r1
        L40:
            ir.nasim.Fq2 r8 = (ir.nasim.InterfaceC4557Fq2) r8
            if (r8 == 0) goto L4a
            ir.nasim.Fq2 r7 = ir.nasim.AbstractC6459Nq2.F(r8)
            if (r7 != 0) goto L51
        L4a:
            r7 = 0
            ir.nasim.PI7[] r7 = new ir.nasim.PI7[r7]
            ir.nasim.Fq2 r7 = ir.nasim.AbstractC6459Nq2.U(r7)
        L51:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.I25.d(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x023a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ai.bale.proto.SearchStruct$PeerSearchResult r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.I25.a(ai.bale.proto.SearchStruct$PeerSearchResult, ir.nasim.rm1):java.lang.Object");
    }
}
