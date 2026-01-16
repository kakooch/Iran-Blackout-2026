package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.oe, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2757oe implements ProtobufConverter {
    public final De a;

    public C2757oe() {
        this(new De());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Ae fromModel(C2805qe c2805qe) {
        Ae ae = new Ae();
        if (!TextUtils.isEmpty(c2805qe.a)) {
            ae.a = c2805qe.a;
        }
        ae.b = c2805qe.b.toString();
        ae.c = this.a.fromModel(c2805qe.c).intValue();
        return ae;
    }

    public C2757oe(De de) {
        this.a = de;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2805qe toModel(Ae ae) {
        JSONObject jSONObject;
        String str = ae.a;
        String str2 = ae.b;
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable unused) {
            }
        } else {
            jSONObject = new JSONObject();
        }
        return new C2805qe(str, jSONObject, this.a.toModel(Integer.valueOf(ae.c)));
    }
}
