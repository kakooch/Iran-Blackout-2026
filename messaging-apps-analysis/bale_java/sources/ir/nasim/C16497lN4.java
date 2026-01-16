package ir.nasim;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import java.util.Objects;

/* renamed from: ir.nasim.lN4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C16497lN4 extends C15906kN4 {

    /* renamed from: ir.nasim.lN4$a */
    private static final class a {
        final OutputConfiguration a;
        String b;
        long c = 1;

        a(OutputConfiguration outputConfiguration) {
            this.a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.a, aVar.a) && this.c == aVar.c && Objects.equals(this.b, aVar.b);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() ^ 31;
            int i = (iHashCode << 5) - iHashCode;
            String str = this.b;
            int iHashCode2 = (str == null ? 0 : str.hashCode()) ^ i;
            return Long.hashCode(this.c) ^ ((iHashCode2 << 5) - iHashCode2);
        }
    }

    C16497lN4(int i, Surface surface) {
        this(new a(new OutputConfiguration(i, surface)));
    }

    static C16497lN4 k(OutputConfiguration outputConfiguration) {
        return new C16497lN4(new a(outputConfiguration));
    }

    @Override // ir.nasim.AbstractC18270oN4, ir.nasim.C15315jN4.a
    public void b(Surface surface) {
        ((OutputConfiguration) h()).addSurface(surface);
    }

    @Override // ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public void c(long j) {
        ((a) this.a).c = j;
    }

    @Override // ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public void d(String str) {
        ((a) this.a).b = str;
    }

    @Override // ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public String e() {
        return ((a) this.a).b;
    }

    @Override // ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public void f() {
        ((OutputConfiguration) h()).enableSurfaceSharing();
    }

    @Override // ir.nasim.C15906kN4, ir.nasim.C15315jN4.a
    public Object h() {
        AbstractC4980Hj5.a(this.a instanceof a);
        return ((a) this.a).a;
    }

    @Override // ir.nasim.C15906kN4, ir.nasim.AbstractC18270oN4
    final boolean i() {
        throw new AssertionError("isSurfaceSharingEnabled() should not be called on API >= 26");
    }

    C16497lN4(Object obj) {
        super(obj);
    }
}
