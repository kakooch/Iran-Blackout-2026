package com.google.ads.interactivemedia.v3.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aon {
    public final String deviceId;
    public final String idType;
    public final boolean isLimitedAdTracking;

    public aon(Context context) {
        String str = BuildConfig.FLAVOR;
        AdvertisingIdClient.Info info = new AdvertisingIdClient.Info(BuildConfig.FLAVOR, false);
        try {
            try {
                info = getInfoFromPlayServices(context);
                str = "adid";
            } catch (Settings.SettingNotFoundException unused) {
                Log.w("IMASDK", "Failed to get advertising ID.");
            }
        } catch (Exception unused2) {
            info = getInfoFromContentResolver(context);
            str = "afai";
        }
        this.idType = str;
        this.deviceId = info.getId();
        this.isLimitedAdTracking = info.isLimitAdTrackingEnabled();
    }

    protected AdvertisingIdClient.Info getInfoFromContentResolver(Context context) throws Settings.SettingNotFoundException {
        ContentResolver contentResolver = context.getContentResolver();
        return new AdvertisingIdClient.Info(Settings.Secure.getString(contentResolver, "advertising_id"), Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 1);
    }

    protected AdvertisingIdClient.Info getInfoFromPlayServices(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, IOException {
        return AdvertisingIdClient.getAdvertisingIdInfo(context);
    }
}
