package org.rbmain.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidMessenger.proxy.DialogsProxy;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$TL_account_checkUsername;
import org.rbmain.tgnet.TLRPC$TL_account_updateUsername;
import org.rbmain.tgnet.TLRPC$TL_boolTrue;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class ChangeUsernameActivity extends BaseFragment {
    private int checkReqId;
    private Runnable checkRunnable;
    private TextView checkTextView;
    private View doneButton;
    private EditTextBoldCursor firstNameField;
    private TextView helpTextView;
    private boolean ignoreCheck;
    private CharSequence infoText;
    private String lastCheckName;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public class LinkSpan extends ClickableSpan {
        private String url;

        public LinkSpan(String str) {
            this.url = str;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            try {
                ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", this.url));
                if (BulletinFactory.canShowBulletin(ChangeUsernameActivity.this)) {
                    BulletinFactory.createCopyLinkBulletin(ChangeUsernameActivity.this).show();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    private static class LinkMovementMethodMy extends LinkMovementMethod {
        private LinkMovementMethodMy() {
        }

        /* synthetic */ LinkMovementMethodMy(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            try {
                boolean zOnTouchEvent = super.onTouchEvent(textView, spannable, motionEvent);
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    Selection.removeSelection(spannable);
                }
                return zOnTouchEvent;
            } catch (Exception e) {
                FileLog.e(e);
                return false;
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        String str;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("Username", R.string.Username));
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass1());
        this.doneButton = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(UserConfig.getInstance(this.currentAccount).getClientUserId()));
        if (user == null) {
            user = UserConfig.getInstance(this.currentAccount).getCurrentUser();
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.fragmentView = linearLayout;
        LinearLayout linearLayout2 = linearLayout;
        linearLayout2.setOrientation(1);
        this.fragmentView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.ChangeUsernameActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ChangeUsernameActivity.lambda$createView$0(view, motionEvent);
            }
        });
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.firstNameField = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        this.firstNameField.setHintTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteHintText));
        EditTextBoldCursor editTextBoldCursor2 = this.firstNameField;
        int i = Theme.key_windowBackgroundWhiteBlackText;
        editTextBoldCursor2.setTextColor(Theme.getColor(i));
        this.firstNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.firstNameField.setMaxLines(1);
        this.firstNameField.setLines(1);
        this.firstNameField.setPadding(0, 0, 0, 0);
        this.firstNameField.setSingleLine(true);
        this.firstNameField.setGravity(LocaleController.isRTL ? 5 : 3);
        this.firstNameField.setInputType(180224);
        this.firstNameField.setImeOptions(6);
        this.firstNameField.setHint(LocaleController.getString("UsernamePlaceholder", R.string.UsernamePlaceholder));
        this.firstNameField.setCursorColor(Theme.getColor(i));
        this.firstNameField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.firstNameField.setCursorWidth(1.5f);
        this.firstNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.ChangeUsernameActivity$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$1(textView, i2, keyEvent);
            }
        });
        this.firstNameField.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.ChangeUsernameActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (ChangeUsernameActivity.this.ignoreCheck) {
                    return;
                }
                ChangeUsernameActivity changeUsernameActivity = ChangeUsernameActivity.this;
                changeUsernameActivity.checkUserName(changeUsernameActivity.firstNameField.getText().toString(), false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string = ChangeUsernameActivity.this.firstNameField.getText().toString();
                if (string.startsWith("@")) {
                    string = string.substring(1);
                }
                if (string.length() <= 0) {
                    ChangeUsernameActivity.this.helpTextView.setText(ChangeUsernameActivity.this.infoText);
                    return;
                }
                String str2 = "https://" + MessagesController.getInstance(((BaseFragment) ChangeUsernameActivity.this).currentAccount).linkPrefix + "/" + string;
                String string2 = LocaleController.formatString("UsernameHelpLink", R.string.UsernameHelpLink, str2);
                int iIndexOf = string2.indexOf(str2);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
                if (iIndexOf >= 0) {
                    spannableStringBuilder.setSpan(ChangeUsernameActivity.this.new LinkSpan(str2), iIndexOf, str2.length() + iIndexOf, 33);
                }
                ChangeUsernameActivity.this.helpTextView.setText(TextUtils.concat(ChangeUsernameActivity.this.infoText, "\n\n", spannableStringBuilder));
            }
        });
        linearLayout2.addView(this.firstNameField, LayoutHelper.createLinear(-1, 36, 24.0f, 24.0f, 24.0f, 0.0f));
        TextView textView = new TextView(context);
        this.checkTextView = textView;
        textView.setTextSize(1, 15.0f);
        this.checkTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        linearLayout2.addView(this.checkTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 24, 12, 24, 0));
        TextView textView2 = new TextView(context);
        this.helpTextView = textView2;
        textView2.setTextSize(1, 15.0f);
        this.helpTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText8));
        this.helpTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        TextView textView3 = this.helpTextView;
        SpannableStringBuilder spannableStringBuilderReplaceTags = AndroidUtilities.replaceTags(LocaleController.getString("UsernameHelp", R.string.UsernameHelp));
        this.infoText = spannableStringBuilderReplaceTags;
        textView3.setText(spannableStringBuilderReplaceTags);
        this.helpTextView.setLinkTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteLinkText));
        this.helpTextView.setHighlightColor(Theme.getColor(Theme.key_windowBackgroundWhiteLinkSelection));
        this.helpTextView.setMovementMethod(new LinkMovementMethodMy(null));
        linearLayout2.addView(this.helpTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 24, 10, 24, 0));
        this.checkTextView.setVisibility(8);
        if (user != null && (str = user.username) != null && str.length() > 0) {
            this.ignoreCheck = true;
            this.firstNameField.setText(user.username);
            EditTextBoldCursor editTextBoldCursor3 = this.firstNameField;
            editTextBoldCursor3.setSelection(editTextBoldCursor3.length());
            this.ignoreCheck = false;
        }
        return this.fragmentView;
    }

    /* renamed from: org.rbmain.ui.ChangeUsernameActivity$1, reason: invalid class name */
    class AnonymousClass1 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass1() {
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) {
            if (i == -1) {
                AndroidUtilities.hideKeyboard(ChangeUsernameActivity.this.firstNameField);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangeUsernameActivity$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onItemClick$0();
                    }
                }, 20L);
            } else if (i == 1) {
                ChangeUsernameActivity.this.saveName();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            ChangeUsernameActivity.this.finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$1(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        if (i != 6 || (view = this.doneButton) == null) {
            return false;
        }
        view.performClick();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (MessagesController.getGlobalMainSettings().getBoolean("view_animations", true)) {
            return;
        }
        this.firstNameField.requestFocus();
        AndroidUtilities.showKeyboard(this.firstNameField);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkUserName(final String str, boolean z) {
        if (str != null && str.startsWith("@")) {
            str = str.substring(1);
        }
        if (!TextUtils.isEmpty(str)) {
            this.checkTextView.setVisibility(0);
        } else {
            this.checkTextView.setVisibility(8);
        }
        Runnable runnable = this.checkRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.checkRunnable = null;
            this.lastCheckName = null;
            if (this.checkReqId != 0) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.checkReqId, true);
            }
        }
        if (str != null) {
            if (str.startsWith("_") || str.endsWith("_")) {
                this.checkTextView.setText(LocaleController.getString("UsernameInvalid", R.string.UsernameInvalid));
                TextView textView = this.checkTextView;
                int i = Theme.key_text_RedRegular;
                textView.setTag(Integer.valueOf(i));
                this.checkTextView.setTextColor(Theme.getColor(i));
                return false;
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (i2 == 0 && cCharAt >= '0' && cCharAt <= '9') {
                    if (z) {
                        AlertsCreator.showSimpleAlert(this, LocaleController.getString("UsernameInvalidStartNumber", R.string.UsernameInvalidStartNumber));
                    } else {
                        this.checkTextView.setText(LocaleController.getString("UsernameInvalidStartNumber", R.string.UsernameInvalidStartNumber));
                        TextView textView2 = this.checkTextView;
                        int i3 = Theme.key_text_RedRegular;
                        textView2.setTag(Integer.valueOf(i3));
                        this.checkTextView.setTextColor(Theme.getColor(i3));
                    }
                    return false;
                }
                if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && cCharAt != '_'))) {
                    if (z) {
                        AlertsCreator.showSimpleAlert(this, LocaleController.getString("UsernameInvalid", R.string.UsernameInvalid));
                    } else {
                        this.checkTextView.setText(LocaleController.getString("UsernameInvalid", R.string.UsernameInvalid));
                        TextView textView3 = this.checkTextView;
                        int i4 = Theme.key_text_RedRegular;
                        textView3.setTag(Integer.valueOf(i4));
                        this.checkTextView.setTextColor(Theme.getColor(i4));
                    }
                    return false;
                }
            }
        }
        if (str == null || str.length() < 5) {
            if (z) {
                AlertsCreator.showSimpleAlert(this, LocaleController.getString("UsernameInvalidShort", R.string.UsernameInvalidShort));
            } else {
                this.checkTextView.setText(LocaleController.getString("UsernameInvalidShort", R.string.UsernameInvalidShort));
                TextView textView4 = this.checkTextView;
                int i5 = Theme.key_text_RedRegular;
                textView4.setTag(Integer.valueOf(i5));
                this.checkTextView.setTextColor(Theme.getColor(i5));
            }
            return false;
        }
        if (str.length() > 32) {
            if (z) {
                AlertsCreator.showSimpleAlert(this, LocaleController.getString("UsernameInvalidLong", R.string.UsernameInvalidLong));
            } else {
                this.checkTextView.setText(LocaleController.getString("UsernameInvalidLong", R.string.UsernameInvalidLong));
                TextView textView5 = this.checkTextView;
                int i6 = Theme.key_text_RedRegular;
                textView5.setTag(Integer.valueOf(i6));
                this.checkTextView.setTextColor(Theme.getColor(i6));
            }
            return false;
        }
        if (!z) {
            String str2 = UserConfig.getInstance(this.currentAccount).getCurrentUser().username;
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            if (str.equals(str2)) {
                this.checkTextView.setText(LocaleController.formatString("UsernameAvailable", R.string.UsernameAvailable, str));
                TextView textView6 = this.checkTextView;
                int i7 = Theme.key_windowBackgroundWhiteGreenText;
                textView6.setTag(Integer.valueOf(i7));
                this.checkTextView.setTextColor(Theme.getColor(i7));
                return true;
            }
            this.checkTextView.setText(LocaleController.getString("UsernameChecking", R.string.UsernameChecking));
            TextView textView7 = this.checkTextView;
            int i8 = Theme.key_windowBackgroundWhiteGrayText8;
            textView7.setTag(Integer.valueOf(i8));
            this.checkTextView.setTextColor(Theme.getColor(i8));
            this.lastCheckName = str;
            Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.ChangeUsernameActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkUserName$4(str);
                }
            };
            this.checkRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 300L);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkUserName$4(final String str) {
        TLRPC$TL_account_checkUsername tLRPC$TL_account_checkUsername = new TLRPC$TL_account_checkUsername();
        tLRPC$TL_account_checkUsername.username = str;
        this.checkReqId = DialogsProxy.getInstance(this.currentAccount).checkAccountUsername(tLRPC$TL_account_checkUsername, new RequestDelegate() { // from class: org.rbmain.ui.ChangeUsernameActivity$$ExternalSyntheticLambda7
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkUserName$3(str, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkUserName$3(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangeUsernameActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUserName$2(str, tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkUserName$2(String str, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.checkReqId = 0;
        String str2 = this.lastCheckName;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            this.checkTextView.setText(LocaleController.formatString("UsernameAvailable", R.string.UsernameAvailable, str));
            TextView textView = this.checkTextView;
            int i = Theme.key_windowBackgroundWhiteGreenText;
            textView.setTag(Integer.valueOf(i));
            this.checkTextView.setTextColor(Theme.getColor(i));
            return;
        }
        this.checkTextView.setText(LocaleController.getString("UsernameInUse", R.string.UsernameInUse));
        TextView textView2 = this.checkTextView;
        int i2 = Theme.key_text_RedRegular;
        textView2.setTag(Integer.valueOf(i2));
        this.checkTextView.setTextColor(Theme.getColor(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveName() {
        String string = this.firstNameField.getText().toString();
        if (string.startsWith("@")) {
            string = string.substring(1);
        }
        if (checkUserName(string, true)) {
            TLRPC$User currentUser = UserConfig.getInstance(this.currentAccount).getCurrentUser();
            if (getParentActivity() == null || currentUser == null) {
                return;
            }
            String str = currentUser.username;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            if (str.equals(string)) {
                finishFragment();
                return;
            }
            final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
            TLRPC$TL_account_updateUsername tLRPC$TL_account_updateUsername = new TLRPC$TL_account_updateUsername();
            tLRPC$TL_account_updateUsername.username = string;
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.updateInterfaces, 1);
            final int iUpdateAccountUserName = DialogsProxy.getInstance(this.currentAccount).updateAccountUserName(tLRPC$TL_account_updateUsername, new RequestDelegate() { // from class: org.rbmain.ui.ChangeUsernameActivity$$ExternalSyntheticLambda8
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$saveName$7(alertDialog, tLObject, tLRPC$TL_error);
                }
            });
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.ChangeUsernameActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$saveName$8(iUpdateAccountUserName, dialogInterface);
                }
            });
            alertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveName$7(final AlertDialog alertDialog, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            final TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangeUsernameActivity$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$saveName$5(alertDialog, tLRPC$User);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangeUsernameActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$saveName$6(alertDialog, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveName$5(AlertDialog alertDialog, TLRPC$User tLRPC$User) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        new ArrayList().add(tLRPC$User);
        UserConfig.getInstance(this.currentAccount).saveConfig(true);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveName$6(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        String str = tLRPC$TL_error.text;
        if (str != null && str.contains("InvalidInput")) {
            AlertsCreator.showSimpleAlert(this, LocaleController.getString("UsernameInvalid", R.string.UsernameInvalid));
        } else {
            AlertsCreator.showSimpleAlert(this, LocaleController.getString("UsernameInUse", R.string.UsernameInUse));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveName$8(int i, DialogInterface dialogInterface) {
        ConnectionsManager.getInstance(this.currentAccount).cancelRequest(i, true);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean z, boolean z2) {
        if (z) {
            this.firstNameField.requestFocus();
            AndroidUtilities.showKeyboard(this.firstNameField);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_actionBarDefault));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteHintText));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputField));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_DRAWABLESELECTEDSTATE | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
        TextView textView = this.helpTextView;
        int i = ThemeDescription.FLAG_TEXTCOLOR;
        int i2 = Theme.key_windowBackgroundWhiteGrayText8;
        arrayList.add(new ThemeDescription(textView, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, Theme.key_text_RedRegular));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, Theme.key_windowBackgroundWhiteGreenText));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i2));
        return arrayList;
    }
}
