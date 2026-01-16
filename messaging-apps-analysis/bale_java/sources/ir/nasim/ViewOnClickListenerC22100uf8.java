package ir.nasim;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* renamed from: ir.nasim.uf8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class ViewOnClickListenerC22100uf8 implements View.OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;

    ViewOnClickListenerC22100uf8(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.a.startActivity(this.b);
        } catch (ActivityNotFoundException e) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
        }
    }
}
