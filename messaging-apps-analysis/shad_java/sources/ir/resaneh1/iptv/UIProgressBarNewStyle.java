package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.CustomProgressView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RadialProgressView;

/* loaded from: classes3.dex */
public class UIProgressBarNewStyle {
    public static int minSize = 9;

    public static void addToFrame(Activity activity, FrameLayout frameLayout) {
        addToFrame(activity, frameLayout, 32);
    }

    public static void addToFrame(Activity activity, FrameLayout frameLayout, int i) {
        int i2 = minSize;
        if (i < i2) {
            i = i2;
        }
        View view = new View(activity);
        view.setBackgroundResource(R.drawable.circle_loading_progress);
        frameLayout.addView(view, LayoutHelper.createFrame(i, i, 17));
        RadialProgressView radialProgressView = new RadialProgressView(activity);
        radialProgressView.setSize(AndroidUtilities.dp(i - 8));
        radialProgressView.setProgressColor(activity.getResources().getColor(R.color.grey_800));
        int i3 = i - 4;
        frameLayout.addView(radialProgressView, LayoutHelper.createFrame(i3, i3, 17));
    }

    public static CustomProgressView addGameProgressBar(Activity activity, FrameLayout frameLayout, int i, int i2, int i3) {
        int i4 = minSize;
        if (i < i4) {
            i = i4;
        }
        View view = new View(activity);
        view.setBackgroundResource(R.drawable.transparent);
        frameLayout.addView(view, LayoutHelper.createFrame(i, i, 17));
        CustomProgressView customProgressView = new CustomProgressView(activity);
        customProgressView.setSize(i - 8, 8);
        customProgressView.setProgressColor(activity.getResources().getColor(i2), activity.getResources().getColor(i3));
        frameLayout.addView(customProgressView, LayoutHelper.createFrame(i, i, 17));
        return customProgressView;
    }

    public static CustomProgressView addStoryProgressBar(Activity activity, FrameLayout frameLayout, int i, int i2, int i3) {
        int i4 = minSize;
        if (i < i4) {
            i = i4;
        }
        View view = new View(activity);
        view.setBackgroundResource(R.drawable.circle_grey_700_alpha_50);
        frameLayout.addView(view, LayoutHelper.createFrame(i, i, 17));
        CustomProgressView customProgressView = new CustomProgressView(activity);
        customProgressView.setSize(i - 2, 2);
        customProgressView.setProgressColor(activity.getResources().getColor(i2), activity.getResources().getColor(i3));
        frameLayout.addView(customProgressView, LayoutHelper.createFrame(i, i, 17));
        return customProgressView;
    }

    public static void addToFrameWithWhiteBackground(Activity activity, FrameLayout frameLayout, int i) {
        int i2 = minSize;
        if (i < i2) {
            i = i2;
        }
        View view = new View(activity);
        view.setBackgroundResource(R.drawable.circle_grey_light);
        frameLayout.addView(view, LayoutHelper.createFrame(i, i, 17));
        RadialProgressView radialProgressView = new RadialProgressView(activity);
        radialProgressView.setSize(AndroidUtilities.dp(i - 8));
        radialProgressView.setProgressColor(activity.getResources().getColor(R.color.grey_800));
        int i3 = i - 4;
        frameLayout.addView(radialProgressView, LayoutHelper.createFrame(i3, i3, 17));
    }

    public static void addToFrameWhiteWithTransparentBackground(Activity activity, FrameLayout frameLayout, int i) {
        int i2 = minSize;
        if (i < i2) {
            i = i2;
        }
        View view = new View(activity);
        view.setBackgroundResource(R.drawable.transparent);
        frameLayout.addView(view, LayoutHelper.createFrame(i, i, 17));
        RadialProgressView radialProgressView = new RadialProgressView(activity);
        radialProgressView.setSize(AndroidUtilities.dp(i - 8));
        radialProgressView.setProgressColor(activity.getResources().getColor(R.color.white));
        int i3 = i - 4;
        frameLayout.addView(radialProgressView, LayoutHelper.createFrame(i3, i3, 17));
    }
}
