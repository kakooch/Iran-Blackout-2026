package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.nasim.C15990kW7;
import java.util.Locale;

/* renamed from: ir.nasim.px1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19204px1 extends LinkMovementMethod {
    private final ViewGroup a;
    private final UA2 b;

    public C19204px1(ViewGroup viewGroup, UA2 ua2) {
        AbstractC13042fc3.i(viewGroup, "mainContainer");
        this.a = viewGroup;
        this.b = ua2;
    }

    private final Activity a(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (context instanceof C15990kW7.a) {
            context = ((C15990kW7.a) context).getBaseContext();
        }
        AbstractC13042fc3.g(context, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) context;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean b(android.widget.TextView r7, android.text.Spannable r8, android.view.MotionEvent r9) {
        /*
            r6 = this;
            int r0 = r9.getAction()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto Le9
            float r0 = r9.getX()
            int r0 = (int) r0
            float r9 = r9.getY()
            int r9 = (int) r9
            int r3 = r7.getTotalPaddingLeft()
            int r0 = r0 - r3
            int r3 = r7.getTotalPaddingTop()
            int r9 = r9 - r3
            int r3 = r7.getScrollX()
            int r0 = r0 + r3
            int r3 = r7.getScrollY()
            int r9 = r9 + r3
            android.text.Layout r7 = r7.getLayout()
            int r9 = r7.getLineForVertical(r9)
            float r0 = (float) r0
            int r7 = r7.getOffsetForHorizontal(r9, r0)
            java.lang.Class<ir.nasim.yL3> r9 = ir.nasim.C24276yL3.class
            java.lang.Object[] r7 = r8.getSpans(r7, r7, r9)
            ir.nasim.yL3[] r7 = (ir.nasim.C24276yL3[]) r7
            ir.nasim.AbstractC13042fc3.f(r7)
            int r8 = r7.length
            if (r8 != 0) goto L43
            r8 = r2
            goto L44
        L43:
            r8 = r1
        L44:
            r8 = r8 ^ r2
            if (r8 == 0) goto Le9
            r7 = r7[r1]
            ir.nasim.xL3 r7 = r7.b()
            java.lang.String r7 = r7.a()
            android.content.Intent r8 = new android.content.Intent
            java.lang.String r9 = "android.intent.action.VIEW"
            r8.<init>(r9)
            android.net.Uri r9 = android.net.Uri.parse(r7)
            r8.setData(r9)
            ir.nasim.pb3 r9 = ir.nasim.C18987pb3.a
            android.view.ViewGroup r0 = r6.a
            android.app.Activity r0 = r6.a(r0)
            boolean r8 = r9.k0(r8, r0)
            if (r8 == 0) goto L6e
            return r2
        L6e:
            ir.nasim.Vt0 r8 = ir.nasim.C8386Vt0.a
            boolean r8 = r8.B5()
            if (r8 == 0) goto Le9
            java.lang.String r8 = "tel:"
            java.lang.String r9 = "sms:"
            java.lang.String r0 = "send:"
            java.lang.String r3 = "ussd:"
            java.lang.String[] r8 = new java.lang.String[]{r0, r3, r8, r9}
            java.util.List r8 = ir.nasim.ZW0.p(r8)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            boolean r9 = r8 instanceof java.util.Collection
            r0 = 0
            r3 = 2
            if (r9 == 0) goto L99
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L99
        L97:
            r8 = r2
            goto Lb4
        L99:
            java.util.Iterator r8 = r8.iterator()
        L9d:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L97
            java.lang.Object r9 = r8.next()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r4 = r7.toString()
            boolean r9 = ir.nasim.AbstractC14836iZ6.S(r4, r9, r1, r3, r0)
            if (r9 == 0) goto L9d
            r8 = r1
        Lb4:
            java.lang.String r9 = "element"
            ir.nasim.AbstractC13042fc3.h(r7, r9)
            java.lang.String r4 = "https://"
            boolean r5 = ir.nasim.AbstractC14836iZ6.S(r7, r4, r1, r3, r0)
            if (r5 != 0) goto Ldb
            ir.nasim.AbstractC13042fc3.h(r7, r9)
            java.lang.String r9 = "http://"
            boolean r9 = ir.nasim.AbstractC14836iZ6.S(r7, r9, r1, r3, r0)
            if (r9 != 0) goto Ldb
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
        Ldb:
            if (r8 == 0) goto Le9
            ir.nasim.UA2 r8 = r6.b
            if (r8 == 0) goto Le8
            java.lang.String r7 = r7.toString()
            r8.invoke(r7)
        Le8:
            return r2
        Le9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19204px1.b(android.widget.TextView, android.text.Spannable, android.view.MotionEvent):boolean");
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        AbstractC13042fc3.i(textView, "textView");
        AbstractC13042fc3.i(spannable, "spannable");
        AbstractC13042fc3.i(motionEvent, "event");
        if (b(textView, spannable, motionEvent)) {
            return true;
        }
        super.onTouchEvent(textView, spannable, motionEvent);
        try {
            this.a.onTouchEvent(motionEvent);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Locale locale = Locale.getDefault();
                AbstractC13042fc3.h(locale, "getDefault(...)");
                String lowerCase = message.toLowerCase(locale);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                if (AbstractC20762sZ6.X(lowerCase, "webview", false, 2, null)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(spannable.toString()));
                    intent.putExtra("create_new_tab", true);
                    C5721Ko c5721Ko = C5721Ko.a;
                    intent.putExtra("com.android.browser.application_id", c5721Ko.d().getPackageName());
                    c5721Ko.d().startActivity(intent);
                }
            }
        }
        return true;
    }
}
