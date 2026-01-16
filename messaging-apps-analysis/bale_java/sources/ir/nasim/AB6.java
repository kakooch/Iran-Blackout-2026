package ir.nasim;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class AB6 implements InterfaceC24779zB6 {
    private final Context a;

    public AB6(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    @Override // ir.nasim.InterfaceC24779zB6
    public void a() {
        Context context = this.a;
        Intent intentA = AbstractC14497i10.a(C14009hB6.a, context);
        intentA.addFlags(268435456);
        context.startActivity(intentA);
    }
}
