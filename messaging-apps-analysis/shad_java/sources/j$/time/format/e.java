package j$.time.format;

/* loaded from: classes2.dex */
final class e implements g {
    private final char a;

    e(char c) {
        this.a = c;
    }

    @Override // j$.time.format.g
    public boolean a(q qVar, StringBuilder sb) {
        sb.append(this.a);
        return true;
    }

    public String toString() {
        if (this.a == '\'') {
            return "''";
        }
        return "'" + this.a + "'";
    }
}
