package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Lk4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5924Lk4 {
    private final int a;
    private final String b;
    private final String c;
    private final Avatar d;
    private final boolean e;

    public C5924Lk4(int i, String str, String str2, Avatar avatar, boolean z) {
        AbstractC13042fc3.i(str, "userText");
        AbstractC13042fc3.i(str2, "userName");
        AbstractC13042fc3.i(avatar, "avatar");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = avatar;
        this.e = z;
    }

    public final Avatar a() {
        return this.d;
    }

    public final int b() {
        return this.a;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5924Lk4)) {
            return false;
        }
        C5924Lk4 c5924Lk4 = (C5924Lk4) obj;
        return this.a == c5924Lk4.a && AbstractC13042fc3.d(this.b, c5924Lk4.b) && AbstractC13042fc3.d(this.c, c5924Lk4.c) && AbstractC13042fc3.d(this.d, c5924Lk4.d) && this.e == c5924Lk4.e;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "MultiAccountBottomSheetItemState(userId=" + this.a + ", userText=" + this.b + ", userName=" + this.c + ", avatar=" + this.d + ", isSelected=" + this.e + Separators.RPAREN;
    }
}
