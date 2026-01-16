package ir.nasim;

import ai.bale.proto.MarketStruct$MarketCategory;
import ir.nasim.core.modules.market.model.MarketSection;

/* renamed from: ir.nasim.sz, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21010sz implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MarketSection a(MarketStruct$MarketCategory marketStruct$MarketCategory) {
        AbstractC13042fc3.i(marketStruct$MarketCategory, "input");
        return MarketSection.INSTANCE.a(marketStruct$MarketCategory);
    }
}
