package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import ir.nasim.C15990kW7;

/* renamed from: ir.nasim.Kx2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C5805Kx2 implements LE2 {
    private volatile Object a;
    private final Object b = new Object();
    private final Fragment c;

    /* renamed from: ir.nasim.Kx2$a */
    public interface a {
        InterfaceC5571Jx2 v();
    }

    public C5805Kx2(Fragment fragment) {
        this.c = fragment;
    }

    private Object a() {
        AbstractC4497Fj5.c(this.c.P5(), "Hilt Fragments must be attached before creating the component.");
        AbstractC4497Fj5.d(this.c.P5() instanceof LE2, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", this.c.P5().getClass());
        e(this.c);
        return ((a) D92.a(this.c.P5(), a.class)).v().b(this.c).a();
    }

    public static ContextWrapper b(Context context, Fragment fragment) {
        return new C15990kW7.a(context, fragment);
    }

    public static ContextWrapper c(LayoutInflater layoutInflater, Fragment fragment) {
        return new C15990kW7.a(layoutInflater, fragment);
    }

    public static final Context d(Context context) {
        while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    @Override // ir.nasim.LE2
    public Object N2() {
        if (this.a == null) {
            synchronized (this.b) {
                try {
                    if (this.a == null) {
                        this.a = a();
                    }
                } finally {
                }
            }
        }
        return this.a;
    }

    protected void e(Fragment fragment) {
    }
}
