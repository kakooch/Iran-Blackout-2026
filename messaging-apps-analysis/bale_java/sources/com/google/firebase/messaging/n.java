package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import ir.nasim.AbstractC18976pa2;
import ir.nasim.AbstractC9078Yj7;
import ir.nasim.C11515d82;
import ir.nasim.C5490Jo2;
import ir.nasim.InterfaceC19191pv7;
import ir.nasim.InterfaceC3816Cm;
import ir.nasim.InterfaceC6025Lv7;
import ir.nasim.V84;
import ir.nasim.W84;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public abstract class n {
    public static boolean A(Intent intent) {
        if (intent == null || r(intent)) {
            return false;
        }
        return B(intent.getExtras());
    }

    public static boolean B(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    static boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            C5490Jo2.k();
            Context contextJ = C5490Jo2.k().j();
            SharedPreferences sharedPreferences = contextJ.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = contextJ.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(contextJ.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    static V84 b(V84.b bVar, Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        V84.a aVarH = V84.p().m(p(extras)).e(bVar).f(f(extras)).i(m()).k(V84.d.ANDROID).h(k(extras));
        String strH = h(extras);
        if (strH != null) {
            aVarH.g(strH);
        }
        String strO = o(extras);
        if (strO != null) {
            aVarH.l(strO);
        }
        String strC = c(extras);
        if (strC != null) {
            aVarH.c(strC);
        }
        String strI = i(extras);
        if (strI != null) {
            aVarH.b(strI);
        }
        String strE = e(extras);
        if (strE != null) {
            aVarH.d(strE);
        }
        long jN = n(extras);
        if (jN > 0) {
            aVarH.j(jN);
        }
        return aVarH.a();
    }

    static String c(Bundle bundle) {
        return bundle.getString("collapse_key");
    }

    static String d(Bundle bundle) {
        return bundle.getString("google.c.a.c_id");
    }

    static String e(Bundle bundle) {
        return bundle.getString("google.c.a.c_l");
    }

    static String f(Bundle bundle) {
        String string = bundle.getString("google.to");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return (String) AbstractC9078Yj7.a(com.google.firebase.installations.c.q(C5490Jo2.k()).getId());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    static String g(Bundle bundle) {
        return bundle.getString("google.c.a.m_c");
    }

    static String h(Bundle bundle) {
        String string = bundle.getString("google.message_id");
        return string == null ? bundle.getString("message_id") : string;
    }

    static String i(Bundle bundle) {
        return bundle.getString("google.c.a.m_l");
    }

    static String j(Bundle bundle) {
        return bundle.getString("google.c.a.ts");
    }

    static V84.c k(Bundle bundle) {
        return (bundle == null || !p.t(bundle)) ? V84.c.DATA_MESSAGE : V84.c.DISPLAY_NOTIFICATION;
    }

    static String l(Bundle bundle) {
        return (bundle == null || !p.t(bundle)) ? "data" : "display";
    }

    static String m() {
        return C5490Jo2.k().j().getPackageName();
    }

    static long n(Bundle bundle) {
        if (bundle.containsKey("google.c.sender.id")) {
            try {
                return Long.parseLong(bundle.getString("google.c.sender.id"));
            } catch (NumberFormatException e) {
                Log.w("FirebaseMessaging", "error parsing project number", e);
            }
        }
        C5490Jo2 c5490Jo2K = C5490Jo2.k();
        String strD = c5490Jo2K.m().d();
        if (strD != null) {
            try {
                return Long.parseLong(strD);
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "error parsing sender ID", e2);
            }
        }
        String strC = c5490Jo2K.m().c();
        if (strC.startsWith("1:")) {
            String[] strArrSplit = strC.split(":");
            if (strArrSplit.length < 2) {
                return 0L;
            }
            String str = strArrSplit[1];
            if (str.isEmpty()) {
                return 0L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e3) {
                Log.w("FirebaseMessaging", "error parsing app ID", e3);
            }
        } else {
            try {
                return Long.parseLong(strC);
            } catch (NumberFormatException e4) {
                Log.w("FirebaseMessaging", "error parsing app ID", e4);
            }
        }
        return 0L;
    }

    static String o(Bundle bundle) {
        String string = bundle.getString("from");
        if (string == null || !string.startsWith("/topics/")) {
            return null;
        }
        return string;
    }

    static int p(Bundle bundle) {
        Object obj = bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    static String q(Bundle bundle) {
        if (bundle.containsKey("google.c.a.udt")) {
            return bundle.getString("google.c.a.udt");
        }
        return null;
    }

    private static boolean r(Intent intent) {
        return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction());
    }

    public static void s(Intent intent) {
        x("_nd", intent.getExtras());
    }

    public static void t(Intent intent) {
        x("_nf", intent.getExtras());
    }

    public static void u(Bundle bundle) {
        y(bundle);
        x("_no", bundle);
    }

    public static void v(Intent intent) {
        if (A(intent)) {
            x("_nr", intent.getExtras());
        }
        if (z(intent)) {
            w(V84.b.MESSAGE_DELIVERED, intent, FirebaseMessaging.s());
        }
    }

    private static void w(V84.b bVar, Intent intent, InterfaceC6025Lv7 interfaceC6025Lv7) {
        if (interfaceC6025Lv7 == null) {
            Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
            return;
        }
        V84 v84B = b(bVar, intent);
        if (v84B == null) {
            return;
        }
        try {
            interfaceC6025Lv7.a("FCM_CLIENT_EVENT_LOGGING", W84.class, C11515d82.b("proto"), new InterfaceC19191pv7() { // from class: ir.nasim.U84
                @Override // ir.nasim.InterfaceC19191pv7
                public final Object apply(Object obj) {
                    return ((W84) obj).c();
                }
            }).a(AbstractC18976pa2.d(W84.b().b(v84B).a()));
        } catch (RuntimeException e) {
            Log.w("FirebaseMessaging", "Failed to send big query analytics payload.", e);
        }
    }

    static void x(String str, Bundle bundle) {
        try {
            C5490Jo2.k();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String strD = d(bundle);
            if (strD != null) {
                bundle2.putString("_nmid", strD);
            }
            String strE = e(bundle);
            if (strE != null) {
                bundle2.putString("_nmn", strE);
            }
            String strI = i(bundle);
            if (!TextUtils.isEmpty(strI)) {
                bundle2.putString("label", strI);
            }
            String strG = g(bundle);
            if (!TextUtils.isEmpty(strG)) {
                bundle2.putString("message_channel", strG);
            }
            String strO = o(bundle);
            if (strO != null) {
                bundle2.putString("_nt", strO);
            }
            String strJ = j(bundle);
            if (strJ != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(strJ));
                } catch (NumberFormatException e) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
                }
            }
            String strQ = q(bundle);
            if (strQ != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(strQ));
                } catch (NumberFormatException e2) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e2);
                }
            }
            String strL = l(bundle);
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", strL);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Logging to scion event=" + str + " scionPayload=" + bundle2);
            }
            InterfaceC3816Cm interfaceC3816Cm = (InterfaceC3816Cm) C5490Jo2.k().i(InterfaceC3816Cm.class);
            if (interfaceC3816Cm != null) {
                interfaceC3816Cm.a("fcm", str, bundle2);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    private static void y(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!"1".equals(bundle.getString("google.c.a.tc"))) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                return;
            }
            return;
        }
        InterfaceC3816Cm interfaceC3816Cm = (InterfaceC3816Cm) C5490Jo2.k().i(InterfaceC3816Cm.class);
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
        }
        if (interfaceC3816Cm == null) {
            Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
            return;
        }
        String string = bundle.getString("google.c.a.c_id");
        interfaceC3816Cm.b("fcm", "_ln", string);
        Bundle bundle2 = new Bundle();
        bundle2.putString("source", "Firebase");
        bundle2.putString("medium", "notification");
        bundle2.putString("campaign", string);
        interfaceC3816Cm.a("fcm", "_cmp", bundle2);
    }

    public static boolean z(Intent intent) {
        if (intent == null || r(intent)) {
            return false;
        }
        return a();
    }
}
