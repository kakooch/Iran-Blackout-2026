package ja.burhanrashid52.photoeditor;

import android.graphics.PointF;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0007"}, d2 = {"Lja/burhanrashid52/photoeditor/Vector2D;", "Landroid/graphics/PointF;", "<init>", "()V", "Lir/nasim/rB7;", "b", "a", "photoeditor_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public final class Vector2D extends PointF {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: ja.burhanrashid52.photoeditor.Vector2D$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final float a(Vector2D vector2D, Vector2D vector2D2) {
            AbstractC13042fc3.i(vector2D, "vector1");
            AbstractC13042fc3.i(vector2D2, "vector2");
            vector2D.b();
            vector2D2.b();
            return (float) ((Math.atan2(((PointF) vector2D2).y, ((PointF) vector2D2).x) - Math.atan2(((PointF) vector2D).y, ((PointF) vector2D).x)) * 57.29577951308232d);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        float f = ((PointF) this).x;
        float f2 = ((PointF) this).y;
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        ((PointF) this).x /= fSqrt;
        ((PointF) this).y /= fSqrt;
    }
}
