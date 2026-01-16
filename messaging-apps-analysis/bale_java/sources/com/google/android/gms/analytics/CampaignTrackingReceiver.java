package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzct;
import com.google.android.gms.internal.gtm.zzfb;
import com.google.android.gms.internal.gtm.zzfs;
import ir.nasim.AbstractC3795Cj5;

@VisibleForTesting
/* loaded from: classes3.dex */
public class CampaignTrackingReceiver extends BroadcastReceiver {
    static Boolean zza;

    public static boolean zzb(@RecentlyNonNull Context context) throws PackageManager.NameNotFoundException {
        AbstractC3795Cj5.j(context);
        Boolean bool = zza;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zZzi = zzfs.zzi(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        zza = Boolean.valueOf(zZzi);
        return zZzi;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@RecentlyNonNull Context context, Intent intent) {
        zzbv zzbvVarZzg = zzbv.zzg(context);
        zzfb zzfbVarZzm = zzbvVarZzg.zzm();
        if (intent == null) {
            zzfbVarZzm.zzR("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        zzfbVarZzm.zzP("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            zzfbVarZzm.zzR("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        zza(context, stringExtra);
        zzbvVarZzg.zzj();
        zzbvVarZzg.zzj();
        int iZzf = zzct.zzf();
        if (stringExtra.length() > iZzf) {
            zzfbVarZzm.zzT("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(iZzf));
            stringExtra = stringExtra.substring(0, iZzf);
        }
        zzbvVarZzg.zzf().zzf(stringExtra, new a(this, goAsync()));
    }

    protected void zza(Context context, String str) {
    }
}
