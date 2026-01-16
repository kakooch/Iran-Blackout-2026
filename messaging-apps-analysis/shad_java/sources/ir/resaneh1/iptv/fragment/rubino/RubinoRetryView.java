package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import android.widget.LinearLayout;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoRetryView extends LinearLayout {
    public ImageView imageView;
    public Context mContext;

    public RubinoRetryView(Context context) {
        super(context);
        this.mContext = context;
        setOrientation(1);
        setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        setPadding(0, AndroidUtilities.dp(16.0f), 0, 0);
        setGravity(17);
        ImageView imageView = new ImageView(this.mContext);
        this.imageView = imageView;
        imageView.setColorFilter(Theme.getColor(Theme.key_rubinoBlackColor), PorterDuff.Mode.SRC_ATOP);
        addView(this.imageView, LayoutHelper.createFrame(48, 48.0f, 1, 8.0f, 28.0f, 8.0f, 20.0f));
    }

    public void setData(int i) {
        if (i != 0) {
            this.imageView.setVisibility(0);
            this.imageView.setImageDrawable(this.mContext.getResources().getDrawable(i));
        } else {
            this.imageView.setVisibility(8);
        }
    }
}
