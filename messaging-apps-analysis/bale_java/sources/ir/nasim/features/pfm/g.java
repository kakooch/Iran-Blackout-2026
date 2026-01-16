package ir.nasim.features.pfm;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC16613la3;
import ir.nasim.AbstractC18306oR4;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C10600bs7;
import ir.nasim.C12889fL5;
import ir.nasim.C19263q32;
import ir.nasim.C19938rB7;
import ir.nasim.C22078ud6;
import ir.nasim.C23077wJ2;
import ir.nasim.C23381wp3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.D20;
import ir.nasim.D45;
import ir.nasim.ED1;
import ir.nasim.EnumC18897pR4;
import ir.nasim.FW7;
import ir.nasim.GY6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.MY;
import ir.nasim.NY;
import ir.nasim.O8;
import ir.nasim.RQ4;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.XY6;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.pfm.entity.PFMTransaction;
import ir.nasim.features.pfm.tags.PFMTag;

/* loaded from: classes6.dex */
public final class g extends RecyclerView.C {
    public static final a G = new a(null);
    public static final int H = 8;
    private static boolean J;
    private final UA2 A;
    private final boolean B;
    private final InterfaceC9173Yu3 D;
    private final FW7 u;
    private final InterfaceC14603iB2 v;
    private final Context w;
    private final InterfaceC18633oz3 x;
    private final boolean y;
    private final InterfaceC15408jX7 z;

    public static final class a {
        private a() {
        }

        public final String a(D45 d45) {
            AbstractC13042fc3.i(d45, "persianDate");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(AbstractC16613la3.a(d45.u()));
            stringBuffer.append(":");
            stringBuffer.append(AbstractC16613la3.a(d45.v()));
            stringBuffer.append(" - ");
            stringBuffer.append(AbstractC16613la3.a(d45.C()));
            stringBuffer.append(Separators.SLASH);
            stringBuffer.append(AbstractC16613la3.a(d45.B()));
            stringBuffer.append(Separators.SLASH);
            stringBuffer.append(AbstractC16613la3.a(d45.A()));
            return XY6.e(stringBuffer.toString());
        }

