package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketSection;

/* renamed from: ir.nasim.vP3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22536vP3 {
    public static final int c = MarketSection.$stable | MarketItem.$stable;
    private final MarketItem a;
    private final MarketSection b;

    public C22536vP3(MarketItem marketItem, MarketSection marketSection) {
        AbstractC13042fc3.i(marketItem, "marketItem");
        AbstractC13042fc3.i(marketSection, "marketSection");
        this.a = marketItem;
        this.b = marketSection;
    }

    public final MarketItem a() {
        return this.a;
    }

    public final MarketSection b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22536vP3)) {
            return false;
        }
        C22536vP3 c22536vP3 = (C22536vP3) obj;
        return AbstractC13042fc3.d(this.a, c22536vP3.a) && AbstractC13042fc3.d(this.b, c22536vP3.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MarketEventModel(marketItem=" + this.a + ", marketSection=" + this.b + Separators.RPAREN;
    }
}
