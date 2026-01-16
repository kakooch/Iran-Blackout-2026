package ir.nasim;

import android.os.Bundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001,B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R4\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001b0#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lir/nasim/Dk1;", "Lir/nasim/Ta0;", "Lir/nasim/hl1;", "Lir/nasim/xl1;", "<init>", "()V", "Lir/nasim/Fq2;", "Lir/nasim/NT4;", "S9", "()Lir/nasim/Fq2;", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Lir/nasim/FF2;", "l1", "Lir/nasim/FF2;", "contentRegex", "", "m1", "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "query", "Lir/nasim/OT4;", "n1", "Lir/nasim/OT4;", "adapter", "Lkotlin/Function1;", "o1", "Lir/nasim/UA2;", "senEvent", "Lkotlin/Function0;", "p1", "Lir/nasim/SA2;", "Q9", "()Lir/nasim/SA2;", "setCallbackAdapter", "(Lir/nasim/SA2;)V", "callbackAdapter", "q1", "a", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Dk1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4034Dk1 extends AbstractC15394jW2<InterfaceC14341hl1, C23929xl1> {

    /* renamed from: q1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int r1 = 8;

    /* renamed from: n1, reason: from kotlin metadata */
    private OT4 adapter;

    /* renamed from: l1, reason: from kotlin metadata */
    private final FF2 contentRegex = new FF2();

    /* renamed from: m1, reason: from kotlin metadata */
    private String query = "";

    /* renamed from: o1, reason: from kotlin metadata */
    private final UA2 senEvent = new UA2() { // from class: ir.nasim.Ak1
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return C4034Dk1.ea(this.a, (InterfaceC14341hl1) obj);
        }
    };

    /* renamed from: p1, reason: from kotlin metadata */
    private SA2 callbackAdapter = new SA2() { // from class: ir.nasim.Bk1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C4034Dk1.ca(this.a);
        }
    };

    /* renamed from: ir.nasim.Dk1$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C4034Dk1 a(String str) {
            AbstractC13042fc3.i(str, "query");
            C4034Dk1 c4034Dk1 = new C4034Dk1();
            c4034Dk1.a8(AbstractC23348wm0.b(new XV4("arg_query", str)));
            return c4034Dk1;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15529jk1 ca(final C4034Dk1 c4034Dk1) {
        AbstractC13042fc3.i(c4034Dk1, "this$0");
        C15529jk1 c15529jk1 = new C15529jk1(c4034Dk1.contentRegex.a(c4034Dk1.query), new UA2() { // from class: ir.nasim.Ck1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C4034Dk1.da(this.a, (InterfaceC14341hl1) obj);
            }
        });
        c4034Dk1.adapter = c15529jk1;
        return c15529jk1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 da(C4034Dk1 c4034Dk1, InterfaceC14341hl1 interfaceC14341hl1) {
        AbstractC13042fc3.i(c4034Dk1, "this$0");
        AbstractC13042fc3.i(interfaceC14341hl1, "it");
        c4034Dk1.senEvent.invoke(interfaceC14341hl1);
        C18987pb3.x1(C18987pb3.a, interfaceC14341hl1.l().e(), Long.valueOf(interfaceC14341hl1.l().f()), Long.valueOf(interfaceC14341hl1.l().d()), true, null, null, false, null, null, false, null, 2032, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ea(C4034Dk1 c4034Dk1, InterfaceC14341hl1 interfaceC14341hl1) {
        C11066cg3 c11066cg3K;
        AbstractC13042fc3.i(c4034Dk1, "this$0");
        AbstractC13042fc3.i(interfaceC14341hl1, "it");
        C14503i16 c14503i16T9 = c4034Dk1.T9();
        String str = c4034Dk1.query;
        OT4 ot4 = c4034Dk1.adapter;
        int iIndexOf = 1;
        if (ot4 != null && (c11066cg3K = ot4.K()) != null) {
            iIndexOf = 1 + c11066cg3K.indexOf(interfaceC14341hl1);
        }
        c14503i16T9.d1(interfaceC14341hl1, str, iIndexOf);
        return C19938rB7.a;
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.query = bundleE5.getString("arg_query", "");
        }
    }

    @Override // ir.nasim.AbstractC7745Ta0
    /* renamed from: Q9, reason: from getter */
    public SA2 getCallbackAdapter() {
        return this.callbackAdapter;
    }

    @Override // ir.nasim.AbstractC7745Ta0
    public InterfaceC4557Fq2 S9() {
        return T9().a1();
    }
}
