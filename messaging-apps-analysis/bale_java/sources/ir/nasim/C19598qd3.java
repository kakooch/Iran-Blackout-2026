package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.gov.nist.javax.sdp.fields.SDPKeywords;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.window.OnBackInvokedCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC22884vz0;
import ir.nasim.C19598qd3;
import ir.nasim.O98;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020 2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0003R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010/\u001a\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lir/nasim/qd3;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "Lir/nasim/rB7;", "s9", "n9", "", "isEmptyState", "m9", "(Z)V", "Lir/nasim/gj3;", "f9", "()Lir/nasim/gj3;", "Lir/nasim/vz0;", "callToast", "isInviteBottomAvailable", "l9", "(Lir/nasim/vz0;Z)V", "t9", "Lir/nasim/Ud3;", "g9", "()Lir/nasim/Ud3;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/app/Dialog;", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "T6", "Lir/nasim/ue3;", "s1", "Lir/nasim/bW7;", "i9", "()Lir/nasim/ue3;", "binding", "Lir/nasim/Ld3;", "t1", "Lir/nasim/Yu3;", "j9", "()Lir/nasim/Ld3;", "viewModel", "Lcom/google/android/material/bottomsheet/a;", "u1", "Lcom/google/android/material/bottomsheet/a;", "bottomSheetDialog", "Lkotlin/Function0;", "v1", "Lir/nasim/SA2;", "onBackPressedAction", "w1", "Lir/nasim/Ud3;", "contactsAdapter", "Lir/nasim/gn6;", "x1", "Lir/nasim/gn6;", "selectedContactsAdapter", "Lir/nasim/n10;", "y1", "k9", "()Lir/nasim/n10;", "voiceCallErrorsSnackBar", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.qd3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19598qd3 extends PW2 {

    /* renamed from: s1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new e(), AbstractC20046rN7.c());

    /* renamed from: t1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: u1, reason: from kotlin metadata */
    private com.google.android.material.bottomsheet.a bottomSheetDialog;

    /* renamed from: v1, reason: from kotlin metadata */
    private SA2 onBackPressedAction;

    /* renamed from: w1, reason: from kotlin metadata */
    private C8011Ud3 contactsAdapter;

    /* renamed from: x1, reason: from kotlin metadata */
    private C13773gn6 selectedContactsAdapter;

    /* renamed from: y1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 voiceCallErrorsSnackBar;
    static final /* synthetic */ InterfaceC5239Im3[] z1 = {AbstractC10882cM5.i(new C25226zw5(C19598qd3.class, "binding", "getBinding()Lir/nasim/databinding/InviteUsersBottomSheetBinding;", 0))};
    public static final int A1 = 8;

    /* renamed from: ir.nasim.qd3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.qd3$a$a, reason: collision with other inner class name */
        static final class C1483a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C19598qd3 d;

            /* renamed from: ir.nasim.qd3$a$a$a, reason: collision with other inner class name */
            static final class C1484a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C19598qd3 c;

                /* renamed from: ir.nasim.qd3$a$a$a$a, reason: collision with other inner class name */
                static final class C1485a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;
                    final /* synthetic */ C19598qd3 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1485a(C19598qd3 c19598qd3, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = c19598qd3;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1485a c1485a = new C1485a(this.d, interfaceC20295rm1);
                        c1485a.c = obj;
                        return c1485a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            NT4 nt4 = (NT4) this.c;
                            C8011Ud3 c8011Ud3 = this.d.contactsAdapter;
                            if (c8011Ud3 != null) {
                                this.b = 1;
                                if (c8011Ud3.L(nt4, this) == objE) {
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
                        return ((C1485a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1484a(C19598qd3 c19598qd3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c19598qd3;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1484a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2Z0 = this.c.j9().Z0();
                        C1485a c1485a = new C1485a(this.c, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2Z0, c1485a, this) == objE) {
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
                    return ((C1484a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.qd3$a$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C19598qd3 c;

                /* renamed from: ir.nasim.qd3$a$a$b$a, reason: collision with other inner class name */
                static final class C1486a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;
                    final /* synthetic */ C19598qd3 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1486a(C19598qd3 c19598qd3, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = c19598qd3;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1486a c1486a = new C1486a(this.d, interfaceC20295rm1);
                        c1486a.c = obj;
                        return c1486a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        C5626Kd3 c5626Kd3 = (C5626Kd3) this.c;
                        MaterialButton materialButton = this.d.i9().i;
                        AbstractC13042fc3.h(materialButton, "inviteButton");
                        materialButton.setVisibility(c5626Kd3.f() ? 0 : 8);
                        this.d.l9(c5626Kd3.c(), c5626Kd3.f());
                        if (c5626Kd3.d()) {
                            this.d.u8();
                        }
                        ImageButton imageButton = this.d.i9().b;
                        AbstractC13042fc3.h(imageButton, "back");
                        imageButton.setVisibility(c5626Kd3.e().length() > 0 ? 0 : 8);
                        ImageButton imageButton2 = this.d.i9().c;
                        AbstractC13042fc3.h(imageButton2, SDPKeywords.CLEAR);
                        imageButton2.setVisibility(c5626Kd3.e().length() > 0 ? 0 : 8);
                        ImageButton imageButton3 = this.d.i9().h;
                        AbstractC13042fc3.h(imageButton3, "icSearch");
                        imageButton3.setVisibility(c5626Kd3.e().length() == 0 ? 0 : 8);
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(C5626Kd3 c5626Kd3, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1486a) create(c5626Kd3, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C19598qd3 c19598qd3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c19598qd3;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new b(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC10258bL6 interfaceC10258bL6A1 = this.c.j9().a1();
                        C1486a c1486a = new C1486a(this.c, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC10258bL6A1, c1486a, this) == objE) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1483a(C19598qd3 c19598qd3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c19598qd3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1483a c1483a = new C1483a(this.d, interfaceC20295rm1);
                c1483a.c = obj;
                return c1483a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1484a(this.d, null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(this.d, null), 3, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1483a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19598qd3.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19598qd3 c19598qd3 = C19598qd3.this;
                j.b bVar = j.b.RESUMED;
                C1483a c1483a = new C1483a(c19598qd3, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c19598qd3, bVar, c1483a, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qd3$c */
    public static final class c extends com.google.android.material.bottomsheet.a {
        c(Context context, int i) {
            super(context, i);
            setCancelable(true);
            setCanceledOnTouchOutside(true);
            if (Build.VERSION.SDK_INT >= 33) {
                getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new OnBackInvokedCallback() { // from class: ir.nasim.td3
                    public final void onBackInvoked() {
                        C19598qd3.c.y(c19598qd3);
                    }
                });
            }
            r(true);
            BottomSheetBehavior bottomSheetBehaviorO = o();
            bottomSheetBehaviorO.J0(3);
            bottomSheetBehaviorO.z0(false);
            bottomSheetBehaviorO.I0(true);
            bottomSheetBehaviorO.B0(Float.MIN_VALUE);
            setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.ud3
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    C19598qd3.c.z(this.a, dialogInterface);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final O98 A(C19598qd3 c19598qd3, View view, O98 o98) {
            AbstractC13042fc3.i(c19598qd3, "this$0");
            AbstractC13042fc3.i(view, "<unused var>");
            AbstractC13042fc3.i(o98, "insets");
            L93 l93F = o98.f(O98.m.h());
            AbstractC13042fc3.h(l93F, "getInsets(...)");
            L93 l93F2 = o98.f(O98.m.g());
            AbstractC13042fc3.h(l93F2, "getInsets(...)");
            L93 l93F3 = o98.f(O98.m.d());
            AbstractC13042fc3.h(l93F3, "getInsets(...)");
            C22085ue3 c22085ue3I9 = c19598qd3.i9();
            MaterialButton materialButton = c22085ue3I9.i;
            AbstractC13042fc3.h(materialButton, "inviteButton");
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int i = l93F3.d;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i > 0 ? i - l93F2.d : AbstractC8943Xx1.c(12);
            materialButton.setLayoutParams(layoutParams2);
            ConstraintLayout root = c22085ue3I9.getRoot();
            AbstractC13042fc3.h(root, "getRoot(...)");
            ViewGroup.LayoutParams layoutParams3 = root.getLayoutParams();
            if (layoutParams3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.topMargin = l93F.b;
            layoutParams4.bottomMargin = l93F2.d;
            root.setLayoutParams(layoutParams4);
            return new O98.b(o98).e(O98.m.g(), false).e(O98.m.d(), false).e(O98.m.h(), false).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(C19598qd3 c19598qd3) {
            AbstractC13042fc3.i(c19598qd3, "this$0");
            SA2 sa2 = c19598qd3.onBackPressedAction;
            if (sa2 != null) {
                sa2.invoke();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(c cVar, DialogInterface dialogInterface) {
            AbstractC13042fc3.i(cVar, "this$0");
            View viewFindViewById = cVar.findViewById(WB5.design_bottom_sheet);
            if (viewFindViewById != null) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams.height = -1;
                viewFindViewById.setLayoutParams(layoutParams);
            }
        }

        @Override // com.google.android.material.bottomsheet.a, android.app.Dialog, android.view.Window.Callback
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            Window window = getWindow();
            if (window == null) {
                return;
            }
            AbstractC19329q98.b(window, false);
            View viewFindViewById = findViewById(WB5.container);
            if (viewFindViewById != null) {
                viewFindViewById.setFitsSystemWindows(false);
            }
            View viewFindViewById2 = findViewById(WB5.coordinator);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setFitsSystemWindows(false);
            }
            View decorView = window.getDecorView();
            final C19598qd3 c19598qd3 = C19598qd3.this;
            AbstractC12990fW7.E0(decorView, new InterfaceC22474vI4() { // from class: ir.nasim.sd3
                @Override // ir.nasim.InterfaceC22474vI4
                public final O98 b(View view, O98 o98) {
                    return C19598qd3.c.A(c19598qd3, view, o98);
                }
            });
        }

        @Override // ir.nasim.V01, android.app.Dialog
        public void onBackPressed() {
            dismiss();
            SA2 sa2 = C19598qd3.this.onBackPressedAction;
            if (sa2 != null) {
                sa2.invoke();
            }
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            Window window = getWindow();
            if (window != null) {
                AbstractC12990fW7.E0(window.getDecorView(), null);
            }
        }
    }

    /* renamed from: ir.nasim.qd3$d */
    /* synthetic */ class d extends EB2 implements UA2 {
        d(Object obj) {
            super(1, obj, C5860Ld3.class, "removeFromSelectedContact", "removeFromSelectedContact(Lir/nasim/features/call/ui/model/BaleContactItem;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((C22613vY) obj);
            return C19938rB7.a;
        }

        public final void y(C22613vY c22613vY) {
            AbstractC13042fc3.i(c22613vY, "p0");
            ((C5860Ld3) this.receiver).d1(c22613vY);
        }
    }

    /* renamed from: ir.nasim.qd3$e */
    public static final class e extends AbstractC8614Ws3 implements UA2 {
        public e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C22085ue3.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.qd3$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.qd3$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.qd3$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.qd3$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.qd3$j */
    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C19598qd3() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new g(new f(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C5860Ld3.class), new h(interfaceC9173Yu3B), new i(null, interfaceC9173Yu3B), new j(this, interfaceC9173Yu3B));
        this.voiceCallErrorsSnackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.od3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19598qd3.u9(this.a);
            }
        });
    }

    private final InterfaceC13730gj3 f9() {
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        return AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new a(null), 3, null);
    }

    private final C8011Ud3 g9() {
        return new C8011Ud3(new UA2() { // from class: ir.nasim.pd3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C19598qd3.h9(this.a, (C22613vY) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h9(C19598qd3 c19598qd3, C22613vY c22613vY) {
        AbstractC13042fc3.i(c19598qd3, "this$0");
        AbstractC13042fc3.i(c22613vY, "it");
        c19598qd3.j9().f1(c22613vY);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C22085ue3 i9() {
        return (C22085ue3) this.binding.a(this, z1[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5860Ld3 j9() {
        return (C5860Ld3) this.viewModel.getValue();
    }

    private final C17468n10 k9() {
        return (C17468n10) this.voiceCallErrorsSnackBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l9(AbstractC22884vz0 callToast, boolean isInviteBottomAvailable) {
        if (callToast != null) {
            t9(callToast, isInviteBottomAvailable);
            j9().e1();
        }
    }

    private final void m9(boolean isEmptyState) {
        LinearLayout linearLayout = i9().d;
        AbstractC13042fc3.h(linearLayout, "emptyState");
        linearLayout.setVisibility(isEmptyState ? 0 : 8);
    }

    private final void n9() {
        TextInputEditText textInputEditText = i9().k;
        AbstractC13042fc3.h(textInputEditText, "searchField");
        textInputEditText.addTextChangedListener(new b());
        i9().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kd3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C19598qd3.o9(this.a, view);
            }
        });
        i9().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ld3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C19598qd3.p9(this.a, view);
            }
        });
        i9().i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.md3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C19598qd3.q9(this.a, view);
            }
        });
        C8011Ud3 c8011Ud3 = this.contactsAdapter;
        if (c8011Ud3 != null) {
            c8011Ud3.B(new UA2() { // from class: ir.nasim.nd3
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C19598qd3.r9(this.a, (C13628gZ0) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o9(C19598qd3 c19598qd3, View view) {
        AbstractC13042fc3.i(c19598qd3, "this$0");
        c19598qd3.u8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p9(C19598qd3 c19598qd3, View view) {
        AbstractC13042fc3.i(c19598qd3, "this$0");
        c19598qd3.j9().g1("");
        c19598qd3.i9().k.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q9(C19598qd3 c19598qd3, View view) {
        AbstractC13042fc3.i(c19598qd3, "this$0");
        c19598qd3.j9().c1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r9(C19598qd3 c19598qd3, C13628gZ0 c13628gZ0) {
        C8011Ud3 c8011Ud3;
        AbstractC13042fc3.i(c19598qd3, "this$0");
        AbstractC13042fc3.i(c13628gZ0, "loadState");
        if (c13628gZ0.a().a() && (c8011Ud3 = c19598qd3.contactsAdapter) != null) {
            c19598qd3.m9(c8011Ud3.getItemCount() < 1);
        }
        return C19938rB7.a;
    }

    private final void s9() {
        C22085ue3 c22085ue3I9 = i9();
        c22085ue3I9.m.setTypeface(C6011Lu2.i());
        c22085ue3I9.i.setTypeface(C6011Lu2.i());
        c22085ue3I9.e.setTypeface(C6011Lu2.i());
    }

    private final void t9(AbstractC22884vz0 callToast, boolean isInviteBottomAvailable) {
        String str;
        if (callToast instanceof AbstractC22884vz0.a.f) {
            DY6 dy6 = DY6.a;
            String strH6 = h6(callToast.a());
            AbstractC13042fc3.h(strH6, "getString(...)");
            str = String.format(strH6, Arrays.copyOf(new Object[]{((AbstractC22884vz0.a.f) callToast).b()}, 1));
            AbstractC13042fc3.h(str, "format(...)");
        } else if (callToast instanceof AbstractC22884vz0.a.b) {
            DY6 dy62 = DY6.a;
            String strH62 = h6(callToast.a());
            AbstractC13042fc3.h(strH62, "getString(...)");
            str = String.format(strH62, Arrays.copyOf(new Object[]{((AbstractC22884vz0.a.b) callToast).b()}, 1));
            AbstractC13042fc3.h(str, "format(...)");
        } else if (callToast instanceof AbstractC22884vz0.a.c) {
            DY6 dy63 = DY6.a;
            String strH63 = h6(callToast.a());
            AbstractC13042fc3.h(strH63, "getString(...)");
            str = String.format(strH63, Arrays.copyOf(new Object[]{((AbstractC22884vz0.a.c) callToast).b()}, 1));
            AbstractC13042fc3.h(str, "format(...)");
        } else if (callToast instanceof AbstractC22884vz0.a.g) {
            DY6 dy64 = DY6.a;
            String strH64 = h6(callToast.a());
            AbstractC13042fc3.h(strH64, "getString(...)");
            str = String.format(strH64, Arrays.copyOf(new Object[]{Integer.valueOf(((AbstractC22884vz0.a.g) callToast).b())}, 1));
            AbstractC13042fc3.h(str, "format(...)");
        } else if (callToast instanceof AbstractC22884vz0.a.C1733a) {
            DY6 dy65 = DY6.a;
            String strH65 = h6(callToast.a());
            AbstractC13042fc3.h(strH65, "getString(...)");
            str = String.format(strH65, Arrays.copyOf(new Object[]{((AbstractC22884vz0.a.C1733a) callToast).b()}, 1));
            AbstractC13042fc3.h(str, "format(...)");
        } else if (AbstractC13042fc3.d(callToast, AbstractC22884vz0.a.d.b)) {
            DY6 dy66 = DY6.a;
            String strH66 = h6(callToast.a());
            AbstractC13042fc3.h(strH66, "getString(...)");
            str = String.format(strH66, Arrays.copyOf(new Object[0], 0));
            AbstractC13042fc3.h(str, "format(...)");
        } else {
            str = null;
        }
        if (str != null) {
            k9().k(isInviteBottomAvailable ? i9().i : i9().n);
            k9().o(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 u9(C19598qd3 c19598qd3) {
        AbstractC13042fc3.i(c19598qd3, "this$0");
        View rootView = c19598qd3.V7().getRootView();
        AbstractC13042fc3.h(rootView, "getRootView(...)");
        C17468n10 c17468n10 = new C17468n10(rootView, null, 0, 6, null);
        c17468n10.m(2000);
        return c17468n10;
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) {
        c cVar = new c(S7(), AbstractC23035wE5.inviteDialogStyle);
        this.bottomSheetDialog = cVar;
        return cVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        View viewInflate = inflater.inflate(AbstractC12208eD5.invite_users_bottom_sheet, container, false);
        AbstractC13042fc3.h(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void T6() {
        i9();
        super.T6();
        AbstractC6713Oq7.c();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        s9();
        this.selectedContactsAdapter = new C13773gn6(new d(j9()), j9().b1());
        this.contactsAdapter = g9();
        i9().f.setAdapter(new androidx.recyclerview.widget.f(this.selectedContactsAdapter, this.contactsAdapter));
        f9();
        n9();
    }

    /* renamed from: ir.nasim.qd3$b */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C19598qd3.this.j9().g1(String.valueOf(charSequence));
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
