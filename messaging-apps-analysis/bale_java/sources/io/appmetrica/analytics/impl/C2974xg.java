package io.appmetrica.analytics.impl;

import android.location.Location;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.xg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2974xg extends BaseRequestConfig.BaseRequestArguments {
    public final String a;
    public final Location b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final int f;
    public final int g;
    public final boolean h;
    public final boolean i;
    public final Map<String, String> j;
    public final int k;

    public C2974xg(C3010z4 c3010z4) {
        this(c3010z4.a, c3010z4.b, c3010z4.c, c3010z4.d, c3010z4.e, c3010z4.f, c3010z4.g, c3010z4.h, c3010z4.i, c3010z4.j, c3010z4.k);
    }

    public static C2974xg a() {
        return new C2974xg(null, null, null, null, null, null, null, null, null, null, null);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C2974xg mergeFrom(C3010z4 c3010z4) {
        return new C2974xg((String) WrapUtils.getOrDefaultNullable(c3010z4.a, this.a), (Boolean) WrapUtils.getOrDefaultNullable(c3010z4.b, Boolean.valueOf(this.c)), (Location) WrapUtils.getOrDefaultNullable(c3010z4.c, this.b), (Boolean) WrapUtils.getOrDefaultNullable(c3010z4.d, Boolean.valueOf(this.d)), (Integer) WrapUtils.getOrDefaultNullable(c3010z4.e, Integer.valueOf(this.e)), (Integer) WrapUtils.getOrDefaultNullable(c3010z4.f, Integer.valueOf(this.f)), (Integer) WrapUtils.getOrDefaultNullable(c3010z4.g, Integer.valueOf(this.g)), (Boolean) WrapUtils.getOrDefaultNullable(c3010z4.h, Boolean.valueOf(this.h)), (Boolean) WrapUtils.getOrDefaultNullable(c3010z4.i, Boolean.valueOf(this.i)), (Map) WrapUtils.getOrDefaultNullable(c3010z4.j, this.j), (Integer) WrapUtils.getOrDefaultNullable(c3010z4.k, Integer.valueOf(this.k)));
    }

    public C2974xg(String str, Boolean bool, Location location, Boolean bool2, Integer num, Integer num2, Integer num3, Boolean bool3, Boolean bool4, Map map, Integer num4) {
        this.a = str;
        Boolean bool5 = Boolean.FALSE;
        this.c = ((Boolean) WrapUtils.getOrDefault(bool, bool5)).booleanValue();
        this.b = location;
        this.d = ((Boolean) WrapUtils.getOrDefault(bool2, bool5)).booleanValue();
        this.e = Math.max(10, ((Integer) WrapUtils.getOrDefault(num, 10)).intValue());
        this.f = ((Integer) WrapUtils.getOrDefault(num2, 7)).intValue();
        this.g = ((Integer) WrapUtils.getOrDefault(num3, 90)).intValue();
        this.h = ((Boolean) WrapUtils.getOrDefault(bool3, bool5)).booleanValue();
        this.i = ((Boolean) WrapUtils.getOrDefault(bool4, Boolean.TRUE)).booleanValue();
        this.j = map;
        this.k = ((Integer) WrapUtils.getOrDefault(num4, Integer.valueOf(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT))).intValue();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ArgumentsMerger
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final boolean compareWithOtherArguments(C3010z4 c3010z4) {
        Location location;
        Map<String, String> map;
        String str;
        Boolean bool = c3010z4.b;
        if (bool != null && this.c != bool.booleanValue()) {
            return false;
        }
        Boolean bool2 = c3010z4.d;
        if (bool2 != null && this.d != bool2.booleanValue()) {
            return false;
        }
        Integer num = c3010z4.e;
        if (num != null && this.e != num.intValue()) {
            return false;
        }
        Integer num2 = c3010z4.f;
        if (num2 != null && this.f != num2.intValue()) {
            return false;
        }
        Integer num3 = c3010z4.g;
        if (num3 != null && this.g != num3.intValue()) {
            return false;
        }
        Boolean bool3 = c3010z4.h;
        if (bool3 != null && this.h != bool3.booleanValue()) {
            return false;
        }
        Boolean bool4 = c3010z4.i;
        if (bool4 != null && this.i != bool4.booleanValue()) {
            return false;
        }
        String str2 = c3010z4.a;
        if (str2 != null && ((str = this.a) == null || !str.equals(str2))) {
            return false;
        }
        Map<String, String> map2 = c3010z4.j;
        if (map2 != null && ((map = this.j) == null || !map.equals(map2))) {
            return false;
        }
        Integer num4 = c3010z4.k;
        if (num4 != null && this.k != num4.intValue()) {
            return false;
        }
        Location location2 = c3010z4.c;
        if (location2 != null && (location = this.b) != location2) {
            if (location == null || location.getTime() != location2.getTime() || location.getElapsedRealtimeNanos() != location2.getElapsedRealtimeNanos() || Double.compare(location2.getLatitude(), location.getLatitude()) != 0 || Double.compare(location2.getLongitude(), location.getLongitude()) != 0 || Double.compare(location2.getAltitude(), location.getAltitude()) != 0 || Float.compare(location2.getSpeed(), location.getSpeed()) != 0 || Float.compare(location2.getBearing(), location.getBearing()) != 0 || Float.compare(location2.getAccuracy(), location.getAccuracy()) != 0) {
                return false;
            }
            if (AndroidUtils.isApiAchieved(26) && (Float.compare(location2.getVerticalAccuracyMeters(), location.getVerticalAccuracyMeters()) != 0 || Float.compare(location2.getSpeedAccuracyMetersPerSecond(), location.getSpeedAccuracyMetersPerSecond()) != 0 || Float.compare(location2.getBearingAccuracyDegrees(), location.getBearingAccuracyDegrees()) != 0)) {
                return false;
            }
            if (location.getProvider() != null) {
                if (!location.getProvider().equals(location2.getProvider())) {
                    return false;
                }
            } else if (location2.getProvider() != null) {
                return false;
            }
            if (location.getExtras() != null) {
                if (!location.getExtras().equals(location2.getExtras())) {
                    return false;
                }
            } else if (location2.getExtras() != null) {
                return false;
            }
        }
        return true;
    }
}
