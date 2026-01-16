package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.z34, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C24698z34 extends AbstractC4177Ea0 {
    private final A34 f;

    /* renamed from: ir.nasim.z34$a */
    class a implements InterfaceC15419jZ0 {
        final /* synthetic */ Boolean a;
        final /* synthetic */ C24119y45 b;
        final /* synthetic */ Integer c;

        a(Boolean bool, C24119y45 c24119y45, Integer num) {
            this.a = bool;
            this.b = c24119y45;
            this.c = num;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C14505i18 c14505i18) {
            if (this.a.booleanValue()) {
                boolean zBooleanValue = false;
                int i = this.b.q() ? 4 : 0;
                if (this.b.p()) {
                    i += 2;
                }
                if (this.b.o()) {
                    i++;
                }
                Integer num = this.c;
                if (num == null) {
                    num = 0;
                } else {
                    C8512Wh0 c8512Wh0N = ((C14733iO2) AbstractC5969Lp4.e().E().Y1().n(num.longValue())).n();
                    if (c8512Wh0N != null) {
                        zBooleanValue = ((Boolean) c8512Wh0N.b()).booleanValue();
                    }
                }
                C3343Am.f(i, num.intValue(), zBooleanValue);
            }
            C24698z34.this.f.V1();
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C24698z34.this.f.f4(exc, true);
        }
    }

    /* renamed from: ir.nasim.z34$b */
    class b implements InterfaceC15419jZ0 {
        b() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            C24698z34.this.f.R1(list);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C24698z34.this.f.f4(exc, false);
        }
    }

    /* renamed from: ir.nasim.z34$c */
    class c implements InterfaceC15419jZ0 {
        final /* synthetic */ C23104wM2 a;

        c(C23104wM2 c23104wM2) {
            this.a = c23104wM2;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C14505i18 c14505i18) {
            C24698z34.this.f.R3(this.a);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C24698z34.this.f.f4(exc, false);
        }
    }

    public C24698z34(A34 a34) {
        super(a34);
        this.f = a34;
    }

    public void g(int i) {
        InterfaceC14830iZ0 interfaceC14830iZ0C0 = AbstractC5969Lp4.d().c0(i);
        if (interfaceC14830iZ0C0 != null) {
            interfaceC14830iZ0C0.a(new b());
        }
    }

    public void h(int i, C23104wM2 c23104wM2, C24119y45 c24119y45) {
        InterfaceC14830iZ0 interfaceC14830iZ0T1 = AbstractC5969Lp4.d().t1(i, c23104wM2.f(), c24119y45);
        if (interfaceC14830iZ0T1 != null) {
            interfaceC14830iZ0T1.a(new c(c23104wM2));
        }
    }

    public void i(int i, C24119y45 c24119y45, Boolean bool, Integer num) {
        InterfaceC14830iZ0 interfaceC14830iZ0S1 = AbstractC5969Lp4.d().s1(i, c24119y45);
        if (interfaceC14830iZ0S1 != null) {
            interfaceC14830iZ0S1.a(new a(bool, c24119y45, num));
        }
    }
}
