package ir.nasim;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* renamed from: ir.nasim.s02, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C20433s02 extends Property {
    public static final Property b = new C20433s02();
    private final WeakHashMap a;

    private C20433s02() {
        super(Integer.class, "drawableAlphaCompat");
        this.a = new WeakHashMap();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
