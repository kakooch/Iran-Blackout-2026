package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Bcms$RequestGetNSFWGroups extends GeneratedMessageLite implements U64 {
    private static final Bcms$RequestGetNSFWGroups DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int idMemoizedSerializedSize = -1;
    private B.i id_ = GeneratedMessageLite.emptyLongList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Bcms$RequestGetNSFWGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        Bcms$RequestGetNSFWGroups bcms$RequestGetNSFWGroups = new Bcms$RequestGetNSFWGroups();
        DEFAULT_INSTANCE = bcms$RequestGetNSFWGroups;
        GeneratedMessageLite.registerDefaultInstance(Bcms$RequestGetNSFWGroups.class, bcms$RequestGetNSFWGroups);
    }

    private Bcms$RequestGetNSFWGroups() {
    }

    private void addAllId(Iterable<? extends Long> iterable) {
        ensureIdIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.id_);
    }

    private void addId(long j) {
        ensureIdIsMutable();
        this.id_.l1(j);
    }

    private void clearId() {
        this.id_ = GeneratedMessageLite.emptyLongList();
    }

    private void ensureIdIsMutable() {
        B.i iVar = this.id_;
        if (iVar.u()) {
            return;
        }
        this.id_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static Bcms$RequestGetNSFWGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Bcms$RequestGetNSFWGroups parseDelimitedFrom(InputStream inputStream) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Bcms$RequestGetNSFWGroups parseFrom(ByteBuffer byteBuffer) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setId(int i, long j) {
        ensureIdIsMutable();
        this.id_.z1(i, j);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1882p.a[gVar.ordinal()]) {
            case 1:
                return new Bcms$RequestGetNSFWGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001%", new Object[]{"id_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Bcms$RequestGetNSFWGroups.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public long getId(int i) {
        return this.id_.getLong(i);
    }

    public int getIdCount() {
        return this.id_.size();
    }

    public List<Long> getIdList() {
        return this.id_;
    }

    public static a newBuilder(Bcms$RequestGetNSFWGroups bcms$RequestGetNSFWGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(bcms$RequestGetNSFWGroups);
    }

    public static Bcms$RequestGetNSFWGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Bcms$RequestGetNSFWGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Bcms$RequestGetNSFWGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Bcms$RequestGetNSFWGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Bcms$RequestGetNSFWGroups parseFrom(byte[] bArr) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Bcms$RequestGetNSFWGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Bcms$RequestGetNSFWGroups parseFrom(InputStream inputStream) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Bcms$RequestGetNSFWGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Bcms$RequestGetNSFWGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Bcms$RequestGetNSFWGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Bcms$RequestGetNSFWGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
