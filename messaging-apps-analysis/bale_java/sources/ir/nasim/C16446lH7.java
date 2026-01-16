package ir.nasim;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import ir.nasim.AbstractC16407lD4;

/* renamed from: ir.nasim.lH7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16446lH7 {
    private static final a e = new a(null);
    public static final int f = 8;
    private final Context a;
    private final NotificationManager b;
    private AbstractC16407lD4.e c;
    private final int d;

    /* renamed from: ir.nasim.lH7$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C16446lH7(Context context, NotificationManager notificationManager) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(notificationManager, "notificationManager");
        this.a = context;
        this.b = notificationManager;
        this.d = 112000211;
    }

    private final AbstractC16407lD4.e a(AbstractC16407lD4.e eVar, YG7 yg7) {
        AbstractC16407lD4.e eVarG = eVar.n(this.a.getString(AbstractC12217eE5.nasim_upload_service_title, yg7.a())).G(100, AbstractC20723sV3.d(yg7.d() * 100), false);
        AbstractC13042fc3.h(eVarG, "setProgress(...)");
        return eVarG;
    }

    private final void b() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationChannel notificationChannel = this.b.getNotificationChannel("upload_channel");
        if (notificationChannel != null) {
            if (notificationChannel.getImportance() == 2) {
                return;
            } else {
                this.b.deleteNotificationChannel("upload_channel");
            }
        }
        EE4.a();
        NotificationChannel notificationChannelA = ZC4.a("upload_channel", "upload_channel", 2);
        notificationChannelA.setSound(null, null);
        notificationChannelA.enableVibration(false);
        notificationChannelA.enableLights(false);
        this.b.createNotificationChannel(notificationChannelA);
    }

    private final void c() {
        this.b.cancel(this.d);
    }

    private final void i(YG7 yg7) {
        NotificationManager notificationManager = this.b;
        int i = this.d;
        AbstractC16407lD4.e eVar = this.c;
        if (eVar == null) {
            AbstractC13042fc3.y("notificationBuilder");
            eVar = null;
        }
        notificationManager.notify(i, a(eVar, yg7).c());
    }

    public final Notification d() {
        AbstractC16407lD4.e eVar = this.c;
        if (eVar == null) {
            AbstractC13042fc3.y("notificationBuilder");
            eVar = null;
        }
        Notification notificationC = eVar.c();
        AbstractC13042fc3.h(notificationC, "build(...)");
        return notificationC;
    }

    public final int e() {
        return this.d;
    }

    public final void f() {
        b();
        this.c = new AbstractC16407lD4.e(this.a, "upload_channel").M(new AbstractC16407lD4.g()).h("progress").K(android.R.drawable.stat_sys_upload).F(-1).f(false).I(false).D(true).Q(null).J(true).L(null);
    }

    public final void g(PendingIntent pendingIntent) {
        AbstractC16407lD4.e eVar = this.c;
        if (eVar == null) {
            AbstractC13042fc3.y("notificationBuilder");
            eVar = null;
        }
        eVar.l(pendingIntent);
    }

    public final void h(YG7 yg7) {
        if (yg7 != null) {
            i(yg7);
        } else {
            c();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C16446lH7(Context context, NotificationManager notificationManager, int i, ED1 ed1) {
        if ((i & 2) != 0) {
            Object systemService = context.getSystemService("notification");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            notificationManager = (NotificationManager) systemService;
        }
        this(context, notificationManager);
    }
}
