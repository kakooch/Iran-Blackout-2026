package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.So1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7635So1 {
    public static final C7635So1 a = new C7635So1();

    private C7635So1() {
    }

    public final String a(int i, Context context) {
        String str;
        AbstractC13042fc3.i(context, "context");
        String strE = PH3.e();
        if (i < 1000) {
            return AbstractC20153rZ6.D(strE, "fa", true) ? XY6.e(String.valueOf(i)) : String.valueOf(i);
        }
        int i2 = i / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        boolean z = i % AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT > 1;
        String string = i2 < 2 ? context.getString(AbstractC12217eE5.market_search_count_in_word_thousand) : context.getString(AbstractC12217eE5.market_search_count_in_word_thousands);
        AbstractC13042fc3.f(string);
        if (z) {
            str = i2 + "+ " + string;
        } else {
            str = i2 + Separators.SP + string;
        }
        return AbstractC20153rZ6.D(strE, "fa", true) ? XY6.e(str) : str;
    }
}
