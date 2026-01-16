package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.vD4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22429vD4 implements CD4 {
    public static final C22429vD4 a = new C22429vD4();

    private C22429vD4() {
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        return new DD4(context.getString(AbstractC12217eE5.gift_packet_notification_text), null, null, 6, null);
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof C22429vD4);
    }

    public int hashCode() {
        return 1706399240;
    }

    public String toString() {
        return "NotificationGiftPacketType";
    }
}
