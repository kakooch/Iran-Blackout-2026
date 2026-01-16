package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzbr {
    private static volatile zzbr zzc;
    private static Boolean zzh;
    protected final Clock zza;
    protected final ExecutorService zzb;
    private final String zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<com.google.android.gms.measurement.internal.zzgm, zzbi>> zzf;
    private int zzg;
    private boolean zzi;
    private volatile zzp zzk;

    protected zzbr(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzX(str2, str3)) {
            this.zzd = "FA";
        } else {
            this.zzd = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzb = zzk.zza().zzb(new zzav(this), 1);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (com.google.android.gms.measurement.internal.zzht.zzb(context, "google_app_id", com.google.android.gms.measurement.internal.zzfd.zza(context)) != null && !zzT()) {
                this.zzi = true;
                Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (!zzX(str2, str3)) {
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.zzd, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzd, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        }
        zzU(new zzak(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzbq(this));
        }
    }

    static /* synthetic */ void zzO(Context context) {
        Bundle bundle;
        synchronized (zzbr.class) {
            try {
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                zzh = Boolean.TRUE;
            }
            if (zzh != null) {
                return;
            }
            Preconditions.checkNotEmpty("app_measurement_internal_disable_startup_flags");
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    if (bundle.getBoolean("app_measurement_internal_disable_startup_flags")) {
                        zzh = Boolean.TRUE;
                        return;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
            zzh = Boolean.valueOf(sharedPreferences.getBoolean("allow_remote_dynamite", true));
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove("allow_remote_dynamite");
            editorEdit.apply();
        }
    }

    protected static final boolean zzT() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzU(zzbg zzbgVar) {
        this.zzb.execute(zzbgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzV(Exception exc, boolean z, boolean z2) {
        this.zzi |= z;
        if (z) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzC(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(this.zzd, "Error with data collection. Data lost.", exc);
    }

    private final void zzW(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzU(new zzbe(this, l, str, str2, bundle, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzX(String str, String str2) {
        return (str2 == null || str == null || zzT()) ? false : true;
    }

    public static zzbr zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzbr.class) {
                if (zzc == null) {
                    zzc = new zzbr(context, str, str2, str3, bundle);
                }
            }
        }
        return zzc;
    }

    public final String zzA() {
        zzm zzmVar = new zzm();
        zzU(new zzar(this, zzmVar));
        return zzmVar.zzc(500L);
    }

    public final Map<String, Object> zzB(String str, String str2, boolean z) {
        zzm zzmVar = new zzm();
        zzU(new zzas(this, str, str2, z, zzmVar));
        Bundle bundleZzd = zzmVar.zzd(5000L);
        if (bundleZzd == null || bundleZzd.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleZzd.size());
        for (String str3 : bundleZzd.keySet()) {
            Object obj = bundleZzd.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    public final void zzC(int i, String str, Object obj, Object obj2, Object obj3) {
        zzU(new zzat(this, false, 5, str, obj, null, null));
    }

    public final int zzE(String str) {
        zzm zzmVar = new zzm();
        zzU(new zzaw(this, str, zzmVar));
        Integer num = (Integer) zzm.zze(zzmVar.zzd(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final void zzI(boolean z) {
        zzU(new zzaz(this, z));
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    public final void zze(com.google.android.gms.measurement.internal.zzgm zzgmVar) {
        Preconditions.checkNotNull(zzgmVar);
        synchronized (this.zzf) {
            for (int i = 0; i < this.zzf.size(); i++) {
                if (zzgmVar.equals(this.zzf.get(i).first)) {
                    Log.w(this.zzd, "OnEventListener already registered.");
                    return;
                }
            }
            zzbi zzbiVar = new zzbi(zzgmVar);
            this.zzf.add(new Pair<>(zzgmVar, zzbiVar));
            if (this.zzk != null) {
                try {
                    this.zzk.registerOnMeasurementEventListener(zzbiVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zzU(new zzbc(this, zzbiVar));
        }
    }

    public final void zzg(String str, Bundle bundle) {
        zzW(null, str, bundle, false, true, null);
    }

    public final void zzh(String str, String str2, Bundle bundle) {
        zzW(str, str2, bundle, true, true, null);
    }

    public final void zzj(String str, String str2, Object obj, boolean z) {
        zzU(new zzbf(this, str, str2, obj, z));
    }

    public final void zzk(Bundle bundle) {
        zzU(new zzaa(this, bundle));
    }

    public final void zzl(String str, String str2, Bundle bundle) {
        zzU(new zzab(this, str, str2, bundle));
    }

    public final List<Bundle> zzm(String str, String str2) {
        zzm zzmVar = new zzm();
        zzU(new zzac(this, str, str2, zzmVar));
        List<Bundle> list = (List) zzm.zze(zzmVar.zzd(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zzo(Activity activity, String str, String str2) {
        zzU(new zzae(this, activity, str, str2));
    }

    public final void zzu(String str) {
        zzU(new zzal(this, str));
    }

    public final void zzv(String str) {
        zzU(new zzam(this, str));
    }

    public final String zzw() {
        zzm zzmVar = new zzm();
        zzU(new zzan(this, zzmVar));
        return zzmVar.zzc(500L);
    }

    public final String zzx() {
        zzm zzmVar = new zzm();
        zzU(new zzao(this, zzmVar));
        return zzmVar.zzc(50L);
    }

    public final long zzy() {
        zzm zzmVar = new zzm();
        zzU(new zzap(this, zzmVar));
        Long l = (Long) zzm.zze(zzmVar.zzd(500L), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return jNextLong + i;
    }

    public final String zzz() {
        zzm zzmVar = new zzm();
        zzU(new zzaq(this, zzmVar));
        return zzmVar.zzc(500L);
    }

    protected final zzp zzc(Context context, boolean z) {
        try {
            return zzo.asInterface(DynamiteModule.load(context, z ? DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION : DynamiteModule.PREFER_LOCAL, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            zzV(e, true, false);
            return null;
        }
    }
}
