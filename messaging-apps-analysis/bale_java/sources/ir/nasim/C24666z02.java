package ir.nasim;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import ir.nasim.InterfaceC22734vk2;

/* renamed from: ir.nasim.z02, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24666z02 implements InterfaceC22734vk2 {
    private final Drawable a;
    private final IL4 b;

    /* renamed from: ir.nasim.z02$a */
    public static final class a implements InterfaceC22734vk2.a {
        @Override // ir.nasim.InterfaceC22734vk2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC22734vk2 a(Drawable drawable, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            return new C24666z02(drawable, il4);
        }
    }

    public C24666z02(Drawable drawable, IL4 il4) {
        this.a = drawable;
        this.b = il4;
    }

    @Override // ir.nasim.InterfaceC22734vk2
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Drawable bitmapDrawable;
        boolean zU = AbstractC18638p.u(this.a);
        if (zU) {
            bitmapDrawable = new BitmapDrawable(this.b.g().getResources(), N02.a.a(this.a, this.b.f(), this.b.o(), this.b.n(), this.b.c()));
        } else {
            bitmapDrawable = this.a;
        }
        return new E02(bitmapDrawable, zU, EnumC21699tz1.b);
    }
}
