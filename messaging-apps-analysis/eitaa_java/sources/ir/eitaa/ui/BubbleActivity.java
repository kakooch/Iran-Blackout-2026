package ir.eitaa.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.camera.CameraController;
import ir.eitaa.ui.ActionBar.ActionBarLayout;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.DrawerLayoutContainer;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.PasscodeView;
import ir.eitaa.ui.Components.ThemeEditorView;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BubbleActivity extends Activity implements ActionBarLayout.ActionBarLayoutDelegate {
    private ActionBarLayout actionBarLayout;
    private long dialogId;
    protected DrawerLayoutContainer drawerLayoutContainer;
    private boolean finished;
    private Runnable lockRunnable;
    private Intent passcodeSaveIntent;
    private int passcodeSaveIntentAccount;
    private boolean passcodeSaveIntentIsNew;
    private boolean passcodeSaveIntentIsRestore;
    private int passcodeSaveIntentState;
    private PasscodeView passcodeView;
    private ArrayList<BaseFragment> mainFragmentsStack = new ArrayList<>();
    private int currentAccount = -1;

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

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public void onRebuildAllFragments(ActionBarLayout layout, boolean last) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws InterruptedException, Resources.NotFoundException, IOException {
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
        ActionBarLayout actionBarLayout = new ActionBarLayout(this);
        this.actionBarLayout = actionBarLayout;
        actionBarLayout.setInBubbleMode(true);
        this.actionBarLayout.setRemoveActionBarExtraHeight(true);
        DrawerLayoutContainer drawerLayoutContainer = new DrawerLayoutContainer(this);
        this.drawerLayoutContainer = drawerLayoutContainer;
        drawerLayoutContainer.setAllowOpenDrawer(false, false);
        setContentView(this.drawerLayoutContainer, new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.drawerLayoutContainer.addView(relativeLayout, LayoutHelper.createFrame(-1, -1.0f));
        relativeLayout.addView(this.actionBarLayout, LayoutHelper.createRelative(-1, -1));
        this.drawerLayoutContainer.setParentActionBarLayout(this.actionBarLayout);
        this.actionBarLayout.setDrawerLayoutContainer(this.drawerLayoutContainer);
        this.actionBarLayout.init(this.mainFragmentsStack);
        this.actionBarLayout.setDelegate(this);
        PasscodeView passcodeView = new PasscodeView(this);
        this.passcodeView = passcodeView;
        this.drawerLayoutContainer.addView(passcodeView, LayoutHelper.createFrame(-1, -1.0f));
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.closeOtherAppActivities, this);
        this.actionBarLayout.removeAllFragments();
        handleIntent(getIntent(), false, savedInstanceState != null, false, UserConfig.selectedAccount, 0);
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
        this.passcodeView.setDelegate(new PasscodeView.PasscodeViewDelegate() { // from class: ir.eitaa.ui.BubbleActivity.1
            @Override // ir.eitaa.ui.Components.PasscodeView.PasscodeViewDelegate
            public void onFinish() {
            }

            @Override // ir.eitaa.ui.Components.PasscodeView.PasscodeViewDelegate
            public void didAcceptedPassword() throws InterruptedException, IOException {
                SharedConfig.isWaitingForPasscodeEnter = false;
                if (BubbleActivity.this.passcodeSaveIntent != null) {
                    BubbleActivity bubbleActivity = BubbleActivity.this;
                    bubbleActivity.handleIntent(bubbleActivity.passcodeSaveIntent, BubbleActivity.this.passcodeSaveIntentIsNew, BubbleActivity.this.passcodeSaveIntentIsRestore, true, BubbleActivity.this.passcodeSaveIntentAccount, BubbleActivity.this.passcodeSaveIntentState);
                    BubbleActivity.this.passcodeSaveIntent = null;
                }
                BubbleActivity.this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
                BubbleActivity.this.actionBarLayout.showLastFragment();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleIntent(final Intent intent, final boolean isNew, final boolean restore, final boolean fromPassword, final int intentAccount, int state) throws InterruptedException, IOException {
        if (!fromPassword && (AndroidUtilities.needShowPasscode(true) || SharedConfig.isWaitingForPasscodeEnter)) {
            showPasscodeActivity();
            this.passcodeSaveIntent = intent;
            this.passcodeSaveIntentIsNew = isNew;
            this.passcodeSaveIntentIsRestore = restore;
            this.passcodeSaveIntentAccount = intentAccount;
            this.passcodeSaveIntentState = state;
            UserConfig.getInstance(intentAccount).saveConfig(false);
            return false;
        }
        int intExtra = intent.getIntExtra("currentAccount", UserConfig.selectedAccount);
        this.currentAccount = intExtra;
        if (!UserConfig.isValidAccount(intExtra)) {
            finish();
            return false;
        }
        ChatActivity chatActivity = null;
        if (intent.getAction() != null && intent.getAction().startsWith("com.tmessages.openchat")) {
            long longExtra = intent.getLongExtra("chatId", 0L);
            long longExtra2 = intent.getLongExtra("userId", 0L);
            Bundle bundle = new Bundle();
            if (longExtra2 != 0) {
                this.dialogId = longExtra2;
                bundle.putLong("user_id", longExtra2);
            } else {
                this.dialogId = -longExtra;
                bundle.putLong("chat_id", longExtra);
            }
            chatActivity = new ChatActivity(bundle);
            chatActivity.setInBubbleMode(true);
            chatActivity.setCurrentAccount(this.currentAccount);
        }
        if (chatActivity == null) {
            finish();
            return false;
        }
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.closeChats, Long.valueOf(this.dialogId));
        this.actionBarLayout.removeAllFragments();
        this.actionBarLayout.addFragmentToStack(chatActivity);
        AccountInstance.getInstance(this.currentAccount).getNotificationsController().setOpenedInBubble(this.dialogId, true);
        AccountInstance.getInstance(this.currentAccount).getConnectionsManager().setAppPaused(false, false);
        this.actionBarLayout.showLastFragment();
        return true;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) throws InterruptedException, IOException {
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

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.actionBarLayout.onPause();
        ApplicationLoader.externalInterfacePaused = true;
        onPasscodePause();
        PasscodeView passcodeView = this.passcodeView;
        if (passcodeView != null) {
            passcodeView.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() throws InterruptedException, IOException {
        super.onDestroy();
        int i = this.currentAccount;
        if (i != -1) {
            AccountInstance.getInstance(i).getNotificationsController().setOpenedInBubble(this.dialogId, false);
            AccountInstance.getInstance(this.currentAccount).getConnectionsManager().setAppPaused(false, false);
        }
        onFinish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ThemeEditorView themeEditorView = ThemeEditorView.getInstance();
        if (themeEditorView != null) {
            themeEditorView.onActivityResult(requestCode, resultCode, data);
        }
        if (this.actionBarLayout.fragmentsStack.size() != 0) {
            this.actionBarLayout.fragmentsStack.get(r0.size() - 1).onActivityResultFragment(requestCode, resultCode, data);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults == null) {
            grantResults = new int[0];
        }
        if (permissions == null) {
            permissions = new String[0];
        }
        boolean z = grantResults.length > 0 && grantResults[0] == 0;
        if (requestCode == 104) {
            if (z) {
                GroupCallActivity groupCallActivity = GroupCallActivity.groupCallInstance;
                if (groupCallActivity != null) {
                    groupCallActivity.enableCamera();
                }
            } else {
                showPermissionErrorAlert(LocaleController.getString("VoipNeedCameraPermission", R.string.VoipNeedCameraPermission));
            }
        } else if (requestCode == 4) {
            if (!z) {
                showPermissionErrorAlert(LocaleController.getString("PermissionStorage", R.string.PermissionStorage));
            } else {
                ImageLoader.getInstance().checkMediaPaths();
            }
        } else if (requestCode == 5) {
            if (!z) {
                showPermissionErrorAlert(LocaleController.getString("PermissionContacts", R.string.PermissionContacts));
                return;
            }
            ContactsController.getInstance(this.currentAccount).forceImportContacts();
        } else if (requestCode == 3) {
            int iMin = Math.min(permissions.length, grantResults.length);
            boolean z2 = true;
            boolean z3 = true;
            for (int i = 0; i < iMin; i++) {
                if ("android.permission.RECORD_AUDIO".equals(permissions[i])) {
                    z2 = grantResults[i] == 0;
                } else if ("android.permission.CAMERA".equals(permissions[i])) {
                    z3 = grantResults[i] == 0;
                }
            }
            if (!z2) {
                showPermissionErrorAlert(LocaleController.getString("PermissionNoAudio", R.string.PermissionNoAudio));
            } else if (!z3) {
                showPermissionErrorAlert(LocaleController.getString("PermissionNoCamera", R.string.PermissionNoCamera));
            } else {
                if (SharedConfig.inappCamera) {
                    CameraController.getInstance().initCamera(null);
                    return;
                }
                return;
            }
        } else if (requestCode == 18 || requestCode == 19 || requestCode == 20 || requestCode == 22) {
            if (!z) {
                showPermissionErrorAlert(LocaleController.getString("PermissionNoCamera", R.string.PermissionNoCamera));
            }
        } else if (requestCode == 2 && z) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.locationPermissionGranted, new Object[0]);
        }
        if (this.actionBarLayout.fragmentsStack.size() != 0) {
            ArrayList<BaseFragment> arrayList = this.actionBarLayout.fragmentsStack;
            arrayList.get(arrayList.size() - 1).onRequestPermissionsResultFragment(requestCode, permissions, grantResults);
        }
        VoIPFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void showPermissionErrorAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(message);
        builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$BubbleActivity$xfMMMQt8yRb0xYWMJiyyCsFzC4s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPermissionErrorAlert$0$BubbleActivity(dialogInterface, i);
            }
        });
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPermissionErrorAlert$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPermissionErrorAlert$0$BubbleActivity(DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.actionBarLayout.onResume();
        ApplicationLoader.externalInterfacePaused = false;
        onPasscodeResume();
        if (this.passcodeView.getVisibility() != 0) {
            this.actionBarLayout.onResume();
        } else {
            this.actionBarLayout.dismissDialogs();
            this.passcodeView.onResume();
        }
    }

    private void onPasscodePause() {
        Runnable runnable = this.lockRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.lockRunnable = null;
        }
        if (SharedConfig.passcodeHash.length() != 0) {
            SharedConfig.lastPauseTime = (int) (SystemClock.elapsedRealtime() / 1000);
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.BubbleActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BubbleActivity.this.lockRunnable == this) {
                        if (AndroidUtilities.needShowPasscode(true)) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("lock app");
                            }
                            BubbleActivity.this.showPasscodeActivity();
                        } else if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("didn't pass lock check");
                        }
                        BubbleActivity.this.lockRunnable = null;
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
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mainFragmentsStack.size() == 1) {
            super.onBackPressed();
            return;
        }
        if (this.passcodeView.getVisibility() == 0) {
            finish();
            return;
        }
        if (PhotoViewer.getInstance().isVisible()) {
            PhotoViewer.getInstance().closePhoto(true, false);
        } else if (this.drawerLayoutContainer.isDrawerOpened()) {
            this.drawerLayoutContainer.closeDrawer(false);
        } else {
            this.actionBarLayout.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.actionBarLayout.onLowMemory();
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean needCloseLastFragment(ActionBarLayout layout) {
        if (layout.fragmentsStack.size() > 1) {
            return true;
        }
        onFinish();
        finish();
        return false;
    }
}
