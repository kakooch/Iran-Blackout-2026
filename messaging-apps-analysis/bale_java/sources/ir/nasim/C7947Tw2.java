package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Tw2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7947Tw2 {
    public static final int f = 0;
    private final String a;
    private final String b;
    private final Avatar c;
    private final int d;
    private final ExPeerType e;

    public C7947Tw2(String str, String str2, Avatar avatar, int i, ExPeerType exPeerType) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        this.a = str;
        this.b = str2;
        this.c = avatar;
        this.d = i;
        this.e = exPeerType;
    }

    public final Avatar a() {
        return this.c;
    }

    public final ExPeerType b() {
        return this.e;
    }

    public final int c() {
        return this.d;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7947Tw2)) {
            return false;
        }
        C7947Tw2 c7947Tw2 = (C7947Tw2) obj;
        return AbstractC13042fc3.d(this.a, c7947Tw2.a) && AbstractC13042fc3.d(this.b, c7947Tw2.b) && AbstractC13042fc3.d(this.c, c7947Tw2.c) && this.d == c7947Tw2.d && this.e == c7947Tw2.e;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Avatar avatar = this.c;
        return ((((iHashCode2 + (avatar != null ? avatar.hashCode() : 0)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "ForwardPeer(name=" + this.a + ", userName=" + this.b + ", avatar=" + this.c + ", id=" + this.d + ", exPeerType=" + this.e + Separators.RPAREN;
    }
}
