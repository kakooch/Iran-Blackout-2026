package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.header.ims.AuthorizationHeaderIms;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.z0;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import livekit.org.webrtc.MediaStreamTrack;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.aN7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9683aN7 {
    public static final int a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final byte[] f;
    private static final Pattern g;
    private static final Pattern h;
    private static final Pattern i;
    private static final Pattern j;
    private static HashMap k;
    private static final String[] l;
    private static final String[] m;
    private static final int[] n;
    private static final int[] o;

    /* renamed from: ir.nasim.aN7$a */
    private static final class a {
        public static Drawable a(Context context, Resources resources, int i) {
            return resources.getDrawable(i, context.getTheme());
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = i2;
        String str = Build.DEVICE;
        b = str;
        String str2 = Build.MANUFACTURER;
        c = str2;
        String str3 = Build.MODEL;
        d = str3;
        e = str + ", " + str3 + ", " + str2 + ", " + i2;
        f = new byte[0];
        g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        i = Pattern.compile("%([A-Fa-f0-9]{2})");
        j = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        l = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        m = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        n = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        o = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 119, 126, WKSRecord.Service.ERPC, Type.EUI48, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER, 252, Type.IXFR, 242, 245, 216, 223, SetUpdatesStruct$ComposedUpdates.GROUP_ABOUT_CHANGED_OBSOLETE_FIELD_NUMBER, 209, 196, 195, 202, SetRpcStruct$ComposedRpc.EDIT_NICK_NAME_FIELD_NUMBER, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER, 151, 158, SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER, WKSRecord.Service.EMFIS_DATA, WKSRecord.Service.NETBIOS_SSN, 130, WKSRecord.Service.STATSRV, 168, 175, 166, SetUpdatesStruct$ComposedUpdates.OWN_STICKERS_CHANGED_FIELD_NUMBER, SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER, 186, SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER, 199, 192, 201, SetRpcStruct$ComposedRpc.CHECK_NICK_NAME_FIELD_NUMBER, 219, SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER, 213, 210, 255, 248, 241, SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_REMOVED_FIELD_NUMBER, 237, SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER, 183, 176, 185, SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER, 171, 172, 165, SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER, 136, 129, 134, 147, 148, SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, WKSRecord.Service.SUNRPC, 104, 97, 102, 115, 116, 125, 122, 137, WKSRecord.Service.BL_IDM, 135, 128, 149, SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER, 155, 156, SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER, 182, SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER, 184, 173, 170, SetUpdatesStruct$ComposedUpdates.MESSAGE_DATE_CHANGED_FIELD_NUMBER, SetUpdatesStruct$ComposedUpdates.STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER, 249, 254, SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER, 226, SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER, 236, SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, WKSRecord.Service.UUCP_PATH, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, 113, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 127, Type.L64, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, SetUpdatesStruct$ComposedUpdates.MESSAGE_QUOTED_CHANGED_FIELD_NUMBER, 160, 167, SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER, 188, SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER, 150, SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER, 152, 159, WKSRecord.Service.NETBIOS_DGM, WKSRecord.Service.EMFIS_CNTL, WKSRecord.Service.CISCO_SYS, 131, 222, 217, 208, 215, 194, 197, SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER, 203, SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER, 225, 232, SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER, Type.TSIG, 253, SetRpcStruct$ComposedRpc.ADD_STICKER_COLLECTION_FIELD_NUMBER, WKSRecord.Service.SUR_MEAS};
    }

    public static String A(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private static String A0(String str) {
        int i2 = 0;
        while (true) {
            String[] strArr = m;
            if (i2 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i2])) {
                return strArr[i2 + 1] + str.substring(strArr[i2].length());
            }
            i2 += 2;
        }
    }

    public static String B(byte[] bArr) {
        return new String(bArr, AbstractC12884fL0.c);
    }

    public static long B0(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 * 1000;
    }

    public static String C(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, AbstractC12884fL0.c);
    }

    public static ExecutorService C0(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: ir.nasim.XM7
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AbstractC9683aN7.y0(str, runnable);
            }
        });
    }

    public static int D(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static String D0(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals("und")) {
            str = strReplace;
        }
        String strE = AbstractC14083hK.e(str);
        String str2 = S0(strE, "-")[0];
        if (k == null) {
            k = z();
        }
        String str3 = (String) k.get(str2);
        if (str3 != null) {
            strE = str3 + strE.substring(str2.length());
            str2 = str3;
        }
        return (AuthorizationHeaderIms.NO.equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? A0(strE) : strE;
    }

    public static int E(int i2) {
        if (i2 == 12) {
            return 743676;
        }
        switch (i2) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER;
            case 5:
                return SetRpcStruct$ComposedRpc.MESSAGE_REMOVE_REACTION_FIELD_NUMBER;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                return 6396;
            default:
                return 0;
        }
    }

    public static Object[] E0(Object[] objArr, Object obj) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
        objArrCopyOf[objArr.length] = obj;
        return k(objArrCopyOf);
    }

    public static z0.b F(com.google.android.exoplayer2.z0 z0Var, z0.b bVar) {
        boolean zK = z0Var.k();
        boolean zP0 = z0Var.p0();
        boolean zG0 = z0Var.g0();
        boolean zG = z0Var.G();
        boolean zF0 = z0Var.F0();
        boolean zL = z0Var.L();
        boolean zV = z0Var.N().v();
        boolean z = false;
        z0.b.a aVarD = new z0.b.a().b(bVar).d(4, !zK).d(5, zP0 && !zK).d(6, zG0 && !zK).d(7, !zV && (zG0 || !zF0 || zP0) && !zK).d(8, zG && !zK).d(9, !zV && (zG || (zF0 && zL)) && !zK).d(10, !zK).d(11, zP0 && !zK);
        if (zP0 && !zK) {
            z = true;
        }
        return aVarD.d(12, z).e();
    }

    public static Object[] F0(Object[] objArr, Object[] objArr2) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + objArr2.length);
        System.arraycopy(objArr2, 0, objArrCopyOf, objArr.length, objArr2.length);
        return objArrCopyOf;
    }

    public static int G(ByteBuffer byteBuffer, int i2) {
        int i3 = byteBuffer.getInt(i2);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i3 : Integer.reverseBytes(i3);
    }

    public static Object[] G0(Object[] objArr, int i2) {
        AbstractC20011rK.a(i2 <= objArr.length);
        return Arrays.copyOf(objArr, i2);
    }

    public static int H(String str, int i2) {
        int i3 = 0;
        for (String str2 : T0(str)) {
            if (i2 == AbstractC24462yf4.m(str2)) {
                i3++;
            }
        }
        return i3;
    }

    public static Object[] H0(Object[] objArr, int i2, int i3) {
        AbstractC20011rK.a(i2 >= 0);
        AbstractC20011rK.a(i3 <= objArr.length);
        return Arrays.copyOfRange(objArr, i2, i3);
    }

    public static String I(String str, int i2) {
        String[] strArrT0 = T0(str);
        if (strArrT0.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrT0) {
            if (i2 == AbstractC24462yf4.m(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public static long I0(String str) throws ParserException {
        Matcher matcher = g.matcher(str);
        if (!matcher.matches()) {
            throw ParserException.a("Invalid date/time format: " + str, null);
        }
        int i2 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i2 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i2 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i2 != 0 ? timeInMillis - (i2 * 60000) : timeInMillis;
    }

    public static String J(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            sb.append(objArr[i2].getClass().getSimpleName());
            if (i2 < objArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static boolean J0(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static String K(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return AbstractC14083hK.f(networkCountryIso);
            }
        }
        return AbstractC14083hK.f(Locale.getDefault().getCountry());
    }

    public static boolean K0(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static Point L(Context context) {
        DisplayManager displayManager;
        Display display = (a < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            display = ((WindowManager) AbstractC20011rK.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return M(context, display);
    }

    public static Intent L0(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return a < 33 ? context.registerReceiver(broadcastReceiver, intentFilter) : context.registerReceiver(broadcastReceiver, intentFilter, 4);
    }

    public static Point M(Context context, Display display) throws NumberFormatException {
        if (display.getDisplayId() == 0 && x0(context)) {
            String strJ0 = a < 28 ? j0("sys.display-size") : j0("vendor.display-size");
            if (!TextUtils.isEmpty(strJ0)) {
                try {
                    String[] strArrR0 = R0(strJ0.trim(), "x");
                    if (strArrR0.length == 2) {
                        int i2 = Integer.parseInt(strArrR0[0]);
                        int i3 = Integer.parseInt(strArrR0[1]);
                        if (i2 > 0 && i3 > 0) {
                            return new Point(i2, i3);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                AbstractC18815pI3.c("Util", "Invalid display size: " + strJ0);
            }
            if ("Sony".equals(c) && d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i4 = a;
        if (i4 >= 23) {
            R(display, point);
        } else if (i4 >= 17) {
            Q(display, point);
        } else {
            P(display, point);
        }
        return point;
    }

    public static void M0(List list, int i2, int i3) {
        if (i2 < 0 || i3 > list.size() || i2 > i3) {
            throw new IllegalArgumentException();
        }
        if (i2 != i3) {
            list.subList(i2, i3).clear();
        }
    }

    public static Looper N() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static long N0(long j2, long j3, long j4) {
        if (j4 >= j3 && j4 % j3 == 0) {
            return j2 / (j4 / j3);
        }
        if (j4 < j3 && j3 % j4 == 0) {
            return j2 * (j3 / j4);
        }
        return (long) (j2 * (j3 / j4));
    }

    public static Locale O() {
        return a >= 24 ? Locale.getDefault(Locale.Category.DISPLAY) : Locale.getDefault();
    }

    public static void O0(long[] jArr, long j2, long j3) {
        int i2 = 0;
        if (j3 >= j2 && j3 % j2 == 0) {
            long j4 = j3 / j2;
            while (i2 < jArr.length) {
                jArr[i2] = jArr[i2] / j4;
                i2++;
            }
            return;
        }
        if (j3 >= j2 || j2 % j3 != 0) {
            double d2 = j2 / j3;
            while (i2 < jArr.length) {
                jArr[i2] = (long) (jArr[i2] * d2);
                i2++;
            }
            return;
        }
        long j5 = j2 / j3;
        while (i2 < jArr.length) {
            jArr[i2] = jArr[i2] * j5;
            i2++;
        }
    }

    private static void P(Display display, Point point) {
        display.getSize(point);
    }

    public static void P0(Throwable th) throws Throwable {
        Q0(th);
    }

    private static void Q(Display display, Point point) {
        display.getRealSize(point);
    }

    private static void R(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static String[] R0(String str, String str2) {
        return str.split(str2, -1);
    }

    public static Drawable S(Context context, Resources resources, int i2) {
        return a >= 21 ? a.a(context, resources, i2) : resources.getDrawable(i2);
    }

    public static String[] S0(String str, String str2) {
        return str.split(str2, 2);
    }

    public static int T(int i2) {
        if (i2 == 2 || i2 == 4) {
            return 6005;
        }
        if (i2 == 10) {
            return 6004;
        }
        if (i2 == 7) {
            return 6005;
        }
        if (i2 == 8) {
            return 6003;
        }
        switch (i2) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i2) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static String[] T0(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : R0(str.trim(), "(\\s*,\\s*)");
    }

    public static int U(String str) throws NumberFormatException {
        String[] strArrR0;
        int length;
        if (str == null || (length = (strArrR0 = R0(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = strArrR0[length - 1];
        boolean z = length >= 3 && "neg".equals(strArrR0[length - 2]);
        try {
            int i2 = Integer.parseInt((String) AbstractC20011rK.e(str2));
            return z ? -i2 : i2;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static ComponentName U0(Context context, Intent intent) {
        return a >= 26 ? context.startForegroundService(intent) : context.startService(intent);
    }

    public static String V(int i2) {
        if (i2 == 0) {
            return "NO";
        }
        if (i2 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i2 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i2 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i2 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static long V0(long j2, long j3, long j4) {
        long j5 = j2 - j3;
        return ((j2 ^ j5) & (j3 ^ j2)) < 0 ? j4 : j5;
    }

    public static String W(Locale locale) {
        return a >= 21 ? X(locale) : locale.toString();
    }

    public static boolean W0(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    private static String X(Locale locale) {
        return locale.toLanguageTag();
    }

    public static byte[] X0(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static long Y(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 * f2);
    }

    public static long Y0(int i2, int i3) {
        return Z0(i3) | (Z0(i2) << 32);
    }

    public static long Z(long j2) {
        return j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime();
    }

    public static long Z0(int i2) {
        return i2 & 4294967295L;
    }

    public static int a0(int i2) {
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 2;
        }
        if (i2 != 24) {
            return i2 != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    public static CharSequence a1(CharSequence charSequence, int i2) {
        return charSequence.length() <= i2 ? charSequence : charSequence.subSequence(0, i2);
    }

    public static long b(long j2, long j3, long j4) {
        long j5 = j2 + j3;
        return ((j2 ^ j5) & (j3 ^ j5)) < 0 ? j4 : j5;
    }

    public static com.google.android.exoplayer2.X b0(int i2, int i3, int i4) {
        return new X.b().g0("audio/raw").J(i3).h0(i4).a0(i2).G();
    }

    public static String b1(String str) {
        int length = str.length();
        int iEnd = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) == '%') {
                i2++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        int i4 = length - (i2 * 2);
        StringBuilder sb = new StringBuilder(i4);
        Matcher matcher = i.matcher(str);
        while (i2 > 0 && matcher.find()) {
            char c2 = (char) Integer.parseInt((String) AbstractC20011rK.e(matcher.group(1)), 16);
            sb.append((CharSequence) str, iEnd, matcher.start());
            sb.append(c2);
            iEnd = matcher.end();
            i2--;
        }
        if (iEnd < length) {
            sb.append((CharSequence) str, iEnd, length);
        }
        if (sb.length() != i4) {
            return null;
        }
        return sb.toString();
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int c0(int i2, int i3) {
        if (i2 != 2) {
            if (i2 == 3) {
                return i3;
            }
            if (i2 != 4) {
                if (i2 != 268435456) {
                    if (i2 == 536870912) {
                        return i3 * 3;
                    }
                    if (i2 != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i3 * 4;
        }
        return i3 * 2;
    }

    public static long c1(long j2) {
        return (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? j2 : j2 / 1000;
    }

    public static int d(List list, Comparable comparable, boolean z, boolean z2) {
        int i2;
        int i3;
        int iBinarySearch = Collections.binarySearch(list, comparable);
        if (iBinarySearch < 0) {
            i3 = ~iBinarySearch;
        } else {
            int size = list.size();
            while (true) {
                i2 = iBinarySearch + 1;
                if (i2 >= size || ((Comparable) list.get(i2)).compareTo(comparable) != 0) {
                    break;
                }
                iBinarySearch = i2;
            }
            i3 = z ? iBinarySearch : i2;
        }
        return z2 ? Math.min(list.size() - 1, i3) : i3;
    }

    public static long d0(long j2, float f2) {
        return f2 == 1.0f ? j2 : Math.round(j2 / f2);
    }

    public static void d1(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static int e(long[] jArr, long j2, boolean z, boolean z2) {
        int i2;
        int i3;
        int iBinarySearch = Arrays.binarySearch(jArr, j2);
        if (iBinarySearch < 0) {
            i3 = ~iBinarySearch;
        } else {
            while (true) {
                i2 = iBinarySearch + 1;
                if (i2 >= jArr.length || jArr[i2] != j2) {
                    break;
                }
                iBinarySearch = i2;
            }
            i3 = z ? iBinarySearch : i2;
        }
        return z2 ? Math.min(jArr.length - 1, i3) : i3;
    }

    public static int e0(int i2) {
        if (i2 == 13) {
            return 1;
        }
        switch (i2) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static int f(YI3 yi3, long j2, boolean z, boolean z2) {
        int i2;
        int iC = yi3.c() - 1;
        int i3 = 0;
        while (i3 <= iC) {
            int i4 = (i3 + iC) >>> 1;
            if (yi3.b(i4) < j2) {
                i3 = i4 + 1;
            } else {
                iC = i4 - 1;
            }
        }
        if (z && (i2 = iC + 1) < yi3.c() && yi3.b(i2) == j2) {
            return i2;
        }
        if (z2 && iC == -1) {
            return 0;
        }
        return iC;
    }

    public static String f0(StringBuilder sb, Formatter formatter, long j2) {
        if (j2 == -9223372036854775807L) {
            j2 = 0;
        }
        String str = j2 < 0 ? "-" : "";
        long jAbs = (Math.abs(j2) + 500) / 1000;
        long j3 = jAbs % 60;
        long j4 = (jAbs / 60) % 60;
        long j5 = jAbs / 3600;
        sb.setLength(0);
        return j5 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j4), Long.valueOf(j3)).toString();
    }

    public static int g(List list, Comparable comparable, boolean z, boolean z2) {
        int i2;
        int i3;
        int iBinarySearch = Collections.binarySearch(list, comparable);
        if (iBinarySearch < 0) {
            i3 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i2 = iBinarySearch - 1;
                if (i2 < 0 || ((Comparable) list.get(i2)).compareTo(comparable) != 0) {
                    break;
                }
                iBinarySearch = i2;
            }
            i3 = z ? iBinarySearch : i2;
        }
        return z2 ? Math.max(0, i3) : i3;
    }

    public static String[] g0() {
        String[] strArrH0 = h0();
        for (int i2 = 0; i2 < strArrH0.length; i2++) {
            strArrH0[i2] = D0(strArrH0[i2]);
        }
        return strArrH0;
    }

    public static int h(int[] iArr, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int iBinarySearch = Arrays.binarySearch(iArr, i2);
        if (iBinarySearch < 0) {
            i4 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i3 = iBinarySearch - 1;
                if (i3 < 0 || iArr[i3] != i2) {
                    break;
                }
                iBinarySearch = i3;
            }
            i4 = z ? iBinarySearch : i3;
        }
        return z2 ? Math.max(0, i4) : i4;
    }

    private static String[] h0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return a >= 24 ? i0(configuration) : new String[]{W(configuration.locale)};
    }

    public static int i(long[] jArr, long j2, boolean z, boolean z2) {
        int i2;
        int i3;
        int iBinarySearch = Arrays.binarySearch(jArr, j2);
        if (iBinarySearch < 0) {
            i3 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i2 = iBinarySearch - 1;
                if (i2 < 0 || jArr[i2] != j2) {
                    break;
                }
                iBinarySearch = i2;
            }
            i3 = z ? iBinarySearch : i2;
        }
        return z2 ? Math.max(0, i3) : i3;
    }

    private static String[] i0(Configuration configuration) {
        return R0(configuration.getLocales().toLanguageTags(), ",");
    }

    private static String j0(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e2) {
            AbstractC18815pI3.d("Util", "Failed to read system property " + str, e2);
            return null;
        }
    }

    public static String k0(int i2) {
        switch (i2) {
            case -2:
                return "none";
            case -1:
                return CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE;
            case 0:
                return "default";
            case 1:
                return MediaStreamTrack.AUDIO_TRACK_KIND;
            case 2:
                return MediaStreamTrack.VIDEO_TRACK_KIND;
            case 3:
                return ParameterNames.TEXT;
            case 4:
                return "image";
            case 5:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                if (i2 < 10000) {
                    return Separators.QUESTION;
                }
                return "custom (" + i2 + Separators.RPAREN;
        }
    }

    public static int l(int i2, int i3) {
        return ((i2 + i3) - 1) / i3;
    }

    public static String l0(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = Separators.QUESTION;
        }
        return str + Separators.SLASH + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.18.3";
    }

    public static void m(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] m0(String str) {
        return str.getBytes(AbstractC12884fL0.c);
    }

    public static int n(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    public static int n0(Uri uri) {
        int iO0;
        String scheme = uri.getScheme();
        if (scheme != null && AbstractC14083hK.a("rtsp", scheme)) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int iLastIndexOf = lastPathSegment.lastIndexOf(46);
        if (iLastIndexOf >= 0 && (iO0 = o0(lastPathSegment.substring(iLastIndexOf + 1))) != 4) {
            return iO0;
        }
        Matcher matcher = j.matcher((CharSequence) AbstractC20011rK.e(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String strGroup = matcher.group(2);
        if (strGroup != null) {
            if (strGroup.contains("format=mpd-time-csf")) {
                return 0;
            }
            if (strGroup.contains("format=m3u8-aapl")) {
                return 2;
            }
        }
        return 1;
    }

    public static float o(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f2, f4));
    }

    public static int o0(String str) {
        String strE = AbstractC14083hK.e(str);
        strE.hashCode();
        switch (strE) {
            case "ism":
            case "isml":
                return 1;
            case "mpd":
                return 0;
            case "m3u8":
                return 2;
            default:
                return 4;
        }
    }

    public static int p(int i2, int i3, int i4) {
        return Math.max(i3, Math.min(i2, i4));
    }

    public static int p0(Uri uri, String str) {
        if (str == null) {
            return n0(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            case "application/x-rtsp":
                return 3;
            default:
                return 4;
        }
    }

    public static long q(long j2, long j3, long j4) {
        return Math.max(j3, Math.min(j2, j4));
    }

    public static boolean q0(EW4 ew4, EW4 ew42, Inflater inflater) {
        if (ew4.a() <= 0) {
            return false;
        }
        if (ew42.b() < ew4.a()) {
            ew42.c(ew4.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(ew4.e(), ew4.f(), ew4.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(ew42.e(), iInflate, ew42.b() - iInflate);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                    }
                    if (iInflate == ew42.b()) {
                        ew42.c(ew42.b() * 2);
                    }
                } else {
                    ew42.R(iInflate);
                    inflater.reset();
                    return true;
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static boolean r(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (c(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static String r0(int i2) {
        return Integer.toString(i2, 36);
    }

    public static int s(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = n[((i4 >>> 24) ^ (bArr[i2] & 255)) & 255] ^ (i4 << 8);
            i2++;
        }
        return i4;
    }

    public static boolean s0(Context context) {
        return a >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static int t(byte[] bArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            i4 = o[i4 ^ (bArr[i2] & 255)];
            i2++;
        }
        return i4;
    }

    public static boolean t0(int i2) {
        return i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static Handler u(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static boolean u0(int i2) {
        return i2 == 3 || i2 == 2 || i2 == 268435456 || i2 == 536870912 || i2 == 805306368 || i2 == 4;
    }

    public static Handler v() {
        return w(null);
    }

    public static boolean v0(int i2) {
        return i2 == 10 || i2 == 13;
    }

    public static Handler w(Handler.Callback callback) {
        return u((Looper) AbstractC20011rK.i(Looper.myLooper()), callback);
    }

    public static boolean w0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static Handler x() {
        return y(null);
    }

    public static boolean x0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static Handler y(Handler.Callback callback) {
        return u(N(), callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread y0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    private static HashMap z() throws MissingResourceException {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap map = new HashMap(iSOLanguages.length + l.length);
        int i2 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    map.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = l;
            if (i2 >= strArr.length) {
                return map;
            }
            map.put(strArr[i2], strArr[i2 + 1]);
            i2 += 2;
        }
    }

    public static int z0(int[] iArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    private static void Q0(Throwable th) throws Throwable {
        throw th;
    }

    public static Object j(Object obj) {
        return obj;
    }

    public static Object[] k(Object[] objArr) {
        return objArr;
    }
}
