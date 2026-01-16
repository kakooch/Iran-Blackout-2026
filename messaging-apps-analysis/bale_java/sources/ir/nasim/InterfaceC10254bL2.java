package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.bL2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC10254bL2 {

    /* renamed from: ir.nasim.bL2$a */
    public static final class a implements InterfaceC10254bL2 {
        private final float a;

        public /* synthetic */ a(float f, ED1 ed1) {
            this(f);
        }

        @Override // ir.nasim.InterfaceC10254bL2
        public List a(WH1 wh1, int i, int i2) {
            return AbstractC15050iv3.c(i, Math.max((i + i2) / (wh1.B0(this.a) + i2), 1), i2);
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && C17784nZ1.s(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return C17784nZ1.t(this.a);
        }

        private a(float f) {
            this.a = f;
            if (C17784nZ1.p(f, C17784nZ1.q((float) 0)) > 0) {
                return;
            }
            P73.a("Provided min size should be larger than zero.");
        }
    }

    /* renamed from: ir.nasim.bL2$b */
    public static final class b implements InterfaceC10254bL2 {
        private final int a;

        public b(int i) {
            this.a = i;
            if (i > 0) {
                return;
            }
            P73.a("Provided count should be larger than zero");
        }

        @Override // ir.nasim.InterfaceC10254bL2
        public List a(WH1 wh1, int i, int i2) {
            return AbstractC15050iv3.c(i, this.a, i2);
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return -this.a;
        }
    }

    List a(WH1 wh1, int i, int i2);
}
