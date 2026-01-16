package ir.nasim;

import livekit.LivekitModels$TranscriptionSegment;

/* renamed from: ir.nasim.yu7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC24615yu7 {
    public static final C24025xu7 a(LivekitModels$TranscriptionSegment livekitModels$TranscriptionSegment, long j) {
        AbstractC13042fc3.i(livekitModels$TranscriptionSegment, "<this>");
        String id = livekitModels$TranscriptionSegment.getId();
        AbstractC13042fc3.h(id, "getId(...)");
        String text = livekitModels$TranscriptionSegment.getText();
        AbstractC13042fc3.h(text, "getText(...)");
        String language = livekitModels$TranscriptionSegment.getLanguage();
        AbstractC13042fc3.h(language, "getLanguage(...)");
        return new C24025xu7(id, text, language, livekitModels$TranscriptionSegment.getFinal(), j, 0L, 32, null);
    }
}
