package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;

/* renamed from: ir.nasim.aS3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9724aS3 {
    public static final int c = MarketSection.$stable | MarketProductItem.$stable;
    private final MarketProductItem a;
    private final MarketSection b;

    public C9724aS3(MarketProductItem marketProductItem, MarketSection marketSection) {
        AbstractC13042fc3.i(marketProductItem, "marketItem");
        AbstractC13042fc3.i(marketSection, "marketSection");
        this.a = marketProductItem;
        this.b = marketSection;
    }

    public final MarketProductItem a() {
        return this.a;
    }

    public final MarketSection b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9724aS3)) {
            return false;
        }
        C9724aS3 c9724aS3 = (C9724aS3) obj;
        return AbstractC13042fc3.d(this.a, c9724aS3.a) && AbstractC13042fc3.d(this.b, c9724aS3.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MarketProductEventModel(marketItem=" + this.a + ", marketSection=" + this.b + Separators.RPAREN;
    }
}
