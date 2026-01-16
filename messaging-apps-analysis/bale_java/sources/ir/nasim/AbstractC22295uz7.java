package ir.nasim;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.uz7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC22295uz7 {
    public static Typeface a(Context context, Typeface typeface) {
        return b(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface b(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0) {
            return null;
        }
        return Typeface.create(typeface, AbstractC22000uV3.b(typeface.getWeight() + configuration.fontWeightAdjustment, 1, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT), typeface.isItalic());
    }
}
