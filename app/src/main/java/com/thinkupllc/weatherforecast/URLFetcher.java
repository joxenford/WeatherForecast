package com.thinkupllc.weatherforecast;

import org.jdeferred.Deferred;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLFetcher {


//    private static  String fetchURL() throws Exception {
//        return fetchURL();
//    }

    final Deferred<String, String, String> deferred = new DeferredObject<String, String, String>();

    public Promise< String, String, String > fetchURL(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            String content = buffer.toString();

            return deferred.resolve(content);

        } finally {
            if (reader != null) {
                reader.close();
                return promise();
            }
        }
    }

    public Promise<String, String, String> promise() {
        return deferred;
    }
}

