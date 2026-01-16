package ir.nasim.features.conversation.placeholder;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC7751Ta6;
import ir.nasim.AbstractC7987Ua6;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C20644sM5;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C8221Va6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lir/nasim/features/conversation/placeholder/SaptaBotEmptyView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lir/nasim/rB7;", "b", "()V", "c", "a", "Lir/nasim/Va6;", "Lir/nasim/Va6;", "getBinding", "()Lir/nasim/Va6;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class SaptaBotEmptyView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final C8221Va6 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaptaBotEmptyView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        C8221Va6 c8221Va6C = C8221Va6.c(LayoutInflater.from(context), this, true);
        AbstractC13042fc3.h(c8221Va6C, "inflate(...)");
        this.binding = c8221Va6C;
        b();
        c();
        a();
    }

    private final void a() {
        if (Build.VERSION.SDK_INT >= 28) {
            AbstractC7987Ua6.a();
            BulletSpan bulletSpanA = AbstractC7751Ta6.a(1, C5495Jo7.a.g1(), 10);
            String string = getContext().getString(AbstractC12217eE5.item1_sapta_bot_empty_state);
            AbstractC13042fc3.h(string, "getString(...)");
            SpannableString spannableString = new SpannableString(new C20644sM5("•").k(string, ""));
            spannableString.setSpan(bulletSpanA, 0, 1, 33);
            this.binding.d.setText(spannableString);
            String string2 = getContext().getString(AbstractC12217eE5.item2_sapta_bot_empty_state);
            AbstractC13042fc3.h(string2, "getString(...)");
            SpannableString spannableString2 = new SpannableString(new C20644sM5("•").k(string2, ""));
            spannableString2.setSpan(bulletSpanA, 0, 1, 33);
            this.binding.e.setText(spannableString2);
            String string3 = getContext().getString(AbstractC12217eE5.item3_sapta_bot_empty_state);
            AbstractC13042fc3.h(string3, "getString(...)");
            SpannableString spannableString3 = new SpannableString(new C20644sM5("•").k(string3, ""));
            spannableString3.setSpan(bulletSpanA, 0, 1, 33);
            this.binding.f.setText(spannableString3);
            String string4 = getContext().getString(AbstractC12217eE5.item4_sapta_bot_empty_state);
            AbstractC13042fc3.h(string4, "getString(...)");
            SpannableString spannableString4 = new SpannableString(new C20644sM5("•").k(string4, ""));
            spannableString4.setSpan(bulletSpanA, 0, 1, 33);
            this.binding.g.setText(spannableString4);
        }
    }

    private final void b() {
        TextView textView = this.binding.k;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.t2());
        this.binding.k.setTypeface(C6011Lu2.i());
        this.binding.i.setTextColor(c5495Jo7.t2());
        this.binding.i.setTypeface(C6011Lu2.k());
        this.binding.b.setTextColor(c5495Jo7.t2());
        this.binding.b.setTypeface(C6011Lu2.k());
        this.binding.j.setTextColor(c5495Jo7.g1());
        this.binding.j.setTypeface(C6011Lu2.i());
        this.binding.d.setTextColor(c5495Jo7.g1());
        this.binding.d.setTypeface(C6011Lu2.k());
        this.binding.e.setTextColor(c5495Jo7.g1());
        this.binding.e.setTypeface(C6011Lu2.k());
        this.binding.f.setTextColor(c5495Jo7.g1());
        this.binding.f.setTypeface(C6011Lu2.k());
        this.binding.g.setTextColor(c5495Jo7.g1());
        this.binding.g.setTypeface(C6011Lu2.k());
    }

    private final void c() {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12)}, null, null));
        shapeDrawable.getPaint().setColor(C5495Jo7.a.P0());
        shapeDrawable.getPaint().setAlpha(SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER);
        shapeDrawable.getPaint().setAntiAlias(true);
        this.binding.getRoot().setBackgroundDrawable(shapeDrawable);
    }

    public final C8221Va6 getBinding() {
        return this.binding;
    }
}
