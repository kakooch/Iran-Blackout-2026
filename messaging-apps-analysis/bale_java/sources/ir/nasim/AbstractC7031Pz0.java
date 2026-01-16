package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC12895fM2;

/* renamed from: ir.nasim.Pz0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC7031Pz0 {
    public static final int a = 0;

    /* renamed from: ir.nasim.Pz0$a */
    public static abstract class a extends AbstractC7031Pz0 {
        public /* synthetic */ a(ED1 ed1) {
            this();
        }

        private a() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.Pz0$c */
    public static final class c extends a {
        public static final c b = new c();

        private c() {
            super(null);
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean a() {
            return false;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean b() {
            return false;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 93905939;
        }

        public String toString() {
            return "IncomingVideoCall";
        }
    }

    /* renamed from: ir.nasim.Pz0$d */
    public static final class d extends a {
        private final AbstractC12895fM2 b;
        private final boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbstractC12895fM2 abstractC12895fM2) {
            super(null);
            AbstractC13042fc3.i(abstractC12895fM2, "groupCallType");
            this.b = abstractC12895fM2;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean a() {
            return true;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean b() {
            return false;
        }

        public final boolean c() {
            return this.c;
        }

        public final AbstractC12895fM2 d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.b, ((d) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "IncomingVideoGroupCall(groupCallType=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Pz0$e */
    public static final class e extends a {
        public static final e b = new e();

        private e() {
            super(null);
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean a() {
            return false;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean b() {
            return false;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return 2036890954;
        }

        public String toString() {
            return "IncomingVoiceCall";
        }
    }

    /* renamed from: ir.nasim.Pz0$g */
    public static abstract class g extends AbstractC7031Pz0 {
        public /* synthetic */ g(ED1 ed1) {
            this();
        }

        private g() {
            super(null);
        }
    }

    /* renamed from: ir.nasim.Pz0$i */
    public static final class i extends g {
        private final boolean b;

        public /* synthetic */ i(boolean z, int i, ED1 ed1) {
            this((i & 1) != 0 ? false : z);
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean a() {
            return false;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean b() {
            return this.b;
        }

        public final i c(boolean z) {
            return new i(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && this.b == ((i) obj).b;
        }

        public int hashCode() {
            return Boolean.hashCode(this.b);
        }

        public String toString() {
            return "OutgoingVideoCall(isStream=" + this.b + Separators.RPAREN;
        }

        public i(boolean z) {
            super(null);
            this.b = z;
        }
    }

    /* renamed from: ir.nasim.Pz0$j */
    public static final class j extends g {
        private final AbstractC12895fM2 b;
        private final boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AbstractC12895fM2 abstractC12895fM2) {
            super(null);
            AbstractC13042fc3.i(abstractC12895fM2, "groupCallType");
            this.b = abstractC12895fM2;
            this.c = true;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean a() {
            return true;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean b() {
            return false;
        }

        public final boolean c() {
            return this.c;
        }

        public final AbstractC12895fM2 d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && AbstractC13042fc3.d(this.b, ((j) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "OutgoingVideoGroupCall(groupCallType=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Pz0$k */
    public static final class k extends g {
        private final boolean b;

        public /* synthetic */ k(boolean z, int i, ED1 ed1) {
            this((i & 1) != 0 ? false : z);
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean a() {
            return false;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean b() {
            return this.b;
        }

        public final k c(boolean z) {
            return new k(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && this.b == ((k) obj).b;
        }

        public int hashCode() {
            return Boolean.hashCode(this.b);
        }

        public String toString() {
            return "OutgoingVoiceCall(isStream=" + this.b + Separators.RPAREN;
        }

        public k(boolean z) {
            super(null);
            this.b = z;
        }
    }

    private AbstractC7031Pz0() {
    }

    public abstract boolean a();

    public abstract boolean b();

    /* renamed from: ir.nasim.Pz0$b */
    public static final class b extends a {
        private final AbstractC12895fM2 b;
        private final boolean c;

        public /* synthetic */ b(AbstractC12895fM2 abstractC12895fM2, int i, ED1 ed1) {
            this((i & 1) != 0 ? AbstractC12895fM2.b.a : abstractC12895fM2);
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean a() {
            return true;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean b() {
            return false;
        }

        public final boolean c() {
            return this.c;
        }

        public final AbstractC12895fM2 d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.b, ((b) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "IncomingGroupCall(groupCallType=" + this.b + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractC12895fM2 abstractC12895fM2) {
            super(null);
            AbstractC13042fc3.i(abstractC12895fM2, "groupCallType");
            this.b = abstractC12895fM2;
        }
    }

    /* renamed from: ir.nasim.Pz0$f */
    public static final class f extends AbstractC7031Pz0 {
        private final AbstractC12895fM2 b;
        private final boolean c;
        private final Long d;
        private String e;
        private final String f;
        private final Long g;

        public /* synthetic */ f(AbstractC12895fM2 abstractC12895fM2, boolean z, Long l, String str, String str2, Long l2, int i, ED1 ed1) {
            this((i & 1) != 0 ? AbstractC12895fM2.b.a : abstractC12895fM2, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) == 0 ? l2 : null);
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean a() {
            return true;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean b() {
            return false;
        }

        public final boolean c() {
            return this.c;
        }

        public final String d() {
            return this.e;
        }

        public final Long e() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return AbstractC13042fc3.d(this.b, fVar.b) && this.c == fVar.c && AbstractC13042fc3.d(this.d, fVar.d) && AbstractC13042fc3.d(this.e, fVar.e) && AbstractC13042fc3.d(this.f, fVar.f) && AbstractC13042fc3.d(this.g, fVar.g);
        }

        public final String f() {
            return this.f;
        }

        public final AbstractC12895fM2 g() {
            return this.b;
        }

        public final Long h() {
            return this.d;
        }

        public int hashCode() {
            int iHashCode = ((this.b.hashCode() * 31) + Boolean.hashCode(this.c)) * 31;
            Long l = this.d;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str = this.e;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Long l2 = this.g;
            return iHashCode4 + (l2 != null ? l2.hashCode() : 0);
        }

        public String toString() {
            return "JoinedGroupCall(groupCallType=" + this.b + ", amIInitiator=" + this.c + ", initiatorUserId=" + this.d + ", callLink=" + this.e + ", callTitle=" + this.f + ", callStartTime=" + this.g + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AbstractC12895fM2 abstractC12895fM2, boolean z, Long l, String str, String str2, Long l2) {
            super(null);
            AbstractC13042fc3.i(abstractC12895fM2, "groupCallType");
            this.b = abstractC12895fM2;
            this.c = z;
            this.d = l;
            this.e = str;
            this.f = str2;
            this.g = l2;
        }
    }

    /* renamed from: ir.nasim.Pz0$h */
    public static final class h extends g {
        private final AbstractC12895fM2 b;
        private final boolean c;

        public /* synthetic */ h(AbstractC12895fM2 abstractC12895fM2, int i, ED1 ed1) {
            this((i & 1) != 0 ? AbstractC12895fM2.b.a : abstractC12895fM2);
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean a() {
            return true;
        }

        @Override // ir.nasim.AbstractC7031Pz0
        public boolean b() {
            return false;
        }

        public final boolean c() {
            return this.c;
        }

        public final AbstractC12895fM2 d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && AbstractC13042fc3.d(this.b, ((h) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "OutgoingGroupCall(groupCallType=" + this.b + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AbstractC12895fM2 abstractC12895fM2) {
            super(null);
            AbstractC13042fc3.i(abstractC12895fM2, "groupCallType");
            this.b = abstractC12895fM2;
            this.c = true;
        }
    }

    public /* synthetic */ AbstractC7031Pz0(ED1 ed1) {
        this();
    }
}
