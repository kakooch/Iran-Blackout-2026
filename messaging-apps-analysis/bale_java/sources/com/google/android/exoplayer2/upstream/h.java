package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import ir.nasim.AbstractC20011rK;
import ir.nasim.InterfaceC25209zu7;

/* loaded from: classes2.dex */
public final class h extends HttpDataSource.a {
    private final String b;
    private final InterfaceC25209zu7 c;
    private final int d;
    private final int e;
    private final boolean f;

    public h(String str, InterfaceC25209zu7 interfaceC25209zu7) {
        this(str, interfaceC25209zu7, 8000, 8000, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e c(HttpDataSource.b bVar) {
        e eVar = new e(this.b, this.d, this.e, this.f, bVar);
        InterfaceC25209zu7 interfaceC25209zu7 = this.c;
        if (interfaceC25209zu7 != null) {
            eVar.i(interfaceC25209zu7);
        }
        return eVar;
    }

    public h(String str, InterfaceC25209zu7 interfaceC25209zu7, int i, int i2, boolean z) {
        this.b = AbstractC20011rK.d(str);
        this.c = interfaceC25209zu7;
        this.d = i;
        this.e = i2;
        this.f = z;
    }
}
