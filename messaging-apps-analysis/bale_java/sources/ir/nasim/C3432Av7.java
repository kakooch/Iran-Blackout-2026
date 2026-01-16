package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.Av7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3432Av7 {
    private final C22094uf2 a;
    private final C14638iE6 b;
    private final C15866kJ0 c;
    private final C14865ic6 d;
    private final boolean e;
    private final Map f;

    public C3432Av7(C22094uf2 c22094uf2, C14638iE6 c14638iE6, C15866kJ0 c15866kJ0, C14865ic6 c14865ic6, boolean z, Map map) {
        this.a = c22094uf2;
        this.b = c14638iE6;
        this.c = c15866kJ0;
        this.d = c14865ic6;
        this.e = z;
        this.f = map;
    }

    public final C15866kJ0 a() {
        return this.c;
    }

    public final Map b() {
        return this.f;
    }

    public final C22094uf2 c() {
        return this.a;
    }

    public final boolean d() {
        return this.e;
    }

    public final C14865ic6 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3432Av7)) {
            return false;
        }
        C3432Av7 c3432Av7 = (C3432Av7) obj;
        return AbstractC13042fc3.d(this.a, c3432Av7.a) && AbstractC13042fc3.d(this.b, c3432Av7.b) && AbstractC13042fc3.d(this.c, c3432Av7.c) && AbstractC13042fc3.d(this.d, c3432Av7.d) && this.e == c3432Av7.e && AbstractC13042fc3.d(this.f, c3432Av7.f);
    }

    public final C14638iE6 f() {
        return this.b;
    }

    public int hashCode() {
        C22094uf2 c22094uf2 = this.a;
        int iHashCode = (c22094uf2 == null ? 0 : c22094uf2.hashCode()) * 31;
        C14638iE6 c14638iE6 = this.b;
        int iHashCode2 = (iHashCode + (c14638iE6 == null ? 0 : c14638iE6.hashCode())) * 31;
        C15866kJ0 c15866kJ0 = this.c;
        int iHashCode3 = (iHashCode2 + (c15866kJ0 == null ? 0 : c15866kJ0.hashCode())) * 31;
        C14865ic6 c14865ic6 = this.d;
        return ((((iHashCode3 + (c14865ic6 != null ? c14865ic6.hashCode() : 0)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "TransitionData(fade=" + this.a + ", slide=" + this.b + ", changeSize=" + this.c + ", scale=" + this.d + ", hold=" + this.e + ", effectsMap=" + this.f + ')';
    }

    public /* synthetic */ C3432Av7(C22094uf2 c22094uf2, C14638iE6 c14638iE6, C15866kJ0 c15866kJ0, C14865ic6 c14865ic6, boolean z, Map map, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : c22094uf2, (i & 2) != 0 ? null : c14638iE6, (i & 4) != 0 ? null : c15866kJ0, (i & 8) == 0 ? c14865ic6 : null, (i & 16) != 0 ? false : z, (i & 32) != 0 ? AbstractC20051rO3.k() : map);
    }
}
