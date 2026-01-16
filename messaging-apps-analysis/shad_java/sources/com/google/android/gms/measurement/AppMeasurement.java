package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgh;
import com.google.android.gms.measurement.internal.zzho;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
@Deprecated
/* loaded from: classes3.dex */
public class AppMeasurement {
    private static volatile AppMeasurement zza;
    private final zzfl zzb;
    private final zzho zzc;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
    public static class ConditionalUserProperty {

        @Keep
        public boolean mActive;

        @RecentlyNonNull
        @Keep
        public String mAppId;

        @Keep
        public long mCreationTimestamp;

        @RecentlyNonNull
        @Keep
        public String mExpiredEventName;

        @RecentlyNonNull
        @Keep
        public Bundle mExpiredEventParams;

        @RecentlyNonNull
        @Keep
        public String mName;

        @RecentlyNonNull
        @Keep
        public String mOrigin;

        @Keep
        public long mTimeToLive;

        @RecentlyNonNull
        @Keep
        public String mTimedOutEventName;

        @RecentlyNonNull
        @Keep
        public Bundle mTimedOutEventParams;

        @RecentlyNonNull
        @Keep
        public String mTriggerEventName;

        @Keep
        public long mTriggerTimeout;

        @RecentlyNonNull
        @Keep
        public String mTriggeredEventName;

        @RecentlyNonNull
        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        public long mTriggeredTimestamp;

        @RecentlyNonNull
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        ConditionalUserProperty(Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzgh.zzb(bundle, "app_id", String.class, null);
            this.mOrigin = (String) zzgh.zzb(bundle, "origin", String.class, null);
            this.mName = (String) zzgh.zzb(bundle, "name", String.class, null);
            this.mValue = zzgh.zzb(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzgh.zzb(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) zzgh.zzb(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) zzgh.zzb(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) zzgh.zzb(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) zzgh.zzb(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) zzgh.zzb(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) zzgh.zzb(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) zzgh.zzb(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) zzgh.zzb(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) zzgh.zzb(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) zzgh.zzb(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzgh.zzb(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }

        final Bundle zza() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                zzgh.zza(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }
    }

    public AppMeasurement(zzfl zzflVar) {
        Preconditions.checkNotNull(zzflVar);
        this.zzb = zzflVar;
        this.zzc = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @RecentlyNonNull
    @Keep
    @Deprecated
    public static AppMeasurement getInstance(@RecentlyNonNull Context context) {
        if (zza == null) {
            synchronized (AppMeasurement.class) {
                if (zza == null) {
                    zzho zzhoVar = (zzho) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    if (zzhoVar != null) {
                        zza = new AppMeasurement(zzhoVar);
                    } else {
                        zza = new AppMeasurement(zzfl.zzC(context, new zzy(0L, 0L, true, null, null, null, null, null), null));
                    }
                }
            }
        }
        return zza;
    }

    @Keep
    public void beginAdUnitExposure(@RecentlyNonNull String str) throws IllegalStateException {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            zzhoVar.zzl(str);
        } else {
            Preconditions.checkNotNull(this.zzb);
            this.zzb.zzB().zza(str, this.zzb.zzax().elapsedRealtime());
        }
    }

    @Keep
    public void clearConditionalUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) throws IllegalStateException {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            zzhoVar.zzo(str, str2, bundle);
        } else {
            Preconditions.checkNotNull(this.zzb);
            this.zzb.zzk().zzO(str, str2, bundle);
        }
    }

    @Keep
    public void endAdUnitExposure(@RecentlyNonNull String str) throws IllegalStateException {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            zzhoVar.zzm(str);
        } else {
            Preconditions.checkNotNull(this.zzb);
            this.zzb.zzB().zzb(str, this.zzb.zzax().elapsedRealtime());
        }
    }

    @Keep
    public long generateEventId() {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            return zzhoVar.zzk();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzl().zzd();
    }

    @RecentlyNonNull
    @Keep
    public String getAppInstanceId() {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            return zzhoVar.zzi();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzD();
    }

    @RecentlyNonNull
    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        List<Bundle> listZzP;
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            listZzP = zzhoVar.zzp(str, str2);
        } else {
            Preconditions.checkNotNull(this.zzb);
            listZzP = this.zzb.zzk().zzP(str, str2);
        }
        ArrayList arrayList = new ArrayList(listZzP == null ? 0 : listZzP.size());
        Iterator<Bundle> it = listZzP.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    @RecentlyNonNull
    @Keep
    public String getCurrentScreenClass() {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            return zzhoVar.zzh();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzS();
    }

    @RecentlyNonNull
    @Keep
    public String getCurrentScreenName() {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            return zzhoVar.zzg();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzR();
    }

    @RecentlyNonNull
    @Keep
    public String getGmpAppId() {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            return zzhoVar.zzj();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzT();
    }

    @Keep
    public int getMaxUserProperties(@RecentlyNonNull String str) {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            return zzhoVar.zzq(str);
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzL(str);
        return 25;
    }

    @RecentlyNonNull
    @Keep
    protected Map<String, Object> getUserProperties(@RecentlyNonNull String str, @RecentlyNonNull String str2, boolean z) {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            return zzhoVar.zzc(str, str2, z);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzQ(str, str2, z);
    }

    @Keep
    public void logEventInternal(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            zzhoVar.zza(str, str2, bundle);
        } else {
            Preconditions.checkNotNull(this.zzb);
            this.zzb.zzk().zzs(str, str2, bundle);
        }
    }

    @Keep
    public void setConditionalUserProperty(@RecentlyNonNull ConditionalUserProperty conditionalUserProperty) throws IllegalStateException {
        Preconditions.checkNotNull(conditionalUserProperty);
        zzho zzhoVar = this.zzc;
        if (zzhoVar != null) {
            zzhoVar.zzn(conditionalUserProperty.zza());
        } else {
            Preconditions.checkNotNull(this.zzb);
            this.zzb.zzk().zzM(conditionalUserProperty.zza());
        }
    }

    public AppMeasurement(zzho zzhoVar) {
        Preconditions.checkNotNull(zzhoVar);
        this.zzc = zzhoVar;
        this.zzb = null;
    }
}
