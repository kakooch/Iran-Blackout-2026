package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.yG6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24234yG6 {
    private AbstractC13463gG6 a;
    private final C19391qG6 b;

    public C24234yG6(AbstractC13463gG6 abstractC13463gG6, C19391qG6 c19391qG6) {
        AbstractC13042fc3.i(abstractC13463gG6, "snakeBarStyle");
        AbstractC13042fc3.i(c19391qG6, "hostState");
        this.a = abstractC13463gG6;
        this.b = c19391qG6;
    }

    public final C19391qG6 a() {
        return this.b;
    }

    public final AbstractC13463gG6 b() {
        return this.a;
    }

    public final void c(AbstractC13463gG6 abstractC13463gG6) {
        AbstractC13042fc3.i(abstractC13463gG6, "<set-?>");
        this.a = abstractC13463gG6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24234yG6)) {
            return false;
        }
        C24234yG6 c24234yG6 = (C24234yG6) obj;
        return AbstractC13042fc3.d(this.a, c24234yG6.a) && AbstractC13042fc3.d(this.b, c24234yG6.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SnakeBarStyle(snakeBarStyle=" + this.a + ", hostState=" + this.b + Separators.RPAREN;
    }
}
