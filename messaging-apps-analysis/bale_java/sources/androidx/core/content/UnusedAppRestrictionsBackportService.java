package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import ir.nasim.C17583nC7;
import ir.nasim.InterfaceC16279l03;
import ir.nasim.InterfaceC16870m03;

/* loaded from: classes2.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {
    private InterfaceC16870m03.a a = new a();

    class a extends InterfaceC16870m03.a {
        a() {
        }

        @Override // ir.nasim.InterfaceC16870m03
        public void o1(InterfaceC16279l03 interfaceC16279l03) {
            if (interfaceC16279l03 == null) {
                return;
            }
            UnusedAppRestrictionsBackportService.this.a(new C17583nC7(interfaceC16279l03));
        }
    }

    protected abstract void a(C17583nC7 c17583nC7);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a;
    }
}
