package ir.nasim;

/* loaded from: classes.dex */
final class NT extends WR7 {
    private final int g;
    private final int h;
    private final int i;
    private final String j;

    NT(int i, int i2, int i3, String str) {
        this.g = i;
        this.h = i2;
        this.i = i3;
        if (str == null) {
            throw new NullPointerException("Null description");
        }
        this.j = str;
    }

    @Override // ir.nasim.WR7
    String o() {
        return this.j;
    }

    @Override // ir.nasim.WR7
    public int p() {
        return this.g;
    }

    @Override // ir.nasim.WR7
    int q() {
        return this.h;
    }

    @Override // ir.nasim.WR7
    int r() {
        return this.i;
    }
}
