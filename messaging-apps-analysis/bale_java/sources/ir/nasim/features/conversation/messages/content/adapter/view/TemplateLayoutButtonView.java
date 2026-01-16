package ir.nasim.features.conversation.messages.content.adapter.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.facebook.shimmer.a;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC17026mG5;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.G73;
import ir.nasim.KB5;
import ir.nasim.OY0;
import ir.nasim.R62;
import ir.nasim.TA5;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lir/nasim/features/conversation/messages/content/adapter/view/TemplateLayoutButtonView;", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lir/nasim/rB7;", "j", "()V", "k", "", "iconRes", "g", "(I)V", "Lir/nasim/G73;", "inlineButton", "h", "(Lir/nasim/G73;)V", "i", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", ParameterNames.TEXT, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", ParameterNames.ICON, "f", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class TemplateLayoutButtonView extends ShimmerFrameLayout {
    public static final int g = 8;

    /* renamed from: d, reason: from kotlin metadata */
    private TextView text;

    /* renamed from: e, reason: from kotlin metadata */
    private ImageView icon;

    public static final class b implements G73.d {
        b() {
        }

        @Override // ir.nasim.G73.d
        public void a() {
            TemplateLayoutButtonView.this.d(true);
            TemplateLayoutButtonView.this.setEnabled(false);
        }

        @Override // ir.nasim.G73.d
        public void b() {
            TemplateLayoutButtonView.this.a();
            TemplateLayoutButtonView.this.f();
            TemplateLayoutButtonView.this.setEnabled(true);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TemplateLayoutButtonView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        AbstractC13042fc3.i(context, "context");
    }

    private final void g(int iconRes) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(iconRes);
        double d = 24;
        imageView.setLayoutParams(new FrameLayout.LayoutParams((int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((d * AbstractC3742Cd6.c()) + 0.5d), 19));
        this.icon = imageView;
        addView(imageView);
    }

    private final void h(G73 inlineButton) {
        TextView textView = new TextView(getContext());
        textView.setText(R62.V(inlineButton.b() + "\u200c", null, true));
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 17));
        if ((inlineButton instanceof G73.b) || (inlineButton instanceof G73.a)) {
            double d = 8;
            textView.setPadding(((int) ((24 * AbstractC3742Cd6.c()) + 0.5d)) + ((int) ((4 * AbstractC3742Cd6.c()) + 0.5d)), (int) ((AbstractC3742Cd6.c() * d) + 0.5d), (int) ((d * AbstractC3742Cd6.c()) + 0.5d), (int) ((AbstractC3742Cd6.c() * d) + 0.5d));
        } else {
            double d2 = 8;
            textView.setPadding((int) ((AbstractC3742Cd6.c() * d2) + 0.5d), (int) ((AbstractC3742Cd6.c() * d2) + 0.5d), (int) ((d2 * AbstractC3742Cd6.c()) + 0.5d), (int) ((AbstractC3742Cd6.c() * d2) + 0.5d));
        }
        textView.setAllCaps(false);
        textView.setSingleLine(true);
        textView.setTextAlignment(4);
        textView.setTextSize(2, 13.0f);
        textView.setTypeface(C6011Lu2.i());
        textView.setIncludeFontPadding(false);
        Context context = textView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        textView.setTextColor(OY0.b(context, AbstractC21139tA5.colorOnPrimary));
        textView.setElevation(0.0f);
        this.text = textView;
        addView(textView);
    }

    private final void j() {
        c(((a.C0157a) ((a.C0157a) ((a.C0157a) new a.C0157a().f(0.6f)).n(0.4f)).h(0)).a());
        a();
        f();
    }

    private final void k() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(AbstractC4043Dl1.c(getContext(), TA5.template));
        gradientDrawable.setCornerRadius((int) ((8 * AbstractC3742Cd6.c()) + 0.5d));
        setBackground(new RippleDrawable(ColorStateList.valueOf(AbstractC4043Dl1.c(getContext(), TA5.template_ripple)), gradientDrawable, null));
    }

    public final void i(G73 inlineButton) {
        AbstractC13042fc3.i(inlineButton, "inlineButton");
        double d = 4;
        setPadding((int) ((AbstractC3742Cd6.c() * d) + 0.5d), getPaddingTop(), (int) ((d * AbstractC3742Cd6.c()) + 0.5d), getPaddingBottom());
        if (inlineButton instanceof G73.b) {
            g(KB5.copy);
        } else if (inlineButton instanceof G73.a) {
            g(KB5.shield_done);
        }
        h(inlineButton);
        inlineButton.c(new b());
    }

    public /* synthetic */ TemplateLayoutButtonView(Context context, AttributeSet attributeSet, int i, ED1 ed1) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateLayoutButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        setId(AbstractC17026mG5.a.f());
        j();
        k();
        setMinimumWidth((int) ((24 * AbstractC3742Cd6.c()) + 0.5d));
        setMinimumHeight((int) ((42 * AbstractC3742Cd6.c()) + 0.5d));
    }
}
