package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.util.Log;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.ms5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17386ms5 implements NI3 {
    private boolean a;

    public C17386ms5(boolean z) {
        this.a = z;
    }

    private final String b(String str) {
        return "AS/" + str;
    }

    @Override // ir.nasim.NI3
    public void a(String str, String str2) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        if (c()) {
            Log.d(b(str), str2);
        }
    }

    public boolean c() {
        return this.a;
    }
}
