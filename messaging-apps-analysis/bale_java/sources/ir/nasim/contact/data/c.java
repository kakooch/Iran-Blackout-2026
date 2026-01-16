package ir.nasim.contact.data;

import android.content.Context;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.C8386Vt0;
import ir.nasim.EnumC4715Gg1;
import ir.nasim.contact.data.a;
import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes4.dex */
public final class c {
    private final Context a;
    private final SettingsModule b;
    private final a.InterfaceC0987a c;
    private final e d;

    public c(Context context, SettingsModule settingsModule, a.InterfaceC0987a interfaceC0987a, e eVar) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC0987a, "baleContactDataLoaderFactory");
        AbstractC13042fc3.i(eVar, "phoneContactDataLoader");
        this.a = context;
        this.b = settingsModule;
        this.c = interfaceC0987a;
        this.d = eVar;
    }

    private final boolean b(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        return AbstractC20762sZ6.V(str, str2, true);
    }

    public final b a(boolean z, String str, int i, boolean z2, EnumC4715Gg1 enumC4715Gg1) {
        AbstractC13042fc3.i(enumC4715Gg1, "sortType");
        String string = this.a.getString(AbstractC12217eE5.settings_saved_messages);
        AbstractC13042fc3.h(string, "getString(...)");
        if (b(string, str) && i == 0) {
            i = 1;
        }
        return new b(i, this.c.a(str, z2, string, enumC4715Gg1), (this.b.K5() && C8386Vt0.a8() && z) ? this.d : d.a.a());
    }
}
