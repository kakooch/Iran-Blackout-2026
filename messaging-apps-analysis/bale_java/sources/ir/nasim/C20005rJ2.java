package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.rJ2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20005rJ2 implements InterfaceC20468s37 {
    private final C14375ho5 a;
    private final OK7 b;
    private final C10299bQ2 c;
    private final Context d;

    /* renamed from: ir.nasim.rJ2$a */
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
            return C20005rJ2.this.b(0, this);
        }
    }

    /* renamed from: ir.nasim.rJ2$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C20005rJ2.this.a(null, this);
        }
    }

    public C20005rJ2(C14375ho5 c14375ho5, OK7 ok7, C10299bQ2 c10299bQ2, Context context) {
        AbstractC13042fc3.i(c14375ho5, "presenceModule");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c10299bQ2, "groupModule");
        AbstractC13042fc3.i(context, "context");
        this.a = c14375ho5;
        this.b = ok7;
        this.c = c10299bQ2;
        this.d = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(int r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C20005rJ2.a
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.rJ2$a r0 = (ir.nasim.C20005rJ2.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.rJ2$a r0 = new ir.nasim.rJ2$a
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
            ir.nasim.ho5 r8 = r6.a
            long r4 = (long) r7
            r0.c = r3
            java.lang.Object r8 = r8.F(r4, r0)
            if (r8 != r1) goto L40
            return r1
        L40:
            ir.nasim.Fq2 r8 = (ir.nasim.InterfaceC4557Fq2) r8
            ir.nasim.Fq2 r7 = ir.nasim.AbstractC6459Nq2.F(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20005rJ2.b(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0296  */
    @Override // ir.nasim.InterfaceC20468s37
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.C18823pJ2 r39, ir.nasim.InterfaceC20295rm1 r40) {
        /*
            Method dump skipped, instructions count: 837
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20005rJ2.a(ir.nasim.pJ2, ir.nasim.rm1):java.lang.Object");
    }
}
