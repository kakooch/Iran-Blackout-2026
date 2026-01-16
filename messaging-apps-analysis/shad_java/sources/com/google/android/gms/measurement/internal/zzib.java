package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import io.github.inflationx.calligraphy3.BuildConfig;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzib extends zzf {
    protected zzhu zza;
    private volatile zzhu zzb;
    private zzhu zzc;
    private final Map<Activity, zzhu> zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzhu zzg;
    private zzhu zzh;
    private boolean zzi;
    private final Object zzj;
    private String zzl;

    public zzib(zzfl zzflVar) {
        super(zzflVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzB(com.google.android.gms.measurement.internal.zzhu r19, com.google.android.gms.measurement.internal.zzhu r20, long r21, boolean r23, android.os.Bundle r24) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzib.zzB(com.google.android.gms.measurement.internal.zzhu, com.google.android.gms.measurement.internal.zzhu, long, boolean, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzC(zzhu zzhuVar, boolean z, long j) {
        this.zzx.zzB().zzc(this.zzx.zzax().elapsedRealtime());
        if (!this.zzx.zzh().zzb.zzd(zzhuVar != null && zzhuVar.zzd, z, j) || zzhuVar == null) {
            return;
        }
        zzhuVar.zzd = false;
    }

    private final zzhu zzD(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzhu zzhuVar = this.zzd.get(activity);
        if (zzhuVar == null) {
            zzhu zzhuVar2 = new zzhu(null, zzi(activity.getClass(), "Activity"), this.zzx.zzl().zzd());
            this.zzd.put(activity, zzhuVar2);
            zzhuVar = zzhuVar2;
        }
        return (this.zzx.zzc().zzn(null, zzdw.zzat) && this.zzg != null) ? this.zzg : zzhuVar;
    }

    public static void zzm(zzhu zzhuVar, Bundle bundle, boolean z) {
        if (zzhuVar != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zzhuVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzhuVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzhuVar.zzc);
                return;
            }
            z = false;
        }
        if (zzhuVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    static /* synthetic */ void zzu(zzib zzibVar, Bundle bundle, zzhu zzhuVar, zzhu zzhuVar2, long j) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        zzibVar.zzB(zzhuVar, zzhuVar2, j, true, zzibVar.zzx.zzl().zzF(null, "screen_view", bundle, null, true));
    }

    static /* synthetic */ zzhu zzz(zzib zzibVar, zzhu zzhuVar) {
        zzibVar.zzh = null;
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zze() {
        return false;
    }

    public final zzhu zzh(boolean z) {
        zzb();
        zzg();
        if (!this.zzx.zzc().zzn(null, zzdw.zzat) || !z) {
            return this.zza;
        }
        zzhu zzhuVar = this.zza;
        return zzhuVar != null ? zzhuVar : this.zzh;
    }

    final String zzi(Class<?> cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] strArrSplit = canonicalName.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : BuildConfig.FLAVOR;
        int length2 = str2.length();
        this.zzx.zzc();
        if (length2 <= 100) {
            return str2;
        }
        this.zzx.zzc();
        return str2.substring(0, 100);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        if (r2 > 100) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        if (r4 > 100) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(android.os.Bundle r13, long r14) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzib.zzj(android.os.Bundle, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r1 <= 100) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        if (r1 <= 100) goto L39;
     */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzk(android.app.Activity r4, java.lang.String r5, java.lang.String r6) throws java.lang.IllegalStateException {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzfl r0 = r3.zzx
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            boolean r0 = r0.zzt()
            if (r0 != 0) goto L1c
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.zza(r5)
            return
        L1c:
            com.google.android.gms.measurement.internal.zzhu r0 = r3.zzb
            if (r0 != 0) goto L30
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.zza(r5)
            return
        L30:
            java.util.Map<android.app.Activity, com.google.android.gms.measurement.internal.zzhu> r1 = r3.zzd
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L48
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.zza(r5)
            return
        L48:
            if (r6 != 0) goto L54
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.zzi(r6, r1)
        L54:
            java.lang.String r1 = r0.zzb
            boolean r1 = com.google.android.gms.measurement.internal.zzkk.zzS(r1, r6)
            java.lang.String r0 = r0.zza
            boolean r0 = com.google.android.gms.measurement.internal.zzkk.zzS(r0, r5)
            if (r1 == 0) goto L75
            if (r0 != 0) goto L65
            goto L75
        L65:
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.zza(r5)
            return
        L75:
            r0 = 100
            if (r5 == 0) goto La3
            int r1 = r5.length()
            if (r1 <= 0) goto L8b
            int r1 = r5.length()
            com.google.android.gms.measurement.internal.zzfl r2 = r3.zzx
            r2.zzc()
            if (r1 > r0) goto L8b
            goto La3
        L8b:
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        La3:
            if (r6 == 0) goto Lcf
            int r1 = r6.length()
            if (r1 <= 0) goto Lb7
            int r1 = r6.length()
            com.google.android.gms.measurement.internal.zzfl r2 = r3.zzx
            r2.zzc()
            if (r1 > r0) goto Lb7
            goto Lcf
        Lb7:
            com.google.android.gms.measurement.internal.zzfl r4 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r4 = r4.zzat()
            com.google.android.gms.measurement.internal.zzeg r4 = r4.zzh()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        Lcf:
            com.google.android.gms.measurement.internal.zzfl r0 = r3.zzx
            com.google.android.gms.measurement.internal.zzei r0 = r0.zzat()
            com.google.android.gms.measurement.internal.zzeg r0 = r0.zzk()
            if (r5 != 0) goto Lde
            java.lang.String r1 = "null"
            goto Ldf
        Lde:
            r1 = r5
        Ldf:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.zzc(r2, r1, r6)
            com.google.android.gms.measurement.internal.zzhu r0 = new com.google.android.gms.measurement.internal.zzhu
            com.google.android.gms.measurement.internal.zzfl r1 = r3.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            long r1 = r1.zzd()
            r0.<init>(r5, r6, r1)
            java.util.Map<android.app.Activity, com.google.android.gms.measurement.internal.zzhu> r5 = r3.zzd
            r5.put(r4, r0)
            r5 = 1
            r3.zzA(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzib.zzk(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public final zzhu zzl() {
        return this.zzb;
    }

    public final void zzn(String str, zzhu zzhuVar) {
        zzg();
        synchronized (this) {
            String str2 = this.zzl;
            if (str2 == null || str2.equals(str) || zzhuVar != null) {
                this.zzl = str;
            }
        }
    }

    public final void zzo(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.zzx.zzc().zzt() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzhu(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zzq(Activity activity) throws IllegalStateException {
        if (this.zzx.zzc().zzn(null, zzdw.zzat)) {
            synchronized (this.zzj) {
                this.zzi = true;
                if (activity != this.zze) {
                    synchronized (this.zzj) {
                        this.zze = activity;
                        this.zzf = false;
                    }
                    if (this.zzx.zzc().zzn(null, zzdw.zzas) && this.zzx.zzc().zzt()) {
                        this.zzg = null;
                        this.zzx.zzau().zzh(new zzia(this));
                    }
                }
            }
        }
        if (this.zzx.zzc().zzn(null, zzdw.zzas) && !this.zzx.zzc().zzt()) {
            this.zzb = this.zzg;
            this.zzx.zzau().zzh(new zzhx(this));
        } else {
            zzA(activity, zzD(activity), false);
            zzd zzdVarZzB = this.zzx.zzB();
            zzdVarZzB.zzx.zzau().zzh(new zzc(zzdVarZzB, zzdVarZzB.zzx.zzax().elapsedRealtime()));
        }
    }

    public final void zzr(Activity activity) throws IllegalStateException {
        if (this.zzx.zzc().zzn(null, zzdw.zzat)) {
            synchronized (this.zzj) {
                this.zzi = false;
                this.zzf = true;
            }
        }
        long jElapsedRealtime = this.zzx.zzax().elapsedRealtime();
        if (this.zzx.zzc().zzn(null, zzdw.zzas) && !this.zzx.zzc().zzt()) {
            this.zzb = null;
            this.zzx.zzau().zzh(new zzhy(this, jElapsedRealtime));
        } else {
            zzhu zzhuVarZzD = zzD(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            this.zzx.zzau().zzh(new zzhz(this, zzhuVarZzD, jElapsedRealtime));
        }
    }

    public final void zzs(Activity activity, Bundle bundle) {
        zzhu zzhuVar;
        if (!this.zzx.zzc().zzt() || bundle == null || (zzhuVar = this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzhuVar.zzc);
        bundle2.putString("name", zzhuVar.zza);
        bundle2.putString("referrer_name", zzhuVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void zzt(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (this.zzx.zzc().zzt()) {
            this.zzd.remove(activity);
        }
    }

    private final void zzA(Activity activity, zzhu zzhuVar, boolean z) throws IllegalStateException {
        zzhu zzhuVar2;
        zzhu zzhuVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzhuVar.zzb == null) {
            zzhuVar2 = new zzhu(zzhuVar.zza, activity != null ? zzi(activity.getClass(), "Activity") : null, zzhuVar.zzc, zzhuVar.zze, zzhuVar.zzf);
        } else {
            zzhuVar2 = zzhuVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzhuVar2;
        this.zzx.zzau().zzh(new zzhw(this, zzhuVar2, zzhuVar3, this.zzx.zzax().elapsedRealtime(), z));
    }
}
