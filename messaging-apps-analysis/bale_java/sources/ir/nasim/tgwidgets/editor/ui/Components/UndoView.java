package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.C22477vI7;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.UndoView;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class UndoView extends FrameLayout {
    private CharSequence A;
    int A0;
    private int B;
    float B0;
    float C0;
    Drawable D;
    private final m.h G;
    private int H;
    StaticLayout J;
    private TextView a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private RLottieImageView e;
    private BackupImageView f;
    private LinearLayout g;
    private int h;
    private Object i;
    private Object j;
    private int k;
    private TextPaint l;
    private Paint m;
    private RectF n;
    private long o;
    private int p;
    private String q;
    private int r;
    private int s;
    private ArrayList t;
    private Runnable u;
    private Runnable v;
    private long w;
    private float x;
    private boolean y;
    private boolean z;
    StaticLayout z0;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            UndoView.this.setVisibility(4);
            UndoView.this.setScaleX(1.0f);
            UndoView.this.setScaleY(1.0f);
            UndoView.this.setAlpha(1.0f);
        }
    }

    public class b extends LinkMovementMethod {
        public b() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            CharacterStyle[] characterStyleArr;
            try {
                if (motionEvent.getAction() != 0 || ((characterStyleArr = (CharacterStyle[]) spannable.getSpans(textView.getSelectionStart(), textView.getSelectionEnd(), CharacterStyle.class)) != null && characterStyleArr.length != 0)) {
                    if (motionEvent.getAction() != 1) {
                        return super.onTouchEvent(textView, spannable, motionEvent);
                    }
                    CharacterStyle[] characterStyleArr2 = (CharacterStyle[]) spannable.getSpans(textView.getSelectionStart(), textView.getSelectionEnd(), CharacterStyle.class);
                    if (characterStyleArr2 != null && characterStyleArr2.length > 0) {
                        UndoView.this.d(characterStyleArr2[0]);
                    }
                    Selection.removeSelection(spannable);
                    return true;
                }
                return false;
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
                return false;
            }
        }
    }

    public UndoView(Context context) {
        this(context, null, false, null);
    }

    private int e(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        if (c()) {
            f(false, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean h(View view, MotionEvent motionEvent) {
        return true;
    }

    private void j() {
        setTranslationY(((this.C0 - this.H) + AbstractC21455b.F(8.0f)) - this.x);
        invalidate();
    }

    protected boolean c() {
        return true;
    }

    public void d(CharacterStyle characterStyle) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.x == 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        float measuredHeight = (getMeasuredHeight() - this.C0) + AbstractC21455b.F(9.0f);
        if (measuredHeight > 0.0f) {
            canvas.clipRect(0.0f, 0.0f, getMeasuredWidth(), measuredHeight);
            super.dispatchDraw(canvas);
        }
        canvas.restore();
    }

    public void f(boolean z, int i) {
        if (getVisibility() == 0 && this.y) {
            this.i = null;
            this.j = null;
            this.y = false;
            Runnable runnable = this.u;
            if (runnable != null) {
                if (z) {
                    runnable.run();
                }
                this.u = null;
            }
            Runnable runnable2 = this.v;
            if (runnable2 != null) {
                if (!z) {
                    runnable2.run();
                }
                this.v = null;
            }
            int i2 = this.s;
            if (i2 == 0 || i2 == 1 || i2 == 26 || i2 == 27) {
                for (int i3 = 0; i3 < this.t.size(); i3++) {
                    long jLongValue = ((Long) this.t.get(i3)).longValue();
                    ir.nasim.tgwidgets.editor.messenger.C cN = ir.nasim.tgwidgets.editor.messenger.C.n(this.k);
                    int i4 = this.s;
                    cN.C(jLongValue, i4 == 0 || i4 == 26, z);
                    i(jLongValue, this.s);
                }
            }
            if (i == 0) {
                setEnterOffset((this.z ? -1.0f : 1.0f) * (this.H + this.h));
                setVisibility(4);
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            if (i == 1) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(this, "enterOffset", (this.z ? -1.0f : 1.0f) * (this.H + this.h)));
                animatorSet.setDuration(250L);
            } else {
                animatorSet.playTogether(ObjectAnimator.ofFloat(this, (Property<UndoView, Float>) View.SCALE_X, 0.8f), ObjectAnimator.ofFloat(this, (Property<UndoView, Float>) View.SCALE_Y, 0.8f), ObjectAnimator.ofFloat(this, (Property<UndoView, Float>) View.ALPHA, 0.0f));
                animatorSet.setDuration(180L);
            }
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.addListener(new a());
            animatorSet.start();
        }
    }

    @Override // android.view.View
    public Drawable getBackground() {
        return this.D;
    }

    public Object getCurrentInfoObject() {
        return this.i;
    }

    @Keep
    public float getEnterOffset() {
        return this.C0;
    }

    protected void i(long j, int i) {
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        this.a.invalidate();
        this.e.invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.x != 0.0f) {
            canvas.save();
            float measuredHeight = (getMeasuredHeight() - this.C0) + this.H + AbstractC21455b.F(1.0f);
            if (measuredHeight > 0.0f) {
                canvas.clipRect(0.0f, 0.0f, getMeasuredWidth(), measuredHeight);
                super.dispatchDraw(canvas);
            }
            this.D.draw(canvas);
            canvas.restore();
        } else {
            this.D.draw(canvas);
        }
        int i = this.s;
        if (i == 1 || i == 0 || i == 27 || i == 26 || i == 81 || i == 88) {
            int iCeil = this.o > 0 ? (int) Math.ceil(r6 / 1000.0f) : 0;
            if (this.p != iCeil) {
                this.p = iCeil;
                this.q = String.format("%d", Integer.valueOf(Math.max(1, iCeil)));
                StaticLayout staticLayout = this.J;
                if (staticLayout != null) {
                    this.z0 = staticLayout;
                    this.B0 = 0.0f;
                    this.A0 = this.r;
                }
                this.r = (int) Math.ceil(this.l.measureText(r0));
                this.J = new StaticLayout(this.q, this.l, Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            float f = this.B0;
            if (f < 1.0f) {
                float f2 = f + 0.10666667f;
                this.B0 = f2;
                if (f2 > 1.0f) {
                    this.B0 = 1.0f;
                } else {
                    invalidate();
                }
            }
            int alpha = this.l.getAlpha();
            if (this.z0 != null) {
                float f3 = this.B0;
                if (f3 < 1.0f) {
                    this.l.setAlpha((int) (alpha * (1.0f - f3)));
                    canvas.save();
                    canvas.translate(this.n.centerX() - (this.r / 2), AbstractC21455b.F(17.2f) + (AbstractC21455b.F(10.0f) * this.B0));
                    this.z0.draw(canvas);
                    this.l.setAlpha(alpha);
                    canvas.restore();
                }
            }
            if (this.J != null) {
                float f4 = this.B0;
                if (f4 != 1.0f) {
                    this.l.setAlpha((int) (alpha * f4));
                }
                canvas.save();
                canvas.translate(this.n.centerX() - (this.r / 2), AbstractC21455b.F(17.2f) - (AbstractC21455b.F(10.0f) * (1.0f - this.B0)));
                this.J.draw(canvas);
                if (this.B0 != 1.0f) {
                    this.l.setAlpha(alpha);
                }
                canvas.restore();
            }
            canvas.drawArc(this.n, -90.0f, (this.o / 5000.0f) * (-360.0f), false, this.m);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.o - (jElapsedRealtime - this.w);
        this.o = j;
        this.w = jElapsedRealtime;
        if (j <= 0) {
            f(true, this.B);
        }
        if (this.s != 82) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(this.h, 1073741824));
        this.D.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void setAdditionalTranslationY(float f) {
        if (this.x != f) {
            this.x = f;
            j();
        }
    }

    public void setColors(int i, int i2) {
        ir.nasim.tgwidgets.editor.ui.ActionBar.m.d1(this.D, i);
        this.a.setTextColor(i2);
        this.b.setTextColor(i2);
        int i3 = i | (-16777216);
        this.e.setLayerColor("info1.**", i3);
        this.e.setLayerColor("info2.**", i3);
    }

    @Keep
    public void setEnterOffset(float f) {
        if (this.C0 != f) {
            this.C0 = f;
            j();
        }
    }

    public void setEnterOffsetMargin(int i) {
        this.H = i;
    }

    public void setHideAnimationType(int i) {
        this.B = i;
    }

    public void setInfoText(CharSequence charSequence) {
        this.A = charSequence;
    }

    public UndoView(Context context, ir.nasim.tgwidgets.editor.ui.ActionBar.c cVar, boolean z, m.h hVar) {
        super(context);
        this.k = C22477vI7.f;
        this.s = -1;
        this.B = 1;
        this.H = AbstractC21455b.F(8.0f);
        this.B0 = 1.0f;
        this.G = hVar;
        this.z = z;
        TextView textView = new TextView(context);
        this.a = textView;
        textView.setTextSize(1, 15.0f);
        TextView textView2 = this.a;
        int i = ir.nasim.tgwidgets.editor.ui.ActionBar.m.vg;
        textView2.setTextColor(e(i));
        TextView textView3 = this.a;
        int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.ug;
        textView3.setLinkTextColor(e(i2));
        this.a.setMovementMethod(new b());
        addView(this.a, AbstractC13840gu3.c(-2, -2.0f, 51, 45.0f, 13.0f, 0.0f, 0.0f));
        TextView textView4 = new TextView(context);
        this.b = textView4;
        textView4.setTextSize(1, 13.0f);
        this.b.setTextColor(e(i));
        this.b.setLinkTextColor(e(i2));
        this.b.setHighlightColor(0);
        this.b.setSingleLine(true);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.b.setMovementMethod(new AbstractC21455b.d());
        addView(this.b, AbstractC13840gu3.c(-2, -2.0f, 51, 58.0f, 27.0f, 8.0f, 0.0f));
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.e = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        RLottieImageView rLottieImageView2 = this.e;
        int i3 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.tg;
        rLottieImageView2.setLayerColor("info1.**", e(i3) | (-16777216));
        this.e.setLayerColor("info2.**", e(i3) | (-16777216));
        this.e.setLayerColor("luc12.**", e(i));
        this.e.setLayerColor("luc11.**", e(i));
        this.e.setLayerColor("luc10.**", e(i));
        this.e.setLayerColor("luc9.**", e(i));
        this.e.setLayerColor("luc8.**", e(i));
        this.e.setLayerColor("luc7.**", e(i));
        this.e.setLayerColor("luc6.**", e(i));
        this.e.setLayerColor("luc5.**", e(i));
        this.e.setLayerColor("luc4.**", e(i));
        this.e.setLayerColor("luc3.**", e(i));
        this.e.setLayerColor("luc2.**", e(i));
        this.e.setLayerColor("luc1.**", e(i));
        this.e.setLayerColor("Oval.**", e(i));
        addView(this.e, AbstractC13840gu3.c(54, -2.0f, 19, 3.0f, 0.0f, 0.0f, 0.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.f = backupImageView;
        backupImageView.setRoundRadius(AbstractC21455b.F(15.0f));
        addView(this.f, AbstractC13840gu3.c(30, 30.0f, 19, 15.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.g = linearLayout;
        linearLayout.setOrientation(0);
        this.g.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.U(e(i2) & 587202559, AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f)));
        addView(this.g, AbstractC13840gu3.c(-2, -2.0f, 21, 0.0f, 0.0f, 11.0f, 0.0f));
        this.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.oB7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.g(view);
            }
        });
        ImageView imageView = new ImageView(context);
        this.d = imageView;
        imageView.setImageResource(AbstractC23598xB5.chats_undo);
        this.d.setColorFilter(new PorterDuffColorFilter(e(i2), PorterDuff.Mode.MULTIPLY));
        this.g.addView(this.d, AbstractC13840gu3.n(-2, -2, 19, 4, 4, 0, 4));
        TextView textView5 = new TextView(context);
        this.c = textView5;
        textView5.setTextSize(1, 14.0f);
        this.c.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.c.setTextColor(e(i2));
        this.c.setText(FH3.E("Undo", TD5.tgwidget_Undo));
        this.g.addView(this.c, AbstractC13840gu3.n(-2, -2, 19, 6, 4, 8, 4));
        this.n = new RectF(AbstractC21455b.F(15.0f), AbstractC21455b.F(15.0f), AbstractC21455b.F(33.0f), AbstractC21455b.F(33.0f));
        Paint paint = new Paint(1);
        this.m = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(AbstractC21455b.F(2.0f));
        this.m.setStrokeCap(Paint.Cap.ROUND);
        this.m.setColor(e(i));
        TextPaint textPaint = new TextPaint(1);
        this.l = textPaint;
        textPaint.setTextSize(AbstractC21455b.F(12.0f));
        this.l.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.l.setColor(e(i));
        setWillNotDraw(false);
        this.D = ir.nasim.tgwidgets.editor.ui.ActionBar.m.W(AbstractC21455b.F(10.0f), e(i3));
        setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.pB7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return UndoView.h(view, motionEvent);
            }
        });
        setVisibility(4);
    }
}
