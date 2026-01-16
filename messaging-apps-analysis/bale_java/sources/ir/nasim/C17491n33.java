package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* renamed from: ir.nasim.n33, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17491n33 {
    public PX7 a(ImageView imageView, Class cls) {
        if (Bitmap.class.equals(cls)) {
            return new C11858dg0(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new A02(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
