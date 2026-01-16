package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class PhotoEditorSeekBar extends View {
    private Paint a;
    private Paint b;
    private int c;
    private int d;
    private float e;
    private boolean f;
    private int g;
    private int h;
    private a i;

    public interface a {
        void a(int i, int i2);
    }

    public PhotoEditorSeekBar(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new Paint(1);
        this.c = AbstractC21455b.F(16.0f);
        this.d = 0;
        this.e = 0.0f;
        this.f = false;
        this.a.setColor(-11711155);
        this.b.setColor(-1);
    }

    public int getProgress() {
        return (int) (this.g + (this.e * (this.h - r0)));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int measuredHeight = (getMeasuredHeight() - this.c) / 2;
        int measuredWidth = getMeasuredWidth();
        int i = this.c;
        int i2 = (int) ((measuredWidth - i) * this.e);
        canvas.drawRect(i / 2, (getMeasuredHeight() / 2) - AbstractC21455b.F(1.0f), getMeasuredWidth() - (this.c / 2), (getMeasuredHeight() / 2) + AbstractC21455b.F(1.0f), this.a);
        if (this.g == 0) {
            canvas.drawRect(this.c / 2, (getMeasuredHeight() / 2) - AbstractC21455b.F(1.0f), i2, (getMeasuredHeight() / 2) + AbstractC21455b.F(1.0f), this.b);
        } else if (this.e > 0.5f) {
            canvas.drawRect((getMeasuredWidth() / 2) - AbstractC21455b.F(1.0f), (getMeasuredHeight() - this.c) / 2, getMeasuredWidth() / 2, (getMeasuredHeight() + this.c) / 2, this.b);
            canvas.drawRect(getMeasuredWidth() / 2, (getMeasuredHeight() / 2) - AbstractC21455b.F(1.0f), i2, (getMeasuredHeight() / 2) + AbstractC21455b.F(1.0f), this.b);
        } else {
            canvas.drawRect(getMeasuredWidth() / 2, (getMeasuredHeight() - this.c) / 2, (getMeasuredWidth() / 2) + AbstractC21455b.F(1.0f), (getMeasuredHeight() + this.c) / 2, this.b);
            canvas.drawRect(i2, (getMeasuredHeight() / 2) - AbstractC21455b.F(1.0f), getMeasuredWidth() / 2, (getMeasuredHeight() / 2) + AbstractC21455b.F(1.0f), this.b);
        }
        int i3 = this.c;
        canvas.drawCircle(i2 + (i3 / 2), measuredHeight + (i3 / 2), i3 / 2, this.b);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float measuredWidth = (int) ((getMeasuredWidth() - this.c) * this.e);
        if (motionEvent.getAction() == 0) {
            int measuredHeight = getMeasuredHeight();
            int i = this.c;
            float f = (measuredHeight - i) / 2;
            if (measuredWidth - f <= x && x <= i + measuredWidth + f && y >= 0.0f && y <= getMeasuredHeight()) {
                this.f = true;
                this.d = (int) (x - measuredWidth);
                getParent().requestDisallowInterceptTouchEvent(true);
                invalidate();
                return true;
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.f) {
                this.f = false;
                invalidate();
                return true;
            }
        } else if (motionEvent.getAction() == 2 && this.f) {
            float f2 = (int) (x - this.d);
            this.e = (f2 >= 0.0f ? f2 > ((float) (getMeasuredWidth() - this.c)) ? getMeasuredWidth() - this.c : f2 : 0.0f) / (getMeasuredWidth() - this.c);
            a aVar = this.i;
            if (aVar != null) {
                aVar.a(((Integer) getTag()).intValue(), getProgress());
            }
            invalidate();
            return true;
        }
        return false;
    }

    public void setDelegate(a aVar) {
        this.i = aVar;
    }

    public void setMinMax(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    public void setProgress(int i) {
        setProgress(i, true);
    }

    public void setProgress(int i, boolean z) {
        a aVar;
        int i2 = this.g;
        if (i < i2) {
            i = i2;
        } else {
            int i3 = this.h;
            if (i > i3) {
                i = i3;
            }
        }
        this.e = (i - i2) / (this.h - i2);
        invalidate();
        if (!z || (aVar = this.i) == null) {
            return;
        }
        aVar.a(((Integer) getTag()).intValue(), getProgress());
    }
}
