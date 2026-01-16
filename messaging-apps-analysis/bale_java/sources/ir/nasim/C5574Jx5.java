package ir.nasim;

import com.google.firebase.encoders.EncodingException;
import ir.nasim.C5574Jx5;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Jx5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C5574Jx5 {
    private final Map a;
    private final Map b;
    private final InterfaceC19389qG4 c;

    /* renamed from: ir.nasim.Jx5$a */
    public static final class a implements InterfaceC9541a82 {
        private static final InterfaceC19389qG4 d = new InterfaceC19389qG4() { // from class: ir.nasim.Ix5
            @Override // ir.nasim.InterfaceC19389qG4
            public final void a(Object obj, Object obj2) {
                C5574Jx5.a.e(obj, (InterfaceC19980rG4) obj2);
            }
        };
        private final Map a = new HashMap();
        private final Map b = new HashMap();
        private InterfaceC19389qG4 c = d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Object obj, InterfaceC19980rG4 interfaceC19980rG4) {
            throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public C5574Jx5 c() {
            return new C5574Jx5(new HashMap(this.a), new HashMap(this.b), this.c);
        }

        public a d(InterfaceC10444bd1 interfaceC10444bd1) {
            interfaceC10444bd1.a(this);
            return this;
        }

        @Override // ir.nasim.InterfaceC9541a82
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a a(Class cls, InterfaceC19389qG4 interfaceC19389qG4) {
            this.a.put(cls, interfaceC19389qG4);
            this.b.remove(cls);
            return this;
        }
    }

    C5574Jx5(Map map, Map map2, InterfaceC19389qG4 interfaceC19389qG4) {
        this.a = map;
        this.b = map2;
        this.c = interfaceC19389qG4;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new C5106Hx5(outputStream, this.a, this.b, this.c).q(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
