package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: ir.nasim.lv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC16827lv7 {
    private static final Paint a = new Paint(6);
    private static final Paint b = new Paint(7);
    private static final Paint c;
    private static final Set d;
    private static final Lock e;

    /* renamed from: ir.nasim.lv7$a */
    class a implements b {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // ir.nasim.AbstractC16827lv7.b
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            int i = this.a;
            canvas.drawRoundRect(rectF, i, i, paint);
        }
    }

    /* renamed from: ir.nasim.lv7$b */
    private interface b {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    /* renamed from: ir.nasim.lv7$c */
    private static final class c implements Lock {
        c() {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        d = hashSet;
        e = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new c();
        Paint paint = new Paint(7);
        c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, a);
            e(canvas);
            lock.unlock();
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    public static Bitmap b(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            width2 = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapD = interfaceC13106fg0.d(i, i2, k(bitmap));
        q(bitmap, bitmapD);
        a(bitmap, bitmapD, matrix);
        return bitmapD;
    }

    public static Bitmap c(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return f(interfaceC13106fg0, bitmap, i, i2);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static Bitmap d(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2) {
        int iMin = Math.min(i, i2);
        float f = iMin;
        float f2 = f / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f / width, f / height);
        float f3 = width * fMax;
        float f4 = fMax * height;
        float f5 = (f - f3) / 2.0f;
        float f6 = (f - f4) / 2.0f;
        RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
        Bitmap bitmapG = g(interfaceC13106fg0, bitmap);
        Bitmap bitmapD = interfaceC13106fg0.d(iMin, iMin, h(bitmap));
        bitmapD.setHasAlpha(true);
        Lock lock = e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapD);
            canvas.drawCircle(f2, f2, f2, b);
            canvas.drawBitmap(bitmapG, (Rect) null, rectF, c);
            e(canvas);
            lock.unlock();
            if (!bitmapG.equals(bitmap)) {
                interfaceC13106fg0.c(bitmapG);
            }
            return bitmapD;
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap f(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float fMin = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int iRound = Math.round(bitmap.getWidth() * fMin);
        int iRound2 = Math.round(bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == iRound && bitmap.getHeight() == iRound2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap bitmapD = interfaceC13106fg0.d((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), k(bitmap));
        q(bitmap, bitmapD);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + "x" + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmapD.getWidth() + "x" + bitmapD.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(fMin);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        a(bitmap, bitmapD, matrix);
        return bitmapD;
    }

    private static Bitmap g(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap) {
        Bitmap.Config configH = h(bitmap);
        if (configH.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmapD = interfaceC13106fg0.d(bitmap.getWidth(), bitmap.getHeight(), configH);
        new Canvas(bitmapD).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapD;
    }

    private static Bitmap.Config h(Bitmap bitmap) {
        return (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
    }

    public static Lock i() {
        return e;
    }

    public static int j(int i) {
        switch (i) {
            case 3:
            case 4:
                return SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    private static Bitmap.Config k(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    static void l(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    public static boolean m(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap n(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i) {
        if (!m(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        l(i, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmapD = interfaceC13106fg0.d(Math.round(rectF.width()), Math.round(rectF.height()), k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmapD.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, bitmapD, matrix);
        return bitmapD;
    }

    public static Bitmap o(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, int i) {
        AbstractC3322Aj5.a(i > 0, "roundingRadius must be greater than 0.");
        return p(interfaceC13106fg0, bitmap, new a(i));
    }

    private static Bitmap p(InterfaceC13106fg0 interfaceC13106fg0, Bitmap bitmap, b bVar) {
        Bitmap.Config configH = h(bitmap);
        Bitmap bitmapG = g(interfaceC13106fg0, bitmap);
        Bitmap bitmapD = interfaceC13106fg0.d(bitmapG.getWidth(), bitmapG.getHeight(), configH);
        bitmapD.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapG, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmapD.getWidth(), bitmapD.getHeight());
        Lock lock = e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapD);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            bVar.a(canvas, paint, rectF);
            e(canvas);
            lock.unlock();
            if (!bitmapG.equals(bitmap)) {
                interfaceC13106fg0.c(bitmapG);
            }
            return bitmapD;
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    public static void q(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