        public final void b(boolean z) {
            g.J = z;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC18897pR4.values().length];
            try {
                iArr[EnumC18897pR4.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18897pR4.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(FW7 fw7, InterfaceC14603iB2 interfaceC14603iB2, Context context, InterfaceC18633oz3 interfaceC18633oz3, boolean z, InterfaceC15408jX7 interfaceC15408jX7, UA2 ua2, boolean z2) {
        super(fw7.getRoot());
        AbstractC13042fc3.i(fw7, "binding");
        AbstractC13042fc3.i(interfaceC14603iB2, "click");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC15408jX7, "viewModelStore");
        AbstractC13042fc3.i(ua2, "showFragmentCallback");
        this.u = fw7;
        this.v = interfaceC14603iB2;
        this.w = context;
        this.x = interfaceC18633oz3;
        this.y = z;
        this.z = interfaceC15408jX7;
        this.A = ua2;
        this.B = z2;
        this.D = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.IR4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.features.pfm.g.O1(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(g gVar, PFMTransaction pFMTransaction, PFMTag pFMTag, View view) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        AbstractC13042fc3.i(pFMTag, "$tag");
        gVar.v.invoke(pFMTransaction, pFMTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(g gVar, PFMTransaction pFMTransaction, View view) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        gVar.v.invoke(pFMTransaction, null);
    }

    private final h C1() {
        return (h) this.D.getValue();
    }

    private final void D1(MY my, PFMTransaction pFMTransaction) {
        if (my != null) {
            my.o();
        }
        pFMTransaction.j("");
        this.u.b.setVisibility(8);
    }

    private final Drawable E1(PFMTag pFMTag) {
        try {
            Drawable drawable = this.a.getContext().getDrawable(pFMTag.getIconId());
            if (pFMTag.getUserId() == 0 || drawable == null) {
                return drawable;
            }
            drawable.setTint(pFMTag.getColor());
            return drawable;
        } catch (Exception unused) {
            return this.a.getContext().getResources().getDrawable(KB5.pfm_default_tag);
        }
    }

    private final void F1(final PFMTransaction pFMTransaction, final AlertDialog alertDialog) {
        final C12889fL5 c12889fL5 = new C12889fL5();
        MY myA = new NY(this.w).E(4).k(4).j(true).e(true).c(false).w(AbstractC12217eE5.positive_remove_custom_tag).u(this.w.getString(AbstractC12217eE5.negative_remove_custom_tag)).B("").h(AbstractC12217eE5.alert_delete_transaction).p(KB5.alert_remove_transaction).v(new View.OnClickListener() { // from class: ir.nasim.zR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.g.H1(this.a, pFMTransaction, alertDialog, c12889fL5, view);
            }
        }).y(C5495Jo7.a.J0()).s(new View.OnClickListener() { // from class: ir.nasim.AR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.g.J1(c12889fL5, alertDialog, view);
            }
        }).a();
        c12889fL5.a = myA;
        myA.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(final g gVar, final PFMTransaction pFMTransaction, final AlertDialog alertDialog, final C12889fL5 c12889fL5, View view) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        gVar.C1().m3(AbstractC18306oR4.a(pFMTransaction)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.BR4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.pfm.g.I1(this.a, pFMTransaction, alertDialog, c12889fL5, (C19938rB7) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(g gVar, PFMTransaction pFMTransaction, AlertDialog alertDialog, C12889fL5 c12889fL5, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        gVar.C1().U2(pFMTransaction);
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        MY my = (MY) c12889fL5.a;
        if (my != null) {
            my.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(C12889fL5 c12889fL5, AlertDialog alertDialog, View view) {
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        MY my = (MY) c12889fL5.a;
        if (my != null) {
            my.o();
        }
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private final void L1(MY my, String str, PFMTransaction pFMTransaction) {
        if (my != null) {
            my.o();
        }
        this.u.b.setVisibility(0);
        this.u.q.setText(str);
        pFMTransaction.j(str);
    }

    private final void M1() {
        if (this.u.getRoot().getTop() == 0 && !this.y && C1().h2()) {
            D20.a aVarA = C10600bs7.a.a(this.x);
            aVarA.X1("<b>گزینه\u200cهای تراکنش  <br> </b>افزودن توضیحات، و حذف تراکنش");
            aVarA.c2(true);
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            aVarA.R1(aVar.f(10.0f));
            aVarA.a1(0.85f);
            aVarA.j2(false);
            aVarA.b2(5);
            D20 d20A = aVarA.a();
            ImageView imageView = this.u.c;
            AbstractC13042fc3.h(imageView, "imageViewMore");
            d20A.M0(imageView, aVar.f((this.u.c.getWidth() / 2) + C22078ud6.a(11.0f)), 0);
            C1().t3(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h O1(g gVar) {
        AbstractC13042fc3.i(gVar, "this$0");
        return (h) new G(gVar.z).b(h.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(g gVar, PFMTransaction pFMTransaction, View view) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        gVar.v.invoke(pFMTransaction, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(final g gVar, final PFMTransaction pFMTransaction, final C12889fL5 c12889fL5, View view) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        final NY nyO = new NY(gVar.w).E(4).j(false).l(true).e(true).u(gVar.w.getString(AbstractC12217eE5.negative_remove_custom_tag)).c(false).D(gVar.w.getString(AbstractC12217eE5.pfm_description_empty)).s(new View.OnClickListener() { // from class: ir.nasim.JR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ir.nasim.features.pfm.g.y1(c12889fL5, view2);
            }
        }).d(true).i("").m(30).o(gVar.w.getString(AbstractC12217eE5.input_description));
        if (pFMTransaction.getDetail().length() == 0) {
            O8 o8C = O8.c(LayoutInflater.from(gVar.w));
            AbstractC13042fc3.h(o8C, "inflate(...)");
            AlertDialog.a aVar = new AlertDialog.a(gVar.w);
            aVar.n(o8C.getRoot());
            aVar.b(true);
            o8C.d.setTypeface(C6011Lu2.k());
            o8C.h.setTypeface(C6011Lu2.k());
            ImageView imageView = o8C.f;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            imageView.setColorFilter(c5495Jo7.d2());
            o8C.g.setColorFilter(c5495Jo7.J0());
            final AlertDialog alertDialogA = aVar.a();
            o8C.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.KR4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ir.nasim.features.pfm.g.i1(alertDialogA, nyO, gVar, c12889fL5, pFMTransaction, view2);
                }
            });
            o8C.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.LR4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ir.nasim.features.pfm.g.o1(this.a, pFMTransaction, alertDialogA, view2);
                }
            });
            alertDialogA.show();
            return;
        }
        C19263q32 c19263q32C = C19263q32.c(LayoutInflater.from(gVar.w));
        AbstractC13042fc3.h(c19263q32C, "inflate(...)");
        AlertDialog.a aVar2 = new AlertDialog.a(gVar.w);
        aVar2.n(c19263q32C.getRoot());
        aVar2.b(true);
        c19263q32C.g.setTypeface(C6011Lu2.k());
        c19263q32C.k.setTypeface(C6011Lu2.k());
        c19263q32C.b.setTypeface(C6011Lu2.k());
        ImageView imageView2 = c19263q32C.h;
        C5495Jo7 c5495Jo72 = C5495Jo7.a;
        imageView2.setColorFilter(c5495Jo72.d2());
        c19263q32C.i.setColorFilter(c5495Jo72.d2());
        c19263q32C.j.setColorFilter(c5495Jo72.J0());
        final AlertDialog alertDialogA2 = aVar2.a();
        c19263q32C.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.MR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ir.nasim.features.pfm.g.p1(alertDialogA2, gVar, c12889fL5, pFMTransaction, view2);
            }
        });
        c19263q32C.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ir.nasim.features.pfm.g.r1(alertDialogA2, nyO, gVar, pFMTransaction, c12889fL5, view2);
            }
        });
        c19263q32C.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ir.nasim.features.pfm.g.x1(this.a, pFMTransaction, alertDialogA2, view2);
            }
        });
        alertDialogA2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(AlertDialog alertDialog, NY ny, final g gVar, final C12889fL5 c12889fL5, final PFMTransaction pFMTransaction, View view) {
        AbstractC13042fc3.i(alertDialog, "$addDescriptionAlertDialog");
        AbstractC13042fc3.i(ny, "$builder");
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        alertDialog.dismiss();
        ny.p(KB5.ic_description);
        ny.B(gVar.w.getString(AbstractC12217eE5.add_description));
        ny.x(gVar.w.getString(AbstractC12217eE5.add_custom_tag_btn));
        ny.v(new View.OnClickListener() { // from class: ir.nasim.uR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ir.nasim.features.pfm.g.j1(c12889fL5, gVar, pFMTransaction, view2);
            }
        });
        MY myA = ny.a();
        c12889fL5.a = myA;
        if (myA != null) {
            myA.z();
        }
        new Handler().postDelayed(new Runnable() { // from class: ir.nasim.vR4
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.pfm.g.n1(c12889fL5);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(final C12889fL5 c12889fL5, final g gVar, final PFMTransaction pFMTransaction, View view) {
        AppCompatEditText appCompatEditTextQ;
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        MY my = (MY) c12889fL5.a;
        final String strValueOf = String.valueOf((my == null || (appCompatEditTextQ = my.q()) == null) ? null : appCompatEditTextQ.getText());
        if (strValueOf.length() == 0) {
            MY my2 = (MY) c12889fL5.a;
            if (my2 != null) {
                MY.B(my2, gVar.w.getString(AbstractC12217eE5.description_can_not_empty), false, 2, null);
                return;
            }
            return;
        }
        if (gVar.B) {
            gVar.L1((MY) c12889fL5.a, strValueOf, pFMTransaction);
        } else {
            gVar.C1().F1(AbstractC18306oR4.a(pFMTransaction), strValueOf).m0(new InterfaceC24449ye1() { // from class: ir.nasim.ER4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.pfm.g.l1(this.a, c12889fL5, strValueOf, pFMTransaction, (C19938rB7) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(g gVar, C12889fL5 c12889fL5, String str, PFMTransaction pFMTransaction, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        AbstractC13042fc3.i(str, "$descriptionText");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        gVar.L1((MY) c12889fL5.a, str, pFMTransaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(C12889fL5 c12889fL5) {
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        MY my = (MY) c12889fL5.a;
        C23381wp3.g(my != null ? my.q() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(g gVar, PFMTransaction pFMTransaction, AlertDialog alertDialog, View view) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        AbstractC13042fc3.i(alertDialog, "$addDescriptionAlertDialog");
        gVar.F1(pFMTransaction, alertDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(AlertDialog alertDialog, final g gVar, final C12889fL5 c12889fL5, final PFMTransaction pFMTransaction, View view) {
        AbstractC13042fc3.i(alertDialog, "$editDescriptionAlertDialog");
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        alertDialog.dismiss();
        if (gVar.B) {
            gVar.D1((MY) c12889fL5.a, pFMTransaction);
        } else {
            gVar.C1().F1(AbstractC18306oR4.a(pFMTransaction), "").m0(new InterfaceC24449ye1() { // from class: ir.nasim.wR4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.pfm.g.q1(this.a, c12889fL5, pFMTransaction, (C19938rB7) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(g gVar, C12889fL5 c12889fL5, PFMTransaction pFMTransaction, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        gVar.D1((MY) c12889fL5.a, pFMTransaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(AlertDialog alertDialog, NY ny, final g gVar, final PFMTransaction pFMTransaction, final C12889fL5 c12889fL5, View view) {
        AbstractC13042fc3.i(alertDialog, "$editDescriptionAlertDialog");
        AbstractC13042fc3.i(ny, "$builder");
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        alertDialog.dismiss();
        ny.p(KB5.ic_edit_description);
        ny.B(gVar.w.getString(AbstractC12217eE5.edit_description));
        ny.x(gVar.w.getString(AbstractC12217eE5.edit));
        ny.z(pFMTransaction.getDetail());
        ny.v(new View.OnClickListener() { // from class: ir.nasim.xR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ir.nasim.features.pfm.g.s1(c12889fL5, pFMTransaction, gVar, view2);
            }
        });
        MY myA = ny.a();
        c12889fL5.a = myA;
        if (myA != null) {
            myA.z();
        }
        new Handler().postDelayed(new Runnable() { // from class: ir.nasim.yR4
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.pfm.g.u1(c12889fL5);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(final C12889fL5 c12889fL5, final PFMTransaction pFMTransaction, final g gVar, View view) {
        AppCompatEditText appCompatEditTextQ;
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        AbstractC13042fc3.i(gVar, "this$0");
        MY my = (MY) c12889fL5.a;
        final String strValueOf = String.valueOf((my == null || (appCompatEditTextQ = my.q()) == null) ? null : appCompatEditTextQ.getText());
        if (AbstractC13042fc3.d(strValueOf, pFMTransaction.getDetail())) {
            MY my2 = (MY) c12889fL5.a;
            if (my2 != null) {
                my2.C(gVar.w.getString(AbstractC12217eE5.no_change_in_the_text));
                return;
            }
            return;
        }
        if (strValueOf.length() == 0) {
            MY my3 = (MY) c12889fL5.a;
            if (my3 != null) {
                MY.B(my3, gVar.w.getString(AbstractC12217eE5.description_can_not_empty), false, 2, null);
                return;
            }
            return;
        }
        if (gVar.B) {
            gVar.L1((MY) c12889fL5.a, strValueOf, pFMTransaction);
        } else {
            gVar.C1().F1(AbstractC18306oR4.a(pFMTransaction), strValueOf).m0(new InterfaceC24449ye1() { // from class: ir.nasim.DR4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.pfm.g.t1(this.a, c12889fL5, strValueOf, pFMTransaction, (C19938rB7) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(g gVar, C12889fL5 c12889fL5, String str, PFMTransaction pFMTransaction, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        AbstractC13042fc3.i(str, "$descriptionText");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        gVar.L1((MY) c12889fL5.a, str, pFMTransaction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(C12889fL5 c12889fL5) {
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        MY my = (MY) c12889fL5.a;
        C23381wp3.g(my != null ? my.q() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(g gVar, PFMTransaction pFMTransaction, AlertDialog alertDialog, View view) {
        AbstractC13042fc3.i(gVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "$pfmTransaction");
        AbstractC13042fc3.i(alertDialog, "$editDescriptionAlertDialog");
        gVar.F1(pFMTransaction, alertDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(C12889fL5 c12889fL5, View view) {
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        MY my = (MY) c12889fL5.a;
        if (my != null) {
            my.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(g gVar) {
        AbstractC13042fc3.i(gVar, "this$0");
        gVar.M1();
    }

    public final void e1(final PFMTransaction pFMTransaction, boolean z) {
        PFMTag pFMTag;
        Long dateTimeStamp;
        AbstractC13042fc3.i(pFMTransaction, "pfmTransaction");
        EnumC18897pR4 transactionType = pFMTransaction.getTransactionType();
        int i = transactionType == null ? -1 : b.a[transactionType.ordinal()];
        if (i == 1) {
            this.u.g.setText(this.a.getContext().getString(AbstractC12217eE5.deposit));
            this.u.g.setTextColor(C5495Jo7.a.f2());
        } else if (i == 2) {
            this.u.g.setText(this.a.getContext().getString(AbstractC12217eE5.withdraw));
            this.u.g.setTextColor(C5495Jo7.a.X0());
        }
        final C12889fL5 c12889fL5 = new C12889fL5();
        String str = XY6.e(XY6.e(GY6.g(pFMTransaction.getAmount()))) + this.a.getContext().getString(AbstractC12217eE5.rail_with_before_space);
        this.u.g.setVisibility(0);
        this.u.f.setText(str);
        if (pFMTransaction.getDateTimeStamp() == null || ((dateTimeStamp = pFMTransaction.getDateTimeStamp()) != null && dateTimeStamp.longValue() == 0)) {
            this.u.k.setText(G.a(new D45(Long.valueOf(pFMTransaction.getDate()))));
        } else {
            this.u.k.setText(G.a(new D45(pFMTransaction.getDateTimeStamp())));
        }
        this.u.e.setText(pFMTransaction.getDescription());
        if (this.B) {
            this.u.k.setVisibility(8);
            this.u.e.setVisibility(8);
        }
        if (pFMTransaction.getLabels().isEmpty()) {
            this.u.j.setTextColor(C5495Jo7.a.a0());
            this.u.m.setVisibility(8);
            this.u.j.setText(this.a.getContext().getString(AbstractC12217eE5.set_tag));
            this.u.i.setImageResource(KB5.ic_set_tag_pfm);
            ImageView imageView = this.u.n;
            AbstractC13042fc3.h(imageView, "tagEditIv");
            imageView.setVisibility(8);
        } else {
            Object obj = pFMTransaction.getLabels().get(0);
            PFMTag pFMTag2 = (PFMTag) obj;
            if (pFMTag2.getUserId() != 0 && (pFMTag = (PFMTag) C23077wJ2.a.f().get(Long.valueOf(pFMTag2.getId()))) != null) {
                obj = pFMTag;
            }
            ImageView imageView2 = this.u.n;
            AbstractC13042fc3.h(imageView2, "tagEditIv");
            imageView2.setVisibility(0);
            this.u.j.setTextColor(C5495Jo7.a.f1());
            PFMTag pFMTag3 = (PFMTag) obj;
            if (RQ4.a(pFMTag3)) {
                this.u.m.setVisibility(0);
                TextView textView = this.u.j;
                PFMTag parentTag = pFMTag3.getParentTag();
                AbstractC13042fc3.f(parentTag);
                textView.setText(parentTag.getLabel());
                this.u.h.setText(pFMTag3.getLabel());
                ImageView imageView3 = this.u.i;
                PFMTag parentTag2 = pFMTag3.getParentTag();
                AbstractC13042fc3.f(parentTag2);
                imageView3.setImageDrawable(E1(parentTag2));
                ImageView imageView4 = this.u.i;
                AbstractC13042fc3.h(imageView4, "pfmTagIv");
                imageView4.setPadding(0, 0, 0, 0);
            } else {
                this.u.j.setText(pFMTag3.getLabel());
                this.u.m.setVisibility(8);
                this.u.i.setImageDrawable(E1(pFMTag3));
                ImageView imageView5 = this.u.i;
                AbstractC13042fc3.h(imageView5, "pfmTagIv");
                imageView5.setPadding(0, 0, 0, 0);
            }
        }
        this.u.o.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.g.f1(this.a, pFMTransaction, view);
            }
        });
        if (!pFMTransaction.getLabels().isEmpty()) {
            final PFMTag pFMTag4 = (PFMTag) pFMTransaction.getLabels().get(0);
            if (RQ4.a(pFMTag4)) {
                this.u.m.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.CR4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ir.nasim.features.pfm.g.A1(this.a, pFMTransaction, pFMTag4, view);
                    }
                });
            }
        }
        this.u.n.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.FR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.g.B1(this.a, pFMTransaction, view);
            }
        });
        if (pFMTransaction.getDetail().length() == 0) {
            this.u.b.setVisibility(8);
        } else {
            this.u.b.setVisibility(0);
            this.u.q.setText(pFMTransaction.getDetail());
        }
        this.u.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.GR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.g.g1(this.a, pFMTransaction, c12889fL5, view);
            }
        });
        LinearLayout linearLayout = this.u.o;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        linearLayout.setBackground(AbstractC4310Eo7.j(c5495Jo7.B2(), c5495Jo7.y0(c5495Jo7.g0(), 18), 5));
        this.u.m.setBackground(AbstractC4310Eo7.j(c5495Jo7.B2(), c5495Jo7.y0(c5495Jo7.g0(), 18), 5));
        if (J || !C1().h2()) {
            return;
        }
        J = true;
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.HR4
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.pfm.g.z1(this.a);
            }
        }, 500L);
    }
}
