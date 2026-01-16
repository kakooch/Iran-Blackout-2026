package ir.nasim;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.util.TypedValue;

/* renamed from: ir.nasim.lk4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC16714lk4 {
    private static float a(String[] strArr, int i) throws NumberFormatException {
        float f = Float.parseFloat(strArr[i]);
        if (f >= 0.0f && f <= 1.0f) {
            return f;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f);
    }

    private static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static boolean c(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(Separators.LPAREN);
        return str.startsWith(sb.toString()) && str.endsWith(Separators.RPAREN);
    }

    public static int d(Context context, int i, int i2) {
        return UU3.c(context, i, i2);
    }

    public static TimeInterpolator e(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be a string");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!c(strValueOf, "cubic-bezier")) {
            if (c(strValueOf, "path")) {
                return AbstractC15109j15.b(AbstractC20446s15.d(b(strValueOf, "path")));
            }
            throw new IllegalArgumentException("Invalid motion easing type: " + strValueOf);
        }
        String[] strArrSplit = b(strValueOf, "cubic-bezier").split(",");
        if (strArrSplit.length == 4) {
            return AbstractC15109j15.a(a(strArrSplit, 0), a(strArrSplit, 1), a(strArrSplit, 2), a(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }
}
