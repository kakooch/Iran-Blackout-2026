package j$.time.format;

import io.github.inflationx.calligraphy3.BuildConfig;
import j$.time.temporal.x;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes2.dex */
final class h implements g {
    private final j$.time.temporal.l a;
    private final int b;
    private final int c;
    private final boolean d;

    h(j$.time.temporal.l lVar, int i, int i2, boolean z) {
        if (lVar == null) {
            throw new NullPointerException("field");
        }
        if (!lVar.a().f()) {
            throw new IllegalArgumentException("Field must have a fixed set of values: " + lVar);
        }
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i);
        }
        if (i2 < 1 || i2 > 9) {
            throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i2);
        }
        if (i2 >= i) {
            this.a = lVar;
            this.b = i;
            this.c = i2;
            this.d = z;
            return;
        }
        throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
    }

    @Override // j$.time.format.g
    public boolean a(q qVar, StringBuilder sb) {
        Long lE = qVar.e(this.a);
        if (lE == null) {
            return false;
        }
        s sVarB = qVar.b();
        long jLongValue = lE.longValue();
        x xVarA = this.a.a();
        xVarA.b(jLongValue, this.a);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(xVarA.e());
        BigDecimal bigDecimalDivide = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf).divide(BigDecimal.valueOf(xVarA.d()).subtract(bigDecimalValueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
        BigDecimal bigDecimalStripTrailingZeros = bigDecimalDivide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : bigDecimalDivide.stripTrailingZeros();
        if (bigDecimalStripTrailingZeros.scale() != 0) {
            String strA = sVarB.a(bigDecimalStripTrailingZeros.setScale(Math.min(Math.max(bigDecimalStripTrailingZeros.scale(), this.b), this.c), RoundingMode.FLOOR).toPlainString().substring(2));
            if (this.d) {
                sb.append(sVarB.b());
            }
            sb.append(strA);
            return true;
        }
        if (this.b <= 0) {
            return true;
        }
        if (this.d) {
            sb.append(sVarB.b());
        }
        for (int i = 0; i < this.b; i++) {
            sb.append(sVarB.e());
        }
        return true;
    }

    public String toString() {
        return "Fraction(" + this.a + "," + this.b + "," + this.c + (this.d ? ",DecimalPoint" : BuildConfig.FLAVOR) + ")";
    }
}
