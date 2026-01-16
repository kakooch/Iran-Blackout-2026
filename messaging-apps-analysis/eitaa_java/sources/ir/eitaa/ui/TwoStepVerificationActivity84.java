package ir.eitaa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_account_getPasswordSettings_layer84;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword_layer84;
import ir.eitaa.tgnet.TLRPC$TL_account_noPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_passwordInputSettings_layer84;
import ir.eitaa.tgnet.TLRPC$TL_account_passwordSettings_layer84;
import ir.eitaa.tgnet.TLRPC$TL_account_password_layer84;
import ir.eitaa.tgnet.TLRPC$TL_account_updatePasswordSettings_layer84;
import ir.eitaa.tgnet.TLRPC$TL_auth_passwordRecovery;
import ir.eitaa.tgnet.TLRPC$TL_auth_recoverPassword_layer84;
import ir.eitaa.tgnet.TLRPC$TL_auth_requestPasswordRecovery_layer84;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCode;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_twoStep_sendCode;
import ir.eitaa.tgnet.TLRPC$TL_twoStep_verifyCode;
import ir.eitaa.tgnet.TLRPC$account_Password;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RecyclerListView;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public class TwoStepVerificationActivity84 extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int abortPasswordRow;
    private ImageView blackImageView;
    private RLottieImageView blueImageView;
    private TextView bottomButton;
    private TextView bottomTextView;
    private TextView callTextView;
    private int changePasswordRow;
    private int changeRecoveryEmailRow;
    private boolean closeAfterSet;
    private EditTextBoldCursor[] codeField;
    private LinearLayout codeFieldContainer;
    private TLRPC$account_Password currentPassword;
    private byte[] currentPasswordHash;
    private byte[] currentSecret;
    private long currentSecretId;
    private byte[] currentSecretSalt;
    private boolean destroyed;
    private ActionBarMenuItem doneItem;
    private String email;
    private boolean emailOnly;
    private EmptyTextProgressView emptyView;
    private String firstPassword;
    private String hint;
    private boolean ignoreOnTextChange;
    private double lastCurrentTime;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private boolean loading;
    private String message;
    private int oldColor;
    private EditTextBoldCursor passwordEditText;
    private int passwordEmailVerifyDetailRow;
    private int passwordEnabledDetailRow;
    private boolean passwordEntered;
    private int passwordSetState;
    private int passwordSetupDetailRow;
    private boolean paused;
    private String phone_code_hash;
    private AlertDialog progressDialog;
    private int rowCount;
    private ScrollView scrollView;
    private int setPasswordDetailRow;
    private int setPasswordRow;
    private int setRecoveryEmailRow;
    private int shadowRow;
    private Runnable shortPollRunnable;
    private TextView timeText;
    private Timer timeTimer;
    private int timeout;
    private final Object timerSync;
    private TextView titleTextView;
    private int turnPasswordOffRow;
    private int type;
    private boolean waitingForEmail;

    static /* synthetic */ int access$126(TwoStepVerificationActivity84 twoStepVerificationActivity84, double d) {
        double d2 = twoStepVerificationActivity84.timeout;
        Double.isNaN(d2);
        int i = (int) (d2 - d);
        twoStepVerificationActivity84.timeout = i;
        return i;
    }

    public TwoStepVerificationActivity84(int type) {
        this.timeout = 60;
        this.timerSync = new Object();
        this.passwordEntered = true;
        this.currentPasswordHash = new byte[0];
        this.type = type;
        if (type == 0) {
            loadPasswordInfo(false);
        }
    }

    public TwoStepVerificationActivity84(int account, int type) {
        this.timeout = 60;
        this.timerSync = new Object();
        this.passwordEntered = true;
        this.currentPasswordHash = new byte[0];
        this.currentAccount = account;
        this.type = type;
        if (type == 0) {
            loadPasswordInfo(false);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        updateRows();
        if (this.type != 0) {
            return true;
        }
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.twoStepPasswordChanged);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        if (this.type == 0) {
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.twoStepPasswordChanged);
            Runnable runnable = this.shortPollRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.shortPollRunnable = null;
            }
            this.destroyed = true;
        }
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
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) throws NoSuchAlgorithmException {
                if (id == -1) {
                    TwoStepVerificationActivity84.this.finishFragment();
                } else if (id == 1) {
                    TwoStepVerificationActivity84.this.processDone();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.doneItem = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f));
        ScrollView scrollView = new ScrollView(context);
        this.scrollView = scrollView;
        scrollView.setFillViewport(true);
        frameLayout2.addView(this.scrollView, LayoutHelper.createFrame(-1, -1.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.scrollView.addView(linearLayout, LayoutHelper.createScroll(-1, -2, 51));
        FrameLayout frameLayout3 = new FrameLayout(context);
        ImageView imageView = new ImageView(context);
        this.blackImageView = imageView;
        imageView.setImageResource(R.drawable.sms_devices);
        this.blackImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
        frameLayout3.addView(this.blackImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.blueImageView = rLottieImageView;
        rLottieImageView.setImageResource(R.drawable.sms_bubble);
        this.blueImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.MULTIPLY));
        frameLayout3.addView(this.blueImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        linearLayout.addView(frameLayout3, LayoutHelper.createLinear(-2, -2, 49, 0, 38, 0, 0));
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.titleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
        this.titleTextView.setTextSize(1, 18.0f);
        this.titleTextView.setGravity(1);
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
        this.passwordEditText.setTypeface(Typeface.DEFAULT);
        this.passwordEditText.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.passwordEditText.setCursorSize(AndroidUtilities.dp(20.0f));
        float f = 1.5f;
        this.passwordEditText.setCursorWidth(1.5f);
        linearLayout.addView(this.passwordEditText, LayoutHelper.createLinear(-1, 36, 51, 40, 32, 40, 0));
        this.passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) throws NoSuchAlgorithmException {
                if (i != 5 && i != 6) {
                    return false;
                }
                TwoStepVerificationActivity84.this.processDone();
                return true;
            }
        });
        this.passwordEditText.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.3
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
        int i = 5;
        this.bottomTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        this.bottomTextView.setText(LocaleController.getString("YourEmailInfo", R.string.YourEmailInfo));
        linearLayout.addView(this.bottomTextView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 40, 30, 40, 0));
        TextView textView3 = new TextView(context);
        this.callTextView = textView3;
        textView3.setTypeface(AndroidUtilities.getFontFamily(false));
        this.callTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
        this.callTextView.setGravity(81);
        linearLayout.addView(this.callTextView, LayoutHelper.createLinear(-2, -2, 81, 40, 40, 40, 20));
        this.callTextView.setOnClickListener(new AnonymousClass4());
        if (this.codeField == null) {
            this.codeField = new EditTextBoldCursor[5];
            LinearLayout linearLayout2 = new LinearLayout(context);
            this.codeFieldContainer = linearLayout2;
            linearLayout2.setOrientation(0);
            final int i2 = 0;
            while (i2 < i) {
                this.codeField[i2] = new EditTextBoldCursor(context);
                this.codeField[i2].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                this.codeField[i2].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                this.codeField[i2].setCursorSize(AndroidUtilities.dp(20.0f));
                this.codeField[i2].setCursorWidth(f);
                Drawable drawableMutate = context.getResources().getDrawable(R.drawable.search_dark_activated).mutate();
                drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteInputFieldActivated"), PorterDuff.Mode.MULTIPLY));
                this.codeField[i2].setBackgroundDrawable(drawableMutate);
                this.codeField[i2].setImeOptions(268435461);
                this.codeField[i2].setTextSize(1, 20.0f);
                this.codeField[i2].setMaxLines(1);
                this.codeField[i2].setTypeface(AndroidUtilities.getFontFamily(true));
                this.codeField[i2].setPadding(0, 0, 0, 0);
                this.codeField[i2].setGravity(49);
                this.codeField[i2].setInputType(3);
                this.codeFieldContainer.addView(this.codeField[i2], LayoutHelper.createLinear(34, 36, 1, 0, 0, i2 != 4 ? 7 : 0, 0));
                this.codeField[i2].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.5
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        int length;
                        if (!TwoStepVerificationActivity84.this.ignoreOnTextChange && (length = s.length()) >= 1) {
                            if (length > 1) {
                                String string = s.toString();
                                TwoStepVerificationActivity84.this.ignoreOnTextChange = true;
                                for (int i3 = 0; i3 < Math.min(5 - i2, length); i3++) {
                                    if (i3 != 0) {
                                        TwoStepVerificationActivity84.this.codeField[i2 + i3].setText(string.substring(i3, i3 + 1));
                                    } else {
                                        s.replace(0, length, string.substring(i3, i3 + 1));
                                    }
                                }
                                TwoStepVerificationActivity84.this.ignoreOnTextChange = false;
                            }
                            if (i2 != 4) {
                                TwoStepVerificationActivity84.this.codeField[i2 + 1].setSelection(TwoStepVerificationActivity84.this.codeField[i2 + 1].length());
                                TwoStepVerificationActivity84.this.codeField[i2 + 1].requestFocus();
                            }
                            int i4 = i2;
                            if ((i4 == 4 || (i4 == 3 && length >= 2)) && TwoStepVerificationActivity84.this.getCode().length() == 5) {
                                TwoStepVerificationActivity84.this.onNextPressed();
                            }
                        }
                    }
                });
                this.codeField[i2].setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity84$pT_TZUth0nmPWyhAVLWsGhhP-dk
                    @Override // android.view.View.OnKeyListener
                    public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                        return this.f$0.lambda$createView$0$TwoStepVerificationActivity84(i2, view, i3, keyEvent);
                    }
                });
                this.codeField[i2].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity84$0feEyuM19gwuCoN6ocS0autFx8U
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView4, int i3, KeyEvent keyEvent) {
                        return this.f$0.lambda$createView$1$TwoStepVerificationActivity84(textView4, i3, keyEvent);
                    }
                });
                i2++;
                i = 5;
                f = 1.5f;
            }
        }
        linearLayout.addView(this.codeFieldContainer, LayoutHelper.createLinear(-2, 36, 1, 0, 0, 0, 20));
        TextView textView4 = new TextView(context);
        this.timeText = textView4;
        textView4.setTypeface(AndroidUtilities.getFontFamily(false));
        this.timeText.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
        this.timeText.setGravity(81);
        linearLayout.addView(this.timeText, LayoutHelper.createLinear(-2, -2, 81, 40, 30, 40, 0));
        this.timeText.setOnClickListener(new AnonymousClass6());
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setGravity(80);
        linearLayout.addView(linearLayout3, LayoutHelper.createLinear(-1, -1));
        TextView textView5 = new TextView(context);
        this.bottomButton = textView5;
        textView5.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
        this.bottomButton.setTextSize(1, 14.0f);
        this.bottomButton.setGravity((LocaleController.isRTL ? 5 : 3) | 80);
        this.bottomButton.setText(LocaleController.getString("YourEmailSkip", R.string.YourEmailSkip));
        this.bottomButton.setPadding(0, AndroidUtilities.dp(10.0f), 0, 0);
        linearLayout3.addView(this.bottomButton, LayoutHelper.createLinear(-1, -2, (LocaleController.isRTL ? 5 : 3) | 80, 40, 0, 40, 14));
        this.bottomButton.setOnClickListener(new AnonymousClass7());
        int i3 = this.type;
        if (i3 == 0) {
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
            this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.8
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                public void onItemClick(View view, int position) {
                    if (position != TwoStepVerificationActivity84.this.setPasswordRow && position != TwoStepVerificationActivity84.this.changePasswordRow) {
                        if (position != TwoStepVerificationActivity84.this.setRecoveryEmailRow && position != TwoStepVerificationActivity84.this.changeRecoveryEmailRow) {
                            if (position == TwoStepVerificationActivity84.this.turnPasswordOffRow || position == TwoStepVerificationActivity84.this.abortPasswordRow) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(TwoStepVerificationActivity84.this.getParentActivity());
                                String string = LocaleController.getString("TurnPasswordOffQuestion", R.string.TurnPasswordOffQuestion);
                                if (TwoStepVerificationActivity84.this.currentPassword.has_secure_values) {
                                    string = string + "\n\n" + LocaleController.getString("TurnPasswordOffPassport", R.string.TurnPasswordOffPassport);
                                }
                                builder.setMessage(string);
                                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.8.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i4) throws NoSuchAlgorithmException {
                                        TwoStepVerificationActivity84.this.setNewPassword(true);
                                    }
                                });
                                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                                TwoStepVerificationActivity84.this.showDialog(builder.create());
                                return;
                            }
                            return;
                        }
                        TwoStepVerificationActivity84 twoStepVerificationActivity84 = new TwoStepVerificationActivity84(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount, 1);
                        twoStepVerificationActivity84.currentPasswordHash = TwoStepVerificationActivity84.this.currentPasswordHash;
                        twoStepVerificationActivity84.currentPassword = TwoStepVerificationActivity84.this.currentPassword;
                        twoStepVerificationActivity84.currentSecretId = TwoStepVerificationActivity84.this.currentSecretId;
                        twoStepVerificationActivity84.currentSecret = TwoStepVerificationActivity84.this.currentSecret;
                        twoStepVerificationActivity84.currentSecretSalt = TwoStepVerificationActivity84.this.currentSecretSalt;
                        twoStepVerificationActivity84.emailOnly = true;
                        twoStepVerificationActivity84.passwordSetState = 3;
                        TwoStepVerificationActivity84.this.presentFragment(twoStepVerificationActivity84);
                        return;
                    }
                    TwoStepVerificationActivity84 twoStepVerificationActivity842 = new TwoStepVerificationActivity84(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount, 1);
                    twoStepVerificationActivity842.currentPasswordHash = TwoStepVerificationActivity84.this.currentPasswordHash;
                    twoStepVerificationActivity842.currentPassword = TwoStepVerificationActivity84.this.currentPassword;
                    twoStepVerificationActivity842.currentSecretId = TwoStepVerificationActivity84.this.currentSecretId;
                    twoStepVerificationActivity842.currentSecret = TwoStepVerificationActivity84.this.currentSecret;
                    twoStepVerificationActivity842.currentSecretSalt = TwoStepVerificationActivity84.this.currentSecretSalt;
                    TwoStepVerificationActivity84.this.presentFragment(twoStepVerificationActivity842);
                }
            });
            updateRows();
            this.actionBar.setTitle(LocaleController.getString("TwoStepVerification", R.string.TwoStepVerification));
            this.titleTextView.setText(LocaleController.getString("PleaseEnterCurrentPassword", R.string.PleaseEnterCurrentPassword));
            this.codeFieldContainer.setVisibility(8);
        } else if (i3 == 1) {
            setPasswordSetState(this.passwordSetState);
        }
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.TwoStepVerificationActivity84$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ConnectionsManager.getInstance(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount).sendRequest(new TLRPC$TL_twoStep_sendCode(), new RequestDelegate() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.4.1
                @Override // ir.eitaa.tgnet.RequestDelegate
                public void run(final TLObject response, final TLRPC$TL_error error) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.4.1.1
                        @Override // java.lang.Runnable
                        public void run() throws NoSuchAlgorithmException {
                            TLRPC$TL_error tLRPC$TL_error = error;
                            if (tLRPC$TL_error == null) {
                                TwoStepVerificationActivity84.this.processDone();
                                TLRPC$TL_auth_sentCode tLRPC$TL_auth_sentCode = (TLRPC$TL_auth_sentCode) response;
                                TwoStepVerificationActivity84 twoStepVerificationActivity84 = TwoStepVerificationActivity84.this;
                                int i = tLRPC$TL_auth_sentCode.timeout;
                                if (i == 0) {
                                    i = 60;
                                }
                                twoStepVerificationActivity84.timeout = i;
                                TwoStepVerificationActivity84.this.phone_code_hash = tLRPC$TL_auth_sentCode.phone_code_hash;
                                TwoStepVerificationActivity84.this.message = tLRPC$TL_auth_sentCode.message;
                                TwoStepVerificationActivity84.this.createTimer();
                                return;
                            }
                            if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                                TwoStepVerificationActivity84.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, new Object[0]));
                                return;
                            }
                            if (error.text.startsWith("CALL_VERIFY")) {
                                TwoStepVerificationActivity84.this.setPasswordSetState(3);
                                return;
                            }
                            TwoStepVerificationActivity84.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + error.text);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$0$TwoStepVerificationActivity84(int i, View view, int i2, KeyEvent keyEvent) {
        if (i2 != 67 || this.codeField[i].length() != 0 || i <= 0) {
            return false;
        }
        EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
        int i3 = i - 1;
        editTextBoldCursorArr[i3].setSelection(editTextBoldCursorArr[i3].length());
        this.codeField[i3].requestFocus();
        this.codeField[i3].dispatchKeyEvent(keyEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$1$TwoStepVerificationActivity84(TextView textView, int i, KeyEvent keyEvent) throws NoSuchAlgorithmException {
        if (i != 5 || this.passwordSetState == 6) {
            return false;
        }
        processDone();
        return true;
    }

    /* renamed from: ir.eitaa.ui.TwoStepVerificationActivity84$6, reason: invalid class name */
    class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ConnectionsManager.getInstance(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount).sendRequest(new TLRPC$TL_twoStep_sendCode(), new RequestDelegate() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.6.1
                @Override // ir.eitaa.tgnet.RequestDelegate
                public void run(final TLObject response, final TLRPC$TL_error error) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TLRPC$TL_error tLRPC$TL_error = error;
                            if (tLRPC$TL_error == null) {
                                TLRPC$TL_auth_sentCode tLRPC$TL_auth_sentCode = (TLRPC$TL_auth_sentCode) response;
                                TwoStepVerificationActivity84 twoStepVerificationActivity84 = TwoStepVerificationActivity84.this;
                                int i = tLRPC$TL_auth_sentCode.timeout;
                                if (i == 0) {
                                    i = 60;
                                }
                                twoStepVerificationActivity84.timeout = i;
                                TwoStepVerificationActivity84.this.phone_code_hash = tLRPC$TL_auth_sentCode.phone_code_hash;
                                TwoStepVerificationActivity84.this.message = tLRPC$TL_auth_sentCode.message;
                                TwoStepVerificationActivity84.this.createTimer();
                                return;
                            }
                            if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                                TwoStepVerificationActivity84.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, new Object[0]));
                                return;
                            }
                            if (error.text.startsWith("CALL_VERIFY")) {
                                TwoStepVerificationActivity84.this.setPasswordSetState(3);
                                return;
                            }
                            TwoStepVerificationActivity84.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + error.text);
                        }
                    });
                }
            });
        }
    }

    /* renamed from: ir.eitaa.ui.TwoStepVerificationActivity84$7, reason: invalid class name */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (TwoStepVerificationActivity84.this.type == 0) {
                if (TwoStepVerificationActivity84.this.currentPassword.has_recovery) {
                    TwoStepVerificationActivity84.this.needShowProgress();
                    ConnectionsManager.getInstance(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount).sendRequest(new TLRPC$TL_auth_requestPasswordRecovery_layer84(), new AnonymousClass1(), 10);
                    return;
                } else {
                    if (TwoStepVerificationActivity84.this.getParentActivity() == null) {
                        return;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(TwoStepVerificationActivity84.this.getParentActivity());
                    builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                    builder.setNegativeButton(LocaleController.getString("RestorePasswordResetAccount", R.string.RestorePasswordResetAccount), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.7.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            Browser.openUrl(TwoStepVerificationActivity84.this.getParentActivity(), "http://my.eitaa.org/?phone=" + UserConfig.getInstance(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount).getClientPhone());
                        }
                    });
                    builder.setTitle(LocaleController.getString("RestorePasswordNoEmailTitle", R.string.RestorePasswordNoEmailTitle));
                    builder.setMessage(LocaleController.getString("RestorePasswordNoEmailText", R.string.RestorePasswordNoEmailText));
                    TwoStepVerificationActivity84.this.showDialog(builder.create());
                    return;
                }
            }
            if (TwoStepVerificationActivity84.this.passwordSetState == 4) {
                TwoStepVerificationActivity84.this.showAlertWithText(LocaleController.getString("RestorePasswordNoEmailTitle", R.string.RestorePasswordNoEmailTitle), LocaleController.getString("RestoreEmailTroubleText", R.string.RestoreEmailTroubleText));
                return;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(TwoStepVerificationActivity84.this.getParentActivity());
            builder2.setMessage(LocaleController.getString("YourEmailSkipWarningText", R.string.YourEmailSkipWarningText));
            builder2.setTitle(LocaleController.getString("YourEmailSkipWarning", R.string.YourEmailSkipWarning));
            builder2.setPositiveButton(LocaleController.getString("YourEmailSkip", R.string.YourEmailSkip), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.7.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) throws NoSuchAlgorithmException {
                    TwoStepVerificationActivity84.this.email = "";
                    TwoStepVerificationActivity84.this.setNewPassword(false);
                }
            });
            builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            TwoStepVerificationActivity84.this.showDialog(builder2.create());
        }

        /* renamed from: ir.eitaa.ui.TwoStepVerificationActivity84$7$1, reason: invalid class name */
        class AnonymousClass1 implements RequestDelegate {
            AnonymousClass1() {
            }

            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, final TLRPC$TL_error error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.7.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String pluralString;
                        TwoStepVerificationActivity84.this.needHideProgress();
                        TLRPC$TL_error tLRPC$TL_error = error;
                        if (tLRPC$TL_error == null) {
                            final TLRPC$TL_auth_passwordRecovery tLRPC$TL_auth_passwordRecovery = (TLRPC$TL_auth_passwordRecovery) response;
                            AlertDialog.Builder builder = new AlertDialog.Builder(TwoStepVerificationActivity84.this.getParentActivity());
                            builder.setMessage(LocaleController.formatString("RestoreEmailSent", R.string.RestoreEmailSent, tLRPC$TL_auth_passwordRecovery.email_pattern));
                            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.7.1.1.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    TwoStepVerificationActivity84 twoStepVerificationActivity84 = new TwoStepVerificationActivity84(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount, 1);
                                    twoStepVerificationActivity84.currentPassword = TwoStepVerificationActivity84.this.currentPassword;
                                    twoStepVerificationActivity84.currentPassword.email_unconfirmed_pattern = tLRPC$TL_auth_passwordRecovery.email_pattern;
                                    twoStepVerificationActivity84.currentSecretId = TwoStepVerificationActivity84.this.currentSecretId;
                                    twoStepVerificationActivity84.currentSecret = TwoStepVerificationActivity84.this.currentSecret;
                                    twoStepVerificationActivity84.currentSecretSalt = TwoStepVerificationActivity84.this.currentSecretSalt;
                                    twoStepVerificationActivity84.passwordSetState = 4;
                                    TwoStepVerificationActivity84.this.presentFragment(twoStepVerificationActivity84);
                                }
                            });
                            Dialog dialogShowDialog = TwoStepVerificationActivity84.this.showDialog(builder.create());
                            if (dialogShowDialog != null) {
                                dialogShowDialog.setCanceledOnTouchOutside(false);
                                dialogShowDialog.setCancelable(false);
                                return;
                            }
                            return;
                        }
                        if (!tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                            TwoStepVerificationActivity84.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), error.text);
                            return;
                        }
                        int iIntValue = Utilities.parseInt(error.text).intValue();
                        if (iIntValue < 60) {
                            pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
                        } else {
                            pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
                        }
                        TwoStepVerificationActivity84.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNextPressed() {
        String code = getCode();
        if (TextUtils.isEmpty(code)) {
            return;
        }
        TLRPC$TL_twoStep_verifyCode tLRPC$TL_twoStep_verifyCode = new TLRPC$TL_twoStep_verifyCode();
        tLRPC$TL_twoStep_verifyCode.phone_code = code;
        tLRPC$TL_twoStep_verifyCode.phone_code_hash = this.phone_code_hash;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_twoStep_verifyCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity84$2E4g-MvB5QQLKNDUSr4PzdvJQjY
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$onNextPressed$3$TwoStepVerificationActivity84(tLObject, tLRPC$TL_error);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onNextPressed$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onNextPressed$3$TwoStepVerificationActivity84(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity84$42FCxrfeVN-7DOQQIk3H50ynn9k
            @Override // java.lang.Runnable
            public final void run() throws NoSuchAlgorithmException {
                this.f$0.lambda$onNextPressed$2$TwoStepVerificationActivity84(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onNextPressed$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onNextPressed$2$TwoStepVerificationActivity84(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) throws NoSuchAlgorithmException {
        if (tLRPC$TL_error == null) {
            destroyTimer();
            if (tLObject instanceof TLRPC$TL_boolTrue) {
                processDone();
                return;
            }
            return;
        }
        if (tLRPC$TL_error.text.contains("PHONE_CODE_EMPTY") || tLRPC$TL_error.text.contains("PHONE_CODE_INVALID")) {
            needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidCode", R.string.InvalidCode));
            int i = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                if (i < editTextBoldCursorArr.length) {
                    editTextBoldCursorArr[i].setText("");
                    i++;
                } else {
                    editTextBoldCursorArr[0].requestFocus();
                    return;
                }
            }
        } else {
            if (tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("CodeExpired", R.string.CodeExpired2));
                return;
            }
            if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("FloodWait", R.string.FloodWait));
                return;
            }
            needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + tLRPC$TL_error.text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needShowAlert(String title, String text) {
        if (text == null || getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(title);
        builder.setMessage(text);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCode() {
        if (this.codeField == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            if (i < editTextBoldCursorArr.length) {
                sb.append(PhoneFormat.stripExceptNumbers(editTextBoldCursorArr[i].getText().toString()));
                i++;
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTimer() {
        if (this.timeTimer != null) {
            return;
        }
        this.lastCurrentTime = System.currentTimeMillis();
        this.timeout *= 1000;
        Timer timer = new Timer();
        this.timeTimer = timer;
        timer.schedule(new AnonymousClass9(), 0L, 1000L);
    }

    /* renamed from: ir.eitaa.ui.TwoStepVerificationActivity84$9, reason: invalid class name */
    class AnonymousClass9 extends TimerTask {
        AnonymousClass9() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (TwoStepVerificationActivity84.this.timeTimer == null) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationActivity84$9$3zJY7H8SnjIBPoKxtiWyA66ZQDw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0$TwoStepVerificationActivity84$9();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$TwoStepVerificationActivity84$9() {
            double dCurrentTimeMillis = System.currentTimeMillis();
            double d = TwoStepVerificationActivity84.this.lastCurrentTime;
            Double.isNaN(dCurrentTimeMillis);
            TwoStepVerificationActivity84.this.lastCurrentTime = dCurrentTimeMillis;
            TwoStepVerificationActivity84.access$126(TwoStepVerificationActivity84.this, dCurrentTimeMillis - d);
            if (TwoStepVerificationActivity84.this.timeout >= 1000) {
                int i = (TwoStepVerificationActivity84.this.timeout / 1000) / 60;
                int i2 = (TwoStepVerificationActivity84.this.timeout / 1000) - (i * 60);
                TextView textView = TwoStepVerificationActivity84.this.timeText;
                StringBuilder sb = new StringBuilder();
                sb.append(LocaleController.formatString("CallAgainAvailableIn", R.string.CallAgainAvailableIn, Integer.valueOf(i), Integer.valueOf(i2)));
                sb.append(" ");
                sb.append(TwoStepVerificationActivity84.this.message != null ? TwoStepVerificationActivity84.this.message : "");
                textView.setText(sb.toString());
                TwoStepVerificationActivity84.this.timeText.setTextColor(TwoStepVerificationActivity84.this.oldColor);
                TwoStepVerificationActivity84.this.timeText.setClickable(false);
                return;
            }
            TwoStepVerificationActivity84.this.destroyTimer();
            TwoStepVerificationActivity84.this.timeText.setText(LocaleController.getString("ResendCode", R.string.ResendCode));
            TwoStepVerificationActivity84.this.timeText.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
            TwoStepVerificationActivity84.this.timeText.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyTimer() {
        try {
            synchronized (this.timerSync) {
                Timer timer = this.timeTimer;
                if (timer != null) {
                    timer.cancel();
                    this.timeTimer = null;
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.twoStepPasswordChanged) {
            if (args != null && args.length > 0 && args[0] != null) {
                this.currentPasswordHash = (byte[]) args[0];
                if (this.closeAfterSet && TextUtils.isEmpty((String) args[4]) && this.closeAfterSet) {
                    removeSelfFromStack();
                }
            }
            loadPasswordInfo(false);
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
        if (this.type == 1) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.10
                @Override // java.lang.Runnable
                public void run() {
                    if (TwoStepVerificationActivity84.this.passwordEditText != null) {
                        TwoStepVerificationActivity84.this.passwordEditText.requestFocus();
                        AndroidUtilities.showKeyboard(TwoStepVerificationActivity84.this.passwordEditText);
                    }
                }
            }, 200L);
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    public void setCloseAfterSet(boolean value) {
        this.closeAfterSet = value;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (isOpen && this.type == 1) {
            AndroidUtilities.showKeyboard(this.passwordEditText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPasswordInfo(final boolean silent) {
        if (!silent) {
            this.loading = true;
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyDataSetChanged();
            }
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword_layer84(), new AnonymousClass11(silent), 10);
    }

    /* renamed from: ir.eitaa.ui.TwoStepVerificationActivity84$11, reason: invalid class name */
    class AnonymousClass11 implements RequestDelegate {
        final /* synthetic */ boolean val$silent;

        AnonymousClass11(final boolean val$silent) {
            this.val$silent = val$silent;
        }

        @Override // ir.eitaa.tgnet.RequestDelegate
        public void run(final TLObject response, final TLRPC$TL_error error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.11.1
                @Override // java.lang.Runnable
                public void run() {
                    TwoStepVerificationActivity84.this.loading = false;
                    if (error == null) {
                        AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                        if (!anonymousClass11.val$silent) {
                            TwoStepVerificationActivity84 twoStepVerificationActivity84 = TwoStepVerificationActivity84.this;
                            twoStepVerificationActivity84.passwordEntered = twoStepVerificationActivity84.currentPassword != null || (response instanceof TLRPC$TL_account_noPassword);
                        }
                        TwoStepVerificationActivity84.this.currentPassword = (TLRPC$account_Password) response;
                        TwoStepVerificationActivity84 twoStepVerificationActivity842 = TwoStepVerificationActivity84.this;
                        twoStepVerificationActivity842.waitingForEmail = twoStepVerificationActivity842.currentPassword.email_unconfirmed_pattern.length() > 0;
                        byte[] bArr = new byte[TwoStepVerificationActivity84.this.currentPassword.new_salt.length + 8];
                        Utilities.random.nextBytes(bArr);
                        System.arraycopy(TwoStepVerificationActivity84.this.currentPassword.new_salt, 0, bArr, 0, TwoStepVerificationActivity84.this.currentPassword.new_salt.length);
                        TwoStepVerificationActivity84.this.currentPassword.new_salt = bArr;
                        if (!TwoStepVerificationActivity84.this.paused && TwoStepVerificationActivity84.this.closeAfterSet && (TwoStepVerificationActivity84.this.currentPassword instanceof TLRPC$TL_account_password_layer84)) {
                            byte[] bArr2 = TwoStepVerificationActivity84.this.currentPassword.current_salt;
                            byte[] bArr3 = TwoStepVerificationActivity84.this.currentPassword.new_secure_salt;
                            byte[] bArr4 = TwoStepVerificationActivity84.this.currentPassword.secure_random;
                            String str = TwoStepVerificationActivity84.this.currentPassword.has_recovery ? "1" : null;
                            String str2 = TwoStepVerificationActivity84.this.currentPassword.hint;
                            if (!TwoStepVerificationActivity84.this.waitingForEmail && bArr2 != null) {
                                NotificationCenter notificationCenter = NotificationCenter.getInstance(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount);
                                TwoStepVerificationActivity84 twoStepVerificationActivity843 = TwoStepVerificationActivity84.this;
                                int i = NotificationCenter.twoStepPasswordChanged;
                                notificationCenter.removeObserver(twoStepVerificationActivity843, i);
                                NotificationCenter.getInstance(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount).postNotificationName(i, null, bArr2, bArr3, bArr4, str, str2, null, null);
                                TwoStepVerificationActivity84.this.finishFragment();
                            }
                        }
                    }
                    if (TwoStepVerificationActivity84.this.type == 0 && !TwoStepVerificationActivity84.this.destroyed && TwoStepVerificationActivity84.this.shortPollRunnable == null) {
                        TwoStepVerificationActivity84.this.shortPollRunnable = new Runnable() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.11.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (TwoStepVerificationActivity84.this.shortPollRunnable == null) {
                                    return;
                                }
                                TwoStepVerificationActivity84.this.loadPasswordInfo(true);
                                TwoStepVerificationActivity84.this.shortPollRunnable = null;
                            }
                        };
                        AndroidUtilities.runOnUIThread(TwoStepVerificationActivity84.this.shortPollRunnable, 5000L);
                    }
                    TwoStepVerificationActivity84.this.updateRows();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPasswordSetState(int state) {
        if (this.passwordEditText == null) {
            return;
        }
        this.passwordSetState = state;
        if (state == 0) {
            this.actionBar.setTitle(LocaleController.getString("YourPassword", R.string.YourPassword));
            if (this.currentPassword instanceof TLRPC$TL_account_noPassword) {
                this.titleTextView.setText(LocaleController.getString("PleaseEnterFirstPassword", R.string.PleaseEnterFirstPassword));
            } else {
                this.titleTextView.setText(LocaleController.getString("PleaseEnterPassword", R.string.PleaseEnterPassword));
            }
            this.passwordEditText.setImeOptions(5);
            this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.bottomTextView.setVisibility(8);
            this.bottomButton.setVisibility(8);
            this.blackImageView.setVisibility(8);
            this.blueImageView.setVisibility(8);
            this.callTextView.setVisibility(8);
            this.codeFieldContainer.setVisibility(8);
            this.timeText.setVisibility(8);
        } else if (state == 1) {
            this.actionBar.setTitle(LocaleController.getString("YourPassword", R.string.YourPassword));
            this.titleTextView.setText(LocaleController.getString("PleaseReEnterPassword", R.string.PleaseReEnterPassword));
            this.passwordEditText.setImeOptions(5);
            this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.bottomTextView.setVisibility(8);
            this.bottomButton.setVisibility(8);
            this.blackImageView.setVisibility(8);
            this.blueImageView.setVisibility(8);
            this.callTextView.setVisibility(8);
            this.codeFieldContainer.setVisibility(8);
            this.timeText.setVisibility(8);
        } else if (state == 2) {
            this.actionBar.setTitle(LocaleController.getString("PasswordHint", R.string.PasswordHint));
            this.titleTextView.setText(LocaleController.getString("PasswordHintText", R.string.PasswordHintText));
            this.passwordEditText.setImeOptions(5);
            this.passwordEditText.setTransformationMethod(null);
            this.bottomTextView.setVisibility(8);
            this.bottomButton.setVisibility(8);
            this.blackImageView.setVisibility(8);
            this.blueImageView.setVisibility(8);
            this.callTextView.setVisibility(8);
            this.codeFieldContainer.setVisibility(8);
            this.timeText.setVisibility(8);
        } else if (state == 3) {
            this.actionBar.setTitle(LocaleController.getString("RecoveryEmail", R.string.RecoveryEmail));
            this.titleTextView.setText(LocaleController.getString("YourEmail", R.string.YourEmail));
            this.passwordEditText.setImeOptions(6);
            this.passwordEditText.setTransformationMethod(null);
            this.passwordEditText.setInputType(33);
            this.passwordEditText.setVisibility(0);
            this.bottomTextView.setVisibility(0);
            this.bottomButton.setVisibility(this.emailOnly ? 8 : 0);
            this.blackImageView.setVisibility(8);
            this.blueImageView.setVisibility(8);
            this.callTextView.setVisibility(8);
            this.codeFieldContainer.setVisibility(8);
            this.timeText.setVisibility(8);
            this.doneItem.setVisibility(0);
        } else if (state == 4) {
            this.actionBar.setTitle(LocaleController.getString("PasswordRecovery", R.string.PasswordRecovery));
            this.titleTextView.setText(LocaleController.getString("PasswordCode", R.string.PasswordCode));
            this.bottomTextView.setText(LocaleController.getString("RestoreEmailSentInfo", R.string.RestoreEmailSentInfo));
            this.bottomButton.setText(LocaleController.formatString("RestoreEmailTrouble", R.string.RestoreEmailTrouble, this.currentPassword.email_unconfirmed_pattern));
            this.passwordEditText.setImeOptions(6);
            this.passwordEditText.setTransformationMethod(null);
            this.passwordEditText.setInputType(3);
            this.bottomTextView.setVisibility(0);
            this.bottomButton.setVisibility(0);
            this.blackImageView.setVisibility(8);
            this.blueImageView.setVisibility(8);
            this.callTextView.setVisibility(8);
            this.codeFieldContainer.setVisibility(8);
            this.timeText.setVisibility(8);
        } else if (state == 5) {
            this.actionBar.setTitle(LocaleController.getString("VerificationCode", R.string.VerificationCode));
            this.titleTextView.setText(LocaleController.getString("SendCallcode", R.string.SendCallcode));
            this.oldColor = this.callTextView.getTextColors().getDefaultColor();
            this.callTextView.setText(LocaleController.getString("RequestCallButton", R.string.RequestCallButton));
            this.callTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
            this.callTextView.setClickable(true);
            this.callTextView.setVisibility(0);
            this.passwordEditText.setVisibility(8);
            this.bottomButton.setVisibility(8);
            this.blackImageView.setVisibility(8);
            this.blueImageView.setVisibility(8);
            this.codeFieldContainer.setVisibility(8);
            this.timeText.setVisibility(8);
            this.doneItem.setVisibility(8);
        } else if (state == 6) {
            this.actionBar.setTitle(LocaleController.getString("VerificationCode", R.string.VerificationCode));
            this.titleTextView.setText(LocaleController.getString("EnterCode", R.string.EnterCode));
            this.callTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("SentCallOnly", R.string.SentCallOnly, UserConfig.getInstance(this.currentAccount).getClientPhone())));
            this.callTextView.setTextColor(this.oldColor);
            this.callTextView.setClickable(false);
            this.codeFieldContainer.setVisibility(0);
            this.blackImageView.setVisibility(0);
            this.blueImageView.setVisibility(0);
            this.timeText.setVisibility(0);
            this.doneItem.setVisibility(8);
        }
        this.passwordEditText.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows() {
        TLRPC$account_Password tLRPC$account_Password;
        this.rowCount = 0;
        this.setPasswordRow = -1;
        this.setPasswordDetailRow = -1;
        this.changePasswordRow = -1;
        this.turnPasswordOffRow = -1;
        this.setRecoveryEmailRow = -1;
        this.changeRecoveryEmailRow = -1;
        this.abortPasswordRow = -1;
        this.passwordSetupDetailRow = -1;
        this.passwordEnabledDetailRow = -1;
        this.passwordEmailVerifyDetailRow = -1;
        this.shadowRow = -1;
        if (!this.loading && (tLRPC$account_Password = this.currentPassword) != null) {
            if (tLRPC$account_Password instanceof TLRPC$TL_account_noPassword) {
                if (this.waitingForEmail) {
                    int i = 0 + 1;
                    this.rowCount = i;
                    this.passwordSetupDetailRow = 0;
                    int i2 = i + 1;
                    this.rowCount = i2;
                    this.abortPasswordRow = i;
                    this.rowCount = i2 + 1;
                    this.shadowRow = i2;
                } else {
                    int i3 = 0 + 1;
                    this.rowCount = i3;
                    this.setPasswordRow = 0;
                    this.rowCount = i3 + 1;
                    this.setPasswordDetailRow = i3;
                }
            } else if (tLRPC$account_Password instanceof TLRPC$TL_account_password_layer84) {
                int i4 = 0 + 1;
                this.rowCount = i4;
                this.changePasswordRow = 0;
                int i5 = i4 + 1;
                this.rowCount = i5;
                this.turnPasswordOffRow = i4;
                if (tLRPC$account_Password.has_recovery) {
                    this.rowCount = i5 + 1;
                    this.changeRecoveryEmailRow = i5;
                } else {
                    this.rowCount = i5 + 1;
                    this.setRecoveryEmailRow = i5;
                }
                if (this.waitingForEmail) {
                    int i6 = this.rowCount;
                    this.rowCount = i6 + 1;
                    this.passwordEmailVerifyDetailRow = i6;
                } else {
                    int i7 = this.rowCount;
                    this.rowCount = i7 + 1;
                    this.passwordEnabledDetailRow = i7;
                }
            }
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        if (this.passwordEntered) {
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
                return;
            }
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
            this.titleTextView.setVisibility(0);
            this.bottomButton.setVisibility(0);
            this.bottomTextView.setVisibility(4);
            this.bottomButton.setText(LocaleController.getString("ForgotPassword", R.string.ForgotPassword));
            String str = this.currentPassword.hint;
            if (str != null && str.length() > 0) {
                this.passwordEditText.setHint(this.currentPassword.hint);
            } else {
                this.passwordEditText.setHint("");
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.12
                @Override // java.lang.Runnable
                public void run() {
                    if (TwoStepVerificationActivity84.this.isFinishing() || TwoStepVerificationActivity84.this.destroyed || TwoStepVerificationActivity84.this.passwordEditText == null) {
                        return;
                    }
                    TwoStepVerificationActivity84.this.passwordEditText.requestFocus();
                    AndroidUtilities.showKeyboard(TwoStepVerificationActivity84.this.passwordEditText);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needShowProgress() {
        if (getParentActivity() == null || getParentActivity().isFinishing() || this.progressDialog != null) {
            return;
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 1);
        this.progressDialog = alertDialog;
        alertDialog.setMessage(LocaleController.getString("Loading", R.string.Loading));
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    private boolean isValidEmail(String text) {
        if (text == null || text.length() < 3) {
            return false;
        }
        int iLastIndexOf = text.lastIndexOf(46);
        int iLastIndexOf2 = text.lastIndexOf(64);
        return iLastIndexOf >= 0 && iLastIndexOf2 >= 0 && iLastIndexOf >= iLastIndexOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertWithText(String title, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(title);
        builder.setMessage(text);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewPassword(final boolean clear) throws NoSuchAlgorithmException {
        TLRPC$TL_account_updatePasswordSettings_layer84 tLRPC$TL_account_updatePasswordSettings_layer84 = new TLRPC$TL_account_updatePasswordSettings_layer84();
        tLRPC$TL_account_updatePasswordSettings_layer84.current_password_hash = this.currentPasswordHash;
        tLRPC$TL_account_updatePasswordSettings_layer84.new_settings = new TLRPC$TL_account_passwordInputSettings_layer84();
        if (clear) {
            UserConfig.getInstance(this.currentAccount).resetSavedPassword();
            if (this.waitingForEmail && (this.currentPassword instanceof TLRPC$TL_account_noPassword)) {
                TLRPC$TL_account_passwordInputSettings_layer84 tLRPC$TL_account_passwordInputSettings_layer84 = tLRPC$TL_account_updatePasswordSettings_layer84.new_settings;
                tLRPC$TL_account_passwordInputSettings_layer84.flags = 2;
                tLRPC$TL_account_passwordInputSettings_layer84.email = "";
                tLRPC$TL_account_updatePasswordSettings_layer84.current_password_hash = new byte[0];
            } else {
                TLRPC$TL_account_passwordInputSettings_layer84 tLRPC$TL_account_passwordInputSettings_layer842 = tLRPC$TL_account_updatePasswordSettings_layer84.new_settings;
                tLRPC$TL_account_passwordInputSettings_layer842.flags = 3;
                tLRPC$TL_account_passwordInputSettings_layer842.hint = "";
                tLRPC$TL_account_passwordInputSettings_layer842.new_password_hash = new byte[0];
                tLRPC$TL_account_passwordInputSettings_layer842.new_salt = new byte[0];
                tLRPC$TL_account_passwordInputSettings_layer842.email = "";
            }
        } else {
            String str = this.firstPassword;
            if (str != null && str.length() > 0) {
                byte[] stringBytes = AndroidUtilities.getStringBytes(this.firstPassword);
                byte[] bArr = this.currentPassword.new_salt;
                int length = (bArr.length * 2) + stringBytes.length;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                System.arraycopy(stringBytes, 0, bArr2, bArr.length, stringBytes.length);
                System.arraycopy(bArr, 0, bArr2, length - bArr.length, bArr.length);
                TLRPC$TL_account_passwordInputSettings_layer84 tLRPC$TL_account_passwordInputSettings_layer843 = tLRPC$TL_account_updatePasswordSettings_layer84.new_settings;
                tLRPC$TL_account_passwordInputSettings_layer843.flags |= 1;
                tLRPC$TL_account_passwordInputSettings_layer843.hint = this.hint;
                tLRPC$TL_account_passwordInputSettings_layer843.new_password_hash = Utilities.computeSHA256(bArr2, 0, length);
                tLRPC$TL_account_updatePasswordSettings_layer84.new_settings.new_salt = bArr;
                byte[] bArr3 = this.currentSecret;
                if (bArr3 != null && bArr3.length == 32) {
                    byte[] bArr4 = this.currentSecretSalt;
                    byte[] bArrComputeSHA512 = Utilities.computeSHA512(bArr4, stringBytes, bArr4);
                    byte[] bArr5 = new byte[32];
                    System.arraycopy(bArrComputeSHA512, 0, bArr5, 0, 32);
                    byte[] bArr6 = new byte[16];
                    System.arraycopy(bArrComputeSHA512, 32, bArr6, 0, 16);
                    byte[] bArr7 = new byte[32];
                    System.arraycopy(this.currentSecret, 0, bArr7, 0, 32);
                    Utilities.aesCbcEncryptionByteArraySafe(bArr7, bArr5, bArr6, 0, 32, 0, 1);
                    TLRPC$TL_account_passwordInputSettings_layer84 tLRPC$TL_account_passwordInputSettings_layer844 = tLRPC$TL_account_updatePasswordSettings_layer84.new_settings;
                    tLRPC$TL_account_passwordInputSettings_layer844.new_secure_secret = bArr7;
                    tLRPC$TL_account_passwordInputSettings_layer844.new_secure_salt = this.currentSecretSalt;
                    tLRPC$TL_account_passwordInputSettings_layer844.new_secure_secret_id = this.currentSecretId;
                    tLRPC$TL_account_passwordInputSettings_layer844.flags |= 4;
                }
            }
            if (this.email.length() > 0) {
                TLRPC$TL_account_passwordInputSettings_layer84 tLRPC$TL_account_passwordInputSettings_layer845 = tLRPC$TL_account_updatePasswordSettings_layer84.new_settings;
                tLRPC$TL_account_passwordInputSettings_layer845.flags = 2 | tLRPC$TL_account_passwordInputSettings_layer845.flags;
                tLRPC$TL_account_passwordInputSettings_layer845.email = this.email.trim();
            }
        }
        needShowProgress();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_updatePasswordSettings_layer84, new AnonymousClass13(clear, tLRPC$TL_account_updatePasswordSettings_layer84), 10);
    }

    /* renamed from: ir.eitaa.ui.TwoStepVerificationActivity84$13, reason: invalid class name */
    class AnonymousClass13 implements RequestDelegate {
        final /* synthetic */ boolean val$clear;
        final /* synthetic */ TLRPC$TL_account_updatePasswordSettings_layer84 val$req;

        AnonymousClass13(final boolean val$clear, final TLRPC$TL_account_updatePasswordSettings_layer84 val$req) {
            this.val$clear = val$clear;
            this.val$req = val$req;
        }

        @Override // ir.eitaa.tgnet.RequestDelegate
        public void run(final TLObject response, final TLRPC$TL_error error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.13.1
                @Override // java.lang.Runnable
                public void run() {
                    String pluralString;
                    TwoStepVerificationActivity84.this.needHideProgress();
                    TLRPC$TL_error tLRPC$TL_error = error;
                    if (tLRPC$TL_error == null && (response instanceof TLRPC$TL_boolTrue)) {
                        AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                        if (anonymousClass13.val$clear) {
                            TwoStepVerificationActivity84.this.currentPassword = null;
                            TwoStepVerificationActivity84.this.currentPasswordHash = new byte[0];
                            TwoStepVerificationActivity84.this.loadPasswordInfo(false);
                            NotificationCenter.getInstance(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount).postNotificationName(NotificationCenter.didRemoveTwoStepPassword, new Object[0]);
                            TwoStepVerificationActivity84.this.updateRows();
                            return;
                        }
                        if (TwoStepVerificationActivity84.this.getParentActivity() == null) {
                            return;
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(TwoStepVerificationActivity84.this.getParentActivity());
                        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.13.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                NotificationCenter notificationCenter = NotificationCenter.getInstance(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount);
                                int i2 = NotificationCenter.twoStepPasswordChanged;
                                AnonymousClass13 anonymousClass132 = AnonymousClass13.this;
                                TLRPC$TL_account_passwordInputSettings_layer84 tLRPC$TL_account_passwordInputSettings_layer84 = anonymousClass132.val$req.new_settings;
                                notificationCenter.postNotificationName(i2, tLRPC$TL_account_passwordInputSettings_layer84.new_password_hash, tLRPC$TL_account_passwordInputSettings_layer84.new_salt, TwoStepVerificationActivity84.this.currentPassword.new_secure_salt, TwoStepVerificationActivity84.this.currentPassword.secure_random, TwoStepVerificationActivity84.this.email, TwoStepVerificationActivity84.this.hint, null, TwoStepVerificationActivity84.this.firstPassword);
                                TwoStepVerificationActivity84.this.finishFragment();
                            }
                        });
                        builder.setMessage(LocaleController.getString("YourPasswordSuccessText", R.string.YourPasswordSuccessText));
                        builder.setTitle(LocaleController.getString("YourPasswordSuccess", R.string.YourPasswordSuccess));
                        Dialog dialogShowDialog = TwoStepVerificationActivity84.this.showDialog(builder.create());
                        if (dialogShowDialog != null) {
                            dialogShowDialog.setCanceledOnTouchOutside(false);
                            dialogShowDialog.setCancelable(false);
                            return;
                        }
                        return;
                    }
                    if (tLRPC$TL_error != null) {
                        if (tLRPC$TL_error.text.equals("EMAIL_UNCONFIRMED")) {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(TwoStepVerificationActivity84.this.getParentActivity());
                            builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.13.1.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (TwoStepVerificationActivity84.this.closeAfterSet) {
                                        TwoStepVerificationActivity84 twoStepVerificationActivity84 = new TwoStepVerificationActivity84(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount, 0);
                                        twoStepVerificationActivity84.setCloseAfterSet(true);
                                        ((BaseFragment) TwoStepVerificationActivity84.this).parentLayout.addFragmentToStack(twoStepVerificationActivity84, ((BaseFragment) TwoStepVerificationActivity84.this).parentLayout.fragmentsStack.size() - 1);
                                    }
                                    NotificationCenter notificationCenter = NotificationCenter.getInstance(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount);
                                    int i2 = NotificationCenter.twoStepPasswordChanged;
                                    AnonymousClass13 anonymousClass132 = AnonymousClass13.this;
                                    TLRPC$TL_account_passwordInputSettings_layer84 tLRPC$TL_account_passwordInputSettings_layer84 = anonymousClass132.val$req.new_settings;
                                    notificationCenter.postNotificationName(i2, tLRPC$TL_account_passwordInputSettings_layer84.new_password_hash, tLRPC$TL_account_passwordInputSettings_layer84.new_salt, TwoStepVerificationActivity84.this.currentPassword.new_secure_salt, TwoStepVerificationActivity84.this.currentPassword.secure_random, TwoStepVerificationActivity84.this.email, TwoStepVerificationActivity84.this.hint, TwoStepVerificationActivity84.this.email, TwoStepVerificationActivity84.this.firstPassword);
                                    TwoStepVerificationActivity84.this.finishFragment();
                                }
                            });
                            builder2.setMessage(LocaleController.getString("YourEmailAlmostThereText", R.string.YourEmailAlmostThereText));
                            builder2.setTitle(LocaleController.getString("YourEmailAlmostThere", R.string.YourEmailAlmostThere));
                            Dialog dialogShowDialog2 = TwoStepVerificationActivity84.this.showDialog(builder2.create());
                            if (dialogShowDialog2 != null) {
                                dialogShowDialog2.setCanceledOnTouchOutside(false);
                                dialogShowDialog2.setCancelable(false);
                                return;
                            }
                            return;
                        }
                        if (error.text.equals("EMAIL_INVALID")) {
                            TwoStepVerificationActivity84.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("PasswordEmailInvalid", R.string.PasswordEmailInvalid));
                            return;
                        }
                        if (error.text.startsWith("FLOOD_WAIT")) {
                            int iIntValue = Utilities.parseInt(error.text).intValue();
                            if (iIntValue < 60) {
                                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
                            } else {
                                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
                            }
                            TwoStepVerificationActivity84.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
                            return;
                        }
                        if (error.text.equals("PHONE_CODE_EXPIRED")) {
                            TwoStepVerificationActivity84.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("CodeExpired", R.string.CodeExpired));
                            TwoStepVerificationActivity84.this.finishFragment();
                        } else if (error.text.equals("PHONE_CODE_INVALID")) {
                            TwoStepVerificationActivity84.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidCode", R.string.InvalidCode));
                            TwoStepVerificationActivity84.this.finishFragment();
                        } else {
                            TwoStepVerificationActivity84.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), error.text);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSecretValues(byte[] passwordBytes, TLRPC$TL_account_passwordSettings_layer84 passwordSettings) throws NoSuchAlgorithmException {
        byte[] bArr = passwordSettings.secure_secret;
        if (bArr.length == 32) {
            this.currentSecret = bArr;
            byte[] bArr2 = passwordSettings.secure_salt;
            this.currentSecretSalt = bArr2;
            this.currentSecretId = passwordSettings.secure_secret_id;
            byte[] bArrComputeSHA512 = Utilities.computeSHA512(bArr2, passwordBytes, bArr2);
            byte[] bArr3 = new byte[32];
            System.arraycopy(bArrComputeSHA512, 0, bArr3, 0, 32);
            byte[] bArr4 = new byte[16];
            System.arraycopy(bArrComputeSHA512, 32, bArr4, 0, 16);
            byte[] bArr5 = this.currentSecret;
            Utilities.aesCbcEncryptionByteArraySafe(bArr5, bArr3, bArr4, 0, bArr5.length, 0, 0);
            return;
        }
        this.currentSecret = null;
        this.currentSecretSalt = null;
        this.currentSecretId = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDone() throws NoSuchAlgorithmException {
        int i = this.type;
        if (i == 0) {
            if (this.passwordEntered) {
                return;
            }
            String string = this.passwordEditText.getText().toString();
            if (string.length() == 0) {
                onPasscodeError(false);
                return;
            }
            final byte[] stringBytes = AndroidUtilities.getStringBytes(string);
            needShowProgress();
            byte[] bArr = this.currentPassword.current_salt;
            int length = (bArr.length * 2) + stringBytes.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(stringBytes, 0, bArr2, this.currentPassword.current_salt.length, stringBytes.length);
            byte[] bArr3 = this.currentPassword.current_salt;
            System.arraycopy(bArr3, 0, bArr2, length - bArr3.length, bArr3.length);
            final TLRPC$TL_account_getPasswordSettings_layer84 tLRPC$TL_account_getPasswordSettings_layer84 = new TLRPC$TL_account_getPasswordSettings_layer84();
            tLRPC$TL_account_getPasswordSettings_layer84.current_password_hash = Utilities.computeSHA256(bArr2, 0, length);
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_getPasswordSettings_layer84, new RequestDelegate() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.14
                @Override // ir.eitaa.tgnet.RequestDelegate
                public void run(final TLObject response, final TLRPC$TL_error error) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.14.1
                        @Override // java.lang.Runnable
                        public void run() throws NoSuchAlgorithmException {
                            String pluralString;
                            TwoStepVerificationActivity84.this.needHideProgress();
                            TLRPC$TL_error tLRPC$TL_error = error;
                            if (tLRPC$TL_error == null) {
                                AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                TwoStepVerificationActivity84.this.checkSecretValues(stringBytes, (TLRPC$TL_account_passwordSettings_layer84) response);
                                AnonymousClass14 anonymousClass142 = AnonymousClass14.this;
                                TwoStepVerificationActivity84.this.currentPasswordHash = tLRPC$TL_account_getPasswordSettings_layer84.current_password_hash;
                                TwoStepVerificationActivity84.this.passwordEntered = true;
                                AndroidUtilities.hideKeyboard(TwoStepVerificationActivity84.this.passwordEditText);
                                TwoStepVerificationActivity84.this.updateRows();
                                return;
                            }
                            if (tLRPC$TL_error.text.equals("PASSWORD_HASH_INVALID")) {
                                TwoStepVerificationActivity84.this.onPasscodeError(true);
                                return;
                            }
                            if (!error.text.startsWith("FLOOD_WAIT")) {
                                TwoStepVerificationActivity84.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), error.text);
                                return;
                            }
                            int iIntValue = Utilities.parseInt(error.text).intValue();
                            if (iIntValue < 60) {
                                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
                            } else {
                                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
                            }
                            TwoStepVerificationActivity84.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
                        }
                    });
                }
            }, 10);
            return;
        }
        if (i == 1) {
            int i2 = this.passwordSetState;
            if (i2 == 0) {
                if (this.passwordEditText.getText().length() == 0) {
                    onPasscodeError(false);
                    return;
                }
                this.titleTextView.setText(LocaleController.getString("ReEnterYourPasscode", R.string.ReEnterYourPasscode));
                this.firstPassword = this.passwordEditText.getText().toString();
                setPasswordSetState(1);
                return;
            }
            if (i2 == 1) {
                if (!this.firstPassword.equals(this.passwordEditText.getText().toString())) {
                    try {
                        Toast.makeText(getParentActivity(), LocaleController.getString("PasswordDoNotMatch", R.string.PasswordDoNotMatch), 0).show();
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    onPasscodeError(true);
                    return;
                }
                setPasswordSetState(2);
                return;
            }
            if (i2 == 2) {
                String string2 = this.passwordEditText.getText().toString();
                this.hint = string2;
                if (string2.toLowerCase().equals(this.firstPassword.toLowerCase())) {
                    try {
                        Toast.makeText(getParentActivity(), LocaleController.getString("PasswordAsHintError", R.string.PasswordAsHintError), 0).show();
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                    onPasscodeError(false);
                    return;
                }
                if (!this.currentPassword.has_recovery) {
                    setPasswordSetState(5);
                    return;
                } else {
                    this.email = "";
                    setNewPassword(false);
                    return;
                }
            }
            if (i2 == 3) {
                String string3 = this.passwordEditText.getText().toString();
                this.email = string3;
                if (!isValidEmail(string3)) {
                    onPasscodeError(false);
                    return;
                } else {
                    setNewPassword(false);
                    return;
                }
            }
            if (i2 != 4) {
                if (i2 == 5) {
                    setPasswordSetState(6);
                    return;
                } else {
                    if (i2 == 6) {
                        setPasswordSetState(3);
                        return;
                    }
                    return;
                }
            }
            String string4 = this.passwordEditText.getText().toString();
            if (string4.length() == 0) {
                onPasscodeError(false);
                return;
            }
            TLRPC$TL_auth_recoverPassword_layer84 tLRPC$TL_auth_recoverPassword_layer84 = new TLRPC$TL_auth_recoverPassword_layer84();
            tLRPC$TL_auth_recoverPassword_layer84.code = string4;
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_auth_recoverPassword_layer84, new AnonymousClass15(), 10);
        }
    }

    /* renamed from: ir.eitaa.ui.TwoStepVerificationActivity84$15, reason: invalid class name */
    class AnonymousClass15 implements RequestDelegate {
        AnonymousClass15() {
        }

        @Override // ir.eitaa.tgnet.RequestDelegate
        public void run(TLObject response, final TLRPC$TL_error error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.15.1
                @Override // java.lang.Runnable
                public void run() {
                    String pluralString;
                    TLRPC$TL_error tLRPC$TL_error = error;
                    if (tLRPC$TL_error == null) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TwoStepVerificationActivity84.this.getParentActivity());
                        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.TwoStepVerificationActivity84.15.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                NotificationCenter.getInstance(((BaseFragment) TwoStepVerificationActivity84.this).currentAccount).postNotificationName(NotificationCenter.twoStepPasswordChanged, new Object[0]);
                                TwoStepVerificationActivity84.this.finishFragment();
                            }
                        });
                        builder.setMessage(LocaleController.getString("PasswordReset", R.string.PasswordReset));
                        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                        Dialog dialogShowDialog = TwoStepVerificationActivity84.this.showDialog(builder.create());
                        if (dialogShowDialog != null) {
                            dialogShowDialog.setCanceledOnTouchOutside(false);
                            dialogShowDialog.setCancelable(false);
                            return;
                        }
                        return;
                    }
                    if (tLRPC$TL_error.text.startsWith("CODE_INVALID")) {
                        TwoStepVerificationActivity84.this.onPasscodeError(true);
                        return;
                    }
                    if (!error.text.startsWith("FLOOD_WAIT")) {
                        TwoStepVerificationActivity84.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), error.text);
                        return;
                    }
                    int iIntValue = Utilities.parseInt(error.text).intValue();
                    if (iIntValue < 60) {
                        pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
                    } else {
                        pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
                    }
                    TwoStepVerificationActivity84.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPasscodeError(boolean clear) {
        if (getParentActivity() == null) {
            return;
        }
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        if (clear) {
            this.passwordEditText.setText("");
        }
        AndroidUtilities.shakeView(this.titleTextView, 2.0f, 0);
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            return (adapterPosition == TwoStepVerificationActivity84.this.setPasswordDetailRow || adapterPosition == TwoStepVerificationActivity84.this.shadowRow || adapterPosition == TwoStepVerificationActivity84.this.passwordSetupDetailRow || adapterPosition == TwoStepVerificationActivity84.this.passwordEmailVerifyDetailRow || adapterPosition == TwoStepVerificationActivity84.this.passwordEnabledDetailRow) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (TwoStepVerificationActivity84.this.loading || TwoStepVerificationActivity84.this.currentPassword == null) {
                return 0;
            }
            return TwoStepVerificationActivity84.this.rowCount;
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
                if (position != TwoStepVerificationActivity84.this.setPasswordDetailRow) {
                    if (position != TwoStepVerificationActivity84.this.shadowRow) {
                        if (position != TwoStepVerificationActivity84.this.passwordSetupDetailRow) {
                            if (position != TwoStepVerificationActivity84.this.passwordEnabledDetailRow) {
                                if (position == TwoStepVerificationActivity84.this.passwordEmailVerifyDetailRow) {
                                    textInfoPrivacyCell.setText(LocaleController.formatString("PendingEmailText", R.string.PendingEmailText, TwoStepVerificationActivity84.this.currentPassword.email_unconfirmed_pattern));
                                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                                    return;
                                }
                                return;
                            }
                            textInfoPrivacyCell.setText(LocaleController.getString("EnabledPasswordText", R.string.EnabledPasswordText));
                            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                            return;
                        }
                        textInfoPrivacyCell.setText(LocaleController.formatString("EmailPasswordConfirmText", R.string.EmailPasswordConfirmText, TwoStepVerificationActivity84.this.currentPassword.email_unconfirmed_pattern));
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_top, "windowBackgroundGrayShadow"));
                        return;
                    }
                    textInfoPrivacyCell.setText("");
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                }
                textInfoPrivacyCell.setText(LocaleController.getString("SetAdditionalPasswordInfo", R.string.SetAdditionalPasswordInfo));
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                return;
            }
            TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
            textSettingsCell.setTag("windowBackgroundWhiteBlackText");
            textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            if (position != TwoStepVerificationActivity84.this.changePasswordRow) {
                if (position != TwoStepVerificationActivity84.this.setPasswordRow) {
                    if (position != TwoStepVerificationActivity84.this.turnPasswordOffRow) {
                        if (position == TwoStepVerificationActivity84.this.changeRecoveryEmailRow) {
                            textSettingsCell.setText(LocaleController.getString("ChangeRecoveryEmail", R.string.ChangeRecoveryEmail), TwoStepVerificationActivity84.this.abortPasswordRow != -1);
                            return;
                        }
                        if (position != TwoStepVerificationActivity84.this.setRecoveryEmailRow) {
                            if (position == TwoStepVerificationActivity84.this.abortPasswordRow) {
                                textSettingsCell.setTag("windowBackgroundWhiteRedText3");
                                textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText3"));
                                textSettingsCell.setText(LocaleController.getString("AbortPassword", R.string.AbortPassword), false);
                                return;
                            }
                            return;
                        }
                        textSettingsCell.setText(LocaleController.getString("SetRecoveryEmail", R.string.SetRecoveryEmail), false);
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
            return (position == TwoStepVerificationActivity84.this.setPasswordDetailRow || position == TwoStepVerificationActivity84.this.shadowRow || position == TwoStepVerificationActivity84.this.passwordSetupDetailRow || position == TwoStepVerificationActivity84.this.passwordEnabledDetailRow || position == TwoStepVerificationActivity84.this.passwordEmailVerifyDetailRow) ? 1 : 0;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
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
