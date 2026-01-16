package ir.eitaa.ui.Cells;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.URLSpanNoUnderline;

/* loaded from: classes3.dex */
public class SettingsSuggestionCell extends LinearLayout {
    private int currentAccount;
    private int currentType;
    private TextView detailTextView;
    private TextView noButton;
    private TextView textView;
    private TextView yesButton;

    protected void onNoClick(int type) {
    }

    protected void onYesClick(int type) {
    }

    public SettingsSuggestionCell(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        setOrientation(1);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextSize(1, 15.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        this.textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlueHeader"));
        addView(this.textView, LayoutHelper.createLinear(-1, -2, (LocaleController.isRTL ? 5 : 3) | 48, 21, 15, 21, 0));
        TextView textView2 = new TextView(context);
        this.detailTextView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
        this.detailTextView.setTextSize(1, 13.0f);
        this.detailTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.detailTextView.setLinkTextColor(Theme.getColor("windowBackgroundWhiteLinkText"));
        this.detailTextView.setHighlightColor(Theme.getColor("windowBackgroundWhiteLinkSelection"));
        this.detailTextView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        this.detailTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        addView(this.detailTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 21, 8, 21, 0));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        addView(linearLayout, LayoutHelper.createLinear(-1, 40, 21.0f, 17.0f, 21.0f, 20.0f));
        int i = 0;
        while (i < 2) {
            TextView textView3 = new TextView(context);
            textView3.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
            textView3.setLines(1);
            textView3.setSingleLine(true);
            textView3.setGravity(1);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            textView3.setGravity(17);
            textView3.setTextColor(Theme.getColor("featuredStickers_buttonText"));
            textView3.setTextSize(1, 14.0f);
            textView3.setTypeface(AndroidUtilities.getFontFamily(true));
            linearLayout.addView(textView3, LayoutHelper.createLinear(0, 40, 0.5f, i == 0 ? 0 : 4, 0, i == 0 ? 4 : 0, 0));
            if (i == 0) {
                this.yesButton = textView3;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$SettingsSuggestionCell$VF__2qScTmI5tBmCq189l6v1AWk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$new$0$SettingsSuggestionCell(view);
                    }
                });
            } else {
                this.noButton = textView3;
                textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$SettingsSuggestionCell$d-CxZq1xJ0eVDLN9fpbIlfnjXMY
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$new$1$SettingsSuggestionCell(view);
                    }
                });
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$SettingsSuggestionCell(View view) {
        onYesClick(this.currentType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$SettingsSuggestionCell(View view) {
        onNoClick(this.currentType);
    }

    public void setType(int type) {
        this.currentType = type;
        if (type != 0) {
            if (type == 1) {
                this.textView.setText(LocaleController.getString("YourPasswordHeader", R.string.YourPasswordHeader));
                this.detailTextView.setText(LocaleController.getString("YourPasswordRemember", R.string.YourPasswordRemember));
                this.yesButton.setText(LocaleController.getString("YourPasswordRememberYes", R.string.YourPasswordRememberYes));
                this.noButton.setText(LocaleController.getString("YourPasswordRememberNo", R.string.YourPasswordRememberNo));
                return;
            }
            return;
        }
        TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(UserConfig.getInstance(this.currentAccount).clientUserId));
        this.textView.setText(LocaleController.formatString("CheckPhoneNumber", R.string.CheckPhoneNumber, PhoneFormat.getInstance().format("+" + user.phone)));
        String string = LocaleController.getString("CheckPhoneNumberInfo", R.string.CheckPhoneNumberInfo);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int iIndexOf = string.indexOf("**");
        int iLastIndexOf = string.lastIndexOf("**");
        if (iIndexOf >= 0 && iLastIndexOf >= 0 && iIndexOf != iLastIndexOf) {
            spannableStringBuilder.replace(iLastIndexOf, iLastIndexOf + 2, (CharSequence) "");
            spannableStringBuilder.replace(iIndexOf, iIndexOf + 2, (CharSequence) "");
            try {
                spannableStringBuilder.setSpan(new URLSpanNoUnderline(LocaleController.getString("CheckPhoneNumberLearnMoreUrl", R.string.CheckPhoneNumberLearnMoreUrl)), iIndexOf, iLastIndexOf - 2, 33);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        this.detailTextView.setText(spannableStringBuilder);
        this.yesButton.setText(LocaleController.getString("CheckPhoneNumberYes", R.string.CheckPhoneNumberYes));
        this.noButton.setText(LocaleController.getString("CheckPhoneNumberNo", R.string.CheckPhoneNumberNo));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), heightMeasureSpec);
    }
}
