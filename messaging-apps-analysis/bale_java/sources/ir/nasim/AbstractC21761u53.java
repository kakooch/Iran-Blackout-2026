package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.u53, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC21761u53 {

    /* renamed from: ir.nasim.u53$a */
    public static final class a extends AbstractC21761u53 {
        private final long a;
        private final int b;
        private final long c;
        private final AbstractC7031Pz0 d;
        private final int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, int i, long j2, AbstractC7031Pz0 abstractC7031Pz0, int i2) {
            super(null);
            AbstractC13042fc3.i(abstractC7031Pz0, "callType");
            this.a = j;
            this.b = i;
            this.c = j2;
            this.d = abstractC7031Pz0;
            this.e = i2;
        }

        @Override // ir.nasim.AbstractC21761u53
        public int a() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC21761u53
        public long b() {
            return this.a;
        }

        @Override // ir.nasim.AbstractC21761u53
        public AbstractC7031Pz0 c() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC21761u53
        public long d() {
            return this.c;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && AbstractC13042fc3.d(this.d, aVar.d) && this.e == aVar.e;
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "GroupCall(callId=" + this.a + ", adminUId=" + this.b + ", createDate=" + this.c + ", callType=" + this.d + ", groupPeerId=" + this.e + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.u53$b */
    public static final class b extends AbstractC21761u53 {
        private final List a;
        private final long b;
        private final int c;
        private final long d;
        private final AbstractC7031Pz0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List list, long j, int i, long j2, AbstractC7031Pz0 abstractC7031Pz0) {
            super(null);
            AbstractC13042fc3.i(list, "invitedUsers");
            AbstractC13042fc3.i(abstractC7031Pz0, "callType");
            this.a = list;
            this.b = j;
            this.c = i;
            this.d = j2;
            this.e = abstractC7031Pz0;
        }

        @Override // ir.nasim.AbstractC21761u53
        public int a() {
            return this.c;
        }

        @Override // ir.nasim.AbstractC21761u53
        public long b() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC21761u53
        public AbstractC7031Pz0 c() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC21761u53
        public long d() {
            return this.d;
        }

        public final List e() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && AbstractC13042fc3.d(this.e, bVar.e);
        }

        public int hashCode() {
            return (((((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "InviteCall(invitedUsers=" + this.a + ", callId=" + this.b + ", adminUId=" + this.c + ", createDate=" + this.d + ", callType=" + this.e + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.u53$c */
    public static final class c extends AbstractC21761u53 {
        private final long a;
        private final int b;
        private final long c;
        private final AbstractC7031Pz0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j, int i, long j2, AbstractC7031Pz0 abstractC7031Pz0) {
            super(null);
            AbstractC13042fc3.i(abstractC7031Pz0, "callType");
            this.a = j;
            this.b = i;
            this.c = j2;
            this.d = abstractC7031Pz0;
        }

        @Override // ir.nasim.AbstractC21761u53
        public int a() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC21761u53
        public long b() {
            return this.a;
        }

        @Override // ir.nasim.AbstractC21761u53
        public AbstractC7031Pz0 c() {
            return this.d;
        }

        @Override // ir.nasim.AbstractC21761u53
        public long d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && this.c == cVar.c && AbstractC13042fc3.d(this.d, cVar.d);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "PersonalCall(callId=" + this.a + ", adminUId=" + this.b + ", createDate=" + this.c + ", callType=" + this.d + Separators.RPAREN;
        }
    }

    private AbstractC21761u53() {
    }

    public abstract int a();

    public abstract long b();

    public abstract AbstractC7031Pz0 c();

    public abstract long d();

    public /* synthetic */ AbstractC21761u53(ED1 ed1) {
        this();
    }
}
