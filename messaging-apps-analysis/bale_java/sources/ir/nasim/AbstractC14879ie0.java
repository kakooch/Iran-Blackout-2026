package ir.nasim;

import android.graphics.RectF;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

/* renamed from: ir.nasim.ie0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14879ie0 extends LinkMovementMethod {
    private static AbstractC14879ie0 i;
    private d a;
    private e b;
    private final RectF c = new RectF();
    private boolean d;
    private ClickableSpan e;
    private int f;
    private c g;
    private boolean h;

    /* renamed from: ir.nasim.ie0$a */
    class a implements c.a {
        final /* synthetic */ TextView a;
        final /* synthetic */ ClickableSpan b;

        a(TextView textView, ClickableSpan clickableSpan) {
            this.a = textView;
            this.b = clickableSpan;
        }

        @Override // ir.nasim.AbstractC14879ie0.c.a
        public void a() {
            AbstractC14879ie0.this.h = true;
            this.a.performHapticFeedback(0);
            AbstractC14879ie0.this.h(this.a);
            AbstractC14879ie0.this.d(this.a, this.b);
        }
    }

    /* renamed from: ir.nasim.ie0$b */
    protected static class b {
        private ClickableSpan a;
        private String b;

        protected b(ClickableSpan clickableSpan, String str) {
            this.a = clickableSpan;
            this.b = str;
        }

        protected static b a(TextView textView, ClickableSpan clickableSpan) {
            Spanned spanned = (Spanned) textView.getText();
            return new b(clickableSpan, clickableSpan instanceof URLSpan ? ((URLSpan) clickableSpan).getURL() : spanned.subSequence(spanned.getSpanStart(clickableSpan), spanned.getSpanEnd(clickableSpan)).toString());
        }

        protected ClickableSpan b() {
            return this.a;
        }

        protected String c() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.ie0$c */
    protected static final class c implements Runnable {
        private a a;

        /* renamed from: ir.nasim.ie0$c$a */
        protected interface a {
            void a();
        }

        protected c() {
        }

        public void a(a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a();
        }
    }

    /* renamed from: ir.nasim.ie0$d */
    public interface d {
        boolean a(TextView textView, String str);
    }

    /* renamed from: ir.nasim.ie0$e */
    public interface e {
        boolean a(TextView textView, String str);
    }

    protected AbstractC14879ie0() {
    }

    private void b(TextView textView) {
        this.h = false;
        this.e = null;
        h(textView);
        g(textView);
    }

    protected void c(TextView textView, ClickableSpan clickableSpan) {
        b bVarA = b.a(textView, clickableSpan);
        d dVar = this.a;
        if (dVar == null || !dVar.a(textView, bVarA.c())) {
            bVarA.b().onClick(textView);
        }
    }

    protected void d(TextView textView, ClickableSpan clickableSpan) {
        b bVarA = b.a(textView, clickableSpan);
        e eVar = this.b;
        if (eVar == null || !eVar.a(textView, bVarA.c())) {
            bVarA.b().onClick(textView);
        }
    }

    protected ClickableSpan e(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int totalPaddingLeft = x - textView.getTotalPaddingLeft();
        int totalPaddingTop = y - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(scrollY);
        float f = scrollX;
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
        this.c.left = layout.getLineLeft(lineForVertical);
        this.c.top = layout.getLineTop(lineForVertical);
        RectF rectF = this.c;
        float lineWidth = layout.getLineWidth(lineForVertical);
        RectF rectF2 = this.c;
        rectF.right = lineWidth + rectF2.left;
        rectF2.bottom = layout.getLineBottom(lineForVertical);
        if (this.c.contains(f, scrollY)) {
            for (Object obj : spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class)) {
                if (obj instanceof ClickableSpan) {
                    return (ClickableSpan) obj;
                }
            }
        }
        return null;
    }

    protected abstract void f(TextView textView, ClickableSpan clickableSpan, Spannable spannable);

    protected void g(TextView textView) {
        c cVar = this.g;
        if (cVar != null) {
            textView.removeCallbacks(cVar);
            this.g = null;
        }
    }

    protected void h(TextView textView) {
        if (this.d) {
            this.d = false;
            Spannable spannable = (Spannable) textView.getText();
            spannable.removeSpan((BackgroundColorSpan) textView.getTag(AbstractC21157tC5.bettermovementmethod_highlight_background_span));
            Selection.removeSelection(spannable);
        }
    }

    public AbstractC14879ie0 i(d dVar) {
        if (this == i) {
            throw new UnsupportedOperationException("Setting a click listener on the instance returned by getInstance() is not supported to avoid memory leaks. Please use newInstance() or any of the linkify() methods instead.");
        }
        this.a = dVar;
        return this;
    }

    public AbstractC14879ie0 j(e eVar) {
        if (this == i) {
            throw new UnsupportedOperationException("Setting a long-click listener on the instance returned by getInstance() is not supported to avoid memory leaks. Please use newInstance() or any of the linkify() methods instead.");
        }
        this.b = eVar;
        return this;
    }

    protected void k(TextView textView, c.a aVar) {
        c cVar = new c();
        this.g = cVar;
        cVar.a(aVar);
        textView.postDelayed(this.g, ViewConfiguration.getLongPressTimeout());
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (this.f != textView.hashCode()) {
            this.f = textView.hashCode();
            textView.setAutoLinkMask(0);
        }
        ClickableSpan clickableSpanE = e(textView, spannable, motionEvent);
        if (motionEvent.getAction() == 0) {
            this.e = clickableSpanE;
        }
        boolean z = this.e != null;
        int action = motionEvent.getAction();
        if (action == 0) {
            if (clickableSpanE != null) {
                f(textView, clickableSpanE, spannable);
            }
            if (z && this.b != null) {
                k(textView, new a(textView, clickableSpanE));
            }
            return z;
        }
        if (action == 1) {
            if (!this.h && z && clickableSpanE == this.e) {
                c(textView, clickableSpanE);
            }
            b(textView);
            return z;
        }
        if (action != 2) {
            if (action != 3) {
                return false;
            }
            b(textView);
            return false;
        }
        if (clickableSpanE != this.e) {
            g(textView);
        }
        if (!this.h) {
            if (clickableSpanE != null) {
                f(textView, clickableSpanE, spannable);
            } else {
                h(textView);
            }
        }
        return z;
    }
}
