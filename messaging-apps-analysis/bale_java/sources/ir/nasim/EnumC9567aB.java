package ir.nasim;

/* renamed from: ir.nasim.aB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC9567aB {
    SINGLECHOICE(1),
    MULTIPLECHOICE(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC9567aB(int i) {
        this.a = i;
    }

    public static EnumC9567aB p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : MULTIPLECHOICE : SINGLECHOICE;
    }

    public int j() {
        return this.a;
    }
}
