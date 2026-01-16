package ir.nasim;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* renamed from: ir.nasim.zS0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24930zS0 {

    /* renamed from: ir.nasim.zS0$a */
    private static class a {
        static void a(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void b(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    public static Drawable a(CheckedTextView checkedTextView) {
        return checkedTextView.getCheckMarkDrawable();
    }

    public static void b(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        a.a(checkedTextView, colorStateList);
    }

    public static void c(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        a.b(checkedTextView, mode);
    }
}
