package j$.time.chrono;

import j$.time.LocalDateTime;
import j$.time.ZonedDateTime;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.w;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class d {
    public static int a(f fVar, l lVar) {
        if (!(lVar instanceof j$.time.temporal.a)) {
            return j.a(fVar, lVar);
        }
        int i = e.a[((j$.time.temporal.a) lVar).ordinal()];
        if (i == 1) {
            throw new w("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) fVar;
        return i != 2 ? ((LocalDateTime) zonedDateTime.l()).a(lVar) : zonedDateTime.g().k();
    }
}
