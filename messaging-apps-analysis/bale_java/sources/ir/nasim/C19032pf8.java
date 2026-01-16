package ir.nasim;

import android.app.Activity;
import android.content.Intent;

/* renamed from: ir.nasim.pf8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C19032pf8 extends Cf8 {
    final /* synthetic */ Intent a;
    final /* synthetic */ Activity b;
    final /* synthetic */ int c;

    C19032pf8(Intent intent, Activity activity, int i) {
        this.a = intent;
        this.b = activity;
        this.c = i;
    }

    @Override // ir.nasim.Cf8
    public final void a() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.c);
        }
    }
}
