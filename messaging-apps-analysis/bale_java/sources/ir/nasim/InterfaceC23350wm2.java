package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.FileNotFoundException;

/* renamed from: ir.nasim.wm2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC23350wm2 {

    /* renamed from: ir.nasim.wm2$a */
    public static final class a implements InterfaceC23350wm2 {
        private final FileNotFoundException a;

        public a(FileNotFoundException fileNotFoundException) {
            AbstractC13042fc3.i(fileNotFoundException, "exception");
            this.a = fileNotFoundException;
        }

        public final FileNotFoundException a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "FileNotFound(exception=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.wm2$b */
    public static final class b implements InterfaceC23350wm2 {
        private final SecurityException a;

        public b(SecurityException securityException) {
            AbstractC13042fc3.i(securityException, "securityException");
            this.a = securityException;
        }

        public final SecurityException a() {
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
            return "PermissionDenied(securityException=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.wm2$c */
    public static final class c implements InterfaceC23350wm2 {
        private final Throwable a;

        public c(Throwable th) {
            AbstractC13042fc3.i(th, "throwable");
            this.a = th;
        }

        public final Throwable a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Unknown(throwable=" + this.a + Separators.RPAREN;
        }
    }
}
