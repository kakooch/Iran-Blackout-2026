package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import io.github.inflationx.calligraphy3.BuildConfig;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes.dex */
final class zzex extends zzgf {
    static final Pair<String, Long> zza = new Pair<>(BuildConfig.FLAVOR, 0L);
    private boolean zzA;
    private long zzB;
    public zzev zzb;
    public final zzeu zzc;
    public final zzeu zzd;
    public final zzeu zze;
    public final zzeu zzf;
    public final zzeu zzg;
    public final zzeu zzh;
    public final zzeu zzi;
    public final zzew zzj;
    public final zzeu zzk;
    public final zzes zzl;
    public final zzew zzm;
    public final zzes zzn;
    public final zzeu zzo;
    public boolean zzp;
    public final zzes zzq;
    public final zzes zzr;
    public final zzeu zzs;
    public final zzew zzt;
    public final zzew zzu;
    public final zzeu zzv;
    public final zzet zzw;
    private SharedPreferences zzy;
    private String zzz;

    zzex(zzfl zzflVar) {
        super(zzflVar);
        this.zzc = new zzeu(this, "last_upload", 0L);
        this.zzd = new zzeu(this, "last_upload_attempt", 0L);
        this.zze = new zzeu(this, "backoff", 0L);
        this.zzf = new zzeu(this, "last_delete_stale", 0L);
        this.zzk = new zzeu(this, "session_timeout", 1800000L);
        this.zzl = new zzes(this, "start_new_session", true);
        this.zzo = new zzeu(this, "last_pause_time", 0L);
        this.zzm = new zzew(this, "non_personalized_ads", null);
        this.zzn = new zzes(this, "allow_remote_dynamite", false);
        this.zzg = new zzeu(this, "midnight_offset", 0L);
        this.zzh = new zzeu(this, "first_open_time", 0L);
        this.zzi = new zzeu(this, "app_install_time", 0L);
        this.zzj = new zzew(this, "app_instance_id", null);
        this.zzq = new zzes(this, "app_backgrounded", false);
        this.zzr = new zzes(this, "deep_link_retrieval_complete", false);
        this.zzs = new zzeu(this, "deep_link_retrieval_attempts", 0L);
        this.zzt = new zzew(this, "firebase_feature_rollouts", null);
        this.zzu = new zzew(this, "deferred_attribution_cache", null);
        this.zzv = new zzeu(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzw = new zzet(this, "default_event_parameters", null);
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    protected final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzgf
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    protected final void zzay() {
        SharedPreferences sharedPreferences = this.zzx.zzaw().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzy = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzp = z;
        if (!z) {
            SharedPreferences.Editor editorEdit = this.zzy.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.zzx.zzc();
        this.zzb = new zzev(this, "health_monitor", Math.max(0L, zzdw.zzb.zzb(null).longValue()), null);
    }

    final Pair<String, Boolean> zzb(String str) {
        zzg();
        long jElapsedRealtime = this.zzx.zzax().elapsedRealtime();
        String str2 = this.zzz;
        if (str2 != null && jElapsedRealtime < this.zzB) {
            return new Pair<>(str2, Boolean.valueOf(this.zzA));
        }
        this.zzB = jElapsedRealtime + this.zzx.zzc().zzj(str, zzdw.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzx.zzaw());
            if (advertisingIdInfo != null) {
                this.zzz = advertisingIdInfo.getId();
                this.zzA = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzz == null) {
                this.zzz = BuildConfig.FLAVOR;
            }
        } catch (Exception e) {
            this.zzx.zzat().zzj().zzb("Unable to get advertising id", e);
            this.zzz = BuildConfig.FLAVOR;
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzz, Boolean.valueOf(this.zzA));
    }

    protected final SharedPreferences zzd() {
        zzg();
        zzv();
        Preconditions.checkNotNull(this.zzy);
        return this.zzy;
    }

    final void zze(Boolean bool) {
        zzg();
        SharedPreferences.Editor editorEdit = zzd().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    final Boolean zzf() {
        zzg();
        if (zzd().contains("measurement_enabled")) {
            return Boolean.valueOf(zzd().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    final boolean zzh(int i) {
        return zzaf.zzm(i, zzd().getInt("consent_source", 100));
    }

    final zzaf zzi() {
        zzg();
        return zzaf.zzc(zzd().getString("consent_settings", "G1"));
    }

    final void zzj(boolean z) {
        zzg();
        this.zzx.zzat().zzk().zzb("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = zzd().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    final boolean zzk() {
        SharedPreferences sharedPreferences = this.zzy;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    final boolean zzl(long j) {
        return j - this.zzk.zza() > this.zzo.zza();
    }
}
