package defpackage;

import android.os.Handler;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC9643aJ3;
import ir.nasim.ED1;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public final class x extends LinkMovementMethod {
    public static final a d = new a(null);
    public static final int e = 8;
    private static x f;
    private final UA2 a;
    private Handler b;
    private boolean c;

    public static final class a {
        private a() {
        }

        public final MovementMethod a(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "onTouch");
            if (x.f == null) {
                x.f = new x(ua2);
                x xVar = x.f;
                if (xVar != null) {
                    xVar.b = new Handler();
                }
            }
            x xVar2 = x.f;
            AbstractC13042fc3.f(xVar2);
            return xVar2;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public x(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onTouch");
        this.a = ua2;
        this.b = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AbstractC9643aJ3[] abstractC9643aJ3Arr, TextView textView, x xVar) {
        AbstractC13042fc3.i(textView, "$widget");
        AbstractC13042fc3.i(xVar, "this$0");
        abstractC9643aJ3Arr[0].a(textView);
        xVar.c = true;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(final TextView textView, Spannable spannable, MotionEvent motionEvent) {
        Handler handler;
        AbstractC13042fc3.i(textView, "widget");
        AbstractC13042fc3.i(spannable, "buffer");
        AbstractC13042fc3.i(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 3 && (handler = this.b) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (action == 0 || action == 1) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int totalPaddingLeft = x - textView.getTotalPaddingLeft();
            int totalPaddingTop = y - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            final AbstractC9643aJ3[] abstractC9643aJ3Arr = (AbstractC9643aJ3[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, AbstractC9643aJ3.class);
            AbstractC13042fc3.f(abstractC9643aJ3Arr);
            if (!(abstractC9643aJ3Arr.length == 0)) {
                if (action == 1) {
                    Handler handler2 = this.b;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                    }
                    if (!this.c) {
                        abstractC9643aJ3Arr[0].onClick(textView);
                    }
                    this.c = false;
                } else {
                    Selection.setSelection(spannable, spannable.getSpanStart(abstractC9643aJ3Arr[0]), spannable.getSpanEnd(abstractC9643aJ3Arr[0]));
                    Handler handler3 = this.b;
                    if (handler3 != null) {
                        handler3.postDelayed(new Runnable() { // from class: w
                            @Override // java.lang.Runnable
                            public final void run() {
                                x.e(abstractC9643aJ3Arr, textView, this);
                            }
                        }, 500L);
                    }
                }
                this.a.invoke(motionEvent);
                return true;
            }
        }
        this.a.invoke(motionEvent);
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
