package ir.nasim;

import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.bk4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10517bk4 {
    private long a;
    private final SparseLongArray b = new SparseLongArray();
    private final SparseBooleanArray c = new SparseBooleanArray();
    private final List d = new ArrayList();
    private int e = -1;
    private int f = -1;

    private final void a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.b.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.b;
                long j = this.a;
                this.a = 1 + j;
                sparseLongArray.put(pointerId, j);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.b.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.b;
            long j2 = this.a;
            this.a = 1 + j2;
            sparseLongArray2.put(pointerId2, j2);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.c.put(pointerId2, true);
            }
        }
    }

    private final void b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.e && source == this.f) {
            return;
        }
        this.e = toolType;
        this.f = source;
        this.c.clear();
        this.b.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C7333Rg5 d(ir.nasim.InterfaceC8058Ui5 r34, android.view.MotionEvent r35, int r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10517bk4.d(ir.nasim.Ui5, android.view.MotionEvent, int, boolean):ir.nasim.Rg5");
    }

    private final long f(int i) {
        long jValueAt;
        int iIndexOfKey = this.b.indexOfKey(i);
        if (iIndexOfKey >= 0) {
            jValueAt = this.b.valueAt(iIndexOfKey);
        } else {
            jValueAt = this.a;
            this.a = 1 + jValueAt;
            this.b.put(i, jValueAt);
        }
        return AbstractC6122Mg5.a(jValueAt);
    }

    private final boolean g(MotionEvent motionEvent, int i) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (motionEvent.getPointerId(i2) == i) {
                return true;
            }
        }
        return false;
    }

    private final void h(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.c.get(pointerId, false)) {
                this.b.delete(pointerId);
                this.c.delete(pointerId);
            }
        }
        if (this.b.size() > motionEvent.getPointerCount()) {
            for (int size = this.b.size() - 1; -1 < size; size--) {
                int iKeyAt = this.b.keyAt(size);
                if (!g(motionEvent, iKeyAt)) {
                    this.b.removeAt(size);
                    this.c.delete(iKeyAt);
                }
            }
        }
    }

    public final C7099Qg5 c(MotionEvent motionEvent, InterfaceC8058Ui5 interfaceC8058Ui5) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.b.clear();
            this.c.clear();
            return null;
        }
        b(motionEvent);
        a(motionEvent);
        boolean z = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z2 = actionMasked == 8;
        if (z) {
            this.c.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        int actionIndex = actionMasked != 1 ? actionMasked != 6 ? -1 : motionEvent.getActionIndex() : 0;
        this.d.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        while (i < pointerCount) {
            this.d.add(d(interfaceC8058Ui5, motionEvent, i, (z || i == actionIndex || (z2 && motionEvent.getButtonState() == 0)) ? false : true));
            i++;
        }
        h(motionEvent);
        return new C7099Qg5(motionEvent.getEventTime(), this.d, motionEvent);
    }

    public final void e(int i) {
        this.c.delete(i);
        this.b.delete(i);
    }
}
