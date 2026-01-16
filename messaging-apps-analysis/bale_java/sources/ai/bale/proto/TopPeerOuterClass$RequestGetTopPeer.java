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
public final class TopPeerOuterClass$RequestGetTopPeer extends GeneratedMessageLite implements U64 {
    private static final TopPeerOuterClass$RequestGetTopPeer DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TopPeerOuterClass$RequestGetTopPeer.DEFAULT_INSTANCE);
        }
    }

    static {
        TopPeerOuterClass$RequestGetTopPeer topPeerOuterClass$RequestGetTopPeer = new TopPeerOuterClass$RequestGetTopPeer();
        DEFAULT_INSTANCE = topPeerOuterClass$RequestGetTopPeer;
        GeneratedMessageLite.registerDefaultInstance(TopPeerOuterClass$RequestGetTopPeer.class, topPeerOuterClass$RequestGetTopPeer);
    }

    private TopPeerOuterClass$RequestGetTopPeer() {
    }

    public static TopPeerOuterClass$RequestGetTopPeer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseDelimitedFrom(InputStream inputStream) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseFrom(ByteBuffer byteBuffer) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (l2.a[gVar.ordinal()]) {
            case 1:
                return new TopPeerOuterClass$RequestGetTopPeer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TopPeerOuterClass$RequestGetTopPeer.class) {
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

    public static a newBuilder(TopPeerOuterClass$RequestGetTopPeer topPeerOuterClass$RequestGetTopPeer) {
        return (a) DEFAULT_INSTANCE.createBuilder(topPeerOuterClass$RequestGetTopPeer);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseFrom(AbstractC2383g abstractC2383g) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseFrom(byte[] bArr) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseFrom(byte[] bArr, C2394s c2394s) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseFrom(InputStream inputStream) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseFrom(AbstractC2384h abstractC2384h) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TopPeerOuterClass$RequestGetTopPeer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TopPeerOuterClass$RequestGetTopPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
