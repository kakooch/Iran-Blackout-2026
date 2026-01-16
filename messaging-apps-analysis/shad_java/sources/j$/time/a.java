package j$.time;

import java.io.Serializable;

/* loaded from: classes2.dex */
final class a extends b implements Serializable {
    private final l a;

    a(l lVar) {
        this.a = lVar;
    }

    @Override // j$.time.b
    public long a() {
        return System.currentTimeMillis();
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.a.equals(((a) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + 1;
    }

    public String toString() {
        return "SystemClock[" + this.a + "]";
    }
}
