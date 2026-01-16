package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum ME3 implements B.c {
    TF_STEREO(0),
    TF_NO_DTX(1),
    TF_AUTO_GAIN_CONTROL(2),
    TF_ECHO_CANCELLATION(3),
    TF_NOISE_SUPPRESSION(4),
    TF_ENHANCED_NOISE_CANCELLATION(5),
    TF_PRECONNECT_BUFFER(6),
    UNRECOGNIZED(-1);

    private static final B.d j = new B.d() { // from class: ir.nasim.ME3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ME3 a(int i) {
            return ME3.j(i);
        }
    };
    private final int a;

    ME3(int i) {
        this.a = i;
    }

    public static ME3 j(int i) {
        switch (i) {
            case 0:
                return TF_STEREO;
            case 1:
                return TF_NO_DTX;
            case 2:
                return TF_AUTO_GAIN_CONTROL;
            case 3:
                return TF_ECHO_CANCELLATION;
            case 4:
                return TF_NOISE_SUPPRESSION;
            case 5:
                return TF_ENHANCED_NOISE_CANCELLATION;
            case 6:
                return TF_PRECONNECT_BUFFER;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
