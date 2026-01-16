package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class PC {
    public static final PC a = new PC();
    public static final List b;
    public static final List c;
    public static final List d;
    public static final List e;
    public static final List f;
    public static final List g;
    public static final List h;
    public static final int i;

    static {
        EnumC16902m35 enumC16902m35 = EnumC16902m35.UpdateOptimization_STRIP_ENTITIES;
        EnumC16902m35 enumC16902m352 = EnumC16902m35.UpdateOptimization_STRIP_COUNTERS;
        EnumC16902m35 enumC16902m353 = EnumC16902m35.UpdateOptimization_COMPACT_USERS;
        b = AbstractC10360bX0.p(enumC16902m35, enumC16902m352, enumC16902m353);
        e = AbstractC10360bX0.g(EnumC15220jD.STRIP_UNREAD_COUNTS);
        ArrayList arrayList = new ArrayList();
        arrayList.add(EnumC15220jD.STRIP_ENTITIES);
        arrayList.add(EnumC15220jD.STRIP_COUNTERS);
        arrayList.add(EnumC15220jD.COMPACT_USERS);
        c = new ArrayList(arrayList);
        ArrayList arrayList2 = new ArrayList(arrayList);
        EnumC15220jD enumC15220jD = EnumC15220jD.STRIP_MESSAGES;
        arrayList2.add(enumC15220jD);
        f = arrayList2;
        ArrayList arrayList3 = new ArrayList(arrayList);
        arrayList3.add(enumC15220jD);
        arrayList3.add(EnumC15220jD.STRIP_TOTAL_UPDATES);
        g = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(enumC16902m352);
        arrayList4.add(enumC16902m35);
        arrayList4.add(enumC16902m353);
        d = new ArrayList(arrayList4);
        ArrayList arrayList5 = new ArrayList(arrayList4);
        arrayList5.add(EnumC16902m35.UpdateOptimization_STRIP_MESSAGES);
        arrayList5.add(EnumC16902m35.UpdateOptimization_STRIP_TOTAL_UPDATES);
        h = arrayList5;
        i = 8;
    }

    private PC() {
    }
}
