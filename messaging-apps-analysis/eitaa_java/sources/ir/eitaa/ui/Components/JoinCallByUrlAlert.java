package ir.eitaa.ui.Components;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class JoinCallByUrlAlert extends BottomSheet {
    private boolean joinAfterDismiss;

    protected void onJoin() {
        throw null;
    }

    public static class BottomSheetCell extends FrameLayout {
        private View background;
        private TextView textView;

        public BottomSheetCell(Context context) {
            super(context);
            View view = new View(context);
            this.background = view;
            view.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
            addView(this.background, LayoutHelper.createFrame(-1, -1.0f, 0, 16.0f, 16.0f, 16.0f, 16.0f));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setLines(1);
            this.textView.setSingleLine(true);
            this.textView.setGravity(1);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setGravity(17);
            this.textView.setTextColor(Theme.getColor("featuredStickers_buttonText"));
            this.textView.setTextSize(1, 14.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
            addView(this.textView, LayoutHelper.createFrame(-2, -2, 17));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824));
        }

        public void setText(CharSequence text) {
            this.textView.setText(text);
        }
    }

    public JoinCallByUrlAlert(final Context context, TLRPC$Chat chat) {
        super(context, true);
        setApplyBottomPadding(false);
        setApplyTopPadding(false);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        setCustomView(linearLayout);
        BackupImageView backupImageView = new BackupImageView(context);
        backupImageView.setRoundRadius(AndroidUtilities.dp(45.0f));
        linearLayout.addView(backupImageView, LayoutHelper.createLinear(90, 90, 49, 0, 29, 0, 0));
        backupImageView.setForUserOrChat(chat, new AvatarDrawable(chat));
        TextView textView = new TextView(context);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        textView.setTextSize(1, 18.0f);
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        textView.setGravity(1);
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 49, 17, 24, 17, 0));
        TextView textView2 = new TextView(context);
        textView2.setTextSize(1, 14.0f);
        textView2.setTextColor(Theme.getColor("dialogTextGray3"));
        textView2.setGravity(1);
        linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 49, 30, 8, 30, 0));
        ChatObject.Call groupCall = AccountInstance.getInstance(this.currentAccount).getMessagesController().getGroupCall(chat.id, false);
        if (groupCall != null) {
            if (TextUtils.isEmpty(groupCall.call.title)) {
                textView.setText(chat.title);
            } else {
                textView.setText(groupCall.call.title);
            }
            int i = groupCall.call.participants_count;
            if (i == 0) {
                textView2.setText(LocaleController.getString("NoOneJoinedYet", R.string.NoOneJoinedYet));
            } else {
                textView2.setText(LocaleController.formatPluralString("Participants", i));
            }
        } else {
            textView.setText(chat.title);
            textView2.setText(LocaleController.getString("NoOneJoinedYet", R.string.NoOneJoinedYet));
        }
        BottomSheetCell bottomSheetCell = new BottomSheetCell(context);
        bottomSheetCell.setBackground(null);
        if (ChatObject.isChannelOrGiga(chat)) {
            bottomSheetCell.setText(LocaleController.getString("VoipChannelJoinVoiceChatUrl", R.string.VoipChannelJoinVoiceChatUrl));
        } else {
            bottomSheetCell.setText(LocaleController.getString("VoipGroupJoinVoiceChatUrl", R.string.VoipGroupJoinVoiceChatUrl));
        }
        bottomSheetCell.background.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinCallByUrlAlert$d7nqqonUDuBWulbe-nL6C0VchsE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$JoinCallByUrlAlert(view);
            }
        });
        linearLayout.addView(bottomSheetCell, LayoutHelper.createLinear(-1, 50, 51, 0, 30, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$JoinCallByUrlAlert(View view) {
        this.joinAfterDismiss = true;
        dismiss();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        super.dismissInternal();
        if (this.joinAfterDismiss) {
            onJoin();
        }
    }
}
