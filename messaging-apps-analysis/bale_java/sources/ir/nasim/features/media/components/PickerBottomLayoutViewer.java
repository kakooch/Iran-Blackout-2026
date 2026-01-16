package ir.nasim.features.media.components;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C14433hu3;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.KB5;
import ir.nasim.TA5;
import ir.nasim.XY6;

/* loaded from: classes6.dex */
public class PickerBottomLayoutViewer extends FrameLayout {
    private boolean a;
    private boolean b;
    private Context c;
    public TextView cancelButton;
    public TextView doneButton;
    public TextView doneButtonBadgeTextView;
    public TextView newBadge;
    public ImageButton newDoneButton;

    public PickerBottomLayoutViewer(Context context, boolean z) {
        super(context);
        this.c = context;
        this.a = true;
        this.b = z;
        f();
    }

    private void a() {
        int iY0;
        TextView textView = new TextView(this.c);
        this.cancelButton = textView;
        textView.setTextSize(1, 15.0f);
        this.cancelButton.setTextColor(AbstractC4043Dl1.c(this.c, TA5.s7));
        this.cancelButton.setGravity(17);
        TextView textView2 = this.cancelButton;
        if (this.a) {
            iY0 = C5495Jo7.a.p2();
        } else {
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            iY0 = c5495Jo7.y0(c5495Jo7.j2(), 18);
        }
        textView2.setBackgroundDrawable(AbstractC4310Eo7.c(iY0, false));
        this.cancelButton.setPadding(AbstractC7426Rr.z(16.0f), 0, AbstractC7426Rr.z(16.0f), 0);
        this.cancelButton.setText(C5721Ko.b.getString(AbstractC12217eE5.GalleryCancel).toUpperCase());
        this.cancelButton.setTypeface(C6011Lu2.i());
        addView(this.cancelButton, C14433hu3.c(-2, -1, 51));
    }

    private void b() {
        View viewInflate = View.inflate(this.c, AbstractC12208eD5.send_button, null);
        viewInflate.setPadding(AbstractC7426Rr.z(0.0f), AbstractC7426Rr.z(10.0f), AbstractC7426Rr.z(12.0f), AbstractC7426Rr.z(2.0f));
        addView(viewInflate, C14433hu3.c(-2, -2, 21));
        this.newDoneButton = (ImageButton) viewInflate.findViewById(BC5.send_button);
        TextView textView = (TextView) viewInflate.findViewById(BC5.badge_txt);
        this.newBadge = textView;
        textView.setTypeface(C6011Lu2.i());
    }

    private void c() {
        TextView textView = new TextView(this.c);
        this.doneButtonBadgeTextView = textView;
        textView.setTypeface(C6011Lu2.k());
        this.doneButtonBadgeTextView.setTextSize(1, 13.0f);
        this.doneButtonBadgeTextView.setTextColor(C5495Jo7.a.f0());
        this.doneButtonBadgeTextView.setGravity(17);
        this.doneButtonBadgeTextView.setBackgroundResource(this.a ? KB5.photobadge : KB5.bluecounter);
        this.doneButtonBadgeTextView.setMinWidth(AbstractC7426Rr.z(23.0f));
        this.doneButtonBadgeTextView.setPadding(AbstractC7426Rr.z(8.0f), 0, AbstractC7426Rr.z(8.0f), AbstractC7426Rr.z(1.0f));
        addView(this.doneButtonBadgeTextView, C14433hu3.b(-2, 23.0f, 53, 0.0f, 0.0f, 7.0f, 0.0f));
    }

    private void d() {
        int iY0;
        TextView textView = new TextView(this.c);
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
        this.cancelButton.setPadding(AbstractC7426Rr.z(20.0f), 0, AbstractC7426Rr.z(20.0f), 0);
        this.cancelButton.setText(C5721Ko.b.getString(AbstractC12217eE5.Cancel).toUpperCase());
        this.cancelButton.setTypeface(C6011Lu2.k());
        addView(this.cancelButton, C14433hu3.c(-2, -1, 51));
    }

    private void e() {
        int iY0;
        TextView textView = new TextView(this.c);
        this.doneButton = textView;
        textView.setTextSize(1, 14.0f);
        this.doneButton.setTextColor(this.a ? C5495Jo7.a.f0() : C5495Jo7.a.t2());
        this.doneButton.setGravity(17);
        TextView textView2 = this.doneButton;
        if (this.a) {
            iY0 = C5495Jo7.a.p2();
        } else {
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            iY0 = c5495Jo7.y0(c5495Jo7.j2(), 18);
        }
        textView2.setBackgroundDrawable(AbstractC4310Eo7.c(iY0, false));
        this.doneButton.setPadding(AbstractC7426Rr.z(20.0f), 0, AbstractC7426Rr.z(20.0f), 0);
        this.doneButton.setText(C5721Ko.b.getString(AbstractC12217eE5.Send).toUpperCase());
        this.doneButton.setTypeface(C6011Lu2.k());
        addView(this.doneButton, C14433hu3.c(-2, -1, 53));
    }

    private void f() {
        setBackgroundColor(this.a ? C5495Jo7.a.m2() : C5495Jo7.a.f0());
        if (!this.b) {
            d();
            e();
            c();
        } else {
            a();
            e();
            this.doneButton.setVisibility(8);
            b();
        }
    }

    public void updateSelectedCount(int i, boolean z) {
        if (this.b) {
            this.newBadge.setText(XY6.e(String.valueOf(i)));
            this.newBadge.setVisibility(i >= 1 ? 0 : 8);
            return;
        }
        if (i == 0) {
            this.doneButtonBadgeTextView.setVisibility(8);
            if (!z) {
                this.doneButton.setTextColor(this.a ? C5495Jo7.a.f0() : C5495Jo7.a.t2());
                return;
            } else {
                this.doneButton.setTextColor(C5495Jo7.a.r2());
                this.doneButton.setEnabled(false);
                return;
            }
        }
        this.doneButtonBadgeTextView.setVisibility(0);
        this.doneButtonBadgeTextView.setText(String.format("%d", Integer.valueOf(i)));
        this.doneButton.setTextColor(this.a ? C5495Jo7.a.f0() : C5495Jo7.a.t2());
        if (z) {
            this.doneButton.setEnabled(true);
        }
    }
}
