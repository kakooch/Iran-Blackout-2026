package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzll;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzfl implements zzgg {
    private static volatile zzfl zzd;
    private zzea zzA;
    private zzfa zzB;
    private Boolean zzD;
    private long zzE;
    private volatile Boolean zzF;
    private volatile boolean zzG;
    private int zzH;
    protected Boolean zza;
    protected Boolean zzb;
    final long zzc;
    private final Context zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;
    private final zzz zzj;
    private final zzae zzk;
    private final zzex zzl;
    private final zzei zzm;
    private final zzfi zzn;
    private final zzjq zzo;
    private final zzkk zzp;
    private final zzed zzq;
    private final Clock zzr;
    private final zzib zzs;
    private final zzhn zzt;
    private final zzd zzu;
    private final zzhr zzv;
    private final String zzw;
    private zzec zzx;
    private zzjb zzy;
    private zzam zzz;
    private boolean zzC = false;
    private final AtomicInteger zzI = new AtomicInteger(0);

    zzfl(zzgn zzgnVar) throws IllegalStateException {
        Bundle bundle;
        Preconditions.checkNotNull(zzgnVar);
        zzz zzzVar = new zzz(zzgnVar.zza);
        this.zzj = zzzVar;
        zzdu.zza = zzzVar;
        Context context = zzgnVar.zza;
        this.zze = context;
        this.zzf = zzgnVar.zzb;
        this.zzg = zzgnVar.zzc;
        this.zzh = zzgnVar.zzd;
        this.zzi = zzgnVar.zzh;
        this.zzF = zzgnVar.zze;
        this.zzw = zzgnVar.zzj;
        this.zzG = true;
        com.google.android.gms.internal.measurement.zzy zzyVar = zzgnVar.zzg;
        if (zzyVar != null && (bundle = zzyVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzyVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzfg.zzb(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzr = defaultClock;
        Long l = zzgnVar.zzi;
        this.zzc = l != null ? l.longValue() : defaultClock.currentTimeMillis();
        this.zzk = new zzae(this);
        zzex zzexVar = new zzex(this);
        zzexVar.zzx();
        this.zzl = zzexVar;
        zzei zzeiVar = new zzei(this);
        zzeiVar.zzx();
        this.zzm = zzeiVar;
        zzkk zzkkVar = new zzkk(this);
        zzkkVar.zzx();
        this.zzp = zzkkVar;
        zzed zzedVar = new zzed(this);
        zzedVar.zzx();
        this.zzq = zzedVar;
        this.zzu = new zzd(this);
        zzib zzibVar = new zzib(this);
        zzibVar.zzc();
        this.zzs = zzibVar;
        zzhn zzhnVar = new zzhn(this);
        zzhnVar.zzc();
        this.zzt = zzhnVar;
        zzjq zzjqVar = new zzjq(this);
        zzjqVar.zzc();
        this.zzo = zzjqVar;
        zzhr zzhrVar = new zzhr(this);
        zzhrVar.zzx();
        this.zzv = zzhrVar;
        zzfi zzfiVar = new zzfi(this);
        zzfiVar.zzx();
        this.zzn = zzfiVar;
        com.google.android.gms.internal.measurement.zzy zzyVar2 = zzgnVar.zzg;
        boolean z = zzyVar2 == null || zzyVar2.zzb == 0;
        if (context.getApplicationContext() instanceof Application) {
            zzhn zzhnVarZzk = zzk();
            if (zzhnVarZzk.zzx.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzhnVarZzk.zzx.zze.getApplicationContext();
                if (zzhnVarZzk.zza == null) {
                    zzhnVarZzk.zza = new zzhm(zzhnVarZzk, null);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzhnVarZzk.zza);
                    application.registerActivityLifecycleCallbacks(zzhnVarZzk.zza);
                    zzhnVarZzk.zzx.zzat().zzk().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzat().zze().zza("Application context is not an Application");
        }
        zzfiVar.zzh(new zzfk(this, zzgnVar));
    }

    public static zzfl zzC(Context context, com.google.android.gms.internal.measurement.zzy zzyVar, Long l) {
        Bundle bundle;
        if (zzyVar != null && (zzyVar.zze == null || zzyVar.zzf == null)) {
            zzyVar = new com.google.android.gms.internal.measurement.zzy(zzyVar.zza, zzyVar.zzb, zzyVar.zzc, zzyVar.zzd, null, null, zzyVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzfl.class) {
                if (zzd == null) {
                    zzd = new zzfl(new zzgn(context, zzyVar, l));
                }
            }
        } else if (zzyVar != null && (bundle = zzyVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzd);
            zzd.zzF = Boolean.valueOf(zzyVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    static /* synthetic */ void zzO(zzfl zzflVar, zzgn zzgnVar) {
        zzflVar.zzau().zzg();
        zzflVar.zzk.zzb();
        zzam zzamVar = new zzam(zzflVar);
        zzamVar.zzx();
        zzflVar.zzz = zzamVar;
        zzea zzeaVar = new zzea(zzflVar, zzgnVar.zzf);
        zzeaVar.zzc();
        zzflVar.zzA = zzeaVar;
        zzec zzecVar = new zzec(zzflVar);
        zzecVar.zzc();
        zzflVar.zzx = zzecVar;
        zzjb zzjbVar = new zzjb(zzflVar);
        zzjbVar.zzc();
        zzflVar.zzy = zzjbVar;
        zzflVar.zzp.zzy();
        zzflVar.zzl.zzy();
        zzflVar.zzB = new zzfa(zzflVar);
        zzflVar.zzA.zzd();
        zzeg zzegVarZzi = zzflVar.zzat().zzi();
        zzflVar.zzk.zzf();
        zzegVarZzi.zzb("App measurement initialized, version", 39000L);
        zzflVar.zzat().zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strZzi = zzeaVar.zzi();
        if (TextUtils.isEmpty(zzflVar.zzf)) {
            if (zzflVar.zzl().zzT(strZzi)) {
                zzflVar.zzat().zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzeg zzegVarZzi2 = zzflVar.zzat().zzi();
                String strValueOf = String.valueOf(strZzi);
                zzegVarZzi2.zza(strValueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(strValueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app "));
            }
        }
        zzflVar.zzat().zzj().zza("Debug-level message logging enabled");
        if (zzflVar.zzH != zzflVar.zzI.get()) {
            zzflVar.zzat().zzb().zzc("Not all components initialized", Integer.valueOf(zzflVar.zzH), Integer.valueOf(zzflVar.zzI.get()));
        }
        zzflVar.zzC = true;
    }

    static final void zzP() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzQ(zzge zzgeVar) {
        if (zzgeVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzR(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzfVar.zza()) {
            return;
        }
        String strValueOf = String.valueOf(zzfVar.getClass());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
        sb.append("Component not initialized: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    private static final void zzS(zzgf zzgfVar) {
        if (zzgfVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzgfVar.zzu()) {
            return;
        }
        String strValueOf = String.valueOf(zzgfVar.getClass());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
        sb.append("Component not initialized: ");
        sb.append(strValueOf);
        throw new IllegalStateException(sb.toString());
    }

    @Pure
    public final zzea zzA() {
        zzR(this.zzA);
        return this.zzA;
    }

    @Pure
    public final zzd zzB() {
        zzd zzdVar = this.zzu;
        if (zzdVar != null) {
            return zzdVar;
        }
        throw new IllegalStateException("Component not created");
    }

    final void zzD(boolean z) {
        this.zzF = Boolean.valueOf(z);
    }

    public final boolean zzE() {
        return this.zzF != null && this.zzF.booleanValue();
    }

    public final boolean zzF() {
        return zzG() == 0;
    }

    public final int zzG() {
        zzau().zzg();
        if (this.zzk.zzr()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzlc.zzb();
        if (this.zzk.zzn(null, zzdw.zzaw)) {
            zzau().zzg();
            if (!this.zzG) {
                return 8;
            }
        }
        Boolean boolZzf = zzd().zzf();
        if (boolZzf != null) {
            return boolZzf.booleanValue() ? 0 : 3;
        }
        zzae zzaeVar = this.zzk;
        zzz zzzVar = zzaeVar.zzx.zzj;
        Boolean boolZzp = zzaeVar.zzp("firebase_analytics_collection_enabled");
        if (boolZzp != null) {
            return boolZzp.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zza;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (!this.zzk.zzn(null, zzdw.zzS) || this.zzF == null || this.zzF.booleanValue()) ? 0 : 7;
    }

    public final void zzH(boolean z) {
        zzau().zzg();
        this.zzG = z;
    }

    public final boolean zzI() {
        zzau().zzg();
        return this.zzG;
    }

    final void zzJ() {
        this.zzH++;
    }

    final void zzK() {
        this.zzI.incrementAndGet();
    }

    protected final boolean zzL() {
        if (!this.zzC) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzau().zzg();
        Boolean bool = this.zzD;
        if (bool == null || this.zzE == 0 || (!bool.booleanValue() && Math.abs(this.zzr.elapsedRealtime() - this.zzE) > 1000)) {
            this.zzE = this.zzr.elapsedRealtime();
            boolean z = true;
            Boolean boolValueOf = Boolean.valueOf(zzl().zzQ("android.permission.INTERNET") && zzl().zzQ("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zze).isCallerInstantApp() || this.zzk.zzy() || (zzfb.zza(this.zze) && zzkk.zzP(this.zze, false))));
            this.zzD = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!zzl().zzA(zzA().zzj(), zzA().zzk(), zzA().zzl()) && TextUtils.isEmpty(zzA().zzk())) {
                    z = false;
                }
                this.zzD = Boolean.valueOf(z);
            }
        }
        return this.zzD.booleanValue();
    }

    public final void zzM() throws IllegalStateException {
        zzau().zzg();
        zzS(zzo());
        String strZzi = zzA().zzi();
        Pair<String, Boolean> pairZzb = zzd().zzb(strZzi);
        if (!this.zzk.zzs() || ((Boolean) pairZzb.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairZzb.first)) {
            zzat().zzj().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        zzhr zzhrVarZzo = zzo();
        zzhrVarZzo.zzv();
        ConnectivityManager connectivityManager = (ConnectivityManager) zzhrVarZzo.zzx.zze.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            zzat().zze().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        zzkk zzkkVarZzl = zzl();
        zzA().zzx.zzk.zzf();
        URL urlZzal = zzkkVarZzl.zzal(39000L, strZzi, (String) pairZzb.first, zzd().zzs.zza() - 1);
        if (urlZzal != null) {
            zzhr zzhrVarZzo2 = zzo();
            zzfj zzfjVar = new zzfj(this);
            zzhrVarZzo2.zzg();
            zzhrVarZzo2.zzv();
            Preconditions.checkNotNull(urlZzal);
            Preconditions.checkNotNull(zzfjVar);
            zzhrVarZzo2.zzx.zzau().zzk(new zzhq(zzhrVarZzo2, strZzi, urlZzal, null, null, zzfjVar, null));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ void zzN(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfl.zzN(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzy zzyVar) throws ClassNotFoundException {
        zzaf zzafVarZzb;
        zzau().zzg();
        zzlc.zzb();
        zzae zzaeVar = this.zzk;
        zzdv<Boolean> zzdvVar = zzdw.zzaw;
        if (zzaeVar.zzn(null, zzdvVar)) {
            zzaf zzafVarZzi = zzd().zzi();
            zzex zzexVarZzd = zzd();
            zzfl zzflVar = zzexVarZzd.zzx;
            zzexVarZzd.zzg();
            int i = 100;
            int i2 = zzexVarZzd.zzd().getInt("consent_source", 100);
            zzae zzaeVar2 = this.zzk;
            zzdv<Boolean> zzdvVar2 = zzdw.zzax;
            if (zzaeVar2.zzn(null, zzdvVar2)) {
                zzae zzaeVar3 = this.zzk;
                zzfl zzflVar2 = zzaeVar3.zzx;
                zzlc.zzb();
                Boolean boolZzp = !zzaeVar3.zzn(null, zzdvVar2) ? null : zzaeVar3.zzp("google_analytics_default_allow_ad_storage");
                zzae zzaeVar4 = this.zzk;
                zzfl zzflVar3 = zzaeVar4.zzx;
                zzlc.zzb();
                Boolean boolZzp2 = !zzaeVar4.zzn(null, zzdvVar2) ? null : zzaeVar4.zzp("google_analytics_default_allow_analytics_storage");
                if (!(boolZzp == null && boolZzp2 == null) && zzd().zzh(20)) {
                    zzafVarZzb = new zzaf(boolZzp, boolZzp2);
                    i = 20;
                } else {
                    if (!TextUtils.isEmpty(zzA().zzj()) && (i2 == 30 || i2 == 40)) {
                        zzk().zzq(zzaf.zza, 20, this.zzc);
                    } else if (zzyVar != null && zzyVar.zzg != null && zzd().zzh(40)) {
                        zzafVarZzb = zzaf.zzb(zzyVar.zzg);
                        if (!zzafVarZzb.equals(zzaf.zza)) {
                            i = 40;
                        }
                    }
                    zzafVarZzb = null;
                }
                if (zzafVarZzb != null) {
                    zzk().zzq(zzafVarZzb, i, this.zzc);
                    zzafVarZzi = zzafVarZzb;
                }
                zzk().zzr(zzafVarZzi);
            } else {
                if (zzyVar != null && zzyVar.zzg != null && zzd().zzh(40)) {
                    zzafVarZzb = zzaf.zzb(zzyVar.zzg);
                    if (!zzafVarZzb.equals(zzaf.zza)) {
                        zzk().zzq(zzafVarZzb, 40, this.zzc);
                        zzafVarZzi = zzafVarZzb;
                    }
                }
                zzk().zzr(zzafVarZzi);
            }
        }
        if (zzd().zzc.zza() == 0) {
            zzd().zzc.zzb(this.zzr.currentTimeMillis());
        }
        if (Long.valueOf(zzd().zzh.zza()).longValue() == 0) {
            zzat().zzk().zzb("Persisting first open", Long.valueOf(this.zzc));
            zzd().zzh.zzb(this.zzc);
        }
        zzk().zzb.zzc();
        if (zzL()) {
            if (!TextUtils.isEmpty(zzA().zzj()) || !TextUtils.isEmpty(zzA().zzk())) {
                zzkk zzkkVarZzl = zzl();
                String strZzj = zzA().zzj();
                zzex zzexVarZzd2 = zzd();
                zzexVarZzd2.zzg();
                String string = zzexVarZzd2.zzd().getString("gmp_app_id", null);
                String strZzk = zzA().zzk();
                zzex zzexVarZzd3 = zzd();
                zzexVarZzd3.zzg();
                if (zzkkVarZzl.zzB(strZzj, string, strZzk, zzexVarZzd3.zzd().getString("admob_app_id", null))) {
                    zzat().zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzex zzexVarZzd4 = zzd();
                    zzexVarZzd4.zzg();
                    Boolean boolZzf = zzexVarZzd4.zzf();
                    SharedPreferences.Editor editorEdit = zzexVarZzd4.zzd().edit();
                    editorEdit.clear();
                    editorEdit.apply();
                    if (boolZzf != null) {
                        zzexVarZzd4.zze(boolZzf);
                    }
                    zzn().zzh();
                    this.zzy.zzF();
                    this.zzy.zzB();
                    zzd().zzh.zzb(this.zzc);
                    zzd().zzj.zzb(null);
                }
                zzex zzexVarZzd5 = zzd();
                String strZzj2 = zzA().zzj();
                zzexVarZzd5.zzg();
                SharedPreferences.Editor editorEdit2 = zzexVarZzd5.zzd().edit();
                editorEdit2.putString("gmp_app_id", strZzj2);
                editorEdit2.apply();
                zzex zzexVarZzd6 = zzd();
                String strZzk2 = zzA().zzk();
                zzexVarZzd6.zzg();
                SharedPreferences.Editor editorEdit3 = zzexVarZzd6.zzd().edit();
                editorEdit3.putString("admob_app_id", strZzk2);
                editorEdit3.apply();
            }
            zzlc.zzb();
            if (this.zzk.zzn(null, zzdvVar) && !zzd().zzi().zzh()) {
                zzd().zzj.zzb(null);
            }
            zzk().zzE(zzd().zzj.zza());
            zzll.zzb();
            if (this.zzk.zzn(null, zzdw.zzan)) {
                try {
                    zzl().zzx.zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(zzd().zzt.zza())) {
                        zzat().zze().zza("Remote config removed with active feature rollouts");
                        zzd().zzt.zzb(null);
                    }
                }
            }
            if (!TextUtils.isEmpty(zzA().zzj()) || !TextUtils.isEmpty(zzA().zzk())) {
                boolean zZzF = zzF();
                if (!zzd().zzk() && !this.zzk.zzr()) {
                    zzd().zzj(!zZzF);
                }
                if (zZzF) {
                    zzk().zzH();
                }
                zzh().zza.zza();
                zzy().zzv(new AtomicReference<>());
                zzy().zzA(zzd().zzw.zza());
            }
        } else if (zzF()) {
            if (!zzl().zzQ("android.permission.INTERNET")) {
                zzat().zzb().zza("App is missing INTERNET permission");
            }
            if (!zzl().zzQ("android.permission.ACCESS_NETWORK_STATE")) {
                zzat().zzb().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zze).isCallerInstantApp() && !this.zzk.zzy()) {
                if (!zzfb.zza(this.zze)) {
                    zzat().zzb().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzkk.zzP(this.zze, false)) {
                    zzat().zzb().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzat().zzb().zza("Uploading is not possible. App measurement disabled");
        }
        zzd().zzn.zzb(this.zzk.zzn(null, zzdw.zzW));
    }

    @Override // com.google.android.gms.measurement.internal.zzgg
    @Pure
    public final zzz zzas() {
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgg
    @Pure
    public final zzei zzat() {
        zzS(this.zzm);
        return this.zzm;
    }

    @Override // com.google.android.gms.measurement.internal.zzgg
    @Pure
    public final zzfi zzau() {
        zzS(this.zzn);
        return this.zzn;
    }

    @Override // com.google.android.gms.measurement.internal.zzgg
    @Pure
    public final Context zzaw() {
        return this.zze;
    }

    @Override // com.google.android.gms.measurement.internal.zzgg
    @Pure
    public final Clock zzax() {
        return this.zzr;
    }

    @Pure
    public final zzae zzc() {
        return this.zzk;
    }

    @Pure
    public final zzex zzd() {
        zzQ(this.zzl);
        return this.zzl;
    }

    public final zzei zzf() {
        zzei zzeiVar = this.zzm;
        if (zzeiVar == null || !zzeiVar.zzu()) {
            return null;
        }
        return this.zzm;
    }

    @Pure
    public final zzjq zzh() {
        zzR(this.zzo);
        return this.zzo;
    }

    @SideEffectFree
    public final zzfa zzi() {
        return this.zzB;
    }

    @SideEffectFree
    final zzfi zzj() {
        return this.zzn;
    }

    @Pure
    public final zzhn zzk() {
        zzR(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzkk zzl() {
        zzQ(this.zzp);
        return this.zzp;
    }

    @Pure
    public final zzed zzm() {
        zzQ(this.zzq);
        return this.zzq;
    }

    @Pure
    public final zzec zzn() {
        zzR(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzhr zzo() {
        zzS(this.zzv);
        return this.zzv;
    }

    @Pure
    public final boolean zzq() {
        return TextUtils.isEmpty(this.zzf);
    }

    @Pure
    public final String zzr() {
        return this.zzf;
    }

    @Pure
    public final String zzs() {
        return this.zzg;
    }

    @Pure
    public final String zzt() {
        return this.zzh;
    }

    @Pure
    public final boolean zzu() {
        return this.zzi;
    }

    @Pure
    public final String zzv() {
        return this.zzw;
    }

    @Pure
    public final zzib zzx() {
        zzR(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzjb zzy() {
        zzR(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzam zzz() {
        zzS(this.zzz);
        return this.zzz;
    }
}
