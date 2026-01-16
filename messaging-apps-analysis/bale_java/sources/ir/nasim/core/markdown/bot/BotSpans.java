package ir.nasim.core.markdown.bot;

import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11458d25;
import ir.nasim.C5668Ki0;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.designsystem.BaseUrlSpan;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lir/nasim/core/markdown/bot/BotSpans;", "Lir/nasim/designsystem/BaseUrlSpan;", "", "url", "Lir/nasim/Ki0;", "data", "<init>", "(Ljava/lang/String;Lir/nasim/Ki0;)V", "Landroid/view/View;", "widget", "Lir/nasim/rB7;", "onClick", "(Landroid/view/View;)V", "a", "Lir/nasim/Ki0;", "getData", "()Lir/nasim/Ki0;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class BotSpans extends BaseUrlSpan {

    /* renamed from: a, reason: from kotlin metadata */
    private final C5668Ki0 data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BotSpans(String str, C5668Ki0 c5668Ki0) {
        super(str);
        AbstractC13042fc3.i(c5668Ki0, "data");
        this.data = c5668Ki0;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        C11458d25 c11458d25B;
        AbstractC13042fc3.i(widget, "widget");
        if ((this.data.a() == ExPeerType.BOT || this.data.a() == ExPeerType.GROUP) && (c11458d25B = this.data.b()) != null) {
            AbstractC5969Lp4.e().H().D1(c11458d25B, getURL(), null);
        }
    }
}
