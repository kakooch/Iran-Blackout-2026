package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class CE7 extends AbstractC20556sC7 {
    private final int a;
    private final C11458d25 b;
    private final long c;
    private final long d;
    private final AbstractC24063xz e;
    private final C21088t54 f;
    private final C16975mB g;
    private final C3460Az h;
    private final Long i;
    private final boolean j;
    private final boolean k;
    private final C7880To7 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CE7(int i, C11458d25 c11458d25, long j, long j2, AbstractC24063xz abstractC24063xz, C21088t54 c21088t54, C16975mB c16975mB, C3460Az c3460Az, Long l, boolean z, boolean z2, C7880To7 c7880To7) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = i;
        this.b = c11458d25;
        this.c = j;
        this.d = j2;
        this.e = abstractC24063xz;
        this.f = c21088t54;
        this.g = c16975mB;
        this.h = c3460Az;
        this.i = l;
        this.j = z;
        this.k = z2;
        this.l = c7880To7;
    }

    public final long a() {
        return this.d;
    }

    public final Long b() {
        return this.i;
    }

    public final boolean c() {
        return this.k;
    }

    public final AbstractC24063xz d() {
        return this.e;
    }

    public final C11458d25 e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CE7)) {
            return false;
        }
        CE7 ce7 = (CE7) obj;
        return this.a == ce7.a && AbstractC13042fc3.d(this.b, ce7.b) && this.c == ce7.c && this.d == ce7.d && AbstractC13042fc3.d(this.e, ce7.e) && AbstractC13042fc3.d(this.f, ce7.f) && AbstractC13042fc3.d(this.g, ce7.g) && AbstractC13042fc3.d(this.h, ce7.h) && AbstractC13042fc3.d(this.i, ce7.i) && this.j == ce7.j && this.k == ce7.k && AbstractC13042fc3.d(this.l, ce7.l);
    }

    public final C3460Az f() {
        return this.h;
    }

    public final C16975mB g() {
        return this.g;
    }

    public final long h() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31;
        AbstractC24063xz abstractC24063xz = this.e;
        int iHashCode2 = (iHashCode + (abstractC24063xz == null ? 0 : abstractC24063xz.hashCode())) * 31;
        C21088t54 c21088t54 = this.f;
        int iHashCode3 = (iHashCode2 + (c21088t54 == null ? 0 : c21088t54.hashCode())) * 31;
        C16975mB c16975mB = this.g;
        int iHashCode4 = (iHashCode3 + (c16975mB == null ? 0 : c16975mB.hashCode())) * 31;
        C3460Az c3460Az = this.h;
        int iHashCode5 = (iHashCode4 + (c3460Az == null ? 0 : c3460Az.hashCode())) * 31;
        Long l = this.i;
        int iHashCode6 = (((((iHashCode5 + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31;
        C7880To7 c7880To7 = this.l;
        return iHashCode6 + (c7880To7 != null ? c7880To7.hashCode() : 0);
    }

    public final int i() {
        return this.a;
    }

    public final C7880To7 j() {
        return this.l;
    }

    public String toString() {
        return "UpdateMessage(senderUid=" + this.a + ", peer=" + this.b + ", rid=" + this.c + ", date=" + this.d + ", message=" + this.e + ", attributes=" + this.f + ", quotedMessage=" + this.g + ", previousMessageId=" + this.h + ", groupedId=" + this.i + ", isSilent=" + this.j + ", hasComment=" + this.k + ", threadId=" + this.l + Separators.RPAREN;
    }
}
