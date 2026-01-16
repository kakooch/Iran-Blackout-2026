package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.DM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$Privacy extends GeneratedMessageLite implements U64 {
    private static final UsersStruct$Privacy DEFAULT_INSTANCE;
    public static final int INVITE_PRIVACY_FIELD_NUMBER = 1;
    public static final int MONEY_TRANSFER_PRIVACY_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PRESENCE_PRIVACY_FIELD_NUMBER = 2;
    private int invitePrivacy_;
    private int moneyTransferPrivacy_;
    private int presencePrivacy_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersStruct$Privacy.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$Privacy usersStruct$Privacy = new UsersStruct$Privacy();
        DEFAULT_INSTANCE = usersStruct$Privacy;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$Privacy.class, usersStruct$Privacy);
    }

    private UsersStruct$Privacy() {
    }

    private void clearInvitePrivacy() {
        this.invitePrivacy_ = 0;
    }

    private void clearMoneyTransferPrivacy() {
        this.moneyTransferPrivacy_ = 0;
    }

    private void clearPresencePrivacy() {
        this.presencePrivacy_ = 0;
    }

    public static UsersStruct$Privacy getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$Privacy parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$Privacy parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setInvitePrivacy(DM7 dm7) {
        this.invitePrivacy_ = dm7.getNumber();
    }

    private void setInvitePrivacyValue(int i) {
        this.invitePrivacy_ = i;
    }

    private void setMoneyTransferPrivacy(DM7 dm7) {
        this.moneyTransferPrivacy_ = dm7.getNumber();
    }

    private void setMoneyTransferPrivacyValue(int i) {
        this.moneyTransferPrivacy_ = i;
    }

    private void setPresencePrivacy(DM7 dm7) {
        this.presencePrivacy_ = dm7.getNumber();
    }

    private void setPresencePrivacyValue(int i) {
        this.presencePrivacy_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$Privacy();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"invitePrivacy_", "presencePrivacy_", "moneyTransferPrivacy_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$Privacy.class) {
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

    public DM7 getInvitePrivacy() {
        DM7 dm7J = DM7.j(this.invitePrivacy_);
        return dm7J == null ? DM7.UNRECOGNIZED : dm7J;
    }

    public int getInvitePrivacyValue() {
        return this.invitePrivacy_;
    }

    public DM7 getMoneyTransferPrivacy() {
        DM7 dm7J = DM7.j(this.moneyTransferPrivacy_);
        return dm7J == null ? DM7.UNRECOGNIZED : dm7J;
    }

    public int getMoneyTransferPrivacyValue() {
        return this.moneyTransferPrivacy_;
    }

    public DM7 getPresencePrivacy() {
        DM7 dm7J = DM7.j(this.presencePrivacy_);
        return dm7J == null ? DM7.UNRECOGNIZED : dm7J;
    }

    public int getPresencePrivacyValue() {
        return this.presencePrivacy_;
    }

    public static a newBuilder(UsersStruct$Privacy usersStruct$Privacy) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$Privacy);
    }

    public static UsersStruct$Privacy parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$Privacy parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$Privacy parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$Privacy parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$Privacy parseFrom(byte[] bArr) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$Privacy parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$Privacy parseFrom(InputStream inputStream) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$Privacy parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$Privacy parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$Privacy parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$Privacy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
