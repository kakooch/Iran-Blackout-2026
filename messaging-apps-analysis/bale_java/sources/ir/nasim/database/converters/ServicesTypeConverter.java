package ir.nasim.database.converters;

import com.google.gson.reflect.TypeToken;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.KS2;
import ir.nasim.database.entity.ServiceItemMenuItemEntity;
import java.util.List;

/* loaded from: classes5.dex */
public final class ServicesTypeConverter {
    public final String a(List list) {
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            try {
                String strU = new KS2().u(list, new TypeToken<List<? extends ServiceItemMenuItemEntity>>() { // from class: ir.nasim.database.converters.ServicesTypeConverter$fromServiceItemMenuEntities$type$1
                }.d());
                AbstractC13042fc3.h(strU, "toJson(...)");
                return strU;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final List b(String str) {
        if (str != null && str.length() != 0) {
            try {
                Object objL = new KS2().l(str, new TypeToken<List<? extends ServiceItemMenuItemEntity>>() { // from class: ir.nasim.database.converters.ServicesTypeConverter$toServiceItemMenuEntities$type$1
                }.d());
                AbstractC13042fc3.h(objL, "fromJson(...)");
                return (List) objL;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
