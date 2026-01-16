package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes6.dex */
public final class XA6 {
    public static final a b = new a(null);
    public static final int c = SettingsModule.W4;
    private final SettingsModule a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public XA6(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.a = settingsModule;
    }

    public final boolean a(long j, int i) {
        if (i != 1) {
            return false;
        }
        boolean z = !(System.currentTimeMillis() - j < this.a.X1());
        boolean z2 = System.currentTimeMillis() - j < this.a.X1();
        StringBuilder sb = new StringBuilder();
        sb.append("tab index: ");
        sb.append(i);
        sb.append(", hasBeenRefreshedRecently: ");
        sb.append(!z2);
        sb.append(Separators.SP);
        C19406qI3.g("ShouldRefreshFeedUseCase", sb.toString(), new Object[0]);
        return z;
    }
}
