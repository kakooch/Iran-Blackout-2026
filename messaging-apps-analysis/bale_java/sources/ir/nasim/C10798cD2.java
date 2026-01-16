package ir.nasim;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.cD2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10798cD2 {
    private final Context a;

    /* renamed from: ir.nasim.cD2$a */
    public interface a {
        C10798cD2 a(Context context);
    }

    public C10798cD2(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    private final Spannable a(long j) {
        String strV = XY6.v(C17959nq7.a.a((int) (j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        spannableStringBuilder.append((CharSequence) strV);
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        AbstractC17636nI6.f(spannableStringBuilder, AbstractC4043Dl1.c(this.a, TA5.white), 0, 0, 6, null);
        AbstractC17636nI6.h(spannableStringBuilder, AbstractC4043Dl1.c(this.a, TA5.background_service), 20, 0, 0, 12, null);
        return spannableStringBuilder;
    }

    public final C21837uD2 b(C9588aD2 c9588aD2, Integer num, C17337mn6 c17337mn6) {
        String strF;
        AbstractC13042fc3.i(c9588aD2, "item");
        int iC = c9588aD2.c();
        if (c17337mn6 == null || (strF = c17337mn6.f()) == null) {
            strF = c9588aD2.f();
        }
        String str = strF;
        Long lB = c9588aD2.b();
        Spannable spannableA = lB != null ? a(lB.longValue()) : null;
        Long lB2 = c9588aD2.b();
        return new C21837uD2(iC, str, spannableA, lB2 != null ? Long.valueOf((lB2.longValue() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) / 2) : null, num, c17337mn6 != null ? c17337mn6.c() : null, c9588aD2.e(), null, c17337mn6 != null ? c17337mn6.e() : null, 128, null);
    }
}
