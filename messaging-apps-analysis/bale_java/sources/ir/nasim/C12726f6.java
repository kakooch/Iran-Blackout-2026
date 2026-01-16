package ir.nasim;

import android.app.Activity;
import android.app.Application;
import androidx.activity.ComponentActivity;

/* renamed from: ir.nasim.f6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C12726f6 implements LE2 {
    private volatile Object a;
    private final Object b = new Object();
    protected final Activity c;
    private final LE2 d;

    /* renamed from: ir.nasim.f6$a */
    public interface a {
        InterfaceC12135e6 a();
    }

    public C12726f6(Activity activity) {
        this.c = activity;
        this.d = new E6((ComponentActivity) activity);
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

    protected Object a() {
        String str;
        if (this.c.getApplication() instanceof LE2) {
            return ((a) D92.a(this.d, a.class)).a().b(this.c).a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Hilt Activity must be attached to an @HiltAndroidApp Application. ");
        if (Application.class.equals(this.c.getApplication().getClass())) {
            str = "Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?";
        } else {
            str = "Found: " + this.c.getApplication().getClass();
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    public final C6317Nb6 b() {
        return ((E6) this.d).c();
    }
}
