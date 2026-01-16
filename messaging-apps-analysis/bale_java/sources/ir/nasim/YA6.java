package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes7.dex */
public final class YA6 {
    public static final int b = SettingsModule.W4;
    private final SettingsModule a;

    public YA6(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.a = settingsModule;
    }

    public final boolean a() {
        if (C8386Vt0.u8()) {
            return (C8386Vt0.a.Pb() && this.a.g4()) || this.a.d4();
        }
        return false;
    }
}
