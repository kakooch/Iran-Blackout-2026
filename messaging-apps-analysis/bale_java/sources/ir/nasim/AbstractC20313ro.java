package ir.nasim;

import android.view.View;
import android.view.ViewParent;

/* renamed from: ir.nasim.ro, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC20313ro {
    private static UA2 a = a.e;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(View view, View view2) {
        if (AbstractC13042fc3.d(view2, view)) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }

    private static final float f(float[] fArr, int i, float[] fArr2, int i2) {
        int i3 = i * 4;
        return (fArr[i3] * fArr2[i2]) + (fArr[i3 + 1] * fArr2[4 + i2]) + (fArr[i3 + 2] * fArr2[8 + i2]) + (fArr[i3 + 3] * fArr2[12 + i2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19666qk1 g(View view) {
        AbstractC14199hW7.c(view, 1);
        return AbstractC14199hW7.b(view);
    }

    public static final UA2 h() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(float[] fArr, float[] fArr2) {
        float f = f(fArr2, 0, fArr, 0);
        float f2 = f(fArr2, 0, fArr, 1);
        float f3 = f(fArr2, 0, fArr, 2);
        float f4 = f(fArr2, 0, fArr, 3);
        float f5 = f(fArr2, 1, fArr, 0);
        float f6 = f(fArr2, 1, fArr, 1);
        float f7 = f(fArr2, 1, fArr, 2);
        float f8 = f(fArr2, 1, fArr, 3);
        float f9 = f(fArr2, 2, fArr, 0);
        float f10 = f(fArr2, 2, fArr, 1);
        float f11 = f(fArr2, 2, fArr, 2);
        float f12 = f(fArr2, 2, fArr, 3);
        float f13 = f(fArr2, 3, fArr, 0);
        float f14 = f(fArr2, 3, fArr, 1);
        float f15 = f(fArr2, 3, fArr, 2);
        float f16 = f(fArr2, 3, fArr, 3);
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
        fArr[8] = f9;
        fArr[9] = f10;
        fArr[10] = f11;
        fArr[11] = f12;
        fArr[12] = f13;
        fArr[13] = f14;
        fArr[14] = f15;
        fArr[15] = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(float[] fArr, float f, float f2, float[] fArr2) {
        AV3.h(fArr2);
        AV3.o(fArr2, f, f2, 0.0f, 4, null);
        i(fArr, fArr2);
    }

    /* renamed from: ir.nasim.ro$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC22097uf5 invoke(InterfaceC22097uf5 interfaceC22097uf5) {
            return interfaceC22097uf5;
        }
    }
}
