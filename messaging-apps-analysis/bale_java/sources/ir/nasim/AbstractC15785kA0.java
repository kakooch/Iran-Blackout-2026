package ir.nasim;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.kA0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15785kA0 implements InterfaceC9916am3, Serializable {
    public static final Object NO_RECEIVER = a.a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient InterfaceC9916am3 reflected;
    private final String signature;

    /* renamed from: ir.nasim.kA0$a */
    private static class a implements Serializable {
        private static final a a = new a();

        private a() {
        }
    }

    public AbstractC15785kA0() {
        this(NO_RECEIVER);
    }

    @Override // ir.nasim.InterfaceC9916am3
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // ir.nasim.InterfaceC9916am3
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public InterfaceC9916am3 compute() {
        InterfaceC9916am3 interfaceC9916am3 = this.reflected;
        if (interfaceC9916am3 != null) {
            return interfaceC9916am3;
        }
        InterfaceC9916am3 interfaceC9916am3ComputeReflected = computeReflected();
        this.reflected = interfaceC9916am3ComputeReflected;
        return interfaceC9916am3ComputeReflected;
    }

    protected abstract InterfaceC9916am3 computeReflected();

    @Override // ir.nasim.InterfaceC9326Zl3
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // ir.nasim.InterfaceC9916am3
    public String getName() {
        return this.name;
    }

    public InterfaceC15551jm3 getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? AbstractC10882cM5.c(cls) : AbstractC10882cM5.b(cls);
    }

    @Override // ir.nasim.InterfaceC9916am3
    public List<InterfaceC3347Am3> getParameters() {
        return getReflected().getParameters();
    }

    protected InterfaceC9916am3 getReflected() {
        InterfaceC9916am3 interfaceC9916am3Compute = compute();
        if (interfaceC9916am3Compute != this) {
            return interfaceC9916am3Compute;
        }
        throw new C3392Ar3();
    }

    @Override // ir.nasim.InterfaceC9916am3
    public InterfaceC5941Lm3 getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // ir.nasim.InterfaceC9916am3
    public List<InterfaceC6907Pm3> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // ir.nasim.InterfaceC9916am3
    public EnumC8560Wm3 getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // ir.nasim.InterfaceC9916am3
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // ir.nasim.InterfaceC9916am3
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // ir.nasim.InterfaceC9916am3
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    protected AbstractC15785kA0(Object obj) {
        this(obj, null, null, null, false);
    }

    protected AbstractC15785kA0(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }
}
