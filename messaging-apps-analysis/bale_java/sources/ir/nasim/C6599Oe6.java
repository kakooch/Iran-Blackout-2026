package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Oe6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6599Oe6 {
    private final C16085kg6 a;
    private final C17267mg6 b;

    public C6599Oe6(C16085kg6 c16085kg6, C17267mg6 c17267mg6) {
        this.a = c16085kg6;
        this.b = c17267mg6;
    }

    public final C16085kg6 a() {
        return this.a;
    }

    public final C17267mg6 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6599Oe6)) {
            return false;
        }
        C6599Oe6 c6599Oe6 = (C6599Oe6) obj;
        return AbstractC13042fc3.d(this.a, c6599Oe6.a) && AbstractC13042fc3.d(this.b, c6599Oe6.b);
    }

    public int hashCode() {
        C16085kg6 c16085kg6 = this.a;
        int iHashCode = (c16085kg6 == null ? 0 : c16085kg6.hashCode()) * 31;
        C17267mg6 c17267mg6 = this.b;
        return iHashCode + (c17267mg6 != null ? c17267mg6.hashCode() : 0);
    }

    public String toString() {
        return "SearchBarFilterItemsBarUiState(selectedDate=" + this.a + ", selectedUser=" + this.b + Separators.RPAREN;
    }
}
