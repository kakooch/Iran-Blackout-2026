package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: ir.nasim.gt, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13826gt {
    private final List a;
    private final LJ b;

    /* renamed from: ir.nasim.gt$a */
    private static final class a implements DW5 {
        private final AnimatedImageDrawable a;

        a(AnimatedImageDrawable animatedImageDrawable) {
            this.a = animatedImageDrawable;
        }

        @Override // ir.nasim.DW5
        public void a() {
            this.a.stop();
            this.a.clearAnimationCallbacks();
        }

        @Override // ir.nasim.DW5
        public Class b() {
            return Drawable.class;
        }

        @Override // ir.nasim.DW5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.a;
        }

        @Override // ir.nasim.DW5
        public int f() {
            return this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight() * YM7.j(Bitmap.Config.ARGB_8888) * 2;
        }
    }

    /* renamed from: ir.nasim.gt$b */
    private static final class b implements HW5 {
        private final C13826gt a;

        b(C13826gt c13826gt) {
            this.a = c13826gt;
        }

        @Override // ir.nasim.HW5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public DW5 a(ByteBuffer byteBuffer, int i, int i2, HL4 hl4) {
            return this.a.b(ImageDecoder.createSource(byteBuffer), i, i2, hl4);
        }

        @Override // ir.nasim.HW5
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(ByteBuffer byteBuffer, HL4 hl4) {
            return this.a.d(byteBuffer);
        }
    }

    /* renamed from: ir.nasim.gt$c */
    private static final class c implements HW5 {
        private final C13826gt a;

        c(C13826gt c13826gt) {
            this.a = c13826gt;
        }

        @Override // ir.nasim.HW5
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public DW5 a(InputStream inputStream, int i, int i2, HL4 hl4) {
            return this.a.b(ImageDecoder.createSource(AbstractC5254Io0.b(inputStream)), i, i2, hl4);
        }

        @Override // ir.nasim.HW5
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(InputStream inputStream, HL4 hl4) {
            return this.a.c(inputStream);
        }
    }

    private C13826gt(List list, LJ lj) {
        this.a = list;
        this.b = lj;
    }

    public static HW5 a(List list, LJ lj) {
        return new b(new C13826gt(list, lj));
    }

    private boolean e(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF);
    }

    public static HW5 f(List list, LJ lj) {
        return new c(new C13826gt(list, lj));
    }

    DW5 b(ImageDecoder.Source source, int i, int i2, HL4 hl4) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new EE1(i, i2, hl4));
        if (AbstractC9985at.a(drawableDecodeDrawable)) {
            return new a(AbstractC10602bt.a(drawableDecodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    boolean c(InputStream inputStream) {
        return e(com.bumptech.glide.load.a.f(this.a, inputStream, this.b));
    }

    boolean d(ByteBuffer byteBuffer) {
        return e(com.bumptech.glide.load.a.g(this.a, byteBuffer));
    }
}
