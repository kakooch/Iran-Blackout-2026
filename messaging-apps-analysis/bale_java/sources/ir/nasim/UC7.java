package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class UC7 extends AbstractC20556sC7 {
    private final int a;
    private final String b;
    private final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UC7(int i, String str, String str2) {
        super(null);
        AbstractC13042fc3.i(str, "channelNativeAdTagId");
        AbstractC13042fc3.i(str2, "channelBannerAdTagId");
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UC7)) {
            return false;
        }
        UC7 uc7 = (UC7) obj;
        return this.a == uc7.a && AbstractC13042fc3.d(this.b, uc7.b) && AbstractC13042fc3.d(this.c, uc7.c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "UpdateChannelAdTagIdChanged(groupId=" + this.a + ", channelNativeAdTagId=" + this.b + ", channelBannerAdTagId=" + this.c + Separators.RPAREN;
    }
}
