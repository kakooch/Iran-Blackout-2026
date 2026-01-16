package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum CE3 implements B.c {
    H264_720P_30FPS_3_LAYERS(0),
    H264_1080P_30FPS_3_LAYERS(1),
    H264_540P_25FPS_2_LAYERS(2),
    H264_720P_30FPS_1_LAYER(3),
    H264_1080P_30FPS_1_LAYER(4),
    H264_720P_30FPS_3_LAYERS_HIGH_MOTION(5),
    H264_1080P_30FPS_3_LAYERS_HIGH_MOTION(6),
    H264_540P_25FPS_2_LAYERS_HIGH_MOTION(7),
    H264_720P_30FPS_1_LAYER_HIGH_MOTION(8),
    H264_1080P_30FPS_1_LAYER_HIGH_MOTION(9),
    UNRECOGNIZED(-1);

    private static final B.d m = new B.d() { // from class: ir.nasim.CE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CE3 a(int i) {
            return CE3.j(i);
        }
    };
    private final int a;

    CE3(int i) {
        this.a = i;
    }

    public static CE3 j(int i) {
        switch (i) {
            case 0:
                return H264_720P_30FPS_3_LAYERS;
            case 1:
                return H264_1080P_30FPS_3_LAYERS;
            case 2:
                return H264_540P_25FPS_2_LAYERS;
            case 3:
                return H264_720P_30FPS_1_LAYER;
            case 4:
                return H264_1080P_30FPS_1_LAYER;
            case 5:
                return H264_720P_30FPS_3_LAYERS_HIGH_MOTION;
            case 6:
                return H264_1080P_30FPS_3_LAYERS_HIGH_MOTION;
            case 7:
                return H264_540P_25FPS_2_LAYERS_HIGH_MOTION;
            case 8:
                return H264_720P_30FPS_1_LAYER_HIGH_MOTION;
            case 9:
                return H264_1080P_30FPS_1_LAYER_HIGH_MOTION;
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
