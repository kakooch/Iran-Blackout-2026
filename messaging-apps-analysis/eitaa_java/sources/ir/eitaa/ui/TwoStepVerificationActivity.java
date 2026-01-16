package ir.eitaa.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SRPHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$InputCheckPasswordSRP;
import ir.eitaa.tgnet.TLRPC$PasswordKdfAlgo;
import ir.eitaa.tgnet.TLRPC$SecurePasswordKdfAlgo;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_getPasswordSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_password;
import ir.eitaa.tgnet.TLRPC$TL_account_passwordInputSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_passwordSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_resetPasswordFailedWait;
import ir.eitaa.tgnet.TLRPC$TL_account_resetPasswordOk;
import ir.eitaa.tgnet.TLRPC$TL_account_resetPasswordRequestedWait;
import ir.eitaa.tgnet.TLRPC$TL_account_updatePasswordSettings;
import ir.eitaa.tgnet.TLRPC$TL_auth_passwordRecovery;
import ir.eitaa.tgnet.TLRPC$TL_auth_requestPasswordRecovery;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputCheckPasswordEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputCheckPasswordSRP;
import ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow;
import ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoUnknown;
import ir.eitaa.tgnet.TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000;
import ir.eitaa.tgnet.TLRPC$TL_securePasswordKdfAlgoSHA512;
import ir.eitaa.tgnet.TLRPC$TL_securePasswordKdfAlgoUnknown;
import ir.eitaa.tgnet.TLRPC$TL_secureSecretSettings;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.EditTextSettingsCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class TwoStepVerificationActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private SimpleTextView bottomButton;
    private TextView bottomTextView;
    private TextView cancelResetButton;
    private int changePasswordRow;
    private int changeRecoveryEmailRow;
    private TLRPC$TL_account_password currentPassword;
    private byte[] currentSecret;
    private long currentSecretId;
    private TwoStepVerificationActivityDelegate delegate;
    private boolean destroyed;
    private ActionBarMenuItem doneItem;
    private EmptyTextProgressView emptyView;
    private boolean forgotPasswordOnShow;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private boolean loading;
    private EditTextBoldCursor passwordEditText;
    private int passwordEnabledDetailRow;
    private boolean paused;
    private AlertDialog progressDialog;
    private boolean resetPasswordOnShow;
    private int rowCount;
    private ScrollView scrollView;
    private int setPasswordDetailRow;
    private int setPasswordRow;
    private int setRecoveryEmailRow;
    private TextView titleTextView;
    private int turnPasswordOffRow;
    private boolean passwordEntered = true;
    private byte[] currentPasswordHash = new byte[0];
    private Runnable updateTimeRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$Qu_tG-YrBPMWVSFa4lxx3Q-6RJs
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.updateBottomButton();
        }
    };

    public interface TwoStepVerificationActivityDelegate {
        void didEnterPassword(TLRPC$InputCheckPasswordSRP password);
    }

    static /* synthetic */ void lambda$checkSecretValues$25(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public void setPassword(TLRPC$TL_account_password password) {
        this.currentPassword = password;
        this.passwordEntered = false;
    }

    public void setCurrentPasswordParams(TLRPC$TL_account_password password, byte[] passwordHash, long secretId, byte[] secret) {
        this.currentPassword = password;
        this.currentPasswordHash = passwordHash;
        this.currentSecret = secret;
        this.currentSecretId = secretId;
        this.passwordEntered = (passwordHash != null && passwordHash.length > 0) || !password.has_password;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        byte[] bArr;
        super.onFragmentCreate();
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        if (tLRPC$TL_account_password == null || tLRPC$TL_account_password.current_algo == null || (bArr = this.currentPasswordHash) == null || bArr.length <= 0) {
            loadPasswordInfo(true, tLRPC$TL_account_password != null);
        }
        updateRows();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.twoStepPasswordChanged);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        AndroidUtilities.cancelRunOnUIThread(this.updateTimeRunnable);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.twoStepPasswordChanged);
        this.destroyed = true;
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.progressDialog = null;
        }
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.TwoStepVerificationActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    TwoStepVerificationActivity.this.finishFragment();
                } else if (id == 1) {
                    TwoStepVerificationActivity.this.processDone();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.doneItem = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        ScrollView scrollView = new ScrollView(context);
        this.scrollView = scrollView;
        scrollView.setFillViewport(true);
        frameLayout2.addView(this.scrollView, LayoutHelper.createFrame(-1, -1.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.scrollView.addView(linearLayout, LayoutHelper.createScroll(-1, -2, 51));
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
        this.titleTextView.setTextSize(1, 18.0f);
        this.titleTextView.setGravity(1);
        this.titleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        linearLayout.addView(this.titleTextView, LayoutHelper.createLinear(-2, -2, 1, 0, 38, 0, 0));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.passwordEditText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 20.0f);
        this.passwordEditText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.passwordEditText.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.passwordEditText.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.passwordEditText.setMaxLines(1);
        this.passwordEditText.setLines(1);
        this.passwordEditText.setGravity(1);
        this.passwordEditText.setSingleLine(true);
        this.passwordEditText.setInputType(129);
        this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.passwordEditText.setTypeface(AndroidUtilities.getFontFamily(false));
        this.passwordEditText.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.passwordEditText.setCursorWidth(1.5f);
        linearLayout.addView(this.passwordEditText, LayoutHelper.createLinear(-1, 36, 51, 40, 32, 40, 0));
        this.passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$4vVJ9NdC_-eDY6xffPBqk3RvVmM
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$0$TwoStepVerificationActivity(textView2, i, keyEvent);
            }
        });
        this.passwordEditText.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: ir.eitaa.ui.TwoStepVerificationActivity.2
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
        TextView textView2 = new TextView(context);
        this.bottomTextView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
        this.bottomTextView.setTextSize(1, 14.0f);
        this.bottomTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        this.bottomTextView.setText(LocaleController.getString("YourEmailInfo", R.string.YourEmailInfo));
        linearLayout.addView(this.bottomTextView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 40, 30, 40, 0));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(80);
        linearLayout2.setClipChildren(false);
        linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -1));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.bottomButton = simpleTextView;
        simpleTextView.setTextSize(14);
        this.bottomButton.setGravity((LocaleController.isRTL ? 5 : 3) | 80);
        this.bottomButton.setPadding(0, AndroidUtilities.dp(10.0f), 0, 0);
        linearLayout2.addView(this.bottomButton, LayoutHelper.createLinear(-1, 40, (LocaleController.isRTL ? 5 : 3) | 80, 40, 0, 40, 14));
        this.bottomButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$RLWkj1h9fg6XeYL_m4RF2BuCvEY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$1$TwoStepVerificationActivity(view);
            }
        });
        TextView textView3 = new TextView(context);
        this.cancelResetButton = textView3;
        textView3.setTextSize(1, 14.0f);
        this.cancelResetButton.setGravity((LocaleController.isRTL ? 5 : 3) | 80);
        this.cancelResetButton.setPadding(0, AndroidUtilities.dp(10.0f), 0, 0);
        this.cancelResetButton.setText(LocaleController.getString("CancelReset", R.string.CancelReset));
        this.cancelResetButton.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
        linearLayout2.addView(this.cancelResetButton, LayoutHelper.createLinear(-1, -2, (LocaleController.isRTL ? 5 : 3) | 80, 40, 0, 40, 26));
        this.cancelResetButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$KVofIET-uY_mlQrjOT7yNiPyofY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$2$TwoStepVerificationActivity(view);
            }
        });
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.showProgress();
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setEmptyView(this.emptyView);
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listAdapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$8wEjMUcYiAA0WFho5mVxtKe6ZG0
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$4$TwoStepVerificationActivity(view, i);
            }
        });
        updateRows();
        this.actionBar.setTitle(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle));
        if (this.delegate != null) {
            this.titleTextView.setText(LocaleController.getString("PleaseEnterCurrentPasswordTransfer", R.string.PleaseEnterCurrentPasswordTransfer));
        } else {
            this.titleTextView.setText(LocaleController.getString("PleaseEnterCurrentPassword", R.string.PleaseEnterCurrentPassword));
        }
        if (this.passwordEntered) {
            this.fragmentView.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
            this.fragmentView.setTag("windowBackgroundGray");
        } else {
            this.fragmentView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.fragmentView.setTag("windowBackgroundWhite");
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$0$TwoStepVerificationActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5 && i != 6) {
            return false;
        }
        processDone();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$TwoStepVerificationActivity(View view) {
        onPasswordForgot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$TwoStepVerificationActivity(View view) {
        cancelPasswordReset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$TwoStepVerificationActivity(View view, int i) {
        if (i == this.setPasswordRow || i == this.changePasswordRow) {
            TwoStepVerificationSetupActivity twoStepVerificationSetupActivity = new TwoStepVerificationSetupActivity(this.currentAccount, 0, this.currentPassword);
            twoStepVerificationSetupActivity.addFragmentToClose(this);
            twoStepVerificationSetupActivity.setCurrentPasswordParams(this.currentPasswordHash, this.currentSecretId, this.currentSecret, false);
            presentFragment(twoStepVerificationSetupActivity);
            return;
        }
        if (i == this.setRecoveryEmailRow || i == this.changeRecoveryEmailRow) {
            TwoStepVerificationSetupActivity twoStepVerificationSetupActivity2 = new TwoStepVerificationSetupActivity(this.currentAccount, 3, this.currentPassword);
            twoStepVerificationSetupActivity2.addFragmentToClose(this);
            twoStepVerificationSetupActivity2.setCurrentPasswordParams(this.currentPasswordHash, this.currentSecretId, this.currentSecret, true);
            presentFragment(twoStepVerificationSetupActivity2);
            return;
        }
        if (i == this.turnPasswordOffRow) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            String string = LocaleController.getString("TurnPasswordOffQuestion", R.string.TurnPasswordOffQuestion);
            if (this.currentPassword.has_secure_values) {
                string = string + "\n\n" + LocaleController.getString("TurnPasswordOffPassport", R.string.TurnPasswordOffPassport);
            }
            String string2 = LocaleController.getString("TurnPasswordOffQuestionTitle", R.string.TurnPasswordOffQuestionTitle);
            String string3 = LocaleController.getString("Disable", R.string.Disable);
            builder.setMessage(string);
            builder.setTitle(string2);
            builder.setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$OH54eKKAxSzKzA3187v3fAGhM-I
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createView$3$TwoStepVerificationActivity(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$TwoStepVerificationActivity(DialogInterface dialogInterface, int i) {
        clearPassword();
    }

    private void cancelPasswordReset() {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("CancelPasswordResetYes", R.string.CancelPasswordResetYes), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$eGQbbMNDg7EpLjOa9-5WgcBTzqY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$cancelPasswordReset$7$TwoStepVerificationActivity(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("CancelPasswordResetNo", R.string.CancelPasswordResetNo), null);
        builder.setTitle(LocaleController.getString("CancelReset", R.string.CancelReset));
        builder.setMessage(LocaleController.getString("CancelPasswordReset", R.string.CancelPasswordReset));
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cancelPasswordReset$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cancelPasswordReset$7$TwoStepVerificationActivity(DialogInterface dialogInterface, int i) {
        getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_declinePasswordReset
            public static int constructor = 1284770294;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$VL9EbbLfIeV6AKfcURb2WenJG0g
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$cancelPasswordReset$6$TwoStepVerificationActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cancelPasswordReset$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cancelPasswordReset$6$TwoStepVerificationActivity(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$V2TdoCI01u3BYujCWNTRpCIwVFw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cancelPasswordReset$5$TwoStepVerificationActivity(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cancelPasswordReset$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cancelPasswordReset$5$TwoStepVerificationActivity(TLObject tLObject) {
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            this.currentPassword.pending_reset_date = 0;
            updateBottomButton();
        }
    }

    public void setForgotPasswordOnShow() {
        this.forgotPasswordOnShow = true;
    }

    private void resetPassword() {
        needShowProgress(true);
        getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_resetPassword
            public static int constructor = -1828139493;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                return TLRPC$account_ResetPasswordResult.TLdeserialize(stream, constructor2, exception);
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$Ed2F6zbnHdLzTMtA3vd2IBKrNvM
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$resetPassword$10$TwoStepVerificationActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$resetPassword$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$resetPassword$10$TwoStepVerificationActivity(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$6kndY8pwpdStQSM3UrPsNcPufyw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$resetPassword$9$TwoStepVerificationActivity(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$resetPassword$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$resetPassword$9$TwoStepVerificationActivity(TLObject tLObject) {
        String pluralString;
        needHideProgress();
        if (tLObject instanceof TLRPC$TL_account_resetPasswordOk) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
            builder.setTitle(LocaleController.getString("ResetPassword", R.string.ResetPassword));
            builder.setMessage(LocaleController.getString("RestorePasswordResetPasswordOk", R.string.RestorePasswordResetPasswordOk));
            showDialog(builder.create(), new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$K2cxhMgbpDKAhxyfoAOXwwkxYHA
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$resetPassword$8$TwoStepVerificationActivity(dialogInterface);
                }
            });
            return;
        }
        if (tLObject instanceof TLRPC$TL_account_resetPasswordRequestedWait) {
            this.currentPassword.pending_reset_date = ((TLRPC$TL_account_resetPasswordRequestedWait) tLObject).until_date;
            updateBottomButton();
            return;
        }
        if (tLObject instanceof TLRPC$TL_account_resetPasswordFailedWait) {
            int currentTime = ((TLRPC$TL_account_resetPasswordFailedWait) tLObject).retry_date - getConnectionsManager().getCurrentTime();
            if (currentTime > 86400) {
                pluralString = LocaleController.formatPluralString("Days", currentTime / 86400);
            } else if (currentTime > 3600) {
                pluralString = LocaleController.formatPluralString("Hours", currentTime / 86400);
            } else if (currentTime > 60) {
                pluralString = LocaleController.formatPluralString("Minutes", currentTime / 60);
            } else {
                pluralString = LocaleController.formatPluralString("Seconds", Math.max(1, currentTime));
            }
            showAlertWithText(LocaleController.getString("ResetPassword", R.string.ResetPassword), LocaleController.formatString("ResetPasswordWait", R.string.ResetPasswordWait, pluralString));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$resetPassword$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$resetPassword$8$TwoStepVerificationActivity(DialogInterface dialogInterface) {
        getNotificationCenter().postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, new Object[0]);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateBottomButton() {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.TwoStepVerificationActivity.updateBottomButton():void");
    }

    private void onPasswordForgot() {
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        if (tLRPC$TL_account_password.pending_reset_date == 0 && tLRPC$TL_account_password.has_recovery) {
            needShowProgress(true);
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_auth_requestPasswordRecovery(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$iRa9xbrU7N0kD5kehSTZiEfKQ5o
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onPasswordForgot$12$TwoStepVerificationActivity(tLObject, tLRPC$TL_error);
                }
            }, 10);
            return;
        }
        if (getParentActivity() == null) {
            return;
        }
        if (this.currentPassword.pending_reset_date != 0) {
            if (getConnectionsManager().getCurrentTime() > this.currentPassword.pending_reset_date) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$fPny8BQIN8-VOYB-6N5L_IpvSlE
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onPasswordForgot$13$TwoStepVerificationActivity(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                builder.setTitle(LocaleController.getString("ResetPassword", R.string.ResetPassword));
                builder.setMessage(LocaleController.getString("RestorePasswordResetPasswordText", R.string.RestorePasswordResetPasswordText));
                AlertDialog alertDialogCreate = builder.create();
                showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor("dialogTextRed2"));
                    return;
                }
                return;
            }
            cancelPasswordReset();
            return;
        }
        AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
        builder2.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$acPnZjgiB6B4IynfB-JVmPH54xA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$onPasswordForgot$14$TwoStepVerificationActivity(dialogInterface, i);
            }
        });
        builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder2.setTitle(LocaleController.getString("ResetPassword", R.string.ResetPassword));
        builder2.setMessage(LocaleController.getString("RestorePasswordNoEmailText2", R.string.RestorePasswordNoEmailText2));
        showDialog(builder2.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPasswordForgot$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPasswordForgot$12$TwoStepVerificationActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$EYeuTUcTl8XBWMOEWzf3TTml1qA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPasswordForgot$11$TwoStepVerificationActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPasswordForgot$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPasswordForgot$11$TwoStepVerificationActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        String pluralString;
        needHideProgress();
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
            tLRPC$TL_account_password.email_unconfirmed_pattern = ((TLRPC$TL_auth_passwordRecovery) tLObject).email_pattern;
            TwoStepVerificationSetupActivity twoStepVerificationSetupActivity = new TwoStepVerificationSetupActivity(this.currentAccount, 4, tLRPC$TL_account_password) { // from class: ir.eitaa.ui.TwoStepVerificationActivity.3
                @Override // ir.eitaa.ui.TwoStepVerificationSetupActivity
                protected void onReset() {
                    TwoStepVerificationActivity.this.resetPasswordOnShow = true;
                }
            };
            twoStepVerificationSetupActivity.addFragmentToClose(this);
            twoStepVerificationSetupActivity.setCurrentPasswordParams(this.currentPasswordHash, this.currentSecretId, this.currentSecret, false);
            presentFragment(twoStepVerificationSetupActivity);
            return;
        }
        if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
            int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
            if (iIntValue < 60) {
                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
            } else {
                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
            }
            showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
            return;
        }
        showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPasswordForgot$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPasswordForgot$13$TwoStepVerificationActivity(DialogInterface dialogInterface, int i) {
        resetPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPasswordForgot$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPasswordForgot$14$TwoStepVerificationActivity(DialogInterface dialogInterface, int i) {
        resetPassword();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.twoStepPasswordChanged) {
            if (args != null && args.length > 0 && args[0] != null) {
                this.currentPasswordHash = (byte[]) args[0];
            }
            loadPasswordInfo(false, false);
            updateRows();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.paused = true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        this.paused = false;
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    public void setCurrentPasswordInfo(byte[] hash, TLRPC$TL_account_password password) {
        if (hash != null) {
            this.currentPasswordHash = hash;
        }
        this.currentPassword = password;
    }

    public void setDelegate(TwoStepVerificationActivityDelegate twoStepVerificationActivityDelegate) {
        this.delegate = twoStepVerificationActivityDelegate;
    }

    public static boolean canHandleCurrentPassword(TLRPC$TL_account_password password, boolean login) {
        return login ? !(password.current_algo instanceof TLRPC$TL_passwordKdfAlgoUnknown) : ((password.new_algo instanceof TLRPC$TL_passwordKdfAlgoUnknown) || (password.current_algo instanceof TLRPC$TL_passwordKdfAlgoUnknown) || (password.new_secure_algo instanceof TLRPC$TL_securePasswordKdfAlgoUnknown)) ? false : true;
    }

    public static void initPasswordNewAlgo(TLRPC$TL_account_password password) {
        TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = password.new_algo;
        if (tLRPC$PasswordKdfAlgo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) {
            TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow tLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow = (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo;
            byte[] bArr = new byte[tLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow.salt1.length + 32];
            Utilities.random.nextBytes(bArr);
            byte[] bArr2 = tLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow.salt1;
            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            tLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow.salt1 = bArr;
        }
        TLRPC$SecurePasswordKdfAlgo tLRPC$SecurePasswordKdfAlgo = password.new_secure_algo;
        if (tLRPC$SecurePasswordKdfAlgo instanceof TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) {
            TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 = (TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) tLRPC$SecurePasswordKdfAlgo;
            byte[] bArr3 = new byte[tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000.salt.length + 32];
            Utilities.random.nextBytes(bArr3);
            byte[] bArr4 = tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000.salt;
            System.arraycopy(bArr4, 0, bArr3, 0, bArr4.length);
            tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000.salt = bArr3;
        }
    }

    private void loadPasswordInfo(final boolean first, final boolean silent) {
        if (!silent) {
            this.loading = true;
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$LgP9mWQt5oLI51uXJekaW661uzg
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPasswordInfo$16$TwoStepVerificationActivity(silent, first, tLObject, tLRPC$TL_error);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPasswordInfo$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPasswordInfo$16$TwoStepVerificationActivity(final boolean z, final boolean z2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$PZxaBAkHboqohBuMETHBSdwFmI8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPasswordInfo$15$TwoStepVerificationActivity(tLRPC$TL_error, tLObject, z, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPasswordInfo$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPasswordInfo$15$TwoStepVerificationActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z, boolean z2) {
        if (tLRPC$TL_error == null) {
            this.loading = false;
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            if (!canHandleCurrentPassword(tLRPC$TL_account_password, false)) {
                AlertsCreator.showUpdateAppAlert(getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
                return;
            }
            if (!z || z2) {
                byte[] bArr = this.currentPasswordHash;
                this.passwordEntered = (bArr != null && bArr.length > 0) || !this.currentPassword.has_password;
            }
            initPasswordNewAlgo(this.currentPassword);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
        }
        updateRows();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        super.onTransitionAnimationEnd(isOpen, backward);
        if (isOpen) {
            if (this.forgotPasswordOnShow) {
                onPasswordForgot();
                this.forgotPasswordOnShow = false;
            } else if (this.resetPasswordOnShow) {
                resetPassword();
                this.resetPasswordOnShow = false;
            }
        }
    }

    private void updateRows() {
        TLRPC$TL_account_password tLRPC$TL_account_password;
        StringBuilder sb = new StringBuilder();
        sb.append(this.setPasswordRow);
        sb.append(this.setPasswordDetailRow);
        sb.append(this.changePasswordRow);
        sb.append(this.turnPasswordOffRow);
        sb.append(this.setRecoveryEmailRow);
        sb.append(this.changeRecoveryEmailRow);
        sb.append(this.passwordEnabledDetailRow);
        sb.append(this.rowCount);
        this.rowCount = 0;
        this.setPasswordRow = -1;
        this.setPasswordDetailRow = -1;
        this.changePasswordRow = -1;
        this.turnPasswordOffRow = -1;
        this.setRecoveryEmailRow = -1;
        this.changeRecoveryEmailRow = -1;
        this.passwordEnabledDetailRow = -1;
        if (!this.loading && (tLRPC$TL_account_password = this.currentPassword) != null && this.passwordEntered) {
            if (tLRPC$TL_account_password.has_password) {
                int i = 0 + 1;
                this.rowCount = i;
                this.changePasswordRow = 0;
                int i2 = i + 1;
                this.rowCount = i2;
                this.turnPasswordOffRow = i;
                if (tLRPC$TL_account_password.has_recovery) {
                    this.rowCount = i2 + 1;
                    this.changeRecoveryEmailRow = i2;
                } else {
                    this.rowCount = i2 + 1;
                    this.setRecoveryEmailRow = i2;
                }
                int i3 = this.rowCount;
                this.rowCount = i3 + 1;
                this.passwordEnabledDetailRow = i3;
            } else {
                int i4 = 0 + 1;
                this.rowCount = i4;
                this.setPasswordRow = 0;
                this.rowCount = i4 + 1;
                this.setPasswordDetailRow = i4;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.setPasswordRow);
        sb2.append(this.setPasswordDetailRow);
        sb2.append(this.changePasswordRow);
        sb2.append(this.turnPasswordOffRow);
        sb2.append(this.setRecoveryEmailRow);
        sb2.append(this.changeRecoveryEmailRow);
        sb2.append(this.passwordEnabledDetailRow);
        sb2.append(this.rowCount);
        if (this.listAdapter != null && !sb.toString().equals(sb2.toString())) {
            this.listAdapter.notifyDataSetChanged();
        }
        if (this.fragmentView != null) {
            if (this.loading || this.passwordEntered) {
                RecyclerListView recyclerListView = this.listView;
                if (recyclerListView != null) {
                    recyclerListView.setVisibility(0);
                    this.scrollView.setVisibility(4);
                    this.listView.setEmptyView(this.emptyView);
                }
                if (this.passwordEditText != null) {
                    this.doneItem.setVisibility(8);
                    this.passwordEditText.setVisibility(4);
                    this.titleTextView.setVisibility(4);
                    this.bottomTextView.setVisibility(4);
                    this.bottomButton.setVisibility(4);
                    updateBottomButton();
                }
                this.fragmentView.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
                this.fragmentView.setTag("windowBackgroundGray");
                return;
            }
            RecyclerListView recyclerListView2 = this.listView;
            if (recyclerListView2 != null) {
                recyclerListView2.setEmptyView(null);
                this.listView.setVisibility(4);
                this.scrollView.setVisibility(0);
                this.emptyView.setVisibility(4);
            }
            if (this.passwordEditText != null) {
                this.doneItem.setVisibility(0);
                this.passwordEditText.setVisibility(0);
                this.fragmentView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                this.fragmentView.setTag("windowBackgroundWhite");
                this.titleTextView.setVisibility(0);
                this.bottomButton.setVisibility(0);
                updateBottomButton();
                this.bottomTextView.setVisibility(4);
                if (!TextUtils.isEmpty(this.currentPassword.hint)) {
                    this.passwordEditText.setHint(this.currentPassword.hint);
                } else {
                    this.passwordEditText.setHint("");
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$6ANRwhthQLQt4o9L8wsSh_5uNZU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateRows$17$TwoStepVerificationActivity();
                    }
                }, 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateRows$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateRows$17$TwoStepVerificationActivity() {
        EditTextBoldCursor editTextBoldCursor;
        if (isFinishing() || this.destroyed || (editTextBoldCursor = this.passwordEditText) == null) {
            return;
        }
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(this.passwordEditText);
    }

    private void needShowProgress() {
        needShowProgress(false);
    }

    private void needShowProgress(boolean delay) {
        if (getParentActivity() == null || getParentActivity().isFinishing() || this.progressDialog != null) {
            return;
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog;
        alertDialog.setCanCacnel(false);
        if (delay) {
            this.progressDialog.showDelayed(300L);
        } else {
            this.progressDialog.show();
        }
    }

    public void needHideProgress() {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog == null) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.progressDialog = null;
    }

    private void showAlertWithText(String title, String text) {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(title);
        builder.setMessage(text);
        showDialog(builder.create());
    }

    private void clearPassword() {
        final TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings = new TLRPC$TL_account_updatePasswordSettings();
        byte[] bArr = this.currentPasswordHash;
        if (bArr == null || bArr.length == 0) {
            tLRPC$TL_account_updatePasswordSettings.password = new TLRPC$TL_inputCheckPasswordEmpty();
        }
        tLRPC$TL_account_updatePasswordSettings.new_settings = new TLRPC$TL_account_passwordInputSettings();
        UserConfig.getInstance(this.currentAccount).resetSavedPassword();
        this.currentSecret = null;
        TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings = tLRPC$TL_account_updatePasswordSettings.new_settings;
        tLRPC$TL_account_passwordInputSettings.flags = 3;
        tLRPC$TL_account_passwordInputSettings.hint = "";
        tLRPC$TL_account_passwordInputSettings.new_password_hash = new byte[0];
        tLRPC$TL_account_passwordInputSettings.new_algo = new TLRPC$TL_passwordKdfAlgoUnknown();
        tLRPC$TL_account_updatePasswordSettings.new_settings.email = "";
        needShowProgress();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$ge8mrVFCNSNxelyjauZuWNdLOKc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearPassword$24$TwoStepVerificationActivity(tLRPC$TL_account_updatePasswordSettings);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearPassword$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearPassword$24$TwoStepVerificationActivity(TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings) {
        if (tLRPC$TL_account_updatePasswordSettings.password == null) {
            if (this.currentPassword.current_algo == null) {
                ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$QHbIbvTCWM0hB7d1SMTnxFVkKE8
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$clearPassword$19$TwoStepVerificationActivity(tLObject, tLRPC$TL_error);
                    }
                }, 8);
                return;
            }
            tLRPC$TL_account_updatePasswordSettings.password = getNewSrpPassword();
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_updatePasswordSettings, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$oNWDwWRpPQL8wLdnZg0EAy22A08
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$clearPassword$23$TwoStepVerificationActivity(tLObject, tLRPC$TL_error);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearPassword$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearPassword$19$TwoStepVerificationActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$ErjTIDcZdLG-H7XYulgQVvZ-z20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearPassword$18$TwoStepVerificationActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearPassword$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearPassword$18$TwoStepVerificationActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            initPasswordNewAlgo(tLRPC$TL_account_password);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
            clearPassword();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearPassword$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearPassword$23$TwoStepVerificationActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$7kN41gzTqDPwLELuhDvWqJ4jRsI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearPassword$22$TwoStepVerificationActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearPassword$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearPassword$22$TwoStepVerificationActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        String pluralString;
        if (tLRPC$TL_error != null && "SRP_ID_INVALID".equals(tLRPC$TL_error.text)) {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$Q9k3Vnlc4f5wovyUof6Tp_J0NDQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$clearPassword$21$TwoStepVerificationActivity(tLObject2, tLRPC$TL_error2);
                }
            }, 8);
            return;
        }
        needHideProgress();
        if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            this.currentPassword = null;
            this.currentPasswordHash = new byte[0];
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didRemoveTwoStepPassword, new Object[0]);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, new Object[0]);
            finishFragment();
            return;
        }
        if (tLRPC$TL_error != null) {
            if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
                if (iIntValue < 60) {
                    pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
                } else {
                    pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
                }
                showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
                return;
            }
            showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearPassword$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearPassword$21$TwoStepVerificationActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$owd9RupStBmfHhHpW-fACcl_tKA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearPassword$20$TwoStepVerificationActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearPassword$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearPassword$20$TwoStepVerificationActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            initPasswordNewAlgo(tLRPC$TL_account_password);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
            clearPassword();
        }
    }

    public TLRPC$TL_inputCheckPasswordSRP getNewSrpPassword() {
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = tLRPC$TL_account_password.current_algo;
        if (!(tLRPC$PasswordKdfAlgo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow)) {
            return null;
        }
        return SRPHelper.startCheck(this.currentPasswordHash, tLRPC$TL_account_password.srp_id, tLRPC$TL_account_password.srp_B, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo);
    }

    private boolean checkSecretValues(byte[] passwordBytes, TLRPC$TL_account_passwordSettings passwordSettings) throws NoSuchAlgorithmException {
        byte[] bArrComputeSHA512;
        TLRPC$TL_secureSecretSettings tLRPC$TL_secureSecretSettings = passwordSettings.secure_settings;
        if (tLRPC$TL_secureSecretSettings != null) {
            this.currentSecret = tLRPC$TL_secureSecretSettings.secure_secret;
            TLRPC$SecurePasswordKdfAlgo tLRPC$SecurePasswordKdfAlgo = tLRPC$TL_secureSecretSettings.secure_algo;
            if (tLRPC$SecurePasswordKdfAlgo instanceof TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) {
                bArrComputeSHA512 = Utilities.computePBKDF2(passwordBytes, ((TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) tLRPC$SecurePasswordKdfAlgo).salt);
            } else {
                if (!(tLRPC$SecurePasswordKdfAlgo instanceof TLRPC$TL_securePasswordKdfAlgoSHA512)) {
                    return false;
                }
                byte[] bArr = ((TLRPC$TL_securePasswordKdfAlgoSHA512) tLRPC$SecurePasswordKdfAlgo).salt;
                bArrComputeSHA512 = Utilities.computeSHA512(bArr, passwordBytes, bArr);
            }
            this.currentSecretId = passwordSettings.secure_settings.secure_secret_id;
            byte[] bArr2 = new byte[32];
            System.arraycopy(bArrComputeSHA512, 0, bArr2, 0, 32);
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArrComputeSHA512, 32, bArr3, 0, 16);
            byte[] bArr4 = this.currentSecret;
            Utilities.aesCbcEncryptionByteArraySafe(bArr4, bArr2, bArr3, 0, bArr4.length, 0, 0);
            TLRPC$TL_secureSecretSettings tLRPC$TL_secureSecretSettings2 = passwordSettings.secure_settings;
            if (PassportActivity.checkSecret(tLRPC$TL_secureSecretSettings2.secure_secret, Long.valueOf(tLRPC$TL_secureSecretSettings2.secure_secret_id))) {
                return true;
            }
            TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings = new TLRPC$TL_account_updatePasswordSettings();
            tLRPC$TL_account_updatePasswordSettings.password = getNewSrpPassword();
            TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings = new TLRPC$TL_account_passwordInputSettings();
            tLRPC$TL_account_updatePasswordSettings.new_settings = tLRPC$TL_account_passwordInputSettings;
            tLRPC$TL_account_passwordInputSettings.new_secure_settings = new TLRPC$TL_secureSecretSettings();
            TLRPC$TL_secureSecretSettings tLRPC$TL_secureSecretSettings3 = tLRPC$TL_account_updatePasswordSettings.new_settings.new_secure_settings;
            tLRPC$TL_secureSecretSettings3.secure_secret = new byte[0];
            tLRPC$TL_secureSecretSettings3.secure_algo = new TLRPC$TL_securePasswordKdfAlgoUnknown();
            TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings2 = tLRPC$TL_account_updatePasswordSettings.new_settings;
            tLRPC$TL_account_passwordInputSettings2.new_secure_settings.secure_secret_id = 0L;
            tLRPC$TL_account_passwordInputSettings2.flags |= 4;
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_updatePasswordSettings, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$p-kJGpaEh6vHspdQM7TQQS2iIkU
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    TwoStepVerificationActivity.lambda$checkSecretValues$25(tLObject, tLRPC$TL_error);
                }
            });
            this.currentSecret = null;
            this.currentSecretId = 0L;
            return true;
        }
        this.currentSecret = null;
        this.currentSecretId = 0L;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone() {
        if (this.passwordEntered) {
            return;
        }
        String string = this.passwordEditText.getText().toString();
        if (string.length() == 0) {
            onFieldError(this.passwordEditText, false);
            return;
        }
        final byte[] stringBytes = AndroidUtilities.getStringBytes(string);
        needShowProgress();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$98ZVsnCFUXVEqiGsgYXLNOf2dQI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDone$32$TwoStepVerificationActivity(stringBytes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$32$TwoStepVerificationActivity(final byte[] bArr) {
        TLRPC$TL_account_getPasswordSettings tLRPC$TL_account_getPasswordSettings = new TLRPC$TL_account_getPasswordSettings();
        TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = this.currentPassword.current_algo;
        final byte[] x = tLRPC$PasswordKdfAlgo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow ? SRPHelper.getX(bArr, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo) : null;
        RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$HnlBYaK3H3F9cEVGNd0518yAUs0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$processDone$31$TwoStepVerificationActivity(bArr, x, tLObject, tLRPC$TL_error);
            }
        };
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo2 = tLRPC$TL_account_password.current_algo;
        if (tLRPC$PasswordKdfAlgo2 instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) {
            TLRPC$TL_inputCheckPasswordSRP tLRPC$TL_inputCheckPasswordSRPStartCheck = SRPHelper.startCheck(x, tLRPC$TL_account_password.srp_id, tLRPC$TL_account_password.srp_B, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo2);
            tLRPC$TL_account_getPasswordSettings.password = tLRPC$TL_inputCheckPasswordSRPStartCheck;
            if (tLRPC$TL_inputCheckPasswordSRPStartCheck == null) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "ALGO_INVALID";
                requestDelegate.run(null, tLRPC$TL_error);
                return;
            }
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_getPasswordSettings, requestDelegate, 10);
            return;
        }
        TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
        tLRPC$TL_error2.text = "PASSWORD_HASH_INVALID";
        requestDelegate.run(null, tLRPC$TL_error2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$31$TwoStepVerificationActivity(final byte[] bArr, final byte[] bArr2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$sqjzotcxB3b-aU1kASywBu9EFGM
                @Override // java.lang.Runnable
                public final void run() throws NoSuchAlgorithmException {
                    this.f$0.lambda$processDone$27$TwoStepVerificationActivity(bArr, tLObject, bArr2);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$bNNNwBCum6BTJ828mVp4r-3iLVQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processDone$30$TwoStepVerificationActivity(tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$27$TwoStepVerificationActivity(byte[] bArr, TLObject tLObject, final byte[] bArr2) throws NoSuchAlgorithmException {
        final boolean zCheckSecretValues = checkSecretValues(bArr, (TLRPC$TL_account_passwordSettings) tLObject);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$6HxXCDJYWlcDMYMEOzKoxdWqY4A
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDone$26$TwoStepVerificationActivity(zCheckSecretValues, bArr2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$26$TwoStepVerificationActivity(boolean z, byte[] bArr) {
        if (this.delegate == null || !z) {
            needHideProgress();
        }
        if (z) {
            this.currentPasswordHash = bArr;
            this.passwordEntered = true;
            if (this.delegate != null) {
                AndroidUtilities.hideKeyboard(this.passwordEditText);
                this.delegate.didEnterPassword(getNewSrpPassword());
                return;
            }
            if (!TextUtils.isEmpty(this.currentPassword.email_unconfirmed_pattern)) {
                TwoStepVerificationSetupActivity twoStepVerificationSetupActivity = new TwoStepVerificationSetupActivity(this.currentAccount, 5, this.currentPassword);
                twoStepVerificationSetupActivity.setCurrentPasswordParams(this.currentPasswordHash, this.currentSecretId, this.currentSecret, true);
                presentFragment(twoStepVerificationSetupActivity, true);
                return;
            }
            AndroidUtilities.hideKeyboard(this.passwordEditText);
            TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
            twoStepVerificationActivity.passwordEntered = true;
            twoStepVerificationActivity.currentPasswordHash = this.currentPasswordHash;
            twoStepVerificationActivity.currentPassword = this.currentPassword;
            twoStepVerificationActivity.currentSecret = this.currentSecret;
            twoStepVerificationActivity.currentSecretId = this.currentSecretId;
            presentFragment(twoStepVerificationActivity, true);
            return;
        }
        AlertsCreator.showUpdateAppAlert(getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$30$TwoStepVerificationActivity(TLRPC$TL_error tLRPC$TL_error) {
        String pluralString;
        if ("SRP_ID_INVALID".equals(tLRPC$TL_error.text)) {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$o5c_3BQyRuJfIk4ePCNZqTe1kMU
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$processDone$29$TwoStepVerificationActivity(tLObject, tLRPC$TL_error2);
                }
            }, 8);
            return;
        }
        needHideProgress();
        if ("PASSWORD_HASH_INVALID".equals(tLRPC$TL_error.text)) {
            onFieldError(this.passwordEditText, true);
            return;
        }
        if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
            int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
            if (iIntValue < 60) {
                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
            } else {
                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
            }
            showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
            return;
        }
        showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$29$TwoStepVerificationActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity$h7Yjz_xnVOjA7SlwkZPn2-Z6ojQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processDone$28$TwoStepVerificationActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processDone$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processDone$28$TwoStepVerificationActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            initPasswordNewAlgo(tLRPC$TL_account_password);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
            processDone();
        }
    }

    private void onFieldError(TextView field, boolean clear) {
        if (getParentActivity() == null) {
            return;
        }
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        if (clear) {
            field.setText("");
        }
        AndroidUtilities.shakeView(field, 2.0f, 0);
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (TwoStepVerificationActivity.this.loading || TwoStepVerificationActivity.this.currentPassword == null) {
                return 0;
            }
            return TwoStepVerificationActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View textSettingsCell;
            if (viewType == 0) {
                textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else {
                textSettingsCell = new TextInfoPrivacyCell(this.mContext);
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return;
                }
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                if (position != TwoStepVerificationActivity.this.setPasswordDetailRow) {
                    if (position == TwoStepVerificationActivity.this.passwordEnabledDetailRow) {
                        textInfoPrivacyCell.setText(LocaleController.getString("EnabledPasswordText", R.string.EnabledPasswordText));
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                        return;
                    }
                    return;
                }
                textInfoPrivacyCell.setText(LocaleController.getString("SetAdditionalPasswordInfo", R.string.SetAdditionalPasswordInfo));
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                return;
            }
            TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
            textSettingsCell.setTag("windowBackgroundWhiteBlackText");
            textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            if (position != TwoStepVerificationActivity.this.changePasswordRow) {
                if (position != TwoStepVerificationActivity.this.setPasswordRow) {
                    if (position != TwoStepVerificationActivity.this.turnPasswordOffRow) {
                        if (position != TwoStepVerificationActivity.this.changeRecoveryEmailRow) {
                            if (position == TwoStepVerificationActivity.this.setRecoveryEmailRow) {
                                textSettingsCell.setText(LocaleController.getString("SetRecoveryEmail", R.string.SetRecoveryEmail), false);
                                return;
                            }
                            return;
                        }
                        textSettingsCell.setText(LocaleController.getString("ChangeRecoveryEmail", R.string.ChangeRecoveryEmail), false);
                        return;
                    }
                    textSettingsCell.setText(LocaleController.getString("TurnPasswordOff", R.string.TurnPasswordOff), true);
                    return;
                }
                textSettingsCell.setText(LocaleController.getString("SetAdditionalPassword", R.string.SetAdditionalPassword), true);
                return;
            }
            textSettingsCell.setText(LocaleController.getString("ChangePassword", R.string.ChangePassword), true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return (position == TwoStepVerificationActivity.this.setPasswordDetailRow || position == TwoStepVerificationActivity.this.passwordEnabledDetailRow) ? 1 : 0;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, EditTextSettingsCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText3"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{EditTextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{EditTextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
        arrayList.add(new ThemeDescription(this.bottomTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
        arrayList.add(new ThemeDescription(this.bottomButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_DRAWABLESELECTEDSTATE | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        return arrayList;
    }
}
