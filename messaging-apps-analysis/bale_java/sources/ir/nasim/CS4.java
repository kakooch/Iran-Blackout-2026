package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class CS4 {
    public static final void a(AS4 as4, C9424Zw2 c9424Zw2, Collection collection) {
        AbstractC13042fc3.i(as4, "<this>");
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(collection, "packageFragments");
        if (as4 instanceof DS4) {
            ((DS4) as4).a(c9424Zw2, collection);
        } else {
            collection.addAll(as4.b(c9424Zw2));
        }
    }

    public static final List b(AS4 as4, C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(as4, "<this>");
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        ArrayList arrayList = new ArrayList();
        a(as4, c9424Zw2, arrayList);
        return arrayList;
    }
}
