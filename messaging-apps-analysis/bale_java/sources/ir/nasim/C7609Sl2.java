package ir.nasim;

import java.io.File;
import java.util.List;

/* renamed from: ir.nasim.Sl2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7609Sl2 {
    private final File a;
    private final List b;

    public C7609Sl2(File file, List list) {
        AbstractC13042fc3.i(file, "root");
        AbstractC13042fc3.i(list, "segments");
        this.a = file;
        this.b = list;
    }

    public final File a() {
        return this.a;
    }

    public final List b() {
        return this.b;
    }

    public final int c() {
        return this.b.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7609Sl2)) {
            return false;
        }
        C7609Sl2 c7609Sl2 = (C7609Sl2) obj;
        return AbstractC13042fc3.d(this.a, c7609Sl2.a) && AbstractC13042fc3.d(this.b, c7609Sl2.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FilePathComponents(root=" + this.a + ", segments=" + this.b + ')';
    }
}
