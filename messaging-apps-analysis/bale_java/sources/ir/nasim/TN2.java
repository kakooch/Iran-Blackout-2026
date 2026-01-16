package ir.nasim;

import com.google.protobuf.BytesValue;
import java.util.List;

/* loaded from: classes5.dex */
public class TN2 extends Z6 {
    public TN2(final C9057Yh4 c9057Yh4) {
        super(C12736f7.n().d("groups/router", new V6() { // from class: ir.nasim.SN2
            @Override // ir.nasim.V6
            public final K6 create() {
                return TN2.s(c9057Yh4);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 s(C9057Yh4 c9057Yh4) {
        return new RN2(c9057Yh4);
    }

    public C6517Nv5 k(List list) {
        return c(new P56(list));
    }

    public void l() {
        i(new S56());
    }

    public C6517Nv5 m(List list, Boolean bool) {
        return c(new X56(list, bool));
    }

    public C6517Nv5 n(List list) {
        return c(new Z56(list));
    }

    public C6517Nv5 o(int i) {
        return c(new C10119b66(i));
    }

    public C6517Nv5 p(int i) {
        return c(new C10735c66(i));
    }

    public C6517Nv5 q(int i) {
        return c(new C12142e66(i));
    }

    public C6517Nv5 r(int i, BytesValue bytesValue, int i2) {
        return c(new C12733f66(i, bytesValue, i2));
    }

    public C6517Nv5 t(AbstractC20556sC7 abstractC20556sC7) {
        return c(new C15160j66(abstractC20556sC7));
    }

    public void u(C11458d25 c11458d25, List list) {
        i(new C24730z66(c11458d25, list));
    }
}
