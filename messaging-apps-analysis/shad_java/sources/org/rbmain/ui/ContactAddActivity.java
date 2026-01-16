package org.rbmain.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class ContactAddActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private boolean addContact;
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImage;
    private CheckBoxCell checkBoxCell;
    private ContactAddActivityDelegate delegate;
    private View doneButton;
    private EditTextBoldCursor firstNameField;
    private TextView infoTextView;
    private EditTextBoldCursor lastNameField;
    private TextView nameTextView;
    private boolean needAddException;
    private TextView onlineTextView;
    boolean paused;
    private String phone;
    private int user_id;

    public interface ContactAddActivityDelegate {
        void didAddToContacts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public ContactAddActivity(Bundle bundle) {
        super(bundle);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.updateInterfaces);
        this.user_id = getArguments().getInt("user_id", 0);
        this.phone = getArguments().getString("phone");
        this.addContact = getArguments().getBoolean("addContact", false);
        this.needAddException = MessagesController.getNotificationsSettings(this.currentAccount).getBoolean("dialog_bar_exception" + this.user_id, false);
        return getMessagesController().getUser(Integer.valueOf(this.user_id)) != null && super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.updateInterfaces);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        String str;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (this.addContact) {
            this.actionBar.setTitle(LocaleController.getString("NewContact", R.string.NewContact));
        } else {
            this.actionBar.setTitle(LocaleController.getString("EditName", R.string.EditName));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ContactAddActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ContactAddActivity.this.finishFragment();
                    return;
                }
                if (i == 1) {
                    if (ContactAddActivity.this.firstNameField.getText().length() == 0 && ContactAddActivity.this.lastNameField.getText().length() == 0) {
                        return;
                    }
                    TLRPC$User user = ContactAddActivity.this.getMessagesController().getUser(Integer.valueOf(ContactAddActivity.this.user_id));
                    user.first_name = ContactAddActivity.this.firstNameField.getText().toString();
                    user.last_name = ContactAddActivity.this.lastNameField.getText().toString();
                    ContactAddActivity.this.getContactsController().addContact(user, ContactAddActivity.this.checkBoxCell != null && ContactAddActivity.this.checkBoxCell.isChecked());
                    MessagesController.getNotificationsSettings(((BaseFragment) ContactAddActivity.this).currentAccount).edit().putInt("dialog_bar_vis3" + ContactAddActivity.this.user_id, 3).apply();
                    ContactAddActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, 1);
                    ContactAddActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.peerSettingsDidLoad, Long.valueOf((long) ContactAddActivity.this.user_id));
                    ContactAddActivity.this.finishFragment();
                    if (ContactAddActivity.this.delegate != null) {
                        ContactAddActivity.this.delegate.didAddToContacts();
                    }
                }
            }
        });
        this.doneButton = this.actionBar.createMenu().addItem(1, LocaleController.getString("Done", R.string.Done).toUpperCase());
        this.fragmentView = new ScrollView(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ((ScrollView) this.fragmentView).addView(linearLayout, LayoutHelper.createScroll(-1, -2, 51));
        linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.ContactAddActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ContactAddActivity.lambda$createView$0(view, motionEvent);
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, -2, 24.0f, 24.0f, 24.0f, 0.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImage = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(30.0f));
        frameLayout.addView(this.avatarImage, LayoutHelper.createFrame(60, 60, (LocaleController.isRTL ? 5 : 3) | 48));
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        int i = Theme.key_windowBackgroundWhiteBlackText;
        textView.setTextColor(Theme.getColor(i));
        this.nameTextView.setTextSize(1, 20.0f);
        this.nameTextView.setLines(1);
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.nameTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        this.nameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        TextView textView2 = this.nameTextView;
        boolean z = LocaleController.isRTL;
        frameLayout.addView(textView2, LayoutHelper.createFrame(-2, -2.0f, (z ? 5 : 3) | 48, z ? 0.0f : 80.0f, 3.0f, z ? 80.0f : 0.0f, 0.0f));
        TextView textView3 = new TextView(context);
        this.onlineTextView = textView3;
        textView3.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
        this.onlineTextView.setTextSize(1, 14.0f);
        this.onlineTextView.setLines(1);
        this.onlineTextView.setMaxLines(1);
        this.onlineTextView.setSingleLine(true);
        this.onlineTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.onlineTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        TextView textView4 = this.onlineTextView;
        boolean z2 = LocaleController.isRTL;
        frameLayout.addView(textView4, LayoutHelper.createFrame(-2, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 0.0f : 80.0f, 32.0f, z2 ? 80.0f : 0.0f, 0.0f));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.firstNameField = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        EditTextBoldCursor editTextBoldCursor2 = this.firstNameField;
        int i2 = Theme.key_windowBackgroundWhiteHintText;
        editTextBoldCursor2.setHintTextColor(Theme.getColor(i2));
        this.firstNameField.setTextColor(Theme.getColor(i));
        this.firstNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.firstNameField.setMaxLines(1);
        this.firstNameField.setLines(1);
        this.firstNameField.setSingleLine(true);
        this.firstNameField.setGravity(LocaleController.isRTL ? 5 : 3);
        this.firstNameField.setInputType(49152);
        this.firstNameField.setImeOptions(5);
        this.firstNameField.setHint(LocaleController.getString("FirstName", R.string.FirstName));
        this.firstNameField.setCursorColor(Theme.getColor(i));
        this.firstNameField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.firstNameField.setCursorWidth(1.5f);
        linearLayout.addView(this.firstNameField, LayoutHelper.createLinear(-1, 36, 24.0f, 24.0f, 24.0f, 0.0f));
        this.firstNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.ContactAddActivity$$ExternalSyntheticLambda3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView5, int i3, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$1(textView5, i3, keyEvent);
            }
        });
        this.firstNameField.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: org.rbmain.ui.ContactAddActivity.2
            boolean focued;

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z3) {
                if (!ContactAddActivity.this.paused && !z3 && this.focued) {
                    FileLog.d("changed");
                }
                this.focued = z3;
            }
        });
        EditTextBoldCursor editTextBoldCursor3 = new EditTextBoldCursor(context);
        this.lastNameField = editTextBoldCursor3;
        editTextBoldCursor3.setTextSize(1, 18.0f);
        this.lastNameField.setHintTextColor(Theme.getColor(i2));
        this.lastNameField.setTextColor(Theme.getColor(i));
        this.lastNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.lastNameField.setMaxLines(1);
        this.lastNameField.setLines(1);
        this.lastNameField.setSingleLine(true);
        this.lastNameField.setGravity(LocaleController.isRTL ? 5 : 3);
        this.lastNameField.setInputType(49152);
        this.lastNameField.setImeOptions(6);
        this.lastNameField.setHint(LocaleController.getString("LastName", R.string.LastName));
        this.lastNameField.setCursorColor(Theme.getColor(i));
        this.lastNameField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.lastNameField.setCursorWidth(1.5f);
        linearLayout.addView(this.lastNameField, LayoutHelper.createLinear(-1, 36, 24.0f, 16.0f, 24.0f, 0.0f));
        this.lastNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.ContactAddActivity$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView5, int i3, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$2(textView5, i3, keyEvent);
            }
        });
        TLRPC$User user = getMessagesController().getUser(Integer.valueOf(this.user_id));
        if (user != null) {
            if (user.phone == null && (str = this.phone) != null) {
                user.phone = PhoneFormat.stripExceptNumbers(str);
            }
            this.firstNameField.setText(user.first_name);
            EditTextBoldCursor editTextBoldCursor4 = this.firstNameField;
            editTextBoldCursor4.setSelection(editTextBoldCursor4.length());
            this.lastNameField.setText(user.last_name);
        }
        TextView textView5 = new TextView(context);
        this.infoTextView = textView5;
        textView5.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText4));
        this.infoTextView.setTextSize(1, 14.0f);
        this.infoTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        if (this.addContact) {
            if (!this.needAddException || TextUtils.isEmpty(user.phone)) {
                linearLayout.addView(this.infoTextView, LayoutHelper.createLinear(-1, -2, 24.0f, 18.0f, 24.0f, 0.0f));
            }
            if (this.needAddException) {
                CheckBoxCell checkBoxCell = new CheckBoxCell(getParentActivity(), 0);
                this.checkBoxCell = checkBoxCell;
                checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                this.checkBoxCell.setText(LocaleController.formatString("SharePhoneNumberWith", R.string.SharePhoneNumberWith, UserObject.getFirstName(user)), BuildConfig.FLAVOR, true, false);
                this.checkBoxCell.setPadding(AndroidUtilities.dp(7.0f), 0, AndroidUtilities.dp(7.0f), 0);
                this.checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ContactAddActivity$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$createView$3(view);
                    }
                });
                linearLayout.addView(this.checkBoxCell, LayoutHelper.createLinear(-1, -2, 0.0f, 10.0f, 0.0f, 0.0f));
            }
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$1(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        this.lastNameField.requestFocus();
        EditTextBoldCursor editTextBoldCursor = this.lastNameField;
        editTextBoldCursor.setSelection(editTextBoldCursor.length());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$2(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.doneButton.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(View view) {
        this.checkBoxCell.setChecked(!r3.isChecked(), true);
    }

    public void setDelegate(ContactAddActivityDelegate contactAddActivityDelegate) {
        this.delegate = contactAddActivityDelegate;
    }

    private void updateAvatarLayout() {
        TLRPC$User user;
        if (this.nameTextView == null || (user = getMessagesController().getUser(Integer.valueOf(this.user_id))) == null) {
            return;
        }
        if (TextUtils.isEmpty(user.phone)) {
            this.nameTextView.setText(LocaleController.getString("MobileHidden", R.string.MobileHidden));
            this.infoTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("MobileHiddenExceptionInfo", R.string.MobileHiddenExceptionInfo, UserObject.getFirstName(user))));
        } else {
            this.nameTextView.setText(PhoneFormat.getInstance().format("+" + user.phone));
            if (this.needAddException) {
                this.infoTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("MobileVisibleInfo", R.string.MobileVisibleInfo, UserObject.getFirstName(user))));
            }
        }
        this.onlineTextView.setText(LocaleController.formatUserStatus(this.currentAccount, user));
        BackupImageView backupImageView = this.avatarImage;
        AvatarDrawable avatarDrawable = new AvatarDrawable(user);
        this.avatarDrawable = avatarDrawable;
        backupImageView.setForUserOrChat(user, avatarDrawable);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.updateInterfaces) {
            int iIntValue = ((Integer) objArr[0]).intValue();
            if ((iIntValue & 2) == 0 && (iIntValue & 4) == 0) {
                return;
            }
            updateAvatarLayout();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.paused = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        updateAvatarLayout();
        EditTextBoldCursor editTextBoldCursor = this.firstNameField;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.requestFocus();
            if (MessagesController.getGlobalMainSettings().getBoolean("view_animations", true)) {
                return;
            }
            AndroidUtilities.showKeyboard(this.firstNameField);
        }
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
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ContactAddActivity$$ExternalSyntheticLambda4
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$4();
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_actionBarDefault));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        TextView textView = this.nameTextView;
        int i = ThemeDescription.FLAG_TEXTCOLOR;
        int i2 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(textView, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.onlineTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText3));
        arrayList.add(new ThemeDescription(this.firstNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i2));
        EditTextBoldCursor editTextBoldCursor = this.firstNameField;
        int i3 = ThemeDescription.FLAG_HINTTEXTCOLOR;
        int i4 = Theme.key_windowBackgroundWhiteHintText;
        arrayList.add(new ThemeDescription(editTextBoldCursor, i3, null, null, null, null, i4));
        EditTextBoldCursor editTextBoldCursor2 = this.firstNameField;
        int i5 = ThemeDescription.FLAG_BACKGROUNDFILTER;
        int i6 = Theme.key_windowBackgroundWhiteInputField;
        arrayList.add(new ThemeDescription(editTextBoldCursor2, i5, null, null, null, null, i6));
        EditTextBoldCursor editTextBoldCursor3 = this.firstNameField;
        int i7 = ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE;
        int i8 = Theme.key_windowBackgroundWhiteInputFieldActivated;
        arrayList.add(new ThemeDescription(editTextBoldCursor3, i7, null, null, null, null, i8));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i6));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i8));
        arrayList.add(new ThemeDescription(this.infoTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(null, 0, null, null, Theme.avatarDrawables, themeDescriptionDelegate, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$4() {
        TLRPC$User user;
        if (this.avatarImage == null || (user = getMessagesController().getUser(Integer.valueOf(this.user_id))) == null) {
            return;
        }
        this.avatarDrawable.setInfo(user);
        this.avatarImage.invalidate();
    }
}
