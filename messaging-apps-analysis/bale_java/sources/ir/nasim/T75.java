package ir.nasim;

import ir.nasim.P75;
import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes4.dex */
public final class T75 {
    public static final int c = SettingsModule.W4;
    private final SettingsModule a;
    private final P75.a b;

    public T75(SettingsModule settingsModule, P75.a aVar) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(aVar, "phoneContactDataLoader");
        this.a = settingsModule;
        this.b = aVar;
    }

    public final S75 a(String str, boolean z) {
        return new S75((this.a.K5() && C8386Vt0.a8() && z) ? this.b.a(str) : ir.nasim.contact.data.d.a.a());
    }
}
