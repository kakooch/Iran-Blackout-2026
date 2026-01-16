package ir.nasim;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* renamed from: ir.nasim.Fk0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C4501Fk0 implements InterfaceC3799Ck0 {
    public static final C4501Fk0 b = new C4501Fk0();

    private C4501Fk0() {
    }

    @Override // ir.nasim.InterfaceC3799Ck0
    public Rect a(Activity activity) throws Exception {
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
            AbstractC13042fc3.g(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
            return new Rect((Rect) objInvoke);
        } catch (Exception e) {
            if (e instanceof NoSuchFieldException ? true : e instanceof NoSuchMethodException ? true : e instanceof IllegalAccessException ? true : e instanceof InvocationTargetException) {
                return C4267Ek0.b.a(activity);
            }
            throw e;
        }
    }
}
