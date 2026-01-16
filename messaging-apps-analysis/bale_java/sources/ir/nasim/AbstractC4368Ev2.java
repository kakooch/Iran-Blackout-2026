package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: ir.nasim.Ev2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4368Ev2 {
    public static final String a(int i) {
        return b(i);
    }

    public static final String b(long j) {
        float f;
        String str;
        if (j < 1000) {
            f = j;
            str = "";
        } else if (j < 1000000) {
            f = j / 1000.0f;
            str = TokenNames.K;
        } else {
            f = j / 1000000.0f;
            str = TokenNames.M;
        }
        DY6 dy6 = DY6.a;
        String str2 = String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
        AbstractC13042fc3.h(str2, "format(...)");
        return AbstractC12152e76.b(AbstractC20762sZ6.E0(str2, ".0")) + str;
    }
}
