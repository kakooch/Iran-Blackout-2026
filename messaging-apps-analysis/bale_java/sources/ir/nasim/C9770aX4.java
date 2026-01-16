package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;
import java.util.List;

/* renamed from: ir.nasim.aX4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9770aX4 {
    private final String a;
    private final Avatar b;
    private final List c;

    public C9770aX4(String str, Avatar avatar, List list) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(list, "userOptions");
        this.a = str;
        this.b = avatar;
        this.c = list;
    }

    public final Avatar a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final List c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9770aX4)) {
            return false;
        }
        C9770aX4 c9770aX4 = (C9770aX4) obj;
        return AbstractC13042fc3.d(this.a, c9770aX4.a) && AbstractC13042fc3.d(this.b, c9770aX4.b) && AbstractC13042fc3.d(this.c, c9770aX4.c);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Avatar avatar = this.b;
        return ((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ParticipantItemData(name=" + this.a + ", avatar=" + this.b + ", userOptions=" + this.c + Separators.RPAREN;
    }
}
