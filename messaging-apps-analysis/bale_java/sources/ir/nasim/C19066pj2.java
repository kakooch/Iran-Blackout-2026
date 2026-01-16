package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import ir.nasim.AbstractC14879ie0;

/* renamed from: ir.nasim.pj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19066pj2 extends AbstractC14879ie0 {
    private final UA2 j;
    private final UA2 k;
    private AbstractC14879ie0.d l;

    public C19066pj2(UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(ua2, "onTouch");
        this.j = ua2;
        this.k = ua22;
    }

    @Override // ir.nasim.AbstractC14879ie0
    protected void c(TextView textView, ClickableSpan clickableSpan) {
        AbstractC13042fc3.i(textView, "textView");
        AbstractC13042fc3.i(clickableSpan, "clickableSpan");
        if (clickableSpan instanceof C24276yL3) {
            Context context = textView.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            C24276yL3 c24276yL3 = (C24276yL3) clickableSpan;
            String strA = c24276yL3.b().a();
            AbstractC13042fc3.h(strA, "getUrl(...)");
            if (C18987pb3.e1(context, strA, null)) {
                return;
            }
            AbstractC14879ie0.d dVar = this.l;
            if (dVar != null) {
                dVar.a(textView, c24276yL3.b().a());
                return;
            }
        }
        super.c(textView, clickableSpan);
    }

    @Override // ir.nasim.AbstractC14879ie0
    public AbstractC14879ie0 i(AbstractC14879ie0.d dVar) {
        AbstractC13042fc3.i(dVar, "clickListener");
        this.l = dVar;
        AbstractC14879ie0 abstractC14879ie0I = super.i(dVar);
        AbstractC13042fc3.h(abstractC14879ie0I, "setOnLinkClickListener(...)");
        return abstractC14879ie0I;
    }

    @Override // ir.nasim.AbstractC14879ie0, android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        AbstractC13042fc3.i(textView, "textView");
        AbstractC13042fc3.i(spannable, ParameterNames.TEXT);
        AbstractC13042fc3.i(motionEvent, "event");
        if (super.onTouchEvent(textView, spannable, motionEvent)) {
            return true;
        }
        return ((Boolean) this.j.invoke(motionEvent)).booleanValue();
    }

    @Override // ir.nasim.AbstractC14879ie0
    protected void f(TextView textView, ClickableSpan clickableSpan, Spannable spannable) {
    }
}
