package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.kZ0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16010kZ0 extends DY2 {
    private final List c;
    private List d;
    private final C21231tK7 e;
    private String f;

    /* renamed from: ir.nasim.kZ0$a */
    public final class a extends DW7 {
        private C5103Hx2 b;

        public a() {
        }

        @Override // ir.nasim.DW7
        public void d(boolean z) {
            if (z) {
                C5103Hx2 c5103Hx2 = this.b;
                if (c5103Hx2 == null) {
                    AbstractC13042fc3.y("binding");
                    c5103Hx2 = null;
                }
                c5103Hx2.b.D();
            }
        }

        @Override // ir.nasim.DW7
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(C24488yi0 c24488yi0, int i, Context context) {
            AbstractC13042fc3.i(c24488yi0, "data");
            AbstractC13042fc3.i(context, "context");
            C21231tK7 c21231tK7 = C16010kZ0.this.e;
            C5103Hx2 c5103Hx2 = null;
            if (c21231tK7 != null) {
                C5103Hx2 c5103Hx22 = this.b;
                if (c5103Hx22 == null) {
                    AbstractC13042fc3.y("binding");
                    c5103Hx22 = null;
                }
                AvatarViewGlide.u(c5103Hx22.b, c21231tK7, null, 2, null);
            }
            C5103Hx2 c5103Hx23 = this.b;
            if (c5103Hx23 == null) {
                AbstractC13042fc3.y("binding");
                c5103Hx23 = null;
            }
            c5103Hx23.c.setText(Separators.SLASH + c24488yi0.c());
            C5103Hx2 c5103Hx24 = this.b;
            if (c5103Hx24 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c5103Hx2 = c5103Hx24;
            }
            c5103Hx2.d.setText(c24488yi0.a());
        }

        @Override // ir.nasim.DW7
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public View c(C24488yi0 c24488yi0, ViewGroup viewGroup, Context context) {
            AbstractC13042fc3.i(c24488yi0, "data");
            AbstractC13042fc3.i(context, "context");
            View viewInflate = ((Activity) context).getLayoutInflater().inflate(AbstractC12208eD5.fragment_chat_bot_slash_command_item, viewGroup, false);
            C5103Hx2 c5103Hx2A = C5103Hx2.a(viewInflate);
            this.b = c5103Hx2A;
            if (c5103Hx2A == null) {
                AbstractC13042fc3.y("binding");
                c5103Hx2A = null;
            }
            c5103Hx2A.b.B(16.0f, true);
            AbstractC13042fc3.f(viewInflate);
            return viewInflate;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C16010kZ0(int i, Context context) {
        C19482qQ7 c19482qQ7I;
        List list;
        super(context);
        AbstractC13042fc3.i(context, "context");
        long j = i;
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(j);
        this.c = (c21231tK7 == null || (c19482qQ7I = c21231tK7.i()) == null || (list = (FJ) c19482qQ7I.b()) == null) ? AbstractC10360bX0.m() : list;
        this.e = (C21231tK7) AbstractC5969Lp4.g().n(j);
        this.d = new ArrayList();
    }

    public final void f() {
        this.f = null;
        this.d = new ArrayList();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.DY2
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public DW7 a(C24488yi0 c24488yi0) {
        AbstractC13042fc3.i(c24488yi0, "obj");
        return new a();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // ir.nasim.DY2, android.widget.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C24488yi0 getItem(int i) {
        return (C24488yi0) this.d.get(i);
    }

    public final void i(String str) {
        if (str == null || AbstractC13042fc3.d(str, this.f)) {
            return;
        }
        this.f = str;
        ArrayList arrayList = new ArrayList();
        for (C24488yi0 c24488yi0 : this.c) {
            String strC = c24488yi0.c();
            Locale locale = Locale.getDefault();
            AbstractC13042fc3.h(locale, "getDefault(...)");
            String lowerCase = strC.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            if (AbstractC20153rZ6.S(lowerCase, str, false, 2, null)) {
                arrayList.add(c24488yi0);
            }
        }
        this.d.clear();
        this.d.addAll(arrayList);
        notifyDataSetChanged();
    }
}
