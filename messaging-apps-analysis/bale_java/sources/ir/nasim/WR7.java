package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class WR7 implements Comparable {
    public static final WR7 a = i(1, 0, 0, "");
    public static final WR7 b = i(1, 1, 0, "");
    public static final WR7 c = i(1, 2, 0, "");
    public static final WR7 d = i(1, 3, 0, "");
    public static final WR7 e = i(1, 4, 0, "");
    private static final Pattern f = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:\\-(.+))?");

    WR7() {
    }

    public static WR7 i(int i, int i2, int i3, String str) {
        return new NT(i, i2, i3, str);
    }

    private static BigInteger j(WR7 wr7) {
        return BigInteger.valueOf(wr7.p()).shiftLeft(32).or(BigInteger.valueOf(wr7.q())).shiftLeft(32).or(BigInteger.valueOf(wr7.r()));
    }

    public static WR7 s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = f.matcher(str);
        if (matcher.matches()) {
            return i(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), matcher.group(4) != null ? matcher.group(4) : "");
        }
        return null;
    }

    public int a(int i, int i2) {
        return p() == i ? Integer.compare(q(), i2) : Integer.compare(p(), i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof WR7)) {
            return false;
        }
        WR7 wr7 = (WR7) obj;
        return Integer.valueOf(p()).equals(Integer.valueOf(wr7.p())) && Integer.valueOf(q()).equals(Integer.valueOf(wr7.q())) && Integer.valueOf(r()).equals(Integer.valueOf(wr7.r()));
    }

    @Override // java.lang.Comparable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(WR7 wr7) {
        return j(this).compareTo(j(wr7));
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(p()), Integer.valueOf(q()), Integer.valueOf(r()));
    }

    abstract String o();

    public abstract int p();

    abstract int q();

    abstract int r();

    public final String toString() {
        StringBuilder sb = new StringBuilder(p() + Separators.DOT + q() + Separators.DOT + r());
        if (!TextUtils.isEmpty(o())) {
            sb.append("-" + o());
        }
        return sb.toString();
    }
}
