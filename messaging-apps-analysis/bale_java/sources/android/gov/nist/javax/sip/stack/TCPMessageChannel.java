package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SIPConstants;
import android.gov.nist.javax.sip.header.CSeq;
import android.gov.nist.javax.sip.header.CallID;
import android.gov.nist.javax.sip.header.ContentLength;
import android.gov.nist.javax.sip.header.From;
import android.gov.nist.javax.sip.header.RequestLine;
import android.gov.nist.javax.sip.header.StatusLine;
import android.gov.nist.javax.sip.header.To;
import android.gov.nist.javax.sip.header.Via;
import android.gov.nist.javax.sip.message.SIPMessage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.ParseException;

/* loaded from: classes.dex */
public class TCPMessageChannel extends ConnectionOrientedMessageChannel {
    private static StackLogger logger = CommonLogger.getLogger(TCPMessageChannel.class);
    protected OutputStream myClientOutputStream;

    protected TCPMessageChannel(SIPTransactionStack sIPTransactionStack) {
        super(sIPTransactionStack);
    }

    @Override // android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel
    public void close(boolean z, boolean z2) throws IOException {
        this.isRunning = false;
        if (this.mySock != null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Closing socket " + this.key);
            }
            try {
                this.mySock.close();
                this.mySock = null;
            } catch (IOException e) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Error closing socket " + e);
                }
            }
        }
        if (this.myParser != null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Closing my parser " + this.myParser);
            }
            this.myParser.close();
        }
        if (this.myClientOutputStream != null) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Closing client output stream " + this.myClientOutputStream);
            }
            try {
                this.myClientOutputStream.close();
            } catch (IOException e2) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Error closing client output stream" + e2);
                }
            }
        }
        if (z) {
            String strSubstring = this.key.substring(4);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Closing TCP socket " + strSubstring);
            }
            this.sipStack.ioHandler.removeSocket(strSubstring);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Closing message Channel (key = " + this.key + Separators.RPAREN + this);
            }
        } else if (logger.isLoggingEnabled(32)) {
            String strSubstring2 = this.key.substring(4);
            logger.logDebug("not removing socket key from the cached map since it has already been updated by the iohandler.sendBytes " + strSubstring2);
        }
        if (z2) {
            cancelPingKeepAliveTimeoutTaskIfStarted();
        }
    }

    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass()) && this.mySock == ((TCPMessageChannel) obj).mySock;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public String getTransport() {
        return "TCP";
    }

    @Override // android.gov.nist.javax.sip.parser.ParseExceptionListener
    public void handleException(ParseException parseException, SIPMessage sIPMessage, Class cls, String str, String str2) throws IOException, ParseException {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Parsing Exception: ", parseException);
        }
        if (cls == null || !(cls.equals(From.class) || cls.equals(To.class) || cls.equals(CSeq.class) || cls.equals(Via.class) || cls.equals(CallID.class) || cls.equals(ContentLength.class) || cls.equals(RequestLine.class) || cls.equals(StatusLine.class))) {
            sIPMessage.addUnparsed(str);
            return;
        }
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Encountered Bad Message \n" + sIPMessage.toString());
        }
        String string = sIPMessage.toString();
        if (string.startsWith("SIP/") || string.startsWith("ACK ") || this.mySock == null) {
            throw parseException;
        }
        if (logger.isLoggingEnabled(4)) {
            logger.logError("Malformed mandatory headers: closing socket! :" + this.mySock.toString());
        }
        try {
            this.mySock.close();
            throw parseException;
        } catch (IOException e) {
            if (!logger.isLoggingEnabled(4)) {
                throw parseException;
            }
            logger.logError("Exception while closing socket! :" + this.mySock.toString() + ":" + e.toString());
            throw parseException;
        }
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public boolean isSecure() {
        return false;
    }

    @Override // android.gov.nist.javax.sip.stack.ConnectionOrientedMessageChannel
    protected synchronized void sendMessage(byte[] bArr, boolean z) throws IOException {
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("sendMessage isClient  = " + z);
        }
        Socket socketSendBytes = null;
        try {
            e = null;
            socketSendBytes = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(), this.peerAddress, this.peerPort, this.peerProtocol, bArr, z, this);
        } catch (IOException e) {
            e = e;
            logger.logWarning("Failed to connect " + this.peerAddress + ":" + this.peerPort + " but trying the advertised port=" + this.peerPortAdvertisedInHeaders + " if it's different than the port we just failed on");
        }
        if (socketSendBytes == null) {
            if (this.peerAddressAdvertisedInHeaders == null || this.peerPortAdvertisedInHeaders <= 0) {
                throw e;
            }
            if (logger.isLoggingEnabled(8)) {
                logger.logWarning("Couldn't connect to peerAddress = " + this.peerAddress + " peerPort = " + this.peerPort + " key = " + this.key + " retrying on peerPortAdvertisedInHeaders " + this.peerPortAdvertisedInHeaders);
            }
            InetAddress byName = InetAddress.getByName(this.peerAddressAdvertisedInHeaders);
            Socket socketSendBytes2 = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(), byName, this.peerPortAdvertisedInHeaders, this.peerProtocol, bArr, z, this);
            int i = this.peerPortAdvertisedInHeaders;
            this.peerPort = i;
            this.peerAddress = byName;
            this.key = MessageChannel.getKey(byName, i, "TCP");
            if (logger.isLoggingEnabled(8)) {
                logger.logWarning("retry suceeded to peerAddress = " + this.peerAddress + " peerPortAdvertisedInHeaders = " + this.peerPortAdvertisedInHeaders + " key = " + this.key);
            }
            socketSendBytes = socketSendBytes2;
        }
        Socket socket = this.mySock;
        if (socketSendBytes != socket && socketSendBytes != null) {
            if (socket != null) {
                if (logger.isLoggingEnabled(8)) {
                    logger.logWarning("Old socket different than new socket on channel " + this.key);
                    logger.logStackTrace();
                    logger.logWarning("Old socket local ip address " + this.mySock.getLocalSocketAddress());
                    logger.logWarning("Old socket remote ip address " + this.mySock.getRemoteSocketAddress());
                    logger.logWarning("New socket local ip address " + socketSendBytes.getLocalSocketAddress());
                    logger.logWarning("New socket remote ip address " + socketSendBytes.getRemoteSocketAddress());
                }
                close(false, false);
            }
            if (e == null) {
                if (this.mySock != null && logger.isLoggingEnabled(8)) {
                    logger.logWarning("There was no exception for the retry mechanism so creating a new thread based on the new socket for incoming " + this.key);
                }
                this.mySock = socketSendBytes;
                this.myClientInputStream = socketSendBytes.getInputStream();
                this.myClientOutputStream = this.mySock.getOutputStream();
                Thread thread = new Thread(this);
                thread.setDaemon(true);
                thread.setName("TCPMessageChannelThread");
                thread.start();
            } else {
                if (logger.isLoggingEnabled(8)) {
                    logger.logWarning("There was an exception for the retry mechanism so not creating a new thread based on the new socket for incoming " + this.key);
                }
                this.mySock = socketSendBytes;
            }
        }
    }

    protected TCPMessageChannel(Socket socket, SIPTransactionStack sIPTransactionStack, TCPMessageProcessor tCPMessageProcessor, String str) {
        super(sIPTransactionStack);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("creating new TCPMessageChannel ");
            logger.logStackTrace();
        }
        this.mySock = socket;
        this.peerAddress = socket.getInetAddress();
        this.myAddress = tCPMessageProcessor.getIpAddress().getHostAddress();
        this.myClientInputStream = this.mySock.getInputStream();
        this.myClientOutputStream = this.mySock.getOutputStream();
        Thread thread = new Thread(this);
        this.mythread = thread;
        thread.setDaemon(true);
        this.mythread.setName(str);
        int port = this.mySock.getPort();
        this.peerPort = port;
        this.key = MessageChannel.getKey(this.peerAddress, port, "TCP");
        this.myPort = tCPMessageProcessor.getPort();
        this.messageProcessor = tCPMessageProcessor;
        this.mythread.start();
    }

    protected TCPMessageChannel(InetAddress inetAddress, int i, SIPTransactionStack sIPTransactionStack, TCPMessageProcessor tCPMessageProcessor) {
        super(sIPTransactionStack);
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("creating new TCPMessageChannel ");
            logger.logStackTrace();
        }
        this.peerAddress = inetAddress;
        this.peerPort = i;
        this.myPort = tCPMessageProcessor.getPort();
        this.peerProtocol = "TCP";
        this.myAddress = tCPMessageProcessor.getIpAddress().getHostAddress();
        this.key = MessageChannel.getKey(this.peerAddress, this.peerPort, "TCP");
        this.messageProcessor = tCPMessageProcessor;
    }

    @Override // android.gov.nist.javax.sip.stack.MessageChannel
    public synchronized void sendMessage(byte[] bArr, InetAddress inetAddress, int i, boolean z) throws IOException {
        try {
            if (bArr != null && inetAddress != null) {
                if (this.peerPortAdvertisedInHeaders <= 0) {
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("receiver port = " + i + " for this channel " + this + " key " + this.key);
                    }
                    if (i <= 0) {
                        this.peerPortAdvertisedInHeaders = SIPConstants.DEFAULT_PORT;
                    } else {
                        this.peerPortAdvertisedInHeaders = i;
                    }
                    if (logger.isLoggingEnabled(32)) {
                        logger.logDebug("2.Storing peerPortAdvertisedInHeaders = " + this.peerPortAdvertisedInHeaders + " for this channel " + this + " key " + this.key);
                    }
                }
                Socket socketSendBytes = null;
                try {
                    socketSendBytes = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(), inetAddress, i, "TCP", bArr, z, this);
                    e = null;
                } catch (IOException e) {
                    e = e;
                    logger.logWarning("Failed to connect " + this.peerAddress + ":" + i + " but trying the advertised port=" + this.peerPortAdvertisedInHeaders + " if it's different than the port we just failed on");
                    logger.logError("Error is ", e);
                }
                if (socketSendBytes == null) {
                    if (this.peerAddressAdvertisedInHeaders != null && this.peerPortAdvertisedInHeaders > 0) {
                        if (logger.isLoggingEnabled(8)) {
                            logger.logWarning("Couldn't connect to receiverAddress = " + inetAddress + " receiverPort = " + i + " key = " + this.key + " retrying on peerPortAdvertisedInHeaders " + this.peerPortAdvertisedInHeaders);
                        }
                        InetAddress byName = InetAddress.getByName(this.peerAddressAdvertisedInHeaders);
                        socketSendBytes = this.sipStack.ioHandler.sendBytes(this.messageProcessor.getIpAddress(), byName, this.peerPortAdvertisedInHeaders, "TCP", bArr, z, this);
                        int i2 = this.peerPortAdvertisedInHeaders;
                        this.peerPort = i2;
                        this.peerAddress = byName;
                        this.key = MessageChannel.getKey(byName, i2, "TCP");
                        if (logger.isLoggingEnabled(8)) {
                            logger.logWarning("retry suceeded to peerAddress = " + this.peerAddress + " peerPort = " + this.peerPort + " key = " + this.key);
                        }
                    } else {
                        throw e;
                    }
                }
                Socket socket = this.mySock;
                if (socketSendBytes != socket && socketSendBytes != null) {
                    if (socket != null) {
                        if (logger.isLoggingEnabled(8)) {
                            logger.logWarning("Old socket different than new socket on channel " + this.key);
                            logger.logStackTrace();
                            logger.logWarning("Old socket local ip address " + this.mySock.getLocalSocketAddress());
                            logger.logWarning("Old socket remote ip address " + this.mySock.getRemoteSocketAddress());
                            logger.logWarning("New socket local ip address " + socketSendBytes.getLocalSocketAddress());
                            logger.logWarning("New socket remote ip address " + socketSendBytes.getRemoteSocketAddress());
                        }
                        close(false, false);
                    }
                    if (e == null) {
                        if (this.mySock != null && logger.isLoggingEnabled(8)) {
                            logger.logWarning("There was no exception for the retry mechanism so creating a new thread based on the new socket for incoming " + this.key);
                        }
                        this.mySock = socketSendBytes;
                        this.myClientInputStream = socketSendBytes.getInputStream();
                        this.myClientOutputStream = this.mySock.getOutputStream();
                        Thread thread = new Thread(this);
                        thread.setDaemon(true);
                        thread.setName("TCPMessageChannelThread");
                        thread.start();
                    } else {
                        if (logger.isLoggingEnabled(8)) {
                            logger.logWarning("There was an exception for the retry mechanism so not creating a new thread based on the new socket for incoming " + this.key);
                        }
                        this.mySock = socketSendBytes;
                    }
                }
            } else {
                throw new IllegalArgumentException("Null argument");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
