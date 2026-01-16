package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.text.Spannable;
import ir.nasim.core.modules.profile.entity.Avatar;
import java.util.List;

/* renamed from: ir.nasim.ef1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12461ef1 {
    private final Spannable a;
    private final Spannable b;
    private final List c;
    private final List d;
    private final C11458d25 e;
    private final int f;
    private final boolean g;
    private final boolean h;
    private final Avatar i;

    public C12461ef1(Spannable spannable, Spannable spannable2, List list, List list2, C11458d25 c11458d25, int i, boolean z, boolean z2, Avatar avatar) {
        AbstractC13042fc3.i(spannable, "name");
        AbstractC13042fc3.i(spannable2, ParameterNames.INFO);
        AbstractC13042fc3.i(list, "phones");
        AbstractC13042fc3.i(list2, "emails");
        this.a = spannable;
        this.b = spannable2;
        this.c = list;
        this.d = list2;
        this.e = c11458d25;
        this.f = i;
        this.g = z;
        this.h = z2;
        this.i = avatar;
    }

    public final Avatar a() {
        return this.i;
    }

    public final int b() {
        return this.f;
    }

    public final List c() {
        return this.d;
    }

    public final Spannable d() {
        return this.b;
    }

    public final Spannable e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12461ef1)) {
            return false;
        }
        C12461ef1 c12461ef1 = (C12461ef1) obj;
        return AbstractC13042fc3.d(this.a, c12461ef1.a) && AbstractC13042fc3.d(this.b, c12461ef1.b) && AbstractC13042fc3.d(this.c, c12461ef1.c) && AbstractC13042fc3.d(this.d, c12461ef1.d) && AbstractC13042fc3.d(this.e, c12461ef1.e) && this.f == c12461ef1.f && this.g == c12461ef1.g && this.h == c12461ef1.h && AbstractC13042fc3.d(this.i, c12461ef1.i);
    }

    public final List f() {
        return this.c;
    }

    public final boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        C11458d25 c11458d25 = this.e;
        int iHashCode2 = (((((((iHashCode + (c11458d25 == null ? 0 : c11458d25.hashCode())) * 31) + Integer.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31;
        Avatar avatar = this.i;
        return iHashCode2 + (avatar != null ? avatar.hashCode() : 0);
    }

    public String toString() {
        Spannable spannable = this.a;
        Spannable spannable2 = this.b;
        return "ContactInfo(name=" + ((Object) spannable) + ", info=" + ((Object) spannable2) + ", phones=" + this.c + ", emails=" + this.d + ", peer=" + this.e + ", contactUId=" + this.f + ", isMe=" + this.g + ", isMyContact=" + this.h + ", avatar=" + this.i + Separators.RPAREN;
    }
}
