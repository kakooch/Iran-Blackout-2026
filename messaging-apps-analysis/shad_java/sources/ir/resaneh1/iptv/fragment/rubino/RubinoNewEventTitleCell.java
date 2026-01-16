package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoNewEventTitleCell extends FrameLayout {
    public TextView textView;

    public RubinoNewEventTitleCell(Context context) {
        super(context);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextSize(2, 15.0f);
        this.textView.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
        this.textView.setTypeface(Theme.getRubinoTypeFaceBold());
        this.textView.setGravity(5);
        addView(this.textView, LayoutHelper.createFrame(-1, -2.0f, 5, 8.0f, 8.0f, 16.0f, 8.0f));
    }

    public void setText(String str) {
        this.textView.setText(str);
    }
}
