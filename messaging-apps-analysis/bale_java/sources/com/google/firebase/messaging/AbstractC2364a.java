package com.google.firebase.messaging;

import android.R;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.YZ0;
import ir.nasim.ZC4;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

/* renamed from: com.google.firebase.messaging.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2364a {
    private static final AtomicInteger a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* renamed from: com.google.firebase.messaging.a$a, reason: collision with other inner class name */
    public static class C0199a {
        public final AbstractC16407lD4.e a;
        public final String b;
        public final int c;

        C0199a(AbstractC16407lD4.e eVar, String str, int i) {
            this.a = eVar;
            this.b = str;
            this.c = i;
        }
    }

    private static PendingIntent a(Context context, p pVar, String str, PackageManager packageManager) {
        Intent intentF = f(str, pVar, packageManager);
        if (intentF == null) {
            return null;
        }
        intentF.addFlags(67108864);
        intentF.putExtras(pVar.y());
        if (q(pVar)) {
            intentF.putExtra("gcm.n.analytics_data", pVar.x());
        }
        return PendingIntent.getActivity(context, g(), intentF, l(1073741824));
    }

    private static PendingIntent b(Context context, Context context2, p pVar) {
        if (q(pVar)) {
            return c(context, context2, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(pVar.x()));
        }
        return null;
    }

    private static PendingIntent c(Context context, Context context2, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context2, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), l(1073741824));
    }

    public static C0199a d(Context context, Context context2, p pVar, String str, Bundle bundle) throws JSONException {
        String packageName = context2.getPackageName();
        Resources resources = context2.getResources();
        PackageManager packageManager = context2.getPackageManager();
        AbstractC16407lD4.e eVar = new AbstractC16407lD4.e(context2, str);
        String strN = pVar.n(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(strN)) {
            eVar.n(strN);
        }
        String strN2 = pVar.n(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(strN2)) {
            eVar.m(strN2);
            eVar.M(new AbstractC16407lD4.c().n(strN2));
        }
        eVar.K(m(packageManager, resources, packageName, pVar.p("gcm.n.icon"), bundle));
        Uri uriN = n(packageName, pVar, resources);
        if (uriN != null) {
            eVar.L(uriN);
        }
        eVar.l(a(context, pVar, packageName, packageManager));
        PendingIntent pendingIntentB = b(context, context2, pVar);
        if (pendingIntentB != null) {
            eVar.s(pendingIntentB);
        }
        Integer numH = h(context2, pVar.p("gcm.n.color"), bundle);
        if (numH != null) {
            eVar.j(numH.intValue());
        }
        eVar.f(!pVar.a("gcm.n.sticky"));
        eVar.B(pVar.a("gcm.n.local_only"));
        String strP = pVar.p("gcm.n.ticker");
        if (strP != null) {
            eVar.O(strP);
        }
        Integer numM = pVar.m();
        if (numM != null) {
            eVar.F(numM.intValue());
        }
        Integer numR = pVar.r();
        if (numR != null) {
            eVar.R(numR.intValue());
        }
        Integer numL = pVar.l();
        if (numL != null) {
            eVar.C(numL.intValue());
        }
        Long lJ = pVar.j("gcm.n.event_time");
        if (lJ != null) {
            eVar.I(true);
            eVar.S(lJ.longValue());
        }
        long[] jArrQ = pVar.q();
        if (jArrQ != null) {
            eVar.Q(jArrQ);
        }
        int[] iArrE = pVar.e();
        if (iArrE != null) {
            eVar.A(iArrE[0], iArrE[1], iArrE[2]);
        }
        eVar.r(i(pVar));
        return new C0199a(eVar, o(pVar), 0);
    }

    static C0199a e(Context context, p pVar) throws PackageManager.NameNotFoundException {
        Bundle bundleJ = j(context.getPackageManager(), context.getPackageName());
        return d(context, context, pVar, k(context, pVar.k(), bundleJ), bundleJ);
    }

    private static Intent f(String str, p pVar, PackageManager packageManager) {
        String strP = pVar.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(strP)) {
            Intent intent = new Intent(strP);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri uriF = pVar.f();
        if (uriF != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(uriF);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w("FirebaseMessaging", "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int g() {
        return a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                Log.w("FirebaseMessaging", "Color is invalid: " + str + ". Notification will use default color.");
            }
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i == 0) {
            return null;
        }
        try {
            return Integer.valueOf(AbstractC4043Dl1.c(context, i));
        } catch (Resources.NotFoundException unused2) {
            Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int i(p pVar) {
        boolean zA = pVar.a("gcm.n.default_sound");
        ?? r0 = zA;
        if (pVar.a("gcm.n.default_vibrate_timings")) {
            r0 = (zA ? 1 : 0) | 2;
        }
        return pVar.a("gcm.n.default_light_settings") ? r0 | 4 : r0;
    }

    private static Bundle j(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("FirebaseMessaging", "Couldn't get own application info: " + e);
        }
        return Bundle.EMPTY;
    }

    public static String k(Context context, String str, Bundle bundle) {
        String string;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                Log.w("FirebaseMessaging", "Notification Channel requested (" + str + ") has not been created by the app. Manifest configuration, or default, value will be used.");
            }
            String string2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string2)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else {
                if (notificationManager.getNotificationChannel(string2) != null) {
                    return string2;
                }
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName());
                if (identifier == 0) {
                    Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                    string = "Misc";
                } else {
                    string = context.getString(identifier);
                }
                notificationManager.createNotificationChannel(ZC4.a("fcm_fallback_notification_channel", string, 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static int l(int i) {
        return i | 67108864;
    }

    private static int m(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && p(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && p(resources, identifier2)) {
                return identifier2;
            }
            Log.w("FirebaseMessaging", "Icon resource " + str2 + " not found. Notification will use default icon.");
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !p(resources, i)) {
            try {
                i = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("FirebaseMessaging", "Couldn't get own application info: " + e);
            }
        }
        return (i == 0 || !p(resources, i)) ? R.drawable.sym_def_app_icon : i;
    }

    private static Uri n(String str, p pVar, Resources resources) {
        String strO = pVar.o();
        if (TextUtils.isEmpty(strO)) {
            return null;
        }
        if ("default".equals(strO) || resources.getIdentifier(strO, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        return Uri.parse("android.resource://" + str + "/raw/" + strO);
    }

    private static String o(p pVar) {
        String strP = pVar.p("gcm.n.tag");
        if (!TextUtils.isEmpty(strP)) {
            return strP;
        }
        return "FCM-Notification:" + SystemClock.uptimeMillis();
    }

    private static boolean p(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!YZ0.a(resources.getDrawable(i, null))) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + i + ", treating it as an invalid icon");
            return false;
        }
    }

    static boolean q(p pVar) {
        return pVar.a("google.c.a.e");
    }
}
