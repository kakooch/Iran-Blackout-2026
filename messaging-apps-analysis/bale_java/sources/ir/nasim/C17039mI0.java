package ir.nasim;

import android.graphics.Bitmap;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.mI0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17039mI0 {
    private final C10299bQ2 a;
    private final C6508Nu5 b;
    private final AbstractC13778go1 c;

    /* renamed from: ir.nasim.mI0$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        int f;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C17039mI0.this.a(0, null, this);
        }
    }

    /* renamed from: ir.nasim.mI0$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C17039mI0.this.b(null, this);
        }
    }

    /* renamed from: ir.nasim.mI0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Bitmap bitmapE = V13.e(this.c);
            if (bitmapE == null) {
                return C19938rB7.a;
            }
            Bitmap bitmapE2 = C16670lg0.a.e(bitmapE);
            String strL = C4053Dm2.l("image", "jpg");
            if (strL == null) {
                return C19938rB7.a;
            }
            V13.f(bitmapE2, strL);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C17039mI0(C10299bQ2 c10299bQ2, C6508Nu5 c6508Nu5, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(c6508Nu5, "profileModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c10299bQ2;
        this.b = c6508Nu5;
        this.c = abstractC13778go1;
    }

    private final Object c(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.c, new c(str, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(int r5, java.lang.String r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.C17039mI0.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.mI0$a r0 = (ir.nasim.C17039mI0.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.mI0$a r0 = new ir.nasim.mI0$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            int r5 = r0.c
            java.lang.Object r6 = r0.b
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r0 = r0.a
            ir.nasim.mI0 r0 = (ir.nasim.C17039mI0) r0
            ir.nasim.AbstractC10685c16.b(r7)
            goto L4e
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            ir.nasim.AbstractC10685c16.b(r7)
            r0.a = r4
            r0.b = r6
            r0.c = r5
            r0.f = r3
            java.lang.Object r7 = r4.c(r6, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            r0 = r4
        L4e:
            ir.nasim.bQ2 r7 = r0.a
            r7.o1(r5, r6)
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17039mI0.a(int, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C17039mI0.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.mI0$b r0 = (ir.nasim.C17039mI0.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.mI0$b r0 = new ir.nasim.mI0$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.a
            ir.nasim.mI0 r0 = (ir.nasim.C17039mI0) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4a
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r6 = r4.c(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r0 = r4
        L4a:
            ir.nasim.Nu5 r6 = r0.b
            r6.A(r5)
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17039mI0.b(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
