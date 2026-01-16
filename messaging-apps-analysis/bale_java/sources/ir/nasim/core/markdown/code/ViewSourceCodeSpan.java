package ir.nasim.core.markdown.code;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C18987pb3;
import ir.nasim.C5721Ko;
import ir.nasim.designsystem.BaseUrlSpan;
import ir.nasim.features.root.RootActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lir/nasim/core/markdown/code/ViewSourceCodeSpan;", "Lir/nasim/designsystem/BaseUrlSpan;", "", "url", "<init>", "(Ljava/lang/String;)V", "Landroid/view/View;", "widget", "Lir/nasim/rB7;", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", "ds", "updateDrawState", "(Landroid/text/TextPaint;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class ViewSourceCodeSpan extends BaseUrlSpan {
    public ViewSourceCodeSpan(String str) {
        super(str);
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        AbstractC13042fc3.i(widget, "widget");
        Context context = widget.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        String url = getURL();
        AbstractC13042fc3.h(url, "getURL(...)");
        if (C18987pb3.e1(context, url, null)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("arg_source_code", getURL());
        RootActivity.INSTANCE.h(C5721Ko.a.d(), "action_open_code_preview_fragment", bundle);
    }

    @Override // ir.nasim.designsystem.BaseUrlSpan, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        AbstractC13042fc3.i(ds, "ds");
        super.updateDrawState(ds);
        ds.setColor(ds.linkColor);
        ds.setUnderlineText(true);
    }
}
