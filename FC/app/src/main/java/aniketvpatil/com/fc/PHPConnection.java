package aniketvpatil.com.fc;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Aniiket on 8/30/2016.
 */
public class PHPConnection extends AsyncTask {
    String st;
    @Override
    protected String doInBackground(Object[] params) {

        try {
            String scan=(String) params[0];
            String imei=(String) params[1];
            String link="http://aniketvpatil.com/index.php?scan="+scan+"& imei="+imei;
            String data= URLEncoder.encode("scan","UTF-8")+"="+URLEncoder.encode(scan,"UTF-8");
            data+= "&" + URLEncoder.encode("imei","UTF-8")+"="+URLEncoder.encode(imei,"UTF-8");

            URL url= new URL(link);
            URLConnection conn=url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr= new OutputStreamWriter(conn.getOutputStream());

            wr.write(data);
            wr.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb= new StringBuilder();

            String line=null;
            while((line = in.readLine()) != null)
            {
                sb.append(line);
                break;
            }
            String st=sb.toString();
            return st;
        }
        catch (MalformedURLException e) {
            e.printStackTrace(); 

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

    }
}
