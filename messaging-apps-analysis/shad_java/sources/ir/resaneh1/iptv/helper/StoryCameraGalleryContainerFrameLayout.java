package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.resaneh1.iptv.logger.MyLog;

/* loaded from: classes3.dex */
public class StoryCameraGalleryContainerFrameLayout extends FrameLayout {
    RecyclerView recyclerView;
    public boolean scrollEnable;

    public StoryCameraGalleryContainerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollEnable = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            if (this.scrollEnable) {
                recyclerView.onTouchEvent(motionEvent);
            }
            if (this.recyclerView.getScrollState() == 0) {
                MyLog.e("StoryCameraGalleryContainerFrameLayout", "scroll SCROLL_STATE_IDLE");
                return super.onInterceptTouchEvent(motionEvent);
            }
            MyLog.e("StoryCameraGalleryContainerFrameLayout", "scroll state" + this.recyclerView.getScrollState());
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null && this.scrollEnable) {
            recyclerView.onTouchEvent(motionEvent);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setScrollEnable(boolean z) {
        this.scrollEnable = z;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
