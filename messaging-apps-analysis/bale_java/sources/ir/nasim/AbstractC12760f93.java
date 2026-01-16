package ir.nasim;

import ir.nasim.T08;
import ir.nasim.chat.inputbar.InputBarView;

/* renamed from: ir.nasim.f93, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC12760f93 {
    public static void a(InputBarView inputBarView, TF2 tf2) {
        inputBarView.getFilePathFromUriUseCase = tf2;
    }

    public static void b(InputBarView inputBarView, C4892Gz7 c4892Gz7) {
        inputBarView.typingModule = c4892Gz7;
    }

    public static void c(InputBarView inputBarView, T08.g gVar) {
        inputBarView.voiceRecorderFactory = gVar;
    }
}
