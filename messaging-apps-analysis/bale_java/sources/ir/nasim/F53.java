package ir.nasim;

import livekit.LivekitModels$DataStream;

/* loaded from: classes3.dex */
public interface F53 {
    void E();

    void a(LivekitModels$DataStream.Chunk chunk);

    void c(LivekitModels$DataStream.Header header, String str);

    void r(LivekitModels$DataStream.Trailer trailer);
}
