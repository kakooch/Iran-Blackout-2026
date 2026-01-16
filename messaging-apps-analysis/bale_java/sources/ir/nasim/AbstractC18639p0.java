package ir.nasim;

import ir.nasim.AbstractC17757nW1;
import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.p0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18639p0 {
    private static final EnumC18310oS a(boolean z, boolean z2) {
        return (z && z2) ? EnumC18310oS.d : z ? EnumC18310oS.c : z2 ? EnumC18310oS.b : EnumC18310oS.a;
    }

    public static final void b(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC17757nW1.c.b.f.a(a(settingsModule.l5(), settingsModule.q5()));
        AbstractC17757nW1.c.a.f.a(a(settingsModule.k5(), settingsModule.p5()));
        AbstractC17757nW1.c.d.g.a(a(settingsModule.m5(), settingsModule.r5()));
        AbstractC17757nW1.a.i.a(a(settingsModule.n5(), settingsModule.s5()));
        AbstractC17757nW1.b.e.b(a(settingsModule.j5(), settingsModule.o5()));
    }
}
