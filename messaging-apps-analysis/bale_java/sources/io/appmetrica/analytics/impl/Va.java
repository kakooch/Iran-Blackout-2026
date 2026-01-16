package io.appmetrica.analytics.impl;

import ir.nasim.C12275eL0;
import kotlin.NoWhenBranchMatchedException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Va {
    public static final C2895u9 a(Va va, D9 d9, JSONObject jSONObject) {
        int i;
        va.getClass();
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
        c2895u9.b = jSONObject.toString().getBytes(C12275eL0.b);
        return c2895u9;
    }
}
