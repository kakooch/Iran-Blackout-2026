package io.appmetrica.analytics.impl;

import android.util.SparseArray;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.bf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2444bf {
    public static final Map a;
    public static final SparseArray b;
    public static final Map c;
    public static final Map d;

    static {
        HashMap map = new HashMap();
        Wj wj = Wj.FOREGROUND;
        map.put(wj, 0);
        Wj wj2 = Wj.BACKGROUND;
        map.put(wj2, 1);
        a = Collections.unmodifiableMap(map);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, wj);
        sparseArray.put(1, wj2);
        b = sparseArray;
        HashMap map2 = new HashMap();
        Ta ta = Ta.EVENT_TYPE_INIT;
        map2.put(ta, 1);
        Ta ta2 = Ta.EVENT_TYPE_REGULAR;
        map2.put(ta2, 4);
        Ta ta3 = Ta.EVENT_TYPE_SEND_REFERRER;
        map2.put(ta3, 5);
        Ta ta4 = Ta.EVENT_TYPE_ALIVE;
        map2.put(ta4, 7);
        Ta ta5 = Ta.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        map2.put(ta5, 26);
        Ta ta6 = Ta.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT;
        map2.put(ta6, 26);
        Ta ta7 = Ta.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        map2.put(ta7, 26);
        Ta ta8 = Ta.EVENT_TYPE_ANR;
        map2.put(ta8, 25);
        Ta ta9 = Ta.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        map2.put(ta9, 26);
        Ta ta10 = Ta.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        map2.put(ta10, 26);
        Ta ta11 = Ta.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        map2.put(ta11, 27);
        Ta ta12 = Ta.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        map2.put(ta12, 27);
        Ta ta13 = Ta.EVENT_TYPE_FIRST_ACTIVATION;
        map2.put(ta13, 13);
        Ta ta14 = Ta.EVENT_TYPE_START;
        map2.put(ta14, 2);
        Ta ta15 = Ta.EVENT_TYPE_APP_OPEN;
        map2.put(ta15, 16);
        Ta ta16 = Ta.EVENT_TYPE_APP_UPDATE;
        map2.put(ta16, 17);
        Ta ta17 = Ta.EVENT_TYPE_PERMISSIONS;
        map2.put(ta17, 18);
        Ta ta18 = Ta.EVENT_TYPE_APP_FEATURES;
        map2.put(ta18, 19);
        Ta ta19 = Ta.EVENT_TYPE_SEND_USER_PROFILE;
        map2.put(ta19, 20);
        Ta ta20 = Ta.EVENT_TYPE_SEND_REVENUE_EVENT;
        map2.put(ta20, 21);
        Ta ta21 = Ta.EVENT_TYPE_SEND_AD_REVENUE_EVENT;
        map2.put(ta21, 40);
        Ta ta22 = Ta.EVENT_TYPE_SEND_ECOMMERCE_EVENT;
        map2.put(ta22, 35);
        map2.put(Ta.EVENT_TYPE_CLEANUP, 29);
        Ta ta23 = Ta.EVENT_TYPE_WEBVIEW_SYNC;
        map2.put(ta23, 38);
        Ta ta24 = Ta.EVENT_CLIENT_EXTERNAL_ATTRIBUTION;
        map2.put(ta24, 42);
        c = Collections.unmodifiableMap(map2);
        HashMap map3 = new HashMap();
        C2799q8 c2799q8 = new C2799q8();
        C2942w8 c2942w8 = new C2942w8(new A8());
        C2822r8 c2822r8 = new C2822r8();
        C2865t3 c2865t3 = new C2865t3(new A8());
        Lm lm = new Lm(new A8());
        Xe xe = new Xe();
        O8 o8A = P8.a();
        o8A.b = xe;
        o8A.c = xe;
        P8 p8 = new P8(o8A);
        O8 o8A2 = P8.a();
        o8A2.b = c2942w8;
        P8 p82 = new P8(o8A2);
        O8 o8A3 = P8.a();
        o8A3.b = c2865t3;
        P8 p83 = new P8(o8A3);
        O8 o8A4 = P8.a();
        o8A4.b = lm;
        P8 p84 = new P8(o8A4);
        O8 o8A5 = P8.a();
        o8A5.a = c2799q8;
        P8 p85 = new P8(o8A5);
        O8 o8A6 = P8.a();
        o8A6.b = new qn(new C2942w8());
        P8 p86 = new P8(o8A6);
        map3.put(ta2, p82);
        O8 o8A7 = P8.a();
        o8A7.b = new Ze();
        map3.put(ta3, new P8(o8A7));
        O8 o8A8 = P8.a();
        o8A8.a = c2799q8;
        o8A8.b = c2822r8;
        o8A8.e = new R7();
        o8A8.f = new S7();
        map3.put(ta4, new P8(o8A8));
        map3.put(ta9, p8);
        map3.put(ta10, p8);
        map3.put(ta11, p83);
        map3.put(ta12, p83);
        map3.put(ta5, p83);
        map3.put(ta6, p83);
        map3.put(ta7, p83);
        map3.put(ta8, p83);
        O8 o8A9 = P8.a();
        o8A9.a = new C2799q8();
        o8A9.b = c2865t3;
        map3.put(ta14, new P8(o8A9));
        Ta ta25 = Ta.EVENT_TYPE_CUSTOM_EVENT;
        O8 o8A10 = P8.a();
        o8A10.d = new C2419af();
        map3.put(ta25, new P8(o8A10));
        map3.put(ta15, p82);
        map3.put(ta17, p85);
        map3.put(ta18, p85);
        map3.put(ta19, p83);
        map3.put(ta20, p83);
        map3.put(ta21, p83);
        map3.put(ta22, p84);
        map3.put(ta, p86);
        map3.put(ta16, p86);
        map3.put(ta13, p82);
        map3.put(ta23, p82);
        map3.put(ta24, p83);
        d = Collections.unmodifiableMap(map3);
    }

    public static C2488d9 a(Long l, Long l2, Boolean bool) {
        C2488d9 c2488d9 = new C2488d9();
        if (l != null) {
            c2488d9.a = l.longValue();
            c2488d9.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(l.longValue() * 1000) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        }
        if (l2 != null) {
            c2488d9.c = l2.longValue();
        }
        if (bool != null) {
            c2488d9.d = bool.booleanValue();
        }
        return c2488d9;
    }

    public static void a(C2438b9 c2438b9) {
        Z8[] z8Arr = c2438b9.c;
        if (z8Arr != null) {
            for (Z8 z8 : z8Arr) {
            }
        }
    }
}
