package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzlc;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzgd extends zzdy {
    private final zzkd zza;
    private Boolean zzb;
    private String zzc;

    public zzgd(zzkd zzkdVar, String str) {
        Preconditions.checkNotNull(zzkdVar);
        this.zza = zzkdVar;
        this.zzc = null;
    }

    private final void zzx(zzp zzpVar, boolean z) {
        Preconditions.checkNotNull(zzpVar);
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzy(zzpVar.zza, false);
        this.zza.zzr().zzA(zzpVar.zzb, zzpVar.zzq, zzpVar.zzu);
    }

    private final void zzy(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzat().zzb().zza("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzb == null) {
                    this.zzb = Boolean.valueOf("com.google.android.gms".equals(this.zzc) || UidVerifier.isGooglePlayServicesUid(this.zza.zzaw(), Binder.getCallingUid()) || GoogleSignatureVerifier.getInstance(this.zza.zzaw()).isUidGoogleSigned(Binder.getCallingUid()));
                }
                if (this.zzb.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zza.zzat().zzb().zzb("Measurement Service called with invalid calling package. appId", zzei.zzl(str));
                throw e;
            }
        }
        if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzaw(), Binder.getCallingUid(), str)) {
            this.zzc = str;
        }
        if (str.equals(this.zzc)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    final zzas zzb(zzas zzasVar, zzp zzpVar) {
        zzaq zzaqVar;
        if ("_cmp".equals(zzasVar.zza) && (zzaqVar = zzasVar.zzb) != null && zzaqVar.zze() != 0) {
            String strZzd = zzasVar.zzb.zzd("_cis");
            if ("referrer broadcast".equals(strZzd) || "referrer API".equals(strZzd)) {
                this.zza.zzat().zzi().zzb("Event has been filtered ", zzasVar.toString());
                return new zzas("_cmpx", zzasVar.zzb, zzasVar.zzc, zzasVar.zzd);
            }
        }
        return zzasVar;
    }

    final void zzc(Runnable runnable) throws IllegalStateException {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzau().zzd()) {
            runnable.run();
        } else {
            this.zza.zzau().zzh(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzd(zzas zzasVar, zzp zzpVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzasVar);
        zzx(zzpVar, false);
        zzc(new zzfw(this, zzasVar, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zze(zzkg zzkgVar, zzp zzpVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzkgVar);
        zzx(zzpVar, false);
        zzc(new zzfz(this, zzkgVar, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzf(zzp zzpVar) throws IllegalStateException {
        zzx(zzpVar, false);
        zzc(new zzgb(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzg(zzas zzasVar, String str, String str2) throws IllegalStateException {
        Preconditions.checkNotNull(zzasVar);
        Preconditions.checkNotEmpty(str);
        zzy(str, true);
        zzc(new zzfx(this, zzasVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzh(zzp zzpVar) throws IllegalStateException {
        zzx(zzpVar, false);
        zzc(new zzfu(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final List<zzkg> zzi(zzp zzpVar, boolean z) {
        zzx(zzpVar, false);
        String str = zzpVar.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzki> list = (List) this.zza.zzau().zze(new zzga(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzki zzkiVar : list) {
                if (z || !zzkk.zzR(zzkiVar.zzc)) {
                    arrayList.add(new zzkg(zzkiVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzc("Failed to get user properties. appId", zzei.zzl(zzpVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final byte[] zzj(zzas zzasVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzasVar);
        zzy(str, true);
        this.zza.zzat().zzj().zzb("Log and bundle. event", this.zza.zzq().zzc(zzasVar.zza));
        long jNanoTime = this.zza.zzax().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzau().zzf(new zzfy(this, zzasVar, str)).get();
            if (bArr == null) {
                this.zza.zzat().zzb().zzb("Log and bundle returned null. appId", zzei.zzl(str));
                bArr = new byte[0];
            }
            this.zza.zzat().zzj().zzd("Log and bundle processed. event, size, time_ms", this.zza.zzq().zzc(zzasVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzax().nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzd("Failed to log and bundle. appId, event, error", zzei.zzl(str), this.zza.zzq().zzc(zzasVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzk(long j, String str, String str2, String str3) throws IllegalStateException {
        zzc(new zzgc(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final String zzl(zzp zzpVar) {
        zzx(zzpVar, false);
        return this.zza.zzY(zzpVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzm(zzaa zzaaVar, zzp zzpVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzaaVar);
        Preconditions.checkNotNull(zzaaVar.zzc);
        zzx(zzpVar, false);
        zzaa zzaaVar2 = new zzaa(zzaaVar);
        zzaaVar2.zza = zzpVar.zza;
        zzc(new zzfn(this, zzaaVar2, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzn(zzaa zzaaVar) throws IllegalStateException {
        Preconditions.checkNotNull(zzaaVar);
        Preconditions.checkNotNull(zzaaVar.zzc);
        Preconditions.checkNotEmpty(zzaaVar.zza);
        zzy(zzaaVar.zza, true);
        zzc(new zzfo(this, new zzaa(zzaaVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final List<zzkg> zzo(String str, String str2, boolean z, zzp zzpVar) {
        zzx(zzpVar, false);
        String str3 = zzpVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzki> list = (List) this.zza.zzau().zze(new zzfp(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzki zzkiVar : list) {
                if (z || !zzkk.zzR(zzkiVar.zzc)) {
                    arrayList.add(new zzkg(zzkiVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzc("Failed to query user properties. appId", zzei.zzl(zzpVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final List<zzkg> zzp(String str, String str2, String str3, boolean z) {
        zzy(str, true);
        try {
            List<zzki> list = (List) this.zza.zzau().zze(new zzfq(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzki zzkiVar : list) {
                if (z || !zzkk.zzR(zzkiVar.zzc)) {
                    arrayList.add(new zzkg(zzkiVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzc("Failed to get user properties as. appId", zzei.zzl(str), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final List<zzaa> zzq(String str, String str2, zzp zzpVar) {
        zzx(zzpVar, false);
        String str3 = zzpVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzau().zze(new zzfr(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzb("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final List<zzaa> zzr(String str, String str2, String str3) {
        zzy(str, true);
        try {
            return (List) this.zza.zzau().zze(new zzfs(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzat().zzb().zzb("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzs(zzp zzpVar) throws IllegalStateException {
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzy(zzpVar.zza, false);
        zzc(new zzft(this, zzpVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzt(final Bundle bundle, zzp zzpVar) throws IllegalStateException {
        zzx(zzpVar, false);
        final String str = zzpVar.zza;
        Preconditions.checkNotNull(str);
        zzc(new Runnable(this, str, bundle) { // from class: com.google.android.gms.measurement.internal.zzfm
            private final zzgd zza;
            private final String zzb;
            private final Bundle zzc;

            {
                this.zza = this;
                this.zzb = str;
                this.zzc = bundle;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzv(this.zzb, this.zzc);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzu(zzp zzpVar) throws IllegalStateException {
        zzlc.zzb();
        if (this.zza.zzd().zzn(null, zzdw.zzay)) {
            Preconditions.checkNotEmpty(zzpVar.zza);
            Preconditions.checkNotNull(zzpVar.zzv);
            zzfv zzfvVar = new zzfv(this, zzpVar);
            Preconditions.checkNotNull(zzfvVar);
            if (this.zza.zzau().zzd()) {
                zzfvVar.run();
            } else {
                this.zza.zzau().zzj(zzfvVar);
            }
        }
    }

    final /* synthetic */ void zzv(String str, Bundle bundle) {
        zzai zzaiVarZzi = this.zza.zzi();
        zzaiVarZzi.zzg();
        zzaiVarZzi.zzX();
        byte[] bArrZzbp = zzaiVarZzi.zza.zzn().zzf(new zzan(zzaiVarZzi.zzx, BuildConfig.FLAVOR, str, "dep", 0L, 0L, bundle)).zzbp();
        zzaiVarZzi.zzx.zzat().zzk().zzc("Saving default event parameters, appId, data size", zzaiVarZzi.zzx.zzm().zzc(str), Integer.valueOf(bArrZzbp.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzbp);
        try {
            if (zzaiVarZzi.zze().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                zzaiVarZzi.zzx.zzat().zzb().zzb("Failed to insert default event parameters (got -1). appId", zzei.zzl(str));
            }
        } catch (SQLiteException e) {
            zzaiVarZzi.zzx.zzat().zzb().zzc("Error storing default event parameters. appId", zzei.zzl(str), e);
        }
    }
}
