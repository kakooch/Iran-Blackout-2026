package ir.nasim;

import kotlin.KotlinNothingValueException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.internal.JsonDecodingException;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.wk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23331wk3 {
    private static final SerialDescriptor a = J73.a("kotlinx.serialization.json.JsonUnquotedLiteral", AbstractC18503om0.z(DY6.a));

    public static final JsonPrimitive a(String str) {
        return str == null ? JsonNull.INSTANCE : new C5221Ik3(str, true, null, 4, null);
    }

    private static final Void b(JsonElement jsonElement, String str) {
        throw new IllegalArgumentException("Element " + AbstractC10882cM5.b(jsonElement.getClass()) + " is not a " + str);
    }

    public static final Boolean c(JsonPrimitive jsonPrimitive) {
        AbstractC13042fc3.i(jsonPrimitive, "<this>");
        return SY6.d(jsonPrimitive.f());
    }

    public static final String d(JsonPrimitive jsonPrimitive) {
        AbstractC13042fc3.i(jsonPrimitive, "<this>");
        if (jsonPrimitive instanceof JsonNull) {
            return null;
        }
        return jsonPrimitive.f();
    }

    public static final double e(JsonPrimitive jsonPrimitive) {
        AbstractC13042fc3.i(jsonPrimitive, "<this>");
        return Double.parseDouble(jsonPrimitive.f());
    }

    public static final float f(JsonPrimitive jsonPrimitive) {
        AbstractC13042fc3.i(jsonPrimitive, "<this>");
        return Float.parseFloat(jsonPrimitive.f());
    }

    public static final int g(JsonPrimitive jsonPrimitive) {
        AbstractC13042fc3.i(jsonPrimitive, "<this>");
        try {
            long jM = new LY6(jsonPrimitive.f()).m();
            if (-2147483648L <= jM && jM <= TTL.MAX_VALUE) {
                return (int) jM;
            }
            throw new NumberFormatException(jsonPrimitive.f() + " is not an Int");
        } catch (JsonDecodingException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }

    public static final JsonPrimitive h(JsonElement jsonElement) {
        AbstractC13042fc3.i(jsonElement, "<this>");
        JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        b(jsonElement, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final SerialDescriptor i() {
        return a;
    }

    public static final long j(JsonPrimitive jsonPrimitive) {
        AbstractC13042fc3.i(jsonPrimitive, "<this>");
        try {
            return new LY6(jsonPrimitive.f()).m();
        } catch (JsonDecodingException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }
}
