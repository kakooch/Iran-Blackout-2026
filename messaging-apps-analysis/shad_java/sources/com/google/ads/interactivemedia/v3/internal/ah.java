package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.res.Resources;
import android.view.WindowManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ah {
    private static WindowManager b;
    private static final String[] c = {"x", "y", "width", "height"};
    static float a = Resources.getSystem().getDisplayMetrics().density;

    public static void a(Context context) {
        if (context != null) {
            a = context.getResources().getDisplayMetrics().density;
            b = (WindowManager) context.getSystemService("window");
        }
    }

    public static JSONObject b(int i, int i2, int i3, int i4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", c(i));
            jSONObject.put("y", c(i2));
            jSONObject.put("width", c(i3));
            jSONObject.put("height", c(i4));
        } catch (JSONException e) {
            asn.s("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    static float c(int i) {
        return i / a;
    }

    public static void d(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
            sb.append("JSONException during JSONObject.put for name [");
            sb.append(str);
            sb.append("]");
            asn.s(sb.toString(), e);
        }
    }

    public static void e(JSONObject jSONObject, String str) throws JSONException {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            asn.s("Error with setting ad session id", e);
        }
    }

    public static void f(JSONObject jSONObject, String str) throws JSONException {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            asn.s("Error with setting not visible reason", e);
        }
    }

    public static void g(JSONObject jSONObject, ai aiVar) throws JSONException {
        s sVarB = aiVar.b();
        JSONArray jSONArray = new JSONArray();
        ArrayList<String> arrayListC = aiVar.c();
        int size = arrayListC.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(arrayListC.get(i));
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", sVarB.a());
            jSONObject.put("friendlyObstructionPurpose", sVarB.b());
            jSONObject.put("friendlyObstructionReason", sVarB.c());
        } catch (JSONException e) {
            asn.s("Error with setting friendly obstruction", e);
        }
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("childViews");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
                jSONObject.put("childViews", jSONArrayOptJSONArray);
            }
            jSONArrayOptJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            auf.b(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(org.json.JSONObject r17) throws org.json.JSONException {
        /*
            r0 = r17
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "height"
            java.lang.String r3 = "width"
            r4 = 0
            r5 = 0
            r6 = 17
            if (r1 < r6) goto L2d
            android.view.WindowManager r1 = com.google.ads.interactivemedia.v3.internal.ah.b
            if (r1 == 0) goto L67
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>(r4, r4)
            android.view.WindowManager r4 = com.google.ads.interactivemedia.v3.internal.ah.b
            android.view.Display r4 = r4.getDefaultDisplay()
            r4.getRealSize(r1)
            int r4 = r1.x
            float r5 = c(r4)
            int r1 = r1.y
            float r1 = c(r1)
            goto L68
        L2d:
            java.lang.String r1 = "childViews"
            org.json.JSONArray r1 = r0.optJSONArray(r1)
            if (r1 == 0) goto L67
            int r6 = r1.length()
            r7 = 0
        L3a:
            if (r4 >= r6) goto L65
            org.json.JSONObject r8 = r1.optJSONObject(r4)
            if (r8 == 0) goto L62
            java.lang.String r9 = "x"
            double r9 = r8.optDouble(r9)
            java.lang.String r11 = "y"
            double r11 = r8.optDouble(r11)
            double r13 = r8.optDouble(r3)
            double r15 = r8.optDouble(r2)
            double r9 = r9 + r13
            float r8 = (float) r9
            float r5 = java.lang.Math.max(r5, r8)
            double r11 = r11 + r15
            float r8 = (float) r11
            float r7 = java.lang.Math.max(r7, r8)
        L62:
            int r4 = r4 + 1
            goto L3a
        L65:
            r1 = r7
            goto L68
        L67:
            r1 = 0
        L68:
            com.google.ads.interactivemedia.v3.internal.ag r4 = new com.google.ads.interactivemedia.v3.internal.ag
            r4.<init>(r5, r1)
            float r1 = r4.a     // Catch: org.json.JSONException -> L7a
            double r5 = (double) r1     // Catch: org.json.JSONException -> L7a
            r0.put(r3, r5)     // Catch: org.json.JSONException -> L7a
            float r1 = r4.b     // Catch: org.json.JSONException -> L7a
            double r3 = (double) r1     // Catch: org.json.JSONException -> L7a
            r0.put(r2, r3)     // Catch: org.json.JSONException -> L7a
            return
        L7a:
            r0 = move-exception
            com.google.ads.interactivemedia.v3.internal.auf.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ah.i(org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean j(org.json.JSONObject r9, org.json.JSONObject r10) {
        /*
            r0 = 1
            if (r9 != 0) goto L7
            if (r10 == 0) goto L6
            goto L7
        L6:
            return r0
        L7:
            r1 = 0
            if (r9 == 0) goto L94
            if (r10 != 0) goto Le
            goto L94
        Le:
            java.lang.String[] r2 = com.google.ads.interactivemedia.v3.internal.ah.c
            int r3 = r2.length
            r3 = 0
        L12:
            r4 = 4
            if (r3 >= r4) goto L28
            r4 = r2[r3]
            double r5 = r9.optDouble(r4)
            double r7 = r10.optDouble(r4)
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 == 0) goto L25
            goto L94
        L25:
            int r3 = r3 + 1
            goto L12
        L28:
            java.lang.String r2 = "adSessionId"
            java.lang.String r3 = ""
            java.lang.String r4 = r9.optString(r2, r3)
            java.lang.String r2 = r10.optString(r2, r3)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L94
            java.lang.String r2 = "isFriendlyObstructionFor"
            org.json.JSONArray r4 = r9.optJSONArray(r2)
            org.json.JSONArray r2 = r10.optJSONArray(r2)
            if (r4 != 0) goto L49
            if (r2 != 0) goto L49
            goto L67
        L49:
            boolean r5 = k(r4, r2)
            if (r5 == 0) goto L94
            r5 = 0
        L50:
            int r6 = r4.length()
            if (r5 >= r6) goto L67
            java.lang.String r6 = r4.optString(r5, r3)
            java.lang.String r7 = r2.optString(r5, r3)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L94
            int r5 = r5 + 1
            goto L50
        L67:
            java.lang.String r2 = "childViews"
            org.json.JSONArray r9 = r9.optJSONArray(r2)
            org.json.JSONArray r10 = r10.optJSONArray(r2)
            if (r9 != 0) goto L75
            if (r10 == 0) goto L93
        L75:
            boolean r2 = k(r9, r10)
            if (r2 == 0) goto L94
            r2 = 0
        L7c:
            int r3 = r9.length()
            if (r2 >= r3) goto L93
            org.json.JSONObject r3 = r9.optJSONObject(r2)
            org.json.JSONObject r4 = r10.optJSONObject(r2)
            boolean r3 = j(r3, r4)
            if (r3 == 0) goto L94
            int r2 = r2 + 1
            goto L7c
        L93:
            return r0
        L94:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ah.j(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    private static boolean k(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
