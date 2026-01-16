package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzlr;
import com.google.android.gms.internal.measurement.zzlx;
import com.google.android.gms.internal.measurement.zznb;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzhn extends zzf {
    protected zzhm zza;
    final zzr zzb;
    protected boolean zzc;
    private zzgl zzd;
    private final Set<zzgm> zze;
    private boolean zzf;
    private final AtomicReference<String> zzg;
    private final Object zzh;
    private zzaf zzi;
    private int zzj;
    private final AtomicLong zzk;
    private long zzl;
    private int zzm;
    private final zzkj zzn;

    protected zzhn(zzfl zzflVar) {
        super(zzflVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzc = true;
        this.zzn = new zzhc(this);
        this.zzg = new AtomicReference<>();
        this.zzi = new zzaf(null, null);
        this.zzj = 100;
        this.zzl = -1L;
        this.zzm = 100;
        this.zzk = new AtomicLong(0L);
        this.zzb = new zzr(zzflVar);
    }

    static /* synthetic */ void zzW(zzhn zzhnVar, zzaf zzafVar, int i, long j, boolean z, boolean z2) {
        zzhnVar.zzg();
        zzhnVar.zzb();
        if (j <= zzhnVar.zzl && zzaf.zzm(zzhnVar.zzm, i)) {
            zzhnVar.zzx.zzat().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzafVar);
            return;
        }
        zzex zzexVarZzd = zzhnVar.zzx.zzd();
        zzlc.zzb();
        if (zzexVarZzd.zzx.zzc().zzn(null, zzdw.zzaw)) {
            zzexVarZzd.zzg();
            if (zzexVarZzd.zzh(i)) {
                SharedPreferences.Editor editorEdit = zzexVarZzd.zzd().edit();
                editorEdit.putString("consent_settings", zzafVar.zzd());
                editorEdit.putInt("consent_source", i);
                editorEdit.apply();
                zzhnVar.zzl = j;
                zzhnVar.zzm = i;
                zzhnVar.zzx.zzy().zzj(z);
                if (z2) {
                    zzhnVar.zzx.zzy().zzv(new AtomicReference<>());
                    return;
                }
                return;
            }
        }
        zzhnVar.zzx.zzat().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzY(Boolean bool, boolean z) throws IllegalStateException {
        zzg();
        zzb();
        this.zzx.zzat().zzj().zzb("Setting app measurement enabled (FE)", bool);
        this.zzx.zzd().zze(bool);
        zzlc.zzb();
        zzae zzaeVarZzc = this.zzx.zzc();
        zzdv<Boolean> zzdvVar = zzdw.zzaw;
        if (zzaeVarZzc.zzn(null, zzdvVar) && z) {
            zzex zzexVarZzd = this.zzx.zzd();
            zzlc.zzb();
            if (zzexVarZzd.zzx.zzc().zzn(null, zzdvVar)) {
                zzexVarZzd.zzg();
                SharedPreferences.Editor editorEdit = zzexVarZzd.zzd().edit();
                if (bool != null) {
                    editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
                } else {
                    editorEdit.remove("measurement_enabled_from_api");
                }
                editorEdit.apply();
            }
        }
        zzlc.zzb();
        if (this.zzx.zzc().zzn(null, zzdvVar) && !this.zzx.zzI() && (bool == null || bool.booleanValue())) {
            return;
        }
        zzZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzZ() throws IllegalStateException {
        zzg();
        String strZza = this.zzx.zzd().zzm.zza();
        if (strZza != null) {
            if ("unset".equals(strZza)) {
                zzB("app", "_npa", null, this.zzx.zzax().currentTimeMillis());
            } else {
                zzB("app", "_npa", Long.valueOf(true != "true".equals(strZza) ? 0L : 1L), this.zzx.zzax().currentTimeMillis());
            }
        }
        if (!this.zzx.zzF() || !this.zzc) {
            this.zzx.zzat().zzj().zza("Updating Scion state (FE)");
            this.zzx.zzy().zzi();
            return;
        }
        this.zzx.zzat().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzH();
        zzlx.zzb();
        if (this.zzx.zzc().zzn(null, zzdw.zzao)) {
            this.zzx.zzh().zza.zza();
        }
        zzlr.zzb();
        if (this.zzx.zzc().zzn(null, zzdw.zzar)) {
            zzfa zzfaVarZzi = this.zzx.zzi();
            Preconditions.checkNotNull(zzfaVarZzi);
            if (zzfaVarZzi.zza.zzd().zzi.zza() <= 0) {
                zzfaVarZzi.zza(zzfaVarZzi.zza.zzaw().getPackageName());
            }
        }
        this.zzx.zzau().zzh(new zzgr(this));
    }

    final void zzA(String str, String str2, long j, Object obj) throws IllegalStateException {
        this.zzx.zzau().zzh(new zzgu(this, str, str2, obj, j));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zzB(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzg()
            r8.zzb()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L64
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L52
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L52
            r10 = 1
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            java.lang.String r0 = "false"
            boolean r11 = r0.equals(r11)
            r2 = 1
            if (r10 == r11) goto L37
            r10 = 0
            goto L38
        L37:
            r10 = r2
        L38:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.zzfl r10 = r8.zzx
            com.google.android.gms.measurement.internal.zzex r10 = r10.zzd()
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzm
            long r4 = r11.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L4e
            java.lang.String r0 = "true"
        L4e:
            r10.zzb(r0)
            goto L61
        L52:
            if (r11 != 0) goto L64
            com.google.android.gms.measurement.internal.zzfl r10 = r8.zzx
            com.google.android.gms.measurement.internal.zzex r10 = r10.zzd()
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzm
            java.lang.String r0 = "unset"
            r10.zzb(r0)
        L61:
            r6 = r11
            r3 = r1
            goto L66
        L64:
            r3 = r10
            r6 = r11
        L66:
            com.google.android.gms.measurement.internal.zzfl r10 = r8.zzx
            boolean r10 = r10.zzF()
            if (r10 != 0) goto L7e
            com.google.android.gms.measurement.internal.zzfl r9 = r8.zzx
            com.google.android.gms.measurement.internal.zzei r9 = r9.zzat()
            com.google.android.gms.measurement.internal.zzeg r9 = r9.zzk()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L7e:
            com.google.android.gms.measurement.internal.zzfl r10 = r8.zzx
            boolean r10 = r10.zzL()
            if (r10 != 0) goto L87
            return
        L87:
            com.google.android.gms.measurement.internal.zzkg r10 = new com.google.android.gms.measurement.internal.zzkg
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzfl r9 = r8.zzx
            com.google.android.gms.measurement.internal.zzjb r9 = r9.zzy()
            r9.zzs(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhn.zzB(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final String zzD() {
        return this.zzg.get();
    }

    final void zzE(String str) {
        this.zzg.set(str);
    }

    public final void zzF(long j) throws IllegalStateException {
        this.zzg.set(null);
        this.zzx.zzau().zzh(new zzgw(this, j));
    }

    final void zzG(long j, boolean z) {
        zzg();
        zzb();
        this.zzx.zzat().zzj().zza("Resetting analytics data (FE)");
        zzjq zzjqVarZzh = this.zzx.zzh();
        zzjqVarZzh.zzg();
        zzjqVarZzh.zzb.zzc();
        boolean zZzF = this.zzx.zzF();
        zzex zzexVarZzd = this.zzx.zzd();
        zzexVarZzd.zzh.zzb(j);
        if (!TextUtils.isEmpty(zzexVarZzd.zzx.zzd().zzt.zza())) {
            zzexVarZzd.zzt.zzb(null);
        }
        zzlx.zzb();
        zzae zzaeVarZzc = zzexVarZzd.zzx.zzc();
        zzdv<Boolean> zzdvVar = zzdw.zzao;
        if (zzaeVarZzc.zzn(null, zzdvVar)) {
            zzexVarZzd.zzo.zzb(0L);
        }
        if (!zzexVarZzd.zzx.zzc().zzr()) {
            zzexVarZzd.zzj(!zZzF);
        }
        zzexVarZzd.zzu.zzb(null);
        zzexVarZzd.zzv.zzb(0L);
        zzexVarZzd.zzw.zzb(null);
        if (z) {
            this.zzx.zzy().zzu();
        }
        zzlx.zzb();
        if (this.zzx.zzc().zzn(null, zzdvVar)) {
            this.zzx.zzh().zza.zza();
        }
        this.zzc = !zZzF;
    }

    public final void zzH() {
        zzg();
        zzb();
        if (this.zzx.zzL()) {
            if (this.zzx.zzc().zzn(null, zzdw.zzab)) {
                zzae zzaeVarZzc = this.zzx.zzc();
                zzaeVarZzc.zzx.zzas();
                Boolean boolZzp = zzaeVarZzc.zzp("google_analytics_deferred_deep_link_enabled");
                if (boolZzp != null && boolZzp.booleanValue()) {
                    this.zzx.zzat().zzj().zza("Deferred Deep Link feature enabled.");
                    this.zzx.zzau().zzh(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzgp
                        private final zzhn zza;

                        {
                            this.zza = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() throws IllegalStateException {
                            zzhn zzhnVar = this.zza;
                            zzhnVar.zzg();
                            if (zzhnVar.zzx.zzd().zzr.zza()) {
                                zzhnVar.zzx.zzat().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long jZza = zzhnVar.zzx.zzd().zzs.zza();
                            zzhnVar.zzx.zzd().zzs.zzb(1 + jZza);
                            zzhnVar.zzx.zzc();
                            if (jZza < 5) {
                                zzhnVar.zzx.zzM();
                            } else {
                                zzhnVar.zzx.zzat().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                zzhnVar.zzx.zzd().zzr.zzb(true);
                            }
                        }
                    });
                }
            }
            this.zzx.zzy().zzy();
            this.zzc = false;
            zzex zzexVarZzd = this.zzx.zzd();
            zzexVarZzd.zzg();
            String string = zzexVarZzd.zzd().getString("previous_os_version", null);
            zzexVarZzd.zzx.zzz().zzv();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = zzexVarZzd.zzd().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.zzx.zzz().zzv();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            zzs("auto", "_ou", bundle);
        }
    }

    public final void zzI(zzgl zzglVar) {
        zzgl zzglVar2;
        zzg();
        zzb();
        if (zzglVar != null && zzglVar != (zzglVar2 = this.zzd)) {
            Preconditions.checkState(zzglVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzglVar;
    }

    public final void zzJ(zzgm zzgmVar) {
        zzb();
        Preconditions.checkNotNull(zzgmVar);
        if (this.zze.add(zzgmVar)) {
            return;
        }
        this.zzx.zzat().zze().zza("OnEventListener already registered");
    }

    public final void zzK(zzgm zzgmVar) {
        zzb();
        Preconditions.checkNotNull(zzgmVar);
        if (this.zze.remove(zzgmVar)) {
            return;
        }
        this.zzx.zzat().zze().zza("OnEventListener had not been registered");
    }

    public final int zzL(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzx.zzc();
        return 25;
    }

    public final void zzM(Bundle bundle) throws IllegalStateException {
        zzN(bundle, this.zzx.zzax().currentTimeMillis());
    }

    public final void zzN(Bundle bundle, long j) throws IllegalStateException {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzx.zzat().zze().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzgh.zzb(bundle2, "app_id", String.class, null);
        zzgh.zzb(bundle2, "origin", String.class, null);
        zzgh.zzb(bundle2, "name", String.class, null);
        zzgh.zzb(bundle2, "value", Object.class, null);
        zzgh.zzb(bundle2, "trigger_event_name", String.class, null);
        zzgh.zzb(bundle2, "trigger_timeout", Long.class, 0L);
        zzgh.zzb(bundle2, "timed_out_event_name", String.class, null);
        zzgh.zzb(bundle2, "timed_out_event_params", Bundle.class, null);
        zzgh.zzb(bundle2, "triggered_event_name", String.class, null);
        zzgh.zzb(bundle2, "triggered_event_params", Bundle.class, null);
        zzgh.zzb(bundle2, "time_to_live", Long.class, 0L);
        zzgh.zzb(bundle2, "expired_event_name", String.class, null);
        zzgh.zzb(bundle2, "expired_event_params", Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.zzx.zzl().zzo(string) != 0) {
            this.zzx.zzat().zzb().zzb("Invalid conditional user property name", this.zzx.zzm().zze(string));
            return;
        }
        if (this.zzx.zzl().zzJ(string, obj) != 0) {
            this.zzx.zzat().zzb().zzc("Invalid conditional user property value", this.zzx.zzm().zze(string), obj);
            return;
        }
        Object objZzK = this.zzx.zzl().zzK(string, obj);
        if (objZzK == null) {
            this.zzx.zzat().zzb().zzc("Unable to normalize conditional user property value", this.zzx.zzm().zze(string), obj);
            return;
        }
        zzgh.zza(bundle2, objZzK);
        long j2 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
            this.zzx.zzc();
            if (j2 > 15552000000L || j2 < 1) {
                this.zzx.zzat().zzb().zzc("Invalid conditional user property timeout", this.zzx.zzm().zze(string), Long.valueOf(j2));
                return;
            }
        }
        long j3 = bundle2.getLong("time_to_live");
        this.zzx.zzc();
        if (j3 > 15552000000L || j3 < 1) {
            this.zzx.zzat().zzb().zzc("Invalid conditional user property time to live", this.zzx.zzm().zze(string), Long.valueOf(j3));
        } else {
            this.zzx.zzau().zzh(new zzgx(this, bundle2));
        }
    }

    public final void zzO(String str, String str2, Bundle bundle) throws IllegalStateException {
        long jCurrentTimeMillis = this.zzx.zzax().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        this.zzx.zzau().zzh(new zzgy(this, bundle2));
    }

    public final ArrayList<Bundle> zzP(String str, String str2) {
        if (this.zzx.zzau().zzd()) {
            this.zzx.zzat().zzb().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        this.zzx.zzas();
        if (zzz.zza()) {
            this.zzx.zzat().zzb().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzx.zzau().zzi(atomicReference, 5000L, "get conditional user properties", new zzha(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzkk.zzak(list);
        }
        this.zzx.zzat().zzb().zzb("Timed out waiting for get conditional user properties", null);
        return new ArrayList<>();
    }

    public final Map<String, Object> zzQ(String str, String str2, boolean z) {
        if (this.zzx.zzau().zzd()) {
            this.zzx.zzat().zzb().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.zzx.zzas();
        if (zzz.zza()) {
            this.zzx.zzat().zzb().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzx.zzau().zzi(atomicReference, 5000L, "get user properties", new zzhb(this, atomicReference, null, str, str2, z));
        List<zzkg> list = (List) atomicReference.get();
        if (list == null) {
            this.zzx.zzat().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzkg zzkgVar : list) {
            Object objZza = zzkgVar.zza();
            if (objZza != null) {
                arrayMap.put(zzkgVar.zzb, objZza);
            }
        }
        return arrayMap;
    }

    public final String zzR() {
        zzhu zzhuVarZzl = this.zzx.zzx().zzl();
        if (zzhuVarZzl != null) {
            return zzhuVarZzl.zza;
        }
        return null;
    }

    public final String zzS() {
        zzhu zzhuVarZzl = this.zzx.zzx().zzl();
        if (zzhuVarZzl != null) {
            return zzhuVarZzl.zzb;
        }
        return null;
    }

    public final String zzT() {
        if (this.zzx.zzr() != null) {
            return this.zzx.zzr();
        }
        try {
            zznb.zzb();
            return this.zzx.zzc().zzn(null, zzdw.zzaB) ? zzht.zzb(this.zzx.zzaw(), "google_app_id", this.zzx.zzv()) : zzht.zza(this.zzx.zzaw(), "google_app_id");
        } catch (IllegalStateException e) {
            this.zzx.zzat().zzb().zzb("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    final /* synthetic */ void zzU(Bundle bundle) {
        if (bundle == null) {
            this.zzx.zzd().zzw.zzb(new Bundle());
            return;
        }
        Bundle bundleZza = this.zzx.zzd().zzw.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.zzx.zzl().zzs(obj)) {
                    this.zzx.zzl().zzM(this.zzn, null, 27, null, null, 0);
                }
                this.zzx.zzat().zzh().zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzkk.zzR(str)) {
                this.zzx.zzat().zzh().zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                bundleZza.remove(str);
            } else {
                zzkk zzkkVarZzl = this.zzx.zzl();
                this.zzx.zzc();
                if (zzkkVarZzl.zzt("param", str, 100, obj)) {
                    this.zzx.zzl().zzL(bundleZza, str, obj);
                }
            }
        }
        this.zzx.zzl();
        int iZzc = this.zzx.zzc().zzc();
        if (bundleZza.size() > iZzc) {
            int i = 0;
            for (String str2 : new TreeSet(bundleZza.keySet())) {
                i++;
                if (i > iZzc) {
                    bundleZza.remove(str2);
                }
            }
            this.zzx.zzl().zzM(this.zzn, null, 26, null, null, 0);
            this.zzx.zzat().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.zzx.zzd().zzw.zzb(bundleZza);
        this.zzx.zzy().zzA(bundleZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        if (!(this.zzx.zzaw().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) this.zzx.zzaw().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzx.zzau().zzi(atomicReference, 15000L, "boolean test flag value", new zzgz(this, atomicReference));
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzx.zzau().zzi(atomicReference, 15000L, "String test flag value", new zzhd(this, atomicReference));
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzx.zzau().zzi(atomicReference, 15000L, "long test flag value", new zzhe(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzx.zzau().zzi(atomicReference, 15000L, "int test flag value", new zzhf(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzx.zzau().zzi(atomicReference, 15000L, "double test flag value", new zzhg(this, atomicReference));
    }

    public final void zzn(Boolean bool) throws IllegalStateException {
        zzb();
        this.zzx.zzau().zzh(new zzhh(this, bool));
    }

    public final void zzo(Bundle bundle, int i, long j) {
        zzlc.zzb();
        if (this.zzx.zzc().zzn(null, zzdw.zzaw)) {
            zzb();
            String strZza = zzaf.zza(bundle);
            if (strZza != null) {
                this.zzx.zzat().zzh().zzb("Ignoring invalid consent setting", strZza);
                this.zzx.zzat().zzh().zza("Valid consent values are 'granted', 'denied'");
            }
            zzq(zzaf.zzb(bundle), i, j);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ac, code lost:
    
        if (r6 == 20) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzq(com.google.android.gms.measurement.internal.zzaf r16, int r17, long r18) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhn.zzq(com.google.android.gms.measurement.internal.zzaf, int, long):void");
    }

    final void zzr(zzaf zzafVar) {
        zzg();
        boolean z = (zzafVar.zzh() && zzafVar.zzf()) || this.zzx.zzy().zzH();
        if (z != this.zzx.zzI()) {
            this.zzx.zzH(z);
            zzex zzexVarZzd = this.zzx.zzd();
            zzlc.zzb();
            Boolean boolValueOf = null;
            if (zzexVarZzd.zzx.zzc().zzn(null, zzdw.zzaw)) {
                zzexVarZzd.zzg();
                if (zzexVarZzd.zzd().contains("measurement_enabled_from_api")) {
                    boolValueOf = Boolean.valueOf(zzexVarZzd.zzd().getBoolean("measurement_enabled_from_api", true));
                }
            }
            if (!z || boolValueOf == null || boolValueOf.booleanValue()) {
                zzY(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        zzv(str, str2, bundle, true, true, this.zzx.zzax().currentTimeMillis());
    }

    final void zzt(String str, String str2, long j, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        zzg();
        zzu(str, str2, j, bundle, true, this.zzd == null || zzkk.zzR(str2), false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void zzu(java.lang.String r23, java.lang.String r24, long r25, android.os.Bundle r27, boolean r28, boolean r29, boolean r30, java.lang.String r31) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhn.zzu(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zzv(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws IllegalStateException {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (this.zzx.zzc().zzn(null, zzdw.zzat) && zzkk.zzS(str2, "screen_view")) {
            this.zzx.zzx().zzj(bundle2, j);
            return;
        }
        zzx(str3, str2, j, bundle2, z2, !z2 || this.zzd == null || zzkk.zzR(str2), !z, null);
    }

    protected final void zzx(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) throws IllegalStateException {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.zzx.zzau().zzh(new zzgt(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    public final void zzy(String str, String str2, Object obj, boolean z) throws IllegalStateException {
        zzz("auto", str2, obj, true, this.zzx.zzax().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzz(java.lang.String r16, java.lang.String r17, java.lang.Object r18, boolean r19, long r20) throws java.lang.IllegalStateException {
        /*
            r15 = this;
            r6 = r15
            r2 = r17
            r0 = r18
            if (r16 != 0) goto La
            java.lang.String r1 = "app"
            goto Lc
        La:
            r1 = r16
        Lc:
            r3 = 6
            r4 = 0
            r5 = 24
            if (r19 == 0) goto L1e
            com.google.android.gms.measurement.internal.zzfl r3 = r6.zzx
            com.google.android.gms.measurement.internal.zzkk r3 = r3.zzl()
            int r3 = r3.zzo(r2)
            r11 = r3
            goto L49
        L1e:
            com.google.android.gms.measurement.internal.zzfl r7 = r6.zzx
            com.google.android.gms.measurement.internal.zzkk r7 = r7.zzl()
            java.lang.String r8 = "user property"
            boolean r9 = r7.zzj(r8, r2)
            if (r9 != 0) goto L2e
        L2c:
            r11 = 6
            goto L49
        L2e:
            java.lang.String[] r9 = com.google.android.gms.measurement.internal.zzgk.zza
            r10 = 0
            boolean r9 = r7.zzl(r8, r9, r10, r2)
            if (r9 != 0) goto L3c
            r3 = 15
            r11 = 15
            goto L49
        L3c:
            com.google.android.gms.measurement.internal.zzfl r9 = r7.zzx
            r9.zzc()
            boolean r7 = r7.zzm(r8, r5, r2)
            if (r7 != 0) goto L48
            goto L2c
        L48:
            r11 = 0
        L49:
            r3 = 1
            if (r11 == 0) goto L73
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzkk r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzfl r1 = r6.zzx
            r1.zzc()
            java.lang.String r13 = r0.zzC(r2, r5, r3)
            if (r2 == 0) goto L63
            int r4 = r17.length()
            r14 = r4
            goto L64
        L63:
            r14 = 0
        L64:
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzkk r8 = r0.zzl()
            com.google.android.gms.measurement.internal.zzkj r9 = r6.zzn
            r10 = 0
            java.lang.String r12 = "_ev"
            r8.zzM(r9, r10, r11, r12, r13, r14)
            return
        L73:
            if (r0 == 0) goto Lc8
            com.google.android.gms.measurement.internal.zzfl r7 = r6.zzx
            com.google.android.gms.measurement.internal.zzkk r7 = r7.zzl()
            int r11 = r7.zzJ(r2, r0)
            if (r11 == 0) goto Lb3
            com.google.android.gms.measurement.internal.zzfl r1 = r6.zzx
            com.google.android.gms.measurement.internal.zzkk r1 = r1.zzl()
            com.google.android.gms.measurement.internal.zzfl r7 = r6.zzx
            r7.zzc()
            java.lang.String r13 = r1.zzC(r2, r5, r3)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L9b
            boolean r1 = r0 instanceof java.lang.CharSequence
            if (r1 == 0) goto L99
            goto L9b
        L99:
            r14 = 0
            goto La4
        L9b:
            java.lang.String r0 = java.lang.String.valueOf(r18)
            int r4 = r0.length()
            r14 = r4
        La4:
            com.google.android.gms.measurement.internal.zzfl r0 = r6.zzx
            com.google.android.gms.measurement.internal.zzkk r8 = r0.zzl()
            com.google.android.gms.measurement.internal.zzkj r9 = r6.zzn
            r10 = 0
            java.lang.String r12 = "_ev"
            r8.zzM(r9, r10, r11, r12, r13, r14)
            return
        Lb3:
            com.google.android.gms.measurement.internal.zzfl r3 = r6.zzx
            com.google.android.gms.measurement.internal.zzkk r3 = r3.zzl()
            java.lang.Object r5 = r3.zzK(r2, r0)
            if (r5 == 0) goto Lc7
            r0 = r15
            r2 = r17
            r3 = r20
            r0.zzA(r1, r2, r3, r5)
        Lc7:
            return
        Lc8:
            r5 = 0
            r0 = r15
            r2 = r17
            r3 = r20
            r0.zzA(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhn.zzz(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }
}
