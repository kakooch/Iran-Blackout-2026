package io.appmetrica.analytics.networktasks.internal;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetId;
import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.model.SdkEnvironment;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;

/* loaded from: classes3.dex */
public class BaseRequestConfig {
    private String a;
    private SdkEnvironment b;
    private SdkIdentifiers c;
    private AdvertisingIdsHolder d;
    private AppSetId e;
    private RetryPolicyConfig f;

    public static abstract class BaseRequestArguments<I, O> implements ArgumentsMerger<I, O> {
    }

    public static abstract class ComponentLoader<T extends BaseRequestConfig, A extends BaseRequestArguments, D extends DataSource<A>> implements RequestConfigLoader<T, D> {
        final Context a;
        final String b;

        protected ComponentLoader(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        protected abstract T createBlankConfig();

        public Context getContext() {
            return this.a;
        }

        public String getPackageName() {
            return this.b;
        }

        @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
        public T load(D d) {
            T t = (T) createBlankConfig();
            t.setSdkIdentifiers(d.sdkIdentifiers);
            t.setSdkEnvironment(d.sdkEnvironmentProvider.getSdkEnvironment());
            PlatformIdentifiers platformIdentifiers = d.platformIdentifiers;
            t.setAppSetId(platformIdentifiers.getAppSetIdProvider().getAppSetId());
            t.setAdvertisingIdsHolder(platformIdentifiers.getAdvIdentifiersProvider().getIdentifiers(this.a));
            t.setPackageName(this.b);
            return t;
        }
    }

    public static class DataSource<A> {
        public final A componentArguments;
        public final PlatformIdentifiers platformIdentifiers;
        public final SdkEnvironmentProvider sdkEnvironmentProvider;
        public final SdkIdentifiers sdkIdentifiers;

        public DataSource(SdkIdentifiers sdkIdentifiers, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, A a) {
            this.sdkIdentifiers = sdkIdentifiers;
            this.componentArguments = a;
            this.sdkEnvironmentProvider = sdkEnvironmentProvider;
            this.platformIdentifiers = platformIdentifiers;
        }
    }

    public interface RequestConfigLoader<T extends BaseRequestConfig, D> {
        T load(D d);
    }

    protected BaseRequestConfig() {
    }

    public AdvertisingIdsHolder getAdvertisingIdsHolder() {
        return this.d;
    }

    public String getAnalyticsSdkBuildNumber() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getSdkInfo().getSdkBuildNumber();
    }

