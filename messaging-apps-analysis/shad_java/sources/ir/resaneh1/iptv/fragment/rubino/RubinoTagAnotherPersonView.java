package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoTagAnotherPersonView extends FrameLayout {
    public ImageView imageView;
    public Context mContext;
    public TextView textView;

    public RubinoTagAnotherPersonView(Context context) {
        super(context);
        setBackgroundColor(0);
        this.mContext = context;
        ImageView imageView = new ImageView(this.mContext);
        this.imageView = imageView;
        imageView.setColorFilter(this.mContext.getResources().getColor(R.color.rubino_blue), PorterDuff.Mode.SRC_ATOP);
        addView(this.imageView, LayoutHelper.createFrame(24, 24.0f, 21, 8.0f, 12.0f, 34.0f, 12.0f));
        TextView textView = new TextView(this.mContext);
        this.textView = textView;
        textView.setTextColor(this.mContext.getResources().getColor(R.color.rubino_blue));
        this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView.setGravity(21);
        this.textView.setTextSize(2, 15.0f);
        addView(this.textView, LayoutHelper.createFrame(-1, -2.0f, 21, 8.0f, 0.0f, 92.0f, 0.0f));
        this.imageView.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.rubino_add_outline_16));
        this.textView.setText(LocaleController.getString(R.string.rubinoTagAnotherPerson));
    }
}
