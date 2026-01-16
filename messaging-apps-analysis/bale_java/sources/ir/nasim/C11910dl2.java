package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.market.model.SearchSuggestion;

/* renamed from: ir.nasim.dl2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11910dl2 {
    private final EnumC9082Yk2 a;
    private final NN6 b;

    public C11910dl2(EnumC9082Yk2 enumC9082Yk2, NN6 nn6) {
        AbstractC13042fc3.i(enumC9082Yk2, SearchSuggestion.CATEGORY_ICON);
        AbstractC13042fc3.i(nn6, "location");
        this.a = enumC9082Yk2;
        this.b = nn6;
    }

    public final EnumC9082Yk2 a() {
        return this.a;
    }

    public final NN6 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11910dl2)) {
            return false;
        }
        C11910dl2 c11910dl2 = (C11910dl2) obj;
        return this.a == c11910dl2.a && this.b == c11910dl2.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FileDescriptor(category=" + this.a + ", location=" + this.b + Separators.RPAREN;
    }
}
