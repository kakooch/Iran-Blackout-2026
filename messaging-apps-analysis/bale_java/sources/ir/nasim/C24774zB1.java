package ir.nasim;

/* renamed from: ir.nasim.zB1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C24774zB1 extends BB1 {
    private final String b;
    private final int c;
    private final boolean d;

    C24774zB1(int i, String str) {
        super(i);
        this.b = str;
        this.d = false;
        this.c = 0;
    }

    String b() {
        return this.b;
    }

    int c() {
        return this.c;
    }

    boolean d() {
        return this.d;
    }

    C24774zB1(int i, String str, int i2) {
        super(i);
        this.d = true;
        this.c = i2;
        this.b = str;
    }
}
