package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import ir.nasim.C9475a16;
import ir.nasim.features.call.service.VibrationService;

/* loaded from: classes5.dex */
public final class U53 {
    private final Context a;
    private final AudioManager b;
    private Ringtone c;

    public U53(Context context, AudioManager audioManager) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(audioManager, "audioManager");
        this.a = context;
        this.b = audioManager;
    }

    private final Object b() {
        try {
            C9475a16.a aVar = C9475a16.b;
            if (AbstractC4043Dl1.a(this.a, "android.permission.FOREGROUND_SERVICE") == 0 && C8386Vt0.a.i7()) {
                this.a.startForegroundService(new Intent(this.a, (Class<?>) VibrationService.class));
            }
            return C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            return C9475a16.b(AbstractC10685c16.a(th));
        }
    }

    private final void d() {
        this.a.stopService(new Intent(this.a, (Class<?>) VibrationService.class));
    }

    public final void a(Uri uri) {
        AbstractC13042fc3.i(uri, "ringtoneUri");
        c();
        int ringerMode = this.b.getRingerMode();
        if (ringerMode == 1) {
            b();
            return;
        }
        if (ringerMode != 2) {
            return;
        }
        Ringtone ringtone = RingtoneManager.getRingtone(this.a, uri);
        this.c = ringtone;
        if (ringtone != null) {
            ringtone.play();
        }
        b();
    }

    public final void c() {
        Ringtone ringtone = this.c;
        if (ringtone != null) {
            ringtone.stop();
        }
        this.c = null;
        d();
    }
}
