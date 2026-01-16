package ir.nasim;

import android.net.Uri;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class UD1 implements InterfaceC12462ef2 {
    private static final int[] o = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};
    private static final a p = new a(new a.InterfaceC0676a() { // from class: ir.nasim.SD1
        @Override // ir.nasim.UD1.a.InterfaceC0676a
        public final Constructor a() {
            return UD1.h();
        }
    });
    private static final a q = new a(new a.InterfaceC0676a() { // from class: ir.nasim.TD1
        @Override // ir.nasim.UD1.a.InterfaceC0676a
        public final Constructor a() {
            return UD1.i();
        }
    });
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int l;
    private int k = 1;
    private int n = 112800;
    private AbstractC12710f43 m = AbstractC12710f43.V();

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        private final InterfaceC0676a a;
        private final AtomicBoolean b = new AtomicBoolean(false);
        private Constructor c;

        /* renamed from: ir.nasim.UD1$a$a, reason: collision with other inner class name */
        public interface InterfaceC0676a {
            Constructor a();
        }

        public a(InterfaceC0676a interfaceC0676a) {
            this.a = interfaceC0676a;
        }

        private Constructor b() {
            synchronized (this.b) {
                if (this.b.get()) {
                    return this.c;
                }
                try {
                    return this.a.a();
                } catch (ClassNotFoundException unused) {
                    this.b.set(true);
                    return this.c;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
        }

        public InterfaceC9262Ze2 a(Object... objArr) {
            Constructor constructorB = b();
            if (constructorB == null) {
                return null;
            }
            try {
                return (InterfaceC9262Ze2) constructorB.newInstance(objArr);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating extractor", e);
            }
        }
    }

    private void g(int i, List list) {
        switch (i) {
            case 0:
                list.add(new C14506i2());
                break;
            case 1:
                list.add(new C16886m2());
                break;
            case 2:
                list.add(new C4419Fb((this.c ? 2 : 0) | this.d | (this.b ? 1 : 0)));
                break;
            case 3:
                list.add(new C24527ym((this.c ? 2 : 0) | this.e | (this.b ? 1 : 0)));
                break;
            case 4:
                InterfaceC9262Ze2 interfaceC9262Ze2A = p.a(Integer.valueOf(this.f));
                if (interfaceC9262Ze2A == null) {
                    list.add(new C23970xp2(this.f));
                    break;
                } else {
                    list.add(interfaceC9262Ze2A);
                    break;
                }
            case 5:
                list.add(new com.google.android.exoplayer2.extractor.flv.b());
                break;
            case 6:
                list.add(new IV3(this.g));
                break;
            case 7:
                list.add(new C24512yk4((this.c ? 2 : 0) | this.j | (this.b ? 1 : 0)));
                break;
            case 8:
                list.add(new C7267Qz2(this.i));
                list.add(new C3569Bk4(this.h));
                break;
            case 9:
                list.add(new C13470gH4());
                break;
            case 10:
                list.add(new C14473hy5());
                break;
            case 11:
                list.add(new C21678tw7(this.k, new C5045Hq7(0L), new C16431lG1(this.l, this.m), this.n));
                break;
            case 12:
                list.add(new C22346v48());
                break;
            case 14:
                list.add(new C9308Zj3());
                break;
            case 15:
                InterfaceC9262Ze2 interfaceC9262Ze2A2 = q.a(new Object[0]);
                if (interfaceC9262Ze2A2 != null) {
                    list.add(interfaceC9262Ze2A2);
                    break;
                }
                break;
            case 16:
                list.add(new C24362yV());
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor h() {
        if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(InterfaceC9262Ze2.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor i() {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(InterfaceC9262Ze2.class).getConstructor(null);
    }

    @Override // ir.nasim.InterfaceC12462ef2
    public synchronized InterfaceC9262Ze2[] b(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            int[] iArr = o;
            arrayList = new ArrayList(iArr.length);
            int iB = AbstractC5238Im2.b(map);
            if (iB != -1) {
                g(iB, arrayList);
            }
            int iC = AbstractC5238Im2.c(uri);
            if (iC != -1 && iC != iB) {
                g(iC, arrayList);
            }
            for (int i : iArr) {
                if (i != iB && i != iC) {
                    g(i, arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (InterfaceC9262Ze2[]) arrayList.toArray(new InterfaceC9262Ze2[arrayList.size()]);
    }

    @Override // ir.nasim.InterfaceC12462ef2
    public synchronized InterfaceC9262Ze2[] c() {
        return b(Uri.EMPTY, new HashMap());
    }

    public synchronized UD1 j(boolean z) {
        this.b = z;
        return this;
    }
}
