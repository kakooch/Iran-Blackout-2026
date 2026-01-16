package j$.time.chrono;

import j$.time.ZonedDateTime;
import j$.time.l;
import j$.time.temporal.k;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class i extends a implements Serializable {
    public static final i a = new i();

    private i() {
    }

    @Override // j$.time.chrono.h
    public String g() {
        return "ISO";
    }

    public boolean h(long j) {
        return (3 & j) == 0 && (j % 100 != 0 || j % 400 == 0);
    }

    @Override // j$.time.chrono.h
    public b i(k kVar) {
        return j$.time.g.v(kVar);
    }

    @Override // j$.time.chrono.a, j$.time.chrono.h
    public c o(k kVar) {
        return j$.time.h.v(kVar);
    }

    @Override // j$.time.chrono.a, j$.time.chrono.h
    public f r(j$.time.f fVar, l lVar) {
        return ZonedDateTime.t(fVar, lVar);
    }
}
