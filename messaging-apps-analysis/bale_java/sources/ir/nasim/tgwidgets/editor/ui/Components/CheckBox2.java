package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.YE2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.CheckBoxBase;

/* loaded from: classes7.dex */
public class CheckBox2 extends View {
    private CheckBoxBase a;
    Drawable b;
    int c;

    public CheckBox2(Context context, int i) {
        this(context, i, null);
    }

    public boolean a() {
        return this.a.k();
    }

    public CheckBoxBase getCheckBoxBase() {
        return this.a;
    }

    public float getProgress() {
        return this.a.getProgress();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.m();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.n();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.b == null) {
            this.a.h(canvas);
            return;
        }
        int measuredWidth = getMeasuredWidth() >> 1;
        int measuredHeight = getMeasuredHeight() >> 1;
        Drawable drawable = this.b;
        drawable.setBounds(measuredWidth - (drawable.getIntrinsicWidth() / 2), measuredHeight - (this.b.getIntrinsicHeight() / 2), (this.b.getIntrinsicWidth() / 2) + measuredWidth, (this.b.getIntrinsicHeight() / 2) + measuredHeight);
        this.b.draw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(AbstractC21455b.F(1.2f));
        paint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.D5));
        canvas.drawCircle(measuredWidth, measuredHeight, measuredWidth - AbstractC21455b.F(1.5f), paint);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(a());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.a.p(0, 0, i3 - i, i4 - i2);
    }

    public void setChecked(int i, boolean z, boolean z2) {
        this.a.q(i, z, z2);
    }

    public void setCirclePaintProvider(YE2 ye2) {
        this.a.s(ye2);
    }

    public void setColor(int i, int i2, int i3) {
        this.a.t(i, i2, i3);
    }

    public void setDrawBackgroundAsArc(int i) {
        this.a.o(i);
    }

    public void setDrawUnchecked(boolean z) {
        this.a.u(z);
    }

    public void setDuration(long j) {
        this.a.A = j;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.a.v(z);
        super.setEnabled(z);
    }

    public void setForbidden(boolean z) {
        this.a.w(z);
    }

    public void setIcon(int i) {
        if (i != this.c) {
            this.c = i;
            if (i == 0) {
                this.b = null;
                return;
            }
            Drawable drawableMutate = AbstractC4043Dl1.f(getContext(), i).mutate();
            this.b = drawableMutate;
            drawableMutate.setColorFilter(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.D5), PorterDuff.Mode.MULTIPLY);
        }
    }

    public void setNum(int i) {
        this.a.x(i);
    }

    public void setProgressDelegate(CheckBoxBase.b bVar) {
        this.a.y(bVar);
    }

    public CheckBox2(Context context, int i, m.h hVar) {
        super(context);
        this.a = new CheckBoxBase(this, i, hVar);
    }

    public void setChecked(boolean z, boolean z2) {
        this.a.r(z, z2);
    }
}
