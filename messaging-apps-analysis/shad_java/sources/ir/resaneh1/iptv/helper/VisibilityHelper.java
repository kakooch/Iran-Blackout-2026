package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.view.View;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class VisibilityHelper {
    public static void makeViewVisible(View view) {
        if (view == null) {
            return;
        }
        if (view.getVisibility() == 8 || view.getVisibility() == 4) {
            view.setVisibility(0);
        }
    }

    public static void makeViewGone(View view) {
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        view.setVisibility(8);
    }

    public static View createLine(Context context) {
        View view = new View(context);
        view.setBackgroundColor(context.getResources().getColor(R.color.home_gray));
        return view;
    }

    public static void showViews(View... viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                makeViewVisible(view);
            }
        }
    }

    public static void hideViews(View... viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                makeViewGone(view);
            }
        }
    }
}
