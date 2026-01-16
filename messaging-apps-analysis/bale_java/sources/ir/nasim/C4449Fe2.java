package ir.nasim;

import android.content.Context;
import com.google.android.exoplayer2.upstream.a;

/* renamed from: ir.nasim.Fe2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C4449Fe2 implements a.InterfaceC0163a {
    private final Context a;
    private final InterfaceC25209zu7 b;
    private final a.InterfaceC0163a c;

    public C4449Fe2(Context context, String str) {
        this(context, str, (InterfaceC25209zu7) null);
    }

    @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0163a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C4215Ee2 a() {
        return new C4215Ee2(this.a, this.b, this.c.a());
    }

    public C4449Fe2(Context context, String str, InterfaceC25209zu7 interfaceC25209zu7) {
        this(context, interfaceC25209zu7, new com.google.android.exoplayer2.upstream.h(str, interfaceC25209zu7));
    }

    public C4449Fe2(Context context, InterfaceC25209zu7 interfaceC25209zu7, a.InterfaceC0163a interfaceC0163a) {
        this.a = context.getApplicationContext();
        this.b = interfaceC25209zu7;
        this.c = interfaceC0163a;
    }
}
