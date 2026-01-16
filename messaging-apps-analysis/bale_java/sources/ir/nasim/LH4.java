package ir.nasim;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.messaging.RemoteMessage;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.W23;
import ir.nasim.features.MainActivity;
import java.util.Map;

/* loaded from: classes5.dex */
public final class LH4 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final InterfaceC9173Yu3 a = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.IH4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return LH4.s();
        }
    });
    private AbstractC16407lD4.e b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private final void d(Intent intent) {
        String stringExtra = intent.getStringExtra("buttonActionTitle");
        String stringExtra2 = intent.getStringExtra("buttonActionCommand");
        if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        intent.putExtra("firebase_banking_command", stringExtra2);
        AbstractC16407lD4.e eVar = this.b;
        if (eVar == null) {
            AbstractC13042fc3.y("customNotificationBuilder");
            eVar = null;
        }
        eVar.b(new AbstractC16407lD4.a(KB5.ic_stat_white_notif_icon, stringExtra, k(intent, C5721Ko.a.d())));
    }

    private final void e(Intent intent) {
        String stringExtra = intent.getStringExtra("image");
        if (stringExtra != null) {
            if (!(!AbstractC20762sZ6.n0(stringExtra))) {
                stringExtra = null;
            }
            if (stringExtra != null) {
                q(stringExtra, new UA2() { // from class: ir.nasim.JH4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return LH4.f(this.a, (Bitmap) obj);
                    }
                }, new UA2() { // from class: ir.nasim.KH4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return LH4.g(this.a, (Throwable) obj);
                    }
                });
                return;
            }
        }
        x(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(LH4 lh4, Bitmap bitmap) {
        AbstractC13042fc3.i(lh4, "this$0");
        AbstractC13042fc3.i(bitmap, "bitmap");
        lh4.x(bitmap);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(LH4 lh4, Throwable th) {
        String name;
        AbstractC13042fc3.i(lh4, "this$0");
        lh4.x(null);
        if (LH4.class.isAnonymousClass()) {
            name = LH4.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = LH4.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.d(name, th);
        return C19938rB7.a;
    }

    private final void h(Context context, Intent intent) {
        this.b = r(context, intent.getStringExtra("title"), intent.getStringExtra(ParameterNames.TEXT), intent);
    }

    private final void i(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            j(context);
        }
        h(context, intent);
        d(intent);
        e(intent);
        u(intent);
    }

    private final void j(Context context) {
        EE4.a();
        NotificationChannel notificationChannelA = ZC4.a("n_custom_notification", context.getString(AbstractC12217eE5.custum_notification_channel_name), 4);
        v(context, notificationChannelA);
        n().createNotificationChannel(notificationChannelA);
    }

    private final PendingIntent k(Intent intent, Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            PendingIntent activity = PendingIntent.getActivity(context, 56465465, intent, 167772160);
            AbstractC13042fc3.f(activity);
            return activity;
        }
        PendingIntent activity2 = PendingIntent.getActivity(context, 56465465, intent, 134217728);
        AbstractC13042fc3.f(activity2);
        return activity2;
    }

    private final Intent l(RemoteMessage remoteMessage) {
        Intent intentS = remoteMessage.S();
        intentS.setClass(C5721Ko.a.d(), MainActivity.class);
        intentS.addFlags(67108864);
        AbstractC13042fc3.f(intentS);
        return intentS;
    }

    private final AbstractC16407lD4.e m(Context context, PendingIntent pendingIntent) {
        AbstractC16407lD4.e eVar = new AbstractC16407lD4.e(context, "n_custom_notification");
        eVar.K(KB5.ic_stat_white_notif_icon);
        eVar.R(1);
        String strE = C7183Qq.p().e("NOTIFICATION_DEFAULT_SOUND");
        if (p() && strE != null) {
            eVar.L(Uri.parse(strE));
        }
        eVar.f(true);
        w(eVar);
        eVar.l(pendingIntent);
        if (AbstractC5969Lp4.d().y0()) {
            eVar.A(-16711936, 700, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        }
        eVar.F(4);
        return eVar;
    }

    private final NotificationManager n() {
        return (NotificationManager) this.a.getValue();
    }

    private final void o(RemoteMessage remoteMessage) {
        i(C5721Ko.a.d(), l(remoteMessage));
    }

    private final boolean p() {
        return C7183Qq.p().h("notif_sound_enabled", true);
    }

    private final void q(String str, UA2 ua2, UA2 ua22) {
        try {
            C5721Ko c5721Ko = C5721Ko.a;
            AbstractC23507x23.a(c5721Ko.d()).d(new W23.a(c5721Ko.d()).d(str).g(new b(ua22, ua22, ua2)).a());
        } catch (Exception e) {
            ua22.invoke(e);
        }
    }

    private final AbstractC16407lD4.e r(Context context, String str, String str2, Intent intent) {
        AbstractC16407lD4.e eVarM = m(context, k(intent, context)).n(str).m(str2);
        AbstractC13042fc3.h(eVarM, "setContentText(...)");
        return eVarM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager s() {
        Object systemService = C5721Ko.a.d().getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    private final void u(Intent intent) {
        String name;
        if (AbstractC13042fc3.d(intent.getStringExtra("google.c.a.m_l"), "marketing")) {
            try {
                XV4 xv4A = AbstractC4616Fw7.a("action_type", 1);
                String stringExtra = intent.getStringExtra("title");
                String str = "";
                if (stringExtra == null) {
                    stringExtra = "";
                }
                XV4 xv4A2 = AbstractC4616Fw7.a("message_type", stringExtra);
                String stringExtra2 = intent.getStringExtra(ParameterNames.TEXT);
                if (stringExtra2 != null) {
                    str = stringExtra2;
                }
                C3343Am.i("push", AbstractC20051rO3.n(xv4A, xv4A2, AbstractC4616Fw7.a("msg_info", str)));
            } catch (Exception e) {
                if (LH4.class.isAnonymousClass()) {
                    name = LH4.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = LH4.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.b(name, e.toString());
            }
        }
    }

    private final void v(Context context, NotificationChannel notificationChannel) {
        String strE = C7183Qq.p().e("NOTIFICATION_DEFAULT_SOUND");
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(5).build();
        if (!p()) {
            notificationChannel.setSound(null, audioAttributesBuild);
            return;
        }
        if (strE != null) {
            notificationChannel.setSound(Uri.parse(strE), audioAttributesBuild);
            return;
        }
        notificationChannel.setSound(Uri.parse("android.resource://" + context.getPackageName() + Separators.SLASH + AbstractC19954rD5.notification), audioAttributesBuild);
    }

    private final void w(AbstractC16407lD4.e eVar) {
        eVar.w("ir.nasim.bale.group.notification");
    }

    private final void x(Bitmap bitmap) {
        AbstractC16407lD4.e eVar = null;
        if (bitmap != null) {
            AbstractC16407lD4.e eVar2 = this.b;
            if (eVar2 == null) {
                AbstractC13042fc3.y("customNotificationBuilder");
                eVar2 = null;
            }
            eVar2.M(new AbstractC16407lD4.b().p(bitmap));
        }
        NotificationManager notificationManagerN = n();
        AbstractC16407lD4.e eVar3 = this.b;
        if (eVar3 == null) {
            AbstractC13042fc3.y("customNotificationBuilder");
        } else {
            eVar = eVar3;
        }
        notificationManagerN.notify(7867867, eVar.c());
        C19406qI3.a("PushHandler", "Display marketing push is done.", new Object[0]);
    }

    public final void t(RemoteMessage remoteMessage, Map map) {
        String name;
        String name2;
        String name3;
        String name4;
        String name5;
        AbstractC13042fc3.i(remoteMessage, "remoteMessage");
        AbstractC13042fc3.i(map, "data");
        if (map.containsKey("newConnections")) {
            if (LH4.class.isAnonymousClass()) {
                name4 = LH4.class.getName();
                int length = name4.length();
                AbstractC13042fc3.f(name4);
                if (length > 23) {
                    name4 = name4.substring(name4.length() - 23, name4.length());
                    AbstractC13042fc3.h(name4, "substring(...)");
                }
            } else {
                name4 = LH4.class.getSimpleName();
                int length2 = name4.length();
                AbstractC13042fc3.f(name4);
                if (length2 > 23) {
                    name4 = name4.substring(0, 23);
                    AbstractC13042fc3.h(name4, "substring(...)");
                }
            }
            C19406qI3.j(name4, "NewConnections received", new Object[0]);
            try {
                LZ2 lz2C = C5735Kp4.w().i().Y().s().H().c();
                Object obj = map.get("newConnections");
                AbstractC13042fc3.f(obj);
                byte[] bytes = ((String) obj).getBytes(C12275eL0.b);
                AbstractC13042fc3.h(bytes, "getBytes(...)");
                lz2C.b(bytes, (String) map.get("sign"));
                return;
            } catch (Exception e) {
                if (LH4.class.isAnonymousClass()) {
                    name5 = LH4.class.getName();
                    int length3 = name5.length();
                    AbstractC13042fc3.f(name5);
                    if (length3 > 23) {
                        name5 = name5.substring(name5.length() - 23, name5.length());
                        AbstractC13042fc3.h(name5, "substring(...)");
                    }
                } else {
                    name5 = LH4.class.getSimpleName();
                    int length4 = name5.length();
                    AbstractC13042fc3.f(name5);
                    if (length4 > 23) {
                        name5 = name5.substring(0, 23);
                        AbstractC13042fc3.h(name5, "substring(...)");
                    }
                }
                C19406qI3.d(name5, e);
                return;
            }
        }
        if (map.containsKey("custom")) {
            if (LH4.class.isAnonymousClass()) {
                name = LH4.class.getName();
                int length5 = name.length();
                AbstractC13042fc3.f(name);
                if (length5 > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = LH4.class.getSimpleName();
                int length6 = name.length();
                AbstractC13042fc3.f(name);
                if (length6 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.a(name, "Received push notif with custom key (Marketing)", new Object[0]);
            try {
                if (!map.entrySet().isEmpty()) {
                    o(remoteMessage);
                    return;
                }
                if (LH4.class.isAnonymousClass()) {
                    name3 = LH4.class.getName();
                    if (name3.length() <= 23) {
                        AbstractC13042fc3.f(name3);
                    } else {
                        AbstractC13042fc3.f(name3);
                        name3 = name3.substring(name3.length() - 23, name3.length());
                        AbstractC13042fc3.h(name3, "substring(...)");
                    }
                } else {
                    name3 = LH4.class.getSimpleName();
                    if (name3.length() <= 23) {
                        AbstractC13042fc3.f(name3);
                    } else {
                        AbstractC13042fc3.f(name3);
                        name3 = name3.substring(0, 23);
                        AbstractC13042fc3.h(name3, "substring(...)");
                    }
                }
                C19406qI3.a(name3, "Marketing push return, because data entries is empty!", new Object[0]);
            } catch (Exception e2) {
                if (LH4.class.isAnonymousClass()) {
                    name2 = LH4.class.getName();
                    int length7 = name2.length();
                    AbstractC13042fc3.f(name2);
                    if (length7 > 23) {
                        name2 = name2.substring(name2.length() - 23, name2.length());
                        AbstractC13042fc3.h(name2, "substring(...)");
                    }
                } else {
                    name2 = LH4.class.getSimpleName();
                    int length8 = name2.length();
                    AbstractC13042fc3.f(name2);
                    if (length8 > 23) {
                        name2 = name2.substring(0, 23);
                        AbstractC13042fc3.h(name2, "substring(...)");
                    }
                }
                C19406qI3.c(name2, "Exception in handling marketing push", e2);
            }
        }
    }

    public static final class b implements W23.b {
        final /* synthetic */ UA2 c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ UA2 e;

        public b(UA2 ua2, UA2 ua22, UA2 ua23) {
            this.c = ua2;
            this.d = ua22;
            this.e = ua23;
        }

        @Override // ir.nasim.W23.b
        public void a(W23 w23) {
            this.c.invoke(null);
        }

        @Override // ir.nasim.W23.b
        public void c(W23 w23, I07 i07) {
            this.e.invoke(B02.b(i07.a(), 0, 0, null, 7, null));
        }

        @Override // ir.nasim.W23.b
        public void d(W23 w23, C12412ea2 c12412ea2) {
            this.d.invoke(c12412ea2.c());
        }

        @Override // ir.nasim.W23.b
        public void b(W23 w23) {
        }
    }
}
