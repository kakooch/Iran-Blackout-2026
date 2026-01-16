package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.X04;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetStruct$JoinRequest extends GeneratedMessageLite implements X04 {
    private static final MeetStruct$JoinRequest DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REQUESTER_IDENTIFIER_FIELD_NUMBER = 1;
    private String requesterIdentifier_ = "";
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements X04 {
        private a() {
            super(MeetStruct$JoinRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetStruct$JoinRequest meetStruct$JoinRequest = new MeetStruct$JoinRequest();
        DEFAULT_INSTANCE = meetStruct$JoinRequest;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$JoinRequest.class, meetStruct$JoinRequest);
    }

    private MeetStruct$JoinRequest() {
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearRequesterIdentifier() {
        this.requesterIdentifier_ = getDefaultInstance().getRequesterIdentifier();
    }

    public static MeetStruct$JoinRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MeetStruct$JoinRequest parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$JoinRequest parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setRequesterIdentifier(String str) {
        str.getClass();
        this.requesterIdentifier_ = str;
    }

    private void setRequesterIdentifierBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.requesterIdentifier_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$JoinRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"requesterIdentifier_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$JoinRequest.class) {
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

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getRequesterIdentifier() {
        return this.requesterIdentifier_;
    }

    public AbstractC2383g getRequesterIdentifierBytes() {
        return AbstractC2383g.N(this.requesterIdentifier_);
    }

    public static a newBuilder(MeetStruct$JoinRequest meetStruct$JoinRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$JoinRequest);
    }

    public static MeetStruct$JoinRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$JoinRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$JoinRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$JoinRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$JoinRequest parseFrom(byte[] bArr) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$JoinRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$JoinRequest parseFrom(InputStream inputStream) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$JoinRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$JoinRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$JoinRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$JoinRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
