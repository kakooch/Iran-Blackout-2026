package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.kV7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC15981kV7 {

    /* renamed from: ir.nasim.kV7$a */
    public static final class a implements InterfaceC15981kV7 {
        private final float a;
        private final float b;
        private final boolean c;
        private final boolean d;

        public a(float f, float f2, boolean z, boolean z2) {
            this.a = f;
            this.b = f2;
            this.c = z;
            this.d = z2;
        }

        @Override // ir.nasim.InterfaceC15981kV7
        public boolean a() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC15981kV7
        public boolean b() {
            return this.c;
        }

        public final float c() {
            return this.b;
        }

        public final float d() {
            return this.a;
        }

        public String toString() {
            return "Loading(progress=" + this.a + ", fileSize=" + this.b + ", isDownloaded=" + b() + ", firstFrameRendered=" + a() + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.kV7$b */
    public static final class b implements InterfaceC15981kV7 {
        private final boolean a;
        private final long b;
        private final boolean c;
        private final boolean d;

        public b(boolean z, long j, boolean z2, boolean z3) {
            this.a = z;
            this.b = j;
            this.c = z2;
            this.d = z3;
        }

        @Override // ir.nasim.InterfaceC15981kV7
        public boolean a() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC15981kV7
        public boolean b() {
            return this.c;
        }

        public final long c() {
            return this.b;
        }

        public final boolean d() {
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
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d;
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
        }

        public String toString() {
            return "Playing(isMute=" + this.a + ", currentPosition=" + this.b + ", isDownloaded=" + this.c + ", firstFrameRendered=" + this.d + Separators.RPAREN;
        }
    }

    boolean a();

    boolean b();
}
