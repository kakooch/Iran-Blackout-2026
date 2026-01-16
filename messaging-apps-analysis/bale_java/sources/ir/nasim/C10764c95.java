package ir.nasim;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR4\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00140\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lir/nasim/c95;", "Lir/nasim/Ta0;", "Lir/nasim/Rg3;", "Lir/nasim/l85;", "<init>", "()V", "Lir/nasim/Fq2;", "Lir/nasim/NT4;", "S9", "()Lir/nasim/Fq2;", "Landroidx/recyclerview/widget/RecyclerView$p;", "R9", "()Landroidx/recyclerview/widget/RecyclerView$p;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/OT4;", "l1", "Lir/nasim/OT4;", "adapter", "Lkotlin/Function1;", "m1", "Lir/nasim/UA2;", "senEvent", "Lkotlin/Function0;", "n1", "Lir/nasim/SA2;", "Q9", "()Lir/nasim/SA2;", "setCallbackAdapter", "(Lir/nasim/SA2;)V", "callbackAdapter", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.c95, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10764c95 extends AbstractC22017uX2<InterfaceC7331Rg3, C16361l85> {

    /* renamed from: l1, reason: from kotlin metadata */
    private OT4 adapter;

    /* renamed from: m1, reason: from kotlin metadata */
    private final UA2 senEvent = new UA2() { // from class: ir.nasim.Z85
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return C10764c95.fa(this.a, (InterfaceC7331Rg3) obj);
        }
    };

    /* renamed from: n1, reason: from kotlin metadata */
    private SA2 callbackAdapter = new SA2() { // from class: ir.nasim.a95
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C10764c95.da(this.a);
        }
    };

    /* renamed from: ir.nasim.c95$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC7331Rg3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC7331Rg3 interfaceC7331Rg3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC7331Rg3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10764c95.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14503i16 c14503i16T9 = C10764c95.this.T9();
                int iA = this.d.a();
                this.b = 1;
                if (c14503i16T9.c1(iA, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C18987pb3.x1(C18987pb3.a, new C11458d25(W25.b, this.d.a()), AbstractC6392Nk0.e(this.d.i()), AbstractC6392Nk0.e(this.d.h()), true, null, null, false, null, null, false, null, 2032, null);
            C10764c95.this.senEvent.invoke(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C13979h85 da(final C10764c95 c10764c95) {
        AbstractC13042fc3.i(c10764c95, "this$0");
        C13979h85 c13979h85 = new C13979h85(new UA2() { // from class: ir.nasim.b95
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C10764c95.ea(this.a, (InterfaceC7331Rg3) obj);
            }
        });
        c10764c95.adapter = c13979h85;
        return c13979h85;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ea(C10764c95 c10764c95, InterfaceC7331Rg3 interfaceC7331Rg3) {
        AbstractC13042fc3.i(c10764c95, "this$0");
        AbstractC13042fc3.i(interfaceC7331Rg3, "it");
        AbstractC10533bm0.d(AbstractC16751lo1.a(c10764c95), null, null, c10764c95.new a(interfaceC7331Rg3, null), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 fa(C10764c95 c10764c95, InterfaceC7331Rg3 interfaceC7331Rg3) {
        C11066cg3 c11066cg3K;
        AbstractC13042fc3.i(c10764c95, "this$0");
        AbstractC13042fc3.i(interfaceC7331Rg3, "it");
        C14503i16 c14503i16T9 = c10764c95.T9();
        OT4 ot4 = c10764c95.adapter;
        int iIndexOf = 1;
        if (ot4 != null && (c11066cg3K = ot4.K()) != null) {
            iIndexOf = 1 + c11066cg3K.indexOf(interfaceC7331Rg3);
        }
        c14503i16T9.e1(interfaceC7331Rg3, iIndexOf);
        return C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC7745Ta0
    /* renamed from: Q9, reason: from getter */
    public SA2 getCallbackAdapter() {
        return this.callbackAdapter;
    }

    @Override // ir.nasim.AbstractC7745Ta0
    public RecyclerView.p R9() {
        return new GridLayoutManager(S7(), 3);
    }

    @Override // ir.nasim.AbstractC7745Ta0
    public InterfaceC4557Fq2 S9() {
        return T9().b1();
    }

    @Override // ir.nasim.AbstractC7745Ta0, androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        P9().e.setPadding(AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(4), AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(4));
    }
}
