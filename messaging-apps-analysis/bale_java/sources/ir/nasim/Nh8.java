package ir.nasim;

import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class Nh8 {
    public static /* synthetic */ BigDecimal a(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }
}
