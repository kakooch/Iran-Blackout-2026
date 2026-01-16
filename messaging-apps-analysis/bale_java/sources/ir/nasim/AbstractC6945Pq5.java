package ir.nasim;

import android.util.SparseArray;
import java.util.HashMap;

/* renamed from: ir.nasim.Pq5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6945Pq5 {
    private static SparseArray a = new SparseArray();
    private static HashMap b;

    static {
        HashMap map = new HashMap();
        b = map;
        map.put(EnumC5979Lq5.DEFAULT, 0);
        b.put(EnumC5979Lq5.VERY_LOW, 1);
        b.put(EnumC5979Lq5.HIGHEST, 2);
        for (EnumC5979Lq5 enumC5979Lq5 : b.keySet()) {
            a.append(((Integer) b.get(enumC5979Lq5)).intValue(), enumC5979Lq5);
        }
    }

    public static int a(EnumC5979Lq5 enumC5979Lq5) {
        Integer num = (Integer) b.get(enumC5979Lq5);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + enumC5979Lq5);
    }

    public static EnumC5979Lq5 b(int i) {
        EnumC5979Lq5 enumC5979Lq5 = (EnumC5979Lq5) a.get(i);
        if (enumC5979Lq5 != null) {
            return enumC5979Lq5;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i);
    }
}
