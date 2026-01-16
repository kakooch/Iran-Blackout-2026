package ir.nasim;

import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class CD0 {
    private final Object a = new Object();
    private final Map b = new LinkedHashMap();
    private final Set c = new HashSet();

    public LinkedHashSet a() {
        LinkedHashSet linkedHashSet;
        synchronized (this.a) {
            linkedHashSet = new LinkedHashSet(this.b.values());
        }
        return linkedHashSet;
    }

    public void b(InterfaceC11560dD0 interfaceC11560dD0) {
        synchronized (this.a) {
            try {
                for (String str : interfaceC11560dD0.b()) {
                    PI3.a("CameraRepository", "Added camera: " + str);
                    this.b.put(str, interfaceC11560dD0.a(str));
                }
            } catch (CameraUnavailableException e) {
                throw new InitializationException(e);
            }
        }
    }
}
