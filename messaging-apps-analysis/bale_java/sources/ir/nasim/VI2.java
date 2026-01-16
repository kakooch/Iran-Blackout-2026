package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

/* loaded from: classes5.dex */
public class VI2 extends com.bumptech.glide.h {
    public VI2(com.bumptech.glide.b bVar, InterfaceC11426cz3 interfaceC11426cz3, InterfaceC12970fU5 interfaceC12970fU5, Context context) {
        super(bVar, interfaceC11426cz3, interfaceC12970fU5, context);
    }

    @Override // com.bumptech.glide.h
    protected void E(C20107rU5 c20107rU5) {
        if (c20107rU5 instanceof TI2) {
            super.E(c20107rU5);
        } else {
            super.E(new TI2().b(c20107rU5));
        }
    }

    @Override // com.bumptech.glide.h
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public UI2 b(Class cls) {
        return new UI2(this.a, this, cls, this.b);
    }

    @Override // com.bumptech.glide.h
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public UI2 d() {
        return (UI2) super.d();
    }

    @Override // com.bumptech.glide.h
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public UI2 j() {
        return (UI2) super.j();
    }

    public UI2 L() {
        return (UI2) super.m();
    }

    public UI2 M(Bitmap bitmap) {
        return (UI2) super.t(bitmap);
    }

    public UI2 N(Drawable drawable) {
        return (UI2) super.u(drawable);
    }

    public UI2 O(Uri uri) {
        return (UI2) super.v(uri);
    }

    @Override // com.bumptech.glide.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public UI2 w(Integer num) {
        return (UI2) super.w(num);
    }

    public UI2 Q(Object obj) {
        return (UI2) super.x(obj);
    }

    @Override // com.bumptech.glide.h
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public UI2 y(String str) {
        return (UI2) super.y(str);
    }

    @Override // com.bumptech.glide.h
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public UI2 z(byte[] bArr) {
        return (UI2) super.z(bArr);
    }
}
