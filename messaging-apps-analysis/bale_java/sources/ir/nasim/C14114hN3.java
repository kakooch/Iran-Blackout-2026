package ir.nasim;

import android.app.NotificationManager;
import android.os.Build;
import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.hN3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14114hN3 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final SettingsModule a;
    private final NotificationManager b;

    /* renamed from: ir.nasim.hN3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C14114hN3(SettingsModule settingsModule, NotificationManager notificationManager) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(notificationManager, "notificationManagerCompat");
        this.a = settingsModule;
        this.b = notificationManager;
    }

    private final boolean b() {
        return this.b.areNotificationsEnabled() && this.b.canUseFullScreenIntent();
    }

    public final void a() {
        if (Build.VERSION.SDK_INT < 34) {
            this.a.c6(false);
            return;
        }
        boolean zB = b();
        C19406qI3.a("ManageAndroid14NotificationUseCase", "device have full screen permission " + zB, new Object[0]);
        this.a.c6(zB ^ true);
    }
}
