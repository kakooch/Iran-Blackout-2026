package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.e;
import ir.nasim.InterfaceC25209zu7;

/* loaded from: classes2.dex */
public final class d implements a.InterfaceC0163a {
    private final Context a;
    private final InterfaceC25209zu7 b;
    private final a.InterfaceC0163a c;

    public d(Context context, String str) {
        this(context, str, (InterfaceC25209zu7) null);
    }

    @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0163a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a() {
        c cVar = new c(this.a, this.c.a());
        InterfaceC25209zu7 interfaceC25209zu7 = this.b;
        if (interfaceC25209zu7 != null) {
            cVar.i(interfaceC25209zu7);
        }
        return cVar;
    }

    public d(Context context, String str, InterfaceC25209zu7 interfaceC25209zu7) {
        this(context, interfaceC25209zu7, new e.b().c(str));
    }

    public d(Context context, InterfaceC25209zu7 interfaceC25209zu7, a.InterfaceC0163a interfaceC0163a) {
        this.a = context.getApplicationContext();
        this.b = interfaceC25209zu7;
        this.c = interfaceC0163a;
    }
}
