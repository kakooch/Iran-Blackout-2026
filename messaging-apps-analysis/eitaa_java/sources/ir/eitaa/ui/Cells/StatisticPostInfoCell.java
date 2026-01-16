package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.StatisticActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StatisticPostInfoCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private final TLRPC$ChatFull chat;
    private TextView date;
    private BackupImageView imageView;
    private TextView message;
    private TextView shares;
    private TextView views;

    public StatisticPostInfoCell(Context context, TLRPC$ChatFull chat) {
        super(context);
        this.avatarDrawable = new AvatarDrawable();
        this.chat = chat;
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        addView(backupImageView, LayoutHelper.createFrame(46, 46.0f, 8388627, 12.0f, 0.0f, 16.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        TextView textView = new TextView(context);
        this.message = textView;
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.message.setTextSize(1, 15.0f);
        this.message.setTypeface(AndroidUtilities.getFontFamily(false));
        this.message.setTextColor(-16777216);
        this.message.setLines(1);
        this.message.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView2 = new TextView(context);
        this.views = textView2;
        textView2.setTextSize(1, 15.0f);
        this.views.setTypeface(AndroidUtilities.getFontFamily(false));
        this.views.setTextColor(-16777216);
        linearLayout2.addView(this.message, LayoutHelper.createLinear(0, -2, 1.0f, 0, 0, 0, 16, 0));
        linearLayout2.addView(this.views, LayoutHelper.createLinear(-2, -2));
        linearLayout.addView(linearLayout2, LayoutHelper.createFrame(-1, -2.0f, 8388659, 0.0f, 8.0f, 0.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.date = textView3;
        textView3.setTextSize(1, 13.0f);
        this.date.setTypeface(AndroidUtilities.getFontFamily(false));
        this.date.setTextColor(-16777216);
        this.date.setLines(1);
        this.date.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView4 = new TextView(context);
        this.shares = textView4;
        textView4.setTextSize(1, 13.0f);
        this.shares.setTypeface(AndroidUtilities.getFontFamily(false));
        this.shares.setTextColor(-16777216);
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout3.addView(this.date, LayoutHelper.createLinear(0, -2, 1.0f, 0, 0, 0, 8, 0));
        linearLayout3.addView(this.shares, LayoutHelper.createLinear(-2, -2));
        linearLayout.addView(linearLayout3, LayoutHelper.createFrame(-1, -2.0f, 8388659, 0.0f, 2.0f, 0.0f, 8.0f));
        addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f, 0, 72.0f, 0.0f, 12.0f, 0.0f));
        this.message.setTextColor(Theme.getColor("dialogTextBlack"));
        this.views.setTextColor(Theme.getColor("dialogTextBlack"));
        this.date.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText3"));
        this.shares.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText3"));
    }

    public void setData(StatisticActivity.RecentPostInfo postInfo) {
        String string;
        MessageObject messageObject = postInfo.message;
        ArrayList<TLRPC$PhotoSize> arrayList = messageObject.photoThumbs;
        if (arrayList != null) {
            this.imageView.setImage(ImageLocation.getForObject(FileLoader.getClosestPhotoSizeWithSize(arrayList, AndroidUtilities.getPhotoSize()), messageObject.photoThumbsObject), "50_50", ImageLocation.getForObject(FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 50), messageObject.photoThumbsObject), "b1", 0, messageObject);
            this.imageView.setRoundRadius(AndroidUtilities.dp(4.0f));
        } else if (this.chat.chat_photo.sizes.size() > 0) {
            this.imageView.setImage(ImageLocation.getForPhoto(this.chat.chat_photo.sizes.get(0), this.chat.chat_photo), "50_50", (String) null, (Drawable) null, this.chat);
            this.imageView.setRoundRadius(AndroidUtilities.dp(46.0f) >> 1);
        }
        if (messageObject.isMusic()) {
            string = String.format("%s, %s", messageObject.getMusicTitle().trim(), messageObject.getMusicAuthor().trim());
        } else {
            CharSequence charSequence = messageObject.caption;
            if (charSequence == null) {
                charSequence = messageObject.messageText;
            }
            string = charSequence.toString();
        }
        this.message.setText(string.replace("\n", " ").trim());
        this.views.setText(String.format(LocaleController.getPluralString("Views", postInfo.counters.views), AndroidUtilities.formatCount(postInfo.counters.views)));
        this.date.setText(LocaleController.formatDateAudio(postInfo.message.messageOwner.date, false));
        this.shares.setText(String.format(LocaleController.getPluralString("Shares", postInfo.counters.forwards), AndroidUtilities.formatCount(postInfo.counters.forwards)));
    }

    public void setData(StatisticActivity.MemberData memberData) {
        this.avatarDrawable.setInfo(memberData.user);
        this.imageView.setForUserOrChat(memberData.user, this.avatarDrawable);
        this.imageView.setRoundRadius(AndroidUtilities.dp(46.0f) >> 1);
        this.message.setText(memberData.user.first_name);
        this.date.setText(memberData.description);
        this.views.setVisibility(8);
        this.shares.setVisibility(8);
    }
}
