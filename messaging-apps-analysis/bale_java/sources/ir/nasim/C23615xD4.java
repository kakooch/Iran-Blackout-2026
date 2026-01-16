package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* renamed from: ir.nasim.xD4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23615xD4 implements CD4 {
    public static final C23615xD4 a = new C23615xD4();

    private C23615xD4() {
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        return new DD4(context.getString(AbstractC12217eE5.contact_notification_text), null, null, 6, null);
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof C23615xD4);
    }

    public int hashCode() {
        return 524612821;
    }

    public String toString() {
        return SIPHeaderNames.CONTACT;
    }
}
