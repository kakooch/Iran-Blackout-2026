package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public abstract class NX1 implements Comparable {

    public static final class a extends NX1 {
        private final MX1 a;
        private final long b;
        private final FY1 c;
        private final LY1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MX1 mx1, long j, FY1 fy1, LY1 ly1) {
            super(null);
            AbstractC13042fc3.i(mx1, "input");
            AbstractC13042fc3.i(fy1, "downloadPolicy");
            AbstractC13042fc3.i(ly1, "requestType");
            this.a = mx1;
            this.b = j;
            this.c = fy1;
            this.d = ly1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!AbstractC13042fc3.d(a.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.file.download.model.DownloadItem.Immediate");
            return AbstractC13042fc3.d(i(), ((a) obj).i());
        }

        @Override // ir.nasim.NX1
        public FY1 h() {
            return this.c;
        }

        public int hashCode() {
            return i().hashCode();
        }

        @Override // ir.nasim.NX1
        public MX1 i() {
            return this.a;
        }

        @Override // ir.nasim.NX1
        public LY1 j() {
            return this.d;
        }

        @Override // ir.nasim.NX1
        public long o() {
            return this.b;
        }

        @Override // ir.nasim.NX1
        public NX1 p(LY1 ly1) {
            AbstractC13042fc3.i(ly1, "other");
            if (ly1.a() > j().a()) {
                ly1 = j();
            }
            return new a(i(), o(), h(), ly1);
        }

        @Override // ir.nasim.NX1
        public String toString() {
            return "<Immediate>" + super.toString();
        }
    }

    private NX1() {
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(NX1 nx1) {
        AbstractC13042fc3.i(nx1, "other");
        j().b();
        return AbstractC13042fc3.l(nx1.o(), o());
    }

    public abstract FY1 h();

    public abstract MX1 i();

    public abstract LY1 j();

    public abstract long o();

    public abstract NX1 p(LY1 ly1);

    public String toString() {
        return "DownloadItem(requestTime=" + o() + ", " + i() + Separators.RPAREN;
    }

    public /* synthetic */ NX1(ED1 ed1) {
        this();
    }
}
