package io.livekit.android.room.track.screencapture;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.livekit.android.room.track.screencapture.ScreenCaptureService;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14251hc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.C19938rB7;
import ir.nasim.C9475a16;
import ir.nasim.IE0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.UI3;
import ir.nasim.WA1;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class a {
    private final Context a;
    private boolean b;
    private ScreenCaptureService c;
    private final Set d;
    private final ServiceConnection e;

    /* renamed from: io.livekit.android.room.track.screencapture.a$a, reason: collision with other inner class name */
    public static final class ServiceConnectionC0229a implements ServiceConnection {
        ServiceConnectionC0229a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AbstractC13042fc3.i(componentName, "name");
            AbstractC13042fc3.i(iBinder, "binder");
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.k(null, "Screen capture service is connected", new Object[0]);
            }
            a.this.c = ((ScreenCaptureService.b) iBinder).a();
            a.this.f();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AbstractC13042fc3.i(componentName, "name");
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.k(null, "Screen capture service is disconnected", new Object[0]);
            }
            a.this.b = false;
            a.this.c = null;
        }
    }

    public a(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        this.d = new LinkedHashSet();
        this.e = new ServiceConnectionC0229a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        synchronized (this) {
            try {
                this.b = true;
                for (InterfaceC20295rm1 interfaceC20295rm1 : this.d) {
                    C9475a16.a aVar = C9475a16.b;
                    interfaceC20295rm1.resumeWith(C9475a16.b(C19938rB7.a));
                }
                this.d.clear();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object e(InterfaceC20295rm1 interfaceC20295rm1) {
        if (this.b) {
            return C19938rB7.a;
        }
        this.a.bindService(new Intent(this.a, (Class<?>) ScreenCaptureService.class), this.e, 1);
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        synchronized (this) {
            try {
                if (g()) {
                    C9475a16.a aVar = C9475a16.b;
                    ie0.resumeWith(C9475a16.b(C19938rB7.a));
                } else {
                    this.d.add(ie0);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    public final boolean g() {
        return this.b;
    }

    public final void h(Integer num, Notification notification) {
        ScreenCaptureService screenCaptureService = this.c;
        if (screenCaptureService != null) {
            screenCaptureService.b(num, notification);
        }
    }

    public final void i() {
        if (this.b) {
            this.a.unbindService(this.e);
        }
        this.c = null;
        this.b = false;
    }
}
