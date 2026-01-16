package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.fh5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13121fh5 {
    private final long a;
    private final EnumC9058Yh5 b;
    private final boolean c;
    private final List d;
    private final String e;
    private final C16885m18 f;
    private final List g;

    public C13121fh5(long j, EnumC9058Yh5 enumC9058Yh5, boolean z, List list, String str, C16885m18 c16885m18, List list2) {
        AbstractC13042fc3.i(enumC9058Yh5, "pollType");
        AbstractC13042fc3.i(list, "options");
        AbstractC13042fc3.i(str, "question");
        this.a = j;
        this.b = enumC9058Yh5;
        this.c = z;
        this.d = list;
        this.e = str;
        this.f = c16885m18;
        this.g = list2;
    }

    public final List a() {
        return this.d;
    }

    public final long b() {
        return this.a;
    }

    public final C16885m18 c() {
        return this.f;
    }

    public final EnumC9058Yh5 d() {
        return this.b;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13121fh5)) {
            return false;
        }
        C13121fh5 c13121fh5 = (C13121fh5) obj;
        return this.a == c13121fh5.a && this.b == c13121fh5.b && this.c == c13121fh5.c && AbstractC13042fc3.d(this.d, c13121fh5.d) && AbstractC13042fc3.d(this.e, c13121fh5.e) && AbstractC13042fc3.d(this.f, c13121fh5.f) && AbstractC13042fc3.d(this.g, c13121fh5.g);
    }

    public final List f() {
        return this.g;
    }

    public final boolean g() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        C16885m18 c16885m18 = this.f;
        int iHashCode2 = (iHashCode + (c16885m18 == null ? 0 : c16885m18.hashCode())) * 31;
        List list = this.g;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "Poll(pollId=" + this.a + ", pollType=" + this.b + ", isAnonymous=" + this.c + ", options=" + this.d + ", question=" + this.e + ", pollResult=" + this.f + ", recentVotersAvatar=" + this.g + Separators.RPAREN;
    }

    public /* synthetic */ C13121fh5(long j, EnumC9058Yh5 enumC9058Yh5, boolean z, List list, String str, C16885m18 c16885m18, List list2, int i, ED1 ed1) {
        this(j, enumC9058Yh5, z, list, str, (i & 32) != 0 ? null : c16885m18, (i & 64) != 0 ? null : list2);
    }
}
