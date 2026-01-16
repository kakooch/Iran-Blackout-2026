package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AA3;
import ir.nasim.AbstractC12797fB3;

/* renamed from: ir.nasim.Fv0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC4600Fv0 {

    /* renamed from: ir.nasim.Fv0$a */
    public static final class a extends AbstractC4600Fv0 {
        private final String a;

        public a(String str) {
            super(null);
            this.a = str;
        }

        @Override // ir.nasim.AbstractC4600Fv0
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            String str = this.a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "GeneratingLink(callTitle=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Fv0$d */
    public static final class d extends AbstractC4600Fv0 {
        private final String a;
        private final String b;

        public d(String str, String str2) {
            super(null);
            this.a = str;
            this.b = str2;
        }

        @Override // ir.nasim.AbstractC4600Fv0
        public String a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return AbstractC13042fc3.d(this.a, dVar.a) && AbstractC13042fc3.d(this.b, dVar.b);
        }

        public int hashCode() {
            String str = this.a;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.b;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "LinkGenerationFailed(rpcErrorMessage=" + this.a + ", callTitle=" + this.b + Separators.RPAREN;
        }
    }

    private AbstractC4600Fv0() {
    }

    public abstract String a();

    /* renamed from: ir.nasim.Fv0$b */
    public static final class b extends AbstractC4600Fv0 {
        private final AbstractC12797fB3 a;
        private final String b;

        public /* synthetic */ b(AbstractC12797fB3 abstractC12797fB3, String str, int i, ED1 ed1) {
            this((i & 1) != 0 ? new AbstractC12797fB3.a(false) : abstractC12797fB3, (i & 2) != 0 ? null : str);
        }

        @Override // ir.nasim.AbstractC4600Fv0
        public String a() {
            return this.b;
        }

        public final b b(AbstractC12797fB3 abstractC12797fB3, String str) {
            AbstractC13042fc3.i(abstractC12797fB3, "state");
            return new b(abstractC12797fB3, str);
        }

        public final AbstractC12797fB3 c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "InitialState(state=" + this.a + ", callTitle=" + this.b + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractC12797fB3 abstractC12797fB3, String str) {
            super(null);
            AbstractC13042fc3.i(abstractC12797fB3, "state");
            this.a = abstractC12797fB3;
            this.b = str;
        }
    }

    public /* synthetic */ AbstractC4600Fv0(ED1 ed1) {
        this();
    }

    /* renamed from: ir.nasim.Fv0$c */
    public static final class c extends AbstractC4600Fv0 {
        private final String a;
        private final long b;
        private final boolean c;
        private final Long d;
        private final AbstractC12797fB3 e;
        private final String f;
        private final Long g;
        private final Long h;
        private final AA3 i;

        public /* synthetic */ c(String str, long j, boolean z, Long l, AbstractC12797fB3 abstractC12797fB3, String str2, Long l2, Long l3, AA3 aa3, int i, ED1 ed1) {
            this(str, j, z, (i & 8) != 0 ? null : l, (i & 16) != 0 ? new AbstractC12797fB3.a(false) : abstractC12797fB3, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : l2, (i & 128) != 0 ? null : l3, (i & 256) != 0 ? AA3.a.a : aa3);
        }

        @Override // ir.nasim.AbstractC4600Fv0
        public String a() {
            return this.f;
        }

        public final c b(String str, long j, boolean z, Long l, AbstractC12797fB3 abstractC12797fB3, String str2, Long l2, Long l3, AA3 aa3) {
            AbstractC13042fc3.i(str, "callLink");
            AbstractC13042fc3.i(abstractC12797fB3, "state");
            AbstractC13042fc3.i(aa3, "linkScreenView");
            return new c(str, j, z, l, abstractC12797fB3, str2, l2, l3, aa3);
        }

        public final boolean d() {
            return this.c;
        }

        public final Long e() {
            return this.h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return AbstractC13042fc3.d(this.a, cVar.a) && this.b == cVar.b && this.c == cVar.c && AbstractC13042fc3.d(this.d, cVar.d) && AbstractC13042fc3.d(this.e, cVar.e) && AbstractC13042fc3.d(this.f, cVar.f) && AbstractC13042fc3.d(this.g, cVar.g) && AbstractC13042fc3.d(this.h, cVar.h) && AbstractC13042fc3.d(this.i, cVar.i);
        }

        public final long f() {
            return this.b;
        }

        public final String g() {
            return this.a;
        }

        public final Long h() {
            return this.g;
        }

        public int hashCode() {
            int iHashCode = ((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31;
            Long l = this.d;
            int iHashCode2 = (((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.e.hashCode()) * 31;
            String str = this.f;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Long l2 = this.g;
            int iHashCode4 = (iHashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.h;
            return ((iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31) + this.i.hashCode();
        }

        public final Long i() {
            return this.d;
        }

        public final AA3 j() {
            return this.i;
        }

        public final AbstractC12797fB3 k() {
            return this.e;
        }

        public String toString() {
            return "LinkGenerated(callLink=" + this.a + ", callId=" + this.b + ", amIInitiator=" + this.c + ", initiatorUserId=" + this.d + ", state=" + this.e + ", callTitle=" + this.f + ", callStartedTime=" + this.g + ", callExpirationInterval=" + this.h + ", linkScreenView=" + this.i + Separators.RPAREN;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, long j, boolean z, Long l, AbstractC12797fB3 abstractC12797fB3, String str2, Long l2, Long l3, AA3 aa3) {
            super(null);
            AbstractC13042fc3.i(str, "callLink");
            AbstractC13042fc3.i(abstractC12797fB3, "state");
            AbstractC13042fc3.i(aa3, "linkScreenView");
            this.a = str;
            this.b = j;
            this.c = z;
            this.d = l;
            this.e = abstractC12797fB3;
            this.f = str2;
            this.g = l2;
            this.h = l3;
            this.i = aa3;
        }
    }
}
