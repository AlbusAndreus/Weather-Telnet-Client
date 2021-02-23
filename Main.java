package com.company;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.telnet.TelnetClient;
import sun.nio.ch.IOUtil;

import java.io.IOException;

import static sun.nio.ch.IOUtil.*;

public class Main {

    public static final void main(String[] args)
    {
        TelnetClient telnet;

        telnet = new TelnetClient();

        try
        {
            telnet.connect("rainmaker.wunderground.com", 3000);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        org.apache.commons.net.examples.util.IOUtil.readWrite(telnet.getInputStream(), telnet.getOutputStream(),
                System.in, System.out);

        try
        {
            telnet.disconnect();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        System.exit(0);
    }
}
