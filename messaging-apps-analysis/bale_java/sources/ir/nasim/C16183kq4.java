package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.kq4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C16183kq4 {
    private final UA2 a;
    private final UA2 b;
    private final UA2 c;
    private final UA2 d;
    private final SA2 e;
    private final UA2 f;
    private final UA2 g;
    private final UA2 h;
    private final SA2 i;

    public C16183kq4(UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, SA2 sa2, UA2 ua25, UA2 ua26, UA2 ua27, SA2 sa22) {
        AbstractC13042fc3.i(ua2, "onPrivateNotificationChanged");
        AbstractC13042fc3.i(ua22, "onGroupOrChannelNotificationChanged");
        AbstractC13042fc3.i(ua23, "onLikeStoryNotificationChanged");
        AbstractC13042fc3.i(ua24, "onNewStoryNotificationChanged");
        AbstractC13042fc3.i(sa2, "navigateToChangedNotificationSound");
        AbstractC13042fc3.i(ua25, "onDisplayTitleInNotificationChanged");
        AbstractC13042fc3.i(ua26, "onTurnOnDisplayNotificationChanged");
        AbstractC13042fc3.i(ua27, "onTurnOnLedInNotificationChanged");
        AbstractC13042fc3.i(sa22, "navigateToFullScreenSetting");
        this.a = ua2;
        this.b = ua22;
        this.c = ua23;
        this.d = ua24;
        this.e = sa2;
        this.f = ua25;
        this.g = ua26;
        this.h = ua27;
        this.i = sa22;
    }

    public final SA2 a() {
        return this.e;
    }

    public final SA2 b() {
        return this.i;
    }

    public final UA2 c() {
        return this.f;
    }

    public final UA2 d() {
        return this.b;
    }

    public final UA2 e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16183kq4)) {
            return false;
        }
        C16183kq4 c16183kq4 = (C16183kq4) obj;
        return AbstractC13042fc3.d(this.a, c16183kq4.a) && AbstractC13042fc3.d(this.b, c16183kq4.b) && AbstractC13042fc3.d(this.c, c16183kq4.c) && AbstractC13042fc3.d(this.d, c16183kq4.d) && AbstractC13042fc3.d(this.e, c16183kq4.e) && AbstractC13042fc3.d(this.f, c16183kq4.f) && AbstractC13042fc3.d(this.g, c16183kq4.g) && AbstractC13042fc3.d(this.h, c16183kq4.h) && AbstractC13042fc3.d(this.i, c16183kq4.i);
    }

    public final UA2 f() {
        return this.d;
    }

    public final UA2 g() {
        return this.a;
    }

    public final UA2 h() {
        return this.g;
    }

    public int hashCode() {
        return (((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public final UA2 i() {
        return this.h;
    }

    public String toString() {
        return "NavigationSettingCallback(onPrivateNotificationChanged=" + this.a + ", onGroupOrChannelNotificationChanged=" + this.b + ", onLikeStoryNotificationChanged=" + this.c + ", onNewStoryNotificationChanged=" + this.d + ", navigateToChangedNotificationSound=" + this.e + ", onDisplayTitleInNotificationChanged=" + this.f + ", onTurnOnDisplayNotificationChanged=" + this.g + ", onTurnOnLedInNotificationChanged=" + this.h + ", navigateToFullScreenSetting=" + this.i + Separators.RPAREN;
    }
}
