package ir.nasim;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10086b33;
import ir.nasim.CB1;
import ir.nasim.FT1;
import java.io.IOException;

/* renamed from: ir.nasim.oT7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18327oT7 implements CB1 {
    public static final a c = new a(null);
    private final AbstractC10086b33 a;
    private final IL4 b;

    /* renamed from: ir.nasim.oT7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.oT7$b */
    public static final class b implements CB1.a {
        private final boolean b(String str) {
            return str != null && AbstractC20153rZ6.S(str, "video/", false, 2, null);
        }

        @Override // ir.nasim.CB1.a
        public CB1 a(WH6 wh6, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            if (b(wh6.b())) {
                return new C18327oT7(wh6.c(), il4);
            }
            return null;
        }

        public boolean equals(Object obj) {
            return obj instanceof b;
        }

        public int hashCode() {
            return b.class.hashCode();
        }
    }

    public C18327oT7(AbstractC10086b33 abstractC10086b33, IL4 il4) {
        this.a = abstractC10086b33;
        this.b = il4;
    }

    private final long b(MediaMetadataRetriever mediaMetadataRetriever) {
        Long lQ;
        Long lA = NV7.a(this.b.l());
        if (lA != null) {
            return lA.longValue();
        }
        Double dC = NV7.c(this.b.l());
        long jLongValue = 0;
        if (dC == null) {
            return 0L;
        }
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
        if (strExtractMetadata != null && (lQ = AbstractC19562qZ6.q(strExtractMetadata)) != null) {
            jLongValue = lQ.longValue();
        }
        return AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT * AbstractC20723sV3.e(dC.doubleValue() * jLongValue);
    }

    private final boolean c(Bitmap bitmap, IL4 il4) {
        return Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE || il4.f() == Bitmap.Config.HARDWARE;
    }

    private final boolean d(Bitmap bitmap, IL4 il4, PD6 pd6) {
        if (il4.c()) {
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        FT1 ft1D = pd6.d();
        int width2 = ft1D instanceof FT1.a ? ((FT1.a) ft1D).a : bitmap.getWidth();
        FT1 ft1C = pd6.c();
        return C21144tB1.c(width, height, width2, ft1C instanceof FT1.a ? ((FT1.a) ft1C).a : bitmap.getHeight(), il4.n()) == 1.0d;
    }

    private final Bitmap e(Bitmap bitmap, PD6 pd6) {
        if (c(bitmap, this.b) && d(bitmap, this.b, pd6)) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        FT1 ft1D = pd6.d();
        int width2 = ft1D instanceof FT1.a ? ((FT1.a) ft1D).a : bitmap.getWidth();
        FT1 ft1C = pd6.c();
        float fC = (float) C21144tB1.c(width, height, width2, ft1C instanceof FT1.a ? ((FT1.a) ft1C).a : bitmap.getHeight(), this.b.n());
        int iD = AbstractC20723sV3.d(bitmap.getWidth() * fC);
        int iD2 = AbstractC20723sV3.d(bitmap.getHeight() * fC);
        Bitmap.Config configF = (Build.VERSION.SDK_INT < 26 || this.b.f() != Bitmap.Config.HARDWARE) ? this.b.f() : Bitmap.Config.ARGB_8888;
        Paint paint = new Paint(3);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iD, iD2, configF);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.scale(fC, fC);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    private final void f(MediaMetadataRetriever mediaMetadataRetriever, AbstractC10086b33 abstractC10086b33) throws IOException, SecurityException, IllegalArgumentException {
        abstractC10086b33.b();
        AbstractC10086b33.a aVarB = abstractC10086b33.b();
        if (aVarB instanceof C21223tK) {
            AssetFileDescriptor assetFileDescriptorOpenFd = this.b.g().getAssets().openFd(((C21223tK) aVarB).a());
            try {
                mediaMetadataRetriever.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                C19938rB7 c19938rB7 = C19938rB7.a;
                YV0.a(assetFileDescriptorOpenFd, null);
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    YV0.a(assetFileDescriptorOpenFd, th);
                    throw th2;
                }
            }
        }
        if (aVarB instanceof C9081Yk1) {
            mediaMetadataRetriever.setDataSource(this.b.g(), ((C9081Yk1) aVarB).a());
            return;
        }
        if (!(aVarB instanceof QW5)) {
            mediaMetadataRetriever.setDataSource(abstractC10086b33.a().toFile().getPath());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("android.resource://");
        QW5 qw5 = (QW5) aVarB;
        sb.append(qw5.b());
        sb.append('/');
        sb.append(qw5.c());
        mediaMetadataRetriever.setDataSource(sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006a A[PHI: r0
      0x006a: PHI (r0v16 int) = (r0v13 int), (r0v13 int), (r0v27 int), (r0v27 int) binds: [B:40:0x0083, B:42:0x0089, B:27:0x005d, B:29:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // ir.nasim.CB1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20295rm1 r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18327oT7.a(ir.nasim.rm1):java.lang.Object");
    }
}
