package defpackage;

import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public final class v {
    private final int a;

    public v(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && this.a == ((v) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "DraggableItem(index=" + this.a + Separators.RPAREN;
    }
}
