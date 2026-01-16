package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class RM1 {
    private final long a;
    private final ExPeerType b;
    private final String c;
    private final AbstractC19428qK7 d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final String h;
    private final Avatar i;

    public RM1(long j, ExPeerType exPeerType, String str, AbstractC19428qK7 abstractC19428qK7, boolean z, boolean z2, boolean z3, String str2, Avatar avatar) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(str, "userName");
        AbstractC13042fc3.i(abstractC19428qK7, "userType");
        this.a = j;
        this.b = exPeerType;
        this.c = str;
        this.d = abstractC19428qK7;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = str2;
        this.i = avatar;
    }

    public final RM1 a(long j, ExPeerType exPeerType, String str, AbstractC19428qK7 abstractC19428qK7, boolean z, boolean z2, boolean z3, String str2, Avatar avatar) {
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(str, "userName");
        AbstractC13042fc3.i(abstractC19428qK7, "userType");
        return new RM1(j, exPeerType, str, abstractC19428qK7, z, z2, z3, str2, avatar);
    }

    public final Avatar c() {
        return this.i;
    }

    public final ExPeerType d() {
        return this.b;
    }

    public final String e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RM1)) {
            return false;
        }
        RM1 rm1 = (RM1) obj;
        return this.a == rm1.a && this.b == rm1.b && AbstractC13042fc3.d(this.c, rm1.c) && AbstractC13042fc3.d(this.d, rm1.d) && this.e == rm1.e && this.f == rm1.f && this.g == rm1.g && AbstractC13042fc3.d(this.h, rm1.h) && AbstractC13042fc3.d(this.i, rm1.i);
    }

    public final long f() {
        return this.a;
    }

    public final String g() {
        return this.c;
    }

    public final AbstractC19428qK7 h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31;
        String str = this.h;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Avatar avatar = this.i;
        return iHashCode2 + (avatar != null ? avatar.hashCode() : 0);
    }

    public final boolean i() {
        return this.e;
    }

    public final boolean j() {
        return this.f;
    }

    public String toString() {
        return "DialogFolderDTO(peerUniqueId=" + this.a + ", exPeerType=" + this.b + ", userName=" + this.c + ", userType=" + this.d + ", isSelectableItem=" + this.e + ", isSelected=" + this.f + ", isDeletableItem=" + this.g + ", foldersName=" + this.h + ", avatar=" + this.i + Separators.RPAREN;
    }

    public /* synthetic */ RM1(long j, ExPeerType exPeerType, String str, AbstractC19428qK7 abstractC19428qK7, boolean z, boolean z2, boolean z3, String str2, Avatar avatar, int i, ED1 ed1) {
        this(j, exPeerType, str, abstractC19428qK7, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? false : z3, str2, avatar);
    }
}
