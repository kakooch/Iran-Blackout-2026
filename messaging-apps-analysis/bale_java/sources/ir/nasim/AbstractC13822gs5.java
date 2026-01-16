package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;

/* renamed from: ir.nasim.gs5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13822gs5 {

    /* renamed from: ir.nasim.gs5$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC13822gs5.a(null, null, this);
        }
    }

    /* renamed from: ir.nasim.gs5$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ HE0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(HE0 he0) {
            super(1);
            this.e = he0;
        }

        public final void a(Throwable th) {
            HE0 he0 = this.e;
            C9475a16.a aVar = C9475a16.b;
            he0.resumeWith(C9475a16.b(C19938rB7.a));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(ir.nasim.InterfaceC16204ks5 r4, ir.nasim.SA2 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            boolean r0 = r6 instanceof ir.nasim.AbstractC13822gs5.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.gs5$a r0 = (ir.nasim.AbstractC13822gs5.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.gs5$a r0 = new ir.nasim.gs5$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.b
            r5 = r4
            ir.nasim.SA2 r5 = (ir.nasim.SA2) r5
            java.lang.Object r4 = r0.a
            ir.nasim.ks5 r4 = (ir.nasim.InterfaceC16204ks5) r4
            ir.nasim.AbstractC10685c16.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L75
        L32:
            r4 = move-exception
            goto L7b
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.do1 r6 = r0.getContext()
            ir.nasim.gj3$b r2 = ir.nasim.InterfaceC13730gj3.n0
            ir.nasim.do1$b r6 = r6.a(r2)
            if (r6 != r4) goto L7f
            r0.a = r4     // Catch: java.lang.Throwable -> L32
            r0.b = r5     // Catch: java.lang.Throwable -> L32
            r0.d = r3     // Catch: java.lang.Throwable -> L32
            ir.nasim.IE0 r6 = new ir.nasim.IE0     // Catch: java.lang.Throwable -> L32
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.w()     // Catch: java.lang.Throwable -> L32
            ir.nasim.gs5$c r2 = new ir.nasim.gs5$c     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.f(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.t()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = ir.nasim.AbstractC13660gc3.e()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L72
            ir.nasim.WA1.c(r0)     // Catch: java.lang.Throwable -> L32
        L72:
            if (r4 != r1) goto L75
            return r1
        L75:
            r5.invoke()
            ir.nasim.rB7 r4 = ir.nasim.C19938rB7.a
            return r4
        L7b:
            r5.invoke()
            throw r4
        L7f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC13822gs5.a(ir.nasim.ks5, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object b(InterfaceC16204ks5 interfaceC16204ks5, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            sa2 = b.e;
        }
        return a(interfaceC16204ks5, sa2, interfaceC20295rm1);
    }

    public static final VI5 c(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0, EnumC23959xo1 enumC23959xo1, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2) {
        C15613js5 c15613js5 = new C15613js5(AbstractC12551eo1.e(interfaceC20315ro1, interfaceC11938do1), DJ0.b(i, enumC6162Ml0, null, 4, null));
        if (ua2 != null) {
            c15613js5.s(ua2);
        }
        c15613js5.g1(enumC23959xo1, c15613js5, interfaceC14603iB2);
        return c15613js5;
    }

    public static final VI5 d(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, int i, InterfaceC14603iB2 interfaceC14603iB2) {
        return c(interfaceC20315ro1, interfaceC11938do1, i, EnumC6162Ml0.SUSPEND, EnumC23959xo1.DEFAULT, null, interfaceC14603iB2);
    }

    public static /* synthetic */ VI5 e(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0, EnumC23959xo1 enumC23959xo1, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        InterfaceC11938do1 interfaceC11938do12 = interfaceC11938do1;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            enumC6162Ml0 = EnumC6162Ml0.SUSPEND;
        }
        EnumC6162Ml0 enumC6162Ml02 = enumC6162Ml0;
        if ((i2 & 8) != 0) {
            enumC23959xo1 = EnumC23959xo1.DEFAULT;
        }
        EnumC23959xo1 enumC23959xo12 = enumC23959xo1;
        if ((i2 & 16) != 0) {
            ua2 = null;
        }
        return c(interfaceC20315ro1, interfaceC11938do12, i3, enumC6162Ml02, enumC23959xo12, ua2, interfaceC14603iB2);
    }

    public static /* synthetic */ VI5 f(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, int i, InterfaceC14603iB2 interfaceC14603iB2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return d(interfaceC20315ro1, interfaceC11938do1, i, interfaceC14603iB2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ir.nasim.gs5$b */
    public static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }

        public final void a() {
        }
    }
}
