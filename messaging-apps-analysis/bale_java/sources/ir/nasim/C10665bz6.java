package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

/* renamed from: ir.nasim.bz6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10665bz6 implements InterfaceC6201Mp3 {
    private final SharedPreferences.Editor a;
    private final String b;

    public C10665bz6(Context context, String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
        this.b = str;
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.a = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.a = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }

    @Override // ir.nasim.InterfaceC6201Mp3
    public void a(C5032Hp3 c5032Hp3) throws IOException {
        if (!this.a.putString(this.b, AbstractC21999uV2.b(c5032Hp3.f())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // ir.nasim.InterfaceC6201Mp3
    public void b(C13976h82 c13976h82) throws IOException {
        if (!this.a.putString(this.b, AbstractC21999uV2.b(c13976h82.f())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
