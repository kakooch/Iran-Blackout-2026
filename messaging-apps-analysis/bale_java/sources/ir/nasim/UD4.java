package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class UD4 implements CD4 {
    private final boolean a;

    public UD4(boolean z) {
        this.a = z;
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        DD4 dd4 = new DD4(null, null, null, 7, null);
        dd4.f(this.a ? context.getString(AbstractC12217eE5.video_call_notification_text) : context.getString(AbstractC12217eE5.call_notification_text));
        return dd4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UD4) && this.a == ((UD4) obj).a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public String toString() {
        return "ExPhoneCall(isVideo=" + this.a + Separators.RPAREN;
    }
}
