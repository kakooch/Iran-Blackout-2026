package ir.eitaa.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_account_authorizationForm;
import ir.eitaa.tgnet.TLRPC$TL_account_getAuthorizationForm;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_password;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.ui.ActionBar.ActionBarLayout;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.DrawerLayoutContainer;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.PasscodeView;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ExternalActionActivity extends Activity implements ActionBarLayout.ActionBarLayoutDelegate {
    protected ActionBarLayout actionBarLayout;
    protected SizeNotifierFrameLayout backgroundTablet;
    protected DrawerLayoutContainer drawerLayoutContainer;
    private boolean finished;
    protected ActionBarLayout layersActionBarLayout;
    private Runnable lockRunnable;
    private Intent passcodeSaveIntent;
    private int passcodeSaveIntentAccount;
    private boolean passcodeSaveIntentIsNew;
    private boolean passcodeSaveIntentIsRestore;
    private int passcodeSaveIntentState;
    private PasscodeView passcodeView;
    private static ArrayList<BaseFragment> mainFragmentsStack = new ArrayList<>();
    private static ArrayList<BaseFragment> layerFragmentsStack = new ArrayList<>();

    static /* synthetic */ void lambda$onCreate$1(View view) {
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean needAddFragmentToStack(BaseFragment fragment, ActionBarLayout layout) {
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean needPresentFragment(BaseFragment fragment, boolean removeLast, boolean forceWithoutAnimation, ActionBarLayout layout) {
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean onPreIme() {
        return false;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException {
        ApplicationLoader.postInitApplication();
        requestWindowFeature(1);
        setTheme(R.style.Theme_TMessages);
        getWindow().setBackgroundDrawableResource(R.drawable.transparent);
        if (SharedConfig.passcodeHash.length() > 0 && !SharedConfig.allowScreenCapture) {
            try {
                getWindow().setFlags(8192, 8192);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        super.onCreate(savedInstanceState);
        if (SharedConfig.passcodeHash.length() != 0 && SharedConfig.appLocked) {
            SharedConfig.lastPauseTime = (int) (SystemClock.elapsedRealtime() / 1000);
        }
        AndroidUtilities.fillStatusBarHeight(this);
        Theme.createDialogsResources(this);
        Theme.createChatResources(this, false);
        this.actionBarLayout = new ActionBarLayout(this);
        DrawerLayoutContainer drawerLayoutContainer = new DrawerLayoutContainer(this);
        this.drawerLayoutContainer = drawerLayoutContainer;
        drawerLayoutContainer.setAllowOpenDrawer(false, false);
        setContentView(this.drawerLayoutContainer, new ViewGroup.LayoutParams(-1, -1));
        if (AndroidUtilities.isTablet()) {
            getWindow().setSoftInputMode(16);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.drawerLayoutContainer.addView(relativeLayout);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            relativeLayout.setLayoutParams(layoutParams);
            SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(this) { // from class: ir.eitaa.ui.ExternalActionActivity.1
                @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout
                protected boolean isActionBarVisible() {
                    return false;
                }
            };
            this.backgroundTablet = sizeNotifierFrameLayout;
            sizeNotifierFrameLayout.setOccupyStatusBar(false);
            this.backgroundTablet.setBackgroundImage(Theme.getCachedWallpaper(), Theme.isWallpaperMotion());
            relativeLayout.addView(this.backgroundTablet, LayoutHelper.createRelative(-1, -1));
            relativeLayout.addView(this.actionBarLayout, LayoutHelper.createRelative(-1, -1));
            FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.setBackgroundColor(2130706432);
            relativeLayout.addView(frameLayout, LayoutHelper.createRelative(-1, -1));
            frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$ExternalActionActivity$_1gdZtscet8kVt_Id2wISdw9Dco
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f$0.lambda$onCreate$0$ExternalActionActivity(view, motionEvent);
                }
            });
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ExternalActionActivity$pJcxyybO7nvYmiYss-Zl1elmhDE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExternalActionActivity.lambda$onCreate$1(view);
                }
            });
            ActionBarLayout actionBarLayout = new ActionBarLayout(this);
            this.layersActionBarLayout = actionBarLayout;
            actionBarLayout.setRemoveActionBarExtraHeight(true);
            this.layersActionBarLayout.setBackgroundView(frameLayout);
            this.layersActionBarLayout.setUseAlphaAnimations(true);
            this.layersActionBarLayout.setBackgroundResource(R.drawable.boxshadow);
            relativeLayout.addView(this.layersActionBarLayout, LayoutHelper.createRelative(530, AndroidUtilities.isSmallTablet() ? 528 : 700));
            this.layersActionBarLayout.init(layerFragmentsStack);
            this.layersActionBarLayout.setDelegate(this);
            this.layersActionBarLayout.setDrawerLayoutContainer(this.drawerLayoutContainer);
        } else {
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            this.drawerLayoutContainer.addView(relativeLayout2, LayoutHelper.createFrame(-1, -1.0f));
            SizeNotifierFrameLayout sizeNotifierFrameLayout2 = new SizeNotifierFrameLayout(this) { // from class: ir.eitaa.ui.ExternalActionActivity.2
                @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout
                protected boolean isActionBarVisible() {
                    return false;
                }
            };
            this.backgroundTablet = sizeNotifierFrameLayout2;
            sizeNotifierFrameLayout2.setOccupyStatusBar(false);
            this.backgroundTablet.setBackgroundImage(Theme.getCachedWallpaper(), Theme.isWallpaperMotion());
            relativeLayout2.addView(this.backgroundTablet, LayoutHelper.createRelative(-1, -1));
            relativeLayout2.addView(this.actionBarLayout, LayoutHelper.createRelative(-1, -1));
        }
        this.drawerLayoutContainer.setParentActionBarLayout(this.actionBarLayout);
        this.actionBarLayout.setDrawerLayoutContainer(this.drawerLayoutContainer);
        this.actionBarLayout.init(mainFragmentsStack);
        this.actionBarLayout.setDelegate(this);
        PasscodeView passcodeView = new PasscodeView(this);
        this.passcodeView = passcodeView;
        this.drawerLayoutContainer.addView(passcodeView, LayoutHelper.createFrame(-1, -1.0f));
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.closeOtherAppActivities, this);
        this.actionBarLayout.removeAllFragments();
        ActionBarLayout actionBarLayout2 = this.layersActionBarLayout;
        if (actionBarLayout2 != null) {
            actionBarLayout2.removeAllFragments();
        }
        handleIntent(getIntent(), false, savedInstanceState != null, false, UserConfig.selectedAccount, 0);
        needLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$onCreate$0$ExternalActionActivity(View view, MotionEvent motionEvent) {
        if (!this.actionBarLayout.fragmentsStack.isEmpty() && motionEvent.getAction() == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int[] iArr = new int[2];
            this.layersActionBarLayout.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            if (!this.layersActionBarLayout.checkTransitionAnimation() && (x <= i || x >= i + this.layersActionBarLayout.getWidth() || y <= i2 || y >= i2 + this.layersActionBarLayout.getHeight())) {
                if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                    while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                        ActionBarLayout actionBarLayout = this.layersActionBarLayout;
                        actionBarLayout.removeFragmentFromStack(actionBarLayout.fragmentsStack.get(0));
                    }
                    this.layersActionBarLayout.closeLastFragment(true);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPasscodeActivity() {
        if (this.passcodeView == null) {
            return;
        }
        SharedConfig.appLocked = true;
        if (SecretMediaViewer.hasInstance() && SecretMediaViewer.getInstance().isVisible()) {
            SecretMediaViewer.getInstance().closePhoto(false, false);
        } else if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
            PhotoViewer.getInstance().closePhoto(false, true);
        } else if (ArticleViewer.hasInstance() && ArticleViewer.getInstance().isVisible()) {
            ArticleViewer.getInstance().close(false, true);
        }
        this.passcodeView.onShow(true, false);
        SharedConfig.isWaitingForPasscodeEnter = true;
        this.drawerLayoutContainer.setAllowOpenDrawer(false, false);
        this.passcodeView.setDelegate(new PasscodeView.PasscodeViewDelegate() { // from class: ir.eitaa.ui.ExternalActionActivity.3
            @Override // ir.eitaa.ui.Components.PasscodeView.PasscodeViewDelegate
            public void onFinish() {
            }

            @Override // ir.eitaa.ui.Components.PasscodeView.PasscodeViewDelegate
            public void didAcceptedPassword() {
                SharedConfig.isWaitingForPasscodeEnter = false;
                if (ExternalActionActivity.this.passcodeSaveIntent != null) {
                    ExternalActionActivity externalActionActivity = ExternalActionActivity.this;
                    externalActionActivity.handleIntent(externalActionActivity.passcodeSaveIntent, ExternalActionActivity.this.passcodeSaveIntentIsNew, ExternalActionActivity.this.passcodeSaveIntentIsRestore, true, ExternalActionActivity.this.passcodeSaveIntentAccount, ExternalActionActivity.this.passcodeSaveIntentState);
                    ExternalActionActivity.this.passcodeSaveIntent = null;
                }
                ExternalActionActivity.this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
                ExternalActionActivity.this.actionBarLayout.showLastFragment();
                if (AndroidUtilities.isTablet()) {
                    ExternalActionActivity.this.layersActionBarLayout.showLastFragment();
                }
            }
        });
    }

    public void onFinishLogin() {
        handleIntent(this.passcodeSaveIntent, this.passcodeSaveIntentIsNew, this.passcodeSaveIntentIsRestore, true, this.passcodeSaveIntentAccount, this.passcodeSaveIntentState);
        this.actionBarLayout.removeAllFragments();
        ActionBarLayout actionBarLayout = this.layersActionBarLayout;
        if (actionBarLayout != null) {
            actionBarLayout.removeAllFragments();
        }
        SizeNotifierFrameLayout sizeNotifierFrameLayout = this.backgroundTablet;
        if (sizeNotifierFrameLayout != null) {
            sizeNotifierFrameLayout.setVisibility(0);
        }
    }

    protected boolean checkPasscode(final Intent intent, final boolean isNew, final boolean restore, final boolean fromPassword, final int intentAccount, int state) {
        if (fromPassword || !(AndroidUtilities.needShowPasscode(true) || SharedConfig.isWaitingForPasscodeEnter)) {
            return true;
        }
        showPasscodeActivity();
        this.passcodeSaveIntent = intent;
        this.passcodeSaveIntentIsNew = isNew;
        this.passcodeSaveIntentIsRestore = restore;
        this.passcodeSaveIntentAccount = intentAccount;
        this.passcodeSaveIntentState = state;
        UserConfig.getInstance(intentAccount).saveConfig(false);
        return false;
    }

    protected boolean handleIntent(final Intent intent, final boolean isNew, final boolean restore, final boolean fromPassword, final int intentAccount, int state) {
        if (!checkPasscode(intent, isNew, restore, fromPassword, intentAccount, state)) {
            return false;
        }
        if ("ir.eitaa.passport.AUTHORIZE".equals(intent.getAction())) {
            if (state == 0) {
                int activatedAccountsCount = UserConfig.getActivatedAccountsCount();
                if (activatedAccountsCount == 0) {
                    this.passcodeSaveIntent = intent;
                    this.passcodeSaveIntentIsNew = isNew;
                    this.passcodeSaveIntentIsRestore = restore;
                    this.passcodeSaveIntentAccount = intentAccount;
                    this.passcodeSaveIntentState = state;
                    LoginActivity loginActivity = new LoginActivity();
                    if (AndroidUtilities.isTablet()) {
                        this.layersActionBarLayout.addFragmentToStack(loginActivity);
                    } else {
                        this.actionBarLayout.addFragmentToStack(loginActivity);
                    }
                    if (!AndroidUtilities.isTablet()) {
                        this.backgroundTablet.setVisibility(8);
                    }
                    this.actionBarLayout.showLastFragment();
                    if (AndroidUtilities.isTablet()) {
                        this.layersActionBarLayout.showLastFragment();
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                    builder.setMessage(LocaleController.getString("PleaseLoginPassport", R.string.PleaseLoginPassport));
                    builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                    builder.show();
                    return true;
                }
                if (activatedAccountsCount >= 2) {
                    AlertDialog alertDialogCreateAccountSelectDialog = AlertsCreator.createAccountSelectDialog(this, new AlertsCreator.AccountSelectDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ExternalActionActivity$MLk4eS_jWUsoG6HUsF6ZLC_CSzM
                        @Override // ir.eitaa.ui.Components.AlertsCreator.AccountSelectDelegate
                        public final void didSelectAccount(int i) throws InterruptedException, IOException {
                            this.f$0.lambda$handleIntent$2$ExternalActionActivity(intentAccount, intent, isNew, restore, fromPassword, i);
                        }
                    });
                    alertDialogCreateAccountSelectDialog.show();
                    alertDialogCreateAccountSelectDialog.setCanceledOnTouchOutside(false);
                    alertDialogCreateAccountSelectDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$ExternalActionActivity$BASHZzB6VQhmUQm88t_sI5dkKMU
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            this.f$0.lambda$handleIntent$3$ExternalActionActivity(dialogInterface);
                        }
                    });
                    return true;
                }
            }
            long longExtra = intent.getLongExtra("bot_id", intent.getIntExtra("bot_id", 0));
            final String stringExtra = intent.getStringExtra("nonce");
            final String stringExtra2 = intent.getStringExtra("payload");
            final TLRPC$TL_account_getAuthorizationForm tLRPC$TL_account_getAuthorizationForm = new TLRPC$TL_account_getAuthorizationForm();
            tLRPC$TL_account_getAuthorizationForm.bot_id = longExtra;
            tLRPC$TL_account_getAuthorizationForm.scope = intent.getStringExtra("scope");
            tLRPC$TL_account_getAuthorizationForm.public_key = intent.getStringExtra("public_key");
            if (longExtra == 0 || ((TextUtils.isEmpty(stringExtra2) && TextUtils.isEmpty(stringExtra)) || TextUtils.isEmpty(tLRPC$TL_account_getAuthorizationForm.scope) || TextUtils.isEmpty(tLRPC$TL_account_getAuthorizationForm.public_key))) {
                finish();
                return false;
            }
            final int[] iArr = {0};
            final AlertDialog alertDialog = new AlertDialog(this, 3);
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ExternalActionActivity$J1JRF_JakiU1DCnCGuCayKj_ioA
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    int i = intentAccount;
                    int[] iArr2 = iArr;
                    ConnectionsManager.getInstance(i).cancelRequest(iArr2[0], true);
                }
            });
            alertDialog.show();
            iArr[0] = ConnectionsManager.getInstance(intentAccount).sendRequest(tLRPC$TL_account_getAuthorizationForm, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ExternalActionActivity$hb6esXAkf7xQvGvWL_1OxZ6BGDw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$handleIntent$9$ExternalActionActivity(iArr, intentAccount, alertDialog, tLRPC$TL_account_getAuthorizationForm, stringExtra2, stringExtra, tLObject, tLRPC$TL_error);
                }
            }, 10);
        } else {
            if (AndroidUtilities.isTablet()) {
                if (this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                    this.layersActionBarLayout.addFragmentToStack(new CacheControlActivity());
                }
            } else if (this.actionBarLayout.fragmentsStack.isEmpty()) {
                this.actionBarLayout.addFragmentToStack(new CacheControlActivity());
            }
            if (!AndroidUtilities.isTablet()) {
                this.backgroundTablet.setVisibility(8);
            }
            this.actionBarLayout.showLastFragment();
            if (AndroidUtilities.isTablet()) {
                this.layersActionBarLayout.showLastFragment();
            }
            intent.setAction(null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$2$ExternalActionActivity(int i, Intent intent, boolean z, boolean z2, boolean z3, int i2) throws InterruptedException, IOException {
        if (i2 != i) {
            switchToAccount(i2);
        }
        handleIntent(intent, z, z2, z3, i2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$3$ExternalActionActivity(DialogInterface dialogInterface) {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$9$ExternalActionActivity(int[] iArr, final int i, final AlertDialog alertDialog, final TLRPC$TL_account_getAuthorizationForm tLRPC$TL_account_getAuthorizationForm, final String str, final String str2, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        final TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm = (TLRPC$TL_account_authorizationForm) tLObject;
        if (tLRPC$TL_account_authorizationForm != null) {
            iArr[0] = ConnectionsManager.getInstance(i).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ExternalActionActivity$XgdUkbZzFAHCQzzy4k3neNxBZsU
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$handleIntent$6$ExternalActionActivity(alertDialog, i, tLRPC$TL_account_authorizationForm, tLRPC$TL_account_getAuthorizationForm, str, str2, tLObject2, tLRPC$TL_error2);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ExternalActionActivity$9lF8aIGm4vr5RKcpOSc3LQCese0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleIntent$8$ExternalActionActivity(alertDialog, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$6$ExternalActionActivity(final AlertDialog alertDialog, final int i, final TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm, final TLRPC$TL_account_getAuthorizationForm tLRPC$TL_account_getAuthorizationForm, final String str, final String str2, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ExternalActionActivity$G-jwvmIsROt_dWKhyJsubNVIs_w
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleIntent$5$ExternalActionActivity(alertDialog, tLObject, i, tLRPC$TL_account_authorizationForm, tLRPC$TL_account_getAuthorizationForm, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$5$ExternalActionActivity(AlertDialog alertDialog, TLObject tLObject, int i, TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm, TLRPC$TL_account_getAuthorizationForm tLRPC$TL_account_getAuthorizationForm, String str, String str2) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLObject != null) {
            MessagesController.getInstance(i).putUsers(tLRPC$TL_account_authorizationForm.users, false);
            PassportActivity passportActivity = new PassportActivity(5, tLRPC$TL_account_getAuthorizationForm.bot_id, tLRPC$TL_account_getAuthorizationForm.scope, tLRPC$TL_account_getAuthorizationForm.public_key, str, str2, (String) null, tLRPC$TL_account_authorizationForm, (TLRPC$TL_account_password) tLObject);
            passportActivity.setNeedActivityResult(true);
            if (AndroidUtilities.isTablet()) {
                this.layersActionBarLayout.addFragmentToStack(passportActivity);
            } else {
                this.actionBarLayout.addFragmentToStack(passportActivity);
            }
            if (!AndroidUtilities.isTablet()) {
                this.backgroundTablet.setVisibility(8);
            }
            this.actionBarLayout.showLastFragment();
            if (AndroidUtilities.isTablet()) {
                this.layersActionBarLayout.showLastFragment();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$8$ExternalActionActivity(AlertDialog alertDialog, final TLRPC$TL_error tLRPC$TL_error) {
        try {
            alertDialog.dismiss();
            if ("APP_VERSION_OUTDATED".equals(tLRPC$TL_error.text)) {
                AlertDialog alertDialogShowUpdateAppAlert = AlertsCreator.showUpdateAppAlert(this, LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
                if (alertDialogShowUpdateAppAlert != null) {
                    alertDialogShowUpdateAppAlert.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$ExternalActionActivity$CaORdasXzXKNhEldaAd5gaL5P8o
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            this.f$0.lambda$handleIntent$7$ExternalActionActivity(tLRPC$TL_error, dialogInterface);
                        }
                    });
                } else {
                    setResult(1, new Intent().putExtra("error", tLRPC$TL_error.text));
                    finish();
                }
            } else if ("BOT_INVALID".equals(tLRPC$TL_error.text) || "PUBLIC_KEY_REQUIRED".equals(tLRPC$TL_error.text) || "PUBLIC_KEY_INVALID".equals(tLRPC$TL_error.text) || "SCOPE_EMPTY".equals(tLRPC$TL_error.text) || "PAYLOAD_EMPTY".equals(tLRPC$TL_error.text)) {
                setResult(1, new Intent().putExtra("error", tLRPC$TL_error.text));
                finish();
            } else {
                setResult(0);
                finish();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$7$ExternalActionActivity(TLRPC$TL_error tLRPC$TL_error, DialogInterface dialogInterface) {
        setResult(1, new Intent().putExtra("error", tLRPC$TL_error.text));
        finish();
    }

    public void switchToAccount(int account) throws InterruptedException, IOException {
        int i = UserConfig.selectedAccount;
        if (account == i) {
            return;
        }
        ConnectionsManager.getInstance(i).setAppPaused(true, false);
        UserConfig.selectedAccount = account;
        UserConfig.getInstance(0).saveConfig(false);
        if (ApplicationLoader.mainInterfacePaused) {
            return;
        }
        ConnectionsManager.getInstance(UserConfig.selectedAccount).setAppPaused(false, false);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent, true, false, false, UserConfig.selectedAccount, 0);
    }

    private void onFinish() {
        if (this.finished) {
            return;
        }
        Runnable runnable = this.lockRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.lockRunnable = null;
        }
        this.finished = true;
    }

    public void needLayout() {
        if (AndroidUtilities.isTablet()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.layersActionBarLayout.getLayoutParams();
            layoutParams.leftMargin = (AndroidUtilities.displaySize.x - layoutParams.width) / 2;
            int i = Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0;
            layoutParams.topMargin = i + (((AndroidUtilities.displaySize.y - layoutParams.height) - i) / 2);
            this.layersActionBarLayout.setLayoutParams(layoutParams);
            if (!AndroidUtilities.isSmallTablet() || getResources().getConfiguration().orientation == 2) {
                int iDp = (AndroidUtilities.displaySize.x / 100) * 35;
                if (iDp < AndroidUtilities.dp(320.0f)) {
                    iDp = AndroidUtilities.dp(320.0f);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.actionBarLayout.getLayoutParams();
                layoutParams2.width = iDp;
                layoutParams2.height = -1;
                this.actionBarLayout.setLayoutParams(layoutParams2);
                if (AndroidUtilities.isSmallTablet() && this.actionBarLayout.fragmentsStack.size() == 2) {
                    this.actionBarLayout.fragmentsStack.get(1).onPause();
                    this.actionBarLayout.fragmentsStack.remove(1);
                    this.actionBarLayout.showLastFragment();
                    return;
                }
                return;
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.actionBarLayout.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            this.actionBarLayout.setLayoutParams(layoutParams3);
        }
    }

    public void fixLayout() {
        ActionBarLayout actionBarLayout;
        if (AndroidUtilities.isTablet() && (actionBarLayout = this.actionBarLayout) != null) {
            actionBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.eitaa.ui.ExternalActionActivity.4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ExternalActionActivity.this.needLayout();
                    ActionBarLayout actionBarLayout2 = ExternalActionActivity.this.actionBarLayout;
                    if (actionBarLayout2 != null) {
                        actionBarLayout2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.actionBarLayout.onPause();
        if (AndroidUtilities.isTablet()) {
            this.layersActionBarLayout.onPause();
        }
        ApplicationLoader.externalInterfacePaused = true;
        onPasscodePause();
        PasscodeView passcodeView = this.passcodeView;
        if (passcodeView != null) {
            passcodeView.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        onFinish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.actionBarLayout.onResume();
        if (AndroidUtilities.isTablet()) {
            this.layersActionBarLayout.onResume();
        }
        ApplicationLoader.externalInterfacePaused = false;
        onPasscodeResume();
        if (this.passcodeView.getVisibility() != 0) {
            this.actionBarLayout.onResume();
            if (AndroidUtilities.isTablet()) {
                this.layersActionBarLayout.onResume();
                return;
            }
            return;
        }
        this.actionBarLayout.dismissDialogs();
        if (AndroidUtilities.isTablet()) {
            this.layersActionBarLayout.dismissDialogs();
        }
        this.passcodeView.onResume();
    }

    private void onPasscodePause() {
        Runnable runnable = this.lockRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.lockRunnable = null;
        }
        if (SharedConfig.passcodeHash.length() != 0) {
            SharedConfig.lastPauseTime = (int) (SystemClock.elapsedRealtime() / 1000);
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.ExternalActionActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    if (ExternalActionActivity.this.lockRunnable == this) {
                        if (AndroidUtilities.needShowPasscode(true)) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("lock app");
                            }
                            ExternalActionActivity.this.showPasscodeActivity();
                        } else if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("didn't pass lock check");
                        }
                        ExternalActionActivity.this.lockRunnable = null;
                    }
                }
            };
            this.lockRunnable = runnable2;
            if (SharedConfig.appLocked) {
                AndroidUtilities.runOnUIThread(runnable2, 1000L);
            } else {
                int i = SharedConfig.autoLockIn;
                if (i != 0) {
                    AndroidUtilities.runOnUIThread(runnable2, (i * 1000) + 1000);
                }
            }
        } else {
            SharedConfig.lastPauseTime = 0;
        }
        SharedConfig.saveConfig();
    }

    private void onPasscodeResume() {
        Runnable runnable = this.lockRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.lockRunnable = null;
        }
        if (AndroidUtilities.needShowPasscode(true)) {
            showPasscodeActivity();
        }
        if (SharedConfig.lastPauseTime != 0) {
            SharedConfig.lastPauseTime = 0;
            SharedConfig.saveConfig();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AndroidUtilities.checkDisplaySize(this, newConfig);
        super.onConfigurationChanged(newConfig);
        fixLayout();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.passcodeView.getVisibility() == 0) {
            finish();
            return;
        }
        if (PhotoViewer.getInstance().isVisible()) {
            PhotoViewer.getInstance().closePhoto(true, false);
            return;
        }
        if (this.drawerLayoutContainer.isDrawerOpened()) {
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (AndroidUtilities.isTablet()) {
            if (this.layersActionBarLayout.getVisibility() == 0) {
                this.layersActionBarLayout.onBackPressed();
                return;
            } else {
                this.actionBarLayout.onBackPressed();
                return;
            }
        }
        this.actionBarLayout.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.actionBarLayout.onLowMemory();
        if (AndroidUtilities.isTablet()) {
            this.layersActionBarLayout.onLowMemory();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean needCloseLastFragment(ActionBarLayout layout) {
        if (AndroidUtilities.isTablet()) {
            if (layout == this.actionBarLayout && layout.fragmentsStack.size() <= 1) {
                onFinish();
                finish();
                return false;
            }
            if (layout == this.layersActionBarLayout && this.actionBarLayout.fragmentsStack.isEmpty() && this.layersActionBarLayout.fragmentsStack.size() == 1) {
                onFinish();
                finish();
                return false;
            }
        } else if (layout.fragmentsStack.size() <= 1) {
            onFinish();
            finish();
            return false;
        }
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public void onRebuildAllFragments(ActionBarLayout layout, boolean last) {
        if (AndroidUtilities.isTablet() && layout == this.layersActionBarLayout) {
            this.actionBarLayout.rebuildAllFragmentViews(last, last);
        }
    }
}
