package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.Spannable;

/* renamed from: ir.nasim.qI2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19405qI2 {
    private final Spannable a;
    private final boolean b;

    public C19405qI2(Spannable spannable, boolean z) {
        this.a = spannable;
        this.b = z;
    }

    public final Spannable a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19405qI2)) {
            return false;
        }
        C19405qI2 c19405qI2 = (C19405qI2) obj;
        return AbstractC13042fc3.d(this.a, c19405qI2.a) && this.b == c19405qI2.b;
    }

    public int hashCode() {
        Spannable spannable = this.a;
        return ((spannable == null ? 0 : spannable.hashCode()) * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        Spannable spannable = this.a;
        return "GiftPacket(senderName=" + ((Object) spannable) + ", isGold=" + this.b + Separators.RPAREN;
    }
}
