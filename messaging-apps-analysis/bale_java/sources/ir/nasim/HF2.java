package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class HF2 implements InterfaceC15283jK {
    private final C11458d25 a;
    private final J44 b;

    public HF2(C11458d25 c11458d25, J44 j44) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        this.a = c11458d25;
        this.b = j44;
    }

    public final J44 a() {
        return this.b;
    }

    public final C11458d25 b() {
        return this.a;
    }
}
