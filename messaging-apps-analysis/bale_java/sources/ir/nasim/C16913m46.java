package ir.nasim;

import ir.nasim.features.root.C13090h;

/* renamed from: ir.nasim.m46, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C16913m46 implements InterfaceC19868r46 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.m46$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // ir.nasim.InterfaceC19868r46
    public int a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return AbstractC12217eE5.tab_title_jaryan;
        }
        if (i == C13090h.INSTANCE.b()) {
            return AbstractC12217eE5.my_bank_fragment_header;
        }
        return 0;
    }

    @Override // ir.nasim.InterfaceC19868r46
    public int b(int i) {
        if (i == 0) {
            return KB5.bale_text_logo;
        }
        if (i != 1) {
            C13090h.INSTANCE.b();
        }
        return 0;
    }

    @Override // ir.nasim.InterfaceC19868r46
    public DD c(int i) {
        return null;
    }

    @Override // ir.nasim.InterfaceC19868r46
    public int d() {
        return 0;
    }

    public Integer[] e() {
        return C8386Vt0.a.h4() ? new Integer[]{Integer.valueOf(KB5.ba_bn_chat_active), Integer.valueOf(KB5.ba_bn_jaryan_active), Integer.valueOf(KB5.magic_ai_active), Integer.valueOf(KB5.ba_bn_khadamat_active)} : new Integer[]{Integer.valueOf(KB5.ba_bn_chat_active), Integer.valueOf(KB5.ba_bn_jaryan_active), Integer.valueOf(KB5.ba_bn_khadamat_active)};
    }

    public Integer[] f() {
        return C8386Vt0.a.h4() ? new Integer[]{Integer.valueOf(KB5.ba_bn_chat), Integer.valueOf(KB5.ba_bn_jaryan), Integer.valueOf(KB5.magic_ai), Integer.valueOf(KB5.ba_bn_khadamat)} : new Integer[]{Integer.valueOf(KB5.ba_bn_chat), Integer.valueOf(KB5.ba_bn_jaryan), Integer.valueOf(KB5.ba_bn_khadamat)};
    }
}
