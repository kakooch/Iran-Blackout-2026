package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/* renamed from: io.appmetrica.analytics.impl.p9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2776p9 {
    public static final Set a;
    public static final EnumSet b;
    public static final EnumSet c;
    public static final EnumSet d;
    public static final List e;
    public static final EnumSet f;
    public static final EnumSet g;
    public static final EnumSet h;
    public static final List i;
    public static final List j;

    static {
        Ta ta = Ta.EVENT_TYPE_EXCEPTION_USER_PROTOBUF;
        Ta ta2 = Ta.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF;
        Ta ta3 = Ta.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF;
        Ta ta4 = Ta.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE;
        Ta ta5 = Ta.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT;
        a = CollectionUtils.unmodifiableSetOf(5892, 5896, 5891, 5889, 5890, 5968);
        Ta ta6 = Ta.EVENT_TYPE_UNDEFINED;
        Ta ta7 = Ta.EVENT_TYPE_PURGE_BUFFER;
        Ta ta8 = Ta.EVENT_TYPE_SEND_REFERRER;
        Ta ta9 = Ta.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        Ta ta10 = Ta.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        Ta ta11 = Ta.EVENT_TYPE_ACTIVATION;
        Ta ta12 = Ta.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF;
        Ta ta13 = Ta.EVENT_TYPE_SET_SESSION_EXTRA;
        b = EnumSet.of(ta6, ta7, ta8, ta9, ta10, ta11, ta12, ta13);
        c = EnumSet.of(Ta.EVENT_TYPE_UPDATE_FOREGROUND_TIME, ta4);
        Ta ta14 = Ta.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF;
        Ta ta15 = Ta.EVENT_TYPE_REGULAR;
        d = EnumSet.of(ta4, ta5, ta3, ta, ta2, ta14, ta12, ta15, Ta.EVENT_CLIENT_EXTERNAL_ATTRIBUTION);
        e = Arrays.asList(3, 6, 4);
        f = EnumSet.of(ta15);
        g = EnumSet.of(ta12);
        h = EnumSet.of(Ta.EVENT_TYPE_ALIVE, ta7, ta13);
        i = Arrays.asList(0, 6145, 4097, 8224);
        j = Arrays.asList(12290);
    }
}
