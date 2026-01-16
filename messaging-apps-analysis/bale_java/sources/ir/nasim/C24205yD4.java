package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.yD4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24205yD4 implements CD4 {
    public static final C24205yD4 a = new C24205yD4();

    private C24205yD4() {
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        return new DD4(context.getString(AbstractC12217eE5.location_notification_text), null, null, 6, null);
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof C24205yD4);
    }

    public int hashCode() {
        return 1551623584;
    }

    public String toString() {
        return "Location";
    }
}
