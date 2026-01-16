package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class PickerBottomLayoutViewer extends FrameLayout {
    public TextView a;
    public TextView b;
    public TextView c;
    private boolean d;

    public PickerBottomLayoutViewer(Context context) {
        this(context, true);
    }

    public void a(int i, boolean z) {
        if (i == 0) {
            this.c.setVisibility(8);
            if (!z) {
                this.b.setTextColor(this.d ? -1 : -15095832);
                return;
            } else {
                this.b.setTextColor(-6710887);
                this.b.setEnabled(false);
                return;
            }
        }
        this.c.setVisibility(0);
        this.c.setText(String.format("%d", Integer.valueOf(i)));
        this.b.setTextColor(this.d ? -1 : -15095832);
        if (z) {
            this.b.setEnabled(true);
        }
    }

    public PickerBottomLayoutViewer(Context context, boolean z) {
        super(context);
        this.d = z;
        setBackgroundColor(z ? -15066598 : -1);
        TextView textView = new TextView(context);
        this.a = textView;
        textView.setTextSize(1, 14.0f);
        this.a.setTextColor(this.d ? -1 : -15095832);
        this.a.setGravity(17);
        this.a.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(this.d ? -12763843 : 788529152, 0));
        this.a.setPadding(AbstractC21455b.F(20.0f), 0, AbstractC21455b.F(20.0f), 0);
        this.a.setText(FH3.E("Cancel", TD5.tgwidget_Cancel).toUpperCase());
        this.a.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        addView(this.a, AbstractC13840gu3.d(-2, -1, 51));
        TextView textView2 = new TextView(context);
        this.b = textView2;
        textView2.setTextSize(1, 14.0f);
        this.b.setTextColor(this.d ? -1 : -15095832);
        this.b.setGravity(17);
        this.b.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(this.d ? -12763843 : 788529152, 0));
        this.b.setPadding(AbstractC21455b.F(20.0f), 0, AbstractC21455b.F(20.0f), 0);
        this.b.setText(FH3.E("Send", TD5.tgwidget_Send).toUpperCase());
        this.b.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        addView(this.b, AbstractC13840gu3.d(-2, -1, 53));
        TextView textView3 = new TextView(context);
        this.c = textView3;
        textView3.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.c.setTextSize(1, 13.0f);
        this.c.setTextColor(-1);
        this.c.setGravity(17);
        this.c.setBackgroundResource(this.d ? AbstractC23598xB5.photobadge : AbstractC23598xB5.bluecounter);
        this.c.setMinWidth(AbstractC21455b.F(23.0f));
        this.c.setPadding(AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f), AbstractC21455b.F(1.0f));
        addView(this.c, AbstractC13840gu3.c(-2, 23.0f, 53, 0.0f, 0.0f, 7.0f, 0.0f));
    }
}
