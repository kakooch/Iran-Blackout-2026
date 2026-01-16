package ir.nasim.story.ui.storyadder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C14486i0;
import ir.nasim.C16710lk0;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.SA2;
import ir.nasim.story.ui.storyadder.StoryAdderBottomSheet;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0010R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lir/nasim/story/ui/storyadder/StoryAdderBottomSheet;", "Lir/nasim/m0;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "Lir/nasim/rB7;", "photoCapture", "videoCapture", "<init>", "(Landroid/content/Context;Lir/nasim/SA2;Lir/nasim/SA2;)V", "e", "()V", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "a", "Lir/nasim/SA2;", "b", "c", "Lir/nasim/i0;", "getAbol", "()Lir/nasim/i0;", "setAbol", "Lir/nasim/lk0;", "d", "Lir/nasim/lk0;", "binding", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class StoryAdderBottomSheet extends FrameLayout implements InterfaceC16866m0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final SA2 photoCapture;

    /* renamed from: b, reason: from kotlin metadata */
    private final SA2 videoCapture;

    /* renamed from: c, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: d, reason: from kotlin metadata */
    private C16710lk0 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryAdderBottomSheet(Context context, SA2 sa2, SA2 sa22) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(sa2, "photoCapture");
        AbstractC13042fc3.i(sa22, "videoCapture");
        this.photoCapture = sa2;
        this.videoCapture = sa22;
        this.binding = C16710lk0.c(LayoutInflater.from(context), this, true);
        e();
    }

    private final void e() {
        this.binding.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ZO6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoryAdderBottomSheet.g(this.a, view);
            }
        });
        this.binding.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.aP6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoryAdderBottomSheet.h(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(StoryAdderBottomSheet storyAdderBottomSheet, View view) {
        AbstractC13042fc3.i(storyAdderBottomSheet, "this$0");
        storyAdderBottomSheet.videoCapture.invoke();
        C14486i0 c14486i0 = storyAdderBottomSheet.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(StoryAdderBottomSheet storyAdderBottomSheet, View view) {
        AbstractC13042fc3.i(storyAdderBottomSheet, "this$0");
        storyAdderBottomSheet.photoCapture.invoke();
        C14486i0 c14486i0 = storyAdderBottomSheet.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    public final C14486i0 getAbol() {
        return this.abol;
    }

    public final void setAbol(C14486i0 c14486i0) {
        this.abol = c14486i0;
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }
}
