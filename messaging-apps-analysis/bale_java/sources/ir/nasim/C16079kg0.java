package ir.nasim;

import android.graphics.Bitmap;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: ir.nasim.kg0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16079kg0 {
    public static final C16079kg0 a = new C16079kg0();

    private C16079kg0() {
    }

    public final Bitmap a(GLSurfaceView gLSurfaceView, GL10 gl10) {
        AbstractC13042fc3.i(gLSurfaceView, "glSurfaceView");
        AbstractC13042fc3.i(gl10, "gl");
        int width = gLSurfaceView.getWidth();
        int height = gLSurfaceView.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        IntBuffer intBufferWrap = IntBuffer.wrap(iArr);
        intBufferWrap.position(0);
        try {
            gl10.glReadPixels(0, 0, width, height, 6408, 5121, intBufferWrap);
            if (height > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    int i4 = i2 * width;
                    int i5 = ((height - i2) - 1) * width;
                    if (width > 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            int i8 = iArr[i4 + i6];
                            iArr2[i6 + i5] = (i8 & (-16711936)) | ((i8 << 16) & 16711680) | ((i8 >> 16) & 255);
                            if (i7 >= width) {
                                break;
                            }
                            i6 = i7;
                        }
                    }
                    if (i3 >= height) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return Bitmap.createBitmap(iArr2, width, height, Bitmap.Config.ARGB_8888);
        } catch (GLException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0079 A[LOOP:2: B:23:0x005a->B:34:0x0079, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a3 A[LOOP:4: B:37:0x0083->B:47:0x00a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cd A[LOOP:6: B:50:0x00ad->B:60:0x00cd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x007b A[EDGE_INSN: B:66:0x007b->B:35:0x007b BREAK  A[LOOP:2: B:23:0x005a->B:34:0x0079], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a5 A[EDGE_INSN: B:70:0x00a5->B:48:0x00a5 BREAK  A[LOOP:4: B:37:0x0083->B:47:0x00a3], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cf A[EDGE_INSN: B:73:0x00cf->B:61:0x00cf BREAK  A[LOOP:6: B:50:0x00ad->B:60:0x00cd], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(android.graphics.Bitmap r13) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16079kg0.b(android.graphics.Bitmap):android.graphics.Bitmap");
    }
}
