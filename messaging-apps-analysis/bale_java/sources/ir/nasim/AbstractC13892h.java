package ir.nasim;

import java.io.FileNotFoundException;
import java.io.IOException;
import okio.FileSystem;
import okio.Path;

/* renamed from: ir.nasim.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13892h {
    public static final void a(FileSystem fileSystem, Path path) throws IOException {
        if (fileSystem.exists(path)) {
            return;
        }
        AbstractC18638p.d(fileSystem.sink(path));
    }

    public static final void b(FileSystem fileSystem, Path path) throws IOException {
        try {
            IOException iOException = null;
            for (Path path2 : fileSystem.list(path)) {
                try {
                    if (fileSystem.metadata(path2).getIsDirectory()) {
                        b(fileSystem, path2);
                    }
                    fileSystem.delete(path2);
                } catch (IOException e) {
                    if (iOException == null) {
                        iOException = e;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }
}
