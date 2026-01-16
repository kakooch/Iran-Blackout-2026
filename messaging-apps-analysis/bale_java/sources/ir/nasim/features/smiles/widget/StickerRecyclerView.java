package ir.nasim.features.smiles.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.gov.nist.core.Separators;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.C23698xM6;
import ir.nasim.ED1;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.R62;
import ir.nasim.RF6;
import ir.nasim.SA2;
import ir.nasim.features.smiles.widget.StickerRecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001HB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\rJ\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\rJ\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\rJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R*\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R(\u00105\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lir/nasim/features/smiles/widget/StickerRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lir/nasim/Um2;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "e1", "()V", "Lir/nasim/xM6;", "s", "i1", "(Lir/nasim/xM6;)V", "c1", "h1", "Lir/nasim/features/smiles/widget/StickerRecyclerView$a;", "currentViewModel", "f1", "(Lir/nasim/features/smiles/widget/StickerRecyclerView$a;)V", "b1", "Lir/nasim/Am2;", "reference", "d", "(Lir/nasim/Am2;)V", "e", "", "progress", "c", "(F)V", "Lkotlin/Function0;", "B1", "Lir/nasim/SA2;", "getOnClearRecentListener", "()Lir/nasim/SA2;", "setOnClearRecentListener", "(Lir/nasim/SA2;)V", "onClearRecentListener", "C1", "Lir/nasim/Yu3;", "get_previewSize", "()I", "_previewSize", "Landroid/app/Dialog;", "value", "D1", "Landroid/app/Dialog;", "getStickerDialogPreview", "()Landroid/app/Dialog;", "stickerDialogPreview", "Lir/nasim/features/smiles/widget/StickerView;", "E1", "Lir/nasim/features/smiles/widget/StickerView;", "lastStickerViewPreviewGlide", "", "F1", "Z", "closePreview", "G1", "Lir/nasim/features/smiles/widget/StickerRecyclerView$a;", "Landroid/os/Handler;", "H1", "Landroid/os/Handler;", "onLongHandler", "Ljava/lang/Runnable;", "I1", "Ljava/lang/Runnable;", "onLongRunnable", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class StickerRecyclerView extends RecyclerView implements InterfaceC8091Um2 {

    /* renamed from: B1, reason: from kotlin metadata */
    private SA2 onClearRecentListener;

    /* renamed from: C1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 _previewSize;

    /* renamed from: D1, reason: from kotlin metadata */
    private Dialog stickerDialogPreview;

    /* renamed from: E1, reason: from kotlin metadata */
    private StickerView lastStickerViewPreviewGlide;

    /* renamed from: F1, reason: from kotlin metadata */
    private boolean closePreview;

    /* renamed from: G1, reason: from kotlin metadata */
    private a currentViewModel;

    /* renamed from: H1, reason: from kotlin metadata */
    private final Handler onLongHandler;

    /* renamed from: I1, reason: from kotlin metadata */
    private final Runnable onLongRunnable;

    public static final class a {
        private final C23698xM6 a;
        private final boolean b;

        public a(C23698xM6 c23698xM6, boolean z) {
            this.a = c23698xM6;
            this.b = z;
        }

        public final C23698xM6 a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            C23698xM6 c23698xM6 = this.a;
            return ((c23698xM6 == null ? 0 : c23698xM6.hashCode()) * 31) + Boolean.hashCode(this.b);
        }

        public String toString() {
            return "CurrentViewModel(sticker=" + this.a + ", isRecent=" + this.b + Separators.RPAREN;
        }
    }

    public static final class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            StickerRecyclerView.this.closePreview = true;
            super.a(recyclerView, i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerRecyclerView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Z0(StickerRecyclerView stickerRecyclerView) {
        AbstractC13042fc3.i(stickerRecyclerView, "this$0");
        if (stickerRecyclerView.isInEditMode()) {
            return 256;
        }
        return RF6.a.i();
    }

    private final void c1() {
        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(1);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.gravity = 17;
            window.setAttributes(layoutParams);
        }
        dialog.setCancelable(true);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.nasim.qN6
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                StickerRecyclerView.d1(this.a, dialogInterface);
            }
        });
        this.stickerDialogPreview = dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(StickerRecyclerView stickerRecyclerView, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(stickerRecyclerView, "this$0");
        StickerView stickerView = stickerRecyclerView.lastStickerViewPreviewGlide;
        if (stickerView != null) {
            stickerView.m();
        }
    }

    private final void e1() {
        if (isInEditMode()) {
            return;
        }
        c1();
        setHasFixedSize(true);
        addOnScrollListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(StickerRecyclerView stickerRecyclerView) {
        AbstractC13042fc3.i(stickerRecyclerView, "this$0");
        a aVar = stickerRecyclerView.currentViewModel;
        if (aVar == null || stickerRecyclerView.closePreview) {
            return;
        }
        if (!aVar.b()) {
            if (aVar.a() != null) {
                stickerRecyclerView.i1(aVar.a());
            }
        } else {
            SA2 sa2 = stickerRecyclerView.onClearRecentListener;
            if (sa2 != null) {
                sa2.invoke();
            }
        }
    }

    private final int get_previewSize() {
        return ((Number) this._previewSize.getValue()).intValue();
    }

    private final void h1() {
        this.onLongHandler.removeCallbacks(this.onLongRunnable);
        this.onLongHandler.postDelayed(this.onLongRunnable, 300L);
    }

    private final void i1(C23698xM6 s) {
        ImageViewEmoji imageViewEmoji;
        Dialog dialog;
        if (isInEditMode() || this.stickerDialogPreview == null) {
            return;
        }
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        StickerView stickerView = new StickerView(context, null, 0, 6, null);
        AppCompatImageView imageView = stickerView.getImageView();
        imageView.setMinimumHeight(get_previewSize());
        imageView.setMaxHeight(get_previewSize());
        imageView.setMinimumWidth(get_previewSize());
        imageView.setMaxWidth(get_previewSize());
        stickerView.a(s.C(), this);
        this.lastStickerViewPreviewGlide = stickerView;
        String strW = s.w();
        if (strW != null) {
            Context context2 = getContext();
            AbstractC13042fc3.h(context2, "getContext(...)");
            imageViewEmoji = new ImageViewEmoji(context2, null, 0, 6, null);
            imageViewEmoji.setPaddingRatio(0.05f);
            imageViewEmoji.setImageDrawable(R62.a.y(strW));
        } else {
            imageViewEmoji = null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        RF6 rf6 = RF6.a;
        linearLayout.addView(imageViewEmoji, (int) rf6.e(), (int) rf6.e());
        linearLayout.addView(this.lastStickerViewPreviewGlide, get_previewSize(), get_previewSize());
        Dialog dialog2 = this.stickerDialogPreview;
        if (dialog2 != null) {
            dialog2.setContentView(linearLayout, new LinearLayout.LayoutParams(-1, -1));
        }
        Dialog dialog3 = this.stickerDialogPreview;
        if (dialog3 == null || dialog3.isShowing() || (dialog = this.stickerDialogPreview) == null) {
            return;
        }
        dialog.show();
    }

    public final void b1() {
        Dialog dialog;
        this.closePreview = true;
        Dialog dialog2 = this.stickerDialogPreview;
        if (dialog2 == null || !dialog2.isShowing() || (dialog = this.stickerDialogPreview) == null) {
            return;
        }
        dialog.dismiss();
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void c(float progress) {
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 reference) {
        AbstractC13042fc3.i(reference, "reference");
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void e() {
    }

    public final void f1(a currentViewModel) {
        AbstractC13042fc3.i(currentViewModel, "currentViewModel");
        this.closePreview = false;
        this.currentViewModel = currentViewModel;
        h1();
    }

    public final SA2 getOnClearRecentListener() {
        return this.onClearRecentListener;
    }

    public final Dialog getStickerDialogPreview() {
        return this.stickerDialogPreview;
    }

    public final void setOnClearRecentListener(SA2 sa2) {
        this.onClearRecentListener = sa2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StickerRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ StickerRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this._previewSize = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.oN6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(StickerRecyclerView.Z0(this.a));
            }
        });
        this.onLongHandler = new Handler(Looper.getMainLooper());
        this.onLongRunnable = new Runnable() { // from class: ir.nasim.pN6
            @Override // java.lang.Runnable
            public final void run() {
                StickerRecyclerView.g1(this.a);
            }
        };
        e1();
    }
}
