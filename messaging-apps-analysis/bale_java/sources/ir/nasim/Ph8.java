package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Ph8 implements InterfaceC22720vi8 {
    private final Double a;

    public Ph8(Double d) {
        if (d == null) {
            this.a = Double.valueOf(Double.NaN);
        } else {
            this.a = d;
        }
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 d() {
        return new Ph8(this.a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Ph8) {
            return this.a.equals(((Ph8) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final String j() throws NumberFormatException {
        if (Double.isNaN(this.a.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(this.a.doubleValue())) {
            return this.a.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal bigDecimalA = Nh8.a(BigDecimal.valueOf(this.a.doubleValue()));
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((bigDecimalA.scale() > 0 ? bigDecimalA.precision() : bigDecimalA.scale()) - 1);
        String str = decimalFormat.format(bigDecimalA);
        int iIndexOf = str.indexOf(TokenNames.E);
        if (iIndexOf <= 0) {
            return str;
        }
        int i = Integer.parseInt(str.substring(iIndexOf + 1));
        return ((i >= 0 || i <= -7) && (i < 0 || i >= 21)) ? str.replace("E-", "e-").replace(TokenNames.E, "e+") : bigDecimalA.toPlainString();
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Double k() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Boolean o() {
        boolean z = false;
        if (!Double.isNaN(this.a.doubleValue()) && this.a.doubleValue() != 0.0d) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Iterator r() {
        return null;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 t(String str, C20322ro8 c20322ro8, List list) {
        if ("toString".equals(str)) {
            return new Ei8(j());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", j(), str));
    }

    public final String toString() {
        return j();
    }
}
