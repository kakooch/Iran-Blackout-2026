package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class KA7 {
    public static final int d = 8;
    private final EnumC21241tM a;
    private final JA7 b;
    private final AbstractC20029rM c;

    public KA7(EnumC21241tM enumC21241tM, JA7 ja7, AbstractC20029rM abstractC20029rM) {
        AbstractC13042fc3.i(enumC21241tM, "speed");
        AbstractC13042fc3.i(ja7, "content");
        AbstractC13042fc3.i(abstractC20029rM, "playbackState");
        this.a = enumC21241tM;
        this.b = ja7;
        this.c = abstractC20029rM;
    }

    public final JA7 a() {
        return this.b;
    }

    public final AbstractC20029rM b() {
        return this.c;
    }

    public final EnumC21241tM c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KA7)) {
            return false;
        }
        KA7 ka7 = (KA7) obj;
        return this.a == ka7.a && AbstractC13042fc3.d(this.b, ka7.b) && AbstractC13042fc3.d(this.c, ka7.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "UiAudioBarState(speed=" + this.a + ", content=" + this.b + ", playbackState=" + this.c + Separators.RPAREN;
    }
}
