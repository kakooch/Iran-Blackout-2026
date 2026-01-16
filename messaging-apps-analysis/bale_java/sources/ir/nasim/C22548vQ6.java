package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.vQ6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22548vQ6 {
    private int a;
    private final int b;
    private final int c;
    private InterfaceC10294bP6 d;

    public C22548vQ6(int i, int i2, int i3, InterfaceC10294bP6 interfaceC10294bP6) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = interfaceC10294bP6;
    }

    public final int a() {
        return this.b;
    }

    public final InterfaceC10294bP6 b() {
        return this.d;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public final void e(InterfaceC10294bP6 interfaceC10294bP6) {
        this.d = interfaceC10294bP6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22548vQ6)) {
            return false;
        }
        C22548vQ6 c22548vQ6 = (C22548vQ6) obj;
        return this.a == c22548vQ6.a && this.b == c22548vQ6.b && this.c == c22548vQ6.c && AbstractC13042fc3.d(this.d, c22548vQ6.d);
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31;
        InterfaceC10294bP6 interfaceC10294bP6 = this.d;
        return iHashCode + (interfaceC10294bP6 == null ? 0 : interfaceC10294bP6.hashCode());
    }

    public String toString() {
        return "StoryEventData(randomSessionId=" + this.a + ", actionType=" + this.b + ", peerId=" + this.c + ", currentSessionEvent=" + this.d + Separators.RPAREN;
    }
}
