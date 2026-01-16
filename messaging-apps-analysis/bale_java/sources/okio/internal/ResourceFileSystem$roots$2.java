package okio.internal;

import ir.nasim.AbstractC8614Ws3;
import ir.nasim.SA2;
import ir.nasim.XV4;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lir/nasim/XV4;", "Lokio/FileSystem;", "Lokio/Path;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
/* loaded from: classes8.dex */
final class ResourceFileSystem$roots$2 extends AbstractC8614Ws3 implements SA2 {
    final /* synthetic */ ResourceFileSystem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ResourceFileSystem$roots$2(ResourceFileSystem resourceFileSystem) {
        super(0);
        this.this$0 = resourceFileSystem;
    }

    @Override // ir.nasim.SA2
    public final List<XV4> invoke() {
        ResourceFileSystem resourceFileSystem = this.this$0;
        return resourceFileSystem.toClasspathRoots(resourceFileSystem.classLoader);
    }
}
