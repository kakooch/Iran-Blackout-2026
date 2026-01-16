package ir.nasim;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;

/* loaded from: classes.dex */
public class MZ6 extends RG1 implements InterfaceC8508Wg5, InterfaceC20937sr2, InterfaceC5283Ir2 {
    private SA2 q;
    private boolean r;
    private final InterfaceC22335v37 s = (InterfaceC22335v37) v2(AbstractC21071t37.a(new a()));

    static final class a implements PointerInputEventHandler {

        /* renamed from: ir.nasim.MZ6$a$a, reason: collision with other inner class name */
        static final class C0501a extends V06 implements InterfaceC14603iB2 {
            Object a;
            Object b;
            int c;
            private /* synthetic */ Object d;
            final /* synthetic */ MZ6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0501a(MZ6 mz6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = mz6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0501a c0501a = new C0501a(this.e, interfaceC20295rm1);
                c0501a.d = obj;
                return c0501a;
            }

            /* JADX WARN: Path cross not found for [B:62:0x0156, B:57:0x013a], limit reached: 95 */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00f5 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0106  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x013a  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x0176  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x0179  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x01a6 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:77:0x01b7  */
            /* JADX WARN: Removed duplicated region for block: B:88:0x01e1  */
            /* JADX WARN: Removed duplicated region for block: B:90:0x01e4  */
            /* JADX WARN: Removed duplicated region for block: B:91:0x01e8  */
            /* JADX WARN: Removed duplicated region for block: B:93:0x01dc A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:98:0x0132 A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f3 -> B:42:0x00f6). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01a4 -> B:75:0x01a7). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r18) {
                /*
                    Method dump skipped, instructions count: 493
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.MZ6.a.C0501a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0501a) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a() {
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objD = AbstractC8163Uu2.d(interfaceC9049Yg5, new C0501a(MZ6.this, null), interfaceC20295rm1);
            return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
        }
    }

    public MZ6(SA2 sa2) {
        this.q = sa2;
    }

    public final SA2 C2() {
        return this.q;
    }

    public final void D2(SA2 sa2) {
        this.q = sa2;
    }

    @Override // ir.nasim.InterfaceC20937sr2
    public void O(InterfaceC5517Jr2 interfaceC5517Jr2) {
        this.r = interfaceC5517Jr2.a();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public long T0() {
        return androidx.compose.foundation.text.handwriting.a.a().a(KG1.k(this));
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void i1() {
        this.s.i1();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void k1(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5, long j) {
        this.s.k1(c3534Bg5, enumC4002Dg5, j);
    }
}
