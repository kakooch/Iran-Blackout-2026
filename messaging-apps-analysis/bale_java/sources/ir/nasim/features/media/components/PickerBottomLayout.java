package ir.nasim.features.media.components;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.C14433hu3;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.JF5;
import ir.nasim.KB5;

/* loaded from: classes6.dex */
public class PickerBottomLayout extends FrameLayout {
    private boolean a;
    public TextView cancelButton;
    public LinearLayout doneButton;
    public TextView doneButtonBadgeTextView;
    public TextView doneButtonTextView;

    public PickerBottomLayout(Context context) {
        this(context, true);
    }

    public PickerBottomLayout(Context context, boolean z) {
        int iY0;
        int iY02;
        super(context);
        this.a = z;
        setBackgroundColor(z ? C5495Jo7.a.m2() : C5495Jo7.a.f0());
        TextView textView = new TextView(context);
        this.cancelButton = textView;
        textView.setTextSize(1, 14.0f);
        this.cancelButton.setTextColor(this.a ? C5495Jo7.a.f0() : C5495Jo7.a.t2());
        this.cancelButton.setGravity(17);
        TextView textView2 = this.cancelButton;
        if (this.a) {
            iY0 = C5495Jo7.a.p2();
        } else {
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            iY0 = c5495Jo7.y0(c5495Jo7.j2(), 18);
        }
        textView2.setBackgroundDrawable(AbstractC4310Eo7.c(iY0, false));
        this.cancelButton.setPadding(C22078ud6.a(29.0f), 0, C22078ud6.a(29.0f), 0);
        this.cancelButton.setText(context.getString(AbstractC12217eE5.Cancel).toUpperCase());
        this.cancelButton.setTypeface(C6011Lu2.k());
        addView(this.cancelButton, C14433hu3.c(-2, -1, 51));
        LinearLayout linearLayout = new LinearLayout(context);
        this.doneButton = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout linearLayout2 = this.doneButton;
        if (this.a) {
            iY02 = C5495Jo7.a.p2();
        } else {
            C5495Jo7 c5495Jo72 = C5495Jo7.a;
            iY02 = c5495Jo72.y0(c5495Jo72.j2(), 18);
        }
        linearLayout2.setBackgroundDrawable(AbstractC4310Eo7.c(iY02, false));
        this.doneButton.setPadding(C22078ud6.a(29.0f), 0, C22078ud6.a(29.0f), 0);
        addView(this.doneButton, C14433hu3.c(-2, -1, 53));
        TextView textView3 = new TextView(context);
        this.doneButtonBadgeTextView = textView3;
        textView3.setTypeface(C6011Lu2.k());
        this.doneButtonBadgeTextView.setTextSize(1, 13.0f);
        TextView textView4 = this.doneButtonBadgeTextView;
        C5495Jo7 c5495Jo73 = C5495Jo7.a;
        textView4.setTextColor(c5495Jo73.f0());
        this.doneButtonBadgeTextView.setGravity(17);
        this.doneButtonBadgeTextView.setBackgroundResource(this.a ? KB5.photobadge : KB5.bluecounter);
        this.doneButtonBadgeTextView.setMinWidth(C22078ud6.a(23.0f));
        this.doneButtonBadgeTextView.setPadding(C22078ud6.a(8.0f), 0, C22078ud6.a(8.0f), C22078ud6.a(1.0f));
        if (JF5.g()) {
            this.doneButton.addView(this.doneButtonBadgeTextView, C14433hu3.i(-2, 23, 16, 10, 0, 0, 0));
        } else {
            this.doneButton.addView(this.doneButtonBadgeTextView, C14433hu3.i(-2, 23, 16, 0, 0, 10, 0));
        }
        TextView textView5 = new TextView(context);
        this.doneButtonTextView = textView5;
        textView5.setTextSize(1, 14.0f);
        this.doneButtonTextView.setTextColor(this.a ? c5495Jo73.f0() : c5495Jo73.t2());
        this.doneButtonTextView.setGravity(17);
        this.doneButtonTextView.setCompoundDrawablePadding(C22078ud6.a(8.0f));
        this.doneButtonTextView.setText(context.getString(AbstractC12217eE5.Send).toUpperCase());
        this.doneButtonTextView.setTypeface(C6011Lu2.k());
        this.doneButton.addView(this.doneButtonTextView, C14433hu3.h(-2, -2, 16));
    }
}
