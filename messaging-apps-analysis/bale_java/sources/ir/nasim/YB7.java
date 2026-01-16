package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes8.dex */
public abstract class YB7 {
    public static final int a(int i, int i2) {
        return AbstractC13042fc3.k(i ^ RecyclerView.UNDEFINED_DURATION, i2 ^ RecyclerView.UNDEFINED_DURATION);
    }

    public static final int b(long j, long j2) {
        return AbstractC13042fc3.l(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    public static final double c(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    public static final String d(long j, int i) {
        if (j >= 0) {
            String string = Long.toString(j, AbstractC10868cL0.a(i));
            AbstractC13042fc3.h(string, "toString(...)");
            return string;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j3, AbstractC10868cL0.a(i));
        AbstractC13042fc3.h(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j4, AbstractC10868cL0.a(i));
        AbstractC13042fc3.h(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
