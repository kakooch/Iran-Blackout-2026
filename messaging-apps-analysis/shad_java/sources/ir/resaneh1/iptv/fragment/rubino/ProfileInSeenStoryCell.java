package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.InsStoryAvatarView;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.EmojiSliderResultObject;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ProfileInSeenStoryCell extends FrameLayout {
    public View container;
    int currentAccount;
    public RubinoProfileObject currentProfile;
    public ImageView imageViewOption;
    public ImageView imageViewSendMessage;
    public Context mContext;
    View.OnClickListener onOptionClick;
    View.OnClickListener onSendMessageClicked;
    View.OnClickListener onUserClickListener;
    private EmojiSliderSeekBarView seekBarView;
    public FrameLayout seekbarContainer;
    public TextView textView1;
    public TextView textView2;
    public InsStoryAvatarView userImageView;

    public ProfileInSeenStoryCell(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.onSendMessageClicked = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileInSeenStoryCell.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MainClickHandler().onMessengerUsernameClicked(ProfileInSeenStoryCell.this.currentProfile.username);
            }
        };
        this.onUserClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileInSeenStoryCell.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity == null) {
                    return;
                }
                new MainClickHandler().onRubinoProfileClick(ProfileInSeenStoryCell.this.currentProfile);
            }
        };
        this.onOptionClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileInSeenStoryCell.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    ArrayList arrayList = new ArrayList();
                    final ArrayList arrayList2 = new ArrayList();
                    arrayList.add(LocaleController.getString(R.string.rubinoProfile));
                    arrayList2.add(2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileInSeenStoryCell.this.mContext);
                    builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileInSeenStoryCell.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (((Integer) arrayList2.get(i)).intValue() == 1) {
                                RubinoController.getInstance(ProfileInSeenStoryCell.this.currentAccount).onBlockClick(ProfileInSeenStoryCell.this.currentProfile, null);
                            } else if (((Integer) arrayList2.get(i)).intValue() == 2) {
                                new MainClickHandler().onRubinoProfileClick(ProfileInSeenStoryCell.this.currentProfile);
                            }
                        }
                    });
                    AlertDialog alertDialogCreate = builder.create();
                    alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: ir.resaneh1.iptv.fragment.rubino.ProfileInSeenStoryCell.3.2
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                        }
                    });
                    ApplicationLoader.applicationActivity.getLastFragment().showDialog(alertDialogCreate);
                }
            }
        };
        this.mContext = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.rubino_profile_row_in_seen_story, (ViewGroup) null, false);
        addView(viewGroup);
        this.imageViewOption = (ImageView) viewGroup.findViewById(R.id.imageViewOption);
        this.imageViewSendMessage = (ImageView) viewGroup.findViewById(R.id.imageViewSendMessage);
        this.container = viewGroup.findViewById(R.id.container);
        this.seekbarContainer = (FrameLayout) viewGroup.findViewById(R.id.seekbarContainer);
        this.textView1 = (TextView) viewGroup.findViewById(R.id.textViewUserName);
        this.textView2 = (TextView) viewGroup.findViewById(R.id.textViewName);
        TextView textView = this.textView1;
        int i = Theme.key_rubinoBlackColor;
        textView.setTextColor(Theme.getColor(i));
        this.textView2.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
        this.userImageView = (InsStoryAvatarView) viewGroup.findViewById(R.id.imageView);
        this.imageViewSendMessage.setColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP);
        this.imageViewOption.setColorFilter(Theme.getColor(i), PorterDuff.Mode.SRC_ATOP);
        this.textView1.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView2.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.container.setOnClickListener(this.onUserClickListener);
        this.userImageView.setOnClickListener(this.onUserClickListener);
        this.imageViewSendMessage.setOnClickListener(this.onSendMessageClicked);
        this.imageViewOption.setOnClickListener(this.onOptionClick);
        EmojiSliderSeekBarView emojiSliderSeekBarView = new EmojiSliderSeekBarView(this.mContext, ImageReceiver.DEFAULT_CROSSFADE_DURATION, true);
        this.seekBarView = emojiSliderSeekBarView;
        this.seekbarContainer.addView(emojiSliderSeekBarView);
    }

    public void setEmojiResult(EmojiSliderResultObject emojiSliderResultObject) {
        if (emojiSliderResultObject != null) {
            this.currentProfile = emojiSliderResultObject.getProfileTryFromMap();
            this.seekbarContainer.setVisibility(0);
            this.textView2.setVisibility(8);
            if (this.currentProfile != null) {
                this.seekBarView.setProgress((int) (emojiSliderResultObject.float_answer * 100.0f));
                SpannableString spannableString = this.currentProfile.usernameSpannableString;
                if (spannableString == null) {
                    spannableString = new SpannableString(BuildConfig.FLAVOR);
                }
                RubinoProfileObject rubinoProfileObject = this.currentProfile;
                setData(spannableString, rubinoProfileObject.full_thumbnail_url, rubinoProfileObject.isMyCurrentProfile());
                return;
            }
            clear();
            return;
        }
        this.currentProfile = null;
        clear();
    }

    public void setProfile(RubinoProfileObject rubinoProfileObject, int i) {
        this.currentProfile = rubinoProfileObject;
        this.seekbarContainer.setVisibility(8);
        this.textView2.setVisibility(0);
        if (rubinoProfileObject != null) {
            this.textView2.setText(rubinoProfileObject.name);
            SpannableString spannableString = rubinoProfileObject.usernameSpannableString;
            if (spannableString == null) {
                spannableString = new SpannableString(BuildConfig.FLAVOR);
            }
            setData(spannableString, rubinoProfileObject.full_thumbnail_url, rubinoProfileObject.isMyCurrentProfile());
            return;
        }
        clear();
    }

    private void clear() {
        this.imageViewOption.setVisibility(4);
        this.imageViewSendMessage.setVisibility(4);
        this.userImageView.setVisibility(4);
        this.textView1.setText(BuildConfig.FLAVOR);
        this.textView2.setText(BuildConfig.FLAVOR);
    }

    private void setData(SpannableString spannableString, String str, boolean z) {
        if (z) {
            this.imageViewOption.setVisibility(4);
            this.imageViewSendMessage.setVisibility(4);
        } else {
            this.imageViewOption.setVisibility(0);
            this.imageViewSendMessage.setVisibility(0);
        }
        this.textView1.setText(spannableString);
        this.userImageView.setVisibility(0);
        GlideHelper.loadCircle(this.mContext, this.userImageView, str, R.drawable.placeholder_avatar_man);
    }
}
