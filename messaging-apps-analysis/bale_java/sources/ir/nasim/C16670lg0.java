package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/* renamed from: ir.nasim.lg0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16670lg0 {
    public static final C16670lg0 a = new C16670lg0();

    private C16670lg0() {
    }

    public static final int[] a(Bitmap bitmap, int i, int i2) {
        AbstractC13042fc3.i(bitmap, "bitmap");
        int[] iArr = new int[i * i2];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        return iArr;
    }

    public static final Bitmap b(byte[] bArr) {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr != null ? bArr.length : 0);
        AbstractC13042fc3.h(bitmapDecodeByteArray, "decodeByteArray(...)");
        return bitmapDecodeByteArray;
    }

    public static final Bitmap c(Bitmap bitmap, int i) {
        AbstractC13042fc3.i(bitmap, "bitmap");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.graphics.Bitmap d(int r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "name"
            ir.nasim.AbstractC13042fc3.i(r6, r0)
            if (r7 == 0) goto L8d
            int r0 = r7.length()     // Catch: java.lang.Exception -> L2b
            if (r0 <= 0) goto L8d
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L2b
            r0.<init>(r7)     // Catch: java.lang.Exception -> L2b
            boolean r7 = r0.exists()     // Catch: java.lang.Exception -> L2b
            if (r7 == 0) goto L8d
            java.lang.String r7 = r0.getAbsolutePath()     // Catch: java.lang.Exception -> L2b
            r0 = 1112014848(0x42480000, float:50.0)
            int r1 = ir.nasim.C22078ud6.a(r0)     // Catch: java.lang.Exception -> L2b
            int r0 = ir.nasim.C22078ud6.a(r0)     // Catch: java.lang.Exception -> L2b
            android.graphics.Bitmap r7 = ir.nasim.AbstractC24097y23.e(r7, r1, r0)     // Catch: java.lang.Exception -> L2b
            goto L8e
        L2b:
            r7 = move-exception
            ir.nasim.X25 r0 = ir.nasim.X25.a
            java.lang.Class r0 = r0.getClass()
            boolean r0 = r0.isAnonymousClass()
            java.lang.String r1 = "substring(...)"
            r2 = 0
            java.lang.Class<ir.nasim.X25> r3 = ir.nasim.X25.class
            r4 = 23
            if (r0 != 0) goto L55
            java.lang.String r0 = r3.getSimpleName()
            int r3 = r0.length()
            ir.nasim.AbstractC13042fc3.f(r0)
            if (r3 > r4) goto L4d
            goto L73
        L4d:
            java.lang.String r0 = r0.substring(r2, r4)
            ir.nasim.AbstractC13042fc3.h(r0, r1)
            goto L73
        L55:
            java.lang.String r0 = r3.getName()
            int r3 = r0.length()
            ir.nasim.AbstractC13042fc3.f(r0)
            if (r3 > r4) goto L63
            goto L73
        L63:
            int r3 = r0.length()
            int r3 = r3 - r4
            int r4 = r0.length()
            java.lang.String r0 = r0.substring(r3, r4)
            ir.nasim.AbstractC13042fc3.h(r0, r1)
        L73:
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Error in loadBitmap: "
            r1.append(r3)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r2]
            ir.nasim.C19406qI3.j(r0, r7, r1)
        L8d:
            r7 = 0
        L8e:
            if (r7 != 0) goto L94
            android.graphics.Bitmap r7 = f(r6, r5)
        L94:
            int r5 = r7.getWidth()
            int r5 = r5 / 2
            android.graphics.Bitmap r5 = c(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16670lg0.d(int, java.lang.String, java.lang.String):android.graphics.Bitmap");
    }

    public static final Bitmap f(String str, int i) {
        AbstractC13042fc3.i(str, "name");
        return h(B02.a(new WU(str, i, 18.0f, C5721Ko.a.d(), false, true), 100, 100, Bitmap.Config.ARGB_8888));
    }

    public static final Bitmap g(String str, int i, int i2, int i3) {
        AbstractC13042fc3.i(str, "name");
        return h(B02.a(new WU(str, i, 18.0f, C5721Ko.a.d(), false, true), i3, i2, Bitmap.Config.ARGB_8888));
    }

    public static final Bitmap h(Bitmap bitmap) {
        AbstractC13042fc3.i(bitmap, "bitmap");
        int iF = AbstractC7426Rr.a.f(48.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iF, iF, Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        RectF rectF = new RectF();
        Paint paint2 = new Paint(1);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Path path = new Path();
        float f = iF / 2;
        path.addCircle(f, f, r1 - r0.f(2.0f), Path.Direction.CW);
        path.toggleInverseFillType();
        rectF.set(r0.f(2.0f), r0.f(2.0f), r0.f(46.0f), r0.f(46.0f));
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
        canvas.drawPath(path, paint2);
        try {
            canvas.setBitmap(null);
        } catch (Exception unused) {
        }
        return bitmapCreateBitmap;
    }

    public final Bitmap e(Bitmap bitmap) {
        AbstractC13042fc3.i(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = Math.min(width, height);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, Math.max((width - height) / 2, 0), Math.max((height - width) / 2, 0), iMin, iMin);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }
}
