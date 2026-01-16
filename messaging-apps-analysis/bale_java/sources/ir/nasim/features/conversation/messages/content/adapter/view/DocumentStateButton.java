package ir.nasim.features.conversation.messages.content.adapter.view;

import android.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C22078ud6;
import ir.nasim.C22352v54;
import ir.nasim.C5495Jo7;
import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.KB5;
import ir.nasim.UA2;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001/B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\fJ\u001f\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\n2\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\n2\b\b\u0001\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010 \u001a\u00020\n2\b\b\u0001\u0010\u001f\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b \u0010$J\u0017\u0010%\u001a\u00020\n2\b\b\u0001\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b%\u0010!J\u0015\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0006¢\u0006\u0004\b'\u0010!J\u0015\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0006¢\u0006\u0004\b)\u0010!J\u001f\u0010+\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0004\b-\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u00102¨\u00064"}, d2 = {"Lir/nasim/features/conversation/messages/content/adapter/view/DocumentStateButton;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "i", "()V", "Lkotlin/Function1;", "Lir/nasim/features/conversation/messages/content/adapter/view/DocumentStateButton$a;", "block", "setOnClickListener", "(Lir/nasim/UA2;)V", "b", "", "isDownload", "withCancelIcon", "e", "(ZZ)V", "imageRes", "c", "(Ljava/lang/Integer;)V", "progress", "Lir/nasim/features/conversation/messages/content/CircleProgressBar;", "h", "(I)Lir/nasim/features/conversation/messages/content/CircleProgressBar;", "color", "setBackgroundColor", "(I)V", "Landroid/graphics/PorterDuff$Mode;", "mode", "(ILandroid/graphics/PorterDuff$Mode;)V", "setTintColor", "width", "setProgressStrokeWidth", "padding", "setIconPadding", "height", "setIconSize", "(II)V", "setProgressBarSize", "Lir/nasim/v54;", "a", "Lir/nasim/v54;", "binding", "Lir/nasim/features/conversation/messages/content/adapter/view/DocumentStateButton$a;", "state", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class DocumentStateButton extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final C22352v54 binding;

    /* renamed from: b, reason: from kotlin metadata */
    private a state;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final a a = new a("DOWNLOAD_NEEDED", 0);
        public static final a b = new a("DOWNLOAD_PROGRESS", 1);
        public static final a c = new a("UPLOAD_PROGRESS", 2);
        public static final a d = new a("IDLE", 3);
        private static final /* synthetic */ a[] e;
        private static final /* synthetic */ F92 f;

        static {
            a[] aVarArrA = a();
            e = aVarArrA;
            f = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c, d};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DocumentStateButton(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    public static /* synthetic */ void d(DocumentStateButton documentStateButton, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        documentStateButton.c(num);
    }

    public static /* synthetic */ void f(DocumentStateButton documentStateButton, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        documentStateButton.e(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(UA2 ua2, DocumentStateButton documentStateButton, View view) {
        AbstractC13042fc3.i(ua2, "$block");
        AbstractC13042fc3.i(documentStateButton, "this$0");
        ua2.invoke(documentStateButton.state);
    }

    private final void i() {
        this.binding.c.setStrokeWidth(C22078ud6.a(2.0f));
    }

    public static /* synthetic */ void setIconSize$default(DocumentStateButton documentStateButton, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        documentStateButton.setIconSize(i, i2);
    }

    public static /* synthetic */ void setProgressBarSize$default(DocumentStateButton documentStateButton, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = i;
        }
        documentStateButton.setProgressBarSize(i, i2);
    }

    public final void b() {
        C22352v54 c22352v54 = this.binding;
        this.state = a.a;
        c22352v54.b.setImageResource(KB5.bubble_document_state_download);
        setContentDescription(c22352v54.b.getContext().getString(AbstractC12217eE5.item_not_downloaded_content_description));
        setVisibility(0);
        CircleProgressBar circleProgressBar = c22352v54.c;
        AbstractC13042fc3.f(circleProgressBar);
        circleProgressBar.setVisibility(8);
        circleProgressBar.setValue(0);
        ImageView imageView = c22352v54.b;
        AbstractC13042fc3.h(imageView, "image");
        imageView.setVisibility(0);
    }

    public final void c(Integer imageRes) {
        C22352v54 c22352v54 = this.binding;
        this.state = a.d;
        CircleProgressBar circleProgressBar = c22352v54.c;
        AbstractC13042fc3.f(circleProgressBar);
        circleProgressBar.setVisibility(8);
        circleProgressBar.setValue(0);
        if (imageRes == null) {
            setVisibility(8);
            ImageView imageView = c22352v54.b;
            AbstractC13042fc3.h(imageView, "image");
            imageView.setVisibility(8);
            return;
        }
        setVisibility(0);
        c22352v54.b.setImageResource(imageRes.intValue());
        ImageView imageView2 = c22352v54.b;
        AbstractC13042fc3.h(imageView2, "image");
        imageView2.setVisibility(0);
    }

    public final void e(boolean isDownload, boolean withCancelIcon) {
        C22352v54 c22352v54 = this.binding;
        a aVar = isDownload ? a.b : a.c;
        if (this.state != aVar) {
            this.state = aVar;
            setVisibility(0);
            CircleProgressBar circleProgressBar = c22352v54.c;
            AbstractC13042fc3.h(circleProgressBar, "progressBar");
            circleProgressBar.setVisibility(0);
            h(0);
            if (withCancelIcon) {
                setContentDescription(getContext().getString(AbstractC12217eE5.item_downloading_content_description));
            }
            ImageView imageView = c22352v54.b;
            if (!withCancelIcon) {
                AbstractC13042fc3.f(imageView);
                imageView.setVisibility(8);
            } else {
                AbstractC13042fc3.f(imageView);
                imageView.setVisibility(0);
                imageView.setImageResource(KB5.message_button_cancel);
                imageView.setContentDescription(imageView.getContext().getString(AbstractC12217eE5.item_downloading_content_description));
            }
        }
    }

    public final CircleProgressBar h(int progress) {
        CircleProgressBar circleProgressBar = this.binding.c;
        circleProgressBar.setValue(progress);
        AbstractC13042fc3.h(circleProgressBar, "apply(...)");
        return circleProgressBar;
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        setBackgroundColor(color, PorterDuff.Mode.SRC_ATOP);
    }

    public final void setIconPadding(int padding) {
        ImageView imageView = this.binding.b;
        AbstractC13042fc3.h(imageView, "image");
        imageView.setPadding(padding, padding, padding, padding);
    }

    public final void setIconSize(int width, int height) {
        ImageView imageView = this.binding.b;
        AbstractC13042fc3.h(imageView, "image");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = width;
        layoutParams2.height = height;
        imageView.setLayoutParams(layoutParams2);
    }

    public final void setOnClickListener(final UA2 block) {
        AbstractC13042fc3.i(block, "block");
        super.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.NW1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentStateButton.g(block, this, view);
            }
        });
    }

    public final void setProgressBarSize(int width, int height) {
        CircleProgressBar circleProgressBar = this.binding.c;
        AbstractC13042fc3.h(circleProgressBar, "progressBar");
        ViewGroup.LayoutParams layoutParams = circleProgressBar.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = width;
        layoutParams2.height = height;
        circleProgressBar.setLayoutParams(layoutParams2);
    }

    public final void setProgressStrokeWidth(int width) {
        this.binding.c.setStrokeWidth(width);
    }

    public final void setTintColor(int color) {
        C22352v54 c22352v54 = this.binding;
        CircleProgressBar circleProgressBar = c22352v54.c;
        circleProgressBar.setColor(color);
        circleProgressBar.setBgColor(C5495Jo7.a.y0(color, 40));
        c22352v54.b.setColorFilter(color);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DocumentStateButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public final void setBackgroundColor(int color, PorterDuff.Mode mode) {
        AbstractC13042fc3.i(mode, "mode");
        getBackground().setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    public /* synthetic */ DocumentStateButton(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.textViewStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentStateButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        C22352v54 c22352v54B = C22352v54.b(LayoutInflater.from(context), this);
        AbstractC13042fc3.h(c22352v54B, "inflate(...)");
        this.binding = c22352v54B;
        this.state = a.a;
        setBackgroundResource(KB5.circle_bubble_secondary_color);
        d(this, null, 1, null);
        if (!isInEditMode()) {
            i();
            return;
        }
        CircleProgressBar circleProgressBar = c22352v54B.c;
        AbstractC13042fc3.f(circleProgressBar);
        circleProgressBar.setVisibility(0);
        circleProgressBar.setValue(45);
        setVisibility(0);
        ImageView imageView = c22352v54B.b;
        AbstractC13042fc3.h(imageView, "image");
        imageView.setVisibility(0);
    }
}
