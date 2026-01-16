package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.widget.FrameLayout;
import android.widget.TextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoLikeTitleCell extends FrameLayout {
    public boolean needDivider;
    public TextView textView1;
    public TextView textView2;

    public RubinoLikeTitleCell(Context context, boolean z) {
        super(context);
        this.needDivider = z;
        setWillNotDraw(false);
        TextView textView = new TextView(context);
        this.textView1 = textView;
        textView.setTextSize(2, 15.0f);
        TextView textView2 = this.textView1;
        int i = Theme.key_rubinoGrayColor;
        textView2.setTextColor(Theme.getColor(i));
        this.textView1.setTypeface(Theme.getRubinoTypeFaceBold());
        addView(this.textView1, LayoutHelper.createFrame(-2, -2.0f, 3, 16.0f, 8.0f, 8.0f, 8.0f));
        TextView textView3 = new TextView(context);
        this.textView2 = textView3;
        textView3.setTextSize(2, 14.0f);
        this.textView2.setTextColor(Theme.getColor(i));
        this.textView2.setTypeface(Theme.getRubinoTypeFaceRegular());
        addView(this.textView2, LayoutHelper.createFrame(-2, -2.0f, 5, 8.0f, 8.0f, 16.0f, 8.0f));
    }

    public void setText(String str, SpannableString spannableString) {
        if (str != null) {
            this.textView1.setVisibility(0);
            this.textView1.setText(str);
        } else {
            this.textView1.setVisibility(8);
        }
        if (spannableString != null) {
            this.textView2.setVisibility(0);
            this.textView2.setText(spannableString);
        } else {
            this.textView2.setVisibility(8);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(getPaddingLeft(), getHeight() - 1, getWidth() - getPaddingRight(), getHeight() - 1, Theme.getDividerPaint());
        }
    }
}
