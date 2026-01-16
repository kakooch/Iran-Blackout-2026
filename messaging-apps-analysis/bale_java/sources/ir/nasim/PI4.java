package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* loaded from: classes5.dex */
public final class PI4 {
    private final int a;
    private final long b;
    private final Avatar c;
    private final boolean d;
    private final String e;

    public PI4(int i, long j, Avatar avatar, boolean z, String str) {
        AbstractC13042fc3.i(str, "name");
        this.a = i;
        this.b = j;
        this.c = avatar;
        this.d = z;
        this.e = str;
    }

    public final Avatar a() {
        return this.c;
    }

    public final boolean b() {
        return this.d;
    }

    public final String c() {
        return this.e;
    }

    public final int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PI4)) {
            return false;
        }
        PI4 pi4 = (PI4) obj;
        return this.a == pi4.a && this.b == pi4.b && AbstractC13042fc3.d(this.c, pi4.c) && this.d == pi4.d && AbstractC13042fc3.d(this.e, pi4.e);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31;
        Avatar avatar = this.c;
        return ((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "OnBoardingModel(peerId=" + this.a + ", lastSeen=" + this.b + ", avatar=" + this.c + ", hasStory=" + this.d + ", name=" + this.e + Separators.RPAREN;
    }
}
