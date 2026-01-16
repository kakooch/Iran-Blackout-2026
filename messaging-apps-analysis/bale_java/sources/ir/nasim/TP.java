package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.List;

/* loaded from: classes4.dex */
public interface TP {
    static /* synthetic */ Intent b(TP tp, Intent intent, Context context, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNewLoginActivity");
        }
        if ((i & 1) != 0) {
            intent = new Intent();
        }
        if ((i & 4) != 0) {
            bundle = null;
        }
        return tp.f(intent, context, bundle);
    }

    C22042ua0 a(long j, String str, List list, SQ sq, long j2, SQ sq2, long j3, String str2);

    C22042ua0 c();

    InterfaceC19933rB2 d();

    Intent e(Context context, Bundle bundle);

    Intent f(Intent intent, Context context, Bundle bundle);

    Intent g(Context context, Bundle bundle);
}
