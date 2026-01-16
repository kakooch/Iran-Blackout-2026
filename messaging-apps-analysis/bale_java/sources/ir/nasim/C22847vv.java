package ir.nasim;

import android.text.SegmentFinder;

/* renamed from: ir.nasim.vv, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22847vv {
    public static final C22847vv a = new C22847vv();

    /* renamed from: ir.nasim.vv$a */
    public static final class a extends SegmentFinder {
        final /* synthetic */ InterfaceC24524yl6 a;

        a(InterfaceC24524yl6 interfaceC24524yl6) {
            this.a = interfaceC24524yl6;
        }

        public int nextEndBoundary(int i) {
            return this.a.c(i);
        }

        public int nextStartBoundary(int i) {
            return this.a.a(i);
        }

        public int previousEndBoundary(int i) {
            return this.a.d(i);
        }

        public int previousStartBoundary(int i) {
            return this.a.b(i);
        }
    }

    private C22847vv() {
    }

    public final SegmentFinder a(InterfaceC24524yl6 interfaceC24524yl6) {
        return AbstractC23377wp.a(new a(interfaceC24524yl6));
    }
}
