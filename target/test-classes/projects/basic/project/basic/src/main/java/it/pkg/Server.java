package it.pkg;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

public class Server
{
    public static void main(String[] args)
    {
        try {
            Injector injector = Guice.createInjector(new DependencyModule());
            basicHandler handler = injector.getInstance(basicHandler.class);
            /*
             * Call the server processor and connect to the API
             * ************************************************
                basic.Processor<basicHandler> processor = new basic.Processor<>(handler);
                Runnable server = () -> runServer(processor);
                new Thread(server).start();
                ***********************************************
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    private static void runServer(basic.Processor<basicHandler> processor)
    {
        try {
            TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(9090);
            TServer server = new TThreadedSelectorServer(new TThreadedSelectorServer.Args(serverTransport).processor(processor));

            System.out.println("Accepting connections through port 9090...");
            server.serve();
        } catch (TTransportException x) {
            x.printStackTrace();
        }
    }
     */
}
