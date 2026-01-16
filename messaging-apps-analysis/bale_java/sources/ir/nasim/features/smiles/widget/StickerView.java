package ir.nasim.features.smiles.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.facebook.shimmer.a;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C6506Nu3;
import ir.nasim.DX1;
import ir.nasim.ED1;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC7857Tm2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.KB5;
import ir.nasim.QI2;
import ir.nasim.core.modules.file.entity.FileReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\rJ%\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u000b¢\u0006\u0004\b(\u0010\rJ\r\u0010*\u001a\u00020)¢\u0006\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u00103R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006:"}, d2 = {"Lir/nasim/features/smiles/widget/StickerView;", "Landroid/widget/FrameLayout;", "Lir/nasim/Um2;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "j", "()V", "i", "f", "n", "k", "l", "Lir/nasim/core/modules/file/entity/FileReference;", "fileReference", "callback", "a", "(Lir/nasim/core/modules/file/entity/FileReference;Lir/nasim/Um2;)V", "Lir/nasim/DX1;", "downloadError", "g", "(Lir/nasim/DX1;)V", "", "progress", "c", "(F)V", "Lir/nasim/Am2;", "reference", "d", "(Lir/nasim/Am2;)V", "", "path", "h", "(Ljava/lang/String;)V", "m", "Landroidx/appcompat/widget/AppCompatImageView;", "getImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "Lir/nasim/Nu3;", "Lir/nasim/Nu3;", "binding", "Lcom/facebook/shimmer/a;", "b", "Lcom/facebook/shimmer/a;", "shimmer", "Lir/nasim/core/modules/file/entity/FileReference;", "Lir/nasim/Tm2;", "Lir/nasim/Tm2;", "boundFile", "e", "Lir/nasim/Um2;", "downloadCallback", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class StickerView extends FrameLayout implements InterfaceC8091Um2 {

    /* renamed from: a, reason: from kotlin metadata */
    private final C6506Nu3 binding;

    /* renamed from: b, reason: from kotlin metadata */
    private final com.facebook.shimmer.a shimmer;

    /* renamed from: c, reason: from kotlin metadata */
    private FileReference fileReference;

    /* renamed from: d, reason: from kotlin metadata */
    private InterfaceC7857Tm2 boundFile;

    /* renamed from: e, reason: from kotlin metadata */
    private InterfaceC8091Um2 downloadCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    public static /* synthetic */ void b(StickerView stickerView, FileReference fileReference, InterfaceC8091Um2 interfaceC8091Um2, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC8091Um2 = null;
        }
        stickerView.a(fileReference, interfaceC8091Um2);
    }

    private final void f() {
        AppCompatImageView appCompatImageView = this.binding.d;
        appCompatImageView.setImageURI(null);
        appCompatImageView.setImageDrawable(null);
    }

    private final void i() {
        AppCompatImageView appCompatImageView = this.binding.d;
        AbstractC13042fc3.h(appCompatImageView, "ivSticker");
        appCompatImageView.setVisibility(0);
        l();
    }

    private final void j() {
        C6506Nu3 c6506Nu3 = this.binding;
        c6506Nu3.d.setVisibility(4);
        c6506Nu3.c.setImageResource(KB5.sticker_placeholder);
        k();
    }

    private final void k() {
        ShimmerFrameLayout shimmerFrameLayout = this.binding.b;
        AbstractC13042fc3.h(shimmerFrameLayout, "frShimmer");
        shimmerFrameLayout.setVisibility(0);
        this.binding.b.e();
    }

    private final void l() {
        this.binding.b.setVisibility(8);
        this.binding.b.f();
    }

    private final void n() {
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.boundFile;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
        }
        this.boundFile = null;
        this.fileReference = null;
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
        j();
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 reference) {
        AbstractC13042fc3.i(reference, "reference");
        InterfaceC8091Um2 interfaceC8091Um2 = this.downloadCallback;
        if (interfaceC8091Um2 != null) {
            interfaceC8091Um2.d(reference);
        }
        h(reference.getDescriptor());
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void g(DX1 downloadError) {
        InterfaceC8091Um2 interfaceC8091Um2 = this.downloadCallback;
        if (interfaceC8091Um2 != null) {
            interfaceC8091Um2.g(downloadError);
        }
    }

    public final AppCompatImageView getImageView() {
        AppCompatImageView appCompatImageView = this.binding.d;
        AbstractC13042fc3.h(appCompatImageView, "ivSticker");
        return appCompatImageView;
    }

    public final void h(String path) {
        AbstractC13042fc3.i(path, "path");
        C6506Nu3 c6506Nu3 = this.binding;
        i();
        AppCompatImageView appCompatImageView = c6506Nu3.d;
        AbstractC13042fc3.h(appCompatImageView, "ivSticker");
        QI2.p(path, appCompatImageView, null, 4, null);
    }

    public final void m() {
        n();
        f();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ StickerView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        com.facebook.shimmer.a aVarA = ((a.C0157a) ((a.C0157a) new a.C0157a().f(0.8f)).h(2)).a();
        AbstractC13042fc3.h(aVarA, "build(...)");
        this.shimmer = aVarA;
        C6506Nu3 c6506Nu3B = C6506Nu3.b(LayoutInflater.from(context), this);
        this.binding = c6506Nu3B;
        c6506Nu3B.b.c(aVarA);
    }
}
