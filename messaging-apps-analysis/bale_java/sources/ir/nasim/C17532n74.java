package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.n74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17532n74 extends AbstractC17902nl0 {
    private int a;
    private List b;
    private C7880To7 c;
    private C7880To7 d;
    private Integer e;
    private Integer f;
    private boolean g;
    private long h;
    private int i;

    public /* synthetic */ C17532n74(int i, List list, C7880To7 c7880To7, C7880To7 c7880To72, Integer num, Integer num2, boolean z, long j, int i2, int i3, ED1 ed1) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : list, (i3 & 4) != 0 ? new C7880To7(0L, 0L, null, 7, null) : c7880To7, (i3 & 8) != 0 ? new C7880To7(0L, 0L, null, 7, null) : c7880To72, (i3 & 16) != 0 ? null : num, (i3 & 32) == 0 ? num2 : null, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? Long.MAX_VALUE : j, (i3 & 256) == 0 ? i2 : 0);
    }

    public final int C() {
        return this.i;
    }

    public final List D() {
        return this.b;
    }

    public final int E() {
        return this.a;
    }

    public final boolean F() {
        return this.c.h() > this.h;
    }

    public final boolean G() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17532n74)) {
            return false;
        }
        C17532n74 c17532n74 = (C17532n74) obj;
        return this.a == c17532n74.a && AbstractC13042fc3.d(this.b, c17532n74.b) && AbstractC13042fc3.d(this.c, c17532n74.c) && AbstractC13042fc3.d(this.d, c17532n74.d) && AbstractC13042fc3.d(this.e, c17532n74.e) && AbstractC13042fc3.d(this.f, c17532n74.f) && this.g == c17532n74.g && this.h == c17532n74.h && this.i == c17532n74.i;
    }

    public int hashCode() {
        return (((((((this.a * 31) + Boolean.hashCode(this.g)) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.h)) * 31) + this.c.hashCode();
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        if (c19084pl0 == null) {
            return;
        }
        this.a = c19084pl0.x(1);
        ArrayList arrayList = new ArrayList();
        int iM = c19084pl0.m(2);
        for (int i = 0; i < iM; i++) {
            arrayList.add(new C18766pD());
        }
        this.b = c19084pl0.p(2, arrayList);
        C7880To7 c7880To7 = (C7880To7) c19084pl0.z(3, new C7880To7(0L, 0L, null, 7, null));
        if (c7880To7 != null) {
            this.c = c7880To7;
        }
        C7880To7 c7880To72 = (C7880To7) c19084pl0.z(4, new C7880To7(0L, 0L, null, 7, null));
        if (c7880To72 != null) {
            this.d = c7880To72;
        }
        int iX = c19084pl0.x(5);
        if (iX != 0) {
            this.e = Integer.valueOf(iX);
        }
        int iX2 = c19084pl0.x(6);
        if (iX2 != 0) {
            this.f = Integer.valueOf(iX2);
        }
        this.g = c19084pl0.u(7);
        this.h = c19084pl0.y(8);
        this.i = c19084pl0.x(9);
    }

    public final C17532n74 q(int i, List list, C7880To7 c7880To7, C7880To7 c7880To72, Integer num, Integer num2, boolean z, long j, int i2) {
        AbstractC13042fc3.i(c7880To7, "lastMessageId");
        AbstractC13042fc3.i(c7880To72, "lastScrolled");
        return new C17532n74(i, list, c7880To7, c7880To72, num, num2, z, j, i2);
    }

    public final Integer s() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        if (c19675ql0 == null) {
            return;
        }
        c19675ql0.f(1, this.a);
        List list = this.b;
        if (list != null) {
            c19675ql0.m(2, list);
        }
        c19675ql0.i(3, this.c);
        c19675ql0.i(4, this.d);
        Integer num = this.e;
        if (num != null) {
            c19675ql0.f(5, num.intValue());
        }
        Integer num2 = this.f;
        if (num2 != null) {
            c19675ql0.f(6, num2.intValue());
        }
        c19675ql0.a(7, this.g);
        c19675ql0.g(8, this.h);
        c19675ql0.f(9, this.i);
    }

    public String toString() {
        return "MessageRepliesInfo(repliesCount=" + this.a + ", recentRepliers=" + this.b + ", lastMessageId=" + this.c + ", lastScrolled=" + this.d + ", discussionGroupId=" + this.e + ", channelId=" + this.f + ", isLoadingState=" + this.g + ", lastReadDate=" + this.h + ", lastScrolledOffset=" + this.i + Separators.RPAREN;
    }

    public final Integer u() {
        return this.e;
    }

    public final C7880To7 w() {
        return this.c;
    }

    public final long y() {
        return this.h;
    }

    public final C7880To7 z() {
        return this.d;
    }

    public C17532n74(int i, List list, C7880To7 c7880To7, C7880To7 c7880To72, Integer num, Integer num2, boolean z, long j, int i2) {
        AbstractC13042fc3.i(c7880To7, "lastMessageId");
        AbstractC13042fc3.i(c7880To72, "lastScrolled");
        this.a = i;
        this.b = list;
        this.c = c7880To7;
        this.d = c7880To72;
        this.e = num;
        this.f = num2;
        this.g = z;
        this.h = j;
        this.i = i2;
    }

    public C17532n74(int i, int i2) {
        this(0, null, null, null, Integer.valueOf(i2), Integer.valueOf(i), false, 0L, 0, 207, null);
    }
}
