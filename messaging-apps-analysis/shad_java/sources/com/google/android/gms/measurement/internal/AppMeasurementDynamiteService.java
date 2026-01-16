package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzlc;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
@DynamiteApi
/* loaded from: classes3.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzo {
    zzfl zza = null;
    private final Map<Integer, zzgm> zzb = new ArrayMap();

    @EnsuresNonNull({"scion"})
    private final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(com.google.android.gms.internal.measurement.zzs zzsVar, String str) {
        zzb();
        this.zza.zzl().zzad(zzsVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void beginAdUnitExposure(@RecentlyNonNull String str, long j) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzB().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void clearConditionalUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzk().zzO(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void clearMeasurementEnabled(long j) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzk().zzn(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void endAdUnitExposure(@RecentlyNonNull String str, long j) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzB().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void generateEventId(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zzb();
        long jZzd = this.zza.zzl().zzd();
        zzb();
        this.zza.zzl().zzae(zzsVar, jZzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzs zzsVar) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzau().zzh(new zzh(this, zzsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zzb();
        zzc(zzsVar, this.zza.zzk().zzD());
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzs zzsVar) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzau().zzh(new zzl(this, zzsVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zzb();
        zzc(zzsVar, this.zza.zzk().zzS());
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zzb();
        zzc(zzsVar, this.zza.zzk().zzR());
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zzb();
        zzc(zzsVar, this.zza.zzk().zzT());
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzs zzsVar) throws RemoteException {
        zzb();
        this.zza.zzk().zzL(str);
        zzb();
        this.zza.zzl().zzaf(zzsVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getTestFlag(com.google.android.gms.internal.measurement.zzs zzsVar, int i) throws RemoteException {
        zzb();
        if (i == 0) {
            this.zza.zzl().zzad(zzsVar, this.zza.zzk().zzj());
            return;
        }
        if (i == 1) {
            this.zza.zzl().zzae(zzsVar, this.zza.zzk().zzk().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.zza.zzl().zzaf(zzsVar, this.zza.zzk().zzl().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.zza.zzl().zzah(zzsVar, this.zza.zzk().zzi().booleanValue());
                return;
            }
        }
        zzkk zzkkVarZzl = this.zza.zzl();
        double dDoubleValue = this.zza.zzk().zzm().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e) {
            zzkkVarZzl.zzx.zzat().zze().zzb("Error returning double value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getUserProperties(String str, String str2, boolean z, com.google.android.gms.internal.measurement.zzs zzsVar) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzau().zzh(new zzj(this, zzsVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void initForTests(@RecentlyNonNull Map map) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzy zzyVar, long j) throws RemoteException {
        zzfl zzflVar = this.zza;
        if (zzflVar == null) {
            this.zza = zzfl.zzC((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzyVar, Long.valueOf(j));
        } else {
            zzflVar.zzat().zze().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzs zzsVar) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzau().zzh(new zzm(this, zzsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void logEvent(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle, boolean z, boolean z2, long j) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzk().zzv(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzs zzsVar, long j) throws IllegalStateException, RemoteException {
        zzb();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.zza.zzau().zzh(new zzi(this, zzsVar, new zzas(str2, new zzaq(bundle), "app", j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void logHealthData(int i, @RecentlyNonNull String str, @RecentlyNonNull IObjectWrapper iObjectWrapper, @RecentlyNonNull IObjectWrapper iObjectWrapper2, @RecentlyNonNull IObjectWrapper iObjectWrapper3) throws RemoteException {
        zzb();
        this.zza.zzat().zzm(i, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityCreated(@RecentlyNonNull IObjectWrapper iObjectWrapper, @RecentlyNonNull Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhm zzhmVar = this.zza.zzk().zza;
        if (zzhmVar != null) {
            this.zza.zzk().zzh();
            zzhmVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityDestroyed(@RecentlyNonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhm zzhmVar = this.zza.zzk().zza;
        if (zzhmVar != null) {
            this.zza.zzk().zzh();
            zzhmVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityPaused(@RecentlyNonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhm zzhmVar = this.zza.zzk().zza;
        if (zzhmVar != null) {
            this.zza.zzk().zzh();
            zzhmVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityResumed(@RecentlyNonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzhm zzhmVar = this.zza.zzk().zza;
        if (zzhmVar != null) {
            this.zza.zzk().zzh();
            zzhmVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzs zzsVar, long j) throws RemoteException {
        zzb();
        zzhm zzhmVar = this.zza.zzk().zza;
        Bundle bundle = new Bundle();
        if (zzhmVar != null) {
            this.zza.zzk().zzh();
            zzhmVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zza.zzat().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityStarted(@RecentlyNonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        if (this.zza.zzk().zza != null) {
            this.zza.zzk().zzh();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityStopped(@RecentlyNonNull IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        if (this.zza.zzk().zza != null) {
            this.zza.zzk().zzh();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzs zzsVar, long j) throws RemoteException {
        zzb();
        zzsVar.zzb(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzv zzvVar) throws RemoteException {
        zzgm zzoVar;
        zzb();
        synchronized (this.zzb) {
            zzoVar = this.zzb.get(Integer.valueOf(zzvVar.zze()));
            if (zzoVar == null) {
                zzoVar = new zzo(this, zzvVar);
                this.zzb.put(Integer.valueOf(zzvVar.zze()), zzoVar);
            }
        }
        this.zza.zzk().zzJ(zzoVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void resetAnalyticsData(long j) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzk().zzF(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setConditionalUserProperty(@RecentlyNonNull Bundle bundle, long j) throws IllegalStateException, RemoteException {
        zzb();
        if (bundle == null) {
            this.zza.zzat().zzb().zza("Conditional user property must not be null");
        } else {
            this.zza.zzk().zzN(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setConsent(@RecentlyNonNull Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhn zzhnVarZzk = this.zza.zzk();
        zzlc.zzb();
        if (zzhnVarZzk.zzx.zzc().zzn(null, zzdw.zzaw)) {
            zzhnVarZzk.zzo(bundle, 30, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setConsentThirdParty(@RecentlyNonNull Bundle bundle, long j) throws RemoteException {
        zzb();
        zzhn zzhnVarZzk = this.zza.zzk();
        zzlc.zzb();
        if (zzhnVarZzk.zzx.zzc().zzn(null, zzdw.zzax)) {
            zzhnVarZzk.zzo(bundle, 10, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setCurrentScreen(@RecentlyNonNull IObjectWrapper iObjectWrapper, @RecentlyNonNull String str, @RecentlyNonNull String str2, long j) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzx().zzk((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setDataCollectionEnabled(boolean z) throws IllegalStateException, RemoteException {
        zzb();
        zzhn zzhnVarZzk = this.zza.zzk();
        zzhnVarZzk.zzb();
        zzhnVarZzk.zzx.zzau().zzh(new zzgq(zzhnVarZzk, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setDefaultEventParameters(@RecentlyNonNull Bundle bundle) throws IllegalStateException {
        zzb();
        final zzhn zzhnVarZzk = this.zza.zzk();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zzhnVarZzk.zzx.zzau().zzh(new Runnable(zzhnVarZzk, bundle2) { // from class: com.google.android.gms.measurement.internal.zzgo
            private final zzhn zza;
            private final Bundle zzb;

            {
                this.zza = zzhnVarZzk;
                this.zzb = bundle2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzU(this.zzb);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzv zzvVar) throws IllegalStateException, RemoteException {
        zzb();
        zzn zznVar = new zzn(this, zzvVar);
        if (this.zza.zzau().zzd()) {
            this.zza.zzk().zzI(zznVar);
        } else {
            this.zza.zzau().zzh(new zzk(this, zznVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzx zzxVar) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setMeasurementEnabled(boolean z, long j) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzk().zzn(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setSessionTimeoutDuration(long j) throws IllegalStateException, RemoteException {
        zzb();
        zzhn zzhnVarZzk = this.zza.zzk();
        zzhnVarZzk.zzx.zzau().zzh(new zzgs(zzhnVarZzk, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setUserId(@RecentlyNonNull String str, long j) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzk().zzz(null, "_id", str, true, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull IObjectWrapper iObjectWrapper, boolean z, long j) throws IllegalStateException, RemoteException {
        zzb();
        this.zza.zzk().zzz(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzv zzvVar) throws RemoteException {
        zzgm zzgmVarRemove;
        zzb();
        synchronized (this.zzb) {
            zzgmVarRemove = this.zzb.remove(Integer.valueOf(zzvVar.zze()));
        }
        if (zzgmVarRemove == null) {
            zzgmVarRemove = new zzo(this, zzvVar);
        }
        this.zza.zzk().zzK(zzgmVarRemove);
    }
}
