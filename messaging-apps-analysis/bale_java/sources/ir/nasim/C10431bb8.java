package ir.nasim;

import android.content.Context;
import androidx.work.b;
import ir.nasim.C18424oe1;
import ir.nasim.PK4;
import ir.nasim.utils.tools.workmanager.workers.ClearAllGroupPermissions;
import ir.nasim.utils.tools.workmanager.workers.ClearMessagesWorker;
import ir.nasim.utils.tools.workmanager.workers.DeleteChatWorker;
import ir.nasim.utils.tools.workmanager.workers.RemoveExpiredStoryPhotosWorker;
import ir.nasim.utils.tools.workmanager.workers.RemoveFilePreferencesFromDefaultProperties;
import ir.nasim.utils.tools.workmanager.workers.UploadPinnedDialogsWorker;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.bb8, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10431bb8 {
    private static Ya8 b;
    public static final C10431bb8 a = new C10431bb8();
    public static final int c = 8;

    private C10431bb8() {
    }

    private final void f(AbstractC16037kb8 abstractC16037kb8) {
        if (b == null) {
            Context contextD = C5721Ko.a.d();
            Context applicationContext = contextD != null ? contextD.getApplicationContext() : null;
            if (applicationContext == null) {
                C19406qI3.j("WorkManagerUtil", "application context is null, so return!", new Object[0]);
                return;
            }
            b = Ya8.d(applicationContext);
        }
        Ya8 ya8 = b;
        if (ya8 != null) {
            ya8.b(abstractC16037kb8);
        }
    }

    public final void a(int i, long[] jArr) throws Throwable {
        AbstractC13042fc3.i(jArr, "pinDialogs");
        androidx.work.b bVarA = new b.a().g("peers_uid_to_pin", jArr).f("folder_id_to_pin", i).a();
        AbstractC13042fc3.h(bVarA, "build(...)");
        AbstractC16037kb8 abstractC16037kb8B = ((PK4.a) ((PK4.a) new PK4.a(UploadPinnedDialogsWorker.class).h(bVarA)).e(EnumC9756aW.EXPONENTIAL, 5L, TimeUnit.SECONDS)).b();
        AbstractC13042fc3.h(abstractC16037kb8B, "build(...)");
        f((PK4) abstractC16037kb8B);
    }

    public final void b(int i) {
        Ya8 ya8 = b;
        if (ya8 != null) {
            ya8.a("DeleteChatWorkerTag " + i);
        }
    }

    public final void c() {
        AbstractC16037kb8 abstractC16037kb8B = ((PK4.a) new PK4.a(ClearAllGroupPermissions.class).e(EnumC9756aW.EXPONENTIAL, 5L, TimeUnit.MINUTES)).b();
        AbstractC13042fc3.h(abstractC16037kb8B, "build(...)");
        f((PK4) abstractC16037kb8B);
    }

    public final void d(long[] jArr) throws Throwable {
        AbstractC13042fc3.i(jArr, "peers");
        C19406qI3.a("WorkManagerUtil", "clearMessagesForPeers size: " + jArr.length, new Object[0]);
        androidx.work.b bVarA = new b.a().g("peers_id_to_clear", jArr).a();
        AbstractC13042fc3.h(bVarA, "build(...)");
        AbstractC16037kb8 abstractC16037kb8B = ((PK4.a) ((PK4.a) new PK4.a(ClearMessagesWorker.class).h(bVarA)).e(EnumC9756aW.EXPONENTIAL, 10L, TimeUnit.SECONDS)).b();
        AbstractC13042fc3.h(abstractC16037kb8B, "build(...)");
        f((PK4) abstractC16037kb8B);
    }

    public final void e(int i, boolean z, long j) throws Throwable {
        androidx.work.b bVarA = new b.a().f("peers_id_to_delete", i).e("peers_id_to_delete_peer_type", z).a();
        AbstractC13042fc3.h(bVarA, "build(...)");
        PK4.a aVar = (PK4.a) new PK4.a(DeleteChatWorker.class).h(bVarA);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        AbstractC16037kb8 abstractC16037kb8B = ((PK4.a) ((PK4.a) ((PK4.a) aVar.g(j, timeUnit)).e(EnumC9756aW.EXPONENTIAL, 5L, timeUnit)).a("DeleteChatWorkerTag " + i)).b();
        AbstractC13042fc3.h(abstractC16037kb8B, "build(...)");
        f((PK4) abstractC16037kb8B);
    }

    public final void g(List list) {
        AbstractC13042fc3.i(list, "storyFileIds");
        b.a aVar = new b.a();
        aVar.g("story_ids", AbstractC15401jX0.n1(list));
        AbstractC16037kb8 abstractC16037kb8B = ((PK4.a) ((PK4.a) ((PK4.a) new PK4.a(RemoveExpiredStoryPhotosWorker.class).e(EnumC9756aW.EXPONENTIAL, 5L, TimeUnit.MINUTES)).f(new C18424oe1.a().b(true).a())).h(aVar.a())).b();
        AbstractC13042fc3.h(abstractC16037kb8B, "build(...)");
        f((PK4) abstractC16037kb8B);
    }

    public final void h() {
        AbstractC16037kb8 abstractC16037kb8B = ((PK4.a) ((PK4.a) new PK4.a(RemoveFilePreferencesFromDefaultProperties.class).e(EnumC9756aW.EXPONENTIAL, 5L, TimeUnit.MINUTES)).f(new C18424oe1.a().b(true).a())).b();
        AbstractC13042fc3.h(abstractC16037kb8B, "build(...)");
        f((PK4) abstractC16037kb8B);
    }
}
