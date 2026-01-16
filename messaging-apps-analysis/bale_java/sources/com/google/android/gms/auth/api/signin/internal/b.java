package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.c;
import ir.nasim.AbstractC22455vG3;
import ir.nasim.AbstractC23051wG3;
import ir.nasim.AbstractC25070zg8;
import ir.nasim.C13114fg8;

/* loaded from: classes3.dex */
final class b implements AbstractC23051wG3.a {
    final /* synthetic */ SignInHubActivity a;

    /* synthetic */ b(SignInHubActivity signInHubActivity, AbstractC25070zg8 abstractC25070zg8) {
        this.a = signInHubActivity;
    }

    @Override // ir.nasim.AbstractC23051wG3.a
    public final AbstractC22455vG3 b(int i, Bundle bundle) {
        return new C13114fg8(this.a, c.b());
    }

    @Override // ir.nasim.AbstractC23051wG3.a
    public final /* bridge */ /* synthetic */ void c(AbstractC22455vG3 abstractC22455vG3, Object obj) {
        SignInHubActivity signInHubActivity = this.a;
        signInHubActivity.setResult(signInHubActivity.H, signInHubActivity.J);
        this.a.finish();
    }

    @Override // ir.nasim.AbstractC23051wG3.a
    public final void a(AbstractC22455vG3 abstractC22455vG3) {
    }
}
