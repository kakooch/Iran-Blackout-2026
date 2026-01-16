package ir.eitaa.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Shader;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.arch.core.util.Function;
import androidx.recyclerview.widget.ItemTouchHelper;
import ir.eitaa.features.CallOut.StartCallOutActivity;
import ir.eitaa.features.CallOut.helper.CallOutManager;
import ir.eitaa.features.ChatLock.ChatLockHelper;
import ir.eitaa.features.ChatLock.LockedChatAction;
import ir.eitaa.features.ChatLock.LockedChatsActivity;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.LocationController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.messenger.camera.CameraController;
import ir.eitaa.messenger.voip.VideoCapturerDevice;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatInvite;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$LangPackString;
import ir.eitaa.tgnet.TLRPC$ReplyMarkup;
import ir.eitaa.tgnet.TLRPC$TL_account_authorizationForm;
import ir.eitaa.tgnet.TLRPC$TL_account_getAuthorizationForm;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_password;
import ir.eitaa.tgnet.TLRPC$TL_auth_acceptLoginToken;
import ir.eitaa.tgnet.TLRPC$TL_authorization;
import ir.eitaa.tgnet.TLRPC$TL_channels_getChannels;
import ir.eitaa.tgnet.TLRPC$TL_chatInvitePreview;
import ir.eitaa.tgnet.TLRPC$TL_contacts_resolvedPeer;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$TL_help_appUpdate;
import ir.eitaa.tgnet.TLRPC$TL_help_deepLinkInfo;
import ir.eitaa.tgnet.TLRPC$TL_help_getAppUpdate;
import ir.eitaa.tgnet.TLRPC$TL_help_termsOfService;
import ir.eitaa.tgnet.TLRPC$TL_inputChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputGameShortName;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaGame;
import ir.eitaa.tgnet.TLRPC$TL_langPackLanguage;
import ir.eitaa.tgnet.TLRPC$TL_langpack_getStrings;
import ir.eitaa.tgnet.TLRPC$TL_messages_chats;
import ir.eitaa.tgnet.TLRPC$TL_messages_checkHistoryImport;
import ir.eitaa.tgnet.TLRPC$TL_messages_getDiscussionMessage;
import ir.eitaa.tgnet.TLRPC$TL_theme;
import ir.eitaa.tgnet.TLRPC$TL_wallPaper;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.tgnet.TLRPC$Vector;
import ir.eitaa.tgnet.TLRPC$WallPaperSettings;
import ir.eitaa.ui.ActionBar.ActionBarLayout;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.DrawerLayoutContainer;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.DrawerLayoutAdapter;
import ir.eitaa.ui.Cells.DrawerAddCell;
import ir.eitaa.ui.Cells.DrawerProfileCell;
import ir.eitaa.ui.Cells.DrawerUserCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BlockingUpdateView;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.ChatAttachAlertContactsLayout;
import ir.eitaa.ui.Components.EmbedBottomSheet;
import ir.eitaa.ui.Components.GroupCallPip;
import ir.eitaa.ui.Components.JoinGroupAlert;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.PasscodeView;
import ir.eitaa.ui.Components.PhonebookShareAlert;
import ir.eitaa.ui.Components.PipRoundVideoView;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RadialProgress2;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SideMenultItemAnimator;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import ir.eitaa.ui.Components.StickersAlert;
import ir.eitaa.ui.Components.TermsOfServiceView;
import ir.eitaa.ui.Components.ThemeEditorView;
import ir.eitaa.ui.Components.UpdateAppAlertDialog;
import ir.eitaa.ui.Components.voip.VoIPHelper;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.LocationActivity;
import ir.eitaa.ui.WallpapersListActivity;
import ir.eitaa.ui.explore.activity.ExploreActivity;
import ir.eitaa.ui.explore.activity.KavoshActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.linphone.mediastream.Factory;
import org.webrtc.MediaStreamTrack;
import org.webrtc.voiceengine.WebRtcAudioTrack;

/* loaded from: classes3.dex */
public class LaunchActivity extends Activity implements ActionBarLayout.ActionBarLayoutDelegate, NotificationCenter.NotificationCenterDelegate, DialogsActivity.DialogsActivityDelegate {
    public static boolean isShare = false;
    private ActionBarLayout actionBarLayout;
    private SizeNotifierFrameLayout backgroundTablet;
    private BlockingUpdateView blockingUpdateView;
    private ArrayList<TLRPC$User> contactsToSend;
    private Uri contactsToSendUri;
    private int currentAccount;
    private int currentConnectionState;
    private String documentsMimeType;
    private ArrayList<String> documentsOriginalPathsArray;
    private ArrayList<String> documentsPathsArray;
    private ArrayList<Uri> documentsUrisArray;
    private DrawerLayoutAdapter drawerLayoutAdapter;
    public DrawerLayoutContainer drawerLayoutContainer;
    private HashMap<String, String> englishLocaleStrings;
    private Uri exportingChatUri;
    private boolean finished;
    private FrameLayout frameLayout;
    private ArrayList<Parcelable> importingStickers;
    private ArrayList<String> importingStickersEmoji;
    private String importingStickersSoftware;
    private SideMenultItemAnimator itemAnimator;
    private ActionBarLayout layersActionBarLayout;
    private boolean loadingLocaleDialog;
    private TLRPC$TL_theme loadingTheme;
    private boolean loadingThemeAccent;
    private String loadingThemeFileName;
    private Theme.ThemeInfo loadingThemeInfo;
    private AlertDialog loadingThemeProgressDialog;
    private TLRPC$TL_wallPaper loadingThemeWallpaper;
    private String loadingThemeWallpaperName;
    private AlertDialog localeDialog;
    private Runnable lockRunnable;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private Intent passcodeSaveIntent;
    private boolean passcodeSaveIntentIsNew;
    private boolean passcodeSaveIntentIsRestore;
    private PasscodeView passcodeView;
    private ArrayList<SendMessagesHelper.SendingMediaInfo> photoPathsArray;
    private AlertDialog proxyErrorDialog;
    private ActionBarLayout rightActionBarLayout;
    private String sendingText;
    private FrameLayout shadowTablet;
    private FrameLayout shadowTabletSide;
    private RecyclerListView sideMenu;
    private FrameLayout sideMenuContainer;
    private HashMap<String, String> systemLocaleStrings;
    private boolean tabletFullSize;
    private TermsOfServiceView termsOfServiceView;
    private ImageView themeSwitchImageView;
    private RLottieDrawable themeSwitchSunDrawable;
    private View themeSwitchSunView;
    private FrameLayout updateLayout;
    private RadialProgress2 updateLayoutIcon;
    private TextView updateSizeTextView;
    private SimpleTextView updateTextView;
    private String videoPath;
    private ActionMode visibleActionMode;
    private AlertDialog visibleDialog;
    private boolean wasMutedByAdminRaisedHand;
    private static ArrayList<BaseFragment> mainFragmentsStack = new ArrayList<>();
    private static ArrayList<BaseFragment> layerFragmentsStack = new ArrayList<>();
    private static ArrayList<BaseFragment> rightFragmentsStack = new ArrayList<>();

    static /* synthetic */ void lambda$onCreate$1(View view) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$onCreate$0$LaunchActivity(View view, MotionEvent motionEvent) {
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
    /* renamed from: lambda$onCreate$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$2$LaunchActivity(View view, int i, float f, float f2) throws InterruptedException, IOException {
        if (i == 0) {
            DrawerProfileCell drawerProfileCell = (DrawerProfileCell) view;
            if (drawerProfileCell.isInAvatar(f, f2)) {
                openSettings(drawerProfileCell.hasAvatar());
                return;
            } else {
                this.drawerLayoutAdapter.setAccountsShown(!r12.isAccountsShown(), true);
                return;
            }
        }
        if (view instanceof DrawerUserCell) {
            switchToAccount(((DrawerUserCell) view).getAccountNumber(), true);
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (view instanceof DrawerAddCell) {
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= 3) {
                    break;
                }
                if (!UserConfig.getInstance(i3).isClientActivated()) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 >= 0) {
                lambda$runLinkRequest$39(new LoginActivity(i2));
            }
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        int id = this.drawerLayoutAdapter.getId(i);
        if (id == 2) {
            lambda$runLinkRequest$39(new GroupCreateActivity(new Bundle()));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 3) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("onlyUsers", true);
            bundle.putBoolean("destroyAfterSelect", true);
            bundle.putBoolean("createSecretChat", true);
            bundle.putBoolean("allowBots", false);
            bundle.putBoolean("allowSelf", false);
            lambda$runLinkRequest$39(new ContactsActivity(bundle));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 4) {
            SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
            if (!BuildVars.DEBUG_VERSION && globalMainSettings.getBoolean("channel_intro", false)) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("step", 0);
                lambda$runLinkRequest$39(new ChannelCreateActivity(bundle2));
            } else {
                lambda$runLinkRequest$39(new ActionIntroActivity(0));
                globalMainSettings.edit().putBoolean("channel_intro", true).commit();
            }
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 6) {
            lambda$runLinkRequest$39(new ContactsActivity(null));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 7) {
            lambda$runLinkRequest$39(new InviteContactsActivity());
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 8) {
            openSettings(false);
            return;
        }
        if (id == 9) {
            Browser.openUrl(this, LocaleController.getString("EitaaFaqUrl", R.string.EitaaFaqUrl));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 10) {
            lambda$runLinkRequest$39(new CallLogActivity());
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 11) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong("user_id", UserConfig.getInstance(this.currentAccount).getClientUserId());
            lambda$runLinkRequest$39(new ChatActivity(bundle3));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 13) {
            Browser.openUrl(this, LocaleController.getString("EitaaFeaturesUrl", R.string.EitaaFeaturesUrl));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 14) {
            lambda$runLinkRequest$39(new PaymentActivity(new Bundle()));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 15) {
            lambda$runLinkRequest$39(new CacheControlActivity());
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 1380) {
            Browser.openUrl(this, MessagesController.getInstance(this.currentAccount).appURL);
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 1381) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            LockedChatAction lockedChatAction = new LockedChatAction();
            lockedChatAction.fragment = new LockedChatsActivity();
            showPasscodeActivity(true, false, lockedChatAction, iArr[0] + ((int) f), iArr[1] + ((int) f2), null, null);
            return;
        }
        if (id == 1382) {
            MessagesController.getInstance(UserConfig.selectedAccount).restartAllActions();
        } else if (id == 1383) {
            if (CallOutManager.getCall() != null) {
                CallOutManager.goToLastCall(this.actionBarLayout.getLastFragment());
            } else {
                lambda$runLinkRequest$39(new StartCallOutActivity());
            }
            this.drawerLayoutContainer.closeDrawer(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$onCreate$3$LaunchActivity(ItemTouchHelper itemTouchHelper, View view, int i) {
        if (!(view instanceof DrawerUserCell)) {
            return false;
        }
        final int accountNumber = ((DrawerUserCell) view).getAccountNumber();
        if (accountNumber == this.currentAccount || AndroidUtilities.isTablet()) {
            itemTouchHelper.startDrag(this.sideMenu.getChildViewHolder(view));
            return false;
        }
        DialogsActivity dialogsActivity = new DialogsActivity(null) { // from class: ir.eitaa.ui.LaunchActivity.8
            @Override // ir.eitaa.ui.DialogsActivity, ir.eitaa.ui.ActionBar.BaseFragment
            protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
                super.onTransitionAnimationEnd(isOpen, backward);
                if (isOpen || !backward) {
                    return;
                }
                LaunchActivity.this.drawerLayoutContainer.setDrawCurrentPreviewFragmentAbove(false);
            }

            @Override // ir.eitaa.ui.ActionBar.BaseFragment
            protected void onPreviewOpenAnimationEnd() {
                super.onPreviewOpenAnimationEnd();
                LaunchActivity.this.drawerLayoutContainer.setAllowOpenDrawer(false, false);
                LaunchActivity.this.drawerLayoutContainer.setDrawCurrentPreviewFragmentAbove(false);
                LaunchActivity.this.switchToAccount(accountNumber, true);
            }
        };
        dialogsActivity.setCurrentAccount(accountNumber);
        this.actionBarLayout.presentFragmentAsPreview(dialogsActivity);
        this.drawerLayoutContainer.setDrawCurrentPreviewFragmentAbove(true);
        return true;
    }

    static /* synthetic */ void lambda$onCreate$4(View view) {
        int measuredHeight = view.getMeasuredHeight();
        FileLog.d("height = " + measuredHeight + " displayHeight = " + AndroidUtilities.displaySize.y);
        if (Build.VERSION.SDK_INT >= 21) {
            measuredHeight -= AndroidUtilities.statusBarHeight;
        }
        if (measuredHeight <= AndroidUtilities.dp(100.0f) || measuredHeight >= AndroidUtilities.displaySize.y) {
            return;
        }
        int iDp = AndroidUtilities.dp(100.0f) + measuredHeight;
        Point point = AndroidUtilities.displaySize;
        if (iDp > point.y) {
            point.y = measuredHeight;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("fix display size y to " + AndroidUtilities.displaySize.y);
            }
        }
    }

    private void openSettings(boolean expanded) {
        Bundle bundle = new Bundle();
        bundle.putLong("user_id", UserConfig.getInstance(this.currentAccount).clientUserId);
        if (expanded) {
            bundle.putBoolean("expandPhoto", true);
        }
        lambda$runLinkRequest$39(new ProfileActivity(bundle));
        this.drawerLayoutContainer.closeDrawer(false);
    }

    private void checkSystemBarColors() {
        checkSystemBarColors(true, true);
    }

