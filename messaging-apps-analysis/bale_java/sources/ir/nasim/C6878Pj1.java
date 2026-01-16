package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C6878Pj1;

/* renamed from: ir.nasim.Pj1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6878Pj1 extends RecyclerView.h {
    private final String d;
    private final boolean e;
    private final a.InterfaceC0580a f;

    /* renamed from: ir.nasim.Pj1$a */
    public static final class a extends RecyclerView.C {
        private final String u;
        private final boolean v;
        private final C7122Qj1 w;

        /* renamed from: ir.nasim.Pj1$a$a, reason: collision with other inner class name */
        public interface InterfaceC0580a {
            void a();

            void b();

            void c();

            void d();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z, C7122Qj1 c7122Qj1, InterfaceC0580a interfaceC0580a) {
            super(c7122Qj1.getRoot());
            AbstractC13042fc3.i(c7122Qj1, "binding");
            AbstractC13042fc3.i(interfaceC0580a, "onOptionsClickListener");
            this.u = str;
            this.v = z;
            this.w = c7122Qj1;
            H0();
            J0(interfaceC0580a);
        }

        private final void H0() {
            C7122Qj1 c7122Qj1 = this.w;
            if (this.v) {
                c7122Qj1.j.setVisibility(0);
                c7122Qj1.h.setVisibility(0);
                c7122Qj1.i.setTypeface(C6011Lu2.k());
                c7122Qj1.k.setTypeface(C6011Lu2.i());
                String str = this.u;
                if (str != null) {
                    c7122Qj1.i.setText(c7122Qj1.getRoot().getContext().getString(ED5.organization_title, str));
                }
            }
            c7122Qj1.g.setTypeface(C6011Lu2.k());
            c7122Qj1.d.setTypeface(C6011Lu2.k());
            c7122Qj1.c.setTypeface(C6011Lu2.k());
        }

        private final void J0(final InterfaceC0580a interfaceC0580a) {
            C7122Qj1 c7122Qj1 = this.w;
            c7122Qj1.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Lj1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C6878Pj1.a.L0(interfaceC0580a, view);
                }
            });
            c7122Qj1.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Mj1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C6878Pj1.a.M0(interfaceC0580a, view);
                }
            });
            c7122Qj1.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Nj1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C6878Pj1.a.N0(interfaceC0580a, view);
                }
            });
            if (this.v) {
                c7122Qj1.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Oj1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C6878Pj1.a.O0(interfaceC0580a, view);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L0(InterfaceC0580a interfaceC0580a, View view) {
            AbstractC13042fc3.i(interfaceC0580a, "$onClickItems");
            interfaceC0580a.c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void M0(InterfaceC0580a interfaceC0580a, View view) {
            AbstractC13042fc3.i(interfaceC0580a, "$onClickItems");
            interfaceC0580a.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void N0(InterfaceC0580a interfaceC0580a, View view) {
            AbstractC13042fc3.i(interfaceC0580a, "$onClickItems");
            interfaceC0580a.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void O0(InterfaceC0580a interfaceC0580a, View view) {
            AbstractC13042fc3.i(interfaceC0580a, "$onClickItems");
            interfaceC0580a.d();
        }
    }

    public C6878Pj1(String str, boolean z, a.InterfaceC0580a interfaceC0580a) {
        AbstractC13042fc3.i(interfaceC0580a, "onOptionsClickListener");
        this.d = str;
        this.e = z;
        this.f = interfaceC0580a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C7122Qj1 c7122Qj1C = C7122Qj1.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c7122Qj1C, "inflate(...)");
        return new a(this.d, this.e, c7122Qj1C, this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        AbstractC13042fc3.i(aVar, "holder");
    }
}
