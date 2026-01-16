package io.appmetrica.analytics.ecommerce;

import io.appmetrica.analytics.impl.hn;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class ECommerceAmount {
    private final BigDecimal a;
    private final String b;

    public ECommerceAmount(long j, String str) {
        this(hn.a(j), str);
    }

    public BigDecimal getAmount() {
        return this.a;
    }

    public String getUnit() {
        return this.b;
    }

    public String toString() {
        return "ECommerceAmount{amount=" + this.a + ", unit='" + this.b + "'}";
    }

    public ECommerceAmount(double d, String str) {
        this(new BigDecimal(hn.a(d)), str);
    }

    public ECommerceAmount(BigDecimal bigDecimal, String str) {
        this.a = bigDecimal;
        this.b = str;
    }
}
