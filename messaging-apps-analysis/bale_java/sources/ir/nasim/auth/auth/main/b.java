package ir.nasim.auth.auth.main;

import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC9773aX7;
import ir.nasim.C12366eV1;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.VW7;
import ir.nasim.auth.auth.main.a;

/* loaded from: classes4.dex */
public final class b extends VW7 {
    private final InterfaceC3570Bk5 b;
    private final InterfaceC9336Zm4 c;
    private final InterfaceC10258bL6 d;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return b.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            boolean zH = b.this.S0().h("PREF_KEY_IS_IN_SING_UP", false);
            String strE = b.this.S0().e("PREF_KEY_TRANSACTION_HASH");
            InterfaceC9336Zm4 interfaceC9336Zm4 = b.this.c;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, (!zH || strE == null) ? a.b.a : new a.C0872a(strE)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public b(InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        this.b = interfaceC3570Bk5;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(a.b.a);
        this.c = interfaceC9336Zm4A;
        this.d = interfaceC9336Zm4A;
        R0();
    }

    private final InterfaceC13730gj3 R0() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new a(null), 2, null);
    }

    public final InterfaceC3570Bk5 S0() {
        return this.b;
    }

    public final InterfaceC10258bL6 T0() {
        return this.d;
    }
}
