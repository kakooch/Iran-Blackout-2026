package ir.nasim;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.internal.measurement.zzcl;
import java.util.Map;

/* renamed from: ir.nasim.jl8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC15546jl8 extends IInterface {
    void beginAdUnitExposure(String str, long j);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j);

    void endAdUnitExposure(String str, long j);

    void generateEventId(InterfaceC19683ql8 interfaceC19683ql8);

    void getAppInstanceId(InterfaceC19683ql8 interfaceC19683ql8);

    void getCachedAppInstanceId(InterfaceC19683ql8 interfaceC19683ql8);

    void getConditionalUserProperties(String str, String str2, InterfaceC19683ql8 interfaceC19683ql8);

    void getCurrentScreenClass(InterfaceC19683ql8 interfaceC19683ql8);

    void getCurrentScreenName(InterfaceC19683ql8 interfaceC19683ql8);

    void getGmpAppId(InterfaceC19683ql8 interfaceC19683ql8);

    void getMaxUserProperties(String str, InterfaceC19683ql8 interfaceC19683ql8);

    void getSessionId(InterfaceC19683ql8 interfaceC19683ql8);

    void getTestFlag(InterfaceC19683ql8 interfaceC19683ql8, int i);

    void getUserProperties(String str, String str2, boolean z, InterfaceC19683ql8 interfaceC19683ql8);

    void initForTests(Map map);

    void initialize(XZ2 xz2, zzcl zzclVar, long j);

    void isDataCollectionEnabled(InterfaceC19683ql8 interfaceC19683ql8);

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j);

    void logEventAndBundle(String str, String str2, Bundle bundle, InterfaceC19683ql8 interfaceC19683ql8, long j);

    void logHealthData(int i, String str, XZ2 xz2, XZ2 xz22, XZ2 xz23);

    void onActivityCreated(XZ2 xz2, Bundle bundle, long j);

    void onActivityDestroyed(XZ2 xz2, long j);

    void onActivityPaused(XZ2 xz2, long j);

    void onActivityResumed(XZ2 xz2, long j);

    void onActivitySaveInstanceState(XZ2 xz2, InterfaceC19683ql8 interfaceC19683ql8, long j);

    void onActivityStarted(XZ2 xz2, long j);

    void onActivityStopped(XZ2 xz2, long j);

    void performAction(Bundle bundle, InterfaceC19683ql8 interfaceC19683ql8, long j);

    void registerOnMeasurementEventListener(InterfaceC20883sl8 interfaceC20883sl8);

    void resetAnalyticsData(long j);

    void setConditionalUserProperty(Bundle bundle, long j);

    void setConsent(Bundle bundle, long j);

    void setConsentThirdParty(Bundle bundle, long j);

    void setCurrentScreen(XZ2 xz2, String str, String str2, long j);

    void setDataCollectionEnabled(boolean z);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(InterfaceC20883sl8 interfaceC20883sl8);

    void setInstanceIdProvider(InterfaceC22750vl8 interfaceC22750vl8);

    void setMeasurementEnabled(boolean z, long j);

    void setMinimumSessionDuration(long j);

    void setSessionTimeoutDuration(long j);

    void setUserId(String str, long j);

    void setUserProperty(String str, String str2, XZ2 xz2, boolean z, long j);

    void unregisterOnMeasurementEventListener(InterfaceC20883sl8 interfaceC20883sl8);
}
