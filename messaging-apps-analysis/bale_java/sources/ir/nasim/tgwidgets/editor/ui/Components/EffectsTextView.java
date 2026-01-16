package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import ir.nasim.C17561nA3;
import ir.nasim.R62;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.LinkSpanDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.spoilers.SpoilersTextView;

/* loaded from: classes7.dex */
public class EffectsTextView extends SpoilersTextView {
    private boolean o;
    private LinkSpanDrawable.a p;
    private m.h q;
    private LinkSpanDrawable r;
    private boolean s;
    private boolean t;
    private boolean u;

    public EffectsTextView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(LinkSpanDrawable linkSpanDrawable, ClickableSpan clickableSpan) {
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.spoilers.SpoilersTextView, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.o) {
            canvas.save();
            if (!this.s) {
                canvas.translate(this.t ? 0.0f : getPaddingLeft(), this.u ? 0.0f : getPaddingTop());
            }
            if (this.p.g(canvas)) {
                invalidate();
            }
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.p != null) {
            Layout layout = getLayout();
            final ClickableSpan clickableSpanZ = z((int) motionEvent.getX(), (int) motionEvent.getY());
            if (clickableSpanZ != null && motionEvent.getAction() == 0) {
                final LinkSpanDrawable linkSpanDrawable = new LinkSpanDrawable(clickableSpanZ, this.q, motionEvent.getX(), motionEvent.getY());
                this.r = linkSpanDrawable;
                this.p.c(linkSpanDrawable);
                SpannableString spannableString = new SpannableString(layout.getText());
                int spanStart = spannableString.getSpanStart(this.r.c());
                int spanEnd = spannableString.getSpanEnd(this.r.c());
                C17561nA3 c17561nA3D = this.r.d();
                c17561nA3D.c(layout, spanStart, getPaddingTop());
                layout.getSelectionPath(spanStart, spanEnd, c17561nA3D);
                AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.d52
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.A(linkSpanDrawable, clickableSpanZ);
                    }
                }, ViewConfiguration.getLongPressTimeout());
                return true;
            }
            if (motionEvent.getAction() == 1) {
                this.p.e();
                LinkSpanDrawable linkSpanDrawable2 = this.r;
                if (linkSpanDrawable2 != null && linkSpanDrawable2.c() == clickableSpanZ) {
                    if (this.r.c() != null) {
                        ((ClickableSpan) this.r.c()).onClick(this);
                    }
                    this.r = null;
                    return true;
                }
                this.r = null;
            }
            if (motionEvent.getAction() == 3) {
                this.p.e();
                this.r = null;
            }
        }
        return this.r != null || super.onTouchEvent(motionEvent);
    }

    public void setDisablePaddingsOffset(boolean z) {
        this.s = z;
    }

    public void setDisablePaddingsOffsetX(boolean z) {
        this.t = z;
    }

    public void setDisablePaddingsOffsetY(boolean z) {
        this.u = z;
    }

    public void setOnLinkLongPressListener(LinkSpanDrawable.LinksTextView.a aVar) {
    }

    public void setOnLinkPressListener(LinkSpanDrawable.LinksTextView.a aVar) {
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.spoilers.SpoilersTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(R62.S(charSequence, getPaint().getFontMetricsInt(), AbstractC21455b.F(14.0f), false), bufferType);
    }

    public ClickableSpan z(int i, int i2) {
        Layout layout = getLayout();
        if (layout == null) {
            return null;
        }
        int paddingLeft = i - getPaddingLeft();
        int paddingTop = i2 - getPaddingTop();
        int lineForVertical = layout.getLineForVertical(paddingTop);
        float f = paddingLeft;
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
        float lineLeft = getLayout().getLineLeft(lineForVertical);
        if (lineLeft <= f && lineLeft + layout.getLineWidth(lineForVertical) >= f && paddingTop >= 0 && paddingTop <= layout.getHeight()) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) new SpannableString(layout.getText()).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0 && !AbstractC21455b.v0()) {
                return clickableSpanArr[0];
            }
        }
        return null;
    }

    public EffectsTextView(Context context, m.h hVar) {
        super(context, true);
        this.o = false;
        this.p = new LinkSpanDrawable.a(this);
        this.q = hVar;
    }
}
