package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.om, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C18502om {
    private final C12335eR6 a;
    private final List b;
    private final List c;
    private final List d;
    private final List e;

    public C18502om(C12335eR6 c12335eR6, List list, List list2, List list3, List list4) {
        AbstractC13042fc3.i(list, "myChannel");
        AbstractC13042fc3.i(list2, "myBots");
        AbstractC13042fc3.i(list3, "othersNotSeen");
        AbstractC13042fc3.i(list4, "othersSeen");
        this.a = c12335eR6;
        this.b = list;
        this.c = list2;
        this.d = list3;
        this.e = list4;
    }

    public final List a() {
        return AbstractC15401jX0.R0(AbstractC15401jX0.R0(AbstractC15401jX0.R0(AbstractC15401jX0.R0(AbstractC10360bX0.q(this.a), this.b), this.c), this.d), this.e);
    }

    public final List b() {
        return this.c;
    }

    public final List c() {
        return this.b;
    }

    public final C12335eR6 d() {
        return this.a;
    }

    public final List e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18502om)) {
            return false;
        }
        C18502om c18502om = (C18502om) obj;
        return AbstractC13042fc3.d(this.a, c18502om.a) && AbstractC13042fc3.d(this.b, c18502om.b) && AbstractC13042fc3.d(this.c, c18502om.c) && AbstractC13042fc3.d(this.d, c18502om.d) && AbstractC13042fc3.d(this.e, c18502om.e);
    }

    public final List f() {
        return this.e;
    }

    public int hashCode() {
        C12335eR6 c12335eR6 = this.a;
        return ((((((((c12335eR6 == null ? 0 : c12335eR6.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "AllStoriesData(myPersonal=" + this.a + ", myChannel=" + this.b + ", myBots=" + this.c + ", othersNotSeen=" + this.d + ", othersSeen=" + this.e + Separators.RPAREN;
    }
}
