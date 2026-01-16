package ir.nasim.features.smiles.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.shimmer.a;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C8610Ws;
import ir.nasim.DX1;
import ir.nasim.ED1;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC7857Tm2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.VH2;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.designsystem.GifViewCrossFade;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\rJ#\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u000b¢\u0006\u0004\b)\u0010\rR\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010.R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00100R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u00108¨\u0006:"}, d2 = {"Lir/nasim/features/smiles/widget/GifRecyclerItemView;", "Landroid/widget/FrameLayout;", "Lir/nasim/Um2;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "i", "()V", "h", "b", "m", "n", "j", "k", "Lir/nasim/core/modules/file/entity/FileReference;", "fileReference", "callback", "a", "(Lir/nasim/core/modules/file/entity/FileReference;Lir/nasim/Um2;)V", "Lir/nasim/DX1;", "downloadError", "g", "(Lir/nasim/DX1;)V", "", "progress", "c", "(F)V", "Lir/nasim/Am2;", "reference", "d", "(Lir/nasim/Am2;)V", "", "path", "f", "(Ljava/lang/String;)V", "l", "Lir/nasim/VH2;", "Lir/nasim/VH2;", "binding", "Lcom/facebook/shimmer/a;", "Lcom/facebook/shimmer/a;", "shimmer", "Lir/nasim/core/modules/file/entity/FileReference;", "Lir/nasim/Tm2;", "Lir/nasim/Tm2;", "boundFile", "e", "Lir/nasim/Um2;", "downloadCallback", "Lir/nasim/Ws;", "Lir/nasim/Ws;", "animatedFileDrawable", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class GifRecyclerItemView extends FrameLayout implements InterfaceC8091Um2 {

    /* renamed from: a, reason: from kotlin metadata */
    private final VH2 binding;

    /* renamed from: b, reason: from kotlin metadata */
    private final com.facebook.shimmer.a shimmer;

    /* renamed from: c, reason: from kotlin metadata */
    private FileReference fileReference;

    /* renamed from: d, reason: from kotlin metadata */
    private InterfaceC7857Tm2 boundFile;

    /* renamed from: e, reason: from kotlin metadata */
    private InterfaceC8091Um2 downloadCallback;

    /* renamed from: f, reason: from kotlin metadata */
    private C8610Ws animatedFileDrawable;

    public /* synthetic */ GifRecyclerItemView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void b() {
        this.binding.c.c();
    }

    private final void h() {
        GifViewCrossFade gifViewCrossFade = this.binding.c;
        AbstractC13042fc3.h(gifViewCrossFade, "imgGif");
        gifViewCrossFade.setVisibility(0);
        k();
    }

    private final void i() {
        j();
    }

    private final void j() {
        this.binding.b.e();
    }

    private final void k() {
        this.binding.b.f();
    }

    private final void m() {
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.boundFile;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
        }
        this.boundFile = null;
        this.fileReference = null;
    }

    private final void n() {
        C8610Ws c8610Ws = this.animatedFileDrawable;
        if (c8610Ws != null) {
            c8610Ws.stop();
            c8610Ws.S(null);
        }
        this.animatedFileDrawable = null;
    }

    public final void a(FileReference fileReference, InterfaceC8091Um2 callback) {
        if ((!AbstractC13042fc3.d(this.fileReference, fileReference) || this.boundFile == null) && fileReference != null) {
            this.fileReference = fileReference;
            this.downloadCallback = callback;
            this.boundFile = AbstractC5969Lp4.e().D().D(fileReference, true, this, (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        }
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void c(float progress) {
        InterfaceC8091Um2 interfaceC8091Um2 = this.downloadCallback;
        if (interfaceC8091Um2 != null) {
            interfaceC8091Um2.c(progress);
        }
        i();
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 reference) {
        AbstractC13042fc3.i(reference, "reference");
        InterfaceC8091Um2 interfaceC8091Um2 = this.downloadCallback;
        if (interfaceC8091Um2 != null) {
            interfaceC8091Um2.d(reference);
        }
        f(reference.getDescriptor());
    }

    public final void f(String path) {
        AbstractC13042fc3.i(path, "path");
        VH2 vh2 = this.binding;
        h();
        n();
        C8610Ws c8610Ws = new C8610Ws(new File(path), false);
        vh2.c.g(c8610Ws, true);
        this.animatedFileDrawable = c8610Ws;
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void g(DX1 downloadError) {
        InterfaceC8091Um2 interfaceC8091Um2 = this.downloadCallback;
        if (interfaceC8091Um2 != null) {
            interfaceC8091Um2.g(downloadError);
        }
    }

    public final void l() {
        m();
        b();
        n();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifRecyclerItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        com.facebook.shimmer.a aVarA = ((a.C0157a) ((a.C0157a) ((a.C0157a) ((a.C0157a) new a.C0157a().f(1.0f)).n(0.8f)).h(2)).e(false)).a();
        AbstractC13042fc3.h(aVarA, "build(...)");
        this.shimmer = aVarA;
        VH2 vh2B = VH2.b(LayoutInflater.from(context), this);
        this.binding = vh2B;
        vh2B.b.c(aVarA);
        vh2B.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        vh2B.c.setCornerRadius((int) ((4 * AbstractC3742Cd6.c()) + 0.5d));
    }
}
