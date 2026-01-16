package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC16417lE5;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC18763pC5;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.TD5;
import ir.nasim.UV0;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class ActionBarMenuItem extends FrameLayout {
    protected boolean A;
    private int A0;
    private boolean B;
    private boolean B0;
    private boolean C0;
    private boolean D;
    private boolean D0;
    private boolean E0;
    private boolean F0;
    private boolean G;
    private float G0;
    private boolean H;
    public int H0;
    private float I0;
    private UV0 J;
    private View J0;
    private final m.h K0;
    public int L0;
    private View.OnClickListener M0;
    private boolean N0;
    AnimatorSet O0;
    private ArrayList P0;
    private HashMap Q0;
    private FrameLayout a;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout b;
    private ActionBarMenu c;
    private ActionBarPopupWindow d;
    private EditTextBoldCursor e;
    private LinearLayout f;
    private TextView g;
    private CharSequence h;
    private CharSequence i;
    private ImageView j;
    private AnimatorSet k;
    private View l;
    protected RLottieImageView m;
    private int n;
    protected TextView o;
    private FrameLayout p;
    private boolean q;
    private boolean r;
    private Rect s;
    private int[] t;
    private View u;
    private Runnable v;
    private int w;
    private int x;
    private m y;
    private boolean z;
    private int z0;

    class a extends UV0 {
        a() {
        }

        @Override // ir.nasim.UV0
        public int a() {
            return ActionBarMenuItem.this.c.a.C0;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarMenuItem.this.j.setVisibility(4);
            ActionBarMenuItem.this.k = null;
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarMenuItem.this.k = null;
        }
    }

    class d extends LinearLayout {
        final /* synthetic */ View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, View view) {
            super(context);
            this.a = view;
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            ActionBarMenuItem.this.b.measure(i, i2);
            if (ActionBarMenuItem.this.b.getSwipeBack() != null) {
                this.a.getLayoutParams().width = ActionBarMenuItem.this.b.getSwipeBack().getChildAt(0).getMeasuredWidth();
            } else {
                this.a.getLayoutParams().width = ActionBarMenuItem.this.b.getMeasuredWidth() - AbstractC21455b.F(16.0f);
            }
            super.onMeasure(i, i2);
        }
    }

    class e extends AnimatorListenerAdapter {
        final /* synthetic */ ArrayList a;

        e(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarMenuItem.this.p.setAlpha(0.0f);
            for (int i = 0; i < this.a.size(); i++) {
                ((View) this.a.get(i)).setAlpha(1.0f);
            }
            ActionBarMenuItem.this.p.setVisibility(8);
        }
    }

    class f extends AnimatorListenerAdapter {
        final /* synthetic */ ArrayList a;

        f(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarMenuItem.this.p.setAlpha(1.0f);
            for (int i = 0; i < this.a.size(); i++) {
                ((View) this.a.get(i)).setAlpha(0.0f);
            }
        }
    }

    class g extends FrameLayout {
        private boolean a;

        g(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            int measuredWidth = 0;
            if (!FH3.D && ActionBarMenuItem.this.g.getVisibility() == 0) {
                measuredWidth = AbstractC21455b.F(4.0f) + ActionBarMenuItem.this.g.getMeasuredWidth();
            }
            if (ActionBarMenuItem.this.f.getVisibility() == 0) {
                measuredWidth += ActionBarMenuItem.this.f.getMeasuredWidth();
            }
            ActionBarMenuItem.this.e.layout(measuredWidth, ActionBarMenuItem.this.e.getTop(), ActionBarMenuItem.this.e.getMeasuredWidth() + measuredWidth, ActionBarMenuItem.this.e.getBottom());
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int measuredWidth;
            int measuredWidth2;
            if (!ActionBarMenuItem.this.r) {
                measureChildWithMargins(ActionBarMenuItem.this.j, i, 0, i2, 0);
                if (ActionBarMenuItem.this.l != null) {
                    measureChildWithMargins(ActionBarMenuItem.this.l, i, 0, i2, 0);
                }
            }
            if (FH3.D) {
                if (ActionBarMenuItem.this.g.getVisibility() == 0) {
                    measureChildWithMargins(ActionBarMenuItem.this.g, i, View.MeasureSpec.getSize(i) / 2, i2, 0);
                    measuredWidth = ActionBarMenuItem.this.g.getMeasuredWidth() + AbstractC21455b.F(4.0f);
                } else {
                    measuredWidth = 0;
                }
                int size = View.MeasureSpec.getSize(i);
                this.a = true;
                measureChildWithMargins(ActionBarMenuItem.this.f, i, measuredWidth, i2, 0);
                int measuredWidth3 = ActionBarMenuItem.this.f.getVisibility() == 0 ? ActionBarMenuItem.this.f.getMeasuredWidth() : 0;
                measureChildWithMargins(ActionBarMenuItem.this.e, View.MeasureSpec.makeMeasureSpec(size - AbstractC21455b.F(12.0f), 0), measuredWidth + measuredWidth3, i2, 0);
                this.a = false;
                setMeasuredDimension(Math.max(measuredWidth3 + ActionBarMenuItem.this.e.getMeasuredWidth(), size), View.MeasureSpec.getSize(i2));
                return;
            }
            if (ActionBarMenuItem.this.g.getVisibility() == 0) {
                measureChildWithMargins(ActionBarMenuItem.this.g, i, View.MeasureSpec.getSize(i) / 2, i2, 0);
                measuredWidth2 = ActionBarMenuItem.this.g.getMeasuredWidth() + AbstractC21455b.F(4.0f);
            } else {
                measuredWidth2 = 0;
            }
            int size2 = View.MeasureSpec.getSize(i);
            this.a = true;
            measureChildWithMargins(ActionBarMenuItem.this.f, i, measuredWidth2, i2, 0);
            int measuredWidth4 = ActionBarMenuItem.this.f.getVisibility() == 0 ? ActionBarMenuItem.this.f.getMeasuredWidth() : 0;
            measureChildWithMargins(ActionBarMenuItem.this.e, i, measuredWidth2 + measuredWidth4 + (ActionBarMenuItem.this.l != null ? ActionBarMenuItem.this.l.getMeasuredWidth() : 0), i2, 0);
            this.a = false;
            setMeasuredDimension(Math.max(measuredWidth4 + ActionBarMenuItem.this.e.getMeasuredWidth(), size2), View.MeasureSpec.getSize(i2));
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.a) {
                return;
            }
            super.requestLayout();
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            super.setAlpha(f);
            if (ActionBarMenuItem.this.j == null || ActionBarMenuItem.this.j.getTag() == null) {
                return;
            }
            ActionBarMenuItem.this.j.setAlpha(f);
            ActionBarMenuItem.this.j.setScaleX(f);
            ActionBarMenuItem.this.j.setScaleY(f);
        }

        @Override // android.view.View
        public void setVisibility(int i) {
            super.setVisibility(i);
            if (ActionBarMenuItem.this.j != null) {
                ActionBarMenuItem.this.j.setVisibility(i);
            }
            if (ActionBarMenuItem.this.l != null) {
                ActionBarMenuItem.this.l.setVisibility(i);
            }
            if (ActionBarMenuItem.this.a != null) {
                ActionBarMenuItem.this.a.setVisibility(i);
            }
        }
    }

    class h extends HorizontalScrollView {
        boolean a;

        h(Context context) {
            super(context);
        }

        private void a(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.a = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.a = false;
            }
        }

        @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            a(motionEvent);
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.widget.HorizontalScrollView, android.view.View
        protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            if (this.a) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @Override // android.widget.HorizontalScrollView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            a(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
    }

    class i extends EditTextBoldCursor {
        i(Context context) {
            super(context);
        }

        @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i != 67 || ActionBarMenuItem.this.e.length() != 0 || ActionBarMenuItem.this.g.getVisibility() != 0 || ActionBarMenuItem.this.g.length() <= 0) {
                return super.onKeyDown(i, keyEvent);
            }
            ActionBarMenuItem.this.j.callOnClick();
            return true;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            setMeasuredDimension(Math.max(View.MeasureSpec.getSize(i), getMeasuredWidth()) + AbstractC21455b.F(3.0f), getMeasuredHeight());
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.widget.TextView
        protected void onSelectionChanged(int i, int i2) {
            super.onSelectionChanged(i, i2);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1 && !AbstractC21455b.C1(this)) {
                clearFocus();
                requestFocus();
            }
            return zOnTouchEvent;
        }
    }

    class j implements TextWatcher {
        j() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (ActionBarMenuItem.this.H) {
                ActionBarMenuItem.this.H = false;
            } else {
                ActionBarMenuItem.this.getClass();
                ActionBarMenuItem.this.J();
            }
        }
    }

    class k extends AppCompatImageView {
        k(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            getBackground().draw(canvas);
            super.draw(canvas);
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            clearAnimation();
            if (getTag() != null) {
                ActionBarMenuItem.this.j.setAlpha(1.0f);
                ActionBarMenuItem.this.j.setRotation(0.0f);
                ActionBarMenuItem.this.j.setScaleX(1.0f);
                ActionBarMenuItem.this.j.setScaleY(1.0f);
                return;
            }
            ActionBarMenuItem.this.j.setVisibility(4);
            ActionBarMenuItem.this.j.setAlpha(0.0f);
            ActionBarMenuItem.this.j.setRotation(45.0f);
            ActionBarMenuItem.this.j.setScaleX(0.0f);
            ActionBarMenuItem.this.j.setScaleY(0.0f);
        }
    }

    public interface l {
    }

    public interface m {
        void a();

        void b();
    }

    public static class n {
        static /* bridge */ /* synthetic */ View a(n nVar, ActionBarMenuItem actionBarMenuItem) {
            throw null;
        }
    }

    public ActionBarMenuItem(Context context, ActionBarMenu actionBarMenu, int i2, int i3, m.h hVar) {
        this(context, actionBarMenu, i2, i3, false, hVar);
    }

    public static ActionBarMenuSubItem D(ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout, int i2, CharSequence charSequence, boolean z, m.h hVar) {
        return E(false, false, actionBarPopupWindowLayout, i2, charSequence, z, hVar);
    }

    public static ActionBarMenuSubItem E(boolean z, boolean z2, ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout, int i2, CharSequence charSequence, boolean z3, m.h hVar) {
        ActionBarMenuSubItem actionBarMenuSubItem = new ActionBarMenuSubItem(actionBarPopupWindowLayout.getContext(), z3, z, z2, hVar);
        actionBarMenuSubItem.setTextAndIcon(charSequence, i2);
        actionBarMenuSubItem.setMinimumWidth(AbstractC21455b.F(196.0f));
        actionBarPopupWindowLayout.addView(actionBarMenuSubItem);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) actionBarMenuSubItem.getLayoutParams();
        if (FH3.D) {
            layoutParams.gravity = 5;
        }
        layoutParams.width = -1;
        layoutParams.height = AbstractC21455b.F(48.0f);
        actionBarMenuSubItem.setLayoutParams(layoutParams);
        return actionBarMenuSubItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        TextView textView;
        if (this.j != null) {
            if (TextUtils.isEmpty(this.e.getText()) && ((textView = this.g) == null || textView.getVisibility() != 0)) {
                if (this.j.getTag() != null) {
                    this.j.setTag(null);
                    AnimatorSet animatorSet = this.k;
                    if (animatorSet != null) {
                        animatorSet.cancel();
                    }
                    if (!this.C0) {
                        this.j.setAlpha(0.0f);
                        this.j.setRotation(45.0f);
                        this.j.setScaleX(0.0f);
                        this.j.setScaleY(0.0f);
                        this.j.setVisibility(4);
                        this.C0 = true;
                        return;
                    }
                    AnimatorSet duration = new AnimatorSet().setDuration(180L);
                    duration.setInterpolator(new DecelerateInterpolator());
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.T4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.a.Y(valueAnimator);
                        }
                    });
                    duration.playTogether(ObjectAnimator.ofFloat(this.j, (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.j, (Property<ImageView, Float>) View.SCALE_X, 0.0f), ObjectAnimator.ofFloat(this.j, (Property<ImageView, Float>) View.SCALE_Y, 0.0f), ObjectAnimator.ofFloat(this.j, (Property<ImageView, Float>) View.ROTATION, 45.0f), valueAnimatorOfFloat);
                    duration.addListener(new b());
                    duration.start();
                    this.k = duration;
                    return;
                }
                return;
            }
            if (this.j.getTag() == null) {
                this.j.setTag(1);
                AnimatorSet animatorSet2 = this.k;
                if (animatorSet2 != null) {
                    animatorSet2.cancel();
                }
                this.j.setVisibility(0);
                if (this.C0) {
                    AnimatorSet duration2 = new AnimatorSet().setDuration(180L);
                    duration2.setInterpolator(new DecelerateInterpolator());
                    ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
                    valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.U4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.a.Z(valueAnimator);
                        }
                    });
                    duration2.playTogether(ObjectAnimator.ofFloat(this.j, (Property<ImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.j, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.j, (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.j, (Property<ImageView, Float>) View.ROTATION, 0.0f), valueAnimatorOfFloat2);
                    duration2.addListener(new c());
                    duration2.start();
                    this.k = duration2;
                    return;
                }
                this.j.setAlpha(1.0f);
                this.j.setRotation(0.0f);
                this.j.setScaleX(1.0f);
                this.j.setScaleY(1.0f);
                View view = this.l;
                if (view != null) {
                    view.setTranslationX(0.0f);
                }
                this.C0 = true;
            }
        }
    }

    private void K() {
        if (this.p == null && this.q) {
            g gVar = new g(getContext());
            this.p = gVar;
            gVar.setClipChildren(this.L0 != 0);
            this.a = null;
            if (this.r) {
                this.a = new FrameLayout(getContext());
                h hVar = new h(getContext());
                hVar.addView(this.p, AbstractC13840gu3.o(-2, -1, 0));
                hVar.setHorizontalScrollBarEnabled(false);
                hVar.setClipChildren(this.L0 != 0);
                this.a.addView(hVar, AbstractC13840gu3.c(-1, -1.0f, 0, 0.0f, 0.0f, 48.0f, 0.0f));
                this.c.addView(this.a, 0, AbstractC13840gu3.k(0, -1, 1.0f, this.L0, 0, 0, 0));
            } else {
                this.c.addView(this.p, 0, AbstractC13840gu3.k(0, -1, 1.0f, this.L0 + 6, 0, this.H0, 0));
            }
            this.p.setVisibility(8);
            TextView textView = new TextView(getContext());
            this.g = textView;
            textView.setTextSize(1, 18.0f);
            TextView textView2 = this.g;
            int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.j7;
            textView2.setTextColor(P(i2));
            this.g.setSingleLine(true);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.g.setVisibility(8);
            this.g.setGravity(FH3.D ? 5 : 3);
            i iVar = new i(getContext());
            this.e = iVar;
            iVar.setScrollContainer(false);
            this.e.setCursorWidth(1.5f);
            this.e.setCursorColor(P(i2));
            this.e.setTextSize(1, 18.0f);
            this.e.setHintTextColor(P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.k7));
            this.e.setTextColor(P(i2));
            this.e.setSingleLine(true);
            this.e.setBackgroundResource(0);
            this.e.setPadding(0, 0, 0, 0);
            this.e.setInputType(this.e.getInputType() | 524288);
            this.e.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.a5
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView3, int i3, KeyEvent keyEvent) {
                    return this.a.a0(textView3, i3, keyEvent);
                }
            });
            this.e.addTextChangedListener(new j());
            this.e.setImeOptions(234881027);
            this.e.setTextIsSelectable(false);
            this.e.setHighlightColor(P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Ud));
            this.e.setHandlesColor(P(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Vd));
            CharSequence charSequence = this.h;
            if (charSequence != null) {
                this.e.setHint(charSequence);
                setContentDescription(this.h);
            }
            CharSequence charSequence2 = this.i;
            if (charSequence2 != null) {
                this.e.setText(charSequence2);
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f = linearLayout;
            linearLayout.setOrientation(0);
            this.f.setVisibility(0);
            if (FH3.D) {
                this.p.addView(this.f, AbstractC13840gu3.c(-2, 32.0f, 16, 0.0f, 0.0f, 48.0f, 0.0f));
                this.p.addView(this.e, AbstractC13840gu3.c(-1, 36.0f, 16, 0.0f, 0.0f, this.r ? 0.0f : 48.0f, 0.0f));
                this.p.addView(this.g, AbstractC13840gu3.c(-2, 36.0f, 21, 0.0f, 5.5f, 48.0f, 0.0f));
            } else {
                this.p.addView(this.g, AbstractC13840gu3.c(-2, 36.0f, 19, 0.0f, 5.5f, 0.0f, 0.0f));
                this.p.addView(this.e, AbstractC13840gu3.c(-1, 36.0f, 16, 6.0f, 0.0f, this.r ? 0.0f : 48.0f, 0.0f));
                this.p.addView(this.f, AbstractC13840gu3.c(-2, 32.0f, 16, 0.0f, 0.0f, 48.0f, 0.0f));
            }
            this.f.setClipChildren(false);
            k kVar = new k(getContext());
            this.j = kVar;
            a aVar = new a();
            this.J = aVar;
            kVar.setImageDrawable(aVar);
            this.j.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(this.c.a.B0, 1));
            this.j.setScaleType(ImageView.ScaleType.CENTER);
            this.j.setAlpha(0.0f);
            this.j.setRotation(45.0f);
            this.j.setScaleX(0.0f);
            this.j.setScaleY(0.0f);
            this.j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.b5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b0(view);
                }
            });
            this.j.setContentDescription(FH3.E("ClearButton", TD5.tgwidget_ClearButton));
            if (this.r) {
                this.a.addView(this.j, AbstractC13840gu3.d(48, -1, 21));
            } else {
                this.p.addView(this.j, AbstractC13840gu3.d(48, -1, 21));
            }
        }
    }

    private void N() {
        if (this.b != null) {
            return;
        }
        this.s = new Rect();
        this.t = new int[2];
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getContext(), AbstractC23598xB5.popup_fixed_alert2, this.K0, 1);
        this.b = actionBarPopupWindowLayout;
        actionBarPopupWindowLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.V4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.a.c0(view, motionEvent);
            }
        });
        this.b.setDispatchKeyEventListener(new ActionBarPopupWindow.d() { // from class: ir.nasim.W4
            @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow.d
            public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                this.a.d0(keyEvent);
            }
        });
    }

    private n O(int i2) {
        HashMap map = this.Q0;
        if (map == null) {
            return null;
        }
        AbstractC18350oW3.a(map.get(Integer.valueOf(i2)));
        return null;
    }

    private int P(int i2) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i2, this.K0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(boolean z, View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.d;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing() && z) {
            if (this.B) {
                return;
            }
            this.B = true;
            this.d.k(this.z);
        }
        ActionBarMenu actionBarMenu = this.c;
        if (actionBarMenu != null) {
            actionBarMenu.j(((Integer) view.getTag()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(int i2) {
        if (this.b.getSwipeBack() != null) {
            this.b.getSwipeBack().B(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.l;
        if (view != null) {
            view.setTranslationX(AbstractC21455b.F(32.0f) * fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.l;
        if (view != null) {
            view.setTranslationX(AbstractC21455b.F(32.0f) * fFloatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a0(TextView textView, int i2, KeyEvent keyEvent) {
        if (keyEvent == null) {
            return false;
        }
        if ((keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 84) && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        AbstractC21455b.t0(this.e);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        if (this.e.length() != 0) {
            this.e.setText("");
        } else {
            TextView textView = this.g;
            if (textView != null && textView.getVisibility() == 0) {
                this.g.setVisibility(8);
            }
        }
        this.e.requestFocus();
        AbstractC21455b.C1(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c0(View view, MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (motionEvent.getActionMasked() != 0 || (actionBarPopupWindow = this.d) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        view.getHitRect(this.s);
        if (this.s.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        this.d.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.d) != null && actionBarPopupWindow.isShowing()) {
            this.d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(Utilities.b bVar) {
        if (bVar != null) {
            bVar.a(Boolean.valueOf(this.B));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean g0(View view, int i2, KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (i2 != 82 || keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 1 || (actionBarPopupWindow = this.d) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        this.d.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0() {
        j0();
        m mVar = this.y;
        if (mVar != null) {
            mVar.a();
        }
    }

    private void i0() {
        if (this.P0 == null) {
            return;
        }
        for (int i2 = 0; i2 < this.P0.size(); i2++) {
            AbstractC18350oW3.a(this.P0.get(i2));
            n.a(null, this);
        }
        this.P0.clear();
    }

    private void r0(boolean z, boolean z2) {
        int top;
        int paddingTop;
        ActionBarMenu actionBarMenu = this.c;
        if (actionBarMenu != null) {
            top = (-actionBarMenu.a.getMeasuredHeight()) + this.c.getTop();
            paddingTop = this.c.getPaddingTop();
        } else {
            float scaleY = getScaleY();
            top = -((int) ((getMeasuredHeight() * scaleY) - ((this.w != 2 ? getTranslationY() : 0.0f) / scaleY)));
            paddingTop = this.z0;
        }
        int i2 = top + paddingTop + this.x;
        if (z) {
            this.b.o();
        }
        View view = this.J0;
        if (view == null) {
            view = this;
        }
        ActionBarMenu actionBarMenu2 = this.c;
        if (actionBarMenu2 != null) {
            ActionBar actionBar = actionBarMenu2.a;
            if (this.w == 0) {
                if (z) {
                    this.d.showAsDropDown(actionBar, (((view.getLeft() + this.c.getLeft()) + view.getMeasuredWidth()) - this.d.getContentView().getMeasuredWidth()) + ((int) getTranslationX()), i2);
                }
                if (z2) {
                    this.d.update(actionBar, (((view.getLeft() + this.c.getLeft()) + view.getMeasuredWidth()) - this.d.getContentView().getMeasuredWidth()) + ((int) getTranslationX()), i2, -1, -1);
                    return;
                }
                return;
            }
            if (z) {
                if (this.E0) {
                    this.d.showAtLocation(actionBar, 51, (getLeft() - AbstractC21455b.F(8.0f)) + ((int) getTranslationX()), i2);
                } else {
                    this.d.showAsDropDown(actionBar, (getLeft() - AbstractC21455b.F(8.0f)) + ((int) getTranslationX()), i2);
                }
            }
            if (z2) {
                this.d.update(actionBar, (getLeft() - AbstractC21455b.F(8.0f)) + ((int) getTranslationX()), i2, -1, -1);
                return;
            }
            return;
        }
        int i3 = this.w;
        if (i3 == 0) {
            if (getParent() != null) {
                View view2 = (View) getParent();
                if (z) {
                    this.d.showAsDropDown(view2, ((getLeft() + getMeasuredWidth()) - this.d.getContentView().getMeasuredWidth()) + this.A0, i2);
                }
                if (z2) {
                    this.d.update(view2, ((getLeft() + getMeasuredWidth()) - this.d.getContentView().getMeasuredWidth()) + this.A0, i2, -1, -1);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (z) {
                this.d.showAsDropDown(this, (-AbstractC21455b.F(8.0f)) + this.A0, i2);
            }
            if (z2) {
                this.d.update(this, (-AbstractC21455b.F(8.0f)) + this.A0, i2, -1, -1);
                return;
            }
            return;
        }
        if (z) {
            this.d.showAsDropDown(this, (getMeasuredWidth() - this.d.getContentView().getMeasuredWidth()) + this.A0, i2);
        }
        if (z2) {
            this.d.update(this, (getMeasuredWidth() - this.d.getContentView().getMeasuredWidth()) + this.A0, i2, -1, -1);
        }
    }

    public ActionBarPopupWindow.GapView B() {
        return C(-1);
    }

    public ActionBarPopupWindow.GapView C(int i2) {
        N();
        ActionBarPopupWindow.GapView gapView = new ActionBarPopupWindow.GapView(getContext(), this.K0, ir.nasim.tgwidgets.editor.ui.ActionBar.m.o7);
        if (i2 != -1) {
            gapView.setTag(Integer.valueOf(i2));
        }
        gapView.setTag(AbstractC18763pC5.fit_width_tag, 1);
        this.b.j(gapView, AbstractC13840gu3.g(-1, 8));
        return gapView;
    }

    public ActionBarMenuSubItem F(int i2, int i3, Drawable drawable, CharSequence charSequence, boolean z, boolean z2) {
        return G(i2, i3, drawable, charSequence, z, z2, this.K0);
    }

    public ActionBarMenuSubItem G(int i2, int i3, Drawable drawable, CharSequence charSequence, final boolean z, boolean z2, m.h hVar) {
        N();
        ActionBarMenuSubItem actionBarMenuSubItem = new ActionBarMenuSubItem(getContext(), z2, false, false, hVar);
        actionBarMenuSubItem.setTextAndIcon(charSequence, i3, drawable);
        actionBarMenuSubItem.setMinimumWidth(AbstractC21455b.F(196.0f));
        actionBarMenuSubItem.setTag(Integer.valueOf(i2));
        this.b.addView(actionBarMenuSubItem);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) actionBarMenuSubItem.getLayoutParams();
        if (FH3.D) {
            layoutParams.gravity = 5;
        }
        layoutParams.width = -1;
        layoutParams.height = AbstractC21455b.F(48.0f);
        actionBarMenuSubItem.setLayoutParams(layoutParams);
        actionBarMenuSubItem.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.c5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.V(z, view);
            }
        });
        return actionBarMenuSubItem;
    }

    public ActionBarMenuSubItem H(int i2, int i3, CharSequence charSequence) {
        return F(i2, i3, null, charSequence, true, false);
    }

    public ActionBarMenuSubItem I(int i2, Drawable drawable, String str, View view) {
        N();
        final ActionBarMenuSubItem actionBarMenuSubItem = new ActionBarMenuSubItem(getContext(), false, false, false, this.K0);
        actionBarMenuSubItem.setTextAndIcon(str, i2, drawable);
        actionBarMenuSubItem.setMinimumWidth(AbstractC21455b.F(196.0f));
        actionBarMenuSubItem.setRightIcon(AbstractC23598xB5.msg_arrowright);
        this.b.addView(actionBarMenuSubItem);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) actionBarMenuSubItem.getLayoutParams();
        if (FH3.D) {
            layoutParams.gravity = 5;
        }
        layoutParams.width = -1;
        layoutParams.height = AbstractC21455b.F(48.0f);
        actionBarMenuSubItem.setLayoutParams(layoutParams);
        final int iK = this.b.k(view);
        actionBarMenuSubItem.m = new Runnable() { // from class: ir.nasim.d5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.W(iK);
            }
        };
        actionBarMenuSubItem.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.S4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                actionBarMenuSubItem.c();
            }
        });
        this.b.b = true;
        return actionBarMenuSubItem;
    }

    public void L() {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.b.getItemsCount()) {
                i2 = 8;
                break;
            } else if (this.b.l(i3).getVisibility() == 0) {
                break;
            } else {
                i3++;
            }
        }
        if (i2 != getVisibility()) {
            setVisibility(i2);
        }
    }

    public void M() {
        ActionBarPopupWindow actionBarPopupWindow = this.d;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.d.dismiss();
    }

    public boolean Q() {
        ArrayList arrayList;
        return (this.b == null && ((arrayList = this.P0) == null || arrayList.isEmpty())) ? false : true;
    }

    public void R(int i2) {
        View viewFindViewWithTag;
        O(i2);
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.b;
        if (actionBarPopupWindowLayout == null || (viewFindViewWithTag = actionBarPopupWindowLayout.findViewWithTag(Integer.valueOf(i2))) == null || viewFindViewWithTag.getVisibility() == 8) {
            return;
        }
        viewFindViewWithTag.setVisibility(8);
        this.D0 = true;
    }

    public boolean S() {
        return this.q;
    }

    public boolean T() {
        FrameLayout frameLayout = this.p;
        return frameLayout != null && frameLayout.getVisibility() == 0;
    }

    public boolean U() {
        ActionBarPopupWindow actionBarPopupWindow = this.d;
        return actionBarPopupWindow != null && actionBarPopupWindow.isShowing();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.N0) {
            getBackground().draw(canvas);
        }
        super.draw(canvas);
    }

    public View getContentView() {
        RLottieImageView rLottieImageView = this.m;
        return rLottieImageView != null ? rLottieImageView : this.o;
    }

    public RLottieImageView getIconView() {
        return this.m;
    }

    public ActionBarPopupWindow.ActionBarPopupWindowLayout getPopupLayout() {
        if (this.b == null) {
            N();
        }
        return this.b;
    }

    public FrameLayout getSearchContainer() {
        return this.p;
    }

    public EditTextBoldCursor getSearchField() {
        K();
        return this.e;
    }

    public TextView getTextView() {
        return this.o;
    }

    public int getVisibleSubItemsCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.b.getItemsCount(); i3++) {
            View viewL = this.b.l(i3);
            if (viewL != null && viewL.getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    protected void j0() {
    }

    public void k0(int i2) {
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.b;
        if (actionBarPopupWindowLayout == null || actionBarPopupWindowLayout.getBackgroundColor() == i2) {
            return;
        }
        this.b.setBackgroundColor(i2);
        ActionBarPopupWindow actionBarPopupWindow = this.d;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.b.invalidate();
    }

    public void l0() {
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.b;
        if (actionBarPopupWindowLayout == null) {
            return;
        }
        actionBarPopupWindowLayout.n();
    }

    public void m0(int i2) {
        n0(i2, false);
    }

    public void n0(int i2, boolean z) {
        View viewFindViewWithTag;
        O(i2);
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.b;
        if (actionBarPopupWindowLayout == null || (viewFindViewWithTag = actionBarPopupWindowLayout.findViewWithTag(Integer.valueOf(i2))) == null || viewFindViewWithTag.getVisibility() == 0) {
            return;
        }
        viewFindViewWithTag.setAlpha(0.0f);
        viewFindViewWithTag.animate().alpha(1.0f).setInterpolator(InterpolatorC12631ew1.f).setDuration(150L).start();
        viewFindViewWithTag.setVisibility(0);
        this.D0 = true;
    }

    public boolean o0(boolean z) {
        RLottieImageView iconView;
        K();
        if (this.p == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            View childAt = this.c.getChildAt(i2);
            if ((childAt instanceof ActionBarMenuItem) && (iconView = ((ActionBarMenuItem) childAt).getIconView()) != null) {
                arrayList.add(iconView);
            }
        }
        if (this.p.getTag() != null) {
            this.p.setTag(null);
            AnimatorSet animatorSet = this.O0;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
                this.O0.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.O0 = animatorSet2;
            FrameLayout frameLayout = this.p;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) View.ALPHA, frameLayout.getAlpha(), 0.0f));
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ((View) arrayList.get(i3)).setAlpha(0.0f);
                this.O0.playTogether(ObjectAnimator.ofFloat((View) arrayList.get(i3), (Property<View, Float>) View.ALPHA, ((View) arrayList.get(i3)).getAlpha(), 1.0f));
            }
            this.O0.setDuration(150L);
            this.O0.addListener(new e(arrayList));
            this.O0.start();
            this.e.clearFocus();
            setVisibility(0);
            if (z) {
                AbstractC21455b.t0(this.e);
            }
            this.c.requestLayout();
            requestLayout();
            return false;
        }
        this.p.setVisibility(0);
        this.p.setAlpha(0.0f);
        AnimatorSet animatorSet3 = this.O0;
        if (animatorSet3 != null) {
            animatorSet3.removeAllListeners();
            this.O0.cancel();
        }
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.O0 = animatorSet4;
        FrameLayout frameLayout2 = this.p;
        animatorSet4.playTogether(ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) View.ALPHA, frameLayout2.getAlpha(), 1.0f));
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            this.O0.playTogether(ObjectAnimator.ofFloat((View) arrayList.get(i4), (Property<View, Float>) View.ALPHA, ((View) arrayList.get(i4)).getAlpha(), 0.0f));
        }
        this.O0.setDuration(150L);
        this.O0.addListener(new f(arrayList));
        this.O0.start();
        setVisibility(8);
        this.e.setText("");
        this.e.requestFocus();
        if (z) {
            AbstractC21455b.C1(this.e);
        }
        this.p.setTag(1);
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.m != null) {
            accessibilityNodeInfo.setClassName("android.widget.ImageButton");
        } else if (this.o != null) {
            accessibilityNodeInfo.setClassName("android.widget.Button");
            if (TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
                accessibilityNodeInfo.setText(this.o.getText());
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        ActionBarPopupWindow actionBarPopupWindow = this.d;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        r0(false, true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        ActionBarPopupWindow actionBarPopupWindow2;
        ActionBarPopupWindow actionBarPopupWindow3;
        if (motionEvent.getActionMasked() == 0) {
            if (this.B0 && Q() && ((actionBarPopupWindow3 = this.d) == null || !actionBarPopupWindow3.isShowing())) {
                Runnable runnable = new Runnable() { // from class: ir.nasim.R4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e0();
                    }
                };
                this.v = runnable;
                AbstractC21455b.n1(runnable, 200L);
            }
        } else if (motionEvent.getActionMasked() != 2) {
            ActionBarPopupWindow actionBarPopupWindow4 = this.d;
            if (actionBarPopupWindow4 != null && actionBarPopupWindow4.isShowing() && motionEvent.getActionMasked() == 1) {
                View view = this.u;
                if (view != null) {
                    view.setSelected(false);
                    ActionBarMenu actionBarMenu = this.c;
                    if (actionBarMenu != null) {
                        actionBarMenu.j(((Integer) this.u.getTag()).intValue());
                    }
                    this.d.k(this.z);
                } else if (this.F0) {
                    this.d.dismiss();
                }
            } else {
                View view2 = this.u;
                if (view2 != null) {
                    view2.setSelected(false);
                    this.u = null;
                }
            }
        } else if (this.F0 && Q() && ((actionBarPopupWindow2 = this.d) == null || !actionBarPopupWindow2.isShowing())) {
            if (motionEvent.getY() > getHeight()) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                p0();
                return true;
            }
        } else if (this.F0 && (actionBarPopupWindow = this.d) != null && actionBarPopupWindow.isShowing()) {
            getLocationOnScreen(this.t);
            float x = motionEvent.getX() + this.t[0];
            float y = motionEvent.getY();
            float f2 = y + r5[1];
            this.b.getLocationOnScreen(this.t);
            int[] iArr = this.t;
            float f3 = x - iArr[0];
            float f4 = f2 - iArr[1];
            this.u = null;
            for (int i2 = 0; i2 < this.b.getItemsCount(); i2++) {
                View viewL = this.b.l(i2);
                viewL.getHitRect(this.s);
                Object tag = viewL.getTag();
                if ((tag instanceof Integer) && ((Integer) tag).intValue() < 100) {
                    if (this.s.contains((int) f3, (int) f4)) {
                        viewL.setPressed(true);
                        viewL.setSelected(true);
                        viewL.drawableHotspotChanged(f3, f4 - viewL.getTop());
                        this.u = viewL;
                    } else {
                        viewL.setPressed(false);
                        viewL.setSelected(false);
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p0() {
        q0(null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v8, types: [android.view.ViewGroup, android.widget.LinearLayout, ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuItem$d] */
    public void q0(View view, View view2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout;
        View childAt;
        ActionBar actionBar;
        ActionBarPopupWindow actionBarPopupWindow = this.d;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            i0();
        }
        if (this.b != null) {
            ActionBarMenu actionBarMenu = this.c;
            if (actionBarMenu == null || !actionBarMenu.b || (actionBar = actionBarMenu.a) == null || actionBar.p()) {
                Runnable runnable = this.v;
                FrameLayout frameLayout = null;
                if (runnable != null) {
                    AbstractC21455b.t(runnable);
                    this.v = null;
                }
                ActionBarPopupWindow actionBarPopupWindow2 = this.d;
                if (actionBarPopupWindow2 != null && actionBarPopupWindow2.isShowing()) {
                    this.d.dismiss();
                    return;
                }
                this.J0 = view2;
                m mVar = this.y;
                if (mVar != null) {
                    mVar.b();
                }
                if (this.b.getParent() != null) {
                    ((ViewGroup) this.b.getParent()).removeView(this.b);
                }
                ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout2 = this.b;
                if (view != null) {
                    ?? dVar = new d(getContext(), view);
                    dVar.setOrientation(1);
                    frameLayout = new FrameLayout(getContext());
                    frameLayout.setAlpha(0.0f);
                    frameLayout.animate().alpha(1.0f).setDuration(100L).setStartDelay(this.b.i ? 165L : 0L).start();
                    if (view.getParent() instanceof ViewGroup) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    if ((view instanceof ActionBarMenuSubItem) || (view instanceof LinearLayout)) {
                        Drawable drawableMutate = AbstractC4043Dl1.f(getContext(), AbstractC23598xB5.popup_fixed_alert2).mutate();
                        drawableMutate.setColorFilter(new PorterDuffColorFilter(this.b.getBackgroundColor(), PorterDuff.Mode.MULTIPLY));
                        frameLayout.setBackground(drawableMutate);
                    }
                    frameLayout.addView(view, AbstractC13840gu3.b(-1, -2.0f));
                    dVar.addView(frameLayout, AbstractC13840gu3.g(-1, -2));
                    dVar.addView(this.b, AbstractC13840gu3.n(-2, -2, 0, 0, -10, 0, 0));
                    this.b.setTopView(frameLayout);
                    actionBarPopupWindowLayout = dVar;
                } else {
                    actionBarPopupWindowLayout2.setTopView(null);
                    actionBarPopupWindowLayout = actionBarPopupWindowLayout2;
                }
                ActionBarPopupWindow actionBarPopupWindow3 = new ActionBarPopupWindow(actionBarPopupWindowLayout, -2, -2);
                this.d = actionBarPopupWindow3;
                if (this.G) {
                    actionBarPopupWindow3.setAnimationStyle(0);
                } else {
                    actionBarPopupWindow3.setAnimationStyle(AbstractC16417lE5.PopupAnimation);
                }
                boolean z = this.G;
                if (!z) {
                    this.d.r(z);
                }
                this.d.setOutsideTouchable(true);
                this.d.setClippingEnabled(true);
                if (this.D) {
                    this.d.s(true);
                }
                this.d.setInputMethodMode(2);
                this.d.setSoftInputMode(0);
                actionBarPopupWindowLayout.setFocusableInTouchMode(true);
                actionBarPopupWindowLayout.setOnKeyListener(new View.OnKeyListener() { // from class: ir.nasim.X4
                    @Override // android.view.View.OnKeyListener
                    public final boolean onKey(View view3, int i2, KeyEvent keyEvent) {
                        return this.a.g0(view3, i2, keyEvent);
                    }
                });
                this.d.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.nasim.Y4
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        this.a.h0();
                    }
                });
                actionBarPopupWindowLayout.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.h.x - AbstractC21455b.F(40.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.h.y, RecyclerView.UNDEFINED_DURATION));
                if (frameLayout != null && frameLayout.getLayoutParams() != null && this.b.getSwipeBack() != null && (childAt = this.b.getSwipeBack().getChildAt(0)) != null && childAt.getMeasuredWidth() > 0) {
                    frameLayout.getLayoutParams().width = childAt.getMeasuredWidth() + AbstractC21455b.F(16.0f);
                }
                this.D0 = false;
                this.B = false;
                this.d.setFocusable(true);
                r0(true, actionBarPopupWindowLayout.getMeasuredWidth() == 0);
                this.b.q();
                if (this.b.getSwipeBack() != null) {
                    this.b.getSwipeBack().t(false);
                }
                this.d.u();
                float f2 = this.G0;
                if (f2 > 0.0f) {
                    this.d.j(f2);
                }
            }
        }
    }

    public void setAdditionalYOffset(int i2) {
        this.z0 = i2;
    }

    public void setDelegate(l lVar) {
    }

    public void setIcon(int i2) {
        RLottieImageView rLottieImageView = this.m;
        if (rLottieImageView == null) {
            return;
        }
        this.n = i2;
        rLottieImageView.setImageResource(i2);
    }

    public void setIconColor(int i2) {
        RLottieImageView rLottieImageView = this.m;
        if (rLottieImageView != null) {
            rLottieImageView.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.MULTIPLY));
        }
        TextView textView = this.o;
        if (textView != null) {
            textView.setTextColor(i2);
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.MULTIPLY));
        }
    }

    public void setLongClickEnabled(boolean z) {
        this.B0 = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.M0 = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    public void setOnMenuDismiss(final Utilities.b bVar) {
        ActionBarPopupWindow actionBarPopupWindow = this.d;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.nasim.Z4
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    this.a.f0(bVar);
                }
            });
        }
    }

    public void setPopupItemsColor(int i2, boolean z) {
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.b;
        if (actionBarPopupWindowLayout == null) {
            return;
        }
        LinearLayout linearLayout = actionBarPopupWindowLayout.s;
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = linearLayout.getChildAt(i3);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(i2);
            } else if (childAt instanceof ActionBarMenuSubItem) {
                if (z) {
                    ((ActionBarMenuSubItem) childAt).setIconColor(i2);
                } else {
                    ((ActionBarMenuSubItem) childAt).setTextColor(i2);
                }
            }
        }
    }

    public void setPopupItemsSelectorColor(int i2) {
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.b;
        if (actionBarPopupWindowLayout == null) {
            return;
        }
        LinearLayout linearLayout = actionBarPopupWindowLayout.s;
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = linearLayout.getChildAt(i3);
            if (childAt instanceof ActionBarMenuSubItem) {
                ((ActionBarMenuSubItem) childAt).setSelectorColor(i2);
            }
        }
    }

    public void setSubMenuDelegate(m mVar) {
        this.y = mVar;
    }

    public void setSubMenuOpenSide(int i2) {
        this.w = i2;
    }

    public void setText(CharSequence charSequence) {
        TextView textView = this.o;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public void setTransitionOffset(float f2) {
        this.I0 = f2;
        setTranslationX(0.0f);
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2 + this.I0);
    }

    public void setupPopupRadialSelectors(int i2) {
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.b;
        if (actionBarPopupWindowLayout != null) {
            actionBarPopupWindowLayout.setupRadialSelectors(i2);
        }
    }

    public ActionBarMenuItem(Context context, ActionBarMenu actionBarMenu, int i2, int i3, boolean z, m.h hVar) {
        super(context);
        this.z = true;
        this.G = true;
        this.C0 = true;
        this.D0 = true;
        this.F0 = true;
        this.K0 = hVar;
        if (i2 != 0) {
            setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(i2, z ? 5 : 1));
        }
        this.c = actionBarMenu;
        if (!z) {
            RLottieImageView rLottieImageView = new RLottieImageView(context);
            this.m = rLottieImageView;
            rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.m.setImportantForAccessibility(2);
            addView(this.m, AbstractC13840gu3.b(-1, -1.0f));
            if (i3 != 0) {
                this.m.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.MULTIPLY));
                return;
            }
            return;
        }
        TextView textView = new TextView(context);
        this.o = textView;
        textView.setTextSize(1, 15.0f);
        this.o.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.o.setGravity(17);
        this.o.setPadding(AbstractC21455b.F(4.0f), 0, AbstractC21455b.F(4.0f), 0);
        this.o.setImportantForAccessibility(2);
        if (i3 != 0) {
            this.o.setTextColor(i3);
        }
        addView(this.o, AbstractC13840gu3.b(-2, -1.0f));
    }
}
