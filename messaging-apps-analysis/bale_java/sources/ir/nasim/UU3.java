package ir.nasim;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes3.dex */
public abstract class UU3 {
    public static TypedValue a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i, boolean z) {
        TypedValue typedValueA = a(context, i);
        return (typedValueA == null || typedValueA.type != 18) ? z : typedValueA.data != 0;
    }

    public static int c(Context context, int i, int i2) {
        TypedValue typedValueA = a(context, i);
        return (typedValueA == null || typedValueA.type != 16) ? i2 : typedValueA.data;
    }

    public static int d(Context context, int i, String str) {
        TypedValue typedValueA = a(context, i);
        if (typedValueA != null) {
            return typedValueA.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static int e(View view, int i) {
        return d(view.getContext(), i, view.getClass().getCanonicalName());
    }
}
