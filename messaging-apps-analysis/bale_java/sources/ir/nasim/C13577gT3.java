package ir.nasim;

import ir.nasim.core.modules.market.model.SearchSuggestion;
import java.util.ArrayList;

/* renamed from: ir.nasim.gT3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13577gT3 extends VW7 {
    private QQ3 b;

    public C13577gT3(QQ3 qq3) {
        AbstractC13042fc3.i(qq3, "marketModule");
        this.b = qq3;
    }

    public void P0(SearchSuggestion searchSuggestion) {
        String strW;
        ArrayList arrayListA;
        AbstractC13042fc3.i(searchSuggestion, "newSuggestion");
        ArrayList arrayList = new ArrayList();
        if (this.b.W() != null && (strW = this.b.W()) != null && (arrayListA = SearchSuggestion.INSTANCE.a(strW)) != null && !arrayListA.isEmpty()) {
            arrayList.addAll(arrayListA);
        }
        Integer numValueOf = null;
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            if (AbstractC13042fc3.d(((SearchSuggestion) obj).getTerm(), searchSuggestion.getTerm())) {
                numValueOf = Integer.valueOf(i);
            }
            i = i2;
        }
        if (numValueOf != null) {
        }
        arrayList.add(0, searchSuggestion);
        if (arrayList.size() > 10) {
            arrayList = new ArrayList(arrayList.subList(0, 10));
        }
        String strB = SearchSuggestion.INSTANCE.b(arrayList);
        if (strB != null) {
            this.b.b0(strB);
        }
    }
}
