package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.view.accessibility.AccessibilityManager;

/* renamed from: ir.nasim.b3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10082b3 {
    public static final C10082b3 a = new C10082b3();

    private C10082b3() {
    }

    public static final String b(Context context, Number number) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(number, "size");
        float fFloatValue = number.floatValue() / 1024;
        String strO = AbstractC7426Rr.a.o(fFloatValue);
        if (AbstractC20762sZ6.V(strO, "kb", true)) {
            return AbstractC20153rZ6.M(AbstractC20153rZ6.K(strO, "kb", "", true), "٫", Separators.DOT, false, 4, null) + context.getString(AbstractC12217eE5.file_size_kb);
        }
        if (AbstractC20762sZ6.V(strO, "mb", true)) {
            return AbstractC20153rZ6.M(AbstractC20153rZ6.K(strO, "mb", "", true), "٫", Separators.DOT, false, 4, null) + context.getString(AbstractC12217eE5.file_size_mb);
        }
        if (!AbstractC20762sZ6.V(strO, "gb", true)) {
            return fFloatValue + context.getString(AbstractC12217eE5.file_size_kb);
        }
        return AbstractC20153rZ6.M(AbstractC20153rZ6.K(strO, "gb", "", true), "٫", Separators.DOT, false, 4, null) + context.getString(AbstractC12217eE5.file_size_gb);
    }

    public static final boolean c(Context context) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("accessibility");
        AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public static final String d(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        return AbstractC20762sZ6.n1(new C20644sM5("\\[([^\\]]+)]\\(([^\\)]+)\\)").k(new C20644sM5("\\*(.*?)\\*").k(str, "$1"), "$1")).toString();
    }

    public final String a(Context context, long j) {
        AbstractC13042fc3.i(context, "context");
        long j2 = 3600;
        long j3 = j / j2;
        long j4 = 60;
        long j5 = (j % j2) / j4;
        long j6 = j % j4;
        if (j3 != 0) {
            String string = j5 != 0 ? context.getString(AbstractC12217eE5.time_duration_hours_minutes, Long.valueOf(j3), Long.valueOf(j5)) : context.getString(AbstractC12217eE5.time_duration_hours, Long.valueOf(j3));
            AbstractC13042fc3.f(string);
            return string;
        }
        if (j5 != 0) {
            String string2 = j6 != 0 ? context.getString(AbstractC12217eE5.time_duration_minutes_seconds, Long.valueOf(j5), Long.valueOf(j6)) : context.getString(AbstractC12217eE5.time_duration_minutes, Long.valueOf(j5));
            AbstractC13042fc3.f(string2);
            return string2;
        }
        String string3 = context.getString(AbstractC12217eE5.time_duration_seconds, Long.valueOf(j6));
        AbstractC13042fc3.f(string3);
        return string3;
    }
}
