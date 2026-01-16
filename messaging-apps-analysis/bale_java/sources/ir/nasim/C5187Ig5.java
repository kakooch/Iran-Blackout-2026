package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

/* renamed from: ir.nasim.Ig5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5187Ig5 {
    private final PointerIcon a;

    /* renamed from: ir.nasim.Ig5$a */
    static class a {
        static PointerIcon a(Bitmap bitmap, float f, float f2) {
            return PointerIcon.create(bitmap, f, f2);
        }

        static PointerIcon b(Context context, int i) {
            return PointerIcon.getSystemIcon(context, i);
        }

        static PointerIcon c(Resources resources, int i) {
            return PointerIcon.load(resources, i);
        }
    }

    private C5187Ig5(PointerIcon pointerIcon) {
        this.a = pointerIcon;
    }

    public static C5187Ig5 b(Context context, int i) {
        return new C5187Ig5(a.b(context, i));
    }

    public Object a() {
        return this.a;
    }
}
