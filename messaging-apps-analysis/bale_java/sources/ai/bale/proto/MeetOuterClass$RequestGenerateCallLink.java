package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetOuterClass$RequestGenerateCallLink extends GeneratedMessageLite implements U64 {
    public static final int CALL_ID_FIELD_NUMBER = 2;
    private static final MeetOuterClass$RequestGenerateCallLink DEFAULT_INSTANCE;
    public static final int IS_PUBLIC_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 3;
    private int bitField0_;
    private CollectionsStruct$Int64Value callId_;
    private boolean isPublic_;
    private CollectionsStruct$StringValue title_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((MeetOuterClass$RequestGenerateCallLink) this.b).setCallId(collectionsStruct$Int64Value);
            return this;
        }

        public a B(boolean z) {
            q();
            ((MeetOuterClass$RequestGenerateCallLink) this.b).setIsPublic(z);
            return this;
        }

        private a() {
            super(MeetOuterClass$RequestGenerateCallLink.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetOuterClass$RequestGenerateCallLink meetOuterClass$RequestGenerateCallLink = new MeetOuterClass$RequestGenerateCallLink();
        DEFAULT_INSTANCE = meetOuterClass$RequestGenerateCallLink;
        GeneratedMessageLite.registerDefaultInstance(MeetOuterClass$RequestGenerateCallLink.class, meetOuterClass$RequestGenerateCallLink);
    }

    private MeetOuterClass$RequestGenerateCallLink() {
    }

    private void clearCallId() {
        this.callId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearIsPublic() {
        this.isPublic_ = false;
    }

    private void clearTitle() {
        this.title_ = null;
        this.bitField0_ &= -3;
    }

    public static MeetOuterClass$RequestGenerateCallLink getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCallId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.callId_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.callId_ = collectionsStruct$Int64Value;
        } else {
            this.callId_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.callId_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTitle(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.title_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.title_ = collectionsStruct$StringValue;
        } else {
            this.title_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.title_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetOuterClass$RequestGenerateCallLink parseDelimitedFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseFrom(ByteBuffer byteBuffer) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallId(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.callId_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsPublic(boolean z) {
        this.isPublic_ = z;
    }

    private void setTitle(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.title_ = collectionsStruct$StringValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F0.a[gVar.ordinal()]) {
            case 1:
                return new MeetOuterClass$RequestGenerateCallLink();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "isPublic_", "callId_", "title_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetOuterClass$RequestGenerateCallLink.class) {
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

    public CollectionsStruct$Int64Value getCallId() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.callId_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean getIsPublic() {
        return this.isPublic_;
    }

    public CollectionsStruct$StringValue getTitle() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.title_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasCallId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTitle() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MeetOuterClass$RequestGenerateCallLink meetOuterClass$RequestGenerateCallLink) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetOuterClass$RequestGenerateCallLink);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseFrom(byte[] bArr) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseFrom(InputStream inputStream) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetOuterClass$RequestGenerateCallLink parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetOuterClass$RequestGenerateCallLink) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
