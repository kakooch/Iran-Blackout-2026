package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.util.Base64;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.iid.h;
import ir.nasim.AbstractC3993Df5;

@Deprecated
/* loaded from: classes3.dex */
public class GcmReceiver extends WakefulBroadcastReceiver {
    private static h c;
    private static h d;

    private final int d(Context context, Intent intent) {
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "Binding to service");
        }
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
        e(context, intent.getAction()).a(intent, goAsync());
        return -1;
    }

    private final synchronized h e(Context context, String str) {
        try {
            if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
                if (d == null) {
                    d = new h(context, str);
                }
                return d;
            }
            if (c == null) {
                c = new h(context, str);
            }
            return c;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static int f(Context context, Intent intent) {
        ComponentName componentNameStartService;
        ServiceInfo serviceInfo;
        String strConcat;
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "Starting service");
        }
        ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null) {
            Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
        } else if (!context.getPackageName().equals(serviceInfo.packageName) || (strConcat = serviceInfo.name) == null) {
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 94 + String.valueOf(str2).length());
            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb.append(str);
            sb.append(Separators.SLASH);
            sb.append(str2);
            Log.e("GcmReceiver", sb.toString());
        } else {
            if (strConcat.startsWith(Separators.DOT)) {
                String strValueOf = String.valueOf(context.getPackageName());
                strConcat = strConcat.length() != 0 ? strValueOf.concat(strConcat) : new String(strValueOf);
            }
            if (Log.isLoggable("GcmReceiver", 3)) {
                String strValueOf2 = String.valueOf(strConcat);
                Log.d("GcmReceiver", strValueOf2.length() != 0 ? "Restricting intent to a specific service: ".concat(strValueOf2) : new String("Restricting intent to a specific service: "));
            }
            intent.setClassName(context.getPackageName(), strConcat);
        }
        try {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                componentNameStartService = WakefulBroadcastReceiver.c(context, intent);
            } else {
                componentNameStartService = context.startService(intent);
                Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService != null) {
                return -1;
            }
            Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (IllegalStateException e) {
            String strValueOf3 = String.valueOf(e);
            StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 45);
            sb2.append("Failed to start service while in background: ");
            sb2.append(strValueOf3);
            Log.e("GcmReceiver", sb2.toString());
            return 402;
        } catch (SecurityException e2) {
            Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", e2);
            return 401;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int iD;
        if (Log.isLoggable("GcmReceiver", 3)) {
            Log.d("GcmReceiver", "received new intent");
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (isOrderedBroadcast()) {
            setResultCode(SIPTransactionStack.BASE_TIMER_INTERVAL);
        }
        boolean z = AbstractC3993Df5.h() && context.getApplicationInfo().targetSdkVersion >= 26;
        boolean z2 = (intent.getFlags() & 268435456) != 0;
        if (!z || z2) {
            int iF = "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction()) ? f(context, intent) : f(context, intent);
            if (AbstractC3993Df5.h() && iF == 402) {
                d(context, intent);
                iD = 403;
            } else {
                iD = iF;
            }
        } else {
            iD = d(context, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(iD);
        }
    }
}
