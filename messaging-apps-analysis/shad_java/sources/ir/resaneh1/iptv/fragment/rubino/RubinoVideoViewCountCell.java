package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoVideoViewCountCell extends LinearLayout {
    public ImageView imageView;
    public Context mContext;
    public TextView textView;

    public RubinoVideoViewCountCell(Context context) {
        super(context);
        this.mContext = context;
        setOrientation(1);
        setPadding(0, AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f));
        setGravity(17);
        ImageView imageView = new ImageView(this.mContext);
        this.imageView = imageView;
        addView(imageView, LayoutHelper.createFrame(60, 60.0f, 1, 8.0f, 8.0f, 8.0f, 2.0f));
        TextView textView = new TextView(this.mContext);
        this.textView = textView;
        textView.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
        this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView.setGravity(1);
        this.textView.setTextSize(2, 22.0f);
        this.textView.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f));
        addView(this.textView);
        this.imageView.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.rubino_play_filled_32));
    }

    public void setData(SpannableString spannableString) {
        this.textView.setText(spannableString);
    }
}
