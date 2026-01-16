package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_account_getWallPaper;
import ir.eitaa.tgnet.TLRPC$TL_account_getWallPapers;
import ir.eitaa.tgnet.TLRPC$TL_account_wallPapers;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteExported;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeFilename;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationUnavailable;
import ir.eitaa.tgnet.TLRPC$TL_inputWallPaperSlug;
import ir.eitaa.tgnet.TLRPC$TL_message;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityTextUrl;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageReplyHeader;
import ir.eitaa.tgnet.TLRPC$TL_peerChat;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_photo;
import ir.eitaa.tgnet.TLRPC$TL_photoSize;
import ir.eitaa.tgnet.TLRPC$TL_reactionCount;
import ir.eitaa.tgnet.TLRPC$TL_user;
import ir.eitaa.tgnet.TLRPC$TL_wallPaper;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WallPaper;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.ChatActionCell;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Cells.DialogCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Cells.PatternCell;
import ir.eitaa.ui.Cells.TextSelectionHelper;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BackgroundGradientDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.ColorPicker;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.HintView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.MotionBackgroundDrawable;
import ir.eitaa.ui.Components.RadialProgress2;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SeekBarView;
import ir.eitaa.ui.Components.ShareAlert;
import ir.eitaa.ui.Components.UndoView;
import ir.eitaa.ui.Components.WallpaperCheckBoxView;
import ir.eitaa.ui.Components.WallpaperParallaxEffect;
import ir.eitaa.ui.WallpapersListActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class ThemePreviewActivity extends BaseFragment implements DownloadController.FileDownloadProgressListener, NotificationCenter.NotificationCenterDelegate {
    private int TAG;
    private Theme.ThemeAccent accent;
    private ActionBar actionBar2;
    private HintView animationHint;
    private Runnable applyColorAction;
    private boolean applyColorScheduled;
    private Theme.ThemeInfo applyingTheme;
    private FrameLayout backgroundButtonsContainer;
    private WallpaperCheckBoxView[] backgroundCheckBoxView;
    private int backgroundColor;
    private int backgroundGradientColor1;
    private int backgroundGradientColor2;
    private int backgroundGradientColor3;
    private BackgroundGradientDrawable.Disposable backgroundGradientDisposable;
    private BackupImageView backgroundImage;
    private ImageView backgroundPlayAnimationImageView;
    private FrameLayout backgroundPlayAnimationView;
    private AnimatorSet backgroundPlayViewAnimator;
    private int backgroundRotation;
    private int backupAccentColor;
    private int backupAccentColor2;
    private long backupBackgroundGradientOverrideColor1;
    private long backupBackgroundGradientOverrideColor2;
    private long backupBackgroundGradientOverrideColor3;
    private long backupBackgroundOverrideColor;
    private int backupBackgroundRotation;
    private float backupIntensity;
    private int backupMyMessagesAccentColor;
    private boolean backupMyMessagesAnimated;
    private int backupMyMessagesGradientAccentColor1;
    private int backupMyMessagesGradientAccentColor2;
    private int backupMyMessagesGradientAccentColor3;
    private String backupSlug;
    private final PorterDuff.Mode blendMode;
    private Bitmap blurredBitmap;
    private FrameLayout bottomOverlayChat;
    private TextView bottomOverlayChatText;
    private TextView cancelButton;
    private int checkColor;
    private ColorPicker colorPicker;
    private int colorType;
    private float currentIntensity;
    private Object currentWallpaper;
    private Bitmap currentWallpaperBitmap;
    private WallpaperActivityDelegate delegate;
    private boolean deleteOnCancel;
    private DialogsAdapter dialogsAdapter;
    private TextView doneButton;
    private View dotsContainer;
    private TextView dropDown;
    private ActionBarMenuItem dropDownContainer;
    private boolean editingTheme;
    private ImageView floatingButton;
    private FrameLayout frameLayout;
    private String imageFilter;
    private HeaderCell intensityCell;
    private SeekBarView intensitySeekBar;
    private boolean isBlurred;
    private boolean isMotion;
    private int lastPickedColor;
    private int lastPickedColorNum;
    private TLRPC$TL_wallPaper lastSelectedPattern;
    private RecyclerListView listView;
    private RecyclerListView listView2;
    private String loadingFile;
    private File loadingFileObject;
    private TLRPC$PhotoSize loadingSize;
    private int maxWallpaperSize;
    private MessagesAdapter messagesAdapter;
    private FrameLayout messagesButtonsContainer;
    private WallpaperCheckBoxView[] messagesCheckBoxView;
    private ImageView messagesPlayAnimationImageView;
    private FrameLayout messagesPlayAnimationView;
    private AnimatorSet messagesPlayViewAnimator;
    private AnimatorSet motionAnimation;
    Theme.MessageDrawable msgOutDrawable;
    Theme.MessageDrawable msgOutDrawableSelected;
    Theme.MessageDrawable msgOutMediaDrawable;
    Theme.MessageDrawable msgOutMediaDrawableSelected;
    private boolean nightTheme;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private Bitmap originalBitmap;
    private FrameLayout page1;
    private FrameLayout page2;
    private WallpaperParallaxEffect parallaxEffect;
    private float parallaxScale;
    private int patternColor;
    private FrameLayout[] patternLayout;
    private AnimatorSet patternViewAnimation;
    private ArrayList<Object> patterns;
    private PatternsAdapter patternsAdapter;
    private FrameLayout[] patternsButtonsContainer;
    private TextView[] patternsCancelButton;
    private HashMap<Long, Object> patternsDict;
    private LinearLayoutManager patternsLayoutManager;
    private RecyclerListView patternsListView;
    private TextView[] patternsSaveButton;
    private int previousBackgroundColor;
    private int previousBackgroundGradientColor1;
    private int previousBackgroundGradientColor2;
    private int previousBackgroundGradientColor3;
    private int previousBackgroundRotation;
    private float previousIntensity;
    private TLRPC$TL_wallPaper previousSelectedPattern;
    private boolean progressVisible;
    private RadialProgress2 radialProgress;
    private boolean removeBackgroundOverride;
    private boolean rotatePreview;
    private FrameLayout saveButtonsContainer;
    private ActionBarMenuItem saveItem;
    private final int screenType;
    private TLRPC$TL_wallPaper selectedPattern;
    private Drawable sheetDrawable;
    private boolean showColor;
    private List<ThemeDescription> themeDescriptions;
    private UndoView undoView;
    public boolean useDefaultThemeForButtons;
    private ViewPager viewPager;
    private boolean wasScroll;
    private long watchForKeyboardEndTime;

    public interface WallpaperActivityDelegate {
        void didSetNewBackground();
    }

    static /* synthetic */ void lambda$createView$1(View view, int i) {
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent event) {
        return false;
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressUpload(String fileName, long uploadedSize, long totalSize, boolean isEncrypted) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ThemePreviewActivity() throws NoSuchFieldException {
        this.applyColorScheduled = false;
        applyColor(this.lastPickedColor, this.lastPickedColorNum);
        this.lastPickedColorNum = -1;
    }

    public ThemePreviewActivity(Object wallPaper, Bitmap bitmap) {
        this(wallPaper, bitmap, false, false);
    }

    public ThemePreviewActivity(Object wallPaper, Bitmap bitmap, boolean rotate, boolean openColor) {
        this.useDefaultThemeForButtons = true;
        this.colorType = 1;
        this.msgOutDrawable = new Theme.MessageDrawable(0, true, false);
        this.msgOutDrawableSelected = new Theme.MessageDrawable(0, true, true);
        this.msgOutMediaDrawable = new Theme.MessageDrawable(1, true, false);
        this.msgOutMediaDrawableSelected = new Theme.MessageDrawable(1, true, true);
        this.lastPickedColorNum = -1;
        this.applyColorAction = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$4BrK2aRNHm2AwZqXwJ7z0xhSvvs
            @Override // java.lang.Runnable
            public final void run() throws NoSuchFieldException {
                this.f$0.lambda$new$0$ThemePreviewActivity();
            }
        };
        this.patternLayout = new FrameLayout[2];
        this.patternsCancelButton = new TextView[2];
        this.patternsSaveButton = new TextView[2];
        this.patternsButtonsContainer = new FrameLayout[2];
        this.patternsDict = new HashMap<>();
        this.currentIntensity = 0.5f;
        this.blendMode = PorterDuff.Mode.SRC_IN;
        this.parallaxScale = 1.0f;
        this.loadingFile = null;
        this.loadingFileObject = null;
        this.loadingSize = null;
        this.imageFilter = "640_360";
        this.maxWallpaperSize = 1920;
        this.screenType = 2;
        this.showColor = openColor;
        this.currentWallpaper = wallPaper;
        this.currentWallpaperBitmap = bitmap;
        this.rotatePreview = rotate;
        if (wallPaper instanceof WallpapersListActivity.ColorWallpaper) {
            WallpapersListActivity.ColorWallpaper colorWallpaper = (WallpapersListActivity.ColorWallpaper) wallPaper;
            this.isMotion = colorWallpaper.motion;
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = colorWallpaper.pattern;
            this.selectedPattern = tLRPC$TL_wallPaper;
            if (tLRPC$TL_wallPaper != null) {
                float f = colorWallpaper.intensity;
                this.currentIntensity = f;
                if (f < 0.0f && !Theme.getActiveTheme().isDark()) {
                    this.currentIntensity *= -1.0f;
                }
            }
        }
        this.msgOutDrawable.themePreview = true;
        this.msgOutMediaDrawable.themePreview = true;
        this.msgOutDrawableSelected.themePreview = true;
        this.msgOutMediaDrawableSelected.themePreview = true;
    }

    public ThemePreviewActivity(Theme.ThemeInfo themeInfo) {
        this(themeInfo, false, 0, false, false);
    }

    public ThemePreviewActivity(Theme.ThemeInfo themeInfo, boolean deleteFile, int screenType, boolean edit, boolean night) {
        this.useDefaultThemeForButtons = true;
        this.colorType = 1;
        this.msgOutDrawable = new Theme.MessageDrawable(0, true, false);
        this.msgOutDrawableSelected = new Theme.MessageDrawable(0, true, true);
        this.msgOutMediaDrawable = new Theme.MessageDrawable(1, true, false);
        this.msgOutMediaDrawableSelected = new Theme.MessageDrawable(1, true, true);
        this.lastPickedColorNum = -1;
        this.applyColorAction = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$4BrK2aRNHm2AwZqXwJ7z0xhSvvs
            @Override // java.lang.Runnable
            public final void run() throws NoSuchFieldException {
                this.f$0.lambda$new$0$ThemePreviewActivity();
            }
        };
        this.patternLayout = new FrameLayout[2];
        this.patternsCancelButton = new TextView[2];
        this.patternsSaveButton = new TextView[2];
        this.patternsButtonsContainer = new FrameLayout[2];
        this.patternsDict = new HashMap<>();
        this.currentIntensity = 0.5f;
        this.blendMode = PorterDuff.Mode.SRC_IN;
        this.parallaxScale = 1.0f;
        this.loadingFile = null;
        this.loadingFileObject = null;
        this.loadingSize = null;
        this.imageFilter = "640_360";
        this.maxWallpaperSize = 1920;
        this.screenType = screenType;
        this.nightTheme = night;
        this.applyingTheme = themeInfo;
        this.deleteOnCancel = deleteFile;
        this.editingTheme = edit;
        if (screenType == 1) {
            Theme.ThemeAccent accent = themeInfo.getAccent(!edit);
            this.accent = accent;
            this.useDefaultThemeForButtons = false;
            this.backupAccentColor = accent.accentColor;
            this.backupAccentColor2 = accent.accentColor2;
            this.backupMyMessagesAccentColor = accent.myMessagesAccentColor;
            this.backupMyMessagesGradientAccentColor1 = accent.myMessagesGradientAccentColor1;
            this.backupMyMessagesGradientAccentColor2 = accent.myMessagesGradientAccentColor2;
            this.backupMyMessagesGradientAccentColor3 = accent.myMessagesGradientAccentColor3;
            this.backupMyMessagesAnimated = accent.myMessagesAnimated;
            this.backupBackgroundOverrideColor = accent.backgroundOverrideColor;
            this.backupBackgroundGradientOverrideColor1 = accent.backgroundGradientOverrideColor1;
            this.backupBackgroundGradientOverrideColor2 = accent.backgroundGradientOverrideColor2;
            this.backupBackgroundGradientOverrideColor3 = accent.backgroundGradientOverrideColor3;
            this.backupIntensity = accent.patternIntensity;
            this.backupSlug = accent.patternSlug;
            this.backupBackgroundRotation = accent.backgroundRotation;
        } else {
            if (screenType == 0) {
                this.useDefaultThemeForButtons = false;
            }
            Theme.ThemeAccent accent2 = themeInfo.getAccent(false);
            this.accent = accent2;
            if (accent2 != null) {
                this.selectedPattern = accent2.pattern;
            }
        }
        Theme.ThemeAccent themeAccent = this.accent;
        if (themeAccent != null) {
            this.isMotion = themeAccent.patternMotion;
            if (!TextUtils.isEmpty(themeAccent.patternSlug)) {
                this.currentIntensity = this.accent.patternIntensity;
            }
            Theme.applyThemeTemporary(this.applyingTheme, true);
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.goingToPreviewTheme, new Object[0]);
        this.msgOutDrawable.themePreview = true;
        this.msgOutMediaDrawable.themePreview = true;
        this.msgOutDrawableSelected.themePreview = true;
        this.msgOutMediaDrawableSelected.themePreview = true;
    }

    public void setInitialModes(boolean blur, boolean motion) {
        this.isBlurred = blur;
        this.isMotion = motion;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public int getNavigationBarColor() {
        return super.getNavigationBarColor();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x06f8  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x07fc  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0936  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0c8b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02a9  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    @android.annotation.SuppressLint({"Recycle"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View createView(android.content.Context r37) throws java.lang.NoSuchFieldException, java.lang.InterruptedException, android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 3729
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ThemePreviewActivity.createView(android.content.Context):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$ThemePreviewActivity(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) throws InterruptedException {
        if (this.currentWallpaper instanceof WallpapersListActivity.ColorWallpaper) {
            return;
        }
        Drawable drawable = imageReceiver.getDrawable();
        if (!z || drawable == null) {
            return;
        }
        if (!Theme.hasThemeKey("chat_serviceBackground") || (this.backgroundImage.getBackground() instanceof MotionBackgroundDrawable)) {
            Theme.applyChatServiceMessageColor(AndroidUtilities.calcDrawableColor(drawable), drawable);
        }
        this.listView2.invalidateViews();
        FrameLayout frameLayout = this.backgroundButtonsContainer;
        if (frameLayout != null) {
            int childCount = frameLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.backgroundButtonsContainer.getChildAt(i).invalidate();
            }
        }
        FrameLayout frameLayout2 = this.messagesButtonsContainer;
        if (frameLayout2 != null) {
            int childCount2 = frameLayout2.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                this.messagesButtonsContainer.getChildAt(i2).invalidate();
            }
        }
        RadialProgress2 radialProgress2 = this.radialProgress;
        if (radialProgress2 != null) {
            radialProgress2.setColors("chat_serviceBackground", "chat_serviceBackground", "chat_serviceText", "chat_serviceText");
        }
        if (!z2 && this.isBlurred && this.blurredBitmap == null) {
            this.backgroundImage.getImageReceiver().setCrossfadeWithOldImage(false);
            updateBlurred();
            this.backgroundImage.getImageReceiver().setCrossfadeWithOldImage(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$ThemePreviewActivity(View view) {
        this.dropDownContainer.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$ThemePreviewActivity(View view, int i, float f, float f2) {
        if (view instanceof ChatMessageCell) {
            ChatMessageCell chatMessageCell = (ChatMessageCell) view;
            if (chatMessageCell.isInsideBackground(f, f2)) {
                if (chatMessageCell.getMessageObject().isOutOwner()) {
                    selectColorType(3);
                    return;
                } else {
                    selectColorType(1);
                    return;
                }
            }
            selectColorType(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$ThemePreviewActivity(int i, int i2, float f) {
        if (this.isMotion) {
            this.backgroundImage.getBackground();
            float scaleX = this.motionAnimation != null ? (this.backgroundImage.getScaleX() - 1.0f) / (this.parallaxScale - 1.0f) : 1.0f;
            this.backgroundImage.setTranslationX(i * scaleX);
            this.backgroundImage.setTranslationY(i2 * scaleX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x018c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c4  */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$6$ThemePreviewActivity(android.view.View r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 786
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ThemePreviewActivity.lambda$createView$6$ThemePreviewActivity(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$ThemePreviewActivity(int i, WallpaperCheckBoxView wallpaperCheckBoxView, View view) throws InterruptedException {
        if (this.backgroundButtonsContainer.getAlpha() == 1.0f && this.patternViewAnimation == null) {
            int i2 = this.screenType;
            if ((i2 == 1 || (this.currentWallpaper instanceof WallpapersListActivity.ColorWallpaper)) && i == 2) {
                wallpaperCheckBoxView.setChecked(!wallpaperCheckBoxView.isChecked(), true);
                boolean zIsChecked = wallpaperCheckBoxView.isChecked();
                this.isMotion = zIsChecked;
                this.parallaxEffect.setEnabled(zIsChecked);
                animateMotionChange();
                return;
            }
            if (i == 1 && (i2 == 1 || (this.currentWallpaper instanceof WallpapersListActivity.ColorWallpaper))) {
                if (this.backgroundCheckBoxView[1].isChecked()) {
                    this.lastSelectedPattern = this.selectedPattern;
                    this.backgroundImage.setImageDrawable(null);
                    this.selectedPattern = null;
                    this.isMotion = false;
                    updateButtonState(false, true);
                    animateMotionChange();
                    if (this.patternLayout[1].getVisibility() == 0) {
                        if (this.screenType == 1) {
                            showPatternsView(0, true, true);
                        } else {
                            showPatternsView(i, this.patternLayout[i].getVisibility() != 0, true);
                        }
                    }
                } else {
                    selectPattern(this.lastSelectedPattern != null ? -1 : 0);
                    if (this.screenType == 1) {
                        showPatternsView(1, true, true);
                    } else {
                        showPatternsView(i, this.patternLayout[i].getVisibility() != 0, true);
                    }
                }
                this.backgroundCheckBoxView[1].setChecked(this.selectedPattern != null, true);
                updateSelectedPattern(true);
                this.patternsListView.invalidateViews();
                updateMotionButton();
                return;
            }
            if (this.currentWallpaper instanceof WallpapersListActivity.ColorWallpaper) {
                showPatternsView(i, this.patternLayout[i].getVisibility() != 0, true);
                return;
            }
            if (i2 != 1) {
                wallpaperCheckBoxView.setChecked(!wallpaperCheckBoxView.isChecked(), true);
                if (i == 0) {
                    boolean zIsChecked2 = wallpaperCheckBoxView.isChecked();
                    this.isBlurred = zIsChecked2;
                    if (zIsChecked2) {
                        this.backgroundImage.getImageReceiver().setForceCrossfade(true);
                    }
                    updateBlurred();
                    return;
                }
                boolean zIsChecked3 = wallpaperCheckBoxView.isChecked();
                this.isMotion = zIsChecked3;
                this.parallaxEffect.setEnabled(zIsChecked3);
                animateMotionChange();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$ThemePreviewActivity(int i, WallpaperCheckBoxView wallpaperCheckBoxView, View view) {
        if (this.messagesButtonsContainer.getAlpha() == 1.0f && i == 0) {
            wallpaperCheckBoxView.setChecked(!wallpaperCheckBoxView.isChecked(), true);
            this.accent.myMessagesAnimated = wallpaperCheckBoxView.isChecked();
            Theme.refreshThemeColors(true, true);
            this.listView2.invalidateViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$ThemePreviewActivity(int i, View view) {
        if (this.patternViewAnimation != null) {
            return;
        }
        if (i == 0) {
            this.backgroundRotation = this.previousBackgroundRotation;
            setBackgroundColor(this.previousBackgroundGradientColor3, 3, true, true);
            setBackgroundColor(this.previousBackgroundGradientColor2, 2, true, true);
            setBackgroundColor(this.previousBackgroundGradientColor1, 1, true, true);
            setBackgroundColor(this.previousBackgroundColor, 0, true, true);
        } else {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = this.previousSelectedPattern;
            this.selectedPattern = tLRPC$TL_wallPaper;
            if (tLRPC$TL_wallPaper == null) {
                this.backgroundImage.setImageDrawable(null);
            } else {
                BackupImageView backupImageView = this.backgroundImage;
                ImageLocation forDocument = ImageLocation.getForDocument(tLRPC$TL_wallPaper.document);
                String str = this.imageFilter;
                TLRPC$TL_wallPaper tLRPC$TL_wallPaper2 = this.selectedPattern;
                backupImageView.setImage(forDocument, str, null, null, "jpg", tLRPC$TL_wallPaper2.document.size, 1, tLRPC$TL_wallPaper2);
            }
            this.backgroundCheckBoxView[1].setChecked(this.selectedPattern != null, false);
            float f = this.previousIntensity;
            this.currentIntensity = f;
            this.intensitySeekBar.setProgress(f);
            this.backgroundImage.getImageReceiver().setAlpha(this.currentIntensity);
            updateButtonState(false, true);
            updateSelectedPattern(true);
        }
        if (this.screenType == 2) {
            showPatternsView(i, false, true);
            return;
        }
        if (this.selectedPattern == null) {
            if (this.isMotion) {
                this.isMotion = false;
                this.backgroundCheckBoxView[0].setChecked(false, true);
                animateMotionChange();
            }
            updateMotionButton();
        }
        showPatternsView(0, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$10$ThemePreviewActivity(int i, View view) {
        if (this.patternViewAnimation != null) {
            return;
        }
        if (this.screenType == 2) {
            showPatternsView(i, false, true);
        } else {
            showPatternsView(0, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$11$ThemePreviewActivity(View view, int i) {
        boolean z = this.selectedPattern != null;
        selectPattern(i);
        if (z == (this.selectedPattern == null)) {
            animateMotionChange();
            updateMotionButton();
        }
        updateSelectedPattern(true);
        this.backgroundCheckBoxView[1].setChecked(this.selectedPattern != null, true);
        this.patternsListView.invalidateViews();
        int left = view.getLeft();
        int right = view.getRight();
        int iDp = AndroidUtilities.dp(52.0f);
        int i2 = left - iDp;
        if (i2 < 0) {
            this.patternsListView.smoothScrollBy(i2, 0);
            return;
        }
        int i3 = right + iDp;
        if (i3 > this.patternsListView.getMeasuredWidth()) {
            RecyclerListView recyclerListView = this.patternsListView;
            recyclerListView.smoothScrollBy(i3 - recyclerListView.getMeasuredWidth(), 0);
        }
    }

    /* renamed from: ir.eitaa.ui.ThemePreviewActivity$22, reason: invalid class name */
    class AnonymousClass22 implements ColorPicker.ColorPickerDelegate {
        AnonymousClass22() {
        }

        @Override // ir.eitaa.ui.Components.ColorPicker.ColorPickerDelegate
        public void setColor(int color, int num, boolean applyNow) {
            if (ThemePreviewActivity.this.screenType == 2) {
                ThemePreviewActivity.this.setBackgroundColor(color, num, applyNow, true);
            } else {
                ThemePreviewActivity.this.scheduleApplyColor(color, num, applyNow);
            }
        }

        @Override // ir.eitaa.ui.Components.ColorPicker.ColorPickerDelegate
        public void openThemeCreate(boolean share) {
            if (share) {
                if (ThemePreviewActivity.this.accent.info == null) {
                    ThemePreviewActivity.this.finishFragment();
                    MessagesController.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).saveThemeToServer(ThemePreviewActivity.this.accent.parentTheme, ThemePreviewActivity.this.accent);
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needShareTheme, ThemePreviewActivity.this.accent.parentTheme, ThemePreviewActivity.this.accent);
                    return;
                }
                String str = "https://" + MessagesController.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).linkPrefix + "/addtheme/" + ThemePreviewActivity.this.accent.info.slug;
                ThemePreviewActivity.this.showDialog(new ShareAlert(ThemePreviewActivity.this.getParentActivity(), null, str, false, str, false));
                return;
            }
            AlertsCreator.createThemeCreateDialog(ThemePreviewActivity.this, 1, null, null);
        }

        @Override // ir.eitaa.ui.Components.ColorPicker.ColorPickerDelegate
        public void deleteTheme() {
            if (ThemePreviewActivity.this.getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(ThemePreviewActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("DeleteThemeTitle", R.string.DeleteThemeTitle));
            builder.setMessage(LocaleController.getString("DeleteThemeAlert", R.string.DeleteThemeAlert));
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$22$lhWKLG3yZ7ecUGU4Q1DzjM9pNyU
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$deleteTheme$0$ThemePreviewActivity$22(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            ThemePreviewActivity.this.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$deleteTheme$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$deleteTheme$0$ThemePreviewActivity$22(DialogInterface dialogInterface, int i) {
            Theme.deleteThemeAccent(ThemePreviewActivity.this.applyingTheme, ThemePreviewActivity.this.accent, true);
            Theme.applyPreviousTheme();
            Theme.refreshThemeColors();
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needSetDayNightTheme, ThemePreviewActivity.this.applyingTheme, Boolean.valueOf(ThemePreviewActivity.this.nightTheme), null, -1);
            ThemePreviewActivity.this.finishFragment();
        }

        @Override // ir.eitaa.ui.Components.ColorPicker.ColorPickerDelegate
        public int getDefaultColor(int num) {
            Theme.ThemeAccent themeAccent;
            if (ThemePreviewActivity.this.colorType == 3 && ThemePreviewActivity.this.applyingTheme.firstAccentIsDefault && num == 0 && (themeAccent = ThemePreviewActivity.this.applyingTheme.themeAccentsMap.get(Theme.DEFALT_THEME_ACCENT_ID)) != null) {
                return themeAccent.myMessagesAccentColor;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$12$ThemePreviewActivity() {
        this.watchForKeyboardEndTime = SystemClock.elapsedRealtime() + 1500;
        this.frameLayout.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$13$ThemePreviewActivity(View view) {
        cancelThemeApply(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$14$ThemePreviewActivity(View view) {
        Theme.ThemeAccent accent;
        Theme.ThemeInfo previousTheme = Theme.getPreviousTheme();
        if (previousTheme == null) {
            return;
        }
        int i = previousTheme.prevAccentId;
        if (i >= 0) {
            accent = previousTheme.themeAccentsMap.get(i);
        } else {
            accent = previousTheme.getAccent(false);
        }
        if (this.accent != null) {
            saveAccentWallpaper();
            Theme.saveThemeAccents(this.applyingTheme, true, false, false, false);
            Theme.clearPreviousTheme();
            Theme.applyTheme(this.applyingTheme, this.nightTheme);
            this.parentLayout.rebuildAllFragmentViews(false, false);
        } else {
            this.parentLayout.rebuildAllFragmentViews(false, false);
            File file = new File(this.applyingTheme.pathToFile);
            Theme.ThemeInfo themeInfo = this.applyingTheme;
            Theme.applyThemeFile(file, themeInfo.name, themeInfo.info, false);
            MessagesController.getInstance(this.applyingTheme.account).saveTheme(this.applyingTheme, null, false, false);
            SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0).edit();
            editorEdit.putString("lastDayTheme", this.applyingTheme.getKey());
            editorEdit.commit();
        }
        finishFragment();
        if (this.screenType == 0) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didApplyNewTheme, previousTheme, accent, Boolean.valueOf(this.deleteOnCancel));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onColorsRotate() {
        if (this.screenType == 2) {
            this.backgroundRotation += 45;
            while (true) {
                int i = this.backgroundRotation;
                if (i >= 360) {
                    this.backgroundRotation = i - 360;
                } else {
                    setBackgroundColor(this.backgroundColor, 0, true, true);
                    return;
                }
            }
        } else {
            this.accent.backgroundRotation += 45;
            while (true) {
                Theme.ThemeAccent themeAccent = this.accent;
                int i2 = themeAccent.backgroundRotation;
                if (i2 >= 360) {
                    themeAccent.backgroundRotation = i2 - 360;
                } else {
                    Theme.refreshThemeColors();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectColorType(int id) {
        selectColorType(id, true);
    }

    private void selectColorType(int id, boolean ask) {
        int i;
        if (getParentActivity() == null || this.colorType == id || this.patternViewAnimation != null) {
            return;
        }
        if (ask && id == 2 && (Theme.hasCustomWallpaper() || this.accent.backgroundOverrideColor == 4294967296L)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("ChangeChatBackground", R.string.ChangeChatBackground));
            if (!Theme.hasCustomWallpaper() || Theme.isCustomWallpaperColor()) {
                builder.setMessage(LocaleController.getString("ChangeColorToColor", R.string.ChangeColorToColor));
                builder.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$jBDYt94tV9KfjaSJNZoIRS3od60
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$selectColorType$15$ThemePreviewActivity(dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Continue", R.string.Continue), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$W59T7AXEBugXQnbH21Z8OxJ3_kE
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$selectColorType$16$ThemePreviewActivity(dialogInterface, i2);
                    }
                });
            } else {
                builder.setMessage(LocaleController.getString("ChangeWallpaperToColor", R.string.ChangeWallpaperToColor));
                builder.setPositiveButton(LocaleController.getString("Change", R.string.Change), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$LqMLOlEs3cM47LhIs7SHVLELfsM
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$selectColorType$17$ThemePreviewActivity(dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            }
            showDialog(builder.create());
            return;
        }
        int i2 = this.colorType;
        this.colorType = id;
        if (id == 1) {
            this.dropDown.setText(LocaleController.getString("ColorPickerMainColor", R.string.ColorPickerMainColor));
            this.colorPicker.setType(1, hasChanges(1), 2, this.accent.accentColor2 != 0 ? 2 : 1, false, 0, false);
            this.colorPicker.setColor(this.accent.accentColor, 0);
            int i3 = this.accent.accentColor2;
            if (i3 != 0) {
                this.colorPicker.setColor(i3, 1);
            }
            if (i2 == 2 || (i2 == 3 && this.accent.myMessagesGradientAccentColor2 != 0)) {
                this.messagesAdapter.notifyItemRemoved(0);
            }
        } else if (id == 2) {
            this.dropDown.setText(LocaleController.getString("ColorPickerBackground", R.string.ColorPickerBackground));
            int color = Theme.getColor("chat_wallpaper");
            int color2 = Theme.hasThemeKey("chat_wallpaper_gradient_to") ? Theme.getColor("chat_wallpaper_gradient_to") : 0;
            int color3 = Theme.hasThemeKey("key_chat_wallpaper_gradient_to2") ? Theme.getColor("key_chat_wallpaper_gradient_to2") : 0;
            int color4 = Theme.hasThemeKey("key_chat_wallpaper_gradient_to3") ? Theme.getColor("key_chat_wallpaper_gradient_to3") : 0;
            Theme.ThemeAccent themeAccent = this.accent;
            long j = themeAccent.backgroundGradientOverrideColor1;
            int i4 = (int) j;
            if (i4 == 0 && j != 0) {
                color2 = 0;
            }
            long j2 = themeAccent.backgroundGradientOverrideColor2;
            int i5 = (int) j2;
            if (i5 == 0 && j2 != 0) {
                color3 = 0;
            }
            long j3 = themeAccent.backgroundGradientOverrideColor3;
            int i6 = (int) j3;
            if (i6 == 0 && j3 != 0) {
                color4 = 0;
            }
            int i7 = (int) themeAccent.backgroundOverrideColor;
            this.colorPicker.setType(2, hasChanges(2), 4, (i4 == 0 && color2 == 0) ? 1 : (i6 == 0 && color4 == 0) ? (i5 == 0 && color3 == 0) ? 2 : 3 : 4, false, this.accent.backgroundRotation, false);
            ColorPicker colorPicker = this.colorPicker;
            if (i6 == 0) {
                i6 = color4;
            }
            colorPicker.setColor(i6, 3);
            ColorPicker colorPicker2 = this.colorPicker;
            if (i5 == 0) {
                i5 = color3;
            }
            colorPicker2.setColor(i5, 2);
            ColorPicker colorPicker3 = this.colorPicker;
            if (i4 == 0) {
                i4 = color2;
            }
            colorPicker3.setColor(i4, 1);
            ColorPicker colorPicker4 = this.colorPicker;
            if (i7 != 0) {
                color = i7;
            }
            colorPicker4.setColor(color, 0);
            if (i2 == 1 || this.accent.myMessagesGradientAccentColor2 == 0) {
                this.messagesAdapter.notifyItemInserted(0);
            } else {
                this.messagesAdapter.notifyItemChanged(0);
            }
            this.listView2.smoothScrollBy(0, AndroidUtilities.dp(60.0f));
        } else if (id == 3) {
            this.dropDown.setText(LocaleController.getString("ColorPickerMyMessages", R.string.ColorPickerMyMessages));
            Theme.ThemeAccent themeAccent2 = this.accent;
            if (themeAccent2.myMessagesGradientAccentColor1 == 0) {
                i = 1;
            } else if (themeAccent2.myMessagesGradientAccentColor3 != 0) {
                i = 4;
            } else {
                i = themeAccent2.myMessagesGradientAccentColor2 != 0 ? 3 : 2;
            }
            this.colorPicker.setType(2, hasChanges(3), 4, i, true, 0, false);
            this.colorPicker.setColor(this.accent.myMessagesGradientAccentColor3, 3);
            this.colorPicker.setColor(this.accent.myMessagesGradientAccentColor2, 2);
            this.colorPicker.setColor(this.accent.myMessagesGradientAccentColor1, 1);
            ColorPicker colorPicker5 = this.colorPicker;
            Theme.ThemeAccent themeAccent3 = this.accent;
            int i8 = themeAccent3.myMessagesAccentColor;
            if (i8 == 0) {
                i8 = themeAccent3.accentColor;
            }
            colorPicker5.setColor(i8, 0);
            this.messagesCheckBoxView[1].setColor(0, this.accent.myMessagesAccentColor);
            this.messagesCheckBoxView[1].setColor(1, this.accent.myMessagesGradientAccentColor1);
            this.messagesCheckBoxView[1].setColor(2, this.accent.myMessagesGradientAccentColor2);
            this.messagesCheckBoxView[1].setColor(3, this.accent.myMessagesGradientAccentColor3);
            if (this.accent.myMessagesGradientAccentColor2 != 0) {
                if (i2 == 1) {
                    this.messagesAdapter.notifyItemInserted(0);
                } else {
                    this.messagesAdapter.notifyItemChanged(0);
                }
            } else if (i2 == 2) {
                this.messagesAdapter.notifyItemRemoved(0);
            }
            this.listView2.smoothScrollBy(0, AndroidUtilities.dp(60.0f));
            showAnimationHint();
        }
        if (id == 1 || id == 3) {
            if (i2 == 2 && this.patternLayout[1].getVisibility() == 0) {
                showPatternsView(0, true, true);
            }
            if (id == 1) {
                if (this.applyingTheme.isDark()) {
                    this.colorPicker.setMinBrightness(0.2f);
                    return;
                } else {
                    this.colorPicker.setMinBrightness(0.05f);
                    this.colorPicker.setMaxBrightness(0.8f);
                    return;
                }
            }
            this.colorPicker.setMinBrightness(0.0f);
            this.colorPicker.setMaxBrightness(1.0f);
            return;
        }
        this.colorPicker.setMinBrightness(0.0f);
        this.colorPicker.setMaxBrightness(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$selectColorType$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$selectColorType$15$ThemePreviewActivity(DialogInterface dialogInterface, int i) {
        Theme.ThemeAccent themeAccent = this.accent;
        if (themeAccent.backgroundOverrideColor == 4294967296L) {
            themeAccent.backgroundOverrideColor = 0L;
            themeAccent.backgroundGradientOverrideColor1 = 0L;
            themeAccent.backgroundGradientOverrideColor2 = 0L;
            themeAccent.backgroundGradientOverrideColor3 = 0L;
            updatePlayAnimationView(false);
            Theme.refreshThemeColors();
        }
        this.removeBackgroundOverride = true;
        Theme.resetCustomWallpaper(true);
        selectColorType(2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$selectColorType$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$selectColorType$16$ThemePreviewActivity(DialogInterface dialogInterface, int i) {
        if (Theme.isCustomWallpaperColor()) {
            Theme.ThemeAccent themeAccent = this.accent;
            Theme.OverrideWallpaperInfo overrideWallpaperInfo = themeAccent.overrideWallpaper;
            themeAccent.backgroundOverrideColor = overrideWallpaperInfo.color;
            themeAccent.backgroundGradientOverrideColor1 = overrideWallpaperInfo.gradientColor1;
            themeAccent.backgroundGradientOverrideColor2 = overrideWallpaperInfo.gradientColor2;
            themeAccent.backgroundGradientOverrideColor3 = overrideWallpaperInfo.gradientColor3;
            themeAccent.backgroundRotation = overrideWallpaperInfo.rotation;
            String str = overrideWallpaperInfo.slug;
            themeAccent.patternSlug = str;
            float f = overrideWallpaperInfo.intensity;
            themeAccent.patternIntensity = f;
            this.currentIntensity = f;
            if (str != null && !"c".equals(str)) {
                int size = this.patterns.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) this.patterns.get(i2);
                    if (tLRPC$TL_wallPaper.pattern && this.accent.patternSlug.equals(tLRPC$TL_wallPaper.slug)) {
                        this.selectedPattern = tLRPC$TL_wallPaper;
                        break;
                    }
                    i2++;
                }
            } else {
                this.selectedPattern = null;
            }
            this.removeBackgroundOverride = true;
            this.backgroundCheckBoxView[1].setChecked(this.selectedPattern != null, true);
            updatePlayAnimationView(false);
            Theme.refreshThemeColors();
        }
        Drawable background = this.backgroundImage.getBackground();
        if (background instanceof MotionBackgroundDrawable) {
            MotionBackgroundDrawable motionBackgroundDrawable = (MotionBackgroundDrawable) background;
            motionBackgroundDrawable.setPatternBitmap(100, null);
            if (Theme.getActiveTheme().isDark()) {
                if (this.currentIntensity < 0.0f) {
                    this.backgroundImage.getImageReceiver().setGradientBitmap(motionBackgroundDrawable.getBitmap());
                }
                SeekBarView seekBarView = this.intensitySeekBar;
                if (seekBarView != null) {
                    seekBarView.setTwoSided(true);
                }
            } else {
                float f2 = this.currentIntensity;
                if (f2 < 0.0f) {
                    this.currentIntensity = -f2;
                }
            }
        }
        SeekBarView seekBarView2 = this.intensitySeekBar;
        if (seekBarView2 != null) {
            seekBarView2.setProgress(this.currentIntensity);
        }
        Theme.resetCustomWallpaper(true);
        selectColorType(2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$selectColorType$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$selectColorType$17$ThemePreviewActivity(DialogInterface dialogInterface, int i) {
        Theme.ThemeAccent themeAccent = this.accent;
        if (themeAccent.backgroundOverrideColor == 4294967296L) {
            themeAccent.backgroundOverrideColor = 0L;
            themeAccent.backgroundGradientOverrideColor1 = 0L;
            themeAccent.backgroundGradientOverrideColor2 = 0L;
            themeAccent.backgroundGradientOverrideColor3 = 0L;
            updatePlayAnimationView(false);
            Theme.refreshThemeColors();
        }
        this.removeBackgroundOverride = true;
        Theme.resetCustomWallpaper(true);
        selectColorType(2, false);
    }

    private void selectPattern(int position) {
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper;
        if (position >= 0 && position < this.patterns.size()) {
            tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) this.patterns.get(position);
        } else {
            tLRPC$TL_wallPaper = this.lastSelectedPattern;
        }
        if (tLRPC$TL_wallPaper == null) {
            return;
        }
        this.backgroundImage.setImage(ImageLocation.getForDocument(tLRPC$TL_wallPaper.document), this.imageFilter, null, null, "jpg", tLRPC$TL_wallPaper.document.size, 1, tLRPC$TL_wallPaper);
        this.selectedPattern = tLRPC$TL_wallPaper;
        this.isMotion = this.backgroundCheckBoxView[2].isChecked();
        updateButtonState(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAccentWallpaper() {
        Theme.ThemeAccent themeAccent = this.accent;
        if (themeAccent == null || TextUtils.isEmpty(themeAccent.patternSlug)) {
            return;
        }
        try {
            File pathToWallpaper = this.accent.getPathToWallpaper();
            Drawable background = this.backgroundImage.getBackground();
            Bitmap bitmap = this.backgroundImage.getImageReceiver().getBitmap();
            FileOutputStream fileOutputStream = new FileOutputStream(pathToWallpaper);
            bitmap.compress(background instanceof MotionBackgroundDrawable ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 87, fileOutputStream);
            fileOutputStream.close();
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    private boolean hasChanges(int type) {
        int defaultAccentColor;
        long j;
        if (this.editingTheme) {
            return false;
        }
        if (type == 1 || type == 2) {
            long j2 = this.backupBackgroundOverrideColor;
            if (j2 == 0) {
                int defaultAccentColor2 = Theme.getDefaultAccentColor("chat_wallpaper");
                int i = (int) this.accent.backgroundOverrideColor;
                if (i == 0) {
                    i = defaultAccentColor2;
                }
                if (i != defaultAccentColor2) {
                    return true;
                }
            } else if (j2 != this.accent.backgroundOverrideColor) {
                return true;
            }
            long j3 = this.backupBackgroundGradientOverrideColor1;
            if (j3 == 0 && this.backupBackgroundGradientOverrideColor2 == 0 && this.backupBackgroundGradientOverrideColor3 == 0) {
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i2 == 0) {
                        defaultAccentColor = Theme.getDefaultAccentColor("chat_wallpaper_gradient_to");
                        j = this.accent.backgroundGradientOverrideColor1;
                    } else if (i2 == 1) {
                        defaultAccentColor = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to2");
                        j = this.accent.backgroundGradientOverrideColor2;
                    } else {
                        defaultAccentColor = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to3");
                        j = this.accent.backgroundGradientOverrideColor3;
                    }
                    int i3 = (int) j;
                    if (i3 == 0 && j != 0) {
                        i3 = 0;
                    } else if (i3 == 0) {
                        i3 = defaultAccentColor;
                    }
                    if (i3 != defaultAccentColor) {
                        return true;
                    }
                }
            } else {
                Theme.ThemeAccent themeAccent = this.accent;
                if (j3 != themeAccent.backgroundGradientOverrideColor1 || this.backupBackgroundGradientOverrideColor2 != themeAccent.backgroundGradientOverrideColor2 || this.backupBackgroundGradientOverrideColor3 != themeAccent.backgroundGradientOverrideColor3) {
                    return true;
                }
            }
            if (this.accent.backgroundRotation != this.backupBackgroundRotation) {
                return true;
            }
        }
        if (type == 1 || type == 3) {
            int i4 = this.backupAccentColor;
            Theme.ThemeAccent themeAccent2 = this.accent;
            if (i4 != themeAccent2.accentColor2) {
                return true;
            }
            int i5 = this.backupMyMessagesAccentColor;
            if (i5 != 0) {
                if (i5 != themeAccent2.myMessagesAccentColor) {
                    return true;
                }
            } else {
                int i6 = themeAccent2.myMessagesAccentColor;
                if (i6 != 0 && i6 != themeAccent2.accentColor) {
                    return true;
                }
            }
            int i7 = this.backupMyMessagesGradientAccentColor1;
            if (i7 != 0) {
                if (i7 != themeAccent2.myMessagesGradientAccentColor1) {
                    return true;
                }
            } else if (themeAccent2.myMessagesGradientAccentColor1 != 0) {
                return true;
            }
            int i8 = this.backupMyMessagesGradientAccentColor2;
            if (i8 != 0) {
                if (i8 != themeAccent2.myMessagesGradientAccentColor2) {
                    return true;
                }
            } else if (themeAccent2.myMessagesGradientAccentColor2 != 0) {
                return true;
            }
            int i9 = this.backupMyMessagesGradientAccentColor3;
            if (i9 != 0) {
                if (i9 != themeAccent2.myMessagesGradientAccentColor3) {
                    return true;
                }
            } else if (themeAccent2.myMessagesGradientAccentColor3 != 0) {
                return true;
            }
            if (this.backupMyMessagesAnimated != themeAccent2.myMessagesAnimated) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
    
        if (r7.accent.patternIntensity == r7.currentIntensity) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean checkDiscard() {
        /*
            r7 = this;
            int r0 = r7.screenType
            r1 = 1
            if (r0 != r1) goto Lde
            ir.eitaa.ui.ActionBar.Theme$ThemeAccent r0 = r7.accent
            int r2 = r0.accentColor
            int r3 = r7.backupAccentColor
            if (r2 != r3) goto L92
            int r2 = r0.accentColor2
            int r3 = r7.backupAccentColor2
            if (r2 != r3) goto L92
            int r2 = r0.myMessagesAccentColor
            int r3 = r7.backupMyMessagesAccentColor
            if (r2 != r3) goto L92
            int r2 = r0.myMessagesGradientAccentColor1
            int r3 = r7.backupMyMessagesGradientAccentColor1
            if (r2 != r3) goto L92
            int r2 = r0.myMessagesGradientAccentColor2
            int r3 = r7.backupMyMessagesGradientAccentColor2
            if (r2 != r3) goto L92
            int r2 = r0.myMessagesGradientAccentColor3
            int r3 = r7.backupMyMessagesGradientAccentColor3
            if (r2 != r3) goto L92
            boolean r2 = r0.myMessagesAnimated
            boolean r3 = r7.backupMyMessagesAnimated
            if (r2 != r3) goto L92
            long r2 = r0.backgroundOverrideColor
            long r4 = r7.backupBackgroundOverrideColor
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L92
            long r2 = r0.backgroundGradientOverrideColor1
            long r4 = r7.backupBackgroundGradientOverrideColor1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L92
            long r2 = r0.backgroundGradientOverrideColor2
            long r4 = r7.backupBackgroundGradientOverrideColor2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L92
            long r2 = r0.backgroundGradientOverrideColor3
            long r4 = r7.backupBackgroundGradientOverrideColor3
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L92
            float r0 = r0.patternIntensity
            float r2 = r7.backupIntensity
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            r2 = 981668463(0x3a83126f, float:0.001)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L92
            ir.eitaa.ui.ActionBar.Theme$ThemeAccent r0 = r7.accent
            int r2 = r0.backgroundRotation
            int r3 = r7.backupBackgroundRotation
            if (r2 != r3) goto L92
            java.lang.String r0 = r0.patternSlug
            ir.eitaa.tgnet.TLRPC$TL_wallPaper r2 = r7.selectedPattern
            if (r2 == 0) goto L72
            java.lang.String r2 = r2.slug
            goto L74
        L72:
            java.lang.String r2 = ""
        L74:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L92
            ir.eitaa.tgnet.TLRPC$TL_wallPaper r0 = r7.selectedPattern
            if (r0 == 0) goto L86
            ir.eitaa.ui.ActionBar.Theme$ThemeAccent r2 = r7.accent
            boolean r2 = r2.patternMotion
            boolean r3 = r7.isMotion
            if (r2 != r3) goto L92
        L86:
            if (r0 == 0) goto Lde
            ir.eitaa.ui.ActionBar.Theme$ThemeAccent r0 = r7.accent
            float r0 = r0.patternIntensity
            float r2 = r7.currentIntensity
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lde
        L92:
            ir.eitaa.ui.ActionBar.AlertDialog$Builder r0 = new ir.eitaa.ui.ActionBar.AlertDialog$Builder
            android.app.Activity r1 = r7.getParentActivity()
            r0.<init>(r1)
            r1 = 2131693897(0x7f0f1149, float:1.9016935E38)
            java.lang.String r2 = "SaveChangesAlertTitle"
            java.lang.String r1 = ir.eitaa.messenger.LocaleController.getString(r2, r1)
            r0.setTitle(r1)
            r1 = 2131693896(0x7f0f1148, float:1.9016933E38)
            java.lang.String r2 = "SaveChangesAlertText"
            java.lang.String r1 = ir.eitaa.messenger.LocaleController.getString(r2, r1)
            r0.setMessage(r1)
            r1 = 2131693895(0x7f0f1147, float:1.9016931E38)
            java.lang.String r2 = "Save"
            java.lang.String r1 = ir.eitaa.messenger.LocaleController.getString(r2, r1)
            ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$ZO7byJxQ4ZwDgnEH8D0gD4hto9I r2 = new ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$ZO7byJxQ4ZwDgnEH8D0gD4hto9I
            r2.<init>()
            r0.setPositiveButton(r1, r2)
            r1 = 2131693004(0x7f0f0dcc, float:1.9015124E38)
            java.lang.String r2 = "PassportDiscard"
            java.lang.String r1 = ir.eitaa.messenger.LocaleController.getString(r2, r1)
            ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$ypYNnZ7Y3mTrvDjNCxVtfjV7PQc r2 = new ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$ypYNnZ7Y3mTrvDjNCxVtfjV7PQc
            r2.<init>()
            r0.setNegativeButton(r1, r2)
            ir.eitaa.ui.ActionBar.AlertDialog r0 = r0.create()
            r7.showDialog(r0)
            r0 = 0
            return r0
        Lde:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ThemePreviewActivity.checkDiscard():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$18$ThemePreviewActivity(DialogInterface dialogInterface, int i) {
        this.actionBar2.getActionBarMenuOnItemClick().onItemClick(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$19$ThemePreviewActivity(DialogInterface dialogInterface, int i) {
        cancelThemeApply(false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.invalidateMotionBackground);
        int i = this.screenType;
        if (i == 1 || i == 0) {
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didSetNewWallpapper);
        }
        int i2 = this.screenType;
        if (i2 == 2 || i2 == 1) {
            Theme.setChangingWallpaper(true);
        }
        if (this.screenType != 0 || this.accent != null) {
            if (SharedConfig.getDevicePerformanceClass() == 0) {
                Point point = AndroidUtilities.displaySize;
                int iMin = Math.min(point.x, point.y);
                Point point2 = AndroidUtilities.displaySize;
                this.imageFilter = ((int) (iMin / AndroidUtilities.density)) + "_" + ((int) (Math.max(point2.x, point2.y) / AndroidUtilities.density)) + "_f";
            } else {
                this.imageFilter = ((int) (1080.0f / AndroidUtilities.density)) + "_" + ((int) (1920.0f / AndroidUtilities.density)) + "_f";
            }
            Point point3 = AndroidUtilities.displaySize;
            this.maxWallpaperSize = Math.min(1920, Math.max(point3.x, point3.y));
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.wallpapersNeedReload);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.wallpapersDidLoad);
            this.TAG = DownloadController.getInstance(this.currentAccount).generateObserverTag();
            if (this.patterns == null) {
                this.patterns = new ArrayList<>();
                MessagesStorage.getInstance(this.currentAccount).getWallpapers();
            }
        } else {
            this.isMotion = Theme.isWallpaperMotion();
        }
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.invalidateMotionBackground);
        FrameLayout frameLayout = this.frameLayout;
        if (frameLayout != null && this.onGlobalLayoutListener != null) {
            frameLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
        int i = this.screenType;
        if (i == 2 || i == 1) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$VuAGr6b-Q3IJZe9zKZEsBYh_LrY
                @Override // java.lang.Runnable
                public final void run() {
                    Theme.setChangingWallpaper(false);
                }
            });
        }
        int i2 = this.screenType;
        if (i2 == 2) {
            Bitmap bitmap = this.blurredBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.blurredBitmap = null;
            }
            Theme.applyChatServiceMessageColor();
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetNewWallpapper, new Object[0]);
        } else if (i2 == 1 || i2 == 0) {
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetNewWallpapper);
        }
        if (this.screenType != 0 || this.accent != null) {
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.wallpapersNeedReload);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.wallpapersDidLoad);
        }
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationStart(boolean isOpen, boolean backward) {
        super.onTransitionAnimationStart(isOpen, backward);
        if (isOpen || this.screenType != 2) {
            return;
        }
        Theme.applyChatServiceMessageColor();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetNewWallpapper, new Object[0]);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        DialogsAdapter dialogsAdapter = this.dialogsAdapter;
        if (dialogsAdapter != null) {
            dialogsAdapter.notifyDataSetChanged();
        }
        MessagesAdapter messagesAdapter = this.messagesAdapter;
        if (messagesAdapter != null) {
            messagesAdapter.notifyDataSetChanged();
        }
        if (this.isMotion) {
            this.parallaxEffect.setEnabled(true);
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        if (this.isMotion) {
            this.parallaxEffect.setEnabled(false);
        }
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String fileName, boolean canceled) {
        updateButtonState(true, canceled);
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onSuccessDownload(String fileName) {
        RadialProgress2 radialProgress2 = this.radialProgress;
        if (radialProgress2 != null) {
            radialProgress2.setProgress(1.0f, this.progressVisible);
        }
        updateButtonState(false, true);
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressDownload(String fileName, long downloadedSize, long totalSize) {
        RadialProgress2 radialProgress2 = this.radialProgress;
        if (radialProgress2 != null) {
            radialProgress2.setProgress(Math.min(1.0f, downloadedSize / totalSize), this.progressVisible);
            if (this.radialProgress.getIcon() != 10) {
                updateButtonState(false, true);
            }
        }
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public int getObserverTag() {
        return this.TAG;
    }

    private void updateBlurred() throws InterruptedException {
        if (this.isBlurred && this.blurredBitmap == null) {
            Bitmap bitmap = this.currentWallpaperBitmap;
            if (bitmap != null) {
                this.originalBitmap = bitmap;
                this.blurredBitmap = Utilities.blurWallpaper(bitmap);
            } else {
                ImageReceiver imageReceiver = this.backgroundImage.getImageReceiver();
                if (imageReceiver.hasNotThumb() || imageReceiver.hasStaticThumb()) {
                    this.originalBitmap = imageReceiver.getBitmap();
                    this.blurredBitmap = Utilities.blurWallpaper(imageReceiver.getBitmap());
                }
            }
        }
        if (this.isBlurred) {
            Bitmap bitmap2 = this.blurredBitmap;
            if (bitmap2 != null) {
                this.backgroundImage.setImageBitmap(bitmap2);
                return;
            }
            return;
        }
        setCurrentImage(false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (!checkDiscard()) {
            return false;
        }
        cancelThemeApply(true);
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) throws InterruptedException {
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper;
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper2;
        if (id == NotificationCenter.emojiLoaded) {
            RecyclerListView recyclerListView = this.listView;
            if (recyclerListView == null) {
                return;
            }
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof DialogCell) {
                    ((DialogCell) childAt).update(0);
                }
            }
            return;
        }
        if (id == NotificationCenter.invalidateMotionBackground) {
            RecyclerListView recyclerListView2 = this.listView2;
            if (recyclerListView2 != null) {
                recyclerListView2.invalidateViews();
                return;
            }
            return;
        }
        if (id == NotificationCenter.didSetNewWallpapper) {
            if (this.page2 != null) {
                setCurrentImage(true);
                return;
            }
            return;
        }
        if (id == NotificationCenter.wallpapersNeedReload) {
            Object obj = this.currentWallpaper;
            if (obj instanceof WallpapersListActivity.FileWallpaper) {
                WallpapersListActivity.FileWallpaper fileWallpaper = (WallpapersListActivity.FileWallpaper) obj;
                if (fileWallpaper.slug == null) {
                    fileWallpaper.slug = (String) args[0];
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.wallpapersDidLoad) {
            ArrayList arrayList = (ArrayList) args[0];
            this.patterns.clear();
            this.patternsDict.clear();
            int size = arrayList.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                TLRPC$WallPaper tLRPC$WallPaper = (TLRPC$WallPaper) arrayList.get(i2);
                if ((tLRPC$WallPaper instanceof TLRPC$TL_wallPaper) && tLRPC$WallPaper.pattern) {
                    TLRPC$Document tLRPC$Document = tLRPC$WallPaper.document;
                    if (tLRPC$Document != null && !this.patternsDict.containsKey(Long.valueOf(tLRPC$Document.id))) {
                        this.patterns.add(tLRPC$WallPaper);
                        this.patternsDict.put(Long.valueOf(tLRPC$WallPaper.document.id), tLRPC$WallPaper);
                    }
                    Theme.ThemeAccent themeAccent = this.accent;
                    if (themeAccent != null && themeAccent.patternSlug.equals(tLRPC$WallPaper.slug)) {
                        this.selectedPattern = (TLRPC$TL_wallPaper) tLRPC$WallPaper;
                        setCurrentImage(false);
                        updateButtonState(false, false);
                    } else if (this.accent != null || (tLRPC$TL_wallPaper2 = this.selectedPattern) == null || !tLRPC$TL_wallPaper2.slug.equals(tLRPC$WallPaper.slug)) {
                    }
                    z = true;
                }
            }
            if (!z && (tLRPC$TL_wallPaper = this.selectedPattern) != null) {
                this.patterns.add(0, tLRPC$TL_wallPaper);
            }
            PatternsAdapter patternsAdapter = this.patternsAdapter;
            if (patternsAdapter != null) {
                patternsAdapter.notifyDataSetChanged();
            }
            long jCalcHash = 0;
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                TLRPC$WallPaper tLRPC$WallPaper2 = (TLRPC$WallPaper) arrayList.get(i3);
                if (tLRPC$WallPaper2 instanceof TLRPC$TL_wallPaper) {
                    jCalcHash = MediaDataController.calcHash(jCalcHash, tLRPC$WallPaper2.id);
                }
            }
            TLRPC$TL_account_getWallPapers tLRPC$TL_account_getWallPapers = new TLRPC$TL_account_getWallPapers();
            tLRPC$TL_account_getWallPapers.hash = jCalcHash;
            ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_getWallPapers, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$a4zusPE773-hldlEzdkis87bzRA
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$didReceivedNotification$24$ThemePreviewActivity(tLObject, tLRPC$TL_error);
                }
            }), this.classGuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$24$ThemePreviewActivity(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$Wmsw5K9oZeZFv5CUP9L87z_FIbk
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$didReceivedNotification$23$ThemePreviewActivity(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$23$ThemePreviewActivity(TLObject tLObject) throws InterruptedException {
        Theme.ThemeAccent themeAccent;
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper;
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper2;
        if (tLObject instanceof TLRPC$TL_account_wallPapers) {
            TLRPC$TL_account_wallPapers tLRPC$TL_account_wallPapers = (TLRPC$TL_account_wallPapers) tLObject;
            this.patterns.clear();
            this.patternsDict.clear();
            int size = tLRPC$TL_account_wallPapers.wallpapers.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                if (tLRPC$TL_account_wallPapers.wallpapers.get(i) instanceof TLRPC$TL_wallPaper) {
                    TLRPC$TL_wallPaper tLRPC$TL_wallPaper3 = (TLRPC$TL_wallPaper) tLRPC$TL_account_wallPapers.wallpapers.get(i);
                    if (tLRPC$TL_wallPaper3.pattern) {
                        TLRPC$Document tLRPC$Document = tLRPC$TL_wallPaper3.document;
                        if (tLRPC$Document != null && !this.patternsDict.containsKey(Long.valueOf(tLRPC$Document.id))) {
                            this.patterns.add(tLRPC$TL_wallPaper3);
                            this.patternsDict.put(Long.valueOf(tLRPC$TL_wallPaper3.document.id), tLRPC$TL_wallPaper3);
                        }
                        Theme.ThemeAccent themeAccent2 = this.accent;
                        if (themeAccent2 != null && themeAccent2.patternSlug.equals(tLRPC$TL_wallPaper3.slug)) {
                            this.selectedPattern = tLRPC$TL_wallPaper3;
                            setCurrentImage(false);
                            updateButtonState(false, false);
                        } else if (this.accent != null || (tLRPC$TL_wallPaper2 = this.selectedPattern) == null || !tLRPC$TL_wallPaper2.slug.equals(tLRPC$TL_wallPaper3.slug)) {
                        }
                        z = true;
                    }
                }
            }
            if (!z && (tLRPC$TL_wallPaper = this.selectedPattern) != null) {
                this.patterns.add(0, tLRPC$TL_wallPaper);
            }
            PatternsAdapter patternsAdapter = this.patternsAdapter;
            if (patternsAdapter != null) {
                patternsAdapter.notifyDataSetChanged();
            }
            MessagesStorage.getInstance(this.currentAccount).putWallpapers(tLRPC$TL_account_wallPapers.wallpapers, 1);
        }
        if (this.selectedPattern != null || (themeAccent = this.accent) == null || TextUtils.isEmpty(themeAccent.patternSlug)) {
            return;
        }
        TLRPC$TL_account_getWallPaper tLRPC$TL_account_getWallPaper = new TLRPC$TL_account_getWallPaper();
        TLRPC$TL_inputWallPaperSlug tLRPC$TL_inputWallPaperSlug = new TLRPC$TL_inputWallPaperSlug();
        tLRPC$TL_inputWallPaperSlug.slug = this.accent.patternSlug;
        tLRPC$TL_account_getWallPaper.wallpaper = tLRPC$TL_inputWallPaperSlug;
        ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(getConnectionsManager().sendRequest(tLRPC$TL_account_getWallPaper, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$AtHR8bpSmcso_QAxKIVb5Ccng8o
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$didReceivedNotification$22$ThemePreviewActivity(tLObject2, tLRPC$TL_error);
            }
        }), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$22$ThemePreviewActivity(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$1WiHJbdyu62vpMePbwyjDVCMH_Y
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$didReceivedNotification$21$ThemePreviewActivity(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$21$ThemePreviewActivity(TLObject tLObject) throws InterruptedException {
        if (tLObject instanceof TLRPC$TL_wallPaper) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) tLObject;
            if (tLRPC$TL_wallPaper.pattern) {
                this.selectedPattern = tLRPC$TL_wallPaper;
                setCurrentImage(false);
                updateButtonState(false, false);
                this.patterns.add(0, this.selectedPattern);
                PatternsAdapter patternsAdapter = this.patternsAdapter;
                if (patternsAdapter != null) {
                    patternsAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelThemeApply(boolean back) {
        if (this.screenType == 2) {
            if (back) {
                return;
            }
            finishFragment();
            return;
        }
        Theme.applyPreviousTheme();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didSetNewWallpapper);
        if (this.screenType == 1) {
            if (this.editingTheme) {
                Theme.ThemeAccent themeAccent = this.accent;
                themeAccent.accentColor = this.backupAccentColor;
                themeAccent.accentColor2 = this.backupAccentColor2;
                themeAccent.myMessagesAccentColor = this.backupMyMessagesAccentColor;
                themeAccent.myMessagesGradientAccentColor1 = this.backupMyMessagesGradientAccentColor1;
                themeAccent.myMessagesGradientAccentColor2 = this.backupMyMessagesGradientAccentColor2;
                themeAccent.myMessagesGradientAccentColor3 = this.backupMyMessagesGradientAccentColor3;
                themeAccent.myMessagesAnimated = this.backupMyMessagesAnimated;
                themeAccent.backgroundOverrideColor = this.backupBackgroundOverrideColor;
                themeAccent.backgroundGradientOverrideColor1 = this.backupBackgroundGradientOverrideColor1;
                themeAccent.backgroundGradientOverrideColor2 = this.backupBackgroundGradientOverrideColor2;
                themeAccent.backgroundGradientOverrideColor3 = this.backupBackgroundGradientOverrideColor3;
                themeAccent.backgroundRotation = this.backupBackgroundRotation;
                themeAccent.patternSlug = this.backupSlug;
                themeAccent.patternIntensity = this.backupIntensity;
            }
            Theme.saveThemeAccents(this.applyingTheme, false, true, false, false);
        } else {
            if (this.accent != null) {
                Theme.saveThemeAccents(this.applyingTheme, false, this.deleteOnCancel, false, false);
            }
            this.parentLayout.rebuildAllFragmentViews(false, false);
            if (this.deleteOnCancel) {
                Theme.ThemeInfo themeInfo = this.applyingTheme;
                if (themeInfo.pathToFile != null && !Theme.isThemeInstalled(themeInfo)) {
                    new File(this.applyingTheme.pathToFile).delete();
                }
            }
        }
        if (back) {
            return;
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getButtonsColor(String key) {
        return this.useDefaultThemeForButtons ? Theme.getDefaultColor(key) : Theme.getColor(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleApplyColor(int color, int num, boolean applyNow) {
        if (num == -1) {
            int i = this.colorType;
            if (i == 1 || i == 2) {
                long j = this.backupBackgroundOverrideColor;
                if (j != 0) {
                    this.accent.backgroundOverrideColor = j;
                } else {
                    this.accent.backgroundOverrideColor = 0L;
                }
                long j2 = this.backupBackgroundGradientOverrideColor1;
                if (j2 != 0) {
                    this.accent.backgroundGradientOverrideColor1 = j2;
                } else {
                    this.accent.backgroundGradientOverrideColor1 = 0L;
                }
                long j3 = this.backupBackgroundGradientOverrideColor2;
                if (j3 != 0) {
                    this.accent.backgroundGradientOverrideColor2 = j3;
                } else {
                    this.accent.backgroundGradientOverrideColor2 = 0L;
                }
                long j4 = this.backupBackgroundGradientOverrideColor3;
                if (j4 != 0) {
                    this.accent.backgroundGradientOverrideColor3 = j4;
                } else {
                    this.accent.backgroundGradientOverrideColor3 = 0L;
                }
                this.accent.backgroundRotation = this.backupBackgroundRotation;
                if (i == 2) {
                    int defaultAccentColor = Theme.getDefaultAccentColor("chat_wallpaper");
                    int defaultAccentColor2 = Theme.getDefaultAccentColor("chat_wallpaper_gradient_to");
                    int defaultAccentColor3 = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to2");
                    int defaultAccentColor4 = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to3");
                    Theme.ThemeAccent themeAccent = this.accent;
                    int i2 = (int) themeAccent.backgroundGradientOverrideColor1;
                    int i3 = (int) themeAccent.backgroundGradientOverrideColor2;
                    int i4 = (int) themeAccent.backgroundGradientOverrideColor3;
                    int i5 = (int) themeAccent.backgroundOverrideColor;
                    ColorPicker colorPicker = this.colorPicker;
                    if (i4 != 0) {
                        defaultAccentColor4 = i4;
                    }
                    colorPicker.setColor(defaultAccentColor4, 3);
                    ColorPicker colorPicker2 = this.colorPicker;
                    if (i3 != 0) {
                        defaultAccentColor3 = i3;
                    }
                    colorPicker2.setColor(defaultAccentColor3, 2);
                    ColorPicker colorPicker3 = this.colorPicker;
                    if (i2 != 0) {
                        defaultAccentColor2 = i2;
                    }
                    colorPicker3.setColor(defaultAccentColor2, 1);
                    ColorPicker colorPicker4 = this.colorPicker;
                    if (i5 != 0) {
                        defaultAccentColor = i5;
                    }
                    colorPicker4.setColor(defaultAccentColor, 0);
                }
            }
            int i6 = this.colorType;
            if (i6 == 1 || i6 == 3) {
                int i7 = this.backupMyMessagesAccentColor;
                if (i7 != 0) {
                    this.accent.myMessagesAccentColor = i7;
                } else {
                    this.accent.myMessagesAccentColor = 0;
                }
                int i8 = this.backupMyMessagesGradientAccentColor1;
                if (i8 != 0) {
                    this.accent.myMessagesGradientAccentColor1 = i8;
                } else {
                    this.accent.myMessagesGradientAccentColor1 = 0;
                }
                int i9 = this.backupMyMessagesGradientAccentColor2;
                if (i9 != 0) {
                    this.accent.myMessagesGradientAccentColor2 = i9;
                } else {
                    this.accent.myMessagesGradientAccentColor2 = 0;
                }
                int i10 = this.backupMyMessagesGradientAccentColor3;
                if (i10 != 0) {
                    this.accent.myMessagesGradientAccentColor3 = i10;
                } else {
                    this.accent.myMessagesGradientAccentColor3 = 0;
                }
                if (i6 == 3) {
                    this.colorPicker.setColor(this.accent.myMessagesGradientAccentColor3, 3);
                    this.colorPicker.setColor(this.accent.myMessagesGradientAccentColor2, 2);
                    this.colorPicker.setColor(this.accent.myMessagesGradientAccentColor1, 1);
                    ColorPicker colorPicker5 = this.colorPicker;
                    Theme.ThemeAccent themeAccent2 = this.accent;
                    int i11 = themeAccent2.myMessagesAccentColor;
                    if (i11 == 0) {
                        i11 = themeAccent2.accentColor;
                    }
                    colorPicker5.setColor(i11, 0);
                }
            }
            Theme.refreshThemeColors();
            this.listView2.invalidateViews();
            return;
        }
        int i12 = this.lastPickedColorNum;
        if (i12 != -1 && i12 != num) {
            this.applyColorAction.run();
        }
        this.lastPickedColor = color;
        this.lastPickedColorNum = num;
        if (applyNow) {
            this.applyColorAction.run();
        } else {
            if (this.applyColorScheduled) {
                return;
            }
            this.applyColorScheduled = true;
            this.fragmentView.postDelayed(this.applyColorAction, 16L);
        }
    }

    private void applyColor(int color, int num) throws NoSuchFieldException {
        int i = this.colorType;
        if (i == 1) {
            if (num == 0) {
                this.accent.accentColor = color;
                Theme.refreshThemeColors();
            } else if (num == 1) {
                this.accent.accentColor2 = color;
                Theme.refreshThemeColors(true, true);
                this.listView2.invalidateViews();
                this.colorPicker.setHasChanges(hasChanges(this.colorType));
                updatePlayAnimationView(true);
            }
        } else if (i == 2) {
            if (this.lastPickedColorNum == 0) {
                this.accent.backgroundOverrideColor = color;
            } else if (num == 1) {
                int defaultAccentColor = Theme.getDefaultAccentColor("chat_wallpaper_gradient_to");
                if (color == 0 && defaultAccentColor != 0) {
                    this.accent.backgroundGradientOverrideColor1 = 4294967296L;
                } else {
                    this.accent.backgroundGradientOverrideColor1 = color;
                }
            } else if (num == 2) {
                int defaultAccentColor2 = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to2");
                if (color == 0 && defaultAccentColor2 != 0) {
                    this.accent.backgroundGradientOverrideColor2 = 4294967296L;
                } else {
                    this.accent.backgroundGradientOverrideColor2 = color;
                }
            } else if (num == 3) {
                int defaultAccentColor3 = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to3");
                if (color == 0 && defaultAccentColor3 != 0) {
                    this.accent.backgroundGradientOverrideColor3 = 4294967296L;
                } else {
                    this.accent.backgroundGradientOverrideColor3 = color;
                }
            }
            Theme.refreshThemeColors(true, false);
            this.colorPicker.setHasChanges(hasChanges(this.colorType));
            updatePlayAnimationView(true);
        } else if (i == 3) {
            int i2 = this.lastPickedColorNum;
            if (i2 == 0) {
                this.accent.myMessagesAccentColor = color;
            } else if (i2 == 1) {
                this.accent.myMessagesGradientAccentColor1 = color;
            } else if (i2 == 2) {
                Theme.ThemeAccent themeAccent = this.accent;
                int i3 = themeAccent.myMessagesGradientAccentColor2;
                themeAccent.myMessagesGradientAccentColor2 = color;
                if (i3 != 0 && color == 0) {
                    this.messagesAdapter.notifyItemRemoved(0);
                } else if (i3 == 0 && color != 0) {
                    this.messagesAdapter.notifyItemInserted(0);
                    showAnimationHint();
                }
            } else {
                this.accent.myMessagesGradientAccentColor3 = color;
            }
            int i4 = this.lastPickedColorNum;
            if (i4 >= 0) {
                this.messagesCheckBoxView[1].setColor(i4, color);
            }
            Theme.refreshThemeColors(true, true);
            this.listView2.invalidateViews();
            this.colorPicker.setHasChanges(hasChanges(this.colorType));
            updatePlayAnimationView(true);
        }
        int size = this.themeDescriptions.size();
        for (int i5 = 0; i5 < size; i5++) {
            ThemeDescription themeDescription = this.themeDescriptions.get(i5);
            themeDescription.setColor(Theme.getColor(themeDescription.getCurrentKey()), false, false);
        }
        this.listView.invalidateViews();
        this.listView2.invalidateViews();
        View view = this.dotsContainer;
        if (view != null) {
            view.invalidate();
        }
    }

    private void updateButtonState(boolean ifSame, boolean animated) {
        File httpFilePath;
        String name;
        int i;
        File pathToAttach;
        String attachFileName;
        FrameLayout frameLayout;
        Object obj = this.selectedPattern;
        if (obj == null) {
            obj = this.currentWallpaper;
        }
        boolean z = obj instanceof TLRPC$TL_wallPaper;
        if (z || (obj instanceof MediaController.SearchImage)) {
            if (animated && !this.progressVisible) {
                animated = false;
            }
            if (z) {
                TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) obj;
                attachFileName = FileLoader.getAttachFileName(tLRPC$TL_wallPaper.document);
                if (TextUtils.isEmpty(attachFileName)) {
                    return;
                }
                pathToAttach = FileLoader.getPathToAttach(tLRPC$TL_wallPaper.document, true);
                i = tLRPC$TL_wallPaper.document.size;
            } else {
                MediaController.SearchImage searchImage = (MediaController.SearchImage) obj;
                TLRPC$Photo tLRPC$Photo = searchImage.photo;
                if (tLRPC$Photo != null) {
                    TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, this.maxWallpaperSize, true);
                    httpFilePath = FileLoader.getPathToAttach(closestPhotoSizeWithSize, true);
                    name = FileLoader.getAttachFileName(closestPhotoSizeWithSize);
                    i = closestPhotoSizeWithSize.size;
                } else {
                    httpFilePath = ImageLoader.getHttpFilePath(searchImage.imageUrl, "jpg");
                    name = httpFilePath.getName();
                    i = searchImage.size;
                }
                String str = name;
                pathToAttach = httpFilePath;
                attachFileName = str;
                if (TextUtils.isEmpty(attachFileName)) {
                    return;
                }
            }
            boolean zExists = pathToAttach.exists();
            if (zExists) {
                DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
                RadialProgress2 radialProgress2 = this.radialProgress;
                if (radialProgress2 != null) {
                    radialProgress2.setProgress(1.0f, animated);
                    this.radialProgress.setIcon(4, ifSame, animated);
                }
                this.backgroundImage.invalidate();
                if (this.screenType == 2) {
                    if (i != 0) {
                        this.actionBar2.setSubtitle(AndroidUtilities.formatFileSize(i));
                    } else {
                        this.actionBar2.setSubtitle(null);
                    }
                }
            } else {
                DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(attachFileName, null, this);
                if (this.radialProgress != null) {
                    FileLoader.getInstance(this.currentAccount).isLoadingFile(attachFileName);
                    Float fileProgress = ImageLoader.getInstance().getFileProgress(attachFileName);
                    if (fileProgress != null) {
                        this.radialProgress.setProgress(fileProgress.floatValue(), animated);
                    } else {
                        this.radialProgress.setProgress(0.0f, animated);
                    }
                    this.radialProgress.setIcon(10, ifSame, animated);
                }
                if (this.screenType == 2) {
                    this.actionBar2.setSubtitle(LocaleController.getString("LoadingFullImage", R.string.LoadingFullImage));
                }
                this.backgroundImage.invalidate();
            }
            if (this.selectedPattern == null && (frameLayout = this.backgroundButtonsContainer) != null) {
                frameLayout.setAlpha(zExists ? 1.0f : 0.5f);
            }
            int i2 = this.screenType;
            if (i2 == 0) {
                this.doneButton.setEnabled(zExists);
                this.doneButton.setAlpha(zExists ? 1.0f : 0.5f);
                return;
            } else if (i2 == 2) {
                this.bottomOverlayChat.setEnabled(zExists);
                this.bottomOverlayChatText.setAlpha(zExists ? 1.0f : 0.5f);
                return;
            } else {
                this.saveItem.setEnabled(zExists);
                this.saveItem.setAlpha(zExists ? 1.0f : 0.5f);
                return;
            }
        }
        RadialProgress2 radialProgress22 = this.radialProgress;
        if (radialProgress22 != null) {
            radialProgress22.setIcon(4, ifSame, animated);
        }
    }

    public void setDelegate(WallpaperActivityDelegate wallpaperActivityDelegate) {
        this.delegate = wallpaperActivityDelegate;
    }

    public void setPatterns(ArrayList<Object> arrayList) {
        this.patterns = arrayList;
        if (this.screenType == 1 || (this.currentWallpaper instanceof WallpapersListActivity.ColorWallpaper)) {
            WallpapersListActivity.ColorWallpaper colorWallpaper = (WallpapersListActivity.ColorWallpaper) this.currentWallpaper;
            if (colorWallpaper.patternId != 0) {
                int i = 0;
                int size = arrayList.size();
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) this.patterns.get(i);
                    if (tLRPC$TL_wallPaper.id == colorWallpaper.patternId) {
                        this.selectedPattern = tLRPC$TL_wallPaper;
                        break;
                    }
                    i++;
                }
                this.currentIntensity = colorWallpaper.intensity;
            }
        }
    }

    private void showAnimationHint() {
        if (this.page2 == null || this.messagesCheckBoxView == null || this.accent.myMessagesGradientAccentColor2 == 0) {
            return;
        }
        final SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        if (globalMainSettings.getBoolean("bganimationhint", false)) {
            return;
        }
        if (this.animationHint == null) {
            HintView hintView = new HintView(getParentActivity(), 8);
            this.animationHint = hintView;
            hintView.setShowingDuration(5000L);
            this.animationHint.setAlpha(0.0f);
            this.animationHint.setVisibility(4);
            this.animationHint.setText(LocaleController.getString("BackgroundAnimateInfo", R.string.BackgroundAnimateInfo));
            this.animationHint.setExtraTranslationY(AndroidUtilities.dp(6.0f));
            this.frameLayout.addView(this.animationHint, LayoutHelper.createFrame(-2, -2.0f, 51, 10.0f, 0.0f, 10.0f, 0.0f));
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$zFQSAbHTfDKmSQNLDwf2Z1eRlmY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showAnimationHint$25$ThemePreviewActivity(globalMainSettings);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showAnimationHint$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showAnimationHint$25$ThemePreviewActivity(SharedPreferences sharedPreferences) {
        if (this.colorType != 3) {
            return;
        }
        sharedPreferences.edit().putBoolean("bganimationhint", true).commit();
        this.animationHint.showForView(this.messagesCheckBoxView[0], true);
    }

    private void updateSelectedPattern(boolean animated) {
        int childCount = this.patternsListView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.patternsListView.getChildAt(i);
            if (childAt instanceof PatternCell) {
                ((PatternCell) childAt).updateSelected(animated);
            }
        }
    }

    private void updateMotionButton() {
        int i = this.screenType;
        if (i == 1 || i == 2) {
            if (this.selectedPattern == null && (this.currentWallpaper instanceof WallpapersListActivity.ColorWallpaper)) {
                this.backgroundCheckBoxView[2].setChecked(false, true);
            }
            this.backgroundCheckBoxView[this.selectedPattern != null ? (char) 2 : (char) 0].setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            Animator[] animatorArr = new Animator[2];
            WallpaperCheckBoxView wallpaperCheckBoxView = this.backgroundCheckBoxView[2];
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = this.selectedPattern != null ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(wallpaperCheckBoxView, (Property<WallpaperCheckBoxView, Float>) property, fArr);
            WallpaperCheckBoxView wallpaperCheckBoxView2 = this.backgroundCheckBoxView[0];
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[1];
            fArr2[0] = this.selectedPattern != null ? 0.0f : 1.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(wallpaperCheckBoxView2, (Property<WallpaperCheckBoxView, Float>) property2, fArr2);
            animatorSet.playTogether(animatorArr);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ThemePreviewActivity.27
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ThemePreviewActivity.this.backgroundCheckBoxView[ThemePreviewActivity.this.selectedPattern != null ? (char) 0 : (char) 2].setVisibility(4);
                }
            });
            animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            animatorSet.setDuration(200L);
            animatorSet.start();
            return;
        }
        boolean zIsEnabled = this.backgroundCheckBoxView[0].isEnabled();
        TLRPC$TL_wallPaper tLRPC$TL_wallPaper = this.selectedPattern;
        if (zIsEnabled == (tLRPC$TL_wallPaper != null)) {
            return;
        }
        if (tLRPC$TL_wallPaper == null) {
            this.backgroundCheckBoxView[0].setChecked(false, true);
        }
        this.backgroundCheckBoxView[0].setEnabled(this.selectedPattern != null);
        if (this.selectedPattern != null) {
            this.backgroundCheckBoxView[0].setVisibility(0);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.backgroundCheckBoxView[1].getLayoutParams();
        AnimatorSet animatorSet2 = new AnimatorSet();
        int iDp = (layoutParams.width + AndroidUtilities.dp(9.0f)) / 2;
        Animator[] animatorArr2 = new Animator[1];
        WallpaperCheckBoxView wallpaperCheckBoxView3 = this.backgroundCheckBoxView[0];
        Property property3 = View.ALPHA;
        float[] fArr3 = new float[1];
        fArr3[0] = this.selectedPattern == null ? 0.0f : 1.0f;
        animatorArr2[0] = ObjectAnimator.ofFloat(wallpaperCheckBoxView3, (Property<WallpaperCheckBoxView, Float>) property3, fArr3);
        animatorSet2.playTogether(animatorArr2);
        Animator[] animatorArr3 = new Animator[1];
        WallpaperCheckBoxView wallpaperCheckBoxView4 = this.backgroundCheckBoxView[0];
        Property property4 = View.TRANSLATION_X;
        float[] fArr4 = new float[1];
        fArr4[0] = this.selectedPattern != null ? 0.0f : iDp;
        animatorArr3[0] = ObjectAnimator.ofFloat(wallpaperCheckBoxView4, (Property<WallpaperCheckBoxView, Float>) property4, fArr4);
        animatorSet2.playTogether(animatorArr3);
        Animator[] animatorArr4 = new Animator[1];
        WallpaperCheckBoxView wallpaperCheckBoxView5 = this.backgroundCheckBoxView[1];
        Property property5 = View.TRANSLATION_X;
        float[] fArr5 = new float[1];
        fArr5[0] = this.selectedPattern == null ? -iDp : 0.0f;
        animatorArr4[0] = ObjectAnimator.ofFloat(wallpaperCheckBoxView5, (Property<WallpaperCheckBoxView, Float>) property5, fArr5);
        animatorSet2.playTogether(animatorArr4);
        animatorSet2.setInterpolator(CubicBezierInterpolator.EASE_OUT);
        animatorSet2.setDuration(200L);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ThemePreviewActivity.28
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ThemePreviewActivity.this.selectedPattern == null) {
                    ThemePreviewActivity.this.backgroundCheckBoxView[0].setVisibility(4);
                }
            }
        });
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPatternsView(final int num, final boolean show, boolean animated) {
        int iIndexOf;
        final boolean z = show && num == 1 && this.selectedPattern != null;
        if (show) {
            if (num == 0) {
                if (this.screenType == 2) {
                    this.previousBackgroundColor = this.backgroundColor;
                    int i = this.backgroundGradientColor1;
                    this.previousBackgroundGradientColor1 = i;
                    int i2 = this.backgroundGradientColor2;
                    this.previousBackgroundGradientColor2 = i2;
                    int i3 = this.backgroundGradientColor3;
                    this.previousBackgroundGradientColor3 = i3;
                    int i4 = this.backupBackgroundRotation;
                    this.previousBackgroundRotation = i4;
                    this.colorPicker.setType(0, false, 4, i3 != 0 ? 4 : i2 != 0 ? 3 : i != 0 ? 2 : 1, false, i4, false);
                    this.colorPicker.setColor(this.backgroundGradientColor3, 3);
                    this.colorPicker.setColor(this.backgroundGradientColor2, 2);
                    this.colorPicker.setColor(this.backgroundGradientColor1, 1);
                    this.colorPicker.setColor(this.backgroundColor, 0);
                }
            } else {
                this.previousSelectedPattern = this.selectedPattern;
                this.previousIntensity = this.currentIntensity;
                this.patternsAdapter.notifyDataSetChanged();
                ArrayList<Object> arrayList = this.patterns;
                if (arrayList != null) {
                    TLRPC$TL_wallPaper tLRPC$TL_wallPaper = this.selectedPattern;
                    if (tLRPC$TL_wallPaper == null) {
                        iIndexOf = 0;
                    } else {
                        iIndexOf = arrayList.indexOf(tLRPC$TL_wallPaper) + (this.screenType == 2 ? 1 : 0);
                    }
                    this.patternsLayoutManager.scrollToPositionWithOffset(iIndexOf, (this.patternsListView.getMeasuredWidth() - AndroidUtilities.dp(124.0f)) / 2);
                }
            }
        }
        int i5 = this.screenType;
        if (i5 == 1 || i5 == 2) {
            this.backgroundCheckBoxView[z ? (char) 2 : (char) 0].setVisibility(0);
        }
        if (num == 1 && !this.intensitySeekBar.isTwoSided()) {
            float f = this.currentIntensity;
            if (f < 0.0f) {
                float f2 = -f;
                this.currentIntensity = f2;
                this.intensitySeekBar.setProgress(f2);
            }
        }
        if (animated) {
            this.patternViewAnimation = new AnimatorSet();
            ArrayList arrayList2 = new ArrayList();
            int i6 = num == 0 ? 1 : 0;
            if (show) {
                this.patternLayout[num].setVisibility(0);
                int i7 = this.screenType;
                if (i7 == 1) {
                    RecyclerListView recyclerListView = this.listView2;
                    Property property = View.TRANSLATION_Y;
                    float[] fArr = new float[1];
                    fArr[0] = num == 1 ? -AndroidUtilities.dp(21.0f) : 0.0f;
                    arrayList2.add(ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) property, fArr));
                    WallpaperCheckBoxView wallpaperCheckBoxView = this.backgroundCheckBoxView[2];
                    Property property2 = View.ALPHA;
                    float[] fArr2 = new float[1];
                    fArr2[0] = z ? 1.0f : 0.0f;
                    arrayList2.add(ObjectAnimator.ofFloat(wallpaperCheckBoxView, (Property<WallpaperCheckBoxView, Float>) property2, fArr2));
                    WallpaperCheckBoxView wallpaperCheckBoxView2 = this.backgroundCheckBoxView[0];
                    Property property3 = View.ALPHA;
                    float[] fArr3 = new float[1];
                    fArr3[0] = z ? 0.0f : 1.0f;
                    arrayList2.add(ObjectAnimator.ofFloat(wallpaperCheckBoxView2, (Property<WallpaperCheckBoxView, Float>) property3, fArr3));
                    if (num == 1) {
                        arrayList2.add(ObjectAnimator.ofFloat(this.patternLayout[num], (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f));
                    } else {
                        this.patternLayout[num].setAlpha(1.0f);
                        arrayList2.add(ObjectAnimator.ofFloat(this.patternLayout[i6], (Property<FrameLayout, Float>) View.ALPHA, 0.0f));
                    }
                    this.colorPicker.hideKeyboard();
                } else if (i7 == 2) {
                    arrayList2.add(ObjectAnimator.ofFloat(this.listView2, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, (-this.patternLayout[num].getMeasuredHeight()) + AndroidUtilities.dp(48.0f)));
                    WallpaperCheckBoxView wallpaperCheckBoxView3 = this.backgroundCheckBoxView[2];
                    Property property4 = View.ALPHA;
                    float[] fArr4 = new float[1];
                    fArr4[0] = z ? 1.0f : 0.0f;
                    arrayList2.add(ObjectAnimator.ofFloat(wallpaperCheckBoxView3, (Property<WallpaperCheckBoxView, Float>) property4, fArr4));
                    WallpaperCheckBoxView wallpaperCheckBoxView4 = this.backgroundCheckBoxView[0];
                    Property property5 = View.ALPHA;
                    float[] fArr5 = new float[1];
                    fArr5[0] = z ? 0.0f : 1.0f;
                    arrayList2.add(ObjectAnimator.ofFloat(wallpaperCheckBoxView4, (Property<WallpaperCheckBoxView, Float>) property5, fArr5));
                    arrayList2.add(ObjectAnimator.ofFloat(this.backgroundImage, (Property<BackupImageView, Float>) View.ALPHA, 0.0f));
                    if (this.patternLayout[i6].getVisibility() == 0) {
                        arrayList2.add(ObjectAnimator.ofFloat(this.patternLayout[i6], (Property<FrameLayout, Float>) View.ALPHA, 0.0f));
                        arrayList2.add(ObjectAnimator.ofFloat(this.patternLayout[num], (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f));
                        this.patternLayout[num].setTranslationY(0.0f);
                    } else {
                        arrayList2.add(ObjectAnimator.ofFloat(this.patternLayout[num], (Property<FrameLayout, Float>) View.TRANSLATION_Y, r8[num].getMeasuredHeight(), 0.0f));
                    }
                } else {
                    if (num == 1) {
                        arrayList2.add(ObjectAnimator.ofFloat(this.patternLayout[num], (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f));
                    } else {
                        this.patternLayout[num].setAlpha(1.0f);
                        arrayList2.add(ObjectAnimator.ofFloat(this.patternLayout[i6], (Property<FrameLayout, Float>) View.ALPHA, 0.0f));
                    }
                    this.colorPicker.hideKeyboard();
                }
            } else {
                arrayList2.add(ObjectAnimator.ofFloat(this.listView2, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, 0.0f));
                arrayList2.add(ObjectAnimator.ofFloat(this.patternLayout[num], (Property<FrameLayout, Float>) View.TRANSLATION_Y, r8[num].getMeasuredHeight()));
                arrayList2.add(ObjectAnimator.ofFloat(this.backgroundCheckBoxView[0], (Property<WallpaperCheckBoxView, Float>) View.ALPHA, 1.0f));
                arrayList2.add(ObjectAnimator.ofFloat(this.backgroundCheckBoxView[2], (Property<WallpaperCheckBoxView, Float>) View.ALPHA, 0.0f));
                arrayList2.add(ObjectAnimator.ofFloat(this.backgroundImage, (Property<BackupImageView, Float>) View.ALPHA, 1.0f));
            }
            this.patternViewAnimation.playTogether(arrayList2);
            final int i8 = i6;
            this.patternViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ThemePreviewActivity.29
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ThemePreviewActivity.this.patternViewAnimation = null;
                    if (show && ThemePreviewActivity.this.patternLayout[i8].getVisibility() == 0) {
                        ThemePreviewActivity.this.patternLayout[i8].setAlpha(1.0f);
                        ThemePreviewActivity.this.patternLayout[i8].setVisibility(4);
                    } else if (!show) {
                        ThemePreviewActivity.this.patternLayout[num].setVisibility(4);
                    }
                    if (ThemePreviewActivity.this.screenType == 1 || ThemePreviewActivity.this.screenType == 2) {
                        ThemePreviewActivity.this.backgroundCheckBoxView[z ? (char) 0 : (char) 2].setVisibility(4);
                    } else if (num == 1) {
                        ThemePreviewActivity.this.patternLayout[i8].setAlpha(0.0f);
                    }
                }
            });
            this.patternViewAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            this.patternViewAnimation.setDuration(200L);
            this.patternViewAnimation.start();
            return;
        }
        char c = num == 0 ? (char) 1 : (char) 0;
        if (show) {
            this.patternLayout[num].setVisibility(0);
            int i9 = this.screenType;
            if (i9 == 1) {
                this.listView2.setTranslationY(num == 1 ? -AndroidUtilities.dp(21.0f) : 0.0f);
                this.backgroundCheckBoxView[2].setAlpha(z ? 1.0f : 0.0f);
                this.backgroundCheckBoxView[0].setAlpha(z ? 0.0f : 1.0f);
                if (num == 1) {
                    this.patternLayout[num].setAlpha(1.0f);
                } else {
                    this.patternLayout[num].setAlpha(1.0f);
                    this.patternLayout[c].setAlpha(0.0f);
                }
                this.colorPicker.hideKeyboard();
            } else if (i9 == 2) {
                this.listView2.setTranslationY((-AndroidUtilities.dp(num == 0 ? 343.0f : 316.0f)) + AndroidUtilities.dp(48.0f));
                this.backgroundCheckBoxView[2].setAlpha(z ? 1.0f : 0.0f);
                this.backgroundCheckBoxView[0].setAlpha(z ? 0.0f : 1.0f);
                this.backgroundImage.setAlpha(0.0f);
                if (this.patternLayout[c].getVisibility() == 0) {
                    this.patternLayout[c].setAlpha(0.0f);
                    this.patternLayout[num].setAlpha(1.0f);
                    this.patternLayout[num].setTranslationY(0.0f);
                } else {
                    this.patternLayout[num].setTranslationY(0.0f);
                }
            } else {
                if (num == 1) {
                    this.patternLayout[num].setAlpha(1.0f);
                } else {
                    this.patternLayout[num].setAlpha(1.0f);
                    this.patternLayout[c].setAlpha(0.0f);
                }
                this.colorPicker.hideKeyboard();
            }
        } else {
            this.listView2.setTranslationY(0.0f);
            this.patternLayout[num].setTranslationY(r8[num].getMeasuredHeight());
            this.backgroundCheckBoxView[0].setAlpha(1.0f);
            this.backgroundCheckBoxView[2].setAlpha(1.0f);
            this.backgroundImage.setAlpha(1.0f);
        }
        if (show && this.patternLayout[c].getVisibility() == 0) {
            this.patternLayout[c].setAlpha(1.0f);
            this.patternLayout[c].setVisibility(4);
        } else if (!show) {
            this.patternLayout[num].setVisibility(4);
        }
        int i10 = this.screenType;
        if (i10 == 1 || i10 == 2) {
            this.backgroundCheckBoxView[z ? (char) 0 : (char) 2].setVisibility(4);
        } else if (num == 1) {
            this.patternLayout[c].setAlpha(0.0f);
        }
    }

    private void animateMotionChange() {
        AnimatorSet animatorSet = this.motionAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.motionAnimation = animatorSet2;
        if (this.isMotion) {
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.backgroundImage, (Property<BackupImageView, Float>) View.SCALE_X, this.parallaxScale), ObjectAnimator.ofFloat(this.backgroundImage, (Property<BackupImageView, Float>) View.SCALE_Y, this.parallaxScale));
        } else {
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.backgroundImage, (Property<BackupImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.backgroundImage, (Property<BackupImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.backgroundImage, (Property<BackupImageView, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.backgroundImage, (Property<BackupImageView, Float>) View.TRANSLATION_Y, 0.0f));
        }
        this.motionAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
        this.motionAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ThemePreviewActivity.30
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ThemePreviewActivity.this.motionAnimation = null;
            }
        });
        this.motionAnimation.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updatePlayAnimationView(boolean r20) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ThemePreviewActivity.updatePlayAnimationView(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackgroundColor(int color, int num, boolean applyNow, boolean animated) {
        MotionBackgroundDrawable motionBackgroundDrawable;
        if (num == 0) {
            this.backgroundColor = color;
        } else if (num == 1) {
            this.backgroundGradientColor1 = color;
        } else if (num == 2) {
            this.backgroundGradientColor2 = color;
        } else if (num == 3) {
            this.backgroundGradientColor3 = color;
        }
        updatePlayAnimationView(animated);
        if (this.backgroundCheckBoxView != null) {
            int i = 0;
            while (true) {
                WallpaperCheckBoxView[] wallpaperCheckBoxViewArr = this.backgroundCheckBoxView;
                if (i >= wallpaperCheckBoxViewArr.length) {
                    break;
                }
                if (wallpaperCheckBoxViewArr[i] != null) {
                    wallpaperCheckBoxViewArr[i].setColor(num, color);
                }
                i++;
            }
        }
        if (this.backgroundGradientColor2 != 0) {
            if (this.intensitySeekBar != null && Theme.getActiveTheme().isDark()) {
                this.intensitySeekBar.setTwoSided(true);
            }
            Drawable background = this.backgroundImage.getBackground();
            if (background instanceof MotionBackgroundDrawable) {
                motionBackgroundDrawable = (MotionBackgroundDrawable) background;
            } else {
                motionBackgroundDrawable = new MotionBackgroundDrawable();
                motionBackgroundDrawable.setParentView(this.backgroundImage);
                if (this.rotatePreview) {
                    motionBackgroundDrawable.rotatePreview(false);
                }
            }
            motionBackgroundDrawable.setColors(this.backgroundColor, this.backgroundGradientColor1, this.backgroundGradientColor2, this.backgroundGradientColor3);
            this.backgroundImage.setBackground(motionBackgroundDrawable);
            this.patternColor = motionBackgroundDrawable.getPatternColor();
            this.checkColor = 754974720;
        } else if (this.backgroundGradientColor1 != 0) {
            this.backgroundImage.setBackground(new GradientDrawable(BackgroundGradientDrawable.getGradientOrientation(this.backgroundRotation), new int[]{this.backgroundColor, this.backgroundGradientColor1}));
            int patternColor = AndroidUtilities.getPatternColor(AndroidUtilities.getAverageColor(this.backgroundColor, this.backgroundGradientColor1));
            this.checkColor = patternColor;
            this.patternColor = patternColor;
        } else {
            this.backgroundImage.setBackgroundColor(this.backgroundColor);
            int patternColor2 = AndroidUtilities.getPatternColor(this.backgroundColor);
            this.checkColor = patternColor2;
            this.patternColor = patternColor2;
        }
        if (!Theme.hasThemeKey("chat_serviceBackground") || (this.backgroundImage.getBackground() instanceof MotionBackgroundDrawable)) {
            int i2 = this.checkColor;
            Theme.applyChatServiceMessageColor(new int[]{i2, i2, i2, i2}, this.backgroundImage.getBackground());
        } else if (Theme.getCachedWallpaper() instanceof MotionBackgroundDrawable) {
            int color2 = Theme.getColor("chat_serviceBackground");
            Theme.applyChatServiceMessageColor(new int[]{color2, color2, color2, color2}, this.backgroundImage.getBackground());
        }
        ImageView imageView = this.backgroundPlayAnimationImageView;
        if (imageView != null) {
            imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_serviceText"), PorterDuff.Mode.MULTIPLY));
        }
        ImageView imageView2 = this.messagesPlayAnimationImageView;
        if (imageView2 != null) {
            imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_serviceText"), PorterDuff.Mode.MULTIPLY));
        }
        BackupImageView backupImageView = this.backgroundImage;
        if (backupImageView != null) {
            backupImageView.getImageReceiver().setColorFilter(new PorterDuffColorFilter(this.patternColor, this.blendMode));
            this.backgroundImage.getImageReceiver().setAlpha(Math.abs(this.currentIntensity));
            this.backgroundImage.invalidate();
            if (Theme.getActiveTheme().isDark() && (this.backgroundImage.getBackground() instanceof MotionBackgroundDrawable)) {
                SeekBarView seekBarView = this.intensitySeekBar;
                if (seekBarView != null) {
                    seekBarView.setTwoSided(true);
                }
                if (this.currentIntensity < 0.0f) {
                    this.backgroundImage.getImageReceiver().setGradientBitmap(((MotionBackgroundDrawable) this.backgroundImage.getBackground()).getBitmap());
                }
            } else {
                this.backgroundImage.getImageReceiver().setGradientBitmap(null);
                SeekBarView seekBarView2 = this.intensitySeekBar;
                if (seekBarView2 != null) {
                    seekBarView2.setTwoSided(false);
                }
            }
            SeekBarView seekBarView3 = this.intensitySeekBar;
            if (seekBarView3 != null) {
                seekBarView3.setProgress(this.currentIntensity);
            }
        }
        RecyclerListView recyclerListView = this.listView2;
        if (recyclerListView != null) {
            recyclerListView.invalidateViews();
        }
        FrameLayout frameLayout = this.backgroundButtonsContainer;
        if (frameLayout != null) {
            int childCount = frameLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                this.backgroundButtonsContainer.getChildAt(i3).invalidate();
            }
        }
        FrameLayout frameLayout2 = this.messagesButtonsContainer;
        if (frameLayout2 != null) {
            int childCount2 = frameLayout2.getChildCount();
            for (int i4 = 0; i4 < childCount2; i4++) {
                this.messagesButtonsContainer.getChildAt(i4).invalidate();
            }
        }
        RadialProgress2 radialProgress2 = this.radialProgress;
        if (radialProgress2 != null) {
            radialProgress2.setColors("chat_serviceBackground", "chat_serviceBackground", "chat_serviceText", "chat_serviceText");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setCurrentImage(boolean z) throws InterruptedException {
        ColorDrawable colorDrawable;
        MotionBackgroundDrawable motionBackgroundDrawable;
        int i = this.screenType;
        if (i == 0 && this.accent == null) {
            this.backgroundImage.setBackground(Theme.getCachedWallpaper());
        } else if (i == 2) {
            Object obj = this.currentWallpaper;
            if (obj instanceof TLRPC$TL_wallPaper) {
                TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) obj;
                this.backgroundImage.setImage(ImageLocation.getForDocument(tLRPC$TL_wallPaper.document), this.imageFilter, ImageLocation.getForDocument(z ? FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_wallPaper.document.thumbs, 100) : null, tLRPC$TL_wallPaper.document), "100_100_b", "jpg", tLRPC$TL_wallPaper.document.size, 1, tLRPC$TL_wallPaper);
            } else if (obj instanceof WallpapersListActivity.ColorWallpaper) {
                WallpapersListActivity.ColorWallpaper colorWallpaper = (WallpapersListActivity.ColorWallpaper) obj;
                this.backgroundRotation = colorWallpaper.gradientRotation;
                setBackgroundColor(colorWallpaper.color, 0, true, false);
                int i2 = colorWallpaper.gradientColor1;
                if (i2 != 0) {
                    setBackgroundColor(i2, 1, true, false);
                }
                setBackgroundColor(colorWallpaper.gradientColor2, 2, true, false);
                setBackgroundColor(colorWallpaper.gradientColor3, 3, true, false);
                TLRPC$TL_wallPaper tLRPC$TL_wallPaper2 = this.selectedPattern;
                if (tLRPC$TL_wallPaper2 != null) {
                    BackupImageView backupImageView = this.backgroundImage;
                    ImageLocation forDocument = ImageLocation.getForDocument(tLRPC$TL_wallPaper2.document);
                    String str = this.imageFilter;
                    TLRPC$TL_wallPaper tLRPC$TL_wallPaper3 = this.selectedPattern;
                    backupImageView.setImage(forDocument, str, null, null, "jpg", tLRPC$TL_wallPaper3.document.size, 1, tLRPC$TL_wallPaper3);
                } else if ("d".equals(colorWallpaper.slug)) {
                    Point point = AndroidUtilities.displaySize;
                    int iMin = Math.min(point.x, point.y);
                    Point point2 = AndroidUtilities.displaySize;
                    this.backgroundImage.setImageBitmap(SvgHelper.getBitmap(R.raw.eitaa_bg3, iMin, Math.max(point2.x, point2.y), Build.VERSION.SDK_INT >= 29 ? 1459617792 : MotionBackgroundDrawable.getPatternColor(colorWallpaper.color, colorWallpaper.gradientColor1, colorWallpaper.gradientColor2, colorWallpaper.gradientColor3)));
                }
            } else if (obj instanceof WallpapersListActivity.FileWallpaper) {
                Bitmap bitmap = this.currentWallpaperBitmap;
                if (bitmap != null) {
                    this.backgroundImage.setImageBitmap(bitmap);
                } else {
                    WallpapersListActivity.FileWallpaper fileWallpaper = (WallpapersListActivity.FileWallpaper) obj;
                    File file = fileWallpaper.originalPath;
                    if (file != null) {
                        this.backgroundImage.setImage(file.getAbsolutePath(), this.imageFilter, null);
                    } else {
                        File file2 = fileWallpaper.path;
                        if (file2 != null) {
                            this.backgroundImage.setImage(file2.getAbsolutePath(), this.imageFilter, null);
                        } else if ("t".equals(fileWallpaper.slug)) {
                            BackupImageView backupImageView2 = this.backgroundImage;
                            backupImageView2.setImageDrawable(Theme.getThemedWallpaper(false, backupImageView2));
                        } else {
                            int i3 = fileWallpaper.resId;
                            if (i3 != 0) {
                                this.backgroundImage.setImageResource(i3);
                            }
                        }
                    }
                }
            } else if (obj instanceof MediaController.SearchImage) {
                MediaController.SearchImage searchImage = (MediaController.SearchImage) obj;
                TLRPC$Photo tLRPC$Photo = searchImage.photo;
                if (tLRPC$Photo != null) {
                    TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, 100);
                    TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(searchImage.photo.sizes, this.maxWallpaperSize, true);
                    TLRPC$PhotoSize tLRPC$PhotoSize = closestPhotoSizeWithSize2 != closestPhotoSizeWithSize ? closestPhotoSizeWithSize2 : null;
                    this.backgroundImage.setImage(ImageLocation.getForPhoto(tLRPC$PhotoSize, searchImage.photo), this.imageFilter, ImageLocation.getForPhoto(closestPhotoSizeWithSize, searchImage.photo), "100_100_b", "jpg", tLRPC$PhotoSize != null ? tLRPC$PhotoSize.size : 0, 1, searchImage);
                } else {
                    this.backgroundImage.setImage(searchImage.imageUrl, this.imageFilter, searchImage.thumbUrl, "100_100_b");
                }
            }
        } else {
            BackgroundGradientDrawable.Disposable disposable = this.backgroundGradientDisposable;
            if (disposable != null) {
                disposable.dispose();
                this.backgroundGradientDisposable = null;
            }
            int defaultAccentColor = Theme.getDefaultAccentColor("chat_wallpaper");
            int i4 = (int) this.accent.backgroundOverrideColor;
            if (i4 != 0) {
                defaultAccentColor = i4;
            }
            int defaultAccentColor2 = Theme.getDefaultAccentColor("chat_wallpaper_gradient_to");
            long j = this.accent.backgroundGradientOverrideColor1;
            int i5 = (int) j;
            if (i5 == 0 && j != 0) {
                defaultAccentColor2 = 0;
            } else if (i5 != 0) {
                defaultAccentColor2 = i5;
            }
            int defaultAccentColor3 = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to2");
            long j2 = this.accent.backgroundGradientOverrideColor2;
            int i6 = (int) j2;
            if (i6 == 0 && j2 != 0) {
                defaultAccentColor3 = 0;
            } else if (i6 != 0) {
                defaultAccentColor3 = i6;
            }
            int defaultAccentColor4 = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to3");
            Theme.ThemeAccent themeAccent = this.accent;
            long j3 = themeAccent.backgroundGradientOverrideColor3;
            int i7 = (int) j3;
            if (i7 == 0 && j3 != 0) {
                defaultAccentColor4 = 0;
            } else if (i7 != 0) {
                defaultAccentColor4 = i7;
            }
            if (!TextUtils.isEmpty(themeAccent.patternSlug) && !Theme.hasCustomWallpaper()) {
                if (defaultAccentColor3 != 0) {
                    Drawable background = this.backgroundImage.getBackground();
                    if (background instanceof MotionBackgroundDrawable) {
                        motionBackgroundDrawable = (MotionBackgroundDrawable) background;
                    } else {
                        MotionBackgroundDrawable motionBackgroundDrawable2 = new MotionBackgroundDrawable();
                        motionBackgroundDrawable2.setParentView(this.backgroundImage);
                        motionBackgroundDrawable = motionBackgroundDrawable2;
                        if (this.rotatePreview) {
                            motionBackgroundDrawable2.rotatePreview(false);
                            motionBackgroundDrawable = motionBackgroundDrawable2;
                        }
                    }
                    motionBackgroundDrawable.setColors(defaultAccentColor, defaultAccentColor2, defaultAccentColor3, defaultAccentColor4);
                    colorDrawable = motionBackgroundDrawable;
                } else if (defaultAccentColor2 != 0) {
                    BackgroundGradientDrawable backgroundGradientDrawable = new BackgroundGradientDrawable(BackgroundGradientDrawable.getGradientOrientation(this.accent.backgroundRotation), new int[]{defaultAccentColor, defaultAccentColor2});
                    this.backgroundGradientDisposable = backgroundGradientDrawable.startDithering(BackgroundGradientDrawable.Sizes.ofDeviceScreen(), new BackgroundGradientDrawable.ListenerAdapter() { // from class: ir.eitaa.ui.ThemePreviewActivity.33
                        @Override // ir.eitaa.ui.Components.BackgroundGradientDrawable.ListenerAdapter, ir.eitaa.ui.Components.BackgroundGradientDrawable.Listener
                        public void onSizeReady(int width, int height) {
                            Point point3 = AndroidUtilities.displaySize;
                            if ((point3.x <= point3.y) == (width <= height)) {
                                ThemePreviewActivity.this.backgroundImage.invalidate();
                            }
                        }
                    }, 100L);
                    colorDrawable = backgroundGradientDrawable;
                } else {
                    colorDrawable = new ColorDrawable(defaultAccentColor);
                }
                this.backgroundImage.setBackground(colorDrawable);
                TLRPC$TL_wallPaper tLRPC$TL_wallPaper4 = this.selectedPattern;
                if (tLRPC$TL_wallPaper4 != null) {
                    BackupImageView backupImageView3 = this.backgroundImage;
                    ImageLocation forDocument2 = ImageLocation.getForDocument(tLRPC$TL_wallPaper4.document);
                    String str2 = this.imageFilter;
                    TLRPC$TL_wallPaper tLRPC$TL_wallPaper5 = this.selectedPattern;
                    backupImageView3.setImage(forDocument2, str2, null, null, "jpg", tLRPC$TL_wallPaper5.document.size, 1, tLRPC$TL_wallPaper5);
                }
            } else {
                Drawable cachedWallpaper = Theme.getCachedWallpaper();
                if (cachedWallpaper != null) {
                    if (cachedWallpaper instanceof MotionBackgroundDrawable) {
                        ((MotionBackgroundDrawable) cachedWallpaper).setParentView(this.backgroundImage);
                    }
                    this.backgroundImage.setBackground(cachedWallpaper);
                }
            }
            if (defaultAccentColor2 == 0) {
                int patternColor = AndroidUtilities.getPatternColor(defaultAccentColor);
                this.checkColor = patternColor;
                this.patternColor = patternColor;
            } else if (defaultAccentColor3 != 0) {
                this.patternColor = MotionBackgroundDrawable.getPatternColor(defaultAccentColor, defaultAccentColor2, defaultAccentColor3, defaultAccentColor4);
                this.checkColor = 754974720;
            } else {
                int patternColor2 = AndroidUtilities.getPatternColor(AndroidUtilities.getAverageColor(defaultAccentColor, defaultAccentColor2));
                this.checkColor = patternColor2;
                this.patternColor = patternColor2;
            }
            BackupImageView backupImageView4 = this.backgroundImage;
            if (backupImageView4 != null) {
                backupImageView4.getImageReceiver().setColorFilter(new PorterDuffColorFilter(this.patternColor, this.blendMode));
                this.backgroundImage.getImageReceiver().setAlpha(Math.abs(this.currentIntensity));
                this.backgroundImage.invalidate();
                if (Theme.getActiveTheme().isDark() && (this.backgroundImage.getBackground() instanceof MotionBackgroundDrawable)) {
                    SeekBarView seekBarView = this.intensitySeekBar;
                    if (seekBarView != null) {
                        seekBarView.setTwoSided(true);
                    }
                    if (this.currentIntensity < 0.0f) {
                        this.backgroundImage.getImageReceiver().setGradientBitmap(((MotionBackgroundDrawable) this.backgroundImage.getBackground()).getBitmap());
                    }
                } else {
                    this.backgroundImage.getImageReceiver().setGradientBitmap(null);
                    SeekBarView seekBarView2 = this.intensitySeekBar;
                    if (seekBarView2 != null) {
                        seekBarView2.setTwoSided(false);
                    }
                }
                SeekBarView seekBarView3 = this.intensitySeekBar;
                if (seekBarView3 != null) {
                    seekBarView3.setProgress(this.currentIntensity);
                }
            }
            if (this.backgroundCheckBoxView != null) {
                int i8 = 0;
                while (true) {
                    WallpaperCheckBoxView[] wallpaperCheckBoxViewArr = this.backgroundCheckBoxView;
                    if (i8 >= wallpaperCheckBoxViewArr.length) {
                        break;
                    }
                    wallpaperCheckBoxViewArr[i8].setColor(0, defaultAccentColor);
                    this.backgroundCheckBoxView[i8].setColor(1, defaultAccentColor2);
                    this.backgroundCheckBoxView[i8].setColor(2, defaultAccentColor3);
                    this.backgroundCheckBoxView[i8].setColor(3, defaultAccentColor4);
                    i8++;
                }
            }
            ImageView imageView = this.backgroundPlayAnimationImageView;
            if (imageView != null) {
                imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_serviceText"), PorterDuff.Mode.MULTIPLY));
            }
            ImageView imageView2 = this.messagesPlayAnimationImageView;
            if (imageView2 != null) {
                imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_serviceText"), PorterDuff.Mode.MULTIPLY));
            }
            FrameLayout frameLayout = this.backgroundButtonsContainer;
            if (frameLayout != null) {
                int childCount = frameLayout.getChildCount();
                for (int i9 = 0; i9 < childCount; i9++) {
                    this.backgroundButtonsContainer.getChildAt(i9).invalidate();
                }
            }
            FrameLayout frameLayout2 = this.messagesButtonsContainer;
            if (frameLayout2 != null) {
                int childCount2 = frameLayout2.getChildCount();
                for (int i10 = 0; i10 < childCount2; i10++) {
                    this.messagesButtonsContainer.getChildAt(i10).invalidate();
                }
            }
        }
        this.rotatePreview = false;
    }

    public static class DialogsAdapter extends RecyclerListView.SelectionAdapter {
        private ArrayList<DialogCell.CustomDialog> dialogs = new ArrayList<>();
        private Context mContext;

        public DialogsAdapter(Context context) {
            this.mContext = context;
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            DialogCell.CustomDialog customDialog = new DialogCell.CustomDialog();
            customDialog.name = LocaleController.getString("ThemePreviewDialog1", R.string.ThemePreviewDialog1);
            customDialog.message = LocaleController.getString("ThemePreviewDialogMessage1", R.string.ThemePreviewDialogMessage1);
            customDialog.id = 0;
            customDialog.unread_count = 0;
            customDialog.pinned = true;
            customDialog.muted = false;
            customDialog.type = 0;
            customDialog.date = iCurrentTimeMillis;
            customDialog.verified = false;
            customDialog.isMedia = false;
            customDialog.sent = true;
            this.dialogs.add(customDialog);
            DialogCell.CustomDialog customDialog2 = new DialogCell.CustomDialog();
            customDialog2.name = LocaleController.getString("ThemePreviewDialog2", R.string.ThemePreviewDialog2);
            customDialog2.message = LocaleController.getString("ThemePreviewDialogMessage2", R.string.ThemePreviewDialogMessage2);
            customDialog2.id = 1;
            customDialog2.unread_count = 2;
            customDialog2.pinned = false;
            customDialog2.muted = false;
            customDialog2.type = 0;
            customDialog2.date = iCurrentTimeMillis - 3600;
            customDialog2.verified = false;
            customDialog2.isMedia = false;
            customDialog2.sent = false;
            this.dialogs.add(customDialog2);
            DialogCell.CustomDialog customDialog3 = new DialogCell.CustomDialog();
            customDialog3.name = LocaleController.getString("ThemePreviewDialog3", R.string.ThemePreviewDialog3);
            customDialog3.message = LocaleController.getString("ThemePreviewDialogMessage3", R.string.ThemePreviewDialogMessage3);
            customDialog3.id = 2;
            customDialog3.unread_count = 3;
            customDialog3.pinned = false;
            customDialog3.muted = true;
            customDialog3.type = 0;
            customDialog3.date = iCurrentTimeMillis - 7200;
            customDialog3.verified = false;
            customDialog3.isMedia = true;
            customDialog3.sent = false;
            this.dialogs.add(customDialog3);
            DialogCell.CustomDialog customDialog4 = new DialogCell.CustomDialog();
            customDialog4.name = LocaleController.getString("ThemePreviewDialog4", R.string.ThemePreviewDialog4);
            customDialog4.message = LocaleController.getString("ThemePreviewDialogMessage4", R.string.ThemePreviewDialogMessage4);
            customDialog4.id = 3;
            customDialog4.unread_count = 0;
            customDialog4.pinned = false;
            customDialog4.muted = false;
            customDialog4.type = 0;
            customDialog4.date = iCurrentTimeMillis - 10800;
            customDialog4.verified = false;
            customDialog4.isMedia = false;
            customDialog4.sent = false;
            this.dialogs.add(customDialog4);
            DialogCell.CustomDialog customDialog5 = new DialogCell.CustomDialog();
            customDialog5.name = LocaleController.getString("ThemePreviewDialog5", R.string.ThemePreviewDialog5);
            customDialog5.message = LocaleController.getString("ThemePreviewDialogMessage5", R.string.ThemePreviewDialogMessage5);
            customDialog5.id = 4;
            customDialog5.unread_count = 0;
            customDialog5.pinned = false;
            customDialog5.muted = false;
            customDialog5.type = 1;
            customDialog5.date = iCurrentTimeMillis - 14400;
            customDialog5.verified = false;
            customDialog5.isMedia = false;
            customDialog5.sent = true;
            this.dialogs.add(customDialog5);
            DialogCell.CustomDialog customDialog6 = new DialogCell.CustomDialog();
            customDialog6.name = LocaleController.getString("ThemePreviewDialog6", R.string.ThemePreviewDialog6);
            customDialog6.message = LocaleController.getString("ThemePreviewDialogMessage6", R.string.ThemePreviewDialogMessage6);
            customDialog6.id = 5;
            customDialog6.unread_count = 0;
            customDialog6.pinned = false;
            customDialog6.muted = false;
            customDialog6.type = 0;
            customDialog6.date = iCurrentTimeMillis - 18000;
            customDialog6.verified = false;
            customDialog6.isMedia = false;
            customDialog6.sent = false;
            this.dialogs.add(customDialog6);
            DialogCell.CustomDialog customDialog7 = new DialogCell.CustomDialog();
            customDialog7.name = LocaleController.getString("ThemePreviewDialog7", R.string.ThemePreviewDialog7);
            customDialog7.message = LocaleController.getString("ThemePreviewDialogMessage7", R.string.ThemePreviewDialogMessage7);
            customDialog7.id = 6;
            customDialog7.unread_count = 0;
            customDialog7.pinned = false;
            customDialog7.muted = false;
            customDialog7.type = 0;
            customDialog7.date = iCurrentTimeMillis - 21600;
            customDialog7.verified = true;
            customDialog7.isMedia = false;
            customDialog7.sent = false;
            this.dialogs.add(customDialog7);
            DialogCell.CustomDialog customDialog8 = new DialogCell.CustomDialog();
            customDialog8.name = LocaleController.getString("ThemePreviewDialog8", R.string.ThemePreviewDialog8);
            customDialog8.message = LocaleController.getString("ThemePreviewDialogMessage8", R.string.ThemePreviewDialogMessage8);
            customDialog8.id = 0;
            customDialog8.unread_count = 0;
            customDialog8.pinned = false;
            customDialog8.muted = false;
            customDialog8.type = 0;
            customDialog8.date = iCurrentTimeMillis - 25200;
            customDialog8.verified = true;
            customDialog8.isMedia = false;
            customDialog8.sent = false;
            this.dialogs.add(customDialog8);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dialogs.size();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() != 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View loadingCell;
            if (viewType == 0) {
                loadingCell = new DialogCell(null, this.mContext, false, false);
            } else {
                loadingCell = new LoadingCell(this.mContext);
            }
            loadingCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(loadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                DialogCell dialogCell = (DialogCell) viewHolder.itemView;
                dialogCell.useSeparator = i != getItemCount() - 1;
                dialogCell.setDialog(this.dialogs.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i == this.dialogs.size() ? 1 : 0;
        }
    }

    public class MessagesAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;
        private ArrayList<MessageObject> messages;
        private boolean showSecretMessages;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        public MessagesAdapter(Context context) {
            this.showSecretMessages = ThemePreviewActivity.this.screenType == 0 && Utilities.random.nextInt(100) <= 1;
            this.mContext = context;
            this.messages = new ArrayList<>();
            int iCurrentTimeMillis = ((int) (System.currentTimeMillis() / 1000)) - 3600;
            if (ThemePreviewActivity.this.screenType != 2) {
                if (ThemePreviewActivity.this.screenType == 1) {
                    TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
                    TLRPC$TL_messageMediaDocument tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
                    tLRPC$TL_message.media = tLRPC$TL_messageMediaDocument;
                    tLRPC$TL_messageMediaDocument.document = new TLRPC$TL_document();
                    TLRPC$Document tLRPC$Document = tLRPC$TL_message.media.document;
                    tLRPC$Document.mime_type = "audio/mp3";
                    tLRPC$Document.file_reference = new byte[0];
                    tLRPC$Document.id = -2147483648L;
                    tLRPC$Document.size = MediaController.VIDEO_BITRATE_720;
                    tLRPC$Document.dc_id = Integer.MIN_VALUE;
                    TLRPC$TL_documentAttributeFilename tLRPC$TL_documentAttributeFilename = new TLRPC$TL_documentAttributeFilename();
                    tLRPC$TL_documentAttributeFilename.file_name = LocaleController.getString("NewThemePreviewReply2", R.string.NewThemePreviewReply2) + ".mp3";
                    tLRPC$TL_message.media.document.attributes.add(tLRPC$TL_documentAttributeFilename);
                    int i = iCurrentTimeMillis + 60;
                    tLRPC$TL_message.date = i;
                    tLRPC$TL_message.dialog_id = 1L;
                    tLRPC$TL_message.flags = 259;
                    TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                    tLRPC$TL_message.from_id = tLRPC$TL_peerUser;
                    tLRPC$TL_peerUser.user_id = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
                    tLRPC$TL_message.id = 1;
                    tLRPC$TL_message.out = true;
                    TLRPC$TL_peerUser tLRPC$TL_peerUser2 = new TLRPC$TL_peerUser();
                    tLRPC$TL_message.peer_id = tLRPC$TL_peerUser2;
                    tLRPC$TL_peerUser2.user_id = 0L;
                    MessageObject messageObject = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message, true, false);
                    if (BuildVars.DEBUG_PRIVATE_VERSION) {
                        TLRPC$TL_message tLRPC$TL_message2 = new TLRPC$TL_message();
                        tLRPC$TL_message2.message = "this is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text\nthis is very very long text";
                        tLRPC$TL_message2.date = iCurrentTimeMillis + 960;
                        tLRPC$TL_message2.dialog_id = 1L;
                        tLRPC$TL_message2.flags = 259;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser3 = new TLRPC$TL_peerUser();
                        tLRPC$TL_message2.from_id = tLRPC$TL_peerUser3;
                        tLRPC$TL_peerUser3.user_id = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
                        tLRPC$TL_message2.id = 1;
                        tLRPC$TL_message2.media = new TLRPC$TL_messageMediaEmpty();
                        tLRPC$TL_message2.out = true;
                        TLRPC$TL_peerUser tLRPC$TL_peerUser4 = new TLRPC$TL_peerUser();
                        tLRPC$TL_message2.peer_id = tLRPC$TL_peerUser4;
                        tLRPC$TL_peerUser4.user_id = 0L;
                        MessageObject messageObject2 = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message2, true, false);
                        messageObject2.resetLayout();
                        messageObject2.eventId = 1L;
                        this.messages.add(messageObject2);
                    }
                    TLRPC$TL_message tLRPC$TL_message3 = new TLRPC$TL_message();
                    String string = LocaleController.getString("NewThemePreviewLine3", R.string.NewThemePreviewLine3);
                    StringBuilder sb = new StringBuilder(string);
                    int iIndexOf = string.indexOf(42);
                    int iLastIndexOf = string.lastIndexOf(42);
                    if (iIndexOf != -1 && iLastIndexOf != -1) {
                        sb.replace(iLastIndexOf, iLastIndexOf + 1, "");
                        sb.replace(iIndexOf, iIndexOf + 1, "");
                        TLRPC$TL_messageEntityTextUrl tLRPC$TL_messageEntityTextUrl = new TLRPC$TL_messageEntityTextUrl();
                        tLRPC$TL_messageEntityTextUrl.offset = iIndexOf;
                        tLRPC$TL_messageEntityTextUrl.length = (iLastIndexOf - iIndexOf) - 1;
                        tLRPC$TL_messageEntityTextUrl.url = "https://eitaa.org";
                        tLRPC$TL_message3.entities.add(tLRPC$TL_messageEntityTextUrl);
                    }
                    tLRPC$TL_message3.message = sb.toString();
                    tLRPC$TL_message3.date = iCurrentTimeMillis + 960;
                    tLRPC$TL_message3.dialog_id = 1L;
                    tLRPC$TL_message3.flags = 259;
                    TLRPC$TL_peerUser tLRPC$TL_peerUser5 = new TLRPC$TL_peerUser();
                    tLRPC$TL_message3.from_id = tLRPC$TL_peerUser5;
                    tLRPC$TL_peerUser5.user_id = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
                    tLRPC$TL_message3.id = 1;
                    tLRPC$TL_message3.media = new TLRPC$TL_messageMediaEmpty();
                    tLRPC$TL_message3.out = true;
                    TLRPC$TL_peerUser tLRPC$TL_peerUser6 = new TLRPC$TL_peerUser();
                    tLRPC$TL_message3.peer_id = tLRPC$TL_peerUser6;
                    tLRPC$TL_peerUser6.user_id = 0L;
                    MessageObject messageObject3 = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message3, true, false);
                    messageObject3.resetLayout();
                    messageObject3.eventId = 1L;
                    this.messages.add(messageObject3);
                    TLRPC$TL_message tLRPC$TL_message4 = new TLRPC$TL_message();
                    tLRPC$TL_message4.message = LocaleController.getString("NewThemePreviewLine1", R.string.NewThemePreviewLine1);
                    tLRPC$TL_message4.date = i;
                    tLRPC$TL_message4.dialog_id = 1L;
                    tLRPC$TL_message4.flags = 265;
                    tLRPC$TL_message4.from_id = new TLRPC$TL_peerUser();
                    tLRPC$TL_message4.id = 1;
                    TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                    tLRPC$TL_message4.reply_to = tLRPC$TL_messageReplyHeader;
                    tLRPC$TL_messageReplyHeader.reply_to_msg_id = 5;
                    tLRPC$TL_message4.media = new TLRPC$TL_messageMediaEmpty();
                    tLRPC$TL_message4.out = false;
                    TLRPC$TL_peerUser tLRPC$TL_peerUser7 = new TLRPC$TL_peerUser();
                    tLRPC$TL_message4.peer_id = tLRPC$TL_peerUser7;
                    tLRPC$TL_peerUser7.user_id = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
                    MessageObject messageObject4 = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message4, true, false);
                    messageObject4.customReplyName = LocaleController.getString("NewThemePreviewName", R.string.NewThemePreviewName);
                    messageObject3.customReplyName = "Hossein";
                    messageObject4.eventId = 1L;
                    messageObject4.resetLayout();
                    messageObject4.replyMessageObject = messageObject;
                    messageObject3.replyMessageObject = messageObject4;
                    this.messages.add(messageObject4);
                    this.messages.add(messageObject);
                    TLRPC$TL_message tLRPC$TL_message5 = new TLRPC$TL_message();
                    tLRPC$TL_message5.date = iCurrentTimeMillis + R.styleable.AppCompatTheme_windowNoTitle;
                    tLRPC$TL_message5.dialog_id = 1L;
                    tLRPC$TL_message5.flags = 259;
                    tLRPC$TL_message5.out = false;
                    tLRPC$TL_message5.from_id = new TLRPC$TL_peerUser();
                    tLRPC$TL_message5.id = 1;
                    TLRPC$TL_messageMediaDocument tLRPC$TL_messageMediaDocument2 = new TLRPC$TL_messageMediaDocument();
                    tLRPC$TL_message5.media = tLRPC$TL_messageMediaDocument2;
                    tLRPC$TL_messageMediaDocument2.flags |= 3;
                    tLRPC$TL_messageMediaDocument2.document = new TLRPC$TL_document();
                    TLRPC$Document tLRPC$Document2 = tLRPC$TL_message5.media.document;
                    tLRPC$Document2.mime_type = "audio/ogg";
                    tLRPC$Document2.file_reference = new byte[0];
                    TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio = new TLRPC$TL_documentAttributeAudio();
                    tLRPC$TL_documentAttributeAudio.flags = 1028;
                    tLRPC$TL_documentAttributeAudio.duration = 3;
                    tLRPC$TL_documentAttributeAudio.voice = true;
                    tLRPC$TL_documentAttributeAudio.waveform = new byte[]{0, 4, 17, -50, -93, 86, -103, -45, -12, -26, 63, -25, -3, 109, -114, -54, -4, -1, -1, -1, -1, -29, -1, -1, -25, -1, -1, -97, -43, 57, -57, -108, 1, -91, -4, -47, 21, 99, 10, 97, 43, 45, 115, -112, -77, 51, -63, 66, 40, 34, -122, -116, 48, -124, 16, 66, -120, 16, 68, 16, 33, 4, 1};
                    tLRPC$TL_message5.media.document.attributes.add(tLRPC$TL_documentAttributeAudio);
                    tLRPC$TL_message5.out = true;
                    TLRPC$TL_peerUser tLRPC$TL_peerUser8 = new TLRPC$TL_peerUser();
                    tLRPC$TL_message5.peer_id = tLRPC$TL_peerUser8;
                    tLRPC$TL_peerUser8.user_id = 0L;
                    MessageObject messageObject5 = new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message5, true, false);
                    messageObject5.audioProgressSec = 1;
                    messageObject5.audioProgress = 0.3f;
                    messageObject5.useCustomPhoto = true;
                    this.messages.add(messageObject5);
                    return;
                }
                if (this.showSecretMessages) {
                    TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
                    tLRPC$TL_user.id = 2147483647L;
                    tLRPC$TL_user.first_name = "Me";
                    TLRPC$TL_user tLRPC$TL_user2 = new TLRPC$TL_user();
                    tLRPC$TL_user2.id = 2147483646L;
                    tLRPC$TL_user2.first_name = "Serj";
                    ArrayList<TLRPC$User> arrayList = new ArrayList<>();
                    arrayList.add(tLRPC$TL_user);
                    arrayList.add(tLRPC$TL_user2);
                    MessagesController.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).putUsers(arrayList, true);
                    TLRPC$TL_message tLRPC$TL_message6 = new TLRPC$TL_message();
                    tLRPC$TL_message6.message = "Guess why Half-Life 3 was never released.";
                    int i2 = iCurrentTimeMillis + 960;
                    tLRPC$TL_message6.date = i2;
                    tLRPC$TL_message6.dialog_id = -1L;
                    tLRPC$TL_message6.flags = 259;
                    tLRPC$TL_message6.id = 2147483646;
                    tLRPC$TL_message6.media = new TLRPC$TL_messageMediaEmpty();
                    tLRPC$TL_message6.out = false;
                    TLRPC$TL_peerChat tLRPC$TL_peerChat = new TLRPC$TL_peerChat();
                    tLRPC$TL_message6.peer_id = tLRPC$TL_peerChat;
                    tLRPC$TL_peerChat.chat_id = 1L;
                    TLRPC$TL_peerUser tLRPC$TL_peerUser9 = new TLRPC$TL_peerUser();
                    tLRPC$TL_message6.from_id = tLRPC$TL_peerUser9;
                    tLRPC$TL_peerUser9.user_id = tLRPC$TL_user2.id;
                    this.messages.add(new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message6, true, false));
                    TLRPC$TL_message tLRPC$TL_message7 = new TLRPC$TL_message();
                    tLRPC$TL_message7.message = "No.\nAnd every unnecessary ping of the dev delays the release for 10 days.\nEvery request for ETA delays the release for 2 weeks.";
                    tLRPC$TL_message7.date = i2;
                    tLRPC$TL_message7.dialog_id = -1L;
                    tLRPC$TL_message7.flags = 259;
                    tLRPC$TL_message7.id = 1;
                    tLRPC$TL_message7.media = new TLRPC$TL_messageMediaEmpty();
                    tLRPC$TL_message7.out = false;
                    TLRPC$TL_peerChat tLRPC$TL_peerChat2 = new TLRPC$TL_peerChat();
                    tLRPC$TL_message7.peer_id = tLRPC$TL_peerChat2;
                    tLRPC$TL_peerChat2.chat_id = 1L;
                    TLRPC$TL_peerUser tLRPC$TL_peerUser10 = new TLRPC$TL_peerUser();
                    tLRPC$TL_message7.from_id = tLRPC$TL_peerUser10;
                    tLRPC$TL_peerUser10.user_id = tLRPC$TL_user2.id;
                    this.messages.add(new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message7, true, false));
                    TLRPC$TL_message tLRPC$TL_message8 = new TLRPC$TL_message();
                    tLRPC$TL_message8.message = "Is source code for Android coming anytime soon?";
                    tLRPC$TL_message8.date = iCurrentTimeMillis + 600;
                    tLRPC$TL_message8.dialog_id = -1L;
                    tLRPC$TL_message8.flags = 259;
                    tLRPC$TL_message8.id = 1;
                    tLRPC$TL_message8.media = new TLRPC$TL_messageMediaEmpty();
                    tLRPC$TL_message8.out = false;
                    TLRPC$TL_peerChat tLRPC$TL_peerChat3 = new TLRPC$TL_peerChat();
                    tLRPC$TL_message8.peer_id = tLRPC$TL_peerChat3;
                    tLRPC$TL_peerChat3.chat_id = 1L;
                    TLRPC$TL_peerUser tLRPC$TL_peerUser11 = new TLRPC$TL_peerUser();
                    tLRPC$TL_message8.from_id = tLRPC$TL_peerUser11;
                    tLRPC$TL_peerUser11.user_id = tLRPC$TL_user.id;
                    this.messages.add(new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message8, true, false));
                    return;
                }
                TLRPC$TL_message tLRPC$TL_message9 = new TLRPC$TL_message();
                tLRPC$TL_message9.message = LocaleController.getString("ThemePreviewLine1", R.string.ThemePreviewLine1);
                int i3 = iCurrentTimeMillis + 60;
                tLRPC$TL_message9.date = i3;
                tLRPC$TL_message9.dialog_id = 1L;
                tLRPC$TL_message9.flags = 259;
                TLRPC$TL_peerUser tLRPC$TL_peerUser12 = new TLRPC$TL_peerUser();
                tLRPC$TL_message9.from_id = tLRPC$TL_peerUser12;
                tLRPC$TL_peerUser12.user_id = UserConfig.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).getClientUserId();
                tLRPC$TL_message9.id = 1;
                tLRPC$TL_message9.media = new TLRPC$TL_messageMediaEmpty();
                tLRPC$TL_message9.out = true;
                TLRPC$TL_peerUser tLRPC$TL_peerUser13 = new TLRPC$TL_peerUser();
                tLRPC$TL_message9.peer_id = tLRPC$TL_peerUser13;
                tLRPC$TL_peerUser13.user_id = 0L;
                MessageObject messageObject6 = new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message9, true, false);
                TLRPC$TL_message tLRPC$TL_message10 = new TLRPC$TL_message();
                tLRPC$TL_message10.message = LocaleController.getString("ThemePreviewLine2", R.string.ThemePreviewLine2);
                tLRPC$TL_message10.date = iCurrentTimeMillis + 960;
                tLRPC$TL_message10.dialog_id = 1L;
                tLRPC$TL_message10.flags = 259;
                TLRPC$TL_peerUser tLRPC$TL_peerUser14 = new TLRPC$TL_peerUser();
                tLRPC$TL_message10.from_id = tLRPC$TL_peerUser14;
                tLRPC$TL_peerUser14.user_id = UserConfig.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).getClientUserId();
                tLRPC$TL_message10.id = 1;
                tLRPC$TL_message10.media = new TLRPC$TL_messageMediaEmpty();
                tLRPC$TL_message10.out = true;
                TLRPC$TL_peerUser tLRPC$TL_peerUser15 = new TLRPC$TL_peerUser();
                tLRPC$TL_message10.peer_id = tLRPC$TL_peerUser15;
                tLRPC$TL_peerUser15.user_id = 0L;
                this.messages.add(new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message10, true, false));
                TLRPC$TL_message tLRPC$TL_message11 = new TLRPC$TL_message();
                tLRPC$TL_message11.date = iCurrentTimeMillis + 130;
                tLRPC$TL_message11.dialog_id = 1L;
                tLRPC$TL_message11.flags = 259;
                tLRPC$TL_message11.from_id = new TLRPC$TL_peerUser();
                tLRPC$TL_message11.id = 5;
                TLRPC$TL_messageMediaDocument tLRPC$TL_messageMediaDocument3 = new TLRPC$TL_messageMediaDocument();
                tLRPC$TL_message11.media = tLRPC$TL_messageMediaDocument3;
                tLRPC$TL_messageMediaDocument3.flags |= 3;
                tLRPC$TL_messageMediaDocument3.document = new TLRPC$TL_document();
                TLRPC$Document tLRPC$Document3 = tLRPC$TL_message11.media.document;
                tLRPC$Document3.mime_type = "audio/mp4";
                tLRPC$Document3.file_reference = new byte[0];
                TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio2 = new TLRPC$TL_documentAttributeAudio();
                tLRPC$TL_documentAttributeAudio2.duration = 243;
                tLRPC$TL_documentAttributeAudio2.performer = LocaleController.getString("ThemePreviewSongPerformer", R.string.ThemePreviewSongPerformer);
                tLRPC$TL_documentAttributeAudio2.title = LocaleController.getString("ThemePreviewSongTitle", R.string.ThemePreviewSongTitle);
                tLRPC$TL_message11.media.document.attributes.add(tLRPC$TL_documentAttributeAudio2);
                tLRPC$TL_message11.out = false;
                TLRPC$TL_peerUser tLRPC$TL_peerUser16 = new TLRPC$TL_peerUser();
                tLRPC$TL_message11.peer_id = tLRPC$TL_peerUser16;
                tLRPC$TL_peerUser16.user_id = UserConfig.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).getClientUserId();
                this.messages.add(new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message11, true, false));
                TLRPC$TL_message tLRPC$TL_message12 = new TLRPC$TL_message();
                tLRPC$TL_message12.message = LocaleController.getString("ThemePreviewLine3", R.string.ThemePreviewLine3);
                tLRPC$TL_message12.date = i3;
                tLRPC$TL_message12.dialog_id = 1L;
                tLRPC$TL_message12.flags = 265;
                tLRPC$TL_message12.from_id = new TLRPC$TL_peerUser();
                tLRPC$TL_message12.id = 1;
                TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader2 = new TLRPC$TL_messageReplyHeader();
                tLRPC$TL_message12.reply_to = tLRPC$TL_messageReplyHeader2;
                tLRPC$TL_messageReplyHeader2.reply_to_msg_id = 5;
                tLRPC$TL_message12.media = new TLRPC$TL_messageMediaEmpty();
                tLRPC$TL_message12.out = false;
                TLRPC$TL_peerUser tLRPC$TL_peerUser17 = new TLRPC$TL_peerUser();
                tLRPC$TL_message12.peer_id = tLRPC$TL_peerUser17;
                tLRPC$TL_peerUser17.user_id = UserConfig.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).getClientUserId();
                MessageObject messageObject7 = new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message12, true, false);
                messageObject7.customReplyName = LocaleController.getString("ThemePreviewLine3Reply", R.string.ThemePreviewLine3Reply);
                messageObject7.replyMessageObject = messageObject6;
                this.messages.add(messageObject7);
                TLRPC$TL_message tLRPC$TL_message13 = new TLRPC$TL_message();
                tLRPC$TL_message13.date = iCurrentTimeMillis + R.styleable.AppCompatTheme_windowNoTitle;
                tLRPC$TL_message13.dialog_id = 1L;
                tLRPC$TL_message13.flags = 259;
                TLRPC$TL_peerUser tLRPC$TL_peerUser18 = new TLRPC$TL_peerUser();
                tLRPC$TL_message13.from_id = tLRPC$TL_peerUser18;
                tLRPC$TL_peerUser18.user_id = UserConfig.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).getClientUserId();
                tLRPC$TL_message13.id = 1;
                TLRPC$TL_messageMediaDocument tLRPC$TL_messageMediaDocument4 = new TLRPC$TL_messageMediaDocument();
                tLRPC$TL_message13.media = tLRPC$TL_messageMediaDocument4;
                tLRPC$TL_messageMediaDocument4.flags |= 3;
                tLRPC$TL_messageMediaDocument4.document = new TLRPC$TL_document();
                TLRPC$Document tLRPC$Document4 = tLRPC$TL_message13.media.document;
                tLRPC$Document4.mime_type = "audio/ogg";
                tLRPC$Document4.file_reference = new byte[0];
                TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio3 = new TLRPC$TL_documentAttributeAudio();
                tLRPC$TL_documentAttributeAudio3.flags = 1028;
                tLRPC$TL_documentAttributeAudio3.duration = 3;
                tLRPC$TL_documentAttributeAudio3.voice = true;
                tLRPC$TL_documentAttributeAudio3.waveform = new byte[]{0, 4, 17, -50, -93, 86, -103, -45, -12, -26, 63, -25, -3, 109, -114, -54, -4, -1, -1, -1, -1, -29, -1, -1, -25, -1, -1, -97, -43, 57, -57, -108, 1, -91, -4, -47, 21, 99, 10, 97, 43, 45, 115, -112, -77, 51, -63, 66, 40, 34, -122, -116, 48, -124, 16, 66, -120, 16, 68, 16, 33, 4, 1};
                tLRPC$TL_message13.media.document.attributes.add(tLRPC$TL_documentAttributeAudio3);
                tLRPC$TL_message13.out = true;
                TLRPC$TL_peerUser tLRPC$TL_peerUser19 = new TLRPC$TL_peerUser();
                tLRPC$TL_message13.peer_id = tLRPC$TL_peerUser19;
                tLRPC$TL_peerUser19.user_id = 0L;
                MessageObject messageObject8 = new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message13, true, false);
                messageObject8.audioProgressSec = 1;
                messageObject8.audioProgress = 0.3f;
                messageObject8.useCustomPhoto = true;
                this.messages.add(messageObject8);
                this.messages.add(messageObject6);
                TLRPC$TL_message tLRPC$TL_message14 = new TLRPC$TL_message();
                tLRPC$TL_message14.date = iCurrentTimeMillis + 10;
                tLRPC$TL_message14.dialog_id = 1L;
                tLRPC$TL_message14.flags = 257;
                tLRPC$TL_message14.from_id = new TLRPC$TL_peerUser();
                tLRPC$TL_message14.id = 1;
                TLRPC$TL_messageMediaPhoto tLRPC$TL_messageMediaPhoto = new TLRPC$TL_messageMediaPhoto();
                tLRPC$TL_message14.media = tLRPC$TL_messageMediaPhoto;
                tLRPC$TL_messageMediaPhoto.flags |= 3;
                tLRPC$TL_messageMediaPhoto.photo = new TLRPC$TL_photo();
                TLRPC$Photo tLRPC$Photo = tLRPC$TL_message14.media.photo;
                tLRPC$Photo.file_reference = new byte[0];
                tLRPC$Photo.has_stickers = false;
                tLRPC$Photo.id = 1L;
                tLRPC$Photo.access_hash = 0L;
                tLRPC$Photo.date = iCurrentTimeMillis;
                TLRPC$TL_photoSize tLRPC$TL_photoSize = new TLRPC$TL_photoSize();
                tLRPC$TL_photoSize.size = 0;
                tLRPC$TL_photoSize.w = 500;
                tLRPC$TL_photoSize.h = 302;
                tLRPC$TL_photoSize.type = "s";
                tLRPC$TL_photoSize.location = new TLRPC$TL_fileLocationUnavailable();
                tLRPC$TL_message14.media.photo.sizes.add(tLRPC$TL_photoSize);
                tLRPC$TL_message14.message = LocaleController.getString("ThemePreviewLine4", R.string.ThemePreviewLine4);
                tLRPC$TL_message14.out = false;
                TLRPC$TL_peerUser tLRPC$TL_peerUser20 = new TLRPC$TL_peerUser();
                tLRPC$TL_message14.peer_id = tLRPC$TL_peerUser20;
                tLRPC$TL_peerUser20.user_id = UserConfig.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).getClientUserId();
                MessageObject messageObject9 = new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message14, true, false);
                messageObject9.useCustomPhoto = true;
                this.messages.add(messageObject9);
                return;
            }
            TLRPC$TL_message tLRPC$TL_message15 = new TLRPC$TL_message();
            if (ThemePreviewActivity.this.currentWallpaper instanceof WallpapersListActivity.ColorWallpaper) {
                tLRPC$TL_message15.message = LocaleController.getString("BackgroundColorSinglePreviewLine2", R.string.BackgroundColorSinglePreviewLine2);
            } else {
                tLRPC$TL_message15.message = LocaleController.getString("BackgroundPreviewLine2", R.string.BackgroundPreviewLine2);
            }
            int i4 = iCurrentTimeMillis + 60;
            tLRPC$TL_message15.date = i4;
            tLRPC$TL_message15.dialog_id = 1L;
            tLRPC$TL_message15.flags = 259;
            TLRPC$TL_peerUser tLRPC$TL_peerUser21 = new TLRPC$TL_peerUser();
            tLRPC$TL_message15.from_id = tLRPC$TL_peerUser21;
            tLRPC$TL_peerUser21.user_id = UserConfig.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).getClientUserId();
            tLRPC$TL_message15.id = 1;
            tLRPC$TL_message15.media = new TLRPC$TL_messageMediaEmpty();
            tLRPC$TL_message15.out = true;
            TLRPC$TL_peerUser tLRPC$TL_peerUser22 = new TLRPC$TL_peerUser();
            tLRPC$TL_message15.peer_id = tLRPC$TL_peerUser22;
            tLRPC$TL_peerUser22.user_id = 0L;
            MessageObject messageObject10 = new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message15, true, false);
            messageObject10.eventId = 1L;
            messageObject10.resetLayout();
            this.messages.add(messageObject10);
            TLRPC$TL_message tLRPC$TL_message16 = new TLRPC$TL_message();
            if (ThemePreviewActivity.this.currentWallpaper instanceof WallpapersListActivity.ColorWallpaper) {
                tLRPC$TL_message16.message = LocaleController.getString("BackgroundColorSinglePreviewLine1", R.string.BackgroundColorSinglePreviewLine1);
            } else {
                tLRPC$TL_message16.message = LocaleController.getString("BackgroundPreviewLine1", R.string.BackgroundPreviewLine1);
            }
            tLRPC$TL_message16.date = i4;
            tLRPC$TL_message16.dialog_id = 1L;
            tLRPC$TL_message16.flags = 265;
            tLRPC$TL_message16.from_id = new TLRPC$TL_peerUser();
            tLRPC$TL_message16.id = 1;
            tLRPC$TL_message16.media = new TLRPC$TL_messageMediaEmpty();
            tLRPC$TL_message16.out = false;
            TLRPC$TL_peerUser tLRPC$TL_peerUser23 = new TLRPC$TL_peerUser();
            tLRPC$TL_message16.peer_id = tLRPC$TL_peerUser23;
            tLRPC$TL_peerUser23.user_id = UserConfig.getInstance(((BaseFragment) ThemePreviewActivity.this).currentAccount).getClientUserId();
            MessageObject messageObject11 = new MessageObject(((BaseFragment) ThemePreviewActivity.this).currentAccount, tLRPC$TL_message16, true, false);
            messageObject11.eventId = 1L;
            messageObject11.resetLayout();
            this.messages.add(messageObject11);
        }

        private boolean hasButtons() {
            if (ThemePreviewActivity.this.messagesButtonsContainer != null && ThemePreviewActivity.this.screenType == 1 && ThemePreviewActivity.this.colorType == 3 && ThemePreviewActivity.this.accent.myMessagesGradientAccentColor2 != 0) {
                return true;
            }
            if (ThemePreviewActivity.this.backgroundButtonsContainer != null) {
                if (ThemePreviewActivity.this.screenType == 2) {
                    return true;
                }
                if (ThemePreviewActivity.this.screenType == 1 && ThemePreviewActivity.this.colorType == 2) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = this.messages.size();
            return hasButtons() ? size + 1 : size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            if (i == 0) {
                ChatMessageCell chatMessageCell = new ChatMessageCell(this.mContext, new Theme.ResourcesProvider() { // from class: ir.eitaa.ui.ThemePreviewActivity.MessagesAdapter.1
                    @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
                    public /* synthetic */ void applyServiceShaderMatrix(int i2, int i3, float f, float f2) {
                        Theme.applyServiceShaderMatrix(i2, i3, f, f2);
                    }

                    @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
                    public /* synthetic */ int getColorOrDefault(String str) {
                        return Theme.ResourcesProvider.CC.$default$getColorOrDefault(this, str);
                    }

                    @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
                    public /* synthetic */ Integer getCurrentColor(String str) {
                        return getColor(str);
                    }

                    @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
                    public /* synthetic */ Paint getPaint(String str) {
                        return Theme.ResourcesProvider.CC.$default$getPaint(this, str);
                    }

                    @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
                    public /* synthetic */ boolean hasGradientService() {
                        return Theme.ResourcesProvider.CC.$default$hasGradientService(this);
                    }

                    @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
                    public /* synthetic */ void setAnimatedColor(String str, int i2) {
                        Theme.ResourcesProvider.CC.$default$setAnimatedColor(this, str, i2);
                    }

                    @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
                    public Integer getColor(String key) {
                        return Integer.valueOf(Theme.getColor(key));
                    }

                    @Override // ir.eitaa.ui.ActionBar.Theme.ResourcesProvider
                    public Drawable getDrawable(String drawableKey) {
                        if (drawableKey.equals("drawableMsgOut")) {
                            return ThemePreviewActivity.this.msgOutDrawable;
                        }
                        if (drawableKey.equals("drawableMsgOutSelected")) {
                            return ThemePreviewActivity.this.msgOutDrawableSelected;
                        }
                        if (drawableKey.equals("drawableMsgOutMedia")) {
                            return ThemePreviewActivity.this.msgOutMediaDrawable;
                        }
                        if (drawableKey.equals("drawableMsgOutMediaSelected")) {
                            return ThemePreviewActivity.this.msgOutMediaDrawableSelected;
                        }
                        return Theme.getThemeDrawable(drawableKey);
                    }
                });
                chatMessageCell.setDelegate(new ChatMessageCell.ChatMessageCellDelegate() { // from class: ir.eitaa.ui.ThemePreviewActivity.MessagesAdapter.2
                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ boolean canPerformActions() {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$canPerformActions(this);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didLongPress(ChatMessageCell chatMessageCell2, float f, float f2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPress(this, chatMessageCell2, f, f2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ boolean didLongPressChannelAvatar(ChatMessageCell chatMessageCell2, TLRPC$Chat tLRPC$Chat, int i2, float f, float f2) {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPressChannelAvatar(this, chatMessageCell2, tLRPC$Chat, i2, f, f2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ boolean didLongPressUserAvatar(ChatMessageCell chatMessageCell2, TLRPC$User tLRPC$User, float f, float f2) {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPressUserAvatar(this, chatMessageCell2, tLRPC$User, f, f2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressBotButton(ChatMessageCell chatMessageCell2, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressBotButton(this, chatMessageCell2, tLRPC$KeyboardButton);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressCancelSendButton(ChatMessageCell chatMessageCell2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressCancelSendButton(this, chatMessageCell2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressChannelAvatar(ChatMessageCell chatMessageCell2, TLRPC$Chat tLRPC$Chat, int i2, float f, float f2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressChannelAvatar(this, chatMessageCell2, tLRPC$Chat, i2, f, f2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressCommentButton(ChatMessageCell chatMessageCell2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressCommentButton(this, chatMessageCell2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressHiddenForward(ChatMessageCell chatMessageCell2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressHiddenForward(this, chatMessageCell2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressHint(ChatMessageCell chatMessageCell2, int i2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressHint(this, chatMessageCell2, i2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressImage(ChatMessageCell chatMessageCell2, float f, float f2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressImage(this, chatMessageCell2, f, f2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressInstantButton(ChatMessageCell chatMessageCell2, int i2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressInstantButton(this, chatMessageCell2, i2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressOther(ChatMessageCell chatMessageCell2, float f, float f2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressOther(this, chatMessageCell2, f, f2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressReaction(ChatMessageCell chatMessageCell2, TLRPC$TL_reactionCount tLRPC$TL_reactionCount) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressReaction(this, chatMessageCell2, tLRPC$TL_reactionCount);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressReplyMessage(ChatMessageCell chatMessageCell2, int i2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressReplyMessage(this, chatMessageCell2, i2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressSideButton(ChatMessageCell chatMessageCell2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressSideButton(this, chatMessageCell2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressTime(ChatMessageCell chatMessageCell2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressTime(this, chatMessageCell2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressUrl(ChatMessageCell chatMessageCell2, CharacterStyle characterStyle, boolean z) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressUrl(this, chatMessageCell2, characterStyle, z);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressUserAvatar(ChatMessageCell chatMessageCell2, TLRPC$User tLRPC$User, float f, float f2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressUserAvatar(this, chatMessageCell2, tLRPC$User, f, f2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressViaBot(ChatMessageCell chatMessageCell2, String str) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressViaBot(this, chatMessageCell2, str);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressVoteButtons(ChatMessageCell chatMessageCell2, ArrayList arrayList, int i2, int i3, int i4) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressVoteButtons(this, chatMessageCell2, arrayList, i2, i3, i4);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didPressedShareToMine(ChatMessageCell chatMessageCell2) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressedShareToMine(this, chatMessageCell2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void didStartVideoStream(MessageObject messageObject) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$didStartVideoStream(this, messageObject);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ String getAdminRank(long j) {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getAdminRank(this, j);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ PinchToZoomHelper getPinchToZoomHelper() {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getPinchToZoomHelper(this);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ TextSelectionHelper.ChatListTextSelectionHelper getTextSelectionHelper() {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getTextSelectionHelper(this);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ boolean hasSelectedMessages() {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$hasSelectedMessages(this);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ boolean isLandscape() {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$isLandscape(this);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ boolean keyboardIsOpened() {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$keyboardIsOpened(this);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void needOpenWebView(MessageObject messageObject, String str, String str2, String str3, String str4, int i2, int i3) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$needOpenWebView(this, messageObject, str, str2, str3, str4, i2, i3);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ boolean needPlayMessage(MessageObject messageObject) {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$needPlayMessage(this, messageObject);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void needReloadPolls() {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$needReloadPolls(this);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void onDiceFinished() {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$onDiceFinished(this);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void setShouldNotRepeatSticker(MessageObject messageObject) {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$setShouldNotRepeatSticker(this, messageObject);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ boolean shouldDrawThreadProgress(ChatMessageCell chatMessageCell2) {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$shouldDrawThreadProgress(this, chatMessageCell2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ boolean shouldRepeatSticker(MessageObject messageObject) {
                        return ChatMessageCell.ChatMessageCellDelegate.CC.$default$shouldRepeatSticker(this, messageObject);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                    public /* synthetic */ void videoTimerReached() {
                        ChatMessageCell.ChatMessageCellDelegate.CC.$default$videoTimerReached(this);
                    }
                });
                frameLayout = chatMessageCell;
            } else if (i == 1) {
                ChatActionCell chatActionCell = new ChatActionCell(this.mContext);
                chatActionCell.setDelegate(new ChatActionCell.ChatActionCellDelegate() { // from class: ir.eitaa.ui.ThemePreviewActivity.MessagesAdapter.3
                    @Override // ir.eitaa.ui.Cells.ChatActionCell.ChatActionCellDelegate
                    public /* synthetic */ void didClickImage(ChatActionCell chatActionCell2) {
                        ChatActionCell.ChatActionCellDelegate.CC.$default$didClickImage(this, chatActionCell2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatActionCell.ChatActionCellDelegate
                    public /* synthetic */ void didLongPress(ChatActionCell chatActionCell2, float f, float f2) {
                        ChatActionCell.ChatActionCellDelegate.CC.$default$didLongPress(this, chatActionCell2, f, f2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatActionCell.ChatActionCellDelegate
                    public /* synthetic */ void didPressReplyMessage(ChatActionCell chatActionCell2, int i2) {
                        ChatActionCell.ChatActionCellDelegate.CC.$default$didPressReplyMessage(this, chatActionCell2, i2);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatActionCell.ChatActionCellDelegate
                    public /* synthetic */ void needOpenInviteLink(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
                        ChatActionCell.ChatActionCellDelegate.CC.$default$needOpenInviteLink(this, tLRPC$TL_chatInviteExported);
                    }

                    @Override // ir.eitaa.ui.Cells.ChatActionCell.ChatActionCellDelegate
                    public /* synthetic */ void needOpenUserProfile(long j) {
                        ChatActionCell.ChatActionCellDelegate.CC.$default$needOpenUserProfile(this, j);
                    }
                });
                frameLayout = chatActionCell;
            } else if (i == 2) {
                if (ThemePreviewActivity.this.backgroundButtonsContainer.getParent() != null) {
                    ((ViewGroup) ThemePreviewActivity.this.backgroundButtonsContainer.getParent()).removeView(ThemePreviewActivity.this.backgroundButtonsContainer);
                }
                FrameLayout frameLayout2 = new FrameLayout(this.mContext) { // from class: ir.eitaa.ui.ThemePreviewActivity.MessagesAdapter.4
                    @Override // android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(60.0f), 1073741824));
                    }
                };
                frameLayout2.addView(ThemePreviewActivity.this.backgroundButtonsContainer, LayoutHelper.createFrame(-1, 76, 17));
                frameLayout = frameLayout2;
            } else {
                if (ThemePreviewActivity.this.messagesButtonsContainer.getParent() != null) {
                    ((ViewGroup) ThemePreviewActivity.this.messagesButtonsContainer.getParent()).removeView(ThemePreviewActivity.this.messagesButtonsContainer);
                }
                FrameLayout frameLayout3 = new FrameLayout(this.mContext) { // from class: ir.eitaa.ui.ThemePreviewActivity.MessagesAdapter.5
                    @Override // android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(60.0f), 1073741824));
                    }
                };
                frameLayout3.addView(ThemePreviewActivity.this.messagesButtonsContainer, LayoutHelper.createFrame(-1, 76, 17));
                frameLayout = frameLayout3;
            }
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(frameLayout);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r10, int r11) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
            /*
                r9 = this;
                int r0 = r10.getItemViewType()
                r1 = 2
                if (r0 == r1) goto Lb7
                r1 = 3
                if (r0 == r1) goto Lb7
                boolean r0 = r9.hasButtons()
                if (r0 == 0) goto L12
                int r11 = r11 + (-1)
            L12:
                java.util.ArrayList<ir.eitaa.messenger.MessageObject> r0 = r9.messages
                java.lang.Object r0 = r0.get(r11)
                ir.eitaa.messenger.MessageObject r0 = (ir.eitaa.messenger.MessageObject) r0
                android.view.View r1 = r10.itemView
                boolean r2 = r1 instanceof ir.eitaa.ui.Cells.ChatMessageCell
                if (r2 == 0) goto La9
                ir.eitaa.ui.Cells.ChatMessageCell r1 = (ir.eitaa.ui.Cells.ChatMessageCell) r1
                r2 = 0
                r1.isChat = r2
                int r3 = r11 + (-1)
                int r4 = r9.getItemViewType(r3)
                r5 = 1
                int r11 = r11 + r5
                int r6 = r9.getItemViewType(r11)
                ir.eitaa.tgnet.TLRPC$Message r7 = r0.messageOwner
                ir.eitaa.tgnet.TLRPC$ReplyMarkup r7 = r7.reply_markup
                boolean r7 = r7 instanceof ir.eitaa.tgnet.TLRPC$TL_replyInlineMarkup
                r8 = 300(0x12c, float:4.2E-43)
                if (r7 != 0) goto L64
                int r7 = r10.getItemViewType()
                if (r4 != r7) goto L64
                java.util.ArrayList<ir.eitaa.messenger.MessageObject> r4 = r9.messages
                java.lang.Object r3 = r4.get(r3)
                ir.eitaa.messenger.MessageObject r3 = (ir.eitaa.messenger.MessageObject) r3
                boolean r4 = r3.isOutOwner()
                boolean r7 = r0.isOutOwner()
                if (r4 != r7) goto L64
                ir.eitaa.tgnet.TLRPC$Message r3 = r3.messageOwner
                int r3 = r3.date
                ir.eitaa.tgnet.TLRPC$Message r4 = r0.messageOwner
                int r4 = r4.date
                int r3 = r3 - r4
                int r3 = java.lang.Math.abs(r3)
                if (r3 > r8) goto L64
                r3 = 1
                goto L65
            L64:
                r3 = 0
            L65:
                int r10 = r10.getItemViewType()
                if (r6 != r10) goto L9d
                java.util.ArrayList<ir.eitaa.messenger.MessageObject> r10 = r9.messages
                int r10 = r10.size()
                if (r11 >= r10) goto L9d
                java.util.ArrayList<ir.eitaa.messenger.MessageObject> r10 = r9.messages
                java.lang.Object r10 = r10.get(r11)
                ir.eitaa.messenger.MessageObject r10 = (ir.eitaa.messenger.MessageObject) r10
                ir.eitaa.tgnet.TLRPC$Message r11 = r10.messageOwner
                ir.eitaa.tgnet.TLRPC$ReplyMarkup r11 = r11.reply_markup
                boolean r11 = r11 instanceof ir.eitaa.tgnet.TLRPC$TL_replyInlineMarkup
                if (r11 != 0) goto L9d
                boolean r11 = r10.isOutOwner()
                boolean r4 = r0.isOutOwner()
                if (r11 != r4) goto L9d
                ir.eitaa.tgnet.TLRPC$Message r10 = r10.messageOwner
                int r10 = r10.date
                ir.eitaa.tgnet.TLRPC$Message r11 = r0.messageOwner
                int r11 = r11.date
                int r10 = r10 - r11
                int r10 = java.lang.Math.abs(r10)
                if (r10 > r8) goto L9d
                r2 = 1
            L9d:
                boolean r10 = r9.showSecretMessages
                r1.isChat = r10
                r1.setFullyDraw(r5)
                r10 = 0
                r1.setMessageObject(r0, r10, r3, r2)
                goto Lb7
            La9:
                boolean r10 = r1 instanceof ir.eitaa.ui.Cells.ChatActionCell
                if (r10 == 0) goto Lb7
                ir.eitaa.ui.Cells.ChatActionCell r1 = (ir.eitaa.ui.Cells.ChatActionCell) r1
                r1.setMessageObject(r0)
                r10 = 1065353216(0x3f800000, float:1.0)
                r1.setAlpha(r10)
            Lb7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ThemePreviewActivity.MessagesAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (hasButtons()) {
                if (position == 0) {
                    return ThemePreviewActivity.this.colorType == 3 ? 3 : 2;
                }
                position--;
            }
            if (position < 0 || position >= this.messages.size()) {
                return 4;
            }
            return this.messages.get(position).contentType;
        }
    }

    private class PatternsAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        public PatternsAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (ThemePreviewActivity.this.patterns != null) {
                return ThemePreviewActivity.this.patterns.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerListView.Holder(new PatternCell(this.mContext, ThemePreviewActivity.this.maxWallpaperSize, new PatternCell.PatternCellDelegate() { // from class: ir.eitaa.ui.ThemePreviewActivity.PatternsAdapter.1
                @Override // ir.eitaa.ui.Cells.PatternCell.PatternCellDelegate
                public TLRPC$TL_wallPaper getSelectedPattern() {
                    return ThemePreviewActivity.this.selectedPattern;
                }

                @Override // ir.eitaa.ui.Cells.PatternCell.PatternCellDelegate
                public int getCheckColor() {
                    return ThemePreviewActivity.this.checkColor;
                }

                @Override // ir.eitaa.ui.Cells.PatternCell.PatternCellDelegate
                public int getBackgroundColor() {
                    if (ThemePreviewActivity.this.screenType == 2) {
                        return ThemePreviewActivity.this.backgroundColor;
                    }
                    int defaultAccentColor = Theme.getDefaultAccentColor("chat_wallpaper");
                    int i = (int) ThemePreviewActivity.this.accent.backgroundOverrideColor;
                    return i != 0 ? i : defaultAccentColor;
                }

                @Override // ir.eitaa.ui.Cells.PatternCell.PatternCellDelegate
                public int getBackgroundGradientColor1() {
                    if (ThemePreviewActivity.this.screenType == 2) {
                        return ThemePreviewActivity.this.backgroundGradientColor1;
                    }
                    int defaultAccentColor = Theme.getDefaultAccentColor("chat_wallpaper_gradient_to");
                    int i = (int) ThemePreviewActivity.this.accent.backgroundGradientOverrideColor1;
                    return i != 0 ? i : defaultAccentColor;
                }

                @Override // ir.eitaa.ui.Cells.PatternCell.PatternCellDelegate
                public int getBackgroundGradientColor2() {
                    if (ThemePreviewActivity.this.screenType == 2) {
                        return ThemePreviewActivity.this.backgroundGradientColor2;
                    }
                    int defaultAccentColor = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to2");
                    int i = (int) ThemePreviewActivity.this.accent.backgroundGradientOverrideColor2;
                    return i != 0 ? i : defaultAccentColor;
                }

                @Override // ir.eitaa.ui.Cells.PatternCell.PatternCellDelegate
                public int getBackgroundGradientColor3() {
                    if (ThemePreviewActivity.this.screenType == 2) {
                        return ThemePreviewActivity.this.backgroundGradientColor3;
                    }
                    int defaultAccentColor = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to3");
                    int i = (int) ThemePreviewActivity.this.accent.backgroundGradientOverrideColor3;
                    return i != 0 ? i : defaultAccentColor;
                }

                @Override // ir.eitaa.ui.Cells.PatternCell.PatternCellDelegate
                public int getBackgroundGradientAngle() {
                    return ThemePreviewActivity.this.screenType == 2 ? ThemePreviewActivity.this.backgroundRotation : ThemePreviewActivity.this.accent.backgroundRotation;
                }

                @Override // ir.eitaa.ui.Cells.PatternCell.PatternCellDelegate
                public float getIntensity() {
                    return ThemePreviewActivity.this.currentIntensity;
                }

                @Override // ir.eitaa.ui.Cells.PatternCell.PatternCellDelegate
                public int getPatternColor() {
                    return ThemePreviewActivity.this.patternColor;
                }
            }));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            PatternCell patternCell = (PatternCell) holder.itemView;
            patternCell.setPattern((TLRPC$TL_wallPaper) ThemePreviewActivity.this.patterns.get(position));
            patternCell.getImageReceiver().setColorFilter(new PorterDuffColorFilter(ThemePreviewActivity.this.patternColor, ThemePreviewActivity.this.blendMode));
            if (Build.VERSION.SDK_INT >= 29) {
                int i = 0;
                if (ThemePreviewActivity.this.screenType != 1) {
                    if (ThemePreviewActivity.this.currentWallpaper instanceof WallpapersListActivity.ColorWallpaper) {
                        i = ThemePreviewActivity.this.backgroundGradientColor2;
                    }
                } else {
                    int defaultAccentColor = Theme.getDefaultAccentColor("key_chat_wallpaper_gradient_to2");
                    int i2 = (int) ThemePreviewActivity.this.accent.backgroundGradientOverrideColor2;
                    if (i2 != 0 || ThemePreviewActivity.this.accent.backgroundGradientOverrideColor2 == 0) {
                        if (i2 != 0) {
                            defaultAccentColor = i2;
                        }
                        i = defaultAccentColor;
                    }
                }
                if (i != 0 && ThemePreviewActivity.this.currentIntensity >= 0.0f) {
                    ThemePreviewActivity.this.backgroundImage.getImageReceiver().setBlendMode(BlendMode.SOFT_LIGHT);
                } else {
                    patternCell.getImageReceiver().setBlendMode(null);
                }
            }
        }
    }

    private List<ThemeDescription> getThemeDescriptionsInternal() {
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ThemePreviewActivity$MiF3LWu0H_mvxckJvsCXivv3rbY
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptionsInternal$26$ThemePreviewActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ThemeDescription(this.page1, ThemeDescription.FLAG_BACKGROUND, null, null, null, themeDescriptionDelegate, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.viewPager, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "actionBarDefaultSearch"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "actionBarDefaultSearchPlaceholder"));
        arrayList.add(new ThemeDescription(this.actionBar2, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar2, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar2, ThemeDescription.FLAG_AB_SUBTITLECOLOR, null, null, null, null, "actionBarDefaultSubtitle"));
        arrayList.add(new ThemeDescription(this.actionBar2, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar2, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.actionBar2, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView2, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chats_actionIcon"));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "chats_actionBackground"));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "chats_actionPressedBackground"));
        if (!this.useDefaultThemeForButtons) {
            arrayList.add(new ThemeDescription(this.saveButtonsContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
            arrayList.add(new ThemeDescription(this.cancelButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "chat_fieldOverlayText"));
            arrayList.add(new ThemeDescription(this.doneButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "chat_fieldOverlayText"));
        }
        ColorPicker colorPicker = this.colorPicker;
        if (colorPicker != null) {
            colorPicker.provideThemeDescriptions(arrayList);
        }
        if (this.patternLayout != null) {
            for (int i = 0; i < this.patternLayout.length; i++) {
                arrayList.add(new ThemeDescription(this.patternLayout[i], 0, null, null, new Drawable[]{Theme.chat_composeShadowDrawable}, null, "chat_messagePanelShadow"));
                arrayList.add(new ThemeDescription(this.patternLayout[i], 0, null, Theme.chat_composeBackgroundPaint, null, null, "chat_messagePanelBackground"));
            }
            for (int i2 = 0; i2 < this.patternsButtonsContainer.length; i2++) {
                arrayList.add(new ThemeDescription(this.patternsButtonsContainer[i2], 0, null, null, new Drawable[]{Theme.chat_composeShadowDrawable}, null, "chat_messagePanelShadow"));
                arrayList.add(new ThemeDescription(this.patternsButtonsContainer[i2], 0, null, Theme.chat_composeBackgroundPaint, null, null, "chat_messagePanelBackground"));
            }
            arrayList.add(new ThemeDescription(this.bottomOverlayChat, 0, null, null, new Drawable[]{Theme.chat_composeShadowDrawable}, null, "chat_messagePanelShadow"));
            arrayList.add(new ThemeDescription(this.bottomOverlayChat, 0, null, Theme.chat_composeBackgroundPaint, null, null, "chat_messagePanelBackground"));
            arrayList.add(new ThemeDescription(this.bottomOverlayChatText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "chat_fieldOverlayText"));
            for (int i3 = 0; i3 < this.patternsSaveButton.length; i3++) {
                arrayList.add(new ThemeDescription(this.patternsSaveButton[i3], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "chat_fieldOverlayText"));
            }
            for (int i4 = 0; i4 < this.patternsCancelButton.length; i4++) {
                arrayList.add(new ThemeDescription(this.patternsCancelButton[i4], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "chat_fieldOverlayText"));
            }
            arrayList.add(new ThemeDescription(this.intensitySeekBar, 0, new Class[]{SeekBarView.class}, new String[]{"innerPaint1"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progressBackground"));
            arrayList.add(new ThemeDescription(this.intensitySeekBar, 0, new Class[]{SeekBarView.class}, new String[]{"outerPaint1"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progress"));
            arrayList.add(new ThemeDescription(this.intensityCell, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgInDrawable, Theme.chat_msgInMediaDrawable}, null, "chat_inBubble"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgInSelectedDrawable, Theme.chat_msgInMediaSelectedDrawable}, null, "chat_inBubbleSelected"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgInDrawable.getShadowDrawables(), null, "chat_inBubbleShadow"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgInMediaDrawable.getShadowDrawables(), null, "chat_inBubbleShadow"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{this.msgOutDrawable, this.msgOutMediaDrawable}, null, "chat_outBubble"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{this.msgOutDrawable, this.msgOutMediaDrawable}, null, "chat_outBubbleGradient"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{this.msgOutDrawable, this.msgOutMediaDrawable}, null, "chat_outBubbleGradient2"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{this.msgOutDrawable, this.msgOutMediaDrawable}, null, "chat_outBubbleGradient3"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutSelectedDrawable, Theme.chat_msgOutMediaSelectedDrawable}, null, "chat_outBubbleSelected"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgOutDrawable.getShadowDrawables(), null, "chat_outBubbleShadow"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, Theme.chat_msgOutMediaDrawable.getShadowDrawables(), null, "chat_outBubbleShadow"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_messageTextIn"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_messageTextOut"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckDrawable}, null, "chat_outSentCheck"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckSelectedDrawable}, null, "chat_outSentCheckSelected"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckReadDrawable, Theme.chat_msgOutHalfCheckDrawable}, null, "chat_outSentCheckRead"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgOutCheckReadSelectedDrawable, Theme.chat_msgOutHalfCheckSelectedDrawable}, null, "chat_outSentCheckReadSelected"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, new Drawable[]{Theme.chat_msgMediaCheckDrawable, Theme.chat_msgMediaHalfCheckDrawable}, null, "chat_mediaSentCheck"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inReplyLine"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outReplyLine"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inReplyNameText"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outReplyNameText"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inReplyMessageText"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outReplyMessageText"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inReplyMediaMessageSelectedText"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outReplyMediaMessageSelectedText"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inTimeText"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outTimeText"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_inTimeSelectedText"));
            arrayList.add(new ThemeDescription(this.listView2, 0, new Class[]{ChatMessageCell.class}, null, null, null, "chat_outTimeSelectedText"));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptionsInternal$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptionsInternal$26$ThemePreviewActivity() {
        ActionBarMenuItem actionBarMenuItem = this.dropDownContainer;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.redrawPopup(Theme.getColor("actionBarDefaultSubmenuBackground"));
            this.dropDownContainer.setPopupItemsColor(Theme.getColor("actionBarDefaultSubmenuItem"), false);
        }
        Drawable drawable = this.sheetDrawable;
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhite"), PorterDuff.Mode.MULTIPLY));
        }
    }
}
