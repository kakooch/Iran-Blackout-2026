package org.rbmain.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidMessenger.ServiceLocator;
import androidMessenger.asemannotification.AsemanNotificationService;
import androidMessenger.model.GetBaseInfoInput;
import androidMessenger.model.GetBaseInfoOutput;
import androidMessenger.model.MessangerOutput;
import androidMessenger.model.StartPopupObject;
import androidMessenger.model.SuggestedUrlsObject;
import androidMessenger.model.UpdateObject2;
import androidMessenger.network.ApiRequestRx;
import androidMessenger.utilites.AppFavorUtils;
import androidMessenger.utilites.FilePickerManager;
import androidMessenger.utilites.UpdateUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.aaap.messengercore.CoreMainClass;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.FloatingViewsLayout;
import ir.resaneh1.iptv.activity.MainTabFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.appUpdate.UpdateActivity;
import ir.resaneh1.iptv.dialog.StartPopupDialog;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.fragment.rubino.RubinoPostListActivity;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.AppPrefrencesTemp;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.messanger.TaskManager;
import ir.resaneh1.iptv.model.PushNotificationObject;
import j$.util.function.Consumer;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.LocationController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.StatsController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.messenger.camera.CameraController;
import org.rbmain.messenger.voip.VideoCapturerDevice;
import org.rbmain.messenger.voip.VoIPService;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$LangPackString;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_account_authorizationForm;
import org.rbmain.tgnet.TLRPC$TL_account_getAuthorizationForm;
import org.rbmain.tgnet.TLRPC$TL_account_getPassword;
import org.rbmain.tgnet.TLRPC$TL_account_password;
import org.rbmain.tgnet.TLRPC$TL_channels_getChannels;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolvedPeer;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipant;
import org.rbmain.tgnet.TLRPC$TL_help_appUpdate;
import org.rbmain.tgnet.TLRPC$TL_help_deepLinkInfo;
import org.rbmain.tgnet.TLRPC$TL_help_getAppUpdate;
import org.rbmain.tgnet.TLRPC$TL_help_termsOfService;
import org.rbmain.tgnet.TLRPC$TL_inputChannel;
import org.rbmain.tgnet.TLRPC$TL_inputGameShortName;
import org.rbmain.tgnet.TLRPC$TL_inputMediaGame;
import org.rbmain.tgnet.TLRPC$TL_langPackLanguage;
import org.rbmain.tgnet.TLRPC$TL_langpack_getStrings;
import org.rbmain.tgnet.TLRPC$TL_messages_chats;
import org.rbmain.tgnet.TLRPC$TL_messages_checkHistoryImport;
import org.rbmain.tgnet.TLRPC$TL_messages_getDiscussionMessage;
import org.rbmain.tgnet.TLRPC$TL_theme;
import org.rbmain.tgnet.TLRPC$TL_wallPaper;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.DrawerLayoutContainer;
import org.rbmain.ui.ActionBar.FrameLayoutContainer;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Adapters.DrawerLayoutAdapter;
import org.rbmain.ui.Cells.DrawerAddCell;
import org.rbmain.ui.Cells.DrawerProfileCell;
import org.rbmain.ui.Cells.DrawerUserCell;
import org.rbmain.ui.Cells.LanguageCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.BlockingUpdateView;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.ChatAttachAlertContactsLayout;
import org.rbmain.ui.Components.EmbedBottomSheet;
import org.rbmain.ui.Components.GroupCallPip;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.PasscodeView;
import org.rbmain.ui.Components.PhonebookShareAlert;
import org.rbmain.ui.Components.PipRoundVideoView;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.SideMenultItemAnimator;
import org.rbmain.ui.Components.TermsOfServiceView;
import org.rbmain.ui.Components.ThemeEditorView;
import org.rbmain.ui.Components.UpdateAppAlertDialog;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.LocationActivity;
import org.webrtc.MediaStreamTrack;
import org.webrtc.voiceengine.WebRtcAudioTrack;

/* loaded from: classes.dex */
public class LaunchActivity extends AppCompatActivity implements ActionBarLayout.ActionBarLayoutDelegate, NotificationCenter.NotificationCenterDelegate, DialogsActivity.DialogsActivityDelegate {
    public static boolean systemBlurEnabled;
    private ActionBarLayout actionBarLayout;
    private View backgroundTablet;
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
    public FloatingViewsLayout floatingViews;
    private FrameLayout frameLayout;
    public FrameLayoutContainer frameLayoutContainer;
    private boolean isBaseUrlSetFromApi;
    public boolean isInBackGround;
    private boolean isLastForceUpdate;
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
    private HashMap<String, String> systemLocaleStrings;
    private boolean tabletFullSize;
    private TermsOfServiceView termsOfServiceView;
    private ImageView themeSwitchImageView;
    private RLottieDrawable themeSwitchSunDrawable;
    private View themeSwitchSunView;
    private TextView toastTextView;
    private String videoPath;
    private ActionMode visibleActionMode;
    private AlertDialog visibleDialog;
    private boolean wasMutedByAdminRaisedHand;
    private static ArrayList<BaseFragment> mainFragmentsStack = new ArrayList<>();
    private static ArrayList<BaseFragment> layerFragmentsStack = new ArrayList<>();
    private static ArrayList<BaseFragment> rightFragmentsStack = new ArrayList<>();
    public CompositeDisposable mainCompositeDisposable = new CompositeDisposable();
    public int topCutoutHeight = 0;
    private SparseIntArray requestedPermissions = new SparseIntArray();
    private int requsetPermissionsPointer = 5934;
    private Consumer<Boolean> blurListener = new Consumer<Boolean>(this) { // from class: org.rbmain.ui.LaunchActivity.1
        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer<Boolean> andThen(Consumer<? super Boolean> consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.function.Consumer
        public void accept(Boolean bool) {
            LaunchActivity.systemBlurEnabled = bool.booleanValue();
        }
    };
    private List<Runnable> onUserLeaveHintListeners = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$1(View view) {
    }

    private void scheduleNotificationWorker() {
    }

    public BaseFragment getSecondLastFragment() {
        if (mainFragmentsStack.size() <= 1) {
            return null;
        }
        return mainFragmentsStack.get(r0.size() - 2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                this.topCutoutHeight = getWindow().getDecorView().getRootWindowInsets().getDisplayCutout().getSafeInsetTop();
            }
        } catch (Exception unused) {
        }
    }

    public static Intent createIntent(Context context, PushNotificationObject pushNotificationObject, int i) {
        Intent intent = new Intent(context, (Class<?>) LaunchActivity.class);
        intent.putExtra("arg", ApplicationLoader.getGson().toJson(pushNotificationObject));
        intent.putExtra("currentAccount", i);
        return intent;
    }

    public void applyTheme() {
        applyTheme(false);
    }

