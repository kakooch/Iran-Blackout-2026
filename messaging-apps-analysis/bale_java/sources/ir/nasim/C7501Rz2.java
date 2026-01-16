package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import java.nio.ByteBuffer;

/* renamed from: ir.nasim.Rz2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C7501Rz2 {
    private final b a;
    private ByteBuffer b;
    private Bitmap c;

    /* renamed from: ir.nasim.Rz2$a */
    public static class a {
        private final C7501Rz2 a = new C7501Rz2();

        public C7501Rz2 a() {
            if (this.a.b != null || this.a.c != null) {
                return this.a;
            }
            C7501Rz2.h(this.a);
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        }

        public a b(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.a.c = bitmap;
            b bVarC = this.a.c();
            bVarC.a = width;
            bVarC.b = height;
            return this;
        }

        public a c(int i) {
            this.a.c().e = i;
            return this;
        }
    }

    /* renamed from: ir.nasim.Rz2$b */
    public static class b {
        private int a;
        private int b;
        private int c;
        private long d;
        private int e;
        private int f = -1;

        public int a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.e;
        }

        public long d() {
            return this.d;
        }

        public int e() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Rz2$c */
    private static class c {
    }

    private C7501Rz2() {
        this.a = new b();
        this.b = null;
        this.c = null;
    }

    static /* synthetic */ c h(C7501Rz2 c7501Rz2) {
        c7501Rz2.getClass();
        return null;
    }

    public Bitmap a() {
        return this.c;
    }

    public ByteBuffer b() {
        Bitmap bitmap = this.c;
        if (bitmap == null) {
            return this.b;
        }
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = this.c.getHeight();
        int i = width * height;
        this.c.getPixels(new int[i], 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((Color.red(r9[i2]) * 0.299f) + (Color.green(r9[i2]) * 0.587f) + (Color.blue(r9[i2]) * 0.114f));
        }
        return ByteBuffer.wrap(bArr);
    }

    public b c() {
        return this.a;
    }

    public Image.Plane[] d() {
        return null;
    }
}
