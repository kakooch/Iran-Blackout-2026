package io.appmetrica.analytics.impl;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.util.SparseArray;

/* renamed from: io.appmetrica.analytics.impl.vj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2929vj extends AbstractC2826rc {
    public final sn a;

    public C2929vj() {
        this(C2586ha.h().A().b());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2826rc
    public final void a(int i) {
        sn snVar = this.a;
        synchronized (snVar) {
            un unVar = snVar.a;
            unVar.a(unVar.a().put("last_migration_api_level", i));
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2826rc
    public final int b() {
        int iOptInt;
        sn snVar = this.a;
        synchronized (snVar) {
            iOptInt = snVar.a.a().optInt("last_migration_api_level", -1);
        }
        return iOptInt;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2826rc
    public final SparseArray<C2953wj> c() {
        SparseArray<C2953wj> sparseArray = new SparseArray<>(1);
        sparseArray.put(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, new C2953wj(this.a));
        return sparseArray;
    }

    public C2929vj(sn snVar) {
        this.a = snVar;
    }
}
