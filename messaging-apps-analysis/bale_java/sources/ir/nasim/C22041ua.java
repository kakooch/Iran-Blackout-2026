package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.ua, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C22041ua extends AbstractC4177Ea0 {
    private final InterfaceC22631va f;

    /* renamed from: ir.nasim.ua$a */
    class a extends ArrayList {
        final /* synthetic */ C14733iO2 a;

        a(C14733iO2 c14733iO2) {
            this.a = c14733iO2;
            add(new C25238zy(c14733iO2.r(), 0L));
        }
    }

    /* renamed from: ir.nasim.ua$c */
    class c implements InterfaceC15419jZ0 {
        final /* synthetic */ C24119y45 a;

        c(C24119y45 c24119y45) {
            this.a = c24119y45;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C14505i18 c14505i18) {
            C22041ua.this.f.F(this.a);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C22041ua.this.f.q(exc);
        }
    }

    /* renamed from: ir.nasim.ua$d */
    class d implements InterfaceC15419jZ0 {
        final /* synthetic */ C24119y45 a;

        d(C24119y45 c24119y45) {
            this.a = c24119y45;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C14505i18 c14505i18) {
            C22041ua.this.f.F(this.a);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C22041ua.this.f.q(exc);
        }
    }

    public C22041ua(InterfaceC22631va interfaceC22631va) {
        super(interfaceC22631va);
        this.f = interfaceC22631va;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(C14733iO2 c14733iO2, int i, C14505i18 c14505i18) {
        InterfaceC14830iZ0 interfaceC14830iZ0N1 = AbstractC5969Lp4.d().n1(c14733iO2.r(), i);
        if (interfaceC14830iZ0N1 != null) {
            interfaceC14830iZ0N1.a(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(boolean z, Exception exc) {
        if (z) {
            return;
        }
        this.f.q(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(boolean z, C24119y45 c24119y45, C14505i18 c14505i18) {
        if (z) {
            return;
        }
        this.f.F(c24119y45);
    }

    public void j(final C14733iO2 c14733iO2, final int i) {
        if (c14733iO2 == null) {
            return;
        }
        (c14733iO2.z().b() == null ? AbstractC5969Lp4.d().o2().V().X(new ArrayList(), new a(c14733iO2)) : C6517Nv5.l0(C14505i18.a)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.ra
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.k(c14733iO2, i, (C14505i18) obj);
            }
        });
    }

    public void n(int i, int i2, String str, C24119y45 c24119y45) {
        InterfaceC14830iZ0 interfaceC14830iZ0P1 = AbstractC5969Lp4.d().p1(i, i2, str, c24119y45);
        if (interfaceC14830iZ0P1 != null) {
            interfaceC14830iZ0P1.a(new d(c24119y45));
        }
    }

    public void o(int i, int i2, C24119y45 c24119y45) {
        InterfaceC14830iZ0 interfaceC14830iZ0T1 = AbstractC5969Lp4.d().t1(i, i2, c24119y45);
        if (interfaceC14830iZ0T1 != null) {
            interfaceC14830iZ0T1.a(new c(c24119y45));
        }
    }

    public void p(int i, int i2, String str, final C24119y45 c24119y45, final boolean z) {
        C6517Nv5 c6517Nv5U1 = AbstractC5969Lp4.d().u1(i, i2, str);
        if (c6517Nv5U1 != null) {
            c6517Nv5U1.E(new InterfaceC24449ye1() { // from class: ir.nasim.sa
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.l(z, (Exception) obj);
                }
            }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.ta
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.m(z, c24119y45, (C14505i18) obj);
                }
            });
        }
    }

    /* renamed from: ir.nasim.ua$b */
    class b implements InterfaceC15419jZ0 {
        b() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C24119y45 c24119y45) {
            if (c24119y45 != null) {
                C22041ua.this.f.P(c24119y45);
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
        }
    }
}
