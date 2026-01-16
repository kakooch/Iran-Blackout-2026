package io.sentry;

import android.gov.nist.core.Separators;
import io.sentry.C3;
import io.sentry.C3034a2;
import io.sentry.C3100c3;
import io.sentry.C3106e;
import io.sentry.C3139k2;
import io.sentry.C3158o1;
import io.sentry.C3160o3;
import io.sentry.C3163p1;
import io.sentry.C3186s1;
import io.sentry.C3191t1;
import io.sentry.C3222x1;
import io.sentry.H3;
import io.sentry.K2;
import io.sentry.L2;
import io.sentry.M3;
import io.sentry.O3;
import io.sentry.X2;
import io.sentry.Y2;
import io.sentry.Z2;
import io.sentry.a4;
import io.sentry.clientreport.c;
import io.sentry.profilemeasurements.a;
import io.sentry.profilemeasurements.b;
import io.sentry.protocol.A;
import io.sentry.protocol.B;
import io.sentry.protocol.C;
import io.sentry.protocol.C3166a;
import io.sentry.protocol.C3167b;
import io.sentry.protocol.C3168c;
import io.sentry.protocol.C3169d;
import io.sentry.protocol.C3170e;
import io.sentry.protocol.C3171f;
import io.sentry.protocol.C3172g;
import io.sentry.protocol.C3173h;
import io.sentry.protocol.C3174i;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.G;
import io.sentry.protocol.H;
import io.sentry.protocol.I;
import io.sentry.protocol.j;
import io.sentry.protocol.k;
import io.sentry.protocol.l;
import io.sentry.protocol.m;
import io.sentry.protocol.o;
import io.sentry.protocol.p;
import io.sentry.protocol.q;
import io.sentry.protocol.w;
import io.sentry.protocol.x;
import io.sentry.protocol.y;
import io.sentry.protocol.z;
import io.sentry.rrweb.a;
import io.sentry.rrweb.c;
import io.sentry.rrweb.e;
import io.sentry.rrweb.f;
import io.sentry.rrweb.g;
import io.sentry.rrweb.i;
import io.sentry.rrweb.j;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class B0 implements InterfaceC3107e0 {
    private static final Charset c = Charset.forName("UTF-8");
    private final C3155n3 a;
    private final Map b;

    public B0(C3155n3 c3155n3) {
        this.a = c3155n3;
        HashMap map = new HashMap();
        this.b = map;
        map.put(C3166a.class, new C3166a.C0249a());
        map.put(C3106e.class, new C3106e.a());
        map.put(C3167b.class, new C3167b.a());
        map.put(C3168c.class, new C3168c.a());
        map.put(DebugImage.class, new DebugImage.a());
        map.put(C3169d.class, new C3169d.a());
        map.put(C3170e.class, new C3170e.a());
        map.put(C3170e.b.class, new C3170e.b.a());
        map.put(C3171f.class, new C3171f.a());
        map.put(C3173h.class, new C3173h.a());
        map.put(C3174i.class, new C3174i.a());
        map.put(io.sentry.protocol.j.class, new j.a());
        map.put(io.sentry.protocol.k.class, new k.a());
        map.put(io.sentry.protocol.l.class, new l.a());
        map.put(C3158o1.class, new C3158o1.b());
        map.put(C3163p1.class, new C3163p1.a());
        map.put(C3186s1.class, new C3186s1.b());
        map.put(C3191t1.class, new C3191t1.a());
        map.put(io.sentry.profilemeasurements.a.class, new a.C0248a());
        map.put(io.sentry.profilemeasurements.b.class, new b.a());
        map.put(io.sentry.protocol.m.class, new m.a());
        map.put(C3222x1.class, new C3222x1.b());
        map.put(io.sentry.rrweb.a.class, new a.C0250a());
        map.put(io.sentry.rrweb.c.class, new c.a());
        map.put(io.sentry.rrweb.e.class, new e.a());
        map.put(io.sentry.rrweb.f.class, new f.a());
        map.put(io.sentry.rrweb.g.class, new g.a());
        map.put(io.sentry.rrweb.i.class, new i.a());
        map.put(io.sentry.rrweb.j.class, new j.a());
        map.put(io.sentry.protocol.o.class, new o.a());
        map.put(io.sentry.protocol.p.class, new p.a());
        map.put(C3139k2.class, new C3139k2.a());
        map.put(K2.class, new K2.a());
        map.put(L2.class, new L2.a());
        map.put(io.sentry.protocol.q.class, new q.a());
        map.put(X2.class, new X2.a());
        map.put(Y2.class, new Y2.a());
        map.put(Z2.class, new Z2.a());
        map.put(C3100c3.class, new C3100c3.a());
        map.put(io.sentry.protocol.w.class, new w.a());
        map.put(io.sentry.protocol.x.class, new x.a());
        map.put(C3160o3.class, new C3160o3.a());
        map.put(io.sentry.protocol.y.class, new y.a());
        map.put(io.sentry.protocol.z.class, new z.a());
        map.put(io.sentry.protocol.A.class, new A.a());
        map.put(C3034a2.class, new C3034a2.a());
        map.put(io.sentry.protocol.B.class, new B.a());
        map.put(io.sentry.protocol.C.class, new C.a());
        map.put(C3.class, new C3.a());
        map.put(H3.class, new H3.a());
        map.put(M3.class, new M3.a());
        map.put(O3.class, new O3.a());
        map.put(io.sentry.protocol.G.class, new G.a());
        map.put(C3172g.class, new C3172g.a());
        map.put(a4.class, new a4.a());
        map.put(io.sentry.clientreport.c.class, new c.a());
        map.put(io.sentry.protocol.I.class, new I.a());
        map.put(io.sentry.protocol.H.class, new H.a());
    }

    private boolean g(Class cls) {
        return cls.isArray() || Collection.class.isAssignableFrom(cls) || String.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls);
    }

    private String h(Object obj, boolean z) {
        StringWriter stringWriter = new StringWriter();
        C3226y0 c3226y0 = new C3226y0(stringWriter, this.a.getMaxDepth());
        if (z) {
            c3226y0.j(Separators.HT);
        }
        c3226y0.l(this.a.getLogger(), obj);
        return stringWriter.toString();
    }

    @Override // io.sentry.InterfaceC3107e0
    public void a(Object obj, Writer writer) throws IOException {
        io.sentry.util.u.c(obj, "The entity is required.");
        io.sentry.util.u.c(writer, "The Writer object is required.");
        ILogger logger = this.a.getLogger();
        Y2 y2 = Y2.DEBUG;
        if (logger.d(y2)) {
            this.a.getLogger().c(y2, "Serializing object: %s", h(obj, this.a.isEnablePrettySerializationOutput()));
        }
        new C3226y0(writer, this.a.getMaxDepth()).l(this.a.getLogger(), obj);
        writer.flush();
    }

    @Override // io.sentry.InterfaceC3107e0
    public void b(C3134j2 c3134j2, OutputStream outputStream) throws IOException {
        io.sentry.util.u.c(c3134j2, "The SentryEnvelope object is required.");
        io.sentry.util.u.c(outputStream, "The Stream object is required.");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), c));
        try {
            c3134j2.b().serialize(new C3226y0(bufferedWriter, this.a.getMaxDepth()), this.a.getLogger());
            bufferedWriter.write(Separators.RETURN);
            for (J2 j2 : c3134j2.c()) {
                try {
                    byte[] bArrI = j2.I();
                    j2.J().serialize(new C3226y0(bufferedWriter, this.a.getMaxDepth()), this.a.getLogger());
                    bufferedWriter.write(Separators.RETURN);
                    bufferedWriter.flush();
                    outputStream.write(bArrI);
                    bufferedWriter.write(Separators.RETURN);
                } catch (Exception e) {
                    this.a.getLogger().b(Y2.ERROR, "Failed to create envelope item. Dropping it.", e);
                }
            }
        } finally {
            bufferedWriter.flush();
        }
    }

    @Override // io.sentry.InterfaceC3107e0
    public Object c(Reader reader, Class cls) {
        try {
            C3216w0 c3216w0 = new C3216w0(reader);
            try {
                InterfaceC3176q0 interfaceC3176q0 = (InterfaceC3176q0) this.b.get(cls);
                if (interfaceC3176q0 != null) {
                    Object objCast = cls.cast(interfaceC3176q0.a(c3216w0, this.a.getLogger()));
                    c3216w0.close();
                    return objCast;
                }
                if (!g(cls)) {
                    c3216w0.close();
                    return null;
                }
                Object objH1 = c3216w0.H1();
                c3216w0.close();
                return objH1;
            } finally {
            }
        } catch (Exception e) {
            this.a.getLogger().b(Y2.ERROR, "Error when deserializing", e);
            return null;
        }
    }

    @Override // io.sentry.InterfaceC3107e0
    public C3134j2 d(InputStream inputStream) {
        io.sentry.util.u.c(inputStream, "The InputStream object is required.");
        try {
            return this.a.getEnvelopeReader().a(inputStream);
        } catch (IOException e) {
            this.a.getLogger().b(Y2.ERROR, "Error deserializing envelope.", e);
            return null;
        }
    }

    @Override // io.sentry.InterfaceC3107e0
    public Object e(Reader reader, Class cls, InterfaceC3176q0 interfaceC3176q0) {
        try {
            C3216w0 c3216w0 = new C3216w0(reader);
            try {
                if (!Collection.class.isAssignableFrom(cls)) {
                    Object objH1 = c3216w0.H1();
                    c3216w0.close();
                    return objH1;
                }
                if (interfaceC3176q0 == null) {
                    Object objH12 = c3216w0.H1();
                    c3216w0.close();
                    return objH12;
                }
                List listQ1 = c3216w0.Q1(this.a.getLogger(), interfaceC3176q0);
                c3216w0.close();
                return listQ1;
            } finally {
            }
        } catch (Throwable th) {
            this.a.getLogger().b(Y2.ERROR, "Error when deserializing", th);
            return null;
        }
    }

    @Override // io.sentry.InterfaceC3107e0
    public String f(Map map) {
        return h(map, false);
    }
}
