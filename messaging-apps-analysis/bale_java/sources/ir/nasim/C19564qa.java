package ir.nasim;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: ir.nasim.qa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19564qa implements InterfaceC9342Zn1 {
    private final InterfaceC9342Zn1 a;
    private final float b;

    public C19564qa(float f, InterfaceC9342Zn1 interfaceC9342Zn1) {
        while (interfaceC9342Zn1 instanceof C19564qa) {
            interfaceC9342Zn1 = ((C19564qa) interfaceC9342Zn1).a;
            f += ((C19564qa) interfaceC9342Zn1).b;
        }
        this.a = interfaceC9342Zn1;
        this.b = f;
    }

    @Override // ir.nasim.InterfaceC9342Zn1
    public float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19564qa)) {
            return false;
        }
        C19564qa c19564qa = (C19564qa) obj;
        return this.a.equals(c19564qa.a) && this.b == c19564qa.b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }
}
