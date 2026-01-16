package ir.nasim;

import android.util.Log;

/* renamed from: ir.nasim.Hp, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C5028Hp extends MI3 {
    String a;

    public C5028Hp(String str) {
        this.a = str;
    }

    @Override // ir.nasim.MI3
    public void b(String str) {
        Log.d("isoparser", String.valueOf(this.a) + ":" + str);
    }
}
