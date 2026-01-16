package io.appmetrica.analytics.impl;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: io.appmetrica.analytics.impl.vd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2923vd {
    public static final C2895u9 a(C2923vd c2923vd, D9 d9) {
        int i;
        c2923vd.getClass();
        C2895u9 c2895u9 = new C2895u9();
        switch (d9) {
            case UNKNOWN:
                i = 0;
                break;
            case APPSFLYER:
                i = 1;
                break;
            case ADJUST:
                i = 2;
                break;
            case KOCHAVA:
                i = 3;
                break;
            case TENJIN:
                i = 4;
                break;
            case AIRBRIDGE:
                i = 5;
                break;
            case SINGULAR:
                i = 6;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        c2895u9.a = i;
        return c2895u9;
    }
}
