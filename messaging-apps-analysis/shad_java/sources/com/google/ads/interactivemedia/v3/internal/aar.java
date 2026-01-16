package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Map;
import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aar extends abd {
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private final SparseArray<Map<vj, aat>> q;
    private final SparseBooleanArray r;

    @Deprecated
    public aar() {
        c();
        this.q = new SparseArray<>();
        this.r = new SparseBooleanArray();
    }

    private final void c() {
        this.d = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.e = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.f = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.g = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.h = true;
        this.i = true;
        this.j = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.k = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.l = true;
        this.m = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.n = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.o = true;
        this.p = true;
    }

    public final aaq a() {
        return new aaq(this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.a, this.m, this.n, this.o, this.b, this.c, this.p, this.q, this.r);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.abd
    public final /* bridge */ /* synthetic */ void b(Context context) {
        super.b(context);
    }

    public aar(Context context) throws NumberFormatException {
        b(context);
        c();
        this.q = new SparseArray<>();
        this.r = new SparseBooleanArray();
        Point pointAh = aeu.ah(context);
        int i = pointAh.x;
        int i2 = pointAh.y;
        this.j = i;
        this.k = i2;
        this.l = true;
    }
}
