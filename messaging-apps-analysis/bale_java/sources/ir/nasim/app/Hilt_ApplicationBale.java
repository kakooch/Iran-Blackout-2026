package ir.nasim.app;

import android.content.res.Resources;
import ir.nasim.C21852uF;
import ir.nasim.C22442vF;
import ir.nasim.InterfaceC15829kF;
import ir.nasim.InterfaceC16287l11;
import ir.nasim.ME2;
import ir.nasim.SB7;

/* loaded from: classes.dex */
public abstract class Hilt_ApplicationBale extends ApplicationCore implements ME2 {
    private boolean g = false;
    private final C21852uF h = new C21852uF(new a());

    class a implements InterfaceC16287l11 {
        a() {
        }

        @Override // ir.nasim.InterfaceC16287l11
        public Object get() {
            return ir.nasim.app.a.a().a(new C22442vF(Hilt_ApplicationBale.this)).b();
        }
    }

    @Override // ir.nasim.ME2
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final C21852uF E4() {
        return this.h;
    }

    protected void J() {
        if (this.g) {
            return;
        }
        this.g = true;
        ((InterfaceC15829kF) N2()).J((ApplicationBale) SB7.a(this));
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // ir.nasim.app.ApplicationCore, android.app.Application
    public void onCreate() throws Resources.NotFoundException, NumberFormatException {
        J();
        super.onCreate();
    }
}
