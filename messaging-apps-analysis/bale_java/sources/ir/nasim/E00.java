package ir.nasim;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.os.Build;
import ir.nasim.AbstractC9599aE4;

/* loaded from: classes5.dex */
public final class E00 {
    private static String f;
    public static final E00 a = new E00();
    private static String b = "New_Bale_Notification";
    private static String c = "New_Bale_Gift_Notification";
    private static String d = "Bale_Silent_Notification";
    private static final InterfaceC9173Yu3 e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.D00
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return E00.n();
        }
    });
    public static final int g = 8;

    private E00() {
    }

    private final NotificationChannel b(NotificationManager notificationManager, Context context, AbstractC24063xz abstractC24063xz) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        String strI = i(context, abstractC24063xz);
        String strG = g(context, abstractC24063xz);
        String strH = h(abstractC24063xz);
        EE4.a();
        NotificationChannel notificationChannelA = ZC4.a(strH, strI, 4);
        notificationChannelA.setDescription(strG);
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(5).setContentType(2).build();
        AbstractC9599aE4.a aVar = AbstractC9599aE4.a;
        if (aVar.w()) {
            notificationChannelA.setSound(aVar.m(abstractC24063xz), audioAttributesBuild);
        }
        notificationChannelA.enableLights(aVar.s());
        notificationChannelA.setLightColor(-16711681);
        notificationChannelA.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannelA);
        return notificationChannelA;
    }

    public static /* synthetic */ void e(E00 e00, AbstractC24063xz abstractC24063xz, int i, Object obj) {
        if ((i & 1) != 0) {
            abstractC24063xz = null;
        }
        e00.d(abstractC24063xz);
    }

    private final String g(Context context, AbstractC24063xz abstractC24063xz) {
        if (abstractC24063xz == null || !((abstractC24063xz instanceof C21001sy) || (abstractC24063xz instanceof C22874vy))) {
            String string = context.getString(AbstractC12217eE5.default_notification_bale_sound__channel_description);
            AbstractC13042fc3.f(string);
            return string;
        }
        String string2 = context.getString(AbstractC12217eE5.gift_notification_bale_sound__channel_description);
        AbstractC13042fc3.f(string2);
        return string2;
    }

    private final String h(AbstractC24063xz abstractC24063xz) {
        if (abstractC24063xz == null || !((abstractC24063xz instanceof C21001sy) || (abstractC24063xz instanceof C22874vy))) {
            String str = b + AbstractC17026mG5.a.k();
            C7183Qq.q(EnumC18608ow5.e).putString("KEY_CHANNEL_ID", str);
            return str;
        }
        String str2 = c + AbstractC17026mG5.a.k();
        C7183Qq.q(EnumC18608ow5.e).putString("KEY_GIFT_CHANNEL_ID", str2);
        return str2;
    }

    private final String i(Context context, AbstractC24063xz abstractC24063xz) {
        if (abstractC24063xz == null || !((abstractC24063xz instanceof C21001sy) || (abstractC24063xz instanceof C22874vy))) {
            String string = context.getString(AbstractC12217eE5.default_notification_bale_sound_channel_name);
            AbstractC13042fc3.f(string);
            return string;
        }
        String string2 = context.getString(AbstractC12217eE5.gift_notification_bale_sound_channel_name);
        AbstractC13042fc3.f(string2);
        return string2;
    }

    private final NotificationManager k() {
        return (NotificationManager) e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager n() {
        Object systemService = C5721Ko.a.d().getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    public final void c(Context context, AbstractC24063xz abstractC24063xz) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        String strJ = j(abstractC24063xz);
        if (strJ == null || strJ.length() == 0 || k().getNotificationChannel(strJ) == null) {
            b(notificationManager, context, abstractC24063xz);
        } else if (AbstractC9599aE4.a.x()) {
            f(context, abstractC24063xz);
            b(notificationManager, context, abstractC24063xz);
        }
    }

    public final void d(AbstractC24063xz abstractC24063xz) {
        if (Build.VERSION.SDK_INT >= 26) {
            c(C5721Ko.a.d(), abstractC24063xz);
        }
    }

    public final void f(Context context, AbstractC24063xz abstractC24063xz) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).deleteNotificationChannel(j(abstractC24063xz));
    }

    public final String j(AbstractC24063xz abstractC24063xz) {
        return (abstractC24063xz == null || !((abstractC24063xz instanceof C21001sy) || (abstractC24063xz instanceof C22874vy))) ? C7183Qq.q(EnumC18608ow5.e).e("KEY_CHANNEL_ID") : C7183Qq.q(EnumC18608ow5.e).e("KEY_GIFT_CHANNEL_ID");
    }

    public final String l() {
        if (Build.VERSION.SDK_INT < 26) {
            return "";
        }
        NotificationManager notificationManager = (NotificationManager) C5721Ko.a.d().getSystemService(NotificationManager.class);
        if (f == null) {
            f = C7183Qq.p().e("KEY_SILENT_CHANNEL_ID");
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(f);
        if (notificationChannel != null && notificationChannel.getImportance() == 0) {
            notificationManager.deleteNotificationChannel(f);
            f = null;
            notificationChannel = null;
        }
        if (f == null) {
            f = d + AbstractC17026mG5.a.k();
            C7183Qq.p().putString("KEY_SILENT_CHANNEL_ID", f);
        }
        if (notificationChannel == null) {
            EE4.a();
            NotificationChannel notificationChannelA = ZC4.a(f, "Bale Internal notifications", 3);
            notificationChannelA.enableLights(false);
            notificationChannelA.enableVibration(false);
            notificationChannelA.setSound(null, null);
            try {
                notificationManager.createNotificationChannel(notificationChannelA);
            } catch (Exception e2) {
                C19406qI3.j("BaleNotificationChannel", "exception in getOtherNotificationsChannel: " + e2.getMessage(), new Object[0]);
            }
        }
        String str = f;
        AbstractC13042fc3.f(str);
        return str;
    }

    public final String m(Context context, AbstractC24063xz abstractC24063xz) {
        AbstractC13042fc3.i(context, "context");
        String strJ = j(abstractC24063xz);
        NotificationChannel notificationChannel = k().getNotificationChannel(strJ);
        if (strJ != null && notificationChannel != null) {
            return strJ;
        }
        c(context, abstractC24063xz);
        String strJ2 = j(abstractC24063xz);
        AbstractC13042fc3.f(strJ2);
        return strJ2;
    }

    public final boolean o() {
        return Build.VERSION.SDK_INT >= 26;
    }
}
