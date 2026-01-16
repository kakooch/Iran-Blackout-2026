package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.Q37;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.fl4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13160fl4 {
    private final C14952il4 a;
    private final UU b;
    private final Avatar c;

    public C13160fl4(C14952il4 c14952il4, UU uu, Avatar avatar) {
        AbstractC13042fc3.i(c14952il4, "userState");
        AbstractC13042fc3.i(uu, "avatarUiState");
        AbstractC13042fc3.i(avatar, "avatar");
        this.a = c14952il4;
        this.b = uu;
        this.c = avatar;
    }

    public final Avatar a() {
        return this.c;
    }

    public final UU b() {
        return this.b;
    }

    public final C14952il4 c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13160fl4)) {
            return false;
        }
        C13160fl4 c13160fl4 = (C13160fl4) obj;
        return AbstractC13042fc3.d(this.a, c13160fl4.a) && AbstractC13042fc3.d(this.b, c13160fl4.b) && AbstractC13042fc3.d(this.c, c13160fl4.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "MultiAccountBottomSheetListItemState(userState=" + this.a + ", avatarUiState=" + this.b + ", avatar=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C13160fl4(C14952il4 c14952il4, UU uu, Avatar avatar, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C14952il4(1, "aaa", "aaaa") : c14952il4, (i & 2) != 0 ? new UU(false, null, null, Q37.b.a, null, 0, false, 119, null) : uu, (i & 4) != 0 ? new Avatar() : avatar);
    }
}
