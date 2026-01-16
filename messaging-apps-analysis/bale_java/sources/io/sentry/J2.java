package io.sentry;

import io.sentry.exception.SentryEnvelopeException;
import io.sentry.util.AbstractC3209h;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class J2 {
    private static final Charset d = Charset.forName("UTF-8");
    private final K2 a;
    private final Callable b;
    private byte[] c;

    /* JADX INFO: Access modifiers changed from: private */
    static class a {
        private byte[] a;
        private final Callable b;

        public a(Callable callable) {
            this.b = callable;
        }

        private static byte[] b(byte[] bArr) {
            return bArr != null ? bArr : new byte[0];
        }

        public byte[] a() {
            Callable callable;
            if (this.a == null && (callable = this.b) != null) {
                this.a = (byte[]) callable.call();
            }
            return b(this.a);
        }
    }

    J2(K2 k2, byte[] bArr) {
        this.a = (K2) io.sentry.util.u.c(k2, "SentryEnvelopeItemHeader is required.");
        this.c = bArr;
        this.b = null;
    }

    public static J2 A(final InterfaceC3107e0 interfaceC3107e0, final io.sentry.clientreport.c cVar) {
        io.sentry.util.u.c(interfaceC3107e0, "ISerializer is required.");
        io.sentry.util.u.c(cVar, "ClientReport is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.r2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.O(interfaceC3107e0, cVar);
            }
        });
        return new J2(new K2(X2.resolve(cVar), new Callable() { // from class: io.sentry.s2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.P(aVar);
            }
        }, "application/json", null), new Callable() { // from class: io.sentry.t2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static J2 B(final InterfaceC3107e0 interfaceC3107e0, final AbstractC3099c2 abstractC3099c2) {
        io.sentry.util.u.c(interfaceC3107e0, "ISerializer is required.");
        io.sentry.util.u.c(abstractC3099c2, "SentryEvent is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.I2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.R(interfaceC3107e0, abstractC3099c2);
            }
        });
        return new J2(new K2(X2.resolve(abstractC3099c2), new Callable() { // from class: io.sentry.m2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.S(aVar);
            }
        }, "application/json", null), new Callable() { // from class: io.sentry.n2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static J2 C(final InterfaceC3107e0 interfaceC3107e0, final C3100c3 c3100c3) {
        io.sentry.util.u.c(interfaceC3107e0, "ISerializer is required.");
        io.sentry.util.u.c(c3100c3, "SentryLogEvents is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.u2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.U(interfaceC3107e0, c3100c3);
            }
        });
        return new J2(new K2(X2.Log, new Callable() { // from class: io.sentry.v2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.V(aVar);
            }
        }, "application/vnd.sentry.items.log+json", (String) null, (String) null, (String) null, Integer.valueOf(c3100c3.a().size())), new Callable() { // from class: io.sentry.x2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static J2 D(final C3158o1 c3158o1, final InterfaceC3107e0 interfaceC3107e0) {
        final File fileO = c3158o1.o();
        final a aVar = new a(new Callable() { // from class: io.sentry.o2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.X(fileO, c3158o1, interfaceC3107e0);
            }
        });
        return new J2(new K2(X2.ProfileChunk, new Callable() { // from class: io.sentry.p2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.Y(aVar);
            }
        }, "application-json", fileO.getName(), (String) null, c3158o1.n(), (Integer) null), new Callable() { // from class: io.sentry.q2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static J2 E(final C3186s1 c3186s1, final long j, final InterfaceC3107e0 interfaceC3107e0) {
        final File fileC = c3186s1.C();
        final a aVar = new a(new Callable() { // from class: io.sentry.C2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.a0(fileC, j, c3186s1, interfaceC3107e0);
            }
        });
        return new J2(new K2(X2.Profile, new Callable() { // from class: io.sentry.D2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.b0(aVar);
            }
        }, "application-json", fileC.getName()), new Callable() { // from class: io.sentry.E2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static J2 F(final InterfaceC3107e0 interfaceC3107e0, final ILogger iLogger, final C3160o3 c3160o3, final C3222x1 c3222x1, final boolean z) {
        final File fileI0 = c3160o3.i0();
        final a aVar = new a(new Callable() { // from class: io.sentry.y2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.d0(interfaceC3107e0, c3160o3, c3222x1, fileI0, iLogger, z);
            }
        });
        return new J2(new K2(X2.ReplayVideo, new Callable() { // from class: io.sentry.z2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.e0(aVar);
            }
        }, null, null), new Callable() { // from class: io.sentry.A2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static J2 G(final InterfaceC3107e0 interfaceC3107e0, final C3 c3) {
        io.sentry.util.u.c(interfaceC3107e0, "ISerializer is required.");
        io.sentry.util.u.c(c3, "Session is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.F2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.g0(interfaceC3107e0, c3);
            }
        });
        return new J2(new K2(X2.Session, new Callable() { // from class: io.sentry.G2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.h0(aVar);
            }
        }, "application/json", null), new Callable() { // from class: io.sentry.H2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] L(C3091b c3091b, long j, InterfaceC3107e0 interfaceC3107e0, ILogger iLogger) throws SentryEnvelopeException {
        byte[] bArr;
        if (c3091b.f() != null) {
            byte[] bArrF = c3091b.f();
            y(bArrF.length, j, c3091b.h());
            return bArrF;
        }
        if (c3091b.j() != null) {
            byte[] bArrB = io.sentry.util.p.b(interfaceC3107e0, iLogger, c3091b.j());
            if (bArrB != null) {
                y(bArrB.length, j, c3091b.h());
                return bArrB;
            }
        } else {
            if (c3091b.i() != null) {
                return AbstractC3209h.b(c3091b.i(), j);
            }
            if (c3091b.e() != null && (bArr = (byte[]) c3091b.e().call()) != null) {
                y(bArr.length, j, c3091b.h());
                return bArr;
            }
        }
        throw new SentryEnvelopeException(String.format("Couldn't attach the attachment %s.\nPlease check that either bytes, serializable, path or provider is set.", c3091b.h()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer M(a aVar) {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] O(InterfaceC3107e0 interfaceC3107e0, io.sentry.clientreport.c cVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d));
            try {
                interfaceC3107e0.a(cVar, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer P(a aVar) {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] R(InterfaceC3107e0 interfaceC3107e0, AbstractC3099c2 abstractC3099c2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d));
            try {
                interfaceC3107e0.a(abstractC3099c2, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer S(a aVar) {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] U(InterfaceC3107e0 interfaceC3107e0, C3100c3 c3100c3) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d));
            try {
                interfaceC3107e0.a(c3100c3, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer V(a aVar) {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] X(File file, C3158o1 c3158o1, InterfaceC3107e0 interfaceC3107e0) throws SentryEnvelopeException {
        if (!file.exists()) {
            throw new SentryEnvelopeException(String.format("Dropping profile chunk, because the file '%s' doesn't exists", file.getName()));
        }
        String strC = io.sentry.vendor.a.c(AbstractC3209h.b(file.getPath(), 52428800L), 3);
        if (strC.isEmpty()) {
            throw new SentryEnvelopeException("Profiling trace file is empty");
        }
        c3158o1.q(strC);
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d));
                    try {
                        interfaceC3107e0.a(c3158o1, bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        return byteArray;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                file.delete();
            }
        } catch (IOException e) {
            throw new SentryEnvelopeException(String.format("Failed to serialize profile chunk\n%s", e.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer Y(a aVar) {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] a0(File file, long j, C3186s1 c3186s1, InterfaceC3107e0 interfaceC3107e0) throws SentryEnvelopeException {
        if (!file.exists()) {
            throw new SentryEnvelopeException(String.format("Dropping profiling trace data, because the file '%s' doesn't exists", file.getName()));
        }
        String strC = io.sentry.vendor.a.c(AbstractC3209h.b(file.getPath(), j), 3);
        if (strC.isEmpty()) {
            throw new SentryEnvelopeException("Profiling trace file is empty");
        }
        c3186s1.G(strC);
        c3186s1.F();
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d));
                    try {
                        interfaceC3107e0.a(c3186s1, bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        return byteArray;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                file.delete();
            }
        } catch (IOException e) {
            throw new SentryEnvelopeException(String.format("Failed to serialize profiling trace data\n%s", e.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer b0(a aVar) {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] d0(InterfaceC3107e0 interfaceC3107e0, C3160o3 c3160o3, C3222x1 c3222x1, File file, ILogger iLogger, boolean z) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d));
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    interfaceC3107e0.a(c3160o3, bufferedWriter);
                    linkedHashMap.put(X2.ReplayEvent.getItemType(), byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.reset();
                    if (c3222x1 != null) {
                        interfaceC3107e0.a(c3222x1, bufferedWriter);
                        linkedHashMap.put(X2.ReplayRecording.getItemType(), byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.reset();
                    }
                    if (file != null && file.exists()) {
                        byte[] bArrB = AbstractC3209h.b(file.getPath(), 10485760L);
                        if (bArrB.length > 0) {
                            linkedHashMap.put(X2.ReplayVideo.getItemType(), bArrB);
                        }
                    }
                    byte[] bArrJ0 = j0(linkedHashMap);
                    bufferedWriter.close();
                    byteArrayOutputStream.close();
                    return bArrJ0;
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                iLogger.b(Y2.ERROR, "Could not serialize replay recording", th);
                if (file == null) {
                    return null;
                }
                if (z) {
                    AbstractC3209h.a(file.getParentFile());
                    return null;
                }
                file.delete();
                return null;
            } finally {
                if (file != null) {
                    if (z) {
                        AbstractC3209h.a(file.getParentFile());
                    } else {
                        file.delete();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer e0(a aVar) {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] g0(InterfaceC3107e0 interfaceC3107e0, C3 c3) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, d));
            try {
                interfaceC3107e0.a(c3, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer h0(a aVar) {
        return Integer.valueOf(aVar.a().length);
    }

    private static byte[] j0(Map map) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write((byte) (map.size() | 128));
            for (Map.Entry entry : map.entrySet()) {
                byte[] bytes = ((String) entry.getKey()).getBytes(d);
                int length = bytes.length;
                byteArrayOutputStream.write(-39);
                byteArrayOutputStream.write((byte) length);
                byteArrayOutputStream.write(bytes);
                byte[] bArr = (byte[]) entry.getValue();
                int length2 = bArr.length;
                byteArrayOutputStream.write(-58);
                byteArrayOutputStream.write(ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(length2).array());
                byteArrayOutputStream.write(bArr);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void y(long j, long j2, String str) throws SentryEnvelopeException {
        if (j > j2) {
            throw new SentryEnvelopeException(String.format("Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes.", str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static J2 z(final InterfaceC3107e0 interfaceC3107e0, final ILogger iLogger, final C3091b c3091b, final long j) {
        final a aVar = new a(new Callable() { // from class: io.sentry.l2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.L(c3091b, j, interfaceC3107e0, iLogger);
            }
        });
        return new J2(new K2(X2.Attachment, new Callable() { // from class: io.sentry.w2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return J2.M(aVar);
            }
        }, c3091b.g(), c3091b.h(), c3091b.d()), new Callable() { // from class: io.sentry.B2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public io.sentry.clientreport.c H(InterfaceC3107e0 interfaceC3107e0) throws IOException {
        K2 k2 = this.a;
        if (k2 == null || k2.b() != X2.ClientReport) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(I()), d));
        try {
            io.sentry.clientreport.c cVar = (io.sentry.clientreport.c) interfaceC3107e0.c(bufferedReader, io.sentry.clientreport.c.class);
            bufferedReader.close();
            return cVar;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public byte[] I() {
        Callable callable;
        if (this.c == null && (callable = this.b) != null) {
            this.c = (byte[]) callable.call();
        }
        return this.c;
    }

    public K2 J() {
        return this.a;
    }

    public io.sentry.protocol.C K(InterfaceC3107e0 interfaceC3107e0) throws IOException {
        K2 k2 = this.a;
        if (k2 == null || k2.b() != X2.Transaction) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(I()), d));
        try {
            io.sentry.protocol.C c = (io.sentry.protocol.C) interfaceC3107e0.c(bufferedReader, io.sentry.protocol.C.class);
            bufferedReader.close();
            return c;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    J2(K2 k2, Callable callable) {
        this.a = (K2) io.sentry.util.u.c(k2, "SentryEnvelopeItemHeader is required.");
        this.b = (Callable) io.sentry.util.u.c(callable, "DataFactory is required.");
        this.c = null;
    }
}
