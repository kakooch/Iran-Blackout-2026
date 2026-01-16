package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sdp.fields.SDPKeywords;
import android.gov.nist.javax.sip.ListeningPointExt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.ep1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C12561ep1 {
    public static final int b = 0;
    private static ArrayList d;
    public static final a a = new a(null);
    private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Zo1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C12561ep1.p();
        }
    });

    /* renamed from: ir.nasim.ep1$a */
    public static final class a {
        private a() {
        }

        public final C13197fp1 a(String str) {
            Object next;
            AbstractC13042fc3.i(str, "phoneCode");
            Iterator it = C12561ep1.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (AbstractC13042fc3.d(((C13197fp1) next).g(), str)) {
                    break;
                }
            }
            return (C13197fp1) next;
        }

        public final C12561ep1 b() {
            return (C12561ep1) C12561ep1.c.getValue();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        d = arrayList;
        arrayList.add(new C13197fp1("1", "US", AbstractC12217eE5.US, "🇺🇸", "آمریکا"));
        d.add(new C13197fp1("1", "CA", AbstractC12217eE5.CA, "🇨🇦", "کانادا"));
        d.add(new C13197fp1("1", "DO", AbstractC12217eE5.DO, "🇩🇴", "جمهوری دومینیکن"));
        d.add(new C13197fp1("1", "PR", AbstractC12217eE5.PR, "🇵🇷", "پورتوریکو"));
        d.add(new C13197fp1("7", "RU", AbstractC12217eE5.RU, "🇷🇺", "روسیه"));
        d.add(new C13197fp1("7", "KZ", AbstractC12217eE5.KZ, "🇰🇿", "قزاقستان"));
        d.add(new C13197fp1("20", "EG", AbstractC12217eE5.EG, "🇪🇬", "مصر"));
        d.add(new C13197fp1("27", "ZA", AbstractC12217eE5.ZA, "🇿🇦", "آفریقای جنوبی"));
        d.add(new C13197fp1("30", "GR", AbstractC12217eE5.GR, "🇬🇷", "یونان"));
        d.add(new C13197fp1("31", "NL", AbstractC12217eE5.NL, "🇳🇱", "هلند"));
        d.add(new C13197fp1("32", "BE", AbstractC12217eE5.BE, "🇧🇪", "بلژیک"));
        d.add(new C13197fp1("33", "FR", AbstractC12217eE5.FR, "🇫🇷", "فرانسه"));
        d.add(new C13197fp1("34", "ES", AbstractC12217eE5.ES, "🇪🇸", "اسپانیا"));
        d.add(new C13197fp1("36", "HU", AbstractC12217eE5.HU, "🇭🇺", "مجارستان"));
        d.add(new C13197fp1("39", "IT", AbstractC12217eE5.IT, "🇮🇹", "ایتالیا"));
        d.add(new C13197fp1("40", "RO", AbstractC12217eE5.RO, "🇷🇴", "رومانی"));
        d.add(new C13197fp1("41", "CH", AbstractC12217eE5.CH, "🇨🇭", "سوئیس"));
        d.add(new C13197fp1("42", "YL", AbstractC12217eE5.YL, "🇾🇱", "یمن"));
        d.add(new C13197fp1("43", "AT", AbstractC12217eE5.AT, "🇦🇹", "اتریش"));
        d.add(new C13197fp1("44", "GB", AbstractC12217eE5.GB, "🇬🇧", "انگلستان"));
        d.add(new C13197fp1("45", "DK", AbstractC12217eE5.DK, "🇩🇰", "دانمارک"));
        d.add(new C13197fp1("46", "SE", AbstractC12217eE5.SE, "🇸🇪", "سوئد"));
        d.add(new C13197fp1("47", "NO", AbstractC12217eE5.NO, "🇳🇴", "نروژ"));
        d.add(new C13197fp1("48", "PL", AbstractC12217eE5.PL, "🇵🇱", "لهستان"));
        d.add(new C13197fp1("49", "DE", AbstractC12217eE5.DE, "🇩🇪", "آلمان"));
        d.add(new C13197fp1("51", "PE", AbstractC12217eE5.PE, "🇵🇪", "پرو"));
        d.add(new C13197fp1("52", "MX", AbstractC12217eE5.MX, "🇲🇽", "مکزیک"));
        d.add(new C13197fp1("53", "CU", AbstractC12217eE5.CU, "🇨🇺", "کوبا"));
        d.add(new C13197fp1("54", "AR", AbstractC12217eE5.AR, "🇦🇷", "آرژانتین"));
        d.add(new C13197fp1("55", "BR", AbstractC12217eE5.BR, "🇧🇷", "برزیل"));
        d.add(new C13197fp1("56", "CL", AbstractC12217eE5.CL, "🇨🇱", "شیلی"));
        d.add(new C13197fp1("57", "CO", AbstractC12217eE5.CO, "🇨🇴", "کلمبیا"));
        d.add(new C13197fp1("58", "VE", AbstractC12217eE5.VE, "🇻🇪", "ونزوئلا"));
        d.add(new C13197fp1("60", "MY", AbstractC12217eE5.MY, "🇲🇾", "مالزی"));
        d.add(new C13197fp1("61", "AU", AbstractC12217eE5.AU, "🇦🇺", "استرالیا"));
        d.add(new C13197fp1("62", "ID", AbstractC12217eE5.ID, "🇮🇩", "اندونزی"));
        d.add(new C13197fp1("63", "PH", AbstractC12217eE5.PH, "🇵🇭", "فیلیپین"));
        d.add(new C13197fp1("64", "NZ", AbstractC12217eE5.NZ, "🇳🇿", "نیوزیلند"));
        d.add(new C13197fp1("65", "SG", AbstractC12217eE5.SG, "🇸🇬", "سنگاپور"));
        d.add(new C13197fp1("66", "TH", AbstractC12217eE5.TH, "🇹🇭", "تایلند"));
        d.add(new C13197fp1("81", "JP", AbstractC12217eE5.JP, "🇯🇵", "ژاپن"));
        d.add(new C13197fp1("82", "KR", AbstractC12217eE5.KR, "🇰🇷", "کره جنوبی"));
        d.add(new C13197fp1("84", "VN", AbstractC12217eE5.VN, "🇻🇳", "ویتنام"));
        d.add(new C13197fp1("86", "CN", AbstractC12217eE5.CN, "🇨🇳", "چین"));
        d.add(new C13197fp1("90", "TR", AbstractC12217eE5.TR, "🇹🇷", "ترکیه"));
        d.add(new C13197fp1("91", SDPKeywords.IN, AbstractC12217eE5.IN, "🇮🇳", "هند"));
        d.add(new C13197fp1("92", "PK", AbstractC12217eE5.PK, "🇵🇰", "پاکستان"));
        d.add(new C13197fp1("93", "AF", AbstractC12217eE5.AF, "🇦🇫", "افغانستان"));
        d.add(new C13197fp1("94", "LK", AbstractC12217eE5.LK, "🇱🇰", "سریلانکا"));
        d.add(new C13197fp1("95", "MM", AbstractC12217eE5.MM, "🇲🇲", "میانمار"));
        d.add(new C13197fp1("98", "IR", AbstractC12217eE5.IR, "🇮🇷", "ایران"));
        d.add(new C13197fp1("211", "SS", AbstractC12217eE5.SS, "🇸🇸", "سودان جنوبی"));
        d.add(new C13197fp1("212", "MA", AbstractC12217eE5.MA, "🇲🇦", "مراکش"));
        d.add(new C13197fp1("213", "DZ", AbstractC12217eE5.DZ, "🇩🇿", "الجزایر"));
        d.add(new C13197fp1("216", "TN", AbstractC12217eE5.TN, "🇹🇳", "تونس"));
        d.add(new C13197fp1("218", "LY", AbstractC12217eE5.LY, "🇱🇾", "لیبی"));
        d.add(new C13197fp1("220", "GM", AbstractC12217eE5.GM, "🇬🇲", "گامبیا"));
        d.add(new C13197fp1("221", "SN", AbstractC12217eE5.SN, "🇸🇳", "سنگال"));
        d.add(new C13197fp1("222", "MR", AbstractC12217eE5.MR, "🇲🇷", "موریتانی"));
        d.add(new C13197fp1("223", "ML", AbstractC12217eE5.ML, "🇲🇱", "مالی"));
        d.add(new C13197fp1("224", "GN", AbstractC12217eE5.GN, "🇬🇳", "گینه"));
        d.add(new C13197fp1("225", "CI", AbstractC12217eE5.CI, "🇨🇮", "ساحل عاج"));
        d.add(new C13197fp1("226", "BF", AbstractC12217eE5.BF, "🇧🇫", "بورکینافاسو"));
        d.add(new C13197fp1("227", "NE", AbstractC12217eE5.NE, "🇳🇪", "نیجر"));
        d.add(new C13197fp1("228", "TG", AbstractC12217eE5.TG, "🇹🇬", "توگو"));
        d.add(new C13197fp1("229", "BJ", AbstractC12217eE5.BJ, "🇧🇯", "بنین"));
        d.add(new C13197fp1("230", "MU", AbstractC12217eE5.MU, "🇲🇺", "موریس"));
        d.add(new C13197fp1("231", "LR", AbstractC12217eE5.LR, "🇱🇷", "لیبریا"));
        d.add(new C13197fp1("232", "SL", AbstractC12217eE5.SL, "🇸🇱", "سیرالئون"));
        d.add(new C13197fp1("233", "GH", AbstractC12217eE5.GH, "🇬🇭", "غنا"));
        d.add(new C13197fp1("234", "NG", AbstractC12217eE5.NG, "🇳🇬", "نیجریه"));
        d.add(new C13197fp1("235", "TD", AbstractC12217eE5.TD, "🇹🇩", "چاد"));
        d.add(new C13197fp1("236", "CF", AbstractC12217eE5.CF, "🇨🇫", "جمهوری آفریقای مرکزی"));
        d.add(new C13197fp1("237", "CM", AbstractC12217eE5.CM, "🇨🇲", "کامرون"));
        d.add(new C13197fp1("238", "CV", AbstractC12217eE5.CV, "🇨🇻", "کیپ ورد"));
        d.add(new C13197fp1("239", "ST", AbstractC12217eE5.ST, "🇸🇹", "سائوتومه و پرینسیپ"));
        d.add(new C13197fp1("240", "GQ", AbstractC12217eE5.GQ, "🇬🇶", "گینه استوایی"));
        d.add(new C13197fp1("241", "GA", AbstractC12217eE5.GA, "🇬🇦", "گابن"));
        d.add(new C13197fp1("242", "CG", AbstractC12217eE5.CG, "🇨🇬", "کنگو"));
        d.add(new C13197fp1("243", "CD", AbstractC12217eE5.CD, "🇨🇩", "کنگو دموکراتیک"));
        d.add(new C13197fp1("244", "AO", AbstractC12217eE5.AO, "🇦🇴", "آنگولا"));
        d.add(new C13197fp1("245", "GW", AbstractC12217eE5.GW, "🇬🇼", "گینه بیسائو"));
        d.add(new C13197fp1("246", "IO", AbstractC12217eE5.IO, "🇮🇴", "قلمرو بریتانیا"));
        d.add(new C13197fp1("247", "SH", AbstractC12217eE5.SH, "🇸🇭", "سنت هلنا"));
        d.add(new C13197fp1("248", "SC", AbstractC12217eE5.SC, "🇸🇨", "سیشل"));
        d.add(new C13197fp1("249", "SD", AbstractC12217eE5.SD, "🇸🇩", "سودان"));
        d.add(new C13197fp1("250", "RW", AbstractC12217eE5.RW, "🇷🇼", "رواندا"));
        d.add(new C13197fp1("251", "ET", AbstractC12217eE5.ET, "🇪🇹", "اتیوپی"));
        d.add(new C13197fp1("252", "SO", AbstractC12217eE5.SO, "🇸🇴", "سومالی"));
        d.add(new C13197fp1("253", "DJ", AbstractC12217eE5.DJ, "🇩🇯", "جیبوتی"));
        d.add(new C13197fp1("254", "KE", AbstractC12217eE5.KE, "🇰🇪", "کنیا"));
        d.add(new C13197fp1("255", "TZ", AbstractC12217eE5.TZ, "🇹🇿", "تانزانیا"));
        d.add(new C13197fp1("256", "UG", AbstractC12217eE5.UG, "🇺🇬", "اوگاندا"));
        d.add(new C13197fp1("257", "BI", AbstractC12217eE5.BI, "🇧🇮", "بوروندی"));
        d.add(new C13197fp1("258", "MZ", AbstractC12217eE5.MZ, "🇲🇿", "موزامبیک"));
        d.add(new C13197fp1("260", "ZM", AbstractC12217eE5.ZM, "🇿🇲", "زامبیا"));
        d.add(new C13197fp1("261", "MG", AbstractC12217eE5.MG, "🇲🇬", "ماداگاسکار"));
        d.add(new C13197fp1("262", "RE", AbstractC12217eE5.RE, "🇷🇪", "رئونیون"));
        d.add(new C13197fp1("263", "ZW", AbstractC12217eE5.ZW, "🇿🇼", "زیمبابوه"));
        d.add(new C13197fp1("264", "NA", AbstractC12217eE5.NA, "🇳🇦", "نامیبیا"));
        d.add(new C13197fp1("265", "MW", AbstractC12217eE5.MW, "🇲🇼", "مالاوی"));
        d.add(new C13197fp1("266", "LS", AbstractC12217eE5.LS, "🇱🇸", "لسوتو"));
        d.add(new C13197fp1("267", "BW", AbstractC12217eE5.BW, "🇧🇼", "بوتسوانا"));
        d.add(new C13197fp1("268", "SZ", AbstractC12217eE5.SZ, "🇸🇿", "اسواتینی"));
        d.add(new C13197fp1("269", "KM", AbstractC12217eE5.KM, "🇰🇲", "کومور"));
        d.add(new C13197fp1("290", "SH", AbstractC12217eE5.SH, "🇹🇦", "سنت هلنا"));
        d.add(new C13197fp1("291", "ER", AbstractC12217eE5.ER, "🇪🇷", "اریتره"));
        d.add(new C13197fp1("297", "AW", AbstractC12217eE5.AW, "🇦🇼", "آروبا"));
        d.add(new C13197fp1("298", "FO", AbstractC12217eE5.FO, "🇫🇴", "جزایر فارو"));
        d.add(new C13197fp1("299", "GL", AbstractC12217eE5.GL, "🇬🇱", "گرینلند"));
        d.add(new C13197fp1("350", "GI", AbstractC12217eE5.GI, "🇬🇮", "جبل الطارق"));
        d.add(new C13197fp1("351", "PT", AbstractC12217eE5.PT, "🇵🇹", "پرتغال"));
        d.add(new C13197fp1("352", "LU", AbstractC12217eE5.LU, "🇱🇺", "لوکزامبورگ"));
        d.add(new C13197fp1("353", "IE", AbstractC12217eE5.IE, "🇮🇪", "ایرلند"));
        d.add(new C13197fp1("354", "IS", AbstractC12217eE5.IS, "🇮🇸", "ایسلند"));
        d.add(new C13197fp1("355", "AL", AbstractC12217eE5.AL, "🇦🇱", "آلبانی"));
        d.add(new C13197fp1("356", "MT", AbstractC12217eE5.MT, "🇲🇹", "مالت"));
        d.add(new C13197fp1("357", "CY", AbstractC12217eE5.CY, "🇨🇾", "قبرس"));
        d.add(new C13197fp1("358", "FI", AbstractC12217eE5.FI, "🇫🇮", "فنلاند"));
        d.add(new C13197fp1("359", "BG", AbstractC12217eE5.BG, "🇧🇬", "بلغارستان"));
        d.add(new C13197fp1("370", "LT", AbstractC12217eE5.LT, "🇱🇹", "لیتوانی"));
        d.add(new C13197fp1("371", "LV", AbstractC12217eE5.LV, "🇱🇻", "لتونی"));
        d.add(new C13197fp1("372", "EE", AbstractC12217eE5.EE, "🇪🇪", "استونی"));
        d.add(new C13197fp1("373", "MD", AbstractC12217eE5.MD, "🇲🇩", "مولداوی"));
        d.add(new C13197fp1("374", "AM", AbstractC12217eE5.AM, "🇦🇲", "ارمنستان"));
        d.add(new C13197fp1("375", "BY", AbstractC12217eE5.BY, "🇧🇾", "بلاروس"));
        d.add(new C13197fp1("376", "AD", AbstractC12217eE5.AD, "🇦🇩", "آندورا"));
        d.add(new C13197fp1("377", "MC", AbstractC12217eE5.MC, "🇲🇨", "موناکو"));
        d.add(new C13197fp1("378", "SM", AbstractC12217eE5.SM, "🇸🇲", "سان مارینو"));
        d.add(new C13197fp1("380", "UA", AbstractC12217eE5.UA, "🇺🇦", "اوکراین"));
        d.add(new C13197fp1("381", "RS", AbstractC12217eE5.RS, "🇷🇸", "صربستان"));
        d.add(new C13197fp1("382", "ME", AbstractC12217eE5.ME, "🇲🇪", "مونته نگرو"));
        d.add(new C13197fp1("385", "HR", AbstractC12217eE5.HR, "🇭🇷", "کرواسی"));
        d.add(new C13197fp1("386", "SI", AbstractC12217eE5.SI, "🇸🇮", "اسلوونی"));
        d.add(new C13197fp1("387", "BA", AbstractC12217eE5.BA, "🇧🇦", "بوسنی و هرزگوین"));
        d.add(new C13197fp1("389", "MK", AbstractC12217eE5.MK, "🇲🇰", "مقدونیه شمالی"));
        d.add(new C13197fp1("420", "CZ", AbstractC12217eE5.CZ, "🇨🇿", "جمهوری چک"));
        d.add(new C13197fp1("421", "SK", AbstractC12217eE5.SK, "🇸🇰", "اسلواکی"));
        d.add(new C13197fp1("423", "LI", AbstractC12217eE5.LI, "🇱🇮", "لیختن اشتاین"));
        d.add(new C13197fp1("500", "FK", AbstractC12217eE5.FK, "🇫🇰", "جزایر فالکلند"));
        d.add(new C13197fp1("501", "BZ", AbstractC12217eE5.BZ, "🇧🇿", "بلیز"));
        d.add(new C13197fp1("502", "GT", AbstractC12217eE5.GT, "🇬🇹", "گواتمالا"));
        d.add(new C13197fp1("503", "SV", AbstractC12217eE5.SV, "🇸🇻", "السالوادور"));
        d.add(new C13197fp1("504", "HN", AbstractC12217eE5.HN, "🇭🇳", "هندوراس"));
        d.add(new C13197fp1("505", "NI", AbstractC12217eE5.NI, "🇳🇮", "نیکاراگوئه"));
        d.add(new C13197fp1("506", "CR", AbstractC12217eE5.CR, "🇨🇷", "کاستاریکا"));
        d.add(new C13197fp1("507", "PA", AbstractC12217eE5.PA, "🇵🇦", "پاناما"));
        d.add(new C13197fp1("508", "PM", AbstractC12217eE5.PM, "🇵🇲", "سن پیر و میکلون"));
        d.add(new C13197fp1("509", "HT", AbstractC12217eE5.HT, "🇭🇹", "هائیتی"));
        d.add(new C13197fp1("590", "GP", AbstractC12217eE5.GP, "🇧🇱", "گوادلوپ"));
        d.add(new C13197fp1("591", "BO", AbstractC12217eE5.BO, "🇧🇴", "بولیوی"));
        d.add(new C13197fp1("592", "GY", AbstractC12217eE5.GY, "🇬🇾", "گویان"));
        d.add(new C13197fp1("593", "EC", AbstractC12217eE5.EC, "🇪🇨", "اکوادور"));
        d.add(new C13197fp1("595", "PY", AbstractC12217eE5.PY, "🇵🇾", "پاراگوئه"));
        d.add(new C13197fp1("597", "SR", AbstractC12217eE5.SR, "🇸🇷", "سورینام"));
        d.add(new C13197fp1("598", "UY", AbstractC12217eE5.UY, "🇺🇾", "اروگوئه"));
        d.add(new C13197fp1("670", "TL", AbstractC12217eE5.TL, "🇹🇱", "تیمور شرقی"));
        d.add(new C13197fp1("672", "NF", AbstractC12217eE5.NF, "🇳🇫", "جزیره نورفولک"));
        d.add(new C13197fp1("673", "BN", AbstractC12217eE5.BN, "🇧🇳", "برونئی"));
        d.add(new C13197fp1("675", "PG", AbstractC12217eE5.PG, "🇵🇬", "پاپوآ گینه نو"));
        d.add(new C13197fp1("676", "TO", AbstractC12217eE5.TO, "🇹🇴", "تونگا"));
        d.add(new C13197fp1("677", "SB", AbstractC12217eE5.SB, "🇸🇧", "جزایر سلیمان"));
        d.add(new C13197fp1("678", "VU", AbstractC12217eE5.VU, "🇻🇺", "وانواتو"));
        d.add(new C13197fp1("679", "FJ", AbstractC12217eE5.FJ, "🇫🇯", "فیجی"));
        d.add(new C13197fp1("680", "PW", AbstractC12217eE5.PW, "🇵🇼", "پالائو"));
        d.add(new C13197fp1("681", "WF", AbstractC12217eE5.WF, "🇼🇫", "والیس و فوتونا"));
        d.add(new C13197fp1("682", "CK", AbstractC12217eE5.CK, "🇨🇰", "جزایر کوک"));
        d.add(new C13197fp1("683", "NU", AbstractC12217eE5.NU, "🇳🇺", "نیوئه"));
        d.add(new C13197fp1("685", ListeningPointExt.WS, AbstractC12217eE5.WS, "🇼🇸", "ساموآ"));
        d.add(new C13197fp1("686", "KI", AbstractC12217eE5.KI, "🇰🇮", "کیریباتی"));
        d.add(new C13197fp1("687", "NC", AbstractC12217eE5.NC, "🇳🇨", "کالدونیای جدید"));
        d.add(new C13197fp1("688", "TV", AbstractC12217eE5.TV, "🇹🇻", "تووالو"));
        d.add(new C13197fp1("690", "TK", AbstractC12217eE5.TK, "🇹🇰", "توکلائو"));
        d.add(new C13197fp1("691", "FM", AbstractC12217eE5.FM, "🇫🇲", "میکرونزی"));
        d.add(new C13197fp1("692", "MH", AbstractC12217eE5.MH, "🇲🇭", "جزایر مارشال"));
        d.add(new C13197fp1("850", "KP", AbstractC12217eE5.KP, "🇰🇵", "کره شمالی"));
        d.add(new C13197fp1("855", "KH", AbstractC12217eE5.KH, "🇰🇭", "کامبوج"));
        d.add(new C13197fp1("856", "LA", AbstractC12217eE5.LA, "🇱🇦", "لائوس"));
        d.add(new C13197fp1("880", "BD", AbstractC12217eE5.BD, "🇧🇩", "بنگلادش"));
        d.add(new C13197fp1("960", "MV", AbstractC12217eE5.MV, "🇲🇻", "مالدیو"));
        d.add(new C13197fp1("961", "LB", AbstractC12217eE5.LB, "🇱🇧", "لبنان"));
        d.add(new C13197fp1("962", "JO", AbstractC12217eE5.JO, "🇯🇴", "اردن"));
        d.add(new C13197fp1("963", "SY", AbstractC12217eE5.SY, "🇸🇾", "سوریه"));
        d.add(new C13197fp1("964", "IQ", AbstractC12217eE5.IQ, "🇮🇶", "عراق"));
        d.add(new C13197fp1("965", "KW", AbstractC12217eE5.KW, "🇰🇼", "کویت"));
        d.add(new C13197fp1("966", "SA", AbstractC12217eE5.SA, "🇸🇦", "عربستان سعودی"));
        d.add(new C13197fp1("967", "YE", AbstractC12217eE5.YE, "🇾🇪", "یمن"));
        d.add(new C13197fp1("968", "OM", AbstractC12217eE5.OM, "🇴🇲", "عمان"));
        d.add(new C13197fp1("970", "PS", AbstractC12217eE5.PS, "🇵🇸", "فلسطین"));
        d.add(new C13197fp1("971", "AE", AbstractC12217eE5.AE, "🇦🇪", "امارات متحده عربی"));
        d.add(new C13197fp1("973", "BH", AbstractC12217eE5.BH, "🇧🇭", "بحرین"));
        d.add(new C13197fp1("974", "QA", AbstractC12217eE5.QA, "🇶🇦", "قطر"));
        d.add(new C13197fp1("975", "BT", AbstractC12217eE5.BT, "🇧🇹", "بوتان"));
        d.add(new C13197fp1("976", "MN", AbstractC12217eE5.MN, "🇲🇳", "مغولستان"));
        d.add(new C13197fp1("977", "NP", AbstractC12217eE5.NP, "🇳🇵", "نپال"));
        d.add(new C13197fp1("992", "TJ", AbstractC12217eE5.TJ, "🇹🇯", "تاجیکستان"));
        d.add(new C13197fp1("993", "TM", AbstractC12217eE5.TM, "🇹🇲", "ترکمنستان"));
        d.add(new C13197fp1("994", "AZ", AbstractC12217eE5.AZ, "🇦🇿", "آذربایجان"));
        d.add(new C13197fp1("995", "GE", AbstractC12217eE5.GE, "🇬🇪", "گرجستان"));
        d.add(new C13197fp1("996", "KG", AbstractC12217eE5.KG, "🇰🇬", "قرقیزستان"));
        d.add(new C13197fp1("998", "UZ", AbstractC12217eE5.UZ, "🇺🇿", "ازبکستان"));
        d.add(new C13197fp1("1242", "BS", AbstractC12217eE5.BS, "🇧🇸", "باهاما"));
        d.add(new C13197fp1("1246", "BB", AbstractC12217eE5.BB, "🇧🇧", "باربادوس"));
        d.add(new C13197fp1("1264", "AI", AbstractC12217eE5.AI, "🇦🇮", "آنگویلا"));
        d.add(new C13197fp1("1268", "AG", AbstractC12217eE5.AG, "🇦🇬", "آنتیگوا و باربودا"));
        d.add(new C13197fp1("1284", "VG", AbstractC12217eE5.VG, "🇻🇬", "جزایر ویرجین بریتانیا"));
        d.add(new C13197fp1("1340", "VI", AbstractC12217eE5.VI, "🇻🇮", "جزایر ویرجین آمریکا"));
        d.add(new C13197fp1("1345", "KY", AbstractC12217eE5.KY, "🇰🇾", "جزایر کیمن"));
        d.add(new C13197fp1("1441", "BM", AbstractC12217eE5.BM, "🇧🇲", "برمودا"));
        d.add(new C13197fp1("1473", "GD", AbstractC12217eE5.GD, "🇬🇩", "گرنادا"));
        d.add(new C13197fp1("1649", "TC", AbstractC12217eE5.TC, "🇹🇨", "جزایر تورکس و کایکوس"));
        d.add(new C13197fp1("1664", "MS", AbstractC12217eE5.MS, "🇲🇸", "مونتسرات"));
        d.add(new C13197fp1("1670", "MP", AbstractC12217eE5.MP, "🇲🇵", "جزایر ماریانای شمالی"));
        d.add(new C13197fp1("1671", "GU", AbstractC12217eE5.GU, "🇬🇺", "گوام"));
        d.add(new C13197fp1("1684", "AS", AbstractC12217eE5.AS, "🇦🇸", "ساموآی آمریکا"));
        d.add(new C13197fp1("1721", "SX", AbstractC12217eE5.SX, "🇸🇽", "سنت مارتین"));
        d.add(new C13197fp1("1758", "LC", AbstractC12217eE5.LC, "🇱🇨", "سنت لوسیا"));
        d.add(new C13197fp1("1767", "DM", AbstractC12217eE5.DM, "🇩🇲", "دومینیکا"));
        d.add(new C13197fp1("1784", "VC", AbstractC12217eE5.VC, "🇻🇨", "سنت وینسنت و گرنادین"));
        d.add(new C13197fp1("1868", "TT", AbstractC12217eE5.TT, "🇹🇹", "ترینیداد و توباگو"));
        d.add(new C13197fp1("1869", "KN", AbstractC12217eE5.KN, "🇰🇳", "سنت کیتس و نویس"));
        d.add(new C13197fp1("1876", "JM", AbstractC12217eE5.JM, "🇯🇲", "جامائیکا"));
    }

    private final ArrayList i(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            C13197fp1 c13197fp1 = (C13197fp1) next;
            c13197fp1.i(XY6.e(c13197fp1.g()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(Context context, C13197fp1 c13197fp1, C13197fp1 c13197fp12) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(c13197fp1, "object1");
        AbstractC13042fc3.i(c13197fp12, "object2");
        String string = context.getString(c13197fp1.e());
        String string2 = context.getString(c13197fp12.e());
        AbstractC13042fc3.h(string2, "getString(...)");
        return string.compareTo(string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(Context context, C13197fp1 c13197fp1, C13197fp1 c13197fp12) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(c13197fp1, "object1");
        AbstractC13042fc3.i(c13197fp12, "object2");
        String string = context.getString(c13197fp1.e());
        String string2 = context.getString(c13197fp12.e());
        AbstractC13042fc3.h(string2, "getString(...)");
        return string.compareTo(string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C12561ep1 p() {
        return new C12561ep1();
    }

    public final C13197fp1 h(String str) {
        AbstractC13042fc3.i(str, "shortName");
        if (str.length() <= 0) {
            return null;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
        Iterator it = d.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            C13197fp1 c13197fp1 = (C13197fp1) next;
            if (AbstractC13042fc3.d(c13197fp1.h(), upperCase)) {
                return c13197fp1;
            }
        }
        return null;
    }

    public final ArrayList j(final Context context) {
        AbstractC13042fc3.i(context, "context");
        ArrayList arrayList = d;
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.ap1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(C12561ep1.k(context, (C13197fp1) obj, (C13197fp1) obj2));
            }
        };
        AbstractC12992fX0.B(arrayList, new Comparator() { // from class: ir.nasim.bp1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12561ep1.l(interfaceC14603iB2, obj, obj2);
            }
        });
        if (JF5.g()) {
            i(d);
        }
        return d;
    }

    public final List m(String str, final Context context) {
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(context, "context");
        ArrayList arrayList = d;
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.cp1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(C12561ep1.n(context, (C13197fp1) obj, (C13197fp1) obj2));
            }
        };
        AbstractC12992fX0.B(arrayList, new Comparator() { // from class: ir.nasim.dp1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C12561ep1.o(interfaceC14603iB2, obj, obj2);
            }
        });
        String lowerCase = str.toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        ArrayList arrayList2 = d;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            C13197fp1 c13197fp1 = (C13197fp1) obj;
            String string = context.getString(c13197fp1.e());
            AbstractC13042fc3.h(string, "getString(...)");
            Locale locale = Locale.ROOT;
            String lowerCase2 = string.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
            if (!AbstractC20762sZ6.X(lowerCase2, lowerCase, false, 2, null) && !AbstractC20153rZ6.S(lowerCase2, lowerCase, false, 2, null) && !AbstractC20153rZ6.C(lowerCase2, lowerCase, false, 2, null)) {
                String lowerCase3 = XY6.v(c13197fp1.g()).toLowerCase(locale);
                AbstractC13042fc3.h(lowerCase3, "toLowerCase(...)");
                if (!AbstractC20762sZ6.X(lowerCase3, XY6.v(lowerCase), false, 2, null)) {
                    String lowerCase4 = c13197fp1.h().toLowerCase(locale);
                    AbstractC13042fc3.h(lowerCase4, "toLowerCase(...)");
                    if (AbstractC20762sZ6.X(lowerCase4, lowerCase, false, 2, null)) {
                    }
                }
            }
            arrayList3.add(obj);
        }
        return arrayList3;
    }
}
