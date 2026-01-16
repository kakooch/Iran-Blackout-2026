package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.jG2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15250jG2 {
    private final PE a;
    private final Context b;
    private final C22481vJ2 c;

    /* renamed from: ir.nasim.jG2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(4, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            Boolean bool = (Boolean) this.c;
            return (bool.booleanValue() || ((Boolean) this.d).booleanValue()) ? !bool.booleanValue() ? EnumC23849xd1.d : C4100Dr4.a(C15250jG2.this.b) ? EnumC23849xd1.c : EnumC23849xd1.e : EnumC23849xd1.b;
        }

        @Override // ir.nasim.InterfaceC16978mB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object e(Boolean bool, Boolean bool2, EnumC19739qr4 enumC19739qr4, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C15250jG2.this.new a(interfaceC20295rm1);
            aVar.c = bool;
            aVar.d = bool2;
            return aVar.invokeSuspend(C19938rB7.a);
        }
    }

    public C15250jG2(PE pe, Context context) {
        AbstractC13042fc3.i(pe, "appStateModule");
        AbstractC13042fc3.i(context, "context");
        this.a = pe;
        this.b = context;
        this.c = pe.E();
    }

    public final InterfaceC4557Fq2 b() {
        C8512Wh0 c8512Wh0F = this.c.f();
        AbstractC13042fc3.h(c8512Wh0F, "getIsConnecting(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A = AbstractC23145wQ7.a(c8512Wh0F);
        C8512Wh0 c8512Wh0G = this.c.g();
        AbstractC13042fc3.h(c8512Wh0G, "getIsSyncing(...)");
        InterfaceC4557Fq2 interfaceC4557Fq2A2 = AbstractC23145wQ7.a(c8512Wh0G);
        C19482qQ7 c19482qQ7H = this.c.h();
        AbstractC13042fc3.h(c19482qQ7H, "getNetworkState(...)");
        return AbstractC6459Nq2.o(interfaceC4557Fq2A, interfaceC4557Fq2A2, AbstractC23145wQ7.a(c19482qQ7H), new a(null));
    }
}
