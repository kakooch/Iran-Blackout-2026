package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.internal.utils.ImageUtil;
import ir.nasim.C11982ds5;
import ir.nasim.QB0;
import java.io.IOException;

/* renamed from: ir.nasim.Ur5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C8139Ur5 implements InterfaceC15888kL4 {
    C8139Ur5() {
    }

    private static PS4 b(AbstractC12595es5 abstractC12595es5, C14871id2 c14871id2, androidx.camera.core.f fVar) {
        return PS4.k(fVar, c14871id2, abstractC12595es5.b(), abstractC12595es5.f(), abstractC12595es5.g(), d(fVar));
    }

    private static PS4 c(AbstractC12595es5 abstractC12595es5, C14871id2 c14871id2, androidx.camera.core.f fVar) {
        Size size = new Size(fVar.getWidth(), fVar.getHeight());
        int iF = abstractC12595es5.f() - c14871id2.n();
        Size sizeE = e(iF, size);
        Matrix matrixD = AbstractC14447hv7.d(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), new RectF(0.0f, 0.0f, sizeE.getWidth(), sizeE.getHeight()), iF);
        return PS4.l(fVar, c14871id2, sizeE, f(abstractC12595es5.b(), matrixD), c14871id2.n(), g(abstractC12595es5.g(), matrixD), d(fVar));
    }

    private static QB0 d(androidx.camera.core.f fVar) {
        return fVar.u1() instanceof RB0 ? ((RB0) fVar.u1()).c() : QB0.a.h();
    }

    private static Size e(int i, Size size) {
        return AbstractC14447hv7.i(AbstractC14447hv7.u(i)) ? new Size(size.getHeight(), size.getWidth()) : size;
    }

    private static Rect f(Rect rect, Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        rectF.sort();
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    private static Matrix g(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.postConcat(matrix2);
        return matrix3;
    }

    @Override // ir.nasim.InterfaceC15888kL4
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PS4 apply(C11982ds5.b bVar) throws ImageCaptureException {
        C14871id2 c14871id2G;
        androidx.camera.core.f fVarA = bVar.a();
        AbstractC12595es5 abstractC12595es5B = bVar.b();
        if (ImageUtil.g(fVarA.C())) {
            try {
                c14871id2G = C14871id2.g(fVarA);
                fVarA.P0()[0].getBuffer().rewind();
            } catch (IOException e) {
                throw new ImageCaptureException(1, "Failed to extract EXIF data.", e);
            }
        } else {
            c14871id2G = null;
        }
        if (!E23.f.b(fVarA)) {
            return b(abstractC12595es5B, c14871id2G, fVarA);
        }
        AbstractC4980Hj5.h(c14871id2G, "JPEG image must have exif.");
        return c(abstractC12595es5B, c14871id2G, fVarA);
    }
}
