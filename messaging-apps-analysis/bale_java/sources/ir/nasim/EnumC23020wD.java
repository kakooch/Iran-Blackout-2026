package ir.nasim;

/* renamed from: ir.nasim.wD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC23020wD {
    UNKNOWN(0),
    BRAVE(1),
    COMBATANT(2),
    HERO(3),
    WARRIOR(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC23020wD(int i) {
        this.a = i;
    }

    public static EnumC23020wD p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : WARRIOR : HERO : COMBATANT : BRAVE : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
