package ir.nasim.features.media.components;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14433hu3;
import ir.nasim.C19406qI3;
import ir.nasim.KB5;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class ActionBarPopupWindow extends PopupWindow {
    private static final Field e;
    private static DecelerateInterpolator f = new DecelerateInterpolator();
    private static final ViewTreeObserver.OnScrollChangedListener g;
    private AnimatorSet a;
    private boolean b;
    private ViewTreeObserver.OnScrollChangedListener c;
    private ViewTreeObserver d;

    public static class ActionBarPopupWindowLayout extends FrameLayout {
        protected static Drawable backgroundDrawable;
        private OnDispatchKeyEventListener a;
        private float b;
        private float c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private HashMap h;
        private ScrollView i;
        private LinearLayout j;
        public boolean showBackgroundDrawable;

        public ActionBarPopupWindowLayout(Context context) {
            super(context);
            this.showBackgroundDrawable = true;
            this.b = 1.0f;
            this.c = 1.0f;
            this.d = 255;
            this.e = 0;
            this.g = true;
            this.h = new HashMap();
            if (backgroundDrawable == null) {
                backgroundDrawable = getResources().getDrawable(KB5.popup_fixed);
            }
            setPadding(AbstractC7426Rr.z(8.0f), AbstractC7426Rr.z(8.0f), AbstractC7426Rr.z(8.0f), AbstractC7426Rr.z(8.0f));
            setWillNotDraw(false);
            try {
                ScrollView scrollView = new ScrollView(context);
                this.i = scrollView;
                scrollView.setVerticalScrollBarEnabled(false);
                addView(this.i, C14433hu3.a(-2, -2.0f));
            } catch (Throwable th) {
                C19406qI3.d("baleMessages", th);
            }
            LinearLayout linearLayout = new LinearLayout(context);
            this.j = linearLayout;
            linearLayout.setOrientation(1);
            ScrollView scrollView2 = this.i;
            if (scrollView2 != null) {
                scrollView2.addView(this.j, new FrameLayout.LayoutParams(-2, -2));
            } else {
                addView(this.j, C14433hu3.a(-2, -2.0f));
            }
        }

        private void c(View view) {
            if (this.g) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(view, "translationY", AbstractC7426Rr.z(this.f ? 6.0f : -6.0f), 0.0f));
                animatorSet.setDuration(180L);
                animatorSet.setInterpolator(ActionBarPopupWindow.f);
                animatorSet.start();
            }
        }

        @Override // android.view.ViewGroup
        public void addView(View view) {
            this.j.addView(view);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            OnDispatchKeyEventListener onDispatchKeyEventListener = this.a;
            if (onDispatchKeyEventListener != null) {
                onDispatchKeyEventListener.onDispatchKeyEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        public int getBackAlpha() {
            return this.d;
        }

        public float getBackScaleX() {
            return this.b;
        }

        public float getBackScaleY() {
            return this.c;
        }

        public View getItemAt(int i) {
            return this.j.getChildAt(i);
        }

        public int getItemsCount() {
            return this.j.getChildCount();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            Drawable drawable;
            if (!this.showBackgroundDrawable || (drawable = backgroundDrawable) == null) {
                return;
            }
            drawable.setAlpha(this.d);
            if (this.f) {
                backgroundDrawable.setBounds(0, (int) (getMeasuredHeight() * (1.0f - this.c)), (int) (getMeasuredWidth() * this.b), getMeasuredHeight());
            } else {
                backgroundDrawable.setBounds(0, 0, (int) (getMeasuredWidth() * this.b), (int) (getMeasuredHeight() * this.c));
            }
            backgroundDrawable.draw(canvas);
        }

        public void removeInnerViews() {
            this.j.removeAllViews();
        }

        public void scrollToTop() {
            ScrollView scrollView = this.i;
            if (scrollView != null) {
                scrollView.scrollTo(0, 0);
            }
        }

        public void setAnimationEnabled(boolean z) {
            this.g = z;
        }

        public void setBackAlpha(int i) {
            this.d = i;
        }

        public void setBackScaleX(float f) {
            this.b = f;
            invalidate();
        }

        public void setBackScaleY(float f) {
            this.c = f;
            if (this.g) {
                int itemsCount = getItemsCount();
                for (int i = 0; i < itemsCount; i++) {
                    getItemAt(i).getVisibility();
                }
                int measuredHeight = getMeasuredHeight() - AbstractC7426Rr.z(16.0f);
                if (this.f) {
                    for (int i2 = this.e; i2 >= 0; i2--) {
                        View itemAt = getItemAt(i2);
                        if (itemAt.getVisibility() == 0) {
                            if (((Integer) this.h.get(itemAt)) != null && measuredHeight - ((r4.intValue() * AbstractC7426Rr.z(48.0f)) + AbstractC7426Rr.z(32.0f)) > measuredHeight * f) {
                                break;
                            }
                            this.e = i2 - 1;
                            c(itemAt);
                        }
                    }
                } else {
                    for (int i3 = this.e; i3 < itemsCount; i3++) {
                        View itemAt2 = getItemAt(i3);
                        if (itemAt2.getVisibility() == 0) {
                            if (((Integer) this.h.get(itemAt2)) != null && ((r5.intValue() + 1) * AbstractC7426Rr.z(48.0f)) - AbstractC7426Rr.z(24.0f) > measuredHeight * f) {
                                break;
                            }
                            this.e = i3 + 1;
                            c(itemAt2);
                        }
                    }
                }
            }
            invalidate();
        }

        public void setDispatchKeyEventListener(OnDispatchKeyEventListener onDispatchKeyEventListener) {
            this.a = onDispatchKeyEventListener;
        }

        public void setShowedFromBotton(boolean z) {
            this.f = z;
        }
    }

    public interface OnDispatchKeyEventListener {
        void onDispatchKeyEvent(KeyEvent keyEvent);
    }

    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
        }
    }

    class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarPopupWindow.this.a = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarPopupWindow.this.a = null;
            ActionBarPopupWindow.this.setFocusable(false);
            try {
                ActionBarPopupWindow.super.dismiss();
            } catch (Exception unused) {
            }
            ActionBarPopupWindow.this.g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    static {
        Field declaredField = null;
        try {
            declaredField = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        e = declaredField;
        g = new a();
    }

    public ActionBarPopupWindow(View view, int i, int i2) throws IllegalAccessException, IllegalArgumentException {
        super(view, i, i2);
        this.b = true;
        e();
    }

    private void e() throws IllegalAccessException, IllegalArgumentException {
        Field field = e;
        if (field != null) {
            try {
                this.c = (ViewTreeObserver.OnScrollChangedListener) field.get(this);
                field.set(this, g);
            } catch (Exception unused) {
                this.c = null;
            }
        }
    }

    private void f(View view) {
        if (this.c != null) {
            ViewTreeObserver viewTreeObserver = view.getWindowToken() != null ? view.getViewTreeObserver() : null;
            ViewTreeObserver viewTreeObserver2 = this.d;
            if (viewTreeObserver != viewTreeObserver2) {
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    this.d.removeOnScrollChangedListener(this.c);
                }
                this.d = viewTreeObserver;
                if (viewTreeObserver != null) {
                    viewTreeObserver.addOnScrollChangedListener(this.c);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ViewTreeObserver viewTreeObserver;
        if (this.c == null || (viewTreeObserver = this.d) == null) {
            return;
        }
        if (viewTreeObserver.isAlive()) {
            this.d.removeOnScrollChangedListener(this.c);
        }
        this.d = null;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        dismiss(true);
    }

    public void setAnimationEnabled(boolean z) {
        this.b = z;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        try {
            super.showAsDropDown(view, i, i2);
            f(view);
        } catch (Exception e2) {
            C19406qI3.d("baleMessages", e2);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        g();
    }

    public void startAnimation() {
        if (this.b && this.a == null) {
            ActionBarPopupWindowLayout actionBarPopupWindowLayout = (ActionBarPopupWindowLayout) getContentView();
            actionBarPopupWindowLayout.setTranslationY(0.0f);
            actionBarPopupWindowLayout.setAlpha(1.0f);
            actionBarPopupWindowLayout.setPivotX(actionBarPopupWindowLayout.getMeasuredWidth());
            actionBarPopupWindowLayout.setPivotY(0.0f);
            int itemsCount = actionBarPopupWindowLayout.getItemsCount();
            actionBarPopupWindowLayout.h.clear();
            int i = 0;
            for (int i2 = 0; i2 < itemsCount; i2++) {
                View itemAt = actionBarPopupWindowLayout.getItemAt(i2);
                if (itemAt.getVisibility() == 0) {
                    actionBarPopupWindowLayout.h.put(itemAt, Integer.valueOf(i));
                    itemAt.setAlpha(0.0f);
                    i++;
                }
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.a = animatorSet;
            animatorSet.playTogether(ObjectAnimator.ofFloat(actionBarPopupWindowLayout, "backScaleY", 0.0f, 1.0f), ObjectAnimator.ofInt(actionBarPopupWindowLayout, "backAlpha", 0, 255));
            this.a.setDuration((i * 16) + 150);
            this.a.addListener(new b());
            this.a.start();
        }
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        super.update(view, i, i2, i3, i4);
        f(view);
    }

    public void dismiss(boolean z) {
        setFocusable(false);
        if (!this.b || !z) {
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
            g();
            return;
        }
        AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ActionBarPopupWindowLayout actionBarPopupWindowLayout = (ActionBarPopupWindowLayout) getContentView();
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.a = animatorSet2;
        animatorSet2.playTogether(ObjectAnimator.ofFloat(actionBarPopupWindowLayout, "translationY", AbstractC7426Rr.z(actionBarPopupWindowLayout.f ? 5.0f : -5.0f)), ObjectAnimator.ofFloat(actionBarPopupWindowLayout, "alpha", 0.0f));
        this.a.setDuration(150L);
        this.a.addListener(new c());
        this.a.start();
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2) {
        super.update(view, i, i2);
        f(view);
    }
}
