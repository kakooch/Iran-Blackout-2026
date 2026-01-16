package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.o2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2745o2 {
    public static void a(C2475cl c2475cl, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObjectOptJSONObject != null) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("deeplink_conditions");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    String strOptString = jSONObjectOptJSONObject2.optString("key", null);
                    if (!TextUtils.isEmpty(strOptString)) {
                        String strOptString2 = jSONObjectOptJSONObject2.optString("value", null);
                        arrayList.add(new Pair(strOptString, strOptString2 != null ? new C2673l2(strOptString2) : null));
                    }
                }
            }
            c2475cl.t = new C2697m2(arrayList);
        }
    }
}
