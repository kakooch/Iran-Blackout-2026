package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
interface N23 {

    public static final class b implements N23 {
        private final com.bumptech.glide.load.data.c a;
        private final LJ b;
        private final List c;

        b(InputStream inputStream, List list, LJ lj) {
            this.b = (LJ) AbstractC3322Aj5.d(lj);
            this.c = (List) AbstractC3322Aj5.d(list);
            this.a = new com.bumptech.glide.load.data.c(inputStream, lj);
        }

        @Override // ir.nasim.N23
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.a.c(), null, options);
        }

        @Override // ir.nasim.N23
        public void b() {
            this.a.a();
        }

        @Override // ir.nasim.N23
        public int c() {
            return com.bumptech.glide.load.a.b(this.c, this.a.c(), this.b);
        }

        @Override // ir.nasim.N23
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.f(this.c, this.a.c(), this.b);
        }
    }

    Bitmap a(BitmapFactory.Options options);

    void b();

    int c();

    ImageHeaderParser.ImageType d();

    public static final class a implements N23 {
        private final ByteBuffer a;
        private final List b;
        private final LJ c;

        a(ByteBuffer byteBuffer, List list, LJ lj) {
            this.a = byteBuffer;
            this.b = list;
            this.c = lj;
        }

        private InputStream e() {
            return AbstractC5254Io0.g(AbstractC5254Io0.d(this.a));
        }

        @Override // ir.nasim.N23
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(e(), null, options);
        }

        @Override // ir.nasim.N23
        public int c() {
            return com.bumptech.glide.load.a.c(this.b, AbstractC5254Io0.d(this.a), this.c);
        }

        @Override // ir.nasim.N23
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.g(this.b, AbstractC5254Io0.d(this.a));
        }

        @Override // ir.nasim.N23
        public void b() {
        }
    }

    public static final class c implements N23 {
        private final LJ a;
        private final List b;
        private final ParcelFileDescriptorRewinder c;

        c(ParcelFileDescriptor parcelFileDescriptor, List list, LJ lj) {
            this.a = (LJ) AbstractC3322Aj5.d(lj);
            this.b = (List) AbstractC3322Aj5.d(list);
            this.c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // ir.nasim.N23
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.c.c().getFileDescriptor(), null, options);
        }

        @Override // ir.nasim.N23
        public int c() {
            return com.bumptech.glide.load.a.a(this.b, this.c, this.a);
        }

        @Override // ir.nasim.N23
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.e(this.b, this.c, this.a);
        }

        @Override // ir.nasim.N23
        public void b() {
        }
    }
}
