package com.google.android.exoplayer2.drm;

import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC9683aN7;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
abstract class a {
    public static byte[] a(byte[] bArr) {
        return AbstractC9683aN7.a >= 27 ? bArr : AbstractC9683aN7.m0(c(AbstractC9683aN7.B(bArr)));
    }

    public static byte[] b(byte[] bArr) throws JSONException {
        if (AbstractC9683aN7.a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(AbstractC9683aN7.B(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return AbstractC9683aN7.m0(sb.toString());
        } catch (JSONException e) {
            AbstractC18815pI3.d("ClearKeyUtil", "Failed to adjust response data: " + AbstractC9683aN7.B(bArr), e);
            return bArr;
        }
    }

    private static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
