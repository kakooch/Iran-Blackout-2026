package ir.eitaa.ui;

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
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_account_checkUsername;
import ir.eitaa.tgnet.TLRPC$TL_account_updateUsername;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.LayoutHelper;
import java.util.ArrayList;

/* loaded from: classes3.dex */
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
    private boolean lastNameAvailable;

    static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public class LinkSpan extends ClickableSpan {
        private String url;

        public LinkSpan(String value) {
            this.url = value;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
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

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
            try {
                boolean zOnTouchEvent = super.onTouchEvent(widget, buffer, event);
                if (event.getAction() == 1 || event.getAction() == 3) {
                    Selection.removeSelection(buffer);
                }
                return zOnTouchEvent;
            } catch (Exception e) {
                FileLog.e(e);
                return false;
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        String str;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("Username", R.string.Username));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ChangeUsernameActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    ChangeUsernameActivity.this.finishFragment();
                } else if (id == 1) {
                    ChangeUsernameActivity.this.saveName();
                }
            }
        });
        this.doneButton = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(UserConfig.getInstance(this.currentAccount).getClientUserId()));
        if (user == null) {
            user = UserConfig.getInstance(this.currentAccount).getCurrentUser();
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.fragmentView = linearLayout;
        LinearLayout linearLayout2 = linearLayout;
        linearLayout2.setOrientation(1);
        this.fragmentView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$ChangeUsernameActivity$u8eBsp4F4uzOWQhJ3MpIyzHxoB4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ChangeUsernameActivity.lambda$createView$0(view, motionEvent);
            }
        });
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.firstNameField = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        this.firstNameField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.firstNameField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.firstNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.firstNameField.setMaxLines(1);
        this.firstNameField.setLines(1);
        this.firstNameField.setPadding(0, 0, 0, 0);
        this.firstNameField.setSingleLine(true);
        this.firstNameField.setGravity(LocaleController.isRTL ? 5 : 3);
        this.firstNameField.setInputType(180224);
        this.firstNameField.setImeOptions(6);
        this.firstNameField.setHint(LocaleController.getString("UsernamePlaceholder", R.string.UsernamePlaceholder));
        this.firstNameField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.firstNameField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.firstNameField.setCursorWidth(1.5f);
        this.firstNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$ChangeUsernameActivity$SfpJn6jDVDn31rIsL9Wgi5IVeg4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$1$ChangeUsernameActivity(textView, i, keyEvent);
            }
        });
        this.firstNameField.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.ChangeUsernameActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
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
        this.helpTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText8"));
        this.helpTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        TextView textView3 = this.helpTextView;
        SpannableStringBuilder spannableStringBuilderReplaceTags = AndroidUtilities.replaceTags(LocaleController.getString("UsernameHelp", R.string.UsernameHelp));
        this.infoText = spannableStringBuilderReplaceTags;
        textView3.setText(spannableStringBuilderReplaceTags);
        this.helpTextView.setLinkTextColor(Theme.getColor("windowBackgroundWhiteLinkText"));
        this.helpTextView.setHighlightColor(Theme.getColor("windowBackgroundWhiteLinkSelection"));
        this.helpTextView.setMovementMethod(new LinkMovementMethodMy());
        linearLayout2.addView(this.helpTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 24, 10, 24, 0));
        this.checkTextView.setVisibility(8);
        if (user != null && (str = user.username) != null && str.length() > 0) {
            this.ignoreCheck = true;
            this.firstNameField.setText(user.username);
            EditTextBoldCursor editTextBoldCursor2 = this.firstNameField;
            editTextBoldCursor2.setSelection(editTextBoldCursor2.length());
            this.ignoreCheck = false;
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$1$ChangeUsernameActivity(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        if (i != 6 || (view = this.doneButton) == null) {
            return false;
        }
        view.performClick();
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (MessagesController.getGlobalMainSettings().getBoolean("view_animations", true)) {
            return;
        }
        this.firstNameField.requestFocus();
        AndroidUtilities.showKeyboard(this.firstNameField);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkUserName(final String name, boolean alert) {
        if (name != null && name.startsWith("@")) {
            name = name.substring(1);
        }
        if (!TextUtils.isEmpty(name)) {
            this.checkTextView.setVisibility(0);
        } else {
            this.checkTextView.setVisibility(8);
        }
        if (alert && name.length() == 0) {
            return true;
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
        this.lastNameAvailable = false;
        if (name != null) {
            if (name.startsWith("_") || name.endsWith("_")) {
                this.checkTextView.setText(LocaleController.getString("UsernameInvalid", R.string.UsernameInvalid));
                this.checkTextView.setTag("windowBackgroundWhiteRedText4");
                this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
                return false;
            }
            for (int i = 0; i < name.length(); i++) {
                char cCharAt = name.charAt(i);
                if ((i == 0 && cCharAt >= '0' && cCharAt <= '9') || (cCharAt >= 1776 && cCharAt <= 1785)) {
                    if (alert) {
                        AlertsCreator.showSimpleAlert(this, LocaleController.getString("UsernameInvalidStartNumber", R.string.UsernameInvalidStartNumber));
                    } else {
                        this.checkTextView.setText(LocaleController.getString("UsernameInvalidStartNumber", R.string.UsernameInvalidStartNumber));
                        this.checkTextView.setTag("windowBackgroundWhiteRedText4");
                        this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
                    }
                    return false;
                }
                if ((cCharAt < 1776 || cCharAt > 1785) && ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'z') && !((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == '_' || ((cCharAt >= 1569 && cCharAt <= 1608 && cCharAt != 1600 && cCharAt != 1577) || cCharAt == 1740 || cCharAt == 1705 || cCharAt == 1711 || cCharAt == 1688 || cCharAt == 1662 || cCharAt == 1670))))) {
                    if (alert) {
                        AlertsCreator.showSimpleAlert(this, LocaleController.getString("UsernameInvalid", R.string.UsernameInvalid));
                    } else {
                        this.checkTextView.setText(LocaleController.getString("UsernameInvalid", R.string.UsernameInvalid));
                        this.checkTextView.setTag("windowBackgroundWhiteRedText4");
                        this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
                    }
                    return false;
                }
            }
        }
        if (name == null || name.length() < 5) {
            if (alert) {
                AlertsCreator.showSimpleAlert(this, LocaleController.getString("UsernameInvalidShort", R.string.UsernameInvalidShort));
            } else {
                this.checkTextView.setText(LocaleController.getString("UsernameInvalidShort", R.string.UsernameInvalidShort));
                this.checkTextView.setTag("windowBackgroundWhiteRedText4");
                this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
            }
            return false;
        }
        if (name.length() > 32) {
            if (alert) {
                AlertsCreator.showSimpleAlert(this, LocaleController.getString("UsernameInvalidLong", R.string.UsernameInvalidLong));
            } else {
                this.checkTextView.setText(LocaleController.getString("UsernameInvalidLong", R.string.UsernameInvalidLong));
                this.checkTextView.setTag("windowBackgroundWhiteRedText4");
                this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
            }
            return false;
        }
        if (!alert) {
            String str = UserConfig.getInstance(this.currentAccount).getCurrentUser().username;
            if (str == null) {
                str = "";
            }
            if (name.equals(str)) {
                this.checkTextView.setText(LocaleController.formatString("UsernameAvailable", R.string.UsernameAvailable, name));
                this.checkTextView.setTag("windowBackgroundWhiteGreenText");
                this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGreenText"));
                return true;
            }
            this.checkTextView.setText(LocaleController.getString("UsernameChecking", R.string.UsernameChecking));
            this.checkTextView.setTag("windowBackgroundWhiteGrayText8");
            this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText8"));
            this.lastCheckName = name;
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChangeUsernameActivity$xUQ0ozwA4-sw0ZbOgFG2SlNGkyE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkUserName$4$ChangeUsernameActivity(name);
                }
            };
            this.checkRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 300L);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUserName$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUserName$4$ChangeUsernameActivity(final String str) {
        TLRPC$TL_account_checkUsername tLRPC$TL_account_checkUsername = new TLRPC$TL_account_checkUsername();
        tLRPC$TL_account_checkUsername.username = str;
        this.checkReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_checkUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChangeUsernameActivity$id1sOHlxpNRC543UILh2JAFLkRw
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkUserName$3$ChangeUsernameActivity(str, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUserName$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUserName$3$ChangeUsernameActivity(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChangeUsernameActivity$vjnu2uCcx8INKTlthQOhFM_7xBk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUserName$2$ChangeUsernameActivity(str, tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUserName$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUserName$2$ChangeUsernameActivity(String str, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.checkReqId = 0;
        String str2 = this.lastCheckName;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            this.checkTextView.setText(LocaleController.formatString("UsernameAvailable", R.string.UsernameAvailable, str));
            this.checkTextView.setTag("windowBackgroundWhiteGreenText");
            this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGreenText"));
            this.lastNameAvailable = true;
            return;
        }
        this.checkTextView.setText(LocaleController.getString("UsernameInUse", R.string.UsernameInUse));
        this.checkTextView.setTag("windowBackgroundWhiteRedText4");
        this.checkTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
        this.lastNameAvailable = false;
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
                str = "";
            }
            if (str.equals(string)) {
                finishFragment();
                return;
            }
            final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
            final TLRPC$TL_account_updateUsername tLRPC$TL_account_updateUsername = new TLRPC$TL_account_updateUsername();
            tLRPC$TL_account_updateUsername.username = string;
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_NAME));
            final int iSendRequest = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_updateUsername, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChangeUsernameActivity$4nnATzRxTSs46DPkgVH2Yzdlzyo
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$saveName$7$ChangeUsernameActivity(alertDialog, tLRPC$TL_account_updateUsername, tLObject, tLRPC$TL_error);
                }
            }, 2);
            ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(iSendRequest, this.classGuid);
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ChangeUsernameActivity$IejTaaomOtfAe0lfra8ls6kiq9g
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$saveName$8$ChangeUsernameActivity(iSendRequest, dialogInterface);
                }
            });
            alertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveName$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveName$7$ChangeUsernameActivity(final AlertDialog alertDialog, final TLRPC$TL_account_updateUsername tLRPC$TL_account_updateUsername, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            final TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChangeUsernameActivity$U9Ecm8biayv-N5zhXbd_oIq-Z2M
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$saveName$5$ChangeUsernameActivity(alertDialog, tLRPC$User);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChangeUsernameActivity$ETWWfPW9sDmXESL54H28LlcBV8M
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$saveName$6$ChangeUsernameActivity(alertDialog, tLRPC$TL_error, tLRPC$TL_account_updateUsername);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveName$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveName$5$ChangeUsernameActivity(AlertDialog alertDialog, TLRPC$User tLRPC$User) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        arrayList.add(tLRPC$User);
        MessagesController.getInstance(this.currentAccount).putUsers(arrayList, false);
        MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(arrayList, null, false, true);
        UserConfig.getInstance(this.currentAccount).saveConfig(true);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveName$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveName$6$ChangeUsernameActivity(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_account_updateUsername tLRPC$TL_account_updateUsername) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_account_updateUsername, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveName$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveName$8$ChangeUsernameActivity(int i, DialogInterface dialogInterface) {
        ConnectionsManager.getInstance(this.currentAccount).cancelRequest(i, true);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (isOpen) {
            this.firstNameField.requestFocus();
            AndroidUtilities.showKeyboard(this.firstNameField);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_DRAWABLESELECTEDSTATE | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        arrayList.add(new ThemeDescription(this.helpTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText8"));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteRedText4"));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundWhiteGreenText"));
        arrayList.add(new ThemeDescription(this.checkTextView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText8"));
        return arrayList;
    }
}
