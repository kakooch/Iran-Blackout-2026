package io.appmetrica.analytics.impl;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Qk implements NetworkResponseHandler {
    public final Xk a;
    public final C2698m3 b;

    public Qk() {
        this(new Xk(), new C2698m3());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.NetworkResponseHandler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2475cl handle(ResponseDataHolder responseDataHolder) {
        String strOptString;
        String strOptString2;
        if (200 == responseDataHolder.getResponseCode()) {
            byte[] responseData = responseDataHolder.getResponseData();
            Map<String, List<String>> responseHeaders = responseDataHolder.getResponseHeaders();
            List list = responseHeaders != null ? (List) CollectionUtils.getFromMapIgnoreCase(responseHeaders, SIPHeaderNames.CONTENT_ENCODING) : null;
            if (!hn.a((Collection) list) && "encrypted".equals(list.get(0))) {
                responseData = this.b.a(responseDataHolder.getResponseData());
            }
            if (responseData != null) {
                Xk xk = this.a;
                xk.getClass();
                C2475cl c2475cl = new C2475cl();
                try {
                    xk.i.getClass();
                    Xa xa = new Xa(new String(responseData, "UTF-8"));
                    JSONObject jSONObjectOptJSONObject = xa.optJSONObject("device_id");
                    if (jSONObjectOptJSONObject != null) {
                        strOptString = jSONObjectOptJSONObject.optString("hash");
                        strOptString2 = jSONObjectOptJSONObject.optString("value");
                    } else {
                        strOptString = "";
                        strOptString2 = "";
                    }
                    c2475cl.h = strOptString2;
                    c2475cl.i = strOptString;
                    xk.a(c2475cl, xa);
                    c2475cl.a = 2;
                } catch (Throwable unused) {
                    c2475cl = new C2475cl();
                    c2475cl.a = 1;
                }
                if (2 == c2475cl.a) {
                    return c2475cl;
                }
            }
        }
        return null;
    }

    public Qk(Xk xk, C2698m3 c2698m3) {
        this.a = xk;
        this.b = c2698m3;
    }
}
