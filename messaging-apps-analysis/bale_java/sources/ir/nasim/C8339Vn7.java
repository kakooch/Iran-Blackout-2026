package ir.nasim;

import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import livekit.LivekitModels$DataStream;

/* renamed from: ir.nasim.Vn7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C8339Vn7 extends VX6 {
    private final String f;
    private final String g;
    private final long h;
    private final Long i;
    private final Map j;
    private final a k;
    private final int l;
    private final String m;
    private final List n;
    private final boolean o;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Vn7$a */
    public static final class a {
        public static final C0717a Companion;
        public static final a a = new a("CREATE", 0);
        public static final a b = new a("UPDATE", 1);
        public static final a c = new a("DELETE", 2);
        public static final a d = new a("REACTION", 3);
        private static final /* synthetic */ a[] e;
        private static final /* synthetic */ F92 f;

        /* renamed from: ir.nasim.Vn7$a$a, reason: collision with other inner class name */
        public static final class C0717a {

            /* renamed from: ir.nasim.Vn7$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0718a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[LivekitModels$DataStream.b.values().length];
                    try {
                        iArr[LivekitModels$DataStream.b.CREATE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LivekitModels$DataStream.b.UPDATE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[LivekitModels$DataStream.b.DELETE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[LivekitModels$DataStream.b.REACTION.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[LivekitModels$DataStream.b.UNRECOGNIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    a = iArr;
                }
            }

            private C0717a() {
            }

            public final a a(LivekitModels$DataStream.b bVar) {
                AbstractC13042fc3.i(bVar, "operationType");
                int i = C0718a.a[bVar.ordinal()];
                if (i == 1) {
                    return a.a;
                }
                if (i == 2) {
                    return a.b;
                }
                if (i == 3) {
                    return a.c;
                }
                if (i == 4) {
                    return a.d;
                }
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalArgumentException("Unrecognized operation type!");
            }

            public /* synthetic */ C0717a(ED1 ed1) {
                this();
            }
        }

        static {
            a[] aVarArrA = a();
            e = aVarArrA;
            f = G92.a(aVarArrA);
            Companion = new C0717a(null);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c, d};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8339Vn7(String str, String str2, long j, Long l, Map map, a aVar, int i, String str3, List list, boolean z) {
        super(str, str2, j, l, map, null);
        AbstractC13042fc3.i(str, "id");
        AbstractC13042fc3.i(str2, "topic");
        AbstractC13042fc3.i(map, "attributes");
        AbstractC13042fc3.i(aVar, "operationType");
        AbstractC13042fc3.i(list, "attachedStreamIds");
        this.f = str;
        this.g = str2;
        this.h = j;
        this.i = l;
        this.j = map;
        this.k = aVar;
        this.l = i;
        this.m = str3;
        this.n = list;
        this.o = z;
    }

    @Override // ir.nasim.VX6
    public String a() {
        return this.f;
    }

    @Override // ir.nasim.VX6
    public String b() {
        return this.g;
    }

    @Override // ir.nasim.VX6
    public Long c() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8339Vn7)) {
            return false;
        }
        C8339Vn7 c8339Vn7 = (C8339Vn7) obj;
        return AbstractC13042fc3.d(this.f, c8339Vn7.f) && AbstractC13042fc3.d(this.g, c8339Vn7.g) && this.h == c8339Vn7.h && AbstractC13042fc3.d(this.i, c8339Vn7.i) && AbstractC13042fc3.d(this.j, c8339Vn7.j) && this.k == c8339Vn7.k && this.l == c8339Vn7.l && AbstractC13042fc3.d(this.m, c8339Vn7.m) && AbstractC13042fc3.d(this.n, c8339Vn7.n) && this.o == c8339Vn7.o;
    }

    public int hashCode() {
        int iHashCode = ((((this.f.hashCode() * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h)) * 31;
        Long l = this.i;
        int iHashCode2 = (((((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + Integer.hashCode(this.l)) * 31;
        String str = this.m;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.n.hashCode()) * 31) + Boolean.hashCode(this.o);
    }

    public String toString() {
        return "TextStreamInfo(id=" + this.f + ", topic=" + this.g + ", timestampMs=" + this.h + ", totalSize=" + this.i + ", attributes=" + this.j + ", operationType=" + this.k + ", version=" + this.l + ", replyToStreamId=" + this.m + ", attachedStreamIds=" + this.n + ", generated=" + this.o + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C8339Vn7(LivekitModels$DataStream.Header header, LivekitModels$DataStream.TextHeader textHeader) {
        AbstractC13042fc3.i(header, "header");
        AbstractC13042fc3.i(textHeader, "textHeader");
        String streamId = header.getStreamId();
        AbstractC13042fc3.h(streamId, "getStreamId(...)");
        String topic = header.getTopic();
        AbstractC13042fc3.h(topic, "getTopic(...)");
        long timestamp = header.getTimestamp();
        Long lValueOf = header.hasTotalLength() ? Long.valueOf(header.getTotalLength()) : null;
        Map<String, String> attributesMap = header.getAttributesMap();
        AbstractC13042fc3.h(attributesMap, "getAttributesMap(...)");
        Map mapY = AbstractC20051rO3.y(attributesMap);
        a.C0717a c0717a = a.Companion;
        LivekitModels$DataStream.b operationType = textHeader.getOperationType();
        AbstractC13042fc3.h(operationType, "getOperationType(...)");
        a aVarA = c0717a.a(operationType);
        int version = textHeader.getVersion();
        String replyToStreamId = textHeader.getReplyToStreamId();
        String replyToStreamId2 = (replyToStreamId == null || replyToStreamId.length() == 0) ? null : textHeader.getReplyToStreamId();
        List<String> attachedStreamIdsList = textHeader.getAttachedStreamIdsList();
        this(streamId, topic, timestamp, lValueOf, mapY, aVarA, version, replyToStreamId2, attachedStreamIdsList == null ? AbstractC10360bX0.m() : attachedStreamIdsList, textHeader.getGenerated());
    }
}
