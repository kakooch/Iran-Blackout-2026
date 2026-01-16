package ir.eitaa.ui.ActionBar;

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
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocationController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.NotificationsController;
import ir.eitaa.messenger.SecretChatHelper;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    protected ActionBar actionBar;
    protected Bundle arguments;
    private boolean finishing;
    protected boolean fragmentBeginToShow;
    protected View fragmentView;
    protected boolean inBubbleMode;
    protected boolean inPreviewMode;
    private boolean isFinished;
    protected Dialog parentDialog;
    protected ActionBarLayout parentLayout;
    protected Dialog visibleDialog;
    protected boolean wrapContentInPreviewMode;
    protected int currentAccount = UserConfig.selectedAccount;
    protected boolean hasOwnBackground = false;
    protected boolean isPaused = true;
    protected boolean inTransitionAnimation = false;
    protected int classGuid = ConnectionsManager.generateClassGuid();

    public boolean canBeginSlide() {
        return true;
    }

    public View createView(Context context) {
        return null;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public /* synthetic */ void didReceivedNotification(int i, int i2, Object... objArr) {
        NotificationCenter.NotificationCenterDelegate.CC.$default$didReceivedNotification(this, i, i2, objArr);
    }

    public boolean dismissDialogOnPause(Dialog dialog) {
        return true;
    }

    public boolean extendActionMode(Menu menu) {
        return false;
    }

    protected Animator getCustomSlideTransition(boolean topFragment, boolean backAnimation, float distanceToMove) {
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

    public boolean isSwipeBackEnabled(MotionEvent event) {
        return true;
    }

    public boolean needDelayOpenAnimation() {
        return false;
    }

    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) {
    }

    public boolean onBackPressed() {
        return true;
    }

    protected void onBecomeFullyHidden() {
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    protected AnimatorSet onCustomTransitionAnimation(boolean isOpen, final Runnable callback) {
        return null;
    }

    protected void onDialogDismiss(Dialog dialog) {
    }

    public boolean onFragmentCreate() {
        return true;
    }

    public void onLowMemory() {
    }

    protected void onPreviewOpenAnimationEnd() {
    }

    protected void onRemoveFromParent() {
    }

    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
    }

    protected void onSlideProgress(boolean isOpen, float progress) {
    }

    protected void onTransitionAnimationProgress(boolean isOpen, float progress) {
    }

    protected void prepareFragmentToSlide(boolean topFragment, boolean beginSlide) {
    }

    public void saveKeyboardPositionBeforeTransition() {
    }

    public void saveSelfArgs(Bundle args) {
    }

    public void setProgressToDrawerOpened(float v) {
    }

    public BaseFragment() {
    }

    public BaseFragment(Bundle args) {
        this.arguments = args;
    }

    public void setCurrentAccount(int account) {
        if (this.fragmentView != null) {
            throw new IllegalStateException("trying to set current account when fragment UI already created");
        }
        this.currentAccount = account;
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

    public void setInBubbleMode(boolean value) {
        this.inBubbleMode = value;
    }

    public boolean isInBubbleMode() {
        return this.inBubbleMode;
    }

    protected void setInPreviewMode(boolean value) {
        this.inPreviewMode = value;
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            if (value) {
                actionBar.setOccupyStatusBar(false);
            } else {
                actionBar.setOccupyStatusBar(Build.VERSION.SDK_INT >= 21);
            }
        }
    }

    protected void clearViews() {
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

    public void setParentFragment(BaseFragment fragment) {
        setParentLayout(fragment.parentLayout);
        this.fragmentView = createView(this.parentLayout.getContext());
    }

    protected void setParentLayout(ActionBarLayout layout) {
        ViewGroup viewGroup;
        if (this.parentLayout != layout) {
            this.parentLayout = layout;
            this.inBubbleMode = layout != null && layout.isInBubbleMode();
            View view = this.fragmentView;
            if (view != null) {
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                if (viewGroup2 != null) {
                    try {
                        onRemoveFromParent();
                        viewGroup2.removeViewInLayout(this.fragmentView);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
                ActionBarLayout actionBarLayout = this.parentLayout;
                if (actionBarLayout != null && actionBarLayout.getContext() != this.fragmentView.getContext()) {
                    this.fragmentView = null;
                }
            }
            if (this.actionBar != null) {
                ActionBarLayout actionBarLayout2 = this.parentLayout;
                boolean z = (actionBarLayout2 == null || actionBarLayout2.getContext() == this.actionBar.getContext()) ? false : true;
                if ((this.actionBar.shouldAddToContainer() || z) && (viewGroup = (ViewGroup) this.actionBar.getParent()) != null) {
                    try {
                        viewGroup.removeViewInLayout(this.actionBar);
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                }
                if (z) {
                    this.actionBar = null;
                }
            }
            ActionBarLayout actionBarLayout3 = this.parentLayout;
            if (actionBarLayout3 == null || this.actionBar != null) {
                return;
            }
            ActionBar actionBarCreateActionBar = createActionBar(actionBarLayout3.getContext());
            this.actionBar = actionBarCreateActionBar;
            actionBarCreateActionBar.parentFragment = this;
        }
    }

    protected ActionBar createActionBar(Context context) {
        ActionBar actionBar = new ActionBar(context);
        actionBar.setBackgroundColor(getThemedColor("actionBarDefault"));
        actionBar.setItemsBackgroundColor(getThemedColor("actionBarDefaultSelector"), false);
        actionBar.setItemsBackgroundColor(getThemedColor("actionBarActionModeDefaultSelector"), true);
        actionBar.setItemsColor(getThemedColor("actionBarDefaultIcon"), false);
        actionBar.setItemsColor(getThemedColor("actionBarActionModeDefaultIcon"), true);
        if (this.inPreviewMode || this.inBubbleMode) {
            actionBar.setOccupyStatusBar(false);
        }
        return actionBar;
    }

    public void movePreviewFragment(float dy) {
        this.parentLayout.movePreviewFragment(dy);
    }

    public void finishPreviewFragment() {
        this.parentLayout.finishPreviewFragment();
    }

    public void finishFragment() {
        Dialog dialog = this.parentDialog;
        if (dialog != null) {
            dialog.dismiss();
        } else {
            finishFragment(true);
        }
    }

    public void finishFragment(boolean animated) {
        ActionBarLayout actionBarLayout;
        if (this.isFinished || (actionBarLayout = this.parentLayout) == null) {
            return;
        }
        this.finishing = true;
        actionBarLayout.closeLastFragment(animated);
    }

    public void removeSelfFromStack() {
        ActionBarLayout actionBarLayout;
        if (this.isFinished || (actionBarLayout = this.parentLayout) == null) {
            return;
        }
        Dialog dialog = this.parentDialog;
        if (dialog != null) {
            dialog.dismiss();
        } else {
            actionBarLayout.removeFragmentFromStack(this);
        }
    }

    protected boolean isFinishing() {
        return this.finishing;
    }

    public void onFragmentDestroy() throws InterruptedException {
        getConnectionsManager().cancelRequestsForGuid(this.classGuid);
        getMessagesStorage().cancelTasksForGuid(this.classGuid);
        this.isFinished = true;
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.setEnabled(false);
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

    public BaseFragment getFragmentForAlert(int offset) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout == null || actionBarLayout.fragmentsStack.size() <= offset + 1) {
            return this;
        }
        return this.parentLayout.fragmentsStack.get((r0.size() - 2) - offset);
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

    public boolean presentFragmentAsPreview(BaseFragment fragment) {
        return presentFragmentAsPreview(fragment, false);
    }

    public boolean presentFragmentAsPreview(BaseFragment fragment, boolean wrapContent) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        return actionBarLayout != null && actionBarLayout.presentFragmentAsPreview(fragment, wrapContent);
    }

    public boolean presentFragment(BaseFragment fragment) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        return actionBarLayout != null && actionBarLayout.presentFragment(fragment);
    }

    public boolean presentFragment(BaseFragment fragment, boolean removeLast) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        return actionBarLayout != null && actionBarLayout.presentFragment(fragment, removeLast);
    }

    public boolean presentFragment(BaseFragment fragment, boolean removeLast, boolean forceWithoutAnimation) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        return actionBarLayout != null && actionBarLayout.presentFragment(fragment, removeLast, forceWithoutAnimation, true, false);
    }

    public Activity getParentActivity() {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout != null) {
            return actionBarLayout.parentActivity;
        }
        return null;
    }

    protected void setParentActivityTitle(CharSequence title) {
        Activity parentActivity = getParentActivity();
        if (parentActivity != null) {
            parentActivity.setTitle(title);
        }
    }

    public void startActivityForResult(final Intent intent, final int requestCode) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout != null) {
            actionBarLayout.startActivityForResult(intent, requestCode);
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

    protected void onTransitionAnimationStart(boolean isOpen, boolean backward) {
        this.inTransitionAnimation = true;
        if (isOpen) {
            this.fragmentBeginToShow = true;
        }
    }

    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        this.inTransitionAnimation = false;
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

    public Dialog showDialog(Dialog dialog, boolean allowInTransition, final DialogInterface.OnDismissListener onDismissListener) {
        ActionBarLayout actionBarLayout;
        if (dialog != null && (actionBarLayout = this.parentLayout) != null && !actionBarLayout.animationInProgress && !actionBarLayout.startedTracking && (allowInTransition || !actionBarLayout.checkTransitionAnimation())) {
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
                this.visibleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$BaseFragment$21pGTQtQ-QyUJQ68QWug8UuF03Y
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.lambda$showDialog$0$BaseFragment(onDismissListener, dialogInterface);
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
    /* renamed from: lambda$showDialog$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showDialog$0$BaseFragment(DialogInterface.OnDismissListener onDismissListener, DialogInterface dialogInterface) {
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

    public AccountInstance getAccountInstance() {
        return AccountInstance.getInstance(this.currentAccount);
    }

    public MessagesController getMessagesController() {
        return getAccountInstance().getMessagesController();
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

    protected DownloadController getDownloadController() {
        return getAccountInstance().getDownloadController();
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

    public void setFragmentPanTranslationOffset(int offset) {
        ActionBarLayout actionBarLayout = this.parentLayout;
        if (actionBarLayout != null) {
            actionBarLayout.setFragmentPanTranslationOffset(offset);
        }
    }

    public ActionBarLayout[] showAsSheet(BaseFragment fragment) {
        if (getParentActivity() == null) {
            return null;
        }
        ActionBarLayout[] actionBarLayoutArr = {new ActionBarLayout(getParentActivity())};
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(getParentActivity(), true, actionBarLayoutArr, fragment);
        fragment.setParentDialog(anonymousClass1);
        anonymousClass1.show();
        return actionBarLayoutArr;
    }

    /* renamed from: ir.eitaa.ui.ActionBar.BaseFragment$1, reason: invalid class name */
    class AnonymousClass1 extends BottomSheet {
        final /* synthetic */ ActionBarLayout[] val$actionBarLayout;
        final /* synthetic */ BaseFragment val$fragment;

        @Override // ir.eitaa.ui.ActionBar.BottomSheet
        protected boolean canDismissWithSwipe() {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, boolean needFocus, final ActionBarLayout[] val$actionBarLayout, final BaseFragment val$fragment) {
            super(context, needFocus);
            this.val$actionBarLayout = val$actionBarLayout;
            this.val$fragment = val$fragment;
            val$actionBarLayout[0].init(new ArrayList<>());
            val$actionBarLayout[0].addFragmentToStack(val$fragment);
            val$actionBarLayout[0].showLastFragment();
            ActionBarLayout actionBarLayout = val$actionBarLayout[0];
            int i = this.backgroundPaddingLeft;
            actionBarLayout.setPadding(i, 0, i, 0);
            this.containerView = val$actionBarLayout[0];
            setApplyBottomPadding(false);
            setApplyBottomPadding(false);
            setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$BaseFragment$1$knYzJab0xVScHpDVTS4vsmzC1y8
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) throws InterruptedException {
                    val$fragment.onFragmentDestroy();
                }
            });
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            ActionBarLayout[] actionBarLayoutArr = this.val$actionBarLayout;
            if (actionBarLayoutArr[0] == null || actionBarLayoutArr[0].fragmentsStack.size() <= 1) {
                super.onBackPressed();
            } else {
                this.val$actionBarLayout[0].onBackPressed();
            }
        }

        @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            super.dismiss();
            this.val$actionBarLayout[0] = null;
        }
    }

    public int getThemedColor(String key) {
        return Theme.getColor(key);
    }

    public Drawable getThemedDrawable(String key) {
        return Theme.getThemeDrawable(key);
    }

    public int getNavigationBarColor() {
        return Theme.getColor("windowBackgroundGray");
    }

    public void setNavigationBarColor(int color) {
        Activity parentActivity = getParentActivity();
        if (parentActivity != null) {
            Window window = parentActivity.getWindow();
            if (Build.VERSION.SDK_INT < 26 || window == null || window.getNavigationBarColor() == color) {
                return;
            }
            window.setNavigationBarColor(color);
            AndroidUtilities.setLightNavigationBar(window, AndroidUtilities.computePerceivedBrightness(color) >= 0.721f);
        }
    }

    public boolean isBeginToShow() {
        return this.fragmentBeginToShow;
    }

    private void setParentDialog(Dialog dialog) {
        this.parentDialog = dialog;
    }
}
