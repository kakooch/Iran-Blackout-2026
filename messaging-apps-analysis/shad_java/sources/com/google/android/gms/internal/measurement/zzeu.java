package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
final class zzeu implements zzer {
    private static zzeu zza;
    private final Context zzb;
    private final ContentObserver zzc;

    private zzeu() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzeu(Context context) {
        this.zzb = context;
        zzet zzetVar = new zzet(this, null);
        this.zzc = zzetVar;
        context.getContentResolver().registerContentObserver(zzei.zza, true, zzetVar);
    }

    static zzeu zza(Context context) {
        zzeu zzeuVar;
        synchronized (zzeu.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzeu(context) : new zzeu();
            }
            zzeuVar = zza;
        }
        return zzeuVar;
    }

    static synchronized void zzc() {
        Context context;
        zzeu zzeuVar = zza;
        if (zzeuVar != null && (context = zzeuVar.zzb) != null && zzeuVar.zzc != null) {
            context.getContentResolver().unregisterContentObserver(zza.zzc);
        }
        zza = null;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final String zze(final String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzep.zza(new zzeq(this, str) { // from class: com.google.android.gms.internal.measurement.zzes
                private final zzeu zza;
                private final String zzb;

                {
                    this.zza = this;
                    this.zzb = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzeq
                public final Object zza() {
                    return this.zza.zzd(this.zzb);
                }
            });
        } catch (IllegalStateException | SecurityException e) {
            String strValueOf = String.valueOf(str);
            Log.e("GservicesLoader", strValueOf.length() != 0 ? "Unable to read GServices for: ".concat(strValueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    final /* synthetic */ String zzd(String str) {
        return zzei.zza(this.zzb.getContentResolver(), str, null);
    }
}
