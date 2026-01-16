package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;

/* renamed from: ir.nasim.hH2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14059hH2 implements InterfaceC15645jv7 {
    private final InterfaceC15645jv7 b;

    public C14059hH2(InterfaceC15645jv7 interfaceC15645jv7) {
        this.b = (InterfaceC15645jv7) AbstractC3322Aj5.d(interfaceC15645jv7);
    }

    @Override // ir.nasim.InterfaceC15645jv7
    public DW5 a(Context context, DW5 dw5, int i, int i2) {
        C11598dH2 c11598dH2 = (C11598dH2) dw5.get();
        DW5 c14288hg0 = new C14288hg0(c11598dH2.e(), com.bumptech.glide.b.c(context).f());
        DW5 dw5A = this.b.a(context, c14288hg0, i, i2);
        if (!c14288hg0.equals(dw5A)) {
            c14288hg0.a();
        }
        c11598dH2.m(this.b, (Bitmap) dw5A.get());
        return dw5;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public boolean equals(Object obj) {
        if (obj instanceof C14059hH2) {
            return this.b.equals(((C14059hH2) obj).b);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC14373ho3
    public int hashCode() {
        return this.b.hashCode();
    }
}
