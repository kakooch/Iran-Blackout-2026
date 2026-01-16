package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes6.dex */
public final class RD3 extends VW7 {
    private final SettingsModule b;
    private final androidx.lifecycle.y c;

    public RD3(SettingsModule settingsModule, androidx.lifecycle.y yVar) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(yVar, "savedStateHandle");
        this.b = settingsModule;
        this.c = yVar;
    }

    private final String P0(long j, int i) {
        String str = this.b.S2() + "?liveKey=" + j + "&eventOpenType=" + i;
        AbstractC13042fc3.h(str, "toString(...)");
        return str;
    }

    private final String S0(String str, int i) {
        String str2 = str + "&eventOpenType=" + i;
        AbstractC13042fc3.h(str2, "toString(...)");
        return str2;
    }

    public final String R0() {
        Integer num = (Integer) this.c.c("ARG_OPEN_SOURCE");
        Long l = (Long) this.c.c("ARG_LIVE_KEY");
        String str = (String) this.c.c("ARG_URL");
        if (num == null) {
            return null;
        }
        if (l != null) {
            return P0(l.longValue(), num.intValue());
        }
        if (str != null) {
            return S0(str, num.intValue());
        }
        return null;
    }
}
