package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto$ThickContent;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class TestDeviceHelper {
    private int fetchCount = 0;
    private boolean isFreshInstall = readFreshInstallStatusFromPreferences();
    private boolean isTestDevice = readTestDeviceStatusFromPreferences();
    private final SharedPreferencesUtils sharedPreferencesUtils;

    public TestDeviceHelper(SharedPreferencesUtils sharedPreferencesUtils) {
        this.sharedPreferencesUtils = sharedPreferencesUtils;
    }

    public boolean isDeviceInTestMode() {
        return this.isTestDevice;
    }

    public boolean isAppInstallFresh() {
        return this.isFreshInstall;
    }

    public void processCampaignFetch(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        if (this.isTestDevice) {
            return;
        }
        updateFreshInstallStatus();
        Iterator<CampaignProto$ThickContent> it = fetchEligibleCampaignsResponse.getMessagesList().iterator();
        while (it.hasNext()) {
            if (it.next().getIsTestCampaign()) {
                setTestDeviceStatus(true);
                Logging.logi("Setting this device as a test device");
                return;
            }
        }
    }

    private void updateFreshInstallStatus() {
        if (this.isFreshInstall) {
            int i = this.fetchCount + 1;
            this.fetchCount = i;
            if (i >= 5) {
                setFreshInstallStatus(false);
            }
        }
    }

    private void setTestDeviceStatus(boolean z) {
        this.isTestDevice = z;
        this.sharedPreferencesUtils.setBooleanPreference("test_device", z);
    }

    private void setFreshInstallStatus(boolean z) {
        this.isFreshInstall = z;
        this.sharedPreferencesUtils.setBooleanPreference("fresh_install", z);
    }

    private boolean readTestDeviceStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference("test_device", false);
    }

    private boolean readFreshInstallStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference("fresh_install", true);
    }
}
