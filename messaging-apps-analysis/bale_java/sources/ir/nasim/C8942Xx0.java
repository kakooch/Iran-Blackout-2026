package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Xx0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8942Xx0 {
    public static final int e = 0;
    private final int a;
    private final String b;
    private final Avatar c;
    private final boolean d;

    public C8942Xx0(int i, String str, Avatar avatar, boolean z) {
        AbstractC13042fc3.i(str, "name");
        this.a = i;
        this.b = str;
        this.c = avatar;
        this.d = z;
    }

    public final Avatar a() {
        return this.c;
    }

    public final int b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8942Xx0)) {
            return false;
        }
        C8942Xx0 c8942Xx0 = (C8942Xx0) obj;
        return this.a == c8942Xx0.a && AbstractC13042fc3.d(this.b, c8942Xx0.b) && AbstractC13042fc3.d(this.c, c8942Xx0.c) && this.d == c8942Xx0.d;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Avatar avatar = this.c;
        return ((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "CallPeer(id=" + this.a + ", isGroupCall=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ C8942Xx0(int i, String str, Avatar avatar, boolean z, int i2, ED1 ed1) {
        this(i, str, avatar, (i2 & 8) != 0 ? false : z);
    }
}
