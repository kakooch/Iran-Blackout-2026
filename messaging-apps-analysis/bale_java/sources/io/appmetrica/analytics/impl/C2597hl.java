package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import ir.nasim.AbstractC13042fc3;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: io.appmetrica.analytics.impl.hl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2597hl implements InterfaceC2668kl {
    public volatile C2549fl a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC2668kl
    public final void a(C2549fl c2549fl) {
        this.a = c2549fl;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((InterfaceC2668kl) it.next()).a(c2549fl);
        }
    }

    public final void b(InterfaceC2668kl interfaceC2668kl) {
        this.b.remove(interfaceC2668kl);
    }

    public final void b(Context context) {
        String strOptStringOrNull;
        ProtobufStateStorage<Object> protobufStateStorageA = Ql.a(C2644jl.class).a(context);
        sn snVarA = C2586ha.h().A().a();
        synchronized (snVarA) {
            strOptStringOrNull = JsonUtils.optStringOrNull(snVarA.a.a(), "device_id");
        }
        a(new C2549fl(strOptStringOrNull, snVarA.a(), (C2644jl) protobufStateStorageA.read()));
    }

    public final C2549fl a() {
        C2549fl c2549fl = this.a;
        if (c2549fl != null) {
            return c2549fl;
        }
        AbstractC13042fc3.y("startupState");
        return null;
    }

    public final void a(InterfaceC2668kl interfaceC2668kl) {
        this.b.add(interfaceC2668kl);
        if (this.a != null) {
            C2549fl c2549fl = this.a;
            if (c2549fl == null) {
                AbstractC13042fc3.y("startupState");
                c2549fl = null;
            }
            interfaceC2668kl.a(c2549fl);
        }
    }
}
