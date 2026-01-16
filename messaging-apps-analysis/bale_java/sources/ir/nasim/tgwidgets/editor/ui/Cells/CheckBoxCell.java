package ir.nasim.tgwidgets.editor.ui.Cells;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.CheckBox2;
import ir.nasim.tgwidgets.editor.ui.Components.CheckBoxSquare;

/* loaded from: classes7.dex */
public class CheckBoxCell extends FrameLayout {
    private final m.h a;
    private final TextView b;
    private final TextView c;
    private final View d;
    private CheckBoxSquare e;
    private CheckBox2 f;
    private View g;
    private final int h;
    private final int i;
    private boolean j;
    private boolean k;
    private View l;
    private View m;

    private int a(int i) {
        return m.j0(i, this.a);
    }

    private void c() {
        float measuredWidth;
        if (this.g == null) {
            return;
        }
        try {
            measuredWidth = this.b.getMeasuredWidth();
        } catch (Exception unused) {
            measuredWidth = 0.0f;
        }
        this.g.setTranslationX(FH3.D ? (this.b.getRight() - measuredWidth) - AbstractC21455b.F(20.0f) : this.b.getLeft() + measuredWidth + AbstractC21455b.F(4.0f));
    }

    public boolean b() {
        CheckBox2 checkBox2 = this.f;
        return checkBox2 != null ? checkBox2.a() : this.e.d();
    }

    public CheckBox2 getCheckBoxRound() {
        return this.f;
    }

    public View getCheckBoxView() {
        return this.d;
    }

    public TextView getTextView() {
        return this.b;
    }

