package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class qn implements pn {
    public final C2942w8 a;

    public qn() {
        this(new C2942w8());
    }

    @Override // io.appmetrica.analytics.impl.pn
    public final byte[] a(G8 g8, Cg cg) {
        if (!((C2484d5) cg.m).B() && !TextUtils.isEmpty(g8.b)) {
            try {
                JSONObject jSONObject = new JSONObject(g8.b);
                jSONObject.remove("preloadInfo");
                g8.b = jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return this.a.a(g8, cg);
    }

    public qn(C2942w8 c2942w8) {
        this.a = c2942w8;
    }
}
