package ir.nasim;

import android.view.ActionMode;
import android.view.View;

/* renamed from: ir.nasim.jr, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15597jr implements InterfaceC11323co7 {
    private final View a;
    private ActionMode b;
    private final C6160Mk7 c = new C6160Mk7(new a(), null, null, null, null, null, null, 126, null);
    private EnumC12557eo7 d = EnumC12557eo7.b;

    /* renamed from: ir.nasim.jr$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final void a() {
            C15597jr.this.b = null;
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public C15597jr(View view) {
        this.a = view;
    }

    @Override // ir.nasim.InterfaceC11323co7
    public void a(CK5 ck5, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25) {
        this.c.m(ck5);
        this.c.i(sa2);
        this.c.j(sa23);
        this.c.k(sa22);
        this.c.l(sa24);
        this.c.h(sa25);
        ActionMode actionMode = this.b;
        if (actionMode == null) {
            this.d = EnumC12557eo7.a;
            this.b = C11944do7.a.a(this.a, new C23980xq2(this.c), 1);
        } else if (actionMode != null) {
            actionMode.invalidate();
        }
    }

    @Override // ir.nasim.InterfaceC11323co7
    public void b() {
        this.d = EnumC12557eo7.b;
        ActionMode actionMode = this.b;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.b = null;
    }

    @Override // ir.nasim.InterfaceC11323co7
    public EnumC12557eo7 j() {
        return this.d;
    }
}
