package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import ir.nasim.AZ2;
import ir.nasim.ZZ2;

/* loaded from: classes.dex */
public class PostMessageService extends Service {
    private ZZ2.a a = new a();

    class a extends ZZ2.a {
        a() {
        }

        @Override // ir.nasim.ZZ2
        public void U0(AZ2 az2, String str, Bundle bundle) {
            az2.q2(str, bundle);
        }

        @Override // ir.nasim.ZZ2
        public void w2(AZ2 az2, Bundle bundle) {
            az2.t2(bundle);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a;
    }
}
