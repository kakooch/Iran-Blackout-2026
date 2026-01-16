package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.root.C13090h;

/* loaded from: classes7.dex */
public final class IF2 {
    public static final int b = SettingsModule.W4;
    private final SettingsModule a;

    public IF2(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.a = settingsModule;
    }

    private final int a(int i) {
        return 4 - i;
    }

    public final EnumC15002iq4 b() {
        int i = 0;
        int iH1 = this.a.H1(0);
        if (iH1 == 3 || iH1 == 4) {
            iH1 = 1;
        }
        if (iH1 <= C13090h.INSTANCE.c() && iH1 >= 0) {
            i = iH1;
        }
        int iA = a(i);
        EnumC15002iq4 enumC15002iq4 = EnumC15002iq4.d;
        if (iA == enumC15002iq4.j()) {
            return enumC15002iq4;
        }
        EnumC15002iq4 enumC15002iq42 = EnumC15002iq4.c;
        return iA == enumC15002iq42.j() ? enumC15002iq42 : EnumC15002iq4.b;
    }
}
