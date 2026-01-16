package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.hl, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14339hl {
    private final C8967Xz7 a;
    private final AbstractC17757nW1 b;
    private final Boolean c;

    public C14339hl(C8967Xz7 c8967Xz7, AbstractC17757nW1 abstractC17757nW1, Boolean bool) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        this.a = c8967Xz7;
        this.b = abstractC17757nW1;
        this.c = bool;
    }

    public static /* synthetic */ C14339hl b(C14339hl c14339hl, C8967Xz7 c8967Xz7, AbstractC17757nW1 abstractC17757nW1, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            c8967Xz7 = c14339hl.a;
        }
        if ((i & 2) != 0) {
            abstractC17757nW1 = c14339hl.b;
        }
        if ((i & 4) != 0) {
            bool = c14339hl.c;
        }
        return c14339hl.a(c8967Xz7, abstractC17757nW1, bool);
    }

    public final C14339hl a(C8967Xz7 c8967Xz7, AbstractC17757nW1 abstractC17757nW1, Boolean bool) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        return new C14339hl(c8967Xz7, abstractC17757nW1, bool);
    }

    public final AbstractC17757nW1 c() {
        return this.b;
    }

    public final C8967Xz7 d() {
        return this.a;
    }

    public final Boolean e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14339hl)) {
            return false;
        }
        C14339hl c14339hl = (C14339hl) obj;
        return AbstractC13042fc3.d(this.a, c14339hl.a) && AbstractC13042fc3.d(this.b, c14339hl.b) && AbstractC13042fc3.d(this.c, c14339hl.c);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Boolean bool = this.c;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "AlbumData(message=" + this.a + ", document=" + this.b + ", isSelected=" + this.c + Separators.RPAREN;
    }
}
