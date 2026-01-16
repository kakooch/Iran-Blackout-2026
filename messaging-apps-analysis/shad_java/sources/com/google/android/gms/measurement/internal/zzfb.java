package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzfb {
    private final zza zza;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzfb(zza zzaVar) {
        Preconditions.checkNotNull(zzaVar);
        this.zza = zzaVar;
    }

    public static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void zzb(Context context, Intent intent) {
        zzfl zzflVarZzC = zzfl.zzC(context, null, null);
        zzei zzeiVarZzat = zzflVarZzC.zzat();
        if (intent == null) {
            zzeiVarZzat.zze().zza("Receiver called with null intent");
            return;
        }
        zzflVarZzC.zzas();
        String action = intent.getAction();
        zzeiVarZzat.zzk().zzb("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                zzeiVarZzat.zze().zza("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzeiVarZzat.zzk().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
        }
    }
}
