package androidx.lifecycle;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC18042nz3;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class j {
    private AtomicReference a = new AtomicReference(null);

    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static final C0092a Companion = new C0092a(null);

        /* renamed from: androidx.lifecycle.j$a$a, reason: collision with other inner class name */
        public static final class C0092a {

            /* renamed from: androidx.lifecycle.j$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0093a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[b.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    a = iArr;
                }
            }

            private C0092a() {
            }

            public final a a(b bVar) {
                AbstractC13042fc3.i(bVar, "state");
                int i = C0093a.a[bVar.ordinal()];
                if (i == 1) {
                    return a.ON_DESTROY;
                }
                if (i == 2) {
                    return a.ON_STOP;
                }
                if (i != 3) {
                    return null;
                }
                return a.ON_PAUSE;
            }

            public final a b(b bVar) {
                AbstractC13042fc3.i(bVar, "state");
                int i = C0093a.a[bVar.ordinal()];
                if (i == 1) {
                    return a.ON_START;
                }
                if (i == 2) {
                    return a.ON_RESUME;
                }
                if (i != 5) {
                    return null;
                }
                return a.ON_CREATE;
            }

            public final a c(b bVar) {
                AbstractC13042fc3.i(bVar, "state");
                int i = C0093a.a[bVar.ordinal()];
                if (i == 1) {
                    return a.ON_CREATE;
                }
                if (i == 2) {
                    return a.ON_START;
                }
                if (i != 3) {
                    return null;
                }
                return a.ON_RESUME;
            }

            public /* synthetic */ C0092a(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[a.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[a.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[a.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[a.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                a = iArr;
            }
        }

        public final b j() {
            switch (b.a[ordinal()]) {
                case 1:
                case 2:
                    return b.CREATED;
                case 3:
                case 4:
                    return b.STARTED;
                case 5:
                    return b.RESUMED;
                case 6:
                    return b.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean j(b bVar) {
            AbstractC13042fc3.i(bVar, "state");
            return compareTo(bVar) >= 0;
        }
    }

    public abstract void a(InterfaceC18042nz3 interfaceC18042nz3);

    public abstract b b();

    public final AtomicReference c() {
        return this.a;
    }

    public abstract void d(InterfaceC18042nz3 interfaceC18042nz3);
}
