package ir.nasim.core.markdown.mention;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.text.TextPaint;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11458d25;
import ir.nasim.C14733iO2;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.C8386Vt0;
import ir.nasim.ED1;
import ir.nasim.W25;
import ir.nasim.X34;
import ir.nasim.ZN2;
import ir.nasim.designsystem.BaseUrlSpan;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lir/nasim/core/markdown/mention/MentionSpans;", "Lir/nasim/designsystem/BaseUrlSpan;", "", "username", "Lir/nasim/X34;", "data", "", "userId", "<init>", "(Ljava/lang/String;Lir/nasim/X34;I)V", "Landroid/text/TextPaint;", "ds", "Lir/nasim/rB7;", "updateDrawState", "(Landroid/text/TextPaint;)V", "Landroid/view/View;", "widget", "onClick", "(Landroid/view/View;)V", "a", "Ljava/lang/String;", "getUsername", "()Ljava/lang/String;", "b", "Lir/nasim/X34;", "getData", "()Lir/nasim/X34;", "c", TokenNames.I, "getUserId", "()I", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class MentionSpans extends BaseUrlSpan {

    /* renamed from: a, reason: from kotlin metadata */
    private final String username;

    /* renamed from: b, reason: from kotlin metadata */
    private final X34 data;

    /* renamed from: c, reason: from kotlin metadata */
    private final int userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MentionSpans(String str, X34 x34, int i) {
        super(str);
        AbstractC13042fc3.i(str, "username");
        AbstractC13042fc3.i(x34, "data");
        this.username = str;
        this.data = x34;
        this.userId = i;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        C14733iO2 c14733iO2;
        AbstractC13042fc3.i(widget, "widget");
        C11458d25 c11458d25D = this.data.d();
        Object objB = "";
        if (c11458d25D != null && c11458d25D.getPeerId() != 0 && c11458d25D.s() == W25.b && (c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c11458d25D.getPeerId())) != null && c14733iO2.q() == ZN2.CHANNEL) {
            objB = c14733iO2.w().b();
        }
        if (this.userId != 0 && C8386Vt0.S7()) {
            C5735Kp4.w().y(widget.getContext(), this.userId);
        } else {
            if (AbstractC13042fc3.d(this.username, objB)) {
                return;
            }
            C5735Kp4.w().K(widget.getContext(), this.username, "dialogue", this.data.d());
        }
    }

    @Override // ir.nasim.designsystem.BaseUrlSpan, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        AbstractC13042fc3.i(ds, "ds");
        ds.setTypeface(C6011Lu2.k());
        if (C8386Vt0.S7() || this.data.c()) {
            ds.setColor(ds.linkColor);
        }
        ds.setUnderlineText(false);
    }

    public /* synthetic */ MentionSpans(String str, X34 x34, int i, int i2, ED1 ed1) {
        this(str, x34, (i2 & 4) != 0 ? 0 : i);
    }
}
