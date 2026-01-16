package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC17606nF3;
import ir.nasim.InterfaceC15242jF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$DataChannelInfo extends GeneratedMessageLite implements InterfaceC15242jF3 {
    private static final LivekitRtc$DataChannelInfo DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    public static final int LABEL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TARGET_FIELD_NUMBER = 3;
    private int id_;
    private String label_ = "";
    private int target_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC15242jF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(int i) {
            q();
            ((LivekitRtc$DataChannelInfo) this.b).setId(i);
            return this;
        }

        public a B(String str) {
            q();
            ((LivekitRtc$DataChannelInfo) this.b).setLabel(str);
            return this;
        }

        private a() {
            super(LivekitRtc$DataChannelInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$DataChannelInfo livekitRtc$DataChannelInfo = new LivekitRtc$DataChannelInfo();
        DEFAULT_INSTANCE = livekitRtc$DataChannelInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$DataChannelInfo.class, livekitRtc$DataChannelInfo);
    }

    private LivekitRtc$DataChannelInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLabel() {
        this.label_ = getDefaultInstance().getLabel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTarget() {
        this.target_ = 0;
    }

    public static LivekitRtc$DataChannelInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$DataChannelInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$DataChannelInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.id_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabel(String str) {
        str.getClass();
        this.label_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabelBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.label_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTarget(EnumC17606nF3 enumC17606nF3) {
        this.target_ = enumC17606nF3.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetValue(int i) {
        this.target_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$DataChannelInfo();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u000b\u0003\f", new Object[]{"label_", "id_", "target_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$DataChannelInfo.class) {
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

    public int getId() {
        return this.id_;
    }

    public String getLabel() {
        return this.label_;
    }

    public AbstractC2383g getLabelBytes() {
        return AbstractC2383g.N(this.label_);
    }

    public EnumC17606nF3 getTarget() {
        EnumC17606nF3 enumC17606nF3J = EnumC17606nF3.j(this.target_);
        return enumC17606nF3J == null ? EnumC17606nF3.UNRECOGNIZED : enumC17606nF3J;
    }

    public int getTargetValue() {
        return this.target_;
    }

    public static a newBuilder(LivekitRtc$DataChannelInfo livekitRtc$DataChannelInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$DataChannelInfo);
    }

    public static LivekitRtc$DataChannelInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$DataChannelInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$DataChannelInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$DataChannelInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$DataChannelInfo parseFrom(byte[] bArr) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$DataChannelInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$DataChannelInfo parseFrom(InputStream inputStream) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$DataChannelInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$DataChannelInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$DataChannelInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$DataChannelInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
