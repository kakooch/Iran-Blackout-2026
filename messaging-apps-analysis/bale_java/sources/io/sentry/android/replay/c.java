package io.sentry.android.replay;

import io.sentry.C3160o3;
import ir.nasim.AbstractC13042fc3;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public final class c {
    private final u a;
    private final h b;
    private final Date c;
    private final int d;
    private final long e;
    private final C3160o3.b f;
    private final String g;
    private final List h;

    public c(u uVar, h hVar, Date date, int i, long j, C3160o3.b bVar, String str, List list) {
        AbstractC13042fc3.i(uVar, "recorderConfig");
        AbstractC13042fc3.i(hVar, "cache");
        AbstractC13042fc3.i(date, "timestamp");
        AbstractC13042fc3.i(bVar, "replayType");
        AbstractC13042fc3.i(list, "events");
        this.a = uVar;
        this.b = hVar;
        this.c = date;
        this.d = i;
        this.e = j;
        this.f = bVar;
        this.g = str;
        this.h = list;
    }

    public final h a() {
        return this.b;
    }

    public final long b() {
        return this.e;
    }

    public final List c() {
        return this.h;
    }

    public final int d() {
        return this.d;
    }

    public final u e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return AbstractC13042fc3.d(this.a, cVar.a) && AbstractC13042fc3.d(this.b, cVar.b) && AbstractC13042fc3.d(this.c, cVar.c) && this.d == cVar.d && this.e == cVar.e && this.f == cVar.f && AbstractC13042fc3.d(this.g, cVar.g) && AbstractC13042fc3.d(this.h, cVar.h);
    }

    public final C3160o3.b f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final Date h() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31;
        String str = this.g;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "LastSegmentData(recorderConfig=" + this.a + ", cache=" + this.b + ", timestamp=" + this.c + ", id=" + this.d + ", duration=" + this.e + ", replayType=" + this.f + ", screenAtStart=" + this.g + ", events=" + this.h + ')';
    }
}
