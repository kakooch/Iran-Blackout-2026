package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.C13010fZ0;
import ir.nasim.C22477vI7;
import ir.nasim.C6011Lu2;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.NO5;
import ir.nasim.QY0;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.EditTextCaption;
import ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public class PhotoViewerCaptionEnterView extends FrameLayout implements E.d, SizeNotifierFrameLayoutPhoto.a {
    private View A;
    float A0;
    private TextPaint B;
    ValueAnimator B0;
    ValueAnimator C0;
    private String D;
    private final m.h G;
    public int H;
    float J;
    private final ImageView a;
    private EditTextCaption b;
    private ImageView c;
    private NO5 d;
    private SizeNotifierFrameLayoutPhoto e;
    private Drawable f;
    private Drawable g;
    private NumberTextView h;
    private int i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private float n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private d w;
    boolean x;
    private float y;
    private ValueAnimator z;
    Paint z0;

    class a extends EditTextCaption {
        a(Context context, m.h hVar) {
            super(context, hVar);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor
        protected void A(ActionMode actionMode, Menu menu) {
            PhotoViewerCaptionEnterView.this.F(actionMode, menu);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor
        protected int getActionModeStyle() {
            return 2;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextCaption, ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
        protected void onMeasure(int i, int i2) {
            try {
                PhotoViewerCaptionEnterView.this.j = getMeasuredWidth() == 0 && getMeasuredHeight() == 0;
                super.onMeasure(i, i2);
                if (PhotoViewerCaptionEnterView.this.j) {
                    PhotoViewerCaptionEnterView.this.i = getLineCount();
                }
                PhotoViewerCaptionEnterView.this.j = false;
            } catch (Exception e) {
                setMeasuredDimension(View.MeasureSpec.getSize(i), AbstractC21455b.F(51.0f));
                AbstractC6403Nl2.d(e);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.widget.TextView
        protected void onSelectionChanged(int i, int i2) {
            super.onSelectionChanged(i, i2);
            if (i != i2) {
                B(false);
            } else {
                B(true);
            }
        }

        @Override // android.view.View
        public boolean requestRectangleOnScreen(Rect rect) {
            rect.bottom += AbstractC21455b.F(1000.0f);
            return super.requestRectangleOnScreen(rect);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextBoldCursor, ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects, android.widget.EditText, android.widget.TextView
        public void setText(CharSequence charSequence, TextView.BufferType bufferType) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.setText(charSequence, bufferType);
            D();
        }
    }

    class b implements TextWatcher {
        boolean a = false;
        boolean b;

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewerCaptionEnterView.this.h.setVisibility(8);
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(ValueAnimator valueAnimator) {
            PhotoViewerCaptionEnterView.this.y = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.d1(PhotoViewerCaptionEnterView.this.g, QY0.k(PhotoViewerCaptionEnterView.this.G(ir.nasim.tgwidgets.editor.ui.ActionBar.m.H4), (int) (Color.alpha(r5) * ((PhotoViewerCaptionEnterView.this.y * 0.42f) + 0.58f))));
            PhotoViewerCaptionEnterView.this.a.invalidate();
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void afterTextChanged(android.text.Editable r11) {
            /*
                Method dump skipped, instructions count: 423
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerCaptionEnterView.b.afterTextChanged(android.text.Editable):void");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (PhotoViewerCaptionEnterView.this.i != PhotoViewerCaptionEnterView.this.b.getLineCount()) {
                this.b = (PhotoViewerCaptionEnterView.this.b.getLineCount() >= 4) != (PhotoViewerCaptionEnterView.this.i >= 4);
                if (!PhotoViewerCaptionEnterView.this.j && PhotoViewerCaptionEnterView.this.b.getMeasuredWidth() > 0) {
                    PhotoViewerCaptionEnterView photoViewerCaptionEnterView = PhotoViewerCaptionEnterView.this;
                    photoViewerCaptionEnterView.Y(photoViewerCaptionEnterView.i, PhotoViewerCaptionEnterView.this.b.getLineCount());
                }
                PhotoViewerCaptionEnterView photoViewerCaptionEnterView2 = PhotoViewerCaptionEnterView.this;
                photoViewerCaptionEnterView2.i = photoViewerCaptionEnterView2.b.getLineCount();
            } else {
                this.b = false;
            }
            if (PhotoViewerCaptionEnterView.this.t) {
                return;
            }
            if (PhotoViewerCaptionEnterView.this.w != null) {
                PhotoViewerCaptionEnterView.this.w.b(charSequence);
            }
            if (i3 - i2 > 1) {
                this.a = true;
            }
        }
    }

    private class c implements m.h {
        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.m.h
        public int getColor(int i) {
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.T3) {
                return -14803426;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.N4) {
                return -15198183;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.p5) {
                return -1;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.md) {
                return -8553090;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.R4) {
                return -10177027;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.kd) {
                return -9211020;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.qd || i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.jd) {
                return 181267199;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.nd || i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.od) {
                return -9539985;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.pd || i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.rd) {
                return -10177041;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.id) {
                return -14803425;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.ld) {
                return -1610612736;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.sd) {
                return -9539985;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4) {
                return 771751936;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.M5) {
                return -16777216;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4) {
                return -10177041;
            }
            if (i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.H4) {
                return -1;
            }
            return i == ir.nasim.tgwidgets.editor.ui.ActionBar.m.ud ? 1946157055 : 0;
        }

        private c() {
        }
    }

    public interface d {
        void a();

        void b(CharSequence charSequence);

        void c(int i);
    }

    public PhotoViewerCaptionEnterView(PhotoViewer photoViewer, Context context, SizeNotifierFrameLayoutPhoto sizeNotifierFrameLayoutPhoto, View view, m.h hVar) {
        super(context);
        this.x = true;
        this.y = 1.0f;
        this.H = C22477vI7.f;
        this.J = 0.0f;
        this.z0 = new Paint();
        this.A0 = 0.0f;
        this.G = new c();
        this.z0.setColor(2130706432);
        setWillNotDraw(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        this.A = view;
        this.e = sizeNotifierFrameLayoutPhoto;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setClipChildren(false);
        linearLayout.setOrientation(0);
        addView(linearLayout, AbstractC13840gu3.c(-1, -2.0f, 51, 2.0f, 0.0f, 0.0f, 0.0f));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setClipChildren(false);
        linearLayout.addView(frameLayout, AbstractC13840gu3.h(0, -2, 1.0f));
        ImageView imageView = new ImageView(context);
        this.c = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.c.setPadding(AbstractC21455b.F(4.0f), AbstractC21455b.F(1.0f), 0, 0);
        this.c.setAlpha(0.58f);
        frameLayout.addView(this.c, AbstractC13840gu3.d(48, 48, 83));
        this.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Gb5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.N(view2);
            }
        });
        this.c.setContentDescription(FH3.E("Emoji", TD5.tgwidget_Emoji));
        ImageView imageView2 = this.c;
        NO5 no5 = new NO5(context);
        this.d = no5;
        imageView2.setImageDrawable(no5);
        this.d.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
        this.d.c(AbstractC23598xB5.input_smile, false);
        TextPaint textPaint = new TextPaint(1);
        this.B = textPaint;
        textPaint.setTextSize(AbstractC21455b.F(13.0f));
        this.B.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.B.setColor(-2500135);
        a aVar = new a(context, null);
        this.b = aVar;
        aVar.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.Hb5
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                this.a.O(view2, z);
            }
        });
        this.b.setSelectAllOnFocus(false);
        this.b.setTypeface(C6011Lu2.i());
        this.b.setDelegate(new EditTextCaption.e() { // from class: ir.nasim.Ib5
            @Override // ir.nasim.tgwidgets.editor.ui.Components.EditTextCaption.e
            public final void a() {
                this.a.P();
            }
        });
        this.b.setWindowView(this.A);
        this.b.setHint(FH3.E("AddCaption", TD5.tgwidget_AddCaption));
        this.b.setImeOptions(268435456);
        this.b.setLinkTextColor(-8994063);
        EditTextCaption editTextCaption = this.b;
        editTextCaption.setInputType(editTextCaption.getInputType() | 16384);
        this.b.setMaxLines(4);
        this.b.setHorizontallyScrolling(false);
        this.b.setTextSize(1, 18.0f);
        this.b.setGravity(80);
        this.b.setPadding(0, AbstractC21455b.F(11.0f), 0, AbstractC21455b.F(12.0f));
        this.b.setBackgroundDrawable(null);
        this.b.setCursorColor(-1);
        this.b.setCursorSize(AbstractC21455b.F(20.0f));
        this.b.setTextColor(-1);
        this.b.setHighlightColor(1342177279);
        this.b.setHintTextColor(-1291845633);
        frameLayout.addView(this.b, AbstractC13840gu3.c(-1, -2.0f, 83, 52.0f, 0.0f, 6.0f, 0.0f));
        this.b.setOnKeyListener(new View.OnKeyListener() { // from class: ir.nasim.Jb5
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i, KeyEvent keyEvent) {
                return this.a.Q(view2, i, keyEvent);
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Kb5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.R(view2);
            }
        });
        this.b.addTextChangedListener(new b());
        this.f = ir.nasim.tgwidgets.editor.ui.ActionBar.m.K(AbstractC21455b.F(16.0f), -10043398);
        this.g = context.getResources().getDrawable(AbstractC23598xB5.input_done).mutate();
        C13010fZ0 c13010fZ0 = new C13010fZ0(this.f, this.g, 0, AbstractC21455b.F(1.0f));
        c13010fZ0.c(AbstractC21455b.F(32.0f), AbstractC21455b.F(32.0f));
        ImageView imageView3 = new ImageView(context);
        this.a = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        imageView3.setImageDrawable(c13010fZ0);
        linearLayout.addView(imageView3, AbstractC13840gu3.m(48, 48, 80));
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Lb5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.S(view2);
            }
        });
        imageView3.setContentDescription(FH3.E("Done", TD5.tgwidget_Done));
        NumberTextView numberTextView = new NumberTextView(context);
        this.h = numberTextView;
        numberTextView.setVisibility(8);
        this.h.setTextSize(15);
        this.h.setTextColor(-1);
        this.h.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.h.setCenterAlign(true);
        addView(this.h, AbstractC13840gu3.c(48, 20.0f, 85, 3.0f, 0.0f, 3.0f, 48.0f));
        this.H = C22477vI7.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(View view) {
        if (this.q || ((AbstractC21455b.s || AbstractC21455b.r) && !L())) {
            c0(1, false);
        } else {
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view, boolean z) {
        if (z) {
            try {
                EditTextCaption editTextCaption = this.b;
                editTextCaption.setSelection(editTextCaption.length(), this.b.length());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        this.b.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Q(View view, int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.A != null && H()) {
                return true;
            }
            if (!this.q && L()) {
                if (keyEvent.getAction() == 1) {
                    c0(0, true);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        if (L()) {
            c0((AbstractC21455b.s || AbstractC21455b.r) ? 0 : 2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        if (getCaptionLimit() - this.v >= 0) {
            this.w.a();
            return;
        }
        AbstractC21455b.x1(this.h);
        try {
            this.h.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(ValueAnimator valueAnimator) {
        this.b.setOffsetY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(ValueAnimator valueAnimator) {
        this.A0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        EditTextCaption editTextCaption = this.b;
        if (editTextCaption != null) {
            try {
                editTextCaption.requestFocus();
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i, int i2) {
        if (TextUtils.isEmpty(this.b.getText())) {
            this.b.animate().cancel();
            this.b.setOffsetY(0.0f);
            this.k = false;
        } else {
            this.k = true;
            this.l = this.b.getMeasuredHeight();
            this.m = this.b.getScrollY();
            invalidate();
        }
        this.n = getTop() + this.A0;
    }

    private void Z() {
        int height = this.e.getHeight();
        if (!this.q) {
            height -= this.r;
        }
        d dVar = this.w;
        if (dVar != null) {
            dVar.c(height);
        }
    }

    private void b0() {
        c0((AbstractC21455b.s || AbstractC21455b.r) ? 0 : 2, false);
        a0();
    }

    private void c0(int i, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCaptionLimit() {
        return 1024;
    }

    public void E() {
        AbstractC21455b.t0(this.b);
        this.b.clearFocus();
    }

    protected void F(ActionMode actionMode, Menu menu) {
    }

    public boolean H() {
        return false;
    }

    public void I() {
        if (L()) {
            c0(0, true);
        }
    }

    public boolean J() {
        return ((AbstractC21455b.r || AbstractC21455b.s) && getTag() != null) || this.q;
    }

    public boolean K() {
        return this.u;
    }

    public boolean L() {
        return false;
    }

    public boolean M(View view) {
        return false;
    }

    public void W() {
        ir.nasim.tgwidgets.editor.messenger.E.j().e(this, ir.nasim.tgwidgets.editor.messenger.E.K2);
        ir.nasim.tgwidgets.editor.messenger.E.k(this.H).e(this, ir.nasim.tgwidgets.editor.messenger.E.F3);
    }

    public void X() {
        I();
        if (J()) {
            E();
        }
        this.q = false;
        ir.nasim.tgwidgets.editor.messenger.E.j().u(this, ir.nasim.tgwidgets.editor.messenger.E.K2);
        ir.nasim.tgwidgets.editor.messenger.E.k(this.H).u(this, ir.nasim.tgwidgets.editor.messenger.E.F3);
        SizeNotifierFrameLayoutPhoto sizeNotifierFrameLayoutPhoto = this.e;
        if (sizeNotifierFrameLayoutPhoto != null) {
            sizeNotifierFrameLayoutPhoto.setDelegate(null);
        }
    }

    public void a0() {
        this.b.requestFocus();
        AbstractC21455b.C1(this.b);
        try {
            EditTextCaption editTextCaption = this.b;
            editTextCaption.setSelection(editTextCaption.length(), this.b.length());
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    public void d0() {
        ir.nasim.tgwidgets.editor.ui.ActionBar.m.d1(this.f, G(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4));
        ir.nasim.tgwidgets.editor.ui.ActionBar.m.d1(this.g, QY0.k(G(ir.nasim.tgwidgets.editor.ui.ActionBar.m.H4), (int) (Color.alpha(r0) * ((this.y * 0.42f) + 0.58f))));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.drawRect(0.0f, this.A0, getMeasuredWidth(), getMeasuredHeight(), this.z0);
        canvas.clipRect(0.0f, this.A0, getMeasuredWidth(), getMeasuredHeight());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getCaptionLimitOffset() {
        return getCaptionLimit() - this.v;
    }

    public int getCodePointCount() {
        return this.v;
    }

    public int getCursorPosition() {
        EditTextCaption editTextCaption = this.b;
        if (editTextCaption == null) {
            return 0;
        }
        return editTextCaption.getSelectionStart();
    }

    public int getEmojiPadding() {
        return this.r;
    }

    public CharSequence getFieldCharSequence() {
        return AbstractC21455b.p0(this.b.getText());
    }

    public EditTextCaption getMessageEditText() {
        return this.b;
    }

    public m.h getResourcesProvider() {
        return this.G;
    }

    public int getSelectionLength() {
        EditTextCaption editTextCaption = this.b;
        if (editTextCaption == null) {
            return 0;
        }
        try {
            return editTextCaption.getSelectionEnd() - this.b.getSelectionStart();
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
            return 0;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.k) {
            float measuredHeight = (this.l - this.b.getMeasuredHeight()) + (this.m - this.b.getScrollY());
            EditTextCaption editTextCaption = this.b;
            editTextCaption.setOffsetY(editTextCaption.getOffsetY() - measuredHeight);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.b.getOffsetY(), 0.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Cb5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a.T(valueAnimator);
                }
            });
            ValueAnimator valueAnimator = this.B0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.B0 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(200L);
            valueAnimatorOfFloat.setInterpolator(InterpolatorC12631ew1.f);
            valueAnimatorOfFloat.start();
            this.k = false;
        }
        float f = this.n;
        if (f == 0.0f || f == getTop() + this.A0) {
            return;
        }
        ValueAnimator valueAnimator2 = this.C0;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        float top = this.n - (getTop() + this.A0);
        this.A0 = top;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(top, 0.0f);
        this.C0 = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Db5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                this.a.U(valueAnimator3);
            }
        });
        this.C0.setInterpolator(InterpolatorC12631ew1.f);
        this.C0.setDuration(200L);
        this.C0.start();
        this.n = 0.0f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.SizeNotifierFrameLayoutPhoto.a
    public void onSizeChanged(int i, boolean z) {
        boolean z2;
        L();
        if (this.o == i && this.p == z) {
            Z();
            return;
        }
        this.o = i;
        this.p = z;
        boolean z3 = this.q;
        boolean z4 = i > 0;
        this.q = z4;
        if (z4 && L()) {
            c0(0, false);
        }
        if (this.r != 0 && !(z2 = this.q) && z2 != z3 && !L()) {
            this.r = 0;
            this.e.requestLayout();
        }
        Z();
    }

    public void setAllowTextEntitiesIntersection(boolean z) {
        this.b.setAllowTextEntitiesIntersection(z);
    }

    public void setDelegate(d dVar) {
        this.w = dVar;
    }

    public void setFieldFocused(boolean z) {
        EditTextCaption editTextCaption = this.b;
        if (editTextCaption == null) {
            return;
        }
        if (z) {
            if (editTextCaption.isFocused()) {
                return;
            }
            this.b.postDelayed(new Runnable() { // from class: ir.nasim.Fb5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.V();
                }
            }, 600L);
        } else {
            if (!editTextCaption.isFocused() || this.q) {
                return;
            }
            this.b.clearFocus();
        }
    }

    public void setFieldText(CharSequence charSequence) {
        EditTextCaption editTextCaption = this.b;
        if (editTextCaption == null) {
            return;
        }
        editTextCaption.setText(charSequence);
        EditTextCaption editTextCaption2 = this.b;
        editTextCaption2.setSelection(editTextCaption2.getText().length());
        d dVar = this.w;
        if (dVar != null) {
            dVar.b(this.b.getText());
        }
    }

    public void setForceFloatingEmoji(boolean z) {
        this.s = z;
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) {
        int i3 = ir.nasim.tgwidgets.editor.messenger.E.s;
    }
}
