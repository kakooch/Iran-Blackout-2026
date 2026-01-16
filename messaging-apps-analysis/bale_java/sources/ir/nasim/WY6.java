package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes2.dex */
public abstract class WY6 {
    public static final String[] a = new String[0];

    public static final void a(StringBuilder sb, int i) {
        AbstractC13042fc3.i(sb, "builder");
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(Separators.QUESTION);
            if (i2 < i - 1) {
                sb.append(",");
            }
        }
    }

    public static final StringBuilder b() {
        return new StringBuilder();
    }
}
