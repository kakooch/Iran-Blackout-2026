package ir.nasim.core.markdown.hashtag;

import android.text.TextPaint;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23348wm0;
import ir.nasim.UA2;
import ir.nasim.XV4;
import ir.nasim.designsystem.BaseUrlSpan;
import ir.nasim.features.root.RootActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0007B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lir/nasim/core/markdown/hashtag/HashTagSpans;", "Lir/nasim/designsystem/BaseUrlSpan;", "", "url", "<init>", "(Ljava/lang/String;)V", "Lir/nasim/rB7;", "a", "()V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", "ds", "updateDrawState", "(Landroid/text/TextPaint;)V", "Lkotlin/Function1;", "Lir/nasim/UA2;", "getListener", "()Lir/nasim/UA2;", "setListener", "(Lir/nasim/UA2;)V", "listener", "b", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class HashTagSpans extends BaseUrlSpan {
    public static final int c = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private UA2 listener;

    public HashTagSpans(String str) {
        super(str);
    }

    private final void a() {
        RootActivity.Companion.i(RootActivity.INSTANCE, null, "action_open_hashtag", AbstractC23348wm0.b(new XV4("arg_url", getURL())), 1, null);
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View v) {
        AbstractC13042fc3.i(v, "v");
        UA2 ua2 = this.listener;
        if (ua2 == null) {
            a();
        } else if (ua2 != null) {
            String url = getURL();
            AbstractC13042fc3.h(url, "getURL(...)");
            ua2.invoke(url);
        }
    }

    @Override // ir.nasim.designsystem.BaseUrlSpan, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        AbstractC13042fc3.i(ds, "ds");
        ds.setColor(ds.linkColor);
        ds.setUnderlineText(false);
    }
}
