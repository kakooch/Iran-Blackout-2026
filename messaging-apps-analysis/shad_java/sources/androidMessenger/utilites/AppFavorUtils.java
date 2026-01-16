package androidMessenger.utilites;

import android.graphics.Color;
import com.google.android.gms.maps.model.LatLng;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes.dex */
public class AppFavorUtils {
    public static String appstoreUrl = null;
    public static String rubinoUrl = "https://shrubino2.iranlms.ir/";
    public static String shopUrl = "";
    public static String walletUrl = "";
    public static final ArrayList<String> rubinoUrlArray = new ArrayList<>(Arrays.asList("https://shrubino2.iranlms.ir/"));
    public static String iptvUrl = "https://shservices.iranlms.ir/";
    public static String commentUrl = "https://shcomments.iranlms.ir/";
    public static String webAppUrl = "https://shwebapp.iranlms.ir";
    public static String paymentUrl = "https://shpaymentc.iranlms.ir/";
    public static String barcodeUrl = "https://shbarcode.iranlms.ir/";
    public static String basketUrl = "https://shbasket.iranlms.ir/";
    public static String usageUrl = "https://shusage.iranlms.ir";
    public static String gameUrl = "https://shqgame.iranlms.ir";
    public static String GATEWAY_URL = "https://shservicesbase.iranlms.ir";
    public static final ArrayList<String> GATEWAY_URL_ARRAY = new ArrayList<>(Arrays.asList("https://shservicesbase.iranlms.ir"));
    public static String SERVICE_EXTERNAL_URL = "https://homesh1.iranlms.ir/";
    public static ArrayList<String> SERVICE_EXTERNAL_URL_Array = new ArrayList<>(Arrays.asList("https://homesh1.iranlms.ir"));
    public static final ArrayList<String> MESSENGER_URL_DEFAULT = new ArrayList<>(Arrays.asList("https://shadmessenger3.iranlms.ir", "https://shadmessenger4.iranlms.ir", "https://shadmessenger5.iranlms.ir", "https://shadmessenger6.iranlms.ir", "https://shadmessenger7.iranlms.ir", "https://shadmessenger8.iranlms.ir", "https://shadmessenger9.iranlms.ir", "https://shadmessenger10.iranlms.ir"));
    public static String GET_DC_MESS_URL = "https://shgetdcmess.iranlms.ir";
    public static final ArrayList<String> GET_DC_MESS_URL_ARRAY = new ArrayList<>(Arrays.asList("https://shgetdcmess.iranlms.ir"));
    public static String payUrlOld = "https://shmegapal.iranlms.ir/api2/v3.0/";
    public static String baseUrlOld = "https://shpanel.iranlms.ir";
    public static String newsUrlOld = "https://shkhabar.iranlms.ir/api/v1.0/";
    public static String jjUrl = "https://shprediction.iranlms.ir/api/v1.0/";
    public static String suggested_nquality = "https://shqc1.iranlms.ir/";
    public static final String DATA_BASE_NAME_MESSENGER = LocaleController.getString(R.string.DBName) + "Messenger";
    public static final String DATA_BASE_NAME_CACHE = LocaleController.getString(R.string.DBName) + "Cache";
    public static final String DATA_BASE_NAME_ID_STORAGE = LocaleController.getString(R.string.DBName) + "IdStorage";
    public static final String SHARED_PREF_NAME_APP = LocaleController.getString(R.string.DBName).toLowerCase(Locale.ROOT) + "Preferences";
    public static final LatLng defaultLocation = new LatLng(32.519195d, 54.392208d);
    public static int rubinoNameId = R.string.RubinoNameShad;
    public static String termsAndConditionsUrl = "https://shad.ir/rules";
    public static String policyUrl = "https://shad.ir/policy";
    public static int introCount = 5;

    public static String[] getIntroDescriptionArray() {
        return new String[]{"ارائه تمامی محتواها و خدمات رسمی آموزش و پروش برای دانش آموزان، مدیران و معلمان", "برگزاری آزمون آنلاین، مدیریت تکالیف، حضور و غیاب، ارائه نظرسنجی و ارسال متن، تصویر و ویدئوهای با کیفیت بالا در پیام رسان شاد و شبکه اجتماعی تخصصی برای مدیران و معلمان", "پخش زنده و ارتباط تعاملی دوسویه بین معلم و تمامی دانش آموزان کلاس، تماس ویدئویی و ارائه تمامی ابزارهای آنلاین مورد نیاز آموزش مجازی", "زیست بوم دیجیتال آموزش و پرورش ایران بر پایه مجهزترین زیرساخت فنی همراه اول", "دسترسی بی انتها به هر آنچه برای اهالی مدارس ایران لازم است"};
    }

    public static String[] getIntroTitleArray() {
        return new String[]{"رسمی و معتبر", "کامل ترین جعبه ابزار", "بالاترین سرعت و کیفیت", "شاد", "شادبوم"};
    }

    public static ArrayList<Integer> getColorArray() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(Color.parseColor("#f5f5f5")));
        arrayList.add(Integer.valueOf(Color.parseColor("#FFC875")));
        arrayList.add(Integer.valueOf(Color.parseColor("#B088BE")));
        arrayList.add(Integer.valueOf(Color.parseColor("#69E1B6")));
        arrayList.add(Integer.valueOf(Color.parseColor("#FFBA68")));
        return arrayList;
    }

    public static int[] getIntroImageResArray() {
        return new int[]{R.drawable.intro_page5, R.drawable.intro_page4, R.drawable.intro_page3, R.drawable.intro_page2, R.drawable.intro_page1};
    }
}
