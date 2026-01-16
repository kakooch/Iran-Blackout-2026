package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import ir.nasim.InterfaceC22734vk2;

/* renamed from: ir.nasim.Zf0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9269Zf0 implements InterfaceC22734vk2 {
    private final Bitmap a;
    private final IL4 b;

    /* renamed from: ir.nasim.Zf0$a */
    public static final class a implements InterfaceC22734vk2.a {
        @Override // ir.nasim.InterfaceC22734vk2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC22734vk2 a(Bitmap bitmap, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            return new C9269Zf0(bitmap, il4);
        }
    }

    public C9269Zf0(Bitmap bitmap, IL4 il4) {
        this.a = bitmap;
        this.b = il4;
    }

    @Override // ir.nasim.InterfaceC22734vk2
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        return new E02(new BitmapDrawable(this.b.g().getResources(), this.a), false, EnumC21699tz1.b);
    }
}
