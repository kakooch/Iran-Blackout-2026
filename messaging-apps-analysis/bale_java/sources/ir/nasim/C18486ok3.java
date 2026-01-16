package ir.nasim;

import com.google.firebase.encoders.EncodingException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: ir.nasim.ok3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18486ok3 implements InterfaceC9541a82 {
    private static final InterfaceC19389qG4 e = new InterfaceC19389qG4() { // from class: ir.nasim.lk3
        @Override // ir.nasim.InterfaceC19389qG4
        public final void a(Object obj, Object obj2) {
            C18486ok3.l(obj, (InterfaceC19980rG4) obj2);
        }
    };
    private static final InterfaceC17118mQ7 f = new InterfaceC17118mQ7() { // from class: ir.nasim.mk3
        @Override // ir.nasim.InterfaceC17118mQ7
        public final void a(Object obj, Object obj2) {
            ((InterfaceC17709nQ7) obj2).d((String) obj);
        }
    };
    private static final InterfaceC17118mQ7 g = new InterfaceC17118mQ7() { // from class: ir.nasim.nk3
        @Override // ir.nasim.InterfaceC17118mQ7
        public final void a(Object obj, Object obj2) {
            C18486ok3.n((Boolean) obj, (InterfaceC17709nQ7) obj2);
        }
    };
    private static final b h = new b(null);
    private final Map a = new HashMap();
    private final Map b = new HashMap();
    private InterfaceC19389qG4 c = e;
    private boolean d = false;

    /* renamed from: ir.nasim.ok3$a */
    class a implements InterfaceC8198Uy1 {
        a() {
        }

        @Override // ir.nasim.InterfaceC8198Uy1
        public void a(Object obj, Writer writer) {
            C21565tl3 c21565tl3 = new C21565tl3(writer, C18486ok3.this.a, C18486ok3.this.b, C18486ok3.this.c, C18486ok3.this.d);
            c21565tl3.h(obj, false);
            c21565tl3.p();
        }
    }

    /* renamed from: ir.nasim.ok3$b */
    private static final class b implements InterfaceC17118mQ7 {
        private static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private b() {
        }

        @Override // ir.nasim.InterfaceC17118mQ7
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, InterfaceC17709nQ7 interfaceC17709nQ7) {
            interfaceC17709nQ7.d(a.format(date));
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public C18486ok3() {
        p(String.class, f);
        p(Boolean.class, g);
        p(Date.class, h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(Object obj, InterfaceC19980rG4 interfaceC19980rG4) {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Boolean bool, InterfaceC17709nQ7 interfaceC17709nQ7) {
        interfaceC17709nQ7.e(bool.booleanValue());
    }

    public InterfaceC8198Uy1 i() {
        return new a();
    }

    public C18486ok3 j(InterfaceC10444bd1 interfaceC10444bd1) {
        interfaceC10444bd1.a(this);
        return this;
    }

    public C18486ok3 k(boolean z) {
        this.d = z;
        return this;
    }

    @Override // ir.nasim.InterfaceC9541a82
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C18486ok3 a(Class cls, InterfaceC19389qG4 interfaceC19389qG4) {
        this.a.put(cls, interfaceC19389qG4);
        this.b.remove(cls);
        return this;
    }

    public C18486ok3 p(Class cls, InterfaceC17118mQ7 interfaceC17118mQ7) {
        this.b.put(cls, interfaceC17118mQ7);
        this.a.remove(cls);
        return this;
    }
}
