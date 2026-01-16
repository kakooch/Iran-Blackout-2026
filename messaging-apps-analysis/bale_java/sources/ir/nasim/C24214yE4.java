package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.yE4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24214yE4 implements CD4 {
    private final String a;

    public C24214yE4(String str) {
        this.a = str;
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        String str2 = this.a;
        if (str2 != null && !AbstractC20762sZ6.n0(str2)) {
            str = str2;
        }
        DD4 dd4 = new DD4(null, null, null, 7, null);
        if (H15.h.matcher(str).find()) {
            str = context.getString(AbstractC12217eE5.link_notification_text, str);
        }
        dd4.f(str);
        return dd4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C24214yE4) && AbstractC13042fc3.d(this.a, ((C24214yE4) obj).a);
    }

    public int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "NotificationTextMessageType(text=" + this.a + Separators.RPAREN;
    }
}
