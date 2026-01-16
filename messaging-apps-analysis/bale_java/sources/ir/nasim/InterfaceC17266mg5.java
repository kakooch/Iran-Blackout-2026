package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mg5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC17266mg5 {

    /* renamed from: ir.nasim.mg5$a */
    public static final class a implements InterfaceC17266mg5 {
        public static final a a = new a();

        private a() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 720604390;
        }

        public String toString() {
            return "Buffering";
        }
    }

    /* renamed from: ir.nasim.mg5$b */
    public static final class b implements InterfaceC17266mg5 {
        public static final b a = new b();

        private b() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 991925264;
        }

        public String toString() {
            return "Idle";
        }
    }

    /* renamed from: ir.nasim.mg5$c */
    public static final class c implements InterfaceC17266mg5 {
        private final boolean a;
        private final boolean b;

        public c(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "Paused(canSeekNext=" + this.a + ", canSeekPrev=" + this.b + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.mg5$d */
    public static final class d implements InterfaceC17266mg5 {
        private final boolean a;
        private final boolean b;

        public d(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "Playing(canSeekNext=" + this.a + ", canSeekPrev=" + this.b + Separators.RPAREN;
        }
    }
}
