package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Shader;
import java.util.List;

/* renamed from: ir.nasim.dq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11956dq {
    public static final void a(C24522yl4 c24522yl4, UE0 ue0, AbstractC12520el0 abstractC12520el0, float f, C5566Jw6 c5566Jw6, C24525yl7 c24525yl7, AbstractC18051o02 abstractC18051o02, int i) {
        ue0.n();
        if (c24522yl4.z().size() <= 1 || (abstractC12520el0 instanceof CH6)) {
            b(c24522yl4, ue0, abstractC12520el0, f, c5566Jw6, c24525yl7, abstractC18051o02, i);
        } else if (abstractC12520el0 instanceof AbstractC4147Dw6) {
            List listZ = c24522yl4.z();
            int size = listZ.size();
            float fMax = 0.0f;
            float height = 0.0f;
            for (int i2 = 0; i2 < size; i2++) {
                C10971cW4 c10971cW4 = (C10971cW4) listZ.get(i2);
                height += c10971cW4.e().getHeight();
                fMax = Math.max(fMax, c10971cW4.e().getWidth());
            }
            Shader shaderB = ((AbstractC4147Dw6) abstractC12520el0).b(OD6.d((Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(height) & 4294967295L)));
            Matrix matrix = new Matrix();
            shaderB.getLocalMatrix(matrix);
            List listZ2 = c24522yl4.z();
            int size2 = listZ2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                C10971cW4 c10971cW42 = (C10971cW4) listZ2.get(i3);
                c10971cW42.e().f(ue0, AbstractC14340hl0.a(shaderB), f, c5566Jw6, c24525yl7, abstractC18051o02, i);
                ue0.c(0.0f, c10971cW42.e().getHeight());
                matrix.setTranslate(0.0f, -c10971cW42.e().getHeight());
                shaderB.setLocalMatrix(matrix);
            }
        }
        ue0.i();
    }

    private static final void b(C24522yl4 c24522yl4, UE0 ue0, AbstractC12520el0 abstractC12520el0, float f, C5566Jw6 c5566Jw6, C24525yl7 c24525yl7, AbstractC18051o02 abstractC18051o02, int i) {
        List listZ = c24522yl4.z();
        int size = listZ.size();
        for (int i2 = 0; i2 < size; i2++) {
            C10971cW4 c10971cW4 = (C10971cW4) listZ.get(i2);
            c10971cW4.e().f(ue0, abstractC12520el0, f, c5566Jw6, c24525yl7, abstractC18051o02, i);
            ue0.c(0.0f, c10971cW4.e().getHeight());
        }
    }
}
