package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Gj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4743Gj2 {
    public static final a i = new a(null);
    public static final int j = 8;
    private static final C4743Gj2 k;
    private final C5886Lg2 a;
    private final C14697iL2 b;
    private final C14733iO2 c;
    private long d;
    private long e;
    private List f;
    private String g;
    private final List h;

    /* renamed from: ir.nasim.Gj2$a */
    public static final class a {
        private a() {
        }

        public final C4743Gj2 a() {
            return C4743Gj2.k;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        C5886Lg2 c5886Lg2A = C5886Lg2.o.a();
        Object objA = C14697iL2.E0.a();
        AbstractC13042fc3.h(objA, "createInstance(...)");
        k = new C4743Gj2(c5886Lg2A, (C14697iL2) objA, null, 0L, 0L, AbstractC10360bX0.m(), "", AbstractC10360bX0.m());
    }

    public C4743Gj2(C5886Lg2 c5886Lg2, C14697iL2 c14697iL2, C14733iO2 c14733iO2, long j2, long j3, List list, String str, List list2) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC13042fc3.i(c14697iL2, "group");
        AbstractC13042fc3.i(list, "upVoterUsers");
        AbstractC13042fc3.i(str, "myReactionCode");
        AbstractC13042fc3.i(list2, "enableReaction");
        this.a = c5886Lg2;
        this.b = c14697iL2;
        this.c = c14733iO2;
        this.d = j2;
        this.e = j3;
        this.f = list;
        this.g = str;
        this.h = list2;
    }

    public final C4743Gj2 b(C5886Lg2 c5886Lg2, C14697iL2 c14697iL2, C14733iO2 c14733iO2, long j2, long j3, List list, String str, List list2) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC13042fc3.i(c14697iL2, "group");
        AbstractC13042fc3.i(list, "upVoterUsers");
        AbstractC13042fc3.i(str, "myReactionCode");
        AbstractC13042fc3.i(list2, "enableReaction");
        return new C4743Gj2(c5886Lg2, c14697iL2, c14733iO2, j2, j3, list, str, list2);
    }

    public final List d() {
        return this.h;
    }

    public final C5886Lg2 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C4743Gj2.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.jaryan.feed.model.ui.FeedUI");
        return AbstractC13042fc3.d(this.a, ((C4743Gj2) obj).a);
    }

    public final C14697iL2 f() {
        return this.b;
    }

    public final C14733iO2 g() {
        return this.c;
    }

    public final String h() {
        return this.g;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final long i() {
        return this.d;
    }

    public final List j() {
        return this.f;
    }

    public final long k() {
        return this.e;
    }

    public String toString() {
        return "FeedUI(feed=" + this.a + ", group=" + this.b + ", groupVM=" + this.c + ", reactionCount=" + this.d + ", viewCount=" + this.e + ", upVoterUsers=" + this.f + ", myReactionCode=" + this.g + ", enableReaction=" + this.h + Separators.RPAREN;
    }
}
