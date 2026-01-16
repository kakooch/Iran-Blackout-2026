package ir.nasim.database.converters;

import com.google.gson.reflect.TypeToken;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.KS2;
import java.util.List;

/* loaded from: classes5.dex */
public final class IntArrayTypeConverter {
    public final List a(String str) {
        AbstractC13042fc3.i(str, "list");
        Object objL = new KS2().l(str, new TypeToken<List<? extends Integer>>() { // from class: ir.nasim.database.converters.IntArrayTypeConverter$getIntList$1
        }.d());
        AbstractC13042fc3.h(objL, "fromJson(...)");
        return (List) objL;
    }

    public final String b(List list) {
        AbstractC13042fc3.i(list, "list");
        String strT = new KS2().t(list);
        AbstractC13042fc3.h(strT, "toJson(...)");
        return strT;
    }
}
