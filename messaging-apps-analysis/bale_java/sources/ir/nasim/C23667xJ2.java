package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.xJ2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C23667xJ2 extends AbstractC17902nl0 {
    private boolean a = false;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private List h = new ArrayList();

    public C23667xJ2() {
    }

    public void C(int i) {
        this.g = i;
    }

    public void D(int i) {
        this.e = i;
    }

    public void E(boolean z) {
        this.a = z;
    }

    public void F(int i) {
        this.b = i;
    }

    public void G(int i) {
        this.d = i;
    }

    public void H(int i) {
        this.c = i;
    }

    public void J(List list) {
        this.h = list;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.u(1);
        this.b = c19084pl0.x(2);
        this.c = c19084pl0.x(3);
        this.d = c19084pl0.x(4);
        this.e = c19084pl0.x(5);
        this.g = c19084pl0.x(6);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(7); i++) {
            arrayList.add(new ExPeer());
        }
        this.h = c19084pl0.p(7, arrayList);
        this.f = c19084pl0.x(8);
    }

    public int q() {
        return this.g;
    }

    public int r() {
        return this.e;
    }

    public int s() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.a);
        c19675ql0.f(2, this.b);
        c19675ql0.f(3, this.c);
        c19675ql0.f(4, this.d);
        c19675ql0.f(5, this.e);
        c19675ql0.f(6, this.g);
        c19675ql0.m(7, this.h);
        c19675ql0.f(8, this.f);
    }

    public int u() {
        return this.d;
    }

    public int w() {
        return this.c;
    }

    public List y() {
        return this.h;
    }

    public boolean z() {
        return this.a;
    }

    public C23667xJ2(byte[] bArr) {
        super.load(bArr);
    }
}
