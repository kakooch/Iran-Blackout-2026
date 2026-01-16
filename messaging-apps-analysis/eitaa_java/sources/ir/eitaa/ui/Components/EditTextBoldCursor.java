package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.FloatingActionMode;
import ir.eitaa.ui.ActionBar.FloatingToolbar;
import ir.eitaa.ui.ActionBar.Theme;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class EditTextBoldCursor extends EditText {
    private static Class editorClass;
    private static Method getVerticalOffsetMethod;
    private static Field mCursorDrawableResField;
    private static Field mEditor;
    private static Field mScrollYField;
    private static boolean mScrollYGet;
    private static Field mShowCursorField;
    private int activeLineColor;
    private boolean allowDrawCursor;
    private View attachedToWindow;
    private boolean currentDrawHintAsHeader;
    ShapeDrawable cursorDrawable;
    private boolean cursorDrawn;
    private int cursorSize;
    private float cursorWidth;
    boolean drawInMaim;
    private Object editor;
    private int errorLineColor;
    private TextPaint errorPaint;
    private CharSequence errorText;
    private boolean fixed;
    private FloatingActionMode floatingActionMode;
    private FloatingToolbar floatingToolbar;
    private ViewTreeObserver.OnPreDrawListener floatingToolbarPreDrawListener;
    private GradientDrawable gradientDrawable;
    private float headerAnimationProgress;
    private int headerHintColor;
    private AnimatorSet headerTransformAnimation;
    private CharSequence hint;
    private float hintAlpha;
    private SubstringLayoutAnimator hintAnimator;
    private int hintColor;
    private StaticLayout hintLayout;
    private boolean hintVisible;
    private int ignoreBottomCount;
    private int ignoreTopCount;
    private Runnable invalidateRunnable;
    int lastOffset;
    private int lastSize;
    CharSequence lastText;
    private long lastUpdateTime;
    private int lineColor;
    private Paint linePaint;
    private float lineSpacingExtra;
    private float lineY;
    private ViewTreeObserver.OnPreDrawListener listenerFixer;
    private android.graphics.Rect mTempRect;
    private boolean nextSetTextAnimated;
    private android.graphics.Rect rect;
    private int scrollY;
    private boolean supportRtlHint;
    private boolean transformHintToHeader;
    private View windowView;

    protected void extendActionMode(ActionMode actionMode, Menu menu) {
    }

    protected int getActionModeStyle() {
        return 1;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(26)
    public int getAutofillType() {
        return 0;
    }

    protected Theme.ResourcesProvider getResourcesProvider() {
        return null;
    }

    @TargetApi(23)
    private class ActionModeCallback2Wrapper extends ActionMode.Callback2 {
        private final ActionMode.Callback mWrapped;

        public ActionModeCallback2Wrapper(ActionMode.Callback wrapped) {
            this.mWrapped = wrapped;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return this.mWrapped.onCreateActionMode(mode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return this.mWrapped.onPrepareActionMode(mode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return this.mWrapped.onActionItemClicked(mode, item);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode mode) {
            this.mWrapped.onDestroyActionMode(mode);
            EditTextBoldCursor.this.cleanupFloatingActionModeViews();
            EditTextBoldCursor.this.floatingActionMode = null;
        }

        @Override // android.view.ActionMode.Callback2
        public void onGetContentRect(ActionMode mode, View view, android.graphics.Rect outRect) {
            ActionMode.Callback callback = this.mWrapped;
            if (callback instanceof ActionMode.Callback2) {
                ((ActionMode.Callback2) callback).onGetContentRect(mode, view, outRect);
            } else {
                super.onGetContentRect(mode, view, outRect);
            }
        }
    }

    public EditTextBoldCursor(Context context) {
        super(context);
        this.invalidateRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.EditTextBoldCursor.1
            @Override // java.lang.Runnable
            public void run() {
                EditTextBoldCursor.this.invalidate();
                if (EditTextBoldCursor.this.attachedToWindow != null) {
                    AndroidUtilities.runOnUIThread(this, 500L);
                }
            }
        };
        this.rect = new android.graphics.Rect();
        this.hintVisible = true;
        this.hintAlpha = 1.0f;
        this.allowDrawCursor = true;
        this.cursorWidth = 2.0f;
        this.lastOffset = -1;
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(2);
        }
        setTypeface(AndroidUtilities.getFontFamily(false));
        init();
    }

    @Override // android.widget.TextView
    public Drawable getTextCursorDrawable() {
        if (this.cursorDrawable != null) {
            return super.getTextCursorDrawable();
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape()) { // from class: ir.eitaa.ui.Components.EditTextBoldCursor.2
            @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                super.draw(canvas);
                EditTextBoldCursor.this.cursorDrawn = true;
            }
        };
        shapeDrawable.getPaint().setColor(0);
        return shapeDrawable;
    }

    @SuppressLint({"PrivateApi"})
    private void init() {
        this.linePaint = new Paint();
        TextPaint textPaint = new TextPaint(1);
        this.errorPaint = textPaint;
        textPaint.setTextSize(AndroidUtilities.dp(11.0f));
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            setImportantForAutofill(2);
        }
        if (i >= 29) {
            ShapeDrawable shapeDrawable = new ShapeDrawable() { // from class: ir.eitaa.ui.Components.EditTextBoldCursor.3
                @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
                public void draw(Canvas canvas) {
                    EditTextBoldCursor editTextBoldCursor = EditTextBoldCursor.this;
                    if (editTextBoldCursor.drawInMaim) {
                        editTextBoldCursor.cursorDrawn = true;
                    } else {
                        super.draw(canvas);
                    }
                }

                @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
                public int getIntrinsicHeight() {
                    return AndroidUtilities.dp(EditTextBoldCursor.this.cursorSize + 20);
                }

                @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
                public int getIntrinsicWidth() {
                    return AndroidUtilities.dp(EditTextBoldCursor.this.cursorWidth);
                }
            };
            this.cursorDrawable = shapeDrawable;
            shapeDrawable.setShape(new RectShape());
            this.gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-11230757, -11230757});
            setTextCursorDrawable(this.cursorDrawable);
        }
        try {
            if (!mScrollYGet && mScrollYField == null) {
                mScrollYGet = true;
                Field declaredField = View.class.getDeclaredField("mScrollY");
                mScrollYField = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (Throwable unused) {
        }
        try {
            if (editorClass == null) {
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                mEditor = declaredField2;
                declaredField2.setAccessible(true);
                Class<?> cls = Class.forName("android.widget.Editor");
                editorClass = cls;
                try {
                    Field declaredField3 = cls.getDeclaredField("mShowCursor");
                    mShowCursorField = declaredField3;
                    declaredField3.setAccessible(true);
                } catch (Exception unused2) {
                }
                Method declaredMethod = TextView.class.getDeclaredMethod("getVerticalOffset", Boolean.TYPE);
                getVerticalOffsetMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
        if (this.cursorDrawable == null) {
            try {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-11230757, -11230757});
                this.gradientDrawable = gradientDrawable;
                if (Build.VERSION.SDK_INT >= 29) {
                    setTextCursorDrawable(gradientDrawable);
                }
                this.editor = mEditor.get(this);
            } catch (Throwable unused3) {
            }
            try {
                if (mCursorDrawableResField == null) {
                    Field declaredField4 = TextView.class.getDeclaredField("mCursorDrawableRes");
                    mCursorDrawableResField = declaredField4;
                    declaredField4.setAccessible(true);
                }
                Field field = mCursorDrawableResField;
                if (field != null) {
                    field.set(this, Integer.valueOf(R.drawable.field_carret_empty));
                }
            } catch (Throwable unused4) {
            }
        }
        this.cursorSize = AndroidUtilities.dp(24.0f);
    }

    @SuppressLint({"PrivateApi"})
    public void fixHandleView(boolean reset) {
        if (reset) {
            this.fixed = false;
            return;
        }
        if (this.fixed) {
            return;
        }
        try {
            if (editorClass == null) {
                editorClass = Class.forName("android.widget.Editor");
                Field declaredField = TextView.class.getDeclaredField("mEditor");
                mEditor = declaredField;
                declaredField.setAccessible(true);
                this.editor = mEditor.get(this);
            }
            if (this.listenerFixer == null) {
                Method declaredMethod = editorClass.getDeclaredMethod("getPositionListener", new Class[0]);
                declaredMethod.setAccessible(true);
                this.listenerFixer = (ViewTreeObserver.OnPreDrawListener) declaredMethod.invoke(this.editor, new Object[0]);
            }
            final ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.listenerFixer;
            onPreDrawListener.getClass();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ybpATXRTPnWUuExFUFhbS_06LOc
                @Override // java.lang.Runnable
                public final void run() {
                    onPreDrawListener.onPreDraw();
                }
            }, 500L);
        } catch (Throwable unused) {
        }
        this.fixed = true;
    }

    public void setTransformHintToHeader(boolean value) {
        if (this.transformHintToHeader == value) {
            return;
        }
        this.transformHintToHeader = value;
        AnimatorSet animatorSet = this.headerTransformAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.headerTransformAnimation = null;
        }
    }

    public void setAllowDrawCursor(boolean value) {
        this.allowDrawCursor = value;
        invalidate();
    }

    public void setCursorWidth(float width) {
        this.cursorWidth = width;
    }

    public void setCursorColor(int color) {
        ShapeDrawable shapeDrawable = this.cursorDrawable;
        if (shapeDrawable != null) {
            shapeDrawable.getPaint().setColor(color);
        }
        GradientDrawable gradientDrawable = this.gradientDrawable;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(color);
        }
        invalidate();
    }

    public void setCursorSize(int value) {
        this.cursorSize = value;
    }

    public void setErrorLineColor(int error) {
        this.errorLineColor = error;
        this.errorPaint.setColor(error);
        invalidate();
    }

    public void setLineColors(int color, int active, int error) {
        this.lineColor = color;
        this.activeLineColor = active;
        this.errorLineColor = error;
        this.errorPaint.setColor(error);
        invalidate();
    }

    public void setHintVisible(boolean value) {
        if (this.hintVisible == value) {
            return;
        }
        this.lastUpdateTime = System.currentTimeMillis();
        this.hintVisible = value;
        invalidate();
    }

    public void setHintColor(int value) {
        this.hintColor = value;
        invalidate();
    }

    public void setHeaderHintColor(int value) {
        this.headerHintColor = value;
        invalidate();
    }

    public void setNextSetTextAnimated(boolean value) {
        this.nextSetTextAnimated = value;
    }

    public void setErrorText(CharSequence text) {
        if (TextUtils.equals(text, this.errorText)) {
            return;
        }
        this.errorText = text;
        requestLayout();
    }

    public boolean hasErrorText() {
        return !TextUtils.isEmpty(this.errorText);
    }

    public StaticLayout getErrorLayout(int width) {
        if (TextUtils.isEmpty(this.errorText)) {
            return null;
        }
        return new StaticLayout(this.errorText, this.errorPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    public float getLineY() {
        return this.lineY;
    }

    public void setSupportRtlHint(boolean value) {
        this.supportRtlHint = value;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        if (horiz != oldHoriz) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        super.setText(text, type);
        checkHeaderVisibility(this.nextSetTextAnimated);
        this.nextSetTextAnimated = false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredHeight = getMeasuredHeight() + (getMeasuredWidth() << 16);
        if (this.hintLayout != null) {
            if (this.lastSize != measuredHeight) {
                setHintText(this.hint);
            }
            this.lineY = ((getMeasuredHeight() - this.hintLayout.getHeight()) / 2.0f) + this.hintLayout.getHeight() + AndroidUtilities.dp(6.0f);
        }
        this.lastSize = measuredHeight;
    }

    public void setHintText(CharSequence text) {
        setHintText(text, false);
    }

    public void setHintText(CharSequence text, boolean animated) {
        if (text == null) {
            text = "";
        }
        if (getMeasuredWidth() == 0) {
            animated = false;
        }
        if (animated) {
            if (this.hintAnimator == null) {
                this.hintAnimator = new SubstringLayoutAnimator(this);
            }
            this.hintAnimator.create(this.hintLayout, this.hint, text, getPaint());
        } else {
            SubstringLayoutAnimator substringLayoutAnimator = this.hintAnimator;
            if (substringLayoutAnimator != null) {
                substringLayoutAnimator.cancel();
            }
        }
        this.hint = text;
        if (getMeasuredWidth() != 0) {
            text = TextUtils.ellipsize(text, getPaint(), getMeasuredWidth(), TextUtils.TruncateAt.END);
            StaticLayout staticLayout = this.hintLayout;
            if (staticLayout != null && TextUtils.equals(staticLayout.getText(), text)) {
                return;
            }
        }
        this.hintLayout = new StaticLayout(text, getPaint(), AndroidUtilities.dp(1000.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    public Layout getHintLayoutEx() {
        return this.hintLayout;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) {
        try {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        } catch (Exception e) {
            FileLog.e(e);
        }
        checkHeaderVisibility(true);
    }

    private void checkHeaderVisibility(boolean animated) {
        boolean z = this.transformHintToHeader && (isFocused() || getText().length() > 0);
        if (this.currentDrawHintAsHeader != z) {
            AnimatorSet animatorSet = this.headerTransformAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.headerTransformAnimation = null;
            }
            this.currentDrawHintAsHeader = z;
            if (animated) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.headerTransformAnimation = animatorSet2;
                Animator[] animatorArr = new Animator[1];
                float[] fArr = new float[1];
                fArr[0] = z ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(this, "headerAnimationProgress", fArr);
                animatorSet2.playTogether(animatorArr);
                this.headerTransformAnimation.setDuration(200L);
                this.headerTransformAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
                this.headerTransformAnimation.start();
            } else {
                this.headerAnimationProgress = z ? 1.0f : 0.0f;
            }
            invalidate();
        }
    }

    @Keep
    public void setHeaderAnimationProgress(float value) {
        this.headerAnimationProgress = value;
        invalidate();
    }

    @Keep
    public float getHeaderAnimationProgress() {
        return this.headerAnimationProgress;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float add, float mult) {
        super.setLineSpacing(add, mult);
        this.lineSpacingExtra = add;
    }

    @Override // android.widget.TextView
    public int getExtendedPaddingTop() {
        int i = this.ignoreTopCount;
        if (i != 0) {
            this.ignoreTopCount = i - 1;
            return 0;
        }
        return super.getExtendedPaddingTop();
    }

    @Override // android.widget.TextView
    public int getExtendedPaddingBottom() {
        int i = this.ignoreBottomCount;
        if (i != 0) {
            this.ignoreBottomCount = i - 1;
            int i2 = this.scrollY;
            if (i2 != Integer.MAX_VALUE) {
                return -i2;
            }
            return 0;
        }
        return super.getExtendedPaddingBottom();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0342  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r18) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.EditTextBoldCursor.onDraw(android.graphics.Canvas):void");
    }

    public void setWindowView(View view) {
        this.windowView = view;
    }

    private boolean updateCursorPosition() {
        Layout layout = getLayout();
        int selectionStart = getSelectionStart();
        int lineForOffset = layout.getLineForOffset(selectionStart);
        updateCursorPosition(layout.getLineTop(lineForOffset), layout.getLineTop(lineForOffset + 1), layout.getPrimaryHorizontal(selectionStart));
        this.lastText = layout.getText();
        this.lastOffset = selectionStart;
        return true;
    }

    private int clampHorizontalPosition(final Drawable drawable, float horizontal) {
        int i;
        float fMax = Math.max(0.5f, horizontal - 0.5f);
        if (this.mTempRect == null) {
            this.mTempRect = new android.graphics.Rect();
        }
        int intrinsicWidth = 0;
        if (drawable != null) {
            drawable.getPadding(this.mTempRect);
            intrinsicWidth = drawable.getIntrinsicWidth();
        } else {
            this.mTempRect.setEmpty();
        }
        int scrollX = getScrollX();
        float f = fMax - scrollX;
        int width = (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        float f2 = width;
        if (f >= f2 - 1.0f) {
            return (width + scrollX) - (intrinsicWidth - this.mTempRect.right);
        }
        if (Math.abs(f) <= 1.0f || (TextUtils.isEmpty(getText()) && 1048576 - scrollX <= f2 + 1.0f && fMax <= 1.0f)) {
            i = this.mTempRect.left;
        } else {
            scrollX = (int) fMax;
            i = this.mTempRect.left;
        }
        return scrollX - i;
    }

    private void updateCursorPosition(int top, int bottom, float horizontal) {
        int iClampHorizontalPosition = clampHorizontalPosition(this.gradientDrawable, horizontal);
        int iDp = AndroidUtilities.dp(this.cursorWidth);
        GradientDrawable gradientDrawable = this.gradientDrawable;
        android.graphics.Rect rect = this.mTempRect;
        gradientDrawable.setBounds(iClampHorizontalPosition, top - rect.top, iDp + iClampHorizontalPosition, bottom + rect.bottom);
    }

    @Override // android.widget.TextView
    public float getLineSpacingExtra() {
        return super.getLineSpacingExtra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanupFloatingActionModeViews() {
        FloatingToolbar floatingToolbar = this.floatingToolbar;
        if (floatingToolbar != null) {
            floatingToolbar.dismiss();
            this.floatingToolbar = null;
        }
        if (this.floatingToolbarPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.floatingToolbarPreDrawListener);
            this.floatingToolbarPreDrawListener = null;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.attachedToWindow = getRootView();
        AndroidUtilities.runOnUIThread(this.invalidateRunnable);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = null;
        AndroidUtilities.cancelRunOnUIThread(this.invalidateRunnable);
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 23 && (this.windowView != null || this.attachedToWindow != null)) {
            FloatingActionMode floatingActionMode = this.floatingActionMode;
            if (floatingActionMode != null) {
                floatingActionMode.finish();
            }
            cleanupFloatingActionModeViews();
            Context context = getContext();
            View view = this.windowView;
            if (view == null) {
                view = this.attachedToWindow;
            }
            this.floatingToolbar = new FloatingToolbar(context, view, getActionModeStyle(), getResourcesProvider());
            FloatingActionMode floatingActionMode2 = new FloatingActionMode(getContext(), new ActionModeCallback2Wrapper(callback), this, this.floatingToolbar);
            this.floatingActionMode = floatingActionMode2;
            this.floatingToolbarPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EditTextBoldCursor$3diHeT1ZIDkmLAMPw36da--usss
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    return this.f$0.lambda$startActionMode$0$EditTextBoldCursor();
                }
            };
            callback.onCreateActionMode(floatingActionMode2, floatingActionMode2.getMenu());
            FloatingActionMode floatingActionMode3 = this.floatingActionMode;
            extendActionMode(floatingActionMode3, floatingActionMode3.getMenu());
            this.floatingActionMode.invalidate();
            getViewTreeObserver().addOnPreDrawListener(this.floatingToolbarPreDrawListener);
            invalidate();
            return this.floatingActionMode;
        }
        return super.startActionMode(callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startActionMode$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$startActionMode$0$EditTextBoldCursor() {
        FloatingActionMode floatingActionMode = this.floatingActionMode;
        if (floatingActionMode == null) {
            return true;
        }
        floatingActionMode.updateViewLocationInWindow();
        return true;
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback, int type) {
        if (Build.VERSION.SDK_INT >= 23 && (this.windowView != null || this.attachedToWindow != null)) {
            return startActionMode(callback);
        }
        return super.startActionMode(callback, type);
    }

    public void hideActionMode() {
        cleanupFloatingActionModeViews();
    }

    @Override // android.widget.EditText
    public void setSelection(int start, int stop) {
        try {
            super.setSelection(start, stop);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // android.widget.EditText
    public void setSelection(int index) {
        try {
            super.setSelection(index);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.EditText");
        if (this.hintLayout != null) {
            AccessibilityNodeInfoCompat.wrap(info).setHintText(this.hintLayout.getText());
        }
    }
}
