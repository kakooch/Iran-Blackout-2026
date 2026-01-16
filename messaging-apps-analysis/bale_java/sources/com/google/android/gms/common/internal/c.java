package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C23773xV0;
import ir.nasim.InterfaceC17823nd1;
import ir.nasim.ZI4;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public abstract class c extends b implements a.f {
    private final C23773xV0 J;
    private final Set Y;
    private final Account Z;

    protected c(Context context, Looper looper, int i, C23773xV0 c23773xV0, c.a aVar, c.b bVar) {
        this(context, looper, i, c23773xV0, (InterfaceC17823nd1) aVar, (ZI4) bVar);
    }

    private final Set l0(Set set) {
        Set setK0 = k0(set);
        Iterator it = setK0.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setK0;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Set C() {
        return this.Y;
    }

    protected final C23773xV0 j0() {
        return this.J;
    }

    @Override // com.google.android.gms.common.api.a.f
    public Set k() {
        return i() ? this.Y : Collections.emptySet();
    }

    protected Set k0(Set set) {
        return set;
    }

    @Override // com.google.android.gms.common.internal.b
    public final Account u() {
        return this.Z;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Executor w() {
        return null;
    }

    protected c(Context context, Looper looper, int i, C23773xV0 c23773xV0, InterfaceC17823nd1 interfaceC17823nd1, ZI4 zi4) {
        this(context, looper, d.a(context), com.google.android.gms.common.a.m(), i, c23773xV0, (InterfaceC17823nd1) AbstractC3795Cj5.j(interfaceC17823nd1), (ZI4) AbstractC3795Cj5.j(zi4));
    }

    protected c(Context context, Looper looper, d dVar, com.google.android.gms.common.a aVar, int i, C23773xV0 c23773xV0, InterfaceC17823nd1 interfaceC17823nd1, ZI4 zi4) {
        super(context, looper, dVar, aVar, i, interfaceC17823nd1 == null ? null : new f(interfaceC17823nd1), zi4 == null ? null : new g(zi4), c23773xV0.j());
        this.J = c23773xV0;
        this.Z = c23773xV0.a();
        this.Y = l0(c23773xV0.d());
    }
}
