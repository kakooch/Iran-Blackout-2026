package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes7.dex */
public final class NJ1 {
    public static final a d = new a(null);
    public static final int e = C10299bQ2.j | SettingsModule.W4;
    private final SettingsModule a;
    private final C10299bQ2 b;
    private final String c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public NJ1(SettingsModule settingsModule, C10299bQ2 c10299bQ2, String str) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(str, "productFlavor");
        this.a = settingsModule;
        this.b = c10299bQ2;
        this.c = str;
    }

    private final boolean b() {
        return this.a.B5(EnumC4196Ec1.E0) && this.b.X1().a(274070295L) != null;
    }

    private final boolean c() {
        return this.a.B5(EnumC4196Ec1.E0) && b() && (AbstractC13042fc3.d(this.c, "productionBeta") || AbstractC13042fc3.d(this.c, "dev"));
    }

    public final boolean a() {
        return c();
    }
}
