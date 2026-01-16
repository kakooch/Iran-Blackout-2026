package ir.nasim;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import java.util.Objects;

/* renamed from: ir.nasim.mN4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C17088mN4 extends C16497lN4 {

    /* renamed from: ir.nasim.mN4$a */
    private static final class a {
        final OutputConfiguration a;
        long b = 1;

        a(OutputConfiguration outputConfiguration) {
            this.a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() ^ 31;
            return Long.hashCode(this.b) ^ ((iHashCode << 5) - iHashCode);
        }
    }

    C17088mN4(int i, Surface surface) {
        this(new a(new OutputConfiguration(i, surface)));
    }

    static C17088mN4 l(OutputConfiguration outputConfiguration) {
        return new C17088mN4(new a(outputConfiguration));
    }

    @Override // ir.nasim.C16497lN4, ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public void c(long j) {
        ((a) this.a).b = j;
    }

    @Override // ir.nasim.C16497lN4, ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public void d(String str) {
        ((OutputConfiguration) h()).setPhysicalCameraId(str);
    }

    @Override // ir.nasim.C16497lN4, ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public String e() {
        return null;
    }

    @Override // ir.nasim.C16497lN4, ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public Object h() {
        AbstractC4980Hj5.a(this.a instanceof a);
        return ((a) this.a).a;
    }

    C17088mN4(Object obj) {
        super(obj);
    }
}
