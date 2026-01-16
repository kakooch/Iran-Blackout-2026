package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.contact.data.ContactItem;
import java.util.Arrays;

/* renamed from: ir.nasim.id3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C14872id3 extends AbstractC20225rf3 {
    private final C23309wi1 w;

    /* renamed from: ir.nasim.id3$a */
    public static final class a extends ClickableSpan {
        final /* synthetic */ View.OnClickListener a;

        a(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "p0");
            this.a.onClick(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C14872id3(C23309wi1 c23309wi1, View.OnClickListener onClickListener) {
        AbstractC13042fc3.i(c23309wi1, "binding");
        AbstractC13042fc3.i(onClickListener, "onClickListener");
        MaterialCardView root = c23309wi1.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root, null, null, 4, null);
        this.w = c23309wi1;
        U0(onClickListener);
    }

    private final C17428mw7 P0(Context context, String str, View.OnClickListener onClickListener) {
        a aVar = new a(onClickListener);
        String string = context.getString(AbstractC12217eE5.user_club_bale);
        AbstractC13042fc3.h(string, "getString(...)");
        int iL0 = AbstractC20762sZ6.l0(str, string, 0, false, 6, null);
        return new C17428mw7(aVar, Integer.valueOf(iL0), Integer.valueOf(string.length() + iL0));
    }

    private final int Q0() {
        return AbstractC5969Lp4.d().o2().S().B2();
    }

    private final ImageSpan S0(Context context) {
        int iA = C22078ud6.a(14.0f);
        Drawable drawableF = AbstractC4043Dl1.f(context, KB5.ic_party_popper);
        if (drawableF == null) {
            return null;
        }
        drawableF.setBounds(0, 0, iA, iA);
        return new ImageSpan(drawableF, 1);
    }

    private final String T0(Context context) {
        DY6 dy6 = DY6.a;
        String string = context.getString(AbstractC12217eE5.contacts_invitation_card_title);
        AbstractC13042fc3.h(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(Q0())}, 1));
        AbstractC13042fc3.h(str, "format(...)");
        return str + Separators.SP;
    }

    private final void U0(View.OnClickListener onClickListener) {
        Context context = this.w.getRoot().getContext();
        AbstractC13042fc3.f(context);
        ImageSpan imageSpanS0 = S0(context);
        if (imageSpanS0 == null) {
            return;
        }
        String strT0 = T0(context);
        C17428mw7 c17428mw7P0 = P0(context, strT0, onClickListener);
        ClickableSpan clickableSpan = (ClickableSpan) c17428mw7P0.a();
        int iIntValue = ((Number) c17428mw7P0.b()).intValue();
        int iIntValue2 = ((Number) c17428mw7P0.c()).intValue();
        SpannableString spannableString = new SpannableString(strT0);
        spannableString.setSpan(clickableSpan, iIntValue, iIntValue2, 33);
        spannableString.setSpan(imageSpanS0, strT0.length() - 1, strT0.length(), 17);
        TextView textView = this.w.b;
        textView.setText(spannableString);
        textView.setTypeface(C6011Lu2.k());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC20225rf3
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public void H0(ContactItem.InvitationCard invitationCard) {
        AbstractC13042fc3.i(invitationCard, "item");
    }

    @Override // ir.nasim.AbstractC20225rf3
    public void a() {
    }
}