    public String getAnalyticsSdkBuildType() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getSdkInfo().getSdkBuildType();
    }

    public String getAnalyticsSdkVersionName() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getSdkInfo().getSdkVersionName();
    }

    public String getAppBuildNumber() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getAppVersionInfo().getAppBuildNumber();
    }

    public String getAppFramework() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getAppFramework();
    }

    public String getAppPlatform() {
        return ConstantDeviceInfo.APP_PLATFORM;
    }

    public synchronized String getAppSetId() {
        AppSetId appSetId;
        try {
            appSetId = this.e;
        } finally {
        }
        return (appSetId == null || appSetId.getId() == null) ? "" : this.e.getId();
    }

    public synchronized String getAppSetIdScope() {
        AppSetId appSetId;
        try {
            appSetId = this.e;
        } finally {
        }
        return appSetId == null ? "" : appSetId.getScope().getValue();
    }

    public String getAppVersion() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getAppVersionInfo().getAppVersionName();
    }

    public synchronized String getDeviceIDHash() {
        String deviceIdHash;
        deviceIdHash = "";
        SdkIdentifiers sdkIdentifiers = this.c;
        if (sdkIdentifiers != null && sdkIdentifiers.getDeviceIdHash() != null) {
            deviceIdHash = this.c.getDeviceIdHash();
        }
        return deviceIdHash;
    }

    public synchronized String getDeviceId() {
        String deviceId;
        deviceId = "";
        SdkIdentifiers sdkIdentifiers = this.c;
        if (sdkIdentifiers != null && sdkIdentifiers.getDeviceId() != null) {
            deviceId = this.c.getDeviceId();
        }
        return deviceId;
    }

    public String getDeviceRootStatus() {
        return ConstantDeviceInfo.DEVICE_ROOT_STATUS;
    }

    public String getDeviceType() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment != null ? sdkEnvironment.getDeviceType() : "phone";
    }

    public String getLocale() {
        String str;
        SdkEnvironment sdkEnvironment = this.b;
        return (sdkEnvironment == null || (str = (String) CollectionUtils.getFirstOrNull(sdkEnvironment.getLocales())) == null) ? "" : str;
    }

    public String getManufacturer() {
        return (String) WrapUtils.getOrDefault(ConstantDeviceInfo.MANUFACTURER, "");
    }

    public String getModel() {
        return ConstantDeviceInfo.MODEL;
    }

    public int getOsApiLevel() {
        return ConstantDeviceInfo.OS_API_LEVEL;
    }

    public String getOsVersion() {
        return ConstantDeviceInfo.OS_VERSION;
    }

    public String getPackageName() {
        return this.a;
    }

    public String getProtocolVersion() {
        return "2";
    }

    public RetryPolicyConfig getRetryPolicyConfig() {
        return this.f;
    }

    public float getScaleFactor() {
        SdkEnvironment sdkEnvironment = this.b;
        if (sdkEnvironment == null) {
            return 0.0f;
        }
        return sdkEnvironment.getScreenInfo().getScaleFactor();
    }

    public int getScreenDpi() {
        SdkEnvironment sdkEnvironment = this.b;
        if (sdkEnvironment == null) {
            return 0;
        }
        return sdkEnvironment.getScreenInfo().getDpi();
    }

    public int getScreenHeight() {
        SdkEnvironment sdkEnvironment = this.b;
        if (sdkEnvironment == null) {
            return 0;
        }
        return sdkEnvironment.getScreenInfo().getHeight();
    }

    public int getScreenWidth() {
        SdkEnvironment sdkEnvironment = this.b;
        if (sdkEnvironment == null) {
            return 0;
        }
        return sdkEnvironment.getScreenInfo().getWidth();
    }

    public synchronized String getUuid() {
        String uuid;
        uuid = "";
        SdkIdentifiers sdkIdentifiers = this.c;
        if (sdkIdentifiers != null && sdkIdentifiers.getUuid() != null) {
            uuid = this.c.getUuid();
        }
        return uuid;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isIdentifiersValid() {
        /*
            r2 = this;
            monitor-enter(r2)
            io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers r0 = r2.c     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L30
            java.lang.String r1 = r0.getUuid()     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L30
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L12
            goto L30
        L12:
            java.lang.String r1 = r0.getDeviceId()     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L30
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L1f
            goto L30
        L1f:
            java.lang.String r0 = r0.getDeviceIdHash()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L30
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L2e
            if (r0 != 0) goto L2c
            goto L30
        L2c:
            r0 = 1
            goto L31
        L2e:
            r0 = move-exception
            goto L33
        L30:
            r0 = 0
        L31:
            monitor-exit(r2)
            return r0
        L33:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.isIdentifiersValid():boolean");
    }

    protected void setAdvertisingIdsHolder(AdvertisingIdsHolder advertisingIdsHolder) {
        this.d = advertisingIdsHolder;
    }

    protected void setAppSetId(AppSetId appSetId) {
        this.e = appSetId;
    }

    protected void setPackageName(String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRetryPolicyConfig(RetryPolicyConfig retryPolicyConfig) {
        this.f = retryPolicyConfig;
    }

    protected void setSdkEnvironment(SdkEnvironment sdkEnvironment) {
        this.b = sdkEnvironment;
    }

    protected void setSdkIdentifiers(SdkIdentifiers sdkIdentifiers) {
        this.c = sdkIdentifiers;
    }

    public String toString() {
        return "BaseRequestConfig{mPackageName='" + this.a + "', sdkEnvironment=" + this.b + ", mProtocolVersion='2', sdkIdentifiers=" + this.c + ", retryPolicyConfig=" + this.f + '}';
    }
}
