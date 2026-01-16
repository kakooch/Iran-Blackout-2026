package org.rbmain.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidMessenger.ServiceLocator;
import androidMessenger.asemannotification.AsemanNotificationService;
import androidMessenger.proxy.ContactsProxy;
import androidMessenger.proxy.DialogsProxy;
import androidMessenger.proxy.FileLoadProxy;
import androidMessenger.proxy.MessageProxy;
import androidMessenger.utilites.MessengerLinkHandler;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import ir.aaap.messengercore.CoreMainClass;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.presenters.PlayerPresenter;
import java.util.ArrayList;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.LocationController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsController;
import org.rbmain.messenger.SecretChatHelper;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.Point;

/* loaded from: classes4.dex */
public abstract class BaseFragment {
    public static boolean destroyPlayeronfragmentDestroy = true;
    protected ActionBar actionBar;
    protected Bundle arguments;
    public BaseFragment baseFragment;
    protected int classGuid;
    private boolean finishing;
    protected boolean fragmentBeginToShow;
    public String fragmentName;
    public float fragmentPresentOriginX;
    public float fragmentPresentOriginY;
    public View fragmentView;
    protected boolean hasOwnBackground;
    protected boolean inBubbleMode;
    protected boolean inMenuMode;
    protected boolean inPreviewMode;
    private boolean isFinished;
    public boolean isFullScreen;
    public boolean isPaused;
    public boolean needLockOrientation;
    protected ActionBarLayout parentLayout;
    protected boolean swipeBackEnabled;
    protected Dialog visibleDialog;
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    public boolean swipeDownEnabled = false;
    public float fragmentAnimationDuration = 150.0f;
    public boolean isForceBlackTheme = false;
    public boolean isSmallActionBar = false;
    protected boolean rtlLayout = true;
    public ActionBarAnimationType presentAnimationType = ActionBarAnimationType.RTL;
    public ActionBarAnimationType dismissAnimationType = ActionBarAnimationType.LTR;
    protected int currentAccount = UserConfig.selectedAccount;

    public boolean canBeginSlide() {
        return true;
    }

    public View createView(Context context) {
        return null;
    }

    public boolean dismissDialogOnPause(Dialog dialog) {
        return true;
    }

    public boolean extendActionMode(Menu menu) {
        return false;
    }

    protected Animator getCustomSlideTransition(boolean z, boolean z2, float f) {
        return null;
    }

    protected int getPreviewHeight() {
        return -1;
    }

    public Theme.ResourcesProvider getResourceProvider() {
        return null;
    }

    protected boolean hideKeyboardOnShow() {
        return true;
    }

    public boolean isSwipeBackEnabled(MotionEvent motionEvent) {
        return true;
    }

    public boolean needDelayOpenAnimation() {
        return false;
    }

    public void onActivityResultFragment(int i, int i2, Intent intent) {
    }

    public boolean onBackPressed() {
        return true;
    }

    protected void onBecomeFullyHidden() {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    protected AnimatorSet onCustomTransitionAnimation(boolean z, Runnable runnable) {
        return null;
    }

    protected void onDialogDismiss(Dialog dialog) {
    }

    public void onFragmentClosed() {
    }

    public void onLowMemory() {
    }

    protected void onPreviewOpenAnimationEnd() {
    }

    protected void onRemoveFromParent() {
    }

    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
    }

    protected void onSlideProgress(boolean z, float f) {
    }

    protected void onTransitionAnimationEnd(boolean z, boolean z2) {
    }

    protected void onTransitionAnimationProgress(boolean z, float f) {
    }

    public void onUserLeaveHint() {
    }

    protected void prepareFragmentToSlide(boolean z, boolean z2) {
    }

    public void saveKeyboardPositionBeforeTransition() {
    }

    public void saveSelfArgs(Bundle bundle) {
    }

    public void setProgressToDrawerOpened(float f) {
    }

    public BaseFragment() {
        FragmentType fragmentType = FragmentType.NotSet;
        this.fragmentName = "NotSet";
        this.hasOwnBackground = false;
        this.isPaused = true;
        this.swipeBackEnabled = true;
        this.baseFragment = this;
        this.classGuid = ConnectionsManager.generateClassGuid();
    }

    public BaseFragment(Bundle bundle) {
        FragmentType fragmentType = FragmentType.NotSet;
        this.fragmentName = "NotSet";
        this.hasOwnBackground = false;
        this.isPaused = true;
        this.swipeBackEnabled = true;
        this.baseFragment = this;
        this.arguments = bundle;
        this.classGuid = ConnectionsManager.generateClassGuid();
    }

