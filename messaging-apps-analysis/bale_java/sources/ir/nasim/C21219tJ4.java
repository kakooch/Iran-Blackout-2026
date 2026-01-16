package ir.nasim;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.InterfaceC19416qJ4;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.tJ4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C21219tJ4 extends RecyclerView.C {
    public static final a x = new a(null);
    public static final int y = 8;
    private static final int z = AbstractC9591aD5.running_call_item;
    private final C19307q76 u;
    private final InterfaceC19342qB2 v;
    private final SA2 w;

    /* renamed from: ir.nasim.tJ4$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C21219tJ4.z;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C21219tJ4(C19307q76 c19307q76, InterfaceC19342qB2 interfaceC19342qB2, SA2 sa2) {
        super(c19307q76.getRoot());
        AbstractC13042fc3.i(c19307q76, "binding");
        AbstractC13042fc3.i(interfaceC19342qB2, "onJoinClicked");
        AbstractC13042fc3.i(sa2, "openCallClicked");
        this.u = c19307q76;
        this.v = interfaceC19342qB2;
        this.w = sa2;
        H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(InterfaceC19416qJ4 interfaceC19416qJ4, C21219tJ4 c21219tJ4, View view) {
        AbstractC13042fc3.i(interfaceC19416qJ4, "$onGoingCall");
        AbstractC13042fc3.i(c21219tJ4, "this$0");
        if (interfaceC19416qJ4.a()) {
            c21219tJ4.w.invoke();
            return;
        }
        if (interfaceC19416qJ4 instanceof InterfaceC19416qJ4.c) {
            InterfaceC19416qJ4.c cVar = (InterfaceC19416qJ4.c) interfaceC19416qJ4;
            c21219tJ4.v.j(Long.valueOf(cVar.d()), Integer.valueOf(cVar.g()), null, null, null, null);
        } else if (interfaceC19416qJ4 instanceof InterfaceC19416qJ4.d) {
            c21219tJ4.v.j(Long.valueOf(((InterfaceC19416qJ4.d) interfaceC19416qJ4).d()), 0, null, null, null, null);
        } else if (interfaceC19416qJ4 instanceof InterfaceC19416qJ4.b) {
            InterfaceC19416qJ4.b bVar = (InterfaceC19416qJ4.b) interfaceC19416qJ4;
            c21219tJ4.v.j(Long.valueOf(bVar.c()), 0, bVar.i(), Integer.valueOf(bVar.h()), bVar.d(), bVar.e());
        } else if (!AbstractC13042fc3.d(interfaceC19416qJ4, InterfaceC19416qJ4.a.a)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final MaterialTextView H0() {
        C19307q76 c19307q76 = this.u;
        c19307q76.c.B(18.0f, true);
        c19307q76.f.setTypeface(C6011Lu2.k());
        MaterialTextView materialTextView = c19307q76.b;
        materialTextView.setTypeface(C6011Lu2.k());
        AbstractC13042fc3.h(materialTextView, "with(...)");
        return materialTextView;
    }

    public final void E0(final InterfaceC19416qJ4 interfaceC19416qJ4) {
        String strK;
        String strV;
        AbstractC13042fc3.i(interfaceC19416qJ4, "onGoingCall");
        C19307q76 c19307q76 = this.u;
        c19307q76.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sJ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C21219tJ4.F0(interfaceC19416qJ4, this, view);
            }
        });
        MaterialTextView materialTextView = c19307q76.f;
        if (interfaceC19416qJ4 instanceof InterfaceC19416qJ4.c) {
            strK = ((InterfaceC19416qJ4.c) interfaceC19416qJ4).f();
        } else if (interfaceC19416qJ4 instanceof InterfaceC19416qJ4.d) {
            strK = ((InterfaceC19416qJ4.d) interfaceC19416qJ4).f();
        } else if (interfaceC19416qJ4 instanceof InterfaceC19416qJ4.b) {
            InterfaceC19416qJ4.b bVar = (InterfaceC19416qJ4.b) interfaceC19416qJ4;
            String strI = bVar.i();
            if (strI == null || AbstractC20762sZ6.n0(strI)) {
                strK = AbstractC4043Dl1.k(this.u.g.getContext(), bVar.f());
                AbstractC13042fc3.f(strK);
            } else {
                strK = strI;
            }
        } else {
            strK = "";
        }
        materialTextView.setText(strK);
        c19307q76.d.setText(interfaceC19416qJ4.b());
        if (interfaceC19416qJ4 instanceof InterfaceC19416qJ4.c) {
            InterfaceC19416qJ4.c cVar = (InterfaceC19416qJ4.c) interfaceC19416qJ4;
            AvatarViewGlide.v(c19307q76.c, cVar.c(), cVar.f(), cVar.g(), false, null, 16, null);
            c19307q76.b.setText(cVar.e());
            return;
        }
        if (interfaceC19416qJ4 instanceof InterfaceC19416qJ4.d) {
            InterfaceC19416qJ4.d dVar = (InterfaceC19416qJ4.d) interfaceC19416qJ4;
            AvatarViewGlide.v(c19307q76.c, dVar.c(), dVar.f(), 0, false, null, 16, null);
            c19307q76.b.setText(dVar.e());
        } else if (interfaceC19416qJ4 instanceof InterfaceC19416qJ4.b) {
            InterfaceC19416qJ4.b bVar2 = (InterfaceC19416qJ4.b) interfaceC19416qJ4;
            c19307q76.c.setImageDrawable(AbstractC4043Dl1.f(this.u.g.getContext(), bVar2.g()));
            MaterialTextView materialTextView2 = c19307q76.b;
            if (bVar2.j() == 0) {
                strV = AbstractC4043Dl1.k(this.u.g.getContext(), BD5.features_call_link_call_no_member);
            } else {
                String str = String.valueOf(bVar2.j()) + AbstractC4043Dl1.k(this.u.g.getContext(), BD5.features_call_link_call_members);
                AbstractC13042fc3.h(str, "toString(...)");
                strV = XY6.v(str);
            }
            materialTextView2.setText(strV);
        }
    }

    public final void a() {
        this.u.c.D();
    }
}
