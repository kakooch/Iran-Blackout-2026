package okio.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.UA2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "entry", "Lokio/internal/ZipEntry;", "invoke", "(Lokio/internal/ZipEntry;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
final class ResourceFileSystem$toJarRoot$zip$1 extends AbstractC8614Ws3 implements UA2 {
    public static final ResourceFileSystem$toJarRoot$zip$1 INSTANCE = new ResourceFileSystem$toJarRoot$zip$1();

    ResourceFileSystem$toJarRoot$zip$1() {
        super(1);
    }

    @Override // ir.nasim.UA2
    public final Boolean invoke(ZipEntry zipEntry) {
        AbstractC13042fc3.i(zipEntry, "entry");
        return Boolean.valueOf(ResourceFileSystem.Companion.keepPath(zipEntry.getCanonicalPath()));
    }
}
