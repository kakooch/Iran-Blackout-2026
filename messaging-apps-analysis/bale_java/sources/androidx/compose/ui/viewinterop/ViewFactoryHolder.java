package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.ui.platform.AbstractComposeView;
import ir.nasim.AbstractC11355cs;
import ir.nasim.AbstractC7050Qb1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C25166zq4;
import ir.nasim.ED1;
import ir.nasim.EX7;
import ir.nasim.InterfaceC11814db6;
import ir.nasim.InterfaceC23714xO4;
import ir.nasim.SA2;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004BI\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013BK\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0014\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u0019R\u0014\u0010\t\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010!R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R(\u0010-\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010'8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b)\u0010*\"\u0004\b+\u0010,RB\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103RB\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010/\u001a\u0004\b6\u00101\"\u0004\b7\u00103RB\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010/\u001a\u0004\b:\u00101\"\u0004\b;\u00103R\u0014\u0010?\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006@"}, d2 = {"Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "Landroid/view/View;", TokenNames.T, "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Lir/nasim/EX7;", "Landroid/content/Context;", "context", "Lir/nasim/Qb1;", "parentContext", "typedView", "Lir/nasim/zq4;", "dispatcher", "Lir/nasim/db6;", "saveStateRegistry", "", "compositeKeyHash", "Lir/nasim/xO4;", "owner", "<init>", "(Landroid/content/Context;Lir/nasim/Qb1;Landroid/view/View;Lir/nasim/zq4;Lir/nasim/db6;ILir/nasim/xO4;)V", "Lkotlin/Function1;", "factory", "(Landroid/content/Context;Lir/nasim/UA2;Lir/nasim/Qb1;Lir/nasim/db6;ILir/nasim/xO4;)V", "Lir/nasim/rB7;", TokenNames.I, "()V", "J", "G", "Landroid/view/View;", "H", "Lir/nasim/zq4;", "getDispatcher", "()Lir/nasim/zq4;", "Lir/nasim/db6;", "z0", "", "A0", "Ljava/lang/String;", "saveStateKey", "Lir/nasim/db6$a;", "value", "B0", "Lir/nasim/db6$a;", "setSavableRegistryEntry", "(Lir/nasim/db6$a;)V", "savableRegistryEntry", "C0", "Lir/nasim/UA2;", "getUpdateBlock", "()Lir/nasim/UA2;", "setUpdateBlock", "(Lir/nasim/UA2;)V", "updateBlock", "D0", "getResetBlock", "setResetBlock", "resetBlock", "E0", "getReleaseBlock", "setReleaseBlock", "releaseBlock", "getViewRoot", "()Landroid/view/View;", "viewRoot", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder implements EX7 {

    /* renamed from: A0, reason: from kotlin metadata */
    private final String saveStateKey;

    /* renamed from: B0, reason: from kotlin metadata */
    private InterfaceC11814db6.a savableRegistryEntry;

    /* renamed from: C0, reason: from kotlin metadata */
    private UA2 updateBlock;

    /* renamed from: D0, reason: from kotlin metadata */
    private UA2 resetBlock;

    /* renamed from: E0, reason: from kotlin metadata */
    private UA2 releaseBlock;

    /* renamed from: G, reason: from kotlin metadata */
    private final View typedView;

    /* renamed from: H, reason: from kotlin metadata */
    private final C25166zq4 dispatcher;

    /* renamed from: J, reason: from kotlin metadata */
    private final InterfaceC11814db6 saveStateRegistry;

    /* renamed from: z0, reason: from kotlin metadata */
    private final int compositeKeyHash;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            ViewFactoryHolder.this.typedView.saveHierarchyState(sparseArray);
            return sparseArray;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        public final void a() {
            ViewFactoryHolder.this.getReleaseBlock().invoke(ViewFactoryHolder.this.typedView);
            ViewFactoryHolder.this.J();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        public final void a() {
            ViewFactoryHolder.this.getResetBlock().invoke(ViewFactoryHolder.this.typedView);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        public final void a() {
            ViewFactoryHolder.this.getUpdateBlock().invoke(ViewFactoryHolder.this.typedView);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* synthetic */ ViewFactoryHolder(Context context, AbstractC7050Qb1 abstractC7050Qb1, View view, C25166zq4 c25166zq4, InterfaceC11814db6 interfaceC11814db6, int i, InterfaceC23714xO4 interfaceC23714xO4, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : abstractC7050Qb1, view, (i2 & 8) != 0 ? new C25166zq4() : c25166zq4, interfaceC11814db6, i, interfaceC23714xO4);
    }

    private final void I() {
        InterfaceC11814db6 interfaceC11814db6 = this.saveStateRegistry;
        if (interfaceC11814db6 != null) {
            setSavableRegistryEntry(interfaceC11814db6.f(this.saveStateKey, new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        setSavableRegistryEntry(null);
    }

    private final void setSavableRegistryEntry(InterfaceC11814db6.a aVar) {
        InterfaceC11814db6.a aVar2 = this.savableRegistryEntry;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.savableRegistryEntry = aVar;
    }

    public final C25166zq4 getDispatcher() {
        return this.dispatcher;
    }

    public final UA2 getReleaseBlock() {
        return this.releaseBlock;
    }

    public final UA2 getResetBlock() {
        return this.resetBlock;
    }

    @Override // ir.nasim.EX7
    public /* bridge */ /* synthetic */ AbstractComposeView getSubCompositionView() {
        return super.getSubCompositionView();
    }

    public final UA2 getUpdateBlock() {
        return this.updateBlock;
    }

    @Override // ir.nasim.EX7
    public View getViewRoot() {
        return this;
    }

    public final void setReleaseBlock(UA2 ua2) {
        this.releaseBlock = ua2;
        setRelease(new b());
    }

    public final void setResetBlock(UA2 ua2) {
        this.resetBlock = ua2;
        setReset(new c());
    }

    public final void setUpdateBlock(UA2 ua2) {
        this.updateBlock = ua2;
        setUpdate(new d());
    }

    private ViewFactoryHolder(Context context, AbstractC7050Qb1 abstractC7050Qb1, View view, C25166zq4 c25166zq4, InterfaceC11814db6 interfaceC11814db6, int i, InterfaceC23714xO4 interfaceC23714xO4) {
        super(context, abstractC7050Qb1, i, c25166zq4, view, interfaceC23714xO4);
        this.typedView = view;
        this.dispatcher = c25166zq4;
        this.saveStateRegistry = interfaceC11814db6;
        this.compositeKeyHash = i;
        setClipChildren(false);
        String strValueOf = String.valueOf(i);
        this.saveStateKey = strValueOf;
        Object objE = interfaceC11814db6 != null ? interfaceC11814db6.e(strValueOf) : null;
        SparseArray<Parcelable> sparseArray = objE instanceof SparseArray ? (SparseArray) objE : null;
        if (sparseArray != null) {
            view.restoreHierarchyState(sparseArray);
        }
        I();
        this.updateBlock = AbstractC11355cs.e();
        this.resetBlock = AbstractC11355cs.e();
        this.releaseBlock = AbstractC11355cs.e();
    }

    public ViewFactoryHolder(Context context, UA2 ua2, AbstractC7050Qb1 abstractC7050Qb1, InterfaceC11814db6 interfaceC11814db6, int i, InterfaceC23714xO4 interfaceC23714xO4) {
        this(context, abstractC7050Qb1, (View) ua2.invoke(context), null, interfaceC11814db6, i, interfaceC23714xO4, 8, null);
    }
}
