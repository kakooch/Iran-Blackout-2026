package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum IE3 implements B.c {
    AGENTS_LLM_TTFT(0),
    AGENTS_STT_TTFT(1),
    AGENTS_TTS_TTFB(2),
    CLIENT_VIDEO_SUBSCRIBER_FREEZE_COUNT(3),
    CLIENT_VIDEO_SUBSCRIBER_TOTAL_FREEZE_DURATION(4),
    CLIENT_VIDEO_SUBSCRIBER_PAUSE_COUNT(5),
    CLIENT_VIDEO_SUBSCRIBER_TOTAL_PAUSES_DURATION(6),
    CLIENT_AUDIO_SUBSCRIBER_CONCEALED_SAMPLES(7),
    CLIENT_AUDIO_SUBSCRIBER_SILENT_CONCEALED_SAMPLES(8),
    CLIENT_AUDIO_SUBSCRIBER_CONCEALMENT_EVENTS(9),
    CLIENT_AUDIO_SUBSCRIBER_INTERRUPTION_COUNT(10),
    CLIENT_AUDIO_SUBSCRIBER_TOTAL_INTERRUPTION_DURATION(11),
    CLIENT_SUBSCRIBER_JITTER_BUFFER_DELAY(12),
    CLIENT_SUBSCRIBER_JITTER_BUFFER_EMITTED_COUNT(13),
    CLIENT_VIDEO_PUBLISHER_QUALITY_LIMITATION_DURATION_BANDWIDTH(14),
    CLIENT_VIDEO_PUBLISHER_QUALITY_LIMITATION_DURATION_CPU(15),
    CLIENT_VIDEO_PUBLISHER_QUALITY_LIMITATION_DURATION_OTHER(16),
    PUBLISHER_RTT(17),
    SERVER_MESH_RTT(18),
    SUBSCRIBER_RTT(19),
    METRIC_LABEL_PREDEFINED_MAX_VALUE(4096),
    UNRECOGNIZED(-1);

    private static final B.d x = new B.d() { // from class: ir.nasim.IE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IE3 a(int i) {
            return IE3.j(i);
        }
    };
    private final int a;

    IE3(int i) {
        this.a = i;
    }

    public static IE3 j(int i) {
        if (i == 4096) {
            return METRIC_LABEL_PREDEFINED_MAX_VALUE;
        }
        switch (i) {
            case 0:
                return AGENTS_LLM_TTFT;
            case 1:
                return AGENTS_STT_TTFT;
            case 2:
                return AGENTS_TTS_TTFB;
            case 3:
                return CLIENT_VIDEO_SUBSCRIBER_FREEZE_COUNT;
            case 4:
                return CLIENT_VIDEO_SUBSCRIBER_TOTAL_FREEZE_DURATION;
            case 5:
                return CLIENT_VIDEO_SUBSCRIBER_PAUSE_COUNT;
            case 6:
                return CLIENT_VIDEO_SUBSCRIBER_TOTAL_PAUSES_DURATION;
            case 7:
                return CLIENT_AUDIO_SUBSCRIBER_CONCEALED_SAMPLES;
            case 8:
                return CLIENT_AUDIO_SUBSCRIBER_SILENT_CONCEALED_SAMPLES;
            case 9:
                return CLIENT_AUDIO_SUBSCRIBER_CONCEALMENT_EVENTS;
            case 10:
                return CLIENT_AUDIO_SUBSCRIBER_INTERRUPTION_COUNT;
            case 11:
                return CLIENT_AUDIO_SUBSCRIBER_TOTAL_INTERRUPTION_DURATION;
            case 12:
                return CLIENT_SUBSCRIBER_JITTER_BUFFER_DELAY;
            case 13:
                return CLIENT_SUBSCRIBER_JITTER_BUFFER_EMITTED_COUNT;
            case 14:
                return CLIENT_VIDEO_PUBLISHER_QUALITY_LIMITATION_DURATION_BANDWIDTH;
            case 15:
                return CLIENT_VIDEO_PUBLISHER_QUALITY_LIMITATION_DURATION_CPU;
            case 16:
                return CLIENT_VIDEO_PUBLISHER_QUALITY_LIMITATION_DURATION_OTHER;
            case 17:
                return PUBLISHER_RTT;
            case 18:
                return SERVER_MESH_RTT;
            case 19:
                return SUBSCRIBER_RTT;
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
