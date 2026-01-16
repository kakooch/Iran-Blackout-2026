package ir.nasim.jaryan;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lir/nasim/jaryan/JaryanSwipeToRefresh;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", "event", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "K0", TokenNames.I, "mTouchSlop", "", "L0", TokenNames.F, "mPrevX", "M0", "Z", "mDeclined", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class JaryanSwipeToRefresh extends SwipeRefreshLayout {

    /* renamed from: K0, reason: from kotlin metadata */
    private final int mTouchSlop;

    /* renamed from: L0, reason: from kotlin metadata */
    private float mPrevX;

    /* renamed from: M0, reason: from kotlin metadata */
    private boolean mDeclined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JaryanSwipeToRefresh(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        AbstractC13042fc3.i(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.mPrevX = MotionEvent.obtain(event).getX();
            this.mDeclined = false;
        } else if (action == 2) {
            float fAbs = Math.abs(event.getX() - this.mPrevX);
            if (this.mDeclined || fAbs > this.mTouchSlop) {
                this.mDeclined = true;
                return false;
            }
        }
        return super.onInterceptTouchEvent(event);
    }
}
