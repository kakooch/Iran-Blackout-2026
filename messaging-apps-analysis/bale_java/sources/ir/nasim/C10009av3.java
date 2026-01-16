package ir.nasim;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* renamed from: ir.nasim.av3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10009av3 implements DW5, B73 {
    private final Resources a;
    private final DW5 b;

    private C10009av3(Resources resources, DW5 dw5) {
        this.a = (Resources) AbstractC3322Aj5.d(resources);
        this.b = (DW5) AbstractC3322Aj5.d(dw5);
    }

    public static DW5 d(Resources resources, DW5 dw5) {
        if (dw5 == null) {
            return null;
        }
        return new C10009av3(resources, dw5);
    }

    @Override // ir.nasim.DW5
    public void a() {
        this.b.a();
    }

    @Override // ir.nasim.DW5
    public Class b() {
        return BitmapDrawable.class;
    }

    @Override // ir.nasim.DW5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.a, (Bitmap) this.b.get());
    }

    @Override // ir.nasim.DW5
    public int f() {
        return this.b.f();
    }

    @Override // ir.nasim.B73
    public void initialize() {
        DW5 dw5 = this.b;
        if (dw5 instanceof B73) {
            ((B73) dw5).initialize();
        }
    }
}
