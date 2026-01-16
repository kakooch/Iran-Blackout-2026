package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.f;
import androidx.camera.core.internal.utils.ImageUtil;
import ir.nasim.C16051kd2;
import java.nio.ByteBuffer;
import java.util.Objects;

/* renamed from: ir.nasim.i26, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14513i26 implements androidx.camera.core.f {
    private final Object a;
    private final int b;
    private final int c;
    private final Rect d;
    f.a[] e;
    private final W13 f;

    /* renamed from: ir.nasim.i26$a */
    class a implements f.a {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ ByteBuffer c;

        a(int i, int i2, ByteBuffer byteBuffer) {
            this.a = i;
            this.b = i2;
            this.c = byteBuffer;
        }

        @Override // androidx.camera.core.f.a
        public int a() {
            return this.a;
        }

        @Override // androidx.camera.core.f.a
        public int b() {
            return this.b;
        }

        @Override // androidx.camera.core.f.a
        public ByteBuffer getBuffer() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.i26$b */
    class b implements W13 {
        final /* synthetic */ long a;
        final /* synthetic */ int b;
        final /* synthetic */ Matrix c;

        b(long j, int i, Matrix matrix) {
            this.a = j;
            this.b = i;
            this.c = matrix;
        }

        @Override // ir.nasim.W13
        public void a(C16051kd2.b bVar) {
            throw new UnsupportedOperationException("Custom ImageProxy does not contain Exif data.");
        }

        @Override // ir.nasim.W13
        public C14935ij7 b() {
            throw new UnsupportedOperationException("Custom ImageProxy does not contain TagBundle");
        }

        @Override // ir.nasim.W13
        public long getTimestamp() {
            return this.a;
        }
    }

    public C14513i26(PS4 ps4) {
        this((Bitmap) ps4.c(), ps4.b(), ps4.f(), ps4.g(), ps4.a().getTimestamp());
    }

    private void a() {
        synchronized (this.a) {
            AbstractC4980Hj5.j(this.e != null, "The image is closed.");
        }
    }

    private static W13 b(long j, int i, Matrix matrix) {
        return new b(j, i, matrix);
    }

    private static f.a c(ByteBuffer byteBuffer, int i, int i2) {
        return new a(i, i2, byteBuffer);
    }

    @Override // androidx.camera.core.f
    public int C() {
        synchronized (this.a) {
            a();
        }
        return 1;
    }

    @Override // androidx.camera.core.f
    public Image F1() {
        synchronized (this.a) {
            a();
        }
        return null;
    }

    @Override // androidx.camera.core.f
    public f.a[] P0() {
        f.a[] aVarArr;
        synchronized (this.a) {
            a();
            f.a[] aVarArr2 = this.e;
            Objects.requireNonNull(aVarArr2);
            aVarArr = aVarArr2;
        }
        return aVarArr;
    }

    @Override // androidx.camera.core.f, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            a();
            this.e = null;
        }
    }

    @Override // androidx.camera.core.f
    public int getHeight() {
        int i;
        synchronized (this.a) {
            a();
            i = this.c;
        }
        return i;
    }

    @Override // androidx.camera.core.f
    public int getWidth() {
        int i;
        synchronized (this.a) {
            a();
            i = this.b;
        }
        return i;
    }

    @Override // androidx.camera.core.f
    public W13 u1() {
        W13 w13;
        synchronized (this.a) {
            a();
            w13 = this.f;
        }
        return w13;
    }

    @Override // androidx.camera.core.f
    public void y0(Rect rect) {
        synchronized (this.a) {
            try {
                a();
                if (rect != null) {
                    this.d.set(rect);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C14513i26(Bitmap bitmap, Rect rect, int i, Matrix matrix, long j) {
        this(ImageUtil.d(bitmap), 4, bitmap.getWidth(), bitmap.getHeight(), rect, i, matrix, j);
    }

    public C14513i26(ByteBuffer byteBuffer, int i, int i2, int i3, Rect rect, int i4, Matrix matrix, long j) {
        this.a = new Object();
        this.b = i2;
        this.c = i3;
        this.d = rect;
        this.f = b(j, i4, matrix);
        byteBuffer.rewind();
        this.e = new f.a[]{c(byteBuffer, i2 * i, i)};
    }
}
