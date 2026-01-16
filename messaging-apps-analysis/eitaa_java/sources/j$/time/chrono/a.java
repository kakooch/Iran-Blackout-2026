package j$.time.chrono;

import j$.time.l;
import j$.time.temporal.k;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class a implements h {
    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new Locale("ja", "JP", "JP");
    }

    protected a() {
    }

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        return "ISO".compareTo(hVar.g());
    }

    @Override // j$.time.chrono.h
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && compareTo((a) obj) == 0;
    }

    public int hashCode() {
        return getClass().hashCode() ^ 72805;
    }

    @Override // j$.time.chrono.h
    public c o(k kVar) {
        try {
            return j$.time.h.z(j$.time.g.v(kVar), j$.time.i.v(kVar));
        } catch (j$.time.c e) {
            StringBuilder sbA = j$.com.android.tools.r8.a.a("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            sbA.append(kVar.getClass());
            throw new j$.time.c(sbA.toString(), e);
        }
    }

    @Override // j$.time.chrono.h
    public f r(j$.time.f fVar, l lVar) {
        return g.t(this, fVar, lVar);
    }

    public String toString() {
        return "ISO";
    }
}
