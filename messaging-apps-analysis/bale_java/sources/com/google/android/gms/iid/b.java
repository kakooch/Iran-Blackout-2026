package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.KJ;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b {
    private SharedPreferences a;
    private Context b;
    private final i c;
    private final Map d;

    public b(Context context) {
        this(context, new i());
    }

    public final boolean a() {
        return this.a.getAll().isEmpty();
    }

    public final synchronized void b(String str) {
        try {
            SharedPreferences.Editor editorEdit = this.a.edit();
            for (String str2 : this.a.getAll().keySet()) {
                if (str2.startsWith(str)) {
                    editorEdit.remove(str2);
                }
            }
            editorEdit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    final void c(String str) {
        synchronized (this) {
            this.d.remove(str);
        }
        i.a(this.b, str);
        b(String.valueOf(str).concat("|"));
    }

    public final synchronized void d() {
        this.d.clear();
        i.b(this.b);
        this.a.edit().clear().commit();
    }

    private b(Context context, i iVar) {
        this.d = new KJ();
        this.b = context;
        this.a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.c = iVar;
        File file = new File(AbstractC4043Dl1.j(this.b), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || a()) {
                return;
            }
            Log.i("InstanceID/Store", "App restored, clearing state");
            InstanceIDListenerService.d(this.b, this);
        } catch (IOException e) {
            if (Log.isLoggable("InstanceID/Store", 3)) {
                String strValueOf = String.valueOf(e.getMessage());
                Log.d("InstanceID/Store", strValueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(strValueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }
}
