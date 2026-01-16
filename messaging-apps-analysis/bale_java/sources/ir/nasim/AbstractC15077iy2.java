package ir.nasim;

import android.content.Context;
import java.util.Set;

/* renamed from: ir.nasim.iy2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC15077iy2 {

    /* renamed from: ir.nasim.iy2$a */
    public interface a {
        Set X();
    }

    public static boolean a(Context context) {
        Set setX = ((a) C92.a(context, a.class)).X();
        AbstractC4497Fj5.d(setX.size() <= 1, "Cannot bind the flag @DisableFragmentGetContextFix more than once.", new Object[0]);
        if (setX.isEmpty()) {
            return true;
        }
        return ((Boolean) setX.iterator().next()).booleanValue();
    }
}
