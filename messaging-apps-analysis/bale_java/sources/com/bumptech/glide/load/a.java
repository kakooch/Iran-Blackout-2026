package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import ir.nasim.AbstractC5254Io0;
import ir.nasim.LJ;
import ir.nasim.OK5;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: com.bumptech.glide.load.a$a, reason: collision with other inner class name */
    class C0145a implements h {
        final /* synthetic */ InputStream a;

        C0145a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.d(this.a);
            } finally {
                this.a.reset();
            }
        }
    }

    class b implements h {
        final /* synthetic */ ByteBuffer a;

        b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.c(this.a);
            } finally {
                AbstractC5254Io0.d(this.a);
            }
        }
    }

    class c implements h {
        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ LJ b;

        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, LJ lj) {
            this.a = parcelFileDescriptorRewinder;
            this.b = lj;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            OK5 ok5 = null;
            try {
                OK5 ok52 = new OK5(new FileInputStream(this.a.c().getFileDescriptor()), this.b);
                try {
                    ImageHeaderParser.ImageType imageTypeD = imageHeaderParser.d(ok52);
                    ok52.c();
                    this.a.c();
                    return imageTypeD;
                } catch (Throwable th) {
                    th = th;
                    ok5 = ok52;
                    if (ok5 != null) {
                        ok5.c();
                    }
                    this.a.c();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    class d implements g {
        final /* synthetic */ ByteBuffer a;
        final /* synthetic */ LJ b;

        d(ByteBuffer byteBuffer, LJ lj) {
            this.a = byteBuffer;
            this.b = lj;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.b(this.a, this.b);
            } finally {
                AbstractC5254Io0.d(this.a);
            }
        }
    }

    class e implements g {
        final /* synthetic */ InputStream a;
        final /* synthetic */ LJ b;

        e(InputStream inputStream, LJ lj) {
            this.a = inputStream;
            this.b = lj;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.a, this.b);
            } finally {
                this.a.reset();
            }
        }
    }

    class f implements g {
        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ LJ b;

        f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, LJ lj) {
            this.a = parcelFileDescriptorRewinder;
            this.b = lj;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            OK5 ok5 = null;
            try {
                OK5 ok52 = new OK5(new FileInputStream(this.a.c().getFileDescriptor()), this.b);
                try {
                    int iA = imageHeaderParser.a(ok52, this.b);
                    ok52.c();
                    this.a.c();
                    return iA;
                } catch (Throwable th) {
                    th = th;
                    ok5 = ok52;
                    if (ok5 != null) {
                        ok5.c();
                    }
                    this.a.c();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private interface g {
        int a(ImageHeaderParser imageHeaderParser);
    }

    private interface h {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, LJ lj) {
        return d(list, new f(parcelFileDescriptorRewinder, lj));
    }

    public static int b(List list, InputStream inputStream, LJ lj) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new OK5(inputStream, lj);
        }
        inputStream.mark(5242880);
        return d(list, new e(inputStream, lj));
    }

    public static int c(List list, ByteBuffer byteBuffer, LJ lj) {
        if (byteBuffer == null) {
            return -1;
        }
        return d(list, new d(byteBuffer, lj));
    }

    private static int d(List list, g gVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int iA = gVar.a((ImageHeaderParser) list.get(i));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType e(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, LJ lj) {
        return h(list, new c(parcelFileDescriptorRewinder, lj));
    }

    public static ImageHeaderParser.ImageType f(List list, InputStream inputStream, LJ lj) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new OK5(inputStream, lj);
        }
        inputStream.mark(5242880);
        return h(list, new C0145a(inputStream));
    }

    public static ImageHeaderParser.ImageType g(List list, ByteBuffer byteBuffer) {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : h(list, new b(byteBuffer));
    }

    private static ImageHeaderParser.ImageType h(List list, h hVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType imageTypeA = hVar.a((ImageHeaderParser) list.get(i));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
