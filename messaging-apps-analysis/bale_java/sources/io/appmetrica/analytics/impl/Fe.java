package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Fe implements ProtobufConverter {
    public final De a = new De();

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C3020ze fromModel(Ee ee) {
        C3020ze c3020ze = new C3020ze();
        if (!TextUtils.isEmpty(ee.a)) {
            c3020ze.a = ee.a;
        }
        c3020ze.b = ee.b.toString();
        c3020ze.c = ee.c;
        c3020ze.d = ee.d;
        c3020ze.e = this.a.fromModel(ee.e).intValue();
        return c3020ze;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Ee toModel(C3020ze c3020ze) {
        JSONObject jSONObject;
        String str = c3020ze.a;
        String str2 = c3020ze.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
        } else {
            jSONObject = new JSONObject();
        }
        return new Ee(str, jSONObject, c3020ze.c, c3020ze.d, this.a.toModel(Integer.valueOf(c3020ze.e)));
    }
}
