package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.j;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* renamed from: ir.nasim.qN7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC19455qN7 {

    /* renamed from: ir.nasim.qN7$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC18633oz3 c;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* renamed from: ir.nasim.qN7$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC14603iB2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14603iB2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                    this.b = 1;
                    if (interfaceC14603iB2.invoke(interfaceC20315ro1, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC18633oz3 interfaceC18633oz3, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC18633oz3;
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18633oz3 interfaceC18633oz3 = this.c;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(this.d, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(interfaceC18633oz3, bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final void a(Context context, String str, UA2 ua2) {
        AbstractC13042fc3.i(context, "<this>");
        AbstractC13042fc3.i(str, "path");
        AbstractC13042fc3.i(ua2, "newPath");
        String string = context.getString(SD5.story_size_dimension_width_height);
        AbstractC13042fc3.h(string, "getString(...)");
        List listN0 = AbstractC20762sZ6.N0(string, new String[]{":"}, false, 0, 6, null);
        ((com.bumptech.glide.g) com.bumptech.glide.b.t(context).y(str).u0(new C5677Kj0(Float.parseFloat((String) listN0.get(0)) / Float.parseFloat((String) listN0.get(1)), false))).M0(new a(context, str, ua2));
    }

    public static final String b() {
        return "❤";
    }

    public static final Object c(Bundle bundle, String str, Class cls) {
        AbstractC13042fc3.i(bundle, "<this>");
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(cls, "clazz");
        return Build.VERSION.SDK_INT >= 33 ? bundle.getParcelable(str, cls) : bundle.getParcelable(str);
    }

    public static final float d() {
        return C22078ud6.c() / C22078ud6.b();
    }

    public static final boolean e(String str) {
        AbstractC13042fc3.i(str, "unicode");
        return AbstractC13042fc3.d(str, b());
    }

    public static final InterfaceC13730gj3 f(InterfaceC18633oz3 interfaceC18633oz3, InterfaceC11938do1 interfaceC11938do1, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC18633oz3, "<this>");
        AbstractC13042fc3.i(interfaceC11938do1, "context");
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        return AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3), interfaceC11938do1, null, new b(interfaceC18633oz3, interfaceC14603iB2, null), 2, null);
    }

    public static /* synthetic */ InterfaceC13730gj3 g(InterfaceC18633oz3 interfaceC18633oz3, InterfaceC11938do1 interfaceC11938do1, InterfaceC14603iB2 interfaceC14603iB2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        return f(interfaceC18633oz3, interfaceC11938do1, interfaceC14603iB2);
    }

    /* renamed from: ir.nasim.qN7$a */
    public static final class a extends AbstractC4151Dx1 {
        final /* synthetic */ Context d;
        final /* synthetic */ String e;
        final /* synthetic */ UA2 f;

        a(Context context, String str, UA2 ua2) {
            this.d = context;
            this.e = str;
            this.f = ua2;
        }

        @Override // ir.nasim.InterfaceC21549tj7
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Drawable drawable, InterfaceC22855vv7 interfaceC22855vv7) throws IOException {
            AbstractC13042fc3.i(drawable, "resource");
            OutputStream outputStreamOpenOutputStream = this.d.getContentResolver().openOutputStream(Uri.fromFile(new File(this.e)));
            if (outputStreamOpenOutputStream != null) {
                B02.b(drawable, 0, 0, null, 7, null).compress(Bitmap.CompressFormat.JPEG, 100, outputStreamOpenOutputStream);
                outputStreamOpenOutputStream.close();
            }
            this.f.invoke(this.e);
        }

        @Override // ir.nasim.InterfaceC21549tj7
        public void g(Drawable drawable) {
        }
    }
}
