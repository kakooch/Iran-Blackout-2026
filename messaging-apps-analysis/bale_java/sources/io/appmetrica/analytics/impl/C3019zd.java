package io.appmetrica.analytics.impl;

import ir.nasim.C12275eL0;
import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.zd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3019zd {
    public static final C2895u9 a(C3019zd c3019zd, D9 d9, Object obj) throws SecurityException {
        int i;
        c3019zd.getClass();
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
        Ad.b.getClass();
        JSONObject jSONObject = new JSONObject();
        for (Field field : obj.getClass().getFields()) {
            try {
                jSONObject.put(field.getName(), field.get(obj));
            } catch (Throwable unused) {
            }
        }
        c2895u9.b = jSONObject.toString().getBytes(C12275eL0.b);
        return c2895u9;
    }
}
