package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import ir.nasim.AbstractC20446s15;
import ir.nasim.AbstractC8958Xy7;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes2.dex */
public class PatternPathMotion extends PathMotion {
    private Path a;
    private final Path b = new Path();
    private final Matrix c = new Matrix();

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.k);
        try {
            String strI = AbstractC8958Xy7.i(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (strI == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            c(AbstractC20446s15.d(strI));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private static float b(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float fB = b(f5, f6);
        double dAtan2 = Math.atan2(f6, f5);
        this.c.setScale(fB, fB);
        this.c.postRotate((float) Math.toDegrees(dAtan2));
        this.c.postTranslate(f, f2);
        Path path = new Path();
        this.b.transform(this.c, path);
        return path;
    }

    public void c(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.c.setTranslate(-f3, -f4);
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fB = 1.0f / b(f5, f6);
        this.c.postScale(fB, fB);
        this.c.postRotate((float) Math.toDegrees(-Math.atan2(f6, f5)));
        path.transform(this.c, this.b);
        this.a = path;
    }
}
