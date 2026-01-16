package ir.nasim;

import android.content.Context;

/* loaded from: classes5.dex */
public final class FD4 implements CD4 {
    public static final FD4 a = new FD4();

    private FD4() {
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        return new DD4(context.getString(AbstractC12217eE5.poll_notification), null, null, 6, null);
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof FD4);
    }

    public int hashCode() {
        return -884304756;
    }

    public String toString() {
        return "NotificationPollMessageType";
    }
}
