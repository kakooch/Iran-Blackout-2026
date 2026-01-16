package ir.nasim;

import ai.bale.proto.AuthStruct$AuthSession;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.ok6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18489ok6 extends VW7 {
    private final C11941do4 b;
    private final SettingsModule c;
    private final C14934ij6 d;
    private final C8054Ui1 e;

    /* renamed from: ir.nasim.ok6$a */
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
            Object objT0 = C18489ok6.this.T0(this);
            return objT0 == AbstractC14862ic3.e() ? objT0 : C9475a16.a(objT0);
        }
    }

    /* renamed from: ir.nasim.ok6$b */
    static final class b implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        b(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(List list) {
            AbstractC13042fc3.i(list, "protoSessions");
            List<AuthStruct$AuthSession> list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (AuthStruct$AuthSession authStruct$AuthSession : list2) {
                arrayList.add(new C6511Nv(authStruct$AuthSession.getId(), authStruct$AuthSession.getAuthHolder() == VQ.AuthHolder_THISDEVICE ? EnumC6017Lv.THISDEVICE : EnumC6017Lv.OTHERDEVICE, authStruct$AuthSession.getAppId(), authStruct$AuthSession.getAppTitle(), authStruct$AuthSession.getDeviceTitle(), authStruct$AuthSession.getAuthTime(), authStruct$AuthSession.getAuthLocation(), Double.valueOf(authStruct$AuthSession.getLatitude().getValue()), Double.valueOf(authStruct$AuthSession.getLongitude().getValue()), Long.valueOf(authStruct$AuthSession.getLastActivityAt().getValue()), new OC(authStruct$AuthSession.getLastIpAddress().toString())));
            }
            AbstractC24549yo1.c(this.a, C9475a16.a(C9475a16.b(arrayList)));
        }
    }

    /* renamed from: ir.nasim.ok6$c */
    static final class c implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        c(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(Exception exc) {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC13042fc3.f(exc);
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(AbstractC10685c16.a(exc))));
        }
    }

    /* renamed from: ir.nasim.ok6$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objU0 = C18489ok6.this.U0(this);
            return objU0 == AbstractC14862ic3.e() ? objU0 : C9475a16.a(objU0);
        }
    }

    /* renamed from: ir.nasim.ok6$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objW0 = C18489ok6.this.W0(this);
            return objW0 == AbstractC14862ic3.e() ? objW0 : C9475a16.a(objW0);
        }
    }

    /* renamed from: ir.nasim.ok6$f */
    static final class f implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        f(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(C14505i18 c14505i18) {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(C19938rB7.a)));
        }
    }

    /* renamed from: ir.nasim.ok6$g */
    static final class g implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        g(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(Exception exc) {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC13042fc3.f(exc);
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(AbstractC10685c16.a(exc))));
        }
    }

    /* renamed from: ir.nasim.ok6$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objX0 = C18489ok6.this.X0(0, this);
            return objX0 == AbstractC14862ic3.e() ? objX0 : C9475a16.a(objX0);
        }
    }

    /* renamed from: ir.nasim.ok6$i */
    static final class i implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        i(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(C14505i18 c14505i18) {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(C19938rB7.a)));
        }
    }

    /* renamed from: ir.nasim.ok6$j */
    static final class j implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        j(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(Exception exc) {
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            AbstractC13042fc3.f(exc);
            AbstractC24549yo1.c(he0, C9475a16.a(C9475a16.b(AbstractC10685c16.a(exc))));
        }
    }

    /* renamed from: ir.nasim.ok6$k */
    static final class k extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objY0 = C18489ok6.this.Y0(this);
            return objY0 == AbstractC14862ic3.e() ? objY0 : C9475a16.a(objY0);
        }
    }

    public C18489ok6(C11941do4 c11941do4, SettingsModule settingsModule, C14934ij6 c14934ij6, C8054Ui1 c8054Ui1) {
        AbstractC13042fc3.i(c11941do4, "mxpModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c14934ij6, "securityModule");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        this.b = c11941do4;
        this.c = settingsModule;
        this.d = c14934ij6;
        this.e = c8054Ui1;
    }

    public final boolean R0() {
        return C13923h3.a.k().getSyncContacts();
    }

    public final boolean S0() {
        return this.c.K5();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object T0(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C18489ok6.a
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.ok6$a r0 = (ir.nasim.C18489ok6.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.ok6$a r0 = new ir.nasim.ok6$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.ok6 r0 = (ir.nasim.C18489ok6) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L71
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            r0.a = r4
            r0.d = r3
            ir.nasim.IE0 r5 = new ir.nasim.IE0
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r5.<init>(r2, r3)
            r5.w()
            ir.nasim.ij6 r2 = P0(r4)
            ir.nasim.Nv5 r2 = r2.I()
            ir.nasim.ok6$b r3 = new ir.nasim.ok6$b
            r3.<init>(r5)
            ir.nasim.Nv5 r2 = r2.m0(r3)
            ir.nasim.ok6$c r3 = new ir.nasim.ok6$c
            r3.<init>(r5)
            r2.E(r3)
            java.lang.Object r5 = r5.t()
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()
            if (r5 != r2) goto L6e
            ir.nasim.WA1.c(r0)
        L6e:
            if (r5 != r1) goto L71
            return r1
        L71:
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18489ok6.T0(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object U0(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C18489ok6.d
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.ok6$d r0 = (ir.nasim.C18489ok6.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.ok6$d r0 = new ir.nasim.ok6$d
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.do4 r5 = r4.b
            ir.nasim.Nv5 r5 = r5.C()
            r0.c = r3
            r2 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18489ok6.U0(ir.nasim.rm1):java.lang.Object");
    }

    public final void V0(boolean z) {
        if (z) {
            this.e.q0();
        }
        C13923h3.a.y(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W0(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C18489ok6.e
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.ok6$e r0 = (ir.nasim.C18489ok6.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.ok6$e r0 = new ir.nasim.ok6$e
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.ok6 r0 = (ir.nasim.C18489ok6) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L71
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            r0.a = r4
            r0.d = r3
            ir.nasim.IE0 r5 = new ir.nasim.IE0
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r5.<init>(r2, r3)
            r5.w()
            ir.nasim.ij6 r2 = P0(r4)
            ir.nasim.Nv5 r2 = r2.N()
            ir.nasim.ok6$f r3 = new ir.nasim.ok6$f
            r3.<init>(r5)
            ir.nasim.Nv5 r2 = r2.m0(r3)
            ir.nasim.ok6$g r3 = new ir.nasim.ok6$g
            r3.<init>(r5)
            r2.E(r3)
            java.lang.Object r5 = r5.t()
            java.lang.Object r2 = ir.nasim.AbstractC13660gc3.e()
            if (r5 != r2) goto L6e
            ir.nasim.WA1.c(r0)
        L6e:
            if (r5 != r1) goto L71
            return r1
        L71:
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18489ok6.W0(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X0(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C18489ok6.h
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.ok6$h r0 = (ir.nasim.C18489ok6.h) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.ok6$h r0 = new ir.nasim.ok6$h
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.a
            ir.nasim.ok6 r5 = (ir.nasim.C18489ok6) r5
            ir.nasim.AbstractC10685c16.b(r6)
            goto L73
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.a = r4
            r0.b = r5
            r0.e = r3
            ir.nasim.IE0 r6 = new ir.nasim.IE0
            ir.nasim.rm1 r2 = ir.nasim.AbstractC13660gc3.c(r0)
            r6.<init>(r2, r3)
            r6.w()
            ir.nasim.ij6 r2 = P0(r4)
            ir.nasim.Nv5 r5 = r2.P(r5)
            ir.nasim.ok6$i r2 = new ir.nasim.ok6$i
            r2.<init>(r6)
            ir.nasim.Nv5 r5 = r5.m0(r2)
            ir.nasim.ok6$j r2 = new ir.nasim.ok6$j
            r2.<init>(r6)
            r5.E(r2)
            java.lang.Object r6 = r6.t()
            java.lang.Object r5 = ir.nasim.AbstractC13660gc3.e()
            if (r6 != r5) goto L70
            ir.nasim.WA1.c(r0)
        L70:
            if (r6 != r1) goto L73
            return r1
        L73:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18489ok6.X0(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y0(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C18489ok6.k
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.ok6$k r0 = (ir.nasim.C18489ok6.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.ok6$k r0 = new ir.nasim.ok6$k
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.do4 r5 = r4.b
            ir.nasim.Nv5 r5 = r5.E()
            r0.c = r3
            r2 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18489ok6.Y0(ir.nasim.rm1):java.lang.Object");
    }
}