    public TextView getValueTextView() {
        return this.c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.j) {
            int iF = AbstractC21455b.F(this.h == 4 ? 60.0f : 20.0f) + ((int) Math.abs(this.b.getTranslationX()));
            float f = FH3.D ? 0.0f : iF;
            float measuredHeight = getMeasuredHeight() - 1;
            int measuredWidth = getMeasuredWidth();
            if (!FH3.D) {
                iF = 0;
            }
            canvas.drawLine(f, measuredHeight, measuredWidth - iF, getMeasuredHeight() - 1, m.V);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.CheckBox");
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(b());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        if (this.h == 3) {
            this.c.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(10.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(50.0f), 1073741824));
            this.b.measure(View.MeasureSpec.makeMeasureSpec(size - AbstractC21455b.F(34.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(50.0f), 1073741824));
            this.d.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(this.i), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(this.i), 1073741824));
            setMeasuredDimension(this.b.getMeasuredWidth() + AbstractC21455b.F(29.0f), AbstractC21455b.F(50.0f));
        } else if (this.k) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(i), AbstractC21455b.F(50.0f) + (this.j ? 1 : 0));
            int measuredWidth = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - AbstractC21455b.F(this.h == 4 ? 60.0f : 34.0f);
            if (this.c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                measuredWidth -= ((ViewGroup.MarginLayoutParams) this.c.getLayoutParams()).rightMargin;
            }
            this.c.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth / 2, RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            TextView textView = this.b;
            textView.measure(View.MeasureSpec.makeMeasureSpec(((measuredWidth - ((int) Math.abs(textView.getTranslationX()))) - this.c.getMeasuredWidth()) - AbstractC21455b.F(8.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            this.d.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(this.i), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(this.i), 1073741824));
        }
        View view = this.l;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            this.l.measure(View.MeasureSpec.makeMeasureSpec((size - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(50.0f), 1073741824));
        }
        View view2 = this.m;
        if (view2 != null) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(56.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(50.0f), 1073741824));
        }
        View view3 = this.g;
        if (view3 != null) {
            view3.measure(View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(16.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(16.0f), 1073741824));
        }
    }

    public void setCheckBoxColor(int i, int i2, int i3) {
        CheckBox2 checkBox2 = this.f;
        if (checkBox2 != null) {
            checkBox2.setColor(i, i, i3);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        CheckBox2 checkBox2 = this.f;
        if (checkBox2 != null) {
            checkBox2.setChecked(z, z2);
        } else {
            this.e.setChecked(z, z2);
        }
    }

    public void setCollapsed(Boolean bool) {
        if (bool == null) {
            View view = this.g;
            if (view != null) {
                removeView(view);
                this.g = null;
                return;
            }
            return;
        }
        if (this.g == null) {
            this.g = new View(getContext());
            Drawable drawableMutate = getContext().getResources().getDrawable(AbstractC23598xB5.arrow_more).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(a(m.p5), PorterDuff.Mode.MULTIPLY));
            this.g.setBackground(drawableMutate);
            addView(this.g, AbstractC13840gu3.d(16, 16, 16));
        }
        c();
        this.g.animate().cancel();
        this.g.animate().rotation(bool.booleanValue() ? 0.0f : 180.0f).setDuration(340L).setInterpolator(InterpolatorC12631ew1.h).start();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.b.setAlpha(z ? 1.0f : 0.5f);
        this.c.setAlpha(z ? 1.0f : 0.5f);
        this.d.setAlpha(z ? 1.0f : 0.5f);
    }

    public void setIcon(int i) {
        this.f.setIcon(i);
    }

    public void setMultiline(boolean z) {
        this.k = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        if (this.k) {
            this.b.setLines(0);
            this.b.setMaxLines(0);
            this.b.setSingleLine(false);
            this.b.setEllipsize(null);
            if (this.h != 5) {
                this.b.setPadding(0, 0, 0, AbstractC21455b.F(5.0f));
                layoutParams.height = -2;
                layoutParams.topMargin = AbstractC21455b.F(10.0f);
                layoutParams2.topMargin = AbstractC21455b.F(12.0f);
            }
        } else {
            this.b.setLines(1);
            this.b.setMaxLines(1);
            this.b.setSingleLine(true);
            this.b.setEllipsize(TextUtils.TruncateAt.END);
            this.b.setPadding(0, 0, 0, 0);
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            layoutParams2.topMargin = AbstractC21455b.F(15.0f);
        }
        this.b.setLayoutParams(layoutParams);
        this.d.setLayoutParams(layoutParams2);
    }

    public void setNeedDivider(boolean z) {
        this.j = z;
    }

    public void setOnSectionsClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        if (onClickListener == null) {
            View view = this.l;
            if (view != null) {
                removeView(view);
                this.l = null;
            }
        } else {
            if (this.l == null) {
                View view2 = new View(getContext());
                this.l = view2;
                view2.setBackground(m.Z(a(m.S4), 2));
                addView(this.l, AbstractC13840gu3.d(-1, -1, 119));
            }
            this.l.setOnClickListener(onClickListener);
        }
        if (onClickListener2 == null) {
            View view3 = this.m;
            if (view3 != null) {
                removeView(view3);
                this.m = null;
                return;
            }
            return;
        }
        if (this.m == null) {
            View view4 = new View(getContext());
            this.m = view4;
            addView(view4, AbstractC13840gu3.d(56, -1, FH3.D ? 5 : 3));
        }
        this.m.setOnClickListener(onClickListener2);
    }

    public void setPad(int i) {
        int iF = AbstractC21455b.F(i * 40 * (FH3.D ? -1 : 1));
        View view = this.d;
        if (view != null) {
            view.setTranslationX(iF);
        }
        float f = iF;
        this.b.setTranslationX(f);
        View view2 = this.l;
        if (view2 != null) {
            view2.setTranslationX(f);
        }
        View view3 = this.m;
        if (view3 != null) {
            view3.setTranslationX(f);
        }
    }

    public void setSquareCheckBoxColor(int i, int i2, int i3) {
        CheckBoxSquare checkBoxSquare = this.e;
        if (checkBoxSquare != null) {
            checkBoxSquare.setColors(i, i2, i3);
        }
    }

    public void setText(CharSequence charSequence, String str, boolean z, boolean z2) {
        setText(charSequence, str, z, z2, false);
    }

    public void setTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setText(CharSequence charSequence, String str, boolean z, boolean z2, boolean z3) {
        this.b.setText(charSequence);
        CheckBox2 checkBox2 = this.f;
        if (checkBox2 != null) {
            checkBox2.setChecked(z, z3);
        } else {
            this.e.setChecked(z, z3);
        }
        this.c.setText(str);
        this.j = z2;
        setWillNotDraw(!z2);
    }
}
