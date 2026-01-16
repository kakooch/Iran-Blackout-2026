package j$.time.chrono;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class a implements g {
    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new Locale("ja", "JP", "JP");
    }

    protected a() {
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        ((g) obj).getClass();
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        ((a) obj).getClass();
        return true;
    }

    public int hashCode() {
        return getClass().hashCode() ^ 72805;
    }

    public String toString() {
        return "ISO";
    }
}
