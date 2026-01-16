package org.rbmain.messenger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.CallLog;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.webkit.MimeTypeMap;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.math.MathUtils;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.android.internal.telephony.ITelephony;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.tasks.OnSuccessListener;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.DimensionHelper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.messenger.utils.CustomHtml;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_restrictionReason;
import org.rbmain.tgnet.TLRPC$TL_userContact_old2;
import org.rbmain.tgnet.TLRPC$TL_wallPaper;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WallPaperSettings;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.TextDetailSettingsCell;
import org.rbmain.ui.Components.BackgroundGradientDrawable;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.ForegroundColorSpanThemable;
import org.rbmain.ui.Components.ForegroundDetector;
import org.rbmain.ui.Components.HideViewAfterAnimation;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.PickerBottomLayout;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ShareAlert;
import org.rbmain.ui.Components.TypefaceSpan;
import org.rbmain.ui.ThemePreviewActivity;
import org.rbmain.ui.WallpapersListActivity;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class AndroidUtilities {
    public static Pattern BAD_CHARS_MESSAGE_PATTERN = null;
    public static Pattern BAD_CHARS_PATTERN = null;
    public static final int FLAG_TAG_ALL = 11;
    public static final int FLAG_TAG_BOLD = 2;
    public static final int FLAG_TAG_BR = 1;
    public static final int FLAG_TAG_COLOR = 4;
    public static final int FLAG_TAG_URL = 8;
    public static final int REPLACING_TAG_TYPE_BOLD = 1;
    public static final int REPLACING_TAG_TYPE_LINK = 0;
    public static final String TYPEFACE_COURIER_NEW_BOLD = "fonts/courier_new_bold.ttf";
    public static final String TYPEFACE_MERRIWEATHER_BOLD = "fonts/mw_bold.ttf";
    public static final String TYPEFACE_ROBOTO_MEDIUM = "fonts/rmedium.ttf";
    public static final String TYPEFACE_ROBOTO_MEDIUM_ITALIC = "fonts/rmediumitalic.ttf";
    public static final String TYPEFACE_ROBOTO_MONO = "fonts/rmono.ttf";
    public static Pattern WEB_URL;
    private static AccessibilityManager accessibilityManager;
    private static Boolean betaApp;
    private static RectF bitmapRect;
    private static CallReceiver callReceiver;
    private static char[] characters;
    private static HashSet<Character> charactersMap;
    private static int[] documentIcons;
    private static int[] documentMediaIcons;
    public static boolean firstConfigurationWas;
    private static WeakReference<BaseFragment> flagSecureFragment;
    private static boolean hasCallPermissions;
    public static boolean incorrectDisplaySizeFix;
    public static boolean isInMultiwindow;
    private static long lastUpdateCheckTime;
    public static int leftBaseline;
    private static Field mAttachInfoField;
    private static Field mStableInsetsField;
    private static HashMap<Window, ValueAnimator> navigationBarColorAnimators;
    static Point navigationBarPoint;
    public static final String[] numbersSignatureArray;
    private static Pattern pattern;
    private static String regexUrl;
    static int rnd;
    public static int roundMessageInset;
    public static int roundMessageSize;
    private static Paint roundPaint;
    public static int roundPlayingMessageSize;
    public static final Linkify.MatchFilter sUrlMatchFilter;
    private static Boolean standaloneApp;
    public static float touchSlop;
    private static Runnable unregisterRunnable;
    private static Pattern uriParse;
    public static boolean usingHardwareInput;
    private static Vibrator vibrator;
    private static final Hashtable<String, Typeface> typefaceCache = new Hashtable<>();
    private static int prevOrientation = -10;
    private static boolean waitingForSms = false;
    private static boolean waitingForCall = false;
    private static final Object smsLock = new Object();
    private static final Object callLock = new Object();
    public static int statusBarHeight = 0;
    public static float density = 1.0f;
    public static Point displaySize = new Point();
    public static float screenRefreshRate = 60.0f;
    public static float screenRefreshTime = 1000.0f / 60.0f;
    public static Integer photoSize = null;
    public static DisplayMetrics displayMetrics = new DisplayMetrics();
    public static DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
    public static AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
    public static OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
    private static Boolean isTablet = null;
    private static int adjustOwnerClassGuid = 0;
    public static final RectF rectTmp = new RectF();
    public static final Rect rectTmp2 = new Rect();

    /* loaded from: classes4.dex */
    public interface IntColorCallback {
        void run(int i);
    }

    public static void checkForUpdates() {
    }

    public static int compare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i > i2 ? 1 : -1;
    }

    public static int getMyLayerVersion(int i) {
        return i & 65535;
    }

    public static int getPeerLayerVersion(int i) {
        return (i >> 16) & 65535;
    }

    public static int getWallpaperRotation(int i, boolean z) {
        int i2 = z ? i + 180 : i - 180;
        while (i2 >= 360) {
            i2 -= 360;
        }
        while (i2 < 0) {
            i2 += 360;
        }
        return i2;
    }

    public static boolean isMapsInstalled(BaseFragment baseFragment) {
        return true;
    }

    public static boolean isValidWallChar(char c) {
        return c == '-' || c == '~';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$formatSpannableSimple$7(Integer num) {
        return "%s";
    }

    public static float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int lerp(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static float lerpAngle(float f, float f2, float f3) {
        return ((f + ((((((f2 - f) + 360.0f) + 180.0f) % 360.0f) - 180.0f) * f3)) + 360.0f) % 360.0f;
    }

    public static int setMyLayerVersion(int i, int i2) {
        return (i & (-65536)) | i2;
    }

    public static int setPeerLayerVersion(int i, int i2) {
        return (i & 65535) | (i2 << 16);
    }

    public static void startAppCenter(Activity activity) {
    }

    static {
        WEB_URL = null;
        BAD_CHARS_PATTERN = null;
        BAD_CHARS_MESSAGE_PATTERN = null;
        try {
            BAD_CHARS_PATTERN = Pattern.compile("[─-◿]");
            BAD_CHARS_MESSAGE_PATTERN = Pattern.compile("[\u2066-\u2067]+");
            WEB_URL = Pattern.compile("((?:(http|https|Http|Https|ton|tg):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:" + Pattern.compile("(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|" + Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))") + ")") + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        } catch (Exception e) {
            FileLog.e(e);
        }
        leftBaseline = isTablet() ? 80 : 72;
        checkDisplaySize(ApplicationLoader.applicationContext, null);
        documentIcons = new int[]{ir.medu.shad.R.drawable.media_doc_blue, ir.medu.shad.R.drawable.media_doc_green, ir.medu.shad.R.drawable.media_doc_red, ir.medu.shad.R.drawable.media_doc_yellow};
        documentMediaIcons = new int[]{ir.medu.shad.R.drawable.media_doc_blue_b, ir.medu.shad.R.drawable.media_doc_green_b, ir.medu.shad.R.drawable.media_doc_red_b, ir.medu.shad.R.drawable.media_doc_yellow_b};
        sUrlMatchFilter = new Linkify.MatchFilter() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda4
            @Override // android.text.util.Linkify.MatchFilter
            public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
                return AndroidUtilities.lambda$static$0(charSequence, i, i2);
            }
        };
        regexUrl = "((http|https)://)[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)";
        pattern = Pattern.compile("((http|https)://)[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)");
        hasCallPermissions = Build.VERSION.SDK_INT >= 23;
        numbersSignatureArray = new String[]{io.github.inflationx.calligraphy3.BuildConfig.FLAVOR, "K", "M", "G", "T", "P"};
        characters = new char[]{160, ' ', '!', '\"', '#', '%', '&', '\'', '(', ')', '*', ',', '-', '.', '/', ':', ';', '?', '@', '[', '\\', ']', '_', '{', '}', 161, 167, 171, 182, 183, 187, 191, 894, 903, 1370, 1371, 1372, 1373, 1374, 1375, 1417, 1418, 1470, 1472, 1475, 1478, 1523, 1524, 1545, 1546, 1548, 1549, 1563, 1566, 1567, 1642, 1643, 1644, 1645, 1748, 1792, 1793, 1794, 1795, 1796, 1797, 1798, 1799, 1800, 1801, 1802, 1803, 1804, 1805, 2039, 2040, 2041, 2096, 2097, 2098, 2099, 2100, 2101, 2102, 2103, 2104, 2105, 2106, 2107, 2108, 2109, 2110, 2142, 2404, 2405, 2416, 2557, 2678, 2800, 3191, 3204, 3572, 3663, 3674, 3675, 3844, 3845, 3846, 3847, 3848, 3849, 3850, 3851, 3852, 3853, 3854, 3855, 3856, 3857, 3858, 3860, 3898, 3899, 3900, 3901, 3973, 4048, 4049, 4050, 4051, 4052, 4057, 4058, 4170, 4171, 4172, 4173, 4174, 4175, 4347, 4960, 4961, 4962, 4963, 4964, 4965, 4966, 4967, 4968, 5120, 5742, 5787, 5788, 5867, 5868, 5869, 5941, 5942, 6100, 6101, 6102, 6104, 6105, 6106, 6144, 6145, 6146, 6147, 6148, 6149, 6150, 6151, 6152, 6153, 6154, 6468, 6469, 6686, 6687, 6816, 6817, 6818, 6819, 6820, 6821, 6822, 6824, 6825, 6826, 6827, 6828, 6829, 7002, 7003, 7004, 7005, 7006, 7007, 7008, 7164, 7165, 7166, 7167, 7227, 7228, 7229, 7230, 7231, 7294, 7295, 7360, 7361, 7362, 7363, 7364, 7365, 7366, 7367, 7379, 8208, 8209, 8210, 8211, 8212, 8213, 8214, 8215, 8216, 8217, 8218, 8219, 8220, 8221, 8222, 8223, 8224, 8225, 8226, 8227, 8228, 8229, 8230, 8231, 8240, 8241, 8242, 8243, 8244, 8245, 8246, 8247, 8248, 8249, 8250, 8251, 8252, 8253, 8254, 8255, 8256, 8257, 8258, 8259, 8261, 8262, 8263, 8264, 8265, 8266, 8267, 8268, 8269, 8270, 8271, 8272, 8273, 8275, 8276, 8277, 8278, 8279, 8280, 8281, 8282, 8283, 8284, 8285, 8286, 8317, 8318, 8333, 8334, 8968, 8969, 8970, 8971, 9001, 9002, 10088, 10089, 10090, 10091, 10092, 10093, 10094, 10095, 10096, 10097, 10098, 10099, 10100, 10101, 10181, 10182, 10214, 10215, 10216, 10217, 10218, 10219, 10220, 10221, 10222, 10223, 10627, 10628, 10629, 10630, 10631, 10632, 10633, 10634, 10635, 10636, 10637, 10638, 10639, 10640, 10641, 10642, 10643, 10644, 10645, 10646, 10647, 10648, 10712, 10713, 10714, 10715, 10748, 10749, 11513, 11514, 11515, 11516, 11518, 11519, 11632, 11776, 11777, 11778, 11779, 11780, 11781, 11782, 11783, 11784, 11785, 11786, 11787, 11788, 11789, 11790, 11791, 11792, 11793, 11794, 11795, 11796, 11797, 11798, 11799, 11800, 11801, 11802, 11803, 11804, 11805, 11806, 11807, 11808, 11809, 11810, 11811, 11812, 11813, 11814, 11815, 11816, 11817, 11818, 11819, 11820, 11821, 11822, 11824, 11825, 11826, 11827, 11828, 11829, 11830, 11831, 11832, 11833, 11834, 11835, 11836, 11837, 11838, 11839, 11840, 11841, 11842, 11843, 11844, 11845, 11846, 11847, 11848, 11849, 11850, 11851, 11852, 11853, 11854, 11855, 12289, 12290, 12291, 12296, 12297, 12298, 12299, 12300, 12301, 12302, 12303, 12304, 12305, 12308, 12309, 12310, 12311, 12312, 12313, 12314, 12315, 12316, 12317, 12318, 12319, 12336, 12349, 12448, 12539, 42238, 42239, 42509, 42510, 42511, 42611, 42622, 42738, 42739, 42740, 42741, 42742, 42743, 43124, 43125, 43126, 43127, 43214, 43215, 43256, 43257, 43258, 43260, 43310, 43311, 43359, 43457, 43458, 43459, 43460, 43461, 43462, 43463, 43464, 43465, 43466, 43467, 43468, 43469, 43486, 43487, 43612, 43613, 43614, 43615, 43742, 43743, 43760, 43761, 44011, 64830, 64831, 65040, 65041, 65042, 65043, 65044, 65045, 65046, 65047, 65048, 65049, 65072, 65073, 65074, 65075, 65076, 65077, 65078, 65079, 65080, 65081, 65082, 65083, 65084, 65085, 65086, 65087, 65088, 65089, 65090, 65091, 65092, 65093, 65094, 65095, 65096, 65097, 65098, 65099, 65100, 65101, 65102, 65103, 65104, 65105, 65106, 65108, 65109, 65110, 65111, 65112, 65113, 65114, 65115, 65116, 65117, 65118, 65119, 65120, 65121, 65123, 65128, 65130, 65131, 65281, 65282, 65283, 65285, 65286, 65287, 65288, 65289, 65290, 65292, 65293, 65294, 65295, 65306, 65307, 65311, 65312, 65339, 65340, 65341, 65343, 65371, 65373, 65375, 65376, 65377, 65378, 65379, 65380, 65381};
        rnd = 0;
        navigationBarPoint = null;
    }

    private static boolean containsUnsupportedCharacters(String str) {
        return str.contains("\u202c") || str.contains("\u202d") || str.contains("\u202e");
    }

    public static File generateAudioPath() {
        try {
            File albumDir = getAlbumDir(false);
            Date date = new Date();
            date.setTime(System.currentTimeMillis() + Utilities.random.nextInt(CloseCodes.NORMAL_CLOSURE) + 1);
            return new File(albumDir, "Audio_" + new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(date) + ".mp3");
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static String getSafeString(String str) {
        try {
            return BAD_CHARS_MESSAGE_PATTERN.matcher(str).replaceAll("\u200c");
        } catch (Throwable unused) {
            return str;
        }
    }

    public static CharSequence ellipsizeCenterEnd(CharSequence charSequence, String str, int i, TextPaint textPaint, int i2) {
        int iIndexOf;
        StaticLayout staticLayout;
        float lineWidth;
        float f;
        CharSequence charSequenceSubSequence;
        try {
            int length = charSequence.length();
            iIndexOf = charSequence.toString().toLowerCase().indexOf(str);
            if (length > i2) {
                charSequence = charSequence.subSequence(Math.max(0, iIndexOf - (i2 / 2)), Math.min(length, (i2 / 2) + iIndexOf));
                iIndexOf -= Math.max(0, iIndexOf - (i2 / 2));
                charSequence.length();
            }
            staticLayout = new StaticLayout(charSequence, textPaint, ConnectionsManager.DEFAULT_DATACENTER_ID, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            lineWidth = staticLayout.getLineWidth(0);
            f = i;
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (textPaint.measureText("...") + lineWidth < f) {
            return charSequence;
        }
        int i3 = iIndexOf + 1;
        int i4 = i3;
        while (i4 < charSequence.length() - 1 && !Character.isWhitespace(charSequence.charAt(i4))) {
            i4++;
        }
        float primaryHorizontal = staticLayout.getPrimaryHorizontal(i4);
        if (staticLayout.isRtlCharAt(i4)) {
            primaryHorizontal = lineWidth - primaryHorizontal;
        }
        if (primaryHorizontal < f) {
            return charSequence;
        }
        float fMeasureText = (primaryHorizontal - f) + (textPaint.measureText("...") * 2.0f);
        float f2 = 0.1f * f;
        float f3 = fMeasureText + f2;
        if (charSequence.length() - i4 > 20) {
            f3 += f2;
        }
        if (f3 > 0.0f) {
            int offsetForHorizontal = staticLayout.getOffsetForHorizontal(0, f3);
            if (offsetForHorizontal > charSequence.length() - 1) {
                offsetForHorizontal = charSequence.length() - 1;
            }
            int i5 = 0;
            while (true) {
                if (Character.isWhitespace(charSequence.charAt(offsetForHorizontal)) || i5 >= 10) {
                    break;
                }
                i5++;
                offsetForHorizontal++;
                if (offsetForHorizontal > charSequence.length() - 1) {
                    offsetForHorizontal = staticLayout.getOffsetForHorizontal(0, f3);
                    break;
                }
            }
            if (i5 >= 10) {
                charSequenceSubSequence = charSequence.subSequence(staticLayout.getOffsetForHorizontal(0, staticLayout.getPrimaryHorizontal(i3) - (f * 0.3f)), charSequence.length());
            } else {
                if (offsetForHorizontal > 0 && offsetForHorizontal < charSequence.length() - 2 && Character.isWhitespace(charSequence.charAt(offsetForHorizontal))) {
                    offsetForHorizontal++;
                }
                charSequenceSubSequence = charSequence.subSequence(offsetForHorizontal, charSequence.length());
            }
            return SpannableStringBuilder.valueOf("...").append(charSequenceSubSequence);
        }
        return charSequence;
    }

    public static CharSequence highlightText(CharSequence charSequence, ArrayList<String> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            CharSequence charSequenceHighlightText = highlightText(charSequence, arrayList.get(i2));
            if (charSequenceHighlightText != null) {
                charSequence = charSequenceHighlightText;
            } else {
                i++;
            }
        }
        if (i == arrayList.size()) {
            return null;
        }
        return charSequence;
    }

    public static CharSequence highlightText(CharSequence charSequence, String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(charSequence)) {
            return null;
        }
        String lowerCase = charSequence.toString().toLowerCase();
        SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(charSequence);
        int iIndexOf = lowerCase.indexOf(str);
        while (iIndexOf >= 0) {
            try {
                spannableStringBuilderValueOf.setSpan(new ForegroundColorSpanThemable(Theme.key_windowBackgroundWhiteBlueText4), iIndexOf, Math.min(str.length() + iIndexOf, charSequence.length()), 0);
            } catch (Exception e) {
                FileLog.e(e);
            }
            iIndexOf = lowerCase.indexOf(str, iIndexOf + 1);
        }
        return spannableStringBuilderValueOf;
    }

    public static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return findActivity(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    public static long getNextRnd(int i) {
        return AccountInstance.getInstance(i).getCoreMainClass().getRnd();
    }

    public static boolean isActivityRunning(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return (activity.isDestroyed() || activity.isFinishing()) ? false : true;
        }
        return !activity.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    static class LinkSpec {
        int end;
        int start;
        String url;

        private LinkSpec() {
        }
    }

    public static boolean isStandaloneApp() {
        if (standaloneApp == null) {
            standaloneApp = Boolean.valueOf("org.rbmain.messenger.web".equals(ApplicationLoader.applicationContext.getPackageName()));
        }
        return standaloneApp.booleanValue();
    }

    public static boolean isBetaApp() {
        if (betaApp == null) {
            betaApp = Boolean.valueOf("org.rbmain.messenger.beta".equals(ApplicationLoader.applicationContext.getPackageName()));
        }
        return betaApp.booleanValue();
    }

    private static String makeUrl(String str, String[] strArr, Matcher matcher) {
        boolean z;
        int i = 0;
        while (true) {
            z = true;
            if (i >= strArr.length) {
                z = false;
                break;
            }
            if (!str.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                i++;
            } else if (!str.regionMatches(false, 0, strArr[i], 0, strArr[i].length())) {
                str = strArr[i] + str.substring(strArr[i].length());
            }
        }
        if (z || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern2, String[] strArr, Linkify.MatchFilter matchFilter, boolean z) {
        if (TextUtils.indexOf((CharSequence) spannable, (char) 9472) >= 0) {
            spannable = new SpannableStringBuilder(spannable.toString().replace((char) 9472, ' '));
        }
        Matcher matcher = pattern2.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                LinkSpec linkSpec = new LinkSpec();
                String strMakeUrl = makeUrl(matcher.group(0), strArr, matcher);
                if (!z || Browser.isInternalUrl(strMakeUrl, true, null)) {
                    linkSpec.url = strMakeUrl;
                    linkSpec.start = iStart;
                    linkSpec.end = iEnd;
                    arrayList.add(linkSpec);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(CharSequence charSequence, int i, int i2) {
        return i == 0 || charSequence.charAt(i - 1) != '@';
    }

    public static boolean addLinks(Spannable spannable, int i) {
        return addLinks(spannable, i, false);
    }

    public static boolean addLinks(Spannable spannable, int i, boolean z) {
        if (spannable == null || containsUnsupportedCharacters(spannable.toString()) || i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        ArrayList arrayList = new ArrayList();
        if (!z && (i & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        if ((i & 1) != 0) {
            gatherLinks(arrayList, spannable, LinkifyPort.WEB_URL, new String[]{"http://", "https://", "ton://"}, sUrlMatchFilter, z);
        }
        pruneOverlaps(arrayList);
        if (arrayList.size() == 0) {
            return false;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            LinkSpec linkSpec = (LinkSpec) arrayList.get(i2);
            URLSpan[] uRLSpanArr2 = (URLSpan[]) spannable.getSpans(linkSpec.start, linkSpec.end, URLSpan.class);
            if (uRLSpanArr2 != null && uRLSpanArr2.length > 0) {
                for (URLSpan uRLSpan : uRLSpanArr2) {
                    spannable.removeSpan(uRLSpan);
                }
            }
            spannable.setSpan(new URLSpan(linkSpec.url), linkSpec.start, linkSpec.end, 33);
        }
        return true;
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> arrayList) {
        int i;
        Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda13
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AndroidUtilities.lambda$pruneOverlaps$1((AndroidUtilities.LinkSpec) obj, (AndroidUtilities.LinkSpec) obj2);
            }
        });
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size - 1) {
            LinkSpec linkSpec = arrayList.get(i2);
            int i3 = i2 + 1;
            LinkSpec linkSpec2 = arrayList.get(i3);
            int i4 = linkSpec.start;
            int i5 = linkSpec2.start;
            if (i4 <= i5 && (i = linkSpec.end) > i5) {
                int i6 = linkSpec2.end;
                int i7 = (i6 > i && i - i4 <= i6 - i5) ? i - i4 < i6 - i5 ? i2 : -1 : i3;
                if (i7 != -1) {
                    arrayList.remove(i7);
                    size--;
                }
            }
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$pruneOverlaps$1(LinkSpec linkSpec, LinkSpec linkSpec2) {
        int i;
        int i2;
        int i3 = linkSpec.start;
        int i4 = linkSpec2.start;
        if (i3 < i4) {
            return -1;
        }
        if (i3 <= i4 && (i = linkSpec.end) >= (i2 = linkSpec2.end)) {
            return i > i2 ? -1 : 0;
        }
        return 1;
    }

    public static void fillStatusBarHeight(Context context) {
        int identifier;
        if (context == null || statusBarHeight > 0 || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return;
        }
        statusBarHeight = context.getResources().getDimensionPixelSize(identifier);
    }

    public static int getThumbForNameOrMime(String str, String str2, boolean z) {
        int iCharAt;
        if (str == null || str.length() == 0) {
            return z ? documentMediaIcons[0] : documentIcons[0];
        }
        if (str.contains(".doc") || str.contains(".txt") || str.contains(".psd")) {
            iCharAt = 0;
        } else if (str.contains(".xls") || str.contains(".csv")) {
            iCharAt = 1;
        } else if (str.contains(".pdf") || str.contains(".ppt") || str.contains(".key")) {
            iCharAt = 2;
        } else {
            iCharAt = (str.contains(".zip") || str.contains(".rar") || str.contains(".ai") || str.contains(".mp3") || str.contains(".mov") || str.contains(".avi")) ? 3 : -1;
        }
        if (iCharAt == -1) {
            int iLastIndexOf = str.lastIndexOf(46);
            String strSubstring = iLastIndexOf == -1 ? io.github.inflationx.calligraphy3.BuildConfig.FLAVOR : str.substring(iLastIndexOf + 1);
            if (strSubstring.length() != 0) {
                iCharAt = strSubstring.charAt(0) % documentIcons.length;
            } else {
                iCharAt = str.charAt(0) % documentIcons.length;
            }
        }
        return z ? documentMediaIcons[iCharAt] : documentIcons[iCharAt];
    }

    public static int calcBitmapColor(Bitmap bitmap) {
        try {
            Bitmap bitmapCreateScaledBitmap = Bitmaps.createScaledBitmap(bitmap, 1, 1, true);
            if (bitmapCreateScaledBitmap != null) {
                int pixel = bitmapCreateScaledBitmap.getPixel(0, 0);
                if (bitmap != bitmapCreateScaledBitmap) {
                    bitmapCreateScaledBitmap.recycle();
                }
                return pixel;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        return 0;
    }

    public static int[] calcDrawableColor(Drawable drawable) {
        int[] colorsList;
        int averageColor;
        int[] iArr = new int[4];
        int i = -16777216;
        try {
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (drawable instanceof BitmapDrawable) {
            averageColor = calcBitmapColor(((BitmapDrawable) drawable).getBitmap());
        } else if (drawable instanceof ColorDrawable) {
            averageColor = ((ColorDrawable) drawable).getColor();
        } else {
            if ((drawable instanceof BackgroundGradientDrawable) && (colorsList = ((BackgroundGradientDrawable) drawable).getColorsList()) != null) {
                if (colorsList.length > 1) {
                    averageColor = getAverageColor(colorsList[0], colorsList[1]);
                } else if (colorsList.length > 0) {
                    averageColor = colorsList[0];
                }
            }
            double[] dArrRgbToHsv = rgbToHsv((i >> 16) & 255, (i >> 8) & 255, i & 255);
            dArrRgbToHsv[1] = Math.min(1.0d, dArrRgbToHsv[1] + 0.05d + ((1.0d - dArrRgbToHsv[1]) * 0.1d));
            int[] iArrHsvToRgb = hsvToRgb(dArrRgbToHsv[0], dArrRgbToHsv[1], Math.max(0.0d, dArrRgbToHsv[2] * 0.65d));
            iArr[0] = Color.argb(102, iArrHsvToRgb[0], iArrHsvToRgb[1], iArrHsvToRgb[2]);
            iArr[1] = Color.argb(136, iArrHsvToRgb[0], iArrHsvToRgb[1], iArrHsvToRgb[2]);
            int[] iArrHsvToRgb2 = hsvToRgb(dArrRgbToHsv[0], dArrRgbToHsv[1], Math.max(0.0d, dArrRgbToHsv[2] * 0.72d));
            iArr[2] = Color.argb(102, iArrHsvToRgb2[0], iArrHsvToRgb2[1], iArrHsvToRgb2[2]);
            iArr[3] = Color.argb(136, iArrHsvToRgb2[0], iArrHsvToRgb2[1], iArrHsvToRgb2[2]);
            return iArr;
        }
        i = averageColor;
        double[] dArrRgbToHsv2 = rgbToHsv((i >> 16) & 255, (i >> 8) & 255, i & 255);
        dArrRgbToHsv2[1] = Math.min(1.0d, dArrRgbToHsv2[1] + 0.05d + ((1.0d - dArrRgbToHsv2[1]) * 0.1d));
        int[] iArrHsvToRgb3 = hsvToRgb(dArrRgbToHsv2[0], dArrRgbToHsv2[1], Math.max(0.0d, dArrRgbToHsv2[2] * 0.65d));
        iArr[0] = Color.argb(102, iArrHsvToRgb3[0], iArrHsvToRgb3[1], iArrHsvToRgb3[2]);
        iArr[1] = Color.argb(136, iArrHsvToRgb3[0], iArrHsvToRgb3[1], iArrHsvToRgb3[2]);
        int[] iArrHsvToRgb22 = hsvToRgb(dArrRgbToHsv2[0], dArrRgbToHsv2[1], Math.max(0.0d, dArrRgbToHsv2[2] * 0.72d));
        iArr[2] = Color.argb(102, iArrHsvToRgb22[0], iArrHsvToRgb22[1], iArrHsvToRgb22[2]);
        iArr[3] = Color.argb(136, iArrHsvToRgb22[0], iArrHsvToRgb22[1], iArrHsvToRgb22[2]);
        return iArr;
    }

    public static double[] rgbToHsv(int i) {
        return rgbToHsv(Color.red(i), Color.green(i), Color.blue(i));
    }

    public static double[] rgbToHsv(int i, int i2, int i3) {
        double d;
        double d2;
        double d3;
        double d4 = i;
        Double.isNaN(d4);
        double d5 = d4 / 255.0d;
        double d6 = i2;
        Double.isNaN(d6);
        double d7 = d6 / 255.0d;
        double d8 = i3;
        Double.isNaN(d8);
        double d9 = d8 / 255.0d;
        double dMax = (d5 <= d7 || d5 <= d9) ? Math.max(d7, d9) : d5;
        double dMin = (d5 >= d7 || d5 >= d9) ? Math.min(d7, d9) : d5;
        double d10 = dMax - dMin;
        double d11 = 0.0d;
        double d12 = dMax == 0.0d ? 0.0d : d10 / dMax;
        if (dMax != dMin) {
            if (d5 > d7 && d5 > d9) {
                d = (d7 - d9) / d10;
                d2 = d7 < d9 ? 6 : 0;
                Double.isNaN(d2);
            } else if (d7 > d9) {
                d3 = 2.0d + ((d9 - d5) / d10);
                d11 = d3 / 6.0d;
            } else {
                d = (d5 - d7) / d10;
                d2 = 4.0d;
            }
            d3 = d + d2;
            d11 = d3 / 6.0d;
        }
        return new double[]{d11, d12, dMax};
    }

    public static int hsvToColor(double d, double d2, double d3) {
        int[] iArrHsvToRgb = hsvToRgb(d, d2, d3);
        return Color.argb(255, iArrHsvToRgb[0], iArrHsvToRgb[1], iArrHsvToRgb[2]);
    }

    public static int[] hsvToRgb(double d, double d2, double d3) {
        double d4 = 6.0d * d;
        double dFloor = (int) Math.floor(d4);
        Double.isNaN(dFloor);
        double d5 = d4 - dFloor;
        double d6 = (1.0d - d2) * d3;
        double d7 = (1.0d - (d5 * d2)) * d3;
        double d8 = d3 * (1.0d - ((1.0d - d5) * d2));
        int i = ((int) dFloor) % 6;
        double d9 = 0.0d;
        if (i != 0) {
            if (i == 1) {
                d9 = d3;
                d8 = d6;
                d6 = d7;
            } else if (i == 2) {
                d9 = d3;
            } else if (i == 3) {
                d8 = d3;
                d9 = d7;
            } else if (i == 4) {
                d9 = d6;
                d6 = d8;
                d8 = d3;
            } else if (i != 5) {
                d8 = 0.0d;
                d6 = 0.0d;
            } else {
                d9 = d6;
                d8 = d7;
            }
            return new int[]{(int) (d6 * 255.0d), (int) (d9 * 255.0d), (int) (d8 * 255.0d)};
        }
        d9 = d8;
        d8 = d6;
        d6 = d3;
        return new int[]{(int) (d6 * 255.0d), (int) (d9 * 255.0d), (int) (d8 * 255.0d)};
    }

    public static void adjustSaturationColorMatrix(ColorMatrix colorMatrix, float f) {
        if (colorMatrix == null) {
            return;
        }
        float f2 = f + 1.0f;
        float f3 = 1.0f - f2;
        float f4 = 0.3086f * f3;
        float f5 = 0.6094f * f3;
        float f6 = f3 * 0.082f;
        colorMatrix.postConcat(new ColorMatrix(new float[]{f4 + f2, f5, f6, 0.0f, 0.0f, f4, f5 + f2, f6, 0.0f, 0.0f, f4, f5, f6 + f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
    }

    public static void adjustBrightnessColorMatrix(ColorMatrix colorMatrix, float f) {
        if (colorMatrix == null) {
            return;
        }
        float f2 = f * 255.0f;
        colorMatrix.postConcat(new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 1.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 1.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
    }

    public static void requestAdjustResize(Activity activity, int i) {
        if (activity == null || isTablet()) {
            return;
        }
        activity.getWindow().setSoftInputMode(16);
        adjustOwnerClassGuid = i;
    }

    public static void requestAdjustNothing(Activity activity, int i) {
        if (activity == null || isTablet()) {
            return;
        }
        activity.getWindow().setSoftInputMode(48);
        adjustOwnerClassGuid = i;
    }

    public static void setAdjustResizeToNothing(Activity activity, int i) {
        if (activity == null || isTablet()) {
            return;
        }
        int i2 = adjustOwnerClassGuid;
        if (i2 == 0 || i2 == i) {
            activity.getWindow().setSoftInputMode(48);
        }
    }

    public static void removeAdjustResize(Activity activity, int i) {
        if (activity == null || isTablet() || adjustOwnerClassGuid != i) {
            return;
        }
        activity.getWindow().setSoftInputMode(32);
    }

    public static void createEmptyFile(File file) {
        try {
            if (file.exists()) {
                return;
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.flush();
            fileWriter.close();
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    public static boolean isGoogleMapsInstalled(final BaseFragment baseFragment) throws PackageManager.NameNotFoundException {
        try {
            ApplicationLoader.applicationContext.getPackageManager().getApplicationInfo("com.google.android.apps.maps", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            if (baseFragment.getParentActivity() == null) {
                return false;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getParentActivity());
            builder.setMessage(LocaleController.getString("InstallGoogleMaps", ir.medu.shad.R.string.InstallGoogleMaps));
            builder.setPositiveButton(LocaleController.getString("OK", ir.medu.shad.R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AndroidUtilities.lambda$isGoogleMapsInstalled$2(baseFragment, dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", ir.medu.shad.R.string.Cancel), null);
            baseFragment.showDialog(builder.create());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isGoogleMapsInstalled$2(BaseFragment baseFragment, DialogInterface dialogInterface, int i) {
        try {
            baseFragment.getParentActivity().startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.maps")), HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static int[] toIntArray(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    public static boolean isInternalUri(Uri uri) {
        return isInternalUri(uri, 0);
    }

    public static boolean isInternalUri(int i) {
        return isInternalUri(null, i);
    }

    private static boolean isInternalUri(Uri uri, int i) throws IOException {
        String path;
        if (uri != null) {
            path = uri.getPath();
            if (path == null) {
                return false;
            }
            if (path.matches(Pattern.quote(new File(ApplicationLoader.applicationContext.getCacheDir(), "voip_logs").getAbsolutePath()) + "/\\d+\\.log")) {
                return false;
            }
            int i2 = 0;
            while (path.length() <= 4096) {
                try {
                    String str = Utilities.readlink(path);
                    if (str != null && !str.equals(path)) {
                        i2++;
                        if (i2 >= 10) {
                            return true;
                        }
                        path = str;
                    }
                } catch (Throwable unused) {
                    return true;
                }
            }
            return true;
        }
        path = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        int i3 = 0;
        while (path.length() <= 4096) {
            try {
                String str2 = Utilities.readlinkFd(i);
                if (str2 != null && !str2.equals(path)) {
                    i3++;
                    if (i3 >= 10) {
                        return true;
                    }
                    path = str2;
                }
            } catch (Throwable unused2) {
                return true;
            }
        }
        return true;
        try {
            String canonicalPath = new File(path).getCanonicalPath();
            if (canonicalPath != null) {
                path = canonicalPath;
            }
        } catch (Exception unused3) {
            path.replace("/./", "/");
        }
        if (path.endsWith(".attheme")) {
            return false;
        }
        String lowerCase = path.toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append("/data/data/");
        sb.append(ApplicationLoader.applicationContext.getPackageName());
        return lowerCase.contains(sb.toString());
    }

    public static void lockOrientation(Activity activity) {
        if (activity == null || prevOrientation != -10) {
            return;
        }
        try {
            prevOrientation = activity.getRequestedOrientation();
            WindowManager windowManager = (WindowManager) activity.getSystemService("window");
            if (windowManager != null && windowManager.getDefaultDisplay() != null) {
                int rotation = windowManager.getDefaultDisplay().getRotation();
                int i = activity.getResources().getConfiguration().orientation;
                if (rotation == 3) {
                    if (i == 1) {
                        activity.setRequestedOrientation(1);
                    } else {
                        activity.setRequestedOrientation(8);
                    }
                } else if (rotation == 1) {
                    if (i == 1) {
                        activity.setRequestedOrientation(9);
                    } else {
                        activity.setRequestedOrientation(0);
                    }
                } else if (rotation == 0) {
                    if (i == 2) {
                        activity.setRequestedOrientation(0);
                    } else {
                        activity.setRequestedOrientation(1);
                    }
                } else if (i == 2) {
                    activity.setRequestedOrientation(8);
                } else {
                    activity.setRequestedOrientation(9);
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void unlockOrientation(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            int i = prevOrientation;
            if (i != -10) {
                activity.setRequestedOrientation(i);
                prevOrientation = -10;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static boolean isValidUrl(String str) {
        try {
            URL url = new URL(str.toLowerCase(Locale.ROOT));
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            if (host == null) {
                return false;
            }
            return pattern.matcher(port == -1 ? String.format("%s://%s", protocol, host) : String.format("%s://%s:%d", protocol, host, Integer.valueOf(port))).matches();
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    private static class VcardData {
        String name;
        ArrayList<String> phones;
        StringBuilder vcard;

        private VcardData() {
            this.phones = new ArrayList<>();
            this.vcard = new StringBuilder();
        }
    }

    /* loaded from: classes4.dex */
    public static class VcardItem {
        public int type;
        public ArrayList<String> vcardData = new ArrayList<>();
        public String fullData = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        public boolean checked = true;

        public String[] getRawValue() {
            byte[] bArrDecodeQuotedPrintable;
            int iIndexOf = this.fullData.indexOf(58);
            if (iIndexOf < 0) {
                return new String[0];
            }
            String strSubstring = this.fullData.substring(0, iIndexOf);
            String strSubstring2 = this.fullData.substring(iIndexOf + 1);
            String str = null;
            String[] strArrSplit = strSubstring.split(";");
            String str2 = Utf8Charset.NAME;
            for (String str3 : strArrSplit) {
                String[] strArrSplit2 = str3.split("=");
                if (strArrSplit2.length == 2) {
                    if (strArrSplit2[0].equals("CHARSET")) {
                        str2 = strArrSplit2[1];
                    } else if (strArrSplit2[0].equals("ENCODING")) {
                        str = strArrSplit2[1];
                    }
                }
            }
            String[] strArrSplit3 = strSubstring2.split(";");
            for (int i = 0; i < strArrSplit3.length; i++) {
                if (!TextUtils.isEmpty(strArrSplit3[i]) && str != null && str.equalsIgnoreCase("QUOTED-PRINTABLE") && (bArrDecodeQuotedPrintable = AndroidUtilities.decodeQuotedPrintable(AndroidUtilities.getStringBytes(strArrSplit3[i]))) != null && bArrDecodeQuotedPrintable.length != 0) {
                    try {
                        strArrSplit3[i] = new String(bArrDecodeQuotedPrintable, str2);
                    } catch (Exception unused) {
                    }
                }
            }
            return strArrSplit3;
        }

        public String getValue(boolean z) {
            byte[] bArrDecodeQuotedPrintable;
            StringBuilder sb = new StringBuilder();
            int iIndexOf = this.fullData.indexOf(58);
            if (iIndexOf < 0) {
                return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            if (sb.length() > 0) {
                sb.append(", ");
            }
            String strSubstring = this.fullData.substring(0, iIndexOf);
            String strSubstring2 = this.fullData.substring(iIndexOf + 1);
            String str = null;
            String[] strArrSplit = strSubstring.split(";");
            String str2 = Utf8Charset.NAME;
            for (String str3 : strArrSplit) {
                String[] strArrSplit2 = str3.split("=");
                if (strArrSplit2.length == 2) {
                    if (strArrSplit2[0].equals("CHARSET")) {
                        str2 = strArrSplit2[1];
                    } else if (strArrSplit2[0].equals("ENCODING")) {
                        str = strArrSplit2[1];
                    }
                }
            }
            String[] strArrSplit3 = strSubstring2.split(";");
            boolean z2 = false;
            for (int i = 0; i < strArrSplit3.length; i++) {
                if (!TextUtils.isEmpty(strArrSplit3[i])) {
                    if (str != null && str.equalsIgnoreCase("QUOTED-PRINTABLE") && (bArrDecodeQuotedPrintable = AndroidUtilities.decodeQuotedPrintable(AndroidUtilities.getStringBytes(strArrSplit3[i]))) != null && bArrDecodeQuotedPrintable.length != 0) {
                        try {
                            strArrSplit3[i] = new String(bArrDecodeQuotedPrintable, str2);
                        } catch (Exception unused) {
                        }
                    }
                    if (z2 && sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(strArrSplit3[i]);
                    if (!z2) {
                        z2 = strArrSplit3[i].length() > 0;
                    }
                }
            }
            if (z) {
                int i2 = this.type;
                if (i2 == 0) {
                    return PhoneFormat.getInstance().format(sb.toString());
                }
                if (i2 == 5) {
                    String[] strArrSplit4 = sb.toString().split("T");
                    if (strArrSplit4.length > 0) {
                        String[] strArrSplit5 = strArrSplit4[0].split("-");
                        if (strArrSplit5.length == 3) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(1, Utilities.parseInt(strArrSplit5[0]).intValue());
                            calendar.set(2, Utilities.parseInt(strArrSplit5[1]).intValue() - 1);
                            calendar.set(5, Utilities.parseInt(strArrSplit5[2]).intValue());
                            return LocaleController.getInstance().formatterYearMax.format(calendar.getTime());
                        }
                    }
                }
            }
            return sb.toString();
        }

        public String getRawType(boolean z) {
            int iIndexOf = this.fullData.indexOf(58);
            if (iIndexOf < 0) {
                return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            String strSubstring = this.fullData.substring(0, iIndexOf);
            if (this.type == 20) {
                String[] strArrSplit = strSubstring.substring(2).split(";");
                if (z) {
                    return strArrSplit[0];
                }
                return strArrSplit.length > 1 ? strArrSplit[strArrSplit.length - 1] : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            String[] strArrSplit2 = strSubstring.split(";");
            for (int i = 0; i < strArrSplit2.length; i++) {
                if (strArrSplit2[i].indexOf(61) < 0) {
                    strSubstring = strArrSplit2[i];
                }
            }
            return strSubstring;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String getType() {
            /*
                Method dump skipped, instructions count: 332
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.AndroidUtilities.VcardItem.getType():java.lang.String");
        }
    }

    public static byte[] getStringBytes(String str) {
        try {
            return str.getBytes(Utf8Charset.NAME);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<TLRPC$User> loadVCardFromStream(Uri uri, int i, boolean z, ArrayList<VcardItem> arrayList, String str) {
        InputStream inputStreamCreateInputStream;
        char c;
        String[] strArr;
        byte[] bArrDecodeQuotedPrintable;
        VcardItem vcardItem;
        ArrayList<VcardItem> arrayList2 = arrayList;
        ArrayList<TLRPC$User> arrayList3 = null;
        AnonymousClass1 anonymousClass1 = 0;
        if (z) {
            try {
                inputStreamCreateInputStream = ApplicationLoader.applicationContext.getContentResolver().openAssetFileDescriptor(uri, "r").createInputStream();
            } catch (Throwable th) {
                th = th;
                FileLog.e(th);
                return arrayList3;
            }
        } else {
            try {
                inputStreamCreateInputStream = ApplicationLoader.applicationContext.getContentResolver().openInputStream(uri);
            } catch (Throwable th2) {
                th = th2;
                arrayList3 = null;
                FileLog.e(th);
                return arrayList3;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamCreateInputStream, Utf8Charset.NAME));
        int i2 = 0;
        VcardData vcardData = null;
        String strSubstring = null;
        VcardItem vcardItem2 = null;
        boolean z2 = false;
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                if (line.startsWith("PHOTO")) {
                    z2 = true;
                } else {
                    if (line.indexOf(58) >= 0) {
                        if (line.startsWith("BEGIN:VCARD")) {
                            vcardData = new VcardData();
                            arrayList4.add(vcardData);
                            vcardData.name = str;
                        } else {
                            if (!line.startsWith("END:VCARD") && arrayList2 != null) {
                                if (line.startsWith("TEL")) {
                                    vcardItem = new VcardItem();
                                    vcardItem.type = i2;
                                } else if (line.startsWith("EMAIL")) {
                                    vcardItem = new VcardItem();
                                    vcardItem.type = 1;
                                } else if (line.startsWith("ADR") || line.startsWith("LABEL") || line.startsWith("GEO")) {
                                    vcardItem = new VcardItem();
                                    vcardItem.type = 2;
                                } else if (line.startsWith("URL")) {
                                    vcardItem = new VcardItem();
                                    vcardItem.type = 3;
                                } else if (line.startsWith("NOTE")) {
                                    vcardItem = new VcardItem();
                                    vcardItem.type = 4;
                                } else if (line.startsWith("BDAY")) {
                                    vcardItem = new VcardItem();
                                    vcardItem.type = 5;
                                } else if (line.startsWith("ORG") || line.startsWith("TITLE") || line.startsWith("ROLE")) {
                                    vcardItem = new VcardItem();
                                    vcardItem.type = 6;
                                } else if (line.startsWith("X-ANDROID")) {
                                    vcardItem = new VcardItem();
                                    vcardItem.type = -1;
                                } else {
                                    if (!line.startsWith("X-PHONETIC") && line.startsWith("X-")) {
                                        vcardItem = new VcardItem();
                                        vcardItem.type = 20;
                                    }
                                    vcardItem2 = anonymousClass1;
                                    if (vcardItem2 != null && vcardItem2.type >= 0) {
                                        arrayList2.add(vcardItem2);
                                    }
                                }
                                vcardItem2 = vcardItem;
                                if (vcardItem2 != null) {
                                    arrayList2.add(vcardItem2);
                                }
                            }
                            z2 = false;
                        }
                        vcardItem2 = anonymousClass1;
                        z2 = false;
                    }
                    if (!z2 && vcardData != null) {
                        if (vcardItem2 == null) {
                            if (vcardData.vcard.length() > 0) {
                                vcardData.vcard.append('\n');
                            }
                            vcardData.vcard.append(line);
                        } else {
                            vcardItem2.vcardData.add(line);
                        }
                    }
                    if (strSubstring != null) {
                        line = strSubstring + line;
                        strSubstring = null;
                    }
                    String str2 = "=";
                    if (line.contains("=QUOTED-PRINTABLE") && line.endsWith("=")) {
                        strSubstring = line.substring(i2, line.length() - 1);
                        anonymousClass1 = 0;
                    } else {
                        if (!z2 && vcardData != null && vcardItem2 != null) {
                            vcardItem2.fullData = line;
                        }
                        int iIndexOf = line.indexOf(":");
                        if (iIndexOf >= 0) {
                            strArr = new String[]{line.substring(0, iIndexOf), line.substring(iIndexOf + 1).trim()};
                            c = 0;
                        } else {
                            c = 0;
                            strArr = new String[]{line.trim()};
                        }
                        if (strArr.length < 2 || vcardData == null) {
                            arrayList2 = arrayList;
                            anonymousClass1 = 0;
                            i2 = 0;
                        } else {
                            if (!strArr[c].startsWith("FN") && (!strArr[c].startsWith("ORG") || !TextUtils.isEmpty(vcardData.name))) {
                                if (strArr[0].startsWith("TEL")) {
                                    vcardData.phones.add(strArr[1]);
                                }
                                arrayList2 = arrayList;
                                anonymousClass1 = 0;
                                i2 = 0;
                            }
                            String[] strArrSplit = strArr[0].split(";");
                            int length = strArrSplit.length;
                            int i3 = 0;
                            String str3 = null;
                            String str4 = null;
                            while (i3 < length) {
                                int i4 = length;
                                String[] strArrSplit2 = strArrSplit[i3].split(str2);
                                String[] strArr2 = strArrSplit;
                                String str5 = str2;
                                if (strArrSplit2.length == 2) {
                                    if (strArrSplit2[0].equals("CHARSET")) {
                                        str4 = strArrSplit2[1];
                                    } else if (strArrSplit2[0].equals("ENCODING")) {
                                        str3 = strArrSplit2[1];
                                    }
                                }
                                i3++;
                                length = i4;
                                strArrSplit = strArr2;
                                str2 = str5;
                            }
                            vcardData.name = strArr[1];
                            if (str3 != null && str3.equalsIgnoreCase("QUOTED-PRINTABLE") && (bArrDecodeQuotedPrintable = decodeQuotedPrintable(getStringBytes(vcardData.name))) != null && bArrDecodeQuotedPrintable.length != 0) {
                                vcardData.name = new String(bArrDecodeQuotedPrintable, str4);
                            }
                            arrayList2 = arrayList;
                            anonymousClass1 = 0;
                            i2 = 0;
                        }
                    }
                }
            } else {
                try {
                    break;
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }
        bufferedReader.close();
        inputStreamCreateInputStream.close();
        arrayList3 = null;
        for (int i5 = 0; i5 < arrayList4.size(); i5++) {
            VcardData vcardData2 = (VcardData) arrayList4.get(i5);
            if (vcardData2.name != null && !vcardData2.phones.isEmpty()) {
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList<>();
                }
                String str6 = vcardData2.phones.get(0);
                int i6 = 0;
                while (true) {
                    if (i6 >= vcardData2.phones.size()) {
                        break;
                    }
                    String str7 = vcardData2.phones.get(i6);
                    if (ContactsController.getInstance(i).contactsByShortPhone.get(str7.substring(Math.max(0, str7.length() - 7))) != null) {
                        str6 = str7;
                        break;
                    }
                    i6++;
                }
                TLRPC$TL_userContact_old2 tLRPC$TL_userContact_old2 = new TLRPC$TL_userContact_old2();
                tLRPC$TL_userContact_old2.phone = str6;
                tLRPC$TL_userContact_old2.first_name = vcardData2.name;
                tLRPC$TL_userContact_old2.last_name = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                tLRPC$TL_userContact_old2.id = 0;
                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReason = new TLRPC$TL_restrictionReason();
                tLRPC$TL_restrictionReason.text = vcardData2.vcard.toString();
                tLRPC$TL_restrictionReason.platform = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                tLRPC$TL_restrictionReason.reason = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                tLRPC$TL_userContact_old2.restriction_reason.add(tLRPC$TL_restrictionReason);
                arrayList3.add(tLRPC$TL_userContact_old2);
            }
        }
        return arrayList3;
    }

    public static Typeface getTypeface(String str) {
        Typeface typefaceCreateFromAsset;
        Typeface typeface;
        Hashtable<String, Typeface> hashtable = typefaceCache;
        synchronized (hashtable) {
            if (!hashtable.containsKey(str)) {
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        Typeface.Builder builder = new Typeface.Builder(ApplicationLoader.applicationContext.getAssets(), str);
                        if (str.contains("medium")) {
                            builder.setWeight(700);
                        }
                        if (str.contains("italic")) {
                            builder.setItalic(true);
                        }
                        typefaceCreateFromAsset = builder.build();
                    } else {
                        typefaceCreateFromAsset = Typeface.createFromAsset(ApplicationLoader.applicationContext.getAssets(), str);
                    }
                    hashtable.put(str, typefaceCreateFromAsset);
                } catch (Exception e) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("Could not get typeface '" + str + "' because " + e.getMessage());
                    }
                    return null;
                }
            }
            typeface = hashtable.get(str);
        }
        return typeface;
    }

    public static boolean isWaitingForSms() {
        boolean z;
        synchronized (smsLock) {
            z = waitingForSms;
        }
        return z;
    }

    public static void setWaitingForSms(boolean z) {
        synchronized (smsLock) {
            waitingForSms = z;
            if (z) {
                try {
                    SmsRetriever.getClient(ApplicationLoader.applicationContext).startSmsRetriever().addOnSuccessListener(new OnSuccessListener() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda8
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            AndroidUtilities.lambda$setWaitingForSms$3((Void) obj);
                        }
                    });
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setWaitingForSms$3(Void r0) {
        if (BuildVars.DEBUG_VERSION) {
            FileLog.d("sms listener registered");
        }
    }

    public static int getShadowHeight() {
        float f = density;
        if (f >= 4.0f) {
            return 3;
        }
        return f >= 2.0f ? 2 : 1;
    }

    public static boolean isWaitingForCall() {
        boolean z;
        synchronized (callLock) {
            z = waitingForCall;
        }
        return z;
    }

    public static void setWaitingForCall(boolean z) {
        synchronized (callLock) {
            try {
                if (z) {
                    if (callReceiver == null) {
                        IntentFilter intentFilter = new IntentFilter("android.intent.action.PHONE_STATE");
                        Context context = ApplicationLoader.applicationContext;
                        CallReceiver callReceiver2 = new CallReceiver();
                        callReceiver = callReceiver2;
                        context.registerReceiver(callReceiver2, intentFilter);
                    }
                } else if (callReceiver != null) {
                    ApplicationLoader.applicationContext.unregisterReceiver(callReceiver);
                    callReceiver = null;
                }
            } catch (Exception unused) {
            }
            waitingForCall = z;
        }
    }

    public static boolean showKeyboard(View view) {
        if (view == null) {
            return false;
        }
        try {
            return ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    public static String[] getCurrentKeyboardLanguage() {
        String locale;
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) ApplicationLoader.applicationContext.getSystemService("input_method");
            InputMethodSubtype currentInputMethodSubtype = inputMethodManager.getCurrentInputMethodSubtype();
            String str = null;
            if (currentInputMethodSubtype != null) {
                locale = Build.VERSION.SDK_INT >= 24 ? currentInputMethodSubtype.getLanguageTag() : null;
                if (TextUtils.isEmpty(locale)) {
                    locale = currentInputMethodSubtype.getLocale();
                }
            } else {
                InputMethodSubtype lastInputMethodSubtype = inputMethodManager.getLastInputMethodSubtype();
                if (lastInputMethodSubtype != null) {
                    String languageTag = Build.VERSION.SDK_INT >= 24 ? lastInputMethodSubtype.getLanguageTag() : null;
                    locale = TextUtils.isEmpty(languageTag) ? lastInputMethodSubtype.getLocale() : languageTag;
                } else {
                    locale = null;
                }
            }
            if (!TextUtils.isEmpty(locale)) {
                return new String[]{locale.replace('_', '-')};
            }
            String systemLocaleStringIso639 = LocaleController.getSystemLocaleStringIso639();
            LocaleController.LocaleInfo currentLocaleInfo = LocaleController.getInstance().getCurrentLocaleInfo();
            String baseLangCode = currentLocaleInfo.getBaseLangCode();
            boolean zIsEmpty = TextUtils.isEmpty(baseLangCode);
            String langCode = baseLangCode;
            if (zIsEmpty) {
                langCode = currentLocaleInfo.getLangCode();
            }
            if (!systemLocaleStringIso639.contains(langCode) && !langCode.contains(systemLocaleStringIso639)) {
                str = langCode;
            } else if (!systemLocaleStringIso639.contains("en")) {
                str = "en";
            }
            return !TextUtils.isEmpty(str) ? new String[]{systemLocaleStringIso639.replace('_', '-'), str} : new String[]{systemLocaleStringIso639.replace('_', '-')};
        } catch (Exception unused) {
            return new String[]{"en"};
        }
    }

    public static void hideKeyboard(View view) {
        if (view == null) {
            return;
        }
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static ArrayList<File> getDataDirs() {
        File[] externalFilesDirs;
        ArrayList<File> arrayList = null;
        if (Build.VERSION.SDK_INT >= 19 && (externalFilesDirs = ApplicationLoader.applicationContext.getExternalFilesDirs(null)) != null) {
            for (int i = 0; i < externalFilesDirs.length; i++) {
                if (externalFilesDirs[i] != null) {
                    externalFilesDirs[i].getAbsolutePath();
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(externalFilesDirs[i]);
                }
            }
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.isEmpty()) {
            arrayList.add(Environment.getExternalStorageDirectory());
        }
        return arrayList;
    }

    public static ArrayList<File> getRootDirs() {
        File[] externalFilesDirs;
        String absolutePath;
        int iIndexOf;
        ArrayList<File> arrayList = null;
        if (Build.VERSION.SDK_INT >= 19 && (externalFilesDirs = ApplicationLoader.applicationContext.getExternalFilesDirs(null)) != null) {
            for (int i = 0; i < externalFilesDirs.length; i++) {
                if (externalFilesDirs[i] != null && (iIndexOf = (absolutePath = externalFilesDirs[i].getAbsolutePath()).indexOf("/Android")) >= 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(new File(absolutePath.substring(0, iIndexOf)));
                }
            }
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.isEmpty()) {
            arrayList.add(Environment.getExternalStorageDirectory());
        }
        return arrayList;
    }

    public static File getCacheDir() {
        String externalStorageState;
        File externalCacheDir;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception e) {
            FileLog.e(e);
            externalStorageState = null;
        }
        if (externalStorageState == null || externalStorageState.startsWith("mounted")) {
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    File[] externalCacheDirs = ApplicationLoader.applicationContext.getExternalCacheDirs();
                    int i = 0;
                    externalCacheDir = externalCacheDirs[0];
                    if (!TextUtils.isEmpty(SharedConfig.storageCacheDir)) {
                        while (true) {
                            if (i < externalCacheDirs.length) {
                                if (externalCacheDirs[i] != null && externalCacheDirs[i].getAbsolutePath().startsWith(SharedConfig.storageCacheDir)) {
                                    externalCacheDir = externalCacheDirs[i];
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                    }
                } else {
                    externalCacheDir = ApplicationLoader.applicationContext.getExternalCacheDir();
                }
                if (externalCacheDir != null) {
                    return externalCacheDir;
                }
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        try {
            File cacheDir = ApplicationLoader.applicationContext.getCacheDir();
            if (cacheDir != null) {
                return cacheDir;
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
        return new File(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
    }

    public static int dp(float f) {
        if (f == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(density * f);
    }

    public static int dpr(float f) {
        if (f == 0.0f) {
            return 0;
        }
        return Math.round(density * f);
    }

    public static int dp2(float f) {
        if (f == 0.0f) {
            return 0;
        }
        return (int) Math.floor(density * f);
    }

    public static float dpf2(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        return density * f;
    }

    public static void checkDisplaySize(Context context, Configuration configuration) {
        Display defaultDisplay;
        try {
            float f = density;
            density = context.getResources().getDisplayMetrics().density;
            if (firstConfigurationWas && Math.abs(f - r2) > 0.001d) {
                Theme.reloadAllResources(context);
            }
            boolean z = true;
            firstConfigurationWas = true;
            if (configuration == null) {
                configuration = context.getResources().getConfiguration();
            }
            if (configuration.keyboard == 1 || configuration.hardKeyboardHidden != 1) {
                z = false;
            }
            usingHardwareInput = z;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                defaultDisplay.getMetrics(displayMetrics);
                defaultDisplay.getSize(displaySize);
                float refreshRate = defaultDisplay.getRefreshRate();
                screenRefreshRate = refreshRate;
                screenRefreshTime = 1000.0f / refreshRate;
            }
            if (configuration.screenWidthDp != 0) {
                int iCeil = (int) Math.ceil(r1 * density);
                if (Math.abs(displaySize.x - iCeil) > 3) {
                    displaySize.x = iCeil;
                }
            }
            if (configuration.screenHeightDp != 0) {
                int iCeil2 = (int) Math.ceil(r7 * density);
                if (Math.abs(displaySize.y - iCeil2) > 3) {
                    displaySize.y = iCeil2;
                }
            }
            if (roundMessageSize == 0) {
                if (isTablet()) {
                    roundMessageSize = (int) (getMinTabletSide() * 0.6f);
                    roundPlayingMessageSize = getMinTabletSide() - dp(28.0f);
                } else {
                    Point point = displaySize;
                    roundMessageSize = (int) (Math.min(point.x, point.y) * 0.6f);
                    Point point2 = displaySize;
                    roundPlayingMessageSize = Math.min(point2.x, point2.y) - dp(28.0f);
                }
                roundMessageInset = dp(2.0f);
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("density = " + density + " display size = " + displaySize.x + " " + displaySize.y + " " + displayMetrics.xdpi + "x" + displayMetrics.ydpi);
            }
            touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static double fixLocationCoord(double d) {
        double d2 = (long) (d * 1000000.0d);
        Double.isNaN(d2);
        return d2 / 1000000.0d;
    }

    public static String formapMapUrl(int i, double d, double d2, int i2, int i3, boolean z, int i4, int i5) {
        int iMin = Math.min(2, (int) Math.ceil(density));
        int i6 = i5 == -1 ? MessagesController.getInstance(i).mapProvider : i5;
        if (i6 == 1 || i6 == 3) {
            String str = null;
            String[] strArr = {"ru_RU", "tr_TR"};
            LocaleController.LocaleInfo currentLocaleInfo = LocaleController.getInstance().getCurrentLocaleInfo();
            for (int i7 = 0; i7 < 2; i7++) {
                if (strArr[i7].toLowerCase().contains(currentLocaleInfo.shortName)) {
                    str = strArr[i7];
                }
            }
            if (str == null) {
                str = "en_US";
            }
            return z ? String.format(Locale.US, "https://static-maps.yandex.ru/1.x/?ll=%.6f,%.6f&z=%d&size=%d,%d&l=map&scale=%d&pt=%.6f,%.6f,vkbkm&lang=%s", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i4), Integer.valueOf(i2 * iMin), Integer.valueOf(i3 * iMin), Integer.valueOf(iMin), Double.valueOf(d2), Double.valueOf(d), str) : String.format(Locale.US, "https://static-maps.yandex.ru/1.x/?ll=%.6f,%.6f&z=%d&size=%d,%d&l=map&scale=%d&lang=%s", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i4), Integer.valueOf(i2 * iMin), Integer.valueOf(i3 * iMin), Integer.valueOf(iMin), str);
        }
        String str2 = MessagesController.getInstance(i).mapKey;
        return !TextUtils.isEmpty(str2) ? z ? String.format(Locale.US, "https://maps.googleapis.com/maps/api/staticmap?center=%.6f,%.6f&zoom=%d&size=%dx%d&maptype=roadmap&scale=%d&markers=color:red%%7Csize:mid%%7C%.6f,%.6f&sensor=false&key=%s", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iMin), Double.valueOf(d), Double.valueOf(d2), str2) : String.format(Locale.US, "https://maps.googleapis.com/maps/api/staticmap?center=%.6f,%.6f&zoom=%d&size=%dx%d&maptype=roadmap&scale=%d&key=%s", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iMin), str2) : z ? String.format(Locale.US, "https://maps.googleapis.com/maps/api/staticmap?center=%.6f,%.6f&zoom=%d&size=%dx%d&maptype=roadmap&scale=%d&markers=color:red%%7Csize:mid%%7C%.6f,%.6f&sensor=false", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iMin), Double.valueOf(d), Double.valueOf(d2)) : String.format(Locale.US, "https://maps.googleapis.com/maps/api/staticmap?center=%.6f,%.6f&zoom=%d&size=%dx%d&maptype=roadmap&scale=%d", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iMin));
    }

    public static float getPixelsInCM(float f, boolean z) {
        return (f / 2.54f) * (z ? displayMetrics.xdpi : displayMetrics.ydpi);
    }

    public static void runOnUIThread(Runnable runnable) {
        runOnUIThread(runnable, 0L);
    }

    public static void runOnUIThread(Runnable runnable, long j) {
        if (j == 0) {
            ApplicationLoader.applicationHandler.post(runnable);
        } else {
            ApplicationLoader.applicationHandler.postDelayed(runnable, j);
        }
    }

    public static void cancelRunOnUIThread(Runnable runnable) {
        ApplicationLoader.applicationHandler.removeCallbacks(runnable);
    }

    public static boolean isTablet() {
        if (isTablet == null) {
            isTablet = Boolean.FALSE;
        }
        return isTablet.booleanValue();
    }

    public static boolean isSmallTablet() {
        Point point = displaySize;
        return ((float) Math.min(point.x, point.y)) / density <= 700.0f;
    }

    public static int getMinTabletSide() {
        if (!isSmallTablet()) {
            Point point = displaySize;
            int iMin = Math.min(point.x, point.y);
            int iDp = (iMin * 35) / 100;
            if (iDp < dp(320.0f)) {
                iDp = dp(320.0f);
            }
            return iMin - iDp;
        }
        Point point2 = displaySize;
        int iMin2 = Math.min(point2.x, point2.y);
        Point point3 = displaySize;
        int iMax = Math.max(point3.x, point3.y);
        int iDp2 = (iMax * 35) / 100;
        if (iDp2 < dp(320.0f)) {
            iDp2 = dp(320.0f);
        }
        return Math.min(iMin2, iMax - iDp2);
    }

    public static int getPhotoSize() {
        if (photoSize == null) {
            photoSize = 20000;
        }
        return photoSize.intValue();
    }

    public static void endIncomingCall() {
        if (hasCallPermissions) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
                Method declaredMethod = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod("getITelephony", new Class[0]);
                declaredMethod.setAccessible(true);
                ITelephony iTelephony = (ITelephony) declaredMethod.invoke(telephonyManager, new Object[0]);
                iTelephony.silenceRinger();
                iTelephony.endCall();
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
    }

    public static String obtainLoginPhoneCall(String str) {
        if (!hasCallPermissions) {
            return null;
        }
        try {
            Cursor cursorQuery = ApplicationLoader.applicationContext.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "date"}, "type IN (3,1,5)", null, "date DESC LIMIT 5");
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(0);
                    long j = cursorQuery.getLong(1);
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.e("number = " + string);
                    }
                    if (Math.abs(System.currentTimeMillis() - j) < 3600000 && checkPhonePattern(str, string)) {
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            }
            cursorQuery.close();
        } catch (Exception e) {
            FileLog.e(e);
        }
        return null;
    }

    public static boolean checkPhonePattern(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !str.equals("*")) {
            String[] strArrSplit = str.split("\\*");
            String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(str2);
            int length = 0;
            for (String str3 : strArrSplit) {
                if (!TextUtils.isEmpty(str3)) {
                    int iIndexOf = strStripExceptNumbers.indexOf(str3, length);
                    if (iIndexOf == -1) {
                        return false;
                    }
                    length = iIndexOf + str3.length();
                }
            }
        }
        return true;
    }

    public static int getViewInset(View view) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        int i;
        if (view != null && (i = Build.VERSION.SDK_INT) >= 21 && view.getHeight() != displaySize.y && view.getHeight() != displaySize.y - statusBarHeight) {
            try {
                if (i >= 23) {
                    WindowInsets rootWindowInsets = view.getRootWindowInsets();
                    if (rootWindowInsets != null) {
                        return rootWindowInsets.getStableInsetBottom();
                    }
                    return 0;
                }
                if (mAttachInfoField == null) {
                    Field declaredField = View.class.getDeclaredField("mAttachInfo");
                    mAttachInfoField = declaredField;
                    declaredField.setAccessible(true);
                }
                Object obj = mAttachInfoField.get(view);
                if (obj != null) {
                    if (mStableInsetsField == null) {
                        Field declaredField2 = obj.getClass().getDeclaredField("mStableInsets");
                        mStableInsetsField = declaredField2;
                        declaredField2.setAccessible(true);
                    }
                    return ((Rect) mStableInsetsField.get(obj)).bottom;
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        return 0;
    }

    public static Point getRealScreenSize() throws NoSuchMethodException, SecurityException {
        Point point = new Point();
        try {
            WindowManager windowManager = (WindowManager) ApplicationLoader.applicationContext.getSystemService("window");
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealSize(point);
            } else {
                try {
                    point.set(((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(windowManager.getDefaultDisplay(), new Object[0])).intValue(), ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(windowManager.getDefaultDisplay(), new Object[0])).intValue());
                } catch (Exception e) {
                    point.set(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
                    FileLog.e(e);
                }
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        return point;
    }

    public static void setEnabled(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                setEnabled(viewGroup.getChildAt(i), z);
            }
        }
    }

    public static CharSequence getTrimmedString(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            while (charSequence.length() > 0 && (charSequence.charAt(0) == '\n' || charSequence.charAt(0) == ' ')) {
                charSequence = charSequence.subSequence(1, charSequence.length());
            }
            while (charSequence.length() > 0 && (charSequence.charAt(charSequence.length() - 1) == '\n' || charSequence.charAt(charSequence.length() - 1) == ' ')) {
                charSequence = charSequence.subSequence(0, charSequence.length() - 1);
            }
        }
        return charSequence;
    }

    public static void setViewPagerEdgeEffectColor(ViewPager viewPager, int i) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mLeftEdge");
                declaredField.setAccessible(true);
                EdgeEffect edgeEffect = (EdgeEffect) declaredField.get(viewPager);
                if (edgeEffect != null) {
                    edgeEffect.setColor(i);
                }
                Field declaredField2 = ViewPager.class.getDeclaredField("mRightEdge");
                declaredField2.setAccessible(true);
                EdgeEffect edgeEffect2 = (EdgeEffect) declaredField2.get(viewPager);
                if (edgeEffect2 != null) {
                    edgeEffect2.setColor(i);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void setScrollViewEdgeEffectColor(HorizontalScrollView horizontalScrollView, int i) throws NoSuchFieldException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            horizontalScrollView.setEdgeEffectColor(i);
            return;
        }
        if (i2 >= 21) {
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mEdgeGlowLeft");
                declaredField.setAccessible(true);
                EdgeEffect edgeEffect = (EdgeEffect) declaredField.get(horizontalScrollView);
                if (edgeEffect != null) {
                    edgeEffect.setColor(i);
                }
                Field declaredField2 = HorizontalScrollView.class.getDeclaredField("mEdgeGlowRight");
                declaredField2.setAccessible(true);
                EdgeEffect edgeEffect2 = (EdgeEffect) declaredField2.get(horizontalScrollView);
                if (edgeEffect2 != null) {
                    edgeEffect2.setColor(i);
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static void setScrollViewEdgeEffectColor(ScrollView scrollView, int i) throws NoSuchFieldException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            scrollView.setTopEdgeEffectColor(i);
            scrollView.setBottomEdgeEffectColor(i);
            return;
        }
        if (i2 >= 21) {
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mEdgeGlowTop");
                declaredField.setAccessible(true);
                EdgeEffect edgeEffect = (EdgeEffect) declaredField.get(scrollView);
                if (edgeEffect != null) {
                    edgeEffect.setColor(i);
                }
                Field declaredField2 = ScrollView.class.getDeclaredField("mEdgeGlowBottom");
                declaredField2.setAccessible(true);
                EdgeEffect edgeEffect2 = (EdgeEffect) declaredField2.get(scrollView);
                if (edgeEffect2 != null) {
                    edgeEffect2.setColor(i);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void clearDrawableAnimation(View view) {
        if (Build.VERSION.SDK_INT < 21 || view == null) {
            return;
        }
        if (view instanceof ListView) {
            Drawable selector = ((ListView) view).getSelector();
            if (selector != null) {
                selector.setState(StateSet.NOTHING);
                return;
            }
            return;
        }
        Drawable background = view.getBackground();
        if (background != null) {
            background.setState(StateSet.NOTHING);
            background.jumpToCurrentState();
        }
    }

    public static SpannableStringBuilder replaceTags(String str) {
        return replaceTags(str, 11, new Object[0]);
    }

    public static SpannableStringBuilder replaceTags(String str, int i, Object... objArr) {
        try {
            StringBuilder sb = new StringBuilder(str);
            if ((i & 1) != 0) {
                while (true) {
                    int iIndexOf = sb.indexOf("<br>");
                    if (iIndexOf == -1) {
                        break;
                    }
                    sb.replace(iIndexOf, iIndexOf + 4, "\n");
                }
                while (true) {
                    int iIndexOf2 = sb.indexOf("<br/>");
                    if (iIndexOf2 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf2, iIndexOf2 + 5, "\n");
                }
            }
            ArrayList arrayList = new ArrayList();
            if ((i & 2) != 0) {
                while (true) {
                    int iIndexOf3 = sb.indexOf("<b>");
                    if (iIndexOf3 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf3, iIndexOf3 + 3, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                    int iIndexOf4 = sb.indexOf("</b>");
                    if (iIndexOf4 == -1) {
                        iIndexOf4 = sb.indexOf("<b>");
                    }
                    sb.replace(iIndexOf4, iIndexOf4 + 4, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                    arrayList.add(Integer.valueOf(iIndexOf3));
                    arrayList.add(Integer.valueOf(iIndexOf4));
                }
                while (true) {
                    int iIndexOf5 = sb.indexOf("**");
                    if (iIndexOf5 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf5, iIndexOf5 + 2, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                    int iIndexOf6 = sb.indexOf("**");
                    if (iIndexOf6 >= 0) {
                        sb.replace(iIndexOf6, iIndexOf6 + 2, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                        arrayList.add(Integer.valueOf(iIndexOf5));
                        arrayList.add(Integer.valueOf(iIndexOf6));
                    }
                }
            }
            if ((i & 8) != 0) {
                while (true) {
                    int iIndexOf7 = sb.indexOf("**");
                    if (iIndexOf7 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf7, iIndexOf7 + 2, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                    int iIndexOf8 = sb.indexOf("**");
                    if (iIndexOf8 >= 0) {
                        sb.replace(iIndexOf8, iIndexOf8 + 2, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                        arrayList.add(Integer.valueOf(iIndexOf7));
                        arrayList.add(Integer.valueOf(iIndexOf8));
                    }
                }
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
            for (int i2 = 0; i2 < arrayList.size() / 2; i2++) {
                int i3 = i2 * 2;
                spannableStringBuilder.setSpan(new TypefaceSpan(getTypeface(TYPEFACE_ROBOTO_MEDIUM)), ((Integer) arrayList.get(i3)).intValue(), ((Integer) arrayList.get(i3 + 1)).intValue(), 33);
            }
            return spannableStringBuilder;
        } catch (Exception e) {
            FileLog.e(e);
            return new SpannableStringBuilder(str);
        }
    }

    /* loaded from: classes4.dex */
    public static class LinkMovementMethodMy extends LinkMovementMethod {
        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            try {
                boolean zOnTouchEvent = super.onTouchEvent(textView, spannable, motionEvent);
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    Selection.removeSelection(spannable);
                }
                return zOnTouchEvent;
            } catch (Exception e) {
                FileLog.e(e);
                return false;
            }
        }
    }

    public static boolean needShowPasscode() {
        return needShowPasscode(false);
    }

    public static boolean needShowPasscode(boolean z) {
        boolean zIsWasInBackground = ForegroundDetector.getInstance().isWasInBackground(z);
        if (z) {
            ForegroundDetector.getInstance().resetBackgroundVar();
        }
        int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() / 1000);
        if (BuildVars.LOGS_ENABLED && z && SharedConfig.passcodeHash.length() > 0) {
            FileLog.d("wasInBackground = " + zIsWasInBackground + " appLocked = " + SharedConfig.appLocked + " autoLockIn = " + SharedConfig.autoLockIn + " lastPauseTime = " + SharedConfig.lastPauseTime + " uptime = " + iElapsedRealtime);
        }
        return SharedConfig.passcodeHash.length() > 0 && zIsWasInBackground && (SharedConfig.appLocked || (!(SharedConfig.autoLockIn == 0 || SharedConfig.lastPauseTime == 0 || SharedConfig.appLocked || SharedConfig.lastPauseTime + SharedConfig.autoLockIn > iElapsedRealtime) || iElapsedRealtime + 5 < SharedConfig.lastPauseTime));
    }

    public static void shakeView(final View view) {
        if (view == null) {
            return;
        }
        Object tag = view.getTag(ir.medu.shad.R.id.shake_animation);
        if (tag instanceof ValueAnimator) {
            ((ValueAnimator) tag).cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AndroidUtilities.lambda$shakeView$4(view, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.messenger.AndroidUtilities.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(0.0f);
            }
        });
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.start();
        view.setTag(ir.medu.shad.R.id.shake_animation, valueAnimatorOfFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$shakeView$4(View view, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        double d = fFloatValue * 4.0f * (1.0f - fFloatValue);
        double d2 = fFloatValue;
        Double.isNaN(d2);
        double dSin = Math.sin(d2 * 3.141592653589793d * 4.0d);
        Double.isNaN(d);
        double d3 = d * dSin;
        double dDp = dp(4.0f);
        Double.isNaN(dDp);
        view.setTranslationX((float) (d3 * dDp));
    }

    public static void shakeView(final View view, final float f, final int i) {
        if (view == null) {
            return;
        }
        if (i == 6) {
            view.setTranslationX(0.0f);
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationX", dp(f)));
        animatorSet.setDuration(50L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.messenger.AndroidUtilities.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View view2 = view;
                int i2 = i;
                AndroidUtilities.shakeView(view2, i2 == 5 ? 0.0f : -f, i2 + 1);
            }
        });
        animatorSet.start();
    }

    public static void shakeViewSpring(View view) {
        shakeViewSpring(view, 10.0f, null);
    }

    public static void shakeViewSpring(View view, float f) {
        shakeViewSpring(view, f, null);
    }

    public static void shakeViewSpring(View view, Runnable runnable) {
        shakeViewSpring(view, 10.0f, runnable);
    }

    public static void shakeViewSpring(final View view, float f, final Runnable runnable) {
        int iDp = dp(f);
        if (view.getTag(ir.medu.shad.R.id.spring_tag) != null) {
            ((SpringAnimation) view.getTag(ir.medu.shad.R.id.spring_tag)).cancel();
        }
        Float f2 = (Float) view.getTag(ir.medu.shad.R.id.spring_was_translation_x_tag);
        if (f2 != null) {
            view.setTranslationX(f2.floatValue());
        }
        view.setTag(ir.medu.shad.R.id.spring_was_translation_x_tag, Float.valueOf(view.getTranslationX()));
        final float translationX = view.getTranslationX();
        SpringAnimation springAnimationAddEndListener = new SpringAnimation(view, DynamicAnimation.TRANSLATION_X, translationX).setSpring(new SpringForce(translationX).setStiffness(600.0f)).setStartVelocity((-iDp) * 100).addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda7
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f3, float f4) {
                AndroidUtilities.lambda$shakeViewSpring$5(runnable, view, translationX, dynamicAnimation, z, f3, f4);
            }
        });
        view.setTag(ir.medu.shad.R.id.spring_tag, springAnimationAddEndListener);
        springAnimationAddEndListener.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$shakeViewSpring$5(Runnable runnable, View view, float f, DynamicAnimation dynamicAnimation, boolean z, float f2, float f3) {
        if (runnable != null) {
            runnable.run();
        }
        view.setTranslationX(f);
        view.setTag(ir.medu.shad.R.id.spring_tag, null);
        view.setTag(ir.medu.shad.R.id.spring_was_translation_x_tag, null);
    }

    public static boolean shouldShowClipboardToast() {
        int i = Build.VERSION.SDK_INT;
        return (i < 31 || !OneUIUtilities.hasBuiltInClipboardToasts()) && i <= 33;
    }

    public static boolean addToClipboard(CharSequence charSequence) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard");
            if (charSequence instanceof Spanned) {
                clipboardManager.setPrimaryClip(ClipData.newHtmlText("label", charSequence, CustomHtml.toHtml((Spanned) charSequence)));
                return true;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText("label", charSequence));
            return true;
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    public static void addMediaToGallery(String str) {
        if (str == null) {
            return;
        }
        addMediaToGallery(Uri.fromFile(new File(str)));
    }

    public static void addMediaToGallery(Uri uri) {
        if (uri == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri);
            ApplicationLoader.applicationContext.sendBroadcast(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private static File getAlbumDir(boolean z) {
        if (z || (Build.VERSION.SDK_INT >= 23 && ApplicationLoader.applicationContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0)) {
            return FileLoader.getDirectory(4);
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), LocaleController.getString(ir.medu.shad.R.string.FilePath));
            if (file.mkdirs() || file.exists()) {
                return file;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("failed to create directory");
            }
            return null;
        }
        if (!BuildVars.LOGS_ENABLED) {
            return null;
        }
        FileLog.d("External storage is not mounted READ/WRITE.");
        return null;
    }

    public static String getPath(Uri uri) {
        Uri uri2;
        try {
            if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(ApplicationLoader.applicationContext, uri)) {
                if (isExternalStorageDocument(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (isDownloadsDocument(uri)) {
                        return getDataColumn(ApplicationLoader.applicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (isMediaDocument(uri)) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        String str = strArrSplit2[0];
                        char c = 65535;
                        int iHashCode = str.hashCode();
                        if (iHashCode != 93166550) {
                            if (iHashCode != 100313435) {
                                if (iHashCode == 112202875 && str.equals(MediaStreamTrack.VIDEO_TRACK_KIND)) {
                                    c = 1;
                                }
                            } else if (str.equals("image")) {
                                c = 0;
                            }
                        } else if (str.equals(MediaStreamTrack.AUDIO_TRACK_KIND)) {
                            c = 2;
                        }
                        if (c == 0) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (c == 1) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            uri2 = c != 2 ? null : MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return getDataColumn(ApplicationLoader.applicationContext, uri2, "_id=?", new String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if ("content".equalsIgnoreCase(uri.getScheme())) {
                    return getDataColumn(ApplicationLoader.applicationContext, uri, null, null);
                }
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
    
        if (r9.startsWith("file://") == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            r0 = 0
            java.lang.String r7 = "_data"
            r3[r0] = r7
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Exception -> L50
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L50
            if (r8 == 0) goto L4b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L46
            if (r9 == 0) goto L4b
            int r9 = r8.getColumnIndexOrThrow(r7)     // Catch: java.lang.Throwable -> L46
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L46
            java.lang.String r10 = "content://"
            boolean r10 = r9.startsWith(r10)     // Catch: java.lang.Throwable -> L46
            if (r10 != 0) goto L42
            java.lang.String r10 = "/"
            boolean r10 = r9.startsWith(r10)     // Catch: java.lang.Throwable -> L46
            if (r10 != 0) goto L3e
            java.lang.String r10 = "file://"
            boolean r10 = r9.startsWith(r10)     // Catch: java.lang.Throwable -> L46
            if (r10 != 0) goto L3e
            goto L42
        L3e:
            r8.close()     // Catch: java.lang.Exception -> L50
            return r9
        L42:
            r8.close()     // Catch: java.lang.Exception -> L50
            return r0
        L46:
            r9 = move-exception
            r8.close()     // Catch: java.lang.Throwable -> L4a
        L4a:
            throw r9     // Catch: java.lang.Exception -> L50
        L4b:
            if (r8 == 0) goto L50
            r8.close()     // Catch: java.lang.Exception -> L50
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.AndroidUtilities.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static File generatePicturePath() {
        return generatePicturePath(false, null);
    }

    public static File generatePicturePath(boolean z, String str) {
        try {
            File albumDir = getAlbumDir(z);
            Date date = new Date();
            date.setTime(System.currentTimeMillis() + Utilities.random.nextInt(CloseCodes.NORMAL_CLOSURE) + 1);
            String str2 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(date);
            StringBuilder sb = new StringBuilder();
            sb.append("IMG_");
            sb.append(str2);
            sb.append(".");
            if (TextUtils.isEmpty(str)) {
                str = "jpg";
            }
            sb.append(str);
            return new File(albumDir, sb.toString());
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static CharSequence generateSearchName(String str, String str2, String str3) {
        if ((str == null && str2 == null) || TextUtils.isEmpty(str3)) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str == null || str.length() == 0) {
            str = str2;
        } else if (str2 != null && str2.length() != 0) {
            str = str + " " + str2;
        }
        String strTrim = str.trim();
        String str4 = " " + strTrim.toLowerCase();
        int i = 0;
        while (true) {
            int iIndexOf = str4.indexOf(" " + str3, i);
            if (iIndexOf == -1) {
                break;
            }
            int i2 = iIndexOf - (iIndexOf == 0 ? 0 : 1);
            int length = str3.length() + (iIndexOf == 0 ? 0 : 1) + i2;
            if (i != 0 && i != i2 + 1) {
                spannableStringBuilder.append((CharSequence) strTrim.substring(i, i2));
            } else if (i == 0 && i2 != 0) {
                spannableStringBuilder.append((CharSequence) strTrim.substring(0, i2));
            }
            String strSubstring = strTrim.substring(i2, Math.min(strTrim.length(), length));
            if (strSubstring.startsWith(" ")) {
                spannableStringBuilder.append((CharSequence) " ");
            }
            String strTrim2 = strSubstring.trim();
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) strTrim2);
            spannableStringBuilder.setSpan(new ForegroundColorSpanThemable(Theme.key_windowBackgroundWhiteBlueText4), length2, strTrim2.length() + length2, 33);
            i = length;
        }
        if (i != -1 && i < strTrim.length()) {
            spannableStringBuilder.append((CharSequence) strTrim.substring(i));
        }
        return spannableStringBuilder;
    }

    public static boolean isAirplaneModeOn() {
        return Build.VERSION.SDK_INT < 17 ? Settings.System.getInt(ApplicationLoader.applicationContext.getContentResolver(), "airplane_mode_on", 0) != 0 : Settings.Global.getInt(ApplicationLoader.applicationContext.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public static File generateVideoPath() {
        return generateVideoPath(false);
    }

    public static File generateVideoPath(boolean z) {
        try {
            File albumDir = getAlbumDir(z);
            Date date = new Date();
            date.setTime(System.currentTimeMillis() + Utilities.random.nextInt(CloseCodes.NORMAL_CLOSURE) + 1);
            return new File(albumDir, "VID_" + new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(date) + ".mp4");
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static String formatFileSize(long j) {
        return formatFileSize(j, false);
    }

    public static String formatFileSize(long j, boolean z) {
        if (j < 1024) {
            return String.format("%d B", Long.valueOf(j));
        }
        if (j < 1048576) {
            float f = j / 1024.0f;
            if (z) {
                int i = (int) f;
                if ((f - i) * 10.0f == 0.0f) {
                    return String.format("%d KB", Integer.valueOf(i));
                }
            }
            return String.format("%.1f KB", Float.valueOf(f));
        }
        if (j < 1073741824) {
            float f2 = (j / 1024.0f) / 1024.0f;
            if (z) {
                int i2 = (int) f2;
                if ((f2 - i2) * 10.0f == 0.0f) {
                    return String.format("%d MB", Integer.valueOf(i2));
                }
            }
            return String.format("%.1f MB", Float.valueOf(f2));
        }
        float f3 = ((j / 1024.0f) / 1024.0f) / 1024.0f;
        if (z) {
            int i3 = (int) f3;
            if ((f3 - i3) * 10.0f == 0.0f) {
                return String.format("%d GB", Integer.valueOf(i3));
            }
        }
        return String.format("%.1f GB", Float.valueOf(f3));
    }

    public static String formatShortDuration(int i) {
        return formatDuration(i, false);
    }

    public static String formatLongDuration(int i) {
        return formatDuration(i, true);
    }

    public static String formatDuration(int i, boolean z) {
        int i2 = i / 3600;
        int i3 = (i / 60) % 60;
        int i4 = i % 60;
        return i2 == 0 ? z ? String.format(Locale.US, "%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%d:%02d", Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public static String formatFullDuration(int i) {
        int i2 = i / 3600;
        int i3 = (i / 60) % 60;
        int i4 = i % 60;
        return i < 0 ? String.format(Locale.US, "-%02d:%02d:%02d", Integer.valueOf(Math.abs(i2)), Integer.valueOf(Math.abs(i3)), Integer.valueOf(Math.abs(i4))) : String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public static String formatDurationNoHours(int i, boolean z) {
        int i2 = i / 60;
        int i3 = i % 60;
        return z ? String.format(Locale.US, "%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3)) : String.format(Locale.US, "%d:%02d", Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String formatShortDuration(int i, int i2) {
        return formatDuration(i, i2, false);
    }

    public static String formatLongDuration(int i, int i2) {
        return formatDuration(i, i2, true);
    }

    public static String formatDuration(int i, int i2, boolean z) {
        int i3 = i2 / 3600;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 % 60;
        int i6 = i / 3600;
        int i7 = (i / 60) % 60;
        int i8 = i % 60;
        return i2 == 0 ? i6 == 0 ? z ? String.format(Locale.US, "%02d:%02d / -:--", Integer.valueOf(i7), Integer.valueOf(i8)) : String.format(Locale.US, "%d:%02d / -:--", Integer.valueOf(i7), Integer.valueOf(i8)) : String.format(Locale.US, "%d:%02d:%02d / -:--", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)) : (i6 == 0 && i3 == 0) ? z ? String.format(Locale.US, "%02d:%02d / %02d:%02d", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%d:%02d / %d:%02d", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%d:%02d:%02d / %d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static String formatVideoDuration(int i, int i2) {
        int i3 = i2 / 3600;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 % 60;
        int i6 = i / 3600;
        int i7 = (i / 60) % 60;
        int i8 = i % 60;
        return (i6 == 0 && i3 == 0) ? String.format(Locale.US, "%02d:%02d / %02d:%02d", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i4), Integer.valueOf(i5)) : i3 == 0 ? String.format(Locale.US, "%d:%02d:%02d / %02d:%02d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i4), Integer.valueOf(i5)) : i6 == 0 ? String.format(Locale.US, "%02d:%02d / %d:%02d:%02d", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%d:%02d:%02d / %d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static String formatCount(int i) {
        if (i < 1000) {
            return Integer.toString(i);
        }
        ArrayList arrayList = new ArrayList();
        while (i != 0) {
            int i2 = i % CloseCodes.NORMAL_CLOSURE;
            i /= CloseCodes.NORMAL_CLOSURE;
            if (i > 0) {
                arrayList.add(String.format(Locale.ENGLISH, "%03d", Integer.valueOf(i2)));
            } else {
                arrayList.add(Integer.toString(i2));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            sb.append((String) arrayList.get(size));
            if (size != 0) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String formatWholeNumber(int i, int i2) {
        if (i == 0) {
            return "0";
        }
        float f = i;
        if (i2 == 0) {
            i2 = i;
        }
        if (i2 < 1000) {
            return formatCount(i);
        }
        int i3 = 0;
        while (i2 >= 1000 && i3 < numbersSignatureArray.length - 1) {
            i2 /= CloseCodes.NORMAL_CLOSURE;
            f /= 1000.0f;
            i3++;
        }
        if (f < 0.1d) {
            return "0";
        }
        float f2 = f * 10.0f;
        float f3 = (int) f2;
        return f2 == f3 ? String.format(Locale.ENGLISH, "%s%s", formatCount((int) f), numbersSignatureArray[i3]) : String.format(Locale.ENGLISH, "%.1f%s", Float.valueOf(f3 / 10.0f), numbersSignatureArray[i3]);
    }

    public static byte[] decodeQuotedPrintable(byte[] bArr) throws IOException {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == 61) {
                int i2 = i + 1;
                try {
                    int iDigit = Character.digit((char) bArr[i2], 16);
                    i = i2 + 1;
                    byteArrayOutputStream.write((char) ((iDigit << 4) + Character.digit((char) bArr[i], 16)));
                } catch (Exception e) {
                    FileLog.e(e);
                    return null;
                }
            } else {
                byteArrayOutputStream.write(b);
            }
            i++;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        return byteArray;
    }

    public static boolean copyFile(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                Thread.yield();
                fileOutputStream.write(bArr, 0, i);
            } else {
                fileOutputStream.close();
                return true;
            }
        }
    }

    public static boolean copyFile(File file, File file2) throws IOException {
        if (file.equals(file2)) {
            return true;
        }
        if (!file2.exists()) {
            file2.createNewFile();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.getChannel().transferFrom(fileInputStream.getChannel(), 0L, fileInputStream.getChannel().size());
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused2) {
                }
                throw th2;
            }
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    public static byte[] calcAuthKeyHash(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(Utilities.computeSHA1(bArr), 0, bArr2, 0, 16);
        return bArr2;
    }

    public static void openDocument(MessageObject messageObject, Activity activity, BaseFragment baseFragment) {
        TLRPC$Document document;
        String mimeTypeFromExtension;
        if (messageObject == null || (document = messageObject.getDocument()) == null) {
            return;
        }
        String attachFileName = messageObject.messageOwner.media != null ? FileLoader.getAttachFileName(document) : io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        String str = messageObject.messageOwner.attachPath;
        File file = (str == null || str.length() == 0) ? null : new File(messageObject.messageOwner.attachPath);
        if (file == null || !file.exists()) {
            file = FileLoader.getPathToMessage(messageObject.messageOwner);
        }
        if (file == null || !file.exists()) {
            return;
        }
        if (baseFragment != null && file.getName().toLowerCase().endsWith("attheme")) {
            Theme.ThemeInfo themeInfoApplyThemeFile = Theme.applyThemeFile(file, messageObject.getDocumentName(), null, true);
            if (themeInfoApplyThemeFile != null) {
                baseFragment.presentFragment(new ThemePreviewActivity(themeInfoApplyThemeFile));
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(LocaleController.getString("AppName", ir.medu.shad.R.string.AppName));
            builder.setMessage(LocaleController.getString("IncorrectTheme", ir.medu.shad.R.string.IncorrectTheme));
            builder.setPositiveButton(LocaleController.getString("OK", ir.medu.shad.R.string.OK), null);
            baseFragment.showDialog(builder.create());
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(1);
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            int iLastIndexOf = attachFileName.lastIndexOf(46);
            if (iLastIndexOf == -1 || ((mimeTypeFromExtension = singleton.getMimeTypeFromExtension(attachFileName.substring(iLastIndexOf + 1).toLowerCase())) == null && ((mimeTypeFromExtension = document.mime_type) == null || mimeTypeFromExtension.length() == 0))) {
                mimeTypeFromExtension = null;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setDataAndType(FileProvider.getUriForFile(activity, "ir.medu.shad.provider", file), mimeTypeFromExtension != null ? mimeTypeFromExtension : "text/plain");
            } else {
                intent.setDataAndType(Uri.fromFile(file), mimeTypeFromExtension != null ? mimeTypeFromExtension : "text/plain");
            }
            if (mimeTypeFromExtension != null) {
                try {
                    activity.startActivityForResult(intent, HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
                    return;
                } catch (Exception unused) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.setDataAndType(FileProvider.getUriForFile(activity, "ir.medu.shad.provider", file), "text/plain");
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), "text/plain");
                    }
                    activity.startActivityForResult(intent, HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
                    return;
                }
            }
            activity.startActivityForResult(intent, HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
        } catch (Exception unused2) {
            if (activity == null) {
                return;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(activity);
            builder2.setTitle(LocaleController.getString("AppName", ir.medu.shad.R.string.AppName));
            builder2.setPositiveButton(LocaleController.getString("OK", ir.medu.shad.R.string.OK), null);
            builder2.setMessage(LocaleController.formatString("NoHandleAppInstalled", ir.medu.shad.R.string.NoHandleAppInstalled, messageObject.getDocument().mime_type));
            if (baseFragment != null) {
                baseFragment.showDialog(builder2.create());
            } else {
                builder2.show();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0070 A[PHI: r0
      0x0070: PHI (r0v10 java.lang.String) = (r0v9 java.lang.String), (r0v13 java.lang.String) binds: [B:18:0x0057, B:25:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean openForView(org.rbmain.messenger.MessageObject r8, final android.app.Activity r9) {
        /*
            java.lang.String r0 = r8.getFileName()
            org.rbmain.tgnet.TLRPC$Message r1 = r8.messageOwner
            java.lang.String r1 = r1.attachPath
            r2 = 0
            if (r1 == 0) goto L1b
            int r1 = r1.length()
            if (r1 == 0) goto L1b
            java.io.File r1 = new java.io.File
            org.rbmain.tgnet.TLRPC$Message r3 = r8.messageOwner
            java.lang.String r3 = r3.attachPath
            r1.<init>(r3)
            goto L1c
        L1b:
            r1 = r2
        L1c:
            if (r1 == 0) goto L24
            boolean r3 = r1.exists()
            if (r3 != 0) goto L2a
        L24:
            org.rbmain.tgnet.TLRPC$Message r1 = r8.messageOwner
            java.io.File r1 = org.rbmain.messenger.FileLoader.getPathToMessage(r1)
        L2a:
            if (r1 == 0) goto Ld8
            boolean r3 = r1.exists()
            if (r3 == 0) goto Ld8
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.VIEW"
            r3.<init>(r4)
            r4 = 1
            r3.setFlags(r4)
            android.webkit.MimeTypeMap r5 = android.webkit.MimeTypeMap.getSingleton()
            r6 = 46
            int r6 = r0.lastIndexOf(r6)
            r7 = -1
            if (r6 == r7) goto L71
            int r6 = r6 + r4
            java.lang.String r0 = r0.substring(r6)
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r0 = r5.getMimeTypeFromExtension(r0)
            if (r0 != 0) goto L70
            int r5 = r8.type
            r6 = 9
            if (r5 == r6) goto L61
            if (r5 != 0) goto L67
        L61:
            org.rbmain.tgnet.TLRPC$Document r0 = r8.getDocument()
            java.lang.String r0 = r0.mime_type
        L67:
            if (r0 == 0) goto L71
            int r5 = r0.length()
            if (r5 != 0) goto L70
            goto L71
        L70:
            r2 = r0
        L71:
            if (r2 == 0) goto L92
            java.lang.String r0 = "application/vnd.android.package-archive"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L92
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r8)
            int r8 = r8.currentAccount
            org.rbmain.messenger.AccountInstance r8 = org.rbmain.messenger.AccountInstance.getInstance(r8)
            org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda16 r1 = new org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda16
            r1.<init>()
            org.rbmain.messenger.MediaController.saveFilesFromMessages(r9, r8, r0, r1)
            return r4
        L92:
            int r8 = android.os.Build.VERSION.SDK_INT
            java.lang.String r0 = "ir.medu.shad.provider"
            r5 = 24
            java.lang.String r6 = "text/plain"
            if (r8 < r5) goto La9
            android.net.Uri r8 = androidx.core.content.FileProvider.getUriForFile(r9, r0, r1)
            if (r2 == 0) goto La4
            r7 = r2
            goto La5
        La4:
            r7 = r6
        La5:
            r3.setDataAndType(r8, r7)
            goto Lb5
        La9:
            android.net.Uri r8 = android.net.Uri.fromFile(r1)
            if (r2 == 0) goto Lb1
            r7 = r2
            goto Lb2
        Lb1:
            r7 = r6
        Lb2:
            r3.setDataAndType(r8, r7)
        Lb5:
            r8 = 500(0x1f4, float:7.0E-43)
            if (r2 == 0) goto Ld4
            r9.startActivityForResult(r3, r8)     // Catch: java.lang.Exception -> Lbd
            goto Ld7
        Lbd:
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r5) goto Lc9
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r9, r0, r1)
            r3.setDataAndType(r0, r6)
            goto Ld0
        Lc9:
            android.net.Uri r0 = android.net.Uri.fromFile(r1)
            r3.setDataAndType(r0, r6)
        Ld0:
            r9.startActivityForResult(r3, r8)
            goto Ld7
        Ld4:
            r9.startActivityForResult(r3, r8)
        Ld7:
            return r4
        Ld8:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.AndroidUtilities.openForView(org.rbmain.messenger.MessageObject, android.app.Activity):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$openForView$6(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        try {
            activity.startActivity(Intent.createChooser(new Intent("android.intent.action.VIEW_DOWNLOADS"), LocaleController.getString("OpenInExternalApp", ir.medu.shad.R.string.OpenInExternalApp)));
        } catch (Exception unused) {
            Toast.makeText(activity, LocaleController.getString("NoHandleAppInstalled", ir.medu.shad.R.string.NoHandleAppInstalled), 0).show();
        }
    }

    public static CharSequence replaceTwoNewLinesToOne(CharSequence charSequence) {
        char[] cArr = new char[2];
        if (charSequence instanceof StringBuilder) {
            StringBuilder sbReplace = (StringBuilder) charSequence;
            int length = charSequence.length();
            int i = 0;
            while (i < length - 2) {
                int i2 = i + 2;
                sbReplace.getChars(i, i2, cArr, 0);
                if (cArr[0] == '\n' && cArr[1] == '\n') {
                    sbReplace = sbReplace.replace(i, i2, "\n");
                    i--;
                    length--;
                }
                i++;
            }
            return charSequence;
        }
        if (charSequence instanceof SpannableStringBuilder) {
            SpannableStringBuilder spannableStringBuilderReplace = (SpannableStringBuilder) charSequence;
            int length2 = charSequence.length();
            int i3 = 0;
            while (i3 < length2 - 2) {
                int i4 = i3 + 2;
                spannableStringBuilderReplace.getChars(i3, i4, cArr, 0);
                if (cArr[0] == '\n' && cArr[1] == '\n') {
                    spannableStringBuilderReplace = spannableStringBuilderReplace.replace(i3, i4, (CharSequence) "\n");
                    i3--;
                    length2--;
                }
                i3++;
            }
            return charSequence;
        }
        return charSequence.toString().replace("\n\n", "\n");
    }

    public static CharSequence replaceNewLines(CharSequence charSequence) {
        int i = 0;
        if (charSequence instanceof StringBuilder) {
            StringBuilder sb = (StringBuilder) charSequence;
            int length = charSequence.length();
            while (i < length) {
                if (charSequence.charAt(i) == '\n') {
                    sb.setCharAt(i, ' ');
                }
                i++;
            }
            return charSequence;
        }
        if (charSequence instanceof SpannableStringBuilder) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            int length2 = charSequence.length();
            while (i < length2) {
                if (charSequence.charAt(i) == '\n') {
                    spannableStringBuilder.replace(i, i + 1, (CharSequence) " ");
                }
                i++;
            }
            return charSequence;
        }
        return charSequence.toString().replace('\n', ' ');
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[PHI: r1
      0x0050: PHI (r1v7 java.lang.String) = (r1v6 java.lang.String), (r1v8 java.lang.String) binds: [B:13:0x003d, B:19:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean openForView(org.rbmain.tgnet.TLObject r8, android.app.Activity r9) {
        /*
            r0 = 0
            if (r8 == 0) goto L97
            if (r9 != 0) goto L7
            goto L97
        L7:
            java.lang.String r1 = org.rbmain.messenger.FileLoader.getAttachFileName(r8)
            r2 = 1
            java.io.File r3 = org.rbmain.messenger.FileLoader.getPathToAttach(r8, r2)
            if (r3 == 0) goto L97
            boolean r4 = r3.exists()
            if (r4 == 0) goto L97
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.VIEW"
            r0.<init>(r4)
            r0.setFlags(r2)
            android.webkit.MimeTypeMap r4 = android.webkit.MimeTypeMap.getSingleton()
            r5 = 46
            int r5 = r1.lastIndexOf(r5)
            r6 = -1
            r7 = 0
            if (r5 == r6) goto L51
            int r5 = r5 + r2
            java.lang.String r1 = r1.substring(r5)
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r1 = r4.getMimeTypeFromExtension(r1)
            if (r1 != 0) goto L50
            boolean r4 = r8 instanceof org.rbmain.tgnet.TLRPC$TL_document
            if (r4 == 0) goto L47
            org.rbmain.tgnet.TLRPC$TL_document r8 = (org.rbmain.tgnet.TLRPC$TL_document) r8
            java.lang.String r1 = r8.mime_type
        L47:
            if (r1 == 0) goto L51
            int r8 = r1.length()
            if (r8 != 0) goto L50
            goto L51
        L50:
            r7 = r1
        L51:
            int r8 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "ir.medu.shad.provider"
            r4 = 24
            java.lang.String r5 = "text/plain"
            if (r8 < r4) goto L68
            android.net.Uri r8 = androidx.core.content.FileProvider.getUriForFile(r9, r1, r3)
            if (r7 == 0) goto L63
            r6 = r7
            goto L64
        L63:
            r6 = r5
        L64:
            r0.setDataAndType(r8, r6)
            goto L74
        L68:
            android.net.Uri r8 = android.net.Uri.fromFile(r3)
            if (r7 == 0) goto L70
            r6 = r7
            goto L71
        L70:
            r6 = r5
        L71:
            r0.setDataAndType(r8, r6)
        L74:
            r8 = 500(0x1f4, float:7.0E-43)
            if (r7 == 0) goto L93
            r9.startActivityForResult(r0, r8)     // Catch: java.lang.Exception -> L7c
            goto L96
        L7c:
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r4) goto L88
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r9, r1, r3)
            r0.setDataAndType(r1, r5)
            goto L8f
        L88:
            android.net.Uri r1 = android.net.Uri.fromFile(r3)
            r0.setDataAndType(r1, r5)
        L8f:
            r9.startActivityForResult(r0, r8)
            goto L96
        L93:
            r9.startActivityForResult(r0, r8)
        L96:
            return r2
        L97:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.AndroidUtilities.openForView(org.rbmain.tgnet.TLObject, android.app.Activity):boolean");
    }

    public static SpannableStringBuilder formatSpannableSimple(CharSequence charSequence, CharSequence... charSequenceArr) {
        return formatSpannable(charSequence, new GenericProvider() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda14
            @Override // org.rbmain.messenger.GenericProvider
            public final Object provide(Object obj) {
                return AndroidUtilities.lambda$formatSpannableSimple$7((Integer) obj);
            }
        }, charSequenceArr);
    }

    public static SpannableStringBuilder formatSpannable(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (charSequence.toString().contains("%s")) {
            return formatSpannableSimple(charSequence, charSequenceArr);
        }
        return formatSpannable(charSequence, new GenericProvider() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda15
            @Override // org.rbmain.messenger.GenericProvider
            public final Object provide(Object obj) {
                return AndroidUtilities.lambda$formatSpannable$8((Integer) obj);
            }
        }, charSequenceArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$formatSpannable$8(Integer num) {
        return "%" + (num.intValue() + 1) + "$s";
    }

    public static SpannableStringBuilder formatSpannable(CharSequence charSequence, GenericProvider<Integer, String> genericProvider, CharSequence... charSequenceArr) {
        String string = charSequence.toString();
        SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(charSequence);
        for (int i = 0; i < charSequenceArr.length; i++) {
            String strProvide = genericProvider.provide(Integer.valueOf(i));
            int iIndexOf = string.indexOf(strProvide);
            if (iIndexOf != -1) {
                spannableStringBuilderValueOf.replace(iIndexOf, strProvide.length() + iIndexOf, charSequenceArr[i]);
                string = string.substring(0, iIndexOf) + charSequenceArr[i].toString() + string.substring(iIndexOf + strProvide.length());
            }
        }
        return spannableStringBuilderValueOf;
    }

    public static boolean isBannedForever(TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights) {
        return tLRPC$TL_chatBannedRights == null || Math.abs(((long) tLRPC$TL_chatBannedRights.until_date) - (System.currentTimeMillis() / 1000)) > 157680000;
    }

    public static void setRectToRect(Matrix matrix, RectF rectF, RectF rectF2, int i, boolean z) {
        float fHeight;
        float fWidth;
        float fHeight2;
        boolean z2;
        float f;
        float f2;
        float fHeight3;
        float fHeight4;
        if (i == 90 || i == 270) {
            fHeight = rectF2.height() / rectF.width();
            fWidth = rectF2.width();
            fHeight2 = rectF.height();
        } else {
            fHeight = rectF2.width() / rectF.width();
            fWidth = rectF2.height();
            fHeight2 = rectF.height();
        }
        float f3 = fWidth / fHeight2;
        if (fHeight < f3) {
            fHeight = f3;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            matrix.setTranslate(rectF2.left, rectF2.top);
        }
        if (i == 90) {
            matrix.preRotate(90.0f);
            matrix.preTranslate(0.0f, -rectF2.width());
        } else if (i == 180) {
            matrix.preRotate(180.0f);
            matrix.preTranslate(-rectF2.width(), -rectF2.height());
        } else if (i == 270) {
            matrix.preRotate(270.0f);
            matrix.preTranslate(-rectF2.height(), 0.0f);
        }
        if (z) {
            f = (-rectF.left) * fHeight;
            f2 = (-rectF.top) * fHeight;
        } else {
            f = rectF2.left - (rectF.left * fHeight);
            f2 = rectF2.top - (rectF.top * fHeight);
        }
        if (z2) {
            fHeight3 = rectF2.width();
            fHeight4 = rectF.width();
        } else {
            fHeight3 = rectF2.height();
            fHeight4 = rectF.height();
        }
        float f4 = (fHeight3 - (fHeight4 * fHeight)) / 2.0f;
        if (z2) {
            f += f4;
        } else {
            f2 += f4;
        }
        matrix.preScale(fHeight, fHeight);
        if (z) {
            matrix.preTranslate(f, f2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean handleProxyIntent(android.app.Activity r12, android.content.Intent r13) {
        /*
            r0 = 0
            if (r13 != 0) goto L4
            return r0
        L4:
            int r1 = r13.getFlags()     // Catch: java.lang.Exception -> Lad
            r2 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r2
            if (r1 == 0) goto Le
            return r0
        Le:
            android.net.Uri r13 = r13.getData()     // Catch: java.lang.Exception -> Lad
            if (r13 == 0) goto Lad
            java.lang.String r1 = r13.getScheme()     // Catch: java.lang.Exception -> Lad
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L87
            java.lang.String r4 = "http"
            boolean r4 = r1.equals(r4)     // Catch: java.lang.Exception -> Lad
            if (r4 != 0) goto L2c
            java.lang.String r4 = "https"
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto L87
        L2c:
            java.lang.String r1 = r13.getHost()     // Catch: java.lang.Exception -> Lad
            java.lang.String r1 = r1.toLowerCase()     // Catch: java.lang.Exception -> Lad
            java.lang.String r4 = "rbmain.me"
            boolean r4 = r1.equals(r4)     // Catch: java.lang.Exception -> Lad
            if (r4 != 0) goto L44
            java.lang.String r4 = "rbmain.dog"
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto L87
        L44:
            java.lang.String r1 = r13.getPath()     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto L87
            java.lang.String r4 = "/socks"
            boolean r4 = r1.startsWith(r4)     // Catch: java.lang.Exception -> Lad
            if (r4 != 0) goto L5a
            java.lang.String r4 = "/proxy"
            boolean r1 = r1.startsWith(r4)     // Catch: java.lang.Exception -> Lad
            if (r1 == 0) goto L87
        L5a:
            java.lang.String r1 = "server"
            java.lang.String r1 = r13.getQueryParameter(r1)     // Catch: java.lang.Exception -> Lad
            boolean r3 = checkHostForPunycode(r1)     // Catch: java.lang.Exception -> Lad
            if (r3 == 0) goto L6a
            java.lang.String r1 = java.net.IDN.toASCII(r1, r2)     // Catch: java.lang.Exception -> Lad
        L6a:
            r3 = r1
            java.lang.String r1 = "port"
            java.lang.String r1 = r13.getQueryParameter(r1)     // Catch: java.lang.Exception -> Lad
            java.lang.String r4 = "user"
            java.lang.String r4 = r13.getQueryParameter(r4)     // Catch: java.lang.Exception -> Lad
            java.lang.String r5 = "pass"
            java.lang.String r5 = r13.getQueryParameter(r5)     // Catch: java.lang.Exception -> Lad
            java.lang.String r6 = "secret"
            java.lang.String r13 = r13.getQueryParameter(r6)     // Catch: java.lang.Exception -> Lad
            r8 = r1
            r7 = r3
            r3 = r4
            goto L8b
        L87:
            r13 = r3
            r5 = r13
            r7 = r5
            r8 = r7
        L8b:
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> Lad
            if (r1 != 0) goto Lad
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Exception -> Lad
            if (r1 != 0) goto Lad
            java.lang.String r1 = ""
            if (r3 != 0) goto L9d
            r9 = r1
            goto L9e
        L9d:
            r9 = r3
        L9e:
            if (r5 != 0) goto La2
            r10 = r1
            goto La3
        La2:
            r10 = r5
        La3:
            if (r13 != 0) goto La7
            r11 = r1
            goto La8
        La7:
            r11 = r13
        La8:
            r6 = r12
            showProxyAlert(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> Lad
            return r2
        Lad:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.AndroidUtilities.handleProxyIntent(android.app.Activity, android.content.Intent):boolean");
    }

    public static boolean shouldEnableAnimation() {
        int i = Build.VERSION.SDK_INT;
        return i < 26 || i >= 28 || (!((PowerManager) ApplicationLoader.applicationContext.getSystemService("power")).isPowerSaveMode() && Settings.Global.getFloat(ApplicationLoader.applicationContext.getContentResolver(), "animator_duration_scale", 1.0f) > 0.0f);
    }

    public static void showProxyAlert(Activity activity, final String str, final String str2, final String str3, final String str4, final String str5) {
        String string;
        BottomSheet.Builder builder = new BottomSheet.Builder(activity);
        final Runnable dismissRunnable = builder.getDismissRunnable();
        builder.setApplyTopPadding(false);
        builder.setApplyBottomPadding(false);
        LinearLayout linearLayout = new LinearLayout(activity);
        builder.setCustomView(linearLayout);
        linearLayout.setOrientation(1);
        if (!TextUtils.isEmpty(str5)) {
            TextView textView = new TextView(activity);
            textView.setText(LocaleController.getString("UseProxyRubikaInfo2", ir.medu.shad.R.string.UseProxyRubikaInfo2));
            textView.setTextColor(Theme.getColor(Theme.key_dialogTextGray4));
            textView.setTextSize(1, 14.0f);
            textView.setGravity(49);
            linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 17, 8, 17, 8));
            View view = new View(activity);
            view.setBackgroundColor(Theme.getColor(Theme.key_divider));
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, 1));
        }
        for (int i = 0; i < 5; i++) {
            String str6 = null;
            if (i == 0) {
                string = LocaleController.getString("UseProxyAddress", ir.medu.shad.R.string.UseProxyAddress);
                str6 = str;
            } else if (i == 1) {
                str6 = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR + str2;
                string = LocaleController.getString("UseProxyPort", ir.medu.shad.R.string.UseProxyPort);
            } else if (i == 2) {
                string = LocaleController.getString("UseProxySecret", ir.medu.shad.R.string.UseProxySecret);
                str6 = str5;
            } else if (i == 3) {
                string = LocaleController.getString("UseProxyUsername", ir.medu.shad.R.string.UseProxyUsername);
                str6 = str3;
            } else if (i == 4) {
                string = LocaleController.getString("UseProxyPassword", ir.medu.shad.R.string.UseProxyPassword);
                str6 = str4;
            } else {
                string = null;
            }
            if (!TextUtils.isEmpty(str6)) {
                TextDetailSettingsCell textDetailSettingsCell = new TextDetailSettingsCell(activity);
                textDetailSettingsCell.setTextAndValue(str6, string, true);
                textDetailSettingsCell.getTextView().setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
                textDetailSettingsCell.getValueTextView().setTextColor(Theme.getColor(Theme.key_dialogTextGray3));
                linearLayout.addView(textDetailSettingsCell, LayoutHelper.createLinear(-1, -2));
                if (i == 2) {
                    break;
                }
            }
        }
        PickerBottomLayout pickerBottomLayout = new PickerBottomLayout(activity, false);
        pickerBottomLayout.setBackgroundColor(Theme.getColor(Theme.key_dialogBackground));
        linearLayout.addView(pickerBottomLayout, LayoutHelper.createFrame(-1, 48, 83));
        pickerBottomLayout.cancelButton.setPadding(dp(18.0f), 0, dp(18.0f), 0);
        TextView textView2 = pickerBottomLayout.cancelButton;
        int i2 = Theme.key_dialogTextBlue2;
        textView2.setTextColor(Theme.getColor(i2));
        pickerBottomLayout.cancelButton.setText(LocaleController.getString("Cancel", ir.medu.shad.R.string.Cancel).toUpperCase());
        pickerBottomLayout.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dismissRunnable.run();
            }
        });
        pickerBottomLayout.doneButtonTextView.setTextColor(Theme.getColor(i2));
        pickerBottomLayout.doneButton.setPadding(dp(18.0f), 0, dp(18.0f), 0);
        pickerBottomLayout.doneButtonBadgeTextView.setVisibility(8);
        pickerBottomLayout.doneButtonTextView.setText(LocaleController.getString("ConnectingConnectProxy", ir.medu.shad.R.string.ConnectingConnectProxy).toUpperCase());
        pickerBottomLayout.doneButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AndroidUtilities.lambda$showProxyAlert$10(str, str2, str5, str4, str3, dismissRunnable, view2);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showProxyAlert$10(String str, String str2, String str3, String str4, String str5, Runnable runnable, View view) {
        SharedConfig.ProxyInfo proxyInfo;
        SharedPreferences.Editor editorEdit = MessagesController.getGlobalMainSettings().edit();
        editorEdit.putBoolean("proxy_enabled", true);
        editorEdit.putString("proxy_ip", str);
        int iIntValue = Utilities.parseInt(str2).intValue();
        editorEdit.putInt("proxy_port", iIntValue);
        if (TextUtils.isEmpty(str3)) {
            editorEdit.remove("proxy_secret");
            if (TextUtils.isEmpty(str4)) {
                editorEdit.remove("proxy_pass");
            } else {
                editorEdit.putString("proxy_pass", str4);
            }
            if (TextUtils.isEmpty(str5)) {
                editorEdit.remove("proxy_user");
            } else {
                editorEdit.putString("proxy_user", str5);
            }
            proxyInfo = new SharedConfig.ProxyInfo(str, iIntValue, str5, str4, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        } else {
            editorEdit.remove("proxy_pass");
            editorEdit.remove("proxy_user");
            editorEdit.putString("proxy_secret", str3);
            proxyInfo = new SharedConfig.ProxyInfo(str, iIntValue, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR, io.github.inflationx.calligraphy3.BuildConfig.FLAVOR, str3);
        }
        editorEdit.apply();
        SharedConfig.currentProxy = SharedConfig.addProxy(proxyInfo);
        ConnectionsManager.setProxySettings(true, str, iIntValue, str5, str4, str3);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.proxySettingsChanged, new Object[0]);
        runnable.run();
    }

    public static String getSystemProperty(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void fixGoogleMapsBug() {
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("google_bug_154855417", 0);
        if (sharedPreferences.contains("fixed")) {
            return;
        }
        new File(ApplicationLoader.getFilesDirFixed(), "ZoomTables.data").delete();
        sharedPreferences.edit().putBoolean("fixed", true).apply();
    }

    public static CharSequence concat(CharSequence... charSequenceArr) {
        if (charSequenceArr.length == 0) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        int i = 0;
        boolean z = true;
        if (charSequenceArr.length == 1) {
            return charSequenceArr[0];
        }
        int length = charSequenceArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (charSequenceArr[i2] instanceof Spanned) {
                break;
            }
            i2++;
        }
        if (z) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int length2 = charSequenceArr.length;
            while (i < length2) {
                CharSequence charSequence = charSequenceArr[i];
                if (charSequence == null) {
                    charSequence = "null";
                }
                spannableStringBuilder.append(charSequence);
                i++;
            }
            return new SpannedString(spannableStringBuilder);
        }
        StringBuilder sb = new StringBuilder();
        int length3 = charSequenceArr.length;
        while (i < length3) {
            sb.append(charSequenceArr[i]);
            i++;
        }
        return sb.toString();
    }

    public static float[] RGBtoHSB(int i, int i2, int i3) {
        float[] fArr = new float[3];
        int iMax = Math.max(i, i2);
        if (i3 > iMax) {
            iMax = i3;
        }
        int iMin = Math.min(i, i2);
        if (i3 < iMin) {
            iMin = i3;
        }
        float f = iMax;
        float f2 = f / 255.0f;
        float f3 = 0.0f;
        float f4 = iMax != 0 ? (iMax - iMin) / f : 0.0f;
        if (f4 != 0.0f) {
            float f5 = iMax - iMin;
            float f6 = (iMax - i) / f5;
            float f7 = (iMax - i2) / f5;
            float f8 = (iMax - i3) / f5;
            float f9 = (i == iMax ? f8 - f7 : i2 == iMax ? (f6 + 2.0f) - f8 : (f7 + 4.0f) - f6) / 6.0f;
            f3 = f9 < 0.0f ? f9 + 1.0f : f9;
        }
        fArr[0] = f3;
        fArr[1] = f4;
        fArr[2] = f2;
        return fArr;
    }

    public static int HSBtoRGB(float f, float f2, float f3) {
        int i;
        int i2;
        int i3 = 0;
        if (f2 == 0.0f) {
            i3 = (int) ((f3 * 255.0f) + 0.5f);
            i = i3;
            i2 = i;
        } else {
            float fFloor = (f - ((float) Math.floor(f))) * 6.0f;
            float fFloor2 = fFloor - ((float) Math.floor(fFloor));
            float f4 = (1.0f - f2) * f3;
            float f5 = (1.0f - (f2 * fFloor2)) * f3;
            float f6 = (1.0f - (f2 * (1.0f - fFloor2))) * f3;
            int i4 = (int) fFloor;
            if (i4 == 0) {
                i3 = (int) ((f3 * 255.0f) + 0.5f);
                i = (int) ((f6 * 255.0f) + 0.5f);
            } else if (i4 == 1) {
                i3 = (int) ((f5 * 255.0f) + 0.5f);
                i = (int) ((f3 * 255.0f) + 0.5f);
            } else if (i4 != 2) {
                if (i4 == 3) {
                    i3 = (int) ((f4 * 255.0f) + 0.5f);
                    i = (int) ((f5 * 255.0f) + 0.5f);
                } else if (i4 == 4) {
                    i3 = (int) ((f6 * 255.0f) + 0.5f);
                    i = (int) ((f4 * 255.0f) + 0.5f);
                } else if (i4 != 5) {
                    i = 0;
                    i2 = 0;
                } else {
                    i3 = (int) ((f3 * 255.0f) + 0.5f);
                    i = (int) ((f4 * 255.0f) + 0.5f);
                    i2 = (int) ((f5 * 255.0f) + 0.5f);
                }
                i2 = (int) ((f3 * 255.0f) + 0.5f);
            } else {
                i3 = (int) ((f4 * 255.0f) + 0.5f);
                i = (int) ((f3 * 255.0f) + 0.5f);
                i2 = (int) ((f6 * 255.0f) + 0.5f);
            }
            i2 = (int) ((f4 * 255.0f) + 0.5f);
        }
        return ((i & 255) << 8) | (-16777216) | ((i3 & 255) << 16) | (i2 & 255);
    }

    public static float computePerceivedBrightness(int i) {
        return (((Color.red(i) * 0.2126f) + (Color.green(i) * 0.7152f)) + (Color.blue(i) * 0.0722f)) / 255.0f;
    }

    public static int getPatternColor(int i) {
        return getPatternColor(i, false);
    }

    public static int getPatternColor(int i, boolean z) {
        float[] fArrRGBtoHSB = RGBtoHSB(Color.red(i), Color.green(i), Color.blue(i));
        if (fArrRGBtoHSB[1] > 0.0f || (fArrRGBtoHSB[2] < 1.0f && fArrRGBtoHSB[2] > 0.0f)) {
            fArrRGBtoHSB[1] = Math.min(1.0f, fArrRGBtoHSB[1] + (z ? 0.15f : 0.05f) + ((1.0f - fArrRGBtoHSB[1]) * 0.1f));
        }
        if (z || fArrRGBtoHSB[2] > 0.5f) {
            fArrRGBtoHSB[2] = Math.max(0.0f, fArrRGBtoHSB[2] * 0.65f);
        } else {
            fArrRGBtoHSB[2] = Math.max(0.0f, Math.min(1.0f, 1.0f - (fArrRGBtoHSB[2] * 0.65f)));
        }
        return HSBtoRGB(fArrRGBtoHSB[0], fArrRGBtoHSB[1], fArrRGBtoHSB[2]) & (z ? -1711276033 : 1728053247);
    }

    public static int getPatternSideColor(int i) {
        float[] fArrRGBtoHSB = RGBtoHSB(Color.red(i), Color.green(i), Color.blue(i));
        fArrRGBtoHSB[1] = Math.min(1.0f, fArrRGBtoHSB[1] + 0.05f);
        if (fArrRGBtoHSB[2] > 0.5f) {
            fArrRGBtoHSB[2] = Math.max(0.0f, fArrRGBtoHSB[2] * 0.9f);
        } else {
            fArrRGBtoHSB[2] = Math.max(0.0f, fArrRGBtoHSB[2] * 0.9f);
        }
        return HSBtoRGB(fArrRGBtoHSB[0], fArrRGBtoHSB[1], fArrRGBtoHSB[2]) | (-16777216);
    }

    public static String getWallPaperUrl(Object obj) {
        if (obj instanceof TLRPC$TL_wallPaper) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) obj;
            String str = "https://" + MessagesController.getInstance(UserConfig.selectedAccount).linkPrefix + "/bg/" + tLRPC$TL_wallPaper.slug;
            StringBuilder sb = new StringBuilder();
            TLRPC$WallPaperSettings tLRPC$WallPaperSettings = tLRPC$TL_wallPaper.settings;
            if (tLRPC$WallPaperSettings != null) {
                if (tLRPC$WallPaperSettings.blur) {
                    sb.append("blur");
                }
                if (tLRPC$TL_wallPaper.settings.motion) {
                    if (sb.length() > 0) {
                        sb.append("+");
                    }
                    sb.append("motion");
                }
            }
            if (sb.length() <= 0) {
                return str;
            }
            return str + "?mode=" + sb.toString();
        }
        if (obj instanceof WallpapersListActivity.ColorWallpaper) {
            return ((WallpapersListActivity.ColorWallpaper) obj).getUrl();
        }
        return null;
    }

    public static float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    public static void makeAccessibilityAnnouncement(CharSequence charSequence) {
        AccessibilityManager accessibilityManager2 = (AccessibilityManager) ApplicationLoader.applicationContext.getSystemService("accessibility");
        if (accessibilityManager2.isEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            accessibilityEventObtain.setEventType(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
            accessibilityEventObtain.getText().add(charSequence);
            accessibilityManager2.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    public static int getOffsetColor(int i, int i2, float f, float f2) {
        int iRed = Color.red(i2);
        int iGreen = Color.green(i2);
        int iBlue = Color.blue(i2);
        int iAlpha = Color.alpha(i2);
        int iRed2 = Color.red(i);
        int iGreen2 = Color.green(i);
        int iBlue2 = Color.blue(i);
        return Color.argb((int) ((Color.alpha(i) + ((iAlpha - r7) * f)) * f2), (int) (iRed2 + ((iRed - iRed2) * f)), (int) (iGreen2 + ((iGreen - iGreen2) * f)), (int) (iBlue2 + ((iBlue - iBlue2) * f)));
    }

    public static int indexOfIgnoreCase(String str, String str2) {
        if (str2.isEmpty() || str.isEmpty()) {
            return str.indexOf(str2);
        }
        for (int i = 0; i < str.length() && str2.length() + i <= str.length(); i++) {
            int i2 = 0;
            for (int i3 = i; i3 < str.length() && i2 < str2.length() && Character.toLowerCase(str.charAt(i3)) == Character.toLowerCase(str2.charAt(i2)); i3++) {
                i2++;
            }
            if (i2 == str2.length()) {
                return i;
            }
        }
        return -1;
    }

    public static float lerp(float[] fArr, float f) {
        return lerp(fArr[0], fArr[1], f);
    }

    public static double lerp(double d, double d2, float f) {
        double d3 = f;
        Double.isNaN(d3);
        return d + (d3 * (d2 - d));
    }

    public static void lerp(RectF rectF, RectF rectF2, float f, RectF rectF3) {
        if (rectF3 != null) {
            rectF3.set(lerp(rectF.left, rectF2.left, f), lerp(rectF.top, rectF2.top, f), lerp(rectF.right, rectF2.right, f), lerp(rectF.bottom, rectF2.bottom, f));
        }
    }

    public static void lerp(Rect rect, Rect rect2, float f, Rect rect3) {
        if (rect3 != null) {
            rect3.set(lerp(rect.left, rect2.left, f), lerp(rect.top, rect2.top, f), lerp(rect.right, rect2.right, f), lerp(rect.bottom, rect2.bottom, f));
        }
    }

    public static float cascade(float f, float f2, float f3, float f4) {
        float f5 = (1.0f / f3) * f4;
        return MathUtils.clamp((f - ((f2 / f3) * (1.0f - f5))) / f5, 0.0f, 1.0f);
    }

    public static boolean hasFlagSecureFragment() {
        return flagSecureFragment != null;
    }

    public static void setFlagSecure(BaseFragment baseFragment, boolean z) {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        if (z) {
            try {
                baseFragment.getParentActivity().getWindow().setFlags(8192, 8192);
                flagSecureFragment = new WeakReference<>(baseFragment);
            } catch (Exception unused) {
            }
        } else {
            WeakReference<BaseFragment> weakReference = flagSecureFragment;
            if (weakReference == null || weakReference.get() != baseFragment) {
                return;
            }
            try {
                baseFragment.getParentActivity().getWindow().clearFlags(8192);
            } catch (Exception unused2) {
            }
            flagSecureFragment = null;
        }
    }

    public static void openSharing(BaseFragment baseFragment, String str) {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        baseFragment.showDialog(new ShareAlert(baseFragment.getParentActivity(), null, str, false, str, false));
    }

    public static boolean allowScreenCapture() {
        return SharedConfig.passcodeHash.length() == 0 || SharedConfig.allowScreenCapture;
    }

    public static File getSharingDirectory() {
        return new File(FileLoader.getDirectory(4), "sharing/");
    }

    public static String getCertificateSHA256Fingerprint() {
        try {
            return Utilities.bytesToHex(Utilities.computeSHA256(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable unused) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
    }

    public static boolean isPunctuationCharacter(char c) {
        if (charactersMap == null) {
            charactersMap = new HashSet<>();
            int i = 0;
            while (true) {
                char[] cArr = characters;
                if (i >= cArr.length) {
                    break;
                }
                charactersMap.add(Character.valueOf(cArr[i]));
                i++;
            }
        }
        return charactersMap.contains(Character.valueOf(c));
    }

    public static int getColorDistance(int i, int i2) {
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        int iRed2 = Color.red(i2);
        int i3 = (iRed + iRed2) / 2;
        int i4 = iRed - iRed2;
        int iGreen2 = iGreen - Color.green(i2);
        int iBlue2 = iBlue - Color.blue(i2);
        return ((((i3 + 512) * i4) * i4) >> 8) + (iGreen2 * 4 * iGreen2) + ((((767 - i3) * iBlue2) * iBlue2) >> 8);
    }

    public static int getAverageColor(int i, int i2) {
        return Color.argb(255, (Color.red(i) / 2) + (Color.red(i2) / 2), (Color.green(i) / 2) + (Color.green(i2) / 2), (Color.blue(i) / 2) + (Color.blue(i2) / 2));
    }

    public static void setLightStatusBar(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                if ((systemUiVisibility & 8192) == 0) {
                    decorView.setSystemUiVisibility(systemUiVisibility | 8192);
                    if (SharedConfig.noStatusBar) {
                        return;
                    }
                    window.setStatusBarColor(251658240);
                    return;
                }
                return;
            }
            if ((systemUiVisibility & 8192) != 0) {
                decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
                if (SharedConfig.noStatusBar) {
                    return;
                }
                window.setStatusBarColor(Theme.getColor(Theme.key_actionBarDefault, null, true));
            }
        }
    }

    public static void setLightNavigationBar(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 16 : systemUiVisibility & (-17));
        }
    }

    public static void setNavigationBarColor(Window window, int i) {
        setNavigationBarColor(window, i, true);
    }

    public static void setNavigationBarColor(Window window, int i, boolean z) {
        setNavigationBarColor(window, i, z, null);
    }

    public static void setNavigationBarColor(final Window window, int i, boolean z, final IntColorCallback intColorCallback) {
        ValueAnimator valueAnimator;
        if (window != null && Build.VERSION.SDK_INT >= 21) {
            HashMap<Window, ValueAnimator> map = navigationBarColorAnimators;
            if (map != null && (valueAnimator = map.get(window)) != null) {
                valueAnimator.cancel();
                navigationBarColorAnimators.remove(window);
            }
            if (!z) {
                if (intColorCallback != null) {
                    intColorCallback.run(i);
                }
                try {
                    window.setNavigationBarColor(i);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(window.getNavigationBarColor(), i);
            valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    AndroidUtilities.lambda$setNavigationBarColor$11(intColorCallback, window, valueAnimator2);
                }
            });
            valueAnimatorOfArgb.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.messenger.AndroidUtilities.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (AndroidUtilities.navigationBarColorAnimators != null) {
                        AndroidUtilities.navigationBarColorAnimators.remove(window);
                    }
                }
            });
            valueAnimatorOfArgb.setDuration(200L);
            valueAnimatorOfArgb.setInterpolator(CubicBezierInterpolator.DEFAULT);
            valueAnimatorOfArgb.start();
            if (navigationBarColorAnimators == null) {
                navigationBarColorAnimators = new HashMap<>();
            }
            navigationBarColorAnimators.put(window, valueAnimatorOfArgb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setNavigationBarColor$11(IntColorCallback intColorCallback, Window window, ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intColorCallback != null) {
            intColorCallback.run(iIntValue);
        }
        try {
            window.setNavigationBarColor(iIntValue);
        } catch (Exception unused) {
        }
    }

    public static boolean checkHostForPunycode(String str) {
        boolean z;
        boolean z2;
        try {
            int length = str.length();
            z = false;
            z2 = false;
            for (int i = 0; i < length; i++) {
                try {
                    char cCharAt = str.charAt(i);
                    if (cCharAt != '.' && cCharAt != '-' && cCharAt != '/' && cCharAt != '+' && (cCharAt < '0' || cCharAt > '9')) {
                        if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                            z2 = true;
                        } else {
                            z = true;
                        }
                        if (z && z2) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    FileLog.e(e);
                    if (z) {
                    }
                }
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
            z2 = false;
        }
        return !z && z2;
    }

    public static boolean shouldShowUrlInAlert(String str) {
        try {
            return checkHostForPunycode(Uri.parse(str).getHost());
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    public static void scrollToFragmentRow(ActionBarLayout actionBarLayout, final String str) {
        if (actionBarLayout == null || str == null) {
            return;
        }
        ArrayList<BaseFragment> arrayList = actionBarLayout.fragmentsStack;
        final BaseFragment baseFragment = arrayList.get(arrayList.size() - 1);
        try {
            Field declaredField = baseFragment.getClass().getDeclaredField("listView");
            declaredField.setAccessible(true);
            final RecyclerListView recyclerListView = (RecyclerListView) declaredField.get(baseFragment);
            recyclerListView.highlightRow(new RecyclerListView.IntReturnCallback() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda17
                @Override // org.rbmain.ui.Components.RecyclerListView.IntReturnCallback
                public final int run() {
                    return AndroidUtilities.lambda$scrollToFragmentRow$12(baseFragment, str, recyclerListView);
                }
            });
            declaredField.setAccessible(false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$scrollToFragmentRow$12(BaseFragment baseFragment, String str, RecyclerListView recyclerListView) {
        int i = -1;
        try {
            Field declaredField = baseFragment.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerListView.getLayoutManager();
            i = declaredField.getInt(baseFragment);
            linearLayoutManager.scrollToPositionWithOffset(i, dp(60.0f));
            declaredField.setAccessible(false);
            return i;
        } catch (Throwable unused) {
            return i;
        }
    }

    public static boolean checkInlinePermissions(Context context) {
        return Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(context);
    }

    public static void updateVisibleRows(RecyclerListView recyclerListView) {
        RecyclerView.Adapter adapter;
        RecyclerView.ViewHolder childViewHolder;
        if (recyclerListView == null || (adapter = recyclerListView.getAdapter()) == null) {
            return;
        }
        for (int i = 0; i < recyclerListView.getChildCount(); i++) {
            View childAt = recyclerListView.getChildAt(i);
            int childAdapterPosition = recyclerListView.getChildAdapterPosition(childAt);
            if (childAdapterPosition >= 0 && (childViewHolder = recyclerListView.getChildViewHolder(childAt)) != null && !childViewHolder.shouldIgnore()) {
                adapter.onBindViewHolder(childViewHolder, childAdapterPosition);
            }
        }
    }

    public static void updateImageViewImageAnimated(ImageView imageView, int i) {
        updateImageViewImageAnimated(imageView, ContextCompat.getDrawable(imageView.getContext(), i));
    }

    public static void updateImageViewImageAnimated(final ImageView imageView, final Drawable drawable) {
        if (imageView.getDrawable() == drawable) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AndroidUtilities.lambda$updateImageViewImageAnimated$13(imageView, atomicBoolean, drawable, valueAnimator);
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateImageViewImageAnimated$13(ImageView imageView, AtomicBoolean atomicBoolean, Drawable drawable, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float fAbs = Math.abs(fFloatValue - 0.5f) + 0.5f;
        imageView.setScaleX(fAbs);
        imageView.setScaleY(fAbs);
        if (fFloatValue < 0.5f || atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        imageView.setImageDrawable(drawable);
    }

    public static void updateViewVisibilityAnimated(View view, boolean z) {
        updateViewVisibilityAnimated(view, z, 1.0f, true);
    }

    public static void updateViewVisibilityAnimated(final View view, boolean z, float f, boolean z2) {
        if (view.getParent() == null) {
            z2 = false;
        }
        if (z && view.getTag() == null) {
            view.animate().setListener(null).cancel();
            if (z2) {
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                    view.setScaleX(f);
                    view.setScaleY(f);
                }
                view.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(150L).start();
            } else {
                view.setVisibility(0);
                view.setAlpha(1.0f);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
            }
            view.setTag(1);
            return;
        }
        if (!z && view.getTag() != null) {
            view.animate().setListener(null).cancel();
            if (z2) {
                view.animate().alpha(0.0f).scaleY(f).scaleX(f).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.messenger.AndroidUtilities.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        view.setVisibility(8);
                    }
                }).setDuration(150L).start();
            } else {
                view.setVisibility(8);
            }
            view.setTag(null);
            return;
        }
        if (z2) {
            return;
        }
        view.animate().setListener(null).cancel();
        view.setVisibility(z ? 0 : 8);
        view.setTag(z ? 1 : null);
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }

    public static int getScreenWidth() throws NoSuchMethodException, SecurityException {
        Point realScreenSize = getRealScreenSize();
        return Math.min(realScreenSize.x, realScreenSize.y);
    }

    public static int getScreenWidthTest() {
        return getRealScreenSize().x;
    }

    public static int getScreenHeight() throws NoSuchMethodException, SecurityException {
        Point realScreenSize = getRealScreenSize();
        return Math.max(realScreenSize.x, realScreenSize.y);
    }

    public static void recycleViewSafeSuppressLayout(RecyclerView recyclerView, boolean z) {
        try {
            if (recyclerView.isComputingLayout()) {
                return;
            }
            recyclerView.suppressLayout(z);
        } catch (Exception unused) {
        }
    }

    public static int countLines(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return str.split("\r\n|\r|\n").length;
    }

    public static int getNextRnd() {
        if (rnd <= 0) {
            int i = (int) AppPreferences.getInstance(0).getLong(AppPreferences.Key.rnd, 0L);
            rnd = i;
            if (i <= 0) {
                rnd = Math.abs(Utilities.random.nextInt() / 4);
            }
        }
        rnd++;
        AppPreferences.getInstance(0).setLongAsync(AppPreferences.Key.rnd, rnd);
        return rnd;
    }

    public static int getCurrentAccountTemporary() {
        return UserConfig.selectedAccount;
    }

    public static int spToPx(float f, Context context) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static Point getNavigationBarSize(Context context) throws NoSuchMethodException, SecurityException {
        Point point = navigationBarPoint;
        if (point != null) {
            return point;
        }
        Point appUsableScreenSize = getAppUsableScreenSize(context);
        Point realScreenSize = getRealScreenSize();
        if (appUsableScreenSize.x < realScreenSize.x) {
            Point point2 = new Point(realScreenSize.x - appUsableScreenSize.x, appUsableScreenSize.y);
            navigationBarPoint = point2;
            return point2;
        }
        if (appUsableScreenSize.y < realScreenSize.y) {
            Point point3 = new Point(appUsableScreenSize.x, realScreenSize.y - appUsableScreenSize.y);
            navigationBarPoint = point3;
            return point3;
        }
        return new Point();
    }

    public static Point getAppUsableScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static int getAvailableHeight(Activity activity, int i, boolean z) {
        int i2;
        int statusBarSizeForAndroidBelow10WithCutout;
        int screenHeight = (DimensionHelper.getScreenHeight(activity) - i) + (i > 0 ? getNavigationBarSizeForAndroidAbove10() : 0);
        if (z) {
            i2 = -ApplicationLoader.applicationActivity.topCutoutHeight;
            statusBarSizeForAndroidBelow10WithCutout = getDifferForAndroid8();
        } else {
            i2 = -statusBarHeight;
            statusBarSizeForAndroidBelow10WithCutout = getStatusBarSizeForAndroidBelow10WithCutout();
        }
        return screenHeight + i2 + statusBarSizeForAndroidBelow10WithCutout;
    }

    public static int getNavigationBarSizeForAndroidAbove10() {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return getNavigationBarSize(ApplicationLoader.applicationActivity).y;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getStatusBarSizeForAndroidBelow10WithCutout() {
        try {
            if (Build.VERSION.SDK_INT > 28 || ApplicationLoader.applicationActivity.topCutoutHeight <= 0) {
                return 0;
            }
            return statusBarHeight;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int getDifferForAndroid8() {
        try {
            int i = Build.VERSION.SDK_INT;
            if (i != 26 && i != 27) {
                return 0;
            }
            int iDp = dp(24.0f);
            int i2 = statusBarHeight;
            if (iDp < i2) {
                return i2 * (-2);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int px(float f) {
        if (f == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(f / density);
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String generateFileName(int i, String str) {
        Date date = new Date();
        date.setTime(System.currentTimeMillis() + Utilities.random.nextInt(CloseCodes.NORMAL_CLOSURE) + 1);
        String str2 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(date);
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("IMG_");
            sb.append(str2);
            sb.append(".");
            if (TextUtils.isEmpty(str)) {
                str = "jpg";
            }
            sb.append(str);
            return sb.toString();
        }
        return "VID_" + str2 + ".mp4";
    }

    public static long getPrefIntOrLong(SharedPreferences sharedPreferences, String str, long j) {
        try {
            return sharedPreferences.getLong(str, j);
        } catch (Exception unused) {
            return sharedPreferences.getInt(str, (int) j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void makeGlobalBlurBitmap(final org.rbmain.messenger.Utilities.Callback16<android.graphics.Bitmap> r14, float r15) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.AndroidUtilities.makeGlobalBlurBitmap(org.rbmain.messenger.Utilities$Callback16, float):void");
    }

    public static boolean isRTL(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            for (int i = 0; i < charSequence.length(); i++) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt >= 1424 && cCharAt <= 1791) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean intersect1d(int i, int i2, int i3, int i4) {
        return Math.max(i, i2) >= Math.min(i3, i4) && Math.max(i3, i4) >= Math.min(i, i2);
    }

    public static boolean isAccessibilityScreenReaderEnabled() {
        return isAccessibilityTouchExplorationEnabled();
    }

    public static boolean isAccessibilityTouchExplorationEnabled() {
        if (accessibilityManager == null) {
            accessibilityManager = (AccessibilityManager) ApplicationLoader.applicationContext.getSystemService("accessibility");
        }
        return accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    public static void recycleBitmaps(final List<Bitmap> list) {
        if (Build.VERSION.SDK_INT <= 23 || list == null || list.isEmpty()) {
            return;
        }
        runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                AndroidUtilities.lambda$recycleBitmaps$17(list);
            }
        }, 36L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$recycleBitmaps$17(final List list) {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.AndroidUtilities$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                AndroidUtilities.lambda$recycleBitmaps$16(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$recycleBitmaps$16(List list) {
        for (int i = 0; i < list.size(); i++) {
            Bitmap bitmap = (Bitmap) list.get(i);
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    bitmap.recycle();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }
    }

    public static void recycleBitmap(Bitmap bitmap) {
        recycleBitmaps(Collections.singletonList(bitmap));
    }

    public static Pair<Integer, Integer> getImageOrientation(InputStream inputStream) {
        try {
            return getImageOrientation(new ExifInterface(inputStream));
        } catch (Exception e) {
            FileLog.e(e);
            return new Pair<>(0, 0);
        }
    }

    public static Pair<Integer, Integer> getImageOrientation(File file) {
        try {
            return getImageOrientation(new ExifInterface(file));
        } catch (Exception e) {
            FileLog.e(e);
            return new Pair<>(0, 0);
        }
    }

    public static Pair<Integer, Integer> getImageOrientation(String str) {
        try {
            return getImageOrientation(new ExifInterface(str));
        } catch (Exception unused) {
            return new Pair<>(0, 0);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Pair<Integer, Integer> getImageOrientation(ExifInterface exifInterface) {
        try {
            int i = 1;
            int i2 = 270;
            switch (exifInterface.getAttributeInt("Orientation", 1)) {
                case 2:
                    i2 = 0;
                    break;
                case 3:
                    i2 = 180;
                    i = 0;
                    break;
                case 4:
                    i = 2;
                    i2 = 0;
                    break;
                case 5:
                    i = 2;
                    break;
                case 6:
                    i2 = 90;
                    i = 0;
                    break;
                case 7:
                    break;
                case 8:
                    i = 0;
                    break;
                default:
                    i = 0;
                    i2 = 0;
                    break;
            }
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i));
        } catch (Exception e) {
            FileLog.e(e);
            return new Pair<>(0, 0);
        }
    }

    protected static float cleanValue(float f, float f2) {
        return Math.min(f2, Math.max(-f2, f));
    }

    public static void multiplyBrightnessColorMatrix(ColorMatrix colorMatrix, float f) {
        if (colorMatrix == null) {
            return;
        }
        colorMatrix.postConcat(new ColorMatrix(new float[]{f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
    }

    public static Bitmap snapshotView(View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.draw(canvas);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        snapshotTextureViews(iArr[0], iArr[1], iArr, canvas, view);
        return bitmapCreateBitmap;
    }

    private static void snapshotTextureViews(int i, int i2, int[] iArr, Canvas canvas, View view) {
        if (view instanceof TextureView) {
            TextureView textureView = (TextureView) view;
            textureView.getLocationInWindow(iArr);
            Bitmap bitmap = textureView.getBitmap();
            if (bitmap != null) {
                canvas.save();
                canvas.drawBitmap(bitmap, iArr[0] - i, iArr[1] - i2, (Paint) null);
                canvas.restore();
                bitmap.recycle();
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                snapshotTextureViews(i, i2, iArr, canvas, viewGroup.getChildAt(i3));
            }
        }
    }

    public static void updateViewShow(View view, boolean z) {
        updateViewShow(view, z, true, true);
    }

    public static void updateViewShow(View view, boolean z, boolean z2, boolean z3) {
        updateViewShow(view, z, z2, 0.0f, z3, null);
    }

    public static void updateViewShow(View view, boolean z, boolean z2, boolean z3, Runnable runnable) {
        updateViewShow(view, z, z2, 0.0f, z3, runnable);
    }

    public static void updateViewShow(View view, boolean z, boolean z2, float f, boolean z3, Runnable runnable) {
        if (view == null) {
            return;
        }
        if (view.getParent() == null) {
            z3 = false;
        }
        view.animate().setListener(null).cancel();
        if (!z3) {
            view.setVisibility(z ? 0 : 8);
            view.setTag(z ? 1 : null);
            view.setAlpha(1.0f);
            view.setScaleX((!z2 || z) ? 1.0f : 0.0f);
            if (z2 && !z) {
                f = 0.0f;
            }
            view.setScaleY(f);
            if (f != 0.0f) {
                view.setTranslationY(z ? 0.0f : dp(-16.0f) * f);
            }
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (z) {
            if (view.getVisibility() != 0) {
                view.setVisibility(0);
                view.setAlpha(0.0f);
                view.setScaleX(z2 ? 0.0f : 1.0f);
                view.setScaleY(z2 ? 0.0f : 1.0f);
                if (f != 0.0f) {
                    view.setTranslationY(dp(-16.0f) * f);
                }
            }
            ViewPropertyAnimator viewPropertyAnimatorWithEndAction = view.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT).setDuration(340L).withEndAction(runnable);
            if (f != 0.0f) {
                viewPropertyAnimatorWithEndAction.translationY(0.0f);
            }
            viewPropertyAnimatorWithEndAction.start();
            return;
        }
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction2 = view.animate().alpha(0.0f).scaleY(z2 ? 0.0f : 1.0f).scaleX(z2 ? 0.0f : 1.0f).setListener(new HideViewAfterAnimation(view)).setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT).setDuration(340L).withEndAction(runnable);
        if (f != 0.0f) {
            viewPropertyAnimatorWithEndAction2.translationY(dp(-16.0f) * f);
        }
        viewPropertyAnimatorWithEndAction2.start();
    }

    public static CharSequence replaceSingleTag(String str, Runnable runnable) {
        return replaceSingleTag(str, -1, 0, runnable);
    }

    public static CharSequence replaceSingleTag(String str, final int i, int i2, final Runnable runnable) {
        int i3;
        int i4;
        int iIndexOf = str.indexOf("**");
        int iIndexOf2 = str.indexOf("**", iIndexOf + 1);
        String strReplace = str.replace("**", io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
        if (iIndexOf < 0 || iIndexOf2 < 0 || (i4 = iIndexOf2 - iIndexOf) <= 2) {
            iIndexOf = -1;
            i3 = 0;
        } else {
            i3 = i4 - 2;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strReplace);
        if (iIndexOf >= 0) {
            if (i2 == 0) {
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: org.rbmain.messenger.AndroidUtilities.5
                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                        int i5 = i;
                        if (i5 >= 0) {
                            textPaint.setColor(Theme.getColor(i5));
                        }
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        Runnable runnable2 = runnable;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                    }
                }, iIndexOf, i3 + iIndexOf, 0);
            } else {
                spannableStringBuilder.setSpan(new CharacterStyle() { // from class: org.rbmain.messenger.AndroidUtilities.6
                    @Override // android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                        int alpha = textPaint.getAlpha();
                        textPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText));
                        textPaint.setAlpha(alpha);
                    }
                }, iIndexOf, i3 + iIndexOf, 0);
            }
        }
        return spannableStringBuilder;
    }

    private static Pattern getURIParsePattern() {
        if (uriParse == null) {
            uriParse = Pattern.compile("^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?");
        }
        return uriParse;
    }

    public static String getHostAuthority(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = getURIParsePattern().matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(4);
        return strGroup != null ? strGroup.toLowerCase() : strGroup;
    }

    public static String getHostAuthority(Uri uri) {
        if (uri == null) {
            return null;
        }
        return getHostAuthority(uri.toString());
    }

    public static CharSequence trim(CharSequence charSequence, int[] iArr) {
        if (charSequence == null) {
            return null;
        }
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) <= ' ') {
            i++;
        }
        while (i < length && charSequence.charAt(length - 1) <= ' ') {
            length--;
        }
        if (iArr != null) {
            iArr[0] = i;
        }
        return (i > 0 || length < charSequence.length()) ? charSequence.subSequence(i, length) : charSequence;
    }

    public static Vibrator getVibrator() {
        if (vibrator == null) {
            vibrator = (Vibrator) ApplicationLoader.applicationContext.getSystemService("vibrator");
        }
        return vibrator;
    }

    public static Bitmap getScaledBitmap(float f, float f2, String str, String str2, int i) throws IOException {
        FileInputStream fileInputStream;
        BitmapFactory.Options options;
        int i2;
        int i3;
        Bitmap bitmapDecodeStream;
        int i4;
        try {
            try {
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if (str != null) {
                    BitmapFactory.decodeFile(str, options);
                    fileInputStream = null;
                } else {
                    fileInputStream = new FileInputStream(str2);
                    try {
                        fileInputStream.getChannel().position(i);
                        BitmapFactory.decodeStream(fileInputStream, null, options);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            FileLog.e(th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e) {
                                    FileLog.e(e);
                                }
                            }
                        }
                    }
                }
                i2 = options.outWidth;
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        if (i2 <= 0 || (i3 = options.outHeight) <= 0) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        }
        if (f > f2 && i2 < i3) {
            f2 = f;
            f = f2;
        }
        float fMin = Math.min(i2 / f, i3 / f2);
        options.inSampleSize = 1;
        if (fMin > 1.0f) {
            do {
                i4 = options.inSampleSize * 2;
                options.inSampleSize = i4;
            } while (i4 < fMin);
        }
        options.inJustDecodeBounds = false;
        if (str != null) {
            bitmapDecodeStream = BitmapFactory.decodeFile(str, options);
        } else {
            fileInputStream.getChannel().position(i);
            bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
        }
        return bitmapDecodeStream;
    }

    public static CharSequence replaceCharSequence(String str, CharSequence charSequence, CharSequence charSequence2) {
        SpannableStringBuilder spannableStringBuilder;
        if (charSequence instanceof SpannableStringBuilder) {
            spannableStringBuilder = (SpannableStringBuilder) charSequence;
        } else {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        }
        int iIndexOf = TextUtils.indexOf(charSequence, str);
        if (iIndexOf >= 0) {
            spannableStringBuilder.replace(iIndexOf, str.length() + iIndexOf, charSequence2);
        }
        return spannableStringBuilder;
    }
}
