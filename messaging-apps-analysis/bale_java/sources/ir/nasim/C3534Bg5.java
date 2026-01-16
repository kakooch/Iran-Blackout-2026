package ir.nasim;

import android.os.Build;
import android.view.MotionEvent;
import java.util.List;

/* renamed from: ir.nasim.Bg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3534Bg5 {
    private final List a;
    private final C7286Rb3 b;
    private final int c;
    private final int d;
    private int e;

    public C3534Bg5(List list, C7286Rb3 c7286Rb3) {
        this.a = list;
        this.b = c7286Rb3;
        MotionEvent motionEventF = f();
        this.c = AbstractC25067zg5.a(motionEventF != null ? motionEventF.getButtonState() : 0);
        MotionEvent motionEventF2 = f();
        this.d = C11078ch5.b(motionEventF2 != null ? motionEventF2.getMetaState() : 0);
        this.e = a();
    }

    private final int a() {
        MotionEvent motionEventF = f();
        if (motionEventF != null) {
            int actionMasked = motionEventF.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        switch (actionMasked) {
                        }
                        return AbstractC4236Eg5.a.d();
                    }
                    return AbstractC4236Eg5.a.c();
                }
                return AbstractC4236Eg5.a.e();
            }
            return AbstractC4236Eg5.a.d();
        }
        List list = this.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C6616Og5 c6616Og5 = (C6616Og5) list.get(i);
            if (AbstractC3768Cg5.d(c6616Og5)) {
                return AbstractC4236Eg5.a.e();
            }
            if (AbstractC3768Cg5.b(c6616Og5)) {
                return AbstractC4236Eg5.a.d();
            }
        }
        return AbstractC4236Eg5.a.c();
    }

    public final int b() {
        return this.c;
    }

    public final List c() {
        return this.a;
    }

    public final int d() {
        MotionEvent motionEventF;
        if (Build.VERSION.SDK_INT < 29 || (motionEventF = f()) == null) {
            return 0;
        }
        return motionEventF.getClassification();
    }

    public final C7286Rb3 e() {
        return this.b;
    }

    public final MotionEvent f() {
        C7286Rb3 c7286Rb3 = this.b;
        if (c7286Rb3 != null) {
            return c7286Rb3.c();
        }
        return null;
    }

    public final int g() {
        return this.e;
    }

    public final void h(int i) {
        this.e = i;
    }

    public C3534Bg5(List list) {
        this(list, null);
    }
}
