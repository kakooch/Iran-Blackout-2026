package ir.nasim;

import android.util.SparseArray;

/* renamed from: ir.nasim.wz5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public enum EnumC23479wz5 {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);

    private static final SparseArray h;
    private final int a;

    static {
        EnumC23479wz5 enumC23479wz5 = DEFAULT;
        EnumC23479wz5 enumC23479wz52 = UNMETERED_ONLY;
        EnumC23479wz5 enumC23479wz53 = UNMETERED_OR_DAILY;
        EnumC23479wz5 enumC23479wz54 = FAST_IF_RADIO_AWAKE;
        EnumC23479wz5 enumC23479wz55 = NEVER;
        EnumC23479wz5 enumC23479wz56 = UNRECOGNIZED;
        SparseArray sparseArray = new SparseArray();
        h = sparseArray;
        sparseArray.put(0, enumC23479wz5);
        sparseArray.put(1, enumC23479wz52);
        sparseArray.put(2, enumC23479wz53);
        sparseArray.put(3, enumC23479wz54);
        sparseArray.put(4, enumC23479wz55);
        sparseArray.put(-1, enumC23479wz56);
    }

    EnumC23479wz5(int i2) {
        this.a = i2;
    }
}
