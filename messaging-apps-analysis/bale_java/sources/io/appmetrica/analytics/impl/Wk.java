package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.appmetrica.analytics.networktasks.internal.IParamsAppender;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Wk implements IParamsAppender {
    public final C2995yd a;
    public final Pc b;

    public Wk(C2995yd c2995yd, Pc pc) {
        this.a = c2995yd;
        this.b = pc;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void appendParams(Uri.Builder builder, C2425al c2425al) {
        Cf cf;
        builder.path("analytics/startup");
        builder.appendQueryParameter(this.a.a(CommonUrlParts.DEVICE_ID), c2425al.getDeviceId());
        a(builder, C2586ha.C.f(), c2425al);
        builder.appendQueryParameter(this.a.a(CommonUrlParts.APP_SET_ID), c2425al.getAppSetId());
        builder.appendQueryParameter(this.a.a(CommonUrlParts.APP_SET_ID_SCOPE), c2425al.getAppSetIdScope());
        builder.appendQueryParameter(this.a.a(CommonUrlParts.APP_PLATFORM), c2425al.getAppPlatform());
        builder.appendQueryParameter(this.a.a(CommonUrlParts.PROTOCOL_VERSION), c2425al.getProtocolVersion());
        builder.appendQueryParameter(this.a.a(CommonUrlParts.ANALYTICS_SDK_VERSION_NAME), c2425al.getAnalyticsSdkVersionName());
        builder.appendQueryParameter(this.a.a(CommonUrlParts.MODEL), c2425al.getModel());
        builder.appendQueryParameter(this.a.a(CommonUrlParts.MANUFACTURER), c2425al.getManufacturer());
        builder.appendQueryParameter(this.a.a(CommonUrlParts.OS_VERSION), c2425al.getOsVersion());
        builder.appendQueryParameter(this.a.a(CommonUrlParts.SCREEN_WIDTH), String.valueOf(c2425al.getScreenWidth()));
        builder.appendQueryParameter(this.a.a(CommonUrlParts.SCREEN_HEIGHT), String.valueOf(c2425al.getScreenHeight()));
        builder.appendQueryParameter(this.a.a(CommonUrlParts.SCREEN_DPI), String.valueOf(c2425al.getScreenDpi()));
        builder.appendQueryParameter(this.a.a(CommonUrlParts.SCALE_FACTOR), String.valueOf(c2425al.getScaleFactor()));
        builder.appendQueryParameter(this.a.a(CommonUrlParts.LOCALE), c2425al.getLocale());
        builder.appendQueryParameter(this.a.a(CommonUrlParts.DEVICE_TYPE), c2425al.getDeviceType());
        builder.appendQueryParameter(this.a.a("queries"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("query_hosts"), String.valueOf(2));
        String strA = this.a.a("features");
        List<String> listG = ((C3001yj) this.b).g();
        String[] strArr = {this.a.a("permissions_collecting"), this.a.a("features_collecting"), this.a.a("google_aid"), this.a.a("huawei_oaid"), this.a.a("sim_info"), this.a.a("ssl_pinning")};
        ArrayList arrayList = new ArrayList(listG);
        arrayList.addAll(Arrays.asList(strArr));
        builder.appendQueryParameter(strA, StringUtils.wrapFeatures((String[]) arrayList.toArray(new String[0])));
        builder.appendQueryParameter(this.a.a(CommonUrlParts.APP_ID), c2425al.getPackageName());
        builder.appendQueryParameter(this.a.a("app_debuggable"), ((O5) c2425al).a);
        if (c2425al.l) {
            String str = c2425al.m;
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter(this.a.a("country_init"), str);
            }
        } else {
            builder.appendQueryParameter(this.a.a("detect_locale"), String.valueOf(1));
        }
        I3 i3 = c2425al.i;
        if (!hn.a(i3.a)) {
            builder.appendQueryParameter(this.a.a("distribution_customization"), String.valueOf(1));
            builder.appendQueryParameter(this.a.a("clids_set"), Gl.a(i3.a));
            int iOrdinal = i3.b.ordinal();
            builder.appendQueryParameter(this.a.a("clids_set_source"), iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? "" : "retail" : "satellite" : "api");
            String str2 = c2425al.f;
            String str3 = c2425al.g;
            if (TextUtils.isEmpty(str2) && (cf = c2425al.o.b) != null) {
                str2 = cf.a;
                str3 = cf.d.a;
            }
            if (!TextUtils.isEmpty(str2)) {
                builder.appendQueryParameter(this.a.a("install_referrer"), str2);
                if (str3 == null) {
                    str3 = "null";
                }
                builder.appendQueryParameter(this.a.a("install_referrer_source"), str3);
            }
        }
        String uuid = c2425al.getUuid();
        if (!TextUtils.isEmpty(uuid)) {
            builder.appendQueryParameter(this.a.a(CommonUrlParts.UUID), uuid);
        }
        builder.appendQueryParameter(this.a.a("time"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("stat_sending"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("retry_policy"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("cache_control"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("permissions_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("app_system_flag"), ((O5) c2425al).b);
        builder.appendQueryParameter(this.a.a("auto_inapp_collecting"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("attribution"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("startup_update"), String.valueOf(1));
        builder.appendQueryParameter(this.a.a("external_attribution"), String.valueOf(1));
        Map<String, Integer> mapC = ((C3001yj) this.b).c();
        for (String str4 : mapC.keySet()) {
            builder.appendQueryParameter(str4, String.valueOf(mapC.get(str4)));
        }
    }

    public final void a(Uri.Builder builder, DataSendingRestrictionController dataSendingRestrictionController, C2425al c2425al) {
        AdvertisingIdsHolder advertisingIdsHolder = c2425al.getAdvertisingIdsHolder();
        if (advertisingIdsHolder != null && !dataSendingRestrictionController.isRestrictedForReporter()) {
            AdTrackingInfoResult google = advertisingIdsHolder.getGoogle();
            if (!google.isValid()) {
                builder.appendQueryParameter(this.a.a(CommonUrlParts.ADV_ID), "");
            } else {
                builder.appendQueryParameter(this.a.a(CommonUrlParts.ADV_ID), google.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult huawei = advertisingIdsHolder.getHuawei();
            if (!huawei.isValid()) {
                builder.appendQueryParameter(this.a.a(CommonUrlParts.HUAWEI_OAID), "");
            } else {
                builder.appendQueryParameter(this.a.a(CommonUrlParts.HUAWEI_OAID), huawei.mAdTrackingInfo.advId);
            }
            AdTrackingInfoResult yandex = advertisingIdsHolder.getYandex();
            if (!yandex.isValid()) {
                builder.appendQueryParameter(this.a.a(CommonUrlParts.YANDEX_ADV_ID), "");
                return;
            } else {
                builder.appendQueryParameter(this.a.a(CommonUrlParts.YANDEX_ADV_ID), yandex.mAdTrackingInfo.advId);
                return;
            }
        }
        builder.appendQueryParameter(this.a.a(CommonUrlParts.ADV_ID), "");
        builder.appendQueryParameter(this.a.a(CommonUrlParts.HUAWEI_OAID), "");
        builder.appendQueryParameter(this.a.a(CommonUrlParts.YANDEX_ADV_ID), "");
    }
}
