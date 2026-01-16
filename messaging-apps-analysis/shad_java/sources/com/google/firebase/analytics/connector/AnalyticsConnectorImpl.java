package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes3.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzc;
    final AppMeasurementSdk zza;
    final Map<String, com.google.firebase.analytics.connector.internal.zza> zzb;

    AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.zza = appMeasurementSdk;
        this.zzb = new ConcurrentHashMap();
    }

    static final /* synthetic */ void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) Preconditions.checkNotNull(zzc)).zza.zza(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc(String str) {
        return (str.isEmpty() || !this.zzb.containsKey(str) || this.zzb.get(str) == null) ? false : true;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        if (str2 == null || zzc.zzb(str2, bundle)) {
            this.zza.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @RecentlyNonNull
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<Bundle> it = this.zza.getConditionalUserProperties(str, str2).iterator();
        while (it.hasNext()) {
            arrayList.add(zzc.zzh(it.next()));
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(@RecentlyNonNull String str) {
        return this.zza.getMaxUserProperties(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zza(str) && zzc.zzb(str2, bundle) && zzc.zzf(str, str2, bundle)) {
            zzc.zzm(str, str2, bundle);
            this.zza.logEvent(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @RecentlyNonNull
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@RecentlyNonNull final String str, @RecentlyNonNull AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzc.zza(str) || zzc(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.zza;
        com.google.firebase.analytics.connector.internal.zza zzeVar = "fiam".equals(str) ? new zze(appMeasurementSdk, analyticsConnectorListener) : ("crash".equals(str) || "clx".equals(str)) ? new zzg(appMeasurementSdk, analyticsConnectorListener) : null;
        if (zzeVar == null) {
            return null;
        }
        this.zzb.put(str, zzeVar);
        return new AnalyticsConnector.AnalyticsConnectorHandle() { // from class: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.1
            @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
            public void registerEventNames(Set<String> set) {
                if (!AnalyticsConnectorImpl.this.zzc(str) || !str.equals("fiam") || set == null || set.isEmpty()) {
                    return;
                }
                AnalyticsConnectorImpl.this.zzb.get(str).zzb(set);
            }
        };
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(@RecentlyNonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzc.zze(conditionalUserProperty)) {
            this.zza.setConditionalUserProperty(zzc.zzg(conditionalUserProperty));
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Object obj) {
        if (zzc.zza(str) && zzc.zzd(str, str2)) {
            this.zza.setUserProperty(str, str2, obj);
        }
    }

    @RecentlyNonNull
    public static AnalyticsConnector getInstance(@RecentlyNonNull FirebaseApp firebaseApp, @RecentlyNonNull Context context, @RecentlyNonNull Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzc == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zza.zza, zzb.zza);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzc = new AnalyticsConnectorImpl(zzbr.zza(context, null, null, null, bundle).zzb());
                }
            }
        }
        return zzc;
    }
}
