package ir.nasim;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.contact.data.ContactItem;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.mxp.entity.PuppetGroup;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\b*\u0002\u001fo\b\u0007\u0018\u0000 t2\u00020\u0001:\u0001uB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020#H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020#2\u0006\u0010)\u001a\u00020\u001aH\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00042\u0006\u0010&\u001a\u00020#H\u0002¢\u0006\u0004\b0\u0010(J\u0017\u00101\u001a\u00020\u00042\u0006\u0010&\u001a\u00020#H\u0002¢\u0006\u0004\b1\u0010(J\u0017\u00102\u001a\u00020\u00042\u0006\u0010&\u001a\u00020#H\u0002¢\u0006\u0004\b2\u0010(J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00042\u0006\u0010&\u001a\u00020#H\u0002¢\u0006\u0004\b7\u0010(J\u001d\u0010:\u001a\b\u0012\u0004\u0012\u000203092\u0006\u00108\u001a\u000203H\u0002¢\u0006\u0004\b:\u0010;J\u0015\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020=H\u0002¢\u0006\u0004\b@\u0010AJ\u0019\u0010D\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bD\u0010EJ+\u0010K\u001a\u00020J2\u0006\u0010G\u001a\u00020F2\b\u0010I\u001a\u0004\u0018\u00010H2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bK\u0010LJ!\u0010N\u001a\u00020\u00042\u0006\u0010M\u001a\u00020J2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bN\u0010OJ/\u0010S\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u000e\u0010P\u001a\n\u0012\u0006\b\u0001\u0012\u000203092\u0006\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0004H\u0016¢\u0006\u0004\bU\u0010\u0003R\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001b\u0010a\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010^\u001a\u0004\bg\u0010hR\u0016\u0010l\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010^\u001a\u0004\bq\u0010r¨\u0006v"}, d2 = {"Lir/nasim/tj1;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "va", "Da", "Ba", "Aa", "Lir/nasim/contact/data/ContactItem$MxpPuppetContactItem;", "item", "Ka", "(Lir/nasim/contact/data/ContactItem$MxpPuppetContactItem;)V", "Lir/nasim/fj1;", "it", "Ta", "(Lir/nasim/fj1;)V", "Pa", "Na", "Ha", "adapter", "la", "Ca", "Ea", "na", "Fa", "", "isVisible", "Ya", "(Z)V", "sa", "ir/nasim/tj1$e", "ra", "()Lir/nasim/tj1$e;", "Lir/nasim/XI4;", "Lir/nasim/contact/data/ContactItem$BaleContactItem;", "pa", "()Lir/nasim/XI4;", "contact", "Ja", "(Lir/nasim/contact/data/ContactItem$BaleContactItem;)V", "isVideo", "Va", "(Lir/nasim/contact/data/ContactItem$BaleContactItem;Z)V", "", "requestCode", "Ma", "(I)V", "Ra", "La", "ua", "", "msg", "Ua", "(Ljava/lang/String;)V", "ta", "contactName", "", "oa", "(Ljava/lang/String;)[Ljava/lang/String;", "Lir/nasim/vJ4;", "Lir/nasim/contact/data/ContactItem$PhoneBookContactItem;", "qa", "()Lir/nasim/vJ4;", "Oa", "(Lir/nasim/contact/data/ContactItem$PhoneBookContactItem;)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "permissions", "", "grantResults", "g7", "(I[Ljava/lang/String;[I)V", "T6", "Lir/nasim/Nx2;", "h1", "Lir/nasim/bW7;", "wa", "()Lir/nasim/Nx2;", "binding", "Lir/nasim/yj1;", "i1", "Lir/nasim/Yu3;", "za", "()Lir/nasim/yj1;", "viewModel", "j1", "Lir/nasim/contact/data/ContactItem$BaleContactItem;", "selectedContactItem", "Lir/nasim/n10;", "k1", "xa", "()Lir/nasim/n10;", "callErrorsSnackBar", "l1", "Z", "isFromCallLog", "m1", "Lir/nasim/fj1;", "ir/nasim/tj1$j", "n1", "ya", "()Lir/nasim/tj1$j;", "onMxpClickListener", "o1", "a", "contact_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.tj1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C21543tj1 extends AbstractC14805iW2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new p(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: j1, reason: from kotlin metadata */
    private ContactItem.BaleContactItem selectedContactItem;

    /* renamed from: k1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 callErrorsSnackBar;

    /* renamed from: l1, reason: from kotlin metadata */
    private boolean isFromCallLog;

    /* renamed from: m1, reason: from kotlin metadata */
    private C13137fj1 adapter;

    /* renamed from: n1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 onMxpClickListener;
    static final /* synthetic */ InterfaceC5239Im3[] p1 = {AbstractC10882cM5.i(new C25226zw5(C21543tj1.class, "binding", "getBinding()Lir/nasim/contact/databinding/FragmentContactsSearchBinding;", 0))};

    /* renamed from: o1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q1 = 8;

    /* renamed from: ir.nasim.tj1$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final C21543tj1 a(ContactItem[] contactItemArr, boolean z) {
            AbstractC13042fc3.i(contactItemArr, "initialItems");
            Bundle bundle = new Bundle();
            bundle.putSerializable("keyInitialPagingData", contactItemArr);
            bundle.putBoolean("isFromCallLog", z);
            C21543tj1 c21543tj1 = new C21543tj1();
            c21543tj1.a8(bundle);
            return c21543tj1;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tj1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.tj1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C21543tj1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21543tj1 c21543tj1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c21543tj1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    NT4 nt4 = (NT4) this.c;
                    C13137fj1 c13137fj1 = this.d.adapter;
                    if (c13137fj1 != null) {
                        this.b = 1;
                        if (c13137fj1.L(nt4, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21543tj1.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6J1 = C21543tj1.this.za().j1();
                a aVar = new a(C21543tj1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6J1, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tj1$c */
    public static final class c implements XI4 {
        c() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(ContactItem.BaleContactItem baleContactItem) {
            AbstractC13042fc3.i(baleContactItem, "item");
            C21543tj1.this.Ja(baleContactItem);
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(ContactItem.BaleContactItem baleContactItem) {
            AbstractC13042fc3.i(baleContactItem, "item");
            C21543tj1.this.Ra(baleContactItem);
            return true;
        }

        @Override // ir.nasim.XI4
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void l5(ContactItem.BaleContactItem baleContactItem) {
            AbstractC13042fc3.i(baleContactItem, "item");
            C21543tj1.this.Va(baleContactItem, false);
        }
    }

    /* renamed from: ir.nasim.tj1$d */
    public static final class d implements InterfaceC22483vJ4 {
        d() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(ContactItem.PhoneBookContactItem phoneBookContactItem) {
            AbstractC13042fc3.i(phoneBookContactItem, "item");
            C21543tj1.this.Oa(phoneBookContactItem);
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(ContactItem.PhoneBookContactItem phoneBookContactItem) {
            AbstractC13042fc3.i(phoneBookContactItem, "item");
            return false;
        }
    }

    /* renamed from: ir.nasim.tj1$f */
    /* synthetic */ class f extends EB2 implements SA2 {
        f(Object obj) {
            super(0, obj, C21543tj1.class, "onInvitationViaLink", "onInvitationViaLink()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C21543tj1) this.receiver).Ha();
        }
    }

    /* renamed from: ir.nasim.tj1$g */
    public static final class g implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.tj1$g$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.tj1$g$a$a, reason: collision with other inner class name */
            public static final class C1598a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1598a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C21543tj1.g.a.C1598a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.tj1$g$a$a r0 = (ir.nasim.C21543tj1.g.a.C1598a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.tj1$g$a$a r0 = new ir.nasim.tj1$g$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L45
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.gZ0 r5 = (ir.nasim.C13628gZ0) r5
                    ir.nasim.iG3 r5 = r5.e()
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L45
                    return r1
                L45:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21543tj1.g.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public g(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tj1$h */
    public static final class h implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C13137fj1 b;

        /* renamed from: ir.nasim.tj1$h$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C13137fj1 b;

            /* renamed from: ir.nasim.tj1$h$a$a, reason: collision with other inner class name */
            public static final class C1599a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1599a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C13137fj1 c13137fj1) {
                this.a = interfaceC4806Gq2;
                this.b = c13137fj1;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C21543tj1.h.a.C1599a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.tj1$h$a$a r0 = (ir.nasim.C21543tj1.h.a.C1599a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.tj1$h$a$a r0 = new ir.nasim.tj1$h$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L62
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.iG3 r5 = (ir.nasim.C14653iG3) r5
                    ir.nasim.gG3 r2 = r5.f()
                    boolean r2 = r2 instanceof ir.nasim.AbstractC13460gG3.c
                    if (r2 == 0) goto L54
                    ir.nasim.gG3 r5 = r5.d()
                    boolean r5 = r5.a()
                    if (r5 == 0) goto L54
                    ir.nasim.fj1 r5 = r4.b
                    int r5 = r5.getItemCount()
                    if (r5 != 0) goto L54
                    r5 = r3
                    goto L55
                L54:
                    r5 = 0
                L55:
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L62
                    return r1
                L62:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21543tj1.h.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public h(InterfaceC4557Fq2 interfaceC4557Fq2, C13137fj1 c13137fj1) {
            this.a = interfaceC4557Fq2;
            this.b = c13137fj1;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tj1$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC4557Fq2 c;
        final /* synthetic */ C21543tj1 d;

        /* renamed from: ir.nasim.tj1$i$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ C21543tj1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C21543tj1 c21543tj1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c21543tj1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.Ya(this.c);
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(InterfaceC4557Fq2 interfaceC4557Fq2, C21543tj1 c21543tj1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC4557Fq2;
            this.d = c21543tj1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2 = this.c;
                a aVar = new a(this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tj1$j */
    public static final class j implements EJ4 {
        j() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(ContactItem.MxpPuppetContactItem mxpPuppetContactItem) {
            AbstractC13042fc3.i(mxpPuppetContactItem, "item");
            C21543tj1.this.Ka(mxpPuppetContactItem);
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(ContactItem.MxpPuppetContactItem mxpPuppetContactItem) {
            AbstractC13042fc3.i(mxpPuppetContactItem, "item");
            return false;
        }

        @Override // ir.nasim.EJ4
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void L0(ContactItem.MxpPuppetContactItem mxpPuppetContactItem) {
            AbstractC13042fc3.i(mxpPuppetContactItem, "item");
            C21543tj1.this.Ka(mxpPuppetContactItem);
        }
    }

    /* renamed from: ir.nasim.tj1$l */
    public static final class l implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.tj1$l$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.tj1$l$a$a, reason: collision with other inner class name */
            public static final class C1600a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1600a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C21543tj1.l.a.C1600a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.tj1$l$a$a r0 = (ir.nasim.C21543tj1.l.a.C1600a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.tj1$l$a$a r0 = new ir.nasim.tj1$l$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L4f
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.gZ0 r5 = (ir.nasim.C13628gZ0) r5
                    ir.nasim.iG3 r5 = r5.e()
                    ir.nasim.gG3 r5 = r5.f()
                    boolean r5 = r5 instanceof ir.nasim.AbstractC13460gG3.c
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L4f
                    return r1
                L4f:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21543tj1.l.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public l(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tj1$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC4557Fq2 c;
        final /* synthetic */ C21543tj1 d;

        /* renamed from: ir.nasim.tj1$m$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C21543tj1 a;

            a(C21543tj1 c21543tj1) {
                this.a = c21543tj1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
            }

            public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                if (z) {
                    this.a.Na();
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(InterfaceC4557Fq2 interfaceC4557Fq2, C21543tj1 c21543tj1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC4557Fq2;
            this.d = c21543tj1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new m(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2 = this.c;
                a aVar = new a(this.d);
                this.b = 1;
                if (interfaceC4557Fq2.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tj1$n */
    /* synthetic */ class n extends C23553x7 implements InterfaceC15796kB2 {
        public static final n h = new n();

        n() {
            super(3, Boolean.TYPE, "and", "and(Z)Z", 4);
        }

        public final Object a(boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21543tj1.Qa(z, z2, interfaceC20295rm1);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.tj1$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C13137fj1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(C13137fj1 c13137fj1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c13137fj1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21543tj1.this.new o(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Bundle bundleE5 = C21543tj1.this.E5();
                Object obj2 = bundleE5 != null ? bundleE5.get("keyInitialPagingData") : null;
                ContactItem[] contactItemArr = obj2 instanceof ContactItem[] ? (ContactItem[]) obj2 : null;
                if (contactItemArr == null) {
                    return C19938rB7.a;
                }
                if (!(contactItemArr.length == 0)) {
                    C13137fj1 c13137fj1 = this.d;
                    NT4 nt4B = NT4.e.b(AbstractC10242bK.f1(contactItemArr));
                    this.b = 1;
                    if (c13137fj1.L(nt4B, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tj1$p */
    public static final class p extends AbstractC8614Ws3 implements UA2 {
        public p() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C6532Nx2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.tj1$q */
    public static final class q extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.tj1$r */
    public static final class r extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.tj1$s */
    public static final class s extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.tj1$t */
    public static final class t extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.tj1$u */
    public static final class u extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    /* renamed from: ir.nasim.tj1$v */
    /* synthetic */ class v extends EB2 implements UA2 {
        v(Object obj) {
            super(1, obj, C21543tj1.class, "requestStartCallPermission", "requestStartCallPermission(I)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y(((Number) obj).intValue());
            return C19938rB7.a;
        }

        public final void y(int i) {
            ((C21543tj1) this.receiver).Ma(i);
        }
    }

    public C21543tj1() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new r(new q(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C24499yj1.class), new s(interfaceC9173Yu3B), new t(null, interfaceC9173Yu3B), new u(this, interfaceC9173Yu3B));
        this.callErrorsSnackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21543tj1.ma(this.a);
            }
        });
        this.onMxpClickListener = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21543tj1.Ia(this.a);
            }
        });
    }

    private final void Aa() {
        C13137fj1 c13137fj1 = new C13137fj1(new f(this), null, null, null, pa(), ya(), qa(), null, this.isFromCallLog, 128, null);
        la(c13137fj1);
        Ta(c13137fj1);
        this.adapter = c13137fj1;
    }

    private final void Ba() {
        wa().d.b.setTypeface(C6011Lu2.i());
    }

    private final void Ca() {
        BaleToolbar baleToolbar = wa().e;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        String strH6 = h6(AbstractC12217eE5.contacts_search_hint);
        AbstractC13042fc3.h(strH6, "getString(...)");
        baleToolbar.setHasSearchButton(strH6, ra(), true);
    }

    private final void Da() {
        wa();
        Ca();
        Aa();
        Ba();
        Pa();
    }

    private final void Ea() {
        na();
        Fa();
    }

    private final void Fa() {
        C13137fj1 c13137fj1 = this.adapter;
        if (c13137fj1 == null) {
            return;
        }
        AbstractC16751lo1.a(this).e(new i(AbstractC6459Nq2.v(new h(new g(AbstractC6459Nq2.x(c13137fj1.E(), new UA2() { // from class: ir.nasim.sj1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C21543tj1.Ga((C13628gZ0) obj);
            }
        })), c13137fj1)), this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC13460gG3 Ga(C13628gZ0 c13628gZ0) {
        AbstractC13042fc3.i(c13628gZ0, "it");
        return c13628gZ0.e().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ha() {
        String strN2 = AbstractC5969Lp4.d().n2();
        AbstractC13042fc3.h(strN2, "getInviteMessage(...)");
        String strM = AbstractC20153rZ6.M(strN2, "{inviteUrl}", za().e1(), false, 4, null);
        String strF = C5735Kp4.w().f();
        AbstractC13042fc3.h(strF, "getAppName(...)");
        String strM2 = AbstractC20153rZ6.M(strM, "{appName}", strF, false, 4, null);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", strM2);
        intent.setType("text/plain");
        n8(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j Ia(C21543tj1 c21543tj1) {
        AbstractC13042fc3.i(c21543tj1, "this$0");
        return c21543tj1.new j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja(ContactItem.BaleContactItem contact) {
        C18987pb3 c18987pb3 = C18987pb3.a;
        C11458d25 c11458d25E = C11458d25.E(contact.getId());
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        if (!c18987pb3.w1(c11458d25E, null, false)) {
            Ua("Failed to open " + contact.getName() + " chat");
        }
        C3343Am.g("contacts_click_on_a_contact");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ka(ContactItem.MxpPuppetContactItem item) {
        C19100pm6.s1.a(new PuppetGroup(item.getName(), item.getPuppets())).L8(F5(), "mxpContactBottomSheet");
    }

    private final void La(ContactItem.BaleContactItem contact) {
        InterfaceC14830iZ0 interfaceC14830iZ0K1 = AbstractC5969Lp4.d().k1(contact.getId());
        if (interfaceC14830iZ0K1 == null) {
            ua(contact);
        } else {
            R8(interfaceC14830iZ0K1, AbstractC12217eE5.contacts_menu_remove_progress, new k(contact));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma(int requestCode) {
        if (requestCode == 1011 || requestCode == 1012) {
            C5505Jq.L(this, requestCode, null);
            return;
        }
        if (requestCode == 1014) {
            C5505Jq.J(this, requestCode, null);
        } else if (requestCode == 1019 || requestCode == 1020) {
            C5505Jq.K(this, requestCode, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Na() {
        wa().c.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oa(ContactItem.PhoneBookContactItem item) {
        n8(C20778sb3.a.a(item.getPhoneNumber(), Y8(AbstractC12217eE5.invitation_via_sms)));
    }

    private final void Pa() {
        C13137fj1 c13137fj1 = this.adapter;
        if (c13137fj1 == null) {
            return;
        }
        AbstractC16751lo1.a(this).e(new m(AbstractC6459Nq2.p(AbstractC6459Nq2.v(new l(c13137fj1.E())), za().f1(), n.h), this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object Qa(boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC6392Nk0.a(z & z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ra(final ContactItem.BaleContactItem contact) {
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        new AlertDialog.a(fragmentActivityQ7).h(oa(contact.getName()), new DialogInterface.OnClickListener() { // from class: ir.nasim.nj1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C21543tj1.Sa(this.a, contact, dialogInterface, i2);
            }
        }).o().setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(C21543tj1 c21543tj1, ContactItem.BaleContactItem baleContactItem, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c21543tj1, "this$0");
        AbstractC13042fc3.i(baleContactItem, "$contact");
        if (i2 == 0) {
            c21543tj1.ta(baleContactItem);
        } else if (i2 == 1) {
            c21543tj1.La(baleContactItem);
        }
        dialogInterface.dismiss();
    }

    private final void Ta(C13137fj1 it) {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new o(it, null), 3, null);
    }

    private final void Ua(String msg) {
        ConstraintLayout root = wa().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.k(wa().getRoot());
        c17468n10.o(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Va(ContactItem.BaleContactItem contact, boolean isVideo) {
        this.selectedContactItem = contact;
        C11458d25 c11458d25E = C11458d25.E(contact.getId());
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        C20384rv0 c20384rv0 = C20384rv0.a;
        C20384rv0.c0(c11458d25E.getPeerId(), isVideo, new SA2() { // from class: ir.nasim.oj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21543tj1.Wa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.pj1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21543tj1.Xa(this.a);
            }
        }, new v(this));
        C5074Hu0.a.d(EnumC22288uz0.e, isVideo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Wa(C21543tj1 c21543tj1) {
        AbstractC13042fc3.i(c21543tj1, "this$0");
        C17468n10 c17468n10Xa = c21543tj1.xa();
        String strH6 = c21543tj1.h6(AbstractC12217eE5.not_possible_to_use_when_calling);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10Xa.o(strH6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Xa(C21543tj1 c21543tj1) {
        AbstractC13042fc3.i(c21543tj1, "this$0");
        FragmentActivity fragmentActivityQ7 = c21543tj1.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C24398yZ.c(fragmentActivityQ7, c21543tj1).show();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ya(boolean isVisible) {
        C6532Nx2 c6532Nx2Wa = wa();
        RecyclerView recyclerView = c6532Nx2Wa.c;
        AbstractC13042fc3.h(recyclerView, "container");
        recyclerView.setVisibility(isVisible ^ true ? 0 : 8);
        LinearLayout root = c6532Nx2Wa.d.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        root.setVisibility(isVisible ? 0 : 8);
    }

    private final void la(C13137fj1 adapter) {
        wa().c.setAdapter(adapter.N(new VT4()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 ma(C21543tj1 c21543tj1) {
        AbstractC13042fc3.i(c21543tj1, "this$0");
        ConstraintLayout root = c21543tj1.wa().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.m(4000);
        return c17468n10;
    }

    private final void na() {
        AbstractC16751lo1.a(this).b(new b(null));
    }

    private final String[] oa(String contactName) {
        String strH6 = h6(AbstractC12217eE5.contacts_menu_edit);
        String strH62 = h6(AbstractC12217eE5.contacts_menu_remove);
        AbstractC13042fc3.h(strH62, "getString(...)");
        return new String[]{strH6, AbstractC20153rZ6.O(strH62, "{0}", contactName, false, 4, null)};
    }

    private final XI4 pa() {
        return new c();
    }

    private final InterfaceC22483vJ4 qa() {
        return new d();
    }

    private final e ra() {
        return new e();
    }

    private final void sa() {
        this.adapter = null;
        wa().c.setAdapter(null);
    }

    private final void ta(ContactItem.BaleContactItem contact) {
        int id = contact.getId();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        n8(C22055ub3.c(id, contextS7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua(ContactItem.BaleContactItem contact) {
        Ua("Failed to remove " + contact.getName() + " from your contacts");
    }

    private final void va() {
        Bundle bundleE5 = E5();
        boolean z = false;
        if (bundleE5 != null && bundleE5.getBoolean("isFromCallLog", false)) {
            z = true;
        }
        this.isFromCallLog = z;
    }

    private final C6532Nx2 wa() {
        Object objA = this.binding.a(this, p1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C6532Nx2) objA;
    }

    private final C17468n10 xa() {
        return (C17468n10) this.callErrorsSnackBar.getValue();
    }

    private final j ya() {
        return (j) this.onMxpClickListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C24499yj1 za() {
        return (C24499yj1) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        va();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C6532Nx2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        sa();
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int requestCode, String[] permissions, int[] grantResults) {
        ContactItem.BaleContactItem baleContactItem;
        ContactItem.BaleContactItem baleContactItem2;
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        if (requestCode != 1011) {
            if (requestCode != 1012 && requestCode != 1014) {
                if (requestCode != 1019) {
                    if (requestCode != 1020) {
                        super.g7(requestCode, permissions, grantResults);
                        return;
                    }
                }
            }
            Integer numD0 = AbstractC10242bK.d0(grantResults);
            if (numD0 == null || numD0.intValue() != 0 || (baleContactItem2 = this.selectedContactItem) == null) {
                return;
            }
            Va(baleContactItem2, true);
            return;
        }
        Integer numD02 = AbstractC10242bK.d0(grantResults);
        if (numD02 == null || numD02.intValue() != 0 || (baleContactItem = this.selectedContactItem) == null) {
            return;
        }
        Va(baleContactItem, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Da();
        Ea();
    }

    /* renamed from: ir.nasim.tj1$e */
    public static final class e implements InterfaceC4228Ef6 {
        e() {
        }

        @Override // ir.nasim.InterfaceC4228Ef6
        public void a(String str) {
            AbstractC13042fc3.i(str, "query");
            C21543tj1.this.za().p1(str);
        }

        @Override // ir.nasim.InterfaceC4228Ef6
        public void b() {
            C21543tj1.this.Q7().onBackPressed();
        }

        @Override // ir.nasim.InterfaceC4228Ef6
        public void d(String str) {
            AbstractC13042fc3.i(str, "query");
            C21543tj1.this.za().p1(str);
        }

        @Override // ir.nasim.InterfaceC4228Ef6
        public void c() {
        }
    }

    /* renamed from: ir.nasim.tj1$k */
    public static final class k implements InterfaceC15419jZ0 {
        final /* synthetic */ ContactItem.BaleContactItem b;

        k(ContactItem.BaleContactItem baleContactItem) {
            this.b = baleContactItem;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C21543tj1.this.ua(this.b);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
        }
    }
}
