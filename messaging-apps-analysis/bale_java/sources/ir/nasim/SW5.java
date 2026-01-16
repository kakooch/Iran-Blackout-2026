package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import ir.nasim.InterfaceC22734vk2;
import kotlin.KotlinNothingValueException;
import okio.Okio;

/* loaded from: classes2.dex */
public final class SW5 implements InterfaceC22734vk2 {
    public static final a c = new a(null);
    private final Uri a;
    private final IL4 b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements InterfaceC22734vk2.a {
        private final boolean c(Uri uri) {
            return AbstractC13042fc3.d(uri.getScheme(), "android.resource");
        }

        @Override // ir.nasim.InterfaceC22734vk2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC22734vk2 a(Uri uri, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            if (c(uri)) {
                return new SW5(uri, il4);
            }
            return null;
        }
    }

    public SW5(Uri uri, IL4 il4) {
        this.a = uri;
        this.b = il4;
    }

    private final Void b(Uri uri) {
        throw new IllegalStateException("Invalid android.resource URI: " + uri);
    }

    @Override // ir.nasim.InterfaceC22734vk2
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) throws Resources.NotFoundException {
        Integer numO;
        String authority = this.a.getAuthority();
        if (authority != null) {
            if (!(!AbstractC20762sZ6.n0(authority))) {
                authority = null;
            }
            if (authority != null) {
                String str = (String) AbstractC15401jX0.F0(this.a.getPathSegments());
                if (str == null || (numO = AbstractC19562qZ6.o(str)) == null) {
                    b(this.a);
                    throw new KotlinNothingValueException();
                }
                int iIntValue = numO.intValue();
                Context contextG = this.b.g();
                Resources resources = AbstractC13042fc3.d(authority, contextG.getPackageName()) ? contextG.getResources() : contextG.getPackageManager().getResourcesForApplication(authority);
                TypedValue typedValue = new TypedValue();
                resources.getValue(iIntValue, typedValue, true);
                CharSequence charSequence = typedValue.string;
                String strK = AbstractC18638p.k(MimeTypeMap.getSingleton(), charSequence.subSequence(AbstractC20762sZ6.q0(charSequence, '/', 0, false, 6, null), charSequence.length()).toString());
                if (!AbstractC13042fc3.d(strK, "text/xml")) {
                    TypedValue typedValue2 = new TypedValue();
                    return new WH6(AbstractC11466d33.b(Okio.buffer(Okio.source(resources.openRawResource(iIntValue, typedValue2))), contextG, new QW5(authority, iIntValue, typedValue2.density)), strK, EnumC21699tz1.c);
                }
                Drawable drawableA = AbstractC13042fc3.d(authority, contextG.getPackageName()) ? AbstractC12665f.a(contextG, iIntValue) : AbstractC12665f.d(contextG, resources, iIntValue);
                boolean zU = AbstractC18638p.u(drawableA);
                if (zU) {
                    drawableA = new BitmapDrawable(contextG.getResources(), N02.a.a(drawableA, this.b.f(), this.b.o(), this.b.n(), this.b.c()));
                }
                return new E02(drawableA, zU, EnumC21699tz1.c);
            }
        }
        b(this.a);
        throw new KotlinNothingValueException();
    }
}
