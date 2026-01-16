package ir.nasim;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;

/* renamed from: ir.nasim.t37, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21071t37 {
    private static final C3534Bg5 a = new C3534Bg5(AbstractC10360bX0.m());

    /* renamed from: ir.nasim.t37$a */
    static final class a implements PointerInputEventHandler, InterfaceC22409vB2 {
        private final /* synthetic */ InterfaceC14603iB2 a;

        a(InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof PointerInputEventHandler) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final /* synthetic */ Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            return this.a.invoke(interfaceC9049Yg5, interfaceC20295rm1);
        }
    }

    public static final InterfaceC22335v37 a(PointerInputEventHandler pointerInputEventHandler) {
        return new C22931w37(null, null, null, pointerInputEventHandler);
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, Object obj, PointerInputEventHandler pointerInputEventHandler) {
        return eVar.i(new SuspendPointerInputElement(obj, null, null, pointerInputEventHandler, 6, null));
    }

    public static final androidx.compose.ui.e e(androidx.compose.ui.e eVar, Object obj, Object obj2, PointerInputEventHandler pointerInputEventHandler) {
        return eVar.i(new SuspendPointerInputElement(obj, obj2, null, pointerInputEventHandler, 4, null));
    }
}
