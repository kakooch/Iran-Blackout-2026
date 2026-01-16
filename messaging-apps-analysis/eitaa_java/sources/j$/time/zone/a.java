package j$.time.zone;

import j$.time.f;
import j$.time.h;
import j$.time.m;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class a implements Comparable<a>, Serializable {
    private final h a;
    private final m b;
    private final m c;

    a(long j, m mVar, m mVar2) {
        this.a = h.A(j, 0, mVar);
        this.b = mVar;
        this.c = mVar2;
    }

    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        return h().t(aVar.h());
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

    public f h() {
        return f.z(this.a.B(this.b), r0.b().x());
    }

    public int hashCode() {
        return (this.a.hashCode() ^ this.b.hashCode()) ^ Integer.rotateLeft(this.c.hashCode(), 16);
    }

    public m j() {
        return this.c;
    }

    public m l() {
        return this.b;
    }

    public String toString() {
        StringBuilder sbA = j$.com.android.tools.r8.a.a("Transition[");
        sbA.append(this.c.y() > this.b.y() ? "Gap" : "Overlap");
        sbA.append(" at ");
        sbA.append(this.a);
        sbA.append(this.b);
        sbA.append(" to ");
        sbA.append(this.c);
        sbA.append(']');
        return sbA.toString();
    }

    public long u() {
        return j$.time.a.l(this.a, this.b);
    }
}