    public void setStatusBarColor(boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            Window window = getWindow();
            window.clearFlags(ConnectionsManager.FileTypeFile);
            window.clearFlags(1024);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.grey_700));
            int color = Theme.getColor(Theme.key_actionBarDefault, null, true);
            if (z) {
                color = -16777216;
            }
            if (i >= 23) {
                getWindow().getDecorView();
                window.setStatusBarColor(color);
            }
        }
    }

    public void applyTheme(boolean z) {
        if (z) {
            try {
                if (Theme.isCurrentThemeNight()) {
                    return;
                }
            } catch (Exception e) {
                MyLog.handleException(e);
                return;
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            AndroidUtilities.setLightStatusBar(getWindow(), (Theme.isCurrentThemeNight() || z) ? false : true);
            setStatusBarColor(z);
        }
        if (i >= 26) {
            Window window = getWindow();
            int color = Theme.getColor(Theme.key_windowBackgroundGray);
            if (z) {
                color = 855638016;
            }
            if (window.getNavigationBarColor() != color) {
                window.setNavigationBarColor(color);
                AndroidUtilities.setLightNavigationBar(getWindow(), AndroidUtilities.computePerceivedBrightness(color) >= 0.721f);
                return;
            }
            AndroidUtilities.setLightNavigationBar(getWindow(), true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x04dd  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$0(View view, MotionEvent motionEvent) {
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
    public /* synthetic */ void lambda$onCreate$2(View view, int i, float f, float f2) {
        boolean zIsLocationEnabled = true;
        if (i == 0) {
            DrawerProfileCell drawerProfileCell = (DrawerProfileCell) view;
            if (drawerProfileCell.isInAvatar(f, f2)) {
                openSettings(drawerProfileCell.hasAvatar());
                return;
            } else {
                this.drawerLayoutAdapter.setAccountsShown(!r2.isAccountsShown(), true);
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
                if (!ServiceLocator.isAccountLoggedIn(i3)) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 >= 0) {
                lambda$runLinkRequest$40(new LoginActivityAppp(i2));
            }
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        int id = this.drawerLayoutAdapter.getId(i);
        if (id == 2) {
            lambda$runLinkRequest$40(new GroupCreateActivity(new Bundle()));
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
            lambda$runLinkRequest$40(new ContactsActivity(bundle));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 4) {
            SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
            if (!BuildVars.DEBUG_VERSION && globalMainSettings.getBoolean("channel_intro", false)) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("step", 0);
                lambda$runLinkRequest$40(new ChannelCreateActivity(bundle2));
            } else {
                lambda$runLinkRequest$40(new ActionIntroActivity(0));
                globalMainSettings.edit().putBoolean("channel_intro", true).apply();
            }
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 6) {
            lambda$runLinkRequest$40(new ContactsActivity(null));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 7) {
            lambda$runLinkRequest$40(new InviteContactsActivity());
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 8) {
            openSettings(false);
            return;
        }
        if (id == 9) {
            Browser.openUrl(this, LocaleController.getString("RubikaFaqUrl", R.string.RubikaFaqUrl));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 10) {
            lambda$runLinkRequest$40(new CallLogActivity());
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id == 11) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("user_id", UserConfig.getInstance(this.currentAccount).getClientUserId());
            lambda$runLinkRequest$40(new ChatActivity(bundle3));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (id != 12) {
            if (id == 13) {
                Browser.openUrl(this, LocaleController.getString("RubikaFeaturesUrl", R.string.RubikaFeaturesUrl));
                this.drawerLayoutContainer.closeDrawer(false);
                return;
            } else {
                if (id == 15) {
                    lambda$runLinkRequest$40(new LanguageSelectActivity());
                    this.drawerLayoutContainer.closeDrawer(false);
                    return;
                }
                return;
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23 && checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            lambda$runLinkRequest$40(new ActionIntroActivity(1));
            this.drawerLayoutContainer.closeDrawer(false);
            return;
        }
        if (i4 >= 28) {
            zIsLocationEnabled = ((LocationManager) ApplicationLoader.applicationContext.getSystemService("location")).isLocationEnabled();
        } else if (i4 >= 19) {
            try {
                if (Settings.Secure.getInt(ApplicationLoader.applicationContext.getContentResolver(), "location_mode", 0) == 0) {
                    zIsLocationEnabled = false;
                }
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        if (zIsLocationEnabled) {
            lambda$runLinkRequest$40(new PeopleNearbyActivity());
        } else {
            lambda$runLinkRequest$40(new ActionIntroActivity(4));
        }
        this.drawerLayoutContainer.closeDrawer(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$3(ItemTouchHelper itemTouchHelper, View view, int i) {
        if (!(view instanceof DrawerUserCell)) {
            return false;
        }
        final int accountNumber = ((DrawerUserCell) view).getAccountNumber();
        if (accountNumber == this.currentAccount || AndroidUtilities.isTablet()) {
            itemTouchHelper.startDrag(this.sideMenu.getChildViewHolder(view));
            return false;
        }
        DialogsActivity dialogsActivity = new DialogsActivity(null) { // from class: org.rbmain.ui.LaunchActivity.7
            @Override // org.rbmain.ui.DialogsActivity, org.rbmain.ui.ActionBar.BaseFragment
            protected void onTransitionAnimationEnd(boolean z, boolean z2) {
                super.onTransitionAnimationEnd(z, z2);
                if (z || !z2) {
                    return;
                }
                LaunchActivity.this.drawerLayoutContainer.setDrawCurrentPreviewFragmentAbove(false);
            }

            @Override // org.rbmain.ui.ActionBar.BaseFragment
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$4(View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNotificationPermission() {
        if (UserConfig.getActivatedAccountsCount() <= 0 || NotificationManagerCompat.from(this).areNotificationsEnabled() || ApplicationLoader.applicationActivity == null || ApplicationLoader.applicationActivity.isFinishing()) {
            return;
        }
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        long j = globalMainSettings.getLong("notification_dialog_time", 0L);
        if (System.currentTimeMillis() - j > (MyLog.isDebugAble ? 30000L : 259200000L)) {
            SharedPreferences.Editor editorEdit = globalMainSettings.edit();
            editorEdit.putLong("notification_dialog_time", System.currentTimeMillis());
            editorEdit.apply();
            showPermissionErrorAlert(LocaleController.getString("PermissionNotification", R.string.PermissionNotification));
        }
    }

    private void checkResetDataUsage() {
        AppPreferences appPreferences = getAppPreferences();
        AppPreferences.Key key = AppPreferences.Key.lastVersionResetDataStat;
        if (appPreferences.getString(key, BuildConfig.FLAVOR).equals(UpdateUtils.getAppVersion(ApplicationLoader.applicationContext))) {
            return;
        }
        StatsController.getInstance(this.currentAccount).resetStats(1);
        StatsController.getInstance(this.currentAccount).resetStats(0);
        StatsController.getInstance(this.currentAccount).resetStats(2);
        getAppPreferences().setString(key, UpdateUtils.getAppVersion(ApplicationLoader.applicationContext));
    }

    protected final ApiRequestRx getAppRequestRx() {
        return AccountInstance.getInstance(this.currentAccount).getAppRequestRx();
    }

    public final AppPreferences getAppPreferences() {
        return AppPreferences.getInstance(this.currentAccount);
    }

    protected final RubinoController getRubinoController() {
        return RubinoController.getInstance(this.currentAccount);
    }

    public void getUpdateRequest2() {
        this.mainCompositeDisposable.add((Disposable) getAppRequestRx().getBaseInfo(new GetBaseInfoInput()).subscribeWith(new DisposableObserver<MessangerOutput<GetBaseInfoOutput>>() { // from class: org.rbmain.ui.LaunchActivity.9
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetBaseInfoOutput> messangerOutput) {
                GetBaseInfoOutput getBaseInfoOutput;
                StartPopupObject startPopupObject;
                StartPopupObject startPopupObject2;
                if (messangerOutput == null || (getBaseInfoOutput = messangerOutput.data) == null) {
                    return;
                }
                GetBaseInfoOutput getBaseInfoOutput2 = getBaseInfoOutput;
                UpdateObject2 updateObject2 = getBaseInfoOutput.update;
                String appVersion = ir.resaneh1.iptv.appUpdate.UpdateUtils.getAppVersion(LaunchActivity.this);
                LaunchActivity.this.isLastForceUpdate = false;
                try {
                    if (LaunchActivity.this.getCoreMainClass().isAccountLoggedIn() && (startPopupObject2 = getBaseInfoOutput2.start_popup) != null && startPopupObject2.priority == StartPopupObject.Priority.High && AppPrefrencesTemp.getInstance().getStartPopupShowedTime(getBaseInfoOutput2.start_popup.id) < getBaseInfoOutput2.start_popup.count_show) {
                        new StartPopupDialog(LaunchActivity.this, getBaseInfoOutput2.start_popup).show();
                        AppPrefrencesTemp.getInstance().increaseStartPopupShowedTime(getBaseInfoOutput2.start_popup.id);
                    } else if (!LaunchActivity.this.isInBackGround) {
                        if (ir.resaneh1.iptv.appUpdate.UpdateUtils.versionCompare(appVersion, updateObject2.latest_version) < 0) {
                            LaunchActivity.this.isLastForceUpdate = updateObject2.force_update;
                            LaunchActivity launchActivity = LaunchActivity.this;
                            launchActivity.startActivity(UpdateActivity.creatIntent(launchActivity, updateObject2));
                        } else if (LaunchActivity.this.getCoreMainClass().isAccountLoggedIn() && (startPopupObject = getBaseInfoOutput2.start_popup) != null && startPopupObject.priority == StartPopupObject.Priority.Low && AppPrefrencesTemp.getInstance().getStartPopupShowedTime(getBaseInfoOutput2.start_popup.id) < getBaseInfoOutput2.start_popup.count_show) {
                            new StartPopupDialog(LaunchActivity.this, getBaseInfoOutput2.start_popup).show();
                            AppPrefrencesTemp.getInstance().increaseStartPopupShowedTime(getBaseInfoOutput2.start_popup.id);
                        }
                    }
                } catch (Exception e) {
                    MyLog.handleException(e);
                }
                if (getBaseInfoOutput2.suggested_urls != null) {
                    LaunchActivity.this.isBaseUrlSetFromApi = true;
                    LaunchActivity.this.setBaseUrls(getBaseInfoOutput2.suggested_urls);
                }
                try {
                    LaunchActivity.this.getAppPreferences().setString(AppPreferences.Key.baseInfoObject, ApplicationLoader.getGson().toJson(getBaseInfoOutput2));
                } catch (Exception e2) {
                    MyLog.handleException(e2);
                }
                LaunchActivity.this.rubinoInit();
                TaskManager.getInstance(LaunchActivity.this.currentAccount).getTasksIfNeeded();
            }
        }));
    }

    public void rubinoInit() {
        try {
            if (getAppPreferences().getMyUsername() == null || getAppPreferences().getMyUsername().isEmpty()) {
                return;
            }
            if (AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id == null || AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id.isEmpty()) {
                getRubinoController().getMyProfileList();
            }
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBaseUrls(SuggestedUrlsObject suggestedUrlsObject) {
        if (suggestedUrlsObject == null) {
            return;
        }
        String str = suggestedUrlsObject.suggest_old_services;
        if (str != null && str.startsWith("http")) {
            AppFavorUtils.baseUrlOld = suggestedUrlsObject.suggest_old_services;
            ApiRequestIPTV.getInstance(this.currentAccount).setRestApiService();
        }
        String str2 = suggestedUrlsObject.suggested_payment;
        if (str2 != null && str2.startsWith("http")) {
            AppFavorUtils.payUrlOld = suggestedUrlsObject.suggested_payment + "/api2/v3.0/";
        }
        String str3 = suggestedUrlsObject.suggested_wallet;
        if (str3 != null && str3.startsWith("http")) {
            AppFavorUtils.walletUrl = suggestedUrlsObject.suggested_wallet;
        }
        String str4 = suggestedUrlsObject.suggested_home;
        if (str4 != null && str4.startsWith("http")) {
            AppFavorUtils.SERVICE_EXTERNAL_URL = suggestedUrlsObject.suggested_home;
        }
        if (FlavorHelper.isShad()) {
            String str5 = suggestedUrlsObject.suggested_rubino2;
            if (str5 != null && str5.startsWith("http") && !MyLog.isDebugAble) {
                AppFavorUtils.rubinoUrl = suggestedUrlsObject.suggested_rubino2;
            }
        } else {
            String str6 = suggestedUrlsObject.suggested_rubino;
            if (str6 != null && str6.startsWith("http") && !MyLog.isDebugAble) {
                AppFavorUtils.rubinoUrl = suggestedUrlsObject.suggested_rubino;
            }
        }
        String str7 = suggestedUrlsObject.suggested_prediction;
        if (str7 != null && str7.startsWith("http")) {
            AppFavorUtils.jjUrl = suggestedUrlsObject.suggested_prediction + "/api/v1.0/";
        }
        String str8 = suggestedUrlsObject.suggested_news;
        if (str8 != null && str8.startsWith("http")) {
            AppFavorUtils.newsUrlOld = suggestedUrlsObject.suggested_news + "/api/v1.0/";
        }
        String str9 = suggestedUrlsObject.suggested_asn;
        if (str9 != null && str9.startsWith("http")) {
            AppFavorUtils.appstoreUrl = suggestedUrlsObject.suggested_asn;
        }
        String str10 = suggestedUrlsObject.suggested_webapp;
        if (str10 != null && str10.startsWith("http")) {
            AppFavorUtils.webAppUrl = suggestedUrlsObject.suggested_webapp;
        }
        String str11 = suggestedUrlsObject.suggested_paymentcenter;
        if (str11 != null && str11.startsWith("http")) {
            AppFavorUtils.paymentUrl = suggestedUrlsObject.suggested_paymentcenter;
        }
        String str12 = suggestedUrlsObject.suggested_barcode;
        if (str12 != null && str12.startsWith("http")) {
            AppFavorUtils.barcodeUrl = suggestedUrlsObject.suggested_barcode;
        }
        String str13 = suggestedUrlsObject.suggested_nquality;
        if (str13 != null && str13.startsWith("http")) {
            AppFavorUtils.suggested_nquality = suggestedUrlsObject.suggested_nquality;
        }
        String str14 = suggestedUrlsObject.suggested_comment;
        if (str14 != null && str14.startsWith("http")) {
            AppFavorUtils.commentUrl = suggestedUrlsObject.suggested_comment;
        }
        String str15 = suggestedUrlsObject.suggested_services;
        if (str15 != null && str15.startsWith("http")) {
            AppFavorUtils.iptvUrl = suggestedUrlsObject.suggested_services;
        }
        String str16 = suggestedUrlsObject.suggested_basket;
        if (str16 != null && str16.startsWith("http")) {
            AppFavorUtils.basketUrl = suggestedUrlsObject.suggested_basket;
        }
        String str17 = suggestedUrlsObject.suggested_qgame;
        if (str17 != null && str17.startsWith("http")) {
            AppFavorUtils.gameUrl = suggestedUrlsObject.suggested_qgame;
        }
        String str18 = suggestedUrlsObject.suggested_usage;
        if (str18 == null || !str18.startsWith("http")) {
            return;
        }
        AppFavorUtils.usageUrl = suggestedUrlsObject.suggested_usage;
    }

    public MainTabFragment createMainTabFragment() {
        String string = getAppPreferences().getString(AppPreferences.Key.baseInfoObject);
        GetBaseInfoOutput.DefaultTabEnum defaultTabEnum = GetBaseInfoOutput.DefaultTabEnum.Messenger;
        if (FlavorHelper.isRubino()) {
            defaultTabEnum = GetBaseInfoOutput.DefaultTabEnum.Rubino;
        }
        if (!string.isEmpty()) {
            try {
                GetBaseInfoOutput.DefaultTabEnum defaultTabEnum2 = ((GetBaseInfoOutput) ApplicationLoader.getGson().fromJson(string, GetBaseInfoOutput.class)).default_tab;
                if (defaultTabEnum2 != null) {
                    defaultTabEnum = defaultTabEnum2;
                }
            } catch (Exception unused) {
            }
        }
        return createMainTabFragment(defaultTabEnum);
    }

    public void setBaseUrlFromCache() {
        String string;
        SuggestedUrlsObject suggestedUrlsObject;
        if (this.isBaseUrlSetFromApi || (string = getAppPreferences().getString(AppPreferences.Key.baseInfoObject)) == null || string.isEmpty() || (suggestedUrlsObject = ((GetBaseInfoOutput) ApplicationLoader.getGson().fromJson(string, GetBaseInfoOutput.class)).suggested_urls) == null) {
            return;
        }
        setBaseUrls(suggestedUrlsObject);
    }

    public MainTabFragment createMainTabFragment(GetBaseInfoOutput.DefaultTabEnum defaultTabEnum) {
        return new MainTabFragment(defaultTabEnum);
    }

    public BaseFragment getLastFragment() {
        ActionBarLayout actionBarLayout = this.actionBarLayout;
        if (actionBarLayout != null) {
            return actionBarLayout.getLastFragment();
        }
        return null;
    }

    private void openSettings(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("user_id", UserConfig.getInstance(this.currentAccount).clientUserId);
        if (z) {
            bundle.putBoolean("expandPhoto", true);
        }
        lambda$runLinkRequest$40(new ProfileActivity(bundle));
        this.drawerLayoutContainer.closeDrawer(false);
    }

    private void checkSystemBarColors() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            Theme.getColor(Theme.key_actionBarDefault, null, true);
            AndroidUtilities.setLightStatusBar(getWindow(), !Theme.isCurrentThemeNight());
            if (i >= 26) {
                Window window = getWindow();
                int color = Theme.getColor(Theme.key_windowBackgroundGray, null, true);
                if (window.getNavigationBarColor() != color) {
                    window.setNavigationBarColor(color);
                    AndroidUtilities.setLightNavigationBar(getWindow(), AndroidUtilities.computePerceivedBrightness(color) >= 0.721f);
                }
            }
        }
        if (!SharedConfig.noStatusBar || i < 21) {
            return;
        }
        getWindow().setStatusBarColor(0);
    }

    public void switchToAccount(int i, boolean z) {
        if (i == UserConfig.selectedAccount || !UserConfig.isValidAccount(i)) {
            return;
        }
        AsemanNotificationService asemanNotificationService = AsemanNotificationService.instance;
        if (asemanNotificationService != null) {
            asemanNotificationService.destroyService();
        }
        ConnectionsManager.getInstance(this.currentAccount).setAppPaused(true, false);
        UserConfig.selectedAccount = i;
        UserConfig.getInstance(0).saveConfig(false);
        ServiceLocator.getInstance(i).initOnActivateCore();
        ServiceLocator.getInstance(i).loadMyUserInfo();
        ServiceLocator.getInstance(i).onAuthSuccess();
        checkCurrentAccount();
        rubinoInit();
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
        if (z) {
            this.actionBarLayout.removeAllFragments();
        } else {
            this.actionBarLayout.removeFragmentFromStack(0);
        }
        this.actionBarLayout.addFragmentToStack(createMainTabFragment(), 0);
        this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
        this.actionBarLayout.showLastFragment();
        if (AndroidUtilities.isTablet()) {
            this.layersActionBarLayout.showLastFragment();
            this.rightActionBarLayout.showLastFragment();
        }
        if (!ApplicationLoader.mainInterfacePaused) {
            ConnectionsManager.getInstance(this.currentAccount).setAppPaused(false, false);
        }
        if (UserConfig.getInstance(i).unacceptedTermsOfService != null) {
            showTosActivity(i, UserConfig.getInstance(i).unacceptedTermsOfService);
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
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.needShowAlert);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.wasUnableToFindCurrentLocation);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.openArticle);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.hasNewContactsToImport);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.needShowPlayServicesAlert);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileDidLoad);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileDidFailToLoad);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.historyImportProgressChanged);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.groupCallUpdated);
        }
        int i2 = UserConfig.selectedAccount;
        this.currentAccount = i2;
        NotificationCenter.getInstance(i2).addObserver(this, NotificationCenter.appDidLogout);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.mainUserInfoChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didUpdateConnectionState);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.needShowAlert);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.wasUnableToFindCurrentLocation);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.openArticle);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.hasNewContactsToImport);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.needShowPlayServicesAlert);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileDidFailToLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.historyImportProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.groupCallUpdated);
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
                if (this.passcodeView.getVisibility() != 0) {
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
            if (this.passcodeView.getVisibility() != 0) {
                this.actionBarLayout.showLastFragment();
            }
        }
        this.shadowTabletSide.setVisibility(8);
        this.rightActionBarLayout.setVisibility(8);
        this.backgroundTablet.setVisibility(this.actionBarLayout.fragmentsStack.isEmpty() ? 0 : 8);
    }

    private void showUpdateActivity(int i, TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate, boolean z) {
        if (this.blockingUpdateView == null) {
            BlockingUpdateView blockingUpdateView = new BlockingUpdateView(this) { // from class: org.rbmain.ui.LaunchActivity.10
                @Override // org.rbmain.ui.Components.BlockingUpdateView, android.view.View
                public void setVisibility(int i2) {
                    super.setVisibility(i2);
                    if (i2 == 8) {
                        LaunchActivity.this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
                    }
                }
            };
            this.blockingUpdateView = blockingUpdateView;
            this.frameLayoutContainer.addView(blockingUpdateView, LayoutHelper.createFrame(-1, -1.0f));
        }
        this.blockingUpdateView.show(i, tLRPC$TL_help_appUpdate, z);
        this.drawerLayoutContainer.setAllowOpenDrawer(false, false);
    }

    private void showTosActivity(int i, TLRPC$TL_help_termsOfService tLRPC$TL_help_termsOfService) {
        if (this.termsOfServiceView == null) {
            TermsOfServiceView termsOfServiceView = new TermsOfServiceView(this);
            this.termsOfServiceView = termsOfServiceView;
            termsOfServiceView.setAlpha(0.0f);
            this.frameLayoutContainer.addView(this.termsOfServiceView, LayoutHelper.createFrame(-1, -1.0f));
            this.termsOfServiceView.setDelegate(new AnonymousClass11());
        }
        TLRPC$TL_help_termsOfService tLRPC$TL_help_termsOfService2 = UserConfig.getInstance(i).unacceptedTermsOfService;
        if (tLRPC$TL_help_termsOfService2 != tLRPC$TL_help_termsOfService && (tLRPC$TL_help_termsOfService2 == null || !tLRPC$TL_help_termsOfService2.id.data.equals(tLRPC$TL_help_termsOfService.id.data))) {
            UserConfig.getInstance(i).unacceptedTermsOfService = tLRPC$TL_help_termsOfService;
            UserConfig.getInstance(i).saveConfig(false);
        }
        this.termsOfServiceView.show(i, tLRPC$TL_help_termsOfService);
        this.drawerLayoutContainer.setAllowOpenDrawer(false, false);
        this.termsOfServiceView.animate().alpha(1.0f).setDuration(150L).setInterpolator(AndroidUtilities.decelerateInterpolator).setListener(null).start();
    }

    /* renamed from: org.rbmain.ui.LaunchActivity$11, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass11 implements TermsOfServiceView.TermsOfServiceViewDelegate {
        AnonymousClass11() {
        }

        @Override // org.rbmain.ui.Components.TermsOfServiceView.TermsOfServiceViewDelegate
        public void onAcceptTerms(int i) {
            UserConfig.getInstance(i).unacceptedTermsOfService = null;
            UserConfig.getInstance(i).saveConfig(false);
            LaunchActivity.this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
            if (LaunchActivity.mainFragmentsStack.size() > 0) {
                ((BaseFragment) LaunchActivity.mainFragmentsStack.get(LaunchActivity.mainFragmentsStack.size() - 1)).onResume();
            }
            LaunchActivity.this.termsOfServiceView.animate().alpha(0.0f).setDuration(150L).setInterpolator(AndroidUtilities.accelerateInterpolator).withEndAction(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$11$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAcceptTerms$0();
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAcceptTerms$0() {
            LaunchActivity.this.termsOfServiceView.setVisibility(8);
        }
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
        this.passcodeView.onShow();
        SharedConfig.isWaitingForPasscodeEnter = true;
        this.drawerLayoutContainer.setAllowOpenDrawer(false, false);
        this.passcodeView.setDelegate(new PasscodeView.PasscodeViewDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda64
            @Override // org.rbmain.ui.Components.PasscodeView.PasscodeViewDelegate
            public final void didAcceptedPassword() throws Throwable {
                this.f$0.lambda$showPasscodeActivity$5();
            }
        });
        this.actionBarLayout.setVisibility(4);
        if (AndroidUtilities.isTablet()) {
            if (this.layersActionBarLayout.getVisibility() == 0) {
                this.layersActionBarLayout.setVisibility(4);
            }
            this.rightActionBarLayout.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPasscodeActivity$5() throws Throwable {
        SharedConfig.isWaitingForPasscodeEnter = false;
        Intent intent = this.passcodeSaveIntent;
        if (intent != null) {
            handleIntent(intent, this.passcodeSaveIntentIsNew, this.passcodeSaveIntentIsRestore, true);
            this.passcodeSaveIntent = null;
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:363:0x0706, code lost:
    
        r6[0] = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x070c, code lost:
    
        switchToAccount(r6[0], true);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x06a3  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x06c6  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0763  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x07b9  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x09a4  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0a49  */
    /* JADX WARN: Removed duplicated region for block: B:576:0x0b9e  */
    /* JADX WARN: Removed duplicated region for block: B:577:0x0bb0  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0bbe  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0bcf  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x0c65  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0c8a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:607:0x0c92  */
    /* JADX WARN: Removed duplicated region for block: B:615:0x0cd9  */
    /* JADX WARN: Removed duplicated region for block: B:623:0x0d1c  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x0d28  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x0d30  */
    /* JADX WARN: Removed duplicated region for block: B:634:0x0d55 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:635:0x0d56  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c1  */
    /* JADX WARN: Type inference failed for: r9v55 */
    /* JADX WARN: Type inference failed for: r9v64 */
    /* JADX WARN: Type inference failed for: r9v65 */
    /* JADX WARN: Type inference failed for: r9v9, types: [android.os.Bundle, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean handleIntent(android.content.Intent r48, boolean r49, boolean r50, boolean r51) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 3418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.handleIntent(android.content.Intent, boolean, boolean, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleIntent$8(final int[] iArr, LocationController.SharingLocationInfo sharingLocationInfo) {
        iArr[0] = sharingLocationInfo.messageObject.currentAccount;
        switchToAccount(iArr[0], true);
        LocationActivity locationActivity = new LocationActivity(2);
        locationActivity.setMessageObject(sharingLocationInfo.messageObject);
        final long dialogId = sharingLocationInfo.messageObject.getDialogId();
        locationActivity.setDelegate(new LocationActivity.LocationActivityDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda72
            @Override // org.rbmain.ui.LocationActivity.LocationActivityDelegate
            public final void didSelectLocation(TLRPC$MessageMedia tLRPC$MessageMedia, int i, boolean z, int i2) {
                LaunchActivity.lambda$handleIntent$7(iArr, dialogId, tLRPC$MessageMedia, i, z, i2);
            }
        });
        lambda$runLinkRequest$40(locationActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleIntent$7(int[] iArr, long j, TLRPC$MessageMedia tLRPC$MessageMedia, int i, boolean z, int i2) {
        SendMessagesHelper.getInstance(iArr[0]).sendMessage(tLRPC$MessageMedia, j, (MessageObject) null, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, z, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleIntent$9(BaseFragment baseFragment, boolean z) {
        presentFragment(baseFragment, z, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void openDialogsToSend(boolean r11) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.openDialogsToSend(boolean):void");
    }

    private int runCommentRequest(final int i, final AlertDialog alertDialog, final Integer num, final Integer num2, final Integer num3, final TLRPC$Chat tLRPC$Chat) {
        if (tLRPC$Chat == null) {
            return 0;
        }
        final TLRPC$TL_messages_getDiscussionMessage tLRPC$TL_messages_getDiscussionMessage = new TLRPC$TL_messages_getDiscussionMessage();
        tLRPC$TL_messages_getDiscussionMessage.peer = MessagesController.getInputPeer(tLRPC$Chat);
        tLRPC$TL_messages_getDiscussionMessage.msg_id = (num2 != null ? num : num3).intValue();
        return ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_messages_getDiscussionMessage, new RequestDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda48
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$runCommentRequest$17(i, num, tLRPC$Chat, tLRPC$TL_messages_getDiscussionMessage, num2, num3, alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runCommentRequest$17(final int i, final Integer num, final TLRPC$Chat tLRPC$Chat, final TLRPC$TL_messages_getDiscussionMessage tLRPC$TL_messages_getDiscussionMessage, final Integer num2, final Integer num3, final AlertDialog alertDialog, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runCommentRequest$16(tLObject, i, num, tLRPC$Chat, tLRPC$TL_messages_getDiscussionMessage, num2, num3, alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$runCommentRequest$16(org.rbmain.tgnet.TLObject r14, int r15, java.lang.Integer r16, org.rbmain.tgnet.TLRPC$Chat r17, org.rbmain.tgnet.TLRPC$TL_messages_getDiscussionMessage r18, java.lang.Integer r19, java.lang.Integer r20, org.rbmain.ui.ActionBar.AlertDialog r21) {
        /*
            r13 = this;
            r0 = r14
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_messages_discussionMessage
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L95
            org.rbmain.tgnet.TLRPC$TL_messages_discussionMessage r0 = (org.rbmain.tgnet.TLRPC$TL_messages_discussionMessage) r0
            org.rbmain.messenger.MessagesController r1 = org.rbmain.messenger.MessagesController.getInstance(r15)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$User> r4 = r0.users
            r1.putUsers(r4, r2)
            org.rbmain.messenger.MessagesController r1 = org.rbmain.messenger.MessagesController.getInstance(r15)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Chat> r4 = r0.chats
            r1.putChats(r4, r2)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r1 = r0.messages
            int r1 = r1.size()
            r4 = 0
        L27:
            if (r4 >= r1) goto L3e
            org.rbmain.messenger.MessageObject r5 = new org.rbmain.messenger.MessageObject
            int r7 = org.rbmain.messenger.UserConfig.selectedAccount
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Message> r8 = r0.messages
            java.lang.Object r8 = r8.get(r4)
            org.rbmain.tgnet.TLRPC$Message r8 = (org.rbmain.tgnet.TLRPC$Message) r8
            r5.<init>(r7, r8, r3, r3)
            r6.add(r5)
            int r4 = r4 + 1
            goto L27
        L3e:
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L95
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.Object r2 = r6.get(r2)
            org.rbmain.messenger.MessageObject r2 = (org.rbmain.messenger.MessageObject) r2
            long r4 = r2.getDialogId()
            long r4 = -r4
            int r2 = (int) r4
            java.lang.String r4 = "chat_id"
            r1.putInt(r4, r2)
            int r2 = r16.intValue()
            int r2 = java.lang.Math.max(r3, r2)
            long r4 = (long) r2
            java.lang.String r2 = "message_id"
            r1.putLong(r2, r4)
            org.rbmain.ui.ChatActivity r2 = new org.rbmain.ui.ChatActivity
            r2.<init>(r1)
            r1 = r18
            long r8 = r1.msg_id
            int r10 = r0.read_inbox_max_id
            int r11 = r0.read_outbox_max_id
            r12 = 0
            r5 = r2
            r7 = r17
            r5.setThreadMessages(r6, r7, r8, r10, r11, r12)
            if (r19 == 0) goto L86
            int r0 = r19.intValue()
            r2.setHighlightMessageId(r0)
            goto L8f
        L86:
            if (r20 == 0) goto L8f
            int r0 = r16.intValue()
            r2.setHighlightMessageId(r0)
        L8f:
            r1 = r13
            r13.lambda$runLinkRequest$40(r2)
            r2 = 1
            goto L96
        L95:
            r1 = r13
        L96:
            if (r2 != 0) goto Lc6
            java.util.ArrayList<org.rbmain.ui.ActionBar.BaseFragment> r0 = org.rbmain.ui.LaunchActivity.mainFragmentsStack     // Catch: java.lang.Exception -> Lc2
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> Lc2
            if (r0 != 0) goto Lc6
            java.util.ArrayList<org.rbmain.ui.ActionBar.BaseFragment> r0 = org.rbmain.ui.LaunchActivity.mainFragmentsStack     // Catch: java.lang.Exception -> Lc2
            int r2 = r0.size()     // Catch: java.lang.Exception -> Lc2
            int r2 = r2 - r3
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Exception -> Lc2
            org.rbmain.ui.ActionBar.BaseFragment r0 = (org.rbmain.ui.ActionBar.BaseFragment) r0     // Catch: java.lang.Exception -> Lc2
            org.rbmain.ui.Components.BulletinFactory r0 = org.rbmain.ui.Components.BulletinFactory.of(r0)     // Catch: java.lang.Exception -> Lc2
            java.lang.String r2 = "ChannelPostDeleted"
            r3 = 2131887314(0x7f1204d2, float:1.9409232E38)
            java.lang.String r2 = org.rbmain.messenger.LocaleController.getString(r2, r3)     // Catch: java.lang.Exception -> Lc2
            org.rbmain.ui.Components.Bulletin r0 = r0.createErrorBulletin(r2)     // Catch: java.lang.Exception -> Lc2
            r0.show()     // Catch: java.lang.Exception -> Lc2
            goto Lc6
        Lc2:
            r0 = move-exception
            org.rbmain.messenger.FileLog.e(r0)
        Lc6:
            r21.dismiss()     // Catch: java.lang.Exception -> Lca
            goto Lcf
        Lca:
            r0 = move-exception
            r2 = r0
            org.rbmain.messenger.FileLog.e(r2)
        Lcf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.lambda$runCommentRequest$16(org.rbmain.tgnet.TLObject, int, java.lang.Integer, org.rbmain.tgnet.TLRPC$Chat, org.rbmain.tgnet.TLRPC$TL_messages_getDiscussionMessage, java.lang.Integer, java.lang.Integer, org.rbmain.ui.ActionBar.AlertDialog):void");
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
            iArr[0] = ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_messages_checkHistoryImport, new RequestDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda51
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$runImportRequest$19(uri, i, alertDialog, tLObject, tLRPC$TL_error);
                }
            });
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    LaunchActivity.lambda$runImportRequest$20(i, iArr, r3, dialogInterface);
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
    public /* synthetic */ void lambda$runImportRequest$19(final Uri uri, final int i, final AlertDialog alertDialog, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runImportRequest$18(tLObject, uri, i, alertDialog);
            }
        }, 2L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$runImportRequest$18(org.rbmain.tgnet.TLObject r10, android.net.Uri r11, int r12, org.rbmain.ui.ActionBar.AlertDialog r13) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.lambda$runImportRequest$18(org.rbmain.tgnet.TLObject, android.net.Uri, int, org.rbmain.ui.ActionBar.AlertDialog):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runImportRequest$20(int i, int[] iArr, Runnable runnable, DialogInterface dialogInterface) {
        ConnectionsManager.getInstance(i).cancelRequest(iArr[0], true);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void runLinkRequest(final int r26, final java.lang.String r27, final java.lang.String r28, final java.lang.String r29, final java.lang.String r30, final java.lang.String r31, final java.lang.String r32, final boolean r33, final java.lang.Integer r34, final java.lang.Integer r35, final java.lang.Integer r36, final java.lang.Integer r37, final java.lang.String r38, final java.util.HashMap<java.lang.String, java.lang.String> r39, final java.lang.String r40, final java.lang.String r41, final java.lang.String r42, final java.lang.String r43, final org.rbmain.tgnet.TLRPC$TL_wallPaper r44, final java.lang.String r45, final java.lang.String r46, int r47, final boolean r48) {
        /*
            Method dump skipped, instructions count: 984
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.runLinkRequest(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.util.HashMap, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.rbmain.tgnet.TLRPC$TL_wallPaper, java.lang.String, java.lang.String, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$21(int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z, Integer num, Integer num2, Integer num3, Integer num4, String str7, HashMap map, String str8, String str9, String str10, String str11, TLRPC$TL_wallPaper tLRPC$TL_wallPaper, String str12, String str13, boolean z2, int i2) {
        if (i2 != i) {
            switchToAccount(i2, true);
        }
        runLinkRequest(i2, str, str2, str3, str4, str5, str6, z, num, num2, num3, num4, str7, map, str8, str9, str10, str11, tLRPC$TL_wallPaper, str12, str13, 1, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$25(final String str, final String str2, final int i, final Integer num, final Integer num2, final Integer num3, final int[] iArr, final AlertDialog alertDialog, final String str3, final String str4, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$24(tLObject, tLRPC$TL_error, str, str2, i, num, num2, num3, iArr, alertDialog, str3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$runLinkRequest$24(org.rbmain.tgnet.TLObject r15, org.rbmain.tgnet.TLRPC$TL_error r16, final java.lang.String r17, java.lang.String r18, final int r19, java.lang.Integer r20, java.lang.Integer r21, java.lang.Integer r22, int[] r23, final org.rbmain.ui.ActionBar.AlertDialog r24, final java.lang.String r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 821
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.lambda$runLinkRequest$24(org.rbmain.tgnet.TLObject, org.rbmain.tgnet.TLRPC$TL_error, java.lang.String, java.lang.String, int, java.lang.Integer, java.lang.Integer, java.lang.Integer, int[], org.rbmain.ui.ActionBar.AlertDialog, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$22(String str, int i, TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        TLRPC$TL_inputMediaGame tLRPC$TL_inputMediaGame = new TLRPC$TL_inputMediaGame();
        TLRPC$TL_inputGameShortName tLRPC$TL_inputGameShortName = new TLRPC$TL_inputGameShortName();
        tLRPC$TL_inputMediaGame.id = tLRPC$TL_inputGameShortName;
        tLRPC$TL_inputGameShortName.short_name = str;
        tLRPC$TL_inputGameShortName.bot_id = MessagesController.getInstance(i).getInputUser(tLRPC$TL_contacts_resolvedPeer.users.get(0));
        int i2 = (int) jLongValue;
        SendMessagesHelper.getInstance(i).sendGame(MessagesController.getInstance(i).getInputPeer(i2), tLRPC$TL_inputMediaGame, 0L, 0L);
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        int i3 = (int) (jLongValue >> 32);
        if (i2 == 0) {
            bundle.putInt("enc_id", i3);
        } else if (i2 > 0) {
            bundle.putInt("user_id", i2);
        } else if (i2 < 0) {
            bundle.putInt("chat_id", -i2);
        }
        if (MessagesController.getInstance(i).checkCanOpenChat(bundle, dialogsActivity)) {
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.closeChats, new Object[0]);
            this.actionBarLayout.presentFragment(new ChatActivity(bundle), true, false, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$23(int i, TLRPC$User tLRPC$User, String str, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        int i2 = -((int) jLongValue);
        bundle.putInt("chat_id", i2);
        if (!mainFragmentsStack.isEmpty()) {
            MessagesController messagesController = MessagesController.getInstance(i);
            ArrayList<BaseFragment> arrayList2 = mainFragmentsStack;
            if (!messagesController.checkCanOpenChat(bundle, arrayList2.get(arrayList2.size() - 1))) {
                return;
            }
        }
        NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.closeChats, new Object[0]);
        MessagesController.getInstance(i).addUserToChat(i2, tLRPC$User, 0, str, null, null);
        this.actionBarLayout.presentFragment(new ChatActivity(bundle), true, false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$28(final int i, final AlertDialog alertDialog, final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$27(tLRPC$TL_error, tLObject, i, alertDialog, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$runLinkRequest$27(org.rbmain.tgnet.TLRPC$TL_error r10, org.rbmain.tgnet.TLObject r11, int r12, final org.rbmain.ui.ActionBar.AlertDialog r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.lambda$runLinkRequest$27(org.rbmain.tgnet.TLRPC$TL_error, org.rbmain.tgnet.TLObject, int, org.rbmain.ui.ActionBar.AlertDialog, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runLinkRequest$26(boolean[] zArr, DialogInterface dialogInterface) {
        zArr[0] = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$30(final int i, final AlertDialog alertDialog, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            MessagesController.getInstance(i).processUpdates((TLRPC$Updates) tLObject, false);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$29(alertDialog, tLRPC$TL_error, tLObject, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$29(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, int i) {
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
                bundle.putInt("chat_id", tLRPC$Chat.id);
                if (!mainFragmentsStack.isEmpty()) {
                    if (!MessagesController.getInstance(i).checkCanOpenChat(bundle, mainFragmentsStack.get(r0.size() - 1))) {
                        return;
                    }
                }
                ChatActivity chatActivity = new ChatActivity(bundle);
                NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.closeChats, new Object[0]);
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
        } else {
            builder.setMessage(LocaleController.getString("JoinToGroupErrorNotExist", R.string.JoinToGroupErrorNotExist));
        }
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        showAlertDialog(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$31(boolean z, int i, String str, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z2) {
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        bundle.putBoolean("hasUrl", z);
        int i2 = (int) jLongValue;
        int i3 = (int) (jLongValue >> 32);
        if (i2 == 0) {
            bundle.putInt("enc_id", i3);
        } else if (i2 > 0) {
            bundle.putInt("user_id", i2);
        } else if (i2 < 0) {
            bundle.putInt("chat_id", -i2);
        }
        if (MessagesController.getInstance(i).checkCanOpenChat(bundle, dialogsActivity)) {
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.closeChats, new Object[0]);
            MediaDataController.getInstance(i).saveDraft(jLongValue, 0L, str, null, null, false);
            this.actionBarLayout.presentFragment(new ChatActivity(bundle), true, false, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$35(int[] iArr, final int i, final AlertDialog alertDialog, final TLRPC$TL_account_getAuthorizationForm tLRPC$TL_account_getAuthorizationForm, final String str, final String str2, final String str3, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        final TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm = (TLRPC$TL_account_authorizationForm) tLObject;
        if (tLRPC$TL_account_authorizationForm != null) {
            iArr[0] = ConnectionsManager.getInstance(i).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda55
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$runLinkRequest$33(alertDialog, i, tLRPC$TL_account_authorizationForm, tLRPC$TL_account_getAuthorizationForm, str, str2, str3, tLObject2, tLRPC$TL_error2);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda39
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$runLinkRequest$34(alertDialog, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$33(final AlertDialog alertDialog, final int i, final TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm, final TLRPC$TL_account_getAuthorizationForm tLRPC$TL_account_getAuthorizationForm, final String str, final String str2, final String str3, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$32(alertDialog, tLObject, i, tLRPC$TL_account_authorizationForm, tLRPC$TL_account_getAuthorizationForm, str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$32(AlertDialog alertDialog, TLObject tLObject, int i, TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm, TLRPC$TL_account_getAuthorizationForm tLRPC$TL_account_getAuthorizationForm, String str, String str2, String str3) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (tLObject != null) {
            MessagesController.getInstance(i).putUsers(tLRPC$TL_account_authorizationForm.users, false);
            lambda$runLinkRequest$40(new PassportActivity(5, tLRPC$TL_account_getAuthorizationForm.bot_id, tLRPC$TL_account_getAuthorizationForm.scope, tLRPC$TL_account_getAuthorizationForm.public_key, str, str2, str3, tLRPC$TL_account_authorizationForm, (TLRPC$TL_account_password) tLObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$34(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error) {
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
    public /* synthetic */ void lambda$runLinkRequest$37(final AlertDialog alertDialog, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$36(alertDialog, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$36(AlertDialog alertDialog, TLObject tLObject) {
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
    public /* synthetic */ void lambda$runLinkRequest$39(final AlertDialog alertDialog, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$38(alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$38(AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
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
    public /* synthetic */ void lambda$runLinkRequest$41() {
        this.loadingThemeFileName = null;
        this.loadingThemeWallpaperName = null;
        this.loadingThemeWallpaper = null;
        this.loadingThemeInfo = null;
        this.loadingThemeProgressDialog = null;
        this.loadingTheme = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$43(final int[] iArr, final int i, final AlertDialog alertDialog, final Integer num, final Integer num2, final Integer num3, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$42(tLObject, iArr, i, alertDialog, num, num2, num3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$runLinkRequest$42(org.rbmain.tgnet.TLObject r11, int[] r12, int r13, org.rbmain.ui.ActionBar.AlertDialog r14, java.lang.Integer r15, java.lang.Integer r16, java.lang.Integer r17) {
        /*
            r10 = this;
            r8 = r10
            r0 = r11
            boolean r1 = r0 instanceof org.rbmain.tgnet.TLRPC$TL_messages_chats
            r9 = 0
            if (r1 == 0) goto L34
            org.rbmain.tgnet.TLRPC$TL_messages_chats r0 = (org.rbmain.tgnet.TLRPC$TL_messages_chats) r0
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Chat> r1 = r0.chats
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L34
            int r1 = r8.currentAccount
            org.rbmain.messenger.MessagesController r1 = org.rbmain.messenger.MessagesController.getInstance(r1)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Chat> r2 = r0.chats
            r1.putChats(r2, r9)
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$Chat> r0 = r0.chats
            java.lang.Object r0 = r0.get(r9)
            r7 = r0
            org.rbmain.tgnet.TLRPC$Chat r7 = (org.rbmain.tgnet.TLRPC$Chat) r7
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
            org.rbmain.messenger.FileLog.e(r1)
        L40:
            r0 = 2131889337(0x7f120cb9, float:1.9413335E38)
            java.lang.String r1 = "LinkNotFound"
            java.lang.String r0 = org.rbmain.messenger.LocaleController.getString(r1, r0)
            org.rbmain.ui.ActionBar.AlertDialog$Builder r0 = org.rbmain.ui.Components.AlertsCreator.createSimpleAlert(r10, r0)
            r10.showAlertDialog(r0)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.lambda$runLinkRequest$42(org.rbmain.tgnet.TLObject, int[], int, org.rbmain.ui.ActionBar.AlertDialog, java.lang.Integer, java.lang.Integer, java.lang.Integer):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$46(final Bundle bundle, Integer num, int[] iArr, final AlertDialog alertDialog, final BaseFragment baseFragment, final int i) {
        if (this.actionBarLayout.presentFragment(new ChatActivity(bundle))) {
            return;
        }
        TLRPC$TL_channels_getChannels tLRPC$TL_channels_getChannels = new TLRPC$TL_channels_getChannels();
        TLRPC$TL_inputChannel tLRPC$TL_inputChannel = new TLRPC$TL_inputChannel();
        tLRPC$TL_inputChannel.channel_id = num.intValue();
        tLRPC$TL_channels_getChannels.id.add(tLRPC$TL_inputChannel);
        iArr[0] = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_getChannels, new RequestDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda56
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$runLinkRequest$45(alertDialog, baseFragment, i, bundle, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$45(final AlertDialog alertDialog, final BaseFragment baseFragment, final int i, final Bundle bundle, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runLinkRequest$44(alertDialog, tLObject, baseFragment, i, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runLinkRequest$44(AlertDialog alertDialog, TLObject tLObject, BaseFragment baseFragment, int i, Bundle bundle) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$runLinkRequest$47(int i, int[] iArr, Runnable runnable, DialogInterface dialogInterface) {
        ConnectionsManager.getInstance(i).cancelRequest(iArr[0], true);
        if (runnable != null) {
            runnable.run();
        }
    }

    public void checkAppUpdate(boolean z) {
        if (z || !BuildVars.DEBUG_VERSION) {
            if (z || BuildVars.CHECK_UPDATES) {
                if (z || Math.abs(System.currentTimeMillis() - UserConfig.getInstance(0).lastUpdateCheckTime) >= MessagesController.getInstance(0).updateCheckDelay * 1000) {
                    TLRPC$TL_help_getAppUpdate tLRPC$TL_help_getAppUpdate = new TLRPC$TL_help_getAppUpdate();
                    try {
                        tLRPC$TL_help_getAppUpdate.source = ApplicationLoader.applicationContext.getPackageManager().getInstallerPackageName(ApplicationLoader.applicationContext.getPackageName());
                    } catch (Exception unused) {
                    }
                    if (tLRPC$TL_help_getAppUpdate.source == null) {
                        tLRPC$TL_help_getAppUpdate.source = BuildConfig.FLAVOR;
                    }
                    final int i = this.currentAccount;
                    ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_help_getAppUpdate, new RequestDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda47
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$checkAppUpdate$49(i, tLObject, tLRPC$TL_error);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAppUpdate$49(final int i, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        UserConfig.getInstance(0).lastUpdateCheckTime = System.currentTimeMillis();
        UserConfig.getInstance(0).saveConfig(false);
        if (tLObject instanceof TLRPC$TL_help_appUpdate) {
            final TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate = (TLRPC$TL_help_appUpdate) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda34
                @Override // java.lang.Runnable
                public final void run() throws PackageManager.NameNotFoundException {
                    this.f$0.lambda$checkAppUpdate$48(tLRPC$TL_help_appUpdate, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAppUpdate$48(TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate, int i) throws PackageManager.NameNotFoundException {
        if (tLRPC$TL_help_appUpdate.can_not_skip) {
            UserConfig.getInstance(0).pendingAppUpdate = tLRPC$TL_help_appUpdate;
            UserConfig.getInstance(0).pendingAppUpdateBuildVersion = BuildVars.BUILD_VERSION;
            try {
                PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
                UserConfig.getInstance(0).pendingAppUpdateInstallTime = Math.max(packageInfo.lastUpdateTime, packageInfo.firstInstallTime);
            } catch (Exception e) {
                FileLog.e(e);
                UserConfig.getInstance(0).pendingAppUpdateInstallTime = 0L;
            }
            UserConfig.getInstance(0).saveConfig(false);
            showUpdateActivity(i, tLRPC$TL_help_appUpdate, false);
            return;
        }
        new UpdateAppAlertDialog(this, tLRPC$TL_help_appUpdate, i).show();
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
            this.visibleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda11
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$showAlertDialog$50(dialogInterface);
                }
            });
            return this.visibleDialog;
        } catch (Exception e2) {
            FileLog.e(e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertDialog$50(DialogInterface dialogInterface) {
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
                editorEdit.apply();
                ConnectionsManager.setProxySettings(false, BuildConfig.FLAVOR, 1080, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.proxySettingsChanged, new Object[0]);
                this.proxyErrorDialog = null;
            }
        }
        this.visibleDialog = null;
    }

    public void showBulletin(Function<BulletinFactory, Bulletin> function) {
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
            function.apply(BulletinFactory.of(baseFragment)).show();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) throws Throwable {
        super.onNewIntent(intent);
        if (this.isLastForceUpdate) {
            getUpdateRequest2();
        }
        handleIntent(intent, true, false, false);
    }

    @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
    public void didSelectDialogs(final DialogsActivity dialogsActivity, final ArrayList<Long> arrayList, CharSequence charSequence, final boolean z) {
        final ChatActivity chatActivity;
        int i;
        final int currentAccount = dialogsActivity != null ? dialogsActivity.getCurrentAccount() : this.currentAccount;
        final Uri uri = this.exportingChatUri;
        if (uri != null) {
            final ArrayList arrayList2 = this.documentsUrisArray != null ? new ArrayList(this.documentsUrisArray) : null;
            final AlertDialog alertDialog = new AlertDialog(this, 3);
            SendMessagesHelper.getInstance(currentAccount).prepareImportHistory(arrayList.get(0).longValue(), this.exportingChatUri, this.documentsUrisArray, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda45
                @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                public final void run(int i2) {
                    this.f$0.lambda$didSelectDialogs$51(currentAccount, dialogsActivity, z, arrayList2, uri, alertDialog, i2);
                }
            });
            try {
                alertDialog.showDelayed(300L);
            } catch (Exception unused) {
            }
        } else {
            if (arrayList.size() <= 1) {
                long jLongValue = arrayList.get(0).longValue();
                int i2 = (int) jLongValue;
                int i3 = (int) (jLongValue >> 32);
                Bundle bundle = new Bundle();
                bundle.putBoolean("scrollToTopOnResume", true);
                if (!AndroidUtilities.isTablet()) {
                    NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
                }
                if (i2 == 0) {
                    bundle.putInt("enc_id", i3);
                } else if (i2 > 0) {
                    bundle.putInt("user_id", i2);
                } else if (i2 < 0) {
                    bundle.putInt("chat_id", -i2);
                }
                if (!MessagesController.getInstance(currentAccount).checkCanOpenChat(bundle, dialogsActivity)) {
                    return;
                } else {
                    chatActivity = new ChatActivity(bundle);
                }
            } else {
                chatActivity = null;
            }
            ArrayList<TLRPC$User> arrayList3 = this.contactsToSend;
            int size = arrayList3 != null ? arrayList3.size() + 0 : 0;
            if (this.videoPath != null) {
                size++;
            }
            ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList4 = this.photoPathsArray;
            if (arrayList4 != null) {
                size += arrayList4.size();
            }
            ArrayList<String> arrayList5 = this.documentsPathsArray;
            if (arrayList5 != null) {
                size += arrayList5.size();
            }
            ArrayList<Uri> arrayList6 = this.documentsUrisArray;
            if (arrayList6 != null) {
                size += arrayList6.size();
            }
            if (this.videoPath == null && this.photoPathsArray == null && this.documentsPathsArray == null && this.documentsUrisArray == null && this.sendingText != null) {
                size++;
            }
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (AlertsCreator.checkSlowMode(this, this.currentAccount, arrayList.get(i4).longValue(), size > 1)) {
                    return;
                }
            }
            ArrayList<TLRPC$User> arrayList7 = this.contactsToSend;
            if (arrayList7 != null && arrayList7.size() == 1 && !mainFragmentsStack.isEmpty()) {
                ArrayList<BaseFragment> arrayList8 = mainFragmentsStack;
                PhonebookShareAlert phonebookShareAlert = new PhonebookShareAlert(arrayList8.get(arrayList8.size() - 1), null, null, this.contactsToSendUri, null, null, null);
                phonebookShareAlert.setDelegate(new ChatAttachAlertContactsLayout.PhonebookShareAlertDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda63
                    @Override // org.rbmain.ui.Components.ChatAttachAlertContactsLayout.PhonebookShareAlertDelegate
                    public final void didSelectContact(TLRPC$User tLRPC$User, boolean z2, int i5) {
                        this.f$0.lambda$didSelectDialogs$52(chatActivity, arrayList, currentAccount, tLRPC$User, z2, i5);
                    }
                });
                ArrayList<BaseFragment> arrayList9 = mainFragmentsStack;
                arrayList9.get(arrayList9.size() - 1).showDialog(phonebookShareAlert);
            } else {
                String str = null;
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    long jLongValue2 = arrayList.get(i5).longValue();
                    AccountInstance accountInstance = AccountInstance.getInstance(UserConfig.selectedAccount);
                    if (chatActivity != null) {
                        i = 1024;
                        this.actionBarLayout.presentFragment(chatActivity, dialogsActivity != null, dialogsActivity == null, true, false);
                        String str2 = this.videoPath;
                        if (str2 != null) {
                            chatActivity.openVideoEditor(str2, this.sendingText);
                            this.sendingText = null;
                        }
                    } else {
                        i = 1024;
                        if (this.videoPath != null) {
                            String str3 = this.sendingText;
                            if (str3 != null && str3.length() <= 1024) {
                                str = this.sendingText;
                                this.sendingText = null;
                            }
                            ArrayList arrayList10 = new ArrayList();
                            arrayList10.add(this.videoPath);
                            SendMessagesHelper.prepareSendingDocuments(accountInstance, arrayList10, arrayList10, null, str, null, jLongValue2, null, null, null, null, true, 0);
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
                            ArrayList<String> arrayList11 = this.documentsPathsArray;
                            int size2 = arrayList11 != null ? arrayList11.size() : 0;
                            ArrayList<Uri> arrayList12 = this.documentsUrisArray;
                            if (size2 + (arrayList12 != null ? arrayList12.size() : 0) == 1) {
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
                    ArrayList<TLRPC$User> arrayList13 = this.contactsToSend;
                    if (arrayList13 != null && !arrayList13.isEmpty()) {
                        for (int i6 = 0; i6 < this.contactsToSend.size(); i6++) {
                            SendMessagesHelper.getInstance(currentAccount).sendMessage(this.contactsToSend.get(i6), jLongValue2, (MessageObject) null, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                        }
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        SendMessagesHelper.prepareSendingText(accountInstance, charSequence.toString(), jLongValue2, true, 0);
                    }
                }
            }
            if (dialogsActivity != null && chatActivity == null) {
                dialogsActivity.finishFragment();
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
    public /* synthetic */ void lambda$didSelectDialogs$51(int i, DialogsActivity dialogsActivity, boolean z, ArrayList arrayList, Uri uri, AlertDialog alertDialog, int i2) {
        if (i2 != 0) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("scrollToTopOnResume", true);
            if (!AndroidUtilities.isTablet()) {
                NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.closeChats, new Object[0]);
            }
            if (i2 > 0) {
                bundle.putInt("user_id", i2);
            } else {
                bundle.putInt("chat_id", -i2);
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
    public /* synthetic */ void lambda$didSelectDialogs$52(ChatActivity chatActivity, ArrayList arrayList, int i, TLRPC$User tLRPC$User, boolean z, int i2) {
        if (chatActivity != null) {
            this.actionBarLayout.presentFragment(chatActivity, true, false, true, false);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            SendMessagesHelper.getInstance(i).sendMessage(tLRPC$User, ((Long) arrayList.get(i3)).longValue(), (MessageObject) null, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, z, i2);
        }
    }

    private void onFinish() {
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
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileDidLoad);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileDidFailToLoad);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.historyImportProgressChanged);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.groupCallUpdated);
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
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.requestPermissions);
        LiteMode.removeOnPowerSaverAppliedListener(new LaunchActivity$$ExternalSyntheticLambda46(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPowerSaver(boolean z) {
        if (Build.VERSION.SDK_INT < 21 || this.actionBarLayout == null || !z) {
            return;
        }
        LiteMode.getPowerSaverLevel();
    }

    /* renamed from: presentFragment, reason: merged with bridge method [inline-methods] */
    public void lambda$runLinkRequest$40(BaseFragment baseFragment) {
        this.actionBarLayout.presentFragment(baseFragment);
    }

    public boolean presentFragment(BaseFragment baseFragment, boolean z, boolean z2) {
        return this.actionBarLayout.presentFragment(baseFragment, z, z2, true, false);
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        VoIPService sharedInstance;
        if (SharedConfig.passcodeHash.length() != 0 && SharedConfig.lastPauseTime != 0) {
            SharedConfig.lastPauseTime = 0;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("reset lastPauseTime onActivityResult");
            }
            UserConfig.getInstance(this.currentAccount).saveConfig(false);
        }
        if (i == 105) {
            if (Build.VERSION.SDK_INT >= 23) {
                boolean zCanDrawOverlays = Settings.canDrawOverlays(this);
                ApplicationLoader.canDrawOverlays = zCanDrawOverlays;
                if (zCanDrawOverlays) {
                    GroupCallActivity groupCallActivity = GroupCallActivity.groupCallInstance;
                    if (groupCallActivity != null) {
                        groupCallActivity.dismissInternal();
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda19
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onActivityResult$53();
                        }
                    }, 200L);
                    return;
                }
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 520) {
            if (i2 != -1 || (sharedInstance = VoIPService.getSharedInstance()) == null) {
                return;
            }
            VideoCapturerDevice.mediaProjectionPermissionResultData = intent;
            sharedInstance.createCaptureDevice(true);
            return;
        }
        if (i == 140) {
            LocationController.getInstance(this.currentAccount).startFusedLocationRequest(i2 == -1);
            return;
        }
        ThemeEditorView themeEditorView = ThemeEditorView.getInstance();
        if (themeEditorView != null) {
            themeEditorView.onActivityResult(i, i2, intent);
        }
        if (this.actionBarLayout.fragmentsStack.size() != 0) {
            ArrayList<BaseFragment> arrayList = this.actionBarLayout.fragmentsStack;
            arrayList.get(arrayList.size() - 1).onActivityResultFragment(i, i2, intent);
        }
        if (AndroidUtilities.isTablet()) {
            if (this.rightActionBarLayout.fragmentsStack.size() != 0) {
                ArrayList<BaseFragment> arrayList2 = this.rightActionBarLayout.fragmentsStack;
                arrayList2.get(arrayList2.size() - 1).onActivityResultFragment(i, i2, intent);
            }
            if (this.layersActionBarLayout.fragmentsStack.size() != 0) {
                ArrayList<BaseFragment> arrayList3 = this.layersActionBarLayout.fragmentsStack;
                arrayList3.get(arrayList3.size() - 1).onActivityResultFragment(i, i2, intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityResult$53() {
        GroupCallPip.clearForce();
        GroupCallPip.updateVisibility(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr == null) {
            iArr = new int[0];
        }
        if (strArr == null) {
            strArr = new String[0];
        }
        boolean z = iArr.length > 0 && iArr[0] == 0;
        if (i == 4) {
            if (!z) {
                showPermissionErrorAlert(LocaleController.getString("PermissionStorage", R.string.PermissionStorage));
            } else {
                ImageLoader.getInstance().checkMediaPaths();
            }
        } else if (i == 5) {
            if (!z) {
                showPermissionErrorAlert(LocaleController.getString("PermissionContacts", R.string.PermissionContacts));
                return;
            }
            ContactsController.getInstance(this.currentAccount).forceImportContacts();
        } else if (i == 3) {
            int iMin = Math.min(strArr.length, iArr.length);
            boolean z2 = true;
            boolean z3 = true;
            for (int i2 = 0; i2 < iMin; i2++) {
                if ("android.permission.RECORD_AUDIO".equals(strArr[i2])) {
                    z2 = iArr[i2] == 0;
                } else if ("android.permission.CAMERA".equals(strArr[i2])) {
                    z3 = iArr[i2] == 0;
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
        } else if (i == 18 || i == 19 || i == 20 || i == 22) {
            if (!z) {
                showPermissionErrorAlert(LocaleController.getString("PermissionNoCamera", R.string.PermissionNoCamera));
            }
        } else if (i == 2 && z) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.locationPermissionGranted, new Object[0]);
        }
        if (this.actionBarLayout.fragmentsStack.size() != 0) {
            ArrayList<BaseFragment> arrayList = this.actionBarLayout.fragmentsStack;
            arrayList.get(arrayList.size() - 1).onRequestPermissionsResultFragment(i, strArr, iArr);
        }
        if (AndroidUtilities.isTablet()) {
            if (this.rightActionBarLayout.fragmentsStack.size() != 0) {
                ArrayList<BaseFragment> arrayList2 = this.rightActionBarLayout.fragmentsStack;
                arrayList2.get(arrayList2.size() - 1).onRequestPermissionsResultFragment(i, strArr, iArr);
            }
            if (this.layersActionBarLayout.fragmentsStack.size() != 0) {
                ArrayList<BaseFragment> arrayList3 = this.layersActionBarLayout.fragmentsStack;
                arrayList3.get(arrayList3.size() - 1).onRequestPermissionsResultFragment(i, strArr, iArr);
            }
        }
        VoIPFragment.onRequestPermissionsResult(i, strArr, iArr);
        if (this.requestedPermissions.get(i, -1) >= 0) {
            int i3 = this.requestedPermissions.get(i, -1);
            this.requestedPermissions.delete(i);
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.permissionsGranted, Integer.valueOf(i3));
        }
    }

    private void showPermissionErrorAlert(String str) {
        if (ApplicationLoader.applicationActivity == null || ApplicationLoader.applicationActivity.isFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(ApplicationLoader.applicationActivity);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(str);
        builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPermissionErrorAlert$54(dialogInterface, i);
            }
        });
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionErrorAlert$54(DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void startActivityRecordAudio() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23 && checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 3);
            return;
        }
        try {
            Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
            File fileGenerateAudioPath = AndroidUtilities.generateAudioPath();
            if (fileGenerateAudioPath != null) {
                if (i >= 24) {
                    intent.putExtra("output", FileProvider.getUriForFile(this, "ir.medu.shad.provider", fileGenerateAudioPath));
                    intent.addFlags(2);
                    intent.addFlags(1);
                } else if (i >= 18) {
                    intent.putExtra("output", Uri.fromFile(fileGenerateAudioPath));
                }
                intent.putExtra("android.intent.extra.sizeLimit", 1610612736L);
                fileGenerateAudioPath.getAbsolutePath();
            }
            startActivityForResult(intent, FilePickerManager.ActivityRequestCode.recordAudio.value);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void startActivitySelectFile(boolean z) {
        if (z) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && checkSelfPermission("android.permission.CAMERA") != 0) {
                requestPermissions(new String[]{"android.permission.CAMERA"}, 20);
                return;
            }
            try {
                Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
                File fileGenerateVideoPath = AndroidUtilities.generateVideoPath();
                if (fileGenerateVideoPath != null) {
                    if (i >= 24) {
                        intent.putExtra("output", FileProvider.getUriForFile(this, "ir.medu.shad.provider", fileGenerateVideoPath));
                        intent.addFlags(2);
                        intent.addFlags(1);
                    } else if (i >= 18) {
                        intent.putExtra("output", Uri.fromFile(fileGenerateVideoPath));
                    }
                    intent.putExtra("android.intent.extra.sizeLimit", 1610612736L);
                    fileGenerateVideoPath.getAbsolutePath();
                }
                startActivityForResult(intent, FilePickerManager.ActivityRequestCode.cameraVideo.value);
                return;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 && checkSelfPermission("android.permission.CAMERA") != 0) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 20);
            return;
        }
        try {
            Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
            File fileGeneratePicturePath = AndroidUtilities.generatePicturePath();
            if (fileGeneratePicturePath != null) {
                if (i2 >= 24) {
                    intent2.putExtra("output", FileProvider.getUriForFile(this, "ir.medu.shad.provider", fileGeneratePicturePath));
                    intent2.addFlags(2);
                    intent2.addFlags(1);
                } else {
                    intent2.putExtra("output", Uri.fromFile(fileGeneratePicturePath));
                }
                fileGeneratePicturePath.getAbsolutePath();
            }
            startActivityForResult(intent2, FilePickerManager.ActivityRequestCode.cameraImage.value);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        super.onPause();
        for (int i = 0; i < 3; i++) {
            AccountInstance.getInstance(i).getDialogsProxy().stopUpdateRunnable();
        }
        this.isInBackGround = true;
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, 4096);
        ApplicationLoader.mainInterfacePaused = true;
        final int i2 = this.currentAccount;
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                LaunchActivity.lambda$onPause$55(i2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPause$55(int i) {
        ApplicationLoader.mainInterfacePausedStageQueue = true;
        ApplicationLoader.mainInterfacePausedStageQueueTime = 0L;
        if (VoIPService.getSharedInstance() == null) {
            MessagesController.getInstance(i).ignoreSetOnline = false;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        Browser.bindCustomTabsService(this);
        ApplicationLoader.mainInterfaceStopped = false;
        GroupCallPip.updateVisibility(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Browser.unbindCustomTabsService(this);
        ApplicationLoader.mainInterfaceStopped = true;
        GroupCallPip.updateVisibility(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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
        this.mainCompositeDisposable.dispose();
        super.onDestroy();
        if (ServiceLocator.checkTag(this)) {
            ServiceLocator.onFinish();
        }
        onFinish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() throws IOException {
        MessageObject playingMessageObject;
        super.onResume();
        this.isInBackGround = false;
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().startUpdateRunnable();
        CompositeDisposable compositeDisposable = this.mainCompositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.mainCompositeDisposable = new CompositeDisposable();
        }
        ServiceLocator.getInstance(this.currentAccount).checkDisposable();
        if (Theme.selectedAutoNightType == 3) {
            Theme.checkAutoNightThemeConditions();
        }
        this.isInBackGround = false;
        checkWasMutedByAdmin(true);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, 4096);
        MediaController.getInstance().setFeedbackView(this.actionBarLayout, true);
        ApplicationLoader.mainInterfacePaused = false;
        showLanguageAlert(false);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                LaunchActivity.lambda$onResume$56();
            }
        });
        checkFreeDiscSpace();
        MediaController.checkGallery();
        onPasscodeResume();
        if (this.passcodeView.getVisibility() != 0) {
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
        } else if (UserConfig.getInstance(0).pendingAppUpdate != null) {
            showUpdateActivity(UserConfig.selectedAccount, UserConfig.getInstance(0).pendingAppUpdate, true);
        }
        checkAppUpdate(false);
        if (Build.VERSION.SDK_INT >= 23) {
            ApplicationLoader.canDrawOverlays = Settings.canDrawOverlays(this);
        }
        if (VoIPFragment.getInstance() != null) {
            VoIPFragment.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onResume$56() {
        ApplicationLoader.mainInterfacePausedStageQueue = false;
        ApplicationLoader.mainInterfacePausedStageQueueTime = System.currentTimeMillis();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IOException {
        AndroidUtilities.checkDisplaySize(this, configuration);
        super.onConfigurationChanged(configuration);
        checkLayout();
        PipRoundVideoView pipRoundVideoView = PipRoundVideoView.getInstance();
        if (pipRoundVideoView != null) {
            pipRoundVideoView.onConfigurationChanged();
        }
        EmbedBottomSheet embedBottomSheet = EmbedBottomSheet.getInstance();
        if (embedBottomSheet != null) {
            embedBottomSheet.onConfigurationChanged(configuration);
        }
        PhotoViewer pipInstance = PhotoViewer.getPipInstance();
        if (pipInstance != null) {
            pipInstance.onConfigurationChanged(configuration);
        }
        ThemeEditorView themeEditorView = ThemeEditorView.getInstance();
        if (themeEditorView != null) {
            themeEditorView.onConfigurationChanged();
        }
        if (Theme.selectedAutoNightType == 3) {
            Theme.checkAutoNightThemeConditions();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        AndroidUtilities.isInMultiwindow = z;
        checkLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x025f  */
    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r17, final int r18, java.lang.Object... r19) {
        /*
            Method dump skipped, instructions count: 1944
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$didReceivedNotification$57(int i, DialogInterface dialogInterface, int i2) {
        if (mainFragmentsStack.isEmpty()) {
            return;
        }
        MessagesController messagesController = MessagesController.getInstance(i);
        ArrayList<BaseFragment> arrayList = mainFragmentsStack;
        messagesController.openByUserName("spambot", arrayList.get(arrayList.size() - 1), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$58(DialogInterface dialogInterface, int i) {
        MessagesController.getInstance(this.currentAccount).performLogout(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$60(final HashMap map, final int i, DialogInterface dialogInterface, int i2) {
        if (mainFragmentsStack.isEmpty()) {
            return;
        }
        if (AndroidUtilities.isGoogleMapsInstalled(mainFragmentsStack.get(r3.size() - 1))) {
            LocationActivity locationActivity = new LocationActivity(0);
            locationActivity.setDelegate(new LocationActivity.LocationActivityDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda71
                @Override // org.rbmain.ui.LocationActivity.LocationActivityDelegate
                public final void didSelectLocation(TLRPC$MessageMedia tLRPC$MessageMedia, int i3, boolean z, int i4) {
                    LaunchActivity.lambda$didReceivedNotification$59(map, i, tLRPC$MessageMedia, i3, z, i4);
                }
            });
            lambda$runLinkRequest$40(locationActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$didReceivedNotification$59(HashMap map, int i, TLRPC$MessageMedia tLRPC$MessageMedia, int i2, boolean z, int i3) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            MessageObject messageObject = (MessageObject) ((Map.Entry) it.next()).getValue();
            SendMessagesHelper.getInstance(i).sendMessage(tLRPC$MessageMedia, messageObject.getDialogId(), messageObject, (MessageObject) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, z, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$didReceivedNotification$61(int i, HashMap map, boolean z, boolean z2, DialogInterface dialogInterface, int i2) {
        ContactsController.getInstance(i).syncPhoneBookByAlert(map, z, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$didReceivedNotification$62(int i, HashMap map, boolean z, boolean z2, DialogInterface dialogInterface, int i2) {
        ContactsController.getInstance(i).syncPhoneBookByAlert(map, z, z2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$didReceivedNotification$63(int i, HashMap map, boolean z, boolean z2, DialogInterface dialogInterface, int i2) {
        ContactsController.getInstance(i).syncPhoneBookByAlert(map, z, z2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$65(final Theme.ThemeInfo themeInfo, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$64(tLObject, themeInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$64(TLObject tLObject, Theme.ThemeInfo themeInfo) {
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
    public /* synthetic */ void lambda$didReceivedNotification$67(Theme.ThemeInfo themeInfo, File file) {
        themeInfo.createBackground(file, themeInfo.pathToWallpaper);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didReceivedNotification$66();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$66() {
        if (this.loadingTheme == null) {
            return;
        }
        File file = new File(ApplicationLoader.getFilesDirFixed(), "remote" + this.loadingTheme.id + ".attheme");
        TLRPC$TL_theme tLRPC$TL_theme = this.loadingTheme;
        Theme.ThemeInfo themeInfoApplyThemeFile = Theme.applyThemeFile(file, tLRPC$TL_theme.title, tLRPC$TL_theme, true);
        if (themeInfoApplyThemeFile != null) {
            lambda$runLinkRequest$40(new ThemePreviewActivity(themeInfoApplyThemeFile, true, 0, false, false));
        }
        onThemeLoadFinish();
    }

    private void invalidateCachedViews(View view) {
        if (view.getLayerType() != 0) {
            view.invalidate();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                invalidateCachedViews(viewGroup.getChildAt(i));
            }
        }
    }

    private void checkWasMutedByAdmin(boolean z) {
        ChatObject.Call call;
        int i;
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        boolean z2 = false;
        if (sharedInstance != null && (call = sharedInstance.groupCall) != null) {
            boolean z3 = this.wasMutedByAdminRaisedHand;
            TLRPC$InputPeer groupCallPeer = sharedInstance.getGroupCallPeer();
            if (groupCallPeer != null) {
                i = groupCallPeer.user_id;
                if (i == 0) {
                    int i2 = groupCallPeer.chat_id;
                    i = i2 != 0 ? -i2 : -groupCallPeer.channel_id;
                }
            } else {
                i = UserConfig.getInstance(this.currentAccount).clientUserId;
            }
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = call.participants.get(i);
            boolean z4 = (tLRPC$TL_groupCallParticipant == null || tLRPC$TL_groupCallParticipant.can_self_unmute || !tLRPC$TL_groupCallParticipant.muted) ? false : true;
            if (z4 && tLRPC$TL_groupCallParticipant.raise_hand_rating != 0) {
                z2 = true;
            }
            this.wasMutedByAdminRaisedHand = z2;
            if (z || !z3 || z2 || z4 || GroupCallActivity.groupCallInstance != null) {
                return;
            }
            showVoiceChatTooltip(38);
            return;
        }
        this.wasMutedByAdminRaisedHand = false;
    }

    private void showVoiceChatTooltip(int i) {
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
            chatActivity.getUndoView().showWithAction(0L, i, chat);
        } else if (baseFragment instanceof DialogsActivity) {
            ((DialogsActivity) baseFragment).getUndoView().showWithAction(0L, i, chat);
        } else if (baseFragment instanceof ProfileActivity) {
            ((ProfileActivity) baseFragment).getUndoView().showWithAction(0L, i, chat);
        }
        if (i != 38 || VoIPService.getSharedInstance() == null) {
            return;
        }
        VoIPService.getSharedInstance().playAllowTalkSound();
    }

    private String getStringForLanguageAlert(HashMap<String, String> map, String str, int i) {
        String str2 = map.get(str);
        return str2 == null ? LocaleController.getString(str, i) : str2;
    }

    private void openThemeAccentPreview(TLRPC$TL_theme tLRPC$TL_theme, TLRPC$TL_wallPaper tLRPC$TL_wallPaper, Theme.ThemeInfo themeInfo) {
        int i = themeInfo.lastAccentId;
        Theme.ThemeAccent themeAccentCreateNewAccent = themeInfo.createNewAccent(tLRPC$TL_theme, this.currentAccount);
        themeInfo.prevAccentId = themeInfo.currentAccentId;
        themeInfo.setCurrentAccentId(themeAccentCreateNewAccent.id);
        themeAccentCreateNewAccent.pattern = tLRPC$TL_wallPaper;
        lambda$runLinkRequest$40(new ThemePreviewActivity(themeInfo, i != themeInfo.lastAccentId, 0, false, false));
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

    private void checkFreeDiscSpace() {
        SharedConfig.checkKeepMedia();
        if (Build.VERSION.SDK_INT >= 26) {
            return;
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkFreeDiscSpace$69();
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkFreeDiscSpace$69() {
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
                    globalMainSettings.edit().putLong("last_space_check", System.currentTimeMillis()).apply();
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda21
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$checkFreeDiscSpace$68();
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkFreeDiscSpace$68() {
        try {
            AlertsCreator.createFreeSpaceDialog(this).show();
        } catch (Throwable unused) {
        }
    }

    private void showLanguageAlertInternal(LocaleController.LocaleInfo localeInfo, LocaleController.LocaleInfo localeInfo2, String str) {
        try {
            this.loadingLocaleDialog = false;
            LocaleController.LocaleInfo localeInfo3 = localeInfo;
            boolean z = localeInfo3.builtIn || LocaleController.getInstance().isCurrentLocalLocale();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getStringForLanguageAlert(this.systemLocaleStrings, "ChooseYourLanguage", R.string.ChooseYourLanguage));
            builder.setSubtitle(getStringForLanguageAlert(this.englishLocaleStrings, "ChooseYourLanguage", R.string.ChooseYourLanguage));
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            final LanguageCell[] languageCellArr = new LanguageCell[2];
            final LocaleController.LocaleInfo[] localeInfoArr = new LocaleController.LocaleInfo[1];
            LocaleController.LocaleInfo[] localeInfoArr2 = new LocaleController.LocaleInfo[2];
            String stringForLanguageAlert = getStringForLanguageAlert(this.systemLocaleStrings, "English", R.string.English);
            localeInfoArr2[0] = z ? localeInfo3 : localeInfo2;
            localeInfoArr2[1] = z ? localeInfo2 : localeInfo3;
            if (!z) {
                localeInfo3 = localeInfo2;
            }
            localeInfoArr[0] = localeInfo3;
            int i = 0;
            while (i < 2) {
                languageCellArr[i] = new LanguageCell(this, true);
                languageCellArr[i].setLanguage(localeInfoArr2[i], localeInfoArr2[i] == localeInfo2 ? stringForLanguageAlert : null, true);
                languageCellArr[i].setTag(Integer.valueOf(i));
                languageCellArr[i].setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_dialogButtonSelector), 2));
                languageCellArr[i].setLanguageSelected(i == 0);
                linearLayout.addView(languageCellArr[i], LayoutHelper.createLinear(-1, 50));
                languageCellArr[i].setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda13
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LaunchActivity.lambda$showLanguageAlertInternal$70(localeInfoArr, languageCellArr, view);
                    }
                });
                i++;
            }
            LanguageCell languageCell = new LanguageCell(this, true);
            languageCell.setValue(getStringForLanguageAlert(this.systemLocaleStrings, "ChooseYourLanguageOther", R.string.ChooseYourLanguageOther), getStringForLanguageAlert(this.englishLocaleStrings, "ChooseYourLanguageOther", R.string.ChooseYourLanguageOther));
            languageCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$showLanguageAlertInternal$71(view);
                }
            });
            linearLayout.addView(languageCell, LayoutHelper.createLinear(-1, 50));
            builder.setView(linearLayout);
            builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$showLanguageAlertInternal$72(localeInfoArr, dialogInterface, i2);
                }
            });
            this.localeDialog = showAlertDialog(builder);
            MessagesController.getGlobalMainSettings().edit().putString("language_showed2", str).apply();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showLanguageAlertInternal$70(LocaleController.LocaleInfo[] localeInfoArr, LanguageCell[] languageCellArr, View view) {
        Integer num = (Integer) view.getTag();
        localeInfoArr[0] = ((LanguageCell) view).getCurrentLocale();
        int i = 0;
        while (i < languageCellArr.length) {
            languageCellArr[i].setLanguageSelected(i == num.intValue());
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLanguageAlertInternal$71(View view) {
        this.localeDialog = null;
        this.drawerLayoutContainer.closeDrawer(true);
        lambda$runLinkRequest$40(new LanguageSelectActivity());
        AlertDialog alertDialog = this.visibleDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.visibleDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLanguageAlertInternal$72(LocaleController.LocaleInfo[] localeInfoArr, DialogInterface dialogInterface, int i) {
        LocaleController.getInstance().applyLanguage(localeInfoArr[0], true, false, this.currentAccount);
        rebuildAllFragments(true);
    }

    private void showLanguageAlert(boolean z) {
        String str;
        try {
            if (!this.loadingLocaleDialog && !ApplicationLoader.mainInterfacePaused) {
                String string = MessagesController.getGlobalMainSettings().getString("language_showed2", BuildConfig.FLAVOR);
                final String str2 = MessagesController.getInstance(this.currentAccount).suggestedLangCode;
                if (!z && string.equals(str2)) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("alert already showed for " + string);
                        return;
                    }
                    return;
                }
                final LocaleController.LocaleInfo[] localeInfoArr = new LocaleController.LocaleInfo[2];
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
                    ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_langpack_getStrings, new RequestDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda61
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$showLanguageAlert$74(localeInfoArr, str2, tLObject, tLRPC$TL_error);
                        }
                    }, 8);
                    TLRPC$TL_langpack_getStrings tLRPC$TL_langpack_getStrings2 = new TLRPC$TL_langpack_getStrings();
                    tLRPC$TL_langpack_getStrings2.lang_code = localeInfoArr[0].getLangCode();
                    tLRPC$TL_langpack_getStrings2.keys.add("English");
                    tLRPC$TL_langpack_getStrings2.keys.add("ChooseYourLanguage");
                    tLRPC$TL_langpack_getStrings2.keys.add("ChooseYourLanguageOther");
                    tLRPC$TL_langpack_getStrings2.keys.add("ChangeLanguageLater");
                    ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_langpack_getStrings2, new RequestDelegate() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda60
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$showLanguageAlert$76(localeInfoArr, str2, tLObject, tLRPC$TL_error);
                        }
                    }, 8);
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLanguageAlert$74(final LocaleController.LocaleInfo[] localeInfoArr, final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final HashMap map = new HashMap();
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            for (int i = 0; i < tLRPC$Vector.objects.size(); i++) {
                TLRPC$LangPackString tLRPC$LangPackString = (TLRPC$LangPackString) tLRPC$Vector.objects.get(i);
                map.put(tLRPC$LangPackString.key, tLRPC$LangPackString.value);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showLanguageAlert$73(map, localeInfoArr, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLanguageAlert$73(HashMap map, LocaleController.LocaleInfo[] localeInfoArr, String str) {
        this.systemLocaleStrings = map;
        if (this.englishLocaleStrings == null || map == null) {
            return;
        }
        showLanguageAlertInternal(localeInfoArr[1], localeInfoArr[0], str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLanguageAlert$76(final LocaleController.LocaleInfo[] localeInfoArr, final String str, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final HashMap map = new HashMap();
        if (tLObject != null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            for (int i = 0; i < tLRPC$Vector.objects.size(); i++) {
                TLRPC$LangPackString tLRPC$LangPackString = (TLRPC$LangPackString) tLRPC$Vector.objects.get(i);
                map.put(tLRPC$LangPackString.key, tLRPC$LangPackString.value);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showLanguageAlert$75(map, localeInfoArr, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showLanguageAlert$75(HashMap map, LocaleController.LocaleInfo[] localeInfoArr, String str) {
        this.englishLocaleStrings = map;
        if (map == null || this.systemLocaleStrings == null) {
            return;
        }
        showLanguageAlertInternal(localeInfoArr[1], localeInfoArr[0], str);
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
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.LaunchActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    if (LaunchActivity.this.lockRunnable == this) {
                        if (AndroidUtilities.needShowPasscode(true)) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("lock app");
                            }
                            LaunchActivity.this.showPasscodeActivity();
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

    private void onPasscodeResume() {
        if (this.lockRunnable != null) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("cancel lockRunnable onPasscodeResume");
            }
            AndroidUtilities.cancelRunOnUIThread(this.lockRunnable);
            this.lockRunnable = null;
        }
        if (AndroidUtilities.needShowPasscode(true)) {
            showPasscodeActivity();
        }
        if (SharedConfig.lastPauseTime != 0) {
            SharedConfig.lastPauseTime = 0;
            SharedConfig.saveConfig();
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("reset lastPauseTime onPasscodeResume");
            }
        }
    }

    private void updateCurrentConnectionState(int i) {
        String str;
        if (this.actionBarLayout == null) {
            return;
        }
        int i2 = 0;
        int connectionState = ConnectionsManager.getInstance(this.currentAccount).getConnectionState();
        this.currentConnectionState = connectionState;
        if (connectionState == 2) {
            i2 = R.string.WaitingForNetwork;
            str = "WaitingForNetwork";
        } else if (connectionState == 5) {
            i2 = R.string.Updating;
            str = "Updating";
        } else if (connectionState == 4) {
            i2 = R.string.ConnectingToProxy;
            str = "ConnectingToProxy";
        } else if (connectionState == 1) {
            i2 = R.string.Connecting;
            str = "Connecting";
        } else {
            str = null;
        }
        this.actionBarLayout.setTitleOverlayText(str, i2, (connectionState == 1 || connectionState == 4) ? new Runnable() { // from class: org.rbmain.ui.LaunchActivity$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateCurrentConnectionState$77();
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$updateCurrentConnectionState$77() {
        /*
            r2 = this;
            boolean r0 = org.rbmain.messenger.AndroidUtilities.isTablet()
            if (r0 == 0) goto L1d
            java.util.ArrayList<org.rbmain.ui.ActionBar.BaseFragment> r0 = org.rbmain.ui.LaunchActivity.layerFragmentsStack
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L34
            java.util.ArrayList<org.rbmain.ui.ActionBar.BaseFragment> r0 = org.rbmain.ui.LaunchActivity.layerFragmentsStack
            int r1 = r0.size()
            int r1 = r1 + (-1)
            java.lang.Object r0 = r0.get(r1)
            org.rbmain.ui.ActionBar.BaseFragment r0 = (org.rbmain.ui.ActionBar.BaseFragment) r0
            goto L35
        L1d:
            java.util.ArrayList<org.rbmain.ui.ActionBar.BaseFragment> r0 = org.rbmain.ui.LaunchActivity.mainFragmentsStack
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L34
            java.util.ArrayList<org.rbmain.ui.ActionBar.BaseFragment> r0 = org.rbmain.ui.LaunchActivity.mainFragmentsStack
            int r1 = r0.size()
            int r1 = r1 + (-1)
            java.lang.Object r0 = r0.get(r1)
            org.rbmain.ui.ActionBar.BaseFragment r0 = (org.rbmain.ui.ActionBar.BaseFragment) r0
            goto L35
        L34:
            r0 = 0
        L35:
            boolean r1 = r0 instanceof org.rbmain.ui.ProxyListActivity
            if (r1 != 0) goto L46
            boolean r0 = r0 instanceof org.rbmain.ui.ProxySettingsActivity
            if (r0 == 0) goto L3e
            goto L46
        L3e:
            org.rbmain.ui.ProxyListActivity r0 = new org.rbmain.ui.ProxyListActivity
            r0.<init>()
            r2.lambda$runLinkRequest$40(r0)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LaunchActivity.lambda$updateCurrentConnectionState$77():void");
    }

    public void hideVisibleActionMode() {
        ActionMode actionMode = this.visibleActionMode;
        if (actionMode == null) {
            return;
        }
        actionMode.finish();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
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
                    bundle.putBundle("args", arguments);
                    bundle.putString("fragment", "chat");
                } else if ((baseFragment instanceof GroupCreateFinalActivity) && arguments != null) {
                    bundle.putBundle("args", arguments);
                    bundle.putString("fragment", "group");
                } else if (baseFragment instanceof WallpapersListActivity) {
                    bundle.putString("fragment", "wallpapers");
                } else if (baseFragment instanceof ProfileActivity) {
                    ProfileActivity profileActivity = (ProfileActivity) baseFragment;
                    if (profileActivity.isSettings()) {
                        bundle.putString("fragment", "settings");
                    } else if (profileActivity.isChat() && arguments != null) {
                        bundle.putBundle("args", arguments);
                        bundle.putString("fragment", "chat_profile");
                    }
                } else if ((baseFragment instanceof ChannelCreateActivity) && arguments != null && arguments.getInt("step") == 0) {
                    bundle.putBundle("args", arguments);
                    bundle.putString("fragment", "channel");
                }
                baseFragment.saveSelfArgs(bundle);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.passcodeView.getVisibility() == 0) {
            finish();
            return;
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
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
    public void onActionModeStarted(ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
        this.visibleActionMode = actionMode;
        try {
            Menu menu = actionMode.getMenu();
            if (menu != null && !this.actionBarLayout.extendActionMode(menu) && AndroidUtilities.isTablet() && !this.rightActionBarLayout.extendActionMode(menu)) {
                this.layersActionBarLayout.extendActionMode(menu);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (Build.VERSION.SDK_INT < 23 || actionMode.getType() != 1) {
            this.actionBarLayout.onActionModeStarted(actionMode);
            if (AndroidUtilities.isTablet()) {
                this.rightActionBarLayout.onActionModeStarted(actionMode);
                this.layersActionBarLayout.onActionModeStarted(actionMode);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        super.onActionModeFinished(actionMode);
        if (this.visibleActionMode == actionMode) {
            this.visibleActionMode = null;
        }
        if (Build.VERSION.SDK_INT < 23 || actionMode.getType() != 1) {
            this.actionBarLayout.onActionModeFinished(actionMode);
            if (AndroidUtilities.isTablet()) {
                this.rightActionBarLayout.onActionModeFinished(actionMode);
                this.layersActionBarLayout.onActionModeFinished(actionMode);
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0 && (keyEvent.getKeyCode() == 24 || keyEvent.getKeyCode() == 25)) {
            boolean z = false;
            if (VoIPService.getSharedInstance() != null) {
                if (Build.VERSION.SDK_INT >= 31 && !SharedConfig.useMediaStream) {
                    boolean zIsSpeakerMuted = WebRtcAudioTrack.isSpeakerMuted();
                    AudioManager audioManager = (AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                    if (audioManager.getStreamVolume(0) == audioManager.getStreamMinVolume(0) && keyEvent.getKeyCode() == 25) {
                        z = true;
                    }
                    WebRtcAudioTrack.setSpeakerMute(z);
                    if (zIsSpeakerMuted != WebRtcAudioTrack.isSpeakerMuted()) {
                        showVoiceChatTooltip(z ? 42 : 43);
                    }
                }
            } else if (!mainFragmentsStack.isEmpty() && ((!PhotoViewer.hasInstance() || !PhotoViewer.getInstance().isVisible()) && keyEvent.getRepeatCount() == 0)) {
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
                int streamVolume = ((AudioManager) getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).getStreamVolume(3);
                boolean z2 = RubinoPostListActivity.isSoundOn;
                boolean z3 = (streamVolume == 0 && keyCode == 25) ? false : true;
                if (z2 != z3) {
                    NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.playerAdjustVolume, Boolean.valueOf(z3));
                }
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.igtvPlayerAdjustVolume, Boolean.valueOf(z3));
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82 && !SharedConfig.isWaitingForPasscodeEnter) {
            if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
                return super.onKeyUp(i, keyEvent);
            }
            if (ArticleViewer.hasInstance() && ArticleViewer.getInstance().isVisible()) {
                return super.onKeyUp(i, keyEvent);
            }
            if (AndroidUtilities.isTablet()) {
                if (this.layersActionBarLayout.getVisibility() == 0 && !this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                    this.layersActionBarLayout.onKeyUp(i, keyEvent);
                } else if (this.rightActionBarLayout.getVisibility() == 0 && !this.rightActionBarLayout.fragmentsStack.isEmpty()) {
                    this.rightActionBarLayout.onKeyUp(i, keyEvent);
                } else {
                    this.actionBarLayout.onKeyUp(i, keyEvent);
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
                this.actionBarLayout.onKeyUp(i, keyEvent);
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // org.rbmain.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean needPresentFragment(BaseFragment baseFragment, boolean z, boolean z2, ActionBarLayout actionBarLayout) {
        ActionBarLayout actionBarLayout2;
        ActionBarLayout actionBarLayout3;
        ActionBarLayout actionBarLayout4;
        ActionBarLayout actionBarLayout5;
        if (ArticleViewer.hasInstance() && ArticleViewer.getInstance().isVisible()) {
            ArticleViewer.getInstance().close(false, true);
        }
        if (AndroidUtilities.isTablet()) {
            boolean z3 = baseFragment instanceof LoginActivityAppp;
            this.drawerLayoutContainer.setAllowOpenDrawer((z3 || (baseFragment instanceof CountrySelectActivity) || this.layersActionBarLayout.getVisibility() == 0) ? false : true, true);
            if ((baseFragment instanceof DialogsActivity) && ((DialogsActivity) baseFragment).isMainDialogList() && actionBarLayout != (actionBarLayout5 = this.actionBarLayout)) {
                actionBarLayout5.removeAllFragments();
                this.actionBarLayout.presentFragment(baseFragment, z, z2, false, false);
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
            if ((baseFragment instanceof ChatActivity) && !((ChatActivity) baseFragment).isInScheduleMode()) {
                boolean z4 = this.tabletFullSize;
                if ((!z4 && actionBarLayout == this.rightActionBarLayout) || (z4 && actionBarLayout == this.actionBarLayout)) {
                    boolean z5 = (z4 && actionBarLayout == (actionBarLayout4 = this.actionBarLayout) && actionBarLayout4.fragmentsStack.size() == 1) ? false : true;
                    if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                        while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                            ActionBarLayout actionBarLayout6 = this.layersActionBarLayout;
                            actionBarLayout6.removeFragmentFromStack(actionBarLayout6.fragmentsStack.get(0));
                        }
                        this.layersActionBarLayout.closeLastFragment(!z2);
                    }
                    if (!z5) {
                        this.actionBarLayout.presentFragment(baseFragment, false, z2, false, false);
                    }
                    return z5;
                }
                if (!z4 && actionBarLayout != (actionBarLayout3 = this.rightActionBarLayout)) {
                    actionBarLayout3.setVisibility(0);
                    this.backgroundTablet.setVisibility(8);
                    this.rightActionBarLayout.removeAllFragments();
                    this.rightActionBarLayout.presentFragment(baseFragment, z, true, false, false);
                    if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                        while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                            ActionBarLayout actionBarLayout7 = this.layersActionBarLayout;
                            actionBarLayout7.removeFragmentFromStack(actionBarLayout7.fragmentsStack.get(0));
                        }
                        this.layersActionBarLayout.closeLastFragment(!z2);
                    }
                    return false;
                }
                if (z4 && actionBarLayout != (actionBarLayout2 = this.actionBarLayout)) {
                    actionBarLayout2.presentFragment(baseFragment, actionBarLayout2.fragmentsStack.size() > 1, z2, false, false);
                    if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                        while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                            ActionBarLayout actionBarLayout8 = this.layersActionBarLayout;
                            actionBarLayout8.removeFragmentFromStack(actionBarLayout8.fragmentsStack.get(0));
                        }
                        this.layersActionBarLayout.closeLastFragment(!z2);
                    }
                    return false;
                }
                if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                    while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                        ActionBarLayout actionBarLayout9 = this.layersActionBarLayout;
                        actionBarLayout9.removeFragmentFromStack(actionBarLayout9.fragmentsStack.get(0));
                    }
                    this.layersActionBarLayout.closeLastFragment(!z2);
                }
                ActionBarLayout actionBarLayout10 = this.actionBarLayout;
                actionBarLayout10.presentFragment(baseFragment, actionBarLayout10.fragmentsStack.size() > 1, z2, false, false);
                return false;
            }
            ActionBarLayout actionBarLayout11 = this.layersActionBarLayout;
            if (actionBarLayout != actionBarLayout11) {
                actionBarLayout11.setVisibility(0);
                this.drawerLayoutContainer.setAllowOpenDrawer(false, true);
                if (z3) {
                    this.backgroundTablet.setVisibility(0);
                    this.shadowTabletSide.setVisibility(8);
                    this.shadowTablet.setBackgroundColor(0);
                } else {
                    this.shadowTablet.setBackgroundColor(2130706432);
                }
                this.layersActionBarLayout.presentFragment(baseFragment, z, z2, false, false);
                return false;
            }
        } else {
            this.drawerLayoutContainer.setAllowOpenDrawer(!(baseFragment instanceof LoginActivityAppp) ? (baseFragment instanceof CountrySelectActivity) && mainFragmentsStack.size() == 1 : mainFragmentsStack.size() == 0, false);
        }
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean needAddFragmentToStack(BaseFragment baseFragment, ActionBarLayout actionBarLayout) {
        ActionBarLayout actionBarLayout2;
        ActionBarLayout actionBarLayout3;
        ActionBarLayout actionBarLayout4;
        if (AndroidUtilities.isTablet()) {
            boolean z = baseFragment instanceof LoginActivityAppp;
            this.drawerLayoutContainer.setAllowOpenDrawer((z || (baseFragment instanceof CountrySelectActivity) || this.layersActionBarLayout.getVisibility() == 0) ? false : true, true);
            if (baseFragment instanceof DialogsActivity) {
                if (((DialogsActivity) baseFragment).isMainDialogList() && actionBarLayout != (actionBarLayout4 = this.actionBarLayout)) {
                    actionBarLayout4.removeAllFragments();
                    this.actionBarLayout.addFragmentToStack(baseFragment);
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
            } else if ((baseFragment instanceof ChatActivity) && !((ChatActivity) baseFragment).isInScheduleMode()) {
                boolean z2 = this.tabletFullSize;
                if (!z2 && actionBarLayout != (actionBarLayout3 = this.rightActionBarLayout)) {
                    actionBarLayout3.setVisibility(0);
                    this.backgroundTablet.setVisibility(8);
                    this.rightActionBarLayout.removeAllFragments();
                    this.rightActionBarLayout.addFragmentToStack(baseFragment);
                    if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                        while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                            ActionBarLayout actionBarLayout5 = this.layersActionBarLayout;
                            actionBarLayout5.removeFragmentFromStack(actionBarLayout5.fragmentsStack.get(0));
                        }
                        this.layersActionBarLayout.closeLastFragment(true);
                    }
                    return false;
                }
                if (z2 && actionBarLayout != (actionBarLayout2 = this.actionBarLayout)) {
                    actionBarLayout2.addFragmentToStack(baseFragment);
                    if (!this.layersActionBarLayout.fragmentsStack.isEmpty()) {
                        while (this.layersActionBarLayout.fragmentsStack.size() - 1 > 0) {
                            ActionBarLayout actionBarLayout6 = this.layersActionBarLayout;
                            actionBarLayout6.removeFragmentFromStack(actionBarLayout6.fragmentsStack.get(0));
                        }
                        this.layersActionBarLayout.closeLastFragment(true);
                    }
                    return false;
                }
            } else {
                ActionBarLayout actionBarLayout7 = this.layersActionBarLayout;
                if (actionBarLayout != actionBarLayout7) {
                    actionBarLayout7.setVisibility(0);
                    this.drawerLayoutContainer.setAllowOpenDrawer(false, true);
                    if (z) {
                        this.backgroundTablet.setVisibility(0);
                        this.shadowTabletSide.setVisibility(8);
                        this.shadowTablet.setBackgroundColor(0);
                    } else {
                        this.shadowTablet.setBackgroundColor(2130706432);
                    }
                    this.layersActionBarLayout.addFragmentToStack(baseFragment);
                    return false;
                }
            }
        } else {
            this.drawerLayoutContainer.setAllowOpenDrawer(!(baseFragment instanceof LoginActivityAppp) ? (baseFragment instanceof CountrySelectActivity) && mainFragmentsStack.size() == 1 : mainFragmentsStack.size() == 0, false);
        }
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public boolean needCloseLastFragment(ActionBarLayout actionBarLayout) {
        if (AndroidUtilities.isTablet()) {
            if (actionBarLayout == this.actionBarLayout && actionBarLayout.fragmentsStack.size() <= 1) {
                onFinish();
                finish();
                return false;
            }
            if (actionBarLayout == this.rightActionBarLayout) {
                if (!this.tabletFullSize) {
                    this.backgroundTablet.setVisibility(0);
                }
            } else if (actionBarLayout == this.layersActionBarLayout && this.actionBarLayout.fragmentsStack.isEmpty() && this.layersActionBarLayout.fragmentsStack.size() == 1) {
                onFinish();
                finish();
                return false;
            }
        } else {
            if (actionBarLayout.fragmentsStack.size() <= 1) {
                onFinish();
                finish();
                return false;
            }
            if (actionBarLayout.fragmentsStack.size() >= 2 && !(actionBarLayout.fragmentsStack.get(0) instanceof LoginActivityAppp)) {
                this.drawerLayoutContainer.setAllowOpenDrawer(true, false);
            }
        }
        return true;
    }

    public void rebuildAllFragments(boolean z) {
        ActionBarLayout actionBarLayout = this.layersActionBarLayout;
        if (actionBarLayout != null) {
            actionBarLayout.rebuildAllFragmentViews(z, z);
        } else {
            this.actionBarLayout.rebuildAllFragmentViews(z, z);
        }
    }

    @Override // org.rbmain.ui.ActionBar.ActionBarLayout.ActionBarLayoutDelegate
    public void onRebuildAllFragments(ActionBarLayout actionBarLayout, boolean z) {
        if (AndroidUtilities.isTablet() && actionBarLayout == this.layersActionBarLayout) {
            this.rightActionBarLayout.rebuildAllFragmentViews(z, z);
            this.actionBarLayout.rebuildAllFragmentViews(z, z);
        }
        this.drawerLayoutAdapter.notifyDataSetChanged();
    }

    public TextView getToastTextView() {
        return this.toastTextView;
    }

    protected CoreMainClass getCoreMainClass() {
        return AccountInstance.getInstance(this.currentAccount).getCoreMainClass();
    }

    public MainTabFragment getMainTabFragment() {
        if (mainFragmentsStack.size() <= 0 || !(mainFragmentsStack.get(0) instanceof MainTabFragment)) {
            return null;
        }
        return (MainTabFragment) mainFragmentsStack.get(0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(context));
    }

    public void addOnUserLeaveHintListener(Runnable runnable) {
        this.onUserLeaveHintListeners.add(runnable);
    }

    public void removeOnUserLeaveHintListener(Runnable runnable) {
        this.onUserLeaveHintListeners.remove(runnable);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        ActionBarLayout actionBarLayout = this.actionBarLayout;
        if (actionBarLayout != null) {
            actionBarLayout.onUserLeaveHint();
        }
    }
}
