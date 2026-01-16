package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.R;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import ir.nasim.AD4;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C22477vI7;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.F;

/* loaded from: classes7.dex */
public class StoryUploadingService extends Service implements E.d {
    private AbstractC16407lD4.e a;
    private String b;
    private float c;
    private int d = -1;

    public StoryUploadingService() {
        E.j().e(this, E.Z3);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            stopForeground(true);
        } catch (Exception unused) {
        }
        AD4.e(AbstractC14047hG.a).b(33);
        E.j().u(this, E.Z3);
        E.k(this.d).u(this, E.Y3);
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.a("upload story destroy");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.b = intent.getStringExtra("path");
        int i3 = this.d;
        int intExtra = intent.getIntExtra("currentAccount", C22477vI7.f);
        this.d = intExtra;
        if (!C22477vI7.l(intExtra)) {
            stopSelf();
            return 2;
        }
        if (i3 != this.d) {
            if (i3 != -1) {
                E.k(i3).u(this, E.Y3);
            }
            int i4 = this.d;
            if (i4 != -1) {
                E.k(i4).e(this, E.Y3);
            }
        }
        if (this.b == null) {
            stopSelf();
            return 2;
        }
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.a("start upload story");
        }
        if (this.a == null) {
            F.l();
            AbstractC16407lD4.e eVar = new AbstractC16407lD4.e(AbstractC14047hG.a);
            this.a = eVar;
            eVar.K(R.drawable.stat_sys_upload);
            this.a.S(System.currentTimeMillis());
            this.a.i(F.B0);
            this.a.n(FH3.E("AppName", TD5.tgwidget_AppName));
            this.a.O(FH3.E("StoryUploading", TD5.tgwidget_StoryUploading));
            this.a.m(FH3.E("StoryUploading", TD5.tgwidget_StoryUploading));
        }
        this.c = 0.0f;
        this.a.G(100, Math.round(0.0f * 100.0f), false);
        startForeground(33, this.a.c());
        try {
            AD4.e(AbstractC14047hG.a).g(33, this.a.c());
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
        }
        return 2;
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) {
        String str;
        if (i != E.Y3) {
            if (i == E.Z3 && (str = this.b) != null && str.equals((String) objArr[0])) {
                stopSelf();
                return;
            }
            return;
        }
        String str2 = this.b;
        if (str2 == null || !str2.equals((String) objArr[0])) {
            return;
        }
        float fFloatValue = ((Float) objArr[1]).floatValue();
        this.c = fFloatValue;
        this.a.G(100, Math.round(fFloatValue * 100.0f), this.c <= 0.0f);
        try {
            AD4.e(AbstractC14047hG.a).g(33, this.a.c());
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
        }
    }
}
