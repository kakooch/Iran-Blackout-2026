package ai.bale.proto;

import ai.bale.proto.PeersStruct$UserOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.FM7;
import ir.nasim.JM7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$PuppetUser extends GeneratedMessageLite implements JM7 {
    private static final UsersStruct$PuppetUser DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PUPPETEER_FIELD_NUMBER = 2;
    public static final int USER_OUT_PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private int puppeteer_;
    private PeersStruct$UserOutPeer userOutPeer_;

    public static final class a extends GeneratedMessageLite.b implements JM7 {
        private a() {
            super(UsersStruct$PuppetUser.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$PuppetUser usersStruct$PuppetUser = new UsersStruct$PuppetUser();
        DEFAULT_INSTANCE = usersStruct$PuppetUser;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$PuppetUser.class, usersStruct$PuppetUser);
    }

    private UsersStruct$PuppetUser() {
    }

    private void clearPuppeteer() {
        this.puppeteer_ = 0;
    }

    private void clearUserOutPeer() {
        this.userOutPeer_ = null;
        this.bitField0_ &= -2;
    }

    public static UsersStruct$PuppetUser getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUserOutPeer(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        PeersStruct$UserOutPeer peersStruct$UserOutPeer2 = this.userOutPeer_;
        if (peersStruct$UserOutPeer2 == null || peersStruct$UserOutPeer2 == PeersStruct$UserOutPeer.getDefaultInstance()) {
            this.userOutPeer_ = peersStruct$UserOutPeer;
        } else {
            this.userOutPeer_ = (PeersStruct$UserOutPeer) ((PeersStruct$UserOutPeer.a) PeersStruct$UserOutPeer.newBuilder(this.userOutPeer_).v(peersStruct$UserOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$PuppetUser parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$PuppetUser parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPuppeteer(FM7 fm7) {
        this.puppeteer_ = fm7.getNumber();
    }

    private void setPuppeteerValue(int i) {
        this.puppeteer_ = i;
    }

    private void setUserOutPeer(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        this.userOutPeer_ = peersStruct$UserOutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$PuppetUser();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f", new Object[]{"bitField0_", "userOutPeer_", "puppeteer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$PuppetUser.class) {
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

    public FM7 getPuppeteer() {
        FM7 fm7J = FM7.j(this.puppeteer_);
        return fm7J == null ? FM7.UNRECOGNIZED : fm7J;
    }

    public int getPuppeteerValue() {
        return this.puppeteer_;
    }

    public PeersStruct$UserOutPeer getUserOutPeer() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.userOutPeer_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public boolean hasUserOutPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersStruct$PuppetUser usersStruct$PuppetUser) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$PuppetUser);
    }

    public static UsersStruct$PuppetUser parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$PuppetUser parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$PuppetUser parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$PuppetUser parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$PuppetUser parseFrom(byte[] bArr) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$PuppetUser parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$PuppetUser parseFrom(InputStream inputStream) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$PuppetUser parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$PuppetUser parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$PuppetUser parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$PuppetUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
