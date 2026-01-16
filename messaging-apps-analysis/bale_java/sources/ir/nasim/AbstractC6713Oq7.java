package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Oq7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6713Oq7 {
    private static final InterfaceC9173Yu3 a = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Nq7
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return AbstractC6713Oq7.b();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap b() {
        return new HashMap();
    }

    public static final void c() {
        e().clear();
    }

    public static final Drawable d(Context context, int i, int i2) {
        AbstractC13042fc3.i(context, "context");
        Pair pair = new Pair(Integer.valueOf(i), Integer.valueOf(i2));
        Object obj = e().get(pair);
        if (obj == null) {
            Drawable drawableF = AbstractC4043Dl1.f(context, i);
            if (drawableF != null) {
                drawableF.mutate();
                AbstractC21710u02.h(drawableF, i2);
                e().put(pair, drawableF);
            } else {
                drawableF = null;
            }
            obj = drawableF;
        }
        return (Drawable) obj;
    }

    private static final Map e() {
        return (Map) a.getValue();
    }
}