    private void checkSystemBarColors(boolean checkStatusBar, boolean checkNavigationBar) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (checkStatusBar) {
                AndroidUtilities.setLightStatusBar(getWindow(), Theme.getColor("actionBarDefault", null, true) == -1);
            }
            if (i >= 26 && checkNavigationBar) {
                Window window = getWindow();
                int color = Theme.getColor("windowBackgroundGray", null, true);
                if (window.getNavigationBarColor() != color) {
                    window.setNavigationBarColor(color);
                    AndroidUtilities.setLightNavigationBar(getWindow(), AndroidUtilities.computePerceivedBrightness(color) >= 0.721f);
                }
            }
        }
        if (SharedConfig.noStatusBar && i >= 21 && checkStatusBar) {
            getWindow().setStatusBarColor(0);
        }
    }

    public void switchToAccount(int account, boolean removeAll) {
        if (account == UserConfig.selectedAccount || !UserConfig.isValidAccount(account)) {
            return;
        }
        ConnectionsManager.getInstance(this.currentAccount).setAppPaused(true, false);
        UserConfig.selectedAccount = account;
        UserConfig.getInstance(0).saveConfig(false);
        ConnectionsManager.getInstance(account);
        checkCurrentAccount();
        if (AndroidUtilities.isTablet()) {
            this.layersActionBarLayout.removeAllFragments();
            this.rightActionBarLayout.removeAllFragments();
            if (!this.tabletFullSize) {
                this.shadowTabletSide.setVisibility(0);
                if (this.rightActionBarLayout.fragmentsStack.isEmpty()) {
                    this.backgroundTablet.setVisibility(0);
                }
                this.rightActionBarLayout.setVisibility(8);
            }
            this.layersActionBarLayout.setVisibility(8);
        }
        if (removeAll) {
            this.actionBarLayout.removeAllFragments();
        } else {
            this.actionBarLayout.removeFragmentFromStack(0);
        }
        int iNeedSwitchToTheme = Theme.needSwitchToTheme();
        if (iNeedSwitchToTheme == 2) {
            Theme.applyTheme(Theme.currentNightTheme, false, false, iNeedSwitchToTheme == 2);
        } else {
            Theme.switchTheme(UserConfig.selectedAccount);
        }
        DialogsActivity dialogsActivity = new DialogsActivity(null);
        dialogsActivity.setSideMenu(this.sideMenu);
        this.actionBarLayout.addFragmentToStack(dialogsActivity, 0);
        this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
        this.actionBarLayout.showLastFragment();
        if (AndroidUtilities.isTablet()) {
            this.layersActionBarLayout.showLastFragment();
            this.rightActionBarLayout.showLastFragment();
        }
        if (!ApplicationLoader.mainInterfacePaused) {
            ConnectionsManager.getInstance(this.currentAccount).setAppPaused(false, false);
        }
        if (UserConfig.getInstance(account).unacceptedTermsOfService != null) {
            showTosActivity(account, UserConfig.getInstance(account).unacceptedTermsOfService);
        }
        updateCurrentConnectionState(this.currentAccount);
    }

    private void switchToAvailableAccountOrLogout() {
        int i = 0;
        while (true) {
            if (i >= 3) {
                i = -1;
                break;
            } else if (UserConfig.getInstance(i).isClientActivated()) {
                break;
            } else {
                i++;
            }
        }
        TermsOfServiceView termsOfServiceView = this.termsOfServiceView;
        if (termsOfServiceView != null) {
            termsOfServiceView.setVisibility(8);
        }
        if (i != -1) {
            switchToAccount(i, true);
            return;
        }
        DrawerLayoutAdapter drawerLayoutAdapter = this.drawerLayoutAdapter;
        if (drawerLayoutAdapter != null) {
            drawerLayoutAdapter.notifyDataSetChanged();
        }
        clearFragments();
        startActivity(new Intent(this, (Class<?>) IntroActivity.class));
        onFinish();
        finish();
    }

    public static void clearFragments() {
        Iterator<BaseFragment> it = mainFragmentsStack.iterator();
        while (it.hasNext()) {
            it.next().onFragmentDestroy();
        }
        mainFragmentsStack.clear();
        if (AndroidUtilities.isTablet()) {
            Iterator<BaseFragment> it2 = layerFragmentsStack.iterator();
            while (it2.hasNext()) {
                it2.next().onFragmentDestroy();
            }
            layerFragmentsStack.clear();
            Iterator<BaseFragment> it3 = rightFragmentsStack.iterator();
            while (it3.hasNext()) {
                it3.next().onFragmentDestroy();
            }
            rightFragmentsStack.clear();
        }
    }

    public int getMainFragmentsCount() {
        return mainFragmentsStack.size();
    }

    private void checkCurrentAccount() {
        int i = this.currentAccount;
        if (i != UserConfig.selectedAccount) {
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.appDidLogout);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mainUserInfoChanged);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didUpdateConnectionState);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.socketAvailable);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.needShowAlert);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.wasUnableToFindCurrentLocation);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.openArticle);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.hasNewContactsToImport);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.needShowPlayServicesAlert);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoaded);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoadProgressChanged);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoadFailed);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.historyImportProgressChanged);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.groupCallUpdated);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.stickersImportComplete);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.newSuggestionsAvailable);
        }
        int i2 = UserConfig.selectedAccount;
        this.currentAccount = i2;
        NotificationCenter.getInstance(i2).addObserver(this, NotificationCenter.appDidLogout);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.mainUserInfoChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didUpdateConnectionState);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.socketAvailable);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.needShowAlert);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.wasUnableToFindCurrentLocation);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.openArticle);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.hasNewContactsToImport);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.needShowPlayServicesAlert);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoaded);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoadProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoadFailed);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.historyImportProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.groupCallUpdated);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.stickersImportComplete);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.newSuggestionsAvailable);
    }

    private void checkLayout() {
        if (!AndroidUtilities.isTablet() || this.rightActionBarLayout == null) {
            return;
        }
        if (!AndroidUtilities.isInMultiwindow && (!AndroidUtilities.isSmallTablet() || getResources().getConfiguration().orientation == 2)) {
            this.tabletFullSize = false;
            if (this.actionBarLayout.fragmentsStack.size() >= 2) {
                while (1 < this.actionBarLayout.fragmentsStack.size()) {
                    BaseFragment baseFragment = this.actionBarLayout.fragmentsStack.get(1);
                    if (baseFragment instanceof ChatActivity) {
                        ((ChatActivity) baseFragment).setIgnoreAttachOnPause(true);
                    }
                    baseFragment.onPause();
                    this.actionBarLayout.fragmentsStack.remove(1);
                    this.rightActionBarLayout.fragmentsStack.add(baseFragment);
                }
                PasscodeView passcodeView = this.passcodeView;
                if (passcodeView == null || passcodeView.getVisibility() != 0) {
                    this.actionBarLayout.showLastFragment();
                    this.rightActionBarLayout.showLastFragment();
                }
            }
            ActionBarLayout actionBarLayout = this.rightActionBarLayout;
            actionBarLayout.setVisibility(actionBarLayout.fragmentsStack.isEmpty() ? 8 : 0);
            this.backgroundTablet.setVisibility(this.rightActionBarLayout.fragmentsStack.isEmpty() ? 0 : 8);
            this.shadowTabletSide.setVisibility(this.actionBarLayout.fragmentsStack.isEmpty() ? 8 : 0);
            return;
        }
        this.tabletFullSize = true;
        if (!this.rightActionBarLayout.fragmentsStack.isEmpty()) {
            while (this.rightActionBarLayout.fragmentsStack.size() > 0) {
                BaseFragment baseFragment2 = this.rightActionBarLayout.fragmentsStack.get(0);
                if (baseFragment2 instanceof ChatActivity) {
                    ((ChatActivity) baseFragment2).setIgnoreAttachOnPause(true);
                }
                baseFragment2.onPause();
                this.rightActionBarLayout.fragmentsStack.remove(0);
                this.actionBarLayout.fragmentsStack.add(baseFragment2);
            }
            PasscodeView passcodeView2 = this.passcodeView;
            if (passcodeView2 == null || passcodeView2.getVisibility() != 0) {
                this.actionBarLayout.showLastFragment();
            }
        }
        this.shadowTabletSide.setVisibility(8);
        this.rightActionBarLayout.setVisibility(8);
        this.backgroundTablet.setVisibility(this.actionBarLayout.fragmentsStack.isEmpty() ? 0 : 8);
    }

    private void showUpdateActivity(int account, TLRPC$TL_help_appUpdate update, boolean check) {
        if (this.blockingUpdateView == null) {
            BlockingUpdateView blockingUpdateView = new BlockingUpdateView(this) { // from class: ir.eitaa.ui.LaunchActivity.9
                @Override // ir.eitaa.ui.Components.BlockingUpdateView, android.view.View
                public void setVisibility(int visibility) {
                    super.setVisibility(visibility);
                    if (visibility == 8) {
                        LaunchActivity.this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
                    }
                }
            };
            this.blockingUpdateView = blockingUpdateView;
            this.drawerLayoutContainer.addView(blockingUpdateView, LayoutHelper.createFrame(-1, -1.0f));
        }
        this.blockingUpdateView.show(account, update, check);
        this.drawerLayoutContainer.setAllowOpenDrawer(false, false);
    }

    private void showTosActivity(int account, TLRPC$TL_help_termsOfService tos) {
        if (this.termsOfServiceView == null) {
            TermsOfServiceView termsOfServiceView = new TermsOfServiceView(this);
            this.termsOfServiceView = termsOfServiceView;
            termsOfServiceView.setAlpha(0.0f);
            this.drawerLayoutContainer.addView(this.termsOfServiceView, LayoutHelper.createFrame(-1, -1.0f));
            this.termsOfServiceView.setDelegate(new AnonymousClass10());
        }
        TLRPC$TL_help_termsOfService tLRPC$TL_help_termsOfService = UserConfig.getInstance(account).unacceptedTermsOfService;
        if (tLRPC$TL_help_termsOfService != tos && (tLRPC$TL_help_termsOfService == null || !tLRPC$TL_help_termsOfService.id.data.equals(tos.id.data))) {
            UserConfig.getInstance(account).unacceptedTermsOfService = tos;
            UserConfig.getInstance(account).saveConfig(false);
        }
        this.termsOfServiceView.show(account, tos);
        this.drawerLayoutContainer.setAllowOpenDrawer(false, false);
        this.termsOfServiceView.animate().alpha(1.0f).setDuration(150L).setInterpolator(AndroidUtilities.decelerateInterpolator).setListener(null).start();
    }

    /* renamed from: ir.eitaa.ui.LaunchActivity$10, reason: invalid class name */
    class AnonymousClass10 implements TermsOfServiceView.TermsOfServiceViewDelegate {
        AnonymousClass10() {
        }

        @Override // ir.eitaa.ui.Components.TermsOfServiceView.TermsOfServiceViewDelegate
        public void onAcceptTerms(int account) {
            UserConfig.getInstance(account).unacceptedTermsOfService = null;
            UserConfig.getInstance(account).saveConfig(false);
            LaunchActivity.this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
            if (LaunchActivity.mainFragmentsStack.size() > 0) {
                ((BaseFragment) LaunchActivity.mainFragmentsStack.get(LaunchActivity.mainFragmentsStack.size() - 1)).onResume();
            }
            LaunchActivity.this.termsOfServiceView.animate().alpha(0.0f).setDuration(150L).setInterpolator(AndroidUtilities.accelerateInterpolator).withEndAction(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$10$Us5DuLZYZio8sAHftvj5ycMMICw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAcceptTerms$0$LaunchActivity$10();
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAcceptTerms$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAcceptTerms$0$LaunchActivity$10() {
            LaunchActivity.this.termsOfServiceView.setVisibility(8);
        }
    }

    public void showPasscodeActivity(boolean fingerprint, boolean animated, int x, int y, Runnable onShow, Runnable onStart) throws InterruptedException, IOException {
        showPasscodeActivity(fingerprint, animated, null, x, y, onShow, onStart);
    }

    public void showPasscodeActivity(boolean fingerprint, boolean animated, final LockedChatAction lockedChatAction, int x, int y, final Runnable onShow, Runnable onStart) throws InterruptedException, IOException {
        if (this.drawerLayoutContainer == null) {
            return;
        }
        if (this.passcodeView == null) {
            PasscodeView passcodeView = new PasscodeView(this);
            this.passcodeView = passcodeView;
            this.drawerLayoutContainer.addView(passcodeView, LayoutHelper.createFrame(-1, -1.0f));
        }
        if (lockedChatAction == null) {
            SharedConfig.appLocked = true;
        }
        if (SecretMediaViewer.hasInstance() && SecretMediaViewer.getInstance().isVisible()) {
            SecretMediaViewer.getInstance().closePhoto(false, false);
        } else if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
            PhotoViewer.getInstance().closePhoto(false, true);
        } else if (ArticleViewer.hasInstance() && ArticleViewer.getInstance().isVisible()) {
            ArticleViewer.getInstance().close(false, true);
        }
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        if (playingMessageObject != null && playingMessageObject.isRoundVideo()) {
            MediaController.getInstance().cleanupPlayer(true, true);
        }
        this.passcodeView.onShow(fingerprint, animated, lockedChatAction != null, x, y, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$agowmK9AbKpWJp17iTkUsgIzmfw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPasscodeActivity$5$LaunchActivity(onShow);
            }
        }, onStart);
        SharedConfig.isWaitingForPasscodeEnter = true;
        this.drawerLayoutContainer.setAllowOpenDrawer(false, false);
        this.passcodeView.setDelegate(new PasscodeView.PasscodeViewDelegate() { // from class: ir.eitaa.ui.LaunchActivity.11
            @Override // ir.eitaa.ui.Components.PasscodeView.PasscodeViewDelegate
            public void didAcceptedPassword() throws Throwable {
                LockedChatAction lockedChatAction2;
                SharedConfig.isWaitingForPasscodeEnter = false;
                if (LaunchActivity.this.passcodeSaveIntent != null) {
                    LaunchActivity launchActivity = LaunchActivity.this;
                    launchActivity.handleIntent(launchActivity.passcodeSaveIntent, LaunchActivity.this.passcodeSaveIntentIsNew, LaunchActivity.this.passcodeSaveIntentIsRestore, true);
                    LaunchActivity.this.passcodeSaveIntent = null;
                }
                LaunchActivity.this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
                LaunchActivity.this.actionBarLayout.setVisibility(0);
                LaunchActivity.this.actionBarLayout.showLastFragment();
                if (AndroidUtilities.isTablet()) {
                    LaunchActivity.this.layersActionBarLayout.showLastFragment();
                    LaunchActivity.this.rightActionBarLayout.showLastFragment();
                    if (LaunchActivity.this.layersActionBarLayout.getVisibility() == 4) {
                        LaunchActivity.this.layersActionBarLayout.setVisibility(0);
                    }
                    LaunchActivity.this.rightActionBarLayout.setVisibility(0);
                }
                if (!LaunchActivity.this.passcodeView.isChatLock || (lockedChatAction2 = lockedChatAction) == null) {
                    return;
                }
                if (lockedChatAction2.fragment != null && !(LaunchActivity.this.actionBarLayout.getLastFragment() instanceof LockedChatsActivity)) {
                    LaunchActivity.this.actionBarLayout.presentFragment(lockedChatAction.fragment, false, true, true, false, false);
                    return;
                }
                Long l = lockedChatAction.dialogId;
                if (l != null) {
                    ChatLockHelper.setChatAsUnlocked(l);
                }
            }

            @Override // ir.eitaa.ui.Components.PasscodeView.PasscodeViewDelegate
            public void onFinish() {
                SharedConfig.isWaitingForPasscodeEnter = false;
                LaunchActivity.this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
                LaunchActivity.this.actionBarLayout.setVisibility(0);
                LaunchActivity.this.actionBarLayout.showLastFragment();
                if (AndroidUtilities.isTablet()) {
                    LaunchActivity.this.layersActionBarLayout.showLastFragment();
                    LaunchActivity.this.rightActionBarLayout.showLastFragment();
                    if (LaunchActivity.this.layersActionBarLayout.getVisibility() == 4) {
                        LaunchActivity.this.layersActionBarLayout.setVisibility(0);
                    }
                    LaunchActivity.this.rightActionBarLayout.setVisibility(0);
                }
                if (lockedChatAction != null) {
                    if ((LaunchActivity.this.actionBarLayout.getLastFragment() instanceof ProfileActivity) || (LaunchActivity.this.actionBarLayout.getLastFragment() instanceof ChatActivity)) {
                        LaunchActivity.this.actionBarLayout.getLastFragment().finishFragment();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPasscodeActivity$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPasscodeActivity$5$LaunchActivity(Runnable runnable) {
        this.actionBarLayout.setVisibility(4);
        if (AndroidUtilities.isTablet()) {
            if (this.layersActionBarLayout.getVisibility() == 0) {
                this.layersActionBarLayout.setVisibility(4);
            }
            this.rightActionBarLayout.setVisibility(4);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    private boolean isNumeric(String stringVal) {
        return stringVal.matches("^[\\$]?[-+]?[\\d\\.,]*[\\.,]?\\d+$");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleIntent(android.content.Intent r66, boolean r67, boolean r68, boolean r69) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 8380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.handleIntent(android.content.Intent, boolean, boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$6$LaunchActivity(Intent intent, boolean z) throws Throwable {
        handleIntent(intent, true, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$7$LaunchActivity(Bundle bundle) {
        lambda$runLinkRequest$39(new CancelAccountDeletionActivity(bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$9$LaunchActivity(final int[] iArr, LocationController.SharingLocationInfo sharingLocationInfo) {
        iArr[0] = sharingLocationInfo.messageObject.currentAccount;
        switchToAccount(iArr[0], true);
        LocationActivity locationActivity = new LocationActivity(2);
        locationActivity.setMessageObject(sharingLocationInfo.messageObject);
        final long dialogId = sharingLocationInfo.messageObject.getDialogId();
        locationActivity.setDelegate(new LocationActivity.LocationActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$nIcvAT_EVhP-G-AKG1YdNVQM_sA
        });
        lambda$runLinkRequest$39(locationActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$10$LaunchActivity() {
        if (this.actionBarLayout.fragmentsStack.isEmpty()) {
            return;
        }
        this.actionBarLayout.fragmentsStack.get(0).showDialog(new StickersAlert(this, this.importingStickersSoftware, this.importingStickers, this.importingStickersEmoji, (Theme.ResourcesProvider) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$11$LaunchActivity(BaseFragment baseFragment, boolean z) {
        presentFragment(baseFragment, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$12$LaunchActivity(boolean z, int[] iArr, TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity) {
        TLRPC$UserFull userFull = MessagesController.getInstance(this.currentAccount).getUserFull(tLRPC$User.id);
        VoIPHelper.startCall(tLRPC$User, z, userFull != null && userFull.video_calls_available, this, userFull, AccountInstance.getInstance(iArr[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$handleIntent$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$handleIntent$16$LaunchActivity(final ActionIntroActivity actionIntroActivity, String str) {
        final AlertDialog alertDialog = new AlertDialog(this, 3);
        alertDialog.setCanCacnel(false);
        alertDialog.show();
        byte[] bArrDecode = Base64.decode(str.substring(17), 8);
        TLRPC$TL_auth_acceptLoginToken tLRPC$TL_auth_acceptLoginToken = new TLRPC$TL_auth_acceptLoginToken();
        tLRPC$TL_auth_acceptLoginToken.token = bArrDecode;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_auth_acceptLoginToken, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$BfGiFhSuELdpkerklzNshHgZrVc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$bga578j9zC_iRqd0qB6xjSkvhkA
                    @Override // java.lang.Runnable
                    public final void run() {
                        LaunchActivity.lambda$handleIntent$14(alertDialog, tLObject, actionIntroActivity, tLRPC$TL_error);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$handleIntent$14(AlertDialog alertDialog, TLObject tLObject, final ActionIntroActivity actionIntroActivity, final TLRPC$TL_error tLRPC$TL_error) {
        try {
            alertDialog.dismiss();
        } catch (Exception unused) {
        }
        if (tLObject instanceof TLRPC$TL_authorization) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$4XWeohHEC9stbOiw_lOkb96WDXs
            @Override // java.lang.Runnable
            public final void run() {
                AlertsCreator.showSimpleAlert(actionIntroActivity, LocaleController.getString("AuthAnotherClient", R.string.AuthAnotherClient), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + tLRPC$TL_error.text);
            }
        });
    }

    static /* synthetic */ void lambda$handleIntent$17(String str, String str2, BaseFragment baseFragment, DialogInterface dialogInterface, int i) {
        NewContactActivity newContactActivity = new NewContactActivity();
        newContactActivity.setInitialPhoneNumber(str, false);
        if (str2 != null) {
            String[] strArrSplit = str2.split(" ", 2);
            newContactActivity.setInitialName(strArrSplit[0], strArrSplit.length > 1 ? strArrSplit[1] : null);
        }
        baseFragment.presentFragment(newContactActivity);
    }

    public static int getTimestampFromLink(Uri data) {
        String queryParameter;
        int i;
        if (data.getPathSegments().contains(MediaStreamTrack.VIDEO_TRACK_KIND)) {
            queryParameter = data.getQuery();
        } else {
            queryParameter = data.getQueryParameter("t") != null ? data.getQueryParameter("t") : null;
        }
        if (queryParameter == null) {
            return -1;
        }
        try {
            i = Integer.parseInt(queryParameter);
        } catch (Throwable unused) {
            i = -1;
        }
        if (i == -1) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
            try {
                return (int) ((simpleDateFormat.parse(queryParameter).getTime() - simpleDateFormat.parse("00:00").getTime()) / 1000);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void openDialogsToSend(boolean r12) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.openDialogsToSend(boolean):void");
    }

    private int runCommentRequest(final int intentAccount, final AlertDialog progressDialog, final Integer messageId, final Integer commentId, final Integer threadId, final TLRPC$Chat chat) {
        if (chat == null) {
            return 0;
        }
        final TLRPC$TL_messages_getDiscussionMessage tLRPC$TL_messages_getDiscussionMessage = new TLRPC$TL_messages_getDiscussionMessage();
        tLRPC$TL_messages_getDiscussionMessage.peer = MessagesController.getInputPeer(chat);
        tLRPC$TL_messages_getDiscussionMessage.msg_id = (commentId != null ? messageId : threadId).intValue();
        return ConnectionsManager.getInstance(intentAccount).sendRequest(tLRPC$TL_messages_getDiscussionMessage, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$KF94pn1wKzZGiZSpBRlRwC1_s0M
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$runCommentRequest$19$LaunchActivity(intentAccount, messageId, chat, tLRPC$TL_messages_getDiscussionMessage, commentId, threadId, progressDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runCommentRequest$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runCommentRequest$19$LaunchActivity(final int i, final Integer num, final TLRPC$Chat tLRPC$Chat, final TLRPC$TL_messages_getDiscussionMessage tLRPC$TL_messages_getDiscussionMessage, final Integer num2, final Integer num3, final AlertDialog alertDialog, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$ZK_0keGs0d1zvW-HDRws2oEHzGk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runCommentRequest$18$LaunchActivity(tLObject, i, num, tLRPC$Chat, tLRPC$TL_messages_getDiscussionMessage, num2, num3, alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0091  */
    /* renamed from: lambda$runCommentRequest$18, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$runCommentRequest$18$LaunchActivity(ir.eitaa.tgnet.TLObject r12, int r13, java.lang.Integer r14, ir.eitaa.tgnet.TLRPC$Chat r15, ir.eitaa.tgnet.TLRPC$TL_messages_getDiscussionMessage r16, java.lang.Integer r17, java.lang.Integer r18, ir.eitaa.ui.ActionBar.AlertDialog r19) {
        /*
            r11 = this;
            r0 = r12
            boolean r1 = r0 instanceof ir.eitaa.tgnet.TLRPC$TL_messages_discussionMessage
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L91
            ir.eitaa.tgnet.TLRPC$TL_messages_discussionMessage r0 = (ir.eitaa.tgnet.TLRPC$TL_messages_discussionMessage) r0
            ir.eitaa.messenger.MessagesController r1 = ir.eitaa.messenger.MessagesController.getInstance(r13)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$User> r4 = r0.users
            r1.putUsers(r4, r2)
            ir.eitaa.messenger.MessagesController r1 = ir.eitaa.messenger.MessagesController.getInstance(r13)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Chat> r4 = r0.chats
            r1.putChats(r4, r2)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r1 = r0.messages
            int r1 = r1.size()
            r4 = 0
        L27:
            if (r4 >= r1) goto L3e
            ir.eitaa.messenger.MessageObject r5 = new ir.eitaa.messenger.MessageObject
            int r7 = ir.eitaa.messenger.UserConfig.selectedAccount
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Message> r8 = r0.messages
            java.lang.Object r8 = r8.get(r4)
            ir.eitaa.tgnet.TLRPC$Message r8 = (ir.eitaa.tgnet.TLRPC$Message) r8
            r5.<init>(r7, r8, r3, r3)
            r6.add(r5)
            int r4 = r4 + 1
            goto L27
        L3e:
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L91
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.Object r2 = r6.get(r2)
            ir.eitaa.messenger.MessageObject r2 = (ir.eitaa.messenger.MessageObject) r2
            long r4 = r2.getDialogId()
            long r4 = -r4
            java.lang.String r2 = "chat_id"
            r1.putLong(r2, r4)
            int r2 = r14.intValue()
            int r2 = java.lang.Math.max(r3, r2)
            java.lang.String r4 = "message_id"
            r1.putInt(r4, r2)
            ir.eitaa.ui.ChatActivity r2 = new ir.eitaa.ui.ChatActivity
            r2.<init>(r1)
            r1 = r16
            int r8 = r1.msg_id
            int r9 = r0.read_inbox_max_id
            int r10 = r0.read_outbox_max_id
            r5 = r2
            r7 = r15
            r5.setThreadMessages(r6, r7, r8, r9, r10)
            if (r17 == 0) goto L82
            int r0 = r17.intValue()
            r2.setHighlightMessageId(r0)
            goto L8b
        L82:
            if (r18 == 0) goto L8b
            int r0 = r14.intValue()
            r2.setHighlightMessageId(r0)
        L8b:
            r1 = r11
            r11.lambda$runLinkRequest$39(r2)
            r2 = 1
            goto L92
        L91:
            r1 = r11
        L92:
            if (r2 != 0) goto Lc2
            java.util.ArrayList<ir.eitaa.ui.ActionBar.BaseFragment> r0 = ir.eitaa.ui.LaunchActivity.mainFragmentsStack     // Catch: java.lang.Exception -> Lbe
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> Lbe
            if (r0 != 0) goto Lc2
            java.util.ArrayList<ir.eitaa.ui.ActionBar.BaseFragment> r0 = ir.eitaa.ui.LaunchActivity.mainFragmentsStack     // Catch: java.lang.Exception -> Lbe
            int r2 = r0.size()     // Catch: java.lang.Exception -> Lbe
            int r2 = r2 - r3
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Exception -> Lbe
            ir.eitaa.ui.ActionBar.BaseFragment r0 = (ir.eitaa.ui.ActionBar.BaseFragment) r0     // Catch: java.lang.Exception -> Lbe
            ir.eitaa.ui.Components.BulletinFactory r0 = ir.eitaa.ui.Components.BulletinFactory.of(r0)     // Catch: java.lang.Exception -> Lbe
            java.lang.String r2 = "ChannelPostDeleted"
            r3 = 2131690535(0x7f0f0427, float:1.9010116E38)
            java.lang.String r2 = ir.eitaa.messenger.LocaleController.getString(r2, r3)     // Catch: java.lang.Exception -> Lbe
            ir.eitaa.ui.Components.Bulletin r0 = r0.createErrorBulletin(r2)     // Catch: java.lang.Exception -> Lbe
            r0.show()     // Catch: java.lang.Exception -> Lbe
            goto Lc2
        Lbe:
            r0 = move-exception
            ir.eitaa.messenger.FileLog.e(r0)
        Lc2:
            r19.dismiss()     // Catch: java.lang.Exception -> Lc6
            goto Lcb
        Lc6:
            r0 = move-exception
            r2 = r0
            ir.eitaa.messenger.FileLog.e(r2)
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.lambda$runCommentRequest$18$LaunchActivity(ir.eitaa.tgnet.TLObject, int, java.lang.Integer, ir.eitaa.tgnet.TLRPC$Chat, ir.eitaa.tgnet.TLRPC$TL_messages_getDiscussionMessage, java.lang.Integer, java.lang.Integer, ir.eitaa.ui.ActionBar.AlertDialog):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    private void runImportRequest(final Uri uri, ArrayList<Uri> arrayList) throws Throwable {
        InputStream inputStreamOpenInputStream;
        final int i = UserConfig.selectedAccount;
        final AlertDialog alertDialog = new AlertDialog(this, 3);
        final int[] iArr = {0};
        final ?? r3 = 0;
        r3 = 0;
        try {
            try {
                inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenInputStream));
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null || i2 >= 100) {
                    break;
                }
                sb.append(line);
                sb.append('\n');
                i2++;
            }
            String string = sb.toString();
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            TLRPC$TL_messages_checkHistoryImport tLRPC$TL_messages_checkHistoryImport = new TLRPC$TL_messages_checkHistoryImport();
            tLRPC$TL_messages_checkHistoryImport.import_head = string;
            iArr[0] = ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_messages_checkHistoryImport, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$Ryth7S1G68ntjCwT_6mTNRnpLZ0
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$runImportRequest$21$LaunchActivity(uri, i, alertDialog, tLObject, tLRPC$TL_error);
                }
            });
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$qVMl-L4jA-d7PgiSrn4qgy1rE10
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    LaunchActivity.lambda$runImportRequest$22(i, iArr, r3, dialogInterface);
                }
            });
            try {
                alertDialog.showDelayed(300L);
            } catch (Exception unused) {
            }
        } catch (Exception e3) {
            e = e3;
            r3 = inputStreamOpenInputStream;
            FileLog.e(e);
            if (r3 != 0) {
                try {
                    r3.close();
                } catch (Exception e4) {
                    FileLog.e(e4);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            r3 = inputStreamOpenInputStream;
            if (r3 != 0) {
                try {
                    r3.close();
                } catch (Exception e5) {
                    FileLog.e(e5);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runImportRequest$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runImportRequest$21$LaunchActivity(final Uri uri, final int i, final AlertDialog alertDialog, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$BuGFYnN0HUjN9Yzfx_fsb6w7LF8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runImportRequest$20$LaunchActivity(tLObject, uri, i, alertDialog);
            }
        }, 2L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0139  */
    /* renamed from: lambda$runImportRequest$20, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$runImportRequest$20$LaunchActivity(ir.eitaa.tgnet.TLObject r10, android.net.Uri r11, int r12, ir.eitaa.ui.ActionBar.AlertDialog r13) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.lambda$runImportRequest$20$LaunchActivity(ir.eitaa.tgnet.TLObject, android.net.Uri, int, ir.eitaa.ui.ActionBar.AlertDialog):void");
    }

    static /* synthetic */ void lambda$runImportRequest$22(int i, int[] iArr, Runnable runnable, DialogInterface dialogInterface) {
        ConnectionsManager.getInstance(i).cancelRequest(iArr[0], true);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0463  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void runLinkRequest(final int r30, final java.lang.String r31, final java.lang.String r32, final java.lang.String r33, final java.lang.String r34, final java.lang.String r35, final java.lang.String r36, final java.lang.String r37, final boolean r38, final java.lang.Integer r39, final java.lang.Long r40, final java.lang.Integer r41, final java.lang.Integer r42, final java.lang.String r43, final java.util.HashMap<java.lang.String, java.lang.String> r44, final java.lang.String r45, final java.lang.String r46, final java.lang.String r47, final java.lang.String r48, final ir.eitaa.tgnet.TLRPC$TL_wallPaper r49, final java.lang.String r50, final java.lang.String r51, final int r52, final int r53, final java.lang.String[] r54) {
        /*
            Method dump skipped, instructions count: 1137
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.runLinkRequest(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.Integer, java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.String, java.util.HashMap, java.lang.String, java.lang.String, java.lang.String, java.lang.String, ir.eitaa.tgnet.TLRPC$TL_wallPaper, java.lang.String, java.lang.String, int, int, java.lang.String[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$23$LaunchActivity(int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z, Integer num, Long l, Integer num2, Integer num3, String str7, HashMap map, String str8, String str9, String str10, String str11, TLRPC$TL_wallPaper tLRPC$TL_wallPaper, String str12, String str13, int i2, String[] strArr, int i3) {
        if (i3 != i) {
            switchToAccount(i3, true);
        }
        runLinkRequest(i3, str, str2, str3, str4, str5, str6, z, num, l, num2, num3, str7, map, str8, str9, str10, str11, tLRPC$TL_wallPaper, str12, str13, 1, i2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$27$LaunchActivity(final String str, final String str2, final int i, final Integer num, final Integer num2, final Integer num3, final int[] iArr, final AlertDialog alertDialog, final String str3, final String str4, final int i2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$vPqIZph_b-ZOxjkw1WfQgijTwm0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$26$LaunchActivity(tLObject, tLRPC$TL_error, str, str2, i, num, num2, num3, iArr, alertDialog, str3, str4, i2);
            }
        }, 2L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e6  */
    /* renamed from: lambda$runLinkRequest$26, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$runLinkRequest$26$LaunchActivity(ir.eitaa.tgnet.TLObject r15, ir.eitaa.tgnet.TLRPC$TL_error r16, final java.lang.String r17, java.lang.String r18, final int r19, java.lang.Integer r20, java.lang.Integer r21, java.lang.Integer r22, int[] r23, final ir.eitaa.ui.ActionBar.AlertDialog r24, final java.lang.String r25, java.lang.String r26, int r27) {
        /*
            Method dump skipped, instructions count: 818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.lambda$runLinkRequest$26$LaunchActivity(ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error, java.lang.String, java.lang.String, int, java.lang.Integer, java.lang.Integer, java.lang.Integer, int[], ir.eitaa.ui.ActionBar.AlertDialog, java.lang.String, java.lang.String, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$24$LaunchActivity(String str, int i, TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        TLRPC$TL_inputMediaGame tLRPC$TL_inputMediaGame = new TLRPC$TL_inputMediaGame();
        TLRPC$TL_inputGameShortName tLRPC$TL_inputGameShortName = new TLRPC$TL_inputGameShortName();
        tLRPC$TL_inputMediaGame.id = tLRPC$TL_inputGameShortName;
        tLRPC$TL_inputGameShortName.short_name = str;
        tLRPC$TL_inputGameShortName.bot_id = MessagesController.getInstance(i).getInputUser(tLRPC$TL_contacts_resolvedPeer.users.get(0));
        SendMessagesHelper.getInstance(i).sendGame(MessagesController.getInstance(i).getInputPeer(jLongValue), tLRPC$TL_inputMediaGame, 0L, 0L);
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        if (DialogObject.isEncryptedDialog(jLongValue)) {
            bundle.putInt("enc_id", DialogObject.getEncryptedChatId(jLongValue));
        } else if (DialogObject.isUserDialog(jLongValue)) {
            bundle.putLong("user_id", jLongValue);
        } else {
            bundle.putLong("chat_id", -jLongValue);
        }
        if (MessagesController.getInstance(i).checkCanOpenChat(bundle, dialogsActivity)) {
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.closeChats, new Object[0]);
            this.actionBarLayout.presentFragment(new ChatActivity(bundle), true, false, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$25$LaunchActivity(int i, TLRPC$User tLRPC$User, String str, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        long j = -jLongValue;
        bundle.putLong("chat_id", j);
        if (!mainFragmentsStack.isEmpty()) {
            MessagesController messagesController = MessagesController.getInstance(i);
            ArrayList<BaseFragment> arrayList2 = mainFragmentsStack;
            if (!messagesController.checkCanOpenChat(bundle, arrayList2.get(arrayList2.size() - 1))) {
                return;
            }
        }
        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.closeChats, new Object[0]);
        MessagesController.getInstance(i).addUserToChat(j, tLRPC$User, 0, str, null, null);
        this.actionBarLayout.presentFragment(new ChatActivity(bundle), true, false, true, false);
    }

    /* renamed from: ir.eitaa.ui.LaunchActivity$14, reason: invalid class name */
    class AnonymousClass14 implements RequestDelegate {
        final /* synthetic */ HashMap val$auth;
        final /* synthetic */ String val$botChat;
        final /* synthetic */ String val$botUser;
        final /* synthetic */ Long val$channelId;
        final /* synthetic */ String val$code;
        final /* synthetic */ Integer val$commentId;
        final /* synthetic */ String val$game;
        final /* synthetic */ String val$group;
        final /* synthetic */ boolean val$hasUrl;
        final /* synthetic */ String[] val$instantView;
        final /* synthetic */ int val$intentAccount;
        final /* synthetic */ String val$lang;
        final /* synthetic */ String val$loginToken;
        final /* synthetic */ String val$message;
        final /* synthetic */ Integer val$messageId;
        final /* synthetic */ AlertDialog val$progressDialog;
        final /* synthetic */ String val$sticker;
        final /* synthetic */ String val$theme;
        final /* synthetic */ Integer val$threadId;
        final /* synthetic */ String val$unsupportedUrl;
        final /* synthetic */ String val$username;
        final /* synthetic */ int val$videoTimestamp;
        final /* synthetic */ String val$voicechat;
        final /* synthetic */ TLRPC$TL_wallPaper val$wallPaper;

        AnonymousClass14(final AlertDialog val$progressDialog, final int val$intentAccount, final String val$username, final String val$group, final String val$sticker, final String val$botUser, final String val$botChat, final String val$message, final boolean val$hasUrl, final Integer val$messageId, final Long val$channelId, final Integer val$threadId, final Integer val$commentId, final String val$game, final HashMap val$auth, final String val$lang, final String val$unsupportedUrl, final String val$code, final String val$loginToken, final TLRPC$TL_wallPaper val$wallPaper, final String val$theme, final String val$voicechat, final int val$videoTimestamp, final String[] val$instantView) {
            this.val$progressDialog = val$progressDialog;
            this.val$intentAccount = val$intentAccount;
            this.val$username = val$username;
            this.val$group = val$group;
            this.val$sticker = val$sticker;
            this.val$botUser = val$botUser;
            this.val$botChat = val$botChat;
            this.val$message = val$message;
            this.val$hasUrl = val$hasUrl;
            this.val$messageId = val$messageId;
            this.val$channelId = val$channelId;
            this.val$threadId = val$threadId;
            this.val$commentId = val$commentId;
            this.val$game = val$game;
            this.val$auth = val$auth;
            this.val$lang = val$lang;
            this.val$unsupportedUrl = val$unsupportedUrl;
            this.val$code = val$code;
            this.val$loginToken = val$loginToken;
            this.val$wallPaper = val$wallPaper;
            this.val$theme = val$theme;
            this.val$voicechat = val$voicechat;
            this.val$videoTimestamp = val$videoTimestamp;
            this.val$instantView = val$instantView;
        }

        @Override // ir.eitaa.tgnet.RequestDelegate
        public void run(final TLObject response, final TLRPC$TL_error error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.LaunchActivity.14.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseFragment chatActivity;
                    if (LaunchActivity.this.isFinishing()) {
                        return;
                    }
                    try {
                        AnonymousClass14.this.val$progressDialog.dismiss();
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    if (error == null && LaunchActivity.this.actionBarLayout != null) {
                        TLObject tLObject = response;
                        if (tLObject instanceof TLRPC$TL_chatInvitePreview) {
                            final TLRPC$TL_chatInvitePreview tLRPC$TL_chatInvitePreview = (TLRPC$TL_chatInvitePreview) tLObject;
                            AlertDialog.Builder builder = new AlertDialog.Builder(LaunchActivity.this);
                            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                            Object[] objArr = new Object[1];
                            TLRPC$Chat tLRPC$Chat = tLRPC$TL_chatInvitePreview.chat;
                            objArr[0] = tLRPC$Chat != null ? tLRPC$Chat.title : tLRPC$TL_chatInvitePreview.title;
                            builder.setMessage(LocaleController.formatString("ChannelJoinTo", R.string.ChannelJoinTo, objArr));
                            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.LaunchActivity.14.1.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                                    LaunchActivity.this.runLinkRequest(anonymousClass14.val$intentAccount, anonymousClass14.val$username, anonymousClass14.val$group, anonymousClass14.val$sticker, anonymousClass14.val$botUser, anonymousClass14.val$botChat, anonymousClass14.val$message, anonymousClass14.val$hasUrl, anonymousClass14.val$messageId, anonymousClass14.val$channelId, anonymousClass14.val$threadId, anonymousClass14.val$commentId, anonymousClass14.val$game, anonymousClass14.val$auth, anonymousClass14.val$lang, anonymousClass14.val$unsupportedUrl, anonymousClass14.val$code, anonymousClass14.val$loginToken, anonymousClass14.val$wallPaper, anonymousClass14.val$theme, anonymousClass14.val$voicechat, 1, anonymousClass14.val$videoTimestamp, anonymousClass14.val$instantView);
                                }
                            });
                            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                            builder.setNeutralButton(LocaleController.getString("OpenChannel", R.string.OpenChannel), true, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.LaunchActivity.14.1.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialog, int which) {
                                    BaseFragment chatActivity2;
                                    if (tLRPC$TL_chatInvitePreview.chat != null) {
                                        MessagesController.getInstance(AnonymousClass14.this.val$intentAccount).putChat(tLRPC$TL_chatInvitePreview.chat, false);
                                        ArrayList<TLRPC$Chat> arrayList = new ArrayList<>();
                                        arrayList.add(tLRPC$TL_chatInvitePreview.chat);
                                        MessagesStorage.getInstance(AnonymousClass14.this.val$intentAccount).putUsersAndChats(null, arrayList, false, true);
                                        Bundle bundle = new Bundle();
                                        bundle.putLong("chat_id", tLRPC$TL_chatInvitePreview.chat.id);
                                        if (LaunchActivity.mainFragmentsStack.isEmpty() || MessagesController.getInstance(AnonymousClass14.this.val$intentAccount).checkCanOpenChat(bundle, (BaseFragment) LaunchActivity.mainFragmentsStack.get(LaunchActivity.mainFragmentsStack.size() - 1))) {
                                            TLRPC$Chat tLRPC$Chat2 = tLRPC$TL_chatInvitePreview.chat;
                                            if (tLRPC$Chat2.isMediaContent) {
                                                bundle.putLong("dialog_id", -tLRPC$Chat2.id);
                                                chatActivity2 = new MediaChannelActivity(bundle);
                                            } else {
                                                chatActivity2 = new ChatActivity(bundle);
                                            }
                                            LaunchActivity.this.actionBarLayout.presentFragment(chatActivity2, false, true, true, false);
                                        }
                                    }
                                }
                            });
                            LaunchActivity.this.showAlertDialog(builder);
                            return;
                        }
                        TLRPC$ChatInvite tLRPC$ChatInvite = (TLRPC$ChatInvite) tLObject;
                        TLRPC$Chat tLRPC$Chat2 = tLRPC$ChatInvite.chat;
                        if (tLRPC$Chat2 != null && !ChatObject.isLeftFromChat(tLRPC$Chat2)) {
                            MessagesController.getInstance(AnonymousClass14.this.val$intentAccount).putChat(tLRPC$ChatInvite.chat, false);
                            ArrayList<TLRPC$Chat> arrayList = new ArrayList<>();
                            arrayList.add(tLRPC$ChatInvite.chat);
                            MessagesStorage.getInstance(AnonymousClass14.this.val$intentAccount).putUsersAndChats(null, arrayList, false, true);
                            Bundle bundle = new Bundle();
                            bundle.putLong("chat_id", tLRPC$ChatInvite.chat.id);
                            if (LaunchActivity.mainFragmentsStack.isEmpty() || MessagesController.getInstance(AnonymousClass14.this.val$intentAccount).checkCanOpenChat(bundle, (BaseFragment) LaunchActivity.mainFragmentsStack.get(LaunchActivity.mainFragmentsStack.size() - 1))) {
                                TLRPC$Chat tLRPC$Chat3 = tLRPC$ChatInvite.chat;
                                if (tLRPC$Chat3.isMediaContent) {
                                    bundle.putLong("dialog_id", -tLRPC$Chat3.id);
                                    chatActivity = new MediaChannelActivity(bundle);
                                } else {
                                    chatActivity = new ChatActivity(bundle);
                                }
                                LaunchActivity.this.actionBarLayout.presentFragment(chatActivity, false, true, true, false);
                                return;
                            }
                            return;
                        }
                        TLRPC$Chat tLRPC$Chat4 = tLRPC$ChatInvite.chat;
                        if (((tLRPC$Chat4 == null && (!tLRPC$ChatInvite.channel || tLRPC$ChatInvite.megagroup)) || (tLRPC$Chat4 != null && (!ChatObject.isChannel(tLRPC$Chat4) || tLRPC$ChatInvite.chat.megagroup))) && !LaunchActivity.mainFragmentsStack.isEmpty()) {
                            BaseFragment baseFragment = (BaseFragment) LaunchActivity.mainFragmentsStack.get(LaunchActivity.mainFragmentsStack.size() - 1);
                            AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                            baseFragment.showDialog(new JoinGroupAlert(LaunchActivity.this, tLRPC$ChatInvite, anonymousClass14.val$group, baseFragment));
                            return;
                        }
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(LaunchActivity.this);
                        builder2.setTitle(LocaleController.getString("AppName", R.string.AppName));
                        Object[] objArr2 = new Object[1];
                        TLRPC$Chat tLRPC$Chat5 = tLRPC$ChatInvite.chat;
                        objArr2[0] = tLRPC$Chat5 != null ? tLRPC$Chat5.title : tLRPC$ChatInvite.title;
                        builder2.setMessage(LocaleController.formatString("ChannelJoinTo", R.string.ChannelJoinTo, objArr2));
                        builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.LaunchActivity.14.1.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                AnonymousClass14 anonymousClass142 = AnonymousClass14.this;
                                LaunchActivity.this.runLinkRequest(anonymousClass142.val$intentAccount, anonymousClass142.val$username, anonymousClass142.val$group, anonymousClass142.val$sticker, anonymousClass142.val$botUser, anonymousClass142.val$botChat, anonymousClass142.val$message, anonymousClass142.val$hasUrl, anonymousClass142.val$messageId, anonymousClass142.val$channelId, anonymousClass142.val$threadId, anonymousClass142.val$commentId, anonymousClass142.val$game, anonymousClass142.val$auth, anonymousClass142.val$lang, anonymousClass142.val$unsupportedUrl, anonymousClass142.val$code, anonymousClass142.val$loginToken, anonymousClass142.val$wallPaper, anonymousClass142.val$theme, anonymousClass142.val$voicechat, 1, anonymousClass142.val$videoTimestamp, anonymousClass142.val$instantView);
                            }
                        });
                        builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                        LaunchActivity.this.showAlertDialog(builder2);
                        return;
                    }
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(LaunchActivity.this);
                    builder3.setTitle(LocaleController.getString("AppName", R.string.AppName));
                    if (error.text.startsWith("FLOOD_WAIT")) {
                        builder3.setMessage(LocaleController.getString("FloodWait", R.string.FloodWait));
                    } else {
                        builder3.setMessage(LocaleController.getString("JoinToGroupErrorNotExist", R.string.JoinToGroupErrorNotExist));
                    }
                    builder3.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                    LaunchActivity.this.showAlertDialog(builder3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$29$LaunchActivity(final int i, final AlertDialog alertDialog, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            MessagesController.getInstance(i).processUpdates((TLRPC$Updates) tLObject, false);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$emFJPkY0kkT_wUKtOGjBtun_iBY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$28$LaunchActivity(alertDialog, tLRPC$TL_error, tLObject, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$28$LaunchActivity(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i) {
        BaseFragment chatActivity;
        if (isFinishing()) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLRPC$TL_error == null) {
            if (this.actionBarLayout != null) {
                TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
                if (tLRPC$Updates.chats.isEmpty()) {
                    return;
                }
                TLRPC$Chat tLRPC$Chat = tLRPC$Updates.chats.get(0);
                tLRPC$Chat.left = false;
                tLRPC$Chat.kicked = false;
                MessagesController.getInstance(i).putUsers(tLRPC$Updates.users, false);
                MessagesController.getInstance(i).putChats(tLRPC$Updates.chats, false);
                Bundle bundle = new Bundle();
                bundle.putLong("chat_id", tLRPC$Chat.id);
                if (!mainFragmentsStack.isEmpty()) {
                    if (!MessagesController.getInstance(i).checkCanOpenChat(bundle, mainFragmentsStack.get(r10.size() - 1))) {
                        return;
                    }
                }
                if (tLRPC$Chat.isMediaContent) {
                    bundle.putLong("dialog_id", -tLRPC$Chat.id);
                    chatActivity = new MediaChannelActivity(bundle);
                } else {
                    chatActivity = new ChatActivity(bundle);
                }
                this.actionBarLayout.presentFragment(chatActivity, false, true, true, false);
                return;
            }
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
            builder.setMessage(LocaleController.getString("FloodWait", R.string.FloodWait));
        } else if (tLRPC$TL_error.text.equals("USERS_TOO_MUCH")) {
            builder.setMessage(LocaleController.getString("JoinToGroupErrorFull", R.string.JoinToGroupErrorFull));
        } else if (tLRPC$TL_error.text.equals("CHANNELS_TOO_MUCH")) {
            builder.setMessage(LocaleController.getString("ChannelTooMuchJoin", R.string.ChannelTooMuchJoin));
        } else {
            builder.setMessage(LocaleController.getString("JoinToGroupErrorNotExist", R.string.JoinToGroupErrorNotExist));
        }
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        showAlertDialog(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$30$LaunchActivity(boolean z, int i, String str, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z2) {
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        bundle.putBoolean("hasUrl", z);
        if (DialogObject.isEncryptedDialog(jLongValue)) {
            bundle.putInt("enc_id", DialogObject.getEncryptedChatId(jLongValue));
        } else if (DialogObject.isUserDialog(jLongValue)) {
            bundle.putLong("user_id", jLongValue);
        } else {
            bundle.putLong("chat_id", -jLongValue);
        }
        if (MessagesController.getInstance(i).checkCanOpenChat(bundle, dialogsActivity)) {
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.closeChats, new Object[0]);
            MediaDataController.getInstance(i).saveDraft(jLongValue, 0, str, null, null, false);
            this.actionBarLayout.presentFragment(new ChatActivity(bundle), true, false, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$34$LaunchActivity(int[] iArr, final int i, final AlertDialog alertDialog, final TLRPC$TL_account_getAuthorizationForm tLRPC$TL_account_getAuthorizationForm, final String str, final String str2, final String str3, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        final TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm = (TLRPC$TL_account_authorizationForm) tLObject;
        if (tLRPC$TL_account_authorizationForm != null) {
            iArr[0] = ConnectionsManager.getInstance(i).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$aaOJdNZxDDcl5qM_-3D_4C4CpsE
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$runLinkRequest$32$LaunchActivity(alertDialog, i, tLRPC$TL_account_authorizationForm, tLRPC$TL_account_getAuthorizationForm, str, str2, str3, tLObject2, tLRPC$TL_error2);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$sFGkYEbhzQibrcvOetteD7cD1c4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$runLinkRequest$33$LaunchActivity(alertDialog, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$32$LaunchActivity(final AlertDialog alertDialog, final int i, final TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm, final TLRPC$TL_account_getAuthorizationForm tLRPC$TL_account_getAuthorizationForm, final String str, final String str2, final String str3, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$5vCS0Il9gd-M0lF02UNGJy5BWiE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$31$LaunchActivity(alertDialog, tLObject, i, tLRPC$TL_account_authorizationForm, tLRPC$TL_account_getAuthorizationForm, str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$31$LaunchActivity(AlertDialog alertDialog, TLObject tLObject, int i, TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm, TLRPC$TL_account_getAuthorizationForm tLRPC$TL_account_getAuthorizationForm, String str, String str2, String str3) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLObject != null) {
            MessagesController.getInstance(i).putUsers(tLRPC$TL_account_authorizationForm.users, false);
            lambda$runLinkRequest$39(new PassportActivity(5, tLRPC$TL_account_getAuthorizationForm.bot_id, tLRPC$TL_account_getAuthorizationForm.scope, tLRPC$TL_account_getAuthorizationForm.public_key, str, str2, str3, tLRPC$TL_account_authorizationForm, (TLRPC$TL_account_password) tLObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$33$LaunchActivity(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error) {
        try {
            alertDialog.dismiss();
            if ("APP_VERSION_OUTDATED".equals(tLRPC$TL_error.text)) {
                AlertsCreator.showUpdateAppAlert(this, LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
            } else {
                showAlertDialog(AlertsCreator.createSimpleAlert(this, LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + tLRPC$TL_error.text));
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$36$LaunchActivity(final AlertDialog alertDialog, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$9hiLoGxTPI-t-8FyoL2gWAlo0uY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$35$LaunchActivity(alertDialog, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$35$LaunchActivity(AlertDialog alertDialog, TLObject tLObject) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLObject instanceof TLRPC$TL_help_deepLinkInfo) {
            TLRPC$TL_help_deepLinkInfo tLRPC$TL_help_deepLinkInfo = (TLRPC$TL_help_deepLinkInfo) tLObject;
            AlertsCreator.showUpdateAppAlert(this, tLRPC$TL_help_deepLinkInfo.message, tLRPC$TL_help_deepLinkInfo.update_app);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$38$LaunchActivity(final AlertDialog alertDialog, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$0IZWt4o0_8IILrudMouVvZ_UNHM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$37$LaunchActivity(alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$37$LaunchActivity(AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLObject instanceof TLRPC$TL_langPackLanguage) {
            showAlertDialog(AlertsCreator.createLanguageAlert(this, (TLRPC$TL_langPackLanguage) tLObject));
            return;
        }
        if (tLRPC$TL_error != null) {
            if ("LANG_CODE_NOT_SUPPORTED".equals(tLRPC$TL_error.text)) {
                showAlertDialog(AlertsCreator.createSimpleAlert(this, LocaleController.getString("LanguageUnsupportedError", R.string.LanguageUnsupportedError)));
                return;
            }
            showAlertDialog(AlertsCreator.createSimpleAlert(this, LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + tLRPC$TL_error.text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$41$LaunchActivity(final AlertDialog alertDialog, final TLRPC$TL_wallPaper tLRPC$TL_wallPaper, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$7sVVD-c-VRlgc7Wn3uyQdpwa_jg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$40$LaunchActivity(alertDialog, tLObject, tLRPC$TL_wallPaper, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$runLinkRequest$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$40$LaunchActivity(AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_wallPaper tLRPC$TL_wallPaper, TLRPC$TL_error tLRPC$TL_error) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLObject instanceof TLRPC$TL_wallPaper) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper2 = (TLRPC$TL_wallPaper) tLObject;
            if (tLRPC$TL_wallPaper2.pattern) {
                String str = tLRPC$TL_wallPaper2.slug;
                TLRPC$WallPaperSettings tLRPC$WallPaperSettings = tLRPC$TL_wallPaper.settings;
                WallpapersListActivity.ColorWallpaper colorWallpaper = new WallpapersListActivity.ColorWallpaper(str, tLRPC$WallPaperSettings.background_color, tLRPC$WallPaperSettings.second_background_color, tLRPC$WallPaperSettings.third_background_color, tLRPC$WallPaperSettings.fourth_background_color, AndroidUtilities.getWallpaperRotation(tLRPC$WallPaperSettings.rotation, false), r0.intensity / 100.0f, tLRPC$TL_wallPaper.settings.motion, null);
                colorWallpaper.pattern = tLRPC$TL_wallPaper2;
                tLRPC$TL_wallPaper2 = colorWallpaper;
            }
            ThemePreviewActivity themePreviewActivity = new ThemePreviewActivity(tLRPC$TL_wallPaper2, null, true, false);
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings2 = tLRPC$TL_wallPaper.settings;
            themePreviewActivity.setInitialModes(tLRPC$WallPaperSettings2.blur, tLRPC$WallPaperSettings2.motion);
            lambda$runLinkRequest$39(themePreviewActivity);
            return;
        }
        showAlertDialog(AlertsCreator.createSimpleAlert(this, LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + tLRPC$TL_error.text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$42$LaunchActivity() {
        this.loadingThemeFileName = null;
        this.loadingThemeWallpaperName = null;
        this.loadingThemeWallpaper = null;
        this.loadingThemeInfo = null;
        this.loadingThemeProgressDialog = null;
        this.loadingTheme = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$44$LaunchActivity(final AlertDialog alertDialog, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$x481dzLm5UXv5GNaeSuu29ljgjE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$43$LaunchActivity(tLObject, alertDialog, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* renamed from: lambda$runLinkRequest$43, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$runLinkRequest$43$LaunchActivity(ir.eitaa.tgnet.TLObject r5, ir.eitaa.ui.ActionBar.AlertDialog r6, ir.eitaa.tgnet.TLRPC$TL_error r7) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.eitaa.tgnet.TLRPC$TL_theme
            r1 = 1
            if (r0 == 0) goto L75
            ir.eitaa.tgnet.TLRPC$TL_theme r5 = (ir.eitaa.tgnet.TLRPC$TL_theme) r5
            ir.eitaa.tgnet.TLRPC$ThemeSettings r7 = r5.settings
            r0 = 0
            if (r7 == 0) goto L57
            java.lang.String r7 = ir.eitaa.ui.ActionBar.Theme.getBaseThemeKey(r7)
            ir.eitaa.ui.ActionBar.Theme$ThemeInfo r7 = ir.eitaa.ui.ActionBar.Theme.getTheme(r7)
            if (r7 == 0) goto L81
            ir.eitaa.tgnet.TLRPC$ThemeSettings r2 = r5.settings
            ir.eitaa.tgnet.TLRPC$WallPaper r2 = r2.wallpaper
            boolean r3 = r2 instanceof ir.eitaa.tgnet.TLRPC$TL_wallPaper
            if (r3 == 0) goto L4a
            ir.eitaa.tgnet.TLRPC$TL_wallPaper r2 = (ir.eitaa.tgnet.TLRPC$TL_wallPaper) r2
            ir.eitaa.tgnet.TLRPC$Document r3 = r2.document
            java.io.File r3 = ir.eitaa.messenger.FileLoader.getPathToAttach(r3, r1)
            boolean r3 = r3.exists()
            if (r3 != 0) goto L4b
            r4.loadingThemeProgressDialog = r6
            r4.loadingThemeAccent = r1
            r4.loadingThemeInfo = r7
            r4.loadingTheme = r5
            r4.loadingThemeWallpaper = r2
            ir.eitaa.tgnet.TLRPC$Document r5 = r2.document
            java.lang.String r5 = ir.eitaa.messenger.FileLoader.getAttachFileName(r5)
            r4.loadingThemeWallpaperName = r5
            int r5 = r4.currentAccount
            ir.eitaa.messenger.FileLoader r5 = ir.eitaa.messenger.FileLoader.getInstance(r5)
            ir.eitaa.tgnet.TLRPC$Document r6 = r2.document
            r5.loadFile(r6, r2, r1, r1)
            return
        L4a:
            r2 = 0
        L4b:
            r6.dismiss()     // Catch: java.lang.Exception -> L4f
            goto L53
        L4f:
            r3 = move-exception
            ir.eitaa.messenger.FileLog.e(r3)
        L53:
            r4.openThemeAccentPreview(r5, r2, r7)
            goto L84
        L57:
            ir.eitaa.tgnet.TLRPC$Document r7 = r5.document
            if (r7 == 0) goto L81
            r4.loadingThemeAccent = r0
            r4.loadingTheme = r5
            java.lang.String r7 = ir.eitaa.messenger.FileLoader.getAttachFileName(r7)
            r4.loadingThemeFileName = r7
            r4.loadingThemeProgressDialog = r6
            int r7 = r4.currentAccount
            ir.eitaa.messenger.FileLoader r7 = ir.eitaa.messenger.FileLoader.getInstance(r7)
            ir.eitaa.tgnet.TLRPC$TL_theme r2 = r4.loadingTheme
            ir.eitaa.tgnet.TLRPC$Document r2 = r2.document
            r7.loadFile(r2, r5, r1, r1)
            goto L84
        L75:
            if (r7 == 0) goto L83
            java.lang.String r5 = r7.text
            java.lang.String r7 = "THEME_FORMAT_INVALID"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L83
        L81:
            r0 = 1
            goto L84
        L83:
            r0 = 2
        L84:
            if (r0 == 0) goto Lbe
            r6.dismiss()     // Catch: java.lang.Exception -> L8a
            goto L8e
        L8a:
            r5 = move-exception
            ir.eitaa.messenger.FileLog.e(r5)
        L8e:
            r5 = 2131694467(0x7f0f1383, float:1.9018091E38)
            java.lang.String r6 = "Theme"
            if (r0 != r1) goto Laa
            java.lang.String r5 = ir.eitaa.messenger.LocaleController.getString(r6, r5)
            r6 = 2131694491(0x7f0f139b, float:1.901814E38)
            java.lang.String r7 = "ThemeNotSupported"
            java.lang.String r6 = ir.eitaa.messenger.LocaleController.getString(r7, r6)
            ir.eitaa.ui.ActionBar.AlertDialog$Builder r5 = ir.eitaa.ui.Components.AlertsCreator.createSimpleAlert(r4, r5, r6)
            r4.showAlertDialog(r5)
            goto Lbe
        Laa:
            java.lang.String r5 = ir.eitaa.messenger.LocaleController.getString(r6, r5)
            r6 = 2131694490(0x7f0f139a, float:1.9018138E38)
            java.lang.String r7 = "ThemeNotFound"
            java.lang.String r6 = ir.eitaa.messenger.LocaleController.getString(r7, r6)
            ir.eitaa.ui.ActionBar.AlertDialog$Builder r5 = ir.eitaa.ui.Components.AlertsCreator.createSimpleAlert(r4, r5, r6)
            r4.showAlertDialog(r5)
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.lambda$runLinkRequest$43$LaunchActivity(ir.eitaa.tgnet.TLObject, ir.eitaa.ui.ActionBar.AlertDialog, ir.eitaa.tgnet.TLRPC$TL_error):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$46$LaunchActivity(final int[] iArr, final int i, final AlertDialog alertDialog, final Integer num, final Integer num2, final Integer num3, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$H80SnAWOahy2e8hLDLQq_ok0EwQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$45$LaunchActivity(tLObject, iArr, i, alertDialog, num, num2, num3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
    /* renamed from: lambda$runLinkRequest$45, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$runLinkRequest$45$LaunchActivity(ir.eitaa.tgnet.TLObject r11, int[] r12, int r13, ir.eitaa.ui.ActionBar.AlertDialog r14, java.lang.Integer r15, java.lang.Integer r16, java.lang.Integer r17) {
        /*
            r10 = this;
            r8 = r10
            r0 = r11
            boolean r1 = r0 instanceof ir.eitaa.tgnet.TLRPC$TL_messages_chats
            r9 = 0
            if (r1 == 0) goto L34
            ir.eitaa.tgnet.TLRPC$TL_messages_chats r0 = (ir.eitaa.tgnet.TLRPC$TL_messages_chats) r0
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Chat> r1 = r0.chats
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L34
            int r1 = r8.currentAccount
            ir.eitaa.messenger.MessagesController r1 = ir.eitaa.messenger.MessagesController.getInstance(r1)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Chat> r2 = r0.chats
            r1.putChats(r2, r9)
            java.util.ArrayList<ir.eitaa.tgnet.TLRPC$Chat> r0 = r0.chats
            java.lang.Object r0 = r0.get(r9)
            r7 = r0
            ir.eitaa.tgnet.TLRPC$Chat r7 = (ir.eitaa.tgnet.TLRPC$Chat) r7
            r1 = r10
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            int r0 = r1.runCommentRequest(r2, r3, r4, r5, r6, r7)
            r12[r9] = r0
            goto L35
        L34:
            r9 = 1
        L35:
            if (r9 == 0) goto L50
            r14.dismiss()     // Catch: java.lang.Exception -> L3b
            goto L40
        L3b:
            r0 = move-exception
            r1 = r0
            ir.eitaa.messenger.FileLog.e(r1)
        L40:
            r0 = 2131692149(0x7f0f0a75, float:1.901339E38)
            java.lang.String r1 = "LinkNotFound"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r1, r0)
            ir.eitaa.ui.ActionBar.AlertDialog$Builder r0 = ir.eitaa.ui.Components.AlertsCreator.createSimpleAlert(r10, r0)
            r10.showAlertDialog(r0)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.lambda$runLinkRequest$45$LaunchActivity(ir.eitaa.tgnet.TLObject, int[], int, ir.eitaa.ui.ActionBar.AlertDialog, java.lang.Integer, java.lang.Integer, java.lang.Integer):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$49$LaunchActivity(final Bundle bundle, Long l, int[] iArr, final AlertDialog alertDialog, final BaseFragment baseFragment, final int i) {
        if (this.actionBarLayout.presentFragment(new ChatActivity(bundle))) {
            return;
        }
        TLRPC$TL_channels_getChannels tLRPC$TL_channels_getChannels = new TLRPC$TL_channels_getChannels();
        TLRPC$TL_inputChannel tLRPC$TL_inputChannel = new TLRPC$TL_inputChannel();
        tLRPC$TL_inputChannel.channel_id = l.longValue();
        tLRPC$TL_channels_getChannels.id.add(tLRPC$TL_inputChannel);
        iArr[0] = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_getChannels, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$r_iWUg3GZuLyLOw1vAmoNsI6pZk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$runLinkRequest$48$LaunchActivity(alertDialog, baseFragment, i, bundle, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$48$LaunchActivity(final AlertDialog alertDialog, final BaseFragment baseFragment, final int i, final Bundle bundle, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$_zvRrev-KEthoEghXx2OhtrCwAc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$47$LaunchActivity(alertDialog, tLObject, baseFragment, i, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runLinkRequest$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runLinkRequest$47$LaunchActivity(AlertDialog alertDialog, TLObject tLObject, BaseFragment baseFragment, int i, Bundle bundle) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        boolean z = true;
        if (tLObject instanceof TLRPC$TL_messages_chats) {
            TLRPC$TL_messages_chats tLRPC$TL_messages_chats = (TLRPC$TL_messages_chats) tLObject;
            if (!tLRPC$TL_messages_chats.chats.isEmpty()) {
                MessagesController.getInstance(this.currentAccount).putChats(tLRPC$TL_messages_chats.chats, false);
                tLRPC$TL_messages_chats.chats.get(0);
                if (baseFragment == null || MessagesController.getInstance(i).checkCanOpenChat(bundle, baseFragment)) {
                    this.actionBarLayout.presentFragment(new ChatActivity(bundle));
                }
                z = false;
            }
        }
        if (z) {
            showAlertDialog(AlertsCreator.createSimpleAlert(this, LocaleController.getString("LinkNotFound", R.string.LinkNotFound)));
        }
    }

    static /* synthetic */ void lambda$runLinkRequest$50(int i, int[] iArr, Runnable runnable, DialogInterface dialogInterface) {
        ConnectionsManager.getInstance(i).cancelRequest(iArr[0], true);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runLinkRequest(final int intentAccount, final String username, final String group, final String sticker, final String botUser, final String botChat, final String message, final boolean hasUrl, final Integer messageId, final Long channelId, final Integer threadId, final Integer commentId, final String game, final HashMap<String, String> auth, final String lang, final String unsupportedUrl, final String code, final String loginToken, final TLRPC$TL_wallPaper wallPaper, final String theme, final String voicechat, final int state, final int videoTimestamp, final String[] instantView) {
        runLinkRequest(intentAccount, username, group, null, sticker, botUser, botChat, message, hasUrl, messageId, channelId, threadId, commentId, game, auth, lang, unsupportedUrl, code, loginToken, wallPaper, theme, voicechat, state, videoTimestamp, instantView);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<ir.eitaa.tgnet.TLRPC$TL_contact> findContacts(java.lang.String r18, java.lang.String r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.findContacts(java.lang.String, java.lang.String, boolean):java.util.List");
    }

    private void createUpdateUI() {
        if (this.sideMenuContainer == null) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this) { // from class: ir.eitaa.ui.LaunchActivity.15
            private int lastGradientWidth;
            private LinearGradient updateGradient;
            private Paint paint = new Paint();
            private Matrix matrix = new Matrix();

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                if (this.updateGradient == null) {
                    return;
                }
                this.paint.setColor(-1);
                this.paint.setShader(this.updateGradient);
                this.updateGradient.setLocalMatrix(this.matrix);
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.paint);
                LaunchActivity.this.updateLayoutIcon.setBackgroundGradientDrawable(this.updateGradient);
                LaunchActivity.this.updateLayoutIcon.draw(canvas);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                if (this.lastGradientWidth != size) {
                    this.updateGradient = new LinearGradient(0.0f, 0.0f, size, 0.0f, new int[]{-9846926, -11291731}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                    this.lastGradientWidth = size;
                }
            }
        };
        this.updateLayout = frameLayout;
        frameLayout.setWillNotDraw(false);
        this.updateLayout.setVisibility(4);
        this.updateLayout.setTranslationY(AndroidUtilities.dp(44.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            this.updateLayout.setBackground(Theme.getSelectorDrawable(Theme.getColor("listSelectorSDK21"), (String) null));
        }
        this.sideMenuContainer.addView(this.updateLayout, LayoutHelper.createFrame(-1, 44, 83));
        this.updateLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$2EuwjWRGzwBLOEeiyEcqBbtwZfw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createUpdateUI$51$LaunchActivity(view);
            }
        });
        RadialProgress2 radialProgress2 = new RadialProgress2(this.updateLayout);
        this.updateLayoutIcon = radialProgress2;
        radialProgress2.setColors(-1, -1, -1, -1);
        this.updateLayoutIcon.setProgressRect(AndroidUtilities.dp(22.0f), AndroidUtilities.dp(11.0f), AndroidUtilities.dp(44.0f), AndroidUtilities.dp(33.0f));
        this.updateLayoutIcon.setCircleRadius(AndroidUtilities.dp(11.0f));
        this.updateLayoutIcon.setAsMini();
        SimpleTextView simpleTextView = new SimpleTextView(this);
        this.updateTextView = simpleTextView;
        simpleTextView.setTextSize(15);
        this.updateTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.updateTextView.setText(LocaleController.getString("AppUpdate", R.string.AppUpdate));
        this.updateTextView.setTextColor(-1);
        this.updateTextView.setGravity(3);
        this.updateLayout.addView(this.updateTextView, LayoutHelper.createFrame(-2, -2.0f, 16, 74.0f, 0.0f, 0.0f, 0.0f));
        TextView textView = new TextView(this);
        this.updateSizeTextView = textView;
        textView.setTextSize(1, 15.0f);
        this.updateSizeTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.updateSizeTextView.setGravity(5);
        this.updateSizeTextView.setTextColor(-1);
        this.updateLayout.addView(this.updateSizeTextView, LayoutHelper.createFrame(-2, -2.0f, 21, 0.0f, 0.0f, 17.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createUpdateUI$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createUpdateUI$51$LaunchActivity(View view) {
        if (SharedConfig.isAppUpdateAvailable()) {
            if (this.updateLayoutIcon.getIcon() == 2) {
                FileLoader.getInstance(this.currentAccount).loadFile(SharedConfig.pendingAppUpdate.document, "update", 1, 1);
                updateAppUpdateViews(true);
            } else if (this.updateLayoutIcon.getIcon() == 3) {
                FileLoader.getInstance(this.currentAccount).cancelLoadFile(SharedConfig.pendingAppUpdate.document);
                updateAppUpdateViews(true);
            } else {
                AndroidUtilities.openForView(SharedConfig.pendingAppUpdate.document, true, (Activity) this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0127 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateAppUpdateViews(boolean r13) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.updateAppUpdateViews(boolean):void");
    }

    public void checkAppUpdate(boolean force) {
        if (force || !BuildVars.DEBUG_VERSION) {
            if (force || BuildVars.CHECK_UPDATES) {
                if (force || Math.abs(System.currentTimeMillis() - SharedConfig.lastUpdateCheckTime) >= MessagesController.getInstance(0).updateCheckDelay * 1000) {
                    TLRPC$TL_help_getAppUpdate tLRPC$TL_help_getAppUpdate = new TLRPC$TL_help_getAppUpdate();
                    try {
                        tLRPC$TL_help_getAppUpdate.source = ApplicationLoader.applicationContext.getPackageManager().getInstallerPackageName(ApplicationLoader.applicationContext.getPackageName());
                    } catch (Exception unused) {
                    }
                    if (tLRPC$TL_help_getAppUpdate.source == null) {
                        tLRPC$TL_help_getAppUpdate.source = "";
                    }
                    final int i = this.currentAccount;
                    ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_help_getAppUpdate, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$Q96m-_en0X7l1vHursQxOTSvw7M
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$checkAppUpdate$53$LaunchActivity(i, tLObject, tLRPC$TL_error);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkAppUpdate$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkAppUpdate$53$LaunchActivity(final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        SharedConfig.lastUpdateCheckTime = System.currentTimeMillis();
        SharedConfig.saveConfig();
        if (tLObject instanceof TLRPC$TL_help_appUpdate) {
            final TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate = (TLRPC$TL_help_appUpdate) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$55rAGvOuXE4To94-20yr0s35W2c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkAppUpdate$52$LaunchActivity(tLRPC$TL_help_appUpdate, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkAppUpdate$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkAppUpdate$52$LaunchActivity(TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate, int i) {
        TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate2 = SharedConfig.pendingAppUpdate;
        if ((tLRPC$TL_help_appUpdate2 == null || !tLRPC$TL_help_appUpdate2.version.equals(tLRPC$TL_help_appUpdate.version)) && SharedConfig.setNewAppVersionAvailable(tLRPC$TL_help_appUpdate)) {
            if (tLRPC$TL_help_appUpdate.can_not_skip) {
                showUpdateActivity(i, tLRPC$TL_help_appUpdate, false);
            } else {
                this.drawerLayoutAdapter.notifyDataSetChanged();
                try {
                    new UpdateAppAlertDialog(this, tLRPC$TL_help_appUpdate, i).show();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.appUpdateAvailable, new Object[0]);
        }
    }

    public AlertDialog showAlertDialog(AlertDialog.Builder builder) {
        try {
            AlertDialog alertDialog = this.visibleDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            AlertDialog alertDialogShow = builder.show();
            this.visibleDialog = alertDialogShow;
            alertDialogShow.setCanceledOnTouchOutside(true);
            this.visibleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$qw3qbd3KRxpIESo-Do4FkO-bKjk
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$showAlertDialog$54$LaunchActivity(dialogInterface);
                }
            });
            return this.visibleDialog;
        } catch (Exception e2) {
            FileLog.e(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showAlertDialog$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showAlertDialog$54$LaunchActivity(DialogInterface dialogInterface) {
        AlertDialog alertDialog = this.visibleDialog;
        if (alertDialog != null) {
            if (alertDialog == this.localeDialog) {
                try {
                    Toast.makeText(this, getStringForLanguageAlert(LocaleController.getInstance().getCurrentLocaleInfo().shortName.equals("en") ? this.englishLocaleStrings : this.systemLocaleStrings, "ChangeLanguageLater", R.string.ChangeLanguageLater), 1).show();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                this.localeDialog = null;
            } else if (alertDialog == this.proxyErrorDialog) {
                MessagesController.getGlobalMainSettings();
                SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
                editorEdit.putBoolean("proxy_enabled", false);
                editorEdit.putBoolean("proxy_enabled_calls", false);
                editorEdit.commit();
                ConnectionsManager.setProxySettings(false, "", 1080, "", "", "");
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.proxySettingsChanged, new Object[0]);
                this.proxyErrorDialog = null;
            }
        }
        this.visibleDialog = null;
    }

    public void showBulletin(Function<BulletinFactory, Bulletin> createBulletin) {
        BaseFragment baseFragment;
        if (!layerFragmentsStack.isEmpty()) {
            baseFragment = layerFragmentsStack.get(r0.size() - 1);
        } else if (!rightFragmentsStack.isEmpty()) {
            baseFragment = rightFragmentsStack.get(r0.size() - 1);
        } else if (mainFragmentsStack.isEmpty()) {
            baseFragment = null;
        } else {
            baseFragment = mainFragmentsStack.get(r0.size() - 1);
        }
        if (BulletinFactory.canShowBulletin(baseFragment)) {
            createBulletin.apply(BulletinFactory.of(baseFragment)).show();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) throws Throwable {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent, true, false, false);
    }

    @Override // ir.eitaa.ui.DialogsActivity.DialogsActivityDelegate
    public void didSelectDialogs(final DialogsActivity dialogsFragment, final ArrayList<Long> dids, CharSequence message, final boolean param) {
        final ChatActivity chatActivity;
        int i;
        final int currentAccount = dialogsFragment != null ? dialogsFragment.getCurrentAccount() : this.currentAccount;
        final Uri uri = this.exportingChatUri;
        if (uri != null) {
            final ArrayList arrayList = this.documentsUrisArray != null ? new ArrayList(this.documentsUrisArray) : null;
            final AlertDialog alertDialog = new AlertDialog(this, 3);
            SendMessagesHelper.getInstance(currentAccount).prepareImportHistory(dids.get(0).longValue(), this.exportingChatUri, this.documentsUrisArray, new MessagesStorage.LongCallback() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$86vyy6h47BO7Fr6O9X-I3Vjtrgg
                @Override // ir.eitaa.messenger.MessagesStorage.LongCallback
                public final void run(long j) {
                    this.f$0.lambda$didSelectDialogs$55$LaunchActivity(currentAccount, dialogsFragment, param, arrayList, uri, alertDialog, j);
                }
            });
            try {
                alertDialog.showDelayed(300L);
            } catch (Exception unused) {
            }
        } else {
            if (dids.size() <= 1) {
                long jLongValue = dids.get(0).longValue();
                Bundle bundle = new Bundle();
                bundle.putBoolean("scrollToTopOnResume", true);
                if (!AndroidUtilities.isTablet()) {
                    NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
                }
                if (DialogObject.isEncryptedDialog(jLongValue)) {
                    bundle.putInt("enc_id", DialogObject.getEncryptedChatId(jLongValue));
                } else if (DialogObject.isUserDialog(jLongValue)) {
                    bundle.putLong("user_id", jLongValue);
                } else {
                    bundle.putLong("chat_id", -jLongValue);
                }
                if (!MessagesController.getInstance(currentAccount).checkCanOpenChat(bundle, dialogsFragment)) {
                    return;
                } else {
                    chatActivity = new ChatActivity(bundle);
                }
            } else {
                chatActivity = null;
            }
            ArrayList<TLRPC$User> arrayList2 = this.contactsToSend;
            int size = arrayList2 != null ? arrayList2.size() + 0 : 0;
            if (this.videoPath != null) {
                size++;
            }
            ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList3 = this.photoPathsArray;
            if (arrayList3 != null) {
                size += arrayList3.size();
            }
            ArrayList<String> arrayList4 = this.documentsPathsArray;
            if (arrayList4 != null) {
                size += arrayList4.size();
            }
            ArrayList<Uri> arrayList5 = this.documentsUrisArray;
            if (arrayList5 != null) {
                size += arrayList5.size();
            }
            if (this.videoPath == null && this.photoPathsArray == null && this.documentsPathsArray == null && this.documentsUrisArray == null && this.sendingText != null) {
                size++;
            }
            for (int i2 = 0; i2 < dids.size(); i2++) {
                if (AlertsCreator.checkSlowMode(this, this.currentAccount, dids.get(i2).longValue(), size > 1)) {
                    return;
                }
            }
            ArrayList<TLRPC$User> arrayList6 = this.contactsToSend;
            if (arrayList6 != null && arrayList6.size() == 1 && !mainFragmentsStack.isEmpty()) {
                ArrayList<BaseFragment> arrayList7 = mainFragmentsStack;
                PhonebookShareAlert phonebookShareAlert = new PhonebookShareAlert(arrayList7.get(arrayList7.size() - 1), null, null, this.contactsToSendUri, null, null, null);
                phonebookShareAlert.setDelegate(new ChatAttachAlertContactsLayout.PhonebookShareAlertDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$9BoUvpLpvo8vqG8AM7PEl4Q7sgw
                    @Override // ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.PhonebookShareAlertDelegate
                    public final void didSelectContact(TLRPC$User tLRPC$User, boolean z, int i3) {
                        this.f$0.lambda$didSelectDialogs$56$LaunchActivity(chatActivity, dids, currentAccount, tLRPC$User, z, i3);
                    }
                });
                ArrayList<BaseFragment> arrayList8 = mainFragmentsStack;
                arrayList8.get(arrayList8.size() - 1).showDialog(phonebookShareAlert);
            } else {
                String str = null;
                for (int i3 = 0; i3 < dids.size(); i3++) {
                    long jLongValue2 = dids.get(i3).longValue();
                    AccountInstance accountInstance = AccountInstance.getInstance(UserConfig.selectedAccount);
                    if (chatActivity != null) {
                        ActionBarLayout actionBarLayout = this.actionBarLayout;
                        boolean z = dialogsFragment != null;
                        boolean z2 = dialogsFragment == null;
                        i = Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV;
                        actionBarLayout.presentFragment(chatActivity, z, z2, true, false);
                        String str2 = this.videoPath;
                        if (str2 != null) {
                            chatActivity.openVideoEditor(str2, this.sendingText);
                            this.sendingText = null;
                        }
                    } else {
                        i = Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV;
                        if (this.videoPath != null) {
                            String str3 = this.sendingText;
                            if (str3 != null && str3.length() <= 1024) {
                                str = this.sendingText;
                                this.sendingText = null;
                            }
                            ArrayList arrayList9 = new ArrayList();
                            arrayList9.add(this.videoPath);
                            SendMessagesHelper.prepareSendingDocuments(accountInstance, arrayList9, arrayList9, null, str, null, jLongValue2, null, null, null, null, true, 0);
                        }
                    }
                    if (this.photoPathsArray != null) {
                        String str4 = this.sendingText;
                        if (str4 != null && str4.length() <= i && this.photoPathsArray.size() == 1) {
                            this.photoPathsArray.get(0).caption = this.sendingText;
                            this.sendingText = null;
                        }
                        SendMessagesHelper.prepareSendingMedia(accountInstance, this.photoPathsArray, jLongValue2, null, null, null, false, false, null, true, 0);
                    }
                    if (this.documentsPathsArray != null || this.documentsUrisArray != null) {
                        String str5 = this.sendingText;
                        if (str5 != null && str5.length() <= i) {
                            ArrayList<String> arrayList10 = this.documentsPathsArray;
                            int size2 = arrayList10 != null ? arrayList10.size() : 0;
                            ArrayList<Uri> arrayList11 = this.documentsUrisArray;
                            if (size2 + (arrayList11 != null ? arrayList11.size() : 0) == 1) {
                                str = this.sendingText;
                                this.sendingText = null;
                            }
                        }
                        SendMessagesHelper.prepareSendingDocuments(accountInstance, this.documentsPathsArray, this.documentsOriginalPathsArray, this.documentsUrisArray, str, this.documentsMimeType, jLongValue2, null, null, null, null, true, 0);
                    }
                    String str6 = this.sendingText;
                    if (str6 != null) {
                        SendMessagesHelper.prepareSendingText(accountInstance, str6, jLongValue2, true, 0);
                    }
                    ArrayList<TLRPC$User> arrayList12 = this.contactsToSend;
                    if (arrayList12 != null && !arrayList12.isEmpty()) {
                        for (int i4 = 0; i4 < this.contactsToSend.size(); i4++) {
                            SendMessagesHelper.getInstance(currentAccount).sendMessage(this.contactsToSend.get(i4), jLongValue2, (MessageObject) null, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                        }
                    }
                    if (!TextUtils.isEmpty(message)) {
                        SendMessagesHelper.prepareSendingText(accountInstance, message.toString(), jLongValue2, true, 0);
                    }
                }
            }
            if (dialogsFragment != null && chatActivity == null) {
                dialogsFragment.finishFragment();
            }
        }
        this.photoPathsArray = null;
        this.videoPath = null;
        this.sendingText = null;
        this.documentsPathsArray = null;
        this.documentsOriginalPathsArray = null;
        this.contactsToSend = null;
        this.contactsToSendUri = null;
        this.exportingChatUri = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didSelectDialogs$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didSelectDialogs$55$LaunchActivity(int i, DialogsActivity dialogsActivity, boolean z, ArrayList arrayList, Uri uri, AlertDialog alertDialog, long j) {
        if (j != 0) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("scrollToTopOnResume", true);
            if (!AndroidUtilities.isTablet()) {
                NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.closeChats, new Object[0]);
            }
            if (DialogObject.isUserDialog(j)) {
                bundle.putLong("user_id", j);
            } else {
                bundle.putLong("chat_id", -j);
            }
            ChatActivity chatActivity = new ChatActivity(bundle);
            chatActivity.setOpenImport();
            this.actionBarLayout.presentFragment(chatActivity, dialogsActivity != null || z, dialogsActivity == null, true, false);
        } else {
            this.documentsUrisArray = arrayList;
            if (arrayList == null) {
                this.documentsUrisArray = new ArrayList<>();
            }
            this.documentsUrisArray.add(0, uri);
            openDialogsToSend(true);
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didSelectDialogs$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didSelectDialogs$56$LaunchActivity(ChatActivity chatActivity, ArrayList arrayList, int i, TLRPC$User tLRPC$User, boolean z, int i2) {
        if (chatActivity != null) {
            this.actionBarLayout.presentFragment(chatActivity, true, false, true, false);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            SendMessagesHelper.getInstance(i).sendMessage(tLRPC$User, ((Long) arrayList.get(i3)).longValue(), (MessageObject) null, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, z, i2);
        }
    }

    private void onFinish() {
        CallOutManager.onAppTerminate();
        Runnable runnable = this.lockRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.lockRunnable = null;
        }
        if (this.finished) {
            return;
        }
        this.finished = true;
        int i = this.currentAccount;
        if (i != -1) {
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.appDidLogout);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mainUserInfoChanged);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didUpdateConnectionState);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.needShowAlert);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.wasUnableToFindCurrentLocation);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.openArticle);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.hasNewContactsToImport);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.needShowPlayServicesAlert);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoaded);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoadProgressChanged);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoadFailed);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.historyImportProgressChanged);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.groupCallUpdated);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.stickersImportComplete);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.newSuggestionsAvailable);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.socketAvailable);
        }
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.needShowAlert);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetNewWallpapper);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.suggestedLangpack);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.reloadInterface);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetNewTheme);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.needSetDayNightTheme);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.needCheckSystemBarColors);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.closeOtherAppActivities);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetPasscode);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.notificationsCountUpdated);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.screenStateChanged);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.showBulletin);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.appUpdateAvailable);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetChatLockPasscode);
    }

    /* renamed from: presentFragment, reason: merged with bridge method [inline-methods] */
    public void lambda$runLinkRequest$39$LaunchActivity(BaseFragment fragment) {
        this.actionBarLayout.presentFragment(fragment);
    }

    public boolean presentFragment(final BaseFragment fragment, final boolean removeLast, boolean forceWithoutAnimation) {
        return this.actionBarLayout.presentFragment(fragment, removeLast, forceWithoutAnimation, true, false);
    }

    public ActionBarLayout getActionBarLayout() {
        return this.actionBarLayout;
    }

    public ActionBarLayout getLayersActionBarLayout() {
        return this.layersActionBarLayout;
    }

    public ActionBarLayout getRightActionBarLayout() {
        return this.rightActionBarLayout;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        VoIPService sharedInstance;
        if (SharedConfig.passcodeHash.length() != 0 && SharedConfig.lastPauseTime != 0) {
            SharedConfig.lastPauseTime = 0;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("reset lastPauseTime onActivityResult");
            }
            UserConfig.getInstance(this.currentAccount).saveConfig(false);
        }
        if (requestCode == 137217) {
            Object obj = PaymentActivity.uploadMessage;
            if (obj == null) {
                return;
            }
            try {
                ((ValueCallback) obj).onReceiveValue(new Uri[]{(data == null || resultCode != -1) ? null : data.getData()});
            } catch (Exception unused) {
            }
            PaymentActivity.uploadMessage = null;
            return;
        }
        if (requestCode == 105) {
            if (Build.VERSION.SDK_INT >= 23) {
                boolean zCanDrawOverlays = Settings.canDrawOverlays(this);
                ApplicationLoader.canDrawOverlays = zCanDrawOverlays;
                if (zCanDrawOverlays) {
                    GroupCallActivity groupCallActivity = GroupCallActivity.groupCallInstance;
                    if (groupCallActivity != null) {
                        groupCallActivity.dismissInternal();
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$CVJvrDRdAf44G9MUNCmpkBX40vs
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onActivityResult$57$LaunchActivity();
                        }
                    }, 200L);
                    return;
                }
                return;
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 520) {
            if (resultCode != -1 || (sharedInstance = VoIPService.getSharedInstance()) == null) {
                return;
            }
            VideoCapturerDevice.mediaProjectionPermissionResultData = data;
            sharedInstance.createCaptureDevice(true);
            return;
        }
        if (requestCode == 140) {
            LocationController.getInstance(this.currentAccount).startFusedLocationRequest(resultCode == -1);
            return;
        }
        ThemeEditorView themeEditorView = ThemeEditorView.getInstance();
        if (themeEditorView != null) {
            themeEditorView.onActivityResult(requestCode, resultCode, data);
        }
        if (this.actionBarLayout.fragmentsStack.size() != 0) {
            ArrayList<BaseFragment> arrayList = this.actionBarLayout.fragmentsStack;
            arrayList.get(arrayList.size() - 1).onActivityResultFragment(requestCode, resultCode, data);
        }
        if (AndroidUtilities.isTablet()) {
            if (this.rightActionBarLayout.fragmentsStack.size() != 0) {
                ArrayList<BaseFragment> arrayList2 = this.rightActionBarLayout.fragmentsStack;
                arrayList2.get(arrayList2.size() - 1).onActivityResultFragment(requestCode, resultCode, data);
            }
            if (this.layersActionBarLayout.fragmentsStack.size() != 0) {
                ArrayList<BaseFragment> arrayList3 = this.layersActionBarLayout.fragmentsStack;
                arrayList3.get(arrayList3.size() - 1).onActivityResultFragment(requestCode, resultCode, data);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onActivityResult$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onActivityResult$57$LaunchActivity() {
        GroupCallPip.clearForce();
        GroupCallPip.updateVisibility(this);
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
        if (AndroidUtilities.isTablet()) {
            if (this.rightActionBarLayout.fragmentsStack.size() != 0) {
                ArrayList<BaseFragment> arrayList2 = this.rightActionBarLayout.fragmentsStack;
                arrayList2.get(arrayList2.size() - 1).onRequestPermissionsResultFragment(requestCode, permissions, grantResults);
            }
            if (this.layersActionBarLayout.fragmentsStack.size() != 0) {
                ArrayList<BaseFragment> arrayList3 = this.layersActionBarLayout.fragmentsStack;
                arrayList3.get(arrayList3.size() - 1).onRequestPermissionsResultFragment(requestCode, permissions, grantResults);
            }
        }
        VoIPFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void showPermissionErrorAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(message);
        builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$-DT-FFmhcDUb55oUKJYhAO19I1A
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPermissionErrorAlert$58$LaunchActivity(dialogInterface, i);
            }
        });
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPermissionErrorAlert$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPermissionErrorAlert$58$LaunchActivity(DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // android.app.Activity
    protected void onPause() throws InterruptedException, Resources.NotFoundException, IOException {
        super.onPause();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, Integer.valueOf(Factory.DEVICE_HAS_CRAPPY_AAUDIO));
        ApplicationLoader.mainInterfacePaused = true;
        SharedConfig.setMainInterfacePaused(true);
        final int i = this.currentAccount;
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$rcHshfTy4ugvgZodIzO8MG72rQc
            @Override // java.lang.Runnable
            public final void run() {
                LaunchActivity.lambda$onPause$59(i);
            }
        });
        onPasscodePause();
        this.actionBarLayout.onPause();
        if (AndroidUtilities.isTablet()) {
            this.rightActionBarLayout.onPause();
            this.layersActionBarLayout.onPause();
        }
        PasscodeView passcodeView = this.passcodeView;
        if (passcodeView != null) {
            passcodeView.onPause();
        }
        ConnectionsManager.getInstance(this.currentAccount).setAppPaused(true, false);
        if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
            PhotoViewer.getInstance().onPause();
        }
        if (VoIPFragment.getInstance() != null) {
            VoIPFragment.onPause();
        }
    }

    static /* synthetic */ void lambda$onPause$59(int i) {
        ApplicationLoader.mainInterfacePausedStageQueue = true;
        ApplicationLoader.mainInterfacePausedStageQueueTime = 0L;
        if (VoIPService.getSharedInstance() == null) {
            MessagesController.getInstance(i).ignoreSetOnline = false;
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Browser.bindCustomTabsService(this);
        ApplicationLoader.mainInterfaceStopped = false;
        GroupCallPip.updateVisibility(this);
        GroupCallActivity groupCallActivity = GroupCallActivity.groupCallInstance;
        if (groupCallActivity != null) {
            groupCallActivity.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Browser.unbindCustomTabsService(this);
        ApplicationLoader.mainInterfaceStopped = true;
        GroupCallPip.updateVisibility(this);
        GroupCallActivity groupCallActivity = GroupCallActivity.groupCallInstance;
        if (groupCallActivity != null) {
            groupCallActivity.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (PhotoViewer.getPipInstance() != null) {
            PhotoViewer.getPipInstance().destroyPhotoViewer();
        }
        if (PhotoViewer.hasInstance()) {
            PhotoViewer.getInstance().destroyPhotoViewer();
        }
        if (SecretMediaViewer.hasInstance()) {
            SecretMediaViewer.getInstance().destroyPhotoViewer();
        }
        if (ArticleViewer.hasInstance()) {
            ArticleViewer.getInstance().destroyArticleViewer();
        }
        if (ContentPreviewViewer.hasInstance()) {
            ContentPreviewViewer.getInstance().destroy();
        }
        GroupCallActivity groupCallActivity = GroupCallActivity.groupCallInstance;
        if (groupCallActivity != null) {
            groupCallActivity.dismissInternal();
        }
        PipRoundVideoView pipRoundVideoView = PipRoundVideoView.getInstance();
        MediaController.getInstance().setBaseActivity(this, false);
        MediaController.getInstance().setFeedbackView(this.actionBarLayout, false);
        if (pipRoundVideoView != null) {
            pipRoundVideoView.close(false);
        }
        Theme.destroyResources();
        EmbedBottomSheet embedBottomSheet = EmbedBottomSheet.getInstance();
        if (embedBottomSheet != null) {
            embedBottomSheet.destroy();
        }
        ThemeEditorView themeEditorView = ThemeEditorView.getInstance();
        if (themeEditorView != null) {
            themeEditorView.destroy();
        }
        try {
            AlertDialog alertDialog = this.visibleDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            if (this.onGlobalLayoutListener != null) {
                getWindow().getDecorView().getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        super.onDestroy();
        onFinish();
    }

    @Override // android.app.Activity
    protected void onResume() throws InterruptedException, IOException {
        MessageObject playingMessageObject;
        super.onResume();
        if (getIntent() == null || !getIntent().getBooleanExtra("internalUri", false)) {
            MessagesController.getInstance(this.currentAccount).reportedDialogAdId = 0;
        } else if (getIntent() != null) {
            getIntent().putExtra("internalUri", false);
        }
        if (Theme.selectedAutoNightType == 3) {
            Theme.checkAutoNightThemeConditions();
        }
        checkWasMutedByAdmin(true);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, Integer.valueOf(Factory.DEVICE_HAS_CRAPPY_AAUDIO));
        MediaController.getInstance().setFeedbackView(this.actionBarLayout, true);
        ApplicationLoader.mainInterfacePaused = false;
        SharedConfig.setMainInterfacePaused(false);
        showLanguageAlert(false);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$1-xn0lQRcuygPyggHGnqDIdknqM
            @Override // java.lang.Runnable
            public final void run() {
                LaunchActivity.lambda$onResume$60();
            }
        });
        checkFreeDiscSpace();
        MediaController.checkGallery();
        onPasscodeResume();
        PasscodeView passcodeView = this.passcodeView;
        if (passcodeView == null || passcodeView.getVisibility() != 0) {
            this.actionBarLayout.onResume();
            if (AndroidUtilities.isTablet()) {
                this.rightActionBarLayout.onResume();
                this.layersActionBarLayout.onResume();
            }
        } else {
            this.actionBarLayout.dismissDialogs();
            if (AndroidUtilities.isTablet()) {
                this.rightActionBarLayout.dismissDialogs();
                this.layersActionBarLayout.dismissDialogs();
            }
            this.passcodeView.onResume();
        }
        ConnectionsManager.getInstance(this.currentAccount).setAppPaused(false, false);
        updateCurrentConnectionState(this.currentAccount);
        if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
            PhotoViewer.getInstance().onResume();
        }
        if (PipRoundVideoView.getInstance() != null && MediaController.getInstance().isMessagePaused() && (playingMessageObject = MediaController.getInstance().getPlayingMessageObject()) != null) {
            MediaController.getInstance().seekToProgress(playingMessageObject, playingMessageObject.audioProgress);
        }
        if (UserConfig.getInstance(UserConfig.selectedAccount).unacceptedTermsOfService != null) {
            int i = UserConfig.selectedAccount;
            showTosActivity(i, UserConfig.getInstance(i).unacceptedTermsOfService);
        } else {
            TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate = SharedConfig.pendingAppUpdate;
            if (tLRPC$TL_help_appUpdate != null && tLRPC$TL_help_appUpdate.can_not_skip) {
                showUpdateActivity(UserConfig.selectedAccount, SharedConfig.pendingAppUpdate, true);
            }
        }
        checkAppUpdate(false);
        if (Build.VERSION.SDK_INT >= 23) {
            ApplicationLoader.canDrawOverlays = Settings.canDrawOverlays(this);
        }
        if (VoIPFragment.getInstance() != null) {
            VoIPFragment.onResume();
        }
        if (SharedConfig.sentDeviceUserIds) {
            return;
        }
        MessagesController.getInstance(this.currentAccount).sendDeviceUserIds();
    }

    static /* synthetic */ void lambda$onResume$60() {
        ApplicationLoader.mainInterfacePausedStageQueue = false;
        ApplicationLoader.mainInterfacePausedStageQueueTime = System.currentTimeMillis();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AndroidUtilities.checkDisplaySize(this, newConfig);
        super.onConfigurationChanged(newConfig);
        checkLayout();
        PipRoundVideoView pipRoundVideoView = PipRoundVideoView.getInstance();
        if (pipRoundVideoView != null) {
            pipRoundVideoView.onConfigurationChanged();
        }
        EmbedBottomSheet embedBottomSheet = EmbedBottomSheet.getInstance();
        if (embedBottomSheet != null) {
            embedBottomSheet.onConfigurationChanged(newConfig);
        }
        PhotoViewer pipInstance = PhotoViewer.getPipInstance();
        if (pipInstance != null) {
            pipInstance.onConfigurationChanged(newConfig);
        }
        ThemeEditorView themeEditorView = ThemeEditorView.getInstance();
        if (themeEditorView != null) {
            themeEditorView.onConfigurationChanged();
        }
        if (Theme.selectedAutoNightType == 3) {
            Theme.checkAutoNightThemeConditions();
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        AndroidUtilities.isInMultiwindow = isInMultiWindowMode;
        checkLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:378:? A[RETURN, SYNTHETIC] */
    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r17, final int r18, java.lang.Object... r19) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 2152
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    static /* synthetic */ void lambda$didReceivedNotification$61(int i, DialogInterface dialogInterface, int i2) {
        if (mainFragmentsStack.isEmpty()) {
            return;
        }
        MessagesController messagesController = MessagesController.getInstance(i);
        ArrayList<BaseFragment> arrayList = mainFragmentsStack;
        messagesController.openByUserName("spambot", arrayList.get(arrayList.size() - 1), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$62, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$62$LaunchActivity(DialogInterface dialogInterface, int i) throws InterruptedException {
        MessagesController.getInstance(this.currentAccount).performLogout(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$64$LaunchActivity(final HashMap map, final int i, DialogInterface dialogInterface, int i2) {
        if (mainFragmentsStack.isEmpty()) {
            return;
        }
        if (AndroidUtilities.isGoogleMapsInstalled(mainFragmentsStack.get(r3.size() - 1))) {
            LocationActivity locationActivity = new LocationActivity(0);
            locationActivity.setDelegate(new LocationActivity.LocationActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$TrS3dr0xO4cQK8BrXqkI42jMklg
            });
            lambda$runLinkRequest$39(locationActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$69, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$69$LaunchActivity(final Theme.ThemeInfo themeInfo, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$PTiWfpGb8k1qDnD0i1C9ff1IISc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$68$LaunchActivity(tLObject, themeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$68$LaunchActivity(TLObject tLObject, Theme.ThemeInfo themeInfo) {
        if (tLObject instanceof TLRPC$TL_wallPaper) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) tLObject;
            this.loadingThemeInfo = themeInfo;
            this.loadingThemeWallpaperName = FileLoader.getAttachFileName(tLRPC$TL_wallPaper.document);
            this.loadingThemeWallpaper = tLRPC$TL_wallPaper;
            FileLoader.getInstance(themeInfo.account).loadFile(tLRPC$TL_wallPaper.document, tLRPC$TL_wallPaper, 1, 1);
            return;
        }
        onThemeLoadFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$71, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$71$LaunchActivity(Theme.ThemeInfo themeInfo, File file) {
        themeInfo.createBackground(file, themeInfo.pathToWallpaper);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$S71yrtzVQdjncODWGvmBQekG5ZQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$70$LaunchActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$70$LaunchActivity() {
        if (this.loadingTheme == null) {
            return;
        }
        File file = new File(ApplicationLoader.getFilesDirFixed(), "remote" + this.loadingTheme.id + ".attheme");
        TLRPC$TL_theme tLRPC$TL_theme = this.loadingTheme;
        Theme.ThemeInfo themeInfoApplyThemeFile = Theme.applyThemeFile(file, tLRPC$TL_theme.title, tLRPC$TL_theme, true);
        if (themeInfoApplyThemeFile != null) {
            lambda$runLinkRequest$39(new ThemePreviewActivity(themeInfoApplyThemeFile, true, 0, false, false));
        }
        onThemeLoadFinish();
    }

    private void invalidateCachedViews(View parent) {
        if (parent.getLayerType() != 0) {
            parent.invalidate();
        }
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                invalidateCachedViews(viewGroup.getChildAt(i));
            }
        }
    }

    private void checkWasMutedByAdmin(boolean checkOnly) {
        ChatObject.Call call;
        long j;
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        boolean z = false;
        if (sharedInstance != null && (call = sharedInstance.groupCall) != null) {
            boolean z2 = this.wasMutedByAdminRaisedHand;
            TLRPC$InputPeer groupCallPeer = sharedInstance.getGroupCallPeer();
            if (groupCallPeer != null) {
                j = groupCallPeer.user_id;
                if (j == 0) {
                    long j2 = groupCallPeer.chat_id;
                    if (j2 == 0) {
                        j2 = groupCallPeer.channel_id;
                    }
                    j = -j2;
                }
            } else {
                j = UserConfig.getInstance(this.currentAccount).clientUserId;
            }
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = call.participants.get(j);
            boolean z3 = (tLRPC$TL_groupCallParticipant == null || tLRPC$TL_groupCallParticipant.can_self_unmute || !tLRPC$TL_groupCallParticipant.muted) ? false : true;
            if (z3 && tLRPC$TL_groupCallParticipant.raise_hand_rating != 0) {
                z = true;
            }
            this.wasMutedByAdminRaisedHand = z;
            if (checkOnly || !z2 || z || z3 || GroupCallActivity.groupCallInstance != null) {
                return;
            }
            showVoiceChatTooltip(38);
            return;
        }
        this.wasMutedByAdminRaisedHand = false;
    }

    private void showVoiceChatTooltip(int action) {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null || mainFragmentsStack.isEmpty() || sharedInstance.groupCall == null || mainFragmentsStack.isEmpty()) {
            return;
        }
        TLRPC$Chat chat = sharedInstance.getChat();
        BaseFragment baseFragment = this.actionBarLayout.fragmentsStack.get(r1.size() - 1);
        if (baseFragment instanceof ChatActivity) {
            ChatActivity chatActivity = (ChatActivity) baseFragment;
            if (chatActivity.getDialogId() == (-chat.id)) {
                chat = null;
            }
            chatActivity.getUndoView().showWithAction(0L, action, chat);
        } else if (baseFragment instanceof DialogsActivity) {
            ((DialogsActivity) baseFragment).getUndoView().showWithAction(0L, action, chat);
        } else if (baseFragment instanceof ProfileActivity) {
            ((ProfileActivity) baseFragment).getUndoView().showWithAction(0L, action, chat);
        }
        if (action != 38 || VoIPService.getSharedInstance() == null) {
            return;
        }
        VoIPService.getSharedInstance().playAllowTalkSound();
    }

    private String getStringForLanguageAlert(HashMap<String, String> map, String key, int intKey) {
        String str = map.get(key);
        return str == null ? LocaleController.getString(key, intKey) : str;
    }

    private void openThemeAccentPreview(TLRPC$TL_theme t, TLRPC$TL_wallPaper wallPaper, Theme.ThemeInfo info) {
        int i = info.lastAccentId;
        Theme.ThemeAccent themeAccentCreateNewAccent = info.createNewAccent(t, this.currentAccount);
        info.prevAccentId = info.currentAccentId;
        info.setCurrentAccentId(themeAccentCreateNewAccent.id);
        themeAccentCreateNewAccent.pattern = wallPaper;
        lambda$runLinkRequest$39(new ThemePreviewActivity(info, i != info.lastAccentId, 0, false, false));
    }

    private void onThemeLoadFinish() {
        AlertDialog alertDialog = this.loadingThemeProgressDialog;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } finally {
                this.loadingThemeProgressDialog = null;
            }
        }
        this.loadingThemeWallpaperName = null;
        this.loadingThemeWallpaper = null;
        this.loadingThemeInfo = null;
        this.loadingThemeFileName = null;
        this.loadingTheme = null;
    }

    private void checkFreeDiscSpace() throws InterruptedException {
        SharedConfig.checkKeepMedia();
        SharedConfig.checkLogsToDelete();
        if (Build.VERSION.SDK_INT >= 26) {
            return;
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$_z7M2TQ0pfpNNnV82GOpeLgv3WE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkFreeDiscSpace$73$LaunchActivity();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkFreeDiscSpace$73, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkFreeDiscSpace$73$LaunchActivity() {
        File directory;
        long blockSizeLong;
        if (UserConfig.getInstance(this.currentAccount).isClientActivated()) {
            try {
                SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
                if (Math.abs(globalMainSettings.getLong("last_space_check", 0L) - System.currentTimeMillis()) < 259200000 || (directory = FileLoader.getDirectory(4)) == null) {
                    return;
                }
                StatFs statFs = new StatFs(directory.getAbsolutePath());
                if (Build.VERSION.SDK_INT < 18) {
                    blockSizeLong = Math.abs(statFs.getAvailableBlocks() * statFs.getBlockSize());
                } else {
                    blockSizeLong = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
                }
                if (blockSizeLong < 104857600) {
                    globalMainSettings.edit().putLong("last_space_check", System.currentTimeMillis()).commit();
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$om2gmpRL-hovxv_VW8oe20mdXuA
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$checkFreeDiscSpace$72$LaunchActivity();
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkFreeDiscSpace$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkFreeDiscSpace$72$LaunchActivity() {
        try {
            AlertsCreator.createFreeSpaceDialog(this).show();
        } catch (Throwable unused) {
        }
    }

    private void showLanguageAlert(boolean force) {
        String str;
        try {
            if (!this.loadingLocaleDialog && !ApplicationLoader.mainInterfacePaused) {
                String string = MessagesController.getGlobalMainSettings().getString("language_showed2", "");
                String str2 = MessagesController.getInstance(this.currentAccount).suggestedLangCode;
                if (!force && string.equals(str2)) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("alert already showed for " + string);
                        return;
                    }
                    return;
                }
                LocaleController.LocaleInfo[] localeInfoArr = new LocaleController.LocaleInfo[2];
                String str3 = str2.contains("-") ? str2.split("-")[0] : str2;
                if ("in".equals(str3)) {
                    str = "id";
                } else if ("iw".equals(str3)) {
                    str = "he";
                } else {
                    str = "jw".equals(str3) ? "jv" : null;
                }
                for (int i = 0; i < LocaleController.getInstance().languages.size(); i++) {
                    LocaleController.LocaleInfo localeInfo = LocaleController.getInstance().languages.get(i);
                    if (localeInfo.shortName.equals("en")) {
                        localeInfoArr[0] = localeInfo;
                    }
                    if (localeInfo.shortName.replace("_", "-").equals(str2) || localeInfo.shortName.equals(str3) || localeInfo.shortName.equals(str)) {
                        localeInfoArr[1] = localeInfo;
                    }
                    if (localeInfoArr[0] != null && localeInfoArr[1] != null) {
                        break;
                    }
                }
                if (localeInfoArr[0] != null && localeInfoArr[1] != null && localeInfoArr[0] != localeInfoArr[1]) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("show lang alert for " + localeInfoArr[0].getKey() + " and " + localeInfoArr[1].getKey());
                    }
                    this.systemLocaleStrings = null;
                    this.englishLocaleStrings = null;
                    this.loadingLocaleDialog = true;
                    TLRPC$TL_langpack_getStrings tLRPC$TL_langpack_getStrings = new TLRPC$TL_langpack_getStrings();
                    tLRPC$TL_langpack_getStrings.lang_code = localeInfoArr[1].getLangCode();
                    tLRPC$TL_langpack_getStrings.keys.add("English");
                    tLRPC$TL_langpack_getStrings.keys.add("ChooseYourLanguage");
                    tLRPC$TL_langpack_getStrings.keys.add("ChooseYourLanguageOther");
                    tLRPC$TL_langpack_getStrings.keys.add("ChangeLanguageLater");
                    ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_langpack_getStrings, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$-7xg788s9aece6x80DghtZeVMAI
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$showLanguageAlert$78$LaunchActivity(tLObject, tLRPC$TL_error);
                        }
                    }, 8);
                    TLRPC$TL_langpack_getStrings tLRPC$TL_langpack_getStrings2 = new TLRPC$TL_langpack_getStrings();
                    tLRPC$TL_langpack_getStrings2.lang_code = localeInfoArr[0].getLangCode();
                    tLRPC$TL_langpack_getStrings2.keys.add("English");
                    tLRPC$TL_langpack_getStrings2.keys.add("ChooseYourLanguage");
                    tLRPC$TL_langpack_getStrings2.keys.add("ChooseYourLanguageOther");
                    tLRPC$TL_langpack_getStrings2.keys.add("ChangeLanguageLater");
                    ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_langpack_getStrings2, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$SHERtXikfEf3mwwGSBLA970Ifno
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$showLanguageAlert$80$LaunchActivity(tLObject, tLRPC$TL_error);
                        }
                    }, 8);
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showLanguageAlert$78, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showLanguageAlert$78$LaunchActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final HashMap map = new HashMap();
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            for (int i = 0; i < tLRPC$Vector.objects.size(); i++) {
                TLRPC$LangPackString tLRPC$LangPackString = (TLRPC$LangPackString) tLRPC$Vector.objects.get(i);
                map.put(tLRPC$LangPackString.key, tLRPC$LangPackString.value);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$8InJFyw36NE_44AmqvCvVcIsC7w
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showLanguageAlert$77$LaunchActivity(map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showLanguageAlert$77, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showLanguageAlert$77$LaunchActivity(HashMap map) {
        this.systemLocaleStrings = map;
        HashMap<String, String> map2 = this.englishLocaleStrings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showLanguageAlert$80, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showLanguageAlert$80$LaunchActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final HashMap map = new HashMap();
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            for (int i = 0; i < tLRPC$Vector.objects.size(); i++) {
                TLRPC$LangPackString tLRPC$LangPackString = (TLRPC$LangPackString) tLRPC$Vector.objects.get(i);
                map.put(tLRPC$LangPackString.key, tLRPC$LangPackString.value);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$kqLpJrFRZSglPDsaWPd7rWVHGCE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showLanguageAlert$79$LaunchActivity(map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showLanguageAlert$79, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showLanguageAlert$79$LaunchActivity(HashMap map) {
        this.englishLocaleStrings = map;
    }

    private void onPasscodePause() {
        if (this.lockRunnable != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("cancel lockRunnable onPasscodePause");
            }
            AndroidUtilities.cancelRunOnUIThread(this.lockRunnable);
            this.lockRunnable = null;
        }
        if (SharedConfig.passcodeHash.length() != 0) {
            SharedConfig.lastPauseTime = (int) (SystemClock.elapsedRealtime() / 1000);
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.LaunchActivity.18
                @Override // java.lang.Runnable
                public void run() throws InterruptedException, IOException {
                    if (LaunchActivity.this.lockRunnable == this) {
                        if (AndroidUtilities.needShowPasscode(true)) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("lock app");
                            }
                            LaunchActivity.this.showPasscodeActivity(true, false, -1, -1, null, null);
                        } else if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("didn't pass lock check");
                        }
                        LaunchActivity.this.lockRunnable = null;
                    }
                }
            };
            this.lockRunnable = runnable;
            if (SharedConfig.appLocked) {
                AndroidUtilities.runOnUIThread(runnable, 1000L);
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("schedule app lock in 1000");
                }
            } else if (SharedConfig.autoLockIn != 0) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("schedule app lock in " + ((SharedConfig.autoLockIn * 1000) + 1000));
                }
                AndroidUtilities.runOnUIThread(this.lockRunnable, (SharedConfig.autoLockIn * 1000) + 1000);
            }
        } else {
            SharedConfig.lastPauseTime = 0;
        }
        SharedConfig.saveConfig();
    }

    private void onPasscodeResume() throws InterruptedException, IOException {
        if (this.lockRunnable != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("cancel lockRunnable onPasscodeResume");
            }
            AndroidUtilities.cancelRunOnUIThread(this.lockRunnable);
            this.lockRunnable = null;
        }
        if (AndroidUtilities.needShowPasscode(true)) {
            showPasscodeActivity(true, false, -1, -1, null, null);
        }
        if (SharedConfig.lastPauseTime != 0) {
            SharedConfig.lastPauseTime = 0;
            SharedConfig.saveConfig();
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("reset lastPauseTime onPasscodeResume");
            }
        }
    }

    private void updateCurrentConnectionState(int account) {
        String str;
        if (this.actionBarLayout == null) {
            return;
        }
        int i = 0;
        int connectionState = ConnectionsManager.getInstance(this.currentAccount).getConnectionState();
        this.currentConnectionState = connectionState;
        if (connectionState == 2) {
            i = R.string.WaitingForNetwork;
            str = "WaitingForNetwork";
        } else if (connectionState == 4) {
            i = R.string.Updating;
            str = "Updating";
        } else if (connectionState == 5) {
            i = R.string.ConnectingToProxy;
            str = "ConnectingToProxy";
        } else if (connectionState == 1) {
            i = R.string.Connecting;
            str = "Connecting";
        } else {
            str = null;
        }
        this.actionBarLayout.setTitleOverlayText(str, i, (connectionState == 1 || connectionState == 5) ? new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LaunchActivity$gnoXSbwvnouSdjhdISI6p2GMrFs
            @Override // java.lang.Runnable
            public final void run() {
                LaunchActivity.lambda$updateCurrentConnectionState$81();
            }
        } : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$updateCurrentConnectionState$81() {
        /*
            boolean r0 = ir.eitaa.messenger.AndroidUtilities.isTablet()
            if (r0 == 0) goto L1d
            java.util.ArrayList<ir.eitaa.ui.ActionBar.BaseFragment> r0 = ir.eitaa.ui.LaunchActivity.layerFragmentsStack
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L34
            java.util.ArrayList<ir.eitaa.ui.ActionBar.BaseFragment> r0 = ir.eitaa.ui.LaunchActivity.layerFragmentsStack
            int r1 = r0.size()
            int r1 = r1 + (-1)
            java.lang.Object r0 = r0.get(r1)
            ir.eitaa.ui.ActionBar.BaseFragment r0 = (ir.eitaa.ui.ActionBar.BaseFragment) r0
            goto L35
        L1d:
            java.util.ArrayList<ir.eitaa.ui.ActionBar.BaseFragment> r0 = ir.eitaa.ui.LaunchActivity.mainFragmentsStack
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L34
            java.util.ArrayList<ir.eitaa.ui.ActionBar.BaseFragment> r0 = ir.eitaa.ui.LaunchActivity.mainFragmentsStack
            int r1 = r0.size()
            int r1 = r1 + (-1)
            java.lang.Object r0 = r0.get(r1)
            ir.eitaa.ui.ActionBar.BaseFragment r0 = (ir.eitaa.ui.ActionBar.BaseFragment) r0
            goto L35
        L34:
            r0 = 0
        L35:
            boolean r1 = r0 instanceof ir.eitaa.ui.ProxyListActivity
            if (r1 != 0) goto L3e
            boolean r0 = r0 instanceof ir.eitaa.ui.ProxySettingsActivity
            if (r0 == 0) goto L3e
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LaunchActivity.lambda$updateCurrentConnectionState$81():void");
    }

    public void hideVisibleActionMode() {
        ActionMode actionMode = this.visibleActionMode;
        if (actionMode == null) {
            return;
        }
        actionMode.finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        try {
            super.onSaveInstanceState(outState);
            BaseFragment baseFragment = null;
            if (AndroidUtilities.isTablet()) {
                if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                    baseFragment = this.layersActionBarLayout.fragmentsStack.get(r0.size() - 1);
                } else if (!this.rightActionBarLayout.fragmentsStack.isEmpty()) {
                    baseFragment = this.rightActionBarLayout.fragmentsStack.get(r0.size() - 1);
                } else if (!this.actionBarLayout.fragmentsStack.isEmpty()) {
                    baseFragment = this.actionBarLayout.fragmentsStack.get(r0.size() - 1);
                }
            } else if (!this.actionBarLayout.fragmentsStack.isEmpty()) {
                baseFragment = this.actionBarLayout.fragmentsStack.get(r0.size() - 1);
            }
            if (baseFragment != null) {
                Bundle arguments = baseFragment.getArguments();
                if ((baseFragment instanceof ChatActivity) && arguments != null) {
                    outState.putBundle("args", arguments);
                    outState.putString("fragment", "chat");
                } else if ((baseFragment instanceof GroupCreateFinalActivity) && arguments != null) {
                    outState.putBundle("args", arguments);
                    outState.putString("fragment", "group");
                } else if (baseFragment instanceof WallpapersListActivity) {
                    outState.putString("fragment", "wallpapers");
                } else if (baseFragment instanceof ProfileActivity) {
                    ProfileActivity profileActivity = (ProfileActivity) baseFragment;
                    if (profileActivity.isSettings()) {
                        outState.putString("fragment", "settings");
                    } else if (profileActivity.isChat() && arguments != null) {
                        outState.putBundle("args", arguments);
                        outState.putString("fragment", "chat_profile");
                    }
                } else if ((baseFragment instanceof ChannelCreateActivity) && arguments != null && arguments.getInt("step") == 0) {
                    outState.putBundle("args", arguments);
                    outState.putString("fragment", "channel");
                }
                baseFragment.saveSelfArgs(outState);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        PasscodeView passcodeView = this.passcodeView;
        if (passcodeView != null && passcodeView.getVisibility() == 0) {
            if (this.passcodeView.isChatLock) {
                dismissPasscodeView();
                return;
            } else {
                finish();
                return;
            }
        }
        boolean z = false;
        if (SecretMediaViewer.hasInstance() && SecretMediaViewer.getInstance().isVisible()) {
            SecretMediaViewer.getInstance().closePhoto(true, false);
            return;
        }
        if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
            PhotoViewer.getInstance().closePhoto(true, false);
            return;
        }
        if (ArticleViewer.hasInstance() && ArticleViewer.getInstance().isVisible()) {
            ArticleViewer.getInstance().close(true, false);
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
            }
            if (this.rightActionBarLayout.getVisibility() == 0 && !this.rightActionBarLayout.fragmentsStack.isEmpty()) {
                ArrayList<BaseFragment> arrayList = this.rightActionBarLayout.fragmentsStack;
                z = !arrayList.get(arrayList.size() - 1).onBackPressed();
            }
            if (z) {
                return;
            }
            this.actionBarLayout.onBackPressed();
            return;
        }
        this.actionBarLayout.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        ActionBarLayout actionBarLayout = this.actionBarLayout;
        if (actionBarLayout != null) {
            actionBarLayout.onLowMemory();
            if (AndroidUtilities.isTablet()) {
                this.rightActionBarLayout.onLowMemory();
                this.layersActionBarLayout.onLowMemory();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode mode) {
        super.onActionModeStarted(mode);
        this.visibleActionMode = mode;
        try {
            Menu menu = mode.getMenu();
            if (menu != null && !this.actionBarLayout.extendActionMode(menu) && AndroidUtilities.isTablet() && !this.rightActionBarLayout.extendActionMode(menu)) {
                this.layersActionBarLayout.extendActionMode(menu);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (Build.VERSION.SDK_INT < 23 || mode.getType() != 1) {
            this.actionBarLayout.onActionModeStarted(mode);
            if (AndroidUtilities.isTablet()) {
                this.rightActionBarLayout.onActionModeStarted(mode);
                this.layersActionBarLayout.onActionModeStarted(mode);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode mode) {
        super.onActionModeFinished(mode);
        if (this.visibleActionMode == mode) {
            this.visibleActionMode = null;
        }
        if (Build.VERSION.SDK_INT < 23 || mode.getType() != 1) {
            this.actionBarLayout.onActionModeFinished(mode);
            if (AndroidUtilities.isTablet()) {
                this.rightActionBarLayout.onActionModeFinished(mode);
                this.layersActionBarLayout.onActionModeFinished(mode);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean onPreIme() {
        if (SecretMediaViewer.hasInstance() && SecretMediaViewer.getInstance().isVisible()) {
            SecretMediaViewer.getInstance().closePhoto(true, false);
            return true;
        }
        if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
            PhotoViewer.getInstance().closePhoto(true, false);
            return true;
        }
        if (!ArticleViewer.hasInstance() || !ArticleViewer.getInstance().isVisible()) {
            return false;
        }
        ArticleViewer.getInstance().close(true, false);
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        event.getKeyCode();
        if (event.getAction() == 0 && (event.getKeyCode() == 24 || event.getKeyCode() == 25)) {
            if (VoIPService.getSharedInstance() != null) {
                if (Build.VERSION.SDK_INT >= 32) {
                    boolean zIsSpeakerMuted = WebRtcAudioTrack.isSpeakerMuted();
                    AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                    boolean z = audioManager.getStreamVolume(0) == audioManager.getStreamMinVolume(0) && event.getKeyCode() == 25;
                    WebRtcAudioTrack.setSpeakerMute(z);
                    if (zIsSpeakerMuted != WebRtcAudioTrack.isSpeakerMuted()) {
                        showVoiceChatTooltip(z ? 42 : 43);
                    }
                }
            } else if (!mainFragmentsStack.isEmpty() && ((!PhotoViewer.hasInstance() || !PhotoViewer.getInstance().isVisible()) && event.getRepeatCount() == 0)) {
                ArrayList<BaseFragment> arrayList = mainFragmentsStack;
                BaseFragment baseFragment = arrayList.get(arrayList.size() - 1);
                if ((baseFragment instanceof ChatActivity) && ((ChatActivity) baseFragment).maybePlayVisibleVideo()) {
                    return true;
                }
                if (AndroidUtilities.isTablet() && !rightFragmentsStack.isEmpty()) {
                    ArrayList<BaseFragment> arrayList2 = rightFragmentsStack;
                    BaseFragment baseFragment2 = arrayList2.get(arrayList2.size() - 1);
                    if ((baseFragment2 instanceof ChatActivity) && ((ChatActivity) baseFragment2).maybePlayVisibleVideo()) {
                        return true;
                    }
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 82 && !SharedConfig.isWaitingForPasscodeEnter) {
            if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
                return super.onKeyUp(keyCode, event);
            }
            if (ArticleViewer.hasInstance() && ArticleViewer.getInstance().isVisible()) {
                return super.onKeyUp(keyCode, event);
            }
            if (AndroidUtilities.isTablet()) {
                if (this.layersActionBarLayout.getVisibility() == 0 && !this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                    this.layersActionBarLayout.onKeyUp(keyCode, event);
                } else if (this.rightActionBarLayout.getVisibility() == 0 && !this.rightActionBarLayout.fragmentsStack.isEmpty()) {
                    this.rightActionBarLayout.onKeyUp(keyCode, event);
                } else {
                    this.actionBarLayout.onKeyUp(keyCode, event);
                }
            } else if (this.actionBarLayout.fragmentsStack.size() == 1) {
                if (!this.drawerLayoutContainer.isDrawerOpened()) {
                    if (getCurrentFocus() != null) {
                        AndroidUtilities.hideKeyboard(getCurrentFocus());
                    }
                    this.drawerLayoutContainer.openDrawer(false);
                } else {
                    this.drawerLayoutContainer.closeDrawer(false);
                }
            } else {
                this.actionBarLayout.onKeyUp(keyCode, event);
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean needPresentFragment(BaseFragment fragment, boolean removeLast, boolean forceWithoutAnimation, ActionBarLayout layout) {
        ActionBarLayout actionBarLayout;
        ActionBarLayout actionBarLayout2;
        ActionBarLayout actionBarLayout3;
        ActionBarLayout actionBarLayout4;
        if (ArticleViewer.hasInstance() && ArticleViewer.getInstance().isVisible()) {
            ArticleViewer.getInstance().close(false, true);
        }
        if (AndroidUtilities.isTablet()) {
            boolean z = fragment instanceof LoginActivity;
            this.drawerLayoutContainer.setAllowOpenDrawer((z || (fragment instanceof CountrySelectActivity) || this.layersActionBarLayout.getVisibility() == 0) ? false : true, true);
            if ((fragment instanceof DialogsActivity) && ((DialogsActivity) fragment).isMainDialogList() && layout != (actionBarLayout4 = this.actionBarLayout)) {
                actionBarLayout4.removeAllFragments();
                this.actionBarLayout.presentFragment(fragment, removeLast, forceWithoutAnimation, false, false);
                this.layersActionBarLayout.removeAllFragments();
                this.layersActionBarLayout.setVisibility(8);
                this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
                if (!this.tabletFullSize) {
                    this.shadowTabletSide.setVisibility(0);
                    if (this.rightActionBarLayout.fragmentsStack.isEmpty()) {
                        this.backgroundTablet.setVisibility(0);
                    }
                }
                return false;
            }
            if (((fragment instanceof ChatActivity) && !((ChatActivity) fragment).isInScheduleMode()) || (fragment instanceof MediaChannelActivity) || (fragment instanceof MessageExploreActivity) || (fragment instanceof ExploreActivity) || (fragment instanceof KavoshActivity)) {
                boolean z2 = this.tabletFullSize;
                if ((!z2 && layout == this.rightActionBarLayout) || (z2 && layout == this.actionBarLayout)) {
                    boolean z3 = (z2 && layout == (actionBarLayout3 = this.actionBarLayout) && actionBarLayout3.fragmentsStack.size() == 1) ? false : true;
                    if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                        while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                            ActionBarLayout actionBarLayout5 = this.layersActionBarLayout;
                            actionBarLayout5.removeFragmentFromStack(actionBarLayout5.fragmentsStack.get(0));
                        }
                        this.layersActionBarLayout.closeLastFragment(!forceWithoutAnimation);
                    }
                    if (!z3) {
                        this.actionBarLayout.presentFragment(fragment, false, forceWithoutAnimation, false, false);
                    }
                    return z3;
                }
                if (!z2 && layout != (actionBarLayout2 = this.rightActionBarLayout)) {
                    actionBarLayout2.setVisibility(0);
                    this.backgroundTablet.setVisibility(8);
                    this.rightActionBarLayout.removeAllFragments();
                    this.rightActionBarLayout.presentFragment(fragment, removeLast, true, false, false);
                    if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                        while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                            ActionBarLayout actionBarLayout6 = this.layersActionBarLayout;
                            actionBarLayout6.removeFragmentFromStack(actionBarLayout6.fragmentsStack.get(0));
                        }
                        this.layersActionBarLayout.closeLastFragment(!forceWithoutAnimation);
                    }
                    return false;
                }
                if (z2 && layout != (actionBarLayout = this.actionBarLayout)) {
                    actionBarLayout.presentFragment(fragment, actionBarLayout.fragmentsStack.size() > 1, forceWithoutAnimation, false, false);
                    if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                        while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                            ActionBarLayout actionBarLayout7 = this.layersActionBarLayout;
                            actionBarLayout7.removeFragmentFromStack(actionBarLayout7.fragmentsStack.get(0));
                        }
                        this.layersActionBarLayout.closeLastFragment(!forceWithoutAnimation);
                    }
                    return false;
                }
                if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                    while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                        ActionBarLayout actionBarLayout8 = this.layersActionBarLayout;
                        actionBarLayout8.removeFragmentFromStack(actionBarLayout8.fragmentsStack.get(0));
                    }
                    this.layersActionBarLayout.closeLastFragment(!forceWithoutAnimation);
                }
                ActionBarLayout actionBarLayout9 = this.actionBarLayout;
                actionBarLayout9.presentFragment(fragment, actionBarLayout9.fragmentsStack.size() > 1, forceWithoutAnimation, false, false);
                return false;
            }
            ActionBarLayout actionBarLayout10 = this.layersActionBarLayout;
            if (layout != actionBarLayout10) {
                actionBarLayout10.setVisibility(0);
                this.drawerLayoutContainer.setAllowOpenDrawer(false, true);
                if (z) {
                    this.backgroundTablet.setVisibility(0);
                    this.shadowTabletSide.setVisibility(8);
                    this.shadowTablet.setBackgroundColor(0);
                } else {
                    this.shadowTablet.setBackgroundColor(2130706432);
                }
                this.layersActionBarLayout.presentFragment(fragment, removeLast, forceWithoutAnimation, false, false);
                return false;
            }
        } else {
            this.drawerLayoutContainer.setAllowOpenDrawer(!(fragment instanceof LoginActivity) ? (fragment instanceof CountrySelectActivity) && mainFragmentsStack.size() == 1 : mainFragmentsStack.size() == 0, false);
        }
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean needAddFragmentToStack(BaseFragment fragment, ActionBarLayout layout) {
        ActionBarLayout actionBarLayout;
        ActionBarLayout actionBarLayout2;
        ActionBarLayout actionBarLayout3;
        if (AndroidUtilities.isTablet()) {
            boolean z = fragment instanceof LoginActivity;
            this.drawerLayoutContainer.setAllowOpenDrawer((z || (fragment instanceof CountrySelectActivity) || this.layersActionBarLayout.getVisibility() == 0) ? false : true, true);
            if (fragment instanceof DialogsActivity) {
                if (((DialogsActivity) fragment).isMainDialogList() && layout != (actionBarLayout3 = this.actionBarLayout)) {
                    actionBarLayout3.removeAllFragments();
                    this.actionBarLayout.addFragmentToStack(fragment);
                    this.layersActionBarLayout.removeAllFragments();
                    this.layersActionBarLayout.setVisibility(8);
                    this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
                    if (!this.tabletFullSize) {
                        this.shadowTabletSide.setVisibility(0);
                        if (this.rightActionBarLayout.fragmentsStack.isEmpty()) {
                            this.backgroundTablet.setVisibility(0);
                        }
                    }
                    return false;
                }
            } else if ((fragment instanceof ChatActivity) && !((ChatActivity) fragment).isInScheduleMode()) {
                boolean z2 = this.tabletFullSize;
                if (!z2 && layout != (actionBarLayout2 = this.rightActionBarLayout)) {
                    actionBarLayout2.setVisibility(0);
                    this.backgroundTablet.setVisibility(8);
                    this.rightActionBarLayout.removeAllFragments();
                    this.rightActionBarLayout.addFragmentToStack(fragment);
                    if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                        while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                            ActionBarLayout actionBarLayout4 = this.layersActionBarLayout;
                            actionBarLayout4.removeFragmentFromStack(actionBarLayout4.fragmentsStack.get(0));
                        }
                        this.layersActionBarLayout.closeLastFragment(true);
                    }
                    return false;
                }
                if (z2 && layout != (actionBarLayout = this.actionBarLayout)) {
                    actionBarLayout.addFragmentToStack(fragment);
                    if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                        while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                            ActionBarLayout actionBarLayout5 = this.layersActionBarLayout;
                            actionBarLayout5.removeFragmentFromStack(actionBarLayout5.fragmentsStack.get(0));
                        }
                        this.layersActionBarLayout.closeLastFragment(true);
                    }
                    return false;
                }
            } else {
                ActionBarLayout actionBarLayout6 = this.layersActionBarLayout;
                if (layout != actionBarLayout6) {
                    actionBarLayout6.setVisibility(0);
                    this.drawerLayoutContainer.setAllowOpenDrawer(false, true);
                    if (z) {
                        this.backgroundTablet.setVisibility(0);
                        this.shadowTabletSide.setVisibility(8);
                        this.shadowTablet.setBackgroundColor(0);
                    } else {
                        this.shadowTablet.setBackgroundColor(2130706432);
                    }
                    this.layersActionBarLayout.addFragmentToStack(fragment);
                    return false;
                }
            }
        } else {
            this.drawerLayoutContainer.setAllowOpenDrawer(!(fragment instanceof LoginActivity) ? (fragment instanceof CountrySelectActivity) && mainFragmentsStack.size() == 1 : mainFragmentsStack.size() == 0, false);
        }
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean needCloseLastFragment(ActionBarLayout layout) {
        if (AndroidUtilities.isTablet()) {
            if (layout == this.actionBarLayout && layout.fragmentsStack.size() <= 1) {
                onFinish();
                finish();
                return false;
            }
            if (layout == this.rightActionBarLayout) {
                if (!this.tabletFullSize) {
                    this.backgroundTablet.setVisibility(0);
                }
            } else if (layout == this.layersActionBarLayout && this.actionBarLayout.fragmentsStack.isEmpty() && this.layersActionBarLayout.fragmentsStack.size() == 1) {
                onFinish();
                finish();
                return false;
            }
        } else {
            if (layout.fragmentsStack.size() <= 1) {
                onFinish();
                finish();
                return false;
            }
            if (layout.fragmentsStack.size() >= 2 && !(layout.fragmentsStack.get(0) instanceof LoginActivity)) {
                this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
            }
        }
        return true;
    }

    public void rebuildAllFragments(boolean last) {
        ActionBarLayout actionBarLayout = this.layersActionBarLayout;
        if (actionBarLayout != null) {
            actionBarLayout.rebuildAllFragmentViews(last, last);
        } else {
            this.actionBarLayout.rebuildAllFragmentViews(last, last);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public void onRebuildAllFragments(ActionBarLayout layout, boolean last) {
        if (AndroidUtilities.isTablet() && layout == this.layersActionBarLayout) {
            this.rightActionBarLayout.rebuildAllFragmentViews(last, last);
            this.actionBarLayout.rebuildAllFragmentViews(last, last);
        }
        this.sideMenu.setAdapter(this.drawerLayoutAdapter);
        this.drawerLayoutAdapter.notifyDataSetChanged();
    }

    private void dismissPasscodeView() {
        this.passcodeView.dismiss();
        SharedConfig.isWaitingForPasscodeEnter = false;
        this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
        this.actionBarLayout.setVisibility(0);
        this.actionBarLayout.showLastFragment();
        if (AndroidUtilities.isTablet()) {
            this.layersActionBarLayout.showLastFragment();
            this.rightActionBarLayout.showLastFragment();
            if (this.layersActionBarLayout.getVisibility() == 4) {
                this.layersActionBarLayout.setVisibility(0);
            }
            this.rightActionBarLayout.setVisibility(0);
        }
    }
}
