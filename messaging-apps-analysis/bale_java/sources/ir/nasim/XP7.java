package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.LP;

/* loaded from: classes4.dex */
public abstract class XP7 {
    private final boolean a;
    private final LP b;

    public static final class a extends XP7 {
        private final LP c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(LP lp) {
            super(false, null, 3, 0 == true ? 1 : 0);
            AbstractC13042fc3.i(lp, "error");
            this.c = lp;
        }

        public LP b() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.c, ((a) obj).c);
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.c + Separators.RPAREN;
        }
    }

    public static final class b extends XP7 {
        public static final b c = new b();

        /* JADX WARN: Multi-variable type inference failed */
        private b() {
            super(false, null, 3, 0 == true ? 1 : 0);
        }
    }

    public static final class c extends XP7 {
        private final boolean c;

        public /* synthetic */ c(boolean z, int i, ED1 ed1) {
            this((i & 1) != 0 ? true : z);
        }

        @Override // ir.nasim.XP7
        public boolean a() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.c == ((c) obj).c;
        }

        public int hashCode() {
            return Boolean.hashCode(this.c);
        }

        public String toString() {
            return "Loading(isLoading=" + this.c + Separators.RPAREN;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(boolean z) {
            super(false, null, 3, 0 == true ? 1 : 0);
            this.c = z;
        }
    }

    public static final class d extends XP7 {
        private final String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(String str) {
            super(false, null, 3, 0 == true ? 1 : 0);
            AbstractC13042fc3.i(str, "transactionHash");
            this.c = str;
        }

        public final String b() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.c, ((d) obj).c);
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public String toString() {
            return "NeedSignUp(transactionHash=" + this.c + Separators.RPAREN;
        }
    }

    public static final class e extends XP7 {
        public static final e c = new e();

        /* JADX WARN: Multi-variable type inference failed */
        private e() {
            super(false, null, 3, 0 == true ? 1 : 0);
        }
    }

    public static final class f extends XP7 {
        private final long c;
        private final String d;
        private final SQ e;
        private final long f;
        private final SQ g;
        private final long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(long j, String str, SQ sq, long j2, SQ sq2, long j3) {
            super(false, null, 3, 0 == true ? 1 : 0);
            AbstractC13042fc3.i(str, "transactionHash");
            AbstractC13042fc3.i(sq, "sentCodeType");
            AbstractC13042fc3.i(sq2, "nextSendCodeType");
            this.c = j;
            this.d = str;
            this.e = sq;
            this.f = j2;
            this.g = sq2;
            this.h = j3;
        }

        public final long b() {
            return this.f;
        }

        public final SQ c() {
            return this.g;
        }

        public final long d() {
            return this.h;
        }

        public final SQ e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.c == fVar.c && AbstractC13042fc3.d(this.d, fVar.d) && this.e == fVar.e && this.f == fVar.f && this.g == fVar.g && this.h == fVar.h;
        }

        public int hashCode() {
            return (((((((((Long.hashCode(this.c) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h);
        }

        public String toString() {
            return "StartAuthSuccess(fullPhoneNumber=" + this.c + ", transactionHash=" + this.d + ", sentCodeType=" + this.e + ", codeTimeoutMillis=" + this.f + ", nextSendCodeType=" + this.g + ", nextSendCodeWaitTimeMillis=" + this.h + Separators.RPAREN;
        }
    }

    public /* synthetic */ XP7(boolean z, LP lp, ED1 ed1) {
        this(z, lp);
    }

    public boolean a() {
        return this.a;
    }

    private XP7(boolean z, LP lp) {
        this.a = z;
        this.b = lp;
    }

    public /* synthetic */ XP7(boolean z, LP lp, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? LP.c.b : lp, null);
    }
}
