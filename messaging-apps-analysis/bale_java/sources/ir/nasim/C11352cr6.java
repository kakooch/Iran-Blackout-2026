package ir.nasim;

import android.app.Application;
import android.app.Service;

/* renamed from: ir.nasim.cr6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C11352cr6 implements LE2 {
    private final Service a;
    private Object b;

    /* renamed from: ir.nasim.cr6$a */
    public interface a {
        InterfaceC10589br6 i();
    }

    public C11352cr6(Service service) {
        this.a = service;
    }

    private Object a() {
        Application application = this.a.getApplication();
        AbstractC4497Fj5.d(application instanceof LE2, "Hilt service must be attached to an @HiltAndroidApp Application. Found: %s", application.getClass());
        return ((a) D92.a(application, a.class)).i().b(this.a).a();
    }

    @Override // ir.nasim.LE2
    public Object N2() {
        if (this.b == null) {
            this.b = a();
        }
        return this.b;
    }
}
