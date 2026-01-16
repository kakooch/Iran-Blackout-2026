package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.uE4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21848uE4 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final boolean h;

    public C21848uE4(boolean z, boolean z2, boolean z3, boolean z4, String str, boolean z5, boolean z6, boolean z7) {
        AbstractC13042fc3.i(str, "notificationSound");
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = str;
        this.f = z5;
        this.g = z6;
        this.h = z7;
    }

    public final C21848uE4 a(boolean z, boolean z2, boolean z3, boolean z4, String str, boolean z5, boolean z6, boolean z7) {
        AbstractC13042fc3.i(str, "notificationSound");
        return new C21848uE4(z, z2, z3, z4, str, z5, z6, z7);
    }

    public final String c() {
        return this.e;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21848uE4)) {
            return false;
        }
        C21848uE4 c21848uE4 = (C21848uE4) obj;
        return this.a == c21848uE4.a && this.b == c21848uE4.b && this.c == c21848uE4.c && this.d == c21848uE4.d && AbstractC13042fc3.d(this.e, c21848uE4.e) && this.f == c21848uE4.f && this.g == c21848uE4.g && this.h == c21848uE4.h;
    }

    public final boolean f() {
        return this.h;
    }

    public final boolean g() {
        return this.c;
    }

    public final boolean h() {
        return this.a;
    }

    public int hashCode() {
        return (((((((((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h);
    }

    public final boolean i() {
        return this.g;
    }

    public final boolean j() {
        return this.f;
    }

    public String toString() {
        return "NotificationSettingUiState(isPrivateNotificationEnabled=" + this.a + ", isGroupOrChannelNotificationsEnabled=" + this.b + ", isLikeStoryNotificationEnabled=" + this.c + ", isContactStoryNotificationState=" + this.d + ", notificationSound=" + this.e + ", isShowNotificationsText=" + this.f + ", isScreenLightEnabled=" + this.g + ", isLEDLightEnabled=" + this.h + Separators.RPAREN;
    }

    public /* synthetic */ C21848uE4(boolean z, boolean z2, boolean z3, boolean z4, String str, boolean z5, boolean z6, boolean z7, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? "" : str, (i & 32) != 0 ? false : z5, (i & 64) != 0 ? false : z6, (i & 128) == 0 ? z7 : false);
    }
}
