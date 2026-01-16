package ir.nasim;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.kj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC16111kj2 {
    public static final List a(Parcel parcel) {
        AbstractC13042fc3.i(parcel, "<this>");
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        return arrayList;
    }

    public static final void b(Parcel parcel, List list) {
        AbstractC13042fc3.i(parcel, "<this>");
        AbstractC13042fc3.i(list, "input");
        parcel.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            parcel.writeInt(((Number) it.next()).intValue());
        }
    }
}
