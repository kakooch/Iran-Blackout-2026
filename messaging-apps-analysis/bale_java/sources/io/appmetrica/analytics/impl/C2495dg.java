package io.appmetrica.analytics.impl;

import android.gov.nist.core.Separators;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.dg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2495dg extends AbstractC2568gg {
    public C2495dg(C2484d5 c2484d5) {
        super(c2484d5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        String value = q5.getValue();
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(value);
            if (!"open".equals(jSONObject.optString("type"))) {
                return false;
            }
            tn tnVar = this.a.v;
            synchronized (tnVar) {
                tnVar.c(tnVar.b() + 1);
            }
            if (!a(jSONObject.optString("link"))) {
                return false;
            }
            q5.n = Boolean.TRUE;
            b();
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void b() {
        tn tnVar = this.a.v;
        synchronized (tnVar) {
            tnVar.a(tnVar.a() + 1);
        }
        this.a.z();
        F8 f8 = this.a.m;
        if (f8.c == null) {
            f8.a();
        }
        H8 h8 = f8.c;
        h8.getClass();
        h8.b = new HashSet();
        h8.d = 0;
        H8 h82 = f8.c;
        h82.a = true;
        K8 k8 = f8.b;
        IBinaryDataHelper iBinaryDataHelper = k8.c;
        J8 j8 = k8.b;
        k8.a.getClass();
        C2728n9 c2728n9A = I8.a(h82);
        j8.getClass();
        iBinaryDataHelper.insert("event_hashes", MessageNano.toByteArray(c2728n9A));
    }

    public final boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String queryParameter = Uri.parse(str).getQueryParameter("referrer");
                if (!TextUtils.isEmpty(queryParameter)) {
                    C2697m2 c2697m2 = this.a.t().z;
                    for (String str2 : queryParameter.split(Separators.AND)) {
                        int iIndexOf = str2.indexOf(Separators.EQUALS);
                        if (iIndexOf >= 0 && a(Uri.decode(str2.substring(0, iIndexOf)), Uri.decode(str2.substring(iIndexOf + 1)), c2697m2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(String str, String str2, C2697m2 c2697m2) {
        Object obj;
        if ("reattribution".equals(str) && "1".equals(str2)) {
            return true;
        }
        if (c2697m2 == null) {
            return false;
        }
        for (Pair pair : c2697m2.a) {
            if (hn.a(pair.first, str) && ((obj = pair.second) == null || ((C2673l2) obj).a.equals(str2))) {
                return true;
            }
        }
        return false;
    }
}
