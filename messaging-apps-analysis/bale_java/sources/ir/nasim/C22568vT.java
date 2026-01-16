package ir.nasim;

import ir.nasim.V45;
import ir.nasim.W45;

/* renamed from: ir.nasim.vT, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C22568vT extends W45 {
    private final String b;
    private final V45.a c;
    private final String d;
    private final String e;
    private final long f;
    private final long g;
    private final String h;

    /* renamed from: ir.nasim.vT$b */
    static final class b extends W45.a {
        private String a;
        private V45.a b;
        private String c;
        private String d;
        private Long e;
        private Long f;
        private String g;

        @Override // ir.nasim.W45.a
        public W45 a() {
            String str = "";
            if (this.b == null) {
                str = " registrationStatus";
            }
            if (this.e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new C22568vT(this.a, this.b, this.c, this.d, this.e.longValue(), this.f.longValue(), this.g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.W45.a
        public W45.a b(String str) {
            this.c = str;
            return this;
        }

        @Override // ir.nasim.W45.a
        public W45.a c(long j) {
            this.e = Long.valueOf(j);
            return this;
        }

        @Override // ir.nasim.W45.a
        public W45.a d(String str) {
            this.a = str;
            return this;
        }

        @Override // ir.nasim.W45.a
        public W45.a e(String str) {
            this.g = str;
            return this;
        }

        @Override // ir.nasim.W45.a
        public W45.a f(String str) {
            this.d = str;
            return this;
        }

        @Override // ir.nasim.W45.a
        public W45.a g(V45.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.b = aVar;
            return this;
        }

        @Override // ir.nasim.W45.a
        public W45.a h(long j) {
            this.f = Long.valueOf(j);
            return this;
        }

        b() {
        }

        private b(W45 w45) {
            this.a = w45.d();
            this.b = w45.g();
            this.c = w45.b();
            this.d = w45.f();
            this.e = Long.valueOf(w45.c());
            this.f = Long.valueOf(w45.h());
            this.g = w45.e();
        }
    }

    @Override // ir.nasim.W45
    public String b() {
        return this.d;
    }

    @Override // ir.nasim.W45
    public long c() {
        return this.f;
    }

    @Override // ir.nasim.W45
    public String d() {
        return this.b;
    }

    @Override // ir.nasim.W45
    public String e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof W45)) {
            return false;
        }
        W45 w45 = (W45) obj;
        String str3 = this.b;
        if (str3 != null ? str3.equals(w45.d()) : w45.d() == null) {
            if (this.c.equals(w45.g()) && ((str = this.d) != null ? str.equals(w45.b()) : w45.b() == null) && ((str2 = this.e) != null ? str2.equals(w45.f()) : w45.f() == null) && this.f == w45.c() && this.g == w45.h()) {
                String str4 = this.h;
                if (str4 == null) {
                    if (w45.e() == null) {
                        return true;
                    }
                } else if (str4.equals(w45.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // ir.nasim.W45
    public String f() {
        return this.e;
    }

    @Override // ir.nasim.W45
    public V45.a g() {
        return this.c;
    }

    @Override // ir.nasim.W45
    public long h() {
        return this.g;
    }

    public int hashCode() {
        String str = this.b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003;
        String str2 = this.d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.f;
        int i = (iHashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.g;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.h;
        return i2 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // ir.nasim.W45
    public W45.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.b + ", registrationStatus=" + this.c + ", authToken=" + this.d + ", refreshToken=" + this.e + ", expiresInSecs=" + this.f + ", tokenCreationEpochInSecs=" + this.g + ", fisError=" + this.h + "}";
    }

    private C22568vT(String str, V45.a aVar, String str2, String str3, long j, long j2, String str4) {
        this.b = str;
        this.c = aVar;
        this.d = str2;
        this.e = str3;
        this.f = j;
        this.g = j2;
        this.h = str4;
    }
}
