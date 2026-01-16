package ir.nasim;

import java.util.EnumMap;

/* renamed from: ir.nasim.Vi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8290Vi3 {
    private final EnumMap a;

    public C8290Vi3(EnumMap enumMap) {
        AbstractC13042fc3.i(enumMap, "defaultQualifiers");
        this.a = enumMap;
    }

    public final C9876ai3 a(EnumC23427wu enumC23427wu) {
        return (C9876ai3) this.a.get(enumC23427wu);
    }

    public final EnumMap b() {
        return this.a;
    }
}
