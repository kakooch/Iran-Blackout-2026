package io.sentry.android.replay;

import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.sentry.C3155n3;
import io.sentry.InterfaceC3102d0;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import ir.nasim.AbstractC11308cn2;
import ir.nasim.AbstractC12542en2;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC14155hS;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC18050o01;
import ir.nasim.AbstractC19562qZ6;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC8839Xn7;
import ir.nasim.C12275eL0;
import ir.nasim.C12889fL5;
import ir.nasim.C16460lJ3;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23384wp6;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.XV4;
import ir.nasim.YV0;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class h implements Closeable {
    public static final a k = new a(null);
    public static final int l = 8;
    private final C3155n3 a;
    private final io.sentry.protocol.v b;
    private final AtomicBoolean c;
    private final C3202a d;
    private final C3202a e;
    private io.sentry.android.replay.video.c f;
    private final InterfaceC9173Yu3 g;
    private final List h;
    private final LinkedHashMap i;
    private final InterfaceC9173Yu3 j;

    public static final class a {

        /* renamed from: io.sentry.android.replay.h$a$a, reason: collision with other inner class name */
        public static final class C0241a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Long.valueOf(((i) obj).c()), Long.valueOf(((i) obj2).c()));
            }
        }

        public static final class b implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Long.valueOf(((io.sentry.rrweb.b) obj).e()), Long.valueOf(((io.sentry.rrweb.b) obj2).e()));
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean b(h hVar, File file, String str) {
            AbstractC13042fc3.i(hVar, "$cache");
            AbstractC13042fc3.h(str, "name");
            if (AbstractC20153rZ6.C(str, ".jpg", false, 2, null)) {
                File file2 = new File(file, str);
                Long lQ = AbstractC19562qZ6.q(AbstractC12542en2.r(file2));
                if (lQ != null) {
                    h.e(hVar, file2, lQ.longValue(), null, 4, null);
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:92:0x020f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final io.sentry.android.replay.c c(io.sentry.C3155n3 r26, io.sentry.protocol.v r27, ir.nasim.UA2 r28) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 591
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.h.a.c(io.sentry.n3, io.sentry.protocol.v, ir.nasim.UA2):io.sentry.android.replay.c");
        }

        public final File d(C3155n3 c3155n3, io.sentry.protocol.v vVar) {
            AbstractC13042fc3.i(c3155n3, "options");
            AbstractC13042fc3.i(vVar, "replayId");
            String cacheDirPath = c3155n3.getCacheDirPath();
            if (cacheDirPath == null || cacheDirPath.length() == 0) {
                c3155n3.getLogger().c(Y2.WARNING, "SentryOptions.cacheDirPath is not set, session replay is no-op", new Object[0]);
                return null;
            }
            String cacheDirPath2 = c3155n3.getCacheDirPath();
            AbstractC13042fc3.f(cacheDirPath2);
            File file = new File(cacheDirPath2, "replay_" + vVar);
            file.mkdirs();
            return file;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() throws IOException {
            if (h.this.q() == null) {
                return null;
            }
            File file = new File(h.this.q(), ".ongoing_segment");
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Map.Entry entry) {
            AbstractC13042fc3.i(entry, "<name for destructuring parameter 0>");
            return ((String) entry.getKey()) + '=' + ((String) entry.getValue());
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            return h.k.d(h.this.a, h.this.b);
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ long e;
        final /* synthetic */ h f;
        final /* synthetic */ C12889fL5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, h hVar, C12889fL5 c12889fL5) {
            super(1);
            this.e = j;
            this.f = hVar;
            this.g = c12889fL5;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(i iVar) {
            AbstractC13042fc3.i(iVar, "it");
            if (iVar.c() < this.e) {
                this.f.l(iVar.b());
                return Boolean.TRUE;
            }
            C12889fL5 c12889fL5 = this.g;
            if (c12889fL5.a == null) {
                c12889fL5.a = iVar.a();
            }
            return Boolean.FALSE;
        }
    }

    public h(C3155n3 c3155n3, io.sentry.protocol.v vVar) {
        AbstractC13042fc3.i(c3155n3, "options");
        AbstractC13042fc3.i(vVar, "replayId");
        this.a = c3155n3;
        this.b = vVar;
        this.c = new AtomicBoolean(false);
        this.d = new C3202a();
        this.e = new C3202a();
        this.g = AbstractC13269fw3.a(new d());
        this.h = new ArrayList();
        this.i = new LinkedHashMap();
        this.j = AbstractC13269fw3.a(new b());
    }

    public static /* synthetic */ void e(h hVar, File file, long j, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        hVar.d(file, j, str);
    }

    public static /* synthetic */ io.sentry.android.replay.b k(h hVar, long j, long j2, int i, int i2, int i3, int i4, int i5, File file, int i6, Object obj) {
        File file2;
        if ((i6 & 128) != 0) {
            file2 = new File(hVar.q(), i + ".mp4");
        } else {
            file2 = file;
        }
        return hVar.j(j, j2, i, i2, i3, i4, i5, file2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(File file) {
        try {
            if (file.delete()) {
                return;
            }
            this.a.getLogger().c(Y2.ERROR, "Failed to delete replay frame: %s", file.getAbsolutePath());
        } catch (Throwable th) {
            this.a.getLogger().a(Y2.ERROR, th, "Failed to delete replay frame: %s", file.getAbsolutePath());
        }
    }

    private final boolean m(i iVar) {
        if (iVar == null) {
            return false;
        }
        try {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(iVar.b().getAbsolutePath());
            InterfaceC3102d0 interfaceC3102d0A = this.d.a();
            try {
                io.sentry.android.replay.video.c cVar = this.f;
                if (cVar != null) {
                    AbstractC13042fc3.h(bitmapDecodeFile, "bitmap");
                    cVar.b(bitmapDecodeFile);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
                AbstractC14155hS.a(interfaceC3102d0A, null);
                bitmapDecodeFile.recycle();
                return true;
            } finally {
            }
        } catch (Throwable th) {
            this.a.getLogger().b(Y2.WARNING, "Unable to decode bitmap and encode it into a video, skipping frame", th);
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Exception {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            io.sentry.android.replay.video.c cVar = this.f;
            if (cVar != null) {
                cVar.i();
            }
            this.f = null;
            C19938rB7 c19938rB7 = C19938rB7.a;
            AbstractC14155hS.a(interfaceC3102d0A, null);
            this.c.set(true);
        } finally {
        }
    }

    public final void d(File file, long j, String str) {
        AbstractC13042fc3.i(file, "screenshot");
        this.h.add(new i(file, j, str));
    }

    public final void g(Bitmap bitmap, long j, String str) throws IOException {
        AbstractC13042fc3.i(bitmap, "bitmap");
        if (q() == null || bitmap.isRecycled()) {
            return;
        }
        File fileQ = q();
        if (fileQ != null) {
            fileQ.mkdirs();
        }
        File file = new File(q(), j + ".jpg");
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, this.a.getSessionReplay().h().screenshotQuality, fileOutputStream);
            fileOutputStream.flush();
            C19938rB7 c19938rB7 = C19938rB7.a;
            YV0.a(fileOutputStream, null);
            d(file, j, str);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                YV0.a(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public final io.sentry.android.replay.b j(long j, long j2, int i, int i2, int i3, int i4, int i5, File file) throws Exception {
        InterfaceC3102d0 interfaceC3102d0;
        int i6;
        AbstractC13042fc3.i(file, "videoFile");
        if (file.exists() && file.length() > 0) {
            file.delete();
        }
        if (this.h.isEmpty()) {
            this.a.getLogger().c(Y2.DEBUG, "No captured frames, skipping generating a video segment", new Object[0]);
            return null;
        }
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            interfaceC3102d0 = interfaceC3102d0A;
            try {
                io.sentry.android.replay.video.c cVar = new io.sentry.android.replay.video.c(this.a, new io.sentry.android.replay.video.a(file, i3, i2, i4, i5, null, 32, null), null, 4, null);
                cVar.j();
                AbstractC14155hS.a(interfaceC3102d0, null);
                this.f = cVar;
                long j3 = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT / i4;
                i iVar = (i) AbstractC15401jX0.q0(this.h);
                long j4 = j2 + j;
                C16460lJ3 c16460lJ3W = AbstractC23053wG5.w(AbstractC23053wG5.z(j2, j4), j3);
                long jO = c16460lJ3W.o();
                long jT = c16460lJ3W.t();
                long jV = c16460lJ3W.v();
                if ((jV <= 0 || jO > jT) && (jV >= 0 || jT > jO)) {
                    i6 = 0;
                } else {
                    int i7 = 0;
                    while (true) {
                        Iterator it = this.h.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            i iVar2 = (i) it.next();
                            long j5 = jO + j3;
                            long jC = iVar2.c();
                            if (jO <= jC && jC <= j5) {
                                iVar = iVar2;
                                break;
                            }
                            if (iVar2.c() > j5) {
                                break;
                            }
                        }
                        if (m(iVar)) {
                            i7++;
                        } else if (iVar != null) {
                            l(iVar.b());
                            this.h.remove(iVar);
                            iVar = null;
                        }
                        if (jO == jT) {
                            break;
                        }
                        jO += jV;
                    }
                    i6 = i7;
                }
                if (i6 == 0) {
                    this.a.getLogger().c(Y2.DEBUG, "Generated a video with no frames, not capturing a replay segment", new Object[0]);
                    l(file);
                    return null;
                }
                InterfaceC3102d0 interfaceC3102d0A2 = this.d.a();
                try {
                    io.sentry.android.replay.video.c cVar2 = this.f;
                    if (cVar2 != null) {
                        cVar2.i();
                    }
                    io.sentry.android.replay.video.c cVar3 = this.f;
                    long jC2 = cVar3 != null ? cVar3.c() : 0L;
                    this.f = null;
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    AbstractC14155hS.a(interfaceC3102d0A2, null);
                    u(j4);
                    return new io.sentry.android.replay.b(file, i6, jC2);
                } finally {
                }
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                try {
                    throw th2;
                } catch (Throwable th3) {
                    AbstractC14155hS.a(interfaceC3102d0, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            interfaceC3102d0 = interfaceC3102d0A;
        }
    }

    public final List n() {
        return this.h;
    }

    public final File p() {
        return (File) this.j.getValue();
    }

    public final File q() {
        return (File) this.g.getValue();
    }

    public final void s(String str, String str2) throws Exception {
        File fileP;
        File fileP2;
        AbstractC13042fc3.i(str, "key");
        InterfaceC3102d0 interfaceC3102d0A = this.e.a();
        try {
            if (this.c.get()) {
                AbstractC14155hS.a(interfaceC3102d0A, null);
                return;
            }
            File fileP3 = p();
            if ((fileP3 == null || !fileP3.exists()) && (fileP = p()) != null) {
                fileP.createNewFile();
            }
            if (this.i.isEmpty() && (fileP2 = p()) != null) {
                Reader inputStreamReader = new InputStreamReader(new FileInputStream(fileP2), C12275eL0.b);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    InterfaceC23384wp6 interfaceC23384wp6D = AbstractC8839Xn7.d(bufferedReader);
                    LinkedHashMap linkedHashMap = this.i;
                    Iterator it = interfaceC23384wp6D.iterator();
                    while (it.hasNext()) {
                        List listN0 = AbstractC20762sZ6.N0((String) it.next(), new String[]{Separators.EQUALS}, false, 2, 2, null);
                        XV4 xv4A = AbstractC4616Fw7.a((String) listN0.get(0), (String) listN0.get(1));
                        linkedHashMap.put(xv4A.e(), xv4A.f());
                    }
                    YV0.a(bufferedReader, null);
                } finally {
                }
            }
            if (str2 == null) {
                this.i.remove(str);
            } else {
                this.i.put(str, str2);
            }
            File fileP4 = p();
            if (fileP4 != null) {
                Set setEntrySet = this.i.entrySet();
                AbstractC13042fc3.h(setEntrySet, "ongoingSegment.entries");
                AbstractC11308cn2.j(fileP4, AbstractC15401jX0.A0(setEntrySet, Separators.RETURN, null, null, 0, null, c.e, 30, null), null, 2, null);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            AbstractC14155hS.a(interfaceC3102d0A, null);
        } finally {
        }
    }

    public final String u(long j) {
        C12889fL5 c12889fL5 = new C12889fL5();
        AbstractC13610gX0.K(this.h, new e(j, this, c12889fL5));
        return (String) c12889fL5.a;
    }
}
