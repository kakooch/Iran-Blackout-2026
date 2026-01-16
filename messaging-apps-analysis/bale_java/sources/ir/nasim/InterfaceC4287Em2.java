package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.IOException;

/* renamed from: ir.nasim.Em2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC4287Em2 {

    /* renamed from: ir.nasim.Em2$a */
    public static final class a implements InterfaceC4287Em2 {
        private final IOException a;

        public a(IOException iOException) {
            AbstractC13042fc3.i(iOException, "throwable");
            this.a = iOException;
        }

        @Override // ir.nasim.InterfaceC4287Em2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IOException c() {
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
            return "IO(throwable=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Em2$b */
    public static final class b implements InterfaceC4287Em2 {
        private final IndexOutOfBoundsException a;

        public b(IndexOutOfBoundsException indexOutOfBoundsException) {
            AbstractC13042fc3.i(indexOutOfBoundsException, "throwable");
            this.a = indexOutOfBoundsException;
        }

        @Override // ir.nasim.InterfaceC4287Em2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IndexOutOfBoundsException c() {
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
            return "IndexOutOfBounds(throwable=" + this.a + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.Em2$c */
    public static final class c implements InterfaceC4287Em2 {
        private final Throwable a;

        public c(Throwable th) {
            AbstractC13042fc3.i(th, "throwable");
            this.a = th;
        }

        @Override // ir.nasim.InterfaceC4287Em2
        public Throwable c() {
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

    Throwable c();
}
