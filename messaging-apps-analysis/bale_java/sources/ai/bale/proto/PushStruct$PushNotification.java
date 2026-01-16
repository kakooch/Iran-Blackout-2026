package ai.bale.proto;

import ai.bale.proto.PushStruct$EncryptedNotifications;
import ai.bale.proto.PushStruct$PlainNotifications;
import ai.bale.proto.PushStruct$WakeupNotification;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushStruct$PushNotification extends GeneratedMessageLite implements U64 {
    private static final PushStruct$PushNotification DEFAULT_INSTANCE;
    public static final int ENCRYPTED_NOTIFICATION_FIELD_NUMBER = 11;
    public static final int OWNER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PLAIN_NOTIFICATION_FIELD_NUMBER = 12;
    public static final int PUSH_SENT_TIME_FIELD_NUMBER = 2;
    public static final int WAKEUP_FIELD_NUMBER = 13;
    private int notificationCase_ = 0;
    private Object notification_;
    private int ownerId_;
    private long pushSentTime_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushStruct$PushNotification.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        ENCRYPTED_NOTIFICATION(11),
        PLAIN_NOTIFICATION(12),
        WAKEUP(13),
        NOTIFICATION_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return NOTIFICATION_NOT_SET;
            }
            switch (i) {
                case 11:
                    return ENCRYPTED_NOTIFICATION;
                case 12:
                    return PLAIN_NOTIFICATION;
                case 13:
                    return WAKEUP;
                default:
                    return null;
            }
        }
    }

    static {
        PushStruct$PushNotification pushStruct$PushNotification = new PushStruct$PushNotification();
        DEFAULT_INSTANCE = pushStruct$PushNotification;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$PushNotification.class, pushStruct$PushNotification);
    }

    private PushStruct$PushNotification() {
    }

    private void clearEncryptedNotification() {
        if (this.notificationCase_ == 11) {
            this.notificationCase_ = 0;
            this.notification_ = null;
        }
    }

    private void clearNotification() {
        this.notificationCase_ = 0;
        this.notification_ = null;
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    private void clearPlainNotification() {
        if (this.notificationCase_ == 12) {
            this.notificationCase_ = 0;
            this.notification_ = null;
        }
    }

    private void clearPushSentTime() {
        this.pushSentTime_ = 0L;
    }

    private void clearWakeup() {
        if (this.notificationCase_ == 13) {
            this.notificationCase_ = 0;
            this.notification_ = null;
        }
    }

    public static PushStruct$PushNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeEncryptedNotification(PushStruct$EncryptedNotifications pushStruct$EncryptedNotifications) {
        pushStruct$EncryptedNotifications.getClass();
        if (this.notificationCase_ != 11 || this.notification_ == PushStruct$EncryptedNotifications.getDefaultInstance()) {
            this.notification_ = pushStruct$EncryptedNotifications;
        } else {
            this.notification_ = ((PushStruct$EncryptedNotifications.a) PushStruct$EncryptedNotifications.newBuilder((PushStruct$EncryptedNotifications) this.notification_).v(pushStruct$EncryptedNotifications)).j();
        }
        this.notificationCase_ = 11;
    }

    private void mergePlainNotification(PushStruct$PlainNotifications pushStruct$PlainNotifications) {
        pushStruct$PlainNotifications.getClass();
        if (this.notificationCase_ != 12 || this.notification_ == PushStruct$PlainNotifications.getDefaultInstance()) {
            this.notification_ = pushStruct$PlainNotifications;
        } else {
            this.notification_ = ((PushStruct$PlainNotifications.a) PushStruct$PlainNotifications.newBuilder((PushStruct$PlainNotifications) this.notification_).v(pushStruct$PlainNotifications)).j();
        }
        this.notificationCase_ = 12;
    }

    private void mergeWakeup(PushStruct$WakeupNotification pushStruct$WakeupNotification) {
        pushStruct$WakeupNotification.getClass();
        if (this.notificationCase_ != 13 || this.notification_ == PushStruct$WakeupNotification.getDefaultInstance()) {
            this.notification_ = pushStruct$WakeupNotification;
        } else {
            this.notification_ = ((PushStruct$WakeupNotification.a) PushStruct$WakeupNotification.newBuilder((PushStruct$WakeupNotification) this.notification_).v(pushStruct$WakeupNotification)).j();
        }
        this.notificationCase_ = 13;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$PushNotification parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$PushNotification parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEncryptedNotification(PushStruct$EncryptedNotifications pushStruct$EncryptedNotifications) {
        pushStruct$EncryptedNotifications.getClass();
        this.notification_ = pushStruct$EncryptedNotifications;
        this.notificationCase_ = 11;
    }

    private void setOwnerId(int i) {
        this.ownerId_ = i;
    }

    private void setPlainNotification(PushStruct$PlainNotifications pushStruct$PlainNotifications) {
        pushStruct$PlainNotifications.getClass();
        this.notification_ = pushStruct$PlainNotifications;
        this.notificationCase_ = 12;
    }

    private void setPushSentTime(long j) {
        this.pushSentTime_ = j;
    }

    private void setWakeup(PushStruct$WakeupNotification pushStruct$WakeupNotification) {
        pushStruct$WakeupNotification.getClass();
        this.notification_ = pushStruct$WakeupNotification;
        this.notificationCase_ = 13;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$PushNotification();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\r\u0005\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u000b<\u0000\f<\u0000\r<\u0000", new Object[]{"notification_", "notificationCase_", "ownerId_", "pushSentTime_", PushStruct$EncryptedNotifications.class, PushStruct$PlainNotifications.class, PushStruct$WakeupNotification.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$PushNotification.class) {
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

    public PushStruct$EncryptedNotifications getEncryptedNotification() {
        return this.notificationCase_ == 11 ? (PushStruct$EncryptedNotifications) this.notification_ : PushStruct$EncryptedNotifications.getDefaultInstance();
    }

    public b getNotificationCase() {
        return b.j(this.notificationCase_);
    }

    public int getOwnerId() {
        return this.ownerId_;
    }

    public PushStruct$PlainNotifications getPlainNotification() {
        return this.notificationCase_ == 12 ? (PushStruct$PlainNotifications) this.notification_ : PushStruct$PlainNotifications.getDefaultInstance();
    }

    public long getPushSentTime() {
        return this.pushSentTime_;
    }

    public PushStruct$WakeupNotification getWakeup() {
        return this.notificationCase_ == 13 ? (PushStruct$WakeupNotification) this.notification_ : PushStruct$WakeupNotification.getDefaultInstance();
    }

    public boolean hasEncryptedNotification() {
        return this.notificationCase_ == 11;
    }

    public boolean hasPlainNotification() {
        return this.notificationCase_ == 12;
    }

    public boolean hasWakeup() {
        return this.notificationCase_ == 13;
    }

    public static a newBuilder(PushStruct$PushNotification pushStruct$PushNotification) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$PushNotification);
    }

    public static PushStruct$PushNotification parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$PushNotification parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$PushNotification parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$PushNotification parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$PushNotification parseFrom(byte[] bArr) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$PushNotification parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$PushNotification parseFrom(InputStream inputStream) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$PushNotification parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$PushNotification parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$PushNotification parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$PushNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
