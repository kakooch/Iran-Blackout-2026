package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.iid.zze;
import ir.nasim.C11364cs8;
import ir.nasim.Ir8;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class GcmListenerService extends zze {
    private Ir8 f = C11364cs8.a;

    static void g(Bundle bundle) {
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    public void c() {
    }

    public void d(String str, Bundle bundle) {
    }

    public void e(String str) {
    }

    public void f(String str, String str2) {
    }

    @Override // com.google.android.gms.iid.zze
    public void handleIntent(Intent intent) {
        String stringExtra;
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            String strValueOf = String.valueOf(intent.getAction());
            Log.w("GcmListenerService", strValueOf.length() != 0 ? "Unknown intent action: ".concat(strValueOf) : new String("Unknown intent action: "));
        }
        stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        switch (stringExtra) {
            case "deleted_messages":
                c();
                break;
            case "gcm":
                Bundle extras = intent.getExtras();
                extras.remove("message_type");
                extras.remove("androidx.contentpager.content.wakelockid");
                if ("1".equals(c.b(extras, "gcm.n.e")) || c.b(extras, "gcm.n.icon") != null) {
                    if (!((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                        int iMyPid = Process.myPid();
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
                        if (runningAppProcesses != null) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    ActivityManager.RunningAppProcessInfo next = it.next();
                                    if (next.pid == iMyPid) {
                                        if (next.importance == 100) {
                                            Bundle bundle = new Bundle();
                                            Iterator<String> it2 = extras.keySet().iterator();
                                            while (it2.hasNext()) {
                                                String next2 = it2.next();
                                                String string = extras.getString(next2);
                                                if (next2.startsWith("gcm.notification.")) {
                                                    next2 = next2.replace("gcm.notification.", "gcm.n.");
                                                }
                                                if (next2.startsWith("gcm.n.")) {
                                                    if (!"gcm.n.e".equals(next2)) {
                                                        bundle.putString(next2.substring(6), string);
                                                    }
                                                    it2.remove();
                                                }
                                            }
                                            String string2 = bundle.getString("sound2");
                                            if (string2 != null) {
                                                bundle.remove("sound2");
                                                bundle.putString("sound", string2);
                                            }
                                            if (!bundle.isEmpty()) {
                                                extras.putBundle("notification", bundle);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    c.a(this).d(extras);
                    break;
                }
                String string3 = extras.getString("from");
                extras.remove("from");
                g(extras);
                this.f.a("onMessageReceived");
                d(string3, extras);
                break;
            case "send_error":
                String stringExtra2 = intent.getStringExtra("google.message_id");
                if (stringExtra2 == null) {
                    stringExtra2 = intent.getStringExtra("message_id");
                }
                f(stringExtra2, intent.getStringExtra("error"));
                break;
            case "send_event":
                e(intent.getStringExtra("google.message_id"));
                break;
            default:
                Log.w("GcmListenerService", stringExtra.length() != 0 ? "Received message with unknown type: ".concat(stringExtra) : new String("Received message with unknown type: "));
                break;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C11364cs8.a();
        this.f = C11364cs8.a;
    }
}
