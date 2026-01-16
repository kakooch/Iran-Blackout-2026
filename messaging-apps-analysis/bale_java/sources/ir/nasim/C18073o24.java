package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.o24, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C18073o24 extends AbstractC4177Ea0 {
    private final InterfaceC18664p24 f;

    /* renamed from: ir.nasim.o24$a */
    class a extends ArrayList {
        final /* synthetic */ C14733iO2 a;

        a(C14733iO2 c14733iO2) {
            this.a = c14733iO2;
            add(new C25238zy(c14733iO2.r(), 0L));
        }
    }

    /* renamed from: ir.nasim.o24$c */
    class c implements InterfaceC15419jZ0 {
        final /* synthetic */ C24119y45 a;

        c(C24119y45 c24119y45) {
            this.a = c24119y45;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C14505i18 c14505i18) {
            C18073o24.this.f.F(this.a);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C18073o24.this.f.q(exc);
        }
    }

    public C18073o24(InterfaceC18664p24 interfaceC18664p24) {
        super(interfaceC18664p24);
        this.f = interfaceC18664p24;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(C14733iO2 c14733iO2, int i, C14505i18 c14505i18) {
        InterfaceC14830iZ0 interfaceC14830iZ0N1 = AbstractC5969Lp4.d().n1(c14733iO2.r(), i);
        if (interfaceC14830iZ0N1 != null) {
            interfaceC14830iZ0N1.a(new b());
        }
    }

    public void h(final C14733iO2 c14733iO2, final int i) {
        if (c14733iO2 == null) {
            return;
        }
        (c14733iO2.z().b() == null ? AbstractC5969Lp4.d().o2().V().X(new ArrayList(), new a(c14733iO2)) : C6517Nv5.l0(C14505i18.a)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.n24
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.i(c14733iO2, i, (C14505i18) obj);
            }
        });
    }

    public void j(int i, int i2, C24119y45 c24119y45) {
        InterfaceC14830iZ0 interfaceC14830iZ0T1 = AbstractC5969Lp4.d().t1(i, i2, c24119y45);
        if (interfaceC14830iZ0T1 != null) {
            interfaceC14830iZ0T1.a(new c(c24119y45));
        }
    }

    /* renamed from: ir.nasim.o24$b */
    class b implements InterfaceC15419jZ0 {
        b() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C24119y45 c24119y45) {
            if (c24119y45 != null) {
                C18073o24.this.f.P(c24119y45);
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
        }
    }
}
