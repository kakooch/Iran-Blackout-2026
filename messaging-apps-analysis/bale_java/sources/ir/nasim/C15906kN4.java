package ir.nasim;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import java.util.Objects;

/* renamed from: ir.nasim.kN4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C15906kN4 extends AbstractC18270oN4 {

    /* renamed from: ir.nasim.kN4$a */
    private static final class a {
        final OutputConfiguration a;
        String b;
        boolean c;
        long d = 1;

        a(OutputConfiguration outputConfiguration) {
            this.a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.a, aVar.a) && this.c == aVar.c && this.d == aVar.d && Objects.equals(this.b, aVar.b);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() ^ 31;
            int i = (this.c ? 1 : 0) ^ ((iHashCode << 5) - iHashCode);
            int i2 = (i << 5) - i;
            String str = this.b;
            int iHashCode2 = (str == null ? 0 : str.hashCode()) ^ i2;
            return Long.hashCode(this.d) ^ ((iHashCode2 << 5) - iHashCode2);
        }
    }

    C15906kN4(int i, Surface surface) {
        this(new a(new OutputConfiguration(i, surface)));
    }

    static C15906kN4 j(OutputConfiguration outputConfiguration) {
        return new C15906kN4(new a(outputConfiguration));
    }

    @Override // ir.nasim.C15315jN4.a
    public void c(long j) {
        ((a) this.a).d = j;
    }

    @Override // ir.nasim.C15315jN4.a
    public void d(String str) {
        ((a) this.a).b = str;
    }

    @Override // ir.nasim.C15315jN4.a
    public String e() {
        return ((a) this.a).b;
    }

    @Override // ir.nasim.C15315jN4.a
    public void f() {
        ((a) this.a).c = true;
    }

    @Override // ir.nasim.AbstractC18270oN4, ir.nasim.C15315jN4.a
    public Surface getSurface() {
        return ((OutputConfiguration) h()).getSurface();
    }

    @Override // ir.nasim.C15315jN4.a
    public Object h() {
        AbstractC4980Hj5.a(this.a instanceof a);
        return ((a) this.a).a;
    }

    @Override // ir.nasim.AbstractC18270oN4
    boolean i() {
        return ((a) this.a).c;
    }

    C15906kN4(Object obj) {
        super(obj);
    }
}
