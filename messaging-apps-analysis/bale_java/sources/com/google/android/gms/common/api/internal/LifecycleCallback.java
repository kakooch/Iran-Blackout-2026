package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C12069dz3;
import ir.nasim.FragmentC21550tj8;
import ir.nasim.InterfaceC16269kz3;
import ir.nasim.Tl8;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class LifecycleCallback {
    protected final InterfaceC16269kz3 a;

    protected LifecycleCallback(InterfaceC16269kz3 interfaceC16269kz3) {
        this.a = interfaceC16269kz3;
    }

    public static InterfaceC16269kz3 c(Activity activity) {
        return d(new C12069dz3(activity));
    }

    protected static InterfaceC16269kz3 d(C12069dz3 c12069dz3) {
        if (c12069dz3.d()) {
            return Tl8.t8(c12069dz3.b());
        }
        if (c12069dz3.c()) {
            return FragmentC21550tj8.c(c12069dz3.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @Keep
    private static InterfaceC16269kz3 getChimeraLifecycleFragmentImpl(C12069dz3 c12069dz3) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity b() {
        Activity activityO3 = this.a.O3();
        AbstractC3795Cj5.j(activityO3);
        return activityO3;
    }

    public void e(int i, int i2, Intent intent) {
    }

    public void f(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Bundle bundle) {
    }

    public void j() {
    }

    public void k() {
    }
}
