package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC20129rX0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestDeleteCallLogs extends GeneratedMessageLite implements U64 {
    public static final int ALL_FIELD_NUMBER = 2;
    public static final int CALL_IDS_FIELD_NUMBER = 1;
    private static final MeetOuterClass$RequestDeleteCallLogs DEFAULT_INSTANCE;
    public static final int INVERT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private boolean all_;
    private B.j callIds_ = GeneratedMessageLite.emptyProtobufList();
    private boolean invert_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((MeetOuterClass$RequestDeleteCallLogs) this.b).addAllCallIds(iterable);
            return this;
        }

        public a B(boolean z) {
            q();
            ((MeetOuterClass$RequestDeleteCallLogs) this.b).setAll(z);
            return this;
        }

        public a C(boolean z) {
            q();
            ((MeetOuterClass$RequestDeleteCallLogs) this.b).setInvert(z);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestDeleteCallLogs.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestDeleteCallLogs meetOuterClass$RequestDeleteCallLogs = new MeetOuterClass$RequestDeleteCallLogs();
        DEFAULT_INSTANCE = meetOuterClass$RequestDeleteCallLogs;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestDeleteCallLogs.class, meetOuterClass$RequestDeleteCallLogs);
    }

    private MeetOuterClass$RequestDeleteCallLogs() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCallIds(Iterable<? extends CollectionsStruct$Int64Value> iterable) {
        ensureCallIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.callIds_);
    }

    private void addCallIds(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        ensureCallIdsIsMutable();
        this.callIds_.add(collectionsStruct$Int64Value);
    }

    private void clearAll() {
        this.all_ = false;
    }

    private void clearCallIds() {
        this.callIds_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearInvert() {
        this.invert_ = false;
    }

    private void ensureCallIdsIsMutable() {
        B.j jVar = this.callIds_;
        if (jVar.u()) {
            return;
        }
        this.callIds_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MeetOuterClass$RequestDeleteCallLogs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCallIds(int i) {
        ensureCallIdsIsMutable();
        this.callIds_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAll(boolean z) {
        this.all_ = z;
    }

    private void setCallIds(int i, CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        ensureCallIdsIsMutable();
        this.callIds_.set(i, collectionsStruct$Int64Value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInvert(boolean z) {
        this.invert_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestDeleteCallLogs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002\u0007\u0003\u0007", new Object[]{"callIds_", CollectionsStruct$Int64Value.class, "all_", "invert_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestDeleteCallLogs.class) {
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

    public boolean getAll() {
        return this.all_;
    }

    public CollectionsStruct$Int64Value getCallIds(int i) {
        return (CollectionsStruct$Int64Value) this.callIds_.get(i);
    }

    public int getCallIdsCount() {
        return this.callIds_.size();
    }

    public List<CollectionsStruct$Int64Value> getCallIdsList() {
        return this.callIds_;
    }

    public InterfaceC20129rX0 getCallIdsOrBuilder(int i) {
        return (InterfaceC20129rX0) this.callIds_.get(i);
    }

    public List<? extends InterfaceC20129rX0> getCallIdsOrBuilderList() {
        return this.callIds_;
    }

    public boolean getInvert() {
        return this.invert_;
    }

    public static a newBuilder(MeetOuterClass$RequestDeleteCallLogs meetOuterClass$RequestDeleteCallLogs) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestDeleteCallLogs);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCallIds(int i, CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        ensureCallIdsIsMutable();
        this.callIds_.add(i, collectionsStruct$Int64Value);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestDeleteCallLogs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestDeleteCallLogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
