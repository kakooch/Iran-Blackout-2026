package ir.nasim;

/* renamed from: ir.nasim.uk6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC22148uk6 {

    /* renamed from: ir.nasim.uk6$a */
    public static final class a {
        public final C23334wk6 a;
        public final C23334wk6 b;

        public a(C23334wk6 c23334wk6) {
            this(c23334wk6, c23334wk6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a.equals(aVar.a) && this.b.equals(aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.a);
            if (this.a.equals(this.b)) {
                str = "";
            } else {
                str = ", " + this.b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public a(C23334wk6 c23334wk6, C23334wk6 c23334wk62) {
            this.a = (C23334wk6) AbstractC20011rK.e(c23334wk6);
            this.b = (C23334wk6) AbstractC20011rK.e(c23334wk62);
        }
    }

    /* renamed from: ir.nasim.uk6$b */
    public static class b implements InterfaceC22148uk6 {
        private final long a;
        private final a b;

        public b(long j) {
            this(j, 0L);
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public a c(long j) {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public boolean g() {
            return false;
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public long i() {
            return this.a;
        }

        public b(long j, long j2) {
            this.a = j;
            this.b = new a(j2 == 0 ? C23334wk6.c : new C23334wk6(0L, j2));
        }
    }

    a c(long j);

    boolean g();

    long i();
}
