package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;
import java.util.Date;

/* renamed from: ir.nasim.Ce3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3748Ce3 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final SettingsModule a;
    private final InterfaceC3570Bk5 b;

    /* renamed from: ir.nasim.Ce3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C3748Ce3(SettingsModule settingsModule, InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC3570Bk5, "mainConfig");
        this.a = settingsModule;
        this.b = interfaceC3570Bk5;
    }

    public final boolean a() {
        return new Date().getTime() - this.b.getLong("LAST_PRESENCES_SYNC_TIME", 0L) >= this.a.t1();
    }
}
