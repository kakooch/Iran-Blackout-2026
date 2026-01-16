package ir.nasim;

import android.content.Context;
import android.media.SoundPool;
import android.net.Uri;

/* renamed from: ir.nasim.Iy0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5344Iy0 {
    public static final a i = new a(null);
    public static final int j = 8;
    private final Context a;
    private final U53 b;
    private C9680aN4 c;
    private TN d;
    private final SoundPool e;
    private final int f;
    private final int g;
    private final int h;

    /* renamed from: ir.nasim.Iy0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C5344Iy0(Context context, U53 u53) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(u53, "incomingRinger");
        this.a = context;
        this.b = u53;
        this.c = new C9680aN4();
        TN tnB = TN.d.b(context);
        this.d = tnB;
        SoundPool soundPoolC = tnB.c();
        this.e = soundPoolC;
        this.f = soundPoolC.load(context, AbstractC19954rD5.call_enter, 1);
        this.g = soundPoolC.load(context, AbstractC19954rD5.call_exit, 1);
        this.h = soundPoolC.load(context, AbstractC19954rD5.starting_record, 1);
    }

    public final void a() {
        g();
        h();
        this.c = null;
    }

    public final void b() {
        float fN = this.d.n();
        this.e.play(this.f, fN, fN, 1, 0, 1.0f);
    }

    public final void c() {
        float fN = this.d.n();
        this.e.play(this.g, fN, fN, 1, 0, 1.0f);
    }

    public final void d() {
        String name;
        try {
            Uri uriA = C16302l26.a.a(this.a);
            if (uriA == null) {
                return;
            }
            this.d.m();
            this.b.a(uriA);
        } catch (Exception unused) {
            if (C5344Iy0.class.isAnonymousClass()) {
                name = C5344Iy0.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C5344Iy0.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.a(name, "failed to play incoming ringtone", new Object[0]);
        }
    }

    public final void e() {
        C9680aN4 c9680aN4 = this.c;
        if (c9680aN4 != null) {
            c9680aN4.f(this.a);
        }
    }

    public final void f() {
        this.e.play(this.h, 0.5f, 0.5f, 1, 1, 1.0f);
    }

    public final void g() {
        this.b.c();
    }

    public final void h() {
        C9680aN4 c9680aN4 = this.c;
        if (c9680aN4 != null) {
            c9680aN4.c();
        }
    }
}
