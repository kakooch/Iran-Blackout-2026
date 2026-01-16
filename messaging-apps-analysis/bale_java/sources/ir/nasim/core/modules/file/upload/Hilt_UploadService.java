package ir.nasim.core.modules.file.upload;

import android.app.Service;
import ir.nasim.C11352cr6;
import ir.nasim.InterfaceC22468vH7;
import ir.nasim.ME2;
import ir.nasim.SB7;

/* loaded from: classes5.dex */
public abstract class Hilt_UploadService extends Service implements ME2 {
    private volatile C11352cr6 a;
    private final Object b = new Object();
    private boolean c = false;

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // ir.nasim.ME2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C11352cr6 E4() {
        if (this.a == null) {
            synchronized (this.b) {
                try {
                    if (this.a == null) {
                        this.a = b();
                    }
                } finally {
                }
            }
        }
        return this.a;
    }

    protected C11352cr6 b() {
        return new C11352cr6(this);
    }

    protected void c() {
        if (this.c) {
            return;
        }
        this.c = true;
        ((InterfaceC22468vH7) N2()).a((UploadService) SB7.a(this));
    }

    @Override // android.app.Service
    public void onCreate() {
        c();
        super.onCreate();
    }
}
