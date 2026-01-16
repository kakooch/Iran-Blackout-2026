package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.KotlinNothingValueException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.JsonEncodingException;

/* renamed from: ir.nasim.Ck3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3802Ck3 {
    public static final JsonDecodingException a(Number number, String str, String str2) {
        AbstractC13042fc3.i(number, "value");
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(str2, "output");
        return d(-1, l(number, str, str2));
    }

    public static final JsonEncodingException b(Number number, String str) {
        AbstractC13042fc3.i(number, "value");
        AbstractC13042fc3.i(str, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) j(str, 0, 1, null)));
    }

    public static final JsonEncodingException c(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + serialDescriptor.i() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + serialDescriptor.f() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonDecodingException d(int i, String str) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        if (i >= 0) {
            str = "Unexpected JSON token at offset " + i + ": " + str;
        }
        return new JsonDecodingException(str);
    }

    public static final JsonDecodingException e(int i, String str, CharSequence charSequence) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(charSequence, "input");
        return d(i, str + "\nJSON input: " + ((Object) i(charSequence, i)));
    }

    public static final JsonDecodingException f(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(str2, "input");
        return d(-1, "Encountered an unknown key '" + str + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + ((Object) j(str2, 0, 1, null)));
    }

    public static final Void g(Z0 z0, String str) {
        AbstractC13042fc3.i(z0, "<this>");
        AbstractC13042fc3.i(str, "entity");
        z0.w("Trailing comma before the end of JSON " + str, z0.a - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void h(Z0 z0, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "object";
        }
        return g(z0, str);
    }

    public static final CharSequence i(CharSequence charSequence, int i) {
        AbstractC13042fc3.i(charSequence, "<this>");
        if (charSequence.length() < 200) {
            return charSequence;
        }
        if (i == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return "....." + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int i2 = i - 30;
        int i3 = i + 30;
        return (i2 <= 0 ? "" : ".....") + charSequence.subSequence(AbstractC23053wG5.e(i2, 0), AbstractC23053wG5.i(i3, charSequence.length())).toString() + (i3 >= charSequence.length() ? "" : ".....");
    }

    public static /* synthetic */ CharSequence j(CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return i(charSequence, i);
    }

    public static final Void k(Z0 z0, Number number) {
        AbstractC13042fc3.i(z0, "<this>");
        AbstractC13042fc3.i(number, "result");
        Z0.x(z0, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, null);
        throw new KotlinNothingValueException();
    }

    private static final String l(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) j(str2, 0, 1, null));
    }
}
