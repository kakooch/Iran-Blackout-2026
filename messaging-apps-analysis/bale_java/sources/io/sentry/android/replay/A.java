package io.sentry.android.replay;

import android.view.View;
import android.view.Window;
import ir.nasim.AbstractC13042fc3;

/* loaded from: classes3.dex */
public abstract class A {
    public static final Window a(View view) {
        AbstractC13042fc3.i(view, "<this>");
        z zVar = z.a;
        View rootView = view.getRootView();
        AbstractC13042fc3.h(rootView, "rootView");
        return zVar.d(rootView);
    }
}
