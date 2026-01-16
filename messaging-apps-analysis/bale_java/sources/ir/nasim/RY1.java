package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.DX1;

/* loaded from: classes5.dex */
public interface RY1 {

    public static final class a implements RY1 {
        private final InterfaceC3346Am2 a;

        public a(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "fileSystemReference");
            this.a = interfaceC3346Am2;
        }

        public final InterfaceC3346Am2 a() {
            return this.a;
        }
    }

    public static final class b implements RY1 {
        private final float a;

        public b(float f) {
            this.a = f;
        }

        public final float a() {
            return this.a;
        }
    }

    public static final class c implements RY1 {
        private final DX1 a;

        public c(DX1 dx1) {
            this.a = dx1;
        }

        public final DX1 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            DX1 dx1 = this.a;
            if (dx1 == null) {
                return 0;
            }
            return dx1.hashCode();
        }

        public String toString() {
            return "FileNotDownloaded(error=" + this.a + Separators.RPAREN;
        }

        public /* synthetic */ c(DX1 dx1, int i, ED1 ed1) {
            this((i & 1) != 0 ? new DX1.d(null, 1, null) : dx1);
        }
    }
}
