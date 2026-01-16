package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.root.C13090h;

/* loaded from: classes5.dex */
public final class JF2 {
    private final SettingsModule a;

    public JF2(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.a = settingsModule;
    }

    public final int a() {
        int iH1 = this.a.H1(0);
        if (iH1 == 3 || iH1 == 4) {
            iH1 = 1;
        }
        if (iH1 > C13090h.INSTANCE.c() || iH1 < 0) {
            return 0;
        }
        return iH1;
    }
}
