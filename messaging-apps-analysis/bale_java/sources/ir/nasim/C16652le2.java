package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.le2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C16652le2 {
    private final List a;
    private final int b;
    private final boolean c;

    C16652le2(List list, int i, boolean z) {
        this.a = new ArrayList(list);
        this.b = i;
        this.c = z;
    }

    List a() {
        return this.a;
    }

    int b() {
        return this.b;
    }

    boolean c(List list) {
        return this.a.equals(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C16652le2)) {
            return false;
        }
        C16652le2 c16652le2 = (C16652le2) obj;
        return this.a.equals(c16652le2.a()) && this.c == c16652le2.c;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }
}
