package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class WC7 extends AbstractC20556sC7 {
    private final int a;
    private final EnumC6364Nh b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WC7(int i, EnumC6364Nh enumC6364Nh) {
        super(null);
        AbstractC13042fc3.i(enumC6364Nh, "advertisementType");
        this.a = i;
        this.b = enumC6364Nh;
    }

    public final EnumC6364Nh a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WC7)) {
            return false;
        }
        WC7 wc7 = (WC7) obj;
        return this.a == wc7.a && this.b == wc7.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateChannelAdvertisementTypeChanged(groupId=" + this.a + ", advertisementType=" + this.b + Separators.RPAREN;
    }
}
