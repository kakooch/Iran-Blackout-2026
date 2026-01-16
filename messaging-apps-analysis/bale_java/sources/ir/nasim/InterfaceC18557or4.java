package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import java.io.IOException;

/* renamed from: ir.nasim.or4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC18557or4 {

    /* renamed from: ir.nasim.or4$a */
    public static final class a implements InterfaceC18557or4 {
        private final long a;
        private final IOException b;
        private final long c;
        private final C12106e30 d;

        public a(long j, IOException iOException, long j2, C12106e30 c12106e30) {
            AbstractC13042fc3.i(iOException, ParameterNames.CAUSE);
            AbstractC13042fc3.i(c12106e30, "feedback");
            this.a = j;
            this.b = iOException;
            this.c = j2;
            this.d = c12106e30;
        }

        @Override // ir.nasim.InterfaceC18557or4
        public C12106e30 a() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c && AbstractC13042fc3.d(this.d, aVar.d);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "Failed(rttInNanos=" + this.a + ", cause=" + this.b + ", transferredSizeInByte=" + this.c + ", feedback=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.or4$b */
    public static final class b implements InterfaceC18557or4 {
        private final long a;
        private final long b;
        private final C12106e30 c;

        public b(long j, long j2, C12106e30 c12106e30) {
            AbstractC13042fc3.i(c12106e30, "feedback");
            this.a = j;
            this.b = j2;
            this.c = c12106e30;
        }

        @Override // ir.nasim.InterfaceC18557or4
        public C12106e30 a() {
            return this.c;
        }

        public final long b() {
            return this.a;
        }

        public long c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && AbstractC13042fc3.d(this.c, bVar.c);
        }

        public int hashCode() {
            return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Successful(rttInNanos=" + this.a + ", transferredSizeInByte=" + this.b + ", feedback=" + this.c + Separators.RPAREN;
        }
    }

    C12106e30 a();
}
