package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.eE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12219eE7 extends AbstractC20556sC7 {
    private final int a;
    private final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12219eE7(int i, List list) {
        super(null);
        AbstractC13042fc3.i(list, "members");
        this.a = i;
        this.b = list;
    }

    public final int a() {
        return this.a;
    }

    public final List b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12219eE7)) {
            return false;
        }
        C12219eE7 c12219eE7 = (C12219eE7) obj;
        return this.a == c12219eE7.a && AbstractC13042fc3.d(this.b, c12219eE7.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateGroupMembersUpdateObsolete(groupId=" + this.a + ", members=" + this.b + Separators.RPAREN;
    }
}
