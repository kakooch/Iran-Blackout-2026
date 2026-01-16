package ir.nasim;

import java.io.File;

/* renamed from: ir.nasim.pj8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C19072pj8 extends Su8 {
    private final File a;
    private final String b;

    C19072pj8(File file, String str) {
        if (file == null) {
            throw new NullPointerException("Null splitFile");
        }
        this.a = file;
        if (str == null) {
            throw new NullPointerException("Null splitId");
        }
        this.b = str;
    }

    @Override // ir.nasim.Su8
    final File a() {
        return this.a;
    }

    @Override // ir.nasim.Su8
    final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Su8) {
            Su8 su8 = (Su8) obj;
            if (this.a.equals(su8.a()) && this.b.equals(su8.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        return "SplitFileInfo{splitFile=" + this.a.toString() + ", splitId=" + this.b + "}";
    }
}
