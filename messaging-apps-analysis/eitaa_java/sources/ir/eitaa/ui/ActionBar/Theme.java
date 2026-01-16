package ir.eitaa.ui.ActionBar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.StateSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.time.SunDate;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$BaseTheme;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$TL_account_getMultiWallPapers;
import ir.eitaa.tgnet.TLRPC$TL_account_getThemes;
import ir.eitaa.tgnet.TLRPC$TL_account_getWallPaper;
import ir.eitaa.tgnet.TLRPC$TL_baseThemeArctic;
import ir.eitaa.tgnet.TLRPC$TL_baseThemeClassic;
import ir.eitaa.tgnet.TLRPC$TL_baseThemeDay;
import ir.eitaa.tgnet.TLRPC$TL_baseThemeNight;
import ir.eitaa.tgnet.TLRPC$TL_baseThemeTinted;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputWallPaperSlug;
import ir.eitaa.tgnet.TLRPC$TL_theme;
import ir.eitaa.tgnet.TLRPC$TL_wallPaper;
import ir.eitaa.tgnet.TLRPC$TL_wallPaperNoFile;
import ir.eitaa.tgnet.TLRPC$Theme;
import ir.eitaa.tgnet.TLRPC$ThemeSettings;
import ir.eitaa.tgnet.TLRPC$WallPaper;
import ir.eitaa.tgnet.TLRPC$WallPaperSettings;
import ir.eitaa.ui.Cells.ThemesHorizontalListCell;
import ir.eitaa.ui.Components.AudioVisualizerDrawable;
import ir.eitaa.ui.Components.BackgroundGradientDrawable;
import ir.eitaa.ui.Components.ChoosingStickerStatusDrawable;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.FragmentContextViewWavesDrawable;
import ir.eitaa.ui.Components.MotionBackgroundDrawable;
import ir.eitaa.ui.Components.MsgClockDrawable;
import ir.eitaa.ui.Components.PathAnimator;
import ir.eitaa.ui.Components.PlayingGameDrawable;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RecordStatusDrawable;
import ir.eitaa.ui.Components.RoundStatusDrawable;
import ir.eitaa.ui.Components.ScamDrawable;
import ir.eitaa.ui.Components.SendingFileDrawable;
import ir.eitaa.ui.Components.StatusDrawable;
import ir.eitaa.ui.Components.ThemeEditorView;
import ir.eitaa.ui.Components.TypingDotsDrawable;
import ir.eitaa.ui.RoundVideoProgressShadow;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class Theme {
    private static Method StateListDrawable_getStateDrawableMethod = null;
    private static SensorEventListener ambientSensorListener = null;
    private static HashMap<MessageObject, AudioVisualizerDrawable> animatedOutVisualizerDrawables = null;
    private static HashMap<String, Integer> animatingColors = null;
    public static float autoNightBrighnessThreshold = 0.0f;
    public static String autoNightCityName = null;
    public static int autoNightDayEndTime = 0;
    public static int autoNightDayStartTime = 0;
    public static int autoNightLastSunCheckDay = 0;
    public static double autoNightLocationLatitude = 0.0d;
    public static double autoNightLocationLongitude = 0.0d;
    public static boolean autoNightScheduleByLocation = false;
    public static int autoNightSunriseTime = 0;
    public static int autoNightSunsetTime = 0;
    public static Paint avatar_backgroundPaint = null;
    public static Drawable avatar_broadcastDrawable = null;
    public static Drawable avatar_photoDrawable = null;
    private static BackgroundGradientDrawable.Disposable backgroundGradientDisposable = null;
    public static Drawable calllog_msgCallDownGreenDrawable = null;
    public static Drawable calllog_msgCallDownRedDrawable = null;
    public static Drawable calllog_msgCallUpGreenDrawable = null;
    public static Drawable calllog_msgCallUpRedDrawable = null;
    private static boolean canStartHolidayAnimation = false;
    private static boolean changingWallpaper = false;
    public static Paint chat_actionBackgroundGradientDarkenPaint = null;
    public static Paint chat_actionBackgroundPaint = null;
    public static Paint chat_actionBackgroundPaint2 = null;
    public static Paint chat_actionBackgroundSelectedPaint = null;
    public static Paint chat_actionBackgroundSelectedPaint2 = null;
    public static TextPaint chat_actionTextPaint = null;
    public static TextPaint chat_adminPaint = null;
    public static Drawable chat_attachEmptyDrawable = null;
    public static TextPaint chat_audioPerformerPaint = null;
    public static TextPaint chat_audioTimePaint = null;
    public static TextPaint chat_audioTitlePaint = null;
    public static TextPaint chat_botButtonPaint = null;
    public static Drawable chat_botCardDrawalbe = null;
    public static Drawable chat_botInlineDrawable = null;
    public static Drawable chat_botLinkDrawalbe = null;
    public static Paint chat_botProgressPaint = null;
    public static Drawable chat_commentArrowDrawable = null;
    public static Drawable chat_commentDrawable = null;
    public static Drawable chat_commentStickerDrawable = null;
    public static Paint chat_composeBackgroundPaint = null;
    public static Drawable chat_composeShadowDrawable = null;
    public static Drawable chat_composeShadowRoundDrawable = null;
    public static TextPaint chat_contactNamePaint = null;
    public static TextPaint chat_contactPhonePaint = null;
    public static TextPaint chat_contextResult_descriptionTextPaint = null;
    public static Drawable chat_contextResult_shadowUnderSwitchDrawable = null;
    public static TextPaint chat_contextResult_titleTextPaint = null;
    public static Paint chat_deleteProgressPaint = null;
    public static Paint chat_docBackPaint = null;
    public static TextPaint chat_docNamePaint = null;
    public static TextPaint chat_durationPaint = null;
    public static Drawable chat_eitaaPayDrawable = null;
    public static Drawable chat_flameIcon = null;
    public static TextPaint chat_forwardNamePaint = null;
    public static TextPaint chat_gamePaint = null;
    public static Drawable chat_gifIcon = null;
    public static Drawable chat_goIconDrawable = null;
    public static TextPaint chat_infoPaint = null;
    public static Drawable chat_inlineResultAudio = null;
    public static Drawable chat_inlineResultFile = null;
    public static Drawable chat_inlineResultLocation = null;
    public static TextPaint chat_instantViewPaint = null;
    public static Paint chat_instantViewRectPaint = null;
    public static Drawable chat_liveMessageIconDrawable = null;
    public static TextPaint chat_livePaint = null;
    public static Drawable chat_liveTotalViewerDrawable = null;
    public static TextPaint chat_locationAddressPaint = null;
    public static TextPaint chat_locationTitlePaint = null;
    public static Drawable chat_lockIconDrawable = null;
    private static AudioVisualizerDrawable chat_msgAudioVisualizeDrawable = null;
    public static Drawable chat_msgAvatarLiveLocationDrawable = null;
    public static TextPaint chat_msgBotButtonPaint = null;
    public static Drawable chat_msgBroadcastDrawable = null;
    public static Drawable chat_msgBroadcastMediaDrawable = null;
    public static Drawable chat_msgCallDownGreenDrawable = null;
    public static Drawable chat_msgCallDownRedDrawable = null;
    public static Drawable chat_msgCallUpGreenDrawable = null;
    public static MsgClockDrawable chat_msgClockDrawable = null;
    public static Drawable chat_msgErrorDrawable = null;
    public static Paint chat_msgErrorPaint = null;
    public static TextPaint chat_msgGameTextPaint = null;
    public static MessageDrawable chat_msgInDrawable = null;
    public static Drawable chat_msgInInstantDrawable = null;
    public static MessageDrawable chat_msgInMediaDrawable = null;
    public static MessageDrawable chat_msgInMediaSelectedDrawable = null;
    public static Drawable chat_msgInMenuDrawable = null;
    public static Drawable chat_msgInMenuSelectedDrawable = null;
    public static Drawable chat_msgInPinnedDrawable = null;
    public static Drawable chat_msgInPinnedSelectedDrawable = null;
    public static Drawable chat_msgInRepliesDrawable = null;
    public static Drawable chat_msgInRepliesSelectedDrawable = null;
    public static MessageDrawable chat_msgInSelectedDrawable = null;
    public static Drawable chat_msgInViewsDrawable = null;
    public static Drawable chat_msgInViewsSelectedDrawable = null;
    public static Drawable chat_msgMediaCheckDrawable = null;
    public static Drawable chat_msgMediaHalfCheckDrawable = null;
    public static Drawable chat_msgMediaMenuDrawable = null;
    public static Drawable chat_msgMediaPinnedDrawable = null;
    public static Drawable chat_msgMediaRepliesDrawable = null;
    public static Drawable chat_msgMediaViewsDrawable = null;
    public static Drawable chat_msgNoSoundDrawable = null;
    public static Drawable chat_msgOutCheckDrawable = null;
    public static Drawable chat_msgOutCheckReadDrawable = null;
    public static Drawable chat_msgOutCheckReadSelectedDrawable = null;
    public static Drawable chat_msgOutCheckSelectedDrawable = null;
    public static MessageDrawable chat_msgOutDrawable = null;
    public static Drawable chat_msgOutHalfCheckDrawable = null;
    public static Drawable chat_msgOutHalfCheckSelectedDrawable = null;
    public static Drawable chat_msgOutInstantDrawable = null;
    public static MessageDrawable chat_msgOutMediaDrawable = null;
    public static MessageDrawable chat_msgOutMediaSelectedDrawable = null;
    public static Drawable chat_msgOutMenuDrawable = null;
    public static Drawable chat_msgOutMenuSelectedDrawable = null;
    public static Drawable chat_msgOutPinnedDrawable = null;
    public static Drawable chat_msgOutPinnedSelectedDrawable = null;
    public static Drawable chat_msgOutRepliesDrawable = null;
    public static Drawable chat_msgOutRepliesSelectedDrawable = null;
    public static MessageDrawable chat_msgOutSelectedDrawable = null;
    public static Drawable chat_msgOutViewsDrawable = null;
    public static Drawable chat_msgOutViewsSelectedDrawable = null;
    public static Drawable chat_msgStickerCheckDrawable = null;
    public static Drawable chat_msgStickerHalfCheckDrawable = null;
    public static Drawable chat_msgStickerPinnedDrawable = null;
    public static Drawable chat_msgStickerRepliesDrawable = null;
    public static Drawable chat_msgStickerViewsDrawable = null;
    public static TextPaint chat_msgTextPaint = null;
    public static TextPaint chat_msgTextPaintOneEmoji = null;
    public static TextPaint chat_msgTextPaintThreeEmoji = null;
    public static TextPaint chat_msgTextPaintTwoEmoji = null;
    public static Drawable chat_muteIconDrawable = null;
    public static TextPaint chat_namePaint = null;
    public static Paint chat_pollTimerPaint = null;
    public static Paint chat_radialProgress2Paint = null;
    public static Paint chat_radialProgressPaint = null;
    public static Paint chat_radialProgressPausedPaint = null;
    public static Paint chat_radialProgressPausedSeekbarPaint = null;
    public static Drawable chat_redLocationIcon = null;
    public static Drawable chat_replyIconDrawable = null;
    public static Paint chat_replyLinePaint = null;
    public static TextPaint chat_replyNamePaint = null;
    public static TextPaint chat_replyTextPaint = null;
    public static Drawable chat_roundVideoShadow = null;
    public static Drawable chat_saveToMyCloudIconDrawable = null;
    public static Drawable chat_saveToMyCloudIconSelectedDrawable = null;
    public static Drawable chat_shareIconDrawable = null;
    public static TextPaint chat_shipmentPaint = null;
    public static Paint chat_statusPaint = null;
    public static Paint chat_statusRecordPaint = null;
    public static TextPaint chat_stickerCommentCountPaint = null;
    public static Paint chat_textSearchSelectionPaint = null;
    public static Paint chat_timeBackgroundPaint = null;
    public static TextPaint chat_timePaint = null;
    public static Paint chat_urlPaint = null;
    public static Paint checkboxSquare_backgroundPaint = null;
    public static Paint checkboxSquare_checkPaint = null;
    public static Paint checkboxSquare_eraserPaint = null;
    public static int currentColor = 0;
    public static HashMap<String, Integer> currentColors = null;
    private static HashMap<String, Integer> currentColorsNoAccent = null;
    private static ThemeInfo currentDayTheme = null;
    public static ThemeInfo currentNightTheme = null;
    private static ThemeInfo currentTheme = null;
    public static String currentThemeType = null;
    private static ThemeInfo defaultTheme = null;
    public static Drawable dialogs_MediaDrawable = null;
    public static Paint dialogs_actionMessagePaint = null;
    public static RLottieDrawable dialogs_archiveAvatarDrawable = null;
    public static boolean dialogs_archiveAvatarDrawableRecolored = false;
    public static RLottieDrawable dialogs_archiveDrawable = null;
    public static boolean dialogs_archiveDrawableRecolored = false;
    public static TextPaint dialogs_archiveTextPaint = null;
    public static TextPaint dialogs_archiveTextPaintSmall = null;
    public static Drawable dialogs_botDrawable = null;
    public static Drawable dialogs_broadcastDrawable = null;
    public static Drawable dialogs_checkDrawable = null;
    public static Drawable dialogs_checkReadDrawable = null;
    public static Drawable dialogs_clockDrawable = null;
    public static Paint dialogs_countGrayPaint = null;
    public static Paint dialogs_countPaint = null;
    public static TextPaint dialogs_countTextPaint = null;
    public static Drawable dialogs_errorDrawable = null;
    public static Paint dialogs_errorPaint = null;
    public static ScamDrawable dialogs_fakeDrawable = null;
    public static Drawable dialogs_groupDrawable = null;
    public static Drawable dialogs_halfCheckDrawable = null;
    public static RLottieDrawable dialogs_hidePsaDrawable = null;
    public static boolean dialogs_hidePsaDrawableRecolored = false;
    public static Drawable dialogs_holidayDrawable = null;
    private static int dialogs_holidayDrawableOffsetX = 0;
    private static int dialogs_holidayDrawableOffsetY = 0;
    public static Drawable dialogs_lockDrawable = null;
    public static Drawable dialogs_mentionDrawable = null;
    public static TextPaint dialogs_messageNamePaint = null;
    public static TextPaint[] dialogs_messagePaint = null;
    public static TextPaint[] dialogs_messagePrintingPaint = null;
    public static Drawable dialogs_muteDrawable = null;
    public static TextPaint[] dialogs_nameEncryptedPaint = null;
    public static TextPaint[] dialogs_namePaint = null;
    public static TextPaint dialogs_offlinePaint = null;
    public static Paint dialogs_onlineCirclePaint = null;
    public static TextPaint dialogs_onlinePaint = null;
    public static RLottieDrawable dialogs_pinArchiveDrawable = null;
    public static Drawable dialogs_pinnedDrawable = null;
    public static Paint dialogs_pinnedPaint = null;
    public static Drawable dialogs_playDrawable = null;
    public static Drawable dialogs_reorderDrawable = null;
    public static ScamDrawable dialogs_scamDrawable = null;
    public static TextPaint dialogs_searchNameEncryptedPaint = null;
    public static TextPaint dialogs_searchNamePaint = null;
    public static ScamDrawable dialogs_shopDrawable = null;
    public static RLottieDrawable dialogs_swipeDeleteDrawable = null;
    public static RLottieDrawable dialogs_swipeMuteDrawable = null;
    public static RLottieDrawable dialogs_swipePinDrawable = null;
    public static RLottieDrawable dialogs_swipeReadDrawable = null;
    public static RLottieDrawable dialogs_swipeUnmuteDrawable = null;
    public static RLottieDrawable dialogs_swipeUnpinDrawable = null;
    public static RLottieDrawable dialogs_swipeUnreadDrawable = null;
    public static Paint dialogs_tabletSeletedPaint = null;
    public static TextPaint dialogs_timePaint = null;
    public static RLottieDrawable dialogs_unarchiveDrawable = null;
    public static RLottieDrawable dialogs_unpinArchiveDrawable = null;
    public static Drawable dialogs_verifiedCheckDrawable = null;
    public static Drawable dialogs_verifiedDrawable = null;
    public static Paint dividerExtraPaint = null;
    public static Paint dividerPaint = null;
    public static TextPaint explore_captionTextPaint = null;
    public static TextPaint explore_channelNameTextPaint = null;
    private static FragmentContextViewWavesDrawable fragmentContextViewWavesDrawable = null;
    public static Paint freeBubbleChat_backgroundColorPaint = null;
    private static boolean hasPreviousTheme = false;
    private static boolean isApplyingAccent = false;
    private static boolean isCustomTheme = false;
    private static boolean isInNigthMode = false;
    private static boolean isPatternWallpaper = false;
    private static boolean isWallpaperMotion = false;
    private static float lastBrightnessValue = 1.0f;
    private static long lastDelayUpdateTime;
    private static long lastHolidayCheckTime;
    private static int lastLoadingCurrentThemeTime;
    private static long lastThemeSwitchTime;
    private static Sensor lightSensor;
    private static boolean lightSensorRegistered;
    public static Paint linkSelectionPaint;
    private static int loadingCurrentTheme;
    public static TextPaint messageExplore_captionPaint;
    public static TextPaint messageExplore_namePaint;
    public static Drawable moveUpDrawable;
    private static ArrayList<ThemeInfo> otherThemes;
    private static int patternIntensity;
    public static PathAnimator playPauseAnimator;
    private static int previousPhase;
    private static ThemeInfo previousTheme;
    public static TextPaint profile_aboutTextPaint;
    public static Drawable profile_verifiedCheckDrawable;
    public static Drawable profile_verifiedDrawable;
    private static RoundVideoProgressShadow roundPlayDrawable;
    public static int selectedAutoNightType;
    private static SensorManager sensorManager;
    private static Bitmap serviceBitmap;
    private static Matrix serviceBitmapMatrix;
    public static BitmapShader serviceBitmapShader;
    private static int serviceMessage2Color;
    private static int serviceMessageColor;
    public static int serviceMessageColorBackup;
    private static int serviceSelectedMessage2Color;
    private static int serviceSelectedMessageColor;
    public static int serviceSelectedMessageColorBackup;
    private static boolean shouldDrawGradientIcons;
    private static boolean switchDayRunnableScheduled;
    private static boolean switchNightRunnableScheduled;
    private static int switchNightThemeDelay;
    private static boolean switchingNightTheme;
    private static Drawable themedWallpaper;
    private static int themedWallpaperFileOffset;
    private static String themedWallpaperLink;
    public static ArrayList<ThemeInfo> themes;
    private static HashMap<String, ThemeInfo> themesDict;
    private static int[] viewPos;
    private static Drawable wallpaper;
    private static Runnable wallpaperLoadTask;
    private static final Object sync = new Object();
    private static Runnable switchDayBrightnessRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.Theme.1
        @Override // java.lang.Runnable
        public void run() {
            boolean unused = Theme.switchDayRunnableScheduled = false;
            Theme.applyDayNightThemeMaybe(false);
        }
    };
    private static Runnable switchNightBrightnessRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.Theme.2
        @Override // java.lang.Runnable
        public void run() {
            boolean unused = Theme.switchNightRunnableScheduled = false;
            Theme.applyDayNightThemeMaybe(true);
        }
    };
    public static int DEFALT_THEME_ACCENT_ID = 99;
    public static int DEFALT_THEME_ACCENT_ID_2 = 9;
    private static Paint maskPaint = new Paint(1);
    private static boolean[] loadingRemoteThemes = new boolean[3];
    private static int[] lastLoadingThemesTime = new int[3];
    private static long[] remoteThemesHash = new long[3];
    public static Drawable[] avatarDrawables = new Drawable[15];
    private static StatusDrawable[] chat_status_drawables = new StatusDrawable[6];
    public static Drawable[] chat_msgInCallDrawable = new Drawable[2];
    public static Drawable[] chat_msgInCallSelectedDrawable = new Drawable[2];
    public static Drawable[] chat_msgOutCallDrawable = new Drawable[2];
    public static Drawable[] chat_msgOutCallSelectedDrawable = new Drawable[2];
    public static Drawable[] chat_pollCheckDrawable = new Drawable[2];
    public static Drawable[] chat_pollCrossDrawable = new Drawable[2];
    public static Drawable[] chat_pollHintDrawable = new Drawable[2];
    public static Drawable[] chat_psaHelpDrawable = new Drawable[2];
    public static RLottieDrawable[] chat_attachButtonDrawables = new RLottieDrawable[7];
    public static Drawable[] chat_liveStreamDrawable = new Drawable[2];
    public static Drawable[] chat_locationDrawable = new Drawable[2];
    public static Drawable[] chat_contactDrawable = new Drawable[2];
    public static Drawable[][] chat_fileStatesDrawable = (Drawable[][]) Array.newInstance((Class<?>) Drawable.class, 10, 2);
    public static CombinedDrawable[][] chat_fileMiniStatesDrawable = (CombinedDrawable[][]) Array.newInstance((Class<?>) CombinedDrawable.class, 6, 2);
    public static Drawable[][] chat_photoStatesDrawables = (Drawable[][]) Array.newInstance((Class<?>) Drawable.class, 13, 2);
    public static Path[] chat_filePath = new Path[2];
    public static Path[] chat_updatePath = new Path[3];
    public static String[] keys_avatar_background = {"avatar_backgroundRed", "avatar_backgroundOrange", "avatar_backgroundViolet", "avatar_backgroundGreen", "avatar_backgroundCyan", "avatar_backgroundBlue", "avatar_backgroundPink"};
    public static String[] keys_avatar_nameInMessage = {"avatar_nameInMessageRed", "avatar_nameInMessageOrange", "avatar_nameInMessageViolet", "avatar_nameInMessageGreen", "avatar_nameInMessageCyan", "avatar_nameInMessageBlue", "avatar_nameInMessagePink"};
    private static final HashMap<String, Drawable> defaultChatDrawables = new HashMap<>();
    private static final HashMap<String, String> defaultChatDrawableColorKeys = new HashMap<>();
    private static final HashMap<String, Paint> defaultChatPaints = new HashMap<>();
    private static final HashMap<String, String> defaultChatPaintColors = new HashMap<>();
    private static HashSet<String> myMessagesColorKeys = new HashSet<>();
    private static HashSet<String> myMessagesBubblesColorKeys = new HashSet<>();
    private static HashSet<String> myMessagesGradientColorsNearKeys = new HashSet<>();
    private static HashMap<String, Integer> defaultColors = new HashMap<>();
    private static HashMap<String, String> fallbackKeys = new HashMap<>();
    private static HashSet<String> themeAccentExclusionKeys = new HashSet<>();
    private static ThreadLocal<float[]> hsvTemp1Local = new ThreadLocal<>();
    private static ThreadLocal<float[]> hsvTemp2Local = new ThreadLocal<>();
    private static ThreadLocal<float[]> hsvTemp3Local = new ThreadLocal<>();
    private static ThreadLocal<float[]> hsvTemp4Local = new ThreadLocal<>();
    private static ThreadLocal<float[]> hsvTemp5Local = new ThreadLocal<>();

    public static class BackgroundDrawableSettings {
        public Boolean isCustomTheme;
        public Boolean isPatternWallpaper;
        public Boolean isWallpaperMotion;
        public Drawable themedWallpaper;
        public Drawable wallpaper;
    }

    public static void destroyResources() {
    }

    public static int getEventType() {
        return -1;
    }

    public static int getWallpaperColor(int color) {
        if (color == 0) {
            return 0;
        }
        return color | (-16777216);
    }

    public static class MessageDrawable extends Drawable {
        public static MotionBackgroundDrawable[] motionBackground = new MotionBackgroundDrawable[3];
        private int alpha;
        private Drawable[][] backgroundDrawable;
        private int[][] backgroundDrawableColor;
        private Rect backupRect;
        private Bitmap crosfadeFromBitmap;
        private Shader crosfadeFromBitmapShader;
        public MessageDrawable crossfadeFromDrawable;
        public float crossfadeProgress;
        private boolean currentAnimateGradient;
        private int[][] currentBackgroundDrawableRadius;
        private int currentBackgroundHeight;
        private int currentColor;
        private int currentGradientColor1;
        private int currentGradientColor2;
        private int currentGradientColor3;
        private int[] currentShadowDrawableRadius;
        private int currentType;
        private boolean drawFullBubble;
        private Shader gradientShader;
        private boolean isBottomNear;
        public boolean isCrossfadeBackground;
        private final boolean isOut;
        private boolean isSelected;
        private boolean isTopNear;
        public boolean lastDrawWithShadow;
        private Matrix matrix;
        private Paint paint;
        private Path path;
        private RectF rect;
        private final ResourcesProvider resourcesProvider;
        private Paint selectedPaint;
        private Drawable[] shadowDrawable;
        private int[] shadowDrawableColor;
        public boolean themePreview;
        private int topY;
        Drawable transitionDrawable;
        int transitionDrawableColor;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(int color, PorterDuff.Mode mode) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public MessageDrawable(int type, boolean out, boolean selected) {
            this(type, out, selected, null);
        }

        public MessageDrawable(int type, boolean out, boolean selected, ResourcesProvider resourcesProvider) {
            this.paint = new Paint(1);
            this.rect = new RectF();
            this.matrix = new Matrix();
            this.backupRect = new Rect();
            this.currentShadowDrawableRadius = new int[]{-1, -1, -1, -1};
            this.shadowDrawable = new Drawable[4];
            this.shadowDrawableColor = new int[]{-1, -1, -1, -1};
            this.currentBackgroundDrawableRadius = new int[][]{new int[]{-1, -1, -1, -1}, new int[]{-1, -1, -1, -1}};
            this.backgroundDrawable = (Drawable[][]) Array.newInstance((Class<?>) Drawable.class, 2, 4);
            this.backgroundDrawableColor = new int[][]{new int[]{-1, -1, -1, -1}, new int[]{-1, -1, -1, -1}};
            this.resourcesProvider = resourcesProvider;
            this.isOut = out;
            this.currentType = type;
            this.isSelected = selected;
            this.path = new Path();
            this.selectedPaint = new Paint(1);
            this.alpha = 255;
        }

        public boolean hasGradient() {
            return this.gradientShader != null && Theme.shouldDrawGradientIcons;
        }

        public void applyMatrixScale() {
            Bitmap bitmap;
            if (this.gradientShader instanceof BitmapShader) {
                char c = 2;
                if (this.isCrossfadeBackground && (bitmap = this.crosfadeFromBitmap) != null) {
                    char c2 = this.currentType != 2 ? (char) 0 : (char) 1;
                    float fMin = 1.0f / Math.min(bitmap.getWidth() / motionBackground[c2].getBounds().width(), this.crosfadeFromBitmap.getHeight() / motionBackground[c2].getBounds().height());
                    this.matrix.postScale(fMin, fMin);
                } else {
                    if (!this.themePreview) {
                        c = this.currentType != 2 ? (char) 0 : (char) 1;
                    }
                    Bitmap bitmap2 = motionBackground[c].getBitmap();
                    float fMin2 = 1.0f / Math.min(bitmap2.getWidth() / motionBackground[c].getBounds().width(), bitmap2.getHeight() / motionBackground[c].getBounds().height());
                    this.matrix.postScale(fMin2, fMin2);
                }
            }
        }

        public Shader getGradientShader() {
            return this.gradientShader;
        }

        public Matrix getMatrix() {
            return this.matrix;
        }

        protected int getColor(String key) {
            if (this.currentType == 2) {
                return Theme.getColor(key);
            }
            ResourcesProvider resourcesProvider = this.resourcesProvider;
            Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
            return color != null ? color.intValue() : Theme.getColor(key);
        }

        protected Integer getCurrentColor(String key) {
            if (this.currentType == 2) {
                return Integer.valueOf(Theme.getColor(key));
            }
            ResourcesProvider resourcesProvider = this.resourcesProvider;
            return resourcesProvider != null ? resourcesProvider.getCurrentColor(key) : Theme.currentColors.get(key);
        }

        public void setTop(int top, int backgroundWidth, int backgroundHeight, boolean topNear, boolean bottomNear) {
            setTop(top, backgroundWidth, backgroundHeight, backgroundHeight, topNear, bottomNear);
        }

        /* JADX WARN: Removed duplicated region for block: B:111:0x0293  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x0299  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x02af  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x02c4  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x02cd  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x016d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setTop(int r34, int r35, int r36, int r37, boolean r38, boolean r39) {
            /*
                Method dump skipped, instructions count: 732
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.MessageDrawable.setTop(int, int, int, int, boolean, boolean):void");
        }

        public int getTopY() {
            return this.topY;
        }

        private int dp(float value) {
            if (this.currentType == 2) {
                return (int) Math.ceil(value * 3.0f);
            }
            return AndroidUtilities.dp(value);
        }

        public Paint getPaint() {
            return this.paint;
        }

        public Drawable[] getShadowDrawables() {
            return this.shadowDrawable;
        }

        public Drawable getBackgroundDrawable() {
            char c;
            int color;
            int iDp = AndroidUtilities.dp(SharedConfig.bubbleRadius);
            boolean z = this.isTopNear;
            boolean z2 = true;
            if (z && this.isBottomNear) {
                c = 3;
            } else if (z) {
                c = 2;
            } else {
                c = this.isBottomNear ? (char) 1 : (char) 0;
            }
            boolean z3 = this.isSelected;
            boolean z4 = (this.gradientShader != null || z3 || this.isCrossfadeBackground) ? false : true;
            int color2 = getColor(this.isOut ? "chat_outBubbleShadow" : "chat_inBubbleShadow");
            if (this.lastDrawWithShadow == z4 && this.currentBackgroundDrawableRadius[z3 ? 1 : 0][c] == iDp && (!z4 || this.shadowDrawableColor[c] == color2)) {
                z2 = false;
            } else {
                this.currentBackgroundDrawableRadius[z3 ? 1 : 0][c] = iDp;
                try {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dp(50.0f), dp(40.0f), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    this.backupRect.set(getBounds());
                    if (z4) {
                        this.shadowDrawableColor[c] = color2;
                        Paint paint = new Paint(1);
                        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, dp(40.0f), new int[]{358573417, 694117737}, (float[]) null, Shader.TileMode.CLAMP));
                        paint.setColorFilter(new PorterDuffColorFilter(color2, PorterDuff.Mode.MULTIPLY));
                        paint.setShadowLayer(2.0f, 0.0f, 1.0f, -1);
                        if (AndroidUtilities.density > 1.0f) {
                            setBounds(-1, -1, bitmapCreateBitmap.getWidth() + 1, bitmapCreateBitmap.getHeight() + 1);
                        } else {
                            setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                        }
                        draw(canvas, paint);
                        if (AndroidUtilities.density > 1.0f) {
                            paint.setColor(0);
                            paint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                            setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                            draw(canvas, paint);
                        }
                    }
                    Paint paint2 = new Paint(1);
                    paint2.setColor(-1);
                    setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                    draw(canvas, paint2);
                    this.backgroundDrawable[z3 ? 1 : 0][c] = new NinePatchDrawable(bitmapCreateBitmap, getByteBuffer((bitmapCreateBitmap.getWidth() / 2) - 1, (bitmapCreateBitmap.getWidth() / 2) + 1, (bitmapCreateBitmap.getHeight() / 2) - 1, (bitmapCreateBitmap.getHeight() / 2) + 1).array(), new Rect(), null);
                    try {
                        setBounds(this.backupRect);
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                }
            }
            this.lastDrawWithShadow = z4;
            if (this.isSelected) {
                color = getColor(this.isOut ? "chat_outBubbleSelected" : "chat_inBubbleSelected");
            } else {
                color = getColor(this.isOut ? "chat_outBubble" : "chat_inBubble");
            }
            Drawable[][] drawableArr = this.backgroundDrawable;
            if (drawableArr[z3 ? 1 : 0][c] != null && (this.backgroundDrawableColor[z3 ? 1 : 0][c] != color || z2)) {
                drawableArr[z3 ? 1 : 0][c].setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                this.backgroundDrawableColor[z3 ? 1 : 0][c] = color;
            }
            return this.backgroundDrawable[z3 ? 1 : 0][c];
        }

        public Drawable getTransitionDrawable(int color) {
            if (this.transitionDrawable == null) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dp(50.0f), dp(40.0f), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                this.backupRect.set(getBounds());
                Paint paint = new Paint(1);
                paint.setColor(-1);
                setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                draw(canvas, paint);
                this.transitionDrawable = new NinePatchDrawable(bitmapCreateBitmap, getByteBuffer((bitmapCreateBitmap.getWidth() / 2) - 1, (bitmapCreateBitmap.getWidth() / 2) + 1, (bitmapCreateBitmap.getHeight() / 2) - 1, (bitmapCreateBitmap.getHeight() / 2) + 1).array(), new Rect(), null);
                setBounds(this.backupRect);
            }
            if (this.transitionDrawableColor != color) {
                this.transitionDrawableColor = color;
                this.transitionDrawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
            }
            return this.transitionDrawable;
        }

        public MotionBackgroundDrawable getMotionBackgroundDrawable() {
            if (this.themePreview) {
                return motionBackground[2];
            }
            return motionBackground[this.currentType == 2 ? (char) 1 : (char) 0];
        }

        public Drawable getShadowDrawable() {
            char c;
            if (this.isCrossfadeBackground) {
                return null;
            }
            if (this.gradientShader == null && !this.isSelected && this.crossfadeFromDrawable == null) {
                return null;
            }
            int iDp = AndroidUtilities.dp(SharedConfig.bubbleRadius);
            boolean z = this.isTopNear;
            boolean z2 = false;
            if (z && this.isBottomNear) {
                c = 3;
            } else if (z) {
                c = 2;
            } else {
                c = this.isBottomNear ? (char) 1 : (char) 0;
            }
            int[] iArr = this.currentShadowDrawableRadius;
            if (iArr[c] != iDp) {
                iArr[c] = iDp;
                try {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dp(50.0f), dp(40.0f), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    Paint paint = new Paint(1);
                    paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, dp(40.0f), new int[]{358573417, 694117737}, (float[]) null, Shader.TileMode.CLAMP));
                    paint.setShadowLayer(2.0f, 0.0f, 1.0f, -1);
                    if (AndroidUtilities.density > 1.0f) {
                        setBounds(-1, -1, bitmapCreateBitmap.getWidth() + 1, bitmapCreateBitmap.getHeight() + 1);
                    } else {
                        setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                    }
                    draw(canvas, paint);
                    if (AndroidUtilities.density > 1.0f) {
                        paint.setColor(0);
                        paint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                        setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                        draw(canvas, paint);
                    }
                    this.shadowDrawable[c] = new NinePatchDrawable(bitmapCreateBitmap, getByteBuffer((bitmapCreateBitmap.getWidth() / 2) - 1, (bitmapCreateBitmap.getWidth() / 2) + 1, (bitmapCreateBitmap.getHeight() / 2) - 1, (bitmapCreateBitmap.getHeight() / 2) + 1).array(), new Rect(), null);
                    z2 = true;
                } catch (Throwable unused) {
                }
            }
            int color = getColor(this.isOut ? "chat_outBubbleShadow" : "chat_inBubbleShadow");
            Drawable[] drawableArr = this.shadowDrawable;
            if (drawableArr[c] != null && (this.shadowDrawableColor[c] != color || z2)) {
                drawableArr[c].setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                this.shadowDrawableColor[c] = color;
            }
            return this.shadowDrawable[c];
        }

        private static ByteBuffer getByteBuffer(int x1, int x2, int y1, int y2) {
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
            byteBufferOrder.put((byte) 1);
            byteBufferOrder.put((byte) 2);
            byteBufferOrder.put((byte) 2);
            byteBufferOrder.put((byte) 9);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(0);
            byteBufferOrder.putInt(x1);
            byteBufferOrder.putInt(x2);
            byteBufferOrder.putInt(y1);
            byteBufferOrder.putInt(y2);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            byteBufferOrder.putInt(1);
            return byteBufferOrder;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            MessageDrawable messageDrawable = this.crossfadeFromDrawable;
            if (messageDrawable != null) {
                messageDrawable.draw(canvas);
                setAlpha((int) (this.crossfadeProgress * 255.0f));
                draw(canvas, null);
                setAlpha(255);
                return;
            }
            draw(canvas, null);
        }

        public void drawFullRounded(Canvas canvas) {
            Rect bounds = getBounds();
            Path path = new Path();
            path.addRoundRect(new RectF(bounds.left, bounds.top, bounds.right, bounds.bottom), new float[]{dp(SharedConfig.bubbleRadius), dp(SharedConfig.bubbleRadius), dp(SharedConfig.bubbleRadius), dp(SharedConfig.bubbleRadius), dp(SharedConfig.bubbleRadius), dp(SharedConfig.bubbleRadius), dp(SharedConfig.bubbleRadius), dp(SharedConfig.bubbleRadius)}, Path.Direction.CW);
            canvas.drawPath(path, this.paint);
        }

        /* JADX WARN: Removed duplicated region for block: B:107:0x03f5  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x049d  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x04b8  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x04ef  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0177  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0220  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x023b  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0271  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void draw(android.graphics.Canvas r20, android.graphics.Paint r21) {
            /*
                Method dump skipped, instructions count: 1454
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.MessageDrawable.draw(android.graphics.Canvas, android.graphics.Paint):void");
        }

        public void setDrawFullBubble(boolean drawFullBuble) {
            this.drawFullBubble = drawFullBuble;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            if (this.alpha != alpha) {
                this.alpha = alpha;
                this.paint.setAlpha(alpha);
                if (this.isOut) {
                    this.selectedPaint.setAlpha((int) (Color.alpha(getColor("chat_outBubbleGradientSelectedOverlay")) * (alpha / 255.0f)));
                }
            }
            if (this.gradientShader == null) {
                Drawable backgroundDrawable = getBackgroundDrawable();
                if (Build.VERSION.SDK_INT >= 19) {
                    if (backgroundDrawable.getAlpha() != alpha) {
                        backgroundDrawable.setAlpha(alpha);
                        return;
                    }
                    return;
                }
                backgroundDrawable.setAlpha(alpha);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int left, int top, int right, int bottom) {
            super.setBounds(left, top, right, bottom);
            MessageDrawable messageDrawable = this.crossfadeFromDrawable;
            if (messageDrawable != null) {
                messageDrawable.setBounds(left, top, right, bottom);
            }
        }
    }

    public static class PatternsLoader implements NotificationCenter.NotificationCenterDelegate {
        private static PatternsLoader loader;
        private int account = UserConfig.selectedAccount;
        private HashMap<String, LoadingPattern> watingForLoad;

        /* JADX INFO: Access modifiers changed from: private */
        static class LoadingPattern {
            public ArrayList<ThemeAccent> accents;
            public TLRPC$TL_wallPaper pattern;

            private LoadingPattern() {
                this.accents = new ArrayList<>();
            }
        }

        public static void createLoader(boolean force) {
            ArrayList<ThemeAccent> arrayList;
            if (loader == null || force) {
                ArrayList arrayList2 = null;
                int i = 0;
                while (i < 5) {
                    ThemeInfo themeInfo = (ThemeInfo) Theme.themesDict.get(i != 0 ? i != 1 ? i != 2 ? i != 3 ? "Night" : "Day" : "Arctic Blue" : "Dark Blue" : "Blue");
                    if (themeInfo != null && (arrayList = themeInfo.themeAccents) != null && !arrayList.isEmpty()) {
                        int size = themeInfo.themeAccents.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            ThemeAccent themeAccent = themeInfo.themeAccents.get(i2);
                            if (themeAccent.id != Theme.DEFALT_THEME_ACCENT_ID && !TextUtils.isEmpty(themeAccent.patternSlug)) {
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(themeAccent);
                            }
                        }
                    }
                    i++;
                }
                loader = new PatternsLoader(arrayList2);
            }
        }

        private PatternsLoader(final ArrayList<ThemeAccent> accents) {
            if (accents == null) {
                return;
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$PatternsLoader$VHCeQQEehx2CuJTzXibwQGVHIQ0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$1$Theme$PatternsLoader(accents);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$Theme$PatternsLoader(final ArrayList arrayList) {
            int size = arrayList.size();
            ArrayList arrayList2 = null;
            int i = 0;
            while (i < size) {
                ThemeAccent themeAccent = (ThemeAccent) arrayList.get(i);
                File pathToWallpaper = themeAccent.getPathToWallpaper();
                if (pathToWallpaper != null && pathToWallpaper.exists()) {
                    arrayList.remove(i);
                    i--;
                    size--;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    if (!arrayList2.contains(themeAccent.patternSlug)) {
                        arrayList2.add(themeAccent.patternSlug);
                    }
                }
                i++;
            }
            if (arrayList2 == null) {
                return;
            }
            TLRPC$TL_account_getMultiWallPapers tLRPC$TL_account_getMultiWallPapers = new TLRPC$TL_account_getMultiWallPapers();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                TLRPC$TL_inputWallPaperSlug tLRPC$TL_inputWallPaperSlug = new TLRPC$TL_inputWallPaperSlug();
                tLRPC$TL_inputWallPaperSlug.slug = (String) arrayList2.get(i2);
                tLRPC$TL_account_getMultiWallPapers.wallpapers.add(tLRPC$TL_inputWallPaperSlug);
            }
            ConnectionsManager.getInstance(this.account).sendRequest(tLRPC$TL_account_getMultiWallPapers, new RequestDelegate() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$PatternsLoader$pmSKESuadfTWp1D-pojkf2PKgHE
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$new$0$Theme$PatternsLoader(arrayList, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v1 */
        /* JADX WARN: Type inference failed for: r12v2 */
        /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r12v4 */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v6 */
        /* JADX WARN: Type inference failed for: r4v3, types: [ir.eitaa.ui.ActionBar.Theme$1] */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$new$0$Theme$PatternsLoader(java.util.ArrayList r17, ir.eitaa.tgnet.TLObject r18, ir.eitaa.tgnet.TLRPC$TL_error r19) {
            /*
                r16 = this;
                r0 = r16
                r1 = r18
                boolean r2 = r1 instanceof ir.eitaa.tgnet.TLRPC$Vector
                if (r2 == 0) goto Lbb
                ir.eitaa.tgnet.TLRPC$Vector r1 = (ir.eitaa.tgnet.TLRPC$Vector) r1
                java.util.ArrayList<java.lang.Object> r2 = r1.objects
                int r2 = r2.size()
                r4 = 0
                r6 = r4
                r5 = 0
            L13:
                r7 = 1
                if (r5 >= r2) goto Lb8
                java.util.ArrayList<java.lang.Object> r8 = r1.objects
                java.lang.Object r8 = r8.get(r5)
                ir.eitaa.tgnet.TLRPC$WallPaper r8 = (ir.eitaa.tgnet.TLRPC$WallPaper) r8
                boolean r9 = r8 instanceof ir.eitaa.tgnet.TLRPC$TL_wallPaper
                if (r9 != 0) goto L24
                goto Lb1
            L24:
                ir.eitaa.tgnet.TLRPC$TL_wallPaper r8 = (ir.eitaa.tgnet.TLRPC$TL_wallPaper) r8
                boolean r9 = r8.pattern
                if (r9 == 0) goto Lb1
                ir.eitaa.tgnet.TLRPC$Document r9 = r8.document
                java.io.File r7 = ir.eitaa.messenger.FileLoader.getPathToAttach(r9, r7)
                int r9 = r17.size()
                r11 = r4
                r12 = r11
                r10 = 0
            L37:
                if (r10 >= r9) goto La9
                r13 = r17
                java.lang.Object r14 = r13.get(r10)
                ir.eitaa.ui.ActionBar.Theme$ThemeAccent r14 = (ir.eitaa.ui.ActionBar.Theme.ThemeAccent) r14
                java.lang.String r15 = r14.patternSlug
                java.lang.String r3 = r8.slug
                boolean r3 = r15.equals(r3)
                if (r3 == 0) goto La5
                if (r12 != 0) goto L56
                boolean r3 = r7.exists()
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                r12 = r3
            L56:
                if (r11 != 0) goto L8c
                boolean r3 = r12.booleanValue()
                if (r3 == 0) goto L5f
                goto L8c
            L5f:
                ir.eitaa.tgnet.TLRPC$Document r3 = r8.document
                java.lang.String r3 = ir.eitaa.messenger.FileLoader.getAttachFileName(r3)
                java.util.HashMap<java.lang.String, ir.eitaa.ui.ActionBar.Theme$PatternsLoader$LoadingPattern> r15 = r0.watingForLoad
                if (r15 != 0) goto L70
                java.util.HashMap r15 = new java.util.HashMap
                r15.<init>()
                r0.watingForLoad = r15
            L70:
                java.util.HashMap<java.lang.String, ir.eitaa.ui.ActionBar.Theme$PatternsLoader$LoadingPattern> r15 = r0.watingForLoad
                java.lang.Object r15 = r15.get(r3)
                ir.eitaa.ui.ActionBar.Theme$PatternsLoader$LoadingPattern r15 = (ir.eitaa.ui.ActionBar.Theme.PatternsLoader.LoadingPattern) r15
                if (r15 != 0) goto L86
                ir.eitaa.ui.ActionBar.Theme$PatternsLoader$LoadingPattern r15 = new ir.eitaa.ui.ActionBar.Theme$PatternsLoader$LoadingPattern
                r15.<init>()
                r15.pattern = r8
                java.util.HashMap<java.lang.String, ir.eitaa.ui.ActionBar.Theme$PatternsLoader$LoadingPattern> r4 = r0.watingForLoad
                r4.put(r3, r15)
            L86:
                java.util.ArrayList<ir.eitaa.ui.ActionBar.Theme$ThemeAccent> r3 = r15.accents
                r3.add(r14)
                goto La5
            L8c:
                ir.eitaa.tgnet.TLRPC$Document r3 = r8.document
                java.lang.String r3 = r3.mime_type
                java.lang.String r4 = "application/x-tgwallpattern"
                boolean r3 = r4.equals(r3)
                android.graphics.Bitmap r11 = r0.createWallpaperForAccent(r11, r3, r7, r14)
                if (r6 != 0) goto La2
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r6 = r3
            La2:
                r6.add(r14)
            La5:
                int r10 = r10 + 1
                r4 = 0
                goto L37
            La9:
                r13 = r17
                if (r11 == 0) goto Lb3
                r11.recycle()
                goto Lb3
            Lb1:
                r13 = r17
            Lb3:
                int r5 = r5 + 1
                r4 = 0
                goto L13
            Lb8:
                r0.checkCurrentWallpaper(r6, r7)
            Lbb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.PatternsLoader.lambda$new$0$Theme$PatternsLoader(java.util.ArrayList, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLRPC$TL_error):void");
        }

        private void checkCurrentWallpaper(final ArrayList<ThemeAccent> accents, final boolean load) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$PatternsLoader$lv3SkpKpROnd6MDq1NlzITj6crQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkCurrentWallpaper$2$Theme$PatternsLoader(accents, load);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: checkCurrentWallpaperInternal, reason: merged with bridge method [inline-methods] */
        public void lambda$checkCurrentWallpaper$2$Theme$PatternsLoader(ArrayList<ThemeAccent> accents, boolean load) {
            if (accents != null && Theme.currentTheme.themeAccents != null && !Theme.currentTheme.themeAccents.isEmpty() && accents.contains(Theme.currentTheme.getAccent(false))) {
                Theme.reloadWallpaper();
            }
            if (load) {
                if (this.watingForLoad != null) {
                    NotificationCenter.getInstance(this.account).addObserver(this, NotificationCenter.fileLoaded);
                    NotificationCenter.getInstance(this.account).addObserver(this, NotificationCenter.fileLoadFailed);
                    Iterator<Map.Entry<String, LoadingPattern>> it = this.watingForLoad.entrySet().iterator();
                    while (it.hasNext()) {
                        FileLoader.getInstance(this.account).loadFile(ImageLocation.getForDocument(it.next().getValue().pattern.document), "wallpaper", null, 0, 1);
                    }
                    return;
                }
                return;
            }
            HashMap<String, LoadingPattern> map = this.watingForLoad;
            if (map == null || map.isEmpty()) {
                NotificationCenter.getInstance(this.account).removeObserver(this, NotificationCenter.fileLoaded);
                NotificationCenter.getInstance(this.account).removeObserver(this, NotificationCenter.fileLoadFailed);
            }
        }

        private Bitmap createWallpaperForAccent(Bitmap patternBitmap, boolean svg, File patternPath, ThemeAccent accent) {
            Bitmap bitmap;
            File pathToWallpaper;
            Drawable colorDrawable;
            int patternColor;
            Bitmap bitmapLoadScreenSizedBitmap;
            Integer num;
            Integer num2;
            Integer num3;
            try {
                pathToWallpaper = accent.getPathToWallpaper();
                colorDrawable = null;
            } catch (Throwable th) {
                th = th;
                bitmap = patternBitmap;
            }
            if (pathToWallpaper == null) {
                return null;
            }
            ThemeInfo themeInfo = accent.parentTheme;
            HashMap<String, Integer> themeFileValues = Theme.getThemeFileValues(null, themeInfo.assetName, null);
            int i = accent.accentColor;
            int iChangeColorAccent = (int) accent.backgroundOverrideColor;
            long j = accent.backgroundGradientOverrideColor1;
            int iChangeColorAccent2 = (int) j;
            if (iChangeColorAccent2 == 0 && j == 0) {
                if (iChangeColorAccent != 0) {
                    i = iChangeColorAccent;
                }
                Integer num4 = themeFileValues.get("chat_wallpaper_gradient_to");
                if (num4 != null) {
                    iChangeColorAccent2 = Theme.changeColorAccent(themeInfo, i, num4.intValue());
                }
            } else {
                i = 0;
            }
            long j2 = accent.backgroundGradientOverrideColor2;
            int iChangeColorAccent3 = (int) j2;
            if (iChangeColorAccent3 == 0 && j2 == 0 && (num3 = themeFileValues.get("key_chat_wallpaper_gradient_to2")) != null) {
                iChangeColorAccent3 = Theme.changeColorAccent(themeInfo, i, num3.intValue());
            }
            long j3 = accent.backgroundGradientOverrideColor3;
            int iChangeColorAccent4 = (int) j3;
            if (iChangeColorAccent4 == 0 && j3 == 0 && (num2 = themeFileValues.get("key_chat_wallpaper_gradient_to3")) != null) {
                iChangeColorAccent4 = Theme.changeColorAccent(themeInfo, i, num2.intValue());
            }
            if (iChangeColorAccent == 0 && (num = themeFileValues.get("chat_wallpaper")) != null) {
                iChangeColorAccent = Theme.changeColorAccent(themeInfo, i, num.intValue());
            }
            if (iChangeColorAccent3 != 0) {
                patternColor = MotionBackgroundDrawable.getPatternColor(iChangeColorAccent, iChangeColorAccent2, iChangeColorAccent3, iChangeColorAccent4);
            } else if (iChangeColorAccent2 != 0) {
                Drawable backgroundGradientDrawable = new BackgroundGradientDrawable(BackgroundGradientDrawable.getGradientOrientation(accent.backgroundRotation), new int[]{iChangeColorAccent, iChangeColorAccent2});
                patternColor = AndroidUtilities.getPatternColor(AndroidUtilities.getAverageColor(iChangeColorAccent, iChangeColorAccent2));
                colorDrawable = backgroundGradientDrawable;
            } else {
                colorDrawable = new ColorDrawable(iChangeColorAccent);
                patternColor = AndroidUtilities.getPatternColor(iChangeColorAccent);
            }
            if (patternBitmap == null) {
                if (!svg) {
                    bitmapLoadScreenSizedBitmap = Theme.loadScreenSizedBitmap(new FileInputStream(patternPath), 0);
                } else {
                    bitmapLoadScreenSizedBitmap = SvgHelper.getBitmap(patternPath, AndroidUtilities.dp(360.0f), AndroidUtilities.dp(640.0f), false);
                }
                bitmap = bitmapLoadScreenSizedBitmap;
            } else {
                bitmap = patternBitmap;
            }
            try {
                if (colorDrawable != null) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    colorDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    colorDrawable.draw(canvas);
                    Paint paint = new Paint(2);
                    paint.setColorFilter(new PorterDuffColorFilter(patternColor, PorterDuff.Mode.SRC_IN));
                    paint.setAlpha((int) (Math.abs(accent.patternIntensity) * 255.0f));
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 87, new FileOutputStream(pathToWallpaper));
                } else {
                    FileOutputStream fileOutputStream = new FileOutputStream(pathToWallpaper);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 87, fileOutputStream);
                    fileOutputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
                FileLog.e(th);
                return bitmap;
            }
            return bitmap;
        }

        @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int id, int account, Object... args) {
            HashMap<String, LoadingPattern> map = this.watingForLoad;
            if (map == null) {
                return;
            }
            if (id == NotificationCenter.fileLoaded) {
                final LoadingPattern loadingPatternRemove = map.remove((String) args[0]);
                if (loadingPatternRemove != null) {
                    Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$PatternsLoader$OUYx56SZBc75-6T5YFo78hnV-Eg
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$didReceivedNotification$3$Theme$PatternsLoader(loadingPatternRemove);
                        }
                    });
                    return;
                }
                return;
            }
            if (id != NotificationCenter.fileLoadFailed || map.remove((String) args[0]) == null) {
                return;
            }
            checkCurrentWallpaper(null, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didReceivedNotification$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didReceivedNotification$3$Theme$PatternsLoader(LoadingPattern loadingPattern) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = loadingPattern.pattern;
            File pathToAttach = FileLoader.getPathToAttach(tLRPC$TL_wallPaper.document, true);
            int size = loadingPattern.accents.size();
            Bitmap bitmapCreateWallpaperForAccent = null;
            ArrayList<ThemeAccent> arrayList = null;
            for (int i = 0; i < size; i++) {
                ThemeAccent themeAccent = loadingPattern.accents.get(i);
                if (themeAccent.patternSlug.equals(tLRPC$TL_wallPaper.slug)) {
                    bitmapCreateWallpaperForAccent = createWallpaperForAccent(bitmapCreateWallpaperForAccent, "application/x-tgwallpattern".equals(tLRPC$TL_wallPaper.document.mime_type), pathToAttach, themeAccent);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        arrayList.add(themeAccent);
                    }
                }
            }
            if (bitmapCreateWallpaperForAccent != null) {
                bitmapCreateWallpaperForAccent.recycle();
            }
            checkCurrentWallpaper(arrayList, false);
        }
    }

    public static class ThemeAccent {
        public int accentColor;
        public int accentColor2;
        public int account;
        public long backgroundGradientOverrideColor1;
        public long backgroundGradientOverrideColor2;
        public long backgroundGradientOverrideColor3;
        public long backgroundOverrideColor;
        public int id;
        public TLRPC$TL_theme info;
        public int myMessagesAccentColor;
        public boolean myMessagesAnimated;
        public int myMessagesGradientAccentColor1;
        public int myMessagesGradientAccentColor2;
        public int myMessagesGradientAccentColor3;
        public OverrideWallpaperInfo overrideWallpaper;
        public ThemeInfo parentTheme;
        public TLRPC$TL_wallPaper pattern;
        public float patternIntensity;
        public boolean patternMotion;
        public TLRPC$InputFile uploadedFile;
        public TLRPC$InputFile uploadedThumb;
        public String uploadingFile;
        public String uploadingThumb;
        public int backgroundRotation = 45;
        public String patternSlug = "";

        ThemeAccent() {
        }

        /* JADX WARN: Removed duplicated region for block: B:131:0x0442  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean fillAccentColors(java.util.HashMap<java.lang.String, java.lang.Integer> r17, java.util.HashMap<java.lang.String, java.lang.Integer> r18) {
            /*
                Method dump skipped, instructions count: 1262
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.ThemeAccent.fillAccentColors(java.util.HashMap, java.util.HashMap):boolean");
        }

        public File getPathToWallpaper() {
            if (this.id < 100) {
                if (TextUtils.isEmpty(this.patternSlug)) {
                    return null;
                }
                return new File(ApplicationLoader.getFilesDirFixed(), String.format(Locale.US, "%s_%d_%s_v5.jpg", this.parentTheme.getKey(), Integer.valueOf(this.id), this.patternSlug));
            }
            if (TextUtils.isEmpty(this.patternSlug)) {
                return null;
            }
            return new File(ApplicationLoader.getFilesDirFixed(), String.format(Locale.US, "%s_%d_%s_v8_dubug.jpg", this.parentTheme.getKey(), Integer.valueOf(this.id), this.patternSlug));
        }

        /* JADX WARN: Removed duplicated region for block: B:115:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:98:0x02f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x02eb -> B:95:0x02ef). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.io.File saveToFile() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 768
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.ThemeAccent.saveToFile():java.io.File");
        }
    }

    public static class OverrideWallpaperInfo {
        public long accessHash;
        public int color;
        public String fileName;
        public int gradientColor1;
        public int gradientColor2;
        public int gradientColor3;
        public float intensity;
        public boolean isBlurred;
        public boolean isMotion;
        public String originalFileName;
        public ThemeAccent parentAccent;
        public ThemeInfo parentTheme;
        public int rotation;
        public String slug;
        public long wallpaperId;

        public OverrideWallpaperInfo() {
            this.fileName = "";
            this.originalFileName = "";
            this.slug = "";
        }

        public OverrideWallpaperInfo(OverrideWallpaperInfo info, ThemeInfo themeInfo, ThemeAccent accent) {
            this.fileName = "";
            this.originalFileName = "";
            this.slug = "";
            this.slug = info.slug;
            this.color = info.color;
            this.gradientColor1 = info.gradientColor1;
            this.gradientColor2 = info.gradientColor2;
            this.gradientColor3 = info.gradientColor3;
            this.rotation = info.rotation;
            this.isBlurred = info.isBlurred;
            this.isMotion = info.isMotion;
            this.intensity = info.intensity;
            this.parentTheme = themeInfo;
            this.parentAccent = accent;
            if (!TextUtils.isEmpty(info.fileName)) {
                try {
                    File file = new File(ApplicationLoader.getFilesDirFixed(), info.fileName);
                    File filesDirFixed = ApplicationLoader.getFilesDirFixed();
                    String strGenerateWallpaperName = this.parentTheme.generateWallpaperName(this.parentAccent, false);
                    this.fileName = strGenerateWallpaperName;
                    AndroidUtilities.copyFile(file, new File(filesDirFixed, strGenerateWallpaperName));
                } catch (Exception e) {
                    this.fileName = "";
                    FileLog.e(e);
                }
            } else {
                this.fileName = "";
            }
            if (!TextUtils.isEmpty(info.originalFileName)) {
                if (!info.originalFileName.equals(info.fileName)) {
                    try {
                        File file2 = new File(ApplicationLoader.getFilesDirFixed(), info.originalFileName);
                        File filesDirFixed2 = ApplicationLoader.getFilesDirFixed();
                        String strGenerateWallpaperName2 = this.parentTheme.generateWallpaperName(this.parentAccent, true);
                        this.originalFileName = strGenerateWallpaperName2;
                        AndroidUtilities.copyFile(file2, new File(filesDirFixed2, strGenerateWallpaperName2));
                        return;
                    } catch (Exception e2) {
                        this.originalFileName = "";
                        FileLog.e(e2);
                        return;
                    }
                }
                this.originalFileName = this.fileName;
                return;
            }
            this.originalFileName = "";
        }

        public boolean isDefault() {
            return "d".equals(this.slug);
        }

        public boolean isColor() {
            return "c".equals(this.slug);
        }

        public boolean isTheme() {
            return "t".equals(this.slug);
        }

        public void saveOverrideWallpaper() {
            ThemeInfo themeInfo = this.parentTheme;
            if (themeInfo != null) {
                ThemeAccent themeAccent = this.parentAccent;
                if (themeAccent != null || themeInfo.overrideWallpaper == this) {
                    if (themeAccent == null || themeAccent.overrideWallpaper == this) {
                        save();
                    }
                }
            }
        }

        private String getKey() {
            if (this.parentAccent != null) {
                return this.parentTheme.name + "_" + this.parentAccent.id + "_owp";
            }
            return this.parentTheme.name + "_owp";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void save() {
            try {
                String key = getKey();
                SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0).edit();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("wall", this.fileName);
                jSONObject.put("owall", this.originalFileName);
                jSONObject.put("pColor", this.color);
                jSONObject.put("pGrColor", this.gradientColor1);
                jSONObject.put("pGrColor2", this.gradientColor2);
                jSONObject.put("pGrColor3", this.gradientColor3);
                jSONObject.put("pGrAngle", this.rotation);
                String str = this.slug;
                if (str == null) {
                    str = "";
                }
                jSONObject.put("wallSlug", str);
                jSONObject.put("wBlur", this.isBlurred);
                jSONObject.put("wMotion", this.isMotion);
                jSONObject.put("pIntensity", this.intensity);
                editorEdit.putString(key, jSONObject.toString());
                editorEdit.commit();
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void delete() {
            ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0).edit().remove(getKey()).commit();
            new File(ApplicationLoader.getFilesDirFixed(), this.fileName).delete();
            new File(ApplicationLoader.getFilesDirFixed(), this.originalFileName).delete();
        }
    }

    public static class ThemeInfo implements NotificationCenter.NotificationCenterDelegate {
        public int accentBaseColor;
        public LongSparseArray<ThemeAccent> accentsByThemeId;
        public int account;
        public String assetName;
        public boolean badWallpaper;
        public LongSparseArray<ThemeAccent> chatAccentsByThemeId;
        public int currentAccentId;
        public int defaultAccentCount;
        public boolean firstAccentIsDefault;
        public TLRPC$TL_theme info;
        public boolean isBlured;
        public boolean isMotion;
        public int lastAccentId;
        public int lastChatThemeId;
        public boolean loaded;
        private String loadingThemeWallpaperName;
        public String name;
        private String newPathToWallpaper;
        public OverrideWallpaperInfo overrideWallpaper;
        public String pathToFile;
        public String pathToWallpaper;
        public int patternBgColor;
        public int patternBgGradientColor1;
        public int patternBgGradientColor2;
        public int patternBgGradientColor3;
        public int patternBgGradientRotation;
        public int patternIntensity;
        public int prevAccentId;
        private int previewBackgroundColor;
        public int previewBackgroundGradientColor1;
        public int previewBackgroundGradientColor2;
        public int previewBackgroundGradientColor3;
        private int previewInColor;
        private int previewOutColor;
        public boolean previewParsed;
        public int previewWallpaperOffset;
        public String slug;
        public int sortIndex;
        public ArrayList<ThemeAccent> themeAccents;
        public SparseArray<ThemeAccent> themeAccentsMap;
        public boolean themeLoaded;
        public TLRPC$InputFile uploadedFile;
        public TLRPC$InputFile uploadedThumb;
        public String uploadingFile;
        public String uploadingThumb;

        ThemeInfo() {
            this.patternBgGradientRotation = 45;
            this.loaded = true;
            this.themeLoaded = true;
            this.prevAccentId = -1;
            this.chatAccentsByThemeId = new LongSparseArray<>();
            this.lastChatThemeId = 0;
            this.lastAccentId = 100;
        }

        public ThemeInfo(ThemeInfo other) {
            this.patternBgGradientRotation = 45;
            this.loaded = true;
            this.themeLoaded = true;
            this.prevAccentId = -1;
            this.chatAccentsByThemeId = new LongSparseArray<>();
            this.lastChatThemeId = 0;
            this.lastAccentId = 100;
            this.name = other.name;
            this.pathToFile = other.pathToFile;
            this.pathToWallpaper = other.pathToWallpaper;
            this.assetName = other.assetName;
            this.slug = other.slug;
            this.badWallpaper = other.badWallpaper;
            this.isBlured = other.isBlured;
            this.isMotion = other.isMotion;
            this.patternBgColor = other.patternBgColor;
            this.patternBgGradientColor1 = other.patternBgGradientColor1;
            this.patternBgGradientColor2 = other.patternBgGradientColor2;
            this.patternBgGradientColor3 = other.patternBgGradientColor3;
            this.patternBgGradientRotation = other.patternBgGradientRotation;
            this.patternIntensity = other.patternIntensity;
            this.account = other.account;
            this.info = other.info;
            this.loaded = other.loaded;
            this.uploadingThumb = other.uploadingThumb;
            this.uploadingFile = other.uploadingFile;
            this.uploadedThumb = other.uploadedThumb;
            this.uploadedFile = other.uploadedFile;
            this.previewBackgroundColor = other.previewBackgroundColor;
            this.previewBackgroundGradientColor1 = other.previewBackgroundGradientColor1;
            this.previewBackgroundGradientColor2 = other.previewBackgroundGradientColor2;
            this.previewBackgroundGradientColor3 = other.previewBackgroundGradientColor3;
            this.previewWallpaperOffset = other.previewWallpaperOffset;
            this.previewInColor = other.previewInColor;
            this.previewOutColor = other.previewOutColor;
            this.firstAccentIsDefault = other.firstAccentIsDefault;
            this.previewParsed = other.previewParsed;
            this.themeLoaded = other.themeLoaded;
            this.sortIndex = other.sortIndex;
            this.defaultAccentCount = other.defaultAccentCount;
            this.accentBaseColor = other.accentBaseColor;
            this.currentAccentId = other.currentAccentId;
            this.prevAccentId = other.prevAccentId;
            this.themeAccentsMap = other.themeAccentsMap;
            this.themeAccents = other.themeAccents;
            this.accentsByThemeId = other.accentsByThemeId;
            this.lastAccentId = other.lastAccentId;
            this.loadingThemeWallpaperName = other.loadingThemeWallpaperName;
            this.newPathToWallpaper = other.newPathToWallpaper;
            this.overrideWallpaper = other.overrideWallpaper;
        }

        JSONObject getSaveJson() throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", this.name);
                jSONObject.put("path", this.pathToFile);
                jSONObject.put("account", this.account);
                TLRPC$TL_theme tLRPC$TL_theme = this.info;
                if (tLRPC$TL_theme != null) {
                    SerializedData serializedData = new SerializedData(tLRPC$TL_theme.getObjectSize());
                    this.info.serializeToStream(serializedData);
                    jSONObject.put("info", Utilities.bytesToHex(serializedData.toByteArray()));
                }
                jSONObject.put("loaded", this.loaded);
                return jSONObject;
            } catch (Exception e) {
                FileLog.e(e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadWallpapers(SharedPreferences sharedPreferences) {
            ArrayList<ThemeAccent> arrayList = this.themeAccents;
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = this.themeAccents.size();
                for (int i = 0; i < size; i++) {
                    ThemeAccent themeAccent = this.themeAccents.get(i);
                    loadOverrideWallpaper(sharedPreferences, themeAccent, this.name + "_" + themeAccent.id + "_owp");
                }
                return;
            }
            loadOverrideWallpaper(sharedPreferences, null, this.name + "_owp");
        }

        private void loadOverrideWallpaper(SharedPreferences sharedPreferences, ThemeAccent accent, String key) {
            try {
                String string = sharedPreferences.getString(key, null);
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(string);
                OverrideWallpaperInfo overrideWallpaperInfo = new OverrideWallpaperInfo();
                overrideWallpaperInfo.fileName = jSONObject.getString("wall");
                overrideWallpaperInfo.originalFileName = jSONObject.getString("owall");
                overrideWallpaperInfo.color = jSONObject.getInt("pColor");
                overrideWallpaperInfo.gradientColor1 = jSONObject.getInt("pGrColor");
                overrideWallpaperInfo.gradientColor2 = jSONObject.optInt("pGrColor2");
                overrideWallpaperInfo.gradientColor3 = jSONObject.optInt("pGrColor3");
                overrideWallpaperInfo.rotation = jSONObject.getInt("pGrAngle");
                overrideWallpaperInfo.slug = jSONObject.getString("wallSlug");
                overrideWallpaperInfo.isBlurred = jSONObject.getBoolean("wBlur");
                overrideWallpaperInfo.isMotion = jSONObject.getBoolean("wMotion");
                overrideWallpaperInfo.intensity = (float) jSONObject.getDouble("pIntensity");
                overrideWallpaperInfo.parentTheme = this;
                overrideWallpaperInfo.parentAccent = accent;
                if (accent != null) {
                    accent.overrideWallpaper = overrideWallpaperInfo;
                } else {
                    this.overrideWallpaper = overrideWallpaperInfo;
                }
                if (jSONObject.has("wallId") && jSONObject.getLong("wallId") == 1000001) {
                    overrideWallpaperInfo.slug = "d";
                }
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }

        public void setOverrideWallpaper(OverrideWallpaperInfo info) {
            if (this.overrideWallpaper == info) {
                return;
            }
            ThemeAccent accent = getAccent(false);
            OverrideWallpaperInfo overrideWallpaperInfo = this.overrideWallpaper;
            if (overrideWallpaperInfo != null) {
                overrideWallpaperInfo.delete();
            }
            if (info != null) {
                info.parentAccent = accent;
                info.parentTheme = this;
                info.save();
            }
            this.overrideWallpaper = info;
            if (accent != null) {
                accent.overrideWallpaper = info;
            }
        }

        public String getName() {
            if ("Blue".equals(this.name)) {
                return LocaleController.getString("ThemeClassic", R.string.ThemeClassic);
            }
            if ("Dark Blue".equals(this.name)) {
                return LocaleController.getString("ThemeDark", R.string.ThemeDark);
            }
            if ("Arctic Blue".equals(this.name)) {
                return LocaleController.getString("ThemeArcticBlue", R.string.ThemeArcticBlue);
            }
            if ("Day".equals(this.name)) {
                return LocaleController.getString("ThemeDay", R.string.ThemeDay);
            }
            if ("Night".equals(this.name)) {
                return LocaleController.getString("ThemeNight", R.string.ThemeNight);
            }
            TLRPC$TL_theme tLRPC$TL_theme = this.info;
            return tLRPC$TL_theme != null ? tLRPC$TL_theme.title : this.name;
        }

        public void setCurrentAccentId(int id) {
            this.currentAccentId = id;
            ThemeAccent accent = getAccent(false);
            if (accent != null) {
                this.overrideWallpaper = accent.overrideWallpaper;
            }
        }

        public String generateWallpaperName(ThemeAccent accent, boolean original) {
            StringBuilder sb;
            StringBuilder sb2;
            if (accent == null) {
                accent = getAccent(false);
            }
            if (accent != null) {
                StringBuilder sb3 = new StringBuilder();
                if (original) {
                    sb2 = new StringBuilder();
                    sb2.append(this.name);
                    sb2.append("_");
                    sb2.append(accent.id);
                    sb2.append("_wp_o");
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(this.name);
                    sb2.append("_");
                    sb2.append(accent.id);
                    sb2.append("_wp");
                }
                sb3.append(sb2.toString());
                sb3.append(Utilities.random.nextInt());
                sb3.append(".jpg");
                return sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            if (original) {
                sb = new StringBuilder();
                sb.append(this.name);
                sb.append("_wp_o");
            } else {
                sb = new StringBuilder();
                sb.append(this.name);
                sb.append("_wp");
            }
            sb4.append(sb.toString());
            sb4.append(Utilities.random.nextInt());
            sb4.append(".jpg");
            return sb4.toString();
        }

        public void setPreviewInColor(int color) {
            this.previewInColor = color;
        }

        public void setPreviewOutColor(int color) {
            this.previewOutColor = color;
        }

        public void setPreviewBackgroundColor(int color) {
            this.previewBackgroundColor = color;
        }

        public int getPreviewInColor() {
            if (this.firstAccentIsDefault && this.currentAccentId == Theme.DEFALT_THEME_ACCENT_ID) {
                return -1;
            }
            return this.previewInColor;
        }

        public int getPreviewOutColor() {
            if (this.firstAccentIsDefault && this.currentAccentId == Theme.DEFALT_THEME_ACCENT_ID) {
                return -983328;
            }
            return this.previewOutColor;
        }

        public int getPreviewBackgroundColor() {
            if (this.firstAccentIsDefault && this.currentAccentId == Theme.DEFALT_THEME_ACCENT_ID) {
                return -3155485;
            }
            return this.previewBackgroundColor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isDefaultMyMessagesBubbles() {
            if (!this.firstAccentIsDefault) {
                return false;
            }
            int i = this.currentAccentId;
            int i2 = Theme.DEFALT_THEME_ACCENT_ID;
            if (i == i2) {
                return true;
            }
            ThemeAccent themeAccent = this.themeAccentsMap.get(i2);
            ThemeAccent themeAccent2 = this.themeAccentsMap.get(this.currentAccentId);
            return themeAccent != null && themeAccent2 != null && themeAccent.myMessagesAccentColor == themeAccent2.myMessagesAccentColor && themeAccent.myMessagesGradientAccentColor1 == themeAccent2.myMessagesGradientAccentColor1 && themeAccent.myMessagesGradientAccentColor2 == themeAccent2.myMessagesGradientAccentColor2 && themeAccent.myMessagesGradientAccentColor3 == themeAccent2.myMessagesGradientAccentColor3 && themeAccent.myMessagesAnimated == themeAccent2.myMessagesAnimated;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isDefaultMyMessages() {
            if (!this.firstAccentIsDefault) {
                return false;
            }
            int i = this.currentAccentId;
            int i2 = Theme.DEFALT_THEME_ACCENT_ID;
            if (i == i2) {
                return true;
            }
            ThemeAccent themeAccent = this.themeAccentsMap.get(i2);
            ThemeAccent themeAccent2 = this.themeAccentsMap.get(this.currentAccentId);
            return themeAccent != null && themeAccent2 != null && themeAccent.accentColor2 == themeAccent2.accentColor2 && themeAccent.myMessagesAccentColor == themeAccent2.myMessagesAccentColor && themeAccent.myMessagesGradientAccentColor1 == themeAccent2.myMessagesGradientAccentColor1 && themeAccent.myMessagesGradientAccentColor2 == themeAccent2.myMessagesGradientAccentColor2 && themeAccent.myMessagesGradientAccentColor3 == themeAccent2.myMessagesGradientAccentColor3 && themeAccent.myMessagesAnimated == themeAccent2.myMessagesAnimated;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isDefaultMainAccent() {
            if (!this.firstAccentIsDefault) {
                return false;
            }
            int i = this.currentAccentId;
            int i2 = Theme.DEFALT_THEME_ACCENT_ID;
            if (i == i2) {
                return true;
            }
            ThemeAccent themeAccent = this.themeAccentsMap.get(i2);
            ThemeAccent themeAccent2 = this.themeAccentsMap.get(this.currentAccentId);
            return (themeAccent2 == null || themeAccent == null || themeAccent.accentColor != themeAccent2.accentColor) ? false : true;
        }

        public boolean hasAccentColors() {
            return this.defaultAccentCount != 0;
        }

        public boolean isDark() {
            return "Dark Blue".equals(this.name) || "Night".equals(this.name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean checkIsDark(HashMap<String, Integer> colors, ThemeInfo info) {
            if (info == null || colors == null) {
                return false;
            }
            return info.isDark() || ColorUtils.calculateLuminance(ColorUtils.blendARGB(Theme.getPreviewColor(colors, "windowBackgroundWhite"), Theme.getPreviewColor(colors, "windowBackgroundWhite"), 0.5f)) < 0.5d;
        }

        public boolean isLight() {
            return this.pathToFile == null && !isDark();
        }

        public String getKey() {
            if (this.info != null) {
                return "remote" + this.info.id;
            }
            return this.name;
        }

        static ThemeInfo createWithJson(JSONObject object) {
            if (object == null) {
                return null;
            }
            try {
                ThemeInfo themeInfo = new ThemeInfo();
                themeInfo.name = object.getString("name");
                themeInfo.pathToFile = object.getString("path");
                if (object.has("account")) {
                    themeInfo.account = object.getInt("account");
                }
                if (object.has("info")) {
                    try {
                        SerializedData serializedData = new SerializedData(Utilities.hexToBytes(object.getString("info")));
                        themeInfo.info = (TLRPC$TL_theme) TLRPC$Theme.TLdeserialize(serializedData, serializedData.readInt32(true), true);
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                }
                if (object.has("loaded")) {
                    themeInfo.loaded = object.getBoolean("loaded");
                }
                return themeInfo;
            } catch (Exception e) {
                FileLog.e(e);
                return null;
            }
        }

        static ThemeInfo createWithString(String string) {
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            String[] strArrSplit = string.split("\\|");
            if (strArrSplit.length != 2) {
                return null;
            }
            ThemeInfo themeInfo = new ThemeInfo();
            themeInfo.name = strArrSplit[0];
            themeInfo.pathToFile = strArrSplit[1];
            return themeInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAccentColorOptions(int[] accent, int[] myMessages, int[] myMessagesGradient, int[] background, int[] backgroundGradient1, int[] backgroundGradient2, int[] backgroundGradient3, int[] ids, String[] patternSlugs, int[] patternRotations, int[] patternIntensities) {
            this.defaultAccentCount = accent.length;
            this.themeAccents = new ArrayList<>();
            this.themeAccentsMap = new SparseArray<>();
            this.accentsByThemeId = new LongSparseArray<>();
            for (int i = 0; i < accent.length; i++) {
                ThemeAccent themeAccent = new ThemeAccent();
                int i2 = ids != null ? ids[i] : i;
                themeAccent.id = i2;
                themeAccent.accentColor = accent[i];
                themeAccent.parentTheme = this;
                if (myMessages != null) {
                    themeAccent.myMessagesAccentColor = myMessages[i];
                }
                if (myMessagesGradient != null) {
                    themeAccent.myMessagesGradientAccentColor1 = myMessagesGradient[i];
                }
                if (background != null) {
                    themeAccent.backgroundOverrideColor = background[i];
                    if (this.firstAccentIsDefault && i2 == Theme.DEFALT_THEME_ACCENT_ID) {
                        themeAccent.backgroundOverrideColor = 4294967296L;
                    } else {
                        themeAccent.backgroundOverrideColor = background[i];
                    }
                }
                if (backgroundGradient1 != null) {
                    if (this.firstAccentIsDefault && i2 == Theme.DEFALT_THEME_ACCENT_ID) {
                        themeAccent.backgroundGradientOverrideColor1 = 4294967296L;
                    } else {
                        themeAccent.backgroundGradientOverrideColor1 = backgroundGradient1[i];
                    }
                }
                if (backgroundGradient2 != null) {
                    if (this.firstAccentIsDefault && i2 == Theme.DEFALT_THEME_ACCENT_ID) {
                        themeAccent.backgroundGradientOverrideColor2 = 4294967296L;
                    } else {
                        themeAccent.backgroundGradientOverrideColor2 = backgroundGradient2[i];
                    }
                }
                if (backgroundGradient3 != null) {
                    if (this.firstAccentIsDefault && i2 == Theme.DEFALT_THEME_ACCENT_ID) {
                        themeAccent.backgroundGradientOverrideColor3 = 4294967296L;
                    } else {
                        themeAccent.backgroundGradientOverrideColor3 = backgroundGradient3[i];
                    }
                }
                if (patternSlugs != null) {
                    themeAccent.patternIntensity = patternIntensities[i] / 100.0f;
                    themeAccent.backgroundRotation = patternRotations[i];
                    themeAccent.patternSlug = patternSlugs[i];
                }
                this.themeAccentsMap.put(i2, themeAccent);
                this.themeAccents.add(themeAccent);
            }
            this.accentBaseColor = this.themeAccentsMap.get(0).accentColor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadThemeDocument() {
            this.loaded = false;
            this.loadingThemeWallpaperName = null;
            this.newPathToWallpaper = null;
            addObservers();
            FileLoader fileLoader = FileLoader.getInstance(this.account);
            TLRPC$TL_theme tLRPC$TL_theme = this.info;
            fileLoader.loadFile(tLRPC$TL_theme.document, tLRPC$TL_theme, 1, 1);
        }

        private void addObservers() {
            NotificationCenter.getInstance(this.account).addObserver(this, NotificationCenter.fileLoaded);
            NotificationCenter.getInstance(this.account).addObserver(this, NotificationCenter.fileLoadFailed);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeObservers() {
            NotificationCenter.getInstance(this.account).removeObserver(this, NotificationCenter.fileLoaded);
            NotificationCenter.getInstance(this.account).removeObserver(this, NotificationCenter.fileLoadFailed);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onFinishLoadingRemoteTheme() throws JSONException {
            this.loaded = true;
            this.previewParsed = false;
            Theme.saveOtherThemes(true);
            if (this == Theme.currentTheme && Theme.previousTheme == null) {
                NotificationCenter globalInstance = NotificationCenter.getGlobalInstance();
                int i = NotificationCenter.needSetDayNightTheme;
                Object[] objArr = new Object[4];
                objArr[0] = this;
                objArr[1] = Boolean.valueOf(this == Theme.currentNightTheme);
                objArr[2] = null;
                objArr[3] = -1;
                globalInstance.postNotificationName(i, objArr);
            }
        }

        public static boolean accentEquals(ThemeAccent accent, TLRPC$ThemeSettings settings) {
            long j;
            long j2;
            int i;
            String str;
            float f;
            int wallpaperColor;
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings;
            long j3;
            int iIntValue = settings.message_colors.size() > 0 ? settings.message_colors.get(0).intValue() | (-16777216) : 0;
            int iIntValue2 = settings.message_colors.size() > 1 ? settings.message_colors.get(1).intValue() | (-16777216) : 0;
            if (iIntValue == iIntValue2) {
                iIntValue2 = 0;
            }
            int iIntValue3 = settings.message_colors.size() > 2 ? settings.message_colors.get(2).intValue() | (-16777216) : 0;
            int iIntValue4 = settings.message_colors.size() > 3 ? (-16777216) | settings.message_colors.get(3).intValue() : 0;
            TLRPC$WallPaper tLRPC$WallPaper = settings.wallpaper;
            long j4 = 0;
            if (tLRPC$WallPaper == null || (tLRPC$WallPaperSettings = tLRPC$WallPaper.settings) == null) {
                j = 0;
                j2 = 0;
                i = 0;
                str = null;
                f = 0.0f;
                wallpaperColor = 0;
            } else {
                wallpaperColor = Theme.getWallpaperColor(tLRPC$WallPaperSettings.background_color);
                long wallpaperColor2 = settings.wallpaper.settings.second_background_color == 0 ? 4294967296L : Theme.getWallpaperColor(r11);
                long wallpaperColor3 = settings.wallpaper.settings.third_background_color == 0 ? 4294967296L : Theme.getWallpaperColor(r11);
                long wallpaperColor4 = settings.wallpaper.settings.fourth_background_color == 0 ? 4294967296L : Theme.getWallpaperColor(r11);
                int wallpaperRotation = AndroidUtilities.getWallpaperRotation(settings.wallpaper.settings.rotation, false);
                TLRPC$WallPaper tLRPC$WallPaper2 = settings.wallpaper;
                if ((tLRPC$WallPaper2 instanceof TLRPC$TL_wallPaperNoFile) || !tLRPC$WallPaper2.pattern) {
                    i = wallpaperRotation;
                    j3 = wallpaperColor3;
                    str = null;
                    f = 0.0f;
                } else {
                    j3 = wallpaperColor3;
                    f = tLRPC$WallPaper2.settings.intensity / 100.0f;
                    str = tLRPC$WallPaper2.slug;
                    i = wallpaperRotation;
                }
                long j5 = wallpaperColor4;
                j4 = wallpaperColor2;
                j = j3;
                j2 = j5;
            }
            return settings.accent_color == accent.accentColor && settings.outbox_accent_color == accent.accentColor2 && iIntValue == accent.myMessagesAccentColor && iIntValue2 == accent.myMessagesGradientAccentColor1 && iIntValue3 == accent.myMessagesGradientAccentColor2 && iIntValue4 == accent.myMessagesGradientAccentColor3 && settings.message_colors_animated == accent.myMessagesAnimated && ((long) wallpaperColor) == accent.backgroundOverrideColor && j4 == accent.backgroundGradientOverrideColor1 && j == accent.backgroundGradientOverrideColor2 && j2 == accent.backgroundGradientOverrideColor3 && i == accent.backgroundRotation && TextUtils.equals(str, accent.patternSlug) && ((double) Math.abs(f - accent.patternIntensity)) < 0.001d;
        }

        public static void fillAccentValues(ThemeAccent themeAccent, TLRPC$ThemeSettings settings) {
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings;
            themeAccent.accentColor = settings.accent_color;
            themeAccent.accentColor2 = settings.outbox_accent_color;
            themeAccent.myMessagesAccentColor = settings.message_colors.size() > 0 ? settings.message_colors.get(0).intValue() | (-16777216) : 0;
            int iIntValue = settings.message_colors.size() > 1 ? settings.message_colors.get(1).intValue() | (-16777216) : 0;
            themeAccent.myMessagesGradientAccentColor1 = iIntValue;
            if (themeAccent.myMessagesAccentColor == iIntValue) {
                themeAccent.myMessagesGradientAccentColor1 = 0;
            }
            themeAccent.myMessagesGradientAccentColor2 = settings.message_colors.size() > 2 ? settings.message_colors.get(2).intValue() | (-16777216) : 0;
            themeAccent.myMessagesGradientAccentColor3 = settings.message_colors.size() > 3 ? settings.message_colors.get(3).intValue() | (-16777216) : 0;
            themeAccent.myMessagesAnimated = settings.message_colors_animated;
            TLRPC$WallPaper tLRPC$WallPaper = settings.wallpaper;
            if (tLRPC$WallPaper == null || (tLRPC$WallPaperSettings = tLRPC$WallPaper.settings) == null) {
                return;
            }
            if (tLRPC$WallPaperSettings.background_color == 0) {
                themeAccent.backgroundOverrideColor = 4294967296L;
            } else {
                themeAccent.backgroundOverrideColor = Theme.getWallpaperColor(r0);
            }
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings2 = settings.wallpaper.settings;
            if ((tLRPC$WallPaperSettings2.flags & 16) != 0 && tLRPC$WallPaperSettings2.second_background_color == 0) {
                themeAccent.backgroundGradientOverrideColor1 = 4294967296L;
            } else {
                themeAccent.backgroundGradientOverrideColor1 = Theme.getWallpaperColor(tLRPC$WallPaperSettings2.second_background_color);
            }
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings3 = settings.wallpaper.settings;
            if ((tLRPC$WallPaperSettings3.flags & 32) != 0 && tLRPC$WallPaperSettings3.third_background_color == 0) {
                themeAccent.backgroundGradientOverrideColor2 = 4294967296L;
            } else {
                themeAccent.backgroundGradientOverrideColor2 = Theme.getWallpaperColor(tLRPC$WallPaperSettings3.third_background_color);
            }
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings4 = settings.wallpaper.settings;
            if ((tLRPC$WallPaperSettings4.flags & 64) != 0 && tLRPC$WallPaperSettings4.fourth_background_color == 0) {
                themeAccent.backgroundGradientOverrideColor3 = 4294967296L;
            } else {
                themeAccent.backgroundGradientOverrideColor3 = Theme.getWallpaperColor(tLRPC$WallPaperSettings4.fourth_background_color);
            }
            themeAccent.backgroundRotation = AndroidUtilities.getWallpaperRotation(settings.wallpaper.settings.rotation, false);
            TLRPC$WallPaper tLRPC$WallPaper2 = settings.wallpaper;
            if ((tLRPC$WallPaper2 instanceof TLRPC$TL_wallPaperNoFile) || !tLRPC$WallPaper2.pattern) {
                return;
            }
            themeAccent.patternSlug = tLRPC$WallPaper2.slug;
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings5 = tLRPC$WallPaper2.settings;
            themeAccent.patternIntensity = tLRPC$WallPaperSettings5.intensity / 100.0f;
            themeAccent.patternMotion = tLRPC$WallPaperSettings5.motion;
        }

        public ThemeAccent createNewAccent(TLRPC$ThemeSettings settings) {
            ThemeAccent themeAccent = new ThemeAccent();
            fillAccentValues(themeAccent, settings);
            themeAccent.parentTheme = this;
            return themeAccent;
        }

        public ThemeAccent createNewAccent(TLRPC$TL_theme info, int account) {
            return createNewAccent(info, account, false);
        }

        public ThemeAccent createNewAccent(TLRPC$TL_theme info, int account, boolean ignoreThemeInfoId) {
            if (info == null) {
                return null;
            }
            if (ignoreThemeInfoId) {
                ThemeAccent themeAccent = this.chatAccentsByThemeId.get(info.id);
                if (themeAccent != null) {
                    return themeAccent;
                }
                int i = this.lastChatThemeId + 1;
                this.lastChatThemeId = i;
                ThemeAccent themeAccentCreateNewAccent = createNewAccent(info.settings);
                themeAccentCreateNewAccent.id = i;
                themeAccentCreateNewAccent.info = info;
                themeAccentCreateNewAccent.account = account;
                this.chatAccentsByThemeId.put(i, themeAccentCreateNewAccent);
                return themeAccentCreateNewAccent;
            }
            ThemeAccent themeAccent2 = this.accentsByThemeId.get(info.id);
            if (themeAccent2 != null) {
                return themeAccent2;
            }
            int i2 = this.lastAccentId + 1;
            this.lastAccentId = i2;
            ThemeAccent themeAccentCreateNewAccent2 = createNewAccent(info.settings);
            themeAccentCreateNewAccent2.id = i2;
            themeAccentCreateNewAccent2.info = info;
            themeAccentCreateNewAccent2.account = account;
            this.themeAccentsMap.put(i2, themeAccentCreateNewAccent2);
            this.themeAccents.add(0, themeAccentCreateNewAccent2);
            this.accentsByThemeId.put(info.id, themeAccentCreateNewAccent2);
            return themeAccentCreateNewAccent2;
        }

        public ThemeAccent getAccent(boolean createNew) {
            if (this.themeAccents == null) {
                return null;
            }
            ThemeAccent themeAccent = this.themeAccentsMap.get(this.currentAccentId);
            if (!createNew) {
                return themeAccent;
            }
            int i = this.lastAccentId + 1;
            this.lastAccentId = i;
            ThemeAccent themeAccent2 = new ThemeAccent();
            themeAccent2.accentColor = themeAccent.accentColor;
            themeAccent2.accentColor2 = themeAccent.accentColor2;
            themeAccent2.myMessagesAccentColor = themeAccent.myMessagesAccentColor;
            themeAccent2.myMessagesGradientAccentColor1 = themeAccent.myMessagesGradientAccentColor1;
            themeAccent2.myMessagesGradientAccentColor2 = themeAccent.myMessagesGradientAccentColor2;
            themeAccent2.myMessagesGradientAccentColor3 = themeAccent.myMessagesGradientAccentColor3;
            themeAccent2.myMessagesAnimated = themeAccent.myMessagesAnimated;
            themeAccent2.backgroundOverrideColor = themeAccent.backgroundOverrideColor;
            themeAccent2.backgroundGradientOverrideColor1 = themeAccent.backgroundGradientOverrideColor1;
            themeAccent2.backgroundGradientOverrideColor2 = themeAccent.backgroundGradientOverrideColor2;
            themeAccent2.backgroundGradientOverrideColor3 = themeAccent.backgroundGradientOverrideColor3;
            themeAccent2.backgroundRotation = themeAccent.backgroundRotation;
            themeAccent2.patternSlug = themeAccent.patternSlug;
            themeAccent2.patternIntensity = themeAccent.patternIntensity;
            themeAccent2.patternMotion = themeAccent.patternMotion;
            themeAccent2.parentTheme = this;
            OverrideWallpaperInfo overrideWallpaperInfo = this.overrideWallpaper;
            if (overrideWallpaperInfo != null) {
                themeAccent2.overrideWallpaper = new OverrideWallpaperInfo(overrideWallpaperInfo, this, themeAccent2);
            }
            this.prevAccentId = this.currentAccentId;
            themeAccent2.id = i;
            this.currentAccentId = i;
            this.overrideWallpaper = themeAccent2.overrideWallpaper;
            this.themeAccentsMap.put(i, themeAccent2);
            this.themeAccents.add(0, themeAccent2);
            return themeAccent2;
        }

        public int getAccentColor(int id) {
            ThemeAccent themeAccent = this.themeAccentsMap.get(id);
            if (themeAccent != null) {
                return themeAccent.accentColor;
            }
            return 0;
        }

        public boolean createBackground(File file, String toPath) {
            int patternColor;
            try {
                Bitmap scaledBitmap = ThemesHorizontalListCell.getScaledBitmap(AndroidUtilities.dp(640.0f), AndroidUtilities.dp(360.0f), file.getAbsolutePath(), null, 0);
                if (scaledBitmap != null && this.patternBgColor != 0) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(scaledBitmap.getWidth(), scaledBitmap.getHeight(), scaledBitmap.getConfig());
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    int i = this.patternBgGradientColor2;
                    if (i != 0) {
                        patternColor = MotionBackgroundDrawable.getPatternColor(this.patternBgColor, this.patternBgGradientColor1, i, this.patternBgGradientColor3);
                    } else {
                        int i2 = this.patternBgGradientColor1;
                        if (i2 != 0) {
                            patternColor = AndroidUtilities.getAverageColor(this.patternBgColor, i2);
                            GradientDrawable gradientDrawable = new GradientDrawable(BackgroundGradientDrawable.getGradientOrientation(this.patternBgGradientRotation), new int[]{this.patternBgColor, this.patternBgGradientColor1});
                            gradientDrawable.setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                            gradientDrawable.draw(canvas);
                        } else {
                            patternColor = AndroidUtilities.getPatternColor(this.patternBgColor);
                            canvas.drawColor(this.patternBgColor);
                        }
                    }
                    Paint paint = new Paint(2);
                    paint.setColorFilter(new PorterDuffColorFilter(patternColor, PorterDuff.Mode.SRC_IN));
                    paint.setAlpha((int) ((this.patternIntensity / 100.0f) * 255.0f));
                    canvas.drawBitmap(scaledBitmap, 0.0f, 0.0f, paint);
                    canvas.setBitmap(null);
                    scaledBitmap = bitmapCreateBitmap;
                }
                if (this.isBlured) {
                    scaledBitmap = Utilities.blurWallpaper(scaledBitmap);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(toPath);
                scaledBitmap.compress(this.patternBgGradientColor2 != 0 ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 87, fileOutputStream);
                fileOutputStream.close();
                return true;
            } catch (Throwable th) {
                FileLog.e(th);
                return false;
            }
        }

        @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int id, int account, Object... args) throws JSONException {
            int i = NotificationCenter.fileLoaded;
            if (id == i || id == NotificationCenter.fileLoadFailed) {
                String str = (String) args[0];
                TLRPC$TL_theme tLRPC$TL_theme = this.info;
                if (tLRPC$TL_theme == null || tLRPC$TL_theme.document == null) {
                    return;
                }
                if (str.equals(this.loadingThemeWallpaperName)) {
                    this.loadingThemeWallpaperName = null;
                    final File file = (File) args[1];
                    Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$ThemeInfo$DYyzh3f4nc6-WRN4l8-v1540H2g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$didReceivedNotification$0$Theme$ThemeInfo(file);
                        }
                    });
                    return;
                }
                if (str.equals(FileLoader.getAttachFileName(this.info.document))) {
                    removeObservers();
                    if (id == i) {
                        File file2 = new File(this.pathToFile);
                        TLRPC$TL_theme tLRPC$TL_theme2 = this.info;
                        final ThemeInfo themeInfoFillThemeValues = Theme.fillThemeValues(file2, tLRPC$TL_theme2.title, tLRPC$TL_theme2);
                        if (themeInfoFillThemeValues != null && themeInfoFillThemeValues.pathToWallpaper != null && !new File(themeInfoFillThemeValues.pathToWallpaper).exists()) {
                            this.patternBgColor = themeInfoFillThemeValues.patternBgColor;
                            this.patternBgGradientColor1 = themeInfoFillThemeValues.patternBgGradientColor1;
                            this.patternBgGradientColor2 = themeInfoFillThemeValues.patternBgGradientColor2;
                            this.patternBgGradientColor3 = themeInfoFillThemeValues.patternBgGradientColor3;
                            this.patternBgGradientRotation = themeInfoFillThemeValues.patternBgGradientRotation;
                            this.isBlured = themeInfoFillThemeValues.isBlured;
                            this.patternIntensity = themeInfoFillThemeValues.patternIntensity;
                            this.newPathToWallpaper = themeInfoFillThemeValues.pathToWallpaper;
                            TLRPC$TL_account_getWallPaper tLRPC$TL_account_getWallPaper = new TLRPC$TL_account_getWallPaper();
                            TLRPC$TL_inputWallPaperSlug tLRPC$TL_inputWallPaperSlug = new TLRPC$TL_inputWallPaperSlug();
                            tLRPC$TL_inputWallPaperSlug.slug = themeInfoFillThemeValues.slug;
                            tLRPC$TL_account_getWallPaper.wallpaper = tLRPC$TL_inputWallPaperSlug;
                            ConnectionsManager.getInstance(themeInfoFillThemeValues.account).sendRequest(tLRPC$TL_account_getWallPaper, new RequestDelegate() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$ThemeInfo$zXgH1LzpOrF7gQsu57QU15xej7Y
                                @Override // ir.eitaa.tgnet.RequestDelegate
                                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                    this.f$0.lambda$didReceivedNotification$2$Theme$ThemeInfo(themeInfoFillThemeValues, tLObject, tLRPC$TL_error);
                                }
                            });
                            return;
                        }
                        onFinishLoadingRemoteTheme();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didReceivedNotification$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didReceivedNotification$0$Theme$ThemeInfo(File file) {
            createBackground(file, this.newPathToWallpaper);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$ThemeInfo$LhQdgV-e-TzwX73Q_gNhNZ6hM44
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f$0.onFinishLoadingRemoteTheme();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didReceivedNotification$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didReceivedNotification$2$Theme$ThemeInfo(final ThemeInfo themeInfo, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$ThemeInfo$VgYs-g79KfGS1pxiTDsA50Y_KXM
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f$0.lambda$didReceivedNotification$1$Theme$ThemeInfo(tLObject, themeInfo);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didReceivedNotification$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didReceivedNotification$1$Theme$ThemeInfo(TLObject tLObject, ThemeInfo themeInfo) throws JSONException {
            if (tLObject instanceof TLRPC$TL_wallPaper) {
                TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) tLObject;
                this.loadingThemeWallpaperName = FileLoader.getAttachFileName(tLRPC$TL_wallPaper.document);
                addObservers();
                FileLoader.getInstance(themeInfo.account).loadFile(tLRPC$TL_wallPaper.document, tLRPC$TL_wallPaper, 1, 1);
                return;
            }
            onFinishLoadingRemoteTheme();
        }
    }

    public interface ResourcesProvider {
        void applyServiceShaderMatrix(int w, int h, float translationX, float translationY);

        Integer getColor(String key);

        int getColorOrDefault(String key);

        Integer getCurrentColor(String key);

        Drawable getDrawable(String drawableKey);

        Paint getPaint(String paintKey);

        boolean hasGradientService();

        void setAnimatedColor(String key, int color);

        /* renamed from: ir.eitaa.ui.ActionBar.Theme$ResourcesProvider$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Drawable $default$getDrawable(ResourcesProvider resourcesProvider, String str) {
                return null;
            }

            public static Paint $default$getPaint(ResourcesProvider resourcesProvider, String str) {
                return null;
            }

            public static boolean $default$hasGradientService(ResourcesProvider resourcesProvider) {
                return false;
            }

            public static void $default$setAnimatedColor(ResourcesProvider resourcesProvider, String str, int i) {
            }

            public static int $default$getColorOrDefault(ResourcesProvider _this, String str) {
                Integer color = _this.getColor(str);
                return color != null ? color.intValue() : Theme.getColor(str);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x34ed A[Catch: all -> 0x350b, TRY_LEAVE, TryCatch #2 {all -> 0x350b, blocks: (B:131:0x34ca, B:133:0x34d0, B:134:0x34e2, B:136:0x34ed), top: B:257:0x34ca }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x34f9  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x367e A[Catch: Exception -> 0x373a, TryCatch #10 {Exception -> 0x373a, blocks: (B:174:0x364f, B:176:0x3655, B:177:0x3660, B:179:0x3664, B:181:0x366c, B:182:0x3674, B:184:0x367e, B:171:0x35bb, B:173:0x3637, B:191:0x369d, B:192:0x36a3, B:196:0x36ad, B:198:0x3704, B:200:0x3712, B:202:0x3720, B:204:0x372e, B:203:0x3727, B:199:0x370b), top: B:273:0x3655 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x369d A[Catch: Exception -> 0x373a, TryCatch #10 {Exception -> 0x373a, blocks: (B:174:0x364f, B:176:0x3655, B:177:0x3660, B:179:0x3664, B:181:0x366c, B:182:0x3674, B:184:0x367e, B:171:0x35bb, B:173:0x3637, B:191:0x369d, B:192:0x36a3, B:196:0x36ad, B:198:0x3704, B:200:0x3712, B:202:0x3720, B:204:0x372e, B:203:0x3727, B:199:0x370b), top: B:273:0x3655 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x36ab  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x36ac  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x3704 A[Catch: Exception -> 0x373a, TryCatch #10 {Exception -> 0x373a, blocks: (B:174:0x364f, B:176:0x3655, B:177:0x3660, B:179:0x3664, B:181:0x366c, B:182:0x3674, B:184:0x367e, B:171:0x35bb, B:173:0x3637, B:191:0x369d, B:192:0x36a3, B:196:0x36ad, B:198:0x3704, B:200:0x3712, B:202:0x3720, B:204:0x372e, B:203:0x3727, B:199:0x370b), top: B:273:0x3655 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x370b A[Catch: Exception -> 0x373a, TryCatch #10 {Exception -> 0x373a, blocks: (B:174:0x364f, B:176:0x3655, B:177:0x3660, B:179:0x3664, B:181:0x366c, B:182:0x3674, B:184:0x367e, B:171:0x35bb, B:173:0x3637, B:191:0x369d, B:192:0x36a3, B:196:0x36ad, B:198:0x3704, B:200:0x3712, B:202:0x3720, B:204:0x372e, B:203:0x3727, B:199:0x370b), top: B:273:0x3655 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x3720 A[Catch: Exception -> 0x373a, TryCatch #10 {Exception -> 0x373a, blocks: (B:174:0x364f, B:176:0x3655, B:177:0x3660, B:179:0x3664, B:181:0x366c, B:182:0x3674, B:184:0x367e, B:171:0x35bb, B:173:0x3637, B:191:0x369d, B:192:0x36a3, B:196:0x36ad, B:198:0x3704, B:200:0x3712, B:202:0x3720, B:204:0x372e, B:203:0x3727, B:199:0x370b), top: B:273:0x3655 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x3727 A[Catch: Exception -> 0x373a, TryCatch #10 {Exception -> 0x373a, blocks: (B:174:0x364f, B:176:0x3655, B:177:0x3660, B:179:0x3664, B:181:0x366c, B:182:0x3674, B:184:0x367e, B:171:0x35bb, B:173:0x3637, B:191:0x369d, B:192:0x36a3, B:196:0x36ad, B:198:0x3704, B:200:0x3712, B:202:0x3720, B:204:0x372e, B:203:0x3727, B:199:0x370b), top: B:273:0x3655 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x3751  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x375b  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x3763  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x3788  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x37b7  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x3805  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x3824  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x3831  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x3655 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x368f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x3307 A[Catch: Exception -> 0x32f7, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x32f7, blocks: (B:38:0x32ec, B:44:0x3307, B:57:0x332d), top: B:256:0x32ec }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x331a A[Catch: Exception -> 0x3747, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x3747, blocks: (B:36:0x32d9, B:42:0x32fb, B:49:0x331a), top: B:269:0x32d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x3360 A[Catch: Exception -> 0x3317, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x3317, blocks: (B:45:0x3312, B:66:0x3360, B:78:0x3392, B:80:0x339a, B:90:0x33fb, B:71:0x3379, B:73:0x3382, B:75:0x338c, B:59:0x3338, B:61:0x3340), top: B:254:0x3305 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x3371 A[Catch: Exception -> 0x3743, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x3743, blocks: (B:64:0x3352, B:69:0x3371), top: B:265:0x3352 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x33be A[Catch: Exception -> 0x373c, TryCatch #12 {Exception -> 0x373c, blocks: (B:76:0x338e, B:81:0x33ac, B:82:0x33b8, B:84:0x33be, B:86:0x33c9, B:88:0x33cd, B:93:0x33ff), top: B:277:0x338e }] */
    /* JADX WARN: Type inference failed for: r12v40, types: [ir.eitaa.tgnet.AbstractSerializedData, ir.eitaa.tgnet.SerializedData] */
    /* JADX WARN: Type inference failed for: r12v41 */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r24v4, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r6v21, types: [ir.eitaa.ui.ActionBar.Theme$ThemeInfo] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v62, types: [ir.eitaa.ui.ActionBar.Theme$ThemeInfo] */
    /* JADX WARN: Type inference failed for: r7v630, types: [ir.eitaa.ui.ActionBar.Theme$ThemeInfo] */
    /* JADX WARN: Type inference failed for: r7v631 */
    /* JADX WARN: Type inference failed for: r7v633, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v634 */
    /* JADX WARN: Type inference failed for: r7v640, types: [ir.eitaa.ui.ActionBar.Theme$ThemeInfo] */
    /* JADX WARN: Type inference failed for: r7v644 */
    /* JADX WARN: Type inference failed for: r7v645 */
    /* JADX WARN: Type inference failed for: r7v646 */
    /* JADX WARN: Type inference failed for: r7v650 */
    /* JADX WARN: Type inference failed for: r7v652 */
    /* JADX WARN: Type inference failed for: r7v681 */
    /* JADX WARN: Type inference failed for: r7v684, types: [ir.eitaa.ui.ActionBar.Theme$ThemeInfo] */
    /* JADX WARN: Type inference failed for: r7v698 */
    /* JADX WARN: Type inference failed for: r7v699 */
    /* JADX WARN: Type inference failed for: r7v700 */
    /* JADX WARN: Type inference failed for: r7v701 */
    /* JADX WARN: Type inference failed for: r7v702 */
    static {
        /*
            Method dump skipped, instructions count: 16124
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.<clinit>():void");
    }

    static /* synthetic */ int lambda$static$0(ThemeAccent themeAccent, ThemeAccent themeAccent2) {
        int i = themeAccent.id;
        int i2 = themeAccent2.id;
        if (i > i2) {
            return -1;
        }
        return i < i2 ? 1 : 0;
    }

    public static void saveAutoNightThemeConfig() {
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putInt("selectedAutoNightType", selectedAutoNightType);
        editorEdit.putBoolean("autoNightScheduleByLocation", autoNightScheduleByLocation);
        editorEdit.putFloat("autoNightBrighnessThreshold", autoNightBrighnessThreshold);
        editorEdit.putInt("autoNightDayStartTime", autoNightDayStartTime);
        editorEdit.putInt("autoNightDayEndTime", autoNightDayEndTime);
        editorEdit.putInt("autoNightSunriseTime", autoNightSunriseTime);
        editorEdit.putString("autoNightCityName", autoNightCityName);
        editorEdit.putInt("autoNightSunsetTime", autoNightSunsetTime);
        editorEdit.putLong("autoNightLocationLatitude3", Double.doubleToRawLongBits(autoNightLocationLatitude));
        editorEdit.putLong("autoNightLocationLongitude3", Double.doubleToRawLongBits(autoNightLocationLongitude));
        editorEdit.putInt("autoNightLastSunCheckDay", autoNightLastSunCheckDay);
        ThemeInfo themeInfo = currentNightTheme;
        if (themeInfo != null) {
            editorEdit.putString("nighttheme", themeInfo.getKey());
        } else {
            editorEdit.remove("nighttheme");
        }
        editorEdit.commit();
    }

    public static void switchTheme(int account) {
        ThemeInfo theme = getTheme();
        String currentThemeType2 = getCurrentThemeType();
        currentThemeType = currentThemeType2;
        if (getDefaultAccentId(account, currentThemeType2) == 0) {
            theme.currentAccentId = theme.currentAccentId;
        } else {
            theme.currentAccentId = getDefaultAccentId(account, currentThemeType);
        }
        applyTheme(theme);
    }

    public static String getCurrentThemeType() {
        String string = MessagesController.getMainSettings(UserConfig.selectedAccount).getString("current_theme_type", "Day");
        currentThemeType = string;
        return string;
    }

    public static int getDefaultAccentId(int account, String type) {
        SharedPreferences mainSettings = MessagesController.getMainSettings(account);
        if (account == 1) {
            return mainSettings.getInt("accentId_1_" + type, type.equals("Day") ? 9 : 0);
        }
        if (account == 2) {
            return mainSettings.getInt("accentId_2_" + type, type.equals("Day") ? 10 : 0);
        }
        return mainSettings.getInt("accentId_0_" + type, type.equals("Day") ? 99 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PrivateApi"})
    public static Drawable getStateDrawable(Drawable drawable, int index) {
        if (Build.VERSION.SDK_INT >= 29 && (drawable instanceof StateListDrawable)) {
            return ((StateListDrawable) drawable).getStateDrawable(index);
        }
        if (StateListDrawable_getStateDrawableMethod == null) {
            try {
                StateListDrawable_getStateDrawableMethod = StateListDrawable.class.getDeclaredMethod("getStateDrawable", Integer.TYPE);
            } catch (Throwable unused) {
            }
        }
        Method method = StateListDrawable_getStateDrawableMethod;
        if (method == null) {
            return null;
        }
        try {
            return (Drawable) method.invoke(drawable, Integer.valueOf(index));
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Drawable createEmojiIconSelectorDrawable(Context context, int resource, int defaultColor, int pressedColor) {
        Resources resources = context.getResources();
        Drawable drawableMutate = resources.getDrawable(resource).mutate();
        if (defaultColor != 0) {
            drawableMutate.setColorFilter(new PorterDuffColorFilter(defaultColor, PorterDuff.Mode.MULTIPLY));
        }
        Drawable drawableMutate2 = resources.getDrawable(resource).mutate();
        if (pressedColor != 0) {
            drawableMutate2.setColorFilter(new PorterDuffColorFilter(pressedColor, PorterDuff.Mode.MULTIPLY));
        }
        StateListDrawable stateListDrawable = new StateListDrawable() { // from class: ir.eitaa.ui.ActionBar.Theme.3
            @Override // android.graphics.drawable.DrawableContainer
            public boolean selectDrawable(int index) {
                if (Build.VERSION.SDK_INT < 21) {
                    Drawable stateDrawable = Theme.getStateDrawable(this, index);
                    ColorFilter colorFilter = null;
                    if (stateDrawable instanceof BitmapDrawable) {
                        colorFilter = ((BitmapDrawable) stateDrawable).getPaint().getColorFilter();
                    } else if (stateDrawable instanceof NinePatchDrawable) {
                        colorFilter = ((NinePatchDrawable) stateDrawable).getPaint().getColorFilter();
                    }
                    boolean zSelectDrawable = super.selectDrawable(index);
                    if (colorFilter != null) {
                        stateDrawable.setColorFilter(colorFilter);
                    }
                    return zSelectDrawable;
                }
                return super.selectDrawable(index);
            }
        };
        stateListDrawable.setEnterFadeDuration(1);
        stateListDrawable.setExitFadeDuration(200);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, drawableMutate2);
        stateListDrawable.addState(new int[0], drawableMutate);
        return stateListDrawable;
    }

    public static Drawable createEditTextDrawable(Context context, boolean alert) {
        return createEditTextDrawable(context, getColor(alert ? "dialogInputField" : "windowBackgroundWhiteInputField"), getColor(alert ? "dialogInputFieldActivated" : "windowBackgroundWhiteInputFieldActivated"));
    }

    public static Drawable createEditTextDrawable(Context context, int color, int colorActivated) {
        Resources resources = context.getResources();
        Drawable drawableMutate = resources.getDrawable(R.drawable.search_dark).mutate();
        drawableMutate.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        Drawable drawableMutate2 = resources.getDrawable(R.drawable.search_dark_activated).mutate();
        drawableMutate2.setColorFilter(new PorterDuffColorFilter(colorActivated, PorterDuff.Mode.MULTIPLY));
        StateListDrawable stateListDrawable = new StateListDrawable() { // from class: ir.eitaa.ui.ActionBar.Theme.4
            @Override // android.graphics.drawable.DrawableContainer
            public boolean selectDrawable(int index) {
                if (Build.VERSION.SDK_INT < 21) {
                    Drawable stateDrawable = Theme.getStateDrawable(this, index);
                    ColorFilter colorFilter = null;
                    if (stateDrawable instanceof BitmapDrawable) {
                        colorFilter = ((BitmapDrawable) stateDrawable).getPaint().getColorFilter();
                    } else if (stateDrawable instanceof NinePatchDrawable) {
                        colorFilter = ((NinePatchDrawable) stateDrawable).getPaint().getColorFilter();
                    }
                    boolean zSelectDrawable = super.selectDrawable(index);
                    if (colorFilter != null) {
                        stateDrawable.setColorFilter(colorFilter);
                    }
                    return zSelectDrawable;
                }
                return super.selectDrawable(index);
            }
        };
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, drawableMutate2);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, drawableMutate2);
        stateListDrawable.addState(StateSet.WILD_CARD, drawableMutate);
        return stateListDrawable;
    }

    public static boolean canStartHolidayAnimation() {
        return canStartHolidayAnimation;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.drawable.Drawable getCurrentHolidayDrawable() {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = ir.eitaa.ui.ActionBar.Theme.lastHolidayCheckTime
            long r0 = r0 - r2
            r2 = 60000(0xea60, double:2.9644E-319)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L80
            long r0 = java.lang.System.currentTimeMillis()
            ir.eitaa.ui.ActionBar.Theme.lastHolidayCheckTime = r0
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            long r1 = java.lang.System.currentTimeMillis()
            r0.setTimeInMillis(r1)
            r1 = 2
            int r1 = r0.get(r1)
            r2 = 5
            int r2 = r0.get(r2)
            r3 = 12
            int r3 = r0.get(r3)
            r4 = 11
            int r0 = r0.get(r4)
            r5 = 1
            if (r1 != 0) goto L43
            if (r2 != r5) goto L43
            r6 = 10
            if (r3 > r6) goto L43
            if (r0 != 0) goto L43
            ir.eitaa.ui.ActionBar.Theme.canStartHolidayAnimation = r5
            goto L46
        L43:
            r0 = 0
            ir.eitaa.ui.ActionBar.Theme.canStartHolidayAnimation = r0
        L46:
            android.graphics.drawable.Drawable r0 = ir.eitaa.ui.ActionBar.Theme.dialogs_holidayDrawable
            if (r0 != 0) goto L80
            if (r1 != r4) goto L5b
            boolean r0 = ir.eitaa.messenger.BuildVars.DEBUG_PRIVATE_VERSION
            r3 = 31
            if (r0 == 0) goto L55
            r0 = 29
            goto L57
        L55:
            r0 = 31
        L57:
            if (r2 < r0) goto L5b
            if (r2 <= r3) goto L5f
        L5b:
            if (r1 != 0) goto L80
            if (r2 != r5) goto L80
        L5f:
            android.content.Context r0 = ir.eitaa.messenger.ApplicationLoader.applicationContext
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131231543(0x7f080337, float:1.807917E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)
            ir.eitaa.ui.ActionBar.Theme.dialogs_holidayDrawable = r0
            r0 = 1077936128(0x40400000, float:3.0)
            int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
            int r0 = -r0
            ir.eitaa.ui.ActionBar.Theme.dialogs_holidayDrawableOffsetX = r0
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
            int r0 = -r0
            ir.eitaa.ui.ActionBar.Theme.dialogs_holidayDrawableOffsetY = r0
        L80:
            android.graphics.drawable.Drawable r0 = ir.eitaa.ui.ActionBar.Theme.dialogs_holidayDrawable
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.getCurrentHolidayDrawable():android.graphics.drawable.Drawable");
    }

    public static int getCurrentHolidayDrawableXOffset() {
        return dialogs_holidayDrawableOffsetX;
    }

    public static int getCurrentHolidayDrawableYOffset() {
        return dialogs_holidayDrawableOffsetY;
    }

    public static ShapeDrawable createCircleDrawable(int size, int color) {
        OvalShape ovalShape = new OvalShape();
        float f = size;
        ovalShape.resize(f, f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.setIntrinsicWidth(size);
        shapeDrawable.setIntrinsicHeight(size);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    public static CombinedDrawable createCircleDrawableWithIcon(int size, int iconRes) {
        return createCircleDrawableWithIcon(size, iconRes, 0);
    }

    public static CombinedDrawable createCircleDrawableWithIcon(int size, int iconRes, int stroke) {
        return createCircleDrawableWithIcon(size, iconRes != 0 ? ApplicationLoader.applicationContext.getResources().getDrawable(iconRes).mutate() : null, stroke);
    }

    public static CombinedDrawable createCircleDrawableWithIcon(int size, Drawable drawable, int stroke) {
        OvalShape ovalShape = new OvalShape();
        float f = size;
        ovalShape.resize(f, f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(-1);
        if (stroke == 1) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        } else if (stroke == 2) {
            paint.setAlpha(0);
        }
        CombinedDrawable combinedDrawable = new CombinedDrawable(shapeDrawable, drawable);
        combinedDrawable.setCustomSize(size, size);
        return combinedDrawable;
    }

    public static Drawable createRoundRectDrawableWithIcon(int rad, int iconRes) {
        float f = rad;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(-1);
        return new CombinedDrawable(shapeDrawable, ApplicationLoader.applicationContext.getResources().getDrawable(iconRes).mutate());
    }

    public static float getThemeIntensity(float value) {
        return (value >= 0.0f || getActiveTheme().isDark()) ? value : -value;
    }

    public static void setCombinedDrawableColor(Drawable combinedDrawable, int color, boolean isIcon) {
        Drawable background;
        if (combinedDrawable instanceof CombinedDrawable) {
            if (isIcon) {
                background = ((CombinedDrawable) combinedDrawable).getIcon();
            } else {
                background = ((CombinedDrawable) combinedDrawable).getBackground();
            }
            if (background instanceof ColorDrawable) {
                ((ColorDrawable) background).setColor(color);
            } else {
                background.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
            }
        }
    }

    public static Drawable createSimpleSelectorCircleDrawable(int size, int defaultColor, int pressedColor) {
        OvalShape ovalShape = new OvalShape();
        float f = size;
        ovalShape.resize(f, f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.getPaint().setColor(defaultColor);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(ovalShape);
        if (Build.VERSION.SDK_INT >= 21) {
            shapeDrawable2.getPaint().setColor(-1);
            return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{pressedColor}), shapeDrawable, shapeDrawable2);
        }
        shapeDrawable2.getPaint().setColor(pressedColor);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, shapeDrawable2);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, shapeDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, shapeDrawable);
        return stateListDrawable;
    }

    public static Drawable createRoundRectDrawable(int rad, int defaultColor) {
        float f = rad;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(defaultColor);
        return shapeDrawable;
    }

    public static Drawable createServiceDrawable(int rad, View view, View containerView) {
        return createServiceDrawable(rad, view, containerView, chat_actionBackgroundPaint);
    }

    public static Drawable createServiceDrawable(final int rad, final View view, final View containerView, final Paint backgroundPaint) {
        return new Drawable() { // from class: ir.eitaa.ui.ActionBar.Theme.6
            private RectF rect = new RectF();

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return -2;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int alpha) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(ColorFilter colorFilter) {
            }

            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Rect bounds = getBounds();
                this.rect.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
                Theme.applyServiceShaderMatrixForView(view, containerView);
                RectF rectF = this.rect;
                int i = rad;
                canvas.drawRoundRect(rectF, i, i, backgroundPaint);
                if (Theme.hasGradientService()) {
                    RectF rectF2 = this.rect;
                    int i2 = rad;
                    canvas.drawRoundRect(rectF2, i2, i2, Theme.chat_actionBackgroundGradientDarkenPaint);
                }
            }
        };
    }

    public static Drawable createSimpleSelectorRoundRectDrawable(int rad, int defaultColor, int pressedColor) {
        return createSimpleSelectorRoundRectDrawable(rad, defaultColor, pressedColor, pressedColor);
    }

    public static Drawable createSimpleSelectorRoundRectDrawable(int rad, int defaultColor, int pressedColor, int maskColor) {
        float f = rad;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(defaultColor);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable2.getPaint().setColor(maskColor);
        if (Build.VERSION.SDK_INT >= 21) {
            return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{pressedColor}), shapeDrawable, shapeDrawable2);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, shapeDrawable2);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, shapeDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, shapeDrawable);
        return stateListDrawable;
    }

    public static Drawable createSelectorDrawableFromDrawables(Drawable normal, Drawable pressed) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, pressed);
        stateListDrawable.addState(StateSet.WILD_CARD, normal);
        return stateListDrawable;
    }

    public static Drawable getRoundRectSelectorDrawable(int color) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{(color & 16777215) | 419430400}), null, createRoundRectDrawable(AndroidUtilities.dp(3.0f), -1));
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        int i = (color & 16777215) | 419430400;
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, createRoundRectDrawable(AndroidUtilities.dp(3.0f), i));
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, createRoundRectDrawable(AndroidUtilities.dp(3.0f), i));
        stateListDrawable.addState(StateSet.WILD_CARD, new ColorDrawable(0));
        return stateListDrawable;
    }

    public static Drawable createSelectorWithBackgroundDrawable(int backgroundColor, int color) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{color}), new ColorDrawable(backgroundColor), new ColorDrawable(backgroundColor));
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(color));
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, new ColorDrawable(color));
        stateListDrawable.addState(StateSet.WILD_CARD, new ColorDrawable(backgroundColor));
        return stateListDrawable;
    }

    public static Drawable getSelectorDrawable(boolean whiteBackground) {
        return getSelectorDrawable(getColor("listSelectorSDK21"), whiteBackground);
    }

    public static Drawable getSelectorDrawable(int color, boolean whiteBackground) {
        if (whiteBackground) {
            return getSelectorDrawable(color, "windowBackgroundWhite");
        }
        return createSelectorDrawable(color, 2);
    }

    public static Drawable getSelectorDrawable(int color, String backgroundColor) {
        if (backgroundColor != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{color}), new ColorDrawable(getColor(backgroundColor)), new ColorDrawable(-1));
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(color));
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, new ColorDrawable(color));
            stateListDrawable.addState(StateSet.WILD_CARD, new ColorDrawable(getColor(backgroundColor)));
            return stateListDrawable;
        }
        return createSelectorDrawable(color, 2);
    }

    public static Drawable createSelectorDrawable(int color) {
        return createSelectorDrawable(color, 1, -1);
    }

    public static Drawable createSelectorDrawable(int color, int maskType) {
        return createSelectorDrawable(color, maskType, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.drawable.Drawable createSelectorDrawable(int r11, final int r12, int r13) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 1
            r3 = 21
            if (r0 < r3) goto L63
            r3 = 23
            r4 = -1
            r5 = 5
            r6 = 0
            if (r12 == r2) goto L11
            if (r12 != r5) goto L15
        L11:
            if (r0 < r3) goto L15
        L13:
            r7 = r6
            goto L39
        L15:
            if (r12 == r2) goto L2f
            r7 = 3
            if (r12 == r7) goto L2f
            r7 = 4
            if (r12 == r7) goto L2f
            if (r12 == r5) goto L2f
            r7 = 6
            if (r12 == r7) goto L2f
            r7 = 7
            if (r12 != r7) goto L26
            goto L2f
        L26:
            r7 = 2
            if (r12 != r7) goto L13
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>(r4)
            goto L39
        L2f:
            android.graphics.Paint r7 = ir.eitaa.ui.ActionBar.Theme.maskPaint
            r7.setColor(r4)
            ir.eitaa.ui.ActionBar.Theme$7 r7 = new ir.eitaa.ui.ActionBar.Theme$7
            r7.<init>()
        L39:
            android.content.res.ColorStateList r8 = new android.content.res.ColorStateList
            int[][] r9 = new int[r2][]
            int[] r10 = android.util.StateSet.WILD_CARD
            r9[r1] = r10
            int[] r10 = new int[r2]
            r10[r1] = r11
            r8.<init>(r9, r10)
            android.graphics.drawable.RippleDrawable r11 = new android.graphics.drawable.RippleDrawable
            r11.<init>(r8, r6, r7)
            if (r0 < r3) goto L62
            if (r12 != r2) goto L5d
            if (r13 > 0) goto L59
            r12 = 1101004800(0x41a00000, float:20.0)
            int r13 = ir.eitaa.messenger.AndroidUtilities.dp(r12)
        L59:
            r11.setRadius(r13)
            goto L62
        L5d:
            if (r12 != r5) goto L62
            r11.setRadius(r4)
        L62:
            return r11
        L63:
            android.graphics.drawable.StateListDrawable r12 = new android.graphics.drawable.StateListDrawable
            r12.<init>()
            int[] r13 = new int[r2]
            r0 = 16842919(0x10100a7, float:2.3694026E-38)
            r13[r1] = r0
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            r0.<init>(r11)
            r12.addState(r13, r0)
            int[] r13 = new int[r2]
            r0 = 16842913(0x10100a1, float:2.369401E-38)
            r13[r1] = r0
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            r0.<init>(r11)
            r12.addState(r13, r0)
            int[] r11 = android.util.StateSet.WILD_CARD
            android.graphics.drawable.ColorDrawable r13 = new android.graphics.drawable.ColorDrawable
            r13.<init>(r1)
            r12.addState(r11, r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.createSelectorDrawable(int, int, int):android.graphics.drawable.Drawable");
    }

    public static Drawable createCircleSelectorDrawable(int color, final int leftInset, final int rightInset) {
        if (Build.VERSION.SDK_INT >= 21) {
            maskPaint.setColor(-1);
            return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{color}), null, new Drawable() { // from class: ir.eitaa.ui.ActionBar.Theme.8
                @Override // android.graphics.drawable.Drawable
                public int getOpacity() {
                    return 0;
                }

                @Override // android.graphics.drawable.Drawable
                public void setAlpha(int alpha) {
                }

                @Override // android.graphics.drawable.Drawable
                public void setColorFilter(ColorFilter colorFilter) {
                }

                @Override // android.graphics.drawable.Drawable
                public void draw(Canvas canvas) {
                    Rect bounds = getBounds();
                    canvas.drawCircle((bounds.centerX() - leftInset) + rightInset, bounds.centerY(), (Math.max(bounds.width(), bounds.height()) / 2) + leftInset + rightInset, Theme.maskPaint);
                }
            });
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(color));
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, new ColorDrawable(color));
        stateListDrawable.addState(StateSet.WILD_CARD, new ColorDrawable(0));
        return stateListDrawable;
    }

    public static class RippleRadMaskDrawable extends Drawable {
        private int bottomRad;
        private int topRad;
        private Path path = new Path();
        private RectF rect = new RectF();
        private float[] radii = new float[8];

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public RippleRadMaskDrawable(int top, int bottom) {
            this.topRad = top;
            this.bottomRad = bottom;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            float[] fArr = this.radii;
            float fDp = AndroidUtilities.dp(this.topRad);
            fArr[3] = fDp;
            fArr[2] = fDp;
            fArr[1] = fDp;
            fArr[0] = fDp;
            float[] fArr2 = this.radii;
            float fDp2 = AndroidUtilities.dp(this.bottomRad);
            fArr2[7] = fDp2;
            fArr2[6] = fDp2;
            fArr2[5] = fDp2;
            fArr2[4] = fDp2;
            this.rect.set(getBounds());
            this.path.addRoundRect(this.rect, this.radii, Path.Direction.CW);
            canvas.drawPath(this.path, Theme.maskPaint);
        }
    }

    public static void setMaskDrawableRad(Drawable rippleDrawable, int top, int bottom) {
        if (Build.VERSION.SDK_INT >= 21 && (rippleDrawable instanceof RippleDrawable)) {
            RippleDrawable rippleDrawable2 = (RippleDrawable) rippleDrawable;
            int numberOfLayers = rippleDrawable2.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                if (rippleDrawable2.getDrawable(i) instanceof RippleRadMaskDrawable) {
                    rippleDrawable2.setDrawableByLayerId(android.R.id.mask, new RippleRadMaskDrawable(top, bottom));
                    return;
                }
            }
        }
    }

    public static Drawable createRadSelectorDrawable(int color, int topRad, int bottomRad) {
        if (Build.VERSION.SDK_INT >= 21) {
            maskPaint.setColor(-1);
            return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{color}), null, new RippleRadMaskDrawable(topRad, bottomRad));
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(color));
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, new ColorDrawable(color));
        stateListDrawable.addState(StateSet.WILD_CARD, new ColorDrawable(0));
        return stateListDrawable;
    }

    public static void applyPreviousTheme() {
        ThemeInfo themeInfo;
        ThemeInfo themeInfo2 = previousTheme;
        if (themeInfo2 == null) {
            return;
        }
        hasPreviousTheme = false;
        if (isInNigthMode && (themeInfo = currentNightTheme) != null) {
            applyTheme(themeInfo, true, false, true);
        } else if (!isApplyingAccent) {
            applyTheme(themeInfo2, true, false, false);
        }
        isApplyingAccent = false;
        previousTheme = null;
        checkAutoNightThemeConditions();
    }

    public static void clearPreviousTheme() {
        if (previousTheme == null) {
            return;
        }
        hasPreviousTheme = false;
        isApplyingAccent = false;
        previousTheme = null;
    }

    private static void sortThemes() {
        Collections.sort(themes, $$Lambda$Theme$rSTjzPlmC34D_SPqq8TM4ZIKWE.INSTANCE);
    }

    static /* synthetic */ int lambda$sortThemes$1(ThemeInfo themeInfo, ThemeInfo themeInfo2) {
        if (themeInfo.pathToFile == null && themeInfo.assetName == null) {
            return -1;
        }
        if (themeInfo2.pathToFile == null && themeInfo2.assetName == null) {
            return 1;
        }
        return themeInfo.name.compareTo(themeInfo2.name);
    }

    public static void applyThemeTemporary(ThemeInfo themeInfo, boolean accent) {
        previousTheme = getCurrentTheme();
        hasPreviousTheme = true;
        isApplyingAccent = accent;
        applyTheme(themeInfo, false, false, false);
    }

    public static boolean hasCustomWallpaper() {
        return isApplyingAccent && currentTheme.overrideWallpaper != null;
    }

    public static boolean isCustomWallpaperColor() {
        return hasCustomWallpaper() && currentTheme.overrideWallpaper.color != 0;
    }

    public static void resetCustomWallpaper(boolean temporary) {
        if (temporary) {
            isApplyingAccent = false;
            reloadWallpaper();
        } else {
            currentTheme.setOverrideWallpaper(null);
        }
    }

    public static ThemeInfo fillThemeValues(File file, String themeName, TLRPC$TL_theme theme) {
        String[] strArrSplit;
        try {
            ThemeInfo themeInfo = new ThemeInfo();
            themeInfo.name = themeName;
            themeInfo.info = theme;
            themeInfo.pathToFile = file.getAbsolutePath();
            themeInfo.account = UserConfig.selectedAccount;
            String[] strArr = new String[1];
            getThemeFileValues(new File(themeInfo.pathToFile), null, strArr);
            if (!TextUtils.isEmpty(strArr[0])) {
                String str = strArr[0];
                themeInfo.pathToWallpaper = new File(ApplicationLoader.getFilesDirFixed(), Utilities.MD5(str) + ".wp").getAbsolutePath();
                try {
                    Uri uri = Uri.parse(str);
                    themeInfo.slug = uri.getQueryParameter("slug");
                    String queryParameter = uri.getQueryParameter("mode");
                    if (queryParameter != null && (strArrSplit = queryParameter.toLowerCase().split(" ")) != null && strArrSplit.length > 0) {
                        for (int i = 0; i < strArrSplit.length; i++) {
                            if ("blur".equals(strArrSplit[i])) {
                                themeInfo.isBlured = true;
                            } else if ("motion".equals(strArrSplit[i])) {
                                themeInfo.isMotion = true;
                            }
                        }
                    }
                    String queryParameter2 = uri.getQueryParameter("intensity");
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        try {
                            String queryParameter3 = uri.getQueryParameter("bg_color");
                            if (!TextUtils.isEmpty(queryParameter3)) {
                                themeInfo.patternBgColor = Integer.parseInt(queryParameter3.substring(0, 6), 16) | (-16777216);
                                if (queryParameter3.length() >= 13 && AndroidUtilities.isValidWallChar(queryParameter3.charAt(6))) {
                                    themeInfo.patternBgGradientColor1 = Integer.parseInt(queryParameter3.substring(7, 13), 16) | (-16777216);
                                }
                                if (queryParameter3.length() >= 20 && AndroidUtilities.isValidWallChar(queryParameter3.charAt(13))) {
                                    themeInfo.patternBgGradientColor2 = Integer.parseInt(queryParameter3.substring(14, 20), 16) | (-16777216);
                                }
                                if (queryParameter3.length() == 27 && AndroidUtilities.isValidWallChar(queryParameter3.charAt(20))) {
                                    themeInfo.patternBgGradientColor3 = Integer.parseInt(queryParameter3.substring(21), 16) | (-16777216);
                                }
                            }
                        } catch (Exception unused) {
                        }
                        try {
                            String queryParameter4 = uri.getQueryParameter("rotation");
                            if (!TextUtils.isEmpty(queryParameter4)) {
                                themeInfo.patternBgGradientRotation = Utilities.parseInt(queryParameter4).intValue();
                            }
                        } catch (Exception unused2) {
                        }
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            themeInfo.patternIntensity = Utilities.parseInt(queryParameter2).intValue();
                        }
                        if (themeInfo.patternIntensity == 0) {
                            themeInfo.patternIntensity = 50;
                        }
                    }
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            } else {
                themedWallpaperLink = null;
            }
            return themeInfo;
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static ThemeInfo applyThemeFile(File file, String themeName, TLRPC$TL_theme theme, boolean temporary) {
        File file2;
        String str;
        try {
            if (!themeName.toLowerCase().endsWith(".attheme")) {
                themeName = themeName + ".attheme";
            }
            if (temporary) {
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.goingToPreviewTheme, new Object[0]);
                ThemeInfo themeInfo = new ThemeInfo();
                themeInfo.name = themeName;
                themeInfo.info = theme;
                themeInfo.pathToFile = file.getAbsolutePath();
                themeInfo.account = UserConfig.selectedAccount;
                applyThemeTemporary(themeInfo, false);
                return themeInfo;
            }
            if (theme != null) {
                str = "remote" + theme.id;
                file2 = new File(ApplicationLoader.getFilesDirFixed(), str + ".attheme");
            } else {
                file2 = new File(ApplicationLoader.getFilesDirFixed(), themeName);
                str = themeName;
            }
            if (!AndroidUtilities.copyFile(file, file2)) {
                applyPreviousTheme();
                return null;
            }
            previousTheme = null;
            hasPreviousTheme = false;
            isApplyingAccent = false;
            ThemeInfo themeInfo2 = themesDict.get(str);
            if (themeInfo2 == null) {
                themeInfo2 = new ThemeInfo();
                themeInfo2.name = themeName;
                themeInfo2.account = UserConfig.selectedAccount;
                themes.add(themeInfo2);
                otherThemes.add(themeInfo2);
                sortThemes();
            } else {
                themesDict.remove(str);
            }
            themeInfo2.info = theme;
            themeInfo2.pathToFile = file2.getAbsolutePath();
            themesDict.put(themeInfo2.getKey(), themeInfo2);
            saveOtherThemes(true);
            applyTheme(themeInfo2, true, true, false);
            return themeInfo2;
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static ThemeInfo getTheme(String key) {
        return themesDict.get(key);
    }

    public static void applyTheme(ThemeInfo themeInfo) {
        applyTheme(themeInfo, true, true, false);
    }

    public static void applyTheme(ThemeInfo themeInfo, boolean nightTheme) {
        applyTheme(themeInfo, true, nightTheme);
    }

    public static void applyTheme(ThemeInfo themeInfo, boolean save, boolean nightTheme) {
        applyTheme(themeInfo, save, true, nightTheme);
    }

    public static void applyTheme(ThemeInfo themeInfo, boolean save, boolean removeWallpaperOverride, final boolean nightTheme) {
        String[] strArrSplit;
        if (themeInfo == null) {
            return;
        }
        ThemeEditorView themeEditorView = ThemeEditorView.getInstance();
        if (themeEditorView != null) {
            themeEditorView.destroy();
        }
        try {
            if (themeInfo.pathToFile != null || themeInfo.assetName != null) {
                if (!nightTheme && save) {
                    SharedPreferences.Editor editorEdit = MessagesController.getMainSettings(UserConfig.selectedAccount).edit();
                    String str = (themeInfo.isDark() || ThemeInfo.checkIsDark(themeInfo.pathToFile != null ? getThemeFileValues(new File(themeInfo.pathToFile), themeInfo.assetName, new String[1]) : null, themeInfo)) ? "Dark" : "Day";
                    currentThemeType = str;
                    if (str.equals("Day")) {
                        editorEdit.putString("day_theme", themeInfo.getKey());
                    } else {
                        editorEdit.putString("dark_theme", themeInfo.getKey());
                    }
                    editorEdit.putString("current_theme_type", currentThemeType);
                    editorEdit.commit();
                }
                String[] strArr = new String[1];
                String str2 = themeInfo.assetName;
                if (str2 != null) {
                    currentColorsNoAccent = getThemeFileValues(null, str2, null);
                } else {
                    currentColorsNoAccent = getThemeFileValues(new File(themeInfo.pathToFile), null, strArr);
                }
                Integer num = currentColorsNoAccent.get("wallpaperFileOffset");
                themedWallpaperFileOffset = num != null ? num.intValue() : -1;
                if (!TextUtils.isEmpty(strArr[0])) {
                    themedWallpaperLink = strArr[0];
                    String absolutePath = new File(ApplicationLoader.getFilesDirFixed(), Utilities.MD5(themedWallpaperLink) + ".wp").getAbsolutePath();
                    try {
                        String str3 = themeInfo.pathToWallpaper;
                        if (str3 != null && !str3.equals(absolutePath)) {
                            new File(themeInfo.pathToWallpaper).delete();
                        }
                    } catch (Exception unused) {
                    }
                    themeInfo.pathToWallpaper = absolutePath;
                    try {
                        Uri uri = Uri.parse(themedWallpaperLink);
                        themeInfo.slug = uri.getQueryParameter("slug");
                        String queryParameter = uri.getQueryParameter("mode");
                        if (queryParameter != null && (strArrSplit = queryParameter.toLowerCase().split(" ")) != null && strArrSplit.length > 0) {
                            for (int i = 0; i < strArrSplit.length; i++) {
                                if ("blur".equals(strArrSplit[i])) {
                                    themeInfo.isBlured = true;
                                } else if ("motion".equals(strArrSplit[i])) {
                                    themeInfo.isMotion = true;
                                }
                            }
                        }
                        Utilities.parseInt(uri.getQueryParameter("intensity")).intValue();
                        themeInfo.patternBgGradientRotation = 45;
                        try {
                            String queryParameter2 = uri.getQueryParameter("bg_color");
                            if (!TextUtils.isEmpty(queryParameter2)) {
                                themeInfo.patternBgColor = Integer.parseInt(queryParameter2.substring(0, 6), 16) | (-16777216);
                                if (queryParameter2.length() >= 13 && AndroidUtilities.isValidWallChar(queryParameter2.charAt(6))) {
                                    themeInfo.patternBgGradientColor1 = Integer.parseInt(queryParameter2.substring(7, 13), 16) | (-16777216);
                                }
                                if (queryParameter2.length() >= 20 && AndroidUtilities.isValidWallChar(queryParameter2.charAt(13))) {
                                    themeInfo.patternBgGradientColor2 = Integer.parseInt(queryParameter2.substring(14, 20), 16) | (-16777216);
                                }
                                if (queryParameter2.length() == 27 && AndroidUtilities.isValidWallChar(queryParameter2.charAt(20))) {
                                    themeInfo.patternBgGradientColor3 = Integer.parseInt(queryParameter2.substring(21), 16) | (-16777216);
                                }
                            }
                        } catch (Exception unused2) {
                        }
                        try {
                            String queryParameter3 = uri.getQueryParameter("rotation");
                            if (!TextUtils.isEmpty(queryParameter3)) {
                                themeInfo.patternBgGradientRotation = Utilities.parseInt(queryParameter3).intValue();
                            }
                        } catch (Exception unused3) {
                        }
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                } else {
                    try {
                        if (themeInfo.pathToWallpaper != null) {
                            new File(themeInfo.pathToWallpaper).delete();
                        }
                    } catch (Exception unused4) {
                    }
                    themeInfo.pathToWallpaper = null;
                    themedWallpaperLink = null;
                }
                if (save) {
                    SharedPreferences.Editor editorEdit2 = MessagesController.getMainSettings(UserConfig.selectedAccount).edit();
                    int i2 = UserConfig.selectedAccount;
                    if (i2 == 1) {
                        editorEdit2.putInt("accentId_1_" + currentThemeType, themeInfo.currentAccentId);
                    } else if (i2 == 2) {
                        editorEdit2.putInt("accentId_2_" + currentThemeType, themeInfo.currentAccentId);
                    } else {
                        editorEdit2.putInt("accentId_0_" + currentThemeType, themeInfo.currentAccentId);
                    }
                    editorEdit2.commit();
                }
            } else {
                if (!nightTheme && save) {
                    SharedPreferences.Editor editorEdit3 = MessagesController.getMainSettings(UserConfig.selectedAccount).edit();
                    editorEdit3.remove("theme");
                    editorEdit3.commit();
                }
                currentColorsNoAccent.clear();
                themedWallpaperFileOffset = 0;
                themedWallpaperLink = null;
                wallpaper = null;
                themedWallpaper = null;
            }
            if (!nightTheme && previousTheme == null) {
                currentDayTheme = themeInfo;
                if (isCurrentThemeNight()) {
                    switchNightThemeDelay = 2000;
                    lastDelayUpdateTime = SystemClock.elapsedRealtime();
                    AndroidUtilities.runOnUIThread($$Lambda$CjpvJp3l2DdHlQZdDH24E06dqFQ.INSTANCE, 2100L);
                }
            }
            currentTheme = themeInfo;
            refreshThemeColors();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (previousTheme == null && save && !switchingNightTheme) {
            MessagesController.getInstance(themeInfo.account).saveTheme(themeInfo, themeInfo.getAccent(false), nightTheme, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean useBlackText(int color1, int color2) {
        float fRed = Color.red(color1) / 255.0f;
        float fGreen = Color.green(color1) / 255.0f;
        float fBlue = Color.blue(color1) / 255.0f;
        return ((((fRed * 0.5f) + ((Color.red(color2) / 255.0f) * 0.5f)) * 0.2126f) + (((fGreen * 0.5f) + ((Color.green(color2) / 255.0f) * 0.5f)) * 0.7152f)) + (((fBlue * 0.5f) + ((((float) Color.blue(color2)) / 255.0f) * 0.5f)) * 0.0722f) > 0.705f || ((fRed * 0.2126f) + (fGreen * 0.7152f)) + (fBlue * 0.0722f) > 0.705f;
    }

    public static void refreshThemeColors() {
        refreshThemeColors(false, false);
    }

    public static void refreshThemeColors(boolean bg, boolean messages) {
        currentColors.clear();
        currentColors.putAll(currentColorsNoAccent);
        shouldDrawGradientIcons = true;
        ThemeAccent accent = currentTheme.getAccent(false);
        if (accent != null) {
            shouldDrawGradientIcons = accent.fillAccentColors(currentColorsNoAccent, currentColors);
        }
        if (!messages) {
            reloadWallpaper();
        }
        applyCommonTheme();
        applyDialogsTheme();
        applyProfileTheme();
        applyChatTheme(false, bg);
        final boolean z = !hasPreviousTheme;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$aqIQKdwkH37roGYFPTOTvrNrtdQ
            @Override // java.lang.Runnable
            public final void run() {
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetNewTheme, Boolean.FALSE, Boolean.valueOf(z));
            }
        });
    }

    public static int changeColorAccent(ThemeInfo themeInfo, int accent, int color) {
        int i;
        if (accent == 0 || (i = themeInfo.accentBaseColor) == 0 || accent == i || (themeInfo.firstAccentIsDefault && themeInfo.currentAccentId == DEFALT_THEME_ACCENT_ID)) {
            return color;
        }
        float[] tempHsv = getTempHsv(3);
        float[] tempHsv2 = getTempHsv(4);
        Color.colorToHSV(themeInfo.accentBaseColor, tempHsv);
        Color.colorToHSV(accent, tempHsv2);
        return changeColorAccent(tempHsv, tempHsv2, color, themeInfo.isDark());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float[] getTempHsv(int num) {
        ThreadLocal<float[]> threadLocal;
        if (num == 1) {
            threadLocal = hsvTemp1Local;
        } else if (num == 2) {
            threadLocal = hsvTemp2Local;
        } else if (num == 3) {
            threadLocal = hsvTemp3Local;
        } else if (num == 4) {
            threadLocal = hsvTemp4Local;
        } else {
            threadLocal = hsvTemp5Local;
        }
        float[] fArr = threadLocal.get();
        if (fArr != null) {
            return fArr;
        }
        float[] fArr2 = new float[3];
        threadLocal.set(fArr2);
        return fArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getAccentColor(float[] baseHsv, int baseColor, int elementColor) {
        float[] tempHsv = getTempHsv(3);
        float[] tempHsv2 = getTempHsv(4);
        Color.colorToHSV(baseColor, tempHsv);
        Color.colorToHSV(elementColor, tempHsv2);
        float fMin = Math.min((tempHsv[1] * 1.5f) / baseHsv[1], 1.0f);
        tempHsv[0] = (tempHsv2[0] - tempHsv[0]) + baseHsv[0];
        tempHsv[1] = (tempHsv2[1] * baseHsv[1]) / tempHsv[1];
        tempHsv[2] = ((((tempHsv2[2] / tempHsv[2]) + fMin) - 1.0f) * baseHsv[2]) / fMin;
        return tempHsv[2] < 0.3f ? elementColor : Color.HSVToColor(255, tempHsv);
    }

    public static int changeColorAccent(int color) {
        ThemeAccent accent = currentTheme.getAccent(false);
        return changeColorAccent(currentTheme, accent != null ? accent.accentColor : 0, color);
    }

    public static int changeColorAccent(float[] baseHsv, float[] accentHsv, int color, boolean isDarkTheme) {
        float[] tempHsv = getTempHsv(5);
        Color.colorToHSV(color, tempHsv);
        boolean z = false;
        if (Math.min(Math.abs(tempHsv[0] - baseHsv[0]), Math.abs((tempHsv[0] - baseHsv[0]) - 360.0f)) > 30.0f) {
            return color;
        }
        float fMin = Math.min((tempHsv[1] * 1.5f) / baseHsv[1], 1.0f);
        tempHsv[0] = (tempHsv[0] + accentHsv[0]) - baseHsv[0];
        tempHsv[1] = (tempHsv[1] * accentHsv[1]) / baseHsv[1];
        tempHsv[2] = tempHsv[2] * ((1.0f - fMin) + ((fMin * accentHsv[2]) / baseHsv[2]));
        int iHSVToColor = Color.HSVToColor(Color.alpha(color), tempHsv);
        float fComputePerceivedBrightness = AndroidUtilities.computePerceivedBrightness(color);
        float fComputePerceivedBrightness2 = AndroidUtilities.computePerceivedBrightness(iHSVToColor);
        if (!isDarkTheme ? fComputePerceivedBrightness < fComputePerceivedBrightness2 : fComputePerceivedBrightness > fComputePerceivedBrightness2) {
            z = true;
        }
        return z ? changeBrightness(iHSVToColor, ((0.39999998f * fComputePerceivedBrightness) / fComputePerceivedBrightness2) + 0.6f) : iHSVToColor;
    }

    private static int changeBrightness(int color, float amount) {
        int iRed = (int) (Color.red(color) * amount);
        int iGreen = (int) (Color.green(color) * amount);
        int iBlue = (int) (Color.blue(color) * amount);
        return Color.argb(Color.alpha(color), iRed < 0 ? 0 : Math.min(iRed, 255), iGreen < 0 ? 0 : Math.min(iGreen, 255), iBlue >= 0 ? Math.min(iBlue, 255) : 0);
    }

    public static boolean deleteThemeAccent(ThemeInfo theme, ThemeAccent accent, boolean save) {
        boolean z = false;
        if (accent == null || theme == null || theme.themeAccents == null) {
            return false;
        }
        boolean z2 = accent.id == theme.currentAccentId;
        File pathToWallpaper = accent.getPathToWallpaper();
        if (pathToWallpaper != null) {
            pathToWallpaper.delete();
        }
        theme.themeAccentsMap.remove(accent.id);
        theme.themeAccents.remove(accent);
        TLRPC$TL_theme tLRPC$TL_theme = accent.info;
        if (tLRPC$TL_theme != null) {
            theme.accentsByThemeId.remove(tLRPC$TL_theme.id);
        }
        OverrideWallpaperInfo overrideWallpaperInfo = accent.overrideWallpaper;
        if (overrideWallpaperInfo != null) {
            overrideWallpaperInfo.delete();
        }
        if (z2) {
            theme.setCurrentAccentId(theme.themeAccents.get(0).id);
        }
        if (save) {
            saveThemeAccents(theme, true, false, false, false);
            if (accent.info != null) {
                MessagesController messagesController = MessagesController.getInstance(accent.account);
                if (z2 && theme == currentNightTheme) {
                    z = true;
                }
                messagesController.saveTheme(theme, accent, z, true);
            }
        }
        return z2;
    }

    public static void saveThemeAccents(ThemeInfo theme, boolean save, boolean remove, boolean indexOnly, boolean upload) {
        saveThemeAccents(theme, save, remove, indexOnly, upload, false);
    }

    public static void saveThemeAccents(ThemeInfo theme, boolean save, boolean remove, boolean indexOnly, boolean upload, boolean migration) {
        if (save) {
            SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0).edit();
            if (!indexOnly) {
                int size = theme.themeAccents.size();
                int iMax = Math.max(0, size - theme.defaultAccentCount);
                SerializedData serializedData = new SerializedData(((iMax * 16) + 2) * 4);
                serializedData.writeInt32(9);
                serializedData.writeInt32(iMax);
                for (int i = 0; i < size; i++) {
                    ThemeAccent themeAccent = theme.themeAccents.get(i);
                    int i2 = themeAccent.id;
                    if (i2 >= 100) {
                        serializedData.writeInt32(i2);
                        serializedData.writeInt32(themeAccent.accentColor);
                        serializedData.writeInt32(themeAccent.accentColor2);
                        serializedData.writeInt32(themeAccent.myMessagesAccentColor);
                        serializedData.writeInt32(themeAccent.myMessagesGradientAccentColor1);
                        serializedData.writeInt32(themeAccent.myMessagesGradientAccentColor2);
                        serializedData.writeInt32(themeAccent.myMessagesGradientAccentColor3);
                        serializedData.writeBool(themeAccent.myMessagesAnimated);
                        serializedData.writeInt64(themeAccent.backgroundOverrideColor);
                        serializedData.writeInt64(themeAccent.backgroundGradientOverrideColor1);
                        serializedData.writeInt64(themeAccent.backgroundGradientOverrideColor2);
                        serializedData.writeInt64(themeAccent.backgroundGradientOverrideColor3);
                        serializedData.writeInt32(themeAccent.backgroundRotation);
                        serializedData.writeInt64(0L);
                        serializedData.writeDouble(themeAccent.patternIntensity);
                        serializedData.writeBool(themeAccent.patternMotion);
                        serializedData.writeString(themeAccent.patternSlug);
                        serializedData.writeBool(themeAccent.info != null);
                        if (themeAccent.info != null) {
                            serializedData.writeInt32(themeAccent.account);
                            themeAccent.info.serializeToStream(serializedData);
                        }
                    }
                }
                editorEdit.putString("accents_" + theme.assetName, Base64.encodeToString(serializedData.toByteArray(), 3));
                if (!migration) {
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.themeAccentListUpdated, new Object[0]);
                }
                if (upload) {
                    MessagesController.getInstance(UserConfig.selectedAccount).saveThemeToServer(theme, theme.getAccent(false));
                }
            }
            editorEdit.putInt("accent_current_" + theme.assetName, theme.currentAccentId);
            editorEdit.commit();
        } else {
            if (theme.prevAccentId != -1) {
                if (remove) {
                    ThemeAccent themeAccent2 = theme.themeAccentsMap.get(theme.currentAccentId);
                    theme.themeAccentsMap.remove(themeAccent2.id);
                    theme.themeAccents.remove(themeAccent2);
                    TLRPC$TL_theme tLRPC$TL_theme = themeAccent2.info;
                    if (tLRPC$TL_theme != null) {
                        theme.accentsByThemeId.remove(tLRPC$TL_theme.id);
                    }
                }
                theme.currentAccentId = theme.prevAccentId;
                ThemeAccent accent = theme.getAccent(false);
                if (accent != null) {
                    theme.overrideWallpaper = accent.overrideWallpaper;
                } else {
                    theme.overrideWallpaper = null;
                }
            }
            if (currentTheme == theme) {
                refreshThemeColors();
            }
        }
        theme.prevAccentId = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveOtherThemes(boolean full) throws JSONException {
        saveOtherThemes(full, false);
    }

    private static void saveOtherThemes(boolean full, boolean migration) throws JSONException {
        ArrayList<ThemeAccent> arrayList;
        int i = 0;
        SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("themeconfig", 0).edit();
        if (full) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < otherThemes.size(); i2++) {
                JSONObject saveJson = otherThemes.get(i2).getSaveJson();
                if (saveJson != null) {
                    jSONArray.put(saveJson);
                }
            }
            editorEdit.putString("themes2", jSONArray.toString());
        }
        int i3 = 0;
        while (i3 < 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("2remoteThemesHash");
            Object objValueOf = "";
            sb.append(i3 != 0 ? Integer.valueOf(i3) : "");
            editorEdit.putLong(sb.toString(), remoteThemesHash[i3]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("lastLoadingThemesTime");
            if (i3 != 0) {
                objValueOf = Integer.valueOf(i3);
            }
            sb2.append(objValueOf);
            editorEdit.putInt(sb2.toString(), lastLoadingThemesTime[i3]);
            i3++;
        }
        editorEdit.putInt("lastLoadingCurrentThemeTime", lastLoadingCurrentThemeTime);
        editorEdit.commit();
        if (full) {
            while (i < 5) {
                ThemeInfo themeInfo = themesDict.get(i != 0 ? i != 1 ? i != 2 ? i != 3 ? "Night" : "Day" : "Arctic Blue" : "Dark Blue" : "Blue");
                if (themeInfo != null && (arrayList = themeInfo.themeAccents) != null && !arrayList.isEmpty()) {
                    saveThemeAccents(themeInfo, true, false, false, false, migration);
                }
                i++;
            }
        }
    }

    public static HashMap<String, Integer> getDefaultColors() {
        return defaultColors;
    }

    public static ThemeInfo getPreviousTheme() {
        return previousTheme;
    }

    public static String getCurrentNightThemeName() {
        ThemeInfo themeInfo = currentNightTheme;
        if (themeInfo == null) {
            return "";
        }
        String name = themeInfo.getName();
        return name.toLowerCase().endsWith(".attheme") ? name.substring(0, name.lastIndexOf(46)) : name;
    }

    public static ThemeInfo getCurrentTheme() {
        ThemeInfo themeInfo = currentDayTheme;
        return themeInfo != null ? themeInfo : defaultTheme;
    }

    public static ThemeInfo getCurrentNightTheme() {
        return currentNightTheme;
    }

    public static boolean isCurrentThemeNight() {
        return currentTheme == currentNightTheme;
    }

    public static boolean isCurrentThemeDark() {
        return currentTheme.isDark();
    }

    public static ThemeInfo getActiveTheme() {
        return currentTheme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getAutoNightSwitchThemeDelay() {
        return Math.abs(lastThemeSwitchTime - SystemClock.elapsedRealtime()) >= 12000 ? 1800L : 12000L;
    }

    public static void setCurrentNightTheme(ThemeInfo theme) {
        boolean z = currentTheme == currentNightTheme;
        currentNightTheme = theme;
        if (z) {
            applyDayNightThemeMaybe(true);
        }
    }

    public static void checkAutoNightThemeConditions() {
        checkAutoNightThemeConditions(false);
    }

    public static void cancelAutoNightThemeCallbacks() {
        if (selectedAutoNightType != 2) {
            if (switchNightRunnableScheduled) {
                switchNightRunnableScheduled = false;
                AndroidUtilities.cancelRunOnUIThread(switchNightBrightnessRunnable);
            }
            if (switchDayRunnableScheduled) {
                switchDayRunnableScheduled = false;
                AndroidUtilities.cancelRunOnUIThread(switchDayBrightnessRunnable);
            }
            if (lightSensorRegistered) {
                lastBrightnessValue = 1.0f;
                sensorManager.unregisterListener(ambientSensorListener, lightSensor);
                lightSensorRegistered = false;
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("light sensor unregistered");
                }
            }
        }
    }

    public static int needSwitchToTheme() {
        Sensor sensor;
        SensorEventListener sensorEventListener;
        int i;
        int i2;
        int i3 = selectedAutoNightType;
        if (i3 == 1) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            int i4 = (calendar.get(11) * 60) + calendar.get(12);
            if (autoNightScheduleByLocation) {
                int i5 = calendar.get(5);
                if (autoNightLastSunCheckDay != i5) {
                    double d = autoNightLocationLatitude;
                    if (d != 10000.0d) {
                        double d2 = autoNightLocationLongitude;
                        if (d2 != 10000.0d) {
                            int[] iArrCalculateSunriseSunset = SunDate.calculateSunriseSunset(d, d2);
                            autoNightSunriseTime = iArrCalculateSunriseSunset[0];
                            autoNightSunsetTime = iArrCalculateSunriseSunset[1];
                            autoNightLastSunCheckDay = i5;
                            saveAutoNightThemeConfig();
                        }
                    }
                }
                i = autoNightSunsetTime;
                i2 = autoNightSunriseTime;
            } else {
                i = autoNightDayStartTime;
                i2 = autoNightDayEndTime;
            }
            return i < i2 ? (i > i4 || i4 > i2) ? 1 : 2 : ((i > i4 || i4 > 1440) && (i4 < 0 || i4 > i2)) ? 1 : 2;
        }
        if (i3 == 2) {
            if (lightSensor == null) {
                SensorManager sensorManager2 = (SensorManager) ApplicationLoader.applicationContext.getSystemService("sensor");
                sensorManager = sensorManager2;
                lightSensor = sensorManager2.getDefaultSensor(5);
            }
            if (!lightSensorRegistered && (sensor = lightSensor) != null && (sensorEventListener = ambientSensorListener) != null) {
                sensorManager.registerListener(sensorEventListener, sensor, 500000);
                lightSensorRegistered = true;
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("light sensor registered");
                }
            }
            if (lastBrightnessValue <= autoNightBrighnessThreshold) {
                if (!switchNightRunnableScheduled) {
                    return 2;
                }
            } else if (!switchDayRunnableScheduled) {
                return 1;
            }
        } else if (i3 == 3) {
            int i6 = ApplicationLoader.applicationContext.getResources().getConfiguration().uiMode & 48;
            if (i6 == 0 || i6 == 16) {
                return 1;
            }
            if (i6 == 32) {
                return 2;
            }
        } else if (i3 == 0) {
            return 1;
        }
        return 0;
    }

    public static void setChangingWallpaper(boolean value) {
        changingWallpaper = value;
        if (value) {
            return;
        }
        checkAutoNightThemeConditions(false);
    }

    public static void checkAutoNightThemeConditions(boolean force) {
        if (previousTheme != null || changingWallpaper) {
            return;
        }
        if (!force && switchNightThemeDelay > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - lastDelayUpdateTime;
            lastDelayUpdateTime = jElapsedRealtime;
            int i = (int) (switchNightThemeDelay - j);
            switchNightThemeDelay = i;
            if (i > 0) {
                return;
            }
        }
        if (force) {
            if (switchNightRunnableScheduled) {
                switchNightRunnableScheduled = false;
                AndroidUtilities.cancelRunOnUIThread(switchNightBrightnessRunnable);
            }
            if (switchDayRunnableScheduled) {
                switchDayRunnableScheduled = false;
                AndroidUtilities.cancelRunOnUIThread(switchDayBrightnessRunnable);
            }
        }
        cancelAutoNightThemeCallbacks();
        int iNeedSwitchToTheme = needSwitchToTheme();
        if (iNeedSwitchToTheme != 0) {
            applyDayNightThemeMaybe(iNeedSwitchToTheme == 2);
        }
        if (force) {
            lastThemeSwitchTime = 0L;
        }
    }

    public static void applyDayNightThemeMaybe(boolean night) {
        if (previousTheme != null) {
            return;
        }
        if (night) {
            if (currentTheme != currentNightTheme) {
                isInNigthMode = true;
                lastThemeSwitchTime = SystemClock.elapsedRealtime();
                switchingNightTheme = true;
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needSetDayNightTheme, currentNightTheme, Boolean.TRUE, null, -1);
                switchingNightTheme = false;
                return;
            }
            return;
        }
        if (currentTheme != currentDayTheme) {
            isInNigthMode = false;
            lastThemeSwitchTime = SystemClock.elapsedRealtime();
            switchingNightTheme = true;
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needSetDayNightTheme, currentDayTheme, Boolean.TRUE, null, -1);
            switchingNightTheme = false;
        }
    }

    public static boolean deleteTheme(ThemeInfo themeInfo) throws JSONException {
        boolean z = false;
        if (themeInfo.pathToFile == null) {
            return false;
        }
        if (currentTheme == themeInfo) {
            applyTheme(defaultTheme, true, false, false);
            z = true;
        }
        if (themeInfo == currentNightTheme) {
            currentNightTheme = themesDict.get("Dark Blue");
        }
        themeInfo.removeObservers();
        otherThemes.remove(themeInfo);
        themesDict.remove(themeInfo.name);
        OverrideWallpaperInfo overrideWallpaperInfo = themeInfo.overrideWallpaper;
        if (overrideWallpaperInfo != null) {
            overrideWallpaperInfo.delete();
        }
        themes.remove(themeInfo);
        new File(themeInfo.pathToFile).delete();
        saveOtherThemes(true);
        return z;
    }

    public static ThemeInfo createNewTheme(String name) throws Throwable {
        ThemeInfo themeInfo = new ThemeInfo();
        themeInfo.pathToFile = new File(ApplicationLoader.getFilesDirFixed(), "theme" + Utilities.random.nextLong() + ".attheme").getAbsolutePath();
        themeInfo.name = name;
        themedWallpaperLink = getWallpaperUrl(currentTheme.overrideWallpaper);
        themeInfo.account = UserConfig.selectedAccount;
        saveCurrentTheme(themeInfo, true, true, false);
        return themeInfo;
    }

    private static String getWallpaperUrl(OverrideWallpaperInfo wallpaperInfo) {
        String str;
        if (wallpaperInfo == null || TextUtils.isEmpty(wallpaperInfo.slug) || wallpaperInfo.slug.equals("d")) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (wallpaperInfo.isBlurred) {
            sb.append("blur");
        }
        if (wallpaperInfo.isMotion) {
            if (sb.length() > 0) {
                sb.append("+");
            }
            sb.append("motion");
        }
        int i = wallpaperInfo.color;
        if (i == 0) {
            str = "https://attheme.org?slug=" + wallpaperInfo.slug;
        } else {
            String lowerCase = String.format("%02x%02x%02x", Integer.valueOf(((byte) (i >> 16)) & 255), Integer.valueOf(((byte) (wallpaperInfo.color >> 8)) & 255), Byte.valueOf((byte) (wallpaperInfo.color & 255))).toLowerCase();
            int i2 = wallpaperInfo.gradientColor1;
            String lowerCase2 = i2 != 0 ? String.format("%02x%02x%02x", Integer.valueOf(((byte) (i2 >> 16)) & 255), Integer.valueOf(((byte) (wallpaperInfo.gradientColor1 >> 8)) & 255), Byte.valueOf((byte) (wallpaperInfo.gradientColor1 & 255))).toLowerCase() : null;
            int i3 = wallpaperInfo.gradientColor2;
            String lowerCase3 = i3 != 0 ? String.format("%02x%02x%02x", Integer.valueOf(((byte) (i3 >> 16)) & 255), Integer.valueOf(((byte) (wallpaperInfo.gradientColor2 >> 8)) & 255), Byte.valueOf((byte) (wallpaperInfo.gradientColor2 & 255))).toLowerCase() : null;
            int i4 = wallpaperInfo.gradientColor3;
            String lowerCase4 = i4 != 0 ? String.format("%02x%02x%02x", Integer.valueOf(((byte) (i4 >> 16)) & 255), Integer.valueOf(((byte) (wallpaperInfo.gradientColor3 >> 8)) & 255), Byte.valueOf((byte) (wallpaperInfo.gradientColor3 & 255))).toLowerCase() : null;
            if (lowerCase2 == null || lowerCase3 == null) {
                if (lowerCase2 != null) {
                    lowerCase = (lowerCase + "-" + lowerCase2) + "&rotation=" + wallpaperInfo.rotation;
                }
            } else if (lowerCase4 != null) {
                lowerCase = lowerCase + "~" + lowerCase2 + "~" + lowerCase3 + "~" + lowerCase4;
            } else {
                lowerCase = lowerCase + "~" + lowerCase2 + "~" + lowerCase3;
            }
            str = "https://attheme.org?slug=" + wallpaperInfo.slug + "&intensity=" + ((int) (wallpaperInfo.intensity * 100.0f)) + "&bg_color=" + lowerCase;
        }
        if (sb.length() <= 0) {
            return str;
        }
        return str + "&mode=" + sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v22, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x0242 -> B:137:0x0245). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void saveCurrentTheme(ir.eitaa.ui.ActionBar.Theme.ThemeInfo r12, boolean r13, boolean r14, boolean r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.saveCurrentTheme(ir.eitaa.ui.ActionBar.Theme$ThemeInfo, boolean, boolean, boolean):void");
    }

    public static void checkCurrentRemoteTheme(boolean force) {
        if (loadingCurrentTheme == 0) {
            if (force || Math.abs((System.currentTimeMillis() / 1000) - lastLoadingCurrentThemeTime) >= 3600) {
                currentThemeType = getCurrentThemeType();
                ThemeInfo theme = getTheme();
                ThemeAccent accent = theme.getAccent(false);
                if (theme.info == null && accent != null && accent.info != null) {
                    int i = UserConfig.selectedAccount;
                }
                loadingCurrentTheme++;
            }
        }
    }

    public static void loadRemoteThemes(final int currentAccount, boolean force) {
        if (loadingRemoteThemes[currentAccount]) {
            return;
        }
        if ((force || Math.abs((System.currentTimeMillis() / 1000) - lastLoadingThemesTime[currentAccount]) >= 3600) && UserConfig.getInstance(currentAccount).isClientActivated()) {
            loadingRemoteThemes[currentAccount] = true;
            TLRPC$TL_account_getThemes tLRPC$TL_account_getThemes = new TLRPC$TL_account_getThemes();
            tLRPC$TL_account_getThemes.format = "android";
            tLRPC$TL_account_getThemes.hash = remoteThemesHash[currentAccount];
            ConnectionsManager.getInstance(currentAccount).sendRequest(tLRPC$TL_account_getThemes, new RequestDelegate() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$tNHSfx7hkAA9X48FnqrApRBmXL0
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$8GbvaYKHI5Y87TAb1adcTMjxc8I
                        @Override // java.lang.Runnable
                        public final void run() throws JSONException {
                            Theme.lambda$loadRemoteThemes$3(i, tLObject);
                        }
                    });
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$loadRemoteThemes$3(int r16, ir.eitaa.tgnet.TLObject r17) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.lambda$loadRemoteThemes$3(int, ir.eitaa.tgnet.TLObject):void");
    }

    public static String getBaseThemeKey(TLRPC$ThemeSettings settings) {
        TLRPC$BaseTheme tLRPC$BaseTheme = settings.base_theme;
        if (tLRPC$BaseTheme instanceof TLRPC$TL_baseThemeClassic) {
            return "Blue";
        }
        if (tLRPC$BaseTheme instanceof TLRPC$TL_baseThemeDay) {
            return "Day";
        }
        if (tLRPC$BaseTheme instanceof TLRPC$TL_baseThemeTinted) {
            return "Dark Blue";
        }
        if (tLRPC$BaseTheme instanceof TLRPC$TL_baseThemeArctic) {
            return "Arctic Blue";
        }
        if (tLRPC$BaseTheme instanceof TLRPC$TL_baseThemeNight) {
            return "Night";
        }
        return null;
    }

    public static TLRPC$BaseTheme getBaseThemeByKey(String key) {
        if ("Blue".equals(key)) {
            return new TLRPC$TL_baseThemeClassic();
        }
        if ("Day".equals(key)) {
            return new TLRPC$TL_baseThemeDay();
        }
        if ("Dark Blue".equals(key)) {
            return new TLRPC$TL_baseThemeTinted();
        }
        if ("Arctic Blue".equals(key)) {
            return new TLRPC$TL_baseThemeArctic();
        }
        if ("Night".equals(key)) {
            return new TLRPC$TL_baseThemeNight();
        }
        return null;
    }

    public static void setThemeFileReference(TLRPC$TL_theme info) throws JSONException {
        TLRPC$Document tLRPC$Document;
        int size = themes.size();
        for (int i = 0; i < size; i++) {
            TLRPC$TL_theme tLRPC$TL_theme = themes.get(i).info;
            if (tLRPC$TL_theme != null && tLRPC$TL_theme.id == info.id) {
                TLRPC$Document tLRPC$Document2 = tLRPC$TL_theme.document;
                if (tLRPC$Document2 == null || (tLRPC$Document = info.document) == null) {
                    return;
                }
                tLRPC$Document2.file_reference = tLRPC$Document.file_reference;
                saveOtherThemes(true);
                return;
            }
        }
    }

    public static boolean isThemeInstalled(ThemeInfo themeInfo) {
        return (themeInfo == null || themesDict.get(themeInfo.getKey()) == null) ? false : true;
    }

    public static void setThemeUploadInfo(ThemeInfo theme, ThemeAccent accent, TLRPC$TL_theme info, int account, boolean update) throws JSONException {
        String key;
        TLRPC$WallPaperSettings tLRPC$WallPaperSettings;
        if (info == null) {
            return;
        }
        TLRPC$ThemeSettings tLRPC$ThemeSettings = info.settings;
        if (tLRPC$ThemeSettings != null) {
            if (theme == null) {
                String baseThemeKey = getBaseThemeKey(tLRPC$ThemeSettings);
                if (baseThemeKey == null || (theme = themesDict.get(baseThemeKey)) == null) {
                    return;
                } else {
                    accent = theme.accentsByThemeId.get(info.id);
                }
            }
            if (accent == null) {
                return;
            }
            TLRPC$TL_theme tLRPC$TL_theme = accent.info;
            if (tLRPC$TL_theme != null) {
                theme.accentsByThemeId.remove(tLRPC$TL_theme.id);
            }
            accent.info = info;
            accent.account = account;
            theme.accentsByThemeId.put(info.id, accent);
            if (!ThemeInfo.accentEquals(accent, info.settings)) {
                File pathToWallpaper = accent.getPathToWallpaper();
                if (pathToWallpaper != null) {
                    pathToWallpaper.delete();
                }
                ThemeInfo.fillAccentValues(accent, info.settings);
                ThemeInfo themeInfo = currentTheme;
                if (themeInfo == theme && themeInfo.currentAccentId == accent.id) {
                    refreshThemeColors();
                    NotificationCenter globalInstance = NotificationCenter.getGlobalInstance();
                    int i = NotificationCenter.needSetDayNightTheme;
                    Object[] objArr = new Object[4];
                    ThemeInfo themeInfo2 = currentTheme;
                    objArr[0] = themeInfo2;
                    objArr[1] = Boolean.valueOf(currentNightTheme == themeInfo2);
                    objArr[2] = null;
                    objArr[3] = -1;
                    globalInstance.postNotificationName(i, objArr);
                }
                PatternsLoader.createLoader(true);
            }
            TLRPC$WallPaper tLRPC$WallPaper = info.settings.wallpaper;
            accent.patternMotion = (tLRPC$WallPaper == null || (tLRPC$WallPaperSettings = tLRPC$WallPaper.settings) == null || !tLRPC$WallPaperSettings.motion) ? false : true;
            theme.previewParsed = false;
        } else {
            if (theme != null) {
                HashMap<String, ThemeInfo> map = themesDict;
                key = theme.getKey();
                map.remove(key);
            } else {
                HashMap<String, ThemeInfo> map2 = themesDict;
                key = "remote" + info.id;
                theme = map2.get(key);
            }
            if (theme == null) {
                return;
            }
            theme.info = info;
            theme.name = info.title;
            File file = new File(theme.pathToFile);
            File file2 = new File(ApplicationLoader.getFilesDirFixed(), key + ".attheme");
            if (!file.equals(file2)) {
                try {
                    AndroidUtilities.copyFile(file, file2);
                    theme.pathToFile = file2.getAbsolutePath();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            if (update) {
                theme.loadThemeDocument();
            } else {
                theme.previewParsed = false;
            }
            themesDict.put(theme.getKey(), theme);
        }
        saveOtherThemes(true);
    }

    public static File getAssetFile(String assetName) throws IOException {
        long jAvailable;
        File file = new File(ApplicationLoader.getFilesDirFixed(), assetName);
        try {
            InputStream inputStreamOpen = ApplicationLoader.applicationContext.getAssets().open(assetName);
            jAvailable = inputStreamOpen.available();
            inputStreamOpen.close();
        } catch (Exception e) {
            FileLog.e(e);
            jAvailable = 0;
        }
        if (!file.exists() || (jAvailable != 0 && file.length() != jAvailable)) {
            try {
                InputStream inputStreamOpen2 = ApplicationLoader.applicationContext.getAssets().open(assetName);
                try {
                    AndroidUtilities.copyFile(inputStreamOpen2, file);
                    if (inputStreamOpen2 != null) {
                        inputStreamOpen2.close();
                    }
                } catch (Throwable th) {
                    if (inputStreamOpen2 != null) {
                        try {
                            inputStreamOpen2.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        return file;
    }

    public static int getPreviewColor(HashMap<String, Integer> colors, String key) {
        Integer num = colors.get(key);
        if (num == null) {
            num = defaultColors.get(key);
        }
        return num.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0244 A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04d9 A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0521 A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x053a A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05ec A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x060e A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x04a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b3 A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0283 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ca A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d2 A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f0 A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8 A[Catch: all -> 0x0675, TryCatch #12 {all -> 0x0675, blocks: (B:3:0x0008, B:5:0x0082, B:8:0x008a, B:13:0x0099, B:22:0x00ab, B:25:0x00b3, B:29:0x00bc, B:36:0x00ca, B:39:0x00d2, B:43:0x00db, B:50:0x00f0, B:53:0x00f8, B:57:0x0103, B:64:0x0113, B:66:0x011c, B:68:0x012a, B:71:0x0134, B:73:0x0144, B:75:0x014e, B:77:0x0158, B:78:0x0167, B:80:0x016f, B:82:0x017b, B:84:0x018b, B:89:0x0196, B:91:0x019e, B:93:0x01aa, B:95:0x01b8, B:109:0x01d9, B:112:0x01e8, B:114:0x0244, B:118:0x0250, B:122:0x0260, B:123:0x026b, B:230:0x04d9, B:232:0x04f8, B:234:0x0521, B:236:0x053a, B:237:0x055c, B:239:0x05ec, B:242:0x060e, B:243:0x0636, B:247:0x0671, B:150:0x0340, B:155:0x034c, B:162:0x0390, B:157:0x0354, B:158:0x0360, B:160:0x036a, B:161:0x0370, B:164:0x03a5, B:201:0x04a5, B:205:0x04ab, B:213:0x04bc, B:217:0x04c2, B:222:0x04ca, B:227:0x04d3, B:226:0x04d0, B:166:0x03ab, B:211:0x04b7, B:244:0x065e), top: B:277:0x0008, inners: #1, #2, #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0101 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0111  */
    /* JADX WARN: Type inference failed for: r0v109 */
    /* JADX WARN: Type inference failed for: r0v110 */
    /* JADX WARN: Type inference failed for: r0v111 */
    /* JADX WARN: Type inference failed for: r0v71, types: [ir.eitaa.ui.Components.MotionBackgroundDrawable] */
    /* JADX WARN: Type inference failed for: r0v97, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r10v48, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r11v10, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable[]] */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.graphics.Canvas] */
    /* JADX WARN: Type inference failed for: r15v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r1v35, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r22v10, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable] */
    /* JADX WARN: Type inference failed for: r24v10, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r24v11, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable] */
    /* JADX WARN: Type inference failed for: r24v12, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable] */
    /* JADX WARN: Type inference failed for: r25v9, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r3v10, types: [android.graphics.Canvas] */
    /* JADX WARN: Type inference failed for: r3v13, types: [android.graphics.Canvas] */
    /* JADX WARN: Type inference failed for: r3v18, types: [android.graphics.Canvas] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.graphics.Canvas] */
    /* JADX WARN: Type inference failed for: r4v15, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r4v19, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable] */
    /* JADX WARN: Type inference failed for: r4v22, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable] */
    /* JADX WARN: Type inference failed for: r6v21, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable] */
    /* JADX WARN: Type inference failed for: r6v22, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable] */
    /* JADX WARN: Type inference failed for: r6v23, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable] */
    /* JADX WARN: Type inference failed for: r6v24, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String createThemePreviewImage(java.lang.String r37, java.lang.String r38, ir.eitaa.ui.ActionBar.Theme.ThemeAccent r39) {
        /*
            Method dump skipped, instructions count: 1659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.createThemePreviewImage(java.lang.String, java.lang.String, ir.eitaa.ui.ActionBar.Theme$ThemeAccent):java.lang.String");
    }

    public static HashMap<String, Integer> getThemeFileValues(File file, String assetName, String[] wallpaperLink) throws IOException {
        int iIntValue;
        HashMap<String, Integer> map = new HashMap<>();
        FileInputStream fileInputStream = null;
        try {
            try {
                byte[] bArr = new byte[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
                FileInputStream fileInputStream2 = new FileInputStream(assetName != null ? getAssetFile(assetName) : file);
                int i = -1;
                int i2 = 0;
                int i3 = 0;
                int i4 = -1;
                boolean z = false;
                while (true) {
                    try {
                        int i5 = fileInputStream2.read(bArr);
                        if (i5 == i) {
                            break;
                        }
                        int i6 = i3;
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            if (i7 >= i5) {
                                break;
                            }
                            if (bArr[i7] == 10) {
                                int i9 = (i7 - i8) + 1;
                                String str = new String(bArr, i8, i9 - 1);
                                if (str.startsWith("WLS=")) {
                                    if (wallpaperLink != null && wallpaperLink.length > 0) {
                                        wallpaperLink[i2] = str.substring(4);
                                    }
                                } else {
                                    if (str.startsWith("WPS")) {
                                        i4 = i9 + i6;
                                        z = true;
                                        break;
                                    }
                                    int iIndexOf = str.indexOf(61);
                                    if (iIndexOf != i) {
                                        String strSubstring = str.substring(i2, iIndexOf);
                                        String strSubstring2 = str.substring(iIndexOf + 1);
                                        if (strSubstring2.length() > 0 && strSubstring2.charAt(i2) == '#') {
                                            try {
                                                iIntValue = Color.parseColor(strSubstring2);
                                            } catch (Exception unused) {
                                                iIntValue = Utilities.parseInt(strSubstring2).intValue();
                                            }
                                        } else {
                                            iIntValue = Utilities.parseInt(strSubstring2).intValue();
                                        }
                                        map.put(strSubstring, Integer.valueOf(iIntValue));
                                    }
                                }
                                i8 += i9;
                                i6 += i9;
                            }
                            i7++;
                            i = -1;
                            i2 = 0;
                        }
                        if (i3 == i6) {
                            break;
                        }
                        fileInputStream2.getChannel().position(i6);
                        if (z) {
                            break;
                        }
                        i3 = i6;
                        i = -1;
                        i2 = 0;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        try {
                            FileLog.e(th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return map;
                        } finally {
                        }
                    }
                }
                map.put("wallpaperFileOffset", Integer.valueOf(i4));
                fileInputStream2.close();
            } catch (Exception e) {
                FileLog.e(e);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return map;
    }

    public static void createCommonResources(Context context) throws Resources.NotFoundException {
        if (dividerPaint == null) {
            Paint paint = new Paint();
            dividerPaint = paint;
            paint.setStrokeWidth(1.0f);
            Paint paint2 = new Paint();
            dividerExtraPaint = paint2;
            paint2.setStrokeWidth(1.0f);
            avatar_backgroundPaint = new Paint(1);
            Paint paint3 = new Paint(1);
            checkboxSquare_checkPaint = paint3;
            paint3.setStyle(Paint.Style.STROKE);
            checkboxSquare_checkPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
            checkboxSquare_checkPaint.setStrokeCap(Paint.Cap.ROUND);
            Paint paint4 = new Paint(1);
            checkboxSquare_eraserPaint = paint4;
            paint4.setColor(0);
            checkboxSquare_eraserPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            checkboxSquare_backgroundPaint = new Paint(1);
            linkSelectionPaint = new Paint();
            Resources resources = context.getResources();
            avatarDrawables[0] = resources.getDrawable(R.drawable.chats_saved);
            avatarDrawables[1] = resources.getDrawable(R.drawable.ghost);
            avatarDrawables[2] = resources.getDrawable(R.drawable.folders_private);
            avatarDrawables[3] = resources.getDrawable(R.drawable.folders_requests);
            avatarDrawables[4] = resources.getDrawable(R.drawable.folders_group);
            avatarDrawables[5] = resources.getDrawable(R.drawable.folders_channel);
            avatarDrawables[6] = resources.getDrawable(R.drawable.folders_bot);
            avatarDrawables[7] = resources.getDrawable(R.drawable.folders_mute);
            avatarDrawables[8] = resources.getDrawable(R.drawable.folders_read);
            avatarDrawables[9] = resources.getDrawable(R.drawable.folders_archive);
            avatarDrawables[10] = resources.getDrawable(R.drawable.folders_private);
            avatarDrawables[11] = resources.getDrawable(R.drawable.chats_replies);
            avatarDrawables[12] = resources.getDrawable(R.drawable.tab_socialmedia);
            avatarDrawables[13] = resources.getDrawable(R.drawable.tab_admin);
            avatarDrawables[14] = resources.getDrawable(R.drawable.stickers_favorites);
            RLottieDrawable rLottieDrawable = dialogs_archiveAvatarDrawable;
            if (rLottieDrawable != null) {
                rLottieDrawable.setCallback(null);
                dialogs_archiveAvatarDrawable.recycle();
            }
            RLottieDrawable rLottieDrawable2 = dialogs_archiveDrawable;
            if (rLottieDrawable2 != null) {
                rLottieDrawable2.recycle();
            }
            RLottieDrawable rLottieDrawable3 = dialogs_unarchiveDrawable;
            if (rLottieDrawable3 != null) {
                rLottieDrawable3.recycle();
            }
            RLottieDrawable rLottieDrawable4 = dialogs_pinArchiveDrawable;
            if (rLottieDrawable4 != null) {
                rLottieDrawable4.recycle();
            }
            RLottieDrawable rLottieDrawable5 = dialogs_unpinArchiveDrawable;
            if (rLottieDrawable5 != null) {
                rLottieDrawable5.recycle();
            }
            RLottieDrawable rLottieDrawable6 = dialogs_hidePsaDrawable;
            if (rLottieDrawable6 != null) {
                rLottieDrawable6.recycle();
            }
            dialogs_archiveAvatarDrawable = new RLottieDrawable(R.raw.chats_archiveavatar, "chats_archiveavatar", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f), false, (int[]) null);
            dialogs_archiveDrawable = new RLottieDrawable(R.raw.chats_archive, "chats_archive", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
            dialogs_unarchiveDrawable = new RLottieDrawable(R.raw.chats_unarchive, "chats_unarchive", AndroidUtilities.dp(AndroidUtilities.dp(36.0f)), AndroidUtilities.dp(36.0f));
            dialogs_pinArchiveDrawable = new RLottieDrawable(R.raw.chats_hide, "chats_hide", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
            dialogs_unpinArchiveDrawable = new RLottieDrawable(R.raw.chats_unhide, "chats_unhide", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
            dialogs_hidePsaDrawable = new RLottieDrawable(R.raw.chat_audio_record_delete, "chats_psahide", AndroidUtilities.dp(30.0f), AndroidUtilities.dp(30.0f));
            dialogs_swipeMuteDrawable = new RLottieDrawable(R.raw.swipe_mute, "swipe_mute", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
            dialogs_swipeUnmuteDrawable = new RLottieDrawable(R.raw.swipe_unmute, "swipe_unmute", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
            dialogs_swipeReadDrawable = new RLottieDrawable(R.raw.swipe_read, "swipe_read", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
            dialogs_swipeUnreadDrawable = new RLottieDrawable(R.raw.swipe_unread, "swipe_unread", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
            dialogs_swipeDeleteDrawable = new RLottieDrawable(R.raw.swipe_delete, "swipe_delete", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
            dialogs_swipeUnpinDrawable = new RLottieDrawable(R.raw.swipe_unpin, "swipe_unpin", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
            dialogs_swipePinDrawable = new RLottieDrawable(R.raw.swipe_pin, "swipe_pin", AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
            applyCommonTheme();
        }
    }

    public static void applyCommonTheme() {
        Paint paint = dividerPaint;
        if (paint == null) {
            return;
        }
        paint.setColor(getColor("divider"));
        linkSelectionPaint.setColor(getColor("windowBackgroundWhiteLinkSelection"));
        int i = 0;
        while (true) {
            Drawable[] drawableArr = avatarDrawables;
            if (i < drawableArr.length) {
                setDrawableColorByKey(drawableArr[i], "avatar_text");
                i++;
            } else {
                dialogs_archiveAvatarDrawable.beginApplyLayerColors();
                dialogs_archiveAvatarDrawable.setLayerColor("Arrow1.**", getNonAnimatedColor("avatar_backgroundArchived"));
                dialogs_archiveAvatarDrawable.setLayerColor("Arrow2.**", getNonAnimatedColor("avatar_backgroundArchived"));
                dialogs_archiveAvatarDrawable.setLayerColor("Box2.**", getNonAnimatedColor("avatar_text"));
                dialogs_archiveAvatarDrawable.setLayerColor("Box1.**", getNonAnimatedColor("avatar_text"));
                dialogs_archiveAvatarDrawable.commitApplyLayerColors();
                dialogs_archiveAvatarDrawableRecolored = false;
                dialogs_archiveAvatarDrawable.setAllowDecodeSingleFrame(true);
                dialogs_pinArchiveDrawable.beginApplyLayerColors();
                dialogs_pinArchiveDrawable.setLayerColor("Arrow.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_pinArchiveDrawable.setLayerColor("Line.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_pinArchiveDrawable.commitApplyLayerColors();
                dialogs_unpinArchiveDrawable.beginApplyLayerColors();
                dialogs_unpinArchiveDrawable.setLayerColor("Arrow.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_unpinArchiveDrawable.setLayerColor("Line.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_unpinArchiveDrawable.commitApplyLayerColors();
                dialogs_hidePsaDrawable.beginApplyLayerColors();
                dialogs_hidePsaDrawable.setLayerColor("Line 1.**", getNonAnimatedColor("chats_archiveBackground"));
                dialogs_hidePsaDrawable.setLayerColor("Line 2.**", getNonAnimatedColor("chats_archiveBackground"));
                dialogs_hidePsaDrawable.setLayerColor("Line 3.**", getNonAnimatedColor("chats_archiveBackground"));
                dialogs_hidePsaDrawable.setLayerColor("Cup Red.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_hidePsaDrawable.setLayerColor("Box.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_hidePsaDrawable.commitApplyLayerColors();
                dialogs_hidePsaDrawableRecolored = false;
                dialogs_archiveDrawable.beginApplyLayerColors();
                dialogs_archiveDrawable.setLayerColor("Arrow.**", getNonAnimatedColor("chats_archiveBackground"));
                dialogs_archiveDrawable.setLayerColor("Box2.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_archiveDrawable.setLayerColor("Box1.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_archiveDrawable.commitApplyLayerColors();
                dialogs_archiveDrawableRecolored = false;
                dialogs_unarchiveDrawable.beginApplyLayerColors();
                dialogs_unarchiveDrawable.setLayerColor("Arrow1.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_unarchiveDrawable.setLayerColor("Arrow2.**", getNonAnimatedColor("chats_archivePinBackground"));
                dialogs_unarchiveDrawable.setLayerColor("Box2.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_unarchiveDrawable.setLayerColor("Box1.**", getNonAnimatedColor("chats_archiveIcon"));
                dialogs_unarchiveDrawable.commitApplyLayerColors();
                return;
            }
        }
    }

    public static void createCommonDialogResources(Context context) {
        if (dialogs_countTextPaint == null) {
            dialogs_countTextPaint = new TextPaint(1);
            dialogs_countPaint = new Paint(1);
            dialogs_onlineCirclePaint = new Paint(1);
        }
        dialogs_countTextPaint.setTextSize(AndroidUtilities.dp(13.0f));
        updateCommonDialogResourcesTypeFace();
    }

    public static void createDialogsResources(Context context) throws Resources.NotFoundException {
        createCommonResources(context);
        createCommonDialogResources(context);
        if (dialogs_namePaint == null) {
            Resources resources = context.getResources();
            dialogs_namePaint = new TextPaint[2];
            dialogs_nameEncryptedPaint = new TextPaint[2];
            dialogs_messagePaint = new TextPaint[2];
            dialogs_messagePrintingPaint = new TextPaint[2];
            for (int i = 0; i < 2; i++) {
                dialogs_namePaint[i] = new TextPaint(1);
                dialogs_nameEncryptedPaint[i] = new TextPaint(1);
                dialogs_messagePaint[i] = new TextPaint(1);
                dialogs_messagePrintingPaint[i] = new TextPaint(1);
            }
            dialogs_searchNamePaint = new TextPaint(1);
            dialogs_searchNameEncryptedPaint = new TextPaint(1);
            dialogs_messageNamePaint = new TextPaint(1);
            dialogs_timePaint = new TextPaint(1);
            dialogs_archiveTextPaint = new TextPaint(1);
            dialogs_archiveTextPaintSmall = new TextPaint(1);
            dialogs_onlinePaint = new TextPaint(1);
            dialogs_offlinePaint = new TextPaint(1);
            dialogs_tabletSeletedPaint = new Paint();
            dialogs_pinnedPaint = new Paint(1);
            dialogs_countGrayPaint = new Paint(1);
            dialogs_errorPaint = new Paint(1);
            dialogs_actionMessagePaint = new Paint(1);
            dialogs_lockDrawable = resources.getDrawable(R.drawable.list_secret);
            dialogs_checkDrawable = resources.getDrawable(R.drawable.list_check).mutate();
            dialogs_playDrawable = resources.getDrawable(R.drawable.minithumb_play).mutate();
            dialogs_checkReadDrawable = resources.getDrawable(R.drawable.list_check).mutate();
            dialogs_halfCheckDrawable = resources.getDrawable(R.drawable.list_halfcheck);
            dialogs_clockDrawable = new MsgClockDrawable();
            dialogs_errorDrawable = resources.getDrawable(R.drawable.list_warning_sign);
            dialogs_reorderDrawable = resources.getDrawable(R.drawable.list_reorder).mutate();
            dialogs_groupDrawable = resources.getDrawable(R.drawable.list_group);
            dialogs_broadcastDrawable = resources.getDrawable(R.drawable.list_broadcast);
            dialogs_MediaDrawable = resources.getDrawable(R.drawable.ic_video).mutate();
            dialogs_muteDrawable = resources.getDrawable(R.drawable.list_mute).mutate();
            dialogs_verifiedDrawable = resources.getDrawable(R.drawable.verified_area).mutate();
            dialogs_scamDrawable = new ScamDrawable(11, 0);
            dialogs_fakeDrawable = new ScamDrawable(11, 1);
            dialogs_shopDrawable = new ScamDrawable(11, 2);
            dialogs_verifiedCheckDrawable = resources.getDrawable(R.drawable.verified_check).mutate();
            dialogs_mentionDrawable = resources.getDrawable(R.drawable.mentionchatslist);
            dialogs_botDrawable = resources.getDrawable(R.drawable.list_bot);
            dialogs_pinnedDrawable = resources.getDrawable(R.drawable.list_pin);
            moveUpDrawable = resources.getDrawable(R.drawable.preview_open);
            avatar_photoDrawable = resources.getDrawable(R.drawable.photo_w);
            avatar_broadcastDrawable = resources.getDrawable(R.drawable.broadcast_w);
            explore_channelNameTextPaint = new TextPaint(1);
            explore_captionTextPaint = new TextPaint(1);
            messageExplore_namePaint = new TextPaint(1);
            RectF rectF = new RectF();
            chat_updatePath[0] = new Path();
            chat_updatePath[2] = new Path();
            float fDp = AndroidUtilities.dp(12.0f);
            float fDp2 = AndroidUtilities.dp(12.0f);
            rectF.set(fDp - AndroidUtilities.dp(5.0f), fDp2 - AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f) + fDp, AndroidUtilities.dp(5.0f) + fDp2);
            chat_updatePath[2].arcTo(rectF, -160.0f, -110.0f, true);
            chat_updatePath[2].arcTo(rectF, 20.0f, -110.0f, true);
            chat_updatePath[0].moveTo(fDp, AndroidUtilities.dp(8.0f) + fDp2);
            chat_updatePath[0].lineTo(fDp, AndroidUtilities.dp(2.0f) + fDp2);
            chat_updatePath[0].lineTo(AndroidUtilities.dp(3.0f) + fDp, AndroidUtilities.dp(5.0f) + fDp2);
            chat_updatePath[0].close();
            chat_updatePath[0].moveTo(fDp, fDp2 - AndroidUtilities.dp(8.0f));
            chat_updatePath[0].lineTo(fDp, fDp2 - AndroidUtilities.dp(2.0f));
            chat_updatePath[0].lineTo(fDp - AndroidUtilities.dp(3.0f), fDp2 - AndroidUtilities.dp(5.0f));
            chat_updatePath[0].close();
            applyDialogsTheme();
        }
        dialogs_messageNamePaint.setTextSize(AndroidUtilities.dp(14.0f));
        dialogs_timePaint.setTextSize(AndroidUtilities.dp(13.0f));
        dialogs_archiveTextPaint.setTextSize(AndroidUtilities.dp(13.0f));
        dialogs_archiveTextPaintSmall.setTextSize(AndroidUtilities.dp(11.0f));
        dialogs_onlinePaint.setTextSize(AndroidUtilities.dp(15.0f));
        dialogs_offlinePaint.setTextSize(AndroidUtilities.dp(15.0f));
        dialogs_searchNamePaint.setTextSize(AndroidUtilities.dp(16.0f));
        dialogs_searchNameEncryptedPaint.setTextSize(AndroidUtilities.dp(16.0f));
        messageExplore_namePaint.setTextSize(AndroidUtilities.dp(16.0f));
        explore_channelNameTextPaint.setTextSize(AndroidUtilities.dp(17.0f));
        explore_captionTextPaint.setTextSize(AndroidUtilities.dp(16.0f));
        updateDialogResourcesTypeFace();
    }

    public static void applyDialogsTheme() {
        if (dialogs_namePaint == null) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            dialogs_namePaint[i].setColor(getColor("chats_name"));
            dialogs_nameEncryptedPaint[i].setColor(getColor("chats_secretName"));
            TextPaint[] textPaintArr = dialogs_messagePaint;
            TextPaint textPaint = textPaintArr[i];
            TextPaint textPaint2 = textPaintArr[i];
            int color = getColor("chats_message");
            textPaint2.linkColor = color;
            textPaint.setColor(color);
            dialogs_messagePrintingPaint[i].setColor(getColor("chats_actionMessage"));
        }
        dialogs_searchNamePaint.setColor(getColor("chats_name"));
        dialogs_searchNameEncryptedPaint.setColor(getColor("chats_secretName"));
        TextPaint textPaint3 = dialogs_messageNamePaint;
        int color2 = getColor("chats_nameMessage_threeLines");
        textPaint3.linkColor = color2;
        textPaint3.setColor(color2);
        dialogs_tabletSeletedPaint.setColor(getColor("chats_tabletSelectedOverlay"));
        dialogs_pinnedPaint.setColor(getColor("chats_pinnedOverlay"));
        dialogs_timePaint.setColor(getColor("chats_date"));
        dialogs_countTextPaint.setColor(getColor("chats_unreadCounterText"));
        dialogs_archiveTextPaint.setColor(getColor("chats_archiveText"));
        dialogs_archiveTextPaintSmall.setColor(getColor("chats_archiveText"));
        dialogs_countPaint.setColor(getColor("chats_unreadCounter"));
        dialogs_countGrayPaint.setColor(getColor("chats_unreadCounterMuted"));
        dialogs_actionMessagePaint.setColor(getColor("chats_actionMessage"));
        dialogs_errorPaint.setColor(getColor("chats_sentError"));
        dialogs_onlinePaint.setColor(getColor("windowBackgroundWhiteBlueText3"));
        dialogs_offlinePaint.setColor(getColor("windowBackgroundWhiteGrayText3"));
        explore_channelNameTextPaint.setColor(getColor("windowBackgroundWhiteBlackText"));
        explore_captionTextPaint.setColor(getColor("chats_date"));
        explore_channelNameTextPaint.setColor(getColor("windowBackgroundWhiteBlackText"));
        messageExplore_namePaint.setColor(getColor("chat_messageLinkIn"));
        setDrawableColorByKey(dialogs_lockDrawable, "chats_secretIcon");
        setDrawableColorByKey(dialogs_checkDrawable, "chats_sentCheck");
        setDrawableColorByKey(dialogs_checkReadDrawable, "chats_sentReadCheck");
        setDrawableColorByKey(dialogs_halfCheckDrawable, "chats_sentReadCheck");
        setDrawableColorByKey(dialogs_clockDrawable, "chats_sentClock");
        setDrawableColorByKey(dialogs_errorDrawable, "chats_sentErrorIcon");
        setDrawableColorByKey(dialogs_groupDrawable, "chats_nameIcon");
        setDrawableColorByKey(dialogs_broadcastDrawable, "chats_nameIcon");
        setDrawableColorByKey(dialogs_MediaDrawable, "chats_nameIcon");
        setDrawableColorByKey(dialogs_botDrawable, "chats_nameIcon");
        setDrawableColorByKey(dialogs_pinnedDrawable, "chats_pinnedIcon");
        setDrawableColorByKey(dialogs_reorderDrawable, "chats_pinnedIcon");
        setDrawableColorByKey(dialogs_muteDrawable, "chats_muteIcon");
        setDrawableColorByKey(dialogs_mentionDrawable, "chats_mentionIcon");
        setDrawableColorByKey(dialogs_verifiedDrawable, "chats_verifiedBackground");
        setDrawableColorByKey(dialogs_verifiedCheckDrawable, "chats_verifiedCheck");
        setDrawableColorByKey(dialogs_holidayDrawable, "actionBarDefaultTitle");
        setDrawableColorByKey(dialogs_scamDrawable, "trusty");
        setDrawableColorByKey(dialogs_fakeDrawable, "chats_draft");
        setDrawableColorByKey(dialogs_shopDrawable, "trusty");
    }

    public static void reloadAllResources(Context context) throws Resources.NotFoundException {
        destroyResources();
        if (chat_msgInDrawable != null) {
            chat_msgInDrawable = null;
            currentColor = 0;
            createChatResources(context, false);
        }
        if (dialogs_namePaint != null) {
            dialogs_namePaint = null;
            createDialogsResources(context);
        }
        if (profile_verifiedDrawable != null) {
            profile_verifiedDrawable = null;
            createProfileResources(context);
        }
    }

    public static void createCommonMessageResources() {
        synchronized (sync) {
            if (chat_msgTextPaint == null) {
                chat_msgTextPaint = new TextPaint(1);
                chat_msgGameTextPaint = new TextPaint(1);
                chat_msgTextPaintOneEmoji = new TextPaint(1);
                chat_msgTextPaintTwoEmoji = new TextPaint(1);
                chat_msgTextPaintThreeEmoji = new TextPaint(1);
                chat_msgBotButtonPaint = new TextPaint(1);
            }
            chat_msgTextPaintOneEmoji.setTextSize(AndroidUtilities.dp(28.0f));
            chat_msgTextPaintTwoEmoji.setTextSize(AndroidUtilities.dp(24.0f));
            chat_msgTextPaintThreeEmoji.setTextSize(AndroidUtilities.dp(20.0f));
            chat_msgTextPaint.setTextSize(AndroidUtilities.dp(SharedConfig.fontSize));
            chat_msgGameTextPaint.setTextSize(AndroidUtilities.dp(14.0f));
            chat_msgBotButtonPaint.setTextSize(AndroidUtilities.dp(15.0f));
            updateMessageResourcesTypeFace();
        }
    }

    public static void createCommonChatResources() {
        createCommonMessageResources();
        if (chat_infoPaint == null) {
            chat_infoPaint = new TextPaint(1);
            chat_stickerCommentCountPaint = new TextPaint(1);
            chat_docNamePaint = new TextPaint(1);
            chat_docBackPaint = new Paint(1);
            chat_deleteProgressPaint = new Paint(1);
            Paint paint = new Paint(1);
            chat_botProgressPaint = paint;
            paint.setStrokeCap(Paint.Cap.ROUND);
            chat_botProgressPaint.setStyle(Paint.Style.STROKE);
            chat_locationTitlePaint = new TextPaint(1);
            chat_locationAddressPaint = new TextPaint(1);
            chat_urlPaint = new Paint();
            chat_textSearchSelectionPaint = new Paint();
            Paint paint2 = new Paint(1);
            chat_radialProgressPaint = paint2;
            paint2.setStrokeCap(Paint.Cap.ROUND);
            chat_radialProgressPaint.setStyle(Paint.Style.STROKE);
            chat_radialProgressPaint.setColor(-1610612737);
            Paint paint3 = new Paint(1);
            chat_radialProgress2Paint = paint3;
            paint3.setStrokeCap(Paint.Cap.ROUND);
            chat_radialProgress2Paint.setStyle(Paint.Style.STROKE);
            chat_audioTimePaint = new TextPaint(1);
            chat_livePaint = new TextPaint(1);
            chat_audioTitlePaint = new TextPaint(1);
            chat_audioPerformerPaint = new TextPaint(1);
            chat_botButtonPaint = new TextPaint(1);
            chat_contactNamePaint = new TextPaint(1);
            chat_contactPhonePaint = new TextPaint(1);
            chat_durationPaint = new TextPaint(1);
            chat_gamePaint = new TextPaint(1);
            chat_shipmentPaint = new TextPaint(1);
            chat_timePaint = new TextPaint(1);
            chat_adminPaint = new TextPaint(1);
            chat_namePaint = new TextPaint(1);
            chat_forwardNamePaint = new TextPaint(1);
            chat_replyNamePaint = new TextPaint(1);
            chat_replyTextPaint = new TextPaint(1);
            chat_instantViewPaint = new TextPaint(1);
            Paint paint4 = new Paint(1);
            chat_instantViewRectPaint = paint4;
            paint4.setStyle(Paint.Style.STROKE);
            chat_instantViewRectPaint.setStrokeCap(Paint.Cap.ROUND);
            Paint paint5 = new Paint(1);
            chat_pollTimerPaint = paint5;
            paint5.setStyle(Paint.Style.STROKE);
            chat_pollTimerPaint.setStrokeCap(Paint.Cap.ROUND);
            chat_replyLinePaint = new Paint(1);
            chat_msgErrorPaint = new Paint(1);
            chat_statusPaint = new Paint(1);
            Paint paint6 = new Paint(1);
            chat_statusRecordPaint = paint6;
            paint6.setStyle(Paint.Style.STROKE);
            chat_statusRecordPaint.setStrokeCap(Paint.Cap.ROUND);
            chat_actionTextPaint = new TextPaint(1);
            Paint paint7 = new Paint(1);
            chat_actionBackgroundGradientDarkenPaint = paint7;
            paint7.setColor(704643072);
            chat_timeBackgroundPaint = new Paint(1);
            chat_contextResult_titleTextPaint = new TextPaint(1);
            chat_contextResult_descriptionTextPaint = new TextPaint(1);
            chat_composeBackgroundPaint = new Paint();
            chat_radialProgressPausedPaint = new Paint(1);
            chat_radialProgressPausedSeekbarPaint = new Paint(1);
            chat_actionBackgroundPaint = new Paint(1);
            chat_actionBackgroundSelectedPaint = new Paint(1);
            chat_actionBackgroundPaint2 = new Paint(1);
            chat_actionBackgroundSelectedPaint2 = new Paint(1);
            addChatPaint("paintChatActionBackground", chat_actionBackgroundPaint, "chat_serviceBackground");
            addChatPaint("paintChatActionBackgroundSelected", chat_actionBackgroundSelectedPaint, "chat_serviceBackgroundSelected");
            addChatPaint("paintChatActionText", chat_actionTextPaint, "chat_serviceText");
            addChatPaint("paintChatBotButton", chat_botButtonPaint, "chat_botButtonText");
            addChatPaint("paintChatComposeBackground", chat_composeBackgroundPaint, "chat_messagePanelBackground");
            addChatPaint("paintChatTimeBackground", chat_timeBackgroundPaint, "chat_mediaTimeBackground");
        }
        updateCommonChatResourcesTypeFace();
    }

    public static void createChatResources(Context context, boolean fontsOnly) throws Resources.NotFoundException {
        Paint paint;
        createCommonChatResources();
        if (!fontsOnly && chat_msgInDrawable == null) {
            Resources resources = context.getResources();
            chat_msgNoSoundDrawable = resources.getDrawable(R.drawable.video_muted);
            chat_msgInDrawable = new MessageDrawable(0, false, false);
            chat_msgInSelectedDrawable = new MessageDrawable(0, false, true);
            chat_msgOutDrawable = new MessageDrawable(0, true, false);
            chat_msgOutSelectedDrawable = new MessageDrawable(0, true, true);
            chat_msgInMediaDrawable = new MessageDrawable(1, false, false);
            chat_msgInMediaSelectedDrawable = new MessageDrawable(1, false, true);
            chat_msgOutMediaDrawable = new MessageDrawable(1, true, false);
            chat_msgOutMediaSelectedDrawable = new MessageDrawable(1, true, true);
            messageExplore_captionPaint = new TextPaint(1);
            PathAnimator pathAnimator = new PathAnimator(0.293f, -26.0f, -28.0f, 1.0f);
            playPauseAnimator = pathAnimator;
            pathAnimator.addSvgKeyFrame("M 34.141 16.042 C 37.384 17.921 40.886 20.001 44.211 21.965 C 46.139 23.104 49.285 24.729 49.586 25.917 C 50.289 28.687 48.484 30 46.274 30 L 6 30.021 C 3.79 30.021 2.075 30.023 2 26.021 L 2.009 3.417 C 2.009 0.417 5.326 -0.58 7.068 0.417 C 10.545 2.406 25.024 10.761 34.141 16.042 Z", 166.0f);
            playPauseAnimator.addSvgKeyFrame("M 37.843 17.769 C 41.143 19.508 44.131 21.164 47.429 23.117 C 48.542 23.775 49.623 24.561 49.761 25.993 C 50.074 28.708 48.557 30 46.347 30 L 6 30.012 C 3.79 30.012 2 28.222 2 26.012 L 2.009 4.609 C 2.009 1.626 5.276 0.664 7.074 1.541 C 10.608 3.309 28.488 12.842 37.843 17.769 Z", 200.0f);
            playPauseAnimator.addSvgKeyFrame("M 40.644 18.756 C 43.986 20.389 49.867 23.108 49.884 25.534 C 49.897 27.154 49.88 24.441 49.894 26.059 C 49.911 28.733 48.6 30 46.39 30 L 6 30.013 C 3.79 30.013 2 28.223 2 26.013 L 2.008 5.52 C 2.008 2.55 5.237 1.614 7.079 2.401 C 10.656 4 31.106 14.097 40.644 18.756 Z", 217.0f);
            playPauseAnimator.addSvgKeyFrame("M 43.782 19.218 C 47.117 20.675 50.075 21.538 50.041 24.796 C 50.022 26.606 50.038 24.309 50.039 26.104 C 50.038 28.736 48.663 30 46.453 30 L 6 29.986 C 3.79 29.986 2 28.196 2 25.986 L 2.008 6.491 C 2.008 3.535 5.196 2.627 7.085 3.316 C 10.708 4.731 33.992 14.944 43.782 19.218 Z", 234.0f);
            playPauseAnimator.addSvgKeyFrame("M 47.421 16.941 C 50.544 18.191 50.783 19.91 50.769 22.706 C 50.761 24.484 50.76 23.953 50.79 26.073 C 50.814 27.835 49.334 30 47.124 30 L 5 30.01 C 2.79 30.01 1 28.22 1 26.01 L 1.001 10.823 C 1.001 8.218 3.532 6.895 5.572 7.26 C 7.493 8.01 47.421 16.941 47.421 16.941 Z", 267.0f);
            playPauseAnimator.addSvgKeyFrame("M 47.641 17.125 C 50.641 18.207 51.09 19.935 51.078 22.653 C 51.07 24.191 51.062 21.23 51.088 23.063 C 51.109 24.886 49.587 27 47.377 27 L 5 27.009 C 2.79 27.009 1 25.219 1 23.009 L 0.983 11.459 C 0.983 8.908 3.414 7.522 5.476 7.838 C 7.138 8.486 47.641 17.125 47.641 17.125 Z", 300.0f);
            playPauseAnimator.addSvgKeyFrame("M 48 7 C 50.21 7 52 8.79 52 11 C 52 19 52 19 52 19 C 52 21.21 50.21 23 48 23 L 4 23 C 1.79 23 0 21.21 0 19 L 0 11 C 0 8.79 1.79 7 4 7 C 48 7 48 7 48 7 Z", 383.0f);
            chat_msgOutCheckDrawable = resources.getDrawable(R.drawable.msg_check).mutate();
            chat_msgOutCheckSelectedDrawable = resources.getDrawable(R.drawable.msg_check).mutate();
            chat_msgOutCheckReadDrawable = resources.getDrawable(R.drawable.msg_check).mutate();
            chat_msgOutCheckReadSelectedDrawable = resources.getDrawable(R.drawable.msg_check).mutate();
            chat_msgMediaCheckDrawable = resources.getDrawable(R.drawable.msg_check_s).mutate();
            chat_msgStickerCheckDrawable = resources.getDrawable(R.drawable.msg_check_s).mutate();
            chat_msgOutHalfCheckDrawable = resources.getDrawable(R.drawable.msg_halfcheck).mutate();
            chat_msgOutHalfCheckSelectedDrawable = resources.getDrawable(R.drawable.msg_halfcheck).mutate();
            chat_msgMediaHalfCheckDrawable = resources.getDrawable(R.drawable.msg_halfcheck_s).mutate();
            chat_msgStickerHalfCheckDrawable = resources.getDrawable(R.drawable.msg_halfcheck_s).mutate();
            chat_msgClockDrawable = new MsgClockDrawable();
            chat_msgInViewsDrawable = resources.getDrawable(R.drawable.msg_views).mutate();
            chat_msgInViewsSelectedDrawable = resources.getDrawable(R.drawable.msg_views).mutate();
            chat_msgOutViewsDrawable = resources.getDrawable(R.drawable.msg_views).mutate();
            chat_msgOutViewsSelectedDrawable = resources.getDrawable(R.drawable.msg_views).mutate();
            chat_liveTotalViewerDrawable = resources.getDrawable(R.drawable.live_total_viewers).mutate();
            chat_liveMessageIconDrawable = resources.getDrawable(R.drawable.msg_live_stream).mutate();
            chat_msgInRepliesDrawable = resources.getDrawable(R.drawable.msg_reply_small).mutate();
            chat_msgInRepliesSelectedDrawable = resources.getDrawable(R.drawable.msg_reply_small).mutate();
            chat_msgOutRepliesDrawable = resources.getDrawable(R.drawable.msg_reply_small).mutate();
            chat_msgOutRepliesSelectedDrawable = resources.getDrawable(R.drawable.msg_reply_small).mutate();
            chat_msgInPinnedDrawable = resources.getDrawable(R.drawable.msg_pin_mini).mutate();
            chat_msgInPinnedSelectedDrawable = resources.getDrawable(R.drawable.msg_pin_mini).mutate();
            chat_msgOutPinnedDrawable = resources.getDrawable(R.drawable.msg_pin_mini).mutate();
            chat_msgOutPinnedSelectedDrawable = resources.getDrawable(R.drawable.msg_pin_mini).mutate();
            chat_msgMediaPinnedDrawable = resources.getDrawable(R.drawable.msg_pin_mini).mutate();
            chat_msgStickerPinnedDrawable = resources.getDrawable(R.drawable.msg_pin_mini).mutate();
            chat_msgMediaViewsDrawable = resources.getDrawable(R.drawable.msg_views).mutate();
            chat_msgMediaRepliesDrawable = resources.getDrawable(R.drawable.msg_reply_small).mutate();
            chat_msgStickerViewsDrawable = resources.getDrawable(R.drawable.msg_views).mutate();
            chat_msgStickerRepliesDrawable = resources.getDrawable(R.drawable.msg_reply_small).mutate();
            chat_msgInMenuDrawable = resources.getDrawable(R.drawable.msg_actions).mutate();
            chat_msgInMenuSelectedDrawable = resources.getDrawable(R.drawable.msg_actions).mutate();
            chat_msgOutMenuDrawable = resources.getDrawable(R.drawable.msg_actions).mutate();
            chat_msgOutMenuSelectedDrawable = resources.getDrawable(R.drawable.msg_actions).mutate();
            chat_msgMediaMenuDrawable = resources.getDrawable(R.drawable.video_actions);
            chat_msgInInstantDrawable = resources.getDrawable(R.drawable.msg_instant).mutate();
            chat_msgOutInstantDrawable = resources.getDrawable(R.drawable.msg_instant).mutate();
            chat_msgErrorDrawable = resources.getDrawable(R.drawable.msg_warning);
            chat_muteIconDrawable = resources.getDrawable(R.drawable.list_mute).mutate();
            chat_lockIconDrawable = resources.getDrawable(R.drawable.ic_lock_header);
            chat_msgBroadcastDrawable = resources.getDrawable(R.drawable.broadcast3).mutate();
            chat_msgBroadcastMediaDrawable = resources.getDrawable(R.drawable.broadcast3).mutate();
            chat_msgInCallDrawable[0] = resources.getDrawable(R.drawable.chat_calls_voice).mutate();
            chat_msgInCallSelectedDrawable[0] = resources.getDrawable(R.drawable.chat_calls_voice).mutate();
            chat_msgOutCallDrawable[0] = resources.getDrawable(R.drawable.chat_calls_voice).mutate();
            chat_msgOutCallSelectedDrawable[0] = resources.getDrawable(R.drawable.chat_calls_voice).mutate();
            chat_msgInCallDrawable[1] = resources.getDrawable(R.drawable.chat_calls_video).mutate();
            chat_msgInCallSelectedDrawable[1] = resources.getDrawable(R.drawable.chat_calls_video).mutate();
            chat_msgOutCallDrawable[1] = resources.getDrawable(R.drawable.chat_calls_video).mutate();
            chat_msgOutCallSelectedDrawable[1] = resources.getDrawable(R.drawable.chat_calls_video).mutate();
            chat_msgCallUpGreenDrawable = resources.getDrawable(R.drawable.chat_calls_outgoing).mutate();
            chat_msgCallDownRedDrawable = resources.getDrawable(R.drawable.chat_calls_incoming).mutate();
            chat_msgCallDownGreenDrawable = resources.getDrawable(R.drawable.chat_calls_incoming).mutate();
            for (int i = 0; i < 2; i++) {
                chat_pollCheckDrawable[i] = resources.getDrawable(R.drawable.poll_right).mutate();
                chat_pollCrossDrawable[i] = resources.getDrawable(R.drawable.poll_wrong).mutate();
                chat_pollHintDrawable[i] = resources.getDrawable(R.drawable.smiles_panel_objects).mutate();
                chat_psaHelpDrawable[i] = resources.getDrawable(R.drawable.msg_psa).mutate();
            }
            calllog_msgCallUpRedDrawable = resources.getDrawable(R.drawable.ic_call_made_green_18dp).mutate();
            calllog_msgCallUpGreenDrawable = resources.getDrawable(R.drawable.ic_call_made_green_18dp).mutate();
            calllog_msgCallDownRedDrawable = resources.getDrawable(R.drawable.ic_call_received_green_18dp).mutate();
            calllog_msgCallDownGreenDrawable = resources.getDrawable(R.drawable.ic_call_received_green_18dp).mutate();
            chat_eitaaPayDrawable = resources.getDrawable(R.drawable.eitaa_pay);
            chat_msgAvatarLiveLocationDrawable = resources.getDrawable(R.drawable.livepin).mutate();
            chat_inlineResultFile = resources.getDrawable(R.drawable.bot_file);
            chat_inlineResultAudio = resources.getDrawable(R.drawable.bot_music);
            chat_inlineResultLocation = resources.getDrawable(R.drawable.bot_location);
            chat_redLocationIcon = resources.getDrawable(R.drawable.map_pin).mutate();
            chat_botLinkDrawalbe = resources.getDrawable(R.drawable.bot_link);
            chat_botInlineDrawable = resources.getDrawable(R.drawable.bot_lines);
            chat_botCardDrawalbe = resources.getDrawable(R.drawable.bot_card);
            chat_commentDrawable = resources.getDrawable(R.drawable.msg_msgbubble);
            chat_commentStickerDrawable = resources.getDrawable(R.drawable.msg_msgbubble2);
            chat_commentArrowDrawable = resources.getDrawable(R.drawable.msg_arrowright);
            chat_contextResult_shadowUnderSwitchDrawable = resources.getDrawable(R.drawable.header_shadow).mutate();
            chat_attachButtonDrawables[0] = new RLottieDrawable(R.raw.attach_gallery, "attach_gallery", AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f));
            chat_attachButtonDrawables[1] = new RLottieDrawable(R.raw.attach_music, "attach_music", AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f));
            chat_attachButtonDrawables[2] = new RLottieDrawable(R.raw.attach_file, "attach_file", AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f));
            chat_attachButtonDrawables[3] = new RLottieDrawable(R.raw.attach_contact, "attach_contact", AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f));
            chat_attachButtonDrawables[4] = new RLottieDrawable(R.raw.attach_location, "attach_location", AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f));
            chat_attachButtonDrawables[5] = new RLottieDrawable(R.raw.attach_poll, "attach_poll", AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f));
            chat_attachButtonDrawables[6] = new RLottieDrawable(R.raw.live, "attach_live", AndroidUtilities.dp(55.0f), AndroidUtilities.dp(55.0f));
            chat_attachEmptyDrawable = resources.getDrawable(R.drawable.nophotos3);
            chat_shareIconDrawable = resources.getDrawable(R.drawable.share_arrow).mutate();
            chat_replyIconDrawable = resources.getDrawable(R.drawable.fast_reply);
            chat_goIconDrawable = resources.getDrawable(R.drawable.message_arrow);
            chat_fileMiniStatesDrawable[0][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.audio_mini_arrow);
            chat_fileMiniStatesDrawable[0][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.audio_mini_arrow);
            chat_fileMiniStatesDrawable[1][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.audio_mini_cancel);
            chat_fileMiniStatesDrawable[1][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.audio_mini_cancel);
            chat_fileMiniStatesDrawable[2][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.audio_mini_arrow);
            chat_fileMiniStatesDrawable[2][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.audio_mini_arrow);
            chat_fileMiniStatesDrawable[3][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.audio_mini_cancel);
            chat_fileMiniStatesDrawable[3][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.audio_mini_cancel);
            chat_fileMiniStatesDrawable[4][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.video_mini_arrow);
            chat_fileMiniStatesDrawable[4][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.video_mini_arrow);
            chat_fileMiniStatesDrawable[5][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.video_mini_cancel);
            chat_fileMiniStatesDrawable[5][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(22.0f), R.drawable.video_mini_cancel);
            int iDp = AndroidUtilities.dp(2.0f);
            RectF rectF = new RectF();
            chat_filePath[0] = new Path();
            chat_filePath[0].moveTo(AndroidUtilities.dp(7.0f), AndroidUtilities.dp(3.0f));
            chat_filePath[0].lineTo(AndroidUtilities.dp(14.0f), AndroidUtilities.dp(3.0f));
            chat_filePath[0].lineTo(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(10.0f));
            chat_filePath[0].lineTo(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(20.0f));
            int i2 = iDp * 2;
            rectF.set(AndroidUtilities.dp(21.0f) - i2, AndroidUtilities.dp(19.0f) - iDp, AndroidUtilities.dp(21.0f), AndroidUtilities.dp(19.0f) + iDp);
            chat_filePath[0].arcTo(rectF, 0.0f, 90.0f, false);
            chat_filePath[0].lineTo(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(21.0f));
            rectF.set(AndroidUtilities.dp(5.0f), AndroidUtilities.dp(19.0f) - iDp, AndroidUtilities.dp(5.0f) + i2, AndroidUtilities.dp(19.0f) + iDp);
            chat_filePath[0].arcTo(rectF, 90.0f, 90.0f, false);
            chat_filePath[0].lineTo(AndroidUtilities.dp(5.0f), AndroidUtilities.dp(4.0f));
            rectF.set(AndroidUtilities.dp(5.0f), AndroidUtilities.dp(3.0f), AndroidUtilities.dp(5.0f) + i2, AndroidUtilities.dp(3.0f) + i2);
            chat_filePath[0].arcTo(rectF, 180.0f, 90.0f, false);
            chat_filePath[0].close();
            chat_filePath[1] = new Path();
            chat_filePath[1].moveTo(AndroidUtilities.dp(14.0f), AndroidUtilities.dp(5.0f));
            chat_filePath[1].lineTo(AndroidUtilities.dp(19.0f), AndroidUtilities.dp(10.0f));
            chat_filePath[1].lineTo(AndroidUtilities.dp(14.0f), AndroidUtilities.dp(10.0f));
            chat_filePath[1].close();
            chat_flameIcon = resources.getDrawable(R.drawable.burn).mutate();
            chat_gifIcon = resources.getDrawable(R.drawable.msg_round_gif_m).mutate();
            chat_fileStatesDrawable[0][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_play_m);
            chat_fileStatesDrawable[0][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_play_m);
            chat_fileStatesDrawable[1][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_pause_m);
            chat_fileStatesDrawable[1][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_pause_m);
            chat_fileStatesDrawable[2][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_load_m);
            chat_fileStatesDrawable[2][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_load_m);
            chat_fileStatesDrawable[3][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_file_s);
            chat_fileStatesDrawable[3][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_file_s);
            chat_fileStatesDrawable[4][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_cancel_m);
            chat_fileStatesDrawable[4][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_cancel_m);
            chat_fileStatesDrawable[5][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_play_m);
            chat_fileStatesDrawable[5][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_play_m);
            chat_fileStatesDrawable[6][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_pause_m);
            chat_fileStatesDrawable[6][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_pause_m);
            chat_fileStatesDrawable[7][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_load_m);
            chat_fileStatesDrawable[7][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_load_m);
            chat_fileStatesDrawable[8][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_file_s);
            chat_fileStatesDrawable[8][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_file_s);
            chat_fileStatesDrawable[9][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_cancel_m);
            chat_fileStatesDrawable[9][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_round_cancel_m);
            chat_photoStatesDrawables[0][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_load_m);
            chat_photoStatesDrawables[0][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_load_m);
            chat_photoStatesDrawables[1][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_cancel_m);
            chat_photoStatesDrawables[1][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_cancel_m);
            chat_photoStatesDrawables[2][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_gif_m);
            chat_photoStatesDrawables[2][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_gif_m);
            chat_photoStatesDrawables[3][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_play_m);
            chat_photoStatesDrawables[3][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_play_m);
            Drawable[][] drawableArr = chat_photoStatesDrawables;
            Drawable[] drawableArr2 = drawableArr[4];
            Drawable[] drawableArr3 = drawableArr[4];
            Drawable drawable = resources.getDrawable(R.drawable.burn);
            drawableArr3[1] = drawable;
            drawableArr2[0] = drawable;
            Drawable[][] drawableArr4 = chat_photoStatesDrawables;
            Drawable[] drawableArr5 = drawableArr4[5];
            Drawable[] drawableArr6 = drawableArr4[5];
            Drawable drawable2 = resources.getDrawable(R.drawable.circle);
            drawableArr6[1] = drawable2;
            drawableArr5[0] = drawable2;
            Drawable[][] drawableArr7 = chat_photoStatesDrawables;
            Drawable[] drawableArr8 = drawableArr7[6];
            Drawable[] drawableArr9 = drawableArr7[6];
            Drawable drawable3 = resources.getDrawable(R.drawable.photocheck);
            drawableArr9[1] = drawable3;
            drawableArr8[0] = drawable3;
            chat_photoStatesDrawables[7][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_load_m);
            chat_photoStatesDrawables[7][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_load_m);
            chat_photoStatesDrawables[8][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_cancel_m);
            chat_photoStatesDrawables[8][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_cancel_m);
            chat_photoStatesDrawables[9][0] = resources.getDrawable(R.drawable.doc_big).mutate();
            chat_photoStatesDrawables[9][1] = resources.getDrawable(R.drawable.doc_big).mutate();
            chat_photoStatesDrawables[10][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_load_m);
            chat_photoStatesDrawables[10][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_load_m);
            chat_photoStatesDrawables[11][0] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_cancel_m);
            chat_photoStatesDrawables[11][1] = createCircleDrawableWithIcon(AndroidUtilities.dp(48.0f), R.drawable.msg_round_cancel_m);
            chat_photoStatesDrawables[12][0] = resources.getDrawable(R.drawable.doc_big).mutate();
            chat_photoStatesDrawables[12][1] = resources.getDrawable(R.drawable.doc_big).mutate();
            chat_saveToMyCloudIconDrawable = resources.getDrawable(R.drawable.menu_saved);
            chat_saveToMyCloudIconSelectedDrawable = resources.getDrawable(R.drawable.menu_selected_saved).mutate();
            chat_contactDrawable[0] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_contact);
            chat_contactDrawable[1] = createCircleDrawableWithIcon(AndroidUtilities.dp(44.0f), R.drawable.msg_contact);
            chat_liveStreamDrawable[0] = createRoundRectDrawableWithIcon(AndroidUtilities.dp(2.0f), R.drawable.msg_live_stream);
            chat_liveStreamDrawable[1] = createRoundRectDrawableWithIcon(AndroidUtilities.dp(2.0f), R.drawable.msg_live_stream);
            chat_locationDrawable[0] = resources.getDrawable(R.drawable.msg_location).mutate();
            chat_locationDrawable[1] = resources.getDrawable(R.drawable.msg_location).mutate();
            chat_composeShadowDrawable = context.getResources().getDrawable(R.drawable.compose_panel_shadow).mutate();
            chat_composeShadowRoundDrawable = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
            Paint paint2 = new Paint(5);
            freeBubbleChat_backgroundColorPaint = paint2;
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            try {
                int iDp2 = AndroidUtilities.roundMessageSize + AndroidUtilities.dp(6.0f);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iDp2, iDp2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint3 = new Paint(1);
                paint3.setColor(0);
                paint3.setStyle(Paint.Style.FILL);
                paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                Paint paint4 = new Paint(1);
                paint4.setShadowLayer(AndroidUtilities.dp(4.0f), 0.0f, 0.0f, 1593835520);
                int i3 = 0;
                while (i3 < 2) {
                    canvas.drawCircle(iDp2 / 2, iDp2 / 2, (AndroidUtilities.roundMessageSize / 2) - AndroidUtilities.dp(1.0f), i3 == 0 ? paint4 : paint3);
                    i3++;
                }
                try {
                    canvas.setBitmap(null);
                } catch (Exception unused) {
                }
                chat_roundVideoShadow = new BitmapDrawable(bitmapCreateBitmap);
            } catch (Throwable unused2) {
            }
            defaultChatDrawables.clear();
            defaultChatDrawableColorKeys.clear();
            addChatDrawable("drawableBotInline", chat_botInlineDrawable, "chat_serviceIcon");
            addChatDrawable("drawableBotLink", chat_botLinkDrawalbe, "chat_serviceIcon");
            addChatDrawable("drawableGoIcon", chat_goIconDrawable, "chat_serviceIcon");
            addChatDrawable("drawableCommentSticker", chat_commentStickerDrawable, "chat_serviceIcon");
            addChatDrawable("drawableMsgError", chat_msgErrorDrawable, "chat_sentErrorIcon");
            addChatDrawable("drawableMsgIn", chat_msgInDrawable, null);
            addChatDrawable("drawableExploreBg", chat_msgInDrawable, null);
            addChatDrawable("drawableMsgInSelected", chat_msgInSelectedDrawable, null);
            addChatDrawable("drawableMsgInMedia", chat_msgInMediaDrawable, null);
            addChatDrawable("drawableMsgInMediaSelected", chat_msgInMediaSelectedDrawable, null);
            addChatDrawable("drawableMsgOut", chat_msgOutDrawable, null);
            addChatDrawable("drawableMsgOutSelected", chat_msgOutSelectedDrawable, null);
            addChatDrawable("drawableMsgOutMedia", chat_msgOutMediaDrawable, null);
            addChatDrawable("drawableMsgOutMediaSelected", chat_msgOutMediaSelectedDrawable, null);
            addChatDrawable("drawableMsgOutCallAudio", chat_msgOutCallDrawable[0], "chat_outInstant");
            addChatDrawable("drawableMsgOutCallAudioSelected", chat_msgOutCallSelectedDrawable[0], "chat_outInstantSelected");
            addChatDrawable("drawableMsgOutCallVideo", chat_msgOutCallDrawable[1], "chat_outInstant");
            addChatDrawable("drawableMsgOutCallVideo", chat_msgOutCallSelectedDrawable[1], "chat_outInstantSelected");
            addChatDrawable("drawableMsgOutCheck", chat_msgOutCheckDrawable, "chat_outSentCheck");
            addChatDrawable("drawableMsgOutCheckSelected", chat_msgOutCheckSelectedDrawable, "chat_outSentCheckSelected");
            addChatDrawable("drawableMsgOutCheckRead", chat_msgOutCheckReadDrawable, "chat_outSentCheckRead");
            addChatDrawable("drawableMsgOutCheckReadSelected", chat_msgOutCheckReadSelectedDrawable, "chat_outSentCheckReadSelected");
            addChatDrawable("drawableMsgOutHalfCheck", chat_msgOutHalfCheckDrawable, "chat_outSentCheckRead");
            addChatDrawable("drawableMsgOutHalfCheckSelected", chat_msgOutHalfCheckSelectedDrawable, "chat_outSentCheckReadSelected");
            addChatDrawable("drawableMsgOutInstant", chat_msgOutInstantDrawable, "chat_outInstant");
            addChatDrawable("drawableMsgOutMenu", chat_msgOutMenuDrawable, "chat_outMenu");
            addChatDrawable("drawableMsgOutMenuSelected", chat_msgOutMenuSelectedDrawable, "chat_outMenuSelected");
            addChatDrawable("drawableMsgOutPinned", chat_msgOutPinnedDrawable, "chat_outViews");
            addChatDrawable("drawableMsgOutPinnedSelected", chat_msgOutPinnedSelectedDrawable, "chat_outViewsSelected");
            addChatDrawable("drawableMsgOutReplies", chat_msgOutRepliesDrawable, "chat_outViews");
            addChatDrawable("drawableMsgOutReplies", chat_msgOutRepliesSelectedDrawable, "chat_outViewsSelected");
            addChatDrawable("drawableMsgOutViews", chat_msgOutViewsDrawable, "chat_outViews");
            addChatDrawable("drawableMsgOutViewsSelected", chat_msgOutViewsSelectedDrawable, "chat_outViewsSelected");
            addChatDrawable("drawableMsgStickerCheck", chat_msgStickerCheckDrawable, "chat_serviceText");
            addChatDrawable("drawableMsgStickerHalfCheck", chat_msgStickerHalfCheckDrawable, "chat_serviceText");
            addChatDrawable("drawableMsgStickerPinned", chat_msgStickerPinnedDrawable, "chat_serviceText");
            addChatDrawable("drawableMsgStickerReplies", chat_msgStickerRepliesDrawable, "chat_serviceText");
            addChatDrawable("drawableMsgStickerViews", chat_msgStickerViewsDrawable, "chat_serviceText");
            addChatDrawable("drawableReplyIcon", chat_replyIconDrawable, "chat_serviceIcon");
            addChatDrawable("drawableShareIcon", chat_shareIconDrawable, "chat_serviceIcon");
            addChatDrawable("drawableMuteIcon", chat_muteIconDrawable, "chat_muteIcon");
            addChatDrawable("drawableLockIcon", chat_lockIconDrawable, "chat_lockIcon");
            applyChatTheme(fontsOnly, false);
        }
        messageExplore_captionPaint.setTextSize(AndroidUtilities.dp(SharedConfig.fontSize - 2));
        if (!fontsOnly && (paint = chat_botProgressPaint) != null) {
            paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
            chat_infoPaint.setTextSize(AndroidUtilities.dp(12.0f));
            chat_stickerCommentCountPaint.setTextSize(AndroidUtilities.dp(11.0f));
            chat_docNamePaint.setTextSize(AndroidUtilities.dp(15.0f));
            chat_locationTitlePaint.setTextSize(AndroidUtilities.dp(15.0f));
            chat_locationAddressPaint.setTextSize(AndroidUtilities.dp(13.0f));
            chat_audioTimePaint.setTextSize(AndroidUtilities.dp(12.0f));
            chat_livePaint.setTextSize(AndroidUtilities.dp(12.0f));
            chat_audioTitlePaint.setTextSize(AndroidUtilities.dp(16.0f));
            chat_audioPerformerPaint.setTextSize(AndroidUtilities.dp(15.0f));
            chat_botButtonPaint.setTextSize(AndroidUtilities.dp(15.0f));
            chat_contactNamePaint.setTextSize(AndroidUtilities.dp(15.0f));
            chat_contactPhonePaint.setTextSize(AndroidUtilities.dp(13.0f));
            chat_durationPaint.setTextSize(AndroidUtilities.dp(12.0f));
            chat_timePaint.setTextSize(AndroidUtilities.dp(12.0f));
            chat_adminPaint.setTextSize(AndroidUtilities.dp(13.0f));
            chat_namePaint.setTextSize(AndroidUtilities.dp(14.0f));
            chat_forwardNamePaint.setTextSize(AndroidUtilities.dp(14.0f));
            chat_replyNamePaint.setTextSize(AndroidUtilities.dp(14.0f));
            chat_replyTextPaint.setTextSize(AndroidUtilities.dp(14.0f));
            chat_gamePaint.setTextSize(AndroidUtilities.dp(13.0f));
            chat_shipmentPaint.setTextSize(AndroidUtilities.dp(13.0f));
            chat_instantViewPaint.setTextSize(AndroidUtilities.dp(13.0f));
            chat_instantViewRectPaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
            chat_pollTimerPaint.setStrokeWidth(AndroidUtilities.dp(1.1f));
            chat_actionTextPaint.setTextSize(AndroidUtilities.dp(Math.max(16, SharedConfig.fontSize) - 2));
            chat_contextResult_titleTextPaint.setTextSize(AndroidUtilities.dp(15.0f));
            chat_contextResult_descriptionTextPaint.setTextSize(AndroidUtilities.dp(13.0f));
            chat_radialProgressPaint.setStrokeWidth(AndroidUtilities.dp(3.0f));
            chat_radialProgress2Paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        }
        updateChatResourcesTypeFace();
    }

    public static void updateDialogResourcesTypeFace() {
        for (int i = 0; i < 2; i++) {
            dialogs_namePaint[i].setTypeface(AndroidUtilities.getFontFamily(true));
            dialogs_nameEncryptedPaint[i].setTypeface(AndroidUtilities.getFontFamily(true));
            dialogs_messagePaint[i].setTypeface(AndroidUtilities.getFontFamily(false));
            dialogs_messagePrintingPaint[i].setTypeface(AndroidUtilities.getFontFamily(false));
        }
        dialogs_searchNamePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        dialogs_searchNameEncryptedPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        dialogs_messageNamePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        dialogs_timePaint.setTypeface(AndroidUtilities.getFontFamily(false));
        dialogs_archiveTextPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        dialogs_archiveTextPaintSmall.setTypeface(AndroidUtilities.getFontFamily(true));
        dialogs_onlinePaint.setTypeface(AndroidUtilities.getFontFamily(false));
        dialogs_offlinePaint.setTypeface(AndroidUtilities.getFontFamily(false));
        explore_channelNameTextPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        explore_captionTextPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        messageExplore_namePaint.setTypeface(AndroidUtilities.getFontFamily(true));
    }

    public static void updateCommonDialogResourcesTypeFace() {
        dialogs_countTextPaint.setTypeface(AndroidUtilities.getFontFamily(true));
    }

    public static void updateProfileResourcesTypeFace() {
        profile_aboutTextPaint.setTypeface(AndroidUtilities.getFontFamily(false));
    }

    public static void updateChatResourcesTypeFace() {
        messageExplore_captionPaint.setTypeface(AndroidUtilities.getFontFamily(false));
    }

    public static void updateCommonChatResourcesTypeFace() {
        chat_infoPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_stickerCommentCountPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_docNamePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_locationTitlePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_locationAddressPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_audioTimePaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_livePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_audioTitlePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_audioPerformerPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_botButtonPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_contactNamePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_contactPhonePaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_durationPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_gamePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_shipmentPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_timePaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_adminPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_namePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_forwardNamePaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_replyNamePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_replyTextPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_instantViewPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_actionTextPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_contextResult_titleTextPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        chat_contextResult_descriptionTextPaint.setTypeface(AndroidUtilities.getFontFamily(false));
    }

    public static void updateMessageResourcesTypeFace() {
        chat_msgTextPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_msgGameTextPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_msgTextPaintOneEmoji.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_msgTextPaintTwoEmoji.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_msgTextPaintThreeEmoji.setTypeface(AndroidUtilities.getFontFamily(false));
        chat_msgBotButtonPaint.setTypeface(AndroidUtilities.getFontFamily(true));
    }

    public static void refreshAttachButtonsColors() {
        int i = 0;
        while (true) {
            RLottieDrawable[] rLottieDrawableArr = chat_attachButtonDrawables;
            if (i >= rLottieDrawableArr.length) {
                return;
            }
            if (rLottieDrawableArr[i] != null) {
                rLottieDrawableArr[i].beginApplyLayerColors();
                if (i == 0) {
                    chat_attachButtonDrawables[i].setLayerColor("Color_Mount.**", getNonAnimatedColor("chat_attachGalleryBackground"));
                    chat_attachButtonDrawables[i].setLayerColor("Color_PhotoShadow.**", getNonAnimatedColor("chat_attachGalleryBackground"));
                    chat_attachButtonDrawables[i].setLayerColor("White_Photo.**", getNonAnimatedColor("chat_attachGalleryIcon"));
                    chat_attachButtonDrawables[i].setLayerColor("White_BackPhoto.**", getNonAnimatedColor("chat_attachGalleryIcon"));
                } else if (i == 1) {
                    chat_attachButtonDrawables[i].setLayerColor("White_Play1.**", getNonAnimatedColor("chat_attachAudioIcon"));
                    chat_attachButtonDrawables[i].setLayerColor("White_Play2.**", getNonAnimatedColor("chat_attachAudioIcon"));
                } else if (i == 2) {
                    chat_attachButtonDrawables[i].setLayerColor("Color_Corner.**", getNonAnimatedColor("chat_attachFileBackground"));
                    chat_attachButtonDrawables[i].setLayerColor("White_List.**", getNonAnimatedColor("chat_attachFileIcon"));
                } else if (i == 3) {
                    chat_attachButtonDrawables[i].setLayerColor("White_User1.**", getNonAnimatedColor("chat_attachContactIcon"));
                    chat_attachButtonDrawables[i].setLayerColor("White_User2.**", getNonAnimatedColor("chat_attachContactIcon"));
                } else if (i == 4) {
                    chat_attachButtonDrawables[i].setLayerColor("Color_Oval.**", getNonAnimatedColor("chat_attachLocationBackground"));
                    chat_attachButtonDrawables[i].setLayerColor("White_Pin.**", getNonAnimatedColor("chat_attachLocationIcon"));
                } else if (i == 5) {
                    chat_attachButtonDrawables[i].setLayerColor("White_Column 1.**", getNonAnimatedColor("chat_attachPollIcon"));
                    chat_attachButtonDrawables[i].setLayerColor("White_Column 2.**", getNonAnimatedColor("chat_attachPollIcon"));
                    chat_attachButtonDrawables[i].setLayerColor("White_Column 3.**", getNonAnimatedColor("chat_attachPollIcon"));
                }
                chat_attachButtonDrawables[i].commitApplyLayerColors();
            }
            i++;
        }
    }

    public static void applyChatTheme(boolean fontsOnly, boolean bg) {
        if (chat_msgTextPaint == null || chat_msgInDrawable == null || fontsOnly) {
            return;
        }
        chat_gamePaint.setColor(getColor("chat_previewGameText"));
        chat_durationPaint.setColor(getColor("chat_previewDurationText"));
        chat_botButtonPaint.setColor(getColor("chat_botButtonText"));
        chat_urlPaint.setColor(getColor("chat_linkSelectBackground"));
        chat_botProgressPaint.setColor(getColor("chat_botProgress"));
        chat_deleteProgressPaint.setColor(getColor("chat_secretTimeText"));
        chat_textSearchSelectionPaint.setColor(getColor("chat_textSelectBackground"));
        chat_msgErrorPaint.setColor(getColor("chat_sentError"));
        chat_statusPaint.setColor(getColor("chat_status"));
        chat_statusRecordPaint.setColor(getColor("chat_status"));
        chat_actionTextPaint.setColor(getColor("chat_serviceText"));
        chat_actionTextPaint.linkColor = getColor("chat_serviceLink");
        chat_contextResult_titleTextPaint.setColor(getColor("windowBackgroundWhiteBlackText"));
        chat_composeBackgroundPaint.setColor(getColor("chat_messagePanelBackground"));
        chat_timeBackgroundPaint.setColor(getColor("chat_mediaTimeBackground"));
        setDrawableColorByKey(chat_msgNoSoundDrawable, "chat_mediaTimeText");
        setDrawableColorByKey(chat_msgInDrawable, "chat_inBubble");
        setDrawableColorByKey(chat_msgInSelectedDrawable, "chat_inBubbleSelected");
        setDrawableColorByKey(chat_msgInMediaDrawable, "chat_inBubble");
        setDrawableColorByKey(chat_msgInMediaSelectedDrawable, "chat_inBubbleSelected");
        setDrawableColorByKey(chat_msgOutCheckDrawable, "chat_outSentCheck");
        setDrawableColorByKey(chat_msgOutCheckSelectedDrawable, "chat_outSentCheckSelected");
        setDrawableColorByKey(chat_msgOutCheckReadDrawable, "chat_outSentCheckRead");
        setDrawableColorByKey(chat_msgOutCheckReadSelectedDrawable, "chat_outSentCheckReadSelected");
        setDrawableColorByKey(chat_msgOutHalfCheckDrawable, "chat_outSentCheckRead");
        setDrawableColorByKey(chat_msgOutHalfCheckSelectedDrawable, "chat_outSentCheckReadSelected");
        setDrawableColorByKey(chat_msgMediaCheckDrawable, "chat_mediaSentCheck");
        setDrawableColorByKey(chat_msgMediaHalfCheckDrawable, "chat_mediaSentCheck");
        setDrawableColorByKey(chat_msgStickerCheckDrawable, "chat_serviceText");
        setDrawableColorByKey(chat_msgStickerHalfCheckDrawable, "chat_serviceText");
        setDrawableColorByKey(chat_msgStickerViewsDrawable, "chat_serviceText");
        setDrawableColorByKey(chat_msgStickerRepliesDrawable, "chat_serviceText");
        setDrawableColorByKey(chat_shareIconDrawable, "chat_serviceIcon");
        setDrawableColorByKey(chat_replyIconDrawable, "chat_serviceIcon");
        setDrawableColorByKey(chat_saveToMyCloudIconDrawable, "chat_serviceIcon");
        setDrawableColorByKey(chat_saveToMyCloudIconSelectedDrawable, "chat_serviceIcon");
        setDrawableColorByKey(chat_goIconDrawable, "chat_serviceIcon");
        setDrawableColorByKey(chat_botInlineDrawable, "chat_serviceIcon");
        setDrawableColorByKey(chat_botLinkDrawalbe, "chat_serviceIcon");
        setDrawableColorByKey(chat_msgInViewsDrawable, "chat_inViews");
        setDrawableColorByKey(chat_msgInViewsSelectedDrawable, "chat_inViewsSelected");
        setDrawableColorByKey(chat_msgOutViewsDrawable, "chat_outViews");
        setDrawableColorByKey(chat_msgOutViewsSelectedDrawable, "chat_outViewsSelected");
        setDrawableColorByKey(chat_liveTotalViewerDrawable, "chat_previewDurationText");
        setDrawableColorByKey(chat_liveMessageIconDrawable, "chat_previewDurationText");
        setDrawableColorByKey(chat_msgInRepliesDrawable, "chat_inViews");
        setDrawableColorByKey(chat_msgInRepliesSelectedDrawable, "chat_inViewsSelected");
        setDrawableColorByKey(chat_msgOutRepliesDrawable, "chat_outViews");
        setDrawableColorByKey(chat_msgOutRepliesSelectedDrawable, "chat_outViewsSelected");
        setDrawableColorByKey(chat_msgInPinnedDrawable, "chat_inViews");
        setDrawableColorByKey(chat_msgInPinnedSelectedDrawable, "chat_inViewsSelected");
        setDrawableColorByKey(chat_msgOutPinnedDrawable, "chat_outViews");
        setDrawableColorByKey(chat_msgOutPinnedSelectedDrawable, "chat_outViewsSelected");
        setDrawableColorByKey(chat_msgMediaPinnedDrawable, "chat_mediaViews");
        setDrawableColorByKey(chat_msgStickerPinnedDrawable, "chat_serviceText");
        setDrawableColorByKey(chat_msgMediaViewsDrawable, "chat_mediaViews");
        setDrawableColorByKey(chat_msgMediaRepliesDrawable, "chat_mediaViews");
        setDrawableColorByKey(chat_msgInMenuDrawable, "chat_inMenu");
        setDrawableColorByKey(chat_msgInMenuSelectedDrawable, "chat_inMenuSelected");
        setDrawableColorByKey(chat_msgOutMenuDrawable, "chat_outMenu");
        setDrawableColorByKey(chat_msgOutMenuSelectedDrawable, "chat_outMenuSelected");
        setDrawableColorByKey(chat_msgMediaMenuDrawable, "chat_mediaMenu");
        setDrawableColorByKey(chat_msgOutInstantDrawable, "chat_outInstant");
        setDrawableColorByKey(chat_msgInInstantDrawable, "chat_inInstant");
        setDrawableColorByKey(chat_msgErrorDrawable, "chat_sentErrorIcon");
        setDrawableColorByKey(chat_muteIconDrawable, "chat_muteIcon");
        setDrawableColorByKey(chat_lockIconDrawable, "chat_lockIcon");
        setDrawableColorByKey(chat_msgBroadcastDrawable, "chat_outBroadcast");
        setDrawableColorByKey(chat_msgBroadcastMediaDrawable, "chat_mediaBroadcast");
        setDrawableColorByKey(chat_inlineResultFile, "chat_inlineResultIcon");
        setDrawableColorByKey(chat_inlineResultAudio, "chat_inlineResultIcon");
        setDrawableColorByKey(chat_inlineResultLocation, "chat_inlineResultIcon");
        setDrawableColorByKey(chat_commentDrawable, "chat_inInstant");
        setDrawableColorByKey(chat_commentStickerDrawable, "chat_serviceIcon");
        setDrawableColorByKey(chat_commentArrowDrawable, "chat_inInstant");
        for (int i = 0; i < 2; i++) {
            setDrawableColorByKey(chat_msgInCallDrawable[i], "chat_inInstant");
            setDrawableColorByKey(chat_msgInCallSelectedDrawable[i], "chat_inInstantSelected");
            setDrawableColorByKey(chat_msgOutCallDrawable[i], "chat_outInstant");
            setDrawableColorByKey(chat_msgOutCallSelectedDrawable[i], "chat_outInstantSelected");
        }
        setDrawableColorByKey(chat_msgCallUpGreenDrawable, "chat_outUpCall");
        setDrawableColorByKey(chat_msgCallDownRedDrawable, "chat_inUpCall");
        setDrawableColorByKey(chat_msgCallDownGreenDrawable, "chat_inDownCall");
        setDrawableColorByKey(calllog_msgCallUpRedDrawable, "calls_callReceivedRedIcon");
        setDrawableColorByKey(calllog_msgCallUpGreenDrawable, "calls_callReceivedGreenIcon");
        setDrawableColorByKey(calllog_msgCallDownRedDrawable, "calls_callReceivedRedIcon");
        setDrawableColorByKey(calllog_msgCallDownGreenDrawable, "calls_callReceivedGreenIcon");
        setDrawableColorByKey(chat_eitaaPayDrawable, "chat_serviceIcon");
        int i2 = 0;
        while (true) {
            StatusDrawable[] statusDrawableArr = chat_status_drawables;
            if (i2 >= statusDrawableArr.length) {
                break;
            }
            setDrawableColorByKey(statusDrawableArr[i2], "chats_actionMessage");
            i2++;
        }
        for (int i3 = 0; i3 < 2; i3++) {
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i3][0], getColor("chat_outLoader"), false);
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i3][0], getColor("chat_outMediaIcon"), true);
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i3][1], getColor("chat_outLoaderSelected"), false);
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i3][1], getColor("chat_outMediaIconSelected"), true);
            int i4 = i3 + 2;
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i4][0], getColor("chat_inLoader"), false);
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i4][0], getColor("chat_inMediaIcon"), true);
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i4][1], getColor("chat_inLoaderSelected"), false);
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i4][1], getColor("chat_inMediaIconSelected"), true);
            int i5 = i3 + 4;
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i5][0], getColor("chat_mediaLoaderPhoto"), false);
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i5][0], getColor("chat_mediaLoaderPhotoIcon"), true);
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i5][1], getColor("chat_mediaLoaderPhotoSelected"), false);
            setCombinedDrawableColor(chat_fileMiniStatesDrawable[i5][1], getColor("chat_mediaLoaderPhotoIconSelected"), true);
        }
        for (int i6 = 0; i6 < 5; i6++) {
            setCombinedDrawableColor(chat_fileStatesDrawable[i6][0], getColor("chat_outLoader"), false);
            setCombinedDrawableColor(chat_fileStatesDrawable[i6][0], getColor("chat_outMediaIcon"), true);
            setCombinedDrawableColor(chat_fileStatesDrawable[i6][1], getColor("chat_outLoaderSelected"), false);
            setCombinedDrawableColor(chat_fileStatesDrawable[i6][1], getColor("chat_outMediaIconSelected"), true);
            int i7 = i6 + 5;
            setCombinedDrawableColor(chat_fileStatesDrawable[i7][0], getColor("chat_inLoader"), false);
            setCombinedDrawableColor(chat_fileStatesDrawable[i7][0], getColor("chat_inMediaIcon"), true);
            setCombinedDrawableColor(chat_fileStatesDrawable[i7][1], getColor("chat_inLoaderSelected"), false);
            setCombinedDrawableColor(chat_fileStatesDrawable[i7][1], getColor("chat_inMediaIconSelected"), true);
        }
        for (int i8 = 0; i8 < 4; i8++) {
            setCombinedDrawableColor(chat_photoStatesDrawables[i8][0], getColor("chat_mediaLoaderPhoto"), false);
            setCombinedDrawableColor(chat_photoStatesDrawables[i8][0], getColor("chat_mediaLoaderPhotoIcon"), true);
            setCombinedDrawableColor(chat_photoStatesDrawables[i8][1], getColor("chat_mediaLoaderPhotoSelected"), false);
            setCombinedDrawableColor(chat_photoStatesDrawables[i8][1], getColor("chat_mediaLoaderPhotoIconSelected"), true);
        }
        for (int i9 = 0; i9 < 2; i9++) {
            int i10 = i9 + 7;
            setCombinedDrawableColor(chat_photoStatesDrawables[i10][0], getColor("chat_outLoaderPhoto"), false);
            setCombinedDrawableColor(chat_photoStatesDrawables[i10][0], getColor("chat_outLoaderPhotoIcon"), true);
            setCombinedDrawableColor(chat_photoStatesDrawables[i10][1], getColor("chat_outLoaderPhotoSelected"), false);
            setCombinedDrawableColor(chat_photoStatesDrawables[i10][1], getColor("chat_outLoaderPhotoIconSelected"), true);
            int i11 = i9 + 10;
            setCombinedDrawableColor(chat_photoStatesDrawables[i11][0], getColor("chat_inLoaderPhoto"), false);
            setCombinedDrawableColor(chat_photoStatesDrawables[i11][0], getColor("chat_inLoaderPhotoIcon"), true);
            setCombinedDrawableColor(chat_photoStatesDrawables[i11][1], getColor("chat_inLoaderPhotoSelected"), false);
            setCombinedDrawableColor(chat_photoStatesDrawables[i11][1], getColor("chat_inLoaderPhotoIconSelected"), true);
        }
        setDrawableColorByKey(chat_photoStatesDrawables[9][0], "chat_outFileIcon");
        setDrawableColorByKey(chat_photoStatesDrawables[9][1], "chat_outFileSelectedIcon");
        setDrawableColorByKey(chat_photoStatesDrawables[12][0], "chat_inFileIcon");
        setDrawableColorByKey(chat_photoStatesDrawables[12][1], "chat_inFileSelectedIcon");
        setCombinedDrawableColor(chat_contactDrawable[0], getColor("chat_inContactBackground"), false);
        setCombinedDrawableColor(chat_contactDrawable[0], getColor("chat_inContactIcon"), true);
        setCombinedDrawableColor(chat_contactDrawable[1], getColor("chat_outContactBackground"), false);
        setCombinedDrawableColor(chat_contactDrawable[1], getColor("chat_outContactIcon"), true);
        setCombinedDrawableColor(chat_liveStreamDrawable[0], getColor("chat_inLocationBackground"), false);
        setCombinedDrawableColor(chat_liveStreamDrawable[0], getColor("chat_inLocationIcon"), true);
        setCombinedDrawableColor(chat_liveStreamDrawable[1], getColor("chat_outLocationBackground"), false);
        setCombinedDrawableColor(chat_liveStreamDrawable[1], getColor("chat_outLocationIcon"), true);
        setDrawableColor(chat_locationDrawable[0], getColor("chat_inLocationIcon"));
        setDrawableColor(chat_locationDrawable[1], getColor("chat_outLocationIcon"));
        setDrawableColor(chat_pollHintDrawable[0], getColor("chat_inPreviewInstantText"));
        setDrawableColor(chat_pollHintDrawable[1], getColor("chat_outPreviewInstantText"));
        setDrawableColor(chat_psaHelpDrawable[0], getColor("chat_inViews"));
        setDrawableColor(chat_psaHelpDrawable[1], getColor("chat_outViews"));
        setDrawableColorByKey(chat_composeShadowDrawable, "chat_messagePanelShadow");
        setDrawableColorByKey(chat_composeShadowRoundDrawable, "chat_messagePanelBackground");
        int color = getColor("chat_outAudioSeekbarFill") == -1 ? getColor("chat_outBubble") : -1;
        setDrawableColor(chat_pollCheckDrawable[1], color);
        setDrawableColor(chat_pollCrossDrawable[1], color);
        setDrawableColor(chat_attachEmptyDrawable, getColor("chat_attachEmptyImage"));
        if (!bg) {
            applyChatServiceMessageColor();
        }
        refreshAttachButtonsColors();
    }

    public static void applyChatServiceMessageColor() {
        applyChatServiceMessageColor(null, null, wallpaper);
    }

    public static boolean hasGradientService() {
        return serviceBitmapShader != null;
    }

    public static void applyServiceShaderMatrixForView(View view, View background) {
        if (view == null || background == null) {
            return;
        }
        view.getLocationOnScreen(viewPos);
        int[] iArr = viewPos;
        int i = iArr[0];
        int i2 = iArr[1];
        background.getLocationOnScreen(iArr);
        applyServiceShaderMatrix(background.getMeasuredWidth(), background.getMeasuredHeight(), i, i2 - viewPos[1]);
    }

    public static void applyServiceShaderMatrix(int w, int h, float translationX, float translationY) {
        applyServiceShaderMatrix(serviceBitmap, serviceBitmapShader, serviceBitmapMatrix, w, h, translationX, translationY);
    }

    public static void applyServiceShaderMatrix(Bitmap bitmap, BitmapShader shader, Matrix matrix, int w, int h, float translationX, float translationY) {
        if (shader == null) {
            return;
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float f = w;
        float f2 = h;
        float fMax = Math.max(f / width, f2 / height);
        matrix.reset();
        matrix.setTranslate(((f - (width * fMax)) / 2.0f) - translationX, ((f2 - (height * fMax)) / 2.0f) - translationY);
        matrix.preScale(fMax, fMax);
        shader.setLocalMatrix(matrix);
    }

    public static void applyChatServiceMessageColor(int[] custom, Drawable wallpaperOverride) {
        applyChatServiceMessageColor(custom, wallpaperOverride, wallpaper);
    }

    public static void applyChatServiceMessageColor(int[] custom, Drawable wallpaperOverride, Drawable currentWallpaper) {
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3;
        if (chat_actionBackgroundPaint == null) {
            return;
        }
        serviceMessageColor = serviceMessageColorBackup;
        serviceSelectedMessageColor = serviceSelectedMessageColorBackup;
        if (custom != null && custom.length >= 2) {
            numValueOf = Integer.valueOf(custom[0]);
            numValueOf2 = Integer.valueOf(custom[1]);
            serviceMessageColor = custom[0];
            serviceSelectedMessageColor = custom[1];
        } else {
            numValueOf = currentColors.get("chat_serviceBackground");
            numValueOf2 = currentColors.get("chat_serviceBackgroundSelected");
        }
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(serviceMessageColor);
            numValueOf3 = Integer.valueOf(serviceMessage2Color);
        } else {
            numValueOf3 = numValueOf;
        }
        Integer numValueOf4 = numValueOf2 == null ? Integer.valueOf(serviceSelectedMessageColor) : numValueOf2;
        if (numValueOf2 == null) {
            numValueOf2 = Integer.valueOf(serviceSelectedMessage2Color);
        }
        if (wallpaperOverride == null) {
            wallpaperOverride = currentWallpaper;
        }
        boolean z = wallpaperOverride instanceof MotionBackgroundDrawable;
        if (z) {
            Bitmap bitmap = ((MotionBackgroundDrawable) wallpaperOverride).getBitmap();
            if (serviceBitmap != bitmap) {
                serviceBitmap = bitmap;
                Bitmap bitmap2 = serviceBitmap;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                serviceBitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
                if (serviceBitmapMatrix == null) {
                    serviceBitmapMatrix = new Matrix();
                }
            }
            setDrawableColor(chat_msgStickerPinnedDrawable, -1);
            setDrawableColor(chat_msgStickerCheckDrawable, -1);
            setDrawableColor(chat_msgStickerHalfCheckDrawable, -1);
            setDrawableColor(chat_msgStickerViewsDrawable, -1);
            setDrawableColor(chat_msgStickerRepliesDrawable, -1);
            chat_actionTextPaint.setColor(-1);
            chat_actionTextPaint.linkColor = -1;
            chat_botButtonPaint.setColor(-1);
            setDrawableColor(chat_commentStickerDrawable, -1);
            setDrawableColor(chat_shareIconDrawable, -1);
            setDrawableColor(chat_replyIconDrawable, -1);
            setDrawableColor(chat_goIconDrawable, -1);
            setDrawableColor(chat_botInlineDrawable, -1);
            setDrawableColor(chat_botLinkDrawalbe, -1);
        } else {
            serviceBitmap = null;
            serviceBitmapShader = null;
            setDrawableColorByKey(chat_msgStickerPinnedDrawable, "chat_serviceText");
            setDrawableColorByKey(chat_msgStickerCheckDrawable, "chat_serviceText");
            setDrawableColorByKey(chat_msgStickerHalfCheckDrawable, "chat_serviceText");
            setDrawableColorByKey(chat_msgStickerViewsDrawable, "chat_serviceText");
            setDrawableColorByKey(chat_msgStickerRepliesDrawable, "chat_serviceText");
            chat_actionTextPaint.setColor(getColor("chat_serviceText"));
            chat_actionTextPaint.linkColor = getColor("chat_serviceLink");
            setDrawableColorByKey(chat_commentStickerDrawable, "chat_serviceIcon");
            setDrawableColorByKey(chat_shareIconDrawable, "chat_serviceIcon");
            setDrawableColorByKey(chat_replyIconDrawable, "chat_serviceIcon");
            setDrawableColorByKey(chat_goIconDrawable, "chat_serviceIcon");
            setDrawableColorByKey(chat_botInlineDrawable, "chat_serviceIcon");
            setDrawableColorByKey(chat_botLinkDrawalbe, "chat_serviceIcon");
            chat_botButtonPaint.setColor(getColor("chat_botButtonText"));
        }
        chat_actionBackgroundPaint.setColor(numValueOf.intValue());
        chat_actionBackgroundSelectedPaint.setColor(numValueOf4.intValue());
        chat_actionBackgroundPaint2.setColor(numValueOf3.intValue());
        chat_actionBackgroundSelectedPaint2.setColor(numValueOf2.intValue());
        currentColor = numValueOf.intValue();
        if (serviceBitmapShader != null && (currentColors.get("chat_serviceBackground") == null || z)) {
            chat_actionBackgroundPaint.setShader(serviceBitmapShader);
            chat_actionBackgroundSelectedPaint.setShader(serviceBitmapShader);
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(((MotionBackgroundDrawable) wallpaperOverride).getIntensity() >= 0 ? 1.8f : 0.5f);
            chat_actionBackgroundPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            chat_actionBackgroundPaint.setAlpha(127);
            chat_actionBackgroundSelectedPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            chat_actionBackgroundSelectedPaint.setAlpha(200);
            return;
        }
        chat_actionBackgroundPaint.setColorFilter(null);
        chat_actionBackgroundPaint.setShader(null);
        chat_actionBackgroundSelectedPaint.setColorFilter(null);
        chat_actionBackgroundSelectedPaint.setShader(null);
    }

    public static void createProfileResources(Context context) {
        if (profile_verifiedDrawable == null) {
            profile_aboutTextPaint = new TextPaint(1);
            Resources resources = context.getResources();
            profile_verifiedDrawable = resources.getDrawable(R.drawable.verified_area).mutate();
            profile_verifiedCheckDrawable = resources.getDrawable(R.drawable.verified_check).mutate();
            applyProfileTheme();
        }
        profile_aboutTextPaint.setTextSize(AndroidUtilities.dp(16.0f));
        updateProfileResourcesTypeFace();
    }

    public static void applyProfileTheme() {
        if (profile_verifiedDrawable == null) {
            return;
        }
        profile_aboutTextPaint.setColor(getColor("windowBackgroundWhiteBlackText"));
        profile_aboutTextPaint.linkColor = getColor("windowBackgroundWhiteLinkText");
        setDrawableColorByKey(profile_verifiedDrawable, "profile_verifiedBackground");
        setDrawableColorByKey(profile_verifiedCheckDrawable, "profile_verifiedCheck");
    }

    public static Drawable getThemedDrawable(Context context, int resId, String key) {
        return getThemedDrawable(context, resId, getColor(key));
    }

    public static Drawable getThemedDrawable(Context context, int resId, int color) {
        if (context == null) {
            return null;
        }
        Drawable drawableMutate = context.getResources().getDrawable(resId).mutate();
        drawableMutate.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        return drawableMutate;
    }

    public static int getDefaultColor(String key) {
        Integer num = defaultColors.get(key);
        if (num == null) {
            return (key.equals("chats_menuTopShadow") || key.equals("chats_menuTopBackground") || key.equals("chats_menuTopShadowCats") || key.equals("key_chat_wallpaper_gradient_to2") || key.equals("key_chat_wallpaper_gradient_to3")) ? 0 : -65536;
        }
        return num.intValue();
    }

    public static boolean hasThemeKey(String key) {
        return currentColors.containsKey(key);
    }

    public static Integer getColorOrNull(String key) {
        Integer num = currentColors.get(key);
        if (num == null) {
            if (fallbackKeys.get(key) != null) {
                num = currentColors.get(key);
            }
            if (num == null) {
                num = defaultColors.get(key);
            }
        }
        return num != null ? ("windowBackgroundWhite".equals(key) || "windowBackgroundGray".equals(key) || "actionBarDefault".equals(key) || "actionBarDefaultArchived".equals(key)) ? Integer.valueOf(num.intValue() | (-16777216)) : num : num;
    }

    public static void setAnimatingColor(boolean animating) {
        animatingColors = animating ? new HashMap<>() : null;
    }

    public static boolean isAnimatingColor() {
        return animatingColors != null;
    }

    public static void setAnimatedColor(String key, int value) {
        HashMap<String, Integer> map = animatingColors;
        if (map == null) {
            return;
        }
        map.put(key, Integer.valueOf(value));
    }

    public static int getDefaultAccentColor(String key) {
        ThemeAccent accent;
        Integer num = currentColorsNoAccent.get(key);
        if (num == null || (accent = currentTheme.getAccent(false)) == null) {
            return 0;
        }
        float[] tempHsv = getTempHsv(1);
        float[] tempHsv2 = getTempHsv(2);
        Color.colorToHSV(currentTheme.accentBaseColor, tempHsv);
        Color.colorToHSV(accent.accentColor, tempHsv2);
        return changeColorAccent(tempHsv, tempHsv2, num.intValue(), currentTheme.isDark());
    }

    public static int getNonAnimatedColor(String key) {
        return getColor(key, null, true);
    }

    public static int getColor(String key, ResourcesProvider provider) {
        Integer color;
        if (provider != null && (color = provider.getColor(key)) != null) {
            return color.intValue();
        }
        return getColor(key);
    }

    public static int getColor(String key) {
        return getColor(key, null, false);
    }

    public static int getColor(String key, boolean[] isDefault) {
        return getColor(key, isDefault, false);
    }

    public static int getColor(String key, boolean[] isDefault, boolean ignoreAnimation) {
        boolean zIsDefaultMyMessages;
        HashMap<String, Integer> map;
        Integer num;
        if (!ignoreAnimation && (map = animatingColors) != null && (num = map.get(key)) != null) {
            return num.intValue();
        }
        if (serviceBitmapShader != null && ("chat_serviceText".equals(key) || "chat_serviceLink".equals(key) || "chat_serviceIcon".equals(key) || "chat_stickerReplyLine".equals(key) || "chat_stickerReplyNameText".equals(key) || "chat_stickerReplyMessageText".equals(key))) {
            return -1;
        }
        if (currentTheme == defaultTheme) {
            if (myMessagesBubblesColorKeys.contains(key)) {
                zIsDefaultMyMessages = currentTheme.isDefaultMyMessagesBubbles();
            } else {
                zIsDefaultMyMessages = myMessagesColorKeys.contains(key) ? currentTheme.isDefaultMyMessages() : ("chat_wallpaper".equals(key) || "chat_wallpaper_gradient_to".equals(key) || "key_chat_wallpaper_gradient_to2".equals(key) || "key_chat_wallpaper_gradient_to3".equals(key)) ? false : currentTheme.isDefaultMainAccent();
            }
            if (zIsDefaultMyMessages) {
                if (key.equals("chat_serviceBackground")) {
                    return serviceMessageColor;
                }
                if (key.equals("chat_serviceBackgroundSelected")) {
                    return serviceSelectedMessageColor;
                }
                return getDefaultColor(key);
            }
        }
        Integer numValueOf = currentColors.get(key);
        if (numValueOf == null) {
            String str = fallbackKeys.get(key);
            if (str != null) {
                numValueOf = currentColors.get(str);
            }
            if (numValueOf == null) {
                if (isDefault != null) {
                    isDefault[0] = true;
                }
                if (key.equals("chat_serviceBackground")) {
                    return serviceMessageColor;
                }
                if (key.equals("chat_serviceBackgroundSelected")) {
                    return serviceSelectedMessageColor;
                }
                return getDefaultColor(key);
            }
        }
        if ("windowBackgroundWhite".equals(key) || "windowBackgroundGray".equals(key) || "actionBarDefault".equals(key) || "actionBarDefaultArchived".equals(key)) {
            numValueOf = Integer.valueOf(numValueOf.intValue() | (-16777216));
        }
        return numValueOf.intValue();
    }

    public static void setColor(String key, int color, boolean useDefault) {
        if (key.equals("chat_wallpaper") || key.equals("chat_wallpaper_gradient_to") || key.equals("key_chat_wallpaper_gradient_to2") || key.equals("key_chat_wallpaper_gradient_to3") || key.equals("windowBackgroundWhite") || key.equals("windowBackgroundGray") || key.equals("actionBarDefault") || key.equals("actionBarDefaultArchived")) {
            color |= -16777216;
        }
        if (useDefault) {
            currentColors.remove(key);
        } else {
            currentColors.put(key, Integer.valueOf(color));
        }
        switch (key) {
            case "chat_wallpaper_gradient_rotation":
            case "chat_wallpaper":
            case "chat_wallpaper_gradient_to":
            case "key_chat_wallpaper_gradient_to2":
            case "key_chat_wallpaper_gradient_to3":
                reloadWallpaper();
                break;
            case "windowBackgroundGray":
                if (Build.VERSION.SDK_INT >= 26) {
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needCheckSystemBarColors, new Object[0]);
                    break;
                }
                break;
            case "actionBarDefault":
                if (Build.VERSION.SDK_INT >= 23) {
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needCheckSystemBarColors, new Object[0]);
                    break;
                }
                break;
            case "chat_serviceBackground":
            case "chat_serviceBackgroundSelected":
                applyChatServiceMessageColor();
                break;
        }
    }

    public static void setDefaultColor(String key, int color) {
        defaultColors.put(key, Integer.valueOf(color));
    }

    public static void setThemeWallpaper(ThemeInfo themeInfo, Bitmap bitmap, File path) throws Throwable {
        currentColors.remove("chat_wallpaper");
        currentColors.remove("chat_wallpaper_gradient_to");
        currentColors.remove("key_chat_wallpaper_gradient_to2");
        currentColors.remove("key_chat_wallpaper_gradient_to3");
        currentColors.remove("chat_wallpaper_gradient_rotation");
        themedWallpaperLink = null;
        themeInfo.setOverrideWallpaper(null);
        if (bitmap != null) {
            themedWallpaper = new BitmapDrawable(bitmap);
            saveCurrentTheme(themeInfo, false, false, false);
            calcBackgroundColor(themedWallpaper, 0);
            applyChatServiceMessageColor();
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetNewWallpapper, new Object[0]);
            return;
        }
        themedWallpaper = null;
        wallpaper = null;
        saveCurrentTheme(themeInfo, false, false, false);
        reloadWallpaper();
    }

    public static void setDrawableColor(Drawable drawable, int color) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof StatusDrawable) {
            ((StatusDrawable) drawable).setColor(color);
            return;
        }
        if (drawable instanceof MsgClockDrawable) {
            ((MsgClockDrawable) drawable).setColor(color);
            return;
        }
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(color);
        } else if (drawable instanceof ScamDrawable) {
            ((ScamDrawable) drawable).setColor(color);
        } else {
            drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        }
    }

    public static void setDrawableColorByKey(Drawable drawable, String key) {
        if (key == null) {
            return;
        }
        setDrawableColor(drawable, getColor(key));
    }

    public static void setEmojiDrawableColor(Drawable drawable, int color, boolean selected) {
        Drawable stateDrawable;
        if (drawable instanceof StateListDrawable) {
            try {
                if (selected) {
                    stateDrawable = getStateDrawable(drawable, 0);
                } else {
                    stateDrawable = getStateDrawable(drawable, 1);
                }
                if (stateDrawable instanceof ShapeDrawable) {
                    ((ShapeDrawable) stateDrawable).getPaint().setColor(color);
                } else {
                    stateDrawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                }
            } catch (Throwable unused) {
            }
        }
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    @TargetApi(21)
    public static void setRippleDrawableForceSoftware(RippleDrawable drawable) {
        if (drawable == null) {
            return;
        }
        try {
            RippleDrawable.class.getDeclaredMethod("setForceSoftware", Boolean.TYPE).invoke(drawable, Boolean.TRUE);
        } catch (Throwable unused) {
        }
    }

    public static void setSelectorDrawableColor(Drawable drawable, int color, boolean selected) {
        Drawable stateDrawable;
        if (drawable instanceof StateListDrawable) {
            try {
                if (selected) {
                    Drawable stateDrawable2 = getStateDrawable(drawable, 0);
                    if (stateDrawable2 instanceof ShapeDrawable) {
                        ((ShapeDrawable) stateDrawable2).getPaint().setColor(color);
                    } else {
                        stateDrawable2.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                    }
                    stateDrawable = getStateDrawable(drawable, 1);
                } else {
                    stateDrawable = getStateDrawable(drawable, 2);
                }
                if (stateDrawable instanceof ShapeDrawable) {
                    ((ShapeDrawable) stateDrawable).getPaint().setColor(color);
                    return;
                } else {
                    stateDrawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 21 || !(drawable instanceof RippleDrawable)) {
            return;
        }
        RippleDrawable rippleDrawable = (RippleDrawable) drawable;
        if (selected) {
            rippleDrawable.setColor(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{color}));
            return;
        }
        if (rippleDrawable.getNumberOfLayers() > 0) {
            Drawable drawable2 = rippleDrawable.getDrawable(0);
            if (drawable2 instanceof ShapeDrawable) {
                ((ShapeDrawable) drawable2).getPaint().setColor(color);
            } else {
                drawable2.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
            }
        }
    }

    public static boolean isThemeWallpaperPublic() {
        return !TextUtils.isEmpty(themedWallpaperLink);
    }

    public static boolean hasWallpaperFromTheme() {
        ThemeInfo themeInfo = currentTheme;
        if (themeInfo.firstAccentIsDefault && themeInfo.currentAccentId == DEFALT_THEME_ACCENT_ID) {
            return false;
        }
        return currentColors.containsKey("chat_wallpaper") || themedWallpaperFileOffset > 0 || !TextUtils.isEmpty(themedWallpaperLink);
    }

    public static boolean isCustomTheme() {
        return isCustomTheme;
    }

    public static void reloadWallpaper() {
        BackgroundGradientDrawable.Disposable disposable = backgroundGradientDisposable;
        if (disposable != null) {
            disposable.dispose();
            backgroundGradientDisposable = null;
        }
        Drawable drawable = wallpaper;
        if (drawable instanceof MotionBackgroundDrawable) {
            previousPhase = ((MotionBackgroundDrawable) drawable).getPhase();
        } else {
            previousPhase = 0;
        }
        wallpaper = null;
        themedWallpaper = null;
        loadWallpaper();
    }

    private static void calcBackgroundColor(Drawable drawable, int save) {
        if (save != 2) {
            int[] iArrCalcDrawableColor = AndroidUtilities.calcDrawableColor(drawable);
            int i = iArrCalcDrawableColor[0];
            serviceMessageColorBackup = i;
            serviceMessageColor = i;
            int i2 = iArrCalcDrawableColor[1];
            serviceSelectedMessageColorBackup = i2;
            serviceSelectedMessageColor = i2;
            serviceMessage2Color = iArrCalcDrawableColor[2];
            serviceSelectedMessage2Color = iArrCalcDrawableColor[3];
        }
    }

    public static int getServiceMessageColor() {
        Integer num = currentColors.get("chat_serviceBackground");
        return num == null ? serviceMessageColor : num.intValue();
    }

    public static void loadWallpaper() {
        final File file;
        final TLRPC$Document tLRPC$Document;
        final boolean z;
        float f;
        float f2;
        TLRPC$ThemeSettings tLRPC$ThemeSettings;
        TLRPC$WallPaper tLRPC$WallPaper;
        int i;
        if (wallpaper != null) {
            return;
        }
        ThemeInfo themeInfo = currentTheme;
        final boolean z2 = themeInfo.firstAccentIsDefault && ((i = themeInfo.currentAccentId) == DEFALT_THEME_ACCENT_ID || i == DEFALT_THEME_ACCENT_ID_2);
        ThemeAccent accent = themeInfo.getAccent(false);
        TLRPC$Document tLRPC$Document2 = null;
        if (accent != null) {
            File pathToWallpaper = accent.getPathToWallpaper();
            boolean z3 = accent.patternMotion;
            TLRPC$TL_theme tLRPC$TL_theme = accent.info;
            if (tLRPC$TL_theme != null && (tLRPC$ThemeSettings = tLRPC$TL_theme.settings) != null && (tLRPC$WallPaper = tLRPC$ThemeSettings.wallpaper) != null) {
                tLRPC$Document2 = tLRPC$WallPaper.document;
            }
            tLRPC$Document = tLRPC$Document2;
            file = pathToWallpaper;
            z = z3;
        } else {
            file = null;
            tLRPC$Document = null;
            z = false;
        }
        ThemeInfo themeInfo2 = currentTheme;
        final OverrideWallpaperInfo overrideWallpaperInfo = themeInfo2.overrideWallpaper;
        if (overrideWallpaperInfo != null) {
            f2 = overrideWallpaperInfo.intensity;
        } else if (accent != null) {
            f2 = accent.patternIntensity;
        } else {
            f = themeInfo2.patternIntensity;
            final int i2 = (int) f;
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$kLpmXxvE5ygV1ISLIZj-oBJp9DA
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    Theme.lambda$loadWallpaper$6(overrideWallpaperInfo, file, i2, z2, z, tLRPC$Document);
                }
            };
            wallpaperLoadTask = runnable;
            dispatchQueue.postRunnable(runnable);
        }
        f = f2 * 100.0f;
        final int i22 = (int) f;
        DispatchQueue dispatchQueue2 = Utilities.searchQueue;
        Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$kLpmXxvE5ygV1ISLIZj-oBJp9DA
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                Theme.lambda$loadWallpaper$6(overrideWallpaperInfo, file, i22, z2, z, tLRPC$Document);
            }
        };
        wallpaperLoadTask = runnable2;
        dispatchQueue2.postRunnable(runnable2);
    }

    static /* synthetic */ void lambda$loadWallpaper$6(OverrideWallpaperInfo overrideWallpaperInfo, File file, int i, boolean z, boolean z2, TLRPC$Document tLRPC$Document) throws IOException {
        BackgroundDrawableSettings backgroundDrawableSettingsCreateBackgroundDrawable = createBackgroundDrawable(currentTheme, overrideWallpaperInfo, currentColors, file, themedWallpaperLink, themedWallpaperFileOffset, i, previousPhase, z, hasPreviousTheme, isApplyingAccent, z2, tLRPC$Document);
        Boolean bool = backgroundDrawableSettingsCreateBackgroundDrawable.isWallpaperMotion;
        isWallpaperMotion = bool != null ? bool.booleanValue() : isWallpaperMotion;
        Boolean bool2 = backgroundDrawableSettingsCreateBackgroundDrawable.isPatternWallpaper;
        isPatternWallpaper = bool2 != null ? bool2.booleanValue() : isPatternWallpaper;
        Boolean bool3 = backgroundDrawableSettingsCreateBackgroundDrawable.isCustomTheme;
        isCustomTheme = bool3 != null ? bool3.booleanValue() : isCustomTheme;
        patternIntensity = i;
        final Drawable drawable = backgroundDrawableSettingsCreateBackgroundDrawable.wallpaper;
        wallpaper = drawable != null ? drawable : wallpaper;
        calcBackgroundColor(drawable, 1);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$odqxIfdTXFUJ_PMxYyXrJSzJrhA
            @Override // java.lang.Runnable
            public final void run() {
                Theme.lambda$loadWallpaper$5(drawable);
            }
        });
    }

    static /* synthetic */ void lambda$loadWallpaper$5(Drawable drawable) {
        wallpaperLoadTask = null;
        createCommonChatResources();
        applyChatServiceMessageColor(null, null, drawable);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didSetNewWallpapper, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.eitaa.ui.ActionBar.Theme.BackgroundDrawableSettings createBackgroundDrawable(ir.eitaa.ui.ActionBar.Theme.ThemeInfo r13, java.util.HashMap<java.lang.String, java.lang.Integer> r14, java.lang.String r15, int r16) {
        /*
            r0 = r13
            boolean r1 = r0.firstAccentIsDefault
            r2 = 1
            r3 = 0
            if (r1 == 0) goto Lf
            int r1 = r0.currentAccentId
            int r4 = ir.eitaa.ui.ActionBar.Theme.DEFALT_THEME_ACCENT_ID
            if (r1 != r4) goto Lf
            r8 = 1
            goto L10
        Lf:
            r8 = 0
        L10:
            ir.eitaa.ui.ActionBar.Theme$ThemeAccent r1 = r13.getAccent(r3)
            if (r1 == 0) goto L1b
            java.io.File r4 = r1.getPathToWallpaper()
            goto L1c
        L1b:
            r4 = 0
        L1c:
            if (r1 == 0) goto L24
            boolean r5 = r1.patternMotion
            if (r5 == 0) goto L24
            r11 = 1
            goto L25
        L24:
            r11 = 0
        L25:
            ir.eitaa.ui.ActionBar.Theme$OverrideWallpaperInfo r2 = r0.overrideWallpaper
            r3 = 1120403456(0x42c80000, float:100.0)
            if (r2 == 0) goto L32
            float r1 = r2.intensity
        L2d:
            float r1 = r1 * r3
        L2f:
            int r1 = (int) r1
            r6 = r1
            goto L3b
        L32:
            if (r1 == 0) goto L37
            float r1 = r1.patternIntensity
            goto L2d
        L37:
            int r1 = r0.patternIntensity
            float r1 = (float) r1
            goto L2f
        L3b:
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = ir.eitaa.ui.ActionBar.Theme.currentColorsNoAccent
            java.lang.String r3 = "wallpaperFileOffset"
            java.lang.Object r1 = r1.get(r3)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L4d
            int r1 = r1.intValue()
            r5 = r1
            goto L4f
        L4d:
            r1 = -1
            r5 = -1
        L4f:
            r9 = 0
            r10 = 0
            r12 = 0
            r0 = r13
            r1 = r2
            r2 = r14
            r3 = r4
            r4 = r15
            r7 = r16
            ir.eitaa.ui.ActionBar.Theme$BackgroundDrawableSettings r0 = createBackgroundDrawable(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.createBackgroundDrawable(ir.eitaa.ui.ActionBar.Theme$ThemeInfo, java.util.HashMap, java.lang.String, int):ir.eitaa.ui.ActionBar.Theme$BackgroundDrawableSettings");
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x030b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.eitaa.ui.ActionBar.Theme.BackgroundDrawableSettings createBackgroundDrawable(ir.eitaa.ui.ActionBar.Theme.ThemeInfo r23, ir.eitaa.ui.ActionBar.Theme.OverrideWallpaperInfo r24, java.util.HashMap<java.lang.String, java.lang.Integer> r25, java.io.File r26, java.lang.String r27, int r28, int r29, int r30, boolean r31, boolean r32, boolean r33, boolean r34, ir.eitaa.tgnet.TLRPC$Document r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.createBackgroundDrawable(ir.eitaa.ui.ActionBar.Theme$ThemeInfo, ir.eitaa.ui.ActionBar.Theme$OverrideWallpaperInfo, java.util.HashMap, java.io.File, java.lang.String, int, int, int, boolean, boolean, boolean, boolean, ir.eitaa.tgnet.TLRPC$Document):ir.eitaa.ui.ActionBar.Theme$BackgroundDrawableSettings");
    }

    public static Drawable createDefaultWallpaper() {
        return createDefaultWallpaper(0, 0);
    }

    public static Drawable createDefaultWallpaper(int w, int h) {
        MotionBackgroundDrawable motionBackgroundDrawable = new MotionBackgroundDrawable(-2368069, -9722489, -2762611, -7817084, w != 0);
        if (w <= 0 || h <= 0) {
            Point point = AndroidUtilities.displaySize;
            w = Math.min(point.x, point.y);
            Point point2 = AndroidUtilities.displaySize;
            h = Math.max(point2.x, point2.y);
        }
        motionBackgroundDrawable.setPatternBitmap(34, SvgHelper.getBitmap(R.raw.eitaa_bg3, w, h, -16777216));
        motionBackgroundDrawable.setPatternColorFilter(motionBackgroundDrawable.getPatternColor());
        return motionBackgroundDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap loadScreenSizedBitmap(FileInputStream stream, int offset) throws IOException {
        float fMin;
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                int i = 1;
                options.inSampleSize = 1;
                options.inJustDecodeBounds = true;
                long j = offset;
                stream.getChannel().position(j);
                BitmapFactory.decodeStream(stream, null, options);
                float f = options.outWidth;
                float f2 = options.outHeight;
                int iDp = AndroidUtilities.dp(360.0f);
                int iDp2 = AndroidUtilities.dp(640.0f);
                if (iDp >= iDp2 && f > f2) {
                    fMin = Math.max(f / iDp, f2 / iDp2);
                } else {
                    fMin = Math.min(f / iDp, f2 / iDp2);
                }
                if (fMin < 1.2f) {
                    fMin = 1.0f;
                }
                options.inJustDecodeBounds = false;
                if (fMin > 1.0f && (f > iDp || f2 > iDp2)) {
                    do {
                        i *= 2;
                    } while (i * 2 < fMin);
                    options.inSampleSize = i;
                } else {
                    options.inSampleSize = (int) fMin;
                }
                stream.getChannel().position(j);
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(stream, null, options);
                try {
                    stream.close();
                } catch (Exception unused) {
                }
                return bitmapDecodeStream;
            } catch (Exception e) {
                FileLog.e(e);
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Exception unused2) {
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            if (stream != null) {
                try {
                    stream.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(3:4|(1:6)|(2:8|9)(4:10|(1:21)|(4:23|(1:25)(1:26)|27|(1:29))(1:(5:31|(1:33)(1:34)|(1:36)|37|38)(1:39))|40))(3:41|(2:43|(6:47|(1:49)(1:50)|51|107|(7:116|55|113|56|(2:58|(2:59|(2:120|63)(1:118)))(0)|64|(6:66|(1:68)(1:69)|70|114|71|75)(1:(4:77|111|78|82)(2:83|106)))|103))|52)|53|107|(0)|103|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x017a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x017b, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.drawable.Drawable getThemedWallpaper(final boolean r17, final android.view.View r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.Theme.getThemedWallpaper(boolean, android.view.View):android.graphics.drawable.Drawable");
    }

    public static String getSelectedBackgroundSlug() {
        OverrideWallpaperInfo overrideWallpaperInfo = currentTheme.overrideWallpaper;
        if (overrideWallpaperInfo != null) {
            return overrideWallpaperInfo.slug;
        }
        return hasWallpaperFromTheme() ? "t" : "d";
    }

    public static Drawable getCachedWallpaper() throws InterruptedException {
        Drawable drawable = themedWallpaper;
        if (drawable == null) {
            drawable = wallpaper;
        }
        if (drawable != null || wallpaperLoadTask == null) {
            return drawable;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$xXX-ywdCqM5leaxXkxy473i7s2A
            @Override // java.lang.Runnable
            public final void run() {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        Drawable drawable2 = themedWallpaper;
        return drawable2 != null ? drawable2 : wallpaper;
    }

    public static Drawable getCachedWallpaperNonBlocking() {
        Drawable drawable = themedWallpaper;
        return drawable != null ? drawable : wallpaper;
    }

    public static boolean isWallpaperMotion() {
        return isWallpaperMotion;
    }

    public static boolean isPatternWallpaper() {
        String selectedBackgroundSlug = getSelectedBackgroundSlug();
        return isPatternWallpaper || "CJz3BZ6YGEYBAAAABboWp6SAv04".equals(selectedBackgroundSlug) || "qeZWES8rGVIEAAAARfWlK1lnfiI".equals(selectedBackgroundSlug);
    }

    public static BackgroundGradientDrawable getCurrentGradientWallpaper() {
        int i;
        int i2;
        OverrideWallpaperInfo overrideWallpaperInfo = currentTheme.overrideWallpaper;
        if (overrideWallpaperInfo == null || (i = overrideWallpaperInfo.color) == 0 || (i2 = overrideWallpaperInfo.gradientColor1) == 0) {
            return null;
        }
        return new BackgroundGradientDrawable(BackgroundGradientDrawable.getGradientOrientation(overrideWallpaperInfo.rotation), new int[]{i, i2});
    }

    public static AudioVisualizerDrawable getCurrentAudiVisualizerDrawable() {
        if (chat_msgAudioVisualizeDrawable == null) {
            chat_msgAudioVisualizeDrawable = new AudioVisualizerDrawable();
        }
        return chat_msgAudioVisualizeDrawable;
    }

    public static void unrefAudioVisualizeDrawable(final MessageObject messageObject) {
        AudioVisualizerDrawable audioVisualizerDrawable = chat_msgAudioVisualizeDrawable;
        if (audioVisualizerDrawable == null) {
            return;
        }
        if (audioVisualizerDrawable.getParentView() == null || messageObject == null) {
            chat_msgAudioVisualizeDrawable.setParentView(null);
            return;
        }
        if (animatedOutVisualizerDrawables == null) {
            animatedOutVisualizerDrawables = new HashMap<>();
        }
        animatedOutVisualizerDrawables.put(messageObject, chat_msgAudioVisualizeDrawable);
        chat_msgAudioVisualizeDrawable.setWaveform(false, true, null);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$Theme$XgZyeFCopavrOygIXEfYKcQKrEY
            @Override // java.lang.Runnable
            public final void run() {
                Theme.lambda$unrefAudioVisualizeDrawable$7(messageObject);
            }
        }, 200L);
        chat_msgAudioVisualizeDrawable = null;
    }

    static /* synthetic */ void lambda$unrefAudioVisualizeDrawable$7(MessageObject messageObject) {
        AudioVisualizerDrawable audioVisualizerDrawableRemove = animatedOutVisualizerDrawables.remove(messageObject);
        if (audioVisualizerDrawableRemove != null) {
            audioVisualizerDrawableRemove.setParentView(null);
        }
    }

    public static AudioVisualizerDrawable getAnimatedOutAudioVisualizerDrawable(MessageObject messageObject) {
        HashMap<MessageObject, AudioVisualizerDrawable> map = animatedOutVisualizerDrawables;
        if (map == null || messageObject == null) {
            return null;
        }
        return map.get(messageObject);
    }

    public static StatusDrawable getChatStatusDrawable(int type) {
        if (type < 0 || type > 5) {
            return null;
        }
        StatusDrawable[] statusDrawableArr = chat_status_drawables;
        StatusDrawable statusDrawable = statusDrawableArr[type];
        if (statusDrawable != null) {
            return statusDrawable;
        }
        if (type == 0) {
            statusDrawableArr[0] = new TypingDotsDrawable(true);
        } else if (type == 1) {
            statusDrawableArr[1] = new RecordStatusDrawable(true);
        } else if (type == 2) {
            statusDrawableArr[2] = new SendingFileDrawable(true);
        } else if (type == 3) {
            statusDrawableArr[3] = new PlayingGameDrawable(true, null);
        } else if (type == 4) {
            statusDrawableArr[4] = new RoundStatusDrawable(true);
        } else if (type == 5) {
            statusDrawableArr[5] = new ChoosingStickerStatusDrawable(true);
        }
        StatusDrawable statusDrawable2 = chat_status_drawables[type];
        statusDrawable2.start();
        statusDrawable2.setColor(getColor("chats_actionMessage"));
        return statusDrawable2;
    }

    public static FragmentContextViewWavesDrawable getFragmentContextViewWavesDrawable() {
        if (fragmentContextViewWavesDrawable == null) {
            fragmentContextViewWavesDrawable = new FragmentContextViewWavesDrawable();
        }
        return fragmentContextViewWavesDrawable;
    }

    public static RoundVideoProgressShadow getRadialSeekbarShadowDrawable() {
        if (roundPlayDrawable == null) {
            roundPlayDrawable = new RoundVideoProgressShadow();
        }
        return roundPlayDrawable;
    }

    public static HashMap<String, String> getFallbackKeys() {
        return fallbackKeys;
    }

    public static String getFallbackKey(String key) {
        return fallbackKeys.get(key);
    }

    public static Map<String, Drawable> getThemeDrawablesMap() {
        return defaultChatDrawables;
    }

    public static Drawable getThemeDrawable(String drawableKey) {
        return defaultChatDrawables.get(drawableKey);
    }

    public static String getThemeDrawableColorKey(String drawableKey) {
        return defaultChatDrawableColorKeys.get(drawableKey);
    }

    public static Map<String, Paint> getThemePaintsMap() {
        return defaultChatPaints;
    }

    public static Paint getThemePaint(String paintKey) {
        return defaultChatPaints.get(paintKey);
    }

    public static String getThemePaintColorKey(String paintKey) {
        return defaultChatPaintColors.get(paintKey);
    }

    private static void addChatDrawable(String key, Drawable drawable, String colorKey) {
        defaultChatDrawables.put(key, drawable);
        if (colorKey != null) {
            defaultChatDrawableColorKeys.put(key, colorKey);
        }
    }

    private static void addChatPaint(String key, Paint paint, String colorKey) {
        defaultChatPaints.put(key, paint);
        if (colorKey != null) {
            defaultChatPaintColors.put(key, colorKey);
        }
    }

    public static void setColorToPaint(Paint paint, int color) {
        if (paint.getColor() != color) {
            paint.setColor(color);
        }
    }

    public static ThemeInfo getTheme() {
        String string;
        SharedPreferences mainSettings = MessagesController.getMainSettings(UserConfig.selectedAccount);
        String currentThemeType2 = getCurrentThemeType();
        currentThemeType = currentThemeType2;
        if (currentThemeType2.equals("Day")) {
            string = mainSettings.getString("day_theme", null);
        } else {
            string = mainSettings.getString("dark_theme", null);
        }
        ThemeInfo themeInfo = string != null ? themesDict.get(string) : null;
        return themeInfo == null ? themesDict.get("Blue") : themeInfo;
    }
}
