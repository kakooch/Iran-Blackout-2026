package ir.nasim;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import ir.nasim.AbstractC6718Or3;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.Pq4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6944Pq4 implements InterfaceC6710Oq4 {
    private final ConnectivityManager.NetworkCallback a;
    private final InterfaceC7188Qq4 b;
    private final AtomicBoolean c;
    private final AtomicBoolean d;

    public C6944Pq4(ConnectivityManager.NetworkCallback networkCallback, InterfaceC7188Qq4 interfaceC7188Qq4) {
        AbstractC13042fc3.i(networkCallback, "networkCallback");
        AbstractC13042fc3.i(interfaceC7188Qq4, "connectivityManager");
        this.a = networkCallback;
        this.b = interfaceC7188Qq4;
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
    }

    @Override // ir.nasim.InterfaceC6710Oq4
    public synchronized void J1() {
        if (!this.d.get() && this.c.compareAndSet(false, true)) {
            try {
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
                InterfaceC7188Qq4 interfaceC7188Qq4 = this.b;
                AbstractC13042fc3.f(networkRequestBuild);
                interfaceC7188Qq4.b(networkRequestBuild, this.a);
            } catch (Exception e) {
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.l(e, "Exception when trying to register network callback, reconnection may be impaired.", new Object[0]);
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.d.get()) {
                return;
            }
            if (this.c.get()) {
                p1();
            }
            this.d.set(true);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC6710Oq4
    public synchronized void p1() {
        if (!this.d.get() && this.c.compareAndSet(true, false)) {
            try {
                this.b.a(this.a);
            } catch (IllegalArgumentException unused) {
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.l(null, "NetworkCallback was unregistered multiple times?", new Object[0]);
                }
            }
        }
    }
}
