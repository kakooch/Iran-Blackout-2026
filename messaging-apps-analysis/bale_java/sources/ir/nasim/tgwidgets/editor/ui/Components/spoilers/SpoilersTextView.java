package ir.nasim.tgwidgets.editor.ui.Components.spoilers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.text.Spanned;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import ir.nasim.TI6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.spoilers.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* loaded from: classes7.dex */
public class SpoilersTextView extends AppCompatTextView {
    private a h;
    protected List i;
    private Stack j;
    private boolean k;
    private Path l;
    private Paint m;
    public boolean n;

    public SpoilersTextView(Context context) {
        this(context, true);
    }

    private void u() {
        List list = this.i;
        if (list == null) {
            return;
        }
        this.j.addAll(list);
        this.i.clear();
        if (this.k) {
            invalidate();
            return;
        }
        if (getLayout() != null && (getText() instanceof Spanned)) {
            TI6.p(this, this.j, this.i);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        this.k = true;
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        post(new Runnable() { // from class: ir.nasim.aJ6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(boolean z, TI6 ti6, float f, float f2) {
        if (this.k || !z) {
            return;
        }
        ti6.D(new Runnable() { // from class: ir.nasim.ZI6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w();
            }
        });
        float fSqrt = (float) Math.sqrt(Math.pow(getWidth(), 2.0d) + Math.pow(getHeight(), 2.0d));
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            ((TI6) it.next()).I(f, f2, fSqrt);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.n && this.h.c(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        canvas.save();
        this.l.rewind();
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            Rect bounds = ((TI6) it.next()).getBounds();
            this.l.addRect(bounds.left + paddingLeft, bounds.top + paddingTop, bounds.right + paddingLeft, bounds.bottom + paddingTop, Path.Direction.CW);
        }
        canvas.clipPath(this.l, Region.Op.DIFFERENCE);
        super.onDraw(canvas);
        canvas.restore();
        canvas.save();
        canvas.clipPath(this.l);
        this.l.rewind();
        if (!this.i.isEmpty()) {
            ((TI6) this.i.get(0)).s(this.l);
        }
        canvas.clipPath(this.l);
        super.onDraw(canvas);
        canvas.restore();
        if (this.i.isEmpty()) {
            return;
        }
        boolean z = ((TI6) this.i.get(0)).t() != -1.0f;
        if (z) {
            canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
        } else {
            canvas.save();
        }
        canvas.translate(getPaddingLeft(), getPaddingTop() + AbstractC21455b.F(2.0f));
        for (TI6 ti6 : this.i) {
            ti6.A(getPaint().getColor());
            ti6.draw(canvas);
        }
        if (z) {
            this.l.rewind();
            ((TI6) this.i.get(0)).s(this.l);
            if (this.m == null) {
                Paint paint = new Paint(1);
                this.m = paint;
                paint.setColor(-16777216);
                this.m.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            canvas.drawPath(this.l, this.m);
        }
        canvas.restore();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        u();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        u();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        u();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.k = false;
        super.setText(charSequence, bufferType);
    }

    public SpoilersTextView(Context context, final boolean z) {
        super(context);
        this.i = new ArrayList();
        this.j = new Stack();
        this.l = new Path();
        this.n = true;
        this.h = new a(this, this.i, new a.b() { // from class: ir.nasim.YI6
            @Override // ir.nasim.tgwidgets.editor.ui.Components.spoilers.a.b
            public final void a(TI6 ti6, float f, float f2) {
                this.a.x(z, ti6, f, f2);
            }
        });
    }
}
