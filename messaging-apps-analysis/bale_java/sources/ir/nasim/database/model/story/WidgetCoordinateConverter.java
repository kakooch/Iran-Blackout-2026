package ir.nasim.database.model.story;

import com.google.gson.reflect.TypeToken;
import ir.nasim.KS2;
import java.util.List;

/* loaded from: classes5.dex */
public final class WidgetCoordinateConverter {
    public final List a(String str) {
        return (List) new KS2().l(str, new TypeToken<List<? extends WidgetCoordinate>>() { // from class: ir.nasim.database.model.story.WidgetCoordinateConverter$fromJsonToList$type$1
        }.d());
    }

    public final String b(List list) {
        return new KS2().t(list);
    }
}
