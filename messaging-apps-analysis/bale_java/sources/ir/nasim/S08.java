package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;

/* loaded from: classes4.dex */
public abstract class S08 {

    public static final class a extends S08 {
        private final C11458d25 a;
        private final ExPeerType b;
        private final AbstractC0605a c;

        /* renamed from: ir.nasim.S08$a$a, reason: collision with other inner class name */
        public static abstract class AbstractC0605a {
            private final String a;

            /* renamed from: ir.nasim.S08$a$a$a, reason: collision with other inner class name */
            public static final class C0606a extends AbstractC0605a {
                private final Integer b;

                public C0606a(Integer num) {
                    super("cancel", null);
                    this.b = num;
                }

                @Override // ir.nasim.S08.a.AbstractC0605a
                public Integer a() {
                    return this.b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof C0606a) && AbstractC13042fc3.d(this.b, ((C0606a) obj).b);
                }

                public int hashCode() {
                    Integer num = this.b;
                    if (num == null) {
                        return 0;
                    }
                    return num.hashCode();
                }

                public String toString() {
                    return "Cancel(duration=" + this.b + Separators.RPAREN;
                }
            }

            /* renamed from: ir.nasim.S08$a$a$b */
            public static final class b extends AbstractC0605a {
                private final Integer b;

                public b(Integer num) {
                    super("send", null);
                    this.b = num;
                }

                @Override // ir.nasim.S08.a.AbstractC0605a
                public Integer a() {
                    return this.b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof b) && AbstractC13042fc3.d(this.b, ((b) obj).b);
                }

                public int hashCode() {
                    Integer num = this.b;
                    if (num == null) {
                        return 0;
                    }
                    return num.hashCode();
                }

                public String toString() {
                    return "Send(duration=" + this.b + Separators.RPAREN;
                }
            }

            /* renamed from: ir.nasim.S08$a$a$c */
            public static final class c extends AbstractC0605a {
                private static final Void c = null;
                public static final c b = new c();
                public static final int d = 8;

                private c() {
                    super("start", null);
                }

                @Override // ir.nasim.S08.a.AbstractC0605a
                public /* bridge */ /* synthetic */ Integer a() {
                    return (Integer) c();
                }

                public Void c() {
                    return c;
                }

                public boolean equals(Object obj) {
                    return this == obj || (obj instanceof c);
                }

                public int hashCode() {
                    return -157441402;
                }

                public String toString() {
                    return "Start";
                }
            }

            public /* synthetic */ AbstractC0605a(String str, ED1 ed1) {
                this(str);
            }

            public abstract Integer a();

            public final String b() {
                return this.a;
            }

            private AbstractC0605a(String str) {
                this.a = str;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C11458d25 c11458d25, ExPeerType exPeerType, AbstractC0605a abstractC0605a) {
            super(null);
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            AbstractC13042fc3.i(abstractC0605a, "eventType");
            this.a = c11458d25;
            this.b = exPeerType;
            this.c = abstractC0605a;
        }

        @Override // ir.nasim.S08
        public HashMap a() {
            HashMap mapA = super.a();
            mapA.put("event_type", this.c.b());
            Integer numA = this.c.a();
            if (numA != null) {
                mapA.put("duration_seconds", Integer.valueOf(numA.intValue()));
            }
            return mapA;
        }

        @Override // ir.nasim.S08
        public String b() {
            return "voice_record";
        }

        @Override // ir.nasim.S08
        protected ExPeerType c() {
            return this.b;
        }

        @Override // ir.nasim.S08
        protected C11458d25 d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b && AbstractC13042fc3.d(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "RecordAction(peer=" + this.a + ", exPeerType=" + this.b + ", eventType=" + this.c + Separators.RPAREN;
        }
    }

    public static final class b extends S08 {
        private final C11458d25 a;
        private final ExPeerType b;
        private final a c;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        public static final class a {
            public static final a b = new a("LOCK", 0, "lock");
            public static final a c = new a("PAUSE", 1, "pause");
            public static final a d = new a("RESUME", 2, "resume");
            private static final /* synthetic */ a[] e;
            private static final /* synthetic */ F92 f;
            private final String a;

            static {
                a[] aVarArrA = a();
                e = aVarArrA;
                f = G92.a(aVarArrA);
            }

            private a(String str, int i, String str2) {
                this.a = str2;
            }

            private static final /* synthetic */ a[] a() {
                return new a[]{b, c, d};
            }

            public static a valueOf(String str) {
                return (a) Enum.valueOf(a.class, str);
            }

            public static a[] values() {
                return (a[]) e.clone();
            }

            public final String j() {
                return this.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11458d25 c11458d25, ExPeerType exPeerType, a aVar) {
            super(null);
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            AbstractC13042fc3.i(aVar, "eventType");
            this.a = c11458d25;
            this.b = exPeerType;
            this.c = aVar;
        }

        @Override // ir.nasim.S08
        public HashMap a() {
            HashMap mapA = super.a();
            mapA.put("event_type", this.c.j());
            return mapA;
        }

        @Override // ir.nasim.S08
        public String b() {
            return "voice_action";
        }

        @Override // ir.nasim.S08
        protected ExPeerType c() {
            return this.b;
        }

        @Override // ir.nasim.S08
        protected C11458d25 d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "UserAction(peer=" + this.a + ", exPeerType=" + this.b + ", eventType=" + this.c + Separators.RPAREN;
        }
    }

    private S08() {
    }

    public HashMap a() {
        return AbstractC20051rO3.m(AbstractC4616Fw7.a("peer_id", Integer.valueOf(d().getPeerId())), AbstractC4616Fw7.a("peer_type", AbstractC7042Qa2.a(c())));
    }

    public abstract String b();

    protected abstract ExPeerType c();

    protected abstract C11458d25 d();

    public /* synthetic */ S08(ED1 ed1) {
        this();
    }
}
