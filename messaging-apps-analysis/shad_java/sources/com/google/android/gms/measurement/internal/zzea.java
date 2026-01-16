package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.android.gms.internal.measurement.zznk;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzea extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private long zzf;
    private final long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzea(zzfl zzflVar, long j) {
        super(zzflVar);
        this.zzg = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zze() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0185 A[Catch: IllegalStateException -> 0x02a5, TRY_ENTER, TryCatch #1 {IllegalStateException -> 0x02a5, blocks: (B:46:0x0172, B:49:0x0185, B:51:0x01a0, B:55:0x01a9, B:58:0x01be, B:61:0x01cf, B:65:0x01ed, B:68:0x01f8, B:70:0x0200, B:92:0x0286, B:94:0x029c, B:96:0x02a1, B:95:0x029f, B:72:0x0206, B:64:0x01e9, B:73:0x020e, B:76:0x0224, B:78:0x022c, B:80:0x0232, B:81:0x0239, B:83:0x023f, B:85:0x024e, B:89:0x026c, B:88:0x0268, B:90:0x0273, B:50:0x0196), top: B:120:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0196 A[Catch: IllegalStateException -> 0x02a5, TryCatch #1 {IllegalStateException -> 0x02a5, blocks: (B:46:0x0172, B:49:0x0185, B:51:0x01a0, B:55:0x01a9, B:58:0x01be, B:61:0x01cf, B:65:0x01ed, B:68:0x01f8, B:70:0x0200, B:92:0x0286, B:94:0x029c, B:96:0x02a1, B:95:0x029f, B:72:0x0206, B:64:0x01e9, B:73:0x020e, B:76:0x0224, B:78:0x022c, B:80:0x0232, B:81:0x0239, B:83:0x023f, B:85:0x024e, B:89:0x026c, B:88:0x0268, B:90:0x0273, B:50:0x0196), top: B:120:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01be A[Catch: IllegalStateException -> 0x02a5, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IllegalStateException -> 0x02a5, blocks: (B:46:0x0172, B:49:0x0185, B:51:0x01a0, B:55:0x01a9, B:58:0x01be, B:61:0x01cf, B:65:0x01ed, B:68:0x01f8, B:70:0x0200, B:92:0x0286, B:94:0x029c, B:96:0x02a1, B:95:0x029f, B:72:0x0206, B:64:0x01e9, B:73:0x020e, B:76:0x0224, B:78:0x022c, B:80:0x0232, B:81:0x0239, B:83:0x023f, B:85:0x024e, B:89:0x026c, B:88:0x0268, B:90:0x0273, B:50:0x0196), top: B:120:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0239 A[Catch: IllegalStateException -> 0x02a5, TryCatch #1 {IllegalStateException -> 0x02a5, blocks: (B:46:0x0172, B:49:0x0185, B:51:0x01a0, B:55:0x01a9, B:58:0x01be, B:61:0x01cf, B:65:0x01ed, B:68:0x01f8, B:70:0x0200, B:92:0x0286, B:94:0x029c, B:96:0x02a1, B:95:0x029f, B:72:0x0206, B:64:0x01e9, B:73:0x020e, B:76:0x0224, B:78:0x022c, B:80:0x0232, B:81:0x0239, B:83:0x023f, B:85:0x024e, B:89:0x026c, B:88:0x0268, B:90:0x0273, B:50:0x0196), top: B:120:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0286 A[Catch: IllegalStateException -> 0x02a5, TryCatch #1 {IllegalStateException -> 0x02a5, blocks: (B:46:0x0172, B:49:0x0185, B:51:0x01a0, B:55:0x01a9, B:58:0x01be, B:61:0x01cf, B:65:0x01ed, B:68:0x01f8, B:70:0x0200, B:92:0x0286, B:94:0x029c, B:96:0x02a1, B:95:0x029f, B:72:0x0206, B:64:0x01e9, B:73:0x020e, B:76:0x0224, B:78:0x022c, B:80:0x0232, B:81:0x0239, B:83:0x023f, B:85:0x024e, B:89:0x026c, B:88:0x0268, B:90:0x0273, B:50:0x0196), top: B:120:0x0172 }] */
    @Override // com.google.android.gms.measurement.internal.zzf
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzf() throws android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 812
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzea.zzf():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v42, types: [com.google.android.gms.measurement.internal.zzge, com.google.android.gms.measurement.internal.zzkk] */
    /* JADX WARN: Type inference failed for: r9v43, types: [com.google.android.gms.measurement.internal.zzge] */
    /* JADX WARN: Type inference failed for: r9v47 */
    /* JADX WARN: Type inference failed for: r9v52 */
    /* JADX WARN: Type inference failed for: r9v53 */
    /* JADX WARN: Type inference failed for: r9v54 */
    final zzp zzh(String str) throws IllegalAccessException, NoSuchAlgorithmException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String str2;
        Class<?> clsLoadClass;
        Object objInvoke;
        zzg();
        String strZzi = zzi();
        String strZzj = zzj();
        zzb();
        String str3 = this.zzb;
        zzb();
        long j = this.zzc;
        zzb();
        Preconditions.checkNotNull(this.zzd);
        String str4 = this.zzd;
        this.zzx.zzc().zzf();
        zzb();
        zzg();
        long j2 = this.zzf;
        if (j2 == 0) {
            ?? Zzl = this.zzx.zzl();
            Context contextZzaw = this.zzx.zzaw();
            String packageName = this.zzx.zzaw().getPackageName();
            Zzl.zzg();
            Preconditions.checkNotNull(contextZzaw);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = contextZzaw.getPackageManager();
            MessageDigest messageDigestZzN = zzkk.zzN();
            long j3 = -1;
            if (messageDigestZzN == null) {
                Zzl.zzx.zzat().zzb().zza("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (Zzl.zzW(contextZzaw, packageName)) {
                            j3 = 0;
                            Zzl = Zzl;
                        } else {
                            Signature[] signatureArr = Wrappers.packageManager(contextZzaw).getPackageInfo(Zzl.zzx.zzaw().getPackageName(), 64).signatures;
                            if (signatureArr == null || signatureArr.length <= 0) {
                                Zzl.zzx.zzat().zze().zza("Could not get signatures");
                                Zzl = Zzl;
                            } else {
                                long jZzO = zzkk.zzO(messageDigestZzN.digest(signatureArr[0].toByteArray()));
                                j3 = jZzO;
                                Zzl = jZzO;
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        Zzl.zzx.zzat().zzb().zzb("Package name not found", e);
                    }
                }
                j2 = 0;
                this.zzf = j2;
            }
            j2 = j3;
            this.zzf = j2;
        }
        long j4 = j2;
        boolean zZzF = this.zzx.zzF();
        boolean z = !this.zzx.zzd().zzp;
        zzg();
        if (this.zzx.zzF()) {
            zznk.zzb();
            if (this.zzx.zzc().zzn(null, zzdw.zzaj)) {
                this.zzx.zzat().zzk().zza("Disabled IID for tests.");
            } else {
                try {
                    clsLoadClass = this.zzx.zzaw().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                } catch (ClassNotFoundException unused) {
                }
                if (clsLoadClass != null) {
                    try {
                        objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzx.zzaw());
                    } catch (Exception unused2) {
                        this.zzx.zzat().zzf().zza("Failed to obtain Firebase Analytics instance");
                    }
                    if (objInvoke == null) {
                        str2 = null;
                    } else {
                        try {
                            str2 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                        } catch (Exception unused3) {
                            this.zzx.zzat().zzh().zza("Failed to retrieve Firebase Instance Id");
                        }
                    }
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        zzfl zzflVar = this.zzx;
        Long lValueOf = Long.valueOf(zzflVar.zzd().zzh.zza());
        long jMin = lValueOf.longValue() == 0 ? zzflVar.zzc : Math.min(zzflVar.zzc, lValueOf.longValue());
        zzb();
        int i = this.zzi;
        boolean zZzs = this.zzx.zzc().zzs();
        zzex zzexVarZzd = this.zzx.zzd();
        zzexVarZzd.zzg();
        boolean z2 = zzexVarZzd.zzd().getBoolean("deferred_analytics_collection", false);
        zzb();
        String str5 = this.zzk;
        Boolean boolValueOf = this.zzx.zzc().zzp("google_analytics_default_allow_ad_personalization_signals") == null ? null : Boolean.valueOf(!r2.booleanValue());
        long j5 = this.zzg;
        List<String> list = this.zzh;
        zzmg.zzb();
        String strZzl = this.zzx.zzc().zzn(null, zzdw.zzah) ? zzl() : null;
        zzlc.zzb();
        return new zzp(strZzi, strZzj, str3, j, str4, 39000L, j4, str, zZzF, z, str2, 0L, jMin, i, zZzs, z2, str5, boolValueOf, j5, list, strZzl, this.zzx.zzc().zzn(null, zzdw.zzaw) ? this.zzx.zzd().zzi().zzd() : BuildConfig.FLAVOR);
    }

    final String zzi() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zzj);
        return this.zzj;
    }

    final String zzk() {
        zzb();
        return this.zzk;
    }

    final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    final int zzm() {
        zzb();
        return this.zzc;
    }

    final int zzn() {
        zzb();
        return this.zzi;
    }

    final List<String> zzo() {
        return this.zzh;
    }
}
