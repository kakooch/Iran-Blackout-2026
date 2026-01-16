package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes6.dex */
public abstract class EX1 {
    private final boolean a;

    public static final class a extends EX1 {
        public static final a b = new a();

        private a() {
            super(false, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1342687793;
        }

        public String toString() {
            return "Canceled";
        }
    }

    public static abstract class b extends EX1 {

        public static final class a extends b {
            private final Cache.CacheException b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Cache.CacheException cacheException) {
                super(true, null);
                AbstractC13042fc3.i(cacheException, "cacheException");
                this.b = cacheException;
            }

            public final Cache.CacheException b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && AbstractC13042fc3.d(this.b, ((a) obj).b);
            }

            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return "Cache(cacheException=" + this.b + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.EX1$b$b, reason: collision with other inner class name */
        public static final class C0341b extends b {
            private final FileNotFoundException b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0341b(FileNotFoundException fileNotFoundException) {
                super(false, null);
                AbstractC13042fc3.i(fileNotFoundException, "exception");
                this.b = fileNotFoundException;
            }

            public final FileNotFoundException b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0341b) && AbstractC13042fc3.d(this.b, ((C0341b) obj).b);
            }

            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return "FileNotFound(exception=" + this.b + Separators.RPAREN;
            }
        }

        public static final class c extends b {
            public static final c b = new c();

            private c() {
                super(false, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof c);
            }

            public int hashCode() {
                return -813074778;
            }

            public String toString() {
                return "InsufficientStorage";
            }
        }

        public static final class d extends b {
            private final IOException b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(IOException iOException) {
                super(true, null);
                AbstractC13042fc3.i(iOException, "ioException");
                this.b = iOException;
            }

            public final IOException b() {
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
                return "Unknown(ioException=" + this.b + Separators.RPAREN;
            }
        }

        public /* synthetic */ b(boolean z, ED1 ed1) {
            this(z);
        }

        private b(boolean z) {
            super(z, null);
        }
    }

    public static abstract class c extends EX1 {

        public static final class a extends c {
            public static final a b = new a();

            private a() {
                super(false, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof a);
            }

            public int hashCode() {
                return 86032026;
            }

            public String toString() {
                return "FileIsBanned";
            }
        }

        public static final class b extends c {
            public static final b b = new b();

            private b() {
                super(false, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof b);
            }

            public int hashCode() {
                return -1933306335;
            }

            public String toString() {
                return "FileNotFound";
            }
        }

        /* renamed from: ir.nasim.EX1$c$c, reason: collision with other inner class name */
        public static final class C0342c extends c {
            public static final C0342c b = new C0342c();

            private C0342c() {
                super(true, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C0342c);
            }

            public int hashCode() {
                return -1344638509;
            }

            public String toString() {
                return "Internal";
            }
        }

        public static final class d extends c {
            public static final d b = new d();

            private d() {
                super(false, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof d);
            }

            public int hashCode() {
                return 346833294;
            }

            public String toString() {
                return "InvalidUrl";
            }
        }

        public static final class e extends c {
            public static final e b = new e();

            private e() {
                super(false, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof e);
            }

            public int hashCode() {
                return -1529509024;
            }

            public String toString() {
                return "PermissionDenied";
            }
        }

        public static final class f extends c {
            public static final f b = new f();

            private f() {
                super(false, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof f);
            }

            public int hashCode() {
                return 951013665;
            }

            public String toString() {
                return "RangeNotSatisfiable";
            }
        }

        public static final class g extends c {
            public static final g b = new g();

            private g() {
                super(true, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof g);
            }

            public int hashCode() {
                return 961729125;
            }

            public String toString() {
                return "RateLimit";
            }
        }

        public static final class h extends c {
            public static final h b = new h();

            private h() {
                super(true, null);
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof h);
            }

            public int hashCode() {
                return 1256681323;
            }

            public String toString() {
                return "TimeOut";
            }
        }

        public static final class i extends c {
            private final Throwable b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public i(Throwable th) {
                super(true, null);
                AbstractC13042fc3.i(th, "throwable");
                this.b = th;
            }

            public final Throwable b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof i) && AbstractC13042fc3.d(this.b, ((i) obj).b);
            }

            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return "Unknown(throwable=" + this.b + Separators.RPAREN;
            }
        }

        public static final class j extends c {
            private final int b;

            public j(int i) {
                super(true, null);
                this.b = i;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof j) && this.b == ((j) obj).b;
            }

            public int hashCode() {
                return Integer.hashCode(this.b);
            }

            public String toString() {
                return "UnknownStatusCode(statusCode=" + this.b + Separators.RPAREN;
            }
        }

        public /* synthetic */ c(boolean z, ED1 ed1) {
            this(z);
        }

        private c(boolean z) {
            super(z, null);
        }
    }

    public static final class d extends EX1 {
        private final SecurityException b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SecurityException securityException) {
            super(false, null);
            AbstractC13042fc3.i(securityException, "securityException");
            this.b = securityException;
        }

        public final SecurityException b() {
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
            return "Security(securityException=" + this.b + Separators.RPAREN;
        }
    }

    public static final class e extends EX1 {
        private final Throwable b;

        public e(Throwable th) {
            super(true, null);
            this.b = th;
        }

        public final Throwable b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && AbstractC13042fc3.d(this.b, ((e) obj).b);
        }

        public int hashCode() {
            Throwable th = this.b;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        public String toString() {
            return "Unknown(throwable=" + this.b + Separators.RPAREN;
        }
    }

    public /* synthetic */ EX1(boolean z, ED1 ed1) {
        this(z);
    }

    public final boolean a() {
        return this.a;
    }

    private EX1(boolean z) {
        this.a = z;
    }
}
