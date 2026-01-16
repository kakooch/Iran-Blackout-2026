package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import ir.nasim.AbstractC14220hZ1;
import ir.nasim.N23;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* renamed from: ir.nasim.lZ1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16602lZ1 {
    public static final C23097wL4 f = C23097wL4.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", EnumC18159oB1.c);
    public static final C23097wL4 g = C23097wL4.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
    public static final C23097wL4 h = AbstractC14220hZ1.h;
    public static final C23097wL4 i;
    public static final C23097wL4 j;
    private static final Set k;
    private static final b l;
    private static final Set m;
    private static final Queue n;
    private final InterfaceC13106fg0 a;
    private final DisplayMetrics b;
    private final LJ c;
    private final List d;
    private final C18331oU2 e = C18331oU2.b();

    /* renamed from: ir.nasim.lZ1$b */
    public interface b {
        void a(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap);

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        i = C23097wL4.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        j = C23097wL4.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        l = new a();
        m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        n = YM7.g(0);
    }

    public C16602lZ1(List list, DisplayMetrics displayMetrics, InterfaceC13106fg0 interfaceC13106fg0, LJ lj) {
        this.d = list;
        this.b = (DisplayMetrics) AbstractC3322Aj5.d(displayMetrics);
        this.a = (InterfaceC13106fg0) AbstractC3322Aj5.d(interfaceC13106fg0);
        this.c = (LJ) AbstractC3322Aj5.d(lj);
    }

    private static int a(double d) {
        return x((d / (r1 / r0)) * x(l(d) * d));
    }

    private void b(N23 n23, EnumC18159oB1 enumC18159oB1, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        boolean zHasAlpha;
        if (this.e.g(i2, i3, options, z, z2)) {
            return;
        }
        if (enumC18159oB1 == EnumC18159oB1.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = n23.d().hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + enumC18159oB1, e);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, N23 n23, b bVar, InterfaceC13106fg0 interfaceC13106fg0, AbstractC14220hZ1 abstractC14220hZ1, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int i7;
        int i8;
        int iFloor;
        int iFloor2;
        if (i3 <= 0 || i4 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
                return;
            }
            return;
        }
        if (r(i2)) {
            i8 = i3;
            i7 = i4;
        } else {
            i7 = i3;
            i8 = i4;
        }
        float fB = abstractC14220hZ1.b(i7, i8, i5, i6);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + abstractC14220hZ1 + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        AbstractC14220hZ1.g gVarA = abstractC14220hZ1.a(i7, i8, i5, i6);
        if (gVarA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i7;
        float f3 = i8;
        int iX = i7 / x(fB * f2);
        int iX2 = i8 / x(fB * f3);
        AbstractC14220hZ1.g gVar = AbstractC14220hZ1.g.MEMORY;
        int iMax = Math.max(1, Integer.highestOneBit(gVarA == gVar ? Math.max(iX, iX2) : Math.min(iX, iX2)));
        if (gVarA == gVar && iMax < 1.0f / fB) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            iFloor = (int) Math.ceil(f2 / fMin);
            iFloor2 = (int) Math.ceil(f3 / fMin);
            int i9 = iMax / 8;
            if (i9 > 0) {
                iFloor /= i9;
                iFloor2 /= i9;
            }
        } else if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
            float f4 = iMax;
            iFloor = (int) Math.floor(f2 / f4);
            iFloor2 = (int) Math.floor(f3 / f4);
        } else if (imageType.isWebp()) {
            float f5 = iMax;
            iFloor = Math.round(f2 / f5);
            iFloor2 = Math.round(f3 / f5);
        } else if (i7 % iMax == 0 && i8 % iMax == 0) {
            iFloor = i7 / iMax;
            iFloor2 = i8 / iMax;
        } else {
            int[] iArrM = m(n23, options, bVar, interfaceC13106fg0);
            iFloor = iArrM[0];
            iFloor2 = iArrM[1];
        }
        double dB = abstractC14220hZ1.b(iFloor, iFloor2, i5, i6);
        options.inTargetDensity = a(dB);
        options.inDensity = l(dB);
        if (s(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iFloor2 + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private DW5 e(N23 n23, int i2, int i3, HL4 hl4, b bVar) {
        byte[] bArr = (byte[]) this.c.c(65536, byte[].class);
        BitmapFactory.Options optionsK = k();
        optionsK.inTempStorage = bArr;
        EnumC18159oB1 enumC18159oB1 = (EnumC18159oB1) hl4.c(f);
        EnumC4038Dk5 enumC4038Dk5 = (EnumC4038Dk5) hl4.c(g);
        AbstractC14220hZ1 abstractC14220hZ1 = (AbstractC14220hZ1) hl4.c(AbstractC14220hZ1.h);
        boolean zBooleanValue = ((Boolean) hl4.c(i)).booleanValue();
        C23097wL4 c23097wL4 = j;
        try {
            return C14288hg0.d(h(n23, optionsK, abstractC14220hZ1, enumC18159oB1, enumC4038Dk5, hl4.c(c23097wL4) != null && ((Boolean) hl4.c(c23097wL4)).booleanValue(), i2, i3, zBooleanValue, bVar), this.a);
        } finally {
            v(optionsK);
            this.c.e(bArr);
        }
    }

    private Bitmap h(N23 n23, BitmapFactory.Options options, AbstractC14220hZ1 abstractC14220hZ1, EnumC18159oB1 enumC18159oB1, EnumC4038Dk5 enumC4038Dk5, boolean z, int i2, int i3, boolean z2, b bVar) {
        int i4;
        int i5;
        String str;
        int i6;
        int iRound;
        int i7;
        int i8;
        long jB = EI3.b();
        int[] iArrM = m(n23, options, bVar, this.a);
        int i9 = iArrM[0];
        int i10 = iArrM[1];
        String str2 = options.outMimeType;
        boolean z3 = (i9 == -1 || i10 == -1) ? false : z;
        int iC = n23.c();
        int iJ = AbstractC16827lv7.j(iC);
        boolean zM = AbstractC16827lv7.m(iC);
        if (i2 == Integer.MIN_VALUE) {
            i4 = i3;
            i5 = r(iJ) ? i10 : i9;
        } else {
            i4 = i3;
            i5 = i2;
        }
        int i11 = i4 == Integer.MIN_VALUE ? r(iJ) ? i9 : i10 : i4;
        ImageHeaderParser.ImageType imageTypeD = n23.d();
        c(imageTypeD, n23, bVar, this.a, abstractC14220hZ1, iJ, i9, i10, i5, i11, options);
        b(n23, enumC18159oB1, z3, zM, options, i5, i11);
        int i12 = Build.VERSION.SDK_INT;
        if (z(imageTypeD)) {
            if (i9 < 0 || i10 < 0 || !z2) {
                float f2 = s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i13 = options.inSampleSize;
                float f3 = i13;
                int iCeil = (int) Math.ceil(i9 / f3);
                int iCeil2 = (int) Math.ceil(i10 / f3);
                int iRound2 = Math.round(iCeil * f2);
                iRound = Math.round(iCeil2 * f2);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculated target [");
                    sb.append(iRound2);
                    sb.append("x");
                    sb.append(iRound);
                    i7 = iRound2;
                    sb.append("] for source [");
                    sb.append(i9);
                    sb.append("x");
                    sb.append(i10);
                    sb.append("], sampleSize: ");
                    sb.append(i13);
                    sb.append(", targetDensity: ");
                    sb.append(options.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options.inDensity);
                    sb.append(", density multiplier: ");
                    sb.append(f2);
                    Log.v(str, sb.toString());
                } else {
                    i7 = iRound2;
                }
                i8 = i7;
            } else {
                str = "Downsampler";
                i8 = i5;
                iRound = i11;
            }
            if (i8 > 0 && iRound > 0) {
                y(options, this.a, i8, iRound);
            }
        } else {
            str = "Downsampler";
        }
        if (enumC4038Dk5 != null) {
            if (i12 >= 28) {
                options.inPreferredColorSpace = ColorSpace.get((enumC4038Dk5 == EnumC4038Dk5.DISPLAY_P3 && options.outColorSpace != null && options.outColorSpace.isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
            } else if (i12 >= 26) {
                options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap bitmapI = i(n23, options, bVar, this.a);
        bVar.a(this.a, bitmapI);
        if (Log.isLoggable(str, 2)) {
            i6 = iC;
            t(i9, i10, str2, options, bitmapI, i2, i3, jB);
        } else {
            i6 = iC;
        }
        if (bitmapI == null) {
            return null;
        }
        bitmapI.setDensity(this.b.densityDpi);
        Bitmap bitmapN = AbstractC16827lv7.n(this.a, bitmapI, i6);
        if (bitmapI.equals(bitmapN)) {
            return bitmapN;
        }
        this.a.c(bitmapI);
        return bitmapN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap i(ir.nasim.N23 r5, android.graphics.BitmapFactory.Options r6, ir.nasim.C16602lZ1.b r7, ir.nasim.InterfaceC13106fg0 r8) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r7.b()
            r5.b()
        Lc:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = ir.nasim.AbstractC16827lv7.i()
            r4.lock()
            android.graphics.Bitmap r5 = r5.a(r6)     // Catch: java.lang.Throwable -> L25 java.lang.IllegalArgumentException -> L27
            java.util.concurrent.locks.Lock r6 = ir.nasim.AbstractC16827lv7.i()
            r6.unlock()
            return r5
        L25:
            r5 = move-exception
            goto L50
        L27:
            r4 = move-exception
            java.io.IOException r1 = u(r4, r1, r2, r3, r6)     // Catch: java.lang.Throwable -> L25
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L38
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L25
        L38:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L4f
            r8.c(r0)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            r0 = 0
            r6.inBitmap = r0     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            android.graphics.Bitmap r5 = i(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            java.util.concurrent.locks.Lock r6 = ir.nasim.AbstractC16827lv7.i()
            r6.unlock()
            return r5
        L4e:
            throw r1     // Catch: java.lang.Throwable -> L25
        L4f:
            throw r1     // Catch: java.lang.Throwable -> L25
        L50:
            java.util.concurrent.locks.Lock r6 = ir.nasim.AbstractC16827lv7.i()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16602lZ1.i(ir.nasim.N23, android.graphics.BitmapFactory$Options, ir.nasim.lZ1$b, ir.nasim.fg0):android.graphics.Bitmap");
    }

    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + Separators.RPAREN);
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options options;
        Queue queue = n;
        synchronized (queue) {
            options = (BitmapFactory.Options) queue.poll();
        }
        if (options == null) {
            options = new BitmapFactory.Options();
            w(options);
        }
        return options;
    }

    private static int l(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private static int[] m(N23 n23, BitmapFactory.Options options, b bVar, InterfaceC13106fg0 interfaceC13106fg0) {
        options.inJustDecodeBounds = true;
        i(n23, options, bVar, interfaceC13106fg0);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + EI3.a(j2));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue queue = n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d) {
        return (int) (d + 0.5d);
    }

    private static void y(BitmapFactory.Options options, InterfaceC13106fg0 interfaceC13106fg0, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = interfaceC13106fg0.e(i2, i3, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public DW5 d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, HL4 hl4) {
        return e(new N23.c(parcelFileDescriptor, this.d, this.c), i2, i3, hl4, l);
    }

    public DW5 f(InputStream inputStream, int i2, int i3, HL4 hl4, b bVar) {
        return e(new N23.b(inputStream, this.d, this.c), i2, i3, hl4, bVar);
    }

    public DW5 g(ByteBuffer byteBuffer, int i2, int i3, HL4 hl4) {
        return e(new N23.a(byteBuffer, this.d, this.c), i2, i3, hl4, l);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.a();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    /* renamed from: ir.nasim.lZ1$a */
    class a implements b {
        a() {
        }

        @Override // ir.nasim.C16602lZ1.b
        public void b() {
        }

        @Override // ir.nasim.C16602lZ1.b
        public void a(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap) {
        }
    }
}
