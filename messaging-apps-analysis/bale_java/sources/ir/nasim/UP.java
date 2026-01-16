package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import ir.nasim.auth.PickCountryActivity;
import ir.nasim.auth.auth.main.AuthActivity;
import ir.nasim.auth.auth.newlogin.IntroActivity;
import java.util.List;

/* loaded from: classes2.dex */
public final class UP implements TP {
    private final Intent h(Context context, Bundle bundle, Class cls) {
        Intent intent = new Intent(context, (Class<?>) cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    @Override // ir.nasim.TP
    public C22042ua0 a(long j, String str, List list, SQ sq, long j2, SQ sq2, long j3, String str2) {
        AbstractC13042fc3.i(str, "transactionHash");
        AbstractC13042fc3.i(list, "imeiList");
        AbstractC13042fc3.i(sq, "sentCodeType");
        AbstractC13042fc3.i(sq2, "nextSendCodeType");
        return C20064rP7.INSTANCE.a(j, str, list, sq, j2, sq2, j3, str2);
    }

    @Override // ir.nasim.TP
    public C22042ua0 c() {
        return C5798Kw4.INSTANCE.a();
    }

    @Override // ir.nasim.TP
    public InterfaceC19933rB2 d() {
        return U11.a.a();
    }

    @Override // ir.nasim.TP
    public Intent e(Context context, Bundle bundle) {
        AbstractC13042fc3.i(context, "context");
        return h(context, bundle, PickCountryActivity.class);
    }

    @Override // ir.nasim.TP
    public Intent f(Intent intent, Context context, Bundle bundle) {
        AbstractC13042fc3.i(intent, "intent");
        AbstractC13042fc3.i(context, "context");
        Intent intent2 = new Intent(intent).setClass(context, IntroActivity.class);
        AbstractC13042fc3.h(intent2, "setClass(...)");
        return intent2;
    }

    @Override // ir.nasim.TP
    public Intent g(Context context, Bundle bundle) {
        AbstractC13042fc3.i(context, "context");
        return h(context, bundle, AuthActivity.class);
    }
}