    public void setCurrentAccount(int i) {
        if (this.fragmentView != null) {
            throw new IllegalStateException("trying to set current account when fragment UI already created");
        }
        this.currentAccount = i;
    }

    public ActionBar getActionBar() {
        return this.actionBar;
    }

    public View getFragmentView() {
        return this.fragmentView;
    }

    public Bundle getArguments() {
        return this.arguments;
    }

    public int getCurrentAccount() {
        return this.currentAccount;
    }

    public int getClassGuid() {
        return this.classGuid;
    }

    public boolean isSwipeDownEnabled() {
        return this.swipeDownEnabled;
    }

    public void setInBubbleMode(boolean z) {
        this.inBubbleMode = z;
    }

    public boolean isInBubbleMode() {
        return this.inBubbleMode;
    }

    public boolean isInPreviewMode() {
        return this.inPreviewMode;
    }

    protected void setInPreviewMode(boolean z) {
        this.inPreviewMode = z;
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            if (z) {
                actionBar.setOccupyStatusBar(false);
            } else {
                actionBar.setOccupyStatusBar(false);
            }
        }
    }

    public void setInMenuMode(boolean z) {
        this.inMenuMode = z;
    }

    public void clearViews() {
        View view = this.fragmentView;
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                try {
                    onRemoveFromParent();
                    viewGroup.removeViewInLayout(this.fragmentView);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            this.fragmentView = null;
            FirebaseEventSender.setKey("fragmentView1", "fragmentView null");
        }
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            ViewGroup viewGroup2 = (ViewGroup) actionBar.getParent();
            if (viewGroup2 != null) {
                try {
                    viewGroup2.removeViewInLayout(this.actionBar);
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            this.actionBar = null;
        }
        this.parentLayout = null;
    }

    public void setParentFragment(BaseFragment baseFragment) {
        setParentLayout(baseFragment.parentLayout);
        this.fragmentView = createView(this.parentLayout.getContext());
    }

    protected ActionBar createActionBar(Context context) {
        ActionBar actionBar = new ActionBar(context);
        actionBar.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_actionBarDefaultSelector), false);
        actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_actionBarActionModeDefaultSelector), true);
        actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarDefaultIcon), false);
        actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarActionModeDefaultIcon), true);
        actionBar.setOccupyStatusBar(false);
        actionBar.setRtlLayout(this.rtlLayout);
        return actionBar;
    }

    public void movePreviewFragment(float f) {
        this.parentLayout.movePreviewFragment(f);
    }

    public void finishPreviewFragment() {
        this.parentLayout.finishPreviewFragment();
    }

    public void finishFragment() {
        finishFragment(true);
    }

    public void finishFragment(boolean z) {
        ActionBarLayout actionBarLayout;
        if (this.isFinished || (actionBarLayout = this.parentLayout) == null) {
            return;
        }
        this.finishing = true;
        actionBarLayout.closeLastFragment(z);
    }

    public void removeSelfFromStack() {
        ActionBarLayout actionBarLayout;
        if (this.isFinished || (actionBarLayout = this.parentLayout) == null) {
            return;
        }
        actionBarLayout.removeFragmentFromStack(this);
    }

    protected boolean isFinishing() {
        return this.finishing;
    }

    public boolean isSwipeBackEnabled() {
        return this.swipeBackEnabled;
    }

    public boolean onFragmentCreate() {
        MyLog.e("BaseFragment", "onFragmentCreate");
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.compositeDisposable = new CompositeDisposable();
        }
        try {
            if (ApplicationLoader.applicationActivity.getLastFragment() != null && this.isFullScreen != ApplicationLoader.applicationActivity.getLastFragment().isFullScreen) {
                toggleFullscreenSwitch(this.isFullScreen);
            }
            if (Theme.isCurrentThemeNight() || this.isForceBlackTheme == ApplicationLoader.applicationActivity.getLastFragment().isForceBlackTheme) {
                return true;
            }
            ApplicationLoader.applicationActivity.applyTheme(this.isForceBlackTheme);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public void toggleFullscreenSwitch(boolean z) {
        try {
            int i = Build.VERSION.SDK_INT;
            WindowManager.LayoutParams attributes = ApplicationLoader.applicationActivity.getWindow().getAttributes();
            Window window = ((Activity) getContext()).getWindow();
            if (z) {
                if (i >= 19) {
                    window.setFlags(ConnectionsManager.FileTypeFile, ConnectionsManager.FileTypeFile);
                    window.setFlags(256, 256);
                    window.setFlags(1024, 1024);
                    window.getDecorView().setSystemUiVisibility(5380);
                    return;
                }
                window.getDecorView().setSystemUiVisibility(0);
                attributes.flags |= 1024;
                window.setAttributes(attributes);
                return;
            }
            if (i >= 19) {
                window.clearFlags(ConnectionsManager.FileTypeFile);
                window.clearFlags(1024);
            }
            window.getDecorView().setSystemUiVisibility(0);
            attributes.flags &= -1025;
            window.setAttributes(attributes);
            if (ApplicationLoader.applicationActivity != null) {
                ApplicationLoader.applicationActivity.applyTheme(this.isForceBlackTheme);
            }
        } catch (Exception unused) {
        }
    }

    public void onFragmentDestroy() {
        if (destroyPlayeronfragmentDestroy) {
            PlayerPresenter.destroyPlayer(getContext());
        }
        getConnectionsManager().cancelRequestsForGuid(this.classGuid);
        getMessagesStorage().cancelTasksForGuid(this.classGuid);
        this.isFinished = true;
        this.isPaused = true;
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.setEnabled(false);
        }
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        try {
            if (this.isFullScreen != ApplicationLoader.applicationActivity.getSecondLastFragment().isFullScreen) {
                toggleFullscreenSwitch(ApplicationLoader.applicationActivity.getSecondLastFragment().isFullScreen);
            }
        } catch (Exception unused) {
        }
        try {
            if (Theme.isCurrentThemeNight() || this.isForceBlackTheme == ApplicationLoader.applicationActivity.getSecondLastFragment().isForceBlackTheme) {
                return;
            }
            ApplicationLoader.applicationActivity.applyTheme(ApplicationLoader.applicationActivity.getSecondLastFragment().isForceBlackTheme);
        } catch (Exception unused2) {
        }
    }

    protected void resumeDelayedFragmentAnimation() {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout != null) {
            actionBarLayout.resumeDelayedFragmentAnimation();
        }
    }

    public void onResume() {
        this.isPaused = false;
        if (this.needLockOrientation) {
            lockOrientationPortrait();
        } else {
            unlockOrientation();
        }
        try {
            if (ServiceLocator.isAccountLoggedIn(this.currentAccount)) {
                AsemanNotificationService.startNotificationService(getParentActivity().getApplicationContext());
            }
        } catch (Exception unused) {
        }
        try {
            LocaleController.getInstance().checkLanguage();
        } catch (Exception unused2) {
        }
        FirebaseCrashlytics.getInstance().setCustomKey("fragmentName", this.fragmentName + BuildConfig.FLAVOR);
    }

    public void onPause() {
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.onPause();
        }
        this.isPaused = true;
        try {
            Dialog dialog = this.visibleDialog;
            if (dialog != null && dialog.isShowing() && dismissDialogOnPause(this.visibleDialog)) {
                this.visibleDialog.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public BaseFragment getFragmentForAlert(int i) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout == null || actionBarLayout.fragmentsStack.size() <= i + 1) {
            return this;
        }
        return this.parentLayout.fragmentsStack.get((r0.size() - 2) - i);
    }

    public boolean isLastFragment() {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout != null && !actionBarLayout.fragmentsStack.isEmpty()) {
            ArrayList<BaseFragment> arrayList = this.parentLayout.fragmentsStack;
            if (arrayList.get(arrayList.size() - 1) == this) {
                return true;
            }
        }
        return false;
    }

    public ActionBarLayout getParentLayout() {
        return this.parentLayout;
    }

    public FrameLayout getLayoutContainer() {
        View view = this.fragmentView;
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof FrameLayout) {
            return (FrameLayout) parent;
        }
        return null;
    }

    public boolean presentFragmentAsPreview(BaseFragment baseFragment) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        return actionBarLayout != null && actionBarLayout.presentFragmentAsPreview(baseFragment);
    }

    public boolean presentFragment(BaseFragment baseFragment) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        return actionBarLayout != null && actionBarLayout.presentFragment(baseFragment);
    }

    public boolean presentFragment(BaseFragment baseFragment, boolean z) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        return actionBarLayout != null && actionBarLayout.presentFragment(baseFragment, z);
    }

    public boolean presentFragment(BaseFragment baseFragment, boolean z, boolean z2) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        return actionBarLayout != null && actionBarLayout.presentFragment(baseFragment, z, z2, true, false);
    }

    public Activity getParentActivity() {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout != null) {
            return actionBarLayout.parentActivity;
        }
        return null;
    }

    protected void setParentActivityTitle(CharSequence charSequence) {
        Activity parentActivity = getParentActivity();
        if (parentActivity != null) {
            parentActivity.setTitle(charSequence);
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout != null) {
            actionBarLayout.startActivityForResult(intent, i);
        }
    }

    public void dismissCurrentDialog() {
        Dialog dialog = this.visibleDialog;
        if (dialog == null) {
            return;
        }
        try {
            dialog.dismiss();
            this.visibleDialog = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void onBeginSlide() {
        try {
            Dialog dialog = this.visibleDialog;
            if (dialog != null && dialog.isShowing()) {
                this.visibleDialog.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.onPause();
        }
    }

    protected void onTransitionAnimationStart(boolean z, boolean z2) {
        if (z) {
            this.fragmentBeginToShow = true;
        }
    }

    protected void onBecomeFullyVisible() {
        ActionBar actionBar;
        if (!((AccessibilityManager) ApplicationLoader.applicationContext.getSystemService("accessibility")).isEnabled() || (actionBar = getActionBar()) == null) {
            return;
        }
        String title = actionBar.getTitle();
        if (TextUtils.isEmpty(title)) {
            return;
        }
        setParentActivityTitle(title);
    }

    public Dialog showDialog(Dialog dialog) {
        return showDialog(dialog, false, null);
    }

    public Dialog showDialog(Dialog dialog, DialogInterface.OnDismissListener onDismissListener) {
        return showDialog(dialog, false, onDismissListener);
    }

    public Dialog showDialog(Dialog dialog, boolean z, final DialogInterface.OnDismissListener onDismissListener) {
        ActionBarLayout actionBarLayout;
        if (dialog != null && (actionBarLayout = this.parentLayout) != null && !actionBarLayout.animationInProgress && !actionBarLayout.startedTracking && (z || !actionBarLayout.checkTransitionAnimation())) {
            try {
                Dialog dialog2 = this.visibleDialog;
                if (dialog2 != null) {
                    dialog2.dismiss();
                    this.visibleDialog = null;
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            try {
                this.visibleDialog = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.visibleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.ActionBar.BaseFragment$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.lambda$showDialog$0(onDismissListener, dialogInterface);
                    }
                });
                this.visibleDialog.show();
                return this.visibleDialog;
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$0(DialogInterface.OnDismissListener onDismissListener, DialogInterface dialogInterface) {
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
        onDialogDismiss((Dialog) dialogInterface);
        if (dialogInterface == this.visibleDialog) {
            this.visibleDialog = null;
        }
    }

    public Dialog getVisibleDialog() {
        return this.visibleDialog;
    }

    public void setVisibleDialog(Dialog dialog) {
        this.visibleDialog = dialog;
    }

    public ArrayList<ThemeDescription> getThemeDescriptions() {
        return new ArrayList<>();
    }

    public CoreMainClass getCoreMainClass() {
        return getAccountInstance().getCoreMainClass();
    }

    public MessageProxy getMessageProxy() {
        return getAccountInstance().getMessageProxy();
    }

    public MessengerLinkHandler getMessengerLinkHandler() {
        return getAccountInstance().getMessengerLinkHandler();
    }

    public ContactsProxy getContactProxy() {
        return getAccountInstance().getContactsProxy();
    }

    public AccountInstance getAccountInstance() {
        return AccountInstance.getInstance(this.currentAccount);
    }

    public MessagesController getMessagesController() {
        return getAccountInstance().getMessagesController();
    }

    public DialogsProxy getDialogsProxy() {
        return getAccountInstance().getDialogsProxy();
    }

    public FileLoadProxy getFileProxy() {
        return getAccountInstance().getFileProxy();
    }

    protected ContactsController getContactsController() {
        return getAccountInstance().getContactsController();
    }

    public MediaDataController getMediaDataController() {
        return getAccountInstance().getMediaDataController();
    }

    public ConnectionsManager getConnectionsManager() {
        return getAccountInstance().getConnectionsManager();
    }

    public LocationController getLocationController() {
        return getAccountInstance().getLocationController();
    }

    protected NotificationsController getNotificationsController() {
        return getAccountInstance().getNotificationsController();
    }

    public MessagesStorage getMessagesStorage() {
        return getAccountInstance().getMessagesStorage();
    }

    public SendMessagesHelper getSendMessagesHelper() {
        return getAccountInstance().getSendMessagesHelper();
    }

    public FileLoader getFileLoader() {
        return getAccountInstance().getFileLoader();
    }

    protected SecretChatHelper getSecretChatHelper() {
        return getAccountInstance().getSecretChatHelper();
    }

    protected SharedPreferences getNotificationsSettings() {
        return getAccountInstance().getNotificationsSettings();
    }

    public NotificationCenter getNotificationCenter() {
        return getAccountInstance().getNotificationCenter();
    }

    public MediaController getMediaController() {
        return MediaController.getInstance();
    }

    public UserConfig getUserConfig() {
        return getAccountInstance().getUserConfig();
    }

    public void setFragmentPanTranslationOffset(int i) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout != null) {
            actionBarLayout.setFragmentPanTranslationOffset(i);
        }
    }

    public void lockOrientationPortrait() {
        Activity activity = (Activity) getContext();
        if (activity.getRequestedOrientation() != 1) {
            activity.setRequestedOrientation(1);
        }
    }

    private void unlockOrientation() {
        Activity activity = (Activity) getContext();
        if (activity.getRequestedOrientation() != -1) {
            activity.setRequestedOrientation(-1);
        }
    }

    public Context getContext() {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout != null) {
            return actionBarLayout.getContext();
        }
        return ApplicationLoader.applicationActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ApiRequestMessangerRx getApiRequestMessangerRx() {
        return ApiRequestMessangerRx.getInstance(this.currentAccount);
    }

    public final RubinoController getRubinoController() {
        return RubinoController.getInstance(this.currentAccount);
    }

    public final StoryController getStoryController() {
        return StoryController.getInstance(this.currentAccount);
    }

    public Point getDismissOriginPoint() {
        return new Point(this.fragmentPresentOriginX, this.fragmentPresentOriginY);
    }

    public void setParentLayout(ActionBarLayout actionBarLayout) {
        ViewGroup viewGroup;
        if (this.parentLayout != actionBarLayout) {
            this.parentLayout = actionBarLayout;
            this.inBubbleMode = actionBarLayout != null && actionBarLayout.isInBubbleMode();
            View view = this.fragmentView;
            if (view != null) {
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                if (viewGroup2 != null) {
                    try {
                        onRemoveFromParent();
                        viewGroup2.removeViewInLayout(this.fragmentView);
                    } catch (Exception unused) {
                    }
                }
                ActionBarLayout actionBarLayout2 = this.parentLayout;
                if (actionBarLayout2 != null && actionBarLayout2.getContext() != this.fragmentView.getContext()) {
                    FirebaseEventSender.setKey("fragmentView2", "fragmentView null " + this.parentLayout.getContext() + " " + this.fragmentView.getContext());
                    this.fragmentView = null;
                }
            }
            if (this.actionBar != null) {
                ActionBarLayout actionBarLayout3 = this.parentLayout;
                boolean z = (actionBarLayout3 == null || actionBarLayout3.getContext() == this.actionBar.getContext()) ? false : true;
                if ((this.actionBar.getAddToContainer() || z) && (viewGroup = (ViewGroup) this.actionBar.getParent()) != null) {
                    try {
                        viewGroup.removeViewInLayout(this.actionBar);
                    } catch (Exception unused2) {
                    }
                }
                if (z) {
                    this.actionBar = null;
                }
            }
            ActionBarLayout actionBarLayout4 = this.parentLayout;
            if (actionBarLayout4 == null || this.actionBar != null || (this instanceof PresenterFragment)) {
                return;
            }
            ActionBar actionBarCreateActionBar = createActionBar(actionBarLayout4.getContext());
            this.actionBar = actionBarCreateActionBar;
            actionBarCreateActionBar.isSmallActionBar = this.isSmallActionBar;
            actionBarCreateActionBar.parentFragment = this;
        }
    }

    public AppPreferences getAppPreferences() {
        return AppPreferences.getInstance(this.currentAccount);
    }

    public int getThemedColor(int i) {
        return Theme.getColor(i, getResourceProvider());
    }

    public Drawable getThemedDrawable(String str) {
        return Theme.getThemeDrawable(str);
    }

    public void setNavigationBarColor(int i) {
        Activity parentActivity = getParentActivity();
        if (parentActivity != null) {
            Window window = parentActivity.getWindow();
            if (Build.VERSION.SDK_INT < 26 || window == null || window.getNavigationBarColor() == i) {
                return;
            }
            window.setNavigationBarColor(i);
            AndroidUtilities.setLightNavigationBar(window, AndroidUtilities.computePerceivedBrightness(i) >= 0.721f);
        }
    }
}
