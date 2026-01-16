package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Nj8 {
    private final Context a;

    public Nj8(Context context) {
        this.a = context;
    }

    private final SharedPreferences c() {
        return this.a.getSharedPreferences("playcore_split_install_internal", 0);
    }

    public final Set a() {
        Set<String> hashSet;
        synchronized (Nj8.class) {
            try {
                hashSet = c().getStringSet("modules_to_uninstall_if_emulated", new HashSet());
            } catch (Exception unused) {
                hashSet = new HashSet<>();
            }
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
        }
        return hashSet;
    }

    public final void b() {
        synchronized (Nj8.class) {
            c().edit().putStringSet("modules_to_uninstall_if_emulated", new HashSet()).apply();
        }
    }
}
