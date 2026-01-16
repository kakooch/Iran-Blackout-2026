package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.xE4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23624xE4 implements CD4 {
    private final C11741dX1 a;

    public C23624xE4(C11741dX1 c11741dX1) {
        this.a = c11741dX1;
    }

    private final void b(C9057Yh4 c9057Yh4, DD4 dd4) {
        C10361bX1 c10361bX1A;
        C11741dX1 c11741dX1 = this.a;
        if (c11741dX1 == null || (c10361bX1A = c11741dX1.a()) == null) {
            return;
        }
        new C4647Fy5(c9057Yh4, new C10977cX1(c10361bX1A, "sticker_" + c10361bX1A.b() + ".webp", "", this.a.b()), "image/webp").a(dd4);
    }

    @Override // ir.nasim.CD4
    public DD4 a(Context context, C9057Yh4 c9057Yh4, long j, ZN2 zn2, boolean z, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        AbstractC13042fc3.i(str, "defaultText");
        String string = context.getString(AbstractC12217eE5.sticker_notification_text);
        AbstractC13042fc3.h(string, "getString(...)");
        DD4 dd4 = new DD4(null, null, null, 7, null);
        if (z) {
            b(c9057Yh4, dd4);
        }
        dd4.f(string);
        return dd4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C23624xE4) && AbstractC13042fc3.d(this.a, ((C23624xE4) obj).a);
    }

    public int hashCode() {
        C11741dX1 c11741dX1 = this.a;
        if (c11741dX1 == null) {
            return 0;
        }
        return c11741dX1.hashCode();
    }

    public String toString() {
        return "NotificationStickerMessageType(imageLocation=" + this.a + Separators.RPAREN;
    }
}
