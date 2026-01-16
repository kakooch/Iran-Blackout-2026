package ir.resaneh1.iptv.fragment.rubino.highlight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.AndroidUtilities;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileLinkObject;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ProfileLinkCell extends FrameLayout {
    public Rubino.StoryHighlight currentHighlight;
    public RubinoProfileLinkObject currentLink;
    public ImageView imageView;
    public Context mContext;
    public TextView textView1;

    public ProfileLinkCell(Context context) {
        super(context);
        int i = UserConfig.selectedAccount;
        this.mContext = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.rubino_profile_link_cell, (ViewGroup) null, false);
        addView(viewGroup);
        this.textView1 = (TextView) viewGroup.findViewById(R.id.textView1);
        this.imageView = (ImageView) viewGroup.findViewById(R.id.imageView);
        viewGroup.findViewById(R.id.linearLayout);
        this.textView1.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView1.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
        viewGroup.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
    }

    public void setData(RubinoProfileLinkObject rubinoProfileLinkObject) {
        this.currentLink = rubinoProfileLinkObject;
        this.currentHighlight = null;
        this.imageView.setPadding(AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f));
        this.imageView.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.circle_grey));
        String str = this.currentLink.image_url;
        if (str != null && !str.isEmpty()) {
            GlideHelper.loadCircle(this.mContext, this.imageView, this.currentLink.image_url, R.drawable.rubino_grey_avatar_placeholder);
        } else {
            this.imageView.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.placeholder_avatar_man));
        }
        String str2 = this.currentLink.title;
        if (str2 != null && !str2.isEmpty()) {
            this.textView1.setText(this.currentLink.title);
        } else {
            this.textView1.setText(BuildConfig.FLAVOR);
        }
    }

    public void setData(Rubino.StoryHighlight storyHighlight) {
        this.currentHighlight = storyHighlight;
        this.currentLink = null;
        this.imageView.setPadding(AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f));
        this.imageView.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.circle_grey));
        String str = this.currentHighlight.avatar_url;
        if (str != null && !str.isEmpty()) {
            GlideHelper.loadCircle(this.mContext, this.imageView, this.currentHighlight.avatar_url, R.drawable.rubino_grey_avatar_placeholder);
        } else {
            this.imageView.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.placeholder_avatar_man));
        }
        String str2 = this.currentHighlight.name;
        if (str2 != null && !str2.isEmpty()) {
            this.textView1.setText(this.currentHighlight.name);
        } else {
            this.textView1.setText(BuildConfig.FLAVOR);
        }
    }

    public void setAsNewCell() {
        this.currentHighlight = null;
        this.currentLink = null;
        this.imageView.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.rubino_add_highlight_placeholder));
        this.imageView.setImageResource(R.drawable.ic_plus_black);
        this.imageView.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f));
        this.textView1.setText(LocaleController.getString(R.string.rubinoHighLightNew));
    }
}
