package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RubinoLoadingCell;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.model.RubinoCommentObject;
import ir.resaneh1.iptv.model.RubinoPostObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddCommentView extends FrameLayout {
    public CharSequence[] charSequences;
    private final int currentAccount;
    public EditText editText;
    int emojiCount;
    public ImageView imageViewClose;
    public ImageView imageViewMyImage;
    public boolean isInReplyMode;
    private boolean isReplyNeeded;
    public LinearLayout linearLayoutReaction;
    public Context mContext;
    public OnReplyModeChangeListener onReplyModeChangeListener;
    public OnSendClickListener onSendClickListener;
    public FrameLayout replyView;
    private RubinoPostObject selectedPost;
    public FrameLayout sendProgressBarContainer;
    public TextView textViewReply;
    public TextView textViewSend;
    public TextView[] textViews;
    public RubinoCommentObject toReplyCommentObject;

    public interface OnReplyModeChangeListener {
        void onReplyModeChange(boolean z);
    }

    public interface OnSendClickListener {
        void onAddCommentClick(RubinoPostObject rubinoPostObject, String str);

        void onAddReplyClick(RubinoPostObject rubinoPostObject, String str, RubinoCommentObject rubinoCommentObject);
    }

    public void setOnSendClickListener(OnSendClickListener onSendClickListener) {
        this.onSendClickListener = onSendClickListener;
    }

    public void setOnReplyModeChangeListener(OnReplyModeChangeListener onReplyModeChangeListener) {
        this.onReplyModeChangeListener = onReplyModeChangeListener;
    }

    public AddCommentView(Context context, boolean z) {
        super(context);
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        this.emojiCount = 8;
        this.textViews = new TextView[8];
        this.charSequences = new CharSequence[]{"👏", "😍", "❤️", "😂", "😮", "😢", "🔥", "🙌"};
        this.mContext = context;
        this.isReplyNeeded = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.add_comment_view, (ViewGroup) null, false);
        addView(linearLayout, LayoutHelper.createFrame(-1, -2.0f));
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.imageviewCloseReply);
        this.imageViewClose = imageView;
        int i2 = Theme.key_rubinoBlackColor;
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.SRC_ATOP));
        this.imageViewClose.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.AddCommentView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddCommentView.this.resetFromReplyMode();
            }
        });
        this.imageViewMyImage = (ImageView) linearLayout.findViewById(R.id.imageViewMyImage);
        GlideHelper.loadCircle(this.mContext, this.imageViewMyImage, AppRubinoPreferences.getInstance(i).getRubinoCurrentProfileObject().full_photo_url, R.drawable.placeholder_avatar_man);
        this.sendProgressBarContainer = (FrameLayout) linearLayout.findViewById(R.id.sendProgressBarContainer);
        RubinoLoadingCell.ProgressView progressView = new RubinoLoadingCell.ProgressView(this.mContext);
        progressView.setSize(AndroidUtilities.dp(24.0f));
        this.sendProgressBarContainer.addView(progressView, LayoutHelper.createFrame(24, 24.0f));
        this.sendProgressBarContainer.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.linearLayoutReaction);
        this.linearLayoutReaction = linearLayout2;
        int i3 = Theme.key_dialogBackground;
        linearLayout2.setBackgroundColor(Theme.getColor(i3));
        linearLayout.findViewById(R.id.container1).setBackgroundColor(Theme.getColor(i3));
        View viewFindViewById = linearLayout.findViewById(R.id.devider);
        int i4 = Theme.key_divider;
        viewFindViewById.setBackgroundColor(Theme.getColor(i4));
        linearLayout.findViewById(R.id.devider2).setBackgroundColor(Theme.getColor(i4));
        linearLayout.findViewById(R.id.devider3).setBackgroundColor(Theme.getColor(i4));
        FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(R.id.replyView);
        this.replyView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_dialogBackgroundGray));
        this.textViewReply = (TextView) linearLayout.findViewById(R.id.textViewReply);
        this.editText = (EditText) linearLayout.findViewById(R.id.editText);
        this.textViewReply.setTypeface(Theme.getRubinoTypeFaceRegular());
        TextView textView = this.textViewReply;
        int i5 = Theme.key_rubinoGrayColor;
        textView.setTextColor(Theme.getColor(i5));
        this.editText.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.editText.setTextColor(Theme.getColor(i2));
        this.editText.setHintTextColor(Theme.getColor(i5));
        EditText editText = this.editText;
        editText.setFilters(InputFilterHelper.getFilterMaxChar(1200, editText));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(AndroidUtilities.dp(0.0f), AndroidUtilities.dp(48.0f), 1.0f);
        for (int i6 = 0; i6 < this.emojiCount; i6++) {
            this.textViews[i6] = new TextView(context);
            this.textViews[i6].setTextColor(this.mContext.getResources().getColor(R.color.grey_900));
            this.textViews[i6].setTextSize(2, 22.0f);
            this.textViews[i6].setGravity(17);
            this.textViews[i6].setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.AddCommentView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String string = ((TextView) view).getText().toString();
                    if (AddCommentView.this.editText.getText().toString().isEmpty()) {
                        AddCommentView.this.editText.setText(string);
                    } else {
                        AddCommentView.this.editText.append(string);
                    }
                    EditText editText2 = AddCommentView.this.editText;
                    editText2.setSelection(editText2.getText().toString().length());
                }
            });
            this.linearLayoutReaction.addView(this.textViews[i6], layoutParams);
        }
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.textViewSend);
        this.textViewSend = textView2;
        textView2.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textViewSend.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.AddCommentView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String strTrim = AddCommentView.this.editText.getText().toString().trim();
                if (strTrim.isEmpty()) {
                    return;
                }
                AddCommentView addCommentView = AddCommentView.this;
                OnSendClickListener onSendClickListener = addCommentView.onSendClickListener;
                if (onSendClickListener != null) {
                    if (addCommentView.isInReplyMode) {
                        onSendClickListener.onAddReplyClick(addCommentView.selectedPost, strTrim, AddCommentView.this.toReplyCommentObject);
                    } else {
                        onSendClickListener.onAddCommentClick(addCommentView.selectedPost, strTrim);
                    }
                }
                AddCommentView.this.editText.setText(BuildConfig.FLAVOR);
                AddCommentView.this.resetFromReplyMode();
            }
        });
        this.editText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.rubino.AddCommentView.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.toString().trim().isEmpty()) {
                    AddCommentView.this.textViewSend.setAlpha(0.5f);
                } else {
                    AddCommentView.this.textViewSend.setAlpha(1.0f);
                }
            }
        });
        this.textViewSend.setAlpha(0.5f);
        this.editText.setText(BuildConfig.FLAVOR);
        this.isInReplyMode = true;
        resetFromReplyMode();
        setEmoji();
    }

    public void setPost(RubinoPostObject rubinoPostObject) {
        this.selectedPost = rubinoPostObject;
    }

    public void setEmoji() {
        for (int i = 0; i < this.emojiCount; i++) {
            this.textViews[i].setText(this.charSequences[i].toString());
        }
    }

    public void resetFromReplyMode() {
        if (this.isInReplyMode) {
            this.isInReplyMode = false;
            this.toReplyCommentObject = null;
            if (this.isReplyNeeded) {
                this.replyView.setVisibility(4);
            } else {
                this.replyView.setVisibility(8);
            }
            String str = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().username;
            this.editText.setHint(LocaleController.getString(R.string.rubinoAddCommentHint) + " " + str + "...");
            this.editText.setText(BuildConfig.FLAVOR);
            OnReplyModeChangeListener onReplyModeChangeListener = this.onReplyModeChangeListener;
            if (onReplyModeChangeListener != null) {
                onReplyModeChangeListener.onReplyModeChange(this.isInReplyMode);
            }
        }
    }

    public void setReplyMode(RubinoCommentObject rubinoCommentObject, RubinoCommentObject rubinoCommentObject2) {
        if (this.isInReplyMode) {
            return;
        }
        this.isInReplyMode = true;
        if (rubinoCommentObject2.isReply && rubinoCommentObject != null) {
            this.toReplyCommentObject = rubinoCommentObject;
        } else {
            this.toReplyCommentObject = rubinoCommentObject2;
        }
        this.replyView.setVisibility(0);
        this.textViewReply.setText(LocaleController.getString(R.string.rubinoReplyingTo) + " " + rubinoCommentObject2.comment.profile_username);
        this.editText.setText("@" + rubinoCommentObject2.comment.profile_username + " ");
        EditText editText = this.editText;
        editText.setSelection(editText.getText().length());
        String str = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().username;
        this.editText.setHint(LocaleController.getString(R.string.rubinoAddReplyHint) + " " + str + "...");
        OnReplyModeChangeListener onReplyModeChangeListener = this.onReplyModeChangeListener;
        if (onReplyModeChangeListener != null) {
            onReplyModeChangeListener.onReplyModeChange(this.isInReplyMode);
        }
    }
}
