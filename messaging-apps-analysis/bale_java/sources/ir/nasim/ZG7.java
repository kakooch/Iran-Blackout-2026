package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.file.FileSizeExceededException;
import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class ZG7 {

    public static final class a extends ZG7 {
        private final JH7 a;
        private final WG7 b;
        private final Exception c;
        private final boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JH7 jh7, WG7 wg7) {
            super(null);
            AbstractC13042fc3.i(jh7, "uploadType");
            AbstractC13042fc3.i(wg7, "uploadConfig");
            this.a = jh7;
            this.b = wg7;
            this.c = new Exception("Url has been expired");
        }

        @Override // ir.nasim.ZG7
        public boolean a() {
            return this.d;
        }

        @Override // ir.nasim.ZG7
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Exception b() {
            return this.c;
        }

        public final WG7 d() {
            return this.b;
        }

        public final JH7 e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "ExpiredUrl(uploadType=" + this.a + ", uploadConfig=" + this.b + Separators.RPAREN;
        }
    }

    public static final class b extends ZG7 {
        private final FileSizeExceededException a;
        private final boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FileSizeExceededException fileSizeExceededException) {
            super(null);
            AbstractC13042fc3.i(fileSizeExceededException, "throwable");
            this.a = fileSizeExceededException;
            this.b = true;
        }

        @Override // ir.nasim.ZG7
        public boolean a() {
            return this.b;
        }

        @Override // ir.nasim.ZG7
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public FileSizeExceededException b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "FileSizeLimitExceeded(throwable=" + this.a + Separators.RPAREN;
        }
    }

    public static final class c extends ZG7 {
        public static final c a = new c();
        private static final boolean b = true;
        private static final Exception c = new Exception("FileSizeMismatched");
        public static final int d = 8;

        private c() {
            super(null);
        }

        @Override // ir.nasim.ZG7
        public boolean a() {
            return b;
        }

        @Override // ir.nasim.ZG7
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Exception b() {
            return c;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 11311449;
        }

        public String toString() {
            return "FileSizeMismatch";
        }
    }

    public static final class d extends ZG7 {
        private final IOException a;
        private final boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(IOException iOException) {
            super(null);
            AbstractC13042fc3.i(iOException, "throwable");
            this.a = iOException;
        }

        @Override // ir.nasim.ZG7
        public boolean a() {
            return this.b;
        }

        @Override // ir.nasim.ZG7
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public IOException b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && AbstractC13042fc3.d(this.a, ((d) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "IO(throwable=" + this.a + Separators.RPAREN;
        }
    }

    public static final class e extends ZG7 {
        private final IOException a;
        private final boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(IOException iOException) {
            super(null);
            AbstractC13042fc3.i(iOException, "throwable");
            this.a = iOException;
            this.b = true;
        }

        @Override // ir.nasim.ZG7
        public boolean a() {
            return this.b;
        }

        @Override // ir.nasim.ZG7
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public IOException b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && AbstractC13042fc3.d(this.a, ((e) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "InvalidInputFile(throwable=" + this.a + Separators.RPAREN;
        }
    }

    public static final class f extends ZG7 {
        private final Throwable a;
        private final boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Throwable th) {
            super(null);
            AbstractC13042fc3.i(th, "throwable");
            this.a = th;
            this.b = true;
        }

        @Override // ir.nasim.ZG7
        public boolean a() {
            return this.b;
        }

        @Override // ir.nasim.ZG7
        public Throwable b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && AbstractC13042fc3.d(this.a, ((f) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Unknown(throwable=" + this.a + Separators.RPAREN;
        }
    }

    private ZG7() {
    }

    public abstract boolean a();

    public abstract Throwable b();

    public /* synthetic */ ZG7(ED1 ed1) {
        this();
    }
}
