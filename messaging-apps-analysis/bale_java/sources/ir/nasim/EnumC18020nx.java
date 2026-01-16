package ir.nasim;

/* renamed from: ir.nasim.nx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC18020nx {
    RIAL(1),
    SCORE(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC18020nx(int i) {
        this.a = i;
    }

    public static EnumC18020nx p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : SCORE : RIAL;
    }

    public int j() {
        return this.a;
    }
}
