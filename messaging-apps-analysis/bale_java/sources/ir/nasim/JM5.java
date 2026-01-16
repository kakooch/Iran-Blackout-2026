package ir.nasim;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class JM5 implements InterfaceC9342Zn1 {
    private final float a;

    public JM5(float f) {
        this.a = f;
    }

    @Override // ir.nasim.InterfaceC9342Zn1
    public float a(RectF rectF) {
        return this.a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof JM5) && this.a == ((JM5) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
