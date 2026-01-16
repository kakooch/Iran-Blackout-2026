package ir.nasim;

import android.view.View;
import android.widget.PopupWindow;

/* renamed from: ir.nasim.Ti5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7822Ti5 {

    /* renamed from: ir.nasim.Ti5$a */
    static class a {
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        static void c(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        static void d(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        a.c(popupWindow, z);
    }

    public static void b(PopupWindow popupWindow, int i) {
        a.d(popupWindow, i);
    }

    public static void c(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        popupWindow.showAsDropDown(view, i, i2, i3);
    }
}
