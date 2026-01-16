package ir.nasim;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/* loaded from: classes3.dex */
public abstract class Cf8 implements DialogInterface.OnClickListener {
    public static Cf8 b(Activity activity, Intent intent, int i) {
        return new C19032pf8(intent, activity, i);
    }

    public static Cf8 c(InterfaceC16269kz3 interfaceC16269kz3, Intent intent, int i) {
        return new Bf8(intent, interfaceC16269kz3, 2);
    }

    protected abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            a();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
