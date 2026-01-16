package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TopPeerOuterClass$ResponseRemovePeer extends GeneratedMessageLite implements U64 {
    private static final TopPeerOuterClass$ResponseRemovePeer DEFAULT_INSTANCE;
    public static final int IS_REMOVED_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean isRemoved_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TopPeerOuterClass$ResponseRemovePeer.DEFAULT_INSTANCE);
        }
    }

    static {
        TopPeerOuterClass$ResponseRemovePeer topPeerOuterClass$ResponseRemovePeer = new TopPeerOuterClass$ResponseRemovePeer();
        DEFAULT_INSTANCE = topPeerOuterClass$ResponseRemovePeer;
        GeneratedMessageLite.registerDefaultInstance(TopPeerOuterClass$ResponseRemovePeer.class, topPeerOuterClass$ResponseRemovePeer);
    }

    private TopPeerOuterClass$ResponseRemovePeer() {
    }

    private void clearIsRemoved() {
        this.isRemoved_ = false;
    }

    public static TopPeerOuterClass$ResponseRemovePeer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseDelimitedFrom(InputStream inputStream) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseFrom(ByteBuffer byteBuffer) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsRemoved(boolean z) {
        this.isRemoved_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (l2.a[gVar.ordinal()]) {
            case 1:
                return new TopPeerOuterClass$ResponseRemovePeer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"isRemoved_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TopPeerOuterClass$ResponseRemovePeer.class) {
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

    public boolean getIsRemoved() {
        return this.isRemoved_;
    }

    public static a newBuilder(TopPeerOuterClass$ResponseRemovePeer topPeerOuterClass$ResponseRemovePeer) {
        return (a) DEFAULT_INSTANCE.createBuilder(topPeerOuterClass$ResponseRemovePeer);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseFrom(AbstractC2383g abstractC2383g) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseFrom(byte[] bArr) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseFrom(byte[] bArr, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseFrom(InputStream inputStream) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseFrom(AbstractC2384h abstractC2384h) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TopPeerOuterClass$ResponseRemovePeer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TopPeerOuterClass$ResponseRemovePeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
