package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class DialogInSharePostCell extends FrameLayout {
    int accountNumber;
    private AvatarDrawable avatarDrawable;
    public Context mContext;
    private TextView nameTextView;
    private TextView sendTextView;
    private TLRPC$User user;
    public BackupImageView userImageView;

    public DialogInSharePostCell(Context context) {
        super(context);
        this.avatarDrawable = new AvatarDrawable();
        this.accountNumber = UserConfig.selectedAccount;
        this.mContext = context;
        BackupImageView backupImageView = new BackupImageView(context);
        this.userImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(27.0f));
        addView(this.userImageView, LayoutHelper.createFrame(44, 44.0f, 21, 0.0f, 8.0f, 11.0f, 8.0f));
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.nameTextView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        this.nameTextView.setTextSize(1, 13.0f);
        this.nameTextView.setMaxLines(2);
        this.nameTextView.setGravity(21);
        this.nameTextView.setLines(2);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.nameTextView, LayoutHelper.createFrame(-2, -2.0f, 21, 86.0f, 0.0f, 70.0f, 0.0f));
        TextView textView2 = new TextView(context);
        this.sendTextView = textView2;
        textView2.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.sendTextView.setTextSize(1, 13.0f);
        addView(this.sendTextView, LayoutHelper.createFrame(-2, -2.0f, 19, 18.0f, 0.0f, 6.0f, 0.0f));
        this.sendTextView.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(4.0f));
        this.sendTextView.setMinWidth(AndroidUtilities.dp(68.0f));
        this.sendTextView.setMinHeight(AndroidUtilities.dp(28.0f));
        this.sendTextView.setGravity(17);
        setButton(false);
    }

    private void setButton(boolean z) {
        if (z) {
            this.sendTextView.setText(LocaleController.getString(R.string.rubinoSentPost));
            this.sendTextView.setBackground(this.mContext.getResources().getDrawable(R.drawable.rubino_shape_transparent_rectangle_border_grey));
            this.sendTextView.setTextColor(Theme.getColor(Theme.key_rubinoBlackColor));
        } else {
            this.sendTextView.setTextColor(-1);
            this.sendTextView.setText(LocaleController.getString(R.string.rubinoSendPost));
            this.sendTextView.setBackground(this.mContext.getResources().getDrawable(R.drawable.rubino_follow_background_shape_blue));
        }
    }

    public void setDialog(int i, boolean z, CharSequence charSequence) {
        if (i > 0) {
            TLRPC$User user = MessagesController.getInstance(this.accountNumber).getUser(Integer.valueOf(i));
            this.user = user;
            this.avatarDrawable.setInfo(user);
            if (charSequence != null) {
                this.nameTextView.setText(charSequence);
            } else {
                TLRPC$User tLRPC$User = this.user;
                if (tLRPC$User != null) {
                    if (tLRPC$User.self) {
                        this.avatarDrawable.setAvatarType(1);
                        this.nameTextView.setText(LocaleController.getString("SavedMessages", R.string.SavedMessages));
                    } else {
                        this.nameTextView.setText(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name));
                    }
                } else {
                    this.nameTextView.setText(BuildConfig.FLAVOR);
                }
            }
            TLRPC$User tLRPC$User2 = this.user;
            if (tLRPC$User2 != null && tLRPC$User2.self) {
                this.userImageView.setImage((ImageLocation) null, "50_50", this.avatarDrawable, tLRPC$User2);
            } else {
                this.userImageView.setForUserOrChat(tLRPC$User2, this.avatarDrawable);
            }
        } else {
            this.user = null;
            TLRPC$Chat chat = MessagesController.getInstance(this.accountNumber).getChat(Integer.valueOf(-i));
            if (charSequence != null) {
                this.nameTextView.setText(charSequence);
            } else if (chat != null) {
                this.nameTextView.setText(chat.title);
            } else {
                this.nameTextView.setText(BuildConfig.FLAVOR);
            }
            this.avatarDrawable.setInfo(chat);
            this.userImageView.setForUserOrChat(chat, this.avatarDrawable);
        }
        setSelected(z, false);
    }

    public void setSelected(boolean z, boolean z2) {
        setButton(z);
    }
}
