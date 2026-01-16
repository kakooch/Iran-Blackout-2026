package ir.nasim;

import java.util.HashMap;
import livekit.org.webrtc.WebrtcBuildVersion;
import okhttp3.internal.ws.RealWebSocket;

/* renamed from: ir.nasim.r80, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19902r80 {
    private static HashMap a;
    private static HashMap b;
    private static String[] c = {"0098", "098", "98"};

    /* renamed from: ir.nasim.r80$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC8374Vr6.values().length];
            b = iArr;
            try {
                iArr[EnumC8374Vr6.MCI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EnumC8374Vr6.IRANCELL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EnumC8374Vr6.RIGHTEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[EnumC8374Vr6.UNSUPPORTED_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[EnumC15124j30.values().length];
            a = iArr2;
            try {
                iArr2[EnumC15124j30.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumC15124j30.SAVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[EnumC15124j30.SHORT_TERM.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[EnumC15124j30.LONG_TERM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* renamed from: ir.nasim.r80$b */
    public enum b {
        MCI,
        MTN,
        RIGhTEL,
        TALIA,
        UNKNOWN
    }

    static {
        HashMap map = new HashMap();
        a = map;
        b bVar = b.MCI;
        map.put("091", bVar);
        a.put("0990", bVar);
        HashMap map2 = a;
        b bVar2 = b.MTN;
        map2.put("0930", bVar2);
        a.put("0933", bVar2);
        a.put("0935", bVar2);
        a.put("0936", bVar2);
        a.put("0937", bVar2);
        a.put("0938", bVar2);
        a.put("0939", bVar2);
        a.put("0901", bVar2);
        a.put("0902", bVar2);
        a.put("0903", bVar2);
        a.put("0905", bVar2);
        HashMap map3 = a;
        b bVar3 = b.RIGhTEL;
        map3.put("0920", bVar3);
        a.put("0921", bVar3);
        a.put("0922", bVar3);
        HashMap map4 = a;
        b bVar4 = b.TALIA;
        map4.put("0932", bVar4);
        HashMap map5 = new HashMap();
        b = map5;
        map5.put(bVar, "0919");
        b.put(bVar2, "0935");
        b.put(bVar3, "0920");
        b.put(bVar4, "0932");
    }

    public static Boolean a() {
        return Boolean.valueOf(C7183Qq.q(EnumC18608ow5.g).e("ir.nasim.shaparak_public_key") != null);
    }

    public static EnumC15124j30 b(String str) {
        return str.length() != 13 ? EnumC15124j30.INVALID : str.startsWith("01") ? EnumC15124j30.CURRENT : str.startsWith("02") ? EnumC15124j30.SHORT_TERM : str.startsWith(WebrtcBuildVersion.webrtc_commit) ? EnumC15124j30.SAVING : str.startsWith("04") ? EnumC15124j30.LONG_TERM : str.startsWith("07") ? EnumC15124j30.GOVERNMENT : (str.startsWith("211") || str.startsWith("217")) ? EnumC15124j30.GOVERNMENT_SHARE : str.startsWith("4") ? EnumC15124j30.SCHOOL : str.startsWith("61") ? EnumC15124j30.LOAN_BENEVOLENT : str.startsWith("62") ? EnumC15124j30.LOAN_JUALAH : str.startsWith("63") ? EnumC15124j30.LOAN_INSTALLMENT_SALES : str.startsWith("64") ? EnumC15124j30.LOAN_HIRE_PURCHASE : str.startsWith("65") ? EnumC15124j30.LOAN_MUDARABAH : str.startsWith("66") ? EnumC15124j30.LOAN_MUSHARAKAH : EnumC15124j30.INVALID;
    }

    public static String c(EnumC15124j30 enumC15124j30) {
        int i = a.a[enumC15124j30.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "بانک ملی" : "بلند مدت" : "کوتاه مدت" : "قرض\u200cالحسنه" : "جاری";
    }

    public static Y50 d(String str) {
        String strH = XY6.h(XY6.q(str));
        return strH.length() == 16 ? e(strH.substring(0, 6)) : Y50.d;
    }

    public static Y50 e(String str) {
        String strH = XY6.h(XY6.q(str));
        return strH.equals("603799") ? Y50.e : strH.equals("589210") ? Y50.f : (strH.equals("627648") || strH.equals("207177")) ? Y50.g : strH.equals("627961") ? Y50.h : (strH.equals("603770") || strH.equals("639217")) ? Y50.i : strH.equals("628023") ? Y50.j : strH.equals("627760") ? Y50.k : strH.equals("502908") ? Y50.l : strH.equals("627412") ? Y50.m : (strH.equals("622106") || strH.equals("639194") || strH.equals("627884")) ? Y50.n : (strH.equals("639347") || strH.equals("502229")) ? Y50.o : (strH.equals("627488") || strH.equals("502910")) ? Y50.p : strH.equals("621986") ? Y50.q : strH.equals("639346") ? Y50.r : strH.equals("639607") ? Y50.s : strH.equals("636214") ? Y50.t : (strH.equals("502806") || strH.equals("504706")) ? Y50.u : strH.equals("502938") ? Y50.v : strH.equals("603769") ? Y50.w : (strH.equals("610433") || strH.equals("991975")) ? Y50.x : (strH.equals("585983") || strH.equals("627353")) ? Y50.y : strH.equals("589463") ? Y50.z : strH.equals("504172") ? Y50.A : strH.equals("639599") ? Y50.B : strH.equals("627381") ? Y50.D : strH.equals("636949") ? Y50.G : strH.equals("505416") ? Y50.H : strH.equals("639370") ? Y50.J : strH.equals("628157") ? Y50.Y : strH.equals("505785") ? Y50.Z : strH.equals("606373") ? Y50.z0 : strH.equals("636795") ? Y50.A0 : strH.equals("505801") ? Y50.B0 : strH.equals("507677") ? Y50.C0 : strH.equals("606256") ? Y50.D0 : strH.equals("585947") ? Y50.E0 : Y50.d;
    }

    public static String f(Long l) {
        return l.longValue() == -1 ? "یکی از موارد مبلغ، شماره سفارش یا کلید درخواست اشتباه است." : l.longValue() == 0 ? "تراکنش با موفقیت به انجام رسید." : l.longValue() == 1 ? "لطفا با بانک صادر کننده کارت، تماس حاصل فرمائيد." : l.longValue() == 2 ? "قبلا تراکنش به حساب شما بازگشت داده شده است." : l.longValue() == 3 ? "پذيرنده کارت  فعال نيست. لطفا با بانک صادر کننده کارت، تماس حاصل فرمائيد." : l.longValue() == 14 ? "شماره کارت معتبر نيست." : l.longValue() == 25 ? "رکورد پيدا نشد." : l.longValue() == 33 ? "کارت شما منقضي شده است. لطفا جهت دریافت کارت جديد به شعبه مراجعه فرمائيد." : l.longValue() == 34 ? "يا رمز دوم اشتباه است. CVV2" : l.longValue() == 41 ? "کارت اعلام مفقودی شده است. لطفا به شعبه خود، مراجعه فرمائيد." : l.longValue() == 43 ? "کارت اعلام سرقت شده است. لطفا به شعبه خود، مراجعه فرمائيد." : l.longValue() == 44 ? "اطلاعات قبض صحیح نیست." : l.longValue() == 45 ? "بدهي نداريد." : l.longValue() == 48 ? "قبض شما قبلا پرداخت شده است." : l.longValue() == 51 ? "مبلغ درخواستی از موجودی حساب شما، بیشتر است. حداقل مانده حساب شما پس از عملیات پرداخت باید 100,000 ریال باشد." : l.longValue() == 55 ? "رمز کارت صحيح نمي\u200cباشد. لطفا مجددا، سعي فرمائيد." : l.longValue() == 56 ? "رمز دوم یا CVV2 صحیح نمی باشد." : l.longValue() == 57 ? "دارنده کارت مجاز به انجام اين تراکنش نمي\u200cباشد." : l.longValue() == 58 ? "پذيرنده کارت مجاز به انجام اين تراکنش نمي\u200cباشد." : l.longValue() == 61 ? "مبلغ تراکنش از حد مجاز بالاتر است." : l.longValue() == 65 ? "تعداد دفعات تراکنش از حد مجاز بيشتر است." : l.longValue() == 74 ? "شماره کارت مبدا و مقصد یکسان است." : l.longValue() == 75 ? "ورود رمز دوم کارت از حد مجاز گذشته است. لطفا با مراجعه به خودپرداز مجددا رمز دوم دريافت فرمائيد." : l.longValue() == 77 ? "Invalid Business Date Time." : l.longValue() == 79 ? "شماره حساب نامعتبر است. لطفا به شعبه مراجعه فرمائيد." : l.longValue() == 80 ? "تراکنش موفق عمل نکرده است." : l.longValue() == 84 ? "سويچ صادر کننده کارت فعال نمي\u200cباشد، لطفا چند دقيقه ديگر مجددا سعي بفرمائيد." : l.longValue() == 88 ? "سيستم از مرکز داراي اشکال است." : l.longValue() == 90 ? "ارتباط با مرکز موقتا قطع مي\u200cباشد." : l.longValue() == 91 ? "پاسخ در زمان تعيين شده به سيستم نرسيده است. لطفا چند دقيقه ديگر مجددا سعي بفرمائيد." : l.longValue() == 93 ? "مرکز مشغول است. لطفا چند دقيقه ديگر مجددا سعي بفرمائيد." : l.longValue() == 99 ? "پاسخ خطا." : l.longValue() == 1000 ? "ترتيب پارامترهاي ارسالي اشتباه مي\u200cباشد، لطفا مشکل را از طریق منوی گزارش و بازخورد گزارش کنید." : l.longValue() == 1001 ? "پارامترهاي پرداخت اشتباه مي\u200cباشد. لطفا مشکل را از طریق منوی گزارش و بازخورد گزارش کنید." : l.longValue() == 1002 ? "خطا در سيستم تراکنش ناموفق." : l.longValue() == 1003 ? "IP  .پذيرنده اشتباه است. لطفا مشکل را از طریق منوی گزارش و بازخورد گزارش کنید." : l.longValue() == 1004 ? "شماره پذيرنده اشتباه است. لطفا مشکل را از طریق منوی گزارش و بازخورد گزارش کنید." : l.longValue() == 1005 ? "خطاي دسترسي! لطفا مشکل را از طریق منوی گزارش و بازخورد گزارش کنید." : l.longValue() == 1006 ? "خطا در سيستم!" : l.longValue() == 1007 ? "شماره پيگيري موجود نيست." : l.longValue() == 1008 ? "شماره پيگيري يکتا نيست." : l.longValue() == 1009 ? "شماره مرجع موجود نيست." : l.longValue() == 1010 ? "شماره مرجع يکتا نيست." : l.longValue() == 1011 ? "درخواست تکراري شماره سفارش تکراري مي\u200cباشد." : l.longValue() == 1012 ? "اطلاعات پذيرنده صحيح نيست، يکي از موارد تاريخ، زمان يا کليد تراکنش اشتباه است. لطفا مشکل را از طریق منوی گزارش و بازخورد گزارش کنید." : l.longValue() == 1013 ? "وضعيت پذيرنده صحيح نيست." : l.longValue() == 1014 ? "تراکنش به حساب مبدا برگشت داده شده است." : l.longValue() == 1015 ? "پاسخ خطا از سمت مرکز." : l.longValue() == 1016 ? "پرداخت با کارتهای شتاب غیر فعال شده است." : l.longValue() == 1017 ? "مبلغ درخواستي شما جهت پرداخت از حد مجاز تعريف شده براي اين پذيرنده بيشتر است." : l.longValue() == 1018 ? "اشکال در تاريخ و زمان سيستم. لطفا تاريخ و زمان سرور خود را با بانک هماهنگ نماييد." : l.longValue() == 1019 ? "امکان پرداخت از طريق سيستم شتاب براي اين پذيرنده امکان پذير نيست." : l.longValue() == 1020 ? "پذيرنده غيرفعال شده است. لطفا مشکل را از طریق منوی گزارش و بازخورد گزارش کنید." : l.longValue() == 1022 ? "آدرس ورودي جهت پرداخت با آدرس بازگشت پذيرنده مطابقت ندارد." : l.longValue() == 1023 ? "آدرس بازگشت پذيرنده نامعتبر است." : l.longValue() == RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE ? "مهر زماني پذيرنده نامعتبر است." : l.longValue() == 1025 ? "امضا تراکنش نامعتبر است." : l.longValue() == 1026 ? "شماره سفارش تراکنش نامعتبر است." : l.longValue() == 1027 ? "شماره پذيرنده نامعتبر است." : l.longValue() == 1028 ? "شماره ترمينال پذيرنده نامعتبر است." : l.longValue() == 1029 ? "آدرس IP پرداخت در محدوده آدرس های معتبر اعلام شده توسط پذیرنده نیست. لطفا مسئول فني پذيرنده با بانک تماس حاصل فرمايند." : l.longValue() == 1030 ? "آدرس Domain پرداخت در محدوده آدرس\u200cهای معتبر اعلام شده توسط پذیرنده نیست. لطفا مسئول فني پذيرنده با بانک تماس حاصل فرمايند." : l.longValue() == 1050 ? "خطا در ارتباط با مرکز. لطفا بعدا سعي بفرمائيد." : (l.longValue() == 1051 || l.longValue() == 1052) ? "وضعيت غير مجاز براي عمليات پرداخت!" : l.longValue() == 1053 ? "خطا) درخواست معتبر، از سمت پذيرنده صورت نگرفته است لطفا اطلاعات پذيرنده خود را چک کنيد." : l.longValue() == 1054 ? "بازيابي session براي پيام اشکال دارد." : l.longValue() == 1055 ? "مقدار غيرمجاز در ورود اطلاعات!" : l.longValue() == 1056 ? "سيستم موقتا قطع مي\u200cباشد.لطفا بعدا تلاش فرماييد." : l.longValue() == 1058 ? "سرويس پرداخت اينترنتي خارج از سرويس مي\u200cباشد.لطفا بعدا سعي بفرماييد." : l.longValue() == 1061 ? "اشکال در توليد کد يکتا. لطفا مرورگر خود را بسته و با اجراي مجدد مرورگر عمليات پرداخت را انجام دهيد." : l.longValue() == 1064 ? "لطفا مجددا سعي بفرماييد." : l.longValue() == 1065 ? "ارتباط ناموفق. لطفا چند لحظه ديگر مجددا سعي کنيد." : l.longValue() == 1066 ? "سیستم سرویس\u200cدهی پرداخت موقتا غیر فعال شده است." : l.longValue() == 1090 ? "درخواست پذيرنده از کانال امن (SSL) صورت نگرفته است." : l.longValue() == 1091 ? "درخواست پذيرنده از طريق متد POST صورت نگرفته است." : l.longValue() == 9005 ? "(تراکنش ناموفق) مبلغ به حساب دارنده کارت برگشت داده شده است." : l.longValue() == 9006 ? "تراکنش ناتمام (در صورت کسر موجودي مبلغ به حساب دارنده کارت برگشت داده مي شود)." : l.longValue() == 10211 ? "محدوديت در تعداد تراکنش\u200cهاي روزانه" : l.longValue() == 10212 ? "محدوديت در مقدار تراکنش\u200cهاي روزانه" : "خطای نامشخص!!";
    }

    public static b g(String str) {
        return str.equals("0919") ? b.MCI : str.equals("0935") ? b.MTN : str.equals("0920") ? b.RIGhTEL : str.equals("0932") ? b.TALIA : b.UNKNOWN;
    }

    public static String h() {
        String strE = C7183Qq.q(EnumC18608ow5.g).e("ir.nasim.shaparak_public_key");
        if (strE == null) {
            return null;
        }
        return C16358l82.a.a(strE);
    }

    public static void i(String str) {
        C7183Qq.q(EnumC18608ow5.g).putString("ir.nasim.shaparak_public_key", C16358l82.a.d(str));
    }
}
