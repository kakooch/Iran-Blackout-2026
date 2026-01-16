package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.kx3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC16251kx3 {

    /* renamed from: ir.nasim.kx3$a */
    public static final class a implements InterfaceC5563Jw3, InterfaceC8748Xd6 {
        private final /* synthetic */ InterfaceC8748Xd6 a;
        final /* synthetic */ C19206px3 b;

        a(InterfaceC8748Xd6 interfaceC8748Xd6, C19206px3 c19206px3) {
            this.b = c19206px3;
            this.a = interfaceC8748Xd6;
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public int a() {
            return this.b.x().g();
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public int b() {
            InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) AbstractC15401jX0.F0(this.b.x().i());
            if (interfaceC7948Tw3 != null) {
                return interfaceC7948Tw3.getIndex();
            }
            return 0;
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public void c(int i, int i2) {
            this.b.M(i, i2, true);
        }

        @Override // ir.nasim.InterfaceC8748Xd6
        public float e(float f) {
            return this.a.e(f);
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public int f(int i, int i2) {
            Object obj;
            InterfaceC9425Zw3 interfaceC9425Zw3X = this.b.x();
            int iA = 0;
            if (interfaceC9425Zw3X.i().isEmpty()) {
                return 0;
            }
            int iH = h();
            if (i > b() || iH > i) {
                iA = (AbstractC10028ax3.a(interfaceC9425Zw3X) * (i - h())) - g();
            } else {
                List listI = interfaceC9425Zw3X.i();
                int size = listI.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        obj = null;
                        break;
                    }
                    obj = listI.get(i3);
                    if (((InterfaceC7948Tw3) obj).getIndex() == i) {
                        break;
                    }
                    i3++;
                }
                InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) obj;
                if (interfaceC7948Tw3 != null) {
                    iA = interfaceC7948Tw3.getOffset();
                }
            }
            return iA + i2;
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public int g() {
            return this.b.t();
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public int h() {
            return this.b.s();
        }
    }

    public static final InterfaceC5563Jw3 a(C19206px3 c19206px3, InterfaceC8748Xd6 interfaceC8748Xd6) {
        return new a(interfaceC8748Xd6, c19206px3);
    }
}
