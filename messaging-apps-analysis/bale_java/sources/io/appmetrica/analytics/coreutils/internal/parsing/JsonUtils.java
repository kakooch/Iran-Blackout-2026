package io.appmetrica.analytics.coreutils.internal.parsing;

import ir.nasim.AbstractC11342cq6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18386oa3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC9962aq6;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u000bH\u0007J\u001f\u0010\r\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u000f\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0007J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u001e\u0010\u0012\u001a\u00020\u0011*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0011H\u0007J)\u0010\u0013\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u0002*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\"\u0010\u0018\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0007J\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u001cH\u0007¨\u0006\u001d"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/parsing/JsonUtils;", "", "Lorg/json/JSONObject;", "", "key", "", "fallback", "optLongOrDefault", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "optLongOrNull", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "", "optFloatOrDefault", "optFloatOrNull", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Float;", "optStringOrNullable", "optStringOrNull", "", "optBooleanOrDefault", "optBooleanOrNullable", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "optBooleanOrNull", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "optJsonObjectOrDefault", "optJsonObjectOrNullable", "optJsonObjectOrNull", "value", "isEqualTo", "Lorg/json/JSONArray;", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class JsonUtils {
    public static final JsonUtils INSTANCE = new JsonUtils();

    private JsonUtils() {
    }

    public static final boolean isEqualTo(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        boolean zEquals;
        if (!AbstractC13042fc3.d(AbstractC11342cq6.M(AbstractC9962aq6.c(jSONObject.keys())), AbstractC11342cq6.M(AbstractC9962aq6.c(jSONObject2.keys())))) {
            return false;
        }
        for (String str : AbstractC9962aq6.c(jSONObject.keys())) {
            Object obj = jSONObject.get(str);
            Object obj2 = jSONObject2.get(str);
            if (obj instanceof JSONObject) {
                if (!(obj2 instanceof JSONObject)) {
                    return false;
                }
                zEquals = isEqualTo((JSONObject) obj, (JSONObject) obj2);
            } else if (!(obj instanceof JSONArray)) {
                zEquals = obj.equals(obj2);
            } else {
                if (!(obj2 instanceof JSONArray)) {
                    return false;
                }
                zEquals = isEqualTo((JSONArray) obj, (JSONArray) obj2);
            }
            if (!zEquals) {
                return false;
            }
        }
        return true;
    }

    public static final boolean optBooleanOrDefault(JSONObject jSONObject, String str, boolean z) {
        Boolean boolOptBooleanOrNull = optBooleanOrNull(jSONObject, str);
        return boolOptBooleanOrNull != null ? boolOptBooleanOrNull.booleanValue() : z;
    }

    public static final Boolean optBooleanOrNull(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Boolean optBooleanOrNullable(JSONObject jSONObject, String str, Boolean bool) {
        Boolean boolOptBooleanOrNull = optBooleanOrNull(jSONObject, str);
        return boolOptBooleanOrNull == null ? bool : boolOptBooleanOrNull;
    }

    public static final float optFloatOrDefault(JSONObject jSONObject, String str, float f) {
        Float fOptFloatOrNull = optFloatOrNull(jSONObject, str);
        return fOptFloatOrNull != null ? fOptFloatOrNull.floatValue() : f;
    }

    public static final Float optFloatOrNull(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return Float.valueOf((float) jSONObject.getDouble(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final JSONObject optJsonObjectOrDefault(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        JSONObject jSONObjectOptJsonObjectOrNull = optJsonObjectOrNull(jSONObject, str);
        return jSONObjectOptJsonObjectOrNull == null ? jSONObject2 : jSONObjectOptJsonObjectOrNull;
    }

    public static final JSONObject optJsonObjectOrNull(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    public static final JSONObject optJsonObjectOrNullable(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        JSONObject jSONObjectOptJsonObjectOrNull = optJsonObjectOrNull(jSONObject, str);
        return jSONObjectOptJsonObjectOrNull == null ? jSONObject2 : jSONObjectOptJsonObjectOrNull;
    }

    public static final Long optLongOrDefault(JSONObject jSONObject, String str, Long l) {
        Long lOptLongOrNull = optLongOrNull(jSONObject, str);
        return lOptLongOrNull == null ? l : lOptLongOrNull;
    }

    public static final Long optLongOrNull(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return Long.valueOf(jSONObject.getLong(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String optStringOrNull(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String optStringOrNullable(JSONObject jSONObject, String str, String str2) {
        String strOptStringOrNull = optStringOrNull(jSONObject, str);
        return strOptStringOrNull == null ? str2 : strOptStringOrNull;
    }

    public static final boolean isEqualTo(JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        boolean zEquals;
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        Iterable iterableY = AbstractC23053wG5.y(0, jSONArray.length());
        if (!(iterableY instanceof Collection) || !((Collection) iterableY).isEmpty()) {
            Iterator it = iterableY.iterator();
            while (it.hasNext()) {
                int iB = ((AbstractC18386oa3) it).b();
                Object obj = jSONArray.get(iB);
                Object obj2 = jSONArray2.get(iB);
                if (obj instanceof JSONObject) {
                    if (!(obj2 instanceof JSONObject)) {
                        return false;
                    }
                    zEquals = isEqualTo((JSONObject) obj, (JSONObject) obj2);
                } else if (obj instanceof JSONArray) {
                    if (!(obj2 instanceof JSONArray)) {
                        return false;
                    }
                    zEquals = isEqualTo((JSONArray) obj, (JSONArray) obj2);
                } else {
                    zEquals = obj.equals(obj2);
                }
                if (!zEquals) {
                    return false;
                }
            }
        }
        return true;
    }
}
