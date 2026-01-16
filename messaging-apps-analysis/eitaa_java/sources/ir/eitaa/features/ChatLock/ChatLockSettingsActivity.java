package ir.eitaa.features.ChatLock;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.support.fingerprint.FingerprintManagerCompat;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class ChatLockSettingsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int changePasscodeRow;
    private TextView dropDown;
    private ActionBarMenuItem dropDownContainer;
    private Drawable dropDownDrawable;
    private int fingerprintRow;
    private String firstPassword;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int passcodeDetailRow;
    private int passcodeRow;
    private EditTextBoldCursor passwordEditText;
    private int rowCount;
    private int showInForwardDetailRow;
    private int showInForwardRow;
    private TextView titleTextView;
    private int type;
    private int currentPasswordType = 0;
    private int passcodeSetStep = 0;

    public ChatLockSettingsActivity(int type) {
        this.type = type;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRows();
        if (this.type != 0) {
            return true;
        }
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didSetChatLockPasscode);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        if (this.type == 0) {
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetChatLockPasscode);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        if (this.type != 3) {
            this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        }
        boolean z = false;
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.features.ChatLock.ChatLockSettingsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) throws UnsupportedEncodingException {
                if (id == -1) {
                    ChatLockSettingsActivity.this.finishFragment();
                    return;
                }
                if (id == 1) {
                    if (ChatLockSettingsActivity.this.passcodeSetStep == 0) {
                        ChatLockSettingsActivity.this.processNext();
                        return;
                    } else {
                        if (ChatLockSettingsActivity.this.passcodeSetStep == 1) {
                            ChatLockSettingsActivity.this.processDone();
                            return;
                        }
                        return;
                    }
                }
                if (id == 2) {
                    ChatLockSettingsActivity.this.currentPasswordType = 0;
                    ChatLockSettingsActivity.this.updateDropDownTextView();
                } else if (id == 3) {
                    ChatLockSettingsActivity.this.currentPasswordType = 1;
                    ChatLockSettingsActivity.this.updateDropDownTextView();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        int i = 1;
        if (this.type != 0) {
            ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
            actionBarMenuCreateMenu.addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
            TextView textView = new TextView(context);
            this.titleTextView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            if (this.type == 1) {
                if (SharedConfig.chatLockPasscodeHash.length() != 0) {
                    this.titleTextView.setText(LocaleController.getString("EnterNewPasscode", R.string.EnterNewPasscode));
                } else {
                    this.titleTextView.setText(LocaleController.getString("EnterNewFirstPasscode", R.string.EnterNewFirstPasscode));
                }
            } else {
                this.titleTextView.setText(LocaleController.getString("EnterCurrentPasscode", R.string.EnterCurrentPasscode));
            }
            this.titleTextView.setTextSize(1, 18.0f);
            this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.titleTextView.setGravity(1);
            frameLayout2.addView(this.titleTextView, LayoutHelper.createFrame(-2, -2.0f, 1, 0.0f, 38.0f, 0.0f, 0.0f));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.passwordEditText = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 20.0f);
            this.passwordEditText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.passwordEditText.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.passwordEditText.setMaxLines(1);
            this.passwordEditText.setLines(1);
            this.passwordEditText.setGravity(1);
            this.passwordEditText.setSingleLine(true);
            if (this.type == 1) {
                this.passcodeSetStep = 0;
                this.passwordEditText.setImeOptions(5);
            } else {
                this.passcodeSetStep = 1;
                this.passwordEditText.setImeOptions(6);
            }
            this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.passwordEditText.setTypeface(AndroidUtilities.getFontFamily(false));
            this.passwordEditText.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.passwordEditText.setCursorSize(AndroidUtilities.dp(20.0f));
            this.passwordEditText.setCursorWidth(1.5f);
            frameLayout2.addView(this.passwordEditText, LayoutHelper.createFrame(-1, 36.0f, 51, 40.0f, 90.0f, 40.0f, 0.0f));
            this.passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.features.ChatLock.-$$Lambda$ChatLockSettingsActivity$gW075hTPi2am2x57DP3bRQIzoc8
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$createView$0$ChatLockSettingsActivity(textView2, i2, keyEvent);
                }
            });
            this.passwordEditText.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.features.ChatLock.ChatLockSettingsActivity.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) throws UnsupportedEncodingException {
                    if (ChatLockSettingsActivity.this.passwordEditText.length() == 4) {
                        if (ChatLockSettingsActivity.this.type != 2 || SharedConfig.chatLockPasscodeType != 0) {
                            if (ChatLockSettingsActivity.this.type == 1 && ChatLockSettingsActivity.this.currentPasswordType == 0) {
                                if (ChatLockSettingsActivity.this.passcodeSetStep == 0) {
                                    ChatLockSettingsActivity.this.processNext();
                                    return;
                                } else {
                                    if (ChatLockSettingsActivity.this.passcodeSetStep == 1) {
                                        ChatLockSettingsActivity.this.processDone();
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        ChatLockSettingsActivity.this.processDone();
                    }
                }
            });
            this.passwordEditText.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: ir.eitaa.features.ChatLock.ChatLockSettingsActivity.3
                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode mode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }
            });
            if (this.type == 1) {
                frameLayout2.setTag("windowBackgroundWhite");
                ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, actionBarMenuCreateMenu, 0, 0);
                this.dropDownContainer = actionBarMenuItem;
                actionBarMenuItem.setSubMenuOpenSide(1);
                this.dropDownContainer.addSubItem(2, LocaleController.getString("PasscodePIN", R.string.PasscodePIN));
                this.dropDownContainer.addSubItem(3, LocaleController.getString("PasscodePassword", R.string.PasscodePassword));
                this.actionBar.addView(this.dropDownContainer, LayoutHelper.createFrame(-2, -1.0f, 51, AndroidUtilities.isTablet() ? 64.0f : 56.0f, 0.0f, 40.0f, 0.0f));
                this.dropDownContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.features.ChatLock.-$$Lambda$ChatLockSettingsActivity$oWJhl0sRE4IDqOpBz8xG3ZqVQ0Y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$createView$1$ChatLockSettingsActivity(view);
                    }
                });
                TextView textView2 = new TextView(context);
                this.dropDown = textView2;
                textView2.setGravity(3);
                this.dropDown.setSingleLine(true);
                this.dropDown.setLines(1);
                this.dropDown.setMaxLines(1);
                this.dropDown.setEllipsize(TextUtils.TruncateAt.END);
                this.dropDown.setTextColor(Theme.getColor("actionBarDefaultTitle"));
                this.dropDown.setTypeface(AndroidUtilities.getFontFamily(true));
                Drawable drawableMutate = context.getResources().getDrawable(R.drawable.ic_arrow_drop_down).mutate();
                this.dropDownDrawable = drawableMutate;
                drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("actionBarDefaultTitle"), PorterDuff.Mode.MULTIPLY));
                this.dropDown.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.dropDownDrawable, (Drawable) null);
                this.dropDown.setCompoundDrawablePadding(AndroidUtilities.dp(4.0f));
                this.dropDown.setPadding(0, 0, AndroidUtilities.dp(10.0f), 0);
                this.dropDownContainer.addView(this.dropDown, LayoutHelper.createFrame(-2, -2.0f, 16, 16.0f, 0.0f, 0.0f, 1.0f));
            } else {
                this.actionBar.setTitle(LocaleController.getString("Passcode", R.string.Passcode));
            }
            updateDropDownTextView();
        } else {
            this.actionBar.setTitle(LocaleController.getString("ChatLock", R.string.ChatLock));
            frameLayout2.setTag("windowBackgroundGray");
            frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
            RecyclerListView recyclerListView = new RecyclerListView(context);
            this.listView = recyclerListView;
            recyclerListView.setLayoutManager(new LinearLayoutManager(context, i, z) { // from class: ir.eitaa.features.ChatLock.ChatLockSettingsActivity.4
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public boolean supportsPredictiveItemAnimations() {
                    return false;
                }
            });
            this.listView.setVerticalScrollBarEnabled(false);
            this.listView.setItemAnimator(null);
            this.listView.setLayoutAnimation(null);
            frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
            RecyclerListView recyclerListView2 = this.listView;
            ListAdapter listAdapter = new ListAdapter(context);
            this.listAdapter = listAdapter;
            recyclerListView2.setAdapter(listAdapter);
            this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.features.ChatLock.-$$Lambda$ChatLockSettingsActivity$sJCLh7HRZBNEJX-IqxLd0pqteDo
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                public final void onItemClick(View view, int i2) {
                    this.f$0.lambda$createView$2$ChatLockSettingsActivity(view, i2);
                }
            });
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$0$ChatLockSettingsActivity(TextView textView, int i, KeyEvent keyEvent) throws UnsupportedEncodingException {
        int i2 = this.passcodeSetStep;
        if (i2 == 0) {
            processNext();
            return true;
        }
        if (i2 != 1) {
            return false;
        }
        processDone();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$ChatLockSettingsActivity(View view) {
        this.dropDownContainer.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$ChatLockSettingsActivity(View view, int i) {
        if (view.isEnabled()) {
            if (i == this.changePasscodeRow) {
                presentFragment(new ChatLockSettingsActivity(1));
                return;
            }
            if (i == this.passcodeRow) {
                TextCheckCell textCheckCell = (TextCheckCell) view;
                if (SharedConfig.chatLockPasscodeHash.length() != 0) {
                    SharedConfig.chatLockPasscodeHash = "";
                    SharedConfig.saveConfig();
                    getMediaDataController().buildShortcuts();
                    int childCount = this.listView.getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= childCount) {
                            break;
                        }
                        View childAt = this.listView.getChildAt(i2);
                        if (childAt instanceof TextSettingsCell) {
                            ((TextSettingsCell) childAt).setTextColor(Theme.getColor("windowBackgroundWhiteGrayText7"));
                            break;
                        }
                        i2++;
                    }
                    textCheckCell.setChecked(SharedConfig.chatLockPasscodeHash.length() != 0);
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetChatLockPasscode, new Object[0]);
                    getMessagesController().unlockAllDialogs();
                    return;
                }
                presentFragment(new ChatLockSettingsActivity(1));
                return;
            }
            if (i == this.fingerprintRow) {
                SharedConfig.chatLockUseFingerprint = !SharedConfig.chatLockUseFingerprint;
                UserConfig.getInstance(this.currentAccount).saveConfig(false);
                ((TextCheckCell) view).setChecked(SharedConfig.chatLockUseFingerprint);
            } else if (i == this.showInForwardRow) {
                SharedConfig.showLockedChatsWhenForward = !SharedConfig.showLockedChatsWhenForward;
                UserConfig.getInstance(this.currentAccount).saveConfig(false);
                ((TextCheckCell) view).setChecked(SharedConfig.showLockedChatsWhenForward);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        if (this.type != 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.features.ChatLock.-$$Lambda$ChatLockSettingsActivity$D_8t7YQnUNaCZQ7BVQ09QumBxWA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$3$ChatLockSettingsActivity();
                }
            }, 200L);
        }
        fixLayoutInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onResume$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onResume$3$ChatLockSettingsActivity() {
        EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.requestFocus();
            AndroidUtilities.showKeyboard(this.passwordEditText);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.didSetChatLockPasscode && this.type == 0) {
            updateRows();
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
        }
    }

    private void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.passcodeRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.changePasscodeRow = i;
        this.rowCount = i2 + 1;
        this.passcodeDetailRow = i2;
        if (SharedConfig.chatLockPasscodeHash.length() > 0) {
            try {
                if (Build.VERSION.SDK_INT >= 23 && FingerprintManagerCompat.from(ApplicationLoader.applicationContext).isHardwareDetected()) {
                    int i3 = this.rowCount;
                    this.rowCount = i3 + 1;
                    this.fingerprintRow = i3;
                }
            } catch (Throwable th) {
                FileLog.e(th);
            }
            int i4 = this.rowCount;
            int i5 = i4 + 1;
            this.rowCount = i5;
            this.showInForwardRow = i4;
            this.rowCount = i5 + 1;
            this.showInForwardDetailRow = i5;
            return;
        }
        this.fingerprintRow = -1;
        this.showInForwardRow = -1;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.features.ChatLock.ChatLockSettingsActivity.5
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    ChatLockSettingsActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    ChatLockSettingsActivity.this.fixLayoutInternal();
                    return true;
                }
            });
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (!isOpen || this.type == 0) {
            return;
        }
        AndroidUtilities.showKeyboard(this.passwordEditText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDropDownTextView() {
        TextView textView = this.dropDown;
        if (textView != null) {
            int i = this.currentPasswordType;
            if (i == 0) {
                textView.setText(LocaleController.getString("PasscodePIN", R.string.PasscodePIN));
            } else if (i == 1) {
                textView.setText(LocaleController.getString("PasscodePassword", R.string.PasscodePassword));
            }
        }
        int i2 = this.type;
        if ((i2 == 1 && this.currentPasswordType == 0) || (i2 == 2 && SharedConfig.chatLockPasscodeType == 0)) {
            this.passwordEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            this.passwordEditText.setInputType(3);
            this.passwordEditText.setKeyListener(DigitsKeyListener.getInstance("1234567890"));
        } else if ((i2 == 1 && this.currentPasswordType == 1) || (i2 == 2 && SharedConfig.chatLockPasscodeType == 1)) {
            this.passwordEditText.setFilters(new InputFilter[0]);
            this.passwordEditText.setKeyListener(null);
            this.passwordEditText.setInputType(129);
        }
        this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNext() {
        if (this.passwordEditText.getText().length() == 0 || (this.currentPasswordType == 0 && this.passwordEditText.getText().length() != 4)) {
            onPasscodeError();
            return;
        }
        if (this.currentPasswordType == 0) {
            this.actionBar.setTitle(LocaleController.getString("PasscodePIN", R.string.PasscodePIN));
        } else {
            this.actionBar.setTitle(LocaleController.getString("PasscodePassword", R.string.PasscodePassword));
        }
        this.dropDownContainer.setVisibility(8);
        this.titleTextView.setText(LocaleController.getString("ReEnterYourPasscode", R.string.ReEnterYourPasscode));
        this.firstPassword = this.passwordEditText.getText().toString();
        this.passwordEditText.setText("");
        this.passcodeSetStep = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone() throws UnsupportedEncodingException {
        if (this.passwordEditText.getText().length() == 0) {
            onPasscodeError();
            return;
        }
        int i = this.type;
        if (i != 1) {
            if (i == 2) {
                long j = SharedConfig.chatLockPasscodeRetryInMs;
                if (j > 0) {
                    double d = j;
                    Double.isNaN(d);
                    Toast.makeText(getParentActivity(), LocaleController.formatString("TooManyTries", R.string.TooManyTries, LocaleController.formatPluralString("Seconds", Math.max(1, (int) Math.ceil(d / 1000.0d)))), 0).show();
                    this.passwordEditText.setText("");
                    onPasscodeError();
                    return;
                }
                if (!SharedConfig.checkChatLockPasscode(this.passwordEditText.getText().toString())) {
                    SharedConfig.increaseChatLockBadPasscodeTries();
                    this.passwordEditText.setText("");
                    onPasscodeError();
                    return;
                } else {
                    SharedConfig.chatLockBadPasscodeTries = 0;
                    SharedConfig.saveConfig();
                    this.passwordEditText.clearFocus();
                    AndroidUtilities.hideKeyboard(this.passwordEditText);
                    presentFragment(new ChatLockSettingsActivity(0), true);
                    return;
                }
            }
            return;
        }
        if (!this.firstPassword.equals(this.passwordEditText.getText().toString())) {
            try {
                Toast.makeText(getParentActivity(), LocaleController.getString("PasscodeDoNotMatch", R.string.PasscodeDoNotMatch), 0).show();
            } catch (Exception e) {
                FileLog.e(e);
            }
            AndroidUtilities.shakeView(this.titleTextView, 2.0f, 0);
            this.passwordEditText.setText("");
            return;
        }
        try {
            SharedConfig.chatLockPasscodeSalt = new byte[16];
            Utilities.random.nextBytes(SharedConfig.chatLockPasscodeSalt);
            byte[] bytes = this.firstPassword.getBytes("UTF-8");
            int length = bytes.length + 32;
            byte[] bArr = new byte[length];
            System.arraycopy(SharedConfig.chatLockPasscodeSalt, 0, bArr, 0, 16);
            System.arraycopy(bytes, 0, bArr, 16, bytes.length);
            System.arraycopy(SharedConfig.chatLockPasscodeSalt, 0, bArr, bytes.length + 16, 16);
            SharedConfig.chatLockPasscodeHash = Utilities.bytesToHex(Utilities.computeSHA256(bArr, 0, length));
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        SharedConfig.chatLockPasscodeType = this.currentPasswordType;
        SharedConfig.saveConfig();
        getMediaDataController().buildShortcuts();
        finishFragment();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetChatLockPasscode, new Object[0]);
        this.passwordEditText.clearFocus();
        AndroidUtilities.hideKeyboard(this.passwordEditText);
    }

    private void onPasscodeError() {
        if (getParentActivity() == null) {
            return;
        }
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        AndroidUtilities.shakeView(this.titleTextView, 2.0f, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal() {
        if (this.dropDownContainer != null) {
            if (!AndroidUtilities.isTablet()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dropDownContainer.getLayoutParams();
                layoutParams.topMargin = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
                this.dropDownContainer.setLayoutParams(layoutParams);
            }
            if (!AndroidUtilities.isTablet() && ApplicationLoader.applicationContext.getResources().getConfiguration().orientation == 2) {
                this.dropDown.setTextSize(1, 18.0f);
            } else {
                this.dropDown.setTextSize(1, 20.0f);
            }
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            return adapterPosition == ChatLockSettingsActivity.this.passcodeRow || adapterPosition == ChatLockSettingsActivity.this.fingerprintRow || adapterPosition == ChatLockSettingsActivity.this.showInForwardRow || (SharedConfig.chatLockPasscodeHash.length() != 0 && adapterPosition == ChatLockSettingsActivity.this.changePasscodeRow);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ChatLockSettingsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            FrameLayout textCheckCell;
            FrameLayout textInfoPrivacyCell;
            if (viewType == 0) {
                textCheckCell = new TextCheckCell(this.mContext);
                textCheckCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 1) {
                textCheckCell = new TextSettingsCell(this.mContext);
                textCheckCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else {
                textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                return new RecyclerListView.Holder(textInfoPrivacyCell);
            }
            textInfoPrivacyCell = textCheckCell;
            return new RecyclerListView.Holder(textInfoPrivacyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                if (position != ChatLockSettingsActivity.this.passcodeRow) {
                    if (position != ChatLockSettingsActivity.this.fingerprintRow) {
                        if (position == ChatLockSettingsActivity.this.showInForwardRow) {
                            textCheckCell.setTextAndCheck(LocaleController.getString("ShowInForward", R.string.ShowInForward), SharedConfig.showLockedChatsWhenForward, true);
                            return;
                        }
                        return;
                    }
                    textCheckCell.setTextAndCheck(LocaleController.getString("UnlockFingerprint", R.string.UnlockFingerprint), SharedConfig.chatLockUseFingerprint, true);
                    return;
                }
                textCheckCell.setTextAndCheck(LocaleController.getString("LockDialogues", R.string.LockDialogues), SharedConfig.chatLockPasscodeHash.length() > 0, true);
                return;
            }
            if (itemViewType == 1) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                if (position == ChatLockSettingsActivity.this.changePasscodeRow) {
                    textSettingsCell.setText(LocaleController.getString("ChangePasscode", R.string.ChangePasscode), false);
                    if (SharedConfig.chatLockPasscodeHash.length() == 0) {
                        textSettingsCell.setTag("windowBackgroundWhiteGrayText7");
                        textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText7"));
                        return;
                    } else {
                        textSettingsCell.setTag("windowBackgroundWhiteBlackText");
                        textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                        return;
                    }
                }
                return;
            }
            if (itemViewType != 2) {
                return;
            }
            TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
            if (position != ChatLockSettingsActivity.this.passcodeDetailRow) {
                if (position == ChatLockSettingsActivity.this.showInForwardDetailRow) {
                    textInfoPrivacyCell.setText(new SpannableStringBuilder(LocaleController.getString("ShowInForwardDescription", R.string.ShowInForwardDescription)));
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                }
                return;
            }
            textInfoPrivacyCell.setText(new SpannableStringBuilder(AndroidUtilities.replaceTags(LocaleController.getString("ChatLockInfo", R.string.ChatLockInfo))));
            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == ChatLockSettingsActivity.this.passcodeRow || position == ChatLockSettingsActivity.this.fingerprintRow || position == ChatLockSettingsActivity.this.showInForwardRow) {
                return 0;
            }
            if (position == ChatLockSettingsActivity.this.changePasscodeRow) {
                return 1;
            }
            return (position == ChatLockSettingsActivity.this.passcodeDetailRow || position == ChatLockSettingsActivity.this.showInForwardDetailRow) ? 2 : 0;
        }
    }
}
