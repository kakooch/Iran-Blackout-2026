package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.tf5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21440tf5 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(a.e);

    /* renamed from: ir.nasim.tf5$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        public final AbstractC15857kI0 a() {
            return null;
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return null;
        }
    }

    /* renamed from: ir.nasim.tf5$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC21440tf5.b(null, null, this);
        }
    }

    /* renamed from: ir.nasim.tf5$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC21440tf5.c(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(ir.nasim.InterfaceC20820sf5 r4, ir.nasim.InterfaceC14603iB2 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            boolean r0 = r6 instanceof ir.nasim.AbstractC21440tf5.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.tf5$b r0 = (ir.nasim.AbstractC21440tf5.b) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            ir.nasim.tf5$b r0 = new ir.nasim.tf5$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            ir.nasim.AbstractC10685c16.b(r6)
            goto L5d
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            androidx.compose.ui.e$c r6 = r4.h()
            boolean r6 = r6.b2()
            if (r6 == 0) goto L63
            ir.nasim.xO4 r6 = ir.nasim.KG1.p(r4)
            ir.nasim.Au3 r4 = ir.nasim.KG1.o(r4)
            ir.nasim.dc1 r4 = r4.S()
            ir.nasim.Nx5 r2 = ir.nasim.AbstractC21440tf5.a
            java.lang.Object r4 = r4.b(r2)
            ir.nasim.AbstractC18350oW3.a(r4)
            r0.b = r3
            r4 = 0
            java.lang.Object r4 = c(r6, r4, r5, r0)
            if (r4 != r1) goto L5d
            return r1
        L5d:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        L63:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "establishTextInputSession called from an unattached node"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21440tf5.b(ir.nasim.sf5, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(ir.nasim.InterfaceC23714xO4 r3, ir.nasim.AbstractC15857kI0 r4, ir.nasim.InterfaceC14603iB2 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            boolean r4 = r6 instanceof ir.nasim.AbstractC21440tf5.c
            if (r4 == 0) goto L13
            r4 = r6
            ir.nasim.tf5$c r4 = (ir.nasim.AbstractC21440tf5.c) r4
            int r0 = r4.b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.b = r0
            goto L18
        L13:
            ir.nasim.tf5$c r4 = new ir.nasim.tf5$c
            r4.<init>(r6)
        L18:
            java.lang.Object r6 = r4.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r4.b
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 == r2) goto L39
            r3 = 2
            if (r1 == r3) goto L30
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L30:
            ir.nasim.AbstractC10685c16.b(r6)
            kotlin.KotlinNothingValueException r3 = new kotlin.KotlinNothingValueException
            r3.<init>()
            throw r3
        L39:
            ir.nasim.AbstractC10685c16.b(r6)
            goto L49
        L3d:
            ir.nasim.AbstractC10685c16.b(r6)
            r4.b = r2
            java.lang.Object r3 = r3.v(r5, r4)
            if (r3 != r0) goto L49
            return r0
        L49:
            kotlin.KotlinNothingValueException r3 = new kotlin.KotlinNothingValueException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21440tf5.c(ir.nasim.xO4, ir.nasim.kI0, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
    }
}
