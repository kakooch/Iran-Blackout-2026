package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Looper;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;
import ir.nasim.TI6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan;
import ir.nasim.tgwidgets.editor.ui.Components.spoilers.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* loaded from: classes7.dex */
public class EditTextEffects extends EditText {
    private List a;
    private Stack b;
    private boolean c;
    private boolean d;
    private ir.nasim.tgwidgets.editor.ui.Components.spoilers.a e;
    public boolean f;
    private Path g;
    private int h;
    private int i;
    private float j;
    private float k;
    private boolean l;
    private AnimatedEmojiSpan.b m;
    private ColorFilter n;
    public boolean o;
    private Layout p;
    private int q;
    private Runnable r;
    private Rect s;
    private boolean t;

    public EditTextEffects(Context context) {
        super(context);
        this.a = new ArrayList();
        this.b = new Stack();
        this.d = true;
        this.g = new Path();
        this.o = true;
        this.p = null;
        this.r = new Runnable() { // from class: ir.nasim.t42
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l();
            }
        };
        this.s = new Rect();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            this.e = new ir.nasim.tgwidgets.editor.ui.Components.spoilers.a(this, this.a, new a.b() { // from class: ir.nasim.u42
                @Override // ir.nasim.tgwidgets.editor.ui.Components.spoilers.a.b
                public final void a(TI6 ti6, float f, float f2) {
                    this.a.o(ti6, f, f2);
                }
            });
        }
    }

    private void g() {
        int i;
        int i2;
        CharSequence text = getLayout() != null ? getLayout().getText() : null;
        boolean z = false;
        if (text instanceof Spannable) {
            Spannable spannable = (Spannable) text;
            for (G g : (G[]) spannable.getSpans(0, spannable.length(), G.class)) {
                int spanStart = spannable.getSpanStart(g);
                int spanEnd = spannable.getSpanEnd(g);
                if (g.a() && ((spanStart > (i = this.h) && spanEnd < this.i) || ((i > spanStart && i < spanEnd) || ((i2 = this.i) > spanStart && i2 < spanEnd)))) {
                    removeCallbacks(this.r);
                    this.l = false;
                    z = true;
                    break;
                }
            }
        }
        if (!this.c || z || this.l) {
            return;
        }
        this.l = true;
        postDelayed(this.r, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        setSpoilersRevealed(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        post(new Runnable() { // from class: ir.nasim.y42
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.l = false;
        this.c = false;
        i();
        if (this.a.isEmpty()) {
            return;
        }
        ((TI6) this.a.get(0)).D(new Runnable() { // from class: ir.nasim.w42
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k();
            }
        });
        float fSqrt = (float) Math.sqrt(Math.pow(getWidth(), 2.0d) + Math.pow(getHeight(), 2.0d));
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((TI6) it.next()).J(this.j, this.k, fSqrt, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        i();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        post(new Runnable() { // from class: ir.nasim.x42
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(TI6 ti6, float f, float f2) {
        if (this.c) {
            return;
        }
        this.j = f;
        this.k = f2;
        this.l = false;
        removeCallbacks(this.r);
        setSpoilersRevealed(true, false);
        ti6.D(new Runnable() { // from class: ir.nasim.v42
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n();
            }
        });
        float fSqrt = (float) Math.sqrt(Math.pow(getWidth(), 2.0d) + Math.pow(getHeight(), 2.0d));
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((TI6) it.next()).I(f, f2, fSqrt);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        ir.nasim.tgwidgets.editor.ui.Components.spoilers.a aVar;
        if (this.d && (aVar = this.e) != null && aVar.c(motionEvent)) {
            if (motionEvent.getActionMasked() == 1) {
                MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
                super.dispatchTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
            z = true;
        } else {
            z = false;
        }
        return super.dispatchTouchEvent(motionEvent) || z;
    }

    public void h() {
        Editable text = getText();
        if (text != null) {
            for (G g : (G[]) text.getSpans(0, text.length(), G.class)) {
                if (g.a()) {
                    g.b(this.c);
                }
            }
        }
        i();
    }

    protected void i() {
        AnimatedEmojiSpan.b bVar;
        AnimatedEmojiSpan.b bVar2;
        List list = this.a;
        if (list == null) {
            return;
        }
        this.b.addAll(list);
        this.a.clear();
        if (this.c) {
            invalidate();
            return;
        }
        Layout layout = getLayout();
        if (layout != null && (layout.getText() instanceof Spannable)) {
            if (this.o && (bVar2 = this.m) != null) {
                bVar2.c(false);
            }
            TI6.p(this, this.b, this.a);
            if (this.o && (bVar = this.m) != null) {
                bVar.c(true);
            }
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        q(false);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.r);
        AnimatedEmojiSpan.i(this, this.m);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        if (this.t && getScrollY() != 0) {
            canvas.clipRect(0, getScrollY(), getMeasuredWidth(), getMeasuredHeight() + getScrollY());
        }
        this.g.rewind();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Rect bounds = ((TI6) it.next()).getBounds();
            this.g.addRect(bounds.left, bounds.top, bounds.right, bounds.bottom, Path.Direction.CW);
        }
        canvas.clipPath(this.g, Region.Op.DIFFERENCE);
        q(false);
        super.onDraw(canvas);
        if (this.o && this.m != null) {
            canvas.save();
            canvas.translate(getPaddingLeft(), 0.0f);
            AnimatedEmojiSpan.f(canvas, getLayout(), this.m, 0.0f, this.a, computeVerticalScrollOffset() - AbstractC21455b.F(6.0f), computeVerticalScrollOffset() + computeVerticalScrollExtent(), 0.0f, 1.0f, this.n);
            canvas.restore();
        }
        canvas.restore();
        canvas.save();
        canvas.clipPath(this.g);
        this.g.rewind();
        if (!this.a.isEmpty()) {
            ((TI6) this.a.get(0)).s(this.g);
        }
        canvas.clipPath(this.g);
        canvas.translate(0.0f, -getPaddingTop());
        super.onDraw(canvas);
        canvas.restore();
        this.s.set(0, getScrollY(), getWidth(), (getScrollY() + getHeight()) - getPaddingBottom());
        canvas.save();
        canvas.clipRect(this.s);
        for (TI6 ti6 : this.a) {
            Rect bounds2 = ti6.getBounds();
            Rect rect = this.s;
            int i = rect.top;
            int i2 = bounds2.bottom;
            if ((i <= i2 && rect.bottom >= bounds2.top) || (bounds2.top <= rect.bottom && i2 >= i)) {
                ti6.A(getPaint().getColor());
                ti6.draw(canvas);
            }
        }
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        q(false);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.f) {
            return;
        }
        this.h = i;
        this.i = i2;
        g();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        r7 = r7 - r6;
        r3.h += r7;
        r3.i += r7;
        o(r1, r5, r4);
     */
    @Override // android.widget.TextView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onTextChanged(java.lang.CharSequence r4, int r5, int r6, int r7) {
        /*
            r3 = this;
            super.onTextChanged(r4, r5, r6, r7)
            boolean r0 = r3.f
            if (r0 != 0) goto L5c
            r3.h()
            android.text.Layout r0 = r3.getLayout()     // Catch: java.lang.Exception -> L58
            boolean r4 = r4 instanceof android.text.Spannable     // Catch: java.lang.Exception -> L58
            if (r4 == 0) goto L5c
            if (r0 == 0) goto L5c
            int r4 = r0.getLineForOffset(r5)     // Catch: java.lang.Exception -> L58
            float r5 = r0.getPrimaryHorizontal(r5)     // Catch: java.lang.Exception -> L58
            int r5 = (int) r5     // Catch: java.lang.Exception -> L58
            int r1 = r0.getLineTop(r4)     // Catch: java.lang.Exception -> L58
            int r4 = r0.getLineBottom(r4)     // Catch: java.lang.Exception -> L58
            int r1 = r1 + r4
            float r4 = (float) r1     // Catch: java.lang.Exception -> L58
            r0 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r0
            int r4 = (int) r4     // Catch: java.lang.Exception -> L58
            java.util.List r0 = r3.a     // Catch: java.lang.Exception -> L58
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L58
        L31:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> L58
            if (r1 == 0) goto L5c
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> L58
            ir.nasim.TI6 r1 = (ir.nasim.TI6) r1     // Catch: java.lang.Exception -> L58
            android.graphics.Rect r2 = r1.getBounds()     // Catch: java.lang.Exception -> L58
            boolean r2 = r2.contains(r5, r4)     // Catch: java.lang.Exception -> L58
            if (r2 == 0) goto L31
            int r7 = r7 - r6
            int r6 = r3.h     // Catch: java.lang.Exception -> L58
            int r6 = r6 + r7
            r3.h = r6     // Catch: java.lang.Exception -> L58
            int r6 = r3.i     // Catch: java.lang.Exception -> L58
            int r6 = r6 + r7
            r3.i = r6     // Catch: java.lang.Exception -> L58
            float r5 = (float) r5     // Catch: java.lang.Exception -> L58
            float r4 = (float) r4     // Catch: java.lang.Exception -> L58
            r3.o(r1, r5, r4)     // Catch: java.lang.Exception -> L58
            goto L5c
        L58:
            r4 = move-exception
            ir.nasim.AbstractC6403Nl2.d(r4)
        L5c:
            r4 = 1
            r3.q(r4)
            r3.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.EditTextEffects.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    public void p() {
        AnimatedEmojiSpan.i(this, this.m);
    }

    public void q(boolean z) {
        if (this.o) {
            int length = (getLayout() == null || getLayout().getText() == null) ? 0 : getLayout().getText().length();
            if (!z && this.p == getLayout() && this.q == length) {
                return;
            }
            this.m = AnimatedEmojiSpan.l(C21463b.i(), this, this.m, getLayout());
            this.p = getLayout();
            this.q = length;
        }
    }

    public void setClipToPadding(boolean z) {
        this.t = z;
    }

    public void setShouldRevealSpoilersByTouch(boolean z) {
        this.d = z;
    }

    public void setSpoilersRevealed(boolean z, boolean z2) {
        this.c = z;
        Editable text = getText();
        if (text != null) {
            for (G g : (G[]) text.getSpans(0, text.length(), G.class)) {
                if (g.a()) {
                    g.b(z);
                }
            }
        }
        this.f = true;
        setText(text, TextView.BufferType.EDITABLE);
        setSelection(this.h, this.i);
        this.f = false;
        if (z2) {
            i();
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!this.f) {
            this.c = false;
            Stack stack = this.b;
            if (stack != null) {
                stack.clear();
            }
        }
        super.setText(charSequence, bufferType);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        this.n = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN);
    }
}
