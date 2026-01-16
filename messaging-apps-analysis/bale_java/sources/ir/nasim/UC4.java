package ir.nasim;

import android.content.Context;

/* loaded from: classes5.dex */
public final class UC4 implements CD4 {
    public static final UC4 a = new UC4();

    private UC4() {
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        return new DD4(context.getString(AbstractC12217eE5.sticker_notification_text), null, null, 6, null);
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof UC4);
    }

    public int hashCode() {
        return 1702273341;
    }

    public String toString() {
        return "NotificationAnimatedStickerMessageType";
    }
}
