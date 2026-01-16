package ir.nasim;

import android.content.Context;
import android.view.View;
import ir.nasim.RA4;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class RA4 {
    public static final RA4 a = new RA4();
    private static final AbstractC23538x54 b = new a();

    private RA4() {
    }

    public final AbstractC23538x54 a() {
        return b;
    }

    public static final class a extends AbstractC23538x54 {
        private final boolean a;
        private final UA2 b = new UA2() { // from class: ir.nasim.QA4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return RA4.a.n((String) obj);
            }
        };
        private final C0595a c = new C0595a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(String str) {
            AbstractC13042fc3.i(str, "it");
            return C19938rB7.a;
        }

        @Override // ir.nasim.AbstractC23538x54
        public InterfaceC14227ha a() {
            throw new IllegalStateException();
        }

        @Override // ir.nasim.AbstractC23538x54
        public InterfaceC6594Oe1 c() {
            throw new IllegalStateException();
        }

        @Override // ir.nasim.AbstractC23538x54
        public InterfaceC24373yW1 d() {
            throw new IllegalStateException();
        }

        @Override // ir.nasim.AbstractC23538x54
        public UA2 e() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC23538x54
        public EY2 f() {
            throw new IllegalStateException();
        }

        @Override // ir.nasim.AbstractC23538x54
        public InterfaceC18458oh5 g() {
            throw new IllegalStateException();
        }

        @Override // ir.nasim.AbstractC23538x54
        public BB7 h() {
            throw new IllegalStateException();
        }

        @Override // ir.nasim.AbstractC23538x54
        public InterfaceC7199Qr6 i() {
            throw new IllegalStateException();
        }

        @Override // ir.nasim.AbstractC23538x54
        public InterfaceC12810fC7 j() {
            throw new IllegalStateException();
        }

        @Override // ir.nasim.AbstractC23538x54
        public boolean k() {
            return this.a;
        }

        @Override // ir.nasim.AbstractC23538x54
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public C0595a b() {
            return this.c;
        }

        /* renamed from: ir.nasim.RA4$a$a, reason: collision with other inner class name */
        public static final class C0595a implements InterfaceC22948w54 {
            C0595a() {
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void b(J44 j44, C17532n74 c17532n74) {
                AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void c(Context context, J44 j44, C11458d25 c11458d25) {
                AbstractC13042fc3.i(context, "context");
                AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
                AbstractC13042fc3.i(c11458d25, "peer");
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void e(View view, C8967Xz7 c8967Xz7) {
                AbstractC13042fc3.i(view, "view");
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void f(C10240bJ6 c10240bJ6) {
                AbstractC13042fc3.i(c10240bJ6, "sponsored");
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void g(C8967Xz7 c8967Xz7, String str, View view) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
                AbstractC13042fc3.i(str, "reactionCode");
                AbstractC13042fc3.i(view, "anchor");
            }

            @Override // ir.nasim.InterfaceC22948w54
            public boolean h(C8967Xz7 c8967Xz7, String str) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
                AbstractC13042fc3.i(str, "url");
                return false;
            }

            @Override // ir.nasim.InterfaceC22948w54
            public boolean j(View view, C8967Xz7 c8967Xz7, String str) {
                AbstractC13042fc3.i(view, "view");
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
                return false;
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void k(C8967Xz7 c8967Xz7) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void l(C8967Xz7 c8967Xz7) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            }

            @Override // ir.nasim.InterfaceC22948w54
            public boolean m(C8967Xz7 c8967Xz7) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
                return false;
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void n(C8967Xz7 c8967Xz7, String str) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
                AbstractC13042fc3.i(str, "hashtag");
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void o(C8967Xz7 c8967Xz7, Boolean bool) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void p(C8967Xz7 c8967Xz7, C4602Fv2 c4602Fv2) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
                AbstractC13042fc3.i(c4602Fv2, "forward");
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void q(String str) {
                AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void r(C8967Xz7 c8967Xz7, G73 g73) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
                AbstractC13042fc3.i(g73, "templateButton");
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void s(C8967Xz7 c8967Xz7) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void t(C8967Xz7 c8967Xz7, String str, boolean z) {
                AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
                AbstractC13042fc3.i(str, "reactionCode");
            }

            @Override // ir.nasim.InterfaceC22948w54
            public void a(int i) {
            }
        }
    }
}
