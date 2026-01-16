package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.BottomUpDragLayout;

/* loaded from: classes3.dex */
public class UIBottomUpDragLayout {
    public BottomUpDragLayout dragLayout;
    public FrameLayout frameLayout;
    public View view;

    public View createView(Activity activity, View view) {
        BottomUpDragLayout bottomUpDragLayout = (BottomUpDragLayout) activity.getLayoutInflater().inflate(R.layout.bottom_up_drag_layout, (ViewGroup) null);
        this.dragLayout = bottomUpDragLayout;
        this.view = bottomUpDragLayout;
        FrameLayout frameLayout = (FrameLayout) bottomUpDragLayout.findViewById(R.id.containerFrameLayout);
        this.frameLayout = frameLayout;
        frameLayout.addView(view);
        return this.view;
    }
}
