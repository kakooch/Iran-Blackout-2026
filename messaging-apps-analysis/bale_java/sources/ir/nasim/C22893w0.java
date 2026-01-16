package ir.nasim;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: ir.nasim.w0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22893w0 implements InterfaceC9342Zn1 {
    private final float a;

    public C22893w0(float f) {
        this.a = f;
    }

    @Override // ir.nasim.InterfaceC9342Zn1
    public float a(RectF rectF) {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C22893w0) && this.a == ((C22893w0) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
