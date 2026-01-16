package io.sentry.protocol;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.sentry.A0;
import io.sentry.ILogger;
import io.sentry.InterfaceC3118g1;
import io.sentry.InterfaceC3123h1;
import io.sentry.InterfaceC3176q0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class DebugImage implements A0 {
    public static final String JVM = "jvm";
    public static final String PROGUARD = "proguard";
    private String arch;
    private String codeFile;
    private String codeId;
    private String debugFile;
    private String debugId;
    private String imageAddr;
    private Long imageSize;
    private String type;
    private Map<String, Object> unknown;
    private String uuid;

    public static final class a implements InterfaceC3176q0 {
        @Override // io.sentry.InterfaceC3176q0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DebugImage a(InterfaceC3118g1 interfaceC3118g1, ILogger iLogger) {
            String strN0;
            DebugImage debugImage = new DebugImage();
            interfaceC3118g1.B();
            HashMap map = null;
            while (interfaceC3118g1.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strN0 = interfaceC3118g1.n0();
                strN0.hashCode();
                switch (strN0) {
                    case "debug_file":
                        debugImage.debugFile = interfaceC3118g1.g1();
                        break;
                    case "image_addr":
                        debugImage.imageAddr = interfaceC3118g1.g1();
                        break;
                    case "image_size":
                        debugImage.imageSize = interfaceC3118g1.a1();
                        break;
                    case "code_file":
                        debugImage.codeFile = interfaceC3118g1.g1();
                        break;
                    case "arch":
                        debugImage.arch = interfaceC3118g1.g1();
                        break;
                    case "type":
                        debugImage.type = interfaceC3118g1.g1();
                        break;
                    case "uuid":
                        debugImage.uuid = interfaceC3118g1.g1();
                        break;
                    case "debug_id":
                        debugImage.debugId = interfaceC3118g1.g1();
                        break;
                    case "code_id":
                        debugImage.codeId = interfaceC3118g1.g1();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        interfaceC3118g1.j1(iLogger, map, strN0);
                        break;
                }
            }
            interfaceC3118g1.F();
            debugImage.setUnknown(map);
            return debugImage;
        }
    }

    public String getArch() {
        return this.arch;
    }

    public String getCodeFile() {
        return this.codeFile;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public String getDebugFile() {
        return this.debugFile;
    }

    public String getDebugId() {
        return this.debugId;
    }

    public String getImageAddr() {
        return this.imageAddr;
    }

    public Long getImageSize() {
        return this.imageSize;
    }

    public String getType() {
        return this.type;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public String getUuid() {
        return this.uuid;
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        if (this.uuid != null) {
            interfaceC3123h1.f(CommonUrlParts.UUID).h(this.uuid);
        }
        if (this.type != null) {
            interfaceC3123h1.f("type").h(this.type);
        }
        if (this.debugId != null) {
            interfaceC3123h1.f("debug_id").h(this.debugId);
        }
        if (this.debugFile != null) {
            interfaceC3123h1.f("debug_file").h(this.debugFile);
        }
        if (this.codeId != null) {
            interfaceC3123h1.f("code_id").h(this.codeId);
        }
        if (this.codeFile != null) {
            interfaceC3123h1.f("code_file").h(this.codeFile);
        }
        if (this.imageAddr != null) {
            interfaceC3123h1.f("image_addr").h(this.imageAddr);
        }
        if (this.imageSize != null) {
            interfaceC3123h1.f("image_size").k(this.imageSize);
        }
        if (this.arch != null) {
            interfaceC3123h1.f("arch").h(this.arch);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                interfaceC3123h1.f(str).l(iLogger, this.unknown.get(str));
            }
        }
        interfaceC3123h1.F();
    }

    public void setArch(String str) {
        this.arch = str;
    }

    public void setCodeFile(String str) {
        this.codeFile = str;
    }

    public void setCodeId(String str) {
        this.codeId = str;
    }

    public void setDebugFile(String str) {
        this.debugFile = str;
    }

    public void setDebugId(String str) {
        this.debugId = str;
    }

    public void setImageAddr(String str) {
        this.imageAddr = str;
    }

    public void setImageSize(Long l) {
        this.imageSize = l;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setImageSize(long j) {
        this.imageSize = Long.valueOf(j);
    }
}
