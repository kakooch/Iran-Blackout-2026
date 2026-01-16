package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.za8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C25010za8 {
    private final List a;

    public C25010za8(List list) {
        AbstractC13042fc3.i(list, "displayFeatures");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !AbstractC13042fc3.d(C25010za8.class, obj.getClass())) {
            return false;
        }
        return AbstractC13042fc3.d(this.a, ((C25010za8) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return AbstractC15401jX0.A0(this.a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, null, null, 56, null);
    }
}
