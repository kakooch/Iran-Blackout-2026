package ir.nasim;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import ir.nasim.features.media.components.Size;

/* renamed from: ir.nasim.oo7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C18530oo7 {
    private Bitmap a;
    private int b;

    public C18530oo7(Bitmap bitmap) {
        this.a = bitmap;
    }

    public static int b(Size size) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, (int) size.width, (int) size.height, 0, 6408, 5121, null);
        return i;
    }

    private boolean c(int i) {
        return (i & (i + (-1))) == 0;
    }

    public void a(boolean z) {
        int i = this.b;
        if (i == 0) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        this.b = 0;
        if (z) {
            this.a.recycle();
        }
    }

    public int d() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        if (this.a.isRecycled()) {
            return 0;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        this.b = i2;
        GLES20.glBindTexture(3553, i2);
        boolean z = c(this.a.getWidth()) && c(this.a.getHeight());
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, z ? 9987 : 9729);
        GLUtils.texImage2D(3553, 0, this.a, 0);
        if (z) {
            GLES20.glGenerateMipmap(3553);
        }
        AbstractC17682nN7.a();
        return this.b;
    }
}
