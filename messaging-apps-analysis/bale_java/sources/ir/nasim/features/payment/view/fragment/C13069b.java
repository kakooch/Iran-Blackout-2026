package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.SapOuterClass$ResponseEnrollNewCard;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C10333bU0;
import ir.nasim.C13396g93;
import ir.nasim.C14819iX7;
import ir.nasim.C16250kx2;
import ir.nasim.C17468n10;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20481s50;
import ir.nasim.C23381wp3;
import ir.nasim.C3641Bs4;
import ir.nasim.C4100Dr4;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.IV2;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC8327Vm4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.Q45;
import ir.nasim.QA7;
import ir.nasim.SA2;
import ir.nasim.WB5;
import ir.nasim.ZY6;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.view.fragment.C13069b;
import ir.nasim.features.payment.view.fragment.y;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t*\u0001:\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0001RB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u0003J+\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\u0003J\r\u0010$\u001a\u00020\u0006¢\u0006\u0004\b$\u0010\u0003J!\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020 2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010\u0003R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lir/nasim/features/payment/view/fragment/b;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "Lir/nasim/features/payment/data/model/BankCreditCard;", ParameterNames.CARD, "Lir/nasim/rB7;", "o9", "(Lir/nasim/features/payment/data/model/BankCreditCard;)V", "", "mTitle", "mInputHint", "l9", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "newCard", "g9", "(Landroidx/fragment/app/FragmentManager;Lir/nasim/features/payment/data/model/BankCreditCard;)V", "d9", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "j7", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "R6", "f9", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "k7", "Lir/nasim/kx2;", "s1", "Lir/nasim/kx2;", "_binding", "", "t1", "Ljava/lang/Integer;", "type", "u1", "Lir/nasim/features/payment/data/model/BankCreditCard;", "editableBankCreditCard", "Lir/nasim/Bs4;", "v1", "Lir/nasim/Yu3;", "k9", "()Lir/nasim/Bs4;", "viewModel", "ir/nasim/features/payment/view/fragment/b$i", "w1", "Lir/nasim/features/payment/view/fragment/b$i;", "validTextWatcher", "Landroid/view/View$OnClickListener;", "x1", "Landroid/view/View$OnClickListener;", "cvv2InputVisibleClickListener", "Lir/nasim/bU0;", "y1", "Lir/nasim/bU0;", "j9", "()Lir/nasim/bU0;", "setLoadingInitData", "(Lir/nasim/bU0;)V", "loadingInitData", "Lir/nasim/n10;", "z1", "Lir/nasim/n10;", "snackBar", "i9", "()Lir/nasim/kx2;", "binding", "A1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.payment.view.fragment.b, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13069b extends IV2 {

    /* renamed from: A1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int B1 = 8;

    /* renamed from: s1, reason: from kotlin metadata */
    private C16250kx2 _binding;

    /* renamed from: t1, reason: from kotlin metadata */
    private Integer type;

    /* renamed from: u1, reason: from kotlin metadata */
    private BankCreditCard editableBankCreditCard;

    /* renamed from: v1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C3641Bs4.class), new f(this), new g(null, this), new h(this));

    /* renamed from: w1, reason: from kotlin metadata */
    private final i validTextWatcher = new i();

    /* renamed from: x1, reason: from kotlin metadata */
    private final View.OnClickListener cvv2InputVisibleClickListener = new View.OnClickListener() { // from class: ir.nasim.U7
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C13069b.e9(this.a, view);
        }
    };

    /* renamed from: y1, reason: from kotlin metadata */
    private C10333bU0 loadingInitData = new C10333bU0();

    /* renamed from: z1, reason: from kotlin metadata */
    private C17468n10 snackBar;

    /* renamed from: ir.nasim.features.payment.view.fragment.b$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ C13069b b(Companion companion, int i, BankCreditCard bankCreditCard, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                bankCreditCard = null;
            }
            return companion.a(i, bankCreditCard);
        }

        public final C13069b a(int i, BankCreditCard bankCreditCard) {
            C13069b c13069b = new C13069b();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            if (bankCreditCard != null) {
                bundle.putParcelable(ParameterNames.CARD, bankCreditCard);
            }
            c13069b.a8(bundle);
            return c13069b;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.b$b, reason: collision with other inner class name */
    public static final class C1194b implements TextWatcher {
        C1194b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable != null) {
                if (ZY6.a(editable.toString()).length() < 6) {
                    C13069b.this.i9().b.setEnabled(false);
                    C13069b.this.i9().c.setMaxLength(-1);
                    C13069b.this.i9().c.setErrorStroke(false);
                    C13069b.this.i9().c.setDrawableStart(AbstractC4043Dl1.f(C13069b.this.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
                    C13069b.this.i9().c.setDrawableStartTint(ColorStateList.valueOf(C5495Jo7.a.L0()));
                    return;
                }
                if (ZY6.a(editable.toString()).length() >= 6) {
                    C20481s50 c20481s50 = C20481s50.a;
                    String strSubstring = ZY6.a(editable.toString()).substring(0, 6);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    Bank bankC = c20481s50.c(strSubstring);
                    if (bankC == null) {
                        C13069b.this.i9().c.setMaxLength(7);
                        CustomInputView customInputView = C13069b.this.i9().c;
                        String strH6 = C13069b.this.h6(AbstractC12217eE5.card_payment_missing_destination_card);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        customInputView.setInputError(strH6);
                        return;
                    }
                    if (editable.length() == 19) {
                        C13069b.this.i9().c.setMaxLength(19);
                        C13069b.this.i9().d.requestFocus();
                    }
                    Drawable drawableF = null;
                    C13069b.this.i9().c.setDrawableStartTint(null);
                    CustomInputView customInputView2 = C13069b.this.i9().c;
                    Integer drawableId = bankC.getDrawableId();
                    if (drawableId != null) {
                        C13069b c13069b = C13069b.this;
                        drawableF = AbstractC4043Dl1.f(c13069b.S7(), drawableId.intValue());
                    }
                    customInputView2.setDrawableStart(drawableF);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.b$c */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 4) {
                return;
            }
            C13069b.this.i9().g.requestFocus();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.b$d */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() != 2) {
                return;
            }
            C13069b.this.i9().k.requestFocus();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.b$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.features.payment.view.fragment.b$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C13069b c;

            /* renamed from: ir.nasim.features.payment.view.fragment.b$e$a$a, reason: collision with other inner class name */
            static final class C1195a implements InterfaceC4806Gq2 {
                final /* synthetic */ C13069b a;

                /* renamed from: ir.nasim.features.payment.view.fragment.b$e$a$a$a, reason: collision with other inner class name */
                static final class C1196a implements InterfaceC4806Gq2 {
                    final /* synthetic */ C13069b a;

                    C1196a(C13069b c13069b) {
                        this.a = c13069b;
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object a(QA7 qa7, InterfaceC20295rm1 interfaceC20295rm1) {
                        if (qa7 instanceof QA7.b) {
                            AbstractC16494lN1.a(this.a.getLoadingInitData());
                            this.a.f9();
                        } else if (qa7 instanceof QA7.c) {
                            C10333bU0 loadingInitData = this.a.getLoadingInitData();
                            FragmentManager fragmentManagerB0 = this.a.Q7().B0();
                            AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
                            AbstractC16494lN1.b(loadingInitData, fragmentManagerB0);
                        } else if (qa7 instanceof QA7.d) {
                            AbstractC16494lN1.a(this.a.getLoadingInitData());
                            this.a.k9().p1();
                            C13069b c13069b = this.a;
                            Object objA = ((QA7.d) qa7).a();
                            AbstractC13042fc3.g(objA, "null cannot be cast to non-null type ir.nasim.features.payment.data.model.BankCreditCard");
                            c13069b.o9((BankCreditCard) objA);
                        } else {
                            if (!(qa7 instanceof QA7.a)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            AbstractC16494lN1.a(this.a.getLoadingInitData());
                            C17468n10 c17468n10 = this.a.snackBar;
                            if (c17468n10 == null) {
                                AbstractC13042fc3.y("snackBar");
                                c17468n10 = null;
                            }
                            String strH6 = this.a.h6(AbstractC12217eE5.error_when_do_operation);
                            AbstractC13042fc3.h(strH6, "getString(...)");
                            c17468n10.o(strH6);
                        }
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.features.payment.view.fragment.b$e$a$a$b, reason: collision with other inner class name */
                static final class C1197b extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int c;

                    C1197b(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.c |= RecyclerView.UNDEFINED_DURATION;
                        return C1195a.this.a(null, this);
                    }
                }

                C1195a(C13069b c13069b) {
                    this.a = c13069b;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(ir.nasim.AbstractC15251jG3 r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.features.payment.view.fragment.C13069b.e.a.C1195a.C1197b
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.features.payment.view.fragment.b$e$a$a$b r0 = (ir.nasim.features.payment.view.fragment.C13069b.e.a.C1195a.C1197b) r0
                        int r1 = r0.c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.c = r1
                        goto L18
                    L13:
                        ir.nasim.features.payment.view.fragment.b$e$a$a$b r0 = new ir.nasim.features.payment.view.fragment.b$e$a$a$b
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.c
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 == r3) goto L2d
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2d:
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L6f
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        boolean r6 = r5 instanceof ir.nasim.AbstractC15251jG3.c
                        if (r6 == 0) goto L51
                        ir.nasim.features.payment.view.fragment.b r5 = r4.a
                        ir.nasim.bU0 r5 = r5.getLoadingInitData()
                        ir.nasim.features.payment.view.fragment.b r6 = r4.a
                        androidx.fragment.app.FragmentActivity r6 = r6.Q7()
                        androidx.fragment.app.FragmentManager r6 = r6.B0()
                        java.lang.String r0 = "getSupportFragmentManager(...)"
                        ir.nasim.AbstractC13042fc3.h(r6, r0)
                        ir.nasim.AbstractC16494lN1.b(r5, r6)
                        goto L97
                    L51:
                        boolean r6 = r5 instanceof ir.nasim.AbstractC15251jG3.b
                        if (r6 == 0) goto L75
                        ir.nasim.features.payment.view.fragment.b r5 = r4.a
                        ir.nasim.Bs4 r5 = ir.nasim.features.payment.view.fragment.C13069b.b9(r5)
                        ir.nasim.bL6 r5 = r5.d1()
                        ir.nasim.features.payment.view.fragment.b$e$a$a$a r6 = new ir.nasim.features.payment.view.fragment.b$e$a$a$a
                        ir.nasim.features.payment.view.fragment.b r2 = r4.a
                        r6.<init>(r2)
                        r0.c = r3
                        java.lang.Object r5 = r5.b(r6, r0)
                        if (r5 != r1) goto L6f
                        return r1
                    L6f:
                        kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
                        r5.<init>()
                        throw r5
                    L75:
                        boolean r5 = r5 instanceof ir.nasim.AbstractC15251jG3.a
                        if (r5 == 0) goto L97
                        ir.nasim.features.payment.view.fragment.b r5 = r4.a
                        ir.nasim.n10 r5 = ir.nasim.features.payment.view.fragment.C13069b.a9(r5)
                        if (r5 != 0) goto L87
                        java.lang.String r5 = "snackBar"
                        ir.nasim.AbstractC13042fc3.y(r5)
                        r5 = 0
                    L87:
                        ir.nasim.features.payment.view.fragment.b r6 = r4.a
                        int r0 = ir.nasim.AbstractC12217eE5.error_when_get_data
                        java.lang.String r6 = r6.h6(r0)
                        java.lang.String r0 = "getString(...)"
                        ir.nasim.AbstractC13042fc3.h(r6, r0)
                        r5.o(r6)
                    L97:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.fragment.C13069b.e.a.C1195a.a(ir.nasim.jG3, ir.nasim.rm1):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C13069b c13069b, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c13069b;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC8327Vm4 interfaceC8327Vm4F1 = this.c.k9().f1();
                    C1195a c1195a = new C1195a(this.c);
                    this.b = 1;
                    if (interfaceC8327Vm4F1.b(c1195a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13069b.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13069b c13069b = C13069b.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(c13069b, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c13069b, bVar, aVar, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.b$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.b$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.b$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.b$i */
    public static final class i implements TextWatcher {
        i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            C13069b.this.d9();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d9() {
        String string = i9().c.getText().toString();
        boolean z = ZY6.a(string).length() > 0 && ZY6.a(string).length() == 16;
        boolean z2 = i9().k.getText().toString().length() > 0;
        String string2 = i9().g.getText().toString();
        boolean z3 = string2.length() > 0 && Integer.parseInt(string2) < 13 && Integer.parseInt(string2) > 0;
        String string3 = i9().d.getText().toString();
        boolean z4 = string3.length() == 0 || (string3.length() > 0 && string3.length() >= 3);
        Drawable background = i9().b.getBackground();
        if (z && z2 && z3 && z4) {
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            AbstractC21710u02.h(background, c5495Jo7.Y());
            i9().b.setTextColor(c5495Jo7.b0());
            i9().b.setEnabled(true);
        } else {
            C5495Jo7 c5495Jo72 = C5495Jo7.a;
            AbstractC21710u02.h(background, c5495Jo72.Z());
            i9().b.setTextColor(c5495Jo72.c0());
            i9().b.setEnabled(false);
        }
        if (i9().c.getText().toString().length() == 0) {
            i9().c.setErrorStroke(false);
        }
        i9().b.setBackground(background);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e9(C13069b c13069b, View view) {
        AbstractC13042fc3.i(c13069b, "this$0");
        if (AbstractC13042fc3.d(c13069b.i9().d.getTag(), 0)) {
            c13069b.i9().d.M(true);
            c13069b.i9().d.setTag(1);
            c13069b.i9().d.setDrawableEndFirst(AbstractC4043Dl1.f(c13069b.S7(), KB5.ic_card_payment_baseline_visibility_off_24));
        } else {
            c13069b.i9().d.M(false);
            c13069b.i9().d.setTag(0);
            c13069b.i9().d.setDrawableEndFirst(AbstractC4043Dl1.f(c13069b.S7(), KB5.ic_card_payment_baseline_visibility_24));
        }
    }

    private final void g9(final FragmentManager fragmentManager, final BankCreditCard newCard) {
        k9().z0(newCard).m0(new InterfaceC24449ye1() { // from class: ir.nasim.V7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13069b.h9(newCard, fragmentManager, (SapOuterClass$ResponseEnrollNewCard) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h9(BankCreditCard bankCreditCard, FragmentManager fragmentManager, SapOuterClass$ResponseEnrollNewCard sapOuterClass$ResponseEnrollNewCard) {
        AbstractC13042fc3.i(bankCreditCard, "$newCard");
        AbstractC13042fc3.i(fragmentManager, "$fragmentManager");
        y.Companion companion = y.INSTANCE;
        companion.b(companion.a(bankCreditCard), fragmentManager, "EnrollmentCardFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C16250kx2 i9() {
        C16250kx2 c16250kx2 = this._binding;
        AbstractC13042fc3.f(c16250kx2);
        return c16250kx2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3641Bs4 k9() {
        return (C3641Bs4) this.viewModel.getValue();
    }

    private final void l9(String mTitle, String mInputHint) {
        i9().i.setTypeface(C6011Lu2.i());
        i9().b.setTypeface(C6011Lu2.i());
        i9().c.setHintTypeFace(C6011Lu2.i());
        i9().c.setTextTypeFace(C6011Lu2.k());
        i9().d.setTextTypeFace(C6011Lu2.k());
        i9().k.setTextTypeFace(C6011Lu2.k());
        i9().g.setTextTypeFace(C6011Lu2.k());
        i9().i.setText(mTitle);
        i9().c.setHint(mInputHint);
        i9().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.W7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13069b.m9(this.a, view);
            }
        });
        CustomInputView customInputView = i9().c;
        CustomInputView customInputView2 = i9().c;
        AbstractC13042fc3.h(customInputView2, "cardNumber");
        customInputView.b(new C13396g93(customInputView2));
        i9().c.b(new C1194b());
        i9().d.b(new c());
        i9().g.b(new d());
        CustomInputView customInputView3 = i9().d;
        CustomInputView customInputView4 = i9().d;
        AbstractC13042fc3.h(customInputView4, "cvv2Input");
        customInputView3.b(new Q45(customInputView4));
        CustomInputView customInputView5 = i9().k;
        CustomInputView customInputView6 = i9().k;
        AbstractC13042fc3.h(customInputView6, "yearInput");
        customInputView5.b(new Q45(customInputView6));
        CustomInputView customInputView7 = i9().g;
        CustomInputView customInputView8 = i9().g;
        AbstractC13042fc3.h(customInputView8, "monthInput");
        customInputView7.b(new Q45(customInputView8));
        i9().c.b(this.validTextWatcher);
        i9().d.b(this.validTextWatcher);
        i9().k.b(this.validTextWatcher);
        i9().g.b(this.validTextWatcher);
        i9().d.setTag(0);
        i9().d.setDrawableEndFirstClickListener(this.cvv2InputVisibleClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4 */
    public static final void m9(C13069b c13069b, View view) {
        ?? r3;
        String id;
        boolean zIsDefault;
        AbstractC13042fc3.i(c13069b, "this$0");
        Context contextS7 = c13069b.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        C17468n10 c17468n10 = null;
        if (!C4100Dr4.a(contextS7)) {
            C17468n10 c17468n102 = c13069b.snackBar;
            if (c17468n102 == null) {
                AbstractC13042fc3.y("snackBar");
            } else {
                c17468n10 = c17468n102;
            }
            String strH6 = c13069b.h6(AbstractC12217eE5.do_not_access);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c17468n10.o(strH6);
            return;
        }
        String strA = ZY6.a(c13069b.i9().c.getText().toString());
        if (!c13069b.i9().c.r()) {
            c13069b.i9().c.requestFocus();
            return;
        }
        if (strA.length() == 16) {
            boolean z = true;
            if (c13069b.editableBankCreditCard == null) {
                Iterator it = c13069b.k9().k1().iterator();
                r3 = false;
                while (it.hasNext()) {
                    if (AbstractC13042fc3.d(((BankCreditCard) it.next()).getNumber(), strA)) {
                        r3 = true;
                    }
                }
            } else {
                r3 = false;
            }
            if (r3 == true) {
                AbstractC16494lN1.a(c13069b.loadingInitData);
                AbstractC16494lN1.a(c13069b);
                return;
            }
            BankCreditCard bankCreditCard = c13069b.editableBankCreditCard;
            if (bankCreditCard != null) {
                AbstractC13042fc3.f(bankCreditCard);
                id = bankCreditCard.getId();
            } else {
                id = null;
            }
            Integer numValueOf = (c13069b.i9().k.getText().toString().length() > 0) != false ? Integer.valueOf(Integer.parseInt(c13069b.i9().k.getText().toString())) : null;
            Integer numValueOf2 = (c13069b.i9().g.getText().toString().length() > 0) != false ? Integer.valueOf(Integer.parseInt(c13069b.i9().g.getText().toString())) : null;
            String string = (!(c13069b.i9().d.getText().toString().length() > 0) == true || c13069b.i9().d.getText().toString().length() > 4) ? null : c13069b.i9().d.getText().toString();
            String str = (string == null || string.length() == 0) == true ? null : string;
            BankCreditCard bankCreditCard2 = c13069b.editableBankCreditCard;
            if (bankCreditCard2 != null) {
                AbstractC13042fc3.f(bankCreditCard2);
                zIsDefault = bankCreditCard2.isDefault();
            } else {
                zIsDefault = false;
            }
            BankCreditCard bankCreditCard3 = new BankCreditCard(id, strA, numValueOf2, numValueOf, str, null, false, BankCreditCard.c.a, zIsDefault, false, false, 1536, null);
            if (c13069b.editableBankCreditCard == null) {
                c13069b.k9().W0(bankCreditCard3);
                return;
            }
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                str = "";
            }
            C3641Bs4 c3641Bs4K9 = c13069b.k9();
            AbstractC13042fc3.f(numValueOf2);
            int iIntValue = numValueOf2.intValue();
            AbstractC13042fc3.f(numValueOf);
            c3641Bs4K9.b1(bankCreditCard3, iIntValue, numValueOf.intValue(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n9(DialogInterface dialogInterface) {
        try {
            AbstractC13042fc3.g(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
            FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(WB5.design_bottom_sheet);
            AbstractC13042fc3.g(frameLayout, "null cannot be cast to non-null type android.view.View");
            BottomSheetBehavior.f0(frameLayout).J0(3);
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o9(BankCreditCard card) {
        C20481s50 c20481s50 = C20481s50.a;
        String strSubstring = card.getNumber().substring(0, 6);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        if (c20481s50.c(strSubstring) != null && !card.isEnrolled()) {
            FragmentManager fragmentManagerB0 = Q7().B0();
            AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
            g9(fragmentManagerB0, card);
        }
        C23381wp3.f(i9().c);
        AbstractC16494lN1.a(this);
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) {
        Dialog dialogB8 = super.B8(savedInstanceState);
        AbstractC13042fc3.g(dialogB8, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogB8;
        aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.X7
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                C13069b.n9(dialogInterface);
            }
        });
        return aVar;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        I8(0, AbstractC23035wE5.CardPaymentBottomSheetTheme);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.type = Integer.valueOf(bundleE5.getInt("type", 0));
            this.editableBankCreditCard = (BankCreditCard) bundleE5.getParcelable(ParameterNames.CARD);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C16250kx2.c(inflater, container, false);
        ConstraintLayout constraintLayoutB = i9().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        return constraintLayoutB;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    public final void f9() {
        Integer num = this.type;
        if (num != null && num.intValue() == 0) {
            String strH6 = h6(AbstractC12217eE5.card_payment_add_new_source_card);
            AbstractC13042fc3.h(strH6, "getString(...)");
            if (this.editableBankCreditCard != null) {
                strH6 = h6(AbstractC12217eE5.card_payment_add_edit_card_information);
            }
            String strH62 = h6(AbstractC12217eE5.card_payment_source_card);
            AbstractC13042fc3.h(strH62, "getString(...)");
            l9(strH6, strH62);
        } else if (num != null && num.intValue() == 1) {
            String strH63 = h6(AbstractC12217eE5.card_payment_add_new_destination_card);
            AbstractC13042fc3.h(strH63, "getString(...)");
            String strH64 = h6(AbstractC12217eE5.card_payment_destination_card);
            AbstractC13042fc3.h(strH64, "getString(...)");
            l9(strH63, strH64);
        }
        BankCreditCard bankCreditCard = this.editableBankCreditCard;
        if (bankCreditCard != null) {
            i9().c.setText(bankCreditCard.getNumber());
            i9().c.setEnabled(false);
            i9().g.setText(bankCreditCard.getRealExpirationMonth());
            i9().k.setText(bankCreditCard.getRealExpirationYear());
            i9().d.setText(bankCreditCard.getCvv2());
        }
        i9().c.clearFocus();
        i9().g.clearFocus();
        i9().k.clearFocus();
        i9().d.clearFocus();
        C23381wp3.f(i9().c);
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void j7() {
        Window window;
        Window window2;
        super.j7();
        if (y8() != null) {
            Dialog dialogY8 = y8();
            if (dialogY8 != null && (window2 = dialogY8.getWindow()) != null) {
                window2.setLayout(-1, -1);
            }
            Dialog dialogY82 = y8();
            if (dialogY82 == null || (window = dialogY82.getWindow()) == null) {
                return;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* renamed from: j9, reason: from getter */
    public final C10333bU0 getLoadingInitData() {
        return this.loadingInitData;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void k7() {
        super.k7();
        C23381wp3.f(i9().c);
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ConstraintLayout constraintLayoutB = i9().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(constraintLayoutB, null, 0, 6, null);
        this.snackBar = c17468n10;
        c17468n10.k(i9().b);
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new e(null), 3, null);
    }
}
