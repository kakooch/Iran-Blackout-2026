package ir.nasim;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* renamed from: ir.nasim.Xk0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8805Xk0 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.e(a.e);
    private static final InterfaceC8539Wk0 b = new b();

    /* renamed from: ir.nasim.Xk0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC8539Wk0 invoke(InterfaceC9234Zb1 interfaceC9234Zb1) {
            return !((Context) interfaceC9234Zb1.r(AndroidCompositionLocals_androidKt.g())).getPackageManager().hasSystemFeature("android.software.leanback") ? InterfaceC8539Wk0.a.b() : AbstractC8805Xk0.b();
        }
    }

    /* renamed from: ir.nasim.Xk0$b */
    public static final class b implements InterfaceC8539Wk0 {
        private final float b = 0.3f;
        private final float c;

        b() {
        }

        @Override // ir.nasim.InterfaceC8539Wk0
        public float a(float f, float f2, float f3) {
            float fAbs = Math.abs((f2 + f) - f);
            boolean z = fAbs <= f3;
            float f4 = (this.b * f3) - (this.c * fAbs);
            float f5 = f3 - f4;
            if (z && f5 < fAbs) {
                f4 = f3 - fAbs;
            }
            return f - f4;
        }
    }

    public static final AbstractC6535Nx5 a() {
        return a;
    }

    public static final InterfaceC8539Wk0 b() {
        return b;
    }
}
