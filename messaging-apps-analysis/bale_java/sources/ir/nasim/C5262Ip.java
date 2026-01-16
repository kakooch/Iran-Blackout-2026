package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.util.Log;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Ip, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5262Ip implements GI3 {
    public static final C5262Ip a = new C5262Ip();

    private C5262Ip() {
    }

    @Override // ir.nasim.GI3
    public void a(String str, String str2) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        Log.d(str, str2);
    }
}
