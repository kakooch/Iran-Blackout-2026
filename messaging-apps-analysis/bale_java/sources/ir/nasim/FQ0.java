package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes7.dex */
public final class FQ0 extends VW7 {
    private final SettingsModule b;
    private final InterfaceC9336Zm4 c;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return FQ0.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            FQ0.this.b.u7(this.d);
            InterfaceC9336Zm4 interfaceC9336Zm4 = FQ0.this.c;
            boolean z = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, ((EQ0) value).a(z)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public FQ0(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = settingsModule;
        this.c = AbstractC12281eL6.a(new EQ0(settingsModule.M5()));
    }

    public final InterfaceC10258bL6 S0() {
        return this.c;
    }

    public final void T0(boolean z) {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(z, null), 3, null);
    }
}
