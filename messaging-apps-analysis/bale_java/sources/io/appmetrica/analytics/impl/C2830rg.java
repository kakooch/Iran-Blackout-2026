package io.appmetrica.analytics.impl;

import android.net.Uri;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.AdvIdWithLimitedAppender;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.appmetrica.analytics.networktasks.internal.IParamsAppender;
import io.appmetrica.analytics.networktasks.internal.NetworkTaskForSendingDataParamsAppender;
import io.appmetrica.analytics.networktasks.internal.RequestBodyEncrypter;

/* renamed from: io.appmetrica.analytics.impl.rg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2830rg implements IParamsAppender {
    public final AdvIdWithLimitedAppender a;
    public final NetworkTaskForSendingDataParamsAppender b;
    public C2630j7 c;
    public long d;

    public C2830rg(RequestBodyEncrypter requestBodyEncrypter) {
        this(new AdvIdWithLimitedAppender(), new NetworkTaskForSendingDataParamsAppender(requestBodyEncrypter));
    }

    public final void a(C2630j7 c2630j7) {
        this.c = c2630j7;
    }

    public C2830rg(AdvIdWithLimitedAppender advIdWithLimitedAppender, NetworkTaskForSendingDataParamsAppender networkTaskForSendingDataParamsAppender) {
        this.a = advIdWithLimitedAppender;
        this.b = networkTaskForSendingDataParamsAppender;
    }

    public final void a(long j) {
        this.d = j;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.IParamsAppender
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void appendParams(Uri.Builder builder, Cg cg) {
        builder.path("report");
        this.b.appendEncryptedData(builder);
        C2630j7 c2630j7 = this.c;
        if (c2630j7 != null) {
            builder.appendQueryParameter(CommonUrlParts.DEVICE_ID, StringUtils.ifIsEmptyToDef(c2630j7.a, cg.getDeviceId()));
            builder.appendQueryParameter(CommonUrlParts.UUID, StringUtils.ifIsEmptyToDef(this.c.b, cg.getUuid()));
            a(builder, CommonUrlParts.ANALYTICS_SDK_VERSION_NAME, this.c.c);
            builder.appendQueryParameter(CommonUrlParts.APP_VERSION, StringUtils.ifIsEmptyToDef(this.c.f, cg.getAppVersion()));
            builder.appendQueryParameter(CommonUrlParts.APP_VERSION_CODE, StringUtils.ifIsEmptyToDef(this.c.h, cg.getAppBuildNumber()));
            builder.appendQueryParameter(CommonUrlParts.OS_VERSION, StringUtils.ifIsEmptyToDef(this.c.i, cg.getOsVersion()));
            a(builder, CommonUrlParts.OS_API_LEVEL, this.c.j);
            a(builder, CommonUrlParts.ANALYTICS_SDK_BUILD_NUMBER, this.c.d);
            a(builder, CommonUrlParts.ANALYTICS_SDK_BUILD_TYPE, this.c.e);
            a(builder, "app_debuggable", this.c.g);
            builder.appendQueryParameter(CommonUrlParts.LOCALE, StringUtils.ifIsEmptyToDef(this.c.k, cg.getLocale()));
            builder.appendQueryParameter(CommonUrlParts.ROOT_STATUS, StringUtils.ifIsEmptyToDef(this.c.l, cg.getDeviceRootStatus()));
            builder.appendQueryParameter(CommonUrlParts.APP_FRAMEWORK, StringUtils.ifIsEmptyToDef(this.c.m, cg.getAppFramework()));
            a(builder, "attribution_id", this.c.n);
        }
        builder.appendQueryParameter("api_key_128", cg.n);
        builder.appendQueryParameter(CommonUrlParts.APP_ID, cg.getPackageName());
        builder.appendQueryParameter(CommonUrlParts.APP_PLATFORM, cg.getAppPlatform());
        builder.appendQueryParameter(CommonUrlParts.MODEL, cg.getModel());
        builder.appendQueryParameter(CommonUrlParts.MANUFACTURER, cg.getManufacturer());
        builder.appendQueryParameter(CommonUrlParts.SCREEN_WIDTH, String.valueOf(cg.getScreenWidth()));
        builder.appendQueryParameter(CommonUrlParts.SCREEN_HEIGHT, String.valueOf(cg.getScreenHeight()));
        builder.appendQueryParameter(CommonUrlParts.SCREEN_DPI, String.valueOf(cg.getScreenDpi()));
        builder.appendQueryParameter(CommonUrlParts.SCALE_FACTOR, String.valueOf(cg.getScaleFactor()));
        builder.appendQueryParameter(CommonUrlParts.DEVICE_TYPE, cg.getDeviceType());
        a(builder, "clids_set", (String) WrapUtils.getOrDefault(cg.q, ""));
        builder.appendQueryParameter(CommonUrlParts.APP_SET_ID, cg.getAppSetId());
        builder.appendQueryParameter(CommonUrlParts.APP_SET_ID_SCOPE, cg.getAppSetIdScope());
        this.a.appendParams(builder, cg.getAdvertisingIdsHolder());
        builder.appendQueryParameter(CommonUrlParts.REQUEST_ID, String.valueOf(this.d));
    }

    public static void a(Uri.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }
}
