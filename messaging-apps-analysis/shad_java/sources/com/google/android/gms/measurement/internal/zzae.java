package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzmp;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzae extends zzge {
    private Boolean zza;
    private zzad zzb;
    private Boolean zzc;

    zzae(zzfl zzflVar) {
        super(zzflVar);
        this.zzb = zzac.zza;
    }

    public static final long zzA() {
        return zzdw.zzC.zzb(null).longValue();
    }

    private final String zzB(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, BuildConfig.FLAVOR);
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            this.zzx.zzat().zzb().zzb("Could not find SystemProperties class", e);
            return BuildConfig.FLAVOR;
        } catch (IllegalAccessException e2) {
            this.zzx.zzat().zzb().zzb("Could not access SystemProperties.get()", e2);
            return BuildConfig.FLAVOR;
        } catch (NoSuchMethodException e3) {
            this.zzx.zzat().zzb().zzb("Could not find SystemProperties.get() method", e3);
            return BuildConfig.FLAVOR;
        } catch (InvocationTargetException e4) {
            this.zzx.zzat().zzb().zzb("SystemProperties.get() threw an exception", e4);
            return BuildConfig.FLAVOR;
        }
    }

    public static final long zzz() {
        return zzdw.zzc.zzb(null).longValue();
    }

    final void zza(zzad zzadVar) {
        this.zzb = zzadVar;
    }

    final String zzb() {
        this.zzx.zzas();
        return "FA";
    }

    public final int zzc() {
        zzkk zzkkVarZzl = this.zzx.zzl();
        Boolean boolZzC = zzkkVarZzl.zzx.zzy().zzC();
        if (zzkkVarZzl.zzZ() < 201500) {
            return (boolZzC == null || boolZzC.booleanValue()) ? 25 : 100;
        }
        return 100;
    }

    public final int zzd(String str) {
        return zzl(str, zzdw.zzH, 25, 100);
    }

    final int zze(String str) {
        return zzl(str, zzdw.zzG, HttpStatus.HTTP_INTERNAL_SERVER_ERROR, 2000);
    }

    public final long zzf() {
        this.zzx.zzas();
        return 39000L;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzh() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = this.zzx.zzaw().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = false;
                        if (str != null && str.equals(myProcessName)) {
                            z = true;
                        }
                        this.zzc = Boolean.valueOf(z);
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        this.zzx.zzat().zzb().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    public final String zzi(String str, zzdv<String> zzdvVar) {
        return str == null ? zzdvVar.zzb(null) : zzdvVar.zzb(this.zzb.zza(str, zzdvVar.zza()));
    }

    public final long zzj(String str, zzdv<Long> zzdvVar) {
        if (str == null) {
            return zzdvVar.zzb(null).longValue();
        }
        String strZza = this.zzb.zza(str, zzdvVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzdvVar.zzb(null).longValue();
        }
        try {
            return zzdvVar.zzb(Long.valueOf(Long.parseLong(strZza))).longValue();
        } catch (NumberFormatException unused) {
            return zzdvVar.zzb(null).longValue();
        }
    }

    public final int zzk(String str, zzdv<Integer> zzdvVar) {
        if (str == null) {
            return zzdvVar.zzb(null).intValue();
        }
        String strZza = this.zzb.zza(str, zzdvVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzdvVar.zzb(null).intValue();
        }
        try {
            return zzdvVar.zzb(Integer.valueOf(Integer.parseInt(strZza))).intValue();
        } catch (NumberFormatException unused) {
            return zzdvVar.zzb(null).intValue();
        }
    }

    public final int zzl(String str, zzdv<Integer> zzdvVar, int i, int i2) {
        return Math.max(Math.min(zzk(str, zzdvVar), i2), i);
    }

    public final double zzm(String str, zzdv<Double> zzdvVar) {
        if (str == null) {
            return zzdvVar.zzb(null).doubleValue();
        }
        String strZza = this.zzb.zza(str, zzdvVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzdvVar.zzb(null).doubleValue();
        }
        try {
            return zzdvVar.zzb(Double.valueOf(Double.parseDouble(strZza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzdvVar.zzb(null).doubleValue();
        }
    }

    public final boolean zzn(String str, zzdv<Boolean> zzdvVar) {
        if (str == null) {
            return zzdvVar.zzb(null).booleanValue();
        }
        String strZza = this.zzb.zza(str, zzdvVar.zza());
        return TextUtils.isEmpty(strZza) ? zzdvVar.zzb(null).booleanValue() : zzdvVar.zzb(Boolean.valueOf(Boolean.parseBoolean(strZza))).booleanValue();
    }

    final Bundle zzo() {
        try {
            if (this.zzx.zzaw().getPackageManager() == null) {
                this.zzx.zzat().zzb().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(this.zzx.zzaw()).getApplicationInfo(this.zzx.zzaw().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            this.zzx.zzat().zzb().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            this.zzx.zzat().zzb().zzb("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    final Boolean zzp(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzo = zzo();
        if (bundleZzo == null) {
            this.zzx.zzat().zzb().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleZzo.containsKey(str)) {
            return Boolean.valueOf(bundleZzo.getBoolean(str));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.List<java.lang.String> zzq(java.lang.String r4) throws android.content.res.Resources.NotFoundException {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzo()
            r1 = 0
            if (r0 != 0) goto L1d
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzb()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L1b:
            r4 = r1
            goto L2c
        L1d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L24
            goto L1b
        L24:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L2c:
            if (r4 == 0) goto L58
            com.google.android.gms.measurement.internal.zzfl r0 = r3.zzx     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.Context r0 = r0.zzaw()     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L48
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L48
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            if (r4 != 0) goto L43
            return r1
        L43:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            return r4
        L48:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzfl r0 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzb()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zzb(r2, r4)
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzae.zzq(java.lang.String):java.util.List");
    }

    public final boolean zzr() {
        this.zzx.zzas();
        Boolean boolZzp = zzp("firebase_analytics_collection_deactivated");
        return boolZzp != null && boolZzp.booleanValue();
    }

    public final boolean zzs() {
        Boolean boolZzp = zzp("google_analytics_adid_collection_enabled");
        return boolZzp == null || boolZzp.booleanValue();
    }

    public final boolean zzt() {
        Boolean boolZzp;
        zzmp.zzb();
        return !zzn(null, zzdw.zzas) || (boolZzp = zzp("google_analytics_automatic_screen_reporting_enabled")) == null || boolZzp.booleanValue();
    }

    public final String zzu() {
        return zzB("debug.firebase.analytics.app", BuildConfig.FLAVOR);
    }

    public final String zzv() {
        return zzB("debug.deferred.deeplink", BuildConfig.FLAVOR);
    }

    public final boolean zzw(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzx(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    final boolean zzy() {
        if (this.zza == null) {
            Boolean boolZzp = zzp("app_measurement_lite");
            this.zza = boolZzp;
            if (boolZzp == null) {
                this.zza = Boolean.FALSE;
            }
        }
        return this.zza.booleanValue() || !this.zzx.zzu();
    }
}
