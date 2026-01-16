package org.linphone.core;

/* loaded from: classes3.dex */
public interface AudioDevice {
    Capabilities getCapabilities();

    String getDeviceName();

    String getDriverName();

    String getId();

    long getNativePointer();

    Type getType();

    Object getUserData();

    boolean hasCapability(Capabilities capabilities);

    void setUserData(Object obj);

    String toString();

    public enum Capabilities {
        CapabilityRecord(1),
        CapabilityPlay(2),
        CapabilityAll(3);

        protected final int mValue;

        Capabilities(int i) {
            this.mValue = i;
        }

        public static Capabilities fromInt(int i) throws RuntimeException {
            if (i == 1) {
                return CapabilityRecord;
            }
            if (i == 2) {
                return CapabilityPlay;
            }
            if (i == 3) {
                return CapabilityAll;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for Capabilities");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum Type {
        Unknown(0),
        Microphone(1),
        Earpiece(2),
        Speaker(3),
        Bluetooth(4),
        BluetoothA2DP(5),
        Telephony(6),
        AuxLine(7),
        GenericUsb(8),
        Headset(9),
        Headphones(10),
        HearingAid(11);

        protected final int mValue;

        Type(int i) {
            this.mValue = i;
        }

        public static Type fromInt(int i) throws RuntimeException {
            switch (i) {
                case 0:
                    return Unknown;
                case 1:
                    return Microphone;
                case 2:
                    return Earpiece;
                case 3:
                    return Speaker;
                case 4:
                    return Bluetooth;
                case 5:
                    return BluetoothA2DP;
                case 6:
                    return Telephony;
                case 7:
                    return AuxLine;
                case 8:
                    return GenericUsb;
                case 9:
                    return Headset;
                case 10:
                    return Headphones;
                case 11:
                    return HearingAid;
                default:
                    throw new RuntimeException("Unhandled enum value " + i + " for Type");
            }
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
