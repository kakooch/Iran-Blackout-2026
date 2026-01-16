package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddCommentCell extends FrameLayout {
    public CharSequence[] charSequences;
    private final int currentAccount;
    public ImageView imageView;
    public ImageView imageViewPlus;
    public Context mContext;
    public TextView textView;
    public TextView textView1;
    public TextView textView2;

    public AddCommentCell(Context context) {
        super(context);
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        this.charSequences = new CharSequence[]{"😂", "😍"};
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.rubino_add_comment_cell, (ViewGroup) null, false);
        addView(viewInflate, LayoutHelper.createFrame(-1, -2.0f));
        this.imageViewPlus = (ImageView) viewInflate.findViewById(R.id.imageViewPlus);
        this.imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.textView1 = (TextView) viewInflate.findViewById(R.id.textView1);
        this.textView2 = (TextView) viewInflate.findViewById(R.id.textView2);
        this.textView1.setText(this.charSequences[0]);
        this.textView2.setText(this.charSequences[1]);
        this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.imageViewPlus.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(R.color.grey_500), PorterDuff.Mode.SRC_ATOP));
        String str = AppRubinoPreferences.getInstance(i).getRubinoCurrentProfileObject().full_thumbnail_url;
        str = str == null ? AppRubinoPreferences.getInstance(i).getRubinoCurrentProfileObject().full_photo_url : str;
        if (str != null) {
            GlideHelper.loadCircle(this.mContext, this.imageView, str, R.drawable.rubino_grey_avatar_placeholder);
        } else {
            this.imageView.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.placeholder_avatar_man));
        }
    }

    public int getHeightPx() {
        return AndroidUtilities.dp(40.0f);
    }
}
