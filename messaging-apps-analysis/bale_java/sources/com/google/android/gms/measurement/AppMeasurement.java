package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.measurement.internal.H1;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC23966xo8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Kp8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public class AppMeasurement {
    private static volatile AppMeasurement b;
    private final c a;

    public static class ConditionalUserProperty {

        @Keep
        public boolean mActive;

        @Keep
        public String mAppId;

        @Keep
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @Keep
        public String mName;

        @Keep
        public String mOrigin;

        @Keep
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @Keep
        public String mTriggerEventName;

        @Keep
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        public long mTriggeredTimestamp;

        @Keep
        public Object mValue;

        ConditionalUserProperty(Bundle bundle) {
            AbstractC3795Cj5.j(bundle);
            this.mAppId = (String) AbstractC23966xo8.a(bundle, CommonUrlParts.APP_ID, String.class, null);
            this.mOrigin = (String) AbstractC23966xo8.a(bundle, "origin", String.class, null);
            this.mName = (String) AbstractC23966xo8.a(bundle, "name", String.class, null);
            this.mValue = AbstractC23966xo8.a(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) AbstractC23966xo8.a(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) AbstractC23966xo8.a(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) AbstractC23966xo8.a(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) AbstractC23966xo8.a(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) AbstractC23966xo8.a(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) AbstractC23966xo8.a(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) AbstractC23966xo8.a(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) AbstractC23966xo8.a(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) AbstractC23966xo8.a(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) AbstractC23966xo8.a(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) AbstractC23966xo8.a(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) AbstractC23966xo8.a(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    public AppMeasurement(H1 h1) {
        this.a = new a(h1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        if (b == null) {
            synchronized (AppMeasurement.class) {
                if (b == null) {
                    Kp8 kp8 = (Kp8) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    if (kp8 != null) {
                        b = new AppMeasurement(kp8);
                    } else {
                        b = new AppMeasurement(H1.H(context, new zzcl(0L, 0L, true, null, null, null, null, null), null));
                    }
                }
            }
        }
        return b;
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.a.l(str);
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.a.r(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.a.n(str);
    }

    @Keep
    public long generateEventId() {
        return this.a.c();
    }

    @Keep
    public String getAppInstanceId() {
        return this.a.k();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List listO = this.a.o(str, str2);
        ArrayList arrayList = new ArrayList(listO == null ? 0 : listO.size());
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty((Bundle) it.next()));
        }
        return arrayList;
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.a.j();
    }

    @Keep
    public String getCurrentScreenName() {
        return this.a.m();
    }

    @Keep
    public String getGmpAppId() {
        return this.a.h();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        return this.a.a(str);
    }

    @VisibleForTesting
    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.a.p(str, str2, z);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.a.i(str, str2, bundle);
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        AbstractC3795Cj5.j(conditionalUserProperty);
        c cVar = this.a;
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString(CommonUrlParts.APP_ID, str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            AbstractC23966xo8.b(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        cVar.q(bundle);
    }

    public AppMeasurement(Kp8 kp8) {
        this.a = new b(kp8);
    }
}
