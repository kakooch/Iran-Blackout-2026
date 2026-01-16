package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.tZ1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21377tZ1 implements InterfaceC15283jK {
    private final C11458d25 a;
    private final long b;
    private final String c;

    public C21377tZ1(C11458d25 c11458d25, long j, String str) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_DRAFT);
        this.a = c11458d25;
        this.b = j;
        this.c = str;
    }

    public final String a() {
        return this.c;
    }

    public final long b() {
        return this.b;
    }

    public final C11458d25 c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21377tZ1)) {
            return false;
        }
        C21377tZ1 c21377tZ1 = (C21377tZ1) obj;
        return AbstractC13042fc3.d(this.a, c21377tZ1.a) && this.b == c21377tZ1.b && AbstractC13042fc3.d(this.c, c21377tZ1.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DraftChange(peer=" + this.a + ", draftDate=" + this.b + ", draft=" + this.c + Separators.RPAREN;
    }
}
