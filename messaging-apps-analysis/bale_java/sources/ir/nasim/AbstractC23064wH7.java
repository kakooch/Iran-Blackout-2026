package ir.nasim;

import android.app.AlarmManager;
import ir.nasim.core.modules.file.upload.UploadService;

/* renamed from: ir.nasim.wH7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC23064wH7 {
    public static void a(UploadService uploadService, AlarmManager alarmManager) {
        uploadService.alarmManager = alarmManager;
    }

    public static void b(UploadService uploadService, InterfaceC12532em2 interfaceC12532em2) {
        uploadService.fileRepository = interfaceC12532em2;
    }

    public static void c(UploadService uploadService, AbstractC13778go1 abstractC13778go1) {
        uploadService.ioDispatcher = abstractC13778go1;
    }

    public static void d(UploadService uploadService, E84 e84) {
        uploadService.messagesModule = e84;
    }
}
