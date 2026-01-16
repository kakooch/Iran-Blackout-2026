package io.sentry.android.replay.util;

import android.os.Build;
import ir.nasim.AbstractC13042fc3;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class m {
    public static final m a = new m();

    public enum a {
        SOC_MODEL,
        SOC_MANUFACTURER
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.SOC_MODEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.SOC_MANUFACTURER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    private m() {
    }

    public static /* synthetic */ String b(m mVar, a aVar, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return mVar.a(aVar, str);
    }

    public final String a(a aVar, String str) {
        String str2;
        AbstractC13042fc3.i(aVar, "key");
        AbstractC13042fc3.i(str, "defaultValue");
        if (Build.VERSION.SDK_INT >= 31) {
            int i = b.a[aVar.ordinal()];
            if (i == 1) {
                str2 = Build.SOC_MODEL;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str2 = Build.SOC_MANUFACTURER;
            }
            str = str2;
            AbstractC13042fc3.h(str, "{\n      when (key) {\n   …ANUFACTURER\n      }\n    }");
        }
        return str;
    }
}
