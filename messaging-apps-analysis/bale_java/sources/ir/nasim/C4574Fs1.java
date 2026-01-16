package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.Fs1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4574Fs1 extends VW7 {
    public static final int c = SettingsModule.W4;
    private final SettingsModule b;

    public C4574Fs1(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = settingsModule;
    }

    public final String P0(boolean z) {
        return z ? this.b.y0() : this.b.A1();
    }
}
