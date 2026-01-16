package ir.nasim.designsystem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import ir.nasim.C19406qI3;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public class NonSwipeAbleViewPager extends ViewPager {

    public class a extends Scroller {
        a(Context context) {
            super(context, new DecelerateInterpolator());
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, 300);
        }
    }

    public NonSwipeAbleViewPager(Context context) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context);
        S();
    }

    private void S() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            declaredField.set(this, new a(getContext()));
        } catch (Exception e) {
            C19406qI3.d("NonSwipeAbleViewPager", e);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public NonSwipeAbleViewPager(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet);
        S();
    }
}
