package io.sentry.android.replay.viewhierarchy;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import io.sentry.C3155n3;
import io.sentry.android.replay.util.o;
import io.sentry.android.replay.util.p;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.UA2;
import ir.nasim.XV4;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class b {
    public static final a m = new a(null);
    public static final int n = 8;
    private final float a;
    private final float b;
    private final int c;
    private final int d;
    private final float e;
    private final int f;
    private final b g;
    private final boolean h;
    private boolean i;
    private final boolean j;
    private final Rect k;
    private List l;

    public static final class a {
        private a() {
        }

        private final boolean b(Class cls, Set set) {
            while (cls != null) {
                if (set.contains(cls.getName())) {
                    return true;
                }
                cls = cls.getSuperclass();
            }
            return false;
        }

        private final boolean c(View view, C3155n3 c3155n3) {
            String strF = c3155n3.getSessionReplay().f();
            if (strF == null) {
                return false;
            }
            return AbstractC13042fc3.d(view.getClass().getName(), strF);
        }

        private final boolean d(ViewParent viewParent, C3155n3 c3155n3) {
            String strN = c3155n3.getSessionReplay().n();
            if (strN == null) {
                return false;
            }
            return AbstractC13042fc3.d(viewParent.getClass().getName(), strN);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final boolean e(android.view.View r8, io.sentry.C3155n3 r9) {
            /*
                r7 = this;
                java.lang.Object r0 = r8.getTag()
                boolean r1 = r0 instanceof java.lang.String
                r2 = 0
                if (r1 == 0) goto Lc
                java.lang.String r0 = (java.lang.String) r0
                goto Ld
            Lc:
                r0 = r2
            Ld:
                r1 = 2
                java.lang.String r3 = "toLowerCase(...)"
                r4 = 1
                r5 = 0
                if (r0 == 0) goto L28
                java.util.Locale r6 = java.util.Locale.ROOT
                java.lang.String r0 = r0.toLowerCase(r6)
                ir.nasim.AbstractC13042fc3.h(r0, r3)
                if (r0 == 0) goto L28
                java.lang.String r6 = "sentry-unmask"
                boolean r0 = ir.nasim.AbstractC14836iZ6.X(r0, r6, r5, r1, r2)
                if (r0 != r4) goto L28
                goto L36
            L28:
                int r0 = io.sentry.android.replay.e.sentry_privacy
                java.lang.Object r0 = r8.getTag(r0)
                java.lang.String r6 = "unmask"
                boolean r0 = ir.nasim.AbstractC13042fc3.d(r0, r6)
                if (r0 == 0) goto L37
            L36:
                return r5
            L37:
                java.lang.Object r0 = r8.getTag()
                boolean r6 = r0 instanceof java.lang.String
                if (r6 == 0) goto L42
                java.lang.String r0 = (java.lang.String) r0
                goto L43
            L42:
                r0 = r2
            L43:
                if (r0 == 0) goto L59
                java.util.Locale r6 = java.util.Locale.ROOT
                java.lang.String r0 = r0.toLowerCase(r6)
                ir.nasim.AbstractC13042fc3.h(r0, r3)
                if (r0 == 0) goto L59
                java.lang.String r3 = "sentry-mask"
                boolean r0 = ir.nasim.AbstractC14836iZ6.X(r0, r3, r5, r1, r2)
                if (r0 != r4) goto L59
                goto L67
            L59:
                int r0 = io.sentry.android.replay.e.sentry_privacy
                java.lang.Object r0 = r8.getTag(r0)
                java.lang.String r1 = "mask"
                boolean r0 = ir.nasim.AbstractC13042fc3.d(r0, r1)
                if (r0 == 0) goto L68
            L67:
                return r4
            L68:
                boolean r0 = r7.c(r8, r9)
                if (r0 != 0) goto L84
                android.view.ViewParent r0 = r8.getParent()
                if (r0 == 0) goto L84
                android.view.ViewParent r0 = r8.getParent()
                java.lang.String r1 = "this.parent"
                ir.nasim.AbstractC13042fc3.h(r0, r1)
                boolean r0 = r7.d(r0, r9)
                if (r0 == 0) goto L84
                return r5
            L84:
                java.lang.Class r0 = r8.getClass()
                io.sentry.p3 r1 = r9.getSessionReplay()
                java.util.Set r1 = r1.m()
                java.lang.String r2 = "options.sessionReplay.unmaskViewClasses"
                ir.nasim.AbstractC13042fc3.h(r1, r2)
                boolean r0 = r7.b(r0, r1)
                if (r0 == 0) goto L9c
                return r5
            L9c:
                java.lang.Class r8 = r8.getClass()
                io.sentry.p3 r9 = r9.getSessionReplay()
                java.util.Set r9 = r9.e()
                java.lang.String r0 = "options.sessionReplay.maskViewClasses"
                ir.nasim.AbstractC13042fc3.h(r9, r0)
                boolean r8 = r7.b(r8, r9)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.viewhierarchy.b.a.e(android.view.View, io.sentry.n3):boolean");
        }

        public final b a(View view, b bVar, int i, C3155n3 c3155n3) {
            Drawable drawable;
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(c3155n3, "options");
            XV4 xv4G = p.g(view);
            boolean zBooleanValue = ((Boolean) xv4G.a()).booleanValue();
            Rect rect = (Rect) xv4G.b();
            boolean z = zBooleanValue && e(view, c3155n3);
            if (view instanceof TextView) {
                if (bVar != null) {
                    bVar.g(true);
                }
                TextView textView = (TextView) view;
                Layout layout = textView.getLayout();
                return new d(layout != null ? new io.sentry.android.replay.util.a(layout) : null, Integer.valueOf(p.j(textView.getCurrentTextColor())), textView.getTotalPaddingLeft(), p.c(textView), textView.getX(), textView.getY(), textView.getWidth(), textView.getHeight(), (bVar != null ? bVar.a() : 0.0f) + textView.getElevation(), i, bVar, z, true, zBooleanValue, rect);
            }
            if (!(view instanceof ImageView)) {
                return new C0244b(view.getX(), view.getY(), view.getWidth(), view.getHeight(), (bVar != null ? bVar.a() : 0.0f) + view.getElevation(), i, bVar, z, false, zBooleanValue, rect);
            }
            if (bVar != null) {
                bVar.g(true);
            }
            ImageView imageView = (ImageView) view;
            return new c(imageView.getX(), imageView.getY(), imageView.getWidth(), imageView.getHeight(), imageView.getElevation() + (bVar != null ? bVar.a() : 0.0f), i, bVar, z && (drawable = imageView.getDrawable()) != null && p.f(drawable), true, zBooleanValue, rect);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: io.sentry.android.replay.viewhierarchy.b$b, reason: collision with other inner class name */
    public static final class C0244b extends b {
        public C0244b(float f, float f2, int i, int i2, float f3, int i3, b bVar, boolean z, boolean z2, boolean z3, Rect rect) {
            super(f, f2, i, i2, f3, i3, bVar, z, z2, z3, rect, null);
        }
    }

    public static final class c extends b {
        public c(float f, float f2, int i, int i2, float f3, int i3, b bVar, boolean z, boolean z2, boolean z3, Rect rect) {
            super(f, f2, i, i2, f3, i3, bVar, z, z2, z3, rect, null);
        }
    }

    public static final class d extends b {
        private final o o;
        private final Integer p;
        private final int q;
        private final int r;

        public /* synthetic */ d(o oVar, Integer num, int i, int i2, float f, float f2, int i3, int i4, float f3, int i5, b bVar, boolean z, boolean z2, boolean z3, Rect rect, int i6, ED1 ed1) {
            this((i6 & 1) != 0 ? null : oVar, (i6 & 2) != 0 ? null : num, (i6 & 4) != 0 ? 0 : i, (i6 & 8) != 0 ? 0 : i2, f, f2, i3, i4, f3, i5, (i6 & 1024) != 0 ? null : bVar, (i6 & 2048) != 0 ? false : z, (i6 & 4096) != 0 ? false : z2, (i6 & 8192) != 0 ? false : z3, (i6 & 16384) != 0 ? null : rect);
        }

        public final Integer i() {
            return this.p;
        }

        public final o j() {
            return this.o;
        }

        public final int k() {
            return this.q;
        }

        public final int l() {
            return this.r;
        }

        public d(o oVar, Integer num, int i, int i2, float f, float f2, int i3, int i4, float f3, int i5, b bVar, boolean z, boolean z2, boolean z3, Rect rect) {
            super(f, f2, i3, i4, f3, i5, bVar, z, z2, z3, rect, null);
            this.o = oVar;
            this.p = num;
            this.q = i;
            this.r = i2;
        }
    }

    public /* synthetic */ b(float f, float f2, int i, int i2, float f3, int i3, b bVar, boolean z, boolean z2, boolean z3, Rect rect, ED1 ed1) {
        this(f, f2, i, i2, f3, i3, bVar, z, z2, z3, rect);
    }

    public final float a() {
        return this.e;
    }

    public final int b() {
        return this.d;
    }

    public final boolean c() {
        return this.h;
    }

    public final Rect d() {
        return this.k;
    }

    public final int e() {
        return this.c;
    }

    public final void f(List list) {
        this.l = list;
    }

    public final void g(boolean z) {
        for (b bVar = this.g; bVar != null; bVar = bVar.g) {
            bVar.i = z;
        }
    }

    public final void h(UA2 ua2) {
        List list;
        AbstractC13042fc3.i(ua2, "callback");
        if (!((Boolean) ua2.invoke(this)).booleanValue() || (list = this.l) == null) {
            return;
        }
        AbstractC13042fc3.f(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((b) it.next()).h(ua2);
        }
    }

    private b(float f, float f2, int i, int i2, float f3, int i3, b bVar, boolean z, boolean z2, boolean z3, Rect rect) {
        this.a = f;
        this.b = f2;
        this.c = i;
        this.d = i2;
        this.e = f3;
        this.f = i3;
        this.g = bVar;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.k = rect;
    }
}
