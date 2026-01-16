package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class T1 implements InterfaceC2718n {
    public final ArrayList a = new ArrayList();
    public volatile C2941w7 b = null;

    public final void a(C2941w7 c2941w7) {
        ArrayList arrayListA;
        synchronized (this) {
            this.b = c2941w7;
            arrayListA = a();
        }
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            ((InterfaceC2851sd) it.next()).consume(c2941w7);
        }
    }

    public final void b() {
        C2747o4.g().e.a(this, EnumC2694m.CREATED);
    }

    public final void c() {
        C2747o4.g().e.b(this, EnumC2694m.CREATED);
    }

    public final synchronized ArrayList a() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.a);
        this.a.clear();
        return arrayList;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2718n
    public final void a(Activity activity, EnumC2694m enumC2694m) {
        Intent intent = (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new R1());
        String dataString = intent == null ? null : intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        S1 s1 = new S1(dataString);
        synchronized (this) {
            try {
                C2941w7 c2941w7 = this.b;
                if (c2941w7 == null) {
                    this.a.add(s1);
                } else {
                    ((C2871t9) C2747o4.g().c.a()).b.post(new Q1(s1, c2941w7));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
