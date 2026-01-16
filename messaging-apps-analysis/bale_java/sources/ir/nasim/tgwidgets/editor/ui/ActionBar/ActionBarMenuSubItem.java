package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.FH3;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.CheckBox2;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;

/* loaded from: classes7.dex */
public class ActionBarMenuSubItem extends FrameLayout {
    private TextView a;
    private TextView b;
    private RLottieImageView c;
    private CheckBox2 d;
    private ImageView e;
    private int f;
    private int g;
    private int h;
    boolean i;
    boolean j;
    private int k;
    private final m.h l;
    Runnable m;
    boolean n;

    public ActionBarMenuSubItem(Context context, boolean z, boolean z2, boolean z3, m.h hVar) {
        this(context, z ? 1 : 0, z2, z3, hVar);
    }

    private int a(int i) {
        return m.j0(i, this.l);
    }

    public void b() {
        if (this.c.getAnimatedDrawable() != null) {
            this.c.getAnimatedDrawable().start();
        }
    }

    public void c() {
        Runnable runnable = this.m;
        if (runnable != null) {
            runnable.run();
        }
    }

    public ActionBarMenuSubItem d(int i, int i2) {
        setTextColor(i);
        setIconColor(i2);
        return this;
    }

    void e() {
        setBackground(m.U(this.h, this.i ? 6 : 0, this.j ? 6 : 0));
    }

    public void f(boolean z, boolean z2) {
        if (this.i == z && this.j == z2) {
            return;
        }
        this.i = z;
        this.j = z2;
        e();
    }

    public ImageView getRightIcon() {
        return this.e;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setEnabled(isEnabled());
        CheckBox2 checkBox2 = this.d;
        if (checkBox2 == null || !checkBox2.a()) {
            return;
        }
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(this.d.a());
        accessibilityNodeInfo.setClassName("android.widget.CheckBox");
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(this.k), 1073741824));
        if (!this.n || this.a.getLayout().getLineCount() <= 1) {
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(this.k + 8), 1073741824));
    }

    public void setIcon(int i) {
        this.c.setImageResource(i);
    }

    public void setIconColor(int i) {
        if (this.g != i) {
            RLottieImageView rLottieImageView = this.c;
            this.g = i;
            rLottieImageView.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.MULTIPLY));
        }
    }

    public void setRightIcon(int i) {
        if (this.e == null) {
            ImageView imageView = new ImageView(getContext());
            this.e = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.e.setColorFilter(this.g, PorterDuff.Mode.MULTIPLY);
            if (FH3.D) {
                this.e.setScaleX(-1.0f);
            }
            addView(this.e, AbstractC13840gu3.d(24, -1, (FH3.D ? 3 : 5) | 16));
        }
        setPadding(AbstractC21455b.F(FH3.D ? 8.0f : 18.0f), 0, AbstractC21455b.F(FH3.D ? 18.0f : 8.0f), 0);
        this.e.setImageResource(i);
    }

    public void setSelectorColor(int i) {
        if (this.h != i) {
            this.h = i;
            e();
        }
    }

    public void setSubtext(String str) {
        if (this.b == null) {
            TextView textView = new TextView(getContext());
            this.b = textView;
            textView.setLines(1);
            this.b.setSingleLine(true);
            this.b.setGravity(3);
            this.b.setEllipsize(TextUtils.TruncateAt.END);
            this.b.setTextColor(a(m.Of));
            this.b.setVisibility(8);
            this.b.setTextSize(1, 13.0f);
            this.b.setPadding(FH3.D ? 0 : AbstractC21455b.F(43.0f), 0, FH3.D ? AbstractC21455b.F(43.0f) : 0, 0);
            addView(this.b, AbstractC13840gu3.c(-2, -2.0f, (FH3.D ? 5 : 3) | 16, 0.0f, 10.0f, 0.0f, 0.0f));
        }
        boolean z = !TextUtils.isEmpty(str);
        if (z != (this.b.getVisibility() == 0)) {
            this.b.setVisibility(z ? 0 : 8);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            layoutParams.bottomMargin = z ? AbstractC21455b.F(10.0f) : 0;
            this.a.setLayoutParams(layoutParams);
        }
        this.b.setText(str);
    }

    public void setText(CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    public void setTextAndIcon(CharSequence charSequence, int i) {
        setTextAndIcon(charSequence, i, null);
    }

    public void setTextColor(int i) {
        if (this.f != i) {
            TextView textView = this.a;
            this.f = i;
            textView.setTextColor(i);
        }
    }

    public ActionBarMenuSubItem(Context context, int i, boolean z, boolean z2, m.h hVar) {
        super(context);
        this.k = 48;
        this.l = hVar;
        this.i = z;
        this.j = z2;
        this.f = a(m.l7);
        this.g = a(m.m7);
        this.h = a(m.u4);
        e();
        setPadding(AbstractC21455b.F(18.0f), 0, AbstractC21455b.F(18.0f), 0);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.c = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.c.setColorFilter(new PorterDuffColorFilter(this.g, PorterDuff.Mode.MULTIPLY));
        addView(this.c, AbstractC13840gu3.d(-2, 40, (FH3.D ? 5 : 3) | 16));
        TextView textView = new TextView(context);
        this.a = textView;
        textView.setLines(1);
        this.a.setSingleLine(true);
        this.a.setGravity(3);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        this.a.setTextColor(this.f);
        this.a.setTextSize(1, 16.0f);
        addView(this.a, AbstractC13840gu3.d(-2, -2, (FH3.D ? 5 : 3) | 16));
        if (i > 0) {
            CheckBox2 checkBox2 = new CheckBox2(context, 26, hVar);
            this.d = checkBox2;
            checkBox2.setDrawUnchecked(false);
            this.d.setColor(-1, -1, m.Q5);
            this.d.setDrawBackgroundAsArc(-1);
            if (i == 1) {
                addView(this.d, AbstractC13840gu3.d(26, -1, (FH3.D ? 5 : 3) | 16));
            } else {
                addView(this.d, AbstractC13840gu3.d(26, -1, (FH3.D ? 3 : 5) | 16));
                this.a.setPadding(FH3.D ? AbstractC21455b.F(34.0f) : 0, 0, FH3.D ? 0 : AbstractC21455b.F(34.0f), 0);
            }
        }
    }

    public void setTextAndIcon(CharSequence charSequence, int i, Drawable drawable) {
        this.a.setText(charSequence);
        if (i == 0 && drawable == null && this.d == null) {
            this.c.setVisibility(4);
            this.a.setPadding(0, 0, 0, 0);
            return;
        }
        if (drawable != null) {
            this.c.setImageDrawable(drawable);
        } else {
            this.c.setImageResource(i);
        }
        this.c.setVisibility(0);
        this.a.setPadding(FH3.D ? 0 : AbstractC21455b.F(43.0f), 0, FH3.D ? AbstractC21455b.F(43.0f) : 0, 0);
    }
}
