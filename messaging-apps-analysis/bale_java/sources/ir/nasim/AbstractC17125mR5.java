package ir.nasim;

import java.util.EventObject;

/* renamed from: ir.nasim.mR5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC17125mR5 extends EventObject {
    private InterfaceC17658nL1 m_dialog;
    private UP5 m_request;
    private InterfaceC5278Iq6 m_transaction;

    public AbstractC17125mR5(Object obj, InterfaceC5278Iq6 interfaceC5278Iq6, InterfaceC17658nL1 interfaceC17658nL1, UP5 up5) {
        super(obj);
        this.m_transaction = interfaceC5278Iq6;
        this.m_request = up5;
        this.m_dialog = interfaceC17658nL1;
    }

    public InterfaceC17658nL1 getDialog() {
        return this.m_dialog;
    }

    public UP5 getRequest() {
        return this.m_request;
    }

    public InterfaceC5278Iq6 getServerTransaction() {
        return this.m_transaction;
    }
}
