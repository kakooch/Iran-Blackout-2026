package ir.nasim;

/* renamed from: ir.nasim.bo1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10554bo1 {
    private static final InterfaceC9934ao1 a = new a();

    /* renamed from: ir.nasim.bo1$a */
    public static final class a implements InterfaceC9934ao1 {
        a() {
        }

        @Override // ir.nasim.InterfaceC9934ao1
        public float a(long j, WH1 wh1) {
            return 0.0f;
        }

        public String toString() {
            return "ZeroCornerSize";
        }
    }

    public static final InterfaceC9934ao1 a(float f) {
        return new C18044nz5(f);
    }

    public static final InterfaceC9934ao1 b(int i) {
        return new C24699z35(i);
    }

    public static final InterfaceC9934ao1 c(float f) {
        return new C18375oZ1(f, null);
    }

    public static final InterfaceC9934ao1 d() {
        return a;
    }
}
