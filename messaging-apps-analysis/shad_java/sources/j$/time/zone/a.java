package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class a implements Comparable, Serializable {
    private final LocalDateTime a;
    private final ZoneOffset b;
    private final ZoneOffset c;

    a(long j, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.a = LocalDateTime.l(j, 0, zoneOffset);
        this.b = zoneOffset;
        this.c = zoneOffset2;
    }

    public Instant a() {
        return Instant.k(this.a.m(this.b), r0.p().h());
    }

    public ZoneOffset b() {
        return this.c;
    }

    public ZoneOffset c() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return a().f(((a) obj).a());
    }

    public long d() {
        return this.a.m(this.b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && this.b.equals(aVar.b) && this.c.equals(aVar.c);
    }

    public int hashCode() {
        return (this.a.hashCode() ^ this.b.hashCode()) ^ Integer.rotateLeft(this.c.hashCode(), 16);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transition[");
        sb.append(this.c.k() > this.b.k() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.a);
        sb.append(this.b);
        sb.append(" to ");
        sb.append(this.c);
        sb.append(']');
        return sb.toString();
    }
}
