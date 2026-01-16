package com.google.android.exoplayer2.source;

import android.util.SparseArray;
import ir.nasim.AbstractC20011rK;
import ir.nasim.InterfaceC23269we1;

/* loaded from: classes2.dex */
final class SpannedData<V> {
    private int a;
    private final SparseArray b;
    private final InterfaceC23269we1 c;

    public SpannedData() {
        this(new InterfaceC23269we1() { // from class: com.google.android.exoplayer2.source.k
            @Override // ir.nasim.InterfaceC23269we1
            public final void accept(Object obj) {
                SpannedData.i(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Object obj) {
    }

    public void b(int i, Object obj) {
        if (this.a == -1) {
            AbstractC20011rK.g(this.b.size() == 0);
            this.a = 0;
        }
        if (this.b.size() > 0) {
            SparseArray sparseArray = this.b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            AbstractC20011rK.a(i >= iKeyAt);
            if (iKeyAt == i) {
                InterfaceC23269we1 interfaceC23269we1 = this.c;
                SparseArray sparseArray2 = this.b;
                interfaceC23269we1.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.b.append(i, obj);
    }

    public void c() {
        for (int i = 0; i < this.b.size(); i++) {
            this.c.accept(this.b.valueAt(i));
        }
        this.a = -1;
        this.b.clear();
    }

    public void d(int i) {
        for (int size = this.b.size() - 1; size >= 0 && i < this.b.keyAt(size); size--) {
            this.c.accept(this.b.valueAt(size));
            this.b.removeAt(size);
        }
        this.a = this.b.size() > 0 ? Math.min(this.a, this.b.size() - 1) : -1;
    }

    public void e(int i) {
        int i2 = 0;
        while (i2 < this.b.size() - 1) {
            int i3 = i2 + 1;
            if (i < this.b.keyAt(i3)) {
                return;
            }
            this.c.accept(this.b.valueAt(i2));
            this.b.removeAt(i2);
            int i4 = this.a;
            if (i4 > 0) {
                this.a = i4 - 1;
            }
            i2 = i3;
        }
    }

    public Object f(int i) {
        if (this.a == -1) {
            this.a = 0;
        }
        while (true) {
            int i2 = this.a;
            if (i2 <= 0 || i >= this.b.keyAt(i2)) {
                break;
            }
            this.a--;
        }
        while (this.a < this.b.size() - 1 && i >= this.b.keyAt(this.a + 1)) {
            this.a++;
        }
        return this.b.valueAt(this.a);
    }

    public Object g() {
        return this.b.valueAt(r0.size() - 1);
    }

    public boolean h() {
        return this.b.size() == 0;
    }

    public SpannedData(InterfaceC23269we1 interfaceC23269we1) {
        this.b = new SparseArray();
        this.c = interfaceC23269we1;
        this.a = -1;
    }
}
