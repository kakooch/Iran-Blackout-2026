package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class KF7 extends AbstractC20556sC7 {
    private final C11458d25 a;
    private final int b;
    private final EnumC5360Iz7 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KF7(C11458d25 c11458d25, int i, EnumC5360Iz7 enumC5360Iz7) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(enumC5360Iz7, "typingType");
        this.a = c11458d25;
        this.b = i;
        this.c = enumC5360Iz7;
    }

    public final C11458d25 a() {
        return this.a;
    }

    public final EnumC5360Iz7 b() {
        return this.c;
    }

    public final int c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KF7)) {
            return false;
        }
        KF7 kf7 = (KF7) obj;
        return AbstractC13042fc3.d(this.a, kf7.a) && this.b == kf7.b && this.c == kf7.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "UpdateTypingStop(peer=" + this.a + ", uid=" + this.b + ", typingType=" + this.c + Separators.RPAREN;
    }
}
