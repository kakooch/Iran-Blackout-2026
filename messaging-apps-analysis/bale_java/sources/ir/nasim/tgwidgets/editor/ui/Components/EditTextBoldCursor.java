package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.Keep;
import ir.nasim.AbstractC14867ic8;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.C23390wq2;
import ir.nasim.C23491x07;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.X2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes7.dex */
public class EditTextBoldCursor extends EditTextEffects {
    private static Method A1;
    private static Field t1;
    private static Field u1;
    private static Field v1;
    private static boolean w1;
    private static Method x1;
    private static Class y1;
    private static Field z1;
    private TextPaint A;
    private StaticLayout A0;
    private int B;
    private CharSequence B0;
    private CharSequence C0;
    private int D;
    private int D0;
    private int E0;
    private boolean F0;
    private int G;
    private float G0;
    private int H;
    private long H0;
    private boolean I0;
    private float J;
    private float J0;
    private boolean K0;
    public boolean L0;
    private boolean M0;
    private boolean N0;
    private int O0;
    private int P0;
    private int Q0;
    private float R0;
    private boolean S0;
    private float T0;
    private long U0;
    private float V0;
    private float W0;
    private boolean X0;
    private boolean Y0;
    private boolean Z0;
    private AnimatorSet a1;
    private float b1;
    private boolean c1;
    private ViewTreeObserver.OnPreDrawListener d1;
    private ir.nasim.tgwidgets.editor.ui.ActionBar.f e1;
    public C23390wq2 f1;
    private ViewTreeObserver.OnPreDrawListener g1;
    private View h1;
    private View i1;
    private int j1;
    int k1;
    CharSequence l1;
    boolean m1;
    ShapeDrawable n1;
    private List o1;
    private boolean p1;
    private Rect q1;
    private int r1;
    private Rect s1;
    private Object u;
    private GradientDrawable v;
    private C23491x07 w;
    private Runnable x;
    private Paint y;
    private Paint z;
    private Rect z0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EditTextBoldCursor.this.invalidate();
            if (EditTextBoldCursor.this.i1 != null) {
                AbstractC21455b.n1(this, 500L);
            }
        }
    }

    class b extends ShapeDrawable {
        b(Shape shape) {
            super(shape);
        }

        @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            super.draw(canvas);
            EditTextBoldCursor.this.M0 = true;
        }
    }

    class c extends ShapeDrawable {
        c() {
        }

        @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            EditTextBoldCursor editTextBoldCursor = EditTextBoldCursor.this;
            if (editTextBoldCursor.m1) {
                editTextBoldCursor.M0 = true;
            } else {
                super.draw(canvas);
            }
        }

        @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return AbstractC21455b.F(EditTextBoldCursor.this.B + 20);
        }

        @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return AbstractC21455b.F(EditTextBoldCursor.this.J0);
        }
    }

    private class d extends ActionMode.Callback2 {
        private final ActionMode.Callback a;

        public d(ActionMode.Callback callback) {
            this.a = callback;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.a.onDestroyActionMode(actionMode);
            EditTextBoldCursor.this.z();
            EditTextBoldCursor.this.f1 = null;
        }

        @Override // android.view.ActionMode.Callback2
        public void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
            ActionMode.Callback callback = this.a;
            if (callback instanceof ActionMode.Callback2) {
                ((ActionMode.Callback2) callback).onGetContentRect(actionMode, view, rect);
            } else {
                super.onGetContentRect(actionMode, view, rect);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.a.onPrepareActionMode(actionMode, menu);
        }
    }

    public EditTextBoldCursor(Context context) {
        super(context);
        this.x = new a();
        this.z0 = new Rect();
        this.F0 = true;
        this.G0 = 1.0f;
        this.I0 = true;
        this.J0 = 2.0f;
        this.N0 = false;
        this.S0 = false;
        this.T0 = 0.0f;
        this.V0 = 0.0f;
        this.W0 = 0.0f;
        this.k1 = -1;
        this.o1 = new ArrayList();
        this.p1 = false;
        this.q1 = new Rect();
        this.r1 = -1;
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(2);
        }
        C();
    }

    private void C() {
        this.y = new Paint();
        this.z = new Paint();
        TextPaint textPaint = new TextPaint(1);
        this.A = textPaint;
        textPaint.setTextSize(AbstractC21455b.F(11.0f));
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            setImportantForAutofill(2);
        }
        if (i >= 29) {
            c cVar = new c();
            this.n1 = cVar;
            cVar.setShape(new RectShape());
            this.v = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-11230757, -11230757});
            setTextCursorDrawable(this.n1);
        }
        try {
            if (!w1 && v1 == null) {
                w1 = true;
                Field declaredField = View.class.getDeclaredField("mScrollY");
                v1 = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (Throwable unused) {
        }
        try {
            if (y1 == null) {
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                t1 = declaredField2;
                declaredField2.setAccessible(true);
                Class<?> cls = Class.forName("android.widget.Editor");
                y1 = cls;
                try {
                    Field declaredField3 = cls.getDeclaredField("mShowCursor");
                    u1 = declaredField3;
                    declaredField3.setAccessible(true);
                } catch (Exception unused2) {
                }
                try {
                    Method declaredMethod = y1.getDeclaredMethod("invalidateTextDisplayList", null);
                    A1 = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused3) {
                }
                Method declaredMethod2 = TextView.class.getDeclaredMethod("getVerticalOffset", Boolean.TYPE);
                x1 = declaredMethod2;
                declaredMethod2.setAccessible(true);
            }
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
        }
        if (this.n1 == null) {
            try {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-11230757, -11230757});
                this.v = gradientDrawable;
                if (Build.VERSION.SDK_INT >= 29) {
                    setTextCursorDrawable(gradientDrawable);
                }
                this.u = t1.get(this);
            } catch (Throwable unused4) {
            }
            try {
                if (z1 == null) {
                    Field declaredField4 = TextView.class.getDeclaredField("mCursorDrawableRes");
                    z1 = declaredField4;
                    declaredField4.setAccessible(true);
                }
                Field field = z1;
                if (field != null) {
                    field.set(this, Integer.valueOf(AbstractC23598xB5.field_carret_empty));
                }
            } catch (Throwable unused5) {
            }
        }
        this.B = AbstractC21455b.F(24.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean E() {
        C23390wq2 c23390wq2 = this.f1;
        if (c23390wq2 == null) {
            return true;
        }
        c23390wq2.m();
        return true;
    }

    private void F(int i, int i2, float f) {
        int iY = y(this.v, f);
        int iF = AbstractC21455b.F(this.J0);
        GradientDrawable gradientDrawable = this.v;
        Rect rect = this.s1;
        gradientDrawable.setBounds(iY, i - rect.top, iF + iY, i2 + rect.bottom);
    }

    private boolean G() {
        Layout layout = getLayout();
        int selectionStart = getSelectionStart();
        int lineForOffset = layout.getLineForOffset(selectionStart);
        F(layout.getLineTop(lineForOffset), layout.getLineTop(lineForOffset + 1), layout.getPrimaryHorizontal(selectionStart));
        this.l1 = layout.getText();
        this.k1 = selectionStart;
        return true;
    }

    private void x(boolean z) {
        boolean z2 = this.Y0 && (isFocused() || getText().length() > 0);
        if (this.Z0 != z2) {
            AnimatorSet animatorSet = this.a1;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.a1 = null;
            }
            this.Z0 = z2;
            if (z) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.a1 = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this, "headerAnimationProgress", z2 ? 1.0f : 0.0f));
                this.a1.setDuration(200L);
                this.a1.setInterpolator(InterpolatorC12631ew1.h);
                this.a1.start();
            } else {
                this.b1 = z2 ? 1.0f : 0.0f;
            }
            invalidate();
        }
    }

    private int y(Drawable drawable, float f) {
        int intrinsicWidth;
        float fMax = Math.max(0.5f, f - 0.5f);
        if (this.s1 == null) {
            this.s1 = new Rect();
        }
        if (drawable != null) {
            drawable.getPadding(this.s1);
            intrinsicWidth = drawable.getIntrinsicWidth();
        } else {
            this.s1.setEmpty();
            intrinsicWidth = 0;
        }
        int scrollX = getScrollX();
        float f2 = fMax - scrollX;
        int width = (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        float f3 = width;
        return f2 >= f3 - 1.0f ? (width + scrollX) - (intrinsicWidth - this.s1.right) : (Math.abs(f2) <= 1.0f || (TextUtils.isEmpty(getText()) && ((float) (1048576 - scrollX)) <= f3 + 1.0f && fMax <= 1.0f)) ? scrollX - this.s1.left : ((int) fMax) - this.s1.left;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        ir.nasim.tgwidgets.editor.ui.ActionBar.f fVar = this.e1;
        if (fVar != null) {
            fVar.r();
            this.e1 = null;
        }
        if (this.g1 != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.g1);
            this.g1 = null;
        }
    }

    protected void A(ActionMode actionMode, Menu menu) {
    }

    public void B(boolean z) {
        if (z) {
            this.c1 = false;
            return;
        }
        if (this.c1) {
            return;
        }
        try {
            if (y1 == null) {
                y1 = Class.forName("android.widget.Editor");
                Field declaredField = TextView.class.getDeclaredField("mEditor");
                t1 = declaredField;
                declaredField.setAccessible(true);
                this.u = t1.get(this);
            }
            if (this.d1 == null) {
                Method declaredMethod = y1.getDeclaredMethod("getPositionListener", null);
                declaredMethod.setAccessible(true);
                this.d1 = (ViewTreeObserver.OnPreDrawListener) declaredMethod.invoke(this.u, null);
            }
            final ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.d1;
            Objects.requireNonNull(onPreDrawListener);
            AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.q42
                @Override // java.lang.Runnable
                public final void run() {
                    onPreDrawListener.onPreDraw();
                }
            }, 500L);
        } catch (Throwable unused) {
        }
        this.c1 = true;
    }

    public void D() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        invalidate();
        if (isHardwareAccelerated()) {
            try {
                if (A1 != null) {
                    if (this.u == null) {
                        this.u = t1.get(this);
                    }
                    Object obj = this.u;
                    if (obj != null) {
                        A1.invoke(obj, null);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher textWatcher) {
        this.o1.add(textWatcher);
        if (this.p1) {
            return;
        }
        super.addTextChangedListener(textWatcher);
    }

    protected int getActionModeStyle() {
        return 1;
    }

    @Override // android.widget.TextView, android.view.View
    public int getAutofillType() {
        return 0;
    }

    @Override // android.widget.TextView
    public int getExtendedPaddingBottom() {
        int i = this.G;
        if (i == 0) {
            return super.getExtendedPaddingBottom();
        }
        this.G = i - 1;
        int i2 = this.H;
        if (i2 != Integer.MAX_VALUE) {
            return -i2;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getExtendedPaddingTop() {
        if (this.L0) {
            return 0;
        }
        int i = this.D;
        if (i == 0) {
            return super.getExtendedPaddingTop();
        }
        this.D = i - 1;
        return 0;
    }

    @Keep
    public float getHeaderAnimationProgress() {
        return this.b1;
    }

    public Layout getHintLayoutEx() {
        return this.A0;
    }

    @Override // android.widget.TextView
    public float getLineSpacingExtra() {
        return super.getLineSpacingExtra();
    }

    public float getLineY() {
        return this.R0;
    }

    protected m.h getResourcesProvider() {
        return null;
    }

    @Override // android.widget.TextView
    public Drawable getTextCursorDrawable() {
        if (this.n1 != null) {
            return super.getTextCursorDrawable();
        }
        b bVar = new b(new RectShape());
        bVar.getPaint().setColor(0);
        return bVar;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        this.i1 = getRootView();
        AbstractC21455b.m1(this.x);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i1 = null;
        AbstractC21455b.t(this.x);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02ec  */
    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r16) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 1208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            super.onFocusChanged(z, i, rect);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        x(true);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.EditText");
        if (this.A0 != null) {
            if (getText().length() <= 0) {
                accessibilityNodeInfo.setText(this.A0.getText());
            } else {
                X2.g1(accessibilityNodeInfo).C0(this.A0.getText());
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight() + (getMeasuredWidth() << 16);
        if (this.A0 != null) {
            if (this.j1 != measuredHeight) {
                setHintText(this.B0);
            }
            this.R0 = ((getMeasuredHeight() - this.A0.getHeight()) / 2.0f) + this.A0.getHeight() + AbstractC21455b.F(6.0f);
        } else {
            this.R0 = getMeasuredHeight() - AbstractC21455b.F(2.0f);
        }
        this.j1 = measuredHeight;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (i != i3) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.r1 = (int) motionEvent.getX();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(TextWatcher textWatcher) {
        this.o1.remove(textWatcher);
        if (this.p1) {
            return;
        }
        super.removeTextChangedListener(textWatcher);
    }

    public void setAllowDrawCursor(boolean z) {
        this.I0 = z;
        invalidate();
    }

    public void setCursorColor(int i) {
        ShapeDrawable shapeDrawable = this.n1;
        if (shapeDrawable != null) {
            shapeDrawable.getPaint().setColor(i);
        }
        GradientDrawable gradientDrawable = this.v;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(i);
        }
        invalidate();
    }

    public void setCursorSize(int i) {
        this.B = i;
    }

    public void setCursorWidth(float f) {
        this.J0 = f;
    }

    public void setErrorLineColor(int i) {
        this.Q0 = i;
        this.A.setColor(i);
        invalidate();
    }

    public void setErrorText(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.C0)) {
            return;
        }
        this.C0 = charSequence;
        requestLayout();
    }

    public void setHandlesColor(int i) {
        if (Build.VERSION.SDK_INT < 29 || AbstractC14867ic8.a()) {
            return;
        }
        try {
            Drawable textSelectHandleLeft = getTextSelectHandleLeft();
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            textSelectHandleLeft.setColorFilter(i, mode);
            setTextSelectHandleLeft(textSelectHandleLeft);
            Drawable textSelectHandle = getTextSelectHandle();
            textSelectHandle.setColorFilter(i, mode);
            setTextSelectHandle(textSelectHandle);
            Drawable textSelectHandleRight = getTextSelectHandleRight();
            textSelectHandleRight.setColorFilter(i, mode);
            setTextSelectHandleRight(textSelectHandleRight);
        } catch (Exception unused) {
        }
    }

    @Keep
    public void setHeaderAnimationProgress(float f) {
        this.b1 = f;
        invalidate();
    }

    public void setHeaderHintColor(int i) {
        this.E0 = i;
        invalidate();
    }

    public void setHintColor(int i) {
        this.D0 = i;
        invalidate();
    }

    public void setHintText(CharSequence charSequence) {
        setHintText(charSequence, false);
    }

    public void setHintVisible(boolean z, boolean z2) {
        if (this.F0 == z) {
            return;
        }
        this.H0 = System.currentTimeMillis();
        this.F0 = z;
        if (!z2) {
            this.G0 = z ? 1.0f : 0.0f;
        }
        invalidate();
    }

    public void setLineColors(int i, int i2, int i3) {
        this.N0 = true;
        getContext().getResources().getDrawable(AbstractC23598xB5.search_dark).getPadding(this.q1);
        Rect rect = this.q1;
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
        this.O0 = i;
        this.P0 = i2;
        this.z.setColor(i2);
        this.Q0 = i3;
        this.A.setColor(i3);
        invalidate();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.J = f;
    }

    public void setNextSetTextAnimated(boolean z) {
        this.X0 = z;
    }

    @Override // android.widget.EditText
    public void setSelection(int i, int i2) {
        try {
            super.setSelection(i, i2);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    public void setSupportRtlHint(boolean z) {
        this.K0 = z;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        x(this.X0);
        this.X0 = false;
    }

    public void setTextWatchersSuppressed(boolean z, boolean z2) {
        if (this.p1 == z) {
            return;
        }
        this.p1 = z;
        if (z) {
            Iterator it = this.o1.iterator();
            while (it.hasNext()) {
                super.removeTextChangedListener((TextWatcher) it.next());
            }
            return;
        }
        for (TextWatcher textWatcher : this.o1) {
            super.addTextChangedListener(textWatcher);
            if (z2) {
                textWatcher.beforeTextChanged("", 0, length(), length());
                textWatcher.onTextChanged(getText(), 0, length(), length());
                textWatcher.afterTextChanged(getText());
            }
        }
    }

    public void setTransformHintToHeader(boolean z) {
        if (this.Y0 == z) {
            return;
        }
        this.Y0 = z;
        AnimatorSet animatorSet = this.a1;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.a1 = null;
        }
    }

    public void setWindowView(View view) {
        this.h1 = view;
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback) {
        if (this.h1 == null && this.i1 == null) {
            return super.startActionMode(callback);
        }
        C23390wq2 c23390wq2 = this.f1;
        if (c23390wq2 != null) {
            c23390wq2.finish();
        }
        z();
        Context context = getContext();
        View view = this.h1;
        if (view == null) {
            view = this.i1;
        }
        this.e1 = new ir.nasim.tgwidgets.editor.ui.ActionBar.f(context, view, getActionModeStyle(), getResourcesProvider());
        this.f1 = new C23390wq2(getContext(), new d(callback), this, this.e1);
        this.g1 = new ViewTreeObserver.OnPreDrawListener() { // from class: ir.nasim.p42
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.a.E();
            }
        };
        C23390wq2 c23390wq22 = this.f1;
        callback.onCreateActionMode(c23390wq22, c23390wq22.getMenu());
        C23390wq2 c23390wq23 = this.f1;
        A(c23390wq23, c23390wq23.getMenu());
        this.f1.invalidate();
        getViewTreeObserver().addOnPreDrawListener(this.g1);
        invalidate();
        return this.f1;
    }

    public void setHintText(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (getMeasuredWidth() == 0) {
            z = false;
        }
        if (z) {
            if (this.w == null) {
                this.w = new C23491x07(this);
            }
            this.w.c(this.A0, this.B0, charSequence, getPaint());
        } else {
            C23491x07 c23491x07 = this.w;
            if (c23491x07 != null) {
                c23491x07.b();
            }
        }
        this.B0 = charSequence;
        if (getMeasuredWidth() != 0) {
            charSequence = TextUtils.ellipsize(charSequence, getPaint(), getMeasuredWidth(), TextUtils.TruncateAt.END);
            StaticLayout staticLayout = this.A0;
            if (staticLayout != null && TextUtils.equals(staticLayout.getText(), charSequence)) {
                return;
            }
        }
        this.A0 = new StaticLayout(charSequence, getPaint(), AbstractC21455b.F(1000.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    @Override // android.widget.EditText
    public void setSelection(int i) {
        try {
            super.setSelection(i);
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        if (this.h1 == null && this.i1 == null) {
            return super.startActionMode(callback, i);
        }
        return startActionMode(callback);
    }
}
