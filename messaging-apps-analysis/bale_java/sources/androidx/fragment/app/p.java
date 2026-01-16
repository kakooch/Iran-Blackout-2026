package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC6771Ox2;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public abstract class p extends AbstractC6771Ox2 {
    private final Activity a;
    private final Context b;
    private final Handler c;
    private final int d;
    private final FragmentManager e;

    public p(Activity activity, Context context, Handler handler, int i) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(handler, "handler");
        this.a = activity;
        this.b = context;
        this.c = handler;
        this.d = i;
        this.e = new s();
    }

    public final Activity j() {
        return this.a;
    }

    public final Context k() {
        return this.b;
    }

    public final FragmentManager m() {
        return this.e;
    }

    public final Handler n() {
        return this.c;
    }

    public abstract void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object q();

    public abstract LayoutInflater r();

    public void s(Fragment fragment, String[] strArr, int i) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(strArr, "permissions");
    }

    public abstract boolean u(String str);

    public void v(Fragment fragment, Intent intent, int i, Bundle bundle) {
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(intent, "intent");
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host".toString());
        }
        AbstractC4043Dl1.o(this.b, intent, bundle);
    }

    public abstract void x();

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
        AbstractC13042fc3.i(fragmentActivity, "activity");
    }
}
