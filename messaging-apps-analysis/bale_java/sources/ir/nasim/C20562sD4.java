package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.sD4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20562sD4 implements CD4 {
    public static final C20562sD4 a = new C20562sD4();

    private C20562sD4() {
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        return new DD4(context.getString(AbstractC12217eE5.crowd_funding_notification_text), null, null, 6, null);
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof C20562sD4);
    }

    public int hashCode() {
        return -1945407461;
    }

    public String toString() {
        return "NotificationCrowdFundingMessageType";
    }
}
