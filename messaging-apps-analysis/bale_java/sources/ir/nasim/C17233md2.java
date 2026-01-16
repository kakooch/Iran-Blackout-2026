package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.AssetManager;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ims.AuthorizationHeaderIms;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import ir.nasim.AbstractC19006pd2;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import okhttp3.internal.ws.WebSocketProtocol;
import org.xbill.DNS.TTL;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.md2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17233md2 {
    private static SimpleDateFormat T;
    private static SimpleDateFormat U;
    private static final d[] Y;
    private static final d[] Z;
    private static final d[] a0;
    private static final d[] b0;
    private static final d[] c0;
    private static final d d0;
    private static final d[] e0;
    private static final d[] f0;
    private static final d[] g0;
    private static final d[] h0;
    static final d[][] i0;
    private static final d[] j0;
    private static final HashMap[] k0;
    private static final HashMap[] l0;
    private static final HashSet m0;
    private static final HashMap n0;
    static final Charset o0;
    static final byte[] p0;
    private static final byte[] q0;
    private static final Pattern r0;
    private static final Pattern s0;
    private static final Pattern t0;
    private static final Pattern u0;
    private String a;
    private FileDescriptor b;
    private AssetManager.AssetInputStream c;
    private int d;
    private boolean e;
    private final HashMap[] f;
    private Set g;
    private ByteOrder h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private byte[] n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private static final boolean u = Log.isLoggable("ExifInterface", 3);
    private static final List v = Arrays.asList(1, 6, 3, 8);
    private static final List w = Arrays.asList(2, 7, 4, 5);
    public static final int[] x = {8, 8, 8};
    public static final int[] y = {4};
    public static final int[] z = {8};
    static final byte[] A = {-1, -40, -1};
    private static final byte[] B = {102, 116, 121, 112};
    private static final byte[] C = {109, 105, 102, 49};
    private static final byte[] D = {104, 101, 105, 99};
    private static final byte[] E = {79, 76, 89, 77, 80, 0};
    private static final byte[] F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] G = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] H = {101, 88, 73, 102};
    private static final byte[] I = {73, 72, 68, 82};
    private static final byte[] J = {73, 69, 78, 68};
    private static final byte[] K = {82, 73, 70, 70};
    private static final byte[] L = {87, 69, 66, 80};
    private static final byte[] M = {69, 88, 73, 70};
    private static final byte[] N = {-99, 1, 42};
    private static final byte[] O = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] P = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] R = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANMF".getBytes(Charset.defaultCharset());
    static final String[] V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] X = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: ir.nasim.md2$c */
    private static class c {
        public final int a;
        public final int b;
        public final long c;
        public final byte[] d;

        c(int i, int i2, byte[] bArr) {
            this(i, i2, -1L, bArr);
        }

        public static c a(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new c(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(C17233md2.o0);
            return new c(1, bytes.length, bytes);
        }

        public static c b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C17233md2.W[12] * dArr.length]);
            byteBufferWrap.order(byteOrder);
            for (double d : dArr) {
                byteBufferWrap.putDouble(d);
            }
            return new c(12, dArr.length, byteBufferWrap.array());
        }

        public static c c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C17233md2.W[9] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putInt(i);
            }
            return new c(9, iArr.length, byteBufferWrap.array());
        }

        public static c d(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C17233md2.W[10] * eVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (e eVar : eVarArr) {
                byteBufferWrap.putInt((int) eVar.a);
                byteBufferWrap.putInt((int) eVar.b);
            }
            return new c(10, eVarArr.length, byteBufferWrap.array());
        }

        public static c e(String str) {
            byte[] bytes = (str + (char) 0).getBytes(C17233md2.o0);
            return new c(2, bytes.length, bytes);
        }

        public static c f(long j, ByteOrder byteOrder) {
            return g(new long[]{j}, byteOrder);
        }

        public static c g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C17233md2.W[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j : jArr) {
                byteBufferWrap.putInt((int) j);
            }
            return new c(4, jArr.length, byteBufferWrap.array());
        }

        public static c h(e eVar, ByteOrder byteOrder) {
            return i(new e[]{eVar}, byteOrder);
        }

        public static c i(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C17233md2.W[5] * eVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (e eVar : eVarArr) {
                byteBufferWrap.putInt((int) eVar.a);
                byteBufferWrap.putInt((int) eVar.b);
            }
            return new c(5, eVarArr.length, byteBufferWrap.array());
        }

        public static c j(int i, ByteOrder byteOrder) {
            return k(new int[]{i}, byteOrder);
        }

        public static c k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[C17233md2.W[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putShort((short) i);
            }
            return new c(3, iArr.length, byteBufferWrap.array());
        }

        public double l(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objO instanceof String) {
                return Double.parseDouble((String) objO);
            }
            if (objO instanceof long[]) {
                if (((long[]) objO).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objO instanceof int[]) {
                if (((int[]) objO).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objO instanceof double[]) {
                double[] dArr = (double[]) objO;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objO instanceof e[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            e[] eVarArr = (e[]) objO;
            if (eVarArr.length == 1) {
                return eVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int m(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objO instanceof String) {
                return Integer.parseInt((String) objO);
            }
            if (objO instanceof long[]) {
                long[] jArr = (long[]) objO;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objO instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objO;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String n(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                return null;
            }
            if (objO instanceof String) {
                return (String) objO;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (objO instanceof long[]) {
                long[] jArr = (long[]) objO;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objO instanceof int[]) {
                int[] iArr = (int[]) objO;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objO instanceof double[]) {
                double[] dArr = (double[]) objO;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objO instanceof e[])) {
                return null;
            }
            e[] eVarArr = (e[]) objO;
            while (i < eVarArr.length) {
                sb.append(eVarArr[i].a);
                sb.append('/');
                sb.append(eVarArr[i].b);
                i++;
                if (i != eVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:49), block:B:17:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:162:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        java.lang.Object o(java.nio.ByteOrder r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 436
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17233md2.c.o(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return Separators.LPAREN + C17233md2.V[this.a] + ", data length:" + this.d.length + Separators.RPAREN;
        }

        c(int i, int i2, long j, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = bArr;
        }
    }

    /* renamed from: ir.nasim.md2$e */
    private static class e {
        public final long a;
        public final long b;

        e(double d) {
            this((long) (d * 10000.0d), 10000L);
        }

        public double a() {
            return this.a / this.b;
        }

        public String toString() {
            return this.a + Separators.SLASH + this.b;
        }

        e(long j, long j2) {
            if (j2 == 0) {
                this.a = 0L;
                this.b = 1L;
            } else {
                this.a = j;
                this.b = j2;
            }
        }
    }

    static {
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", Type.CAA, 3, 4), new d("BitsPerSample", Type.AVC, 3), new d("Compression", Type.DOA, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1)};
        Y = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        Z = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        a0 = dVarArr3;
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        b0 = dVarArr4;
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", Type.CAA, 3, 4), new d("BitsPerSample", Type.AVC, 3), new d("Compression", Type.DOA, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        c0 = dVarArr5;
        d0 = new d("StripOffsets", 273, 3);
        d[] dVarArr6 = {new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        e0 = dVarArr6;
        d[] dVarArr7 = {new d("PreviewImageStart", Type.CAA, 4), new d("PreviewImageLength", Type.AVC, 4)};
        f0 = dVarArr7;
        d[] dVarArr8 = {new d("AspectFrame", 4371, 3)};
        g0 = dVarArr8;
        d[] dVarArr9 = {new d("ColorSpace", 55, 3)};
        h0 = dVarArr9;
        d[][] dVarArr10 = {dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, dVarArr6, dVarArr7, dVarArr8, dVarArr9};
        i0 = dVarArr10;
        j0 = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        k0 = new HashMap[dVarArr10.length];
        l0 = new HashMap[dVarArr10.length];
        m0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        n0 = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        o0 = charsetForName;
        p0 = "Exif\u0000\u0000".getBytes(charsetForName);
        q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        T = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            d[][] dVarArr11 = i0;
            if (i >= dVarArr11.length) {
                HashMap map = n0;
                d[] dVarArr12 = j0;
                map.put(Integer.valueOf(dVarArr12[0].a), 5);
                map.put(Integer.valueOf(dVarArr12[1].a), 1);
                map.put(Integer.valueOf(dVarArr12[2].a), 2);
                map.put(Integer.valueOf(dVarArr12[3].a), 3);
                map.put(Integer.valueOf(dVarArr12[4].a), 7);
                map.put(Integer.valueOf(dVarArr12[5].a), 8);
                r0 = Pattern.compile(".*[1-9].*");
                s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            k0[i] = new HashMap();
            l0[i] = new HashMap();
            for (d dVar : dVarArr11[i]) {
                k0[i].put(Integer.valueOf(dVar.a), dVar);
                l0[i].put(dVar.b, dVar);
            }
            i++;
        }
    }

    public C17233md2(File file) throws Throwable {
        d[][] dVarArr = i0;
        this.f = new HashMap[dVarArr.length];
        this.g = new HashSet(dVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        if (file == null) {
            throw new NullPointerException("file cannot be null");
        }
        w(file.getAbsolutePath());
    }

    private static boolean A(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = A;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean B(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderM = M(bVar2);
                this.h = byteOrderM;
                bVar2.d(byteOrderM);
                short s = bVar2.readShort();
                boolean z2 = s == 20306 || s == 21330;
                bVar2.close();
                return z2;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean C(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = G;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean D(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean E(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderM = M(bVar2);
                this.h = byteOrderM;
                bVar2.d(byteOrderM);
                boolean z2 = bVar2.readShort() == 85;
                bVar2.close();
                return z2;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean F(FileDescriptor fileDescriptor) {
        try {
            AbstractC19006pd2.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!u) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    private boolean G(HashMap map) {
        c cVar;
        int iM;
        c cVar2 = (c) map.get("BitsPerSample");
        if (cVar2 != null) {
            int[] iArr = (int[]) cVar2.o(this.h);
            int[] iArr2 = x;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.d == 3 && (cVar = (c) map.get("PhotometricInterpretation")) != null && (((iM = cVar.m(this.h)) == 1 && Arrays.equals(iArr, z)) || (iM == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!u) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    private boolean H(HashMap map) {
        c cVar = (c) map.get("ImageLength");
        c cVar2 = (c) map.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.m(this.h) <= 512 && cVar2.m(this.h) <= 512;
    }

    private boolean I(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = K;
            if (i >= bArr2.length) {
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = L;
                    if (i2 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[K.length + i2 + 4] != bArr3[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:13:0x001e, B:15:0x0022, B:16:0x0030, B:18:0x0038, B:20:0x0041, B:31:0x0061, B:21:0x0045, B:23:0x004b, B:26:0x0052, B:29:0x005a, B:30:0x005e, B:32:0x006b, B:34:0x0075, B:37:0x007d, B:40:0x0085, B:43:0x008d, B:47:0x009b, B:49:0x009f), top: B:60:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void J(java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto Lb8
            r0 = 0
            r1 = r0
        L4:
            ir.nasim.md2$d[][] r2 = ir.nasim.C17233md2.i0     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r2 = r2.length     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 >= r2) goto L1e
            java.util.HashMap[] r2 = r4.f     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r3.<init>()     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2[r1] = r3     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r1 = r1 + 1
            goto L4
        L15:
            r5 = move-exception
            goto Lad
        L18:
            r5 = move-exception
            goto L9b
        L1b:
            r5 = move-exception
            goto L9b
        L1e:
            boolean r1 = r4.e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 != 0) goto L30
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.k(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.d = r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r5 = r1
        L30:
            int r1 = r4.d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r1 = T(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r1 == 0) goto L6b
            ir.nasim.md2$f r0 = new ir.nasim.md2$f     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            boolean r5 = r4.e     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            if (r5 == 0) goto L45
            r4.r(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L45:
            int r5 = r4.d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1 = 12
            if (r5 != r1) goto L4f
            r4.h(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L4f:
            r1 = 7
            if (r5 != r1) goto L56
            r4.l(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L56:
            r1 = 10
            if (r5 != r1) goto L5e
            r4.q(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L61
        L5e:
            r4.o(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L61:
            int r5 = r4.p     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            long r1 = (long) r5     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r0.g(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r4.S(r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L6b:
            ir.nasim.md2$b r1 = new ir.nasim.md2$b     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            int r5 = r4.d     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            r2 = 4
            if (r5 != r2) goto L79
            r4.i(r1, r0, r0)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L79:
            r0 = 13
            if (r5 != r0) goto L81
            r4.m(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L81:
            r0 = 9
            if (r5 != r0) goto L89
            r4.n(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
            goto L90
        L89:
            r0 = 14
            if (r5 != r0) goto L90
            r4.s(r1)     // Catch: java.lang.Throwable -> L15 java.lang.UnsupportedOperationException -> L18 java.io.IOException -> L1b
        L90:
            r4.a()
            boolean r5 = ir.nasim.C17233md2.u
            if (r5 == 0) goto Lac
        L97:
            r4.L()
            goto Lac
        L9b:
            boolean r0 = ir.nasim.C17233md2.u     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto La6
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r5)     // Catch: java.lang.Throwable -> L15
        La6:
            r4.a()
            if (r0 == 0) goto Lac
            goto L97
        Lac:
            return
        Lad:
            r4.a()
            boolean r0 = ir.nasim.C17233md2.u
            if (r0 == 0) goto Lb7
            r4.L()
        Lb7:
            throw r5
        Lb8:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17233md2.J(java.io.InputStream):void");
    }

    private void K(b bVar) throws IOException {
        ByteOrder byteOrderM = M(bVar);
        this.h = byteOrderM;
        bVar.d(byteOrderM);
        int unsignedShort = bVar.readUnsignedShort();
        int i = this.d;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i2 = bVar.readInt();
        if (i2 < 8) {
            throw new IOException("Invalid first Ifd offset: " + i2);
        }
        int i3 = i2 - 8;
        if (i3 > 0) {
            bVar.e(i3);
        }
    }

    private void L() {
        for (int i = 0; i < this.f.length; i++) {
            Log.d("ExifInterface", "The size of tag group[" + i + "]: " + this.f[i].size());
            for (Map.Entry entry : this.f[i].entrySet()) {
                c cVar = (c) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + cVar.toString() + ", tagValue: '" + cVar.n(this.h) + Separators.QUOTE);
            }
        }
    }

    private ByteOrder M(b bVar) throws IOException {
        short s = bVar.readShort();
        if (s == 18761) {
            if (u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s == 19789) {
            if (u) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s));
    }

    private void N(byte[] bArr, int i) throws IOException {
        f fVar = new f(bArr);
        K(fVar);
        O(fVar, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0280  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void O(ir.nasim.C17233md2.f r26, int r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 956
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17233md2.O(ir.nasim.md2$f, int):void");
    }

    private void P(int i, String str, String str2) {
        if (this.f[i].isEmpty() || this.f[i].get(str) == null) {
            return;
        }
        HashMap map = this.f[i];
        map.put(str2, map.get(str));
        this.f[i].remove(str);
    }

    private void Q(f fVar, int i) throws Throwable {
        c cVar = (c) this.f[i].get("ImageLength");
        c cVar2 = (c) this.f[i].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = (c) this.f[i].get("JPEGInterchangeFormat");
            c cVar4 = (c) this.f[i].get("JPEGInterchangeFormatLength");
            if (cVar3 == null || cVar4 == null) {
                return;
            }
            int iM = cVar3.m(this.h);
            int iM2 = cVar3.m(this.h);
            fVar.g(iM);
            byte[] bArr = new byte[iM2];
            fVar.readFully(bArr);
            i(new b(bArr), iM, i);
        }
    }

    private void S(b bVar) throws Throwable {
        HashMap map = this.f[4];
        c cVar = (c) map.get("Compression");
        if (cVar == null) {
            this.o = 6;
            u(bVar, map);
            return;
        }
        int iM = cVar.m(this.h);
        this.o = iM;
        if (iM != 1) {
            if (iM == 6) {
                u(bVar, map);
                return;
            } else if (iM != 7) {
                return;
            }
        }
        if (G(map)) {
            v(bVar, map);
        }
    }

    private static boolean T(int i) {
        return (i == 4 || i == 9 || i == 13 || i == 14) ? false : true;
    }

    private void U(int i, int i2) throws Throwable {
        if (this.f[i].isEmpty() || this.f[i2].isEmpty()) {
            if (u) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        c cVar = (c) this.f[i].get("ImageLength");
        c cVar2 = (c) this.f[i].get("ImageWidth");
        c cVar3 = (c) this.f[i2].get("ImageLength");
        c cVar4 = (c) this.f[i2].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            if (u) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (cVar3 == null || cVar4 == null) {
            if (u) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iM = cVar.m(this.h);
        int iM2 = cVar2.m(this.h);
        int iM3 = cVar3.m(this.h);
        int iM4 = cVar4.m(this.h);
        if (iM >= iM3 || iM2 >= iM4) {
            return;
        }
        HashMap[] mapArr = this.f;
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    private void V(f fVar, int i) throws Throwable {
        c cVarJ;
        c cVarJ2;
        c cVar = (c) this.f[i].get("DefaultCropSize");
        c cVar2 = (c) this.f[i].get("SensorTopBorder");
        c cVar3 = (c) this.f[i].get("SensorLeftBorder");
        c cVar4 = (c) this.f[i].get("SensorBottomBorder");
        c cVar5 = (c) this.f[i].get("SensorRightBorder");
        if (cVar == null) {
            if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
                Q(fVar, i);
                return;
            }
            int iM = cVar2.m(this.h);
            int iM2 = cVar4.m(this.h);
            int iM3 = cVar5.m(this.h);
            int iM4 = cVar3.m(this.h);
            if (iM2 <= iM || iM3 <= iM4) {
                return;
            }
            c cVarJ3 = c.j(iM2 - iM, this.h);
            c cVarJ4 = c.j(iM3 - iM4, this.h);
            this.f[i].put("ImageLength", cVarJ3);
            this.f[i].put("ImageWidth", cVarJ4);
            return;
        }
        if (cVar.a == 5) {
            e[] eVarArr = (e[]) cVar.o(this.h);
            if (eVarArr == null || eVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(eVarArr));
                return;
            }
            cVarJ = c.h(eVarArr[0], this.h);
            cVarJ2 = c.h(eVarArr[1], this.h);
        } else {
            int[] iArr = (int[]) cVar.o(this.h);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            cVarJ = c.j(iArr[0], this.h);
            cVarJ2 = c.j(iArr[1], this.h);
        }
        this.f[i].put("ImageWidth", cVarJ);
        this.f[i].put("ImageLength", cVarJ2);
    }

    private void W() throws Throwable {
        U(0, 5);
        U(0, 4);
        U(5, 4);
        c cVar = (c) this.f[1].get("PixelXDimension");
        c cVar2 = (c) this.f[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            this.f[0].put("ImageWidth", cVar);
            this.f[0].put("ImageLength", cVar2);
        }
        if (this.f[4].isEmpty() && H(this.f[5])) {
            HashMap[] mapArr = this.f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!H(this.f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        P(0, "ThumbnailOrientation", "Orientation");
        P(0, "ThumbnailImageLength", "ImageLength");
        P(0, "ThumbnailImageWidth", "ImageWidth");
        P(5, "ThumbnailOrientation", "Orientation");
        P(5, "ThumbnailImageLength", "ImageLength");
        P(5, "ThumbnailImageWidth", "ImageWidth");
        P(4, "Orientation", "ThumbnailOrientation");
        P(4, "ImageLength", "ThumbnailImageLength");
        P(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private void a() {
        String strD = d("DateTimeOriginal");
        if (strD != null && d("DateTime") == null) {
            this.f[0].put("DateTime", c.e(strD));
        }
        if (d("ImageWidth") == null) {
            this.f[0].put("ImageWidth", c.f(0L, this.h));
        }
        if (d("ImageLength") == null) {
            this.f[0].put("ImageLength", c.f(0L, this.h));
        }
        if (d("Orientation") == null) {
            this.f[0].put("Orientation", c.f(0L, this.h));
        }
        if (d("LightSource") == null) {
            this.f[1].put("LightSource", c.f(0L, this.h));
        }
    }

    private static double b(String str, String str2) {
        try {
            String[] strArrSplit = str.split(",", -1);
            String[] strArrSplit2 = strArrSplit[0].split(Separators.SLASH, -1);
            double d2 = Double.parseDouble(strArrSplit2[0].trim()) / Double.parseDouble(strArrSplit2[1].trim());
            String[] strArrSplit3 = strArrSplit[1].split(Separators.SLASH, -1);
            double d3 = Double.parseDouble(strArrSplit3[0].trim()) / Double.parseDouble(strArrSplit3[1].trim());
            String[] strArrSplit4 = strArrSplit[2].split(Separators.SLASH, -1);
            double d4 = d2 + (d3 / 60.0d) + ((Double.parseDouble(strArrSplit4[0].trim()) / Double.parseDouble(strArrSplit4[1].trim())) / 3600.0d);
            if (!str2.equals(TokenNames.S) && !str2.equals("W")) {
                if (!str2.equals("N") && !str2.equals(TokenNames.E)) {
                    throw new IllegalArgumentException();
                }
                return d4;
            }
            return -d4;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private c g(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (u) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < i0.length; i++) {
            c cVar = (c) this.f[i].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    private void h(f fVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                AbstractC19006pd2.b.a(mediaMetadataRetriever, new a(fVar));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if (AuthorizationHeaderIms.YES.equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if (AuthorizationHeaderIms.YES.equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                if (strExtractMetadata != null) {
                    this.f[0].put("ImageWidth", c.j(Integer.parseInt(strExtractMetadata), this.h));
                }
                if (strExtractMetadata2 != null) {
                    this.f[0].put("ImageLength", c.j(Integer.parseInt(strExtractMetadata2), this.h));
                }
                if (strExtractMetadata3 != null) {
                    int i = Integer.parseInt(strExtractMetadata3);
                    this.f[0].put("Orientation", c.j(i != 90 ? i != 180 ? i != 270 ? 1 : 8 : 3 : 6, this.h));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i2 = Integer.parseInt(strExtractMetadata4);
                    int i3 = Integer.parseInt(strExtractMetadata5);
                    if (i3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.g(i2);
                    byte[] bArr = new byte[6];
                    fVar.readFully(bArr);
                    int i4 = i2 + 6;
                    int i5 = i3 - 6;
                    if (!Arrays.equals(bArr, p0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i5];
                    fVar.readFully(bArr2);
                    this.p = i4;
                    N(bArr2, 0);
                }
                if (u) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0186, code lost:
    
        r22.d(r21.h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x018b, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0170 A[LOOP:0: B:10:0x0037->B:59:0x0170, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0177 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i(ir.nasim.C17233md2.b r22, int r23, int r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17233md2.i(ir.nasim.md2$b, int, int):void");
    }

    private int k(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (A(bArr)) {
            return 4;
        }
        if (D(bArr)) {
            return 9;
        }
        if (z(bArr)) {
            return 12;
        }
        if (B(bArr)) {
            return 7;
        }
        if (E(bArr)) {
            return 10;
        }
        if (C(bArr)) {
            return 13;
        }
        return I(bArr) ? 14 : 0;
    }

    private void l(f fVar) throws Throwable {
        int i;
        int i2;
        o(fVar);
        c cVar = (c) this.f[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.d);
            fVar2.d(this.h);
            byte[] bArr = E;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.g(0L);
            byte[] bArr3 = F;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.g(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.g(12L);
            }
            O(fVar2, 6);
            c cVar2 = (c) this.f[7].get("PreviewImageStart");
            c cVar3 = (c) this.f[7].get("PreviewImageLength");
            if (cVar2 != null && cVar3 != null) {
                this.f[5].put("JPEGInterchangeFormat", cVar2);
                this.f[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = (c) this.f[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.o(this.h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                c cVarJ = c.j(i5, this.h);
                c cVarJ2 = c.j(i6, this.h);
                this.f[0].put("ImageWidth", cVarJ);
                this.f[0].put("ImageLength", cVarJ2);
            }
        }
    }

    private void m(b bVar) throws Throwable {
        if (u) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.d(ByteOrder.BIG_ENDIAN);
        byte[] bArr = G;
        bVar.e(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i = bVar.readInt();
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int i2 = length + 8;
                if (i2 == 16 && !Arrays.equals(bArr2, I)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, J)) {
                    return;
                }
                if (Arrays.equals(bArr2, H)) {
                    byte[] bArr3 = new byte[i];
                    bVar.readFully(bArr3);
                    int i3 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i3) {
                        this.p = i2;
                        N(bArr3, 0);
                        W();
                        S(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i3 + ", calculated CRC value: " + crc32.getValue());
                }
                int i4 = i + 4;
                bVar.e(i4);
                length = i2 + i4;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void n(b bVar) throws Throwable {
        boolean z2 = u;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.e(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.readFully(bArr);
        bVar.readFully(bArr2);
        bVar.readFully(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        bVar.e(i - bVar.b());
        bVar.readFully(bArr4);
        i(new b(bArr4), i, 5);
        bVar.e(i3 - bVar.b());
        bVar.d(ByteOrder.BIG_ENDIAN);
        int i4 = bVar.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == d0.a) {
                short s = bVar.readShort();
                short s2 = bVar.readShort();
                c cVarJ = c.j(s, this.h);
                c cVarJ2 = c.j(s2, this.h);
                this.f[0].put("ImageLength", cVarJ);
                this.f[0].put("ImageWidth", cVarJ2);
                if (u) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s) + ", width: " + ((int) s2));
                    return;
                }
                return;
            }
            bVar.e(unsignedShort2);
        }
    }

    private void o(f fVar) throws Throwable {
        c cVar;
        K(fVar);
        O(fVar, 0);
        V(fVar, 0);
        V(fVar, 5);
        V(fVar, 4);
        W();
        if (this.d != 8 || (cVar = (c) this.f[1].get("MakerNote")) == null) {
            return;
        }
        f fVar2 = new f(cVar.d);
        fVar2.d(this.h);
        fVar2.e(6);
        O(fVar2, 9);
        c cVar2 = (c) this.f[9].get("ColorSpace");
        if (cVar2 != null) {
            this.f[1].put("ColorSpace", cVar2);
        }
    }

    private void q(f fVar) throws Throwable {
        if (u) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + fVar);
        }
        o(fVar);
        c cVar = (c) this.f[0].get("JpgFromRaw");
        if (cVar != null) {
            i(new b(cVar.d), (int) cVar.c, 5);
        }
        c cVar2 = (c) this.f[0].get("ISO");
        c cVar3 = (c) this.f[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        this.f[1].put("PhotographicSensitivity", cVar2);
    }

    private void r(f fVar) throws IOException {
        byte[] bArr = p0;
        fVar.e(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.p = bArr.length;
        N(bArr2, 0);
    }

    private void s(b bVar) throws Throwable {
        if (u) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.d(ByteOrder.LITTLE_ENDIAN);
        bVar.e(K.length);
        int i = bVar.readInt() + 8;
        byte[] bArr = L;
        bVar.e(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                bVar.readFully(bArr2);
                int i2 = bVar.readInt();
                int i3 = length + 8;
                if (Arrays.equals(M, bArr2)) {
                    byte[] bArr3 = new byte[i2];
                    bVar.readFully(bArr3);
                    this.p = i3;
                    N(bArr3, 0);
                    S(new b(bArr3));
                    return;
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                length = i3 + i2;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.e(i2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private static Pair t(String str) throws NumberFormatException {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair pairT = t(strArrSplit[0]);
            if (((Integer) pairT.first).intValue() == 2) {
                return pairT;
            }
            for (int i = 1; i < strArrSplit.length; i++) {
                Pair pairT2 = t(strArrSplit[i]);
                int iIntValue = (((Integer) pairT2.first).equals(pairT.first) || ((Integer) pairT2.second).equals(pairT.first)) ? ((Integer) pairT.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairT.second).intValue() == -1 || !(((Integer) pairT2.first).equals(pairT.second) || ((Integer) pairT2.second).equals(pairT.second))) ? -1 : ((Integer) pairT.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair(2, -1);
                }
                if (iIntValue == -1) {
                    pairT = new Pair(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairT = new Pair(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairT;
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

    private void u(b bVar, HashMap map) throws Throwable {
        c cVar = (c) map.get("JPEGInterchangeFormat");
        c cVar2 = (c) map.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int iM = cVar.m(this.h);
        int iM2 = cVar2.m(this.h);
        if (this.d == 7) {
            iM += this.q;
        }
        if (iM > 0 && iM2 > 0) {
            this.i = true;
            if (this.a == null && this.c == null && this.b == null) {
                byte[] bArr = new byte[iM2];
                bVar.e(iM);
                bVar.readFully(bArr);
                this.n = bArr;
            }
            this.l = iM;
            this.m = iM2;
        }
        if (u) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iM + ", length: " + iM2);
        }
    }

    private void v(b bVar, HashMap map) throws IOException {
        byte[] bArr;
        c cVar = (c) map.get("StripOffsets");
        c cVar2 = (c) map.get("StripByteCounts");
        if (cVar == null || cVar2 == null) {
            return;
        }
        long[] jArrB = AbstractC19006pd2.b(cVar.o(this.h));
        long[] jArrB2 = AbstractC19006pd2.b(cVar2.o(this.h));
        if (jArrB == null || jArrB.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrB2 == null || jArrB2.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrB.length != jArrB2.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j = 0;
        for (long j2 : jArrB2) {
            j += j2;
        }
        int i = (int) j;
        byte[] bArr2 = new byte[i];
        this.k = true;
        this.j = true;
        this.i = true;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < jArrB.length) {
            int i5 = (int) jArrB[i2];
            int i6 = (int) jArrB2[i2];
            if (i2 < jArrB.length - 1) {
                bArr = bArr2;
                if (i5 + i6 != jArrB[i2 + 1]) {
                    this.k = false;
                }
            } else {
                bArr = bArr2;
            }
            int i7 = i5 - i3;
            if (i7 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
                return;
            }
            try {
                bVar.e(i7);
                int i8 = i3 + i7;
                byte[] bArr3 = new byte[i6];
                try {
                    bVar.readFully(bArr3);
                    i3 = i8 + i6;
                    byte[] bArr4 = bArr;
                    System.arraycopy(bArr3, 0, bArr4, i4, i6);
                    i4 += i6;
                    i2++;
                    bArr2 = bArr4;
                } catch (EOFException unused) {
                    Log.d("ExifInterface", "Failed to read " + i6 + " bytes.");
                    return;
                }
            } catch (EOFException unused2) {
                Log.d("ExifInterface", "Failed to skip " + i7 + " bytes.");
                return;
            }
        }
        this.n = bArr2;
        if (this.k) {
            this.l = (int) jArrB[0];
            this.m = i;
        }
    }

    private void w(String str) throws Throwable {
        FileInputStream fileInputStream;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        FileInputStream fileInputStream2 = null;
        this.c = null;
        this.a = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (F(fileInputStream.getFD())) {
                this.b = fileInputStream.getFD();
            } else {
                this.b = null;
            }
            J(fileInputStream);
            AbstractC19006pd2.a(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            AbstractC19006pd2.a(fileInputStream2);
            throw th;
        }
    }

    private static boolean x(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = p0;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr2[i] != bArr3[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean z(byte[] bArr) throws Throwable {
        b bVar;
        long length;
        byte[] bArr2;
        long j;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            length = bVar.readInt();
            bArr2 = new byte[4];
            bVar.readFully(bArr2);
        } catch (Exception e3) {
            e = e3;
            bVar2 = bVar;
            if (u) {
                Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
            }
            if (bVar2 != null) {
                bVar2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
        if (!Arrays.equals(bArr2, B)) {
            bVar.close();
            return false;
        }
        if (length == 1) {
            length = bVar.readLong();
            j = 16;
            if (length < 16) {
                bVar.close();
                return false;
            }
        } else {
            j = 8;
        }
        if (length > bArr.length) {
            length = bArr.length;
        }
        long j2 = length - j;
        if (j2 < 8) {
            bVar.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z2 = false;
        boolean z3 = false;
        for (long j3 = 0; j3 < j2 / 4; j3++) {
            try {
                bVar.readFully(bArr3);
                if (j3 != 1) {
                    if (Arrays.equals(bArr3, C)) {
                        z2 = true;
                    } else if (Arrays.equals(bArr3, D)) {
                        z3 = true;
                    }
                    if (z2 && z3) {
                        bVar.close();
                        return true;
                    }
                }
            } catch (EOFException unused) {
                bVar.close();
                return false;
            }
        }
        bVar.close();
        return false;
    }

    public void R(String str, String str2) throws NumberFormatException {
        d dVar;
        int i;
        int i2;
        String str3 = str;
        String strReplaceAll = str2;
        if (str3 == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if (("DateTime".equals(str3) || "DateTimeOriginal".equals(str3) || "DateTimeDigitized".equals(str3)) && strReplaceAll != null) {
            boolean zFind = t0.matcher(strReplaceAll).find();
            boolean zFind2 = u0.matcher(strReplaceAll).find();
            if (str2.length() != 19 || (!zFind && !zFind2)) {
                Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                return;
            }
            if (zFind2) {
                strReplaceAll = strReplaceAll.replaceAll("-", ":");
            }
        }
        if ("ISOSpeedRatings".equals(str3)) {
            if (u) {
                Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str3 = "PhotographicSensitivity";
        }
        int i3 = 2;
        int i4 = 1;
        if (strReplaceAll != null && m0.contains(str3)) {
            if (str3.equals("GPSTimeStamp")) {
                Matcher matcher = s0.matcher(strReplaceAll);
                if (!matcher.find()) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                strReplaceAll = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    strReplaceAll = new e(Double.parseDouble(strReplaceAll)).toString();
                } catch (NumberFormatException unused) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
            }
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 < i0.length) {
            if ((i6 != 4 || this.i) && (dVar = (d) l0[i6].get(str3)) != null) {
                if (strReplaceAll != null) {
                    Pair pairT = t(strReplaceAll);
                    int i7 = -1;
                    if (dVar.c == ((Integer) pairT.first).intValue() || dVar.c == ((Integer) pairT.second).intValue()) {
                        i = dVar.c;
                    } else {
                        int i8 = dVar.d;
                        if (i8 == -1 || !(i8 == ((Integer) pairT.first).intValue() || dVar.d == ((Integer) pairT.second).intValue())) {
                            int i9 = dVar.c;
                            if (i9 == i4 || i9 == 7 || i9 == i3) {
                                i = i9;
                            } else if (u) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Given tag (");
                                sb.append(str3);
                                sb.append(") value didn't match with one of expected formats: ");
                                String[] strArr = V;
                                sb.append(strArr[dVar.c]);
                                sb.append(dVar.d == -1 ? "" : ", " + strArr[dVar.d]);
                                sb.append(" (guess: ");
                                sb.append(strArr[((Integer) pairT.first).intValue()]);
                                sb.append(((Integer) pairT.second).intValue() != -1 ? ", " + strArr[((Integer) pairT.second).intValue()] : "");
                                sb.append(Separators.RPAREN);
                                Log.d("ExifInterface", sb.toString());
                            }
                        } else {
                            i = dVar.d;
                        }
                    }
                    switch (i) {
                        case 1:
                            i2 = i4;
                            this.f[i6].put(str3, c.a(strReplaceAll));
                            break;
                        case 2:
                        case 7:
                            i2 = i4;
                            this.f[i6].put(str3, c.e(strReplaceAll));
                            break;
                        case 3:
                            i2 = i4;
                            String[] strArrSplit = strReplaceAll.split(",", -1);
                            int[] iArr = new int[strArrSplit.length];
                            for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                                iArr[i10] = Integer.parseInt(strArrSplit[i10]);
                            }
                            this.f[i6].put(str3, c.k(iArr, this.h));
                            break;
                        case 4:
                            i2 = i4;
                            String[] strArrSplit2 = strReplaceAll.split(",", -1);
                            long[] jArr = new long[strArrSplit2.length];
                            for (int i11 = 0; i11 < strArrSplit2.length; i11++) {
                                jArr[i11] = Long.parseLong(strArrSplit2[i11]);
                            }
                            this.f[i6].put(str3, c.g(jArr, this.h));
                            break;
                        case 5:
                            String[] strArrSplit3 = strReplaceAll.split(",", -1);
                            e[] eVarArr = new e[strArrSplit3.length];
                            int i12 = 0;
                            while (i12 < strArrSplit3.length) {
                                String[] strArrSplit4 = strArrSplit3[i12].split(Separators.SLASH, i7);
                                eVarArr[i12] = new e((long) Double.parseDouble(strArrSplit4[0]), (long) Double.parseDouble(strArrSplit4[1]));
                                i12++;
                                i7 = -1;
                            }
                            i2 = 1;
                            this.f[i6].put(str3, c.i(eVarArr, this.h));
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            if (u) {
                                Log.d("ExifInterface", "Data format isn't one of expected formats: " + i);
                                break;
                            }
                            break;
                        case 9:
                            String[] strArrSplit5 = strReplaceAll.split(",", -1);
                            int[] iArr2 = new int[strArrSplit5.length];
                            for (int i13 = 0; i13 < strArrSplit5.length; i13++) {
                                iArr2[i13] = Integer.parseInt(strArrSplit5[i13]);
                            }
                            this.f[i6].put(str3, c.c(iArr2, this.h));
                            i2 = 1;
                            break;
                        case 10:
                            String[] strArrSplit6 = strReplaceAll.split(",", -1);
                            e[] eVarArr2 = new e[strArrSplit6.length];
                            int i14 = i5;
                            while (i14 < strArrSplit6.length) {
                                String[] strArrSplit7 = strArrSplit6[i14].split(Separators.SLASH, -1);
                                eVarArr2[i14] = new e((long) Double.parseDouble(strArrSplit7[i5]), (long) Double.parseDouble(strArrSplit7[i4]));
                                i14++;
                                strArrSplit6 = strArrSplit6;
                                i5 = 0;
                                i4 = 1;
                            }
                            this.f[i6].put(str3, c.d(eVarArr2, this.h));
                            i2 = 1;
                            break;
                        case 12:
                            String[] strArrSplit8 = strReplaceAll.split(",", -1);
                            double[] dArr = new double[strArrSplit8.length];
                            for (int i15 = i5; i15 < strArrSplit8.length; i15++) {
                                dArr[i15] = Double.parseDouble(strArrSplit8[i15]);
                            }
                            this.f[i6].put(str3, c.b(dArr, this.h));
                            break;
                    }
                } else {
                    this.f[i6].remove(str3);
                }
                i2 = i4;
            } else {
                i2 = i4;
            }
            i6++;
            i4 = i2;
            i3 = 2;
            i5 = 0;
        }
    }

    public double c(double d2) {
        double dE = e("GPSAltitude", -1.0d);
        int iF = f("GPSAltitudeRef", -1);
        if (dE < 0.0d || iF < 0) {
            return d2;
        }
        return dE * (iF != 1 ? 1 : -1);
    }

    public String d(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c cVarG = g(str);
        if (cVarG != null) {
            if (!m0.contains(str)) {
                return cVarG.n(this.h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = cVarG.a;
                if (i != 5 && i != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + cVarG.a);
                    return null;
                }
                e[] eVarArr = (e[]) cVarG.o(this.h);
                if (eVarArr == null || eVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr));
                    return null;
                }
                e eVar = eVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (eVar.a / eVar.b));
                e eVar2 = eVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (eVar2.a / eVar2.b));
                e eVar3 = eVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (eVar3.a / eVar3.b)));
            }
            try {
                return Double.toString(cVarG.l(this.h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public double e(String str, double d2) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c cVarG = g(str);
        if (cVarG == null) {
            return d2;
        }
        try {
            return cVarG.l(this.h);
        } catch (NumberFormatException unused) {
            return d2;
        }
    }

    public int f(String str, int i) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c cVarG = g(str);
        if (cVarG == null) {
            return i;
        }
        try {
            return cVarG.m(this.h);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public double[] j() {
        String strD = d("GPSLatitude");
        String strD2 = d("GPSLatitudeRef");
        String strD3 = d("GPSLongitude");
        String strD4 = d("GPSLongitudeRef");
        if (strD == null || strD2 == null || strD3 == null || strD4 == null) {
            return null;
        }
        try {
            return new double[]{b(strD, strD2), b(strD3, strD4)};
        } catch (IllegalArgumentException unused) {
            Log.w("ExifInterface", "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", strD, strD2, strD3, strD4));
            return null;
        }
    }

    public int p() {
        switch (f("Orientation", 1)) {
            case 3:
            case 4:
                return SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public boolean y() {
        int iF = f("Orientation", 1);
        return iF == 2 || iF == 7 || iF == 4 || iF == 5;
    }

    /* renamed from: ir.nasim.md2$b */
    private static class b extends InputStream implements DataInput {
        protected final DataInputStream a;
        protected int b;
        private ByteOrder c;
        private byte[] d;
        private int e;

        b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
            this.e = bArr.length;
        }

        public int a() {
            return this.e;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.a.available();
        }

        public int b() {
            return this.b;
        }

        public long c() {
            return readInt() & 4294967295L;
        }

        public void d(ByteOrder byteOrder) {
            this.c = byteOrder;
        }

        public void e(int i) throws IOException {
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                int iSkip = (int) this.a.skip(i3);
                if (iSkip <= 0) {
                    if (this.d == null) {
                        this.d = new byte[8192];
                    }
                    iSkip = this.a.read(this.d, 0, Math.min(8192, i3));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i + " bytes.");
                    }
                }
                i2 += iSkip;
            }
            this.b += i2;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.b++;
            return this.a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.b++;
            return this.a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.b++;
            int i = this.a.read();
            if (i >= 0) {
                return (byte) i;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.b += 2;
            return this.a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.b += i2;
            this.a.readFully(bArr, i, i2);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.b += 4;
            int i = this.a.read();
            int i2 = this.a.read();
            int i3 = this.a.read();
            int i4 = this.a.read();
            if ((i | i2 | i3 | i4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
            }
            throw new IOException("Invalid byte order: " + this.c);
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.b += 8;
            int i = this.a.read();
            int i2 = this.a.read();
            int i3 = this.a.read();
            int i4 = this.a.read();
            int i5 = this.a.read();
            int i6 = this.a.read();
            int i7 = this.a.read();
            int i8 = this.a.read();
            if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i8 << 56) + (i7 << 48) + (i6 << 40) + (i5 << 32) + (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i << 56) + (i2 << 48) + (i3 << 40) + (i4 << 32) + (i5 << 24) + (i6 << 16) + (i7 << 8) + i8;
            }
            throw new IOException("Invalid byte order: " + this.c);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.b += 2;
            int i = this.a.read();
            int i2 = this.a.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (short) ((i2 << 8) + i);
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (short) ((i << 8) + i2);
            }
            throw new IOException("Invalid byte order: " + this.c);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.b += 2;
            return this.a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.b++;
            return this.a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.b += 2;
            int i = this.a.read();
            int i2 = this.a.read();
            if ((i | i2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i2 << 8) + i;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i << 8) + i2;
            }
            throw new IOException("Invalid byte order: " + this.c);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.a.read(bArr, i, i2);
            this.b += i3;
            return i3;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.b += bArr.length;
            this.a.readFully(bArr);
        }

        b(InputStream inputStream, ByteOrder byteOrder) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.a = dataInputStream;
            dataInputStream.mark(0);
            this.b = 0;
            this.c = byteOrder;
            this.e = inputStream instanceof b ? ((b) inputStream).a() : -1;
        }
    }

    /* renamed from: ir.nasim.md2$f */
    private static class f extends b {
        f(byte[] bArr) {
            super(bArr);
            this.a.mark(Integer.MAX_VALUE);
        }

        public void g(long j) throws IOException {
            int i = this.b;
            if (i > j) {
                this.b = 0;
                this.a.reset();
            } else {
                j -= i;
            }
            e((int) j);
        }

        f(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    /* renamed from: ir.nasim.md2$d */
    static class d {
        public final int a;
        public final String b;
        public final int c;
        public final int d;

        d(String str, int i, int i2) {
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = -1;
        }

        boolean a(int i) {
            int i2;
            int i3 = this.c;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.d) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((i3 == 9 || i2 == 9) && i == 8) {
                return true;
            }
            return (i3 == 12 || i2 == 12) && i == 11;
        }

        d(String str, int i, int i2, int i3) {
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public C17233md2(String str) throws Throwable {
        d[][] dVarArr = i0;
        this.f = new HashMap[dVarArr.length];
        this.g = new HashSet(dVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            w(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    public C17233md2(InputStream inputStream) {
        this(inputStream, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C17233md2(java.io.InputStream r4, int r5) {
        /*
            r3 = this;
            r3.<init>()
            ir.nasim.md2$d[][] r0 = ir.nasim.C17233md2.i0
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r3.f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r3.g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r3.h = r0
            if (r4 == 0) goto L6a
            r0 = 0
            r3.a = r0
            r1 = 1
            if (r5 != r1) goto L3c
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream
            byte[] r2 = ir.nasim.C17233md2.p0
            int r2 = r2.length
            r5.<init>(r4, r2)
            boolean r4 = x(r5)
            if (r4 != 0) goto L34
            java.lang.String r4 = "ExifInterface"
            java.lang.String r5 = "Given data does not follow the structure of an Exif-only data."
            android.util.Log.w(r4, r5)
            return
        L34:
            r3.e = r1
            r3.c = r0
            r3.b = r0
            r4 = r5
            goto L66
        L3c:
            boolean r5 = r4 instanceof android.content.res.AssetManager.AssetInputStream
            if (r5 == 0) goto L48
            r5 = r4
            android.content.res.AssetManager$AssetInputStream r5 = (android.content.res.AssetManager.AssetInputStream) r5
            r3.c = r5
            r3.b = r0
            goto L66
        L48:
            boolean r5 = r4 instanceof java.io.FileInputStream
            if (r5 == 0) goto L62
            r5 = r4
            java.io.FileInputStream r5 = (java.io.FileInputStream) r5
            java.io.FileDescriptor r1 = r5.getFD()
            boolean r1 = F(r1)
            if (r1 == 0) goto L62
            r3.c = r0
            java.io.FileDescriptor r5 = r5.getFD()
            r3.b = r5
            goto L66
        L62:
            r3.c = r0
            r3.b = r0
        L66:
            r3.J(r4)
            return
        L6a:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "inputStream cannot be null"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17233md2.<init>(java.io.InputStream, int):void");
    }

    /* renamed from: ir.nasim.md2$a */
    class a extends MediaDataSource {
        long a;
        final /* synthetic */ f b;

        a(f fVar) {
            this.b = fVar;
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            try {
                long j2 = this.a;
                if (j2 != j) {
                    if (j2 >= 0 && j >= j2 + this.b.available()) {
                        return -1;
                    }
                    this.b.g(j);
                    this.a = j;
                }
                if (i2 > this.b.available()) {
                    i2 = this.b.available();
                }
                int i3 = this.b.read(bArr, i, i2);
                if (i3 >= 0) {
                    this.a += i3;
                    return i3;
                }
            } catch (IOException unused) {
            }
            this.a = -1L;
            return -1;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
