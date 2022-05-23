//Clients.java
import java.rmi.*;
import java.net.*;

public class Clients{
	public static void main(String[] args) {
		try{
			String Serverurl = "rmi://" + args[0] + "/Server";
			ServerIntf intf      = (ServerIntf) Naming.Lookup(Serverurl);
			String str       = "Sample String";
			System.out.println("Output from Server is: " + intf.upper(str) );

		}
		catch(Exception e){
			System.out.println("Exception");
		}
	}
}

//Server1.java
import java.rmi.*;
import java.net.*;

public class Server1{
	public static void main(String[] args) {
		ServerImpl impl = new ServerImpl();
		Naming.rebind("Server",impl); 
	}
}

//ServerImpl.java
import java.rmi.*;
import java.rmi.server.*;
import java.net.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf{
	public ServerImpl() throws RemoteException { }

	public String upper(String str) throws RemoteException{
      return str.toUpperCase();
	}
}

//ServerIntf.java
import java.rmi.*;
import java.net.*;

public interface ServerIntf extends Remote{
	String upper(String str) throws RemoteException;
}