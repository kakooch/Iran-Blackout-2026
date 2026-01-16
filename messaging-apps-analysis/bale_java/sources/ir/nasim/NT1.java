package ir.nasim;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import ir.nasim.InterfaceC13701gg4;
import ir.nasim.InterfaceC8666Wy1;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class NT1 implements InterfaceC13701gg4 {
    private final Context a;
    private final e b;

    private static final class a implements InterfaceC14292hg4, e {
        private final Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // ir.nasim.NT1.e
        public Class a() {
            return AssetFileDescriptor.class;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new NT1(this.a, this);
        }

        @Override // ir.nasim.NT1.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(AssetFileDescriptor assetFileDescriptor) throws IOException {
            assetFileDescriptor.close();
        }

        @Override // ir.nasim.NT1.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public AssetFileDescriptor c(Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResourceFd(i);
        }
    }

    private static final class c implements InterfaceC14292hg4, e {
        private final Context a;

        c(Context context) {
            this.a = context;
        }

        @Override // ir.nasim.NT1.e
        public Class a() {
            return InputStream.class;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new NT1(this.a, this);
        }

        @Override // ir.nasim.NT1.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(InputStream inputStream) throws IOException {
            inputStream.close();
        }

        @Override // ir.nasim.NT1.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public InputStream c(Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResource(i);
        }
    }

    private interface e {
        Class a();

        void b(Object obj);

        Object c(Resources.Theme theme, Resources resources, int i);
    }

    NT1(Context context, e eVar) {
        this.a = context.getApplicationContext();
        this.b = eVar;
    }

    public static InterfaceC14292hg4 c(Context context) {
        return new a(context);
    }

    public static InterfaceC14292hg4 e(Context context) {
        return new b(context);
    }

    public static InterfaceC14292hg4 g(Context context) {
        return new c(context);
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC13701gg4.a b(Integer num, int i, int i2, HL4 hl4) {
        Resources.Theme theme = (Resources.Theme) hl4.c(JW5.b);
        return new InterfaceC13701gg4.a(new C22456vG4(num), new d(theme, theme != null ? theme.getResources() : this.a.getResources(), this.b, num.intValue()));
    }

    @Override // ir.nasim.InterfaceC13701gg4
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }

    private static final class d implements InterfaceC8666Wy1 {
        private final Resources.Theme a;
        private final Resources b;
        private final e c;
        private final int d;
        private Object e;

        d(Resources.Theme theme, Resources resources, e eVar, int i) {
            this.a = theme;
            this.b = resources;
            this.c = eVar;
            this.d = i;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public Class a() {
            return this.c.a();
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void b() {
            Object obj = this.e;
            if (obj != null) {
                try {
                    this.c.b(obj);
                } catch (IOException unused) {
                }
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public EnumC21012sz1 d() {
            return EnumC21012sz1.LOCAL;
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void e(EnumC6212Mq5 enumC6212Mq5, InterfaceC8666Wy1.a aVar) {
            try {
                Object objC = this.c.c(this.a, this.b, this.d);
                this.e = objC;
                aVar.f(objC);
            } catch (Resources.NotFoundException e) {
                aVar.c(e);
            }
        }

        @Override // ir.nasim.InterfaceC8666Wy1
        public void cancel() {
        }
    }

    private static final class b implements InterfaceC14292hg4, e {
        private final Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // ir.nasim.NT1.e
        public Class a() {
            return Drawable.class;
        }

        @Override // ir.nasim.InterfaceC14292hg4
        public InterfaceC13701gg4 d(C23932xl4 c23932xl4) {
            return new NT1(this.a, this);
        }

        @Override // ir.nasim.NT1.e
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Drawable c(Resources.Theme theme, Resources resources, int i) {
            return AbstractC23486x02.a(this.a, i, theme);
        }

        @Override // ir.nasim.NT1.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(Drawable drawable) {
        }
    }
}
