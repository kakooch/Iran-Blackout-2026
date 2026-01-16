package ir.nasim;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.features.root.RootActivity;

/* renamed from: ir.nasim.yL3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24276yL3 extends ClickableSpan {
    private final boolean a;
    private final C23686xL3 b;

    public C24276yL3(boolean z, C23686xL3 c23686xL3) {
        AbstractC13042fc3.i(c23686xL3, "mdUrl");
        this.a = z;
        this.b = c23686xL3;
    }

    private final Context a(Context context) {
        return (!(context instanceof AppCompatActivity) && (context instanceof ContextWrapper)) ? a(((ContextWrapper) context).getBaseContext()) : context;
    }

    private final void c(Context context, String str) {
        Context contextA = a(context);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse(str));
        if (contextA != null) {
            contextA.startActivity(intent);
        }
    }

    private final void d(Context context, String str) {
        Context contextA = a(context);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (contextA != null) {
            contextA.startActivity(intent);
        }
    }

    public final C23686xL3 b() {
        return this.b;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        C11458d25 c11458d25K3;
        AbstractC13042fc3.i(view, "view");
        Context context = view.getContext();
        AbstractC13042fc3.f(context);
        String strA = this.b.a();
        AbstractC13042fc3.h(strA, "getUrl(...)");
        if (C18987pb3.e1(context, strA, null)) {
            return;
        }
        String strA2 = this.b.a();
        AbstractC13042fc3.h(strA2, "getUrl(...)");
        if (AbstractC20153rZ6.S(strA2, "send:", false, 2, null)) {
            Context contextA = a(context);
            RootActivity rootActivity = contextA instanceof RootActivity ? (RootActivity) contextA : null;
            if (rootActivity == null || (c11458d25K3 = rootActivity.K3()) == null) {
                return;
            }
            C11335cq c11335cqI = C5735Kp4.w().i();
            String strA3 = this.b.a();
            AbstractC13042fc3.h(strA3, "getUrl(...)");
            c11335cqI.D1(c11458d25K3, AbstractC20153rZ6.M(strA3, "send:", "", false, 4, null), null);
            return;
        }
        String strA4 = this.b.a();
        AbstractC13042fc3.h(strA4, "getUrl(...)");
        if (AbstractC20153rZ6.S(strA4, "ussd:", false, 2, null)) {
            if (a(context) instanceof RootActivity) {
                RootActivity.Companion companion = RootActivity.INSTANCE;
                String strA5 = this.b.a();
                AbstractC13042fc3.h(strA5, "getUrl(...)");
                RootActivity.Companion.f(companion, null, AbstractC20153rZ6.M(strA5, "ussd:", "", false, 4, null), 1, null);
                return;
            }
            return;
        }
        String strA6 = this.b.a();
        AbstractC13042fc3.h(strA6, "getUrl(...)");
        if (AbstractC20153rZ6.S(strA6, "tel:", false, 2, null)) {
            AbstractC13042fc3.f(context);
            String strA7 = this.b.a();
            AbstractC13042fc3.h(strA7, "getUrl(...)");
            c(context, strA7);
            return;
        }
        String strA8 = this.b.a();
        AbstractC13042fc3.h(strA8, "getUrl(...)");
        if (AbstractC20153rZ6.S(strA8, "sms:", false, 2, null)) {
            AbstractC13042fc3.f(context);
            String strA9 = this.b.a();
            AbstractC13042fc3.h(strA9, "getUrl(...)");
            d(context, strA9);
            return;
        }
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        AbstractC13042fc3.f(context);
        Uri uri = Uri.parse(this.b.a());
        AbstractC13042fc3.h(uri, "parse(...)");
        aVar.E(context, uri);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AbstractC13042fc3.i(textPaint, "paint");
        super.updateDrawState(textPaint);
        if (this.a) {
            return;
        }
        textPaint.setUnderlineText(false);
    }
}
