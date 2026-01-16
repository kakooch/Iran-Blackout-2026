package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* renamed from: ir.nasim.v03, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22301v03 {
    private final Drawable a;
    private Integer b;
    private final EnumC22897w03 c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final CharSequence h;

    /* renamed from: ir.nasim.v03$a */
    public static final class a {
        private final Context a;
        private Drawable b;
        private Integer c;
        private EnumC22897w03 d;
        private int e;
        private int f;
        private int g;
        private int h;
        private CharSequence i;

        public a(Context context) {
            AbstractC13042fc3.i(context, "context");
            this.a = context;
            this.d = EnumC22897w03.a;
            float f = 28;
            this.e = AbstractC20723sV3.d(TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()));
            this.f = AbstractC20723sV3.d(TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()));
            this.g = AbstractC20723sV3.d(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
            this.h = -1;
            DY6 dy6 = DY6.a;
            this.i = "";
        }

        public final C22301v03 a() {
            return new C22301v03(this, null);
        }

        public final Drawable b() {
            return this.b;
        }

        public final Integer c() {
            return this.c;
        }

        public final int d() {
            return this.h;
        }

        public final CharSequence e() {
            return this.i;
        }

        public final EnumC22897w03 f() {
            return this.d;
        }

        public final int g() {
            return this.f;
        }

        public final int h() {
            return this.g;
        }

        public final int i() {
            return this.e;
        }

        public final a j(Drawable drawable) {
            this.b = drawable;
            return this;
        }

        public final a k(EnumC22897w03 enumC22897w03) {
            AbstractC13042fc3.i(enumC22897w03, "value");
            this.d = enumC22897w03;
            return this;
        }

        public final a l(int i) {
            this.h = i;
            return this;
        }

        public final a m(int i) {
            this.f = i;
            return this;
        }

        public final a n(int i) {
            this.g = i;
            return this;
        }

        public final a o(int i) {
            this.e = i;
            return this;
        }
    }

    public /* synthetic */ C22301v03(a aVar, ED1 ed1) {
        this(aVar);
    }

    public final Drawable a() {
        return this.a;
    }

    public final Integer b() {
        return this.b;
    }

    public final int c() {
        return this.g;
    }

    public final CharSequence d() {
        return this.h;
    }

    public final EnumC22897w03 e() {
        return this.c;
    }

    public final int f() {
        return this.e;
    }

    public final int g() {
        return this.f;
    }

    public final int h() {
        return this.d;
    }

    private C22301v03(a aVar) {
        this.a = aVar.b();
        this.b = aVar.c();
        this.c = aVar.f();
        this.d = aVar.i();
        this.e = aVar.g();
        this.f = aVar.h();
        this.g = aVar.d();
        this.h = aVar.e();
    }
}
