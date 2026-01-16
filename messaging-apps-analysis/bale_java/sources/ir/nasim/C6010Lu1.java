package ir.nasim;

import android.graphics.drawable.Drawable;
import ir.nasim.InterfaceC22259uv7;

/* renamed from: ir.nasim.Lu1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6010Lu1 implements InterfaceC22259uv7 {
    private final InterfaceC4856Gv7 a;
    private final Y23 b;
    private final int c;
    private final boolean d;

    public C6010Lu1(InterfaceC4856Gv7 interfaceC4856Gv7, Y23 y23, int i, boolean z) {
        this.a = interfaceC4856Gv7;
        this.b = y23;
        this.c = i;
        this.d = z;
        if (i <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.".toString());
        }
    }

    @Override // ir.nasim.InterfaceC22259uv7
    public void a() {
        Drawable drawableD = this.a.d();
        Drawable drawableA = this.b.a();
        EnumC14254hc6 enumC14254hc6J = this.b.b().J();
        int i = this.c;
        Y23 y23 = this.b;
        C5777Ku1 c5777Ku1 = new C5777Ku1(drawableD, drawableA, enumC14254hc6J, i, ((y23 instanceof I07) && ((I07) y23).d()) ? false : true, this.d);
        Y23 y232 = this.b;
        if (y232 instanceof I07) {
            this.a.a(c5777Ku1);
        } else if (y232 instanceof C12412ea2) {
            this.a.c(c5777Ku1);
        }
    }

    public final int b() {
        return this.c;
    }

    public final boolean c() {
        return this.d;
    }

    /* renamed from: ir.nasim.Lu1$a */
    public static final class a implements InterfaceC22259uv7.a {
        private final int c;
        private final boolean d;

        public a(int i, boolean z) {
            this.c = i;
            this.d = z;
            if (i <= 0) {
                throw new IllegalArgumentException("durationMillis must be > 0.".toString());
            }
        }

        @Override // ir.nasim.InterfaceC22259uv7.a
        public InterfaceC22259uv7 a(InterfaceC4856Gv7 interfaceC4856Gv7, Y23 y23) {
            return !(y23 instanceof I07) ? InterfaceC22259uv7.a.b.a(interfaceC4856Gv7, y23) : ((I07) y23).c() == EnumC21699tz1.a ? InterfaceC22259uv7.a.b.a(interfaceC4856Gv7, y23) : new C6010Lu1(interfaceC4856Gv7, y23, this.c, this.d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.c == aVar.c && this.d == aVar.d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.c * 31) + Boolean.hashCode(this.d);
        }

        public /* synthetic */ a(int i, boolean z, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? 100 : i, (i2 & 2) != 0 ? false : z);
        }
    }
}
