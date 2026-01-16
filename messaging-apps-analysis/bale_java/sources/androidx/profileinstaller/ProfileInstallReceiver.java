package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import androidx.profileinstaller.f;
import ir.nasim.ExecutorC4596Fu5;
import java.io.IOException;

/* loaded from: classes2.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    class a implements f.c {
        a() {
        }

        @Override // androidx.profileinstaller.f.c
        public void a(int i, Object obj) {
            f.b.a(i, obj);
            ProfileInstallReceiver.this.setResultCode(i);
        }

        @Override // androidx.profileinstaller.f.c
        public void b(int i, Object obj) {
            f.b.b(i, obj);
        }
    }

    static void a(int i, f.c cVar) {
        Process.sendSignal(i, 10);
        cVar.a(12, null);
    }

    static void b(f.c cVar) {
        a(Process.myPid(), cVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws PackageManager.NameNotFoundException, IOException {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            f.k(context, new ExecutorC4596Fu5(), new a(), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if ("WRITE_SKIP_FILE".equals(string)) {
                    f.l(context, new ExecutorC4596Fu5(), new a());
                    return;
                } else {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        f.c(context, new ExecutorC4596Fu5(), new a());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            b(new a());
            return;
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
        a aVar = new a();
        if ("DROP_SHADER_CACHE".equals(string2)) {
            androidx.profileinstaller.a.b(context, aVar);
        } else if ("SAVE_PROFILE".equals(string2)) {
            a(extras.getInt("EXTRA_PID", Process.myPid()), aVar);
        } else {
            aVar.a(16, null);
        }
    }
}
