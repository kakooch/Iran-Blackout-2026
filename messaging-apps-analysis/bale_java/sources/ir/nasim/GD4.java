package ir.nasim;

import android.content.Context;

/* loaded from: classes5.dex */
public final class GD4 implements CD4 {
    public static final GD4 a = new GD4();

    private GD4() {
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        return new DD4(context.getString(AbstractC12217eE5.money_request_payment_notification_text), null, null, 6, null);
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof GD4);
    }

    public int hashCode() {
        return 2090444042;
    }

    public String toString() {
        return "NotificationPurchaseMessageType";
    }
}
