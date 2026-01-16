package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.InterfaceC16239kw0;
import ir.nasim.InterfaceC5308Iu0;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Cw0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C3907Cw0 extends RecyclerView.C {
    public static final a w = new a(null);
    public static final int x = 8;
    private static final int y = AbstractC9591aD5.call_log_item;
    private final C16830lw0 u;
    private final InterfaceC23079wJ4 v;

    /* renamed from: ir.nasim.Cw0$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C3907Cw0.y;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Cw0$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC23944xm6.values().length];
            try {
                iArr[EnumC23944xm6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23944xm6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC23944xm6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3907Cw0(C16830lw0 c16830lw0, InterfaceC23079wJ4 interfaceC23079wJ4) {
        super(c16830lw0.getRoot());
        AbstractC13042fc3.i(c16830lw0, "binding");
        AbstractC13042fc3.i(interfaceC23079wJ4, "onItemClickListener");
        this.u = c16830lw0;
        this.v = interfaceC23079wJ4;
        U0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(C3907Cw0 c3907Cw0, InterfaceC16239kw0.a aVar, View view) {
        AbstractC13042fc3.i(c3907Cw0, "this$0");
        AbstractC13042fc3.i(aVar, "$callLog");
        c3907Cw0.v.e(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O0(C3907Cw0 c3907Cw0, InterfaceC16239kw0.a aVar, View view) {
        AbstractC13042fc3.i(c3907Cw0, "this$0");
        AbstractC13042fc3.i(aVar, "$callLog");
        return c3907Cw0.v.v(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(C3907Cw0 c3907Cw0, InterfaceC16239kw0.a aVar, View view) {
        AbstractC13042fc3.i(c3907Cw0, "this$0");
        AbstractC13042fc3.i(aVar, "$callLog");
        c3907Cw0.v.e(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(InterfaceC16239kw0.a aVar, C3907Cw0 c3907Cw0, View view) {
        AbstractC13042fc3.i(aVar, "$callLog");
        AbstractC13042fc3.i(c3907Cw0, "this$0");
        InterfaceC16239kw0.c cVar = (InterfaceC16239kw0.c) aVar;
        if (cVar.a() == null) {
            return;
        }
        InterfaceC23079wJ4 interfaceC23079wJ4 = c3907Cw0.v;
        Integer numA = cVar.a();
        AbstractC13042fc3.f(numA);
        interfaceC23079wJ4.b(numA.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(InterfaceC16239kw0.a aVar, C3907Cw0 c3907Cw0, View view) {
        AbstractC13042fc3.i(aVar, "$callLog");
        AbstractC13042fc3.i(c3907Cw0, "this$0");
        InterfaceC16239kw0.g gVar = (InterfaceC16239kw0.g) aVar;
        if (gVar.a() == null) {
            return;
        }
        InterfaceC23079wJ4 interfaceC23079wJ4 = c3907Cw0.v;
        Integer numA = gVar.a();
        AbstractC13042fc3.f(numA);
        interfaceC23079wJ4.a(numA.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(C16830lw0 c16830lw0, View view) {
        String name;
        AbstractC13042fc3.i(c16830lw0, "$this_with");
        if (c16830lw0.getClass().isAnonymousClass()) {
            name = C16830lw0.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C16830lw0.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.a(name, "start this call type is not supported", new Object[0]);
    }

    private final MaterialTextView U0() {
        C16830lw0 c16830lw0 = this.u;
        c16830lw0.e.B(18.0f, true);
        c16830lw0.g.setTypeface(C6011Lu2.k());
        MaterialTextView materialTextView = c16830lw0.b;
        materialTextView.setTypeface(C6011Lu2.k());
        AbstractC13042fc3.h(materialTextView, "with(...)");
        return materialTextView;
    }

    public final void M0(final InterfaceC16239kw0.a aVar) {
        AbstractC13042fc3.i(aVar, "callLog");
        final C16830lw0 c16830lw0 = this.u;
        StringBuilder sb = new StringBuilder();
        V0(aVar.b());
        c16830lw0.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ww0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C3907Cw0.N0(this.a, aVar, view);
            }
        });
        c16830lw0.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.xw0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C3907Cw0.O0(this.a, aVar, view);
            }
        });
        c16830lw0.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yw0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C3907Cw0.P0(this.a, aVar, view);
            }
        });
        if (aVar instanceof InterfaceC16239kw0.c) {
            c16830lw0.i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zw0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C3907Cw0.Q0(aVar, this, view);
                }
            });
        } else if (aVar instanceof InterfaceC16239kw0.g) {
            c16830lw0.i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Aw0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C3907Cw0.S0(aVar, this, view);
                }
            });
        } else {
            c16830lw0.i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Bw0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C3907Cw0.T0(c16830lw0, view);
                }
            });
        }
        InterfaceC5308Iu0 interfaceC5308Iu0C = aVar.c();
        if (interfaceC5308Iu0C instanceof InterfaceC5308Iu0.b) {
            AvatarViewGlide avatarViewGlide = c16830lw0.e;
            Avatar avatarA = ((InterfaceC5308Iu0.b) interfaceC5308Iu0C).a();
            String name = aVar.getName();
            Integer numA = aVar.a();
            AvatarViewGlide.v(avatarViewGlide, avatarA, name, numA != null ? numA.intValue() : 0, false, null, 16, null);
        } else if (interfaceC5308Iu0C instanceof InterfaceC5308Iu0.a) {
            AvatarViewGlide avatarViewGlide2 = c16830lw0.e;
            String name2 = aVar.getName();
            Integer numA2 = aVar.a();
            AvatarViewGlide.v(avatarViewGlide2, null, name2, numA2 != null ? numA2.intValue() : 0, false, null, 16, null);
        }
        c16830lw0.g.setText(aVar.getName());
        sb.append(aVar.getName());
        sb.append(Separators.SP);
        c16830lw0.b.setText(aVar.getDescription());
        c16830lw0.c.setImageDrawable(AbstractC9594aE.b(c16830lw0.getRoot().getContext(), aVar.d()));
        String string = (aVar.d() == AbstractC14606iB5.success_status_call_out || aVar.d() == AbstractC14606iB5.fail_status_call_out) ? c16830lw0.getRoot().getContext().getString(BD5.features_call_calllogs_accessibility_outgoing_call) : c16830lw0.getRoot().getContext().getString(BD5.features_call_calllogs_accessibility_incoming_call);
        AbstractC13042fc3.f(string);
        sb.append(string);
        sb.append(Separators.SP);
        sb.append(aVar.getDescription());
        c16830lw0.getRoot().setContentDescription(sb);
    }

    public final void V0(EnumC23944xm6 enumC23944xm6) {
        AbstractC13042fc3.i(enumC23944xm6, "selectState");
        C16830lw0 c16830lw0 = this.u;
        int i = b.a[enumC23944xm6.ordinal()];
        if (i == 1) {
            c16830lw0.d.setVisibility(0);
            c16830lw0.d.setChecked(true);
        } else if (i == 2) {
            c16830lw0.d.setVisibility(0);
            c16830lw0.d.setChecked(false);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            c16830lw0.d.setVisibility(8);
            c16830lw0.d.setChecked(false);
        }
    }

    public final void a() {
        C16830lw0 c16830lw0 = this.u;
        c16830lw0.d.setChecked(false);
        c16830lw0.e.D();
    }
}
