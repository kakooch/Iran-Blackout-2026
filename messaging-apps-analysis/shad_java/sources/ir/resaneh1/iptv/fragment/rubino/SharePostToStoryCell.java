package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class SharePostToStoryCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    int currentAccount;
    private TextView textView;
    public BackupImageView userImageView;

    public SharePostToStoryCell(Context context) {
        super(context);
        this.avatarDrawable = new AvatarDrawable();
        this.currentAccount = UserConfig.selectedAccount;
        BackupImageView backupImageView = new BackupImageView(context);
        this.userImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(27.0f));
        addView(this.userImageView, LayoutHelper.createFrame(49, 49.0f, 21, 0.0f, 5.0f, 8.0f, 5.0f));
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView.setTextColor(context.getResources().getColor(R.color.rubino_blue));
        this.textView.setTextSize(1, 14.0f);
        this.textView.setMaxLines(2);
        this.textView.setGravity(21);
        this.textView.setLines(2);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.textView, LayoutHelper.createFrame(-1, -2.0f, 21, 6.0f, 0.0f, 70.0f, 0.0f));
        setData();
    }

    private void setData() {
        this.textView.setText(LocaleController.getString(R.string.rubinoSharePostToStory));
        TLRPC$User currentUser = UserConfig.getInstance(this.currentAccount).getCurrentUser();
        this.avatarDrawable.setInfo(currentUser);
        this.userImageView.setForUserOrChat(currentUser, this.avatarDrawable);
    }
}
