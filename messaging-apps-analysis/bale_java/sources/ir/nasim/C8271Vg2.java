package ir.nasim;

import ir.nasim.InterfaceC10676c07;
import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.Vg2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8271Vg2 extends VW7 {
    private final SettingsModule b;
    private final InterfaceC9336Zm4 c;
    private final InterfaceC10258bL6 d;

    public C8271Vg2(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = settingsModule;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(InterfaceC10676c07.c.a);
        this.c = interfaceC9336Zm4A;
        this.d = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    public final void P0(boolean z) {
        this.b.h7(z);
    }

    public final InterfaceC10258bL6 R0() {
        return this.d;
    }

    public final void S0(EnumC7123Qj2 enumC7123Qj2, String str) {
        Object value;
        Object value2;
        AbstractC13042fc3.i(enumC7123Qj2, "feedBackRate");
        AbstractC13042fc3.i(str, "opinion");
        if (enumC7123Qj2 != EnumC7123Qj2.i || !C8386Vt0.a.D4() || this.b.P5() || this.b.G5()) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, InterfaceC10676c07.a.a));
        } else {
            if (this.b.C5()) {
                this.b.h7(true);
            } else {
                this.b.Q6(true);
            }
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.c;
            do {
                value2 = interfaceC9336Zm42.getValue();
            } while (!interfaceC9336Zm42.f(value2, new InterfaceC10676c07.d(this.b.G5())));
        }
        C6879Pj2.a.s(str, enumC7123Qj2.q());
    }

    public final void T0() {
        Object value;
        this.b.N7(true);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, InterfaceC10676c07.b.a));
    }
}
