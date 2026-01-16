package ir.nasim;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import ir.nasim.C23097wL4;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class PS7 implements HW5 {
    public static final C23097wL4 d = C23097wL4.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final C23097wL4 e = C23097wL4.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());
    private static final f f = new f();
    private static final List g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));
    private final e a;
    private final InterfaceC13106fg0 b;
    private final f c;

    class a implements C23097wL4.b {
        private final ByteBuffer a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // ir.nasim.C23097wL4.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l.longValue()).array());
            }
        }
    }

    class b implements C23097wL4.b {
        private final ByteBuffer a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // ir.nasim.C23097wL4.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    private static final class c implements e {
        private c() {
        }

        @Override // ir.nasim.PS7.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        @Override // ir.nasim.PS7.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    interface e {
        void a(MediaExtractor mediaExtractor, Object obj);

        void b(MediaMetadataRetriever mediaMetadataRetriever, Object obj);
    }

    static class f {
        f() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    static final class g implements e {
        g() {
        }

        @Override // ir.nasim.PS7.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        @Override // ir.nasim.PS7.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    private static final class h extends RuntimeException {
        h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    PS7(InterfaceC13106fg0 interfaceC13106fg0, e eVar) {
        this(interfaceC13106fg0, eVar, f);
    }

    public static HW5 c(InterfaceC13106fg0 interfaceC13106fg0) {
        return new PS7(interfaceC13106fg0, new c(null));
    }

    public static HW5 d(InterfaceC13106fg0 interfaceC13106fg0) {
        return new PS7(interfaceC13106fg0, new d());
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (!j()) {
            return bitmap;
        }
        try {
            if (i(mediaMetadataRetriever)) {
                if (Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) == 180) {
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(180.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            }
        } catch (NumberFormatException unused) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
            }
        }
        return bitmap;
    }

    private Bitmap f(Object obj, MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, AbstractC14220hZ1 abstractC14220hZ1) {
        if (l(obj, mediaMetadataRetriever)) {
            throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
        }
        Bitmap bitmapH = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || abstractC14220hZ1 == AbstractC14220hZ1.f) ? null : h(mediaMetadataRetriever, j, i, i2, i3, abstractC14220hZ1);
        if (bitmapH == null) {
            bitmapH = g(mediaMetadataRetriever, j, i);
        }
        Bitmap bitmapE = e(mediaMetadataRetriever, bitmapH);
        if (bitmapE != null) {
            return bitmapE;
        }
        throw new h();
    }

    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    private static Bitmap h(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, AbstractC14220hZ1 abstractC14220hZ1) {
        try {
            int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i6 == 90 || i6 == 270) {
                i5 = i4;
                i4 = i5;
            }
            float fB = abstractC14220hZ1.b(i4, i5, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(i4 * fB), Math.round(fB * i5));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    private static boolean i(MediaMetadataRetriever mediaMetadataRetriever) throws NumberFormatException {
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int i = Integer.parseInt(strExtractMetadata);
        return (i == 7 || i == 6) && Integer.parseInt(strExtractMetadata2) == 6;
    }

    static boolean j() {
        if (Build.MODEL.startsWith("Pixel") && Build.VERSION.SDK_INT == 33) {
            return k();
        }
        int i = Build.VERSION.SDK_INT;
        return i >= 30 && i < 33;
    }

    private static boolean k() {
        Iterator it = g.iterator();
        while (it.hasNext()) {
            if (Build.ID.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean l(Object obj, MediaMetadataRetriever mediaMetadataRetriever) {
        String str = Build.DEVICE;
        if (str == null || !str.matches(".+_cheets|cheets_.+")) {
            return false;
        }
        MediaExtractor mediaExtractor = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (!"video/webm".equals(mediaMetadataRetriever.extractMetadata(12))) {
            return false;
        }
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        try {
            this.a.a(mediaExtractor2, obj);
            int trackCount = mediaExtractor2.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                if ("video/x-vnd.on2.vp8".equals(mediaExtractor2.getTrackFormat(i).getString("mime"))) {
                    mediaExtractor2.release();
                    return true;
                }
            }
            mediaExtractor2.release();
        } catch (Throwable th2) {
            th = th2;
            mediaExtractor = mediaExtractor2;
            try {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to extract track info for a webm video on CrOS.", th);
                }
                return false;
            } finally {
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
            }
        }
        return false;
    }

    public static HW5 m(InterfaceC13106fg0 interfaceC13106fg0) {
        return new PS7(interfaceC13106fg0, new g());
    }

    @Override // ir.nasim.HW5
    public DW5 a(Object obj, int i, int i2, HL4 hl4) throws IOException {
        long jLongValue = ((Long) hl4.c(d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) hl4.c(e);
        if (num == null) {
            num = 2;
        }
        AbstractC14220hZ1 abstractC14220hZ1 = (AbstractC14220hZ1) hl4.c(AbstractC14220hZ1.h);
        if (abstractC14220hZ1 == null) {
            abstractC14220hZ1 = AbstractC14220hZ1.g;
        }
        AbstractC14220hZ1 abstractC14220hZ12 = abstractC14220hZ1;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.c.a();
        try {
            this.a.b(mediaMetadataRetrieverA, obj);
            return C14288hg0.d(f(obj, mediaMetadataRetrieverA, jLongValue, num.intValue(), i, i2, abstractC14220hZ12), this.b);
        } finally {
            if (Build.VERSION.SDK_INT >= 29) {
                mediaMetadataRetrieverA.release();
            } else {
                mediaMetadataRetrieverA.release();
            }
        }
    }

    @Override // ir.nasim.HW5
    public boolean b(Object obj, HL4 hl4) {
        return true;
    }

    PS7(InterfaceC13106fg0 interfaceC13106fg0, e eVar, f fVar) {
        this.b = interfaceC13106fg0;
        this.a = eVar;
        this.c = fVar;
    }

    static final class d implements e {
        d() {
        }

        private MediaDataSource c(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // ir.nasim.PS7.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) throws IOException {
            mediaExtractor.setDataSource(c(byteBuffer));
        }

        @Override // ir.nasim.PS7.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(c(byteBuffer));
        }

        class a extends MediaDataSource {
            final /* synthetic */ ByteBuffer a;

            a(ByteBuffer byteBuffer) {
                this.a = byteBuffer;
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j, byte[] bArr, int i, int i2) {
                if (j >= this.a.limit()) {
                    return -1;
                }
                this.a.position((int) j);
                int iMin = Math.min(i2, this.a.remaining());
                this.a.get(bArr, i, iMin);
                return iMin;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        }
    }
}
