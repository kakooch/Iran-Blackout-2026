package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Build;
import android.util.Pair;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.ws.WebSocketProtocol;
import org.xbill.DNS.TTL;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.kd2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C16051kd2 {
    static final String[] c = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    private static final C22074ud2[] d;
    private static final C22074ud2[] e;
    private static final C22074ud2[] f;
    static final C22074ud2[] g;
    private static final C22074ud2[] h;
    static final C22074ud2[][] i;
    static final HashSet j;
    private final List a;
    private final ByteOrder b;

    /* renamed from: ir.nasim.kd2$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PB0.values().length];
            a = iArr;
            try {
                iArr[PB0.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PB0.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PB0.FIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: ir.nasim.kd2$b */
    public static final class b {
        private static final Pattern c = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        private static final Pattern d = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        private static final Pattern e = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        static final List f = Collections.list(new a());
        final List a = Collections.list(new C1354b());
        private final ByteOrder b;

        /* renamed from: ir.nasim.kd2$b$a */
        class a implements Enumeration {
            int a = 0;

            a() {
            }

            @Override // java.util.Enumeration
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap nextElement() {
                HashMap map = new HashMap();
                for (C22074ud2 c22074ud2 : C16051kd2.i[this.a]) {
                    map.put(c22074ud2.b, c22074ud2);
                }
                this.a++;
                return map;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.a < C16051kd2.i.length;
            }
        }

        /* renamed from: ir.nasim.kd2$b$b, reason: collision with other inner class name */
        class C1354b implements Enumeration {
            int a = 0;

            C1354b() {
            }

            @Override // java.util.Enumeration
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map nextElement() {
                this.a++;
                return new HashMap();
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.a < C16051kd2.i.length;
            }
        }

        /* renamed from: ir.nasim.kd2$b$c */
        class c implements Enumeration {
            final Enumeration a;

            c() {
                this.a = Collections.enumeration(b.this.a);
            }

            @Override // java.util.Enumeration
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map nextElement() {
                return new HashMap((Map) this.a.nextElement());
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.a.hasMoreElements();
            }
        }

        b(ByteOrder byteOrder) {
            this.b = byteOrder;
        }

        private static Pair b(String str) throws NumberFormatException {
            if (str.contains(",")) {
                String[] strArrSplit = str.split(",", -1);
                Pair pairB = b(strArrSplit[0]);
                if (((Integer) pairB.first).intValue() == 2) {
                    return pairB;
                }
                for (int i = 1; i < strArrSplit.length; i++) {
                    Pair pairB2 = b(strArrSplit[i]);
                    int iIntValue = (((Integer) pairB2.first).equals(pairB.first) || ((Integer) pairB2.second).equals(pairB.first)) ? ((Integer) pairB.first).intValue() : -1;
                    int iIntValue2 = (((Integer) pairB.second).intValue() == -1 || !(((Integer) pairB2.first).equals(pairB.second) || ((Integer) pairB2.second).equals(pairB.second))) ? -1 : ((Integer) pairB.second).intValue();
                    if (iIntValue == -1 && iIntValue2 == -1) {
                        return new Pair(2, -1);
                    }
                    if (iIntValue == -1) {
                        pairB = new Pair(Integer.valueOf(iIntValue2), -1);
                    } else if (iIntValue2 == -1) {
                        pairB = new Pair(Integer.valueOf(iIntValue), -1);
                    }
                }
                return pairB;
            }
            if (!str.contains(Separators.SLASH)) {
                try {
                    try {
                        long j = Long.parseLong(str);
                        return (j < 0 || j > WebSocketProtocol.PAYLOAD_SHORT_MAX) ? j < 0 ? new Pair(9, -1) : new Pair(4, -1) : new Pair(3, 4);
                    } catch (NumberFormatException unused) {
                        return new Pair(2, -1);
                    }
                } catch (NumberFormatException unused2) {
                    Double.parseDouble(str);
                    return new Pair(12, -1);
                }
            }
            String[] strArrSplit2 = str.split(Separators.SLASH, -1);
            if (strArrSplit2.length == 2) {
                try {
                    long j2 = (long) Double.parseDouble(strArrSplit2[0]);
                    long j3 = (long) Double.parseDouble(strArrSplit2[1]);
                    if (j2 >= 0 && j3 >= 0) {
                        if (j2 <= TTL.MAX_VALUE && j3 <= TTL.MAX_VALUE) {
                            return new Pair(10, 5);
                        }
                        return new Pair(5, -1);
                    }
                    return new Pair(10, -1);
                } catch (NumberFormatException unused3) {
                }
            }
            return new Pair(2, -1);
        }

        private void d(String str, String str2, List list) throws NumberFormatException {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((Map) it.next()).containsKey(str)) {
                    return;
                }
            }
            e(str, str2, list);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private void e(String str, String str2, List list) throws NumberFormatException {
            int i;
            int i2;
            int i3;
            b bVar = this;
            String str3 = str;
            String strReplaceAll = str2;
            if (("DateTime".equals(str3) || "DateTimeOriginal".equals(str3) || "DateTimeDigitized".equals(str3)) && strReplaceAll != null) {
                boolean zFind = d.matcher(strReplaceAll).find();
                boolean zFind2 = e.matcher(strReplaceAll).find();
                if (str2.length() != 19 || (!zFind && !zFind2)) {
                    PI3.l("ExifData", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                if (zFind2) {
                    strReplaceAll = strReplaceAll.replaceAll("-", ":");
                }
            }
            if ("ISOSpeedRatings".equals(str3)) {
                str3 = "PhotographicSensitivity";
            }
            String str4 = str3;
            int i4 = 2;
            int i5 = 1;
            if (strReplaceAll != null && C16051kd2.j.contains(str4)) {
                if (str4.equals("GPSTimeStamp")) {
                    Matcher matcher = c.matcher(strReplaceAll);
                    if (!matcher.find()) {
                        PI3.l("ExifData", "Invalid value for " + str4 + " : " + strReplaceAll);
                        return;
                    }
                    strReplaceAll = Integer.parseInt((String) AbstractC4980Hj5.g(matcher.group(1))) + "/1," + Integer.parseInt((String) AbstractC4980Hj5.g(matcher.group(2))) + "/1," + Integer.parseInt((String) AbstractC4980Hj5.g(matcher.group(3))) + "/1";
                } else {
                    try {
                        strReplaceAll = new C18233oJ3(Double.parseDouble(strReplaceAll)).toString();
                    } catch (NumberFormatException e2) {
                        PI3.m("ExifData", "Invalid value for " + str4 + " : " + strReplaceAll, e2);
                        return;
                    }
                }
            }
            int i6 = 0;
            int i7 = 0;
            while (i7 < C16051kd2.i.length) {
                C22074ud2 c22074ud2 = (C22074ud2) ((HashMap) f.get(i7)).get(str4);
                if (c22074ud2 == null) {
                    i = i7;
                    i2 = i5;
                } else {
                    if (strReplaceAll != null) {
                        Pair pairB = b(strReplaceAll);
                        if (c22074ud2.c == ((Integer) pairB.first).intValue() || c22074ud2.c == ((Integer) pairB.second).intValue()) {
                            i3 = c22074ud2.c;
                        } else {
                            int i8 = c22074ud2.d;
                            if (i8 == -1 || !(i8 == ((Integer) pairB.first).intValue() || c22074ud2.d == ((Integer) pairB.second).intValue())) {
                                i3 = c22074ud2.c;
                                if (i3 == i5 || i3 == 7 || i3 == i4) {
                                }
                            } else {
                                i3 = c22074ud2.d;
                            }
                        }
                        String str5 = Separators.SLASH;
                        switch (i3) {
                            case 1:
                                i = i7;
                                i2 = i5;
                                ((Map) list.get(i)).put(str4, C15460jd2.a(strReplaceAll));
                                break;
                            case 2:
                            case 7:
                                i = i7;
                                i2 = i5;
                                ((Map) list.get(i)).put(str4, C15460jd2.e(strReplaceAll));
                                break;
                            case 3:
                                i = i7;
                                i2 = i5;
                                String[] strArrSplit = strReplaceAll.split(",", -1);
                                int[] iArr = new int[strArrSplit.length];
                                for (int i9 = 0; i9 < strArrSplit.length; i9++) {
                                    iArr[i9] = Integer.parseInt(strArrSplit[i9]);
                                }
                                ((Map) list.get(i)).put(str4, C15460jd2.i(iArr, bVar.b));
                                break;
                            case 4:
                                i = i7;
                                i2 = i5;
                                String[] strArrSplit2 = strReplaceAll.split(",", -1);
                                long[] jArr = new long[strArrSplit2.length];
                                for (int i10 = 0; i10 < strArrSplit2.length; i10++) {
                                    jArr[i10] = Long.parseLong(strArrSplit2[i10]);
                                }
                                ((Map) list.get(i)).put(str4, C15460jd2.g(jArr, bVar.b));
                                break;
                            case 5:
                                String str6 = Separators.SLASH;
                                String[] strArrSplit3 = strReplaceAll.split(",", -1);
                                C18233oJ3[] c18233oJ3Arr = new C18233oJ3[strArrSplit3.length];
                                int i11 = i6;
                                while (i11 < strArrSplit3.length) {
                                    String str7 = str6;
                                    String[] strArrSplit4 = strArrSplit3[i11].split(str7, -1);
                                    c18233oJ3Arr[i11] = new C18233oJ3((long) Double.parseDouble(strArrSplit4[i6]), (long) Double.parseDouble(strArrSplit4[1]));
                                    i11++;
                                    str6 = str7;
                                    i7 = i7;
                                    i6 = 0;
                                }
                                i = i7;
                                i2 = 1;
                                ((Map) list.get(i)).put(str4, C15460jd2.h(c18233oJ3Arr, bVar.b));
                                break;
                            case 9:
                                String[] strArrSplit5 = strReplaceAll.split(",", -1);
                                int[] iArr2 = new int[strArrSplit5.length];
                                for (int i12 = i6; i12 < strArrSplit5.length; i12++) {
                                    iArr2[i12] = Integer.parseInt(strArrSplit5[i12]);
                                }
                                ((Map) list.get(i7)).put(str4, C15460jd2.c(iArr2, bVar.b));
                                i = i7;
                                i2 = 1;
                                break;
                            case 10:
                                String[] strArrSplit6 = strReplaceAll.split(",", -1);
                                C18233oJ3[] c18233oJ3Arr2 = new C18233oJ3[strArrSplit6.length];
                                int i13 = i6;
                                while (i13 < strArrSplit6.length) {
                                    String[] strArrSplit7 = strArrSplit6[i13].split(str5, -1);
                                    c18233oJ3Arr2[i13] = new C18233oJ3((long) Double.parseDouble(strArrSplit7[i6]), (long) Double.parseDouble(strArrSplit7[i5]));
                                    i13++;
                                    str5 = str5;
                                    i5 = 1;
                                }
                                bVar = this;
                                ((Map) list.get(i7)).put(str4, C15460jd2.d(c18233oJ3Arr2, bVar.b));
                                i = i7;
                                i2 = 1;
                                break;
                            case 12:
                                String[] strArrSplit8 = strReplaceAll.split(",", -1);
                                double[] dArr = new double[strArrSplit8.length];
                                for (int i14 = i6; i14 < strArrSplit8.length; i14++) {
                                    dArr[i14] = Double.parseDouble(strArrSplit8[i14]);
                                }
                                ((Map) list.get(i7)).put(str4, C15460jd2.b(dArr, bVar.b));
                                break;
                        }
                    } else {
                        ((Map) list.get(i7)).remove(str4);
                    }
                    i = i7;
                    i2 = i5;
                }
                i7 = i + 1;
                i5 = i2;
                i4 = 2;
                i6 = 0;
            }
        }

        public C16051kd2 a() throws NumberFormatException {
            ArrayList list = Collections.list(new c());
            if (!((Map) list.get(1)).isEmpty()) {
                d("ExposureProgram", String.valueOf(0), list);
                d("ExifVersion", "0230", list);
                d("ComponentsConfiguration", "1,2,3,0", list);
                d("MeteringMode", String.valueOf(0), list);
                d("LightSource", String.valueOf(0), list);
                d("FlashpixVersion", "0100", list);
                d("FocalPlaneResolutionUnit", String.valueOf(2), list);
                d("FileSource", String.valueOf(3), list);
                d("SceneType", String.valueOf(1), list);
                d("CustomRendered", String.valueOf(0), list);
                d("SceneCaptureType", String.valueOf(0), list);
                d("Contrast", String.valueOf(0), list);
                d("Saturation", String.valueOf(0), list);
                d("Sharpness", String.valueOf(0), list);
            }
            if (!((Map) list.get(2)).isEmpty()) {
                d("GPSVersionID", "2300", list);
                d("GPSSpeedRef", TokenNames.K, list);
                d("GPSTrackRef", TokenNames.T, list);
                d("GPSImgDirectionRef", TokenNames.T, list);
                d("GPSDestBearingRef", TokenNames.T, list);
                d("GPSDestDistanceRef", TokenNames.K, list);
            }
            return new C16051kd2(this.b, list);
        }

        public b c(String str, String str2) throws NumberFormatException {
            e(str, str2, this.a);
            return this;
        }

        public b f(long j) {
            return c("ExposureTime", String.valueOf(j / TimeUnit.SECONDS.toNanos(1L)));
        }

        public b g(PB0 pb0) {
            int i;
            if (pb0 == PB0.UNKNOWN) {
                return this;
            }
            int i2 = a.a[pb0.ordinal()];
            if (i2 == 1) {
                i = 0;
            } else if (i2 == 2) {
                i = 32;
            } else {
                if (i2 != 3) {
                    PI3.l("ExifData", "Unknown flash state: " + pb0);
                    return this;
                }
                i = 1;
            }
            if ((i & 1) == 1) {
                c("LightSource", String.valueOf(4));
            }
            return c("Flash", String.valueOf(i));
        }

        public b h(float f2) {
            return c("FocalLength", new C18233oJ3((long) (f2 * 1000.0f), 1000L).toString());
        }

        public b i(int i) {
            return c("ImageLength", String.valueOf(i));
        }

        public b j(int i) {
            return c("ImageWidth", String.valueOf(i));
        }

        public b k(int i) {
            return c("SensitivityType", String.valueOf(3)).c("PhotographicSensitivity", String.valueOf(Math.min(65535, i)));
        }

        public b l(float f2) {
            return c("FNumber", String.valueOf(f2));
        }

        public b m(int i) {
            int i2;
            if (i == 0) {
                i2 = 1;
            } else if (i == 90) {
                i2 = 6;
            } else if (i == 180) {
                i2 = 3;
            } else if (i != 270) {
                PI3.l("ExifData", "Unexpected orientation value: " + i + ". Must be one of 0, 90, 180, 270.");
                i2 = 0;
            } else {
                i2 = 8;
            }
            return c("Orientation", String.valueOf(i2));
        }

        public b n(c cVar) {
            int iOrdinal = cVar.ordinal();
            return c("WhiteBalance", iOrdinal != 0 ? iOrdinal != 1 ? null : String.valueOf(1) : String.valueOf(0));
        }
    }

    /* renamed from: ir.nasim.kd2$c */
    public enum c {
        AUTO,
        MANUAL
    }

    static {
        C22074ud2[] c22074ud2Arr = {new C22074ud2("ImageWidth", 256, 3, 4), new C22074ud2("ImageLength", Type.CAA, 3, 4), new C22074ud2("Make", 271, 2), new C22074ud2("Model", 272, 2), new C22074ud2("Orientation", 274, 3), new C22074ud2("XResolution", 282, 5), new C22074ud2("YResolution", 283, 5), new C22074ud2("ResolutionUnit", 296, 3), new C22074ud2("Software", 305, 2), new C22074ud2("DateTime", 306, 2), new C22074ud2("YCbCrPositioning", 531, 3), new C22074ud2("SubIFDPointer", 330, 4), new C22074ud2("ExifIFDPointer", 34665, 4), new C22074ud2("GPSInfoIFDPointer", 34853, 4)};
        d = c22074ud2Arr;
        C22074ud2[] c22074ud2Arr2 = {new C22074ud2("ExposureTime", 33434, 5), new C22074ud2("FNumber", 33437, 5), new C22074ud2("ExposureProgram", 34850, 3), new C22074ud2("PhotographicSensitivity", 34855, 3), new C22074ud2("SensitivityType", 34864, 3), new C22074ud2("ExifVersion", 36864, 2), new C22074ud2("DateTimeOriginal", 36867, 2), new C22074ud2("DateTimeDigitized", 36868, 2), new C22074ud2("ComponentsConfiguration", 37121, 7), new C22074ud2("ShutterSpeedValue", 37377, 10), new C22074ud2("ApertureValue", 37378, 5), new C22074ud2("BrightnessValue", 37379, 10), new C22074ud2("ExposureBiasValue", 37380, 10), new C22074ud2("MaxApertureValue", 37381, 5), new C22074ud2("MeteringMode", 37383, 3), new C22074ud2("LightSource", 37384, 3), new C22074ud2("Flash", 37385, 3), new C22074ud2("FocalLength", 37386, 5), new C22074ud2("SubSecTime", 37520, 2), new C22074ud2("SubSecTimeOriginal", 37521, 2), new C22074ud2("SubSecTimeDigitized", 37522, 2), new C22074ud2("FlashpixVersion", 40960, 7), new C22074ud2("ColorSpace", 40961, 3), new C22074ud2("PixelXDimension", 40962, 3, 4), new C22074ud2("PixelYDimension", 40963, 3, 4), new C22074ud2("InteroperabilityIFDPointer", 40965, 4), new C22074ud2("FocalPlaneResolutionUnit", 41488, 3), new C22074ud2("SensingMethod", 41495, 3), new C22074ud2("FileSource", 41728, 7), new C22074ud2("SceneType", 41729, 7), new C22074ud2("CustomRendered", 41985, 3), new C22074ud2("ExposureMode", 41986, 3), new C22074ud2("WhiteBalance", 41987, 3), new C22074ud2("SceneCaptureType", 41990, 3), new C22074ud2("Contrast", 41992, 3), new C22074ud2("Saturation", 41993, 3), new C22074ud2("Sharpness", 41994, 3)};
        e = c22074ud2Arr2;
        C22074ud2[] c22074ud2Arr3 = {new C22074ud2("GPSVersionID", 0, 1), new C22074ud2("GPSLatitudeRef", 1, 2), new C22074ud2("GPSLatitude", 2, 5, 10), new C22074ud2("GPSLongitudeRef", 3, 2), new C22074ud2("GPSLongitude", 4, 5, 10), new C22074ud2("GPSAltitudeRef", 5, 1), new C22074ud2("GPSAltitude", 6, 5), new C22074ud2("GPSTimeStamp", 7, 5), new C22074ud2("GPSSpeedRef", 12, 2), new C22074ud2("GPSTrackRef", 14, 2), new C22074ud2("GPSImgDirectionRef", 16, 2), new C22074ud2("GPSDestBearingRef", 23, 2), new C22074ud2("GPSDestDistanceRef", 25, 2)};
        f = c22074ud2Arr3;
        g = new C22074ud2[]{new C22074ud2("SubIFDPointer", 330, 4), new C22074ud2("ExifIFDPointer", 34665, 4), new C22074ud2("GPSInfoIFDPointer", 34853, 4), new C22074ud2("InteroperabilityIFDPointer", 40965, 4)};
        C22074ud2[] c22074ud2Arr4 = {new C22074ud2("InteroperabilityIndex", 1, 2)};
        h = c22074ud2Arr4;
        i = new C22074ud2[][]{c22074ud2Arr, c22074ud2Arr2, c22074ud2Arr3, c22074ud2Arr4};
        j = new HashSet(Arrays.asList("FNumber", "ExposureTime", "GPSTimeStamp"));
    }

    C16051kd2(ByteOrder byteOrder, List list) {
        AbstractC4980Hj5.j(list.size() == i.length, "Malformed attributes list. Number of IFDs mismatch.");
        this.b = byteOrder;
        this.a = list;
    }

    public static b a() {
        return new b(ByteOrder.BIG_ENDIAN).c("Orientation", String.valueOf(1)).c("XResolution", "72/1").c("YResolution", "72/1").c("ResolutionUnit", String.valueOf(2)).c("YCbCrPositioning", String.valueOf(1)).c("Make", Build.MANUFACTURER).c("Model", Build.MODEL);
    }

    public static C16051kd2 b(androidx.camera.core.f fVar, int i2) {
        b bVarA = a();
        if (fVar.u1() != null) {
            fVar.u1().a(bVarA);
        }
        bVarA.m(i2);
        return bVarA.j(fVar.getWidth()).i(fVar.getHeight()).a();
    }

    Map c(int i2) {
        AbstractC4980Hj5.c(i2, 0, i.length, "Invalid IFD index: " + i2 + ". Index should be between [0, EXIF_TAGS.length] ");
        return (Map) this.a.get(i2);
    }

    public ByteOrder d() {
        return this.b;
    }
}
