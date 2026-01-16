package ir.eitaa.messenger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.android.internal.telephony.ITelephony;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_restrictionReason;
import ir.eitaa.tgnet.TLRPC$TL_userContact_old2;
import ir.eitaa.tgnet.TLRPC$TL_wallPaper;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WallPaperSettings;
import ir.eitaa.ui.ActionBar.ActionBarLayout;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.TextDetailSettingsCell;
import ir.eitaa.ui.Components.BackgroundGradientDrawable;
import ir.eitaa.ui.Components.ForegroundColorSpanThemable;
import ir.eitaa.ui.Components.ForegroundDetector;
import ir.eitaa.ui.Components.HideViewAfterAnimation;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.MotionBackgroundDrawable;
import ir.eitaa.ui.Components.PickerBottomLayout;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ShareAlert;
import ir.eitaa.ui.Components.TypefaceSpan;
import ir.eitaa.ui.ThemePreviewActivity;
import ir.eitaa.ui.WallpapersListActivity;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.linphone.mediastream.Factory;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class AndroidUtilities {
    public static Pattern BAD_CHARS_MESSAGE_LONG_PATTERN = null;
    public static Pattern BAD_CHARS_MESSAGE_PATTERN = null;
    public static Pattern BAD_CHARS_PATTERN = null;
    public static final int FLAG_TAG_ALL = 11;
    public static final int FLAG_TAG_BOLD = 2;
    public static final int FLAG_TAG_BR = 1;
    public static final int FLAG_TAG_COLOR = 4;
    public static final int FLAG_TAG_URL = 8;
    public static final String STICKERS_PLACEHOLDER_PACK_NAME = "tg_placeholders_android";
    public static Pattern WEB_URL;
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
    public static final String[] numbersSignatureArray;
    public static int roundMessageInset;
    public static int roundMessageSize;
    private static Paint roundPaint;
    public static int roundPlayingMessageSize;
    public static final Linkify.MatchFilter sUrlMatchFilter;
    static Typeface typefaceBold;
    static Typeface typefaceBoldItalic;
    static Typeface typefaceItalic;
    static Typeface typefaceRegular;
    private static Runnable unregisterRunnable;
    public static boolean usingHardwareInput;
    private ExecutorService executorService = Executors.newCachedThreadPool();
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
    public static Integer photoSize = null;
    public static DisplayMetrics displayMetrics = new DisplayMetrics();
    public static DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
    public static AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
    public static OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
    private static Boolean isTablet = null;
    private static int adjustOwnerClassGuid = 0;
    public static final RectF rectTmp = new RectF();

    public static void checkForUpdates() {
    }

    public static int compare(int lhs, int rhs) {
        if (lhs == rhs) {
            return 0;
        }
        return lhs > rhs ? 1 : -1;
    }

    public static int compare(long lhs, long rhs) {
        if (lhs == rhs) {
            return 0;
        }
        return lhs > rhs ? 1 : -1;
    }

    public static int getMyLayerVersion(int layer) {
        return layer & 65535;
    }

    public static int getWallpaperRotation(int angle, boolean iOS) {
        int i = iOS ? angle + 180 : angle - 180;
        while (i >= 360) {
            i -= 360;
        }
        while (i < 0) {
            i += 360;
        }
        return i;
    }

    public static boolean isGoogleMapsInstalled(final BaseFragment fragment) {
        return true;
    }

    public static boolean isValidWallChar(char ch) {
        return ch == '-' || ch == '~';
    }

    public static float lerp(float a, float b, float f) {
        return a + (f * (b - a));
    }

    public static long makeBroadcastId(int id) {
        return (id & 4294967295L) | 4294967296L;
    }

    public static int setMyLayerVersion(int layer, int version) {
        return (layer & (-65536)) | version;
    }

    public static int setPeerLayerVersion(int layer, int version) {
        return (layer & 65535) | (version << 16);
    }

    public static void startAppCenter(Activity context) {
    }

    static {
        WEB_URL = null;
        BAD_CHARS_PATTERN = null;
        BAD_CHARS_MESSAGE_PATTERN = null;
        BAD_CHARS_MESSAGE_LONG_PATTERN = null;
        try {
            BAD_CHARS_PATTERN = Pattern.compile("[─-◿]");
            BAD_CHARS_MESSAGE_LONG_PATTERN = Pattern.compile("[̀-ͯ\u2066-\u2067]+");
            BAD_CHARS_MESSAGE_PATTERN = Pattern.compile("[\u2066-\u2067]+");
            WEB_URL = Pattern.compile("((?:(http|https|Http|Https|ton|tg):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:" + Pattern.compile("(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|" + Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))") + ")") + ")(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        } catch (Exception e) {
            FileLog.e(e);
        }
        leftBaseline = isTablet() ? 80 : 72;
        checkDisplaySize(ApplicationLoader.applicationContext, null);
        documentIcons = new int[]{R.drawable.media_doc_blue, R.drawable.media_doc_green, R.drawable.media_doc_red, R.drawable.media_doc_yellow};
        documentMediaIcons = new int[]{R.drawable.media_doc_blue_b, R.drawable.media_doc_green_b, R.drawable.media_doc_red_b, R.drawable.media_doc_yellow_b};
        sUrlMatchFilter = new Linkify.MatchFilter() { // from class: ir.eitaa.messenger.-$$Lambda$AndroidUtilities$XTDHpLBs7MI_WI1JXxhDb_c9D38
            @Override // android.text.util.Linkify.MatchFilter
            public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
                return AndroidUtilities.lambda$static$0(charSequence, i, i2);
            }
        };
        typefaceRegular = null;
        typefaceBold = null;
        typefaceItalic = null;
        typefaceBoldItalic = null;
        hasCallPermissions = Build.VERSION.SDK_INT >= 23;
        numbersSignatureArray = new String[]{"", "K", "M", "G", "T", "P"};
        characters = new char[]{160, ' ', '!', '\"', '#', '%', '&', '\'', '(', ')', '*', ',', '-', '.', '/', ':', ';', '?', '@', '[', '\\', ']', '_', '{', '}', 161, 167, 171, 182, 183, 187, 191, 894, 903, 1370, 1371, 1372, 1373, 1374, 1375, 1417, 1418, 1470, 1472, 1475, 1478, 1523, 1524, 1545, 1546, 1548, 1549, 1563, 1566, 1567, 1642, 1643, 1644, 1645, 1748, 1792, 1793, 1794, 1795, 1796, 1797, 1798, 1799, 1800, 1801, 1802, 1803, 1804, 1805, 2039, 2040, 2041, 2096, 2097, 2098, 2099, 2100, 2101, 2102, 2103, 2104, 2105, 2106, 2107, 2108, 2109, 2110, 2142, 2404, 2405, 2416, 2557, 2678, 2800, 3191, 3204, 3572, 3663, 3674, 3675, 3844, 3845, 3846, 3847, 3848, 3849, 3850, 3851, 3852, 3853, 3854, 3855, 3856, 3857, 3858, 3860, 3898, 3899, 3900, 3901, 3973, 4048, 4049, 4050, 4051, 4052, 4057, 4058, 4170, 4171, 4172, 4173, 4174, 4175, 4347, 4960, 4961, 4962, 4963, 4964, 4965, 4966, 4967, 4968, 5120, 5742, 5787, 5788, 5867, 5868, 5869, 5941, 5942, 6100, 6101, 6102, 6104, 6105, 6106, 6144, 6145, 6146, 6147, 6148, 6149, 6150, 6151, 6152, 6153, 6154, 6468, 6469, 6686, 6687, 6816, 6817, 6818, 6819, 6820, 6821, 6822, 6824, 6825, 6826, 6827, 6828, 6829, 7002, 7003, 7004, 7005, 7006, 7007, 7008, 7164, 7165, 7166, 7167, 7227, 7228, 7229, 7230, 7231, 7294, 7295, 7360, 7361, 7362, 7363, 7364, 7365, 7366, 7367, 7379, 8208, 8209, 8210, 8211, 8212, 8213, 8214, 8215, 8216, 8217, 8218, 8219, 8220, 8221, 8222, 8223, 8224, 8225, 8226, 8227, 8228, 8229, 8230, 8231, 8240, 8241, 8242, 8243, 8244, 8245, 8246, 8247, 8248, 8249, 8250, 8251, 8252, 8253, 8254, 8255, 8256, 8257, 8258, 8259, 8261, 8262, 8263, 8264, 8265, 8266, 8267, 8268, 8269, 8270, 8271, 8272, 8273, 8275, 8276, 8277, 8278, 8279, 8280, 8281, 8282, 8283, 8284, 8285, 8286, 8317, 8318, 8333, 8334, 8968, 8969, 8970, 8971, 9001, 9002, 10088, 10089, 10090, 10091, 10092, 10093, 10094, 10095, 10096, 10097, 10098, 10099, 10100, 10101, 10181, 10182, 10214, 10215, 10216, 10217, 10218, 10219, 10220, 10221, 10222, 10223, 10627, 10628, 10629, 10630, 10631, 10632, 10633, 10634, 10635, 10636, 10637, 10638, 10639, 10640, 10641, 10642, 10643, 10644, 10645, 10646, 10647, 10648, 10712, 10713, 10714, 10715, 10748, 10749, 11513, 11514, 11515, 11516, 11518, 11519, 11632, 11776, 11777, 11778, 11779, 11780, 11781, 11782, 11783, 11784, 11785, 11786, 11787, 11788, 11789, 11790, 11791, 11792, 11793, 11794, 11795, 11796, 11797, 11798, 11799, 11800, 11801, 11802, 11803, 11804, 11805, 11806, 11807, 11808, 11809, 11810, 11811, 11812, 11813, 11814, 11815, 11816, 11817, 11818, 11819, 11820, 11821, 11822, 11824, 11825, 11826, 11827, 11828, 11829, 11830, 11831, 11832, 11833, 11834, 11835, 11836, 11837, 11838, 11839, 11840, 11841, 11842, 11843, 11844, 11845, 11846, 11847, 11848, 11849, 11850, 11851, 11852, 11853, 11854, 11855, 12289, 12290, 12291, 12296, 12297, 12298, 12299, 12300, 12301, 12302, 12303, 12304, 12305, 12308, 12309, 12310, 12311, 12312, 12313, 12314, 12315, 12316, 12317, 12318, 12319, 12336, 12349, 12448, 12539, 42238, 42239, 42509, 42510, 42511, 42611, 42622, 42738, 42739, 42740, 42741, 42742, 42743, 43124, 43125, 43126, 43127, 43214, 43215, 43256, 43257, 43258, 43260, 43310, 43311, 43359, 43457, 43458, 43459, 43460, 43461, 43462, 43463, 43464, 43465, 43466, 43467, 43468, 43469, 43486, 43487, 43612, 43613, 43614, 43615, 43742, 43743, 43760, 43761, 44011, 64830, 64831, 65040, 65041, 65042, 65043, 65044, 65045, 65046, 65047, 65048, 65049, 65072, 65073, 65074, 65075, 65076, 65077, 65078, 65079, 65080, 65081, 65082, 65083, 65084, 65085, 65086, 65087, 65088, 65089, 65090, 65091, 65092, 65093, 65094, 65095, 65096, 65097, 65098, 65099, 65100, 65101, 65102, 65103, 65104, 65105, 65106, 65108, 65109, 65110, 65111, 65112, 65113, 65114, 65115, 65116, 65117, 65118, 65119, 65120, 65121, 65123, 65128, 65130, 65131, 65281, 65282, 65283, 65285, 65286, 65287, 65288, 65289, 65290, 65292, 65293, 65294, 65295, 65306, 65307, 65311, 65312, 65339, 65340, 65341, 65343, 65371, 65373, 65375, 65376, 65377, 65378, 65379, 65380, 65381};
    }

    private static boolean containsUnsupportedCharacters(String text) {
        if (text.contains("\u202c") || text.contains("\u202d") || text.contains("\u202e")) {
            return true;
        }
        try {
            return BAD_CHARS_PATTERN.matcher(text).find();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static String getSafeString(String str) {
        try {
            return BAD_CHARS_MESSAGE_PATTERN.matcher(str).replaceAll("\u200c");
        } catch (Throwable unused) {
            return str;
        }
    }

    public static CharSequence ellipsizeCenterEnd(CharSequence str, String query, int availableWidth, TextPaint textPaint, int maxSymbols) {
        int iIndexOf;
        StaticLayout staticLayout;
        float lineWidth;
        float f;
        CharSequence charSequenceSubSequence;
        try {
            int length = str.length();
            iIndexOf = str.toString().toLowerCase().indexOf(query);
            if (length > maxSymbols) {
                str = str.subSequence(Math.max(0, iIndexOf - (maxSymbols / 2)), Math.min(length, (maxSymbols / 2) + iIndexOf));
                iIndexOf -= Math.max(0, iIndexOf - (maxSymbols / 2));
                str.length();
            }
            staticLayout = new StaticLayout(str, textPaint, ConnectionsManager.DEFAULT_DATACENTER_ID, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            lineWidth = staticLayout.getLineWidth(0);
            f = availableWidth;
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (textPaint.measureText("...") + lineWidth < f) {
            return str;
        }
        int i = iIndexOf + 1;
        int i2 = i;
        while (i2 < str.length() - 1 && !Character.isWhitespace(str.charAt(i2))) {
            i2++;
        }
        float primaryHorizontal = staticLayout.getPrimaryHorizontal(i2);
        if (staticLayout.isRtlCharAt(i2)) {
            primaryHorizontal = lineWidth - primaryHorizontal;
        }
        if (primaryHorizontal < f) {
            return str;
        }
        float fMeasureText = (primaryHorizontal - f) + (textPaint.measureText("...") * 2.0f);
        float f2 = 0.1f * f;
        float f3 = fMeasureText + f2;
        if (str.length() - i2 > 20) {
            f3 += f2;
        }
        if (f3 > 0.0f) {
            int offsetForHorizontal = staticLayout.getOffsetForHorizontal(0, f3);
            if (offsetForHorizontal > str.length() - 1) {
                offsetForHorizontal = str.length() - 1;
            }
            int i3 = 0;
            while (true) {
                if (Character.isWhitespace(str.charAt(offsetForHorizontal)) || i3 >= 10) {
                    break;
                }
                i3++;
                offsetForHorizontal++;
                if (offsetForHorizontal > str.length() - 1) {
                    offsetForHorizontal = staticLayout.getOffsetForHorizontal(0, f3);
                    break;
                }
            }
            if (i3 >= 10) {
                charSequenceSubSequence = str.subSequence(staticLayout.getOffsetForHorizontal(0, staticLayout.getPrimaryHorizontal(i) - (f * 0.3f)), str.length());
            } else {
                if (offsetForHorizontal > 0 && offsetForHorizontal < str.length() - 2 && Character.isWhitespace(str.charAt(offsetForHorizontal))) {
                    offsetForHorizontal++;
                }
                charSequenceSubSequence = str.subSequence(offsetForHorizontal, str.length());
            }
            return SpannableStringBuilder.valueOf("...").append(charSequenceSubSequence);
        }
        return str;
    }

    public static CharSequence highlightText(CharSequence str, ArrayList<String> query, Theme.ResourcesProvider resourcesProvider) {
        if (query == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < query.size(); i2++) {
            CharSequence charSequenceHighlightText = highlightText(str, query.get(i2), resourcesProvider);
            if (charSequenceHighlightText != null) {
                str = charSequenceHighlightText;
            } else {
                i++;
            }
        }
        if (i == query.size()) {
            return null;
        }
        return str;
    }

    public static CharSequence highlightText(CharSequence str, String query, Theme.ResourcesProvider resourcesProvider) {
        if (TextUtils.isEmpty(query) || TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.toString().toLowerCase();
        SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(str);
        int iIndexOf = lowerCase.indexOf(query);
        while (iIndexOf >= 0) {
            try {
                spannableStringBuilderValueOf.setSpan(new ForegroundColorSpanThemable("windowBackgroundWhiteBlueText4", resourcesProvider), iIndexOf, Math.min(query.length() + iIndexOf, str.length()), 0);
            } catch (Exception e) {
                FileLog.e(e);
            }
            iIndexOf = lowerCase.indexOf(query, iIndexOf + 1);
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

    /* JADX INFO: Access modifiers changed from: private */
    static class LinkSpec {
        int end;
        int start;
        String url;

        private LinkSpec() {
        }
    }

    private static String makeUrl(String url, String[] prefixes, Matcher matcher) {
        boolean z;
        int i = 0;
        while (true) {
            z = true;
            if (i >= prefixes.length) {
                z = false;
                break;
            }
            if (!url.regionMatches(true, 0, prefixes[i], 0, prefixes[i].length())) {
                i++;
            } else if (!url.regionMatches(false, 0, prefixes[i], 0, prefixes[i].length())) {
                url = prefixes[i] + url.substring(prefixes[i].length());
            }
        }
        if (z || prefixes.length <= 0) {
            return url;
        }
        return prefixes[0] + url;
    }

    private static void gatherLinks(ArrayList<LinkSpec> links, Spannable s, Pattern pattern, String[] schemes, Linkify.MatchFilter matchFilter, boolean internalOnly) {
        if (TextUtils.indexOf((CharSequence) s, (char) 9472) >= 0) {
            s = new SpannableStringBuilder(s.toString().replace((char) 9472, ' '));
        }
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(s, iStart, iEnd)) {
                LinkSpec linkSpec = new LinkSpec();
                String strMakeUrl = makeUrl(matcher.group(0), schemes, matcher);
                if (!internalOnly || Browser.isInternalUrl(strMakeUrl, true, null)) {
                    linkSpec.url = strMakeUrl;
                    linkSpec.start = iStart;
                    linkSpec.end = iEnd;
                    links.add(linkSpec);
                }
            }
        }
    }

    static /* synthetic */ boolean lambda$static$0(CharSequence charSequence, int i, int i2) {
        return i == 0 || charSequence.charAt(i - 1) != '@';
    }

    public static boolean addLinks(Spannable text, int mask) {
        return addLinks(text, mask, false);
    }

    public static boolean addLinks(Spannable text, int mask, boolean internalOnly) {
        if (text == null || containsUnsupportedCharacters(text.toString()) || mask == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) text.getSpans(0, text.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            text.removeSpan(uRLSpanArr[length]);
        }
        ArrayList arrayList = new ArrayList();
        if (!internalOnly && (mask & 4) != 0) {
            Linkify.addLinks(text, 4);
        }
        if ((mask & 1) != 0) {
            gatherLinks(arrayList, text, LinkifyPort.WEB_URL, new String[]{"http://", "https://", "ton://", "et://"}, sUrlMatchFilter, internalOnly);
        }
        pruneOverlaps(arrayList);
        if (arrayList.size() == 0) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            LinkSpec linkSpec = (LinkSpec) arrayList.get(i);
            URLSpan[] uRLSpanArr2 = (URLSpan[]) text.getSpans(linkSpec.start, linkSpec.end, URLSpan.class);
            if (uRLSpanArr2 != null && uRLSpanArr2.length > 0) {
                for (URLSpan uRLSpan : uRLSpanArr2) {
                    text.removeSpan(uRLSpan);
                }
            }
            text.setSpan(new URLSpan(linkSpec.url), linkSpec.start, linkSpec.end, 33);
        }
        return true;
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> links) {
        int i;
        Collections.sort(links, $$Lambda$AndroidUtilities$H5wEEaOfoeCPFehpkPS4kkD4XE.INSTANCE);
        int size = links.size();
        int i2 = 0;
        while (i2 < size - 1) {
            LinkSpec linkSpec = links.get(i2);
            int i3 = i2 + 1;
            LinkSpec linkSpec2 = links.get(i3);
            int i4 = linkSpec.start;
            int i5 = linkSpec2.start;
            if (i4 <= i5 && (i = linkSpec.end) > i5) {
                int i6 = linkSpec2.end;
                int i7 = (i6 > i && i - i4 <= i6 - i5) ? i - i4 < i6 - i5 ? i2 : -1 : i3;
                if (i7 != -1) {
                    links.remove(i7);
                    size--;
                }
            }
            i2 = i3;
        }
    }

    static /* synthetic */ int lambda$pruneOverlaps$1(LinkSpec linkSpec, LinkSpec linkSpec2) {
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

    public static int getThumbForNameOrMime(String name, String mime, boolean media) {
        int iCharAt;
        if (name == null || name.length() == 0) {
            return media ? documentMediaIcons[0] : documentIcons[0];
        }
        if (name.contains(".doc") || name.contains(".txt") || name.contains(".psd")) {
            iCharAt = 0;
        } else if (name.contains(".xls") || name.contains(".csv")) {
            iCharAt = 1;
        } else if (name.contains(".pdf") || name.contains(".ppt") || name.contains(".key")) {
            iCharAt = 2;
        } else {
            iCharAt = (name.contains(".zip") || name.contains(".rar") || name.contains(".ai") || name.contains(".mp3") || name.contains(".mov") || name.contains(".avi")) ? 3 : -1;
        }
        if (iCharAt == -1) {
            int iLastIndexOf = name.lastIndexOf(46);
            String strSubstring = iLastIndexOf == -1 ? "" : name.substring(iLastIndexOf + 1);
            if (strSubstring.length() != 0) {
                iCharAt = strSubstring.charAt(0) % documentIcons.length;
            } else {
                iCharAt = name.charAt(0) % documentIcons.length;
            }
        }
        return media ? documentMediaIcons[iCharAt] : documentIcons[iCharAt];
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
        int averageColor;
        int[] iArr = new int[4];
        int color = -16777216;
        try {
            if (drawable instanceof BitmapDrawable) {
                color = calcBitmapColor(((BitmapDrawable) drawable).getBitmap());
            } else if (drawable instanceof ColorDrawable) {
                color = ((ColorDrawable) drawable).getColor();
            } else if (drawable instanceof BackgroundGradientDrawable) {
                int[] colorsList = ((BackgroundGradientDrawable) drawable).getColorsList();
                if (colorsList != null) {
                    if (colorsList.length > 1) {
                        averageColor = getAverageColor(colorsList[0], colorsList[1]);
                    } else if (colorsList.length > 0) {
                        averageColor = colorsList[0];
                    }
                    color = averageColor;
                }
            } else if (drawable instanceof MotionBackgroundDrawable) {
                int iArgb = Color.argb(45, 0, 0, 0);
                iArr[2] = iArgb;
                iArr[0] = iArgb;
                int iArgb2 = Color.argb(61, 0, 0, 0);
                iArr[3] = iArgb2;
                iArr[1] = iArgb2;
                return iArr;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        double[] dArrRgbToHsv = rgbToHsv((color >> 16) & 255, (color >> 8) & 255, color & 255);
        dArrRgbToHsv[1] = Math.min(1.0d, dArrRgbToHsv[1] + 0.05d + ((1.0d - dArrRgbToHsv[1]) * 0.1d));
        int[] iArrHsvToRgb = hsvToRgb(dArrRgbToHsv[0], dArrRgbToHsv[1], Math.max(0.0d, dArrRgbToHsv[2] * 0.65d));
        iArr[0] = Color.argb(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, iArrHsvToRgb[0], iArrHsvToRgb[1], iArrHsvToRgb[2]);
        iArr[1] = Color.argb(136, iArrHsvToRgb[0], iArrHsvToRgb[1], iArrHsvToRgb[2]);
        int[] iArrHsvToRgb2 = hsvToRgb(dArrRgbToHsv[0], dArrRgbToHsv[1], Math.max(0.0d, dArrRgbToHsv[2] * 0.72d));
        iArr[2] = Color.argb(R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, iArrHsvToRgb2[0], iArrHsvToRgb2[1], iArrHsvToRgb2[2]);
        iArr[3] = Color.argb(136, iArrHsvToRgb2[0], iArrHsvToRgb2[1], iArrHsvToRgb2[2]);
        return iArr;
    }

    public static double[] rgbToHsv(int color) {
        return rgbToHsv(Color.red(color), Color.green(color), Color.blue(color));
    }

    public static double[] rgbToHsv(int r, int g, int b) {
        double d;
        double d2;
        double d3;
        double d4 = r;
        Double.isNaN(d4);
        double d5 = d4 / 255.0d;
        double d6 = g;
        Double.isNaN(d6);
        double d7 = d6 / 255.0d;
        double d8 = b;
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

    public static int hsvToColor(double h, double s, double v) {
        int[] iArrHsvToRgb = hsvToRgb(h, s, v);
        return Color.argb(255, iArrHsvToRgb[0], iArrHsvToRgb[1], iArrHsvToRgb[2]);
    }

    public static int[] hsvToRgb(double h, double s, double v) {
        double d = 6.0d * h;
        double dFloor = (int) Math.floor(d);
        Double.isNaN(dFloor);
        double d2 = d - dFloor;
        double d3 = (1.0d - s) * v;
        double d4 = (1.0d - (d2 * s)) * v;
        double d5 = v * (1.0d - ((1.0d - d2) * s));
        int i = ((int) dFloor) % 6;
        double d6 = 0.0d;
        if (i != 0) {
            if (i == 1) {
                d6 = v;
                d5 = d3;
                d3 = d4;
            } else if (i == 2) {
                d6 = v;
            } else if (i == 3) {
                d5 = v;
                d6 = d4;
            } else if (i == 4) {
                d6 = d3;
                d3 = d5;
                d5 = v;
            } else if (i != 5) {
                d5 = 0.0d;
                d3 = 0.0d;
            } else {
                d6 = d3;
                d5 = d4;
            }
            return new int[]{(int) (d3 * 255.0d), (int) (d6 * 255.0d), (int) (d5 * 255.0d)};
        }
        d6 = d5;
        d5 = d3;
        d3 = v;
        return new int[]{(int) (d3 * 255.0d), (int) (d6 * 255.0d), (int) (d5 * 255.0d)};
    }

    public static void requestAdjustResize(Activity activity, int classGuid) {
        if (activity == null || isTablet()) {
            return;
        }
        activity.getWindow().setSoftInputMode(16);
        adjustOwnerClassGuid = classGuid;
    }

    public static void requestAdjustNothing(Activity activity, int classGuid) {
        if (activity == null || isTablet()) {
            return;
        }
        activity.getWindow().setSoftInputMode(48);
        adjustOwnerClassGuid = classGuid;
    }

    public static void setAdjustResizeToNothing(Activity activity, int classGuid) {
        if (activity == null || isTablet()) {
            return;
        }
        int i = adjustOwnerClassGuid;
        if (i == 0 || i == classGuid) {
            activity.getWindow().setSoftInputMode(48);
        }
    }

    public static void removeAdjustResize(Activity activity, int classGuid) {
        if (activity == null || isTablet() || adjustOwnerClassGuid != classGuid) {
            return;
        }
        activity.getWindow().setSoftInputMode(32);
    }

    public static void createEmptyFile(File f) {
        try {
            if (f.exists()) {
                return;
            }
            FileWriter fileWriter = new FileWriter(f);
            fileWriter.flush();
            fileWriter.close();
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    public static int[] toIntArray(List<Integer> integers) {
        int size = integers.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = integers.get(i).intValue();
        }
        return iArr;
    }

    public static boolean isInternalUri(Uri uri) {
        return isInternalUri(uri, 0);
    }

    public static boolean isInternalUri(int fd) {
        return isInternalUri(null, fd);
    }

    private static boolean isInternalUri(Uri uri, int fd) throws IOException {
        String path;
        if (uri != null) {
            path = uri.getPath();
            if (path == null) {
                return false;
            }
            if (path.matches(Pattern.quote(new File(ApplicationLoader.applicationContext.getCacheDir(), "voip_logs").getAbsolutePath()) + "/\\d+\\.log")) {
                return false;
            }
            int i = 0;
            while (path.length() <= 4096) {
                try {
                    String str = Utilities.readlink(path);
                    if (str != null && !str.equals(path)) {
                        i++;
                        if (i >= 10) {
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
        path = "";
        int i2 = 0;
        while (path.length() <= 4096) {
            try {
                String str2 = Utilities.readlinkFd(fd);
                if (str2 != null && !str2.equals(path)) {
                    i2++;
                    if (i2 >= 10) {
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

    @SuppressLint({"WrongConstant"})
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

    @SuppressLint({"WrongConstant"})
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

    private static class VcardData {
        String name;
        ArrayList<String> phones;
        StringBuilder vcard;

        private VcardData() {
            this.phones = new ArrayList<>();
            this.vcard = new StringBuilder();
        }
    }

    public static class VcardItem {
        public int type;
        public ArrayList<String> vcardData = new ArrayList<>();
        public String fullData = "";
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
            String str2 = "UTF-8";
            for (String str3 : strSubstring.split(";")) {
                String[] strArrSplit = str3.split("=");
                if (strArrSplit.length == 2) {
                    if (strArrSplit[0].equals("CHARSET")) {
                        str2 = strArrSplit[1];
                    } else if (strArrSplit[0].equals("ENCODING")) {
                        str = strArrSplit[1];
                    }
                }
            }
            String[] strArrSplit2 = strSubstring2.split(";");
            for (int i = 0; i < strArrSplit2.length; i++) {
                if (!TextUtils.isEmpty(strArrSplit2[i]) && str != null && str.equalsIgnoreCase("QUOTED-PRINTABLE") && (bArrDecodeQuotedPrintable = AndroidUtilities.decodeQuotedPrintable(AndroidUtilities.getStringBytes(strArrSplit2[i]))) != null && bArrDecodeQuotedPrintable.length != 0) {
                    try {
                        strArrSplit2[i] = new String(bArrDecodeQuotedPrintable, str2);
                    } catch (Exception unused) {
                    }
                }
            }
            return strArrSplit2;
        }

        public String getValue(boolean format) {
            byte[] bArrDecodeQuotedPrintable;
            StringBuilder sb = new StringBuilder();
            int iIndexOf = this.fullData.indexOf(58);
            if (iIndexOf < 0) {
                return "";
            }
            if (sb.length() > 0) {
                sb.append(", ");
            }
            String strSubstring = this.fullData.substring(0, iIndexOf);
            String strSubstring2 = this.fullData.substring(iIndexOf + 1);
            String str = null;
            String str2 = "UTF-8";
            for (String str3 : strSubstring.split(";")) {
                String[] strArrSplit = str3.split("=");
                if (strArrSplit.length == 2) {
                    if (strArrSplit[0].equals("CHARSET")) {
                        str2 = strArrSplit[1];
                    } else if (strArrSplit[0].equals("ENCODING")) {
                        str = strArrSplit[1];
                    }
                }
            }
            String[] strArrSplit2 = strSubstring2.split(";");
            boolean z = false;
            for (int i = 0; i < strArrSplit2.length; i++) {
                if (!TextUtils.isEmpty(strArrSplit2[i])) {
                    if (str != null && str.equalsIgnoreCase("QUOTED-PRINTABLE") && (bArrDecodeQuotedPrintable = AndroidUtilities.decodeQuotedPrintable(AndroidUtilities.getStringBytes(strArrSplit2[i]))) != null && bArrDecodeQuotedPrintable.length != 0) {
                        try {
                            strArrSplit2[i] = new String(bArrDecodeQuotedPrintable, str2);
                        } catch (Exception unused) {
                        }
                    }
                    if (z && sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(strArrSplit2[i]);
                    if (!z) {
                        z = strArrSplit2[i].length() > 0;
                    }
                }
            }
            if (format) {
                int i2 = this.type;
                if (i2 == 0) {
                    return PhoneFormat.getInstance().format(sb.toString());
                }
                if (i2 == 5) {
                    String[] strArrSplit3 = sb.toString().split("T");
                    if (strArrSplit3.length > 0) {
                        String[] strArrSplit4 = strArrSplit3[0].split("-");
                        if (strArrSplit4.length == 3) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(1, Utilities.parseInt(strArrSplit4[0]).intValue());
                            calendar.set(2, Utilities.parseInt(strArrSplit4[1]).intValue() - 1);
                            calendar.set(5, Utilities.parseInt(strArrSplit4[2]).intValue());
                            return LocaleController.getInstance().formatterYearMax.format(calendar.getTime());
                        }
                    }
                }
            }
            return sb.toString();
        }

        public String getRawType(boolean first) {
            int iIndexOf = this.fullData.indexOf(58);
            if (iIndexOf < 0) {
                return "";
            }
            String strSubstring = this.fullData.substring(0, iIndexOf);
            if (this.type == 20) {
                String[] strArrSplit = strSubstring.substring(2).split(";");
                if (first) {
                    return strArrSplit[0];
                }
                return strArrSplit.length > 1 ? strArrSplit[strArrSplit.length - 1] : "";
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
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.AndroidUtilities.VcardItem.getType():java.lang.String");
        }
    }

    public static byte[] getStringBytes(String src) {
        try {
            return src.getBytes("UTF-8");
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<TLRPC$User> loadVCardFromStream(Uri uri, int i, boolean z, ArrayList<VcardItem> arrayList, String str) {
        InputStream inputStreamCreateInputStream;
        char c;
        String[] strArr;
        String str2;
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamCreateInputStream, "UTF-8"));
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
                    String str3 = "=";
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
                            str2 = strSubstring;
                            arrayList2 = arrayList;
                            strSubstring = str2;
                            anonymousClass1 = 0;
                            i2 = 0;
                        } else {
                            if (!strArr[c].startsWith("FN") && !strArr[c].startsWith("N") && (!strArr[c].startsWith("ORG") || !TextUtils.isEmpty(vcardData.name))) {
                                if (strArr[0].startsWith("TEL")) {
                                    vcardData.phones.add(strArr[1]);
                                }
                                str2 = strSubstring;
                                arrayList2 = arrayList;
                                strSubstring = str2;
                                anonymousClass1 = 0;
                                i2 = 0;
                            }
                            String[] strArrSplit = strArr[0].split(";");
                            int length = strArrSplit.length;
                            str2 = strSubstring;
                            String str4 = null;
                            int i3 = 0;
                            String str5 = null;
                            while (i3 < length) {
                                int i4 = length;
                                String[] strArrSplit2 = strArrSplit[i3].split(str3);
                                String[] strArr2 = strArrSplit;
                                String str6 = str3;
                                if (strArrSplit2.length == 2) {
                                    if (strArrSplit2[0].equals("CHARSET")) {
                                        str4 = strArrSplit2[1];
                                    } else if (strArrSplit2[0].equals("ENCODING")) {
                                        str5 = strArrSplit2[1];
                                    }
                                }
                                i3++;
                                length = i4;
                                strArrSplit = strArr2;
                                str3 = str6;
                            }
                            if (strArr[0].startsWith("N")) {
                                vcardData.name = strArr[1].replace(';', ' ').trim();
                            } else {
                                vcardData.name = strArr[1];
                            }
                            if (str5 != null && str5.equalsIgnoreCase("QUOTED-PRINTABLE") && (bArrDecodeQuotedPrintable = decodeQuotedPrintable(getStringBytes(vcardData.name))) != null && bArrDecodeQuotedPrintable.length != 0) {
                                vcardData.name = new String(bArrDecodeQuotedPrintable, str4);
                            }
                            arrayList2 = arrayList;
                            strSubstring = str2;
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
                String str7 = vcardData2.phones.get(0);
                int i6 = 0;
                while (true) {
                    if (i6 >= vcardData2.phones.size()) {
                        break;
                    }
                    String str8 = vcardData2.phones.get(i6);
                    if (ContactsController.getInstance(i).contactsByShortPhone.get(str8.substring(Math.max(0, str8.length() - 7))) != null) {
                        str7 = str8;
                        break;
                    }
                    i6++;
                }
                TLRPC$TL_userContact_old2 tLRPC$TL_userContact_old2 = new TLRPC$TL_userContact_old2();
                tLRPC$TL_userContact_old2.phone = str7;
                tLRPC$TL_userContact_old2.first_name = vcardData2.name;
                tLRPC$TL_userContact_old2.last_name = "";
                tLRPC$TL_userContact_old2.id = 0L;
                TLRPC$TL_restrictionReason tLRPC$TL_restrictionReason = new TLRPC$TL_restrictionReason();
                tLRPC$TL_restrictionReason.text = vcardData2.vcard.toString();
                tLRPC$TL_restrictionReason.platform = "";
                tLRPC$TL_restrictionReason.reason = "";
                tLRPC$TL_userContact_old2.restriction_reason.add(tLRPC$TL_restrictionReason);
                arrayList3.add(tLRPC$TL_userContact_old2);
            }
        }
        return arrayList3;
    }

    public static void recreateFontFamily() {
        int i = SharedConfig.fontFamily;
        String str = "fonts/vazir.ttf";
        if (i == 0) {
            str = "fonts/iransans.ttf";
        } else if (i != 1) {
            if (i == 2) {
                str = "fonts/roboto.ttf";
            } else if (i == 3) {
                str = "fonts/nahid.ttf";
            } else if (i == 4) {
                str = "fonts/sahel.ttf";
            } else if (i == 5) {
                str = "fonts/tanha.ttf";
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Typeface.Builder builder = new Typeface.Builder(ApplicationLoader.applicationContext.getAssets(), str);
            typefaceRegular = Typeface.create(builder.build(), 400, false);
            typefaceItalic = Typeface.create(builder.build(), 400, true);
            typefaceBold = Typeface.create(builder.build(), 700, false);
            typefaceBoldItalic = Typeface.create(builder.build(), 700, true);
            return;
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(ApplicationLoader.applicationContext.getAssets(), str);
        typefaceRegular = typefaceCreateFromAsset;
        typefaceBold = typefaceCreateFromAsset;
        typefaceBoldItalic = typefaceCreateFromAsset;
        typefaceItalic = typefaceCreateFromAsset;
    }

    public static Typeface getFontFamily(boolean bold) {
        return getFontFamily(bold, false);
    }

    public static Typeface getFontFamily(boolean bold, boolean italic) {
        if (bold && italic) {
            return typefaceBoldItalic;
        }
        if (bold) {
            return typefaceBold;
        }
        if (italic) {
            return typefaceItalic;
        }
        return typefaceRegular;
    }

    public static boolean isWaitingForSms() {
        boolean z;
        synchronized (smsLock) {
            z = waitingForSms;
        }
        return z;
    }

    public static void setWaitingForSms(boolean value) {
        synchronized (smsLock) {
            waitingForSms = value;
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

    public static void setWaitingForCall(boolean value) {
        synchronized (callLock) {
            try {
                if (value) {
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
            waitingForCall = value;
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
        return new File("");
    }

    public static int dp(float value) {
        if (value == 0.0f) {
            return 0;
        }
        return (int) Math.ceil(density * value);
    }

    public static int dpr(float value) {
        if (value == 0.0f) {
            return 0;
        }
        return Math.round(density * value);
    }

    public static int dp2(float value) {
        if (value == 0.0f) {
            return 0;
        }
        return (int) Math.floor(density * value);
    }

    public static float dpf2(float value) {
        if (value == 0.0f) {
            return 0.0f;
        }
        return density * value;
    }

    public static float pxToDp(float value) {
        if (value == 0.0f) {
            return 0.0f;
        }
        return value / density;
    }

    public static void checkDisplaySize(Context context, Configuration newConfiguration) {
        Display defaultDisplay;
        try {
            float f = density;
            density = context.getResources().getDisplayMetrics().density;
            if (firstConfigurationWas && Math.abs(f - r2) > 0.001d) {
                Theme.reloadAllResources(context);
            }
            boolean z = true;
            firstConfigurationWas = true;
            if (newConfiguration == null) {
                newConfiguration = context.getResources().getConfiguration();
            }
            if (newConfiguration.keyboard == 1 || newConfiguration.hardKeyboardHidden != 1) {
                z = false;
            }
            usingHardwareInput = z;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                defaultDisplay.getMetrics(displayMetrics);
                defaultDisplay.getSize(displaySize);
                screenRefreshRate = defaultDisplay.getRefreshRate();
            }
            if (newConfiguration.screenWidthDp != 0) {
                int iCeil = (int) Math.ceil(r6 * density);
                if (Math.abs(displaySize.x - iCeil) > 3) {
                    displaySize.x = iCeil;
                }
            }
            if (newConfiguration.screenHeightDp != 0) {
                int iCeil2 = (int) Math.ceil(r6 * density);
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
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static double fixLocationCoord(double value) {
        double d = (long) (value * 1000000.0d);
        Double.isNaN(d);
        return d / 1000000.0d;
    }

    public static String formapMapUrl(int account, double lat, double lon, int width, int height, boolean marker, int zoom, int provider) {
        int i = 1 << zoom;
        double d = i;
        Double.isNaN(d);
        int iFloor = (int) Math.floor(((lon + 180.0d) / 360.0d) * d);
        double dLog = (1.0d - (Math.log(Math.tan(Math.toRadians(lat)) + (1.0d / Math.cos(Math.toRadians(lat)))) / 3.141592653589793d)) / 2.0d;
        Double.isNaN(d);
        int iFloor2 = (int) Math.floor(dLog * d);
        if (iFloor < 0) {
            iFloor = 0;
        }
        if (iFloor >= i) {
            iFloor = i - 1;
        }
        if (iFloor2 < 0) {
            iFloor2 = 0;
        }
        if (iFloor2 >= i) {
            iFloor2 = i - 1;
        }
        return String.format(Locale.ENGLISH, "https://maps.eitaa.com/tile/%d/%d/%d.png", Integer.valueOf(zoom), Integer.valueOf(iFloor), Integer.valueOf(iFloor2));
    }

    public static float getPixelsInCM(float cm, boolean isX) {
        return (cm / 2.54f) * (isX ? displayMetrics.xdpi : displayMetrics.ydpi);
    }

    public static int getPeerLayerVersion(int layer) {
        return Math.max(73, (layer >> 16) & 65535);
    }

    public static void runOnUIThread(Runnable runnable) {
        runOnUIThread(runnable, 0L);
    }

    public static void runOnUIThread(Runnable runnable, long delay) {
        if (ApplicationLoader.applicationHandler == null) {
            return;
        }
        if (delay == 0) {
            ApplicationLoader.applicationHandler.post(runnable);
        } else {
            ApplicationLoader.applicationHandler.postDelayed(runnable, delay);
        }
    }

    public static void cancelRunOnUIThread(Runnable runnable) {
        if (ApplicationLoader.applicationHandler == null) {
            return;
        }
        ApplicationLoader.applicationHandler.removeCallbacks(runnable);
    }

    public static boolean isTablet() {
        if (isTablet == null) {
            isTablet = Boolean.valueOf(ApplicationLoader.applicationContext != null && ApplicationLoader.applicationContext.getResources().getBoolean(R.bool.isTablet));
        }
        return isTablet.booleanValue();
    }

    public static boolean isSmallTablet() {
        Point point = displaySize;
        return ((float) Math.min(point.x, point.y)) / density <= 690.0f;
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
            photoSize = 1280;
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

    public static String obtainLoginPhoneCall(String pattern) {
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
                    if (Math.abs(System.currentTimeMillis() - j) < 3600000 && checkPhonePattern(pattern, string)) {
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

    public static boolean checkPhonePattern(String pattern, String phone) {
        if (!TextUtils.isEmpty(pattern) && !pattern.equals("*")) {
            String[] strArrSplit = pattern.split("\\*");
            String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(phone);
            int length = 0;
            for (String str : strArrSplit) {
                if (!TextUtils.isEmpty(str)) {
                    int iIndexOf = strStripExceptNumbers.indexOf(str, length);
                    if (iIndexOf == -1) {
                        return false;
                    }
                    length = iIndexOf + str.length();
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

    public static void setEnabled(View view, boolean enabled) {
        if (view == null) {
            return;
        }
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                setEnabled(viewGroup.getChildAt(i), enabled);
            }
        }
    }

    public static CharSequence getTrimmedString(CharSequence src) {
        if (src != null && src.length() != 0) {
            while (src.length() > 0 && (src.charAt(0) == '\n' || src.charAt(0) == ' ')) {
                src = src.subSequence(1, src.length());
            }
            while (src.length() > 0 && (src.charAt(src.length() - 1) == '\n' || src.charAt(src.length() - 1) == ' ')) {
                src = src.subSequence(0, src.length() - 1);
            }
        }
        return src;
    }

    public static void setViewPagerEdgeEffectColor(ViewPager viewPager, int color) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mLeftEdge");
                declaredField.setAccessible(true);
                EdgeEffect edgeEffect = (EdgeEffect) declaredField.get(viewPager);
                if (edgeEffect != null) {
                    edgeEffect.setColor(color);
                }
                Field declaredField2 = ViewPager.class.getDeclaredField("mRightEdge");
                declaredField2.setAccessible(true);
                EdgeEffect edgeEffect2 = (EdgeEffect) declaredField2.get(viewPager);
                if (edgeEffect2 != null) {
                    edgeEffect2.setColor(color);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void setScrollViewEdgeEffectColor(HorizontalScrollView scrollView, int color) throws NoSuchFieldException {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            scrollView.setEdgeEffectColor(color);
            return;
        }
        if (i >= 21) {
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mEdgeGlowLeft");
                declaredField.setAccessible(true);
                EdgeEffect edgeEffect = (EdgeEffect) declaredField.get(scrollView);
                if (edgeEffect != null) {
                    edgeEffect.setColor(color);
                }
                Field declaredField2 = HorizontalScrollView.class.getDeclaredField("mEdgeGlowRight");
                declaredField2.setAccessible(true);
                EdgeEffect edgeEffect2 = (EdgeEffect) declaredField2.get(scrollView);
                if (edgeEffect2 != null) {
                    edgeEffect2.setColor(color);
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static void setScrollViewEdgeEffectColor(ScrollView scrollView, int color) throws NoSuchFieldException {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            scrollView.setTopEdgeEffectColor(color);
            scrollView.setBottomEdgeEffectColor(color);
            return;
        }
        if (i >= 21) {
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mEdgeGlowTop");
                declaredField.setAccessible(true);
                EdgeEffect edgeEffect = (EdgeEffect) declaredField.get(scrollView);
                if (edgeEffect != null) {
                    edgeEffect.setColor(color);
                }
                Field declaredField2 = ScrollView.class.getDeclaredField("mEdgeGlowBottom");
                declaredField2.setAccessible(true);
                EdgeEffect edgeEffect2 = (EdgeEffect) declaredField2.get(scrollView);
                if (edgeEffect2 != null) {
                    edgeEffect2.setColor(color);
                }
            } catch (Exception unused) {
            }
        }
    }

    @SuppressLint({"NewApi"})
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

    public static SpannableStringBuilder replaceTags(String str, int flag, Object... args) {
        try {
            StringBuilder sb = new StringBuilder(str);
            if ((flag & 1) != 0) {
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
            if ((flag & 2) != 0) {
                while (true) {
                    int iIndexOf3 = sb.indexOf("<b>");
                    if (iIndexOf3 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf3, iIndexOf3 + 3, "");
                    int iIndexOf4 = sb.indexOf("</b>");
                    if (iIndexOf4 == -1) {
                        iIndexOf4 = sb.indexOf("<b>");
                    }
                    sb.replace(iIndexOf4, iIndexOf4 + 4, "");
                    arrayList.add(Integer.valueOf(iIndexOf3));
                    arrayList.add(Integer.valueOf(iIndexOf4));
                }
                while (true) {
                    int iIndexOf5 = sb.indexOf("**");
                    if (iIndexOf5 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf5, iIndexOf5 + 2, "");
                    int iIndexOf6 = sb.indexOf("**");
                    if (iIndexOf6 >= 0) {
                        sb.replace(iIndexOf6, iIndexOf6 + 2, "");
                        arrayList.add(Integer.valueOf(iIndexOf5));
                        arrayList.add(Integer.valueOf(iIndexOf6));
                    }
                }
            }
            if ((flag & 8) != 0) {
                while (true) {
                    int iIndexOf7 = sb.indexOf("**");
                    if (iIndexOf7 == -1) {
                        break;
                    }
                    sb.replace(iIndexOf7, iIndexOf7 + 2, "");
                    int iIndexOf8 = sb.indexOf("**");
                    if (iIndexOf8 >= 0) {
                        sb.replace(iIndexOf8, iIndexOf8 + 2, "");
                        arrayList.add(Integer.valueOf(iIndexOf7));
                        arrayList.add(Integer.valueOf(iIndexOf8));
                    }
                }
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb);
            for (int i = 0; i < arrayList.size() / 2; i++) {
                int i2 = i * 2;
                spannableStringBuilder.setSpan(new TypefaceSpan(getFontFamily(true)), ((Integer) arrayList.get(i2)).intValue(), ((Integer) arrayList.get(i2 + 1)).intValue(), 33);
            }
            return spannableStringBuilder;
        } catch (Exception e) {
            FileLog.e(e);
            return new SpannableStringBuilder(str);
        }
    }

    public static class LinkMovementMethodMy extends LinkMovementMethod {
        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
            try {
                boolean zOnTouchEvent = super.onTouchEvent(widget, buffer, event);
                if (event.getAction() == 1 || event.getAction() == 3) {
                    Selection.removeSelection(buffer);
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

    public static boolean needShowPasscode(boolean reset) {
        boolean zIsWasInBackground = ForegroundDetector.getInstance().isWasInBackground(reset);
        if (reset) {
            ForegroundDetector.getInstance().resetBackgroundVar();
        }
        int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() / 1000);
        if (BuildVars.LOGS_ENABLED && reset && SharedConfig.passcodeHash.length() > 0) {
            FileLog.d("wasInBackground = " + zIsWasInBackground + " appLocked = " + SharedConfig.appLocked + " autoLockIn = " + SharedConfig.autoLockIn + " lastPauseTime = " + SharedConfig.lastPauseTime + " uptime = " + iElapsedRealtime);
        }
        return SharedConfig.passcodeHash.length() > 0 && zIsWasInBackground && (SharedConfig.appLocked || (!(SharedConfig.autoLockIn == 0 || SharedConfig.lastPauseTime == 0 || SharedConfig.appLocked || SharedConfig.lastPauseTime + SharedConfig.autoLockIn > iElapsedRealtime) || iElapsedRealtime + 5 < SharedConfig.lastPauseTime));
    }

    public static void shakeView(final View view, final float x, final int num) {
        if (view == null) {
            return;
        }
        if (num == 6) {
            view.setTranslationX(0.0f);
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationX", dp(x)));
        animatorSet.setDuration(50L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.messenger.AndroidUtilities.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                View view2 = view;
                int i = num;
                AndroidUtilities.shakeView(view2, i == 5 ? 0.0f : -x, i + 1);
            }
        });
        animatorSet.start();
    }

    public static void addToClipboard(CharSequence str) {
        try {
            ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", str));
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void addMediaToGallery(String fromPath) {
        if (fromPath == null) {
            return;
        }
        addMediaToGallery(Uri.fromFile(new File(fromPath)));
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

    private static File getAlbumDir(boolean secretChat) {
        if (secretChat || (Build.VERSION.SDK_INT >= 23 && ApplicationLoader.applicationContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0)) {
            return FileLoader.getDirectory(4);
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Eitaa");
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

    @SuppressLint({"NewApi"})
    public static String getPath(final Uri uri) {
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.AndroidUtilities.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
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

    public static File generatePicturePath(boolean secretChat, String ext) {
        try {
            File albumDir = getAlbumDir(secretChat);
            Date date = new Date();
            date.setTime(System.currentTimeMillis() + Utilities.random.nextInt(1000) + 1);
            String str = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(date);
            StringBuilder sb = new StringBuilder();
            sb.append("IMG_");
            sb.append(str);
            sb.append(".");
            if (TextUtils.isEmpty(ext)) {
                ext = "jpg";
            }
            sb.append(ext);
            return new File(albumDir, sb.toString());
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static CharSequence generateSearchName(String name, String name2, String q) {
        if ((name == null && name2 == null) || TextUtils.isEmpty(q)) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (name == null || name.length() == 0) {
            name = name2;
        } else if (name2 != null && name2.length() != 0) {
            name = name + " " + name2;
        }
        String strTrim = name.trim();
        String str = " " + strTrim.toLowerCase();
        int i = 0;
        while (true) {
            int iIndexOf = str.indexOf(" " + q, i);
            if (iIndexOf == -1) {
                break;
            }
            int i2 = iIndexOf - (iIndexOf == 0 ? 0 : 1);
            int length = q.length() + (iIndexOf == 0 ? 0 : 1) + i2;
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
            spannableStringBuilder.setSpan(new ForegroundColorSpanThemable("windowBackgroundWhiteBlueText4"), length2, strTrim2.length() + length2, 33);
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

    public static File generateVideoPath(boolean secretChat) {
        try {
            File albumDir = getAlbumDir(secretChat);
            Date date = new Date();
            date.setTime(System.currentTimeMillis() + Utilities.random.nextInt(1000) + 1);
            return new File(albumDir, "VID_" + new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(date) + ".mp4");
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    public static String formatFileSize(long size) {
        return formatFileSize(size, false);
    }

    public static String formatFileSize(long size, boolean removeZero) {
        if (size < 1024) {
            return String.format("%d B", Long.valueOf(size));
        }
        if (size < 1048576) {
            float f = size / 1024.0f;
            if (removeZero) {
                int i = (int) f;
                if ((f - i) * 10.0f == 0.0f) {
                    return String.format("%d KB", Integer.valueOf(i));
                }
            }
            return String.format("%.1f KB", Float.valueOf(f));
        }
        if (size < 1073741824) {
            float f2 = (size / 1024.0f) / 1024.0f;
            if (removeZero) {
                int i2 = (int) f2;
                if ((f2 - i2) * 10.0f == 0.0f) {
                    return String.format("%d MB", Integer.valueOf(i2));
                }
            }
            return String.format("%.1f MB", Float.valueOf(f2));
        }
        float f3 = ((size / 1024.0f) / 1024.0f) / 1024.0f;
        if (removeZero) {
            int i3 = (int) f3;
            if ((f3 - i3) * 10.0f == 0.0f) {
                return String.format("%d GB", Integer.valueOf(i3));
            }
        }
        return String.format("%.1f GB", Float.valueOf(f3));
    }

    public static String formatShortDuration(int duration) {
        return formatDuration(duration, false);
    }

    public static String formatLongDuration(int duration) {
        return formatDuration(duration, true);
    }

    public static String formatDuration(int duration, boolean isLong) {
        int i = duration / 3600;
        int i2 = (duration / 60) % 60;
        int i3 = duration % 60;
        return i == 0 ? isLong ? String.format(Locale.US, "%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3)) : String.format(Locale.US, "%d:%02d", Integer.valueOf(i2), Integer.valueOf(i3)) : String.format(Locale.US, "%d:%02d:%02d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String formatFullDuration(int duration) {
        int i = duration / 3600;
        int i2 = (duration / 60) % 60;
        int i3 = duration % 60;
        return duration < 0 ? String.format(Locale.US, "-%02d:%02d:%02d", Integer.valueOf(Math.abs(i)), Integer.valueOf(Math.abs(i2)), Integer.valueOf(Math.abs(i3))) : String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String formatDurationNoHours(int duration, boolean isLong) {
        int i = duration / 60;
        int i2 = duration % 60;
        return isLong ? String.format(Locale.US, "%02d:%02d", Integer.valueOf(i), Integer.valueOf(i2)) : String.format(Locale.US, "%d:%02d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static String formatShortDuration(int progress, int duration) {
        return formatDuration(progress, duration, false);
    }

    public static String formatLongDuration(int progress, int duration) {
        return formatDuration(progress, duration, true);
    }

    public static String formatDuration(int progress, int duration, boolean isLong) {
        int i = duration / 3600;
        int i2 = (duration / 60) % 60;
        int i3 = duration % 60;
        int i4 = progress / 3600;
        int i5 = (progress / 60) % 60;
        int i6 = progress % 60;
        return duration == 0 ? i4 == 0 ? isLong ? String.format(Locale.US, "%02d:%02d / -:--", Integer.valueOf(i5), Integer.valueOf(i6)) : String.format(Locale.US, "%d:%02d / -:--", Integer.valueOf(i5), Integer.valueOf(i6)) : String.format(Locale.US, "%d:%02d:%02d / -:--", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)) : (i4 == 0 && i == 0) ? isLong ? String.format(Locale.US, "%02d:%02d / %02d:%02d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i3)) : String.format(Locale.US, "%d:%02d / %d:%02d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i3)) : String.format(Locale.US, "%d:%02d:%02d / %d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String formatVideoDuration(int progress, int duration) {
        int i = duration / 3600;
        int i2 = (duration / 60) % 60;
        int i3 = duration % 60;
        int i4 = progress / 3600;
        int i5 = (progress / 60) % 60;
        int i6 = progress % 60;
        return (i4 == 0 && i == 0) ? String.format(Locale.US, "%02d:%02d / %02d:%02d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i3)) : i == 0 ? String.format(Locale.US, "%d:%02d:%02d / %02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i3)) : i4 == 0 ? String.format(Locale.US, "%02d:%02d / %d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)) : String.format(Locale.US, "%d:%02d:%02d / %d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String formatCount(int count) {
        if (count < 1000) {
            return Integer.toString(count);
        }
        ArrayList arrayList = new ArrayList();
        while (count != 0) {
            int i = count % 1000;
            count /= 1000;
            if (count > 0) {
                arrayList.add(String.format(Locale.ENGLISH, "%03d", Integer.valueOf(i)));
            } else {
                arrayList.add(Integer.toString(i));
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

    public static String formatWholeNumber(int v, int dif) {
        if (v == 0) {
            return "0";
        }
        float f = v;
        if (dif == 0) {
            dif = v;
        }
        if (dif < 1000) {
            return formatCount(v);
        }
        int i = 0;
        while (dif >= 1000 && i < numbersSignatureArray.length - 1) {
            dif /= 1000;
            f /= 1000.0f;
            i++;
        }
        if (f < 0.1d) {
            return "0";
        }
        float f2 = f * 10.0f;
        float f3 = (int) f2;
        return f2 == f3 ? String.format(Locale.ENGLISH, "%s%s", formatCount((int) f), numbersSignatureArray[i]) : String.format(Locale.ENGLISH, "%.1f%s", Float.valueOf(f3 / 10.0f), numbersSignatureArray[i]);
    }

    public static byte[] decodeQuotedPrintable(final byte[] bytes) throws IOException {
        if (bytes == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bytes.length) {
            byte b = bytes[i];
            if (b == 61) {
                int i2 = i + 1;
                try {
                    int iDigit = Character.digit((char) bytes[i2], 16);
                    i = i2 + 1;
                    byteArrayOutputStream.write((char) ((iDigit << 4) + Character.digit((char) bytes[i], 16)));
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

    public static boolean copyFile(InputStream sourceFile, File destFile) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);
        byte[] bArr = new byte[Factory.DEVICE_HAS_CRAPPY_AAUDIO];
        while (true) {
            int i = sourceFile.read(bArr);
            if (i > 0) {
                Thread.yield();
                fileOutputStream.write(bArr, 0, i);
            } else {
                fileOutputStream.close();
                return true;
            }
        }
    }

    public static boolean copyFile(File sourceFile, File destFile) throws IOException {
        if (sourceFile.equals(destFile)) {
            return true;
        }
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(destFile);
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

    public static byte[] calcAuthKeyHash(byte[] auth_key) {
        byte[] bArr = new byte[16];
        System.arraycopy(Utilities.computeSHA1(auth_key), 0, bArr, 0, 16);
        return bArr;
    }

    public static void openDocument(MessageObject message, Activity activity, BaseFragment parentFragment) {
        TLRPC$Document document;
        String mimeTypeFromExtension;
        if (message == null || (document = message.getDocument()) == null) {
            return;
        }
        String attachFileName = message.messageOwner.media != null ? FileLoader.getAttachFileName(document) : "";
        String str = message.messageOwner.attachPath;
        File file = (str == null || str.length() == 0) ? null : new File(message.messageOwner.attachPath);
        if (file == null || !file.exists()) {
            file = FileLoader.getPathToMessage(message.messageOwner);
        }
        if (file == null || !file.exists()) {
            return;
        }
        if (parentFragment != null && file.getName().toLowerCase().endsWith("attheme")) {
            Theme.ThemeInfo themeInfoApplyThemeFile = Theme.applyThemeFile(file, message.getDocumentName(), null, true);
            if (themeInfoApplyThemeFile != null) {
                parentFragment.presentFragment(new ThemePreviewActivity(themeInfoApplyThemeFile));
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.getString("IncorrectTheme", R.string.IncorrectTheme));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            parentFragment.showDialog(builder.create());
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
                intent.setDataAndType(FileProvider.getUriForFile(activity, "ir.eitaa.messenger.provider", file), mimeTypeFromExtension != null ? mimeTypeFromExtension : "text/plain");
            } else {
                intent.setDataAndType(Uri.fromFile(file), mimeTypeFromExtension != null ? mimeTypeFromExtension : "text/plain");
            }
            if (mimeTypeFromExtension != null) {
                try {
                    activity.startActivityForResult(intent, 500);
                    return;
                } catch (Exception unused) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.setDataAndType(FileProvider.getUriForFile(activity, "ir.eitaa.messenger.provider", file), "text/plain");
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), "text/plain");
                    }
                    activity.startActivityForResult(intent, 500);
                    return;
                }
            }
            activity.startActivityForResult(intent, 500);
        } catch (Exception unused2) {
            if (activity == null) {
                return;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(activity);
            builder2.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            builder2.setMessage(LocaleController.formatString("NoHandleAppInstalled", R.string.NoHandleAppInstalled, message.getDocument().mime_type));
            if (parentFragment != null) {
                parentFragment.showDialog(builder2.create());
            } else {
                builder2.show();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean openForView(java.io.File r6, java.lang.String r7, java.lang.String r8, final android.app.Activity r9, ir.eitaa.ui.ActionBar.Theme.ResourcesProvider r10) {
        /*
            if (r6 == 0) goto Lda
            boolean r0 = r6.exists()
            if (r0 == 0) goto Lda
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)
            r1 = 1
            r0.setFlags(r1)
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            r3 = 46
            int r3 = r7.lastIndexOf(r3)
            r4 = -1
            r5 = 0
            if (r3 == r4) goto L3b
            int r3 = r3 + r1
            java.lang.String r7 = r7.substring(r3)
            java.lang.String r7 = r7.toLowerCase()
            java.lang.String r7 = r2.getMimeTypeFromExtension(r7)
            if (r7 != 0) goto L39
            if (r8 == 0) goto L3b
            int r7 = r8.length()
            if (r7 != 0) goto L3c
            goto L3b
        L39:
            r8 = r7
            goto L3c
        L3b:
            r8 = r5
        L3c:
            int r7 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r7 < r2) goto L96
            if (r8 == 0) goto L96
            java.lang.String r2 = "application/vnd.android.package-archive"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L96
            android.content.Context r2 = ir.eitaa.messenger.ApplicationLoader.applicationContext
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            boolean r2 = r2.canRequestPackageInstalls()
            if (r2 != 0) goto L96
            ir.eitaa.ui.ActionBar.AlertDialog$Builder r6 = new ir.eitaa.ui.ActionBar.AlertDialog$Builder
            r6.<init>(r9, r10)
            r7 = 2131689938(0x7f0f01d2, float:1.9008906E38)
            java.lang.String r8 = "AppName"
            java.lang.String r7 = ir.eitaa.messenger.LocaleController.getString(r8, r7)
            r6.setTitle(r7)
            r7 = 2131689928(0x7f0f01c8, float:1.9008885E38)
            java.lang.String r8 = "ApkRestricted"
            java.lang.String r7 = ir.eitaa.messenger.LocaleController.getString(r8, r7)
            r6.setMessage(r7)
            r7 = 2131693283(0x7f0f0ee3, float:1.901569E38)
            java.lang.String r8 = "PermissionOpenSettings"
            java.lang.String r7 = ir.eitaa.messenger.LocaleController.getString(r8, r7)
            ir.eitaa.messenger.-$$Lambda$AndroidUtilities$twVK4z_VW8KqKlFv-JiSMhU26R4 r8 = new ir.eitaa.messenger.-$$Lambda$AndroidUtilities$twVK4z_VW8KqKlFv-JiSMhU26R4
            r8.<init>()
            r6.setPositiveButton(r7, r8)
            r7 = 2131690403(0x7f0f03a3, float:1.9009849E38)
            java.lang.String r8 = "Cancel"
            java.lang.String r7 = ir.eitaa.messenger.LocaleController.getString(r8, r7)
            r6.setNegativeButton(r7, r5)
            r6.show()
            return r1
        L96:
            java.lang.String r10 = "ir.eitaa.messenger.provider"
            r2 = 24
            java.lang.String r3 = "text/plain"
            if (r7 < r2) goto Lab
            android.net.Uri r7 = androidx.core.content.FileProvider.getUriForFile(r9, r10, r6)
            if (r8 == 0) goto La6
            r4 = r8
            goto La7
        La6:
            r4 = r3
        La7:
            r0.setDataAndType(r7, r4)
            goto Lb7
        Lab:
            android.net.Uri r7 = android.net.Uri.fromFile(r6)
            if (r8 == 0) goto Lb3
            r4 = r8
            goto Lb4
        Lb3:
            r4 = r3
        Lb4:
            r0.setDataAndType(r7, r4)
        Lb7:
            r7 = 500(0x1f4, float:7.0E-43)
            if (r8 == 0) goto Ld6
            r9.startActivityForResult(r0, r7)     // Catch: java.lang.Exception -> Lbf
            goto Ld9
        Lbf:
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r2) goto Lcb
            android.net.Uri r6 = androidx.core.content.FileProvider.getUriForFile(r9, r10, r6)
            r0.setDataAndType(r6, r3)
            goto Ld2
        Lcb:
            android.net.Uri r6 = android.net.Uri.fromFile(r6)
            r0.setDataAndType(r6, r3)
        Ld2:
            r9.startActivityForResult(r0, r7)
            goto Ld9
        Ld6:
            r9.startActivityForResult(r0, r7)
        Ld9:
            return r1
        Lda:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.AndroidUtilities.openForView(java.io.File, java.lang.String, java.lang.String, android.app.Activity, ir.eitaa.ui.ActionBar.Theme$ResourcesProvider):boolean");
    }

    static /* synthetic */ void lambda$openForView$2(Activity activity, DialogInterface dialogInterface, int i) {
        try {
            activity.startActivity(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + activity.getPackageName())));
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static boolean openForView(MessageObject message, Activity activity, Theme.ResourcesProvider resourcesProvider) {
        String str = message.messageOwner.attachPath;
        File file = (str == null || str.length() == 0) ? null : new File(message.messageOwner.attachPath);
        if (file == null || !file.exists()) {
            file = FileLoader.getPathToMessage(message.messageOwner);
        }
        int i = message.type;
        return openForView(file, message.getFileName(), (i == 9 || i == 0) ? message.getMimeType() : null, activity, resourcesProvider);
    }

    public static boolean openForView(TLRPC$Document document, boolean forceCache, Activity activity) {
        return openForView(FileLoader.getPathToAttach(document, true), FileLoader.getAttachFileName(document), document.mime_type, activity, null);
    }

    public static CharSequence replaceNewLines(CharSequence original) {
        int i = 0;
        if (original instanceof StringBuilder) {
            StringBuilder sb = (StringBuilder) original;
            int length = original.length();
            while (i < length) {
                if (original.charAt(i) == '\n') {
                    sb.setCharAt(i, ' ');
                }
                i++;
            }
        } else if (original instanceof SpannableStringBuilder) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) original;
            int length2 = original.length();
            while (i < length2) {
                if (original.charAt(i) == '\n') {
                    spannableStringBuilder.replace(i, i + 1, (CharSequence) " ");
                }
                i++;
            }
        }
        return original.toString().replace('\n', ' ');
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[PHI: r1
      0x0050: PHI (r1v7 java.lang.String) = (r1v6 java.lang.String), (r1v8 java.lang.String) binds: [B:13:0x003d, B:19:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean openForView(ir.eitaa.tgnet.TLObject r8, android.app.Activity r9) {
        /*
            r0 = 0
            if (r8 == 0) goto L97
            if (r9 != 0) goto L7
            goto L97
        L7:
            java.lang.String r1 = ir.eitaa.messenger.FileLoader.getAttachFileName(r8)
            r2 = 1
            java.io.File r3 = ir.eitaa.messenger.FileLoader.getPathToAttach(r8, r2)
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
            boolean r4 = r8 instanceof ir.eitaa.tgnet.TLRPC$TL_document
            if (r4 == 0) goto L47
            ir.eitaa.tgnet.TLRPC$TL_document r8 = (ir.eitaa.tgnet.TLRPC$TL_document) r8
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
            java.lang.String r1 = "ir.eitaa.messenger.provider"
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.AndroidUtilities.openForView(ir.eitaa.tgnet.TLObject, android.app.Activity):boolean");
    }

    public static boolean isBannedForever(TLRPC$TL_chatBannedRights rights) {
        return rights == null || Math.abs(((long) rights.until_date) - (System.currentTimeMillis() / 1000)) > 157680000;
    }

    public static void setRectToRect(Matrix matrix, RectF src, RectF dst, int rotation, boolean translate) {
        float fHeight;
        float fWidth;
        float fHeight2;
        boolean z;
        float f;
        float f2;
        float fHeight3;
        float fHeight4;
        if (rotation == 90 || rotation == 270) {
            fHeight = dst.height() / src.width();
            fWidth = dst.width();
            fHeight2 = src.height();
        } else {
            fHeight = dst.width() / src.width();
            fWidth = dst.height();
            fHeight2 = src.height();
        }
        float f3 = fWidth / fHeight2;
        if (fHeight < f3) {
            fHeight = f3;
            z = true;
        } else {
            z = false;
        }
        if (translate) {
            matrix.setTranslate(dst.left, dst.top);
        }
        if (rotation == 90) {
            matrix.preRotate(90.0f);
            matrix.preTranslate(0.0f, -dst.width());
        } else if (rotation == 180) {
            matrix.preRotate(180.0f);
            matrix.preTranslate(-dst.width(), -dst.height());
        } else if (rotation == 270) {
            matrix.preRotate(270.0f);
            matrix.preTranslate(-dst.height(), 0.0f);
        }
        if (translate) {
            f = (-src.left) * fHeight;
            f2 = (-src.top) * fHeight;
        } else {
            f = dst.left - (src.left * fHeight);
            f2 = dst.top - (src.top * fHeight);
        }
        if (z) {
            fHeight3 = dst.width();
            fHeight4 = src.width();
        } else {
            fHeight3 = dst.height();
            fHeight4 = src.height();
        }
        float f4 = (fHeight3 - (fHeight4 * fHeight)) / 2.0f;
        if (z) {
            f += f4;
        } else {
            f2 += f4;
        }
        matrix.preScale(fHeight, fHeight);
        if (translate) {
            matrix.preTranslate(f, f2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean handleProxyIntent(android.app.Activity r16, android.content.Intent r17) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.AndroidUtilities.handleProxyIntent(android.app.Activity, android.content.Intent):boolean");
    }

    public static boolean shouldEnableAnimation() {
        int i = Build.VERSION.SDK_INT;
        return i < 26 || i >= 28 || (!((PowerManager) ApplicationLoader.applicationContext.getSystemService("power")).isPowerSaveMode() && Settings.Global.getFloat(ApplicationLoader.applicationContext.getContentResolver(), "animator_duration_scale", 1.0f) > 0.0f);
    }

    public static void showProxyAlert(Activity activity, final String address, final String port, final String user, final String password, final String secret) {
        String string;
        BottomSheet.Builder builder = new BottomSheet.Builder(activity);
        final Runnable dismissRunnable = builder.getDismissRunnable();
        builder.setApplyTopPadding(false);
        builder.setApplyBottomPadding(false);
        LinearLayout linearLayout = new LinearLayout(activity);
        builder.setCustomView(linearLayout);
        linearLayout.setOrientation(1);
        if (!TextUtils.isEmpty(secret)) {
            TextView textView = new TextView(activity);
            textView.setText(LocaleController.getString("UseProxyEitaaInfo2", R.string.UseProxyEitaaInfo2));
            textView.setTextColor(Theme.getColor("dialogTextGray4"));
            textView.setTextSize(1, 14.0f);
            textView.setGravity(49);
            linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 17, 8, 17, 8));
            View view = new View(activity);
            view.setBackgroundColor(Theme.getColor("divider"));
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, 1));
        }
        for (int i = 0; i < 5; i++) {
            String str = null;
            if (i == 0) {
                string = LocaleController.getString("UseProxyAddress", R.string.UseProxyAddress);
                str = address;
            } else if (i == 1) {
                str = "" + port;
                string = LocaleController.getString("UseProxyPort", R.string.UseProxyPort);
            } else if (i == 2) {
                string = LocaleController.getString("UseProxySecret", R.string.UseProxySecret);
                str = secret;
            } else if (i == 3) {
                string = LocaleController.getString("UseProxyUsername", R.string.UseProxyUsername);
                str = user;
            } else if (i == 4) {
                string = LocaleController.getString("UseProxyPassword", R.string.UseProxyPassword);
                str = password;
            } else {
                string = null;
            }
            if (!TextUtils.isEmpty(str)) {
                TextDetailSettingsCell textDetailSettingsCell = new TextDetailSettingsCell(activity);
                textDetailSettingsCell.setTextAndValue(str, string, true);
                textDetailSettingsCell.getTextView().setTextColor(Theme.getColor("dialogTextBlack"));
                textDetailSettingsCell.getValueTextView().setTextColor(Theme.getColor("dialogTextGray3"));
                linearLayout.addView(textDetailSettingsCell, LayoutHelper.createLinear(-1, -2));
                if (i == 2) {
                    break;
                }
            }
        }
        PickerBottomLayout pickerBottomLayout = new PickerBottomLayout(activity, false);
        pickerBottomLayout.setBackgroundColor(Theme.getColor("dialogBackground"));
        linearLayout.addView(pickerBottomLayout, LayoutHelper.createFrame(-1, 48, 83));
        pickerBottomLayout.cancelButton.setPadding(dp(18.0f), 0, dp(18.0f), 0);
        pickerBottomLayout.cancelButton.setTextColor(Theme.getColor("dialogTextBlue2"));
        pickerBottomLayout.cancelButton.setText(LocaleController.getString("Cancel", R.string.Cancel).toUpperCase());
        pickerBottomLayout.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.messenger.-$$Lambda$AndroidUtilities$SJd9BVaJxTUdNb1oQ3frP9afzq0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dismissRunnable.run();
            }
        });
        pickerBottomLayout.doneButtonTextView.setTextColor(Theme.getColor("dialogTextBlue2"));
        pickerBottomLayout.doneButton.setPadding(dp(18.0f), 0, dp(18.0f), 0);
        pickerBottomLayout.doneButtonBadgeTextView.setVisibility(8);
        pickerBottomLayout.doneButtonTextView.setText(LocaleController.getString("ConnectingConnectProxy", R.string.ConnectingConnectProxy).toUpperCase());
        pickerBottomLayout.doneButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.messenger.-$$Lambda$AndroidUtilities$gBUKCykI_yeL9OcrCGYJCm2byNY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AndroidUtilities.lambda$showProxyAlert$4(address, port, secret, password, user, dismissRunnable, view2);
            }
        });
        builder.show();
    }

    static /* synthetic */ void lambda$showProxyAlert$4(String str, String str2, String str3, String str4, String str5, Runnable runnable, View view) {
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
            proxyInfo = new SharedConfig.ProxyInfo(str, iIntValue, str5, str4, "");
        } else {
            editorEdit.remove("proxy_pass");
            editorEdit.remove("proxy_user");
            editorEdit.putString("proxy_secret", str3);
            proxyInfo = new SharedConfig.ProxyInfo(str, iIntValue, "", "", str3);
        }
        editorEdit.commit();
        SharedConfig.currentProxy = SharedConfig.addProxy(proxyInfo);
        ConnectionsManager.setProxySettings(true, str, iIntValue, str5, str4, str3);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.proxySettingsChanged, new Object[0]);
        runnable.run();
    }

    @SuppressLint({"PrivateApi"})
    public static String getSystemProperty(String key) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, key);
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

    public static CharSequence concat(CharSequence... text) {
        if (text.length == 0) {
            return "";
        }
        int i = 0;
        boolean z = true;
        if (text.length == 1) {
            return text[0];
        }
        int length = text.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (text[i2] instanceof Spanned) {
                break;
            }
            i2++;
        }
        if (z) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int length2 = text.length;
            while (i < length2) {
                CharSequence charSequence = text[i];
                if (charSequence == null) {
                    charSequence = "null";
                }
                spannableStringBuilder.append(charSequence);
                i++;
            }
            return new SpannedString(spannableStringBuilder);
        }
        StringBuilder sb = new StringBuilder();
        int length3 = text.length;
        while (i < length3) {
            sb.append(text[i]);
            i++;
        }
        return sb.toString();
    }

    public static float[] RGBtoHSB(int r, int g, int b) {
        float[] fArr = new float[3];
        int iMax = Math.max(r, g);
        if (b > iMax) {
            iMax = b;
        }
        int iMin = Math.min(r, g);
        if (b < iMin) {
            iMin = b;
        }
        float f = iMax;
        float f2 = f / 255.0f;
        float f3 = 0.0f;
        float f4 = iMax != 0 ? (iMax - iMin) / f : 0.0f;
        if (f4 != 0.0f) {
            float f5 = iMax - iMin;
            float f6 = (iMax - r) / f5;
            float f7 = (iMax - g) / f5;
            float f8 = (iMax - b) / f5;
            float f9 = (r == iMax ? f8 - f7 : g == iMax ? (f6 + 2.0f) - f8 : (f7 + 4.0f) - f6) / 6.0f;
            f3 = f9 < 0.0f ? f9 + 1.0f : f9;
        }
        fArr[0] = f3;
        fArr[1] = f4;
        fArr[2] = f2;
        return fArr;
    }

    public static int HSBtoRGB(float hue, float saturation, float brightness) {
        int i;
        int i2;
        int i3 = 0;
        if (saturation == 0.0f) {
            i3 = (int) ((brightness * 255.0f) + 0.5f);
            i = i3;
            i2 = i;
        } else {
            float fFloor = (hue - ((float) Math.floor(hue))) * 6.0f;
            float fFloor2 = fFloor - ((float) Math.floor(fFloor));
            float f = (1.0f - saturation) * brightness;
            float f2 = (1.0f - (saturation * fFloor2)) * brightness;
            float f3 = (1.0f - (saturation * (1.0f - fFloor2))) * brightness;
            int i4 = (int) fFloor;
            if (i4 == 0) {
                i3 = (int) ((brightness * 255.0f) + 0.5f);
                i = (int) ((f3 * 255.0f) + 0.5f);
            } else if (i4 == 1) {
                i3 = (int) ((f2 * 255.0f) + 0.5f);
                i = (int) ((brightness * 255.0f) + 0.5f);
            } else if (i4 != 2) {
                if (i4 == 3) {
                    i3 = (int) ((f * 255.0f) + 0.5f);
                    i = (int) ((f2 * 255.0f) + 0.5f);
                } else if (i4 == 4) {
                    i3 = (int) ((f3 * 255.0f) + 0.5f);
                    i = (int) ((f * 255.0f) + 0.5f);
                } else if (i4 != 5) {
                    i = 0;
                    i2 = 0;
                } else {
                    i3 = (int) ((brightness * 255.0f) + 0.5f);
                    i = (int) ((f * 255.0f) + 0.5f);
                    i2 = (int) ((f2 * 255.0f) + 0.5f);
                }
                i2 = (int) ((brightness * 255.0f) + 0.5f);
            } else {
                i3 = (int) ((f * 255.0f) + 0.5f);
                i = (int) ((brightness * 255.0f) + 0.5f);
                i2 = (int) ((f3 * 255.0f) + 0.5f);
            }
            i2 = (int) ((f * 255.0f) + 0.5f);
        }
        return ((i & 255) << 8) | (-16777216) | ((i3 & 255) << 16) | (i2 & 255);
    }

    public static float computePerceivedBrightness(int color) {
        return (((Color.red(color) * 0.2126f) + (Color.green(color) * 0.7152f)) + (Color.blue(color) * 0.0722f)) / 255.0f;
    }

    public static int getPatternColor(int color) {
        return getPatternColor(color, false);
    }

    public static int getPatternColor(int color, boolean alwaysDark) {
        float[] fArrRGBtoHSB = RGBtoHSB(Color.red(color), Color.green(color), Color.blue(color));
        if (fArrRGBtoHSB[1] > 0.0f || (fArrRGBtoHSB[2] < 1.0f && fArrRGBtoHSB[2] > 0.0f)) {
            fArrRGBtoHSB[1] = Math.min(1.0f, fArrRGBtoHSB[1] + (alwaysDark ? 0.15f : 0.05f) + ((1.0f - fArrRGBtoHSB[1]) * 0.1f));
        }
        if (alwaysDark || fArrRGBtoHSB[2] > 0.5f) {
            fArrRGBtoHSB[2] = Math.max(0.0f, fArrRGBtoHSB[2] * 0.65f);
        } else {
            fArrRGBtoHSB[2] = Math.max(0.0f, Math.min(1.0f, 1.0f - (fArrRGBtoHSB[2] * 0.65f)));
        }
        return HSBtoRGB(fArrRGBtoHSB[0], fArrRGBtoHSB[1], fArrRGBtoHSB[2]) & (alwaysDark ? -1711276033 : 1728053247);
    }

    public static int getPatternSideColor(int color) {
        float[] fArrRGBtoHSB = RGBtoHSB(Color.red(color), Color.green(color), Color.blue(color));
        fArrRGBtoHSB[1] = Math.min(1.0f, fArrRGBtoHSB[1] + 0.05f);
        if (fArrRGBtoHSB[2] > 0.5f) {
            fArrRGBtoHSB[2] = Math.max(0.0f, fArrRGBtoHSB[2] * 0.9f);
        } else {
            fArrRGBtoHSB[2] = Math.max(0.0f, fArrRGBtoHSB[2] * 0.9f);
        }
        return HSBtoRGB(fArrRGBtoHSB[0], fArrRGBtoHSB[1], fArrRGBtoHSB[2]) | (-16777216);
    }

    public static String getWallPaperUrl(Object object) {
        if (object instanceof TLRPC$TL_wallPaper) {
            TLRPC$TL_wallPaper tLRPC$TL_wallPaper = (TLRPC$TL_wallPaper) object;
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
        if (object instanceof WallpapersListActivity.ColorWallpaper) {
            return ((WallpapersListActivity.ColorWallpaper) object).getUrl();
        }
        return null;
    }

    public static float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    public static void makeAccessibilityAnnouncement(CharSequence what) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) ApplicationLoader.applicationContext.getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            accessibilityEventObtain.setEventType(16384);
            accessibilityEventObtain.getText().add(what);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    public static int getOffsetColor(int color1, int color2, float offset, float alpha) {
        int iRed = Color.red(color2);
        int iGreen = Color.green(color2);
        int iBlue = Color.blue(color2);
        int iAlpha = Color.alpha(color2);
        int iRed2 = Color.red(color1);
        int iGreen2 = Color.green(color1);
        int iBlue2 = Color.blue(color1);
        return Color.argb((int) ((Color.alpha(color1) + ((iAlpha - r7) * offset)) * alpha), (int) (iRed2 + ((iRed - iRed2) * offset)), (int) (iGreen2 + ((iGreen - iGreen2) * offset)), (int) (iBlue2 + ((iBlue - iBlue2) * offset)));
    }

    public static int indexOfIgnoreCase(final String origin, final String searchStr) {
        if (searchStr.isEmpty() || origin.isEmpty()) {
            return origin.indexOf(searchStr);
        }
        for (int i = 0; i < origin.length() && searchStr.length() + i <= origin.length(); i++) {
            int i2 = 0;
            for (int i3 = i; i3 < origin.length() && i2 < searchStr.length() && Character.toLowerCase(origin.charAt(i3)) == Character.toLowerCase(searchStr.charAt(i2)); i3++) {
                i2++;
            }
            if (i2 == searchStr.length()) {
                return i;
            }
        }
        return -1;
    }

    public static float lerp(float[] ab, float f) {
        return lerp(ab[0], ab[1], f);
    }

    public static boolean hasFlagSecureFragment() {
        return flagSecureFragment != null;
    }

    public static void setFlagSecure(BaseFragment parentFragment, boolean set) {
        if (parentFragment == null || parentFragment.getParentActivity() == null) {
            return;
        }
        if (set) {
            try {
                parentFragment.getParentActivity().getWindow().setFlags(8192, 8192);
                flagSecureFragment = new WeakReference<>(parentFragment);
            } catch (Exception unused) {
            }
        } else {
            WeakReference<BaseFragment> weakReference = flagSecureFragment;
            if (weakReference == null || weakReference.get() != parentFragment) {
                return;
            }
            try {
                parentFragment.getParentActivity().getWindow().clearFlags(8192);
            } catch (Exception unused2) {
            }
            flagSecureFragment = null;
        }
    }

    public static void openSharing(BaseFragment fragment, String url) {
        if (fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        fragment.showDialog(new ShareAlert(fragment.getParentActivity(), null, url, false, url, false));
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
            return "";
        }
    }

    public static boolean isPunctuationCharacter(char ch) {
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
        return charactersMap.contains(Character.valueOf(ch));
    }

    public static int getColorDistance(int color1, int color2) {
        int iRed = Color.red(color1);
        int iGreen = Color.green(color1);
        int iBlue = Color.blue(color1);
        int iRed2 = Color.red(color2);
        int i = (iRed + iRed2) / 2;
        int i2 = iRed - iRed2;
        int iGreen2 = iGreen - Color.green(color2);
        int iBlue2 = iBlue - Color.blue(color2);
        return ((((i + Factory.DEVICE_USE_ANDROID_CAMCORDER) * i2) * i2) >> 8) + (iGreen2 * 4 * iGreen2) + ((((767 - i) * iBlue2) * iBlue2) >> 8);
    }

    public static int getAverageColor(int color1, int color2) {
        return Color.argb(255, (Color.red(color1) / 2) + (Color.red(color2) / 2), (Color.green(color1) / 2) + (Color.green(color2) / 2), (Color.blue(color1) / 2) + (Color.blue(color2) / 2));
    }

    public static void setLightStatusBar(Window window, boolean enable) {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (enable) {
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
                window.setStatusBarColor(855638016);
            }
        }
    }

    public static void setLightNavigationBar(Window window, boolean enable) {
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(enable ? systemUiVisibility | 16 : systemUiVisibility & (-17));
        }
    }

    public static boolean checkHostForPunycode(String url) {
        boolean z;
        boolean z2;
        try {
            int length = url.length();
            z = false;
            z2 = false;
            for (int i = 0; i < length; i++) {
                try {
                    char cCharAt = url.charAt(i);
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

    public static boolean shouldShowUrlInAlert(String url) {
        try {
            return checkHostForPunycode(Uri.parse(url).getHost());
        } catch (Exception e) {
            FileLog.e(e);
            return false;
        }
    }

    public static void scrollToFragmentRow(ActionBarLayout parentLayout, final String rowName) {
        if (parentLayout == null || rowName == null) {
            return;
        }
        ArrayList<BaseFragment> arrayList = parentLayout.fragmentsStack;
        final BaseFragment baseFragment = arrayList.get(arrayList.size() - 1);
        try {
            Field declaredField = baseFragment.getClass().getDeclaredField("listView");
            declaredField.setAccessible(true);
            final RecyclerListView recyclerListView = (RecyclerListView) declaredField.get(baseFragment);
            recyclerListView.highlightRow(new RecyclerListView.IntReturnCallback() { // from class: ir.eitaa.messenger.-$$Lambda$AndroidUtilities$0yTDDQS-_9_b52IlIp87nrmF31M
                @Override // ir.eitaa.ui.Components.RecyclerListView.IntReturnCallback
                public final int run() {
                    return AndroidUtilities.lambda$scrollToFragmentRow$5(baseFragment, rowName, recyclerListView);
                }
            });
            declaredField.setAccessible(false);
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ int lambda$scrollToFragmentRow$5(BaseFragment baseFragment, String str, RecyclerListView recyclerListView) {
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

    public static void updateVisibleRows(RecyclerListView listView) {
        RecyclerView.Adapter adapter;
        RecyclerView.ViewHolder childViewHolder;
        if (listView == null || (adapter = listView.getAdapter()) == null) {
            return;
        }
        for (int i = 0; i < listView.getChildCount(); i++) {
            View childAt = listView.getChildAt(i);
            int childAdapterPosition = listView.getChildAdapterPosition(childAt);
            if (childAdapterPosition >= 0 && (childViewHolder = listView.getChildViewHolder(childAt)) != null && !childViewHolder.shouldIgnore()) {
                adapter.onBindViewHolder(childViewHolder, childAdapterPosition);
            }
        }
    }

    public static void updateViewVisibilityAnimated(View view, boolean show) {
        updateViewVisibilityAnimated(view, show, 1.0f, true);
    }

    public static void updateViewVisibilityAnimated(View view, boolean show, float scaleFactor, boolean animated) {
        if (view.getParent() == null) {
            animated = false;
        }
        if (!animated) {
            view.animate().setListener(null).cancel();
            view.setVisibility(show ? 0 : 8);
            view.setTag(show ? 1 : null);
            view.setAlpha(1.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            return;
        }
        if (show && view.getTag() == null) {
            view.animate().setListener(null).cancel();
            if (view.getVisibility() != 0) {
                view.setVisibility(0);
                view.setAlpha(0.0f);
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
            }
            view.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(150L).start();
            view.setTag(1);
            return;
        }
        if (show || view.getTag() == null) {
            return;
        }
        view.animate().setListener(null).cancel();
        view.animate().alpha(0.0f).scaleY(scaleFactor).scaleX(scaleFactor).setListener(new HideViewAfterAnimation(view)).setDuration(150L).start();
        view.setTag(null);
    }

    public static long getPrefIntOrLong(SharedPreferences preferences, String key, long defaultValue) {
        try {
            return preferences.getLong(key, defaultValue);
        } catch (Exception unused) {
            return preferences.getInt(key, (int) defaultValue);
        }
    }

    public void sendLog(final TLObject request, final TLObject response) {
        this.executorService.execute(new Runnable() { // from class: ir.eitaa.messenger.AndroidUtilities.2
            @Override // java.lang.Runnable
            public void run() throws JSONException, IOException {
                String strWriteValueAsString;
                ObjectWriter objectWriterWriter = new ObjectMapper().writer();
                String strWriteValueAsString2 = null;
                try {
                    strWriteValueAsString = objectWriterWriter.writeValueAsString(request);
                    try {
                        strWriteValueAsString2 = objectWriterWriter.writeValueAsString(response);
                    } catch (JsonProcessingException e) {
                        e = e;
                        e.printStackTrace();
                        if (strWriteValueAsString != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                } catch (JsonProcessingException e2) {
                    e = e2;
                    strWriteValueAsString = null;
                }
                if (strWriteValueAsString != null || strWriteValueAsString2 == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("Request", strWriteValueAsString);
                    jSONObject.put("Response", strWriteValueAsString2);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    FileLog.e("TSMS JSONException: ", e3);
                }
                AndroidUtilities.this.executeHTTPPost("http://www.tsms.ir/eitaa/log.php", jSONObject.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String executeHTTPPost(String targetURL, String urlParameters) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(targetURL).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(urlParameters.getBytes("utf-8"));
            dataOutputStream.flush();
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    stringBuffer.append(line);
                    stringBuffer.append('\r');
                } else {
                    bufferedReader.close();
                    String string = stringBuffer.toString();
                    httpURLConnection.disconnect();
                    return string;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String fixNumbers(String text) {
        return LocaleController.isRTL ? text.replaceAll("0", "٠").replaceAll("1", "١").replaceAll("2", "٢").replaceAll("3", "٣").replaceAll("4", "٤").replaceAll("5", "٥").replaceAll("6", "٦").replaceAll("7", "٧").replaceAll("8", "٨").replaceAll("9", "٩") : text;
    }
}
